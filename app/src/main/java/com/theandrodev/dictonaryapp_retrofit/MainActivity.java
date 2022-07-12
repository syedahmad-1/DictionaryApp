package com.theandrodev.dictonaryapp_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView word_textView, phonetics_textView, synonyms_textView;
    SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        synonyms_textView = findViewById(R.id.tv_synonyms);
        word_textView = findViewById(R.id.word_text_view);
        phonetics_textView = findViewById(R.id.phoentics_textview);
        searchView = findViewById(R.id.search_view);
        RequestQueue queue = Volley.newRequestQueue(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getWord(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private void getWord(String word){

        String url = "https://api.dictionaryapi.dev/api/v2/entries/en/"+word;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int responseIndex=0; responseIndex<response.length(); responseIndex++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(responseIndex);
                        JSONArray meaningArray = jsonObject.getJSONArray("meanings");
                        for(int meaningIndex =0; meaningIndex<meaningArray.length(); meaningIndex++){
                            JSONObject meaningObject = meaningArray.getJSONObject(meaningIndex);
                            JSONArray definitionArray = meaningObject.getJSONArray("definitions");
                            for (int definitionIndex=0; definitionIndex<definitionArray.length(); definitionIndex++){
                                JSONObject defintionObject = definitionArray.getJSONObject(definitionIndex);
                                JSONArray synonymsArray = defintionObject.getJSONArray("synonyms");
                                for(int synonymsIndex=0; synonymsIndex<synonymsArray.length(); synonymsIndex++){
                                    String synonyms = synonymsArray.getString(synonymsIndex);
                                    synonyms_textView.append(synonyms);
                                    synonyms_textView.append(", ");
                                }
                            }
                        }
                    } catch (JSONException e) {
                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();

                    }
                });

    }
}