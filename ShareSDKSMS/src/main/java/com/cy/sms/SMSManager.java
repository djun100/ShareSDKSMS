package com.cy.sms;

import android.content.Context;

import com.cy.util.Listener;

import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

public class SMSManager {
	static boolean mHasInited=false;
	public static void init(Context context,String appkey,String appSecret) {
		SMSSDK.initSDK(context, appkey, appSecret);
		mHasInited=true;
	}
/*	 EventHandler eh=new EventHandler(){
		 
         @Override
         public void afterEvent(int event, int result, Object data) {

            if (result == SMSSDK.RESULT_COMPLETE) {
             //回调完成
             if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
             //提交验证码成功
            	 Log.w("提交验证码成功 result:"+result+" data:"+data.toString());
             }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
             //获取验证码成功
             }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
             //返回支持发送验证码的国家列表
             } 
           }else{                                                                 
              ((Throwable)data).printStackTrace(); 
           }
         } 
      }; */
	public static void getVerificationCode(String phone,final Listener listener){
		if (mHasInited==false) throw new RuntimeException("请先初始化SMSManager.init(...)");
		SMSSDK.getVerificationCode("86", phone.trim(), new OnSendMessageHandler() {

			@Override
			public boolean onSendMessage(String arg0, String arg1) {

//				Log.w(arg0 + " " + arg1);
				listener.onComplete();
				return false;
			}
		});
	}
	public static void getVoiceVerifyCode(String phone,final Listener listener){
		if (mHasInited==false) throw new RuntimeException("请先初始化SMSManager.init(...)");
		EventHandler eh=new EventHandler(){

			@Override
			public void afterEvent(int event, int result, Object data) {
//				Log.w("event:"+event+" result:"+result+" ");
				if (result == SMSSDK.RESULT_COMPLETE) {
					//回调完成
					if (event == SMSSDK.EVENT_GET_VOICE_VERIFICATION_CODE){
						listener.onComplete();
						//获取验证码成功
					}
				}else if (result==SMSSDK.RESULT_ERROR){
					if (event==SMSSDK.EVENT_GET_VOICE_VERIFICATION_CODE){
						//验证码发送失败
						listener.onError();
					}
				}else{
					((Throwable)data).printStackTrace();
				}
				SMSSDK.unregisterAllEventHandler();
			}
		};
		SMSSDK.registerEventHandler(eh); //注册回调
		SMSSDK.getVoiceVerifyCode("86", phone);
	}
	public static void submitVerificationCode(String phone,String verificationCode,final Listener listener){
		EventHandler eh=new EventHandler(){
			 
	         @Override
	         public void afterEvent(int event, int result, Object data) {
//				 Log.w("event:"+event+" result:"+result+" ");
				 if (result == SMSSDK.RESULT_COMPLETE) {
					 //回调完成
					 if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
						 //提交验证码成功
//						 Log.w("提交验证码成功 result:" + result + " data:" + data.toString());
						 SMSSDK.unregisterAllEventHandler();
						 if (result==SMSSDK.RESULT_COMPLETE) {
							 listener.onComplete();
						 }else {
							 //验证码错误
							 listener.onError();
						 }

					 }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
						 //获取验证码成功
						 SMSSDK.unregisterAllEventHandler();
					 }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
						 //返回支持发送验证码的国家列表
					 }
				 }else if (result==SMSSDK.RESULT_ERROR){
					 if (event==SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
						 //验证码错误
						 listener.onError();
					 }
				 }else{
					 ((Throwable)data).printStackTrace();
				 }
				 SMSSDK.unregisterAllEventHandler();
	         } 
	      }; 
		SMSSDK.registerEventHandler(eh); //注册短信回调
		SMSSDK.submitVerificationCode("86", phone.trim(), verificationCode);
		
	}
}
