package com.arlosoft.macrodroid.utils.sparkpostutil;

/* loaded from: classes3.dex */
public class SparkPostSender {
    private String email;
    private String name;

    public SparkPostSender(String str, String str2) {
        this.email = str;
        this.name = str2;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "<" + this.email + ">";
    }
}
