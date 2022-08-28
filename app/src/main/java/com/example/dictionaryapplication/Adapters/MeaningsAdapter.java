package com.example.dictionaryapplication.Adapters;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapplication.MainActivity;
import com.example.dictionaryapplication.Models.Meaning;
import com.example.dictionaryapplication.R;
import com.example.dictionaryapplication.ViewHolders.MeaningViewHolder;

import java.util.List;

public class MeaningsAdapter extends RecyclerView.Adapter<MeaningViewHolder>{
    private Context context;
    private List<Meaning> meaningList;

    public MeaningsAdapter(Context context, List<Meaning> meaningsList) {
        this.context=context;
        this.meaningList=meaningsList;
    }


    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {

        holder.partOfSpeech.setText(meaningList.get(position).getPartOfSpeech());
        holder.definition.setHasFixedSize(true);
        holder.definition.setLayoutManager(new GridLayoutManager(context, 1));
        DefinitionAdapter definitionAdapter = new DefinitionAdapter(context, meaningList.get(position).getDefinitions());
        holder.definition.setAdapter(definitionAdapter);

    }

    @Override
    public int getItemCount() {
        return meaningList.size();
    }
}
