package edu.pujadas.activitat3.rest.service;

import edu.pujadas.activitat3.rest.contants.ApiConstants;
import edu.pujadas.activitat3.rest.model.Owner;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET(ApiConstants.GITHUB_USER_ENDPOINT)
    Call<Owner> getOwner(@Path("owner") String owner);
}
