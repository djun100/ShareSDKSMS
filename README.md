# ShareSDKSMS
base on ShareSMSSDK v1.2.2
已经配置好permission，加好jar包
usage

1、

      repositories {
        // ...
        maven { url "https://jitpack.io" }
    }

    compile 'com.github.djun100:ShareSDKSMS:8ccfbf96d328d98cd36d99480d6f2b85b6db07af'
2、在您的项目启动时，调用下面的代码：

    SMSSDK.initSDK(this, "<您的appkey>", "<您的appsecret>");
文档
[http://wiki.mob.com/android-%E7%9F%AD%E4%BF%A1sdk%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/](http://wiki.mob.com/android-%E7%9F%AD%E4%BF%A1sdk%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/)