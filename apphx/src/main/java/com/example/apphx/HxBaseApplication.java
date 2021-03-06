package com.example.apphx;


import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;



import timber.log.Timber;


/**
 * 环信相关基础配置
 */
public abstract class HxBaseApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();

        // 初始化Timber日志
        Timber.plant(new Timber.DebugTree());

        // 初始化环信sdk和easeui库
        initEaseUI();
    }

    private void initEaseUI() {
        EMOptions options = new EMOptions();
        // 关闭自动登录
        options.setAutoLogin(false);
        EaseUI.getInstance().init(this, options);

        // 关闭环信日志
        EMClient.getInstance().setDebugMode(false);
    }


//    // 异常登出情况处理
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(HxDisconnectEvent event){
//        if (event.errorCode == EMError.USER_LOGIN_ANOTHER_DEVICE) {
//            Toast.makeText(this, R.string.hx_error_account_conflict, Toast.LENGTH_SHORT).show();
//        } else if (event.errorCode == EMError.USER_REMOVED) {
//            Toast.makeText(this, R.string.hx_error_account_removed, Toast.LENGTH_SHORT).show();
//        }
//        exit();
//    }

    protected abstract void exit();
}
