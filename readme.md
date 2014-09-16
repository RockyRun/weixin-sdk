## 交互种类

和微信服务器的交互方式分两种：

  * 被动响应微信服务器发过来的请求
  * 主动与微信服务器进行交互

## 被动响应

被动响应是指开发者自己的应用被动响应微信服务器发过来的请求，进行相应的业务处理后返回某个响应给微信；目前微信要求此响应必须在5秒以内完成。

安装微信官方的分类，此被动响应模型中微信会发送两种消息：普通的消息和事件消息。

在本SDK中，针对此两种类型的消息，为了方便开发者根据场景选择；分别设计了两个不同的接口`Message`和`Event`

### 普通消息

普通的消息在实际环境中通常是由一个终端微信用户直接对一个工作号发送的各种消息，如文本，图片，地理位置等。


微信能发送的普通类消息分为以下六种，在SDK中分别具有对应

* 文本消息  -  对应`TextMessage`
* 图片消息  -  对应`ImageMessage`
* 位置消息  -  对应`LocationMessage`
* 音频消息  -  对应`VoiceMessage`
* 视频消息  -  对应`VideoMessage`
* 链接消息  -  对应`LinkMessage`

### 事件消息

事件消息在实际环境中通常是由一个终端微信用户针对某个公众帐号进行了某些非消息发送类的操作而产生的；如关注此公众号，点击某个菜单。

微信能发送的事件消息分为以下几种：

* 关注类事件          -  对应`SubscribeEvent`
* 取消关注类事件       -  对应`UnsubscribeEvent`
* 扫描类事件          -  对应`ScanEvent`
* 位置类事件          -  对应`LocationEvent`
* 点击菜单类事件       -  对应`ClickEvent`
* 浏览菜单链接类事件   -  对应`ViewEvent`

### 如何使用SDK对被动类消息进行响应

根据被动消息的两种分类，SDK直接提供了两个单独的接口，`MessageHandler`用来处理普通消息，`EventHandler`用来出来事件消息，开发者可以根据需要选择是否实现此两个接口。

_MessageHandler_使用

`MessageHandler`用来处理普通消息即`Message`, 其接口定义为

    public interface MessageHandler {

        Response handleMessage(Message message);
        
    }

如果开发者要使用此接口，需自己完成一个实现，同时在实现中根据`Message`的方法`messageType()`来获取消息类型（如是文本还是图片），从而进行自己的业务处理； 为方便开发者，SDK中提供了一个默认的`MessageHandlerAdapter`, 开发者可以直接继承此类从而只对自己感兴趣的消息类型进行处理。

`MessageHandlerAdapter`类的方法如下：

    Response handleTextMessage(TextMessage message);

    Response handleImageMessage(ImageMessage message);

    Response handleLinkMessage(LinkMessage message);
    
    Response handleLocationMessage(LocationMessage message);

    Response handleVoiceMessage(VoiceMessage message);

    Response handleVideoMessage(VideoMessage message);

例如开发者的应用只需要对图片或者文本进行响应，只需要继承`MessageHandlerAdapter`并实现其中的两个方法即可，同时方法参数已经为具体的类型消息而不需要再进行判断。


_EventHandler_使用

`EventHandler`与`MessageHandler`的使用方式一样，同时提供了接口`EventHandler`和一个适配器类`EventHandlerAdapter`。
`EventHandler`的定义如下：

    public interface EventHandler {
        
        Response handleEvent(Event eventMessage);

    }

使用此接口时用户需要自己根据`Event.getEventType()`来获取事件类型并进行相应的业务处理；因此推荐使用`EventHandlerAdapter`类, 开发者只需重写关注的事件方法即可，其所有方法如下：

    Response handleSubscribeEvent(SubscribeEvent eventMessage)

    Response handleUnsubscribeEvent(UnsubscribeEvent eventMessage)

    Response handleScanEvent(ScanEvent eventMessage)

    Response handleLocationEvent(LocationEvent eventMessage)

    Response handleClickEvent(ClickEvent eventMessage)

    Response handleViewEvent(ViewEvent eventMessage)

### 使用方式

无论开发者采取实现`MessageHandler`和`EventHandler`接口或者继承`MessageHandlerAdapter`和`EventHandlerAdapter`，SDK将自动探测，故开发者不需要在配置文件或者别的地方注册；如果开发者使用Spring之类的IOC框架，请根据框架的方式使用。

