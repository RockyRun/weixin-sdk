package com.weixin.sdk.message;

public abstract class AbstractRecieved implements Receivable{

    private Integer createTime;
    private String fromUser;
    private String toUser;
    
    @Override
    public Integer createTime() {
        return this.createTime;
    }
    
    @Override
    public String fromUser() {
        return fromUser;
    }
    
    @Override
    public String toUser() {
        return toUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
    
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
    
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}
