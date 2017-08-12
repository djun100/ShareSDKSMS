# ShareSDKSMS
base on ShareSMSSDK v3.0.0
已经配置好permission，加好jar包
收不到短信请确保后台关闭了智能验证。
usage

1、

      repositories {
        // ...
        maven { url "https://jitpack.io" }
    }

    compile 'com.github.djun100:ShareSDKSMS:3692a1586fc6233404fe95f37643c1c3b2a23041'
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

http://wiki.mob.com/sdk-sms-android-3-0-0/

无gui接口

http://wiki.mob.com/sms-android-%E6%97%A0gui%E6%8E%A5%E5%8F%A3%E8%B0%83%E7%94%A8/
