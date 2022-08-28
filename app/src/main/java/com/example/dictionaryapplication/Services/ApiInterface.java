package com.example.dictionaryapplication.Services;

import com.example.dictionaryapplication.Models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

        @GET("entries/en/{word}")
        Call<List<ApiResponse>> callMeanings(
                @Path("word") String word
        );
}
