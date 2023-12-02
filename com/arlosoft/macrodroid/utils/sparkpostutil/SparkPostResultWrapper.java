package com.arlosoft.macrodroid.utils.sparkpostutil;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SparkPostResultWrapper {
    private ArrayList<SparkPostError> errors;
    private SparkPostResult results;

    public SparkPostResultWrapper(ArrayList<SparkPostError> arrayList, SparkPostResult sparkPostResult) {
        this.errors = arrayList;
        this.results = sparkPostResult;
    }

    public static SparkPostResultWrapper fromJson(String str) {
        return (SparkPostResultWrapper) new Gson().fromJson(str, (Class<Object>) SparkPostResultWrapper.class);
    }

    public ArrayList<SparkPostError> getErrors() {
        return this.errors;
    }

    public SparkPostResult getResults() {
        return this.results;
    }

    public void setErrors(ArrayList<SparkPostError> arrayList) {
        this.errors = arrayList;
    }

    public void setResults(SparkPostResult sparkPostResult) {
        this.results = sparkPostResult;
    }
}
