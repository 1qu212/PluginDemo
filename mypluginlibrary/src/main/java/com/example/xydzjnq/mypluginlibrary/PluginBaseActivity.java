package com.example.xydzjnq.mypluginlibrary;

import android.app.Activity;
import android.content.res.Resources;

public class PluginBaseActivity extends Activity {

    @Override
    public Resources getResources() {
        return PluginManager.mNowResources;
    }
}
