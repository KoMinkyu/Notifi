package com.hitherejoe.notifi.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.hitherejoe.notifi.NotifiApplication;
import com.hitherejoe.notifi.util.NotificationUtil;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {
    @Inject NotificationUtil notificationUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((NotifiApplication)getApplication()).getComponent().inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public NotificationUtil notificationUtil() {
        return this.notificationUtil;
    }

}
