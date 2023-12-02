package com.arlosoft.macrodroid.utils.sparkpostutil;

/* loaded from: classes3.dex */
public class SparkPostResult {
    private String id;
    private int total_accepted_recipients;
    private int total_rejected_recipients;

    public SparkPostResult(String str, int i4, int i5) {
        this.id = str;
        this.total_accepted_recipients = i4;
        this.total_rejected_recipients = i5;
    }

    public String getId() {
        return this.id;
    }

    public int getTotal_accepted_recipients() {
        return this.total_accepted_recipients;
    }

    public int getTotal_rejected_recipients() {
        return this.total_rejected_recipients;
    }
}
