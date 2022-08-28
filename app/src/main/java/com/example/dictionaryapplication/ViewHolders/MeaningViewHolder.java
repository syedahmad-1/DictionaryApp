package com.example.dictionaryapplication.ViewHolders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapplication.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder{
    public TextView partOfSpeech;
    public RecyclerView definition;

    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);

        partOfSpeech = itemView.findViewById(R.id.textView_partsOfSpeech);
        definition = itemView.findViewById(R.id.recycler_definitions);
    }
}
