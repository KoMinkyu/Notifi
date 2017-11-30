package com.hitherejoe.notifi;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.hitherejoe.notifi.injection.component.ApplicationComponent;
import com.hitherejoe.notifi.injection.component.DaggerApplicationComponent;
import com.hitherejoe.notifi.injection.module.ApplicationModule;
import com.hitherejoe.notifi.util.NotificationUtil;

import javax.inject.Inject;

import timber.log.Timber;

public class NotifiApplication extends Application  {

    ApplicationComponent mApplicationComponent;
    @Inject NotificationUtil notificationUtil;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        initUtils();
    }

    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
          .applicationModule(new ApplicationModule(this))
          .build();

        getComponent().inject(this);
    }

    private void initUtils() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationUtil.initNotificationChannel(this);
        }
    }

    public static NotifiApplication get(Context context) {
        return (NotifiApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

}
