package com.lucasbais.tinyandroidapp.ui.main;

import com.lucasbais.tinyandroidapp.dto.TweetList;
import com.lucasbais.tinyandroidapp.ui.base.ViewContract;

/**
 * Created by zehemz on 21/01/2017.
 */

public interface SearchContract {

    interface View extends ViewContract {

        void setTweets(TweetList next);

        void showLoading(boolean loading);

        void showErrorMessage(String string);
    }

    interface Actions {
        void searchOnTwitter(String s);
    }
}
