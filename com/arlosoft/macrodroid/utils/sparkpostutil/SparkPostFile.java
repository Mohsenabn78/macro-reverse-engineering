package com.arlosoft.macrodroid.utils.sparkpostutil;

/* loaded from: classes3.dex */
public class SparkPostFile {
    private String data;
    private String name;
    private String type;

    public SparkPostFile(String str, String str2, String str3) {
        this.type = str;
        this.name = str2;
        this.data = str3;
    }

    public String getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
