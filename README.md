# ShareSDKSMS
base on ShareSMSSDK v1.2.2
已经配置好permission，加好jar包
usage

1、

      repositories {
        // ...
        maven { url "https://jitpack.io" }
    }

    compile 'com.github.djun100:ShareSDKSMS:599209d4f4ae97bcebccc0ccc62d84cbc4d926fd'
2、在您的项目启动时，调用下面的代码：

    SMSSDK.initSDK(this, "<您的appkey>", "<您的appsecret>");
文档
[http://wiki.mob.com/android-%E7%9F%AD%E4%BF%A1sdk%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/](http://wiki.mob.com/android-%E7%9F%AD%E4%BF%A1sdk%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/)