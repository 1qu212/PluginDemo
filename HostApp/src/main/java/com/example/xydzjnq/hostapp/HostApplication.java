package com.example.xydzjnq.hostapp;

import android.app.Application;
import android.content.Context;

import com.example.xydzjnq.hostapp.hook.HookHelper;
import com.example.xydzjnq.mypluginlibrary.PluginManager;

public class HostApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.init(this);
        try {
            HookHelper.hookAMN();
            HookHelper.hookActivityThread();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
