package default_xyz.playground.rest.service;

import java.util.List;

import default_xyz.playground.rest.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Rest Service
 * Created by yevhenii_ishchenko on 20/02/16.
 */
public interface Rest {
    @GET("/linksapi/users")
    Call<List<User>> getUsers();
}
