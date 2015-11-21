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

    compile 'com.github.djun100:ShareSDKSMS:16a1de1d0f9cfbe04e240bb2132abae9e98c41b1'
2、在您的项目启动时，用SMSManager类进行初始化（必须）

    SMSManager.init(this, "<您的appkey>", "<您的appsecret>");`

3、请求验证码

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