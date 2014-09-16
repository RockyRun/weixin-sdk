package com.weixin.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;

import org.json.JSONObject;

import com.weixin.sdk.custom.CustomMessage;
import com.weixin.sdk.department.Department;
import com.weixin.sdk.http.Getter;
import com.weixin.sdk.http.Poster;
import com.weixin.sdk.menu.Menu;

/**
 * 用来处理主动向微信发送消息，依赖于 {@link AccessTokenStorager} 和 {@link AppSpecific}
 * 
 * 非线程安全，使用时请每App单独实例化
 *
 */
public class Client {

    private AppSpecific appSpecific;
    private AccessToken accessToken;

    private AccessTokenStorager accessTokenStorager = new FileBasedAccessTokenStorager();
    
    public Client(AppSpecific app){
        this.appSpecific = app;
    }
    
    public void refreshAccessToken(){
//        System.out.println("refreshing access token");
        String response = new Getter().executeGet(apiURLForGetAccessToken(this.appSpecific.getAppID(), this.appSpecific.getSecret()));
        JSONObject json = new JSONObject(response);
        String token = json.getString("access_token");
//        Integer expiresIn = json.getInt("expires_in") - 200; //考虑到时间差，为绝对保证过期判断，将过期判断时间提前200秒
        Integer expiresIn = 7200 - 200;
        long createdAt = new Date().getTime() / 1000;
        this.accessToken = new AccessToken(token, createdAt, expiresIn);   
        this.saveAccessToken(accessToken);
    }
    
    private void saveAccessToken(AccessToken accessToken){
        this.accessTokenStorager.saveAccessToken(this.appSpecific, accessToken);
    }
    
    private AccessToken loadAccessToken(){
        return this.accessTokenStorager.loadAccessToken(this.appSpecific);
    }
    
    /**
     * 此方法一定保证获取一个可以用的accesstoken，先检查实例变量中的accesstoken是否存在，如不存在再获取已经存储的accesstoen，
     * 检查它是否还有效，如果有效则返回；如果无效了则刷新
     */
    public AccessToken getAccessToken(){
       if(this.accessToken == null){
            this.accessToken = this.loadAccessToken();
       }
       long timeStampNow = new Date().getTime() / 1000;
       boolean isAccessTokenValid = (this.accessToken != null) && this.accessToken.aviableFor(timeStampNow);
       if(!isAccessTokenValid){
           this.refreshAccessToken();
       }
       return this.accessToken;
    }
    
    private String apiURLForGetAccessToken(String appID, String appSecret){
        return String.format("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s", 
                appID, appSecret); 
    }
    
    public ResponseStatus createMenu(Menu menu, String agentID){
        return doPost(menu.toJson(), "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=%s&agentid=%s", 
                this.getAccessToken().getToken(), agentID);
    }
    
    public ResponseStatus deleteMenu(){
        String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s",
                this.getAccessToken().getToken());
        String response = new Getter().executeGet(url);
        return responseStatusFromResult(response);
    }
    
    public ResponseStatus createDepartment(Department department){
        return doPost(department.toJson(), "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=%s", 
                this.getAccessToken().getToken());
    }
    
    public ResponseStatus updateDepartment(Department department){
        return doPost(department.toUpdateJson(), "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=%s", 
                this.getAccessToken().getToken());
    }
    
    public ResponseStatus deleteDepartment(Department department){
        return doPost(department.toUpdateJson(), "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=%s&id=%s", 
                this.getAccessToken().getToken(), department.getId());
    }
    
    
    public ResponseStatus listDepartment(){
        return doGet("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=%s", 
                this.getAccessToken().getToken());
    }
    
    public ResponseStatus createUser(User user){
        return doPost(user.toJson(), "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=%s", 
                this.getAccessToken().getToken());
    }
    
    public ResponseStatus updateUser(User user) {
        return doPost(user.toJson(), "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=%s", 
                this.getAccessToken().getToken());
    }
    
    public ResponseStatus deleteUser(String userid){
        return doPost("", "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=%s&userid=%s", 
                this.getAccessToken().getToken(), userid);
    }
    
    
    public ResponseStatus getUserInfo(String userid){
        return doGet("https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=%s&userid=%s", 
                this.getAccessToken().getToken(), userid);
    }

    public ResponseStatus listUsers(String department_id, boolean fetchChild){
        String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=%s&department_id=%s",
                this.getAccessToken().getToken(), department_id);
        String response = new Getter().executeGet(url);
        return responseStatusFromResult(response);
    }

    public ResponseStatus getAgent(String agentID){
        return doGet("https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=%s&agentid=%s", 
                this.getAccessToken().getToken(), agentID);
    }
    
    private ResponseStatus doGet(String urlFormat, Object... args){
        String url = String.format(urlFormat, args);
        String response = new Getter().executeGet(url);
        return responseStatusFromResult(response);
    }
    
    public ResponseStatus doPost(String data, String urlFormat, Object... args){
        String url = String.format(urlFormat, args);
        String result = new Poster().postData(url, data);
        return responseStatusFromResult(result);
    }
    
    public ResponseStatus sendCustomMessage(CustomMessage message){
        String urlFormat = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";
        return doPost(message.toJson(), urlFormat, this.getAccessToken().getToken());
    }
    
    public ResponseStatus uploadMedia(InputStream inputStream, String fileName, MediaType type){
        String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s", 
                this.getAccessToken().getToken(), type.toString().toLowerCase());
        
        String result = null;
        try {
            result = new Poster().send(url, fileName, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseStatusFromResult(result);
    }
        
    public void getMediaFile(String mediaID) {
        String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", 
                this.getAccessToken().getToken(), mediaID);
        new Getter().executeGet(url);
    }        
        
    
    
    private ResponseStatus responseStatusFromResult(String result){
//        System.out.println("get weixin response : " + result);
        JSONObject json = new JSONObject(result);
        if(json.has("errcode")){
            int code = json.getInt("errcode"); 
            if(code  != 0){
                return ResponseStatus.error(code, json.getString("errmsg"));
            } else {
                return ResponseStatus.succeed(new JSONObject(result));
            }            
        } else {
            return ResponseStatus.succeed(new JSONObject(result));
        }
    }


    @SuppressWarnings("deprecation")
    public String redirectionURL(String url, String state){
        String format = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s";
        String encoded = URLEncoder.encode(url);
        return String.format(format, this.appSpecific.getAppID(), encoded, "snsapi_base", state);
    }
    
    public ResponseStatus getUserIDWithCode(String code, String agentID){
        String format = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=%s&code=%s&agentid=%s";
        String url = String.format(format, this.getAccessToken().getToken(), code, agentID);
        String response = new Getter().executeGet(url);
        return responseStatusFromResult(response);
    }
    
}
