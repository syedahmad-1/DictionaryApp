package com.example.dictionaryapplication.ViewHolders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapplication.R;

public class PhoneticsViewHolder extends RecyclerView.ViewHolder {
    public TextView  phoneticText;
    public ImageButton audioButton;


    public PhoneticsViewHolder(@NonNull View itemView) {
        super(itemView);
        phoneticText= itemView.findViewById(R.id.textView_phonetic);
        audioButton =itemView.findViewById(R.id.imageButton_audio);
    }
}



