package com.lucasbais.tinyandroidapp.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucasbais.tinyandroidapp.R;
import com.lucasbais.tinyandroidapp.dto.TweetList;
import com.lucasbais.tinyandroidapp.ui.adapter.TweetAdapter;
import com.lucasbais.tinyandroidapp.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TwitterListFragment extends BaseFragment {

    @BindView(R.id.twitterRecyclerView) RecyclerView recyclerView;

    private TweetAdapter tweetAdapter;


    public static TwitterListFragment newInstance() {
        TwitterListFragment fragment = new TwitterListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        initLayout();
        return view;
    }

    private void initLayout() {
        tweetAdapter = new TweetAdapter(getContext(), null);
        recyclerView.setAdapter(tweetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void setTweets(TweetList tweets) {
        tweetAdapter.setTweetList(tweets);
        tweetAdapter.notifyDataSetChanged();
    }
}
