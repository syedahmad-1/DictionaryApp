package com.example.dictionaryapplication.Services;


import com.example.dictionaryapplication.Models.ApiResponse;

public interface OnFetchDataListner {
    void onFetchData(ApiResponse apiResponse, String message);
    void onError(String message);
}