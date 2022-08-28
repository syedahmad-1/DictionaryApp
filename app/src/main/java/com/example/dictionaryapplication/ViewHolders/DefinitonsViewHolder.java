package com.example.dictionaryapplication.ViewHolders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapplication.R;

public class DefinitonsViewHolder extends RecyclerView.ViewHolder {
    public TextView definition, synonyms, antonyms, example;

    public DefinitonsViewHolder(@NonNull View itemView ){


        super(itemView);

        definition = itemView.findViewById(R.id.textView_definitions);
        example = itemView.findViewById(R.id.textView_example);
//        synonyms = itemView.findViewById(R.id.textView_synonyms);
//        antonyms = itemView.findViewById(R.id.textView_antonyms);


    }
}
