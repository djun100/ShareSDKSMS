# ShareSDKSMS
base on ShareSMSSDK v1.3.1
已经配置好permission，加好jar包
收不到短信请确保后台关闭了智能验证。
usage

1、

      repositories {
        // ...
        maven { url "https://jitpack.io" }
    }

    compile 'com.github.djun100:ShareSDKSMS:24798ae04d44e4cc52a130ec390f84f824690364'
2、在您的项目启动时，调用下面的代码：

    SMSSDK.initSDK(this, "<您的appkey>", "<您的appsecret>");
文档
[http://wiki.mob.com/android-%E7%9F%AD%E4%BF%A1sdk%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/](http://wiki.mob.com/android-%E7%9F%AD%E4%BF%A1sdk%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/)