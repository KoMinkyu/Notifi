package com.hitherejoe.notifi.injection.component;

import android.app.Application;
import android.content.Context;

import com.hitherejoe.notifi.NotifiApplication;
import com.hitherejoe.notifi.injection.ApplicationContext;
import com.hitherejoe.notifi.injection.module.ApplicationModule;
import com.hitherejoe.notifi.ui.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();

    void inject(NotifiApplication __);
    void inject(BaseActivity __);
}
