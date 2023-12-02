package com.arlosoft.macrodroid.utils.sparkpostutil;

/* loaded from: classes3.dex */
public class SparkPostError {
    private String code;
    private String description;
    private String message;

    public SparkPostError(String str, String str2, String str3) {
        this.message = str;
        this.description = str2;
        this.code = str3;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
