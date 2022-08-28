package com.example.dictionaryapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapplication.Models.Definition;
import com.example.dictionaryapplication.R;
import com.example.dictionaryapplication.ViewHolders.DefinitonsViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitonsViewHolder>{
    private Context context;
    private List<Definition> definitionList;

    public DefinitionAdapter(Context context, List<Definition> definitions) {
        this.context = context;
        this.definitionList = definitions;
    }

    @NonNull
    @Override
    public DefinitonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new DefinitonsViewHolder(LayoutInflater.from(context).inflate(R.layout.definition_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitonsViewHolder holder, int position) {
        holder.definition.setText("Definitions: "+ definitionList.get(position).getDefinition());
        String example = definitionList.get(position).getExample();
        if(example!=null){
            holder.example.setVisibility(View.VISIBLE);
            holder.example.setText("Example:"+example);
        }
        else {
            holder.example.setVisibility(View.INVISIBLE);
        }
        example="";
//
//        StringBuilder synonyms = new StringBuilder();
//        StringBuilder antonyms = new StringBuilder();
//        synonyms.append(definitionList.get(position).getSynonyms());
//        antonyms.append(definitionList.get(position).getAntonyms());
//        if(synonyms==null){
//            holder.antonyms.setVisibility(View.INVISIBLE);
//
//        }
//        if(antonyms==null){
//            holder.antonyms.setVisibility(View.INVISIBLE);
//        }
//        holder.synonyms.setText(synonyms);
//        holder.synonyms.setSelected(true);
//        holder.antonyms.setText(antonyms);
//        holder.antonyms.setSelected(true);


    }

    @Override
    public int getItemCount() {
        return definitionList.size();
    }
}
