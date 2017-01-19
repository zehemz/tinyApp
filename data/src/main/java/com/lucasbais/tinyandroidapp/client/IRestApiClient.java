package com.lucasbais.tinyandroidapp.client;

import com.lucasbais.tinyandroidapp.dto.AuthUser;

/**
 * Created by zehemz on 18/01/2017.
 */

public interface IRestApiClient {
    ApiClient getClient();

    void setBaseUrl(String baseUrl) throws RuntimeException;

    void regenerateAuthRestClient(AuthUser authUser);
}
