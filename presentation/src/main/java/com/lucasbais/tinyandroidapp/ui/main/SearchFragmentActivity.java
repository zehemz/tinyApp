package com.lucasbais.tinyandroidapp.ui.main;

import android.app.SearchManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.lucasbais.tinyandroidapp.R;
import com.lucasbais.tinyandroidapp.dto.TweetList;
import com.lucasbais.tinyandroidapp.ui.base.BaseFragmentActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.BindView;


public class SearchFragmentActivity extends BaseFragmentActivity
        implements SearchContract.View,
        SearchView.OnQueryTextListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    MainPresenter actions;

    private TwitterListFragment twitterListFragment;
    private Handler queryHandler;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        queryHandler = new Handler();
    }

    @Override
    protected Fragment getFragment() {
        twitterListFragment = TwitterListFragment.newInstance();
        return twitterListFragment;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public void onFragmentAttached() {
        actions.attachView(this);
    }

    @Override
    public void onFragmentDetached() {
        actions.detachView();
    }

    @Override
    public void setTweets(TweetList tweets) {
        twitterListFragment.setTweets(tweets);
    }

    @Override
    public void showLoading(boolean loading) {

    }

    @Override
    public void showErrorMessage(String string) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        actions.searchOnTwitter(query);
        searchView.clearFocus();
        return true;
    }

    /**
     * Comportamiento opcional, se puede eliminar a gusto.
     *
     * @param newText
     * @return
     */
    @Override
    public boolean onQueryTextChange(String newText) {
        final String queryString = newText;
        queryHandler.removeCallbacksAndMessages(null);

        queryHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                actions.searchOnTwitter(queryString);
            }
        }, 300);

        return true;
    }
}
