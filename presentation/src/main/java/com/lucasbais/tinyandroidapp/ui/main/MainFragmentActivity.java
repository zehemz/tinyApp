package com.lucasbais.tinyandroidapp.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lucasbais.tinyandroidapp.R;
import com.lucasbais.tinyandroidapp.repository.TweeterRepositoryImp;
import com.lucasbais.tinyandroidapp.ui.base.BaseFragmentActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;


public class MainFragmentActivity extends BaseFragmentActivity {

    @BindView(R.id.fab) FloatingActionButton floatingActionButton;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Inject
    MainPresenter actions;

    @Inject
    TweeterRepositoryImp tweeterRepositoryImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityComponent().inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @OnClick(R.id.fab)
    public void OnFabIconClicked(View view){
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached() {

    }
}
