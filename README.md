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

    compile 'com.github.djun100:ShareSDKSMS:3caf6dd5acdc5274ba6fc1222db02a75ed2f771f'
2、在SMSManager类中先初始化

    SMSSDK.initSDK(this, "<您的appkey>", "<您的appsecret>");`
3、在您的项目启动时，调用下面的代码：

    SMSManager.init(getApplicationContext());
4、请求验证码

    SMSManager.getVerificationCode(mEtPhone.getText().toString(), new Listener() {
                    @Override
                    public void onComplete() {
                        Log.w("下发短信验证码成功");
                    }

                    @Override
                    public void onError() {

                    }
                });

5、提交验证码

     SMSManager.submitVerificationCode(mEtPhone.getText().toString(), mEtVerifyCode.getText().toString(), new Listener() {
                    @Override
                    public void onComplete() {
                        Log.w("验证码正确");
                    }

                    @Override
                    public void onError() {
                        Log.w("验证码错误");
                    }
                });

文档
[http://wiki.mob.com/android-%E7%9F%AD%E4%BF%A1sdk%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/](http://wiki.mob.com/android-%E7%9F%AD%E4%BF%A1sdk%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/)