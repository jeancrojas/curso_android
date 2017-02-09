package es.cice.androidstackexchange.retrofitresource;

import java.util.List;

import es.cice.androidstackexchange.model.Item;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cice on 7/2/17.
 */

public interface QuestionCall {
    @GET("/21/questions?order=desc&sort=creation&")
    public Call<List<Item>> getQuestionsCall ();



}
