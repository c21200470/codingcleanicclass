package a21200470.mycodingcleanic.api;

import a21200470.mycodingcleanic.model.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}
