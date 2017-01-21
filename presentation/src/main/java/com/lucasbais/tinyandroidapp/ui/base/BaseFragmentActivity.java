package com.lucasbais.tinyandroidapp.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.lucasbais.tinyandroidapp.R;
import com.lucasbais.tinyandroidapp.TinyAndroidApplication;
import com.lucasbais.tinyandroidapp.injection.components.ActivityComponent;
import com.lucasbais.tinyandroidapp.injection.components.DaggerActivityComponent;
import com.lucasbais.tinyandroidapp.injection.modules.ActivityModule;

/**
 * Created by zehemz on 18/01/2017.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity
        implements BaseFragment.OnFragmentInteractionListener {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            readExtras(getIntent().getExtras());
        }
        placeFragment();
    }

    private void placeFragment() {
        Fragment fragment = getFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_main, fragment,  fragment.getTag())
                .commit();
    }

    protected abstract Fragment getFragment();

    public void readExtras(@NonNull final Bundle extras) {
    }

    public ActivityComponent activityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(TinyAndroidApplication.get(this).getComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return activityComponent;
    }

}
