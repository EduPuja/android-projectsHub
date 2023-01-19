package edu.pujadas.activitat3.rest.adapter;

import edu.pujadas.activitat3.rest.contants.ApiConstants;
import edu.pujadas.activitat3.rest.model.Owner;
import edu.pujadas.activitat3.rest.service.GitHubService;
import retrofit2.Call;

public class GitHubAdapter extends BaseAdapter implements GitHubService
{

    private GitHubService gitHubService;

    public GitHubAdapter() {
        super(ApiConstants.BASE_GITHUB_URL);
        gitHubService = createService(GitHubService.class);
    }

    @Override
    public Call<Owner> getOwner(String owner) {
        return gitHubService.getOwner(owner);
    }
}
