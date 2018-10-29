package a21200470.mycodingcleanic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("repos/{owner}/{repo}/contributors")
    Call<List<ContributorModel>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
}
