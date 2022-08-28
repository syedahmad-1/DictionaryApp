package com.example.dictionaryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.dictionaryapplication.Adapters.MeaningsAdapter;
import com.example.dictionaryapplication.Adapters.PhoneticsAdapter;
import com.example.dictionaryapplication.Models.ApiResponse;
import com.example.dictionaryapplication.Models.Definition;
import com.example.dictionaryapplication.Services.ApiInterface;
import com.example.dictionaryapplication.Services.OnFetchDataListner;
import com.example.dictionaryapplication.Services.RequestManager;
import com.example.dictionaryapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PhoneticsAdapter phoneticsAdapter;
    MeaningsAdapter meaningsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.defaultText.setVisibility(View.VISIBLE);
        binding.linearLayout.setVisibility(View.GONE);


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RequestManager requestManager = new RequestManager(MainActivity.this);
                requestManager.getWordMeaning(listener ,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty()){
                    binding.linearLayout.setVisibility(View.GONE);
                    binding.defaultText.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });
    }

    private final OnFetchDataListner listener = new OnFetchDataListner() {
        @Override
        public void onFetchData(ApiResponse apiResponse, String message) {
            binding.linearLayout.setVisibility(View.VISIBLE);
            binding.defaultText.setVisibility(View.GONE);
            if (apiResponse==null){
                Toast.makeText(MainActivity.this, "No data found!", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);

        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
    private void showData(ApiResponse apiResponse){
        binding.textViewWord.setText( apiResponse.getWord());
        binding.recyclerPhonetics.setHasFixedSize(true);
        binding.recyclerPhonetics.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        phoneticsAdapter = new PhoneticsAdapter(MainActivity.this, apiResponse.getPhonetics());
        binding.recyclerPhonetics.setAdapter(phoneticsAdapter);
        meaningsAdapter = new MeaningsAdapter(MainActivity.this, apiResponse.getMeanings());
        binding.recyclerMeanings.setHasFixedSize(true);
        binding.recyclerMeanings.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        binding.recyclerMeanings.setAdapter(meaningsAdapter);

    }
}