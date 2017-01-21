package com.lucasbais.tinyandroidapp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucasbais.tinyandroidapp.R;
import com.lucasbais.tinyandroidapp.dto.TweetList;

/**
 * Created by zehemz on 21/01/2017.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetHolder> {

    private final LayoutInflater inflater;
    private TweetList tweetList;

    public TweetAdapter(Context mContext, TweetList tweetList) {
        this.tweetList = tweetList;
        inflater = ((Activity) mContext).getLayoutInflater();
    }

    public void setTweetList(TweetList tweetList) {
        this.tweetList = tweetList;
    }

    @Override
    public int getItemCount() {
        return tweetList != null && tweetList.tweets != null ? tweetList.tweets.size() : 0;
    }

    @Override
    public TweetHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.row_tweet, parent, false);
        TweetHolder tweetHolder = new TweetHolder(inflate);
        return tweetHolder;
    }

    @Override
    public void onBindViewHolder(TweetHolder holder, int position) {
        holder.populate(tweetList.tweets.get(position));
    }

}
