package com.example.framgiahangoclong.Query;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TrackApi {

    @GET("tracks")
    Call<List<Track>> getTracks();

}
