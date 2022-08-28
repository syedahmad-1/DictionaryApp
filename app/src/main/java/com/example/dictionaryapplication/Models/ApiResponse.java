package com.example.dictionaryapplication.Models;

import java.util.List;

public class ApiResponse {
    private String word;
    private List<Phonetics> phonetics;
    private List<Meaning> meanings;

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }
}
