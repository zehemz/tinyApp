package com.lucasbais.tinyandroidapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucasbais.tinyandroidapp.R;
import com.lucasbais.tinyandroidapp.dto.Tweet;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zehemz on 21/01/2017.
 */

public class TweetHolder extends RecyclerView.ViewHolder {
    private final Context context;
    @BindView(R.id.text_tweet)
    TextView textTweet;
    @BindView(R.id.text_user)
    TextView textUser;
    @BindView(R.id.image_user_logo)
    ImageView imageLogo;

    public TweetHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
    }

    public void populate(Tweet tweet) {
        textTweet.setText(tweet.text);
        textUser.setText(tweet.user.name);
        Picasso.with(context).load(tweet.user.profileImageUrl).into(imageLogo);
    }
}