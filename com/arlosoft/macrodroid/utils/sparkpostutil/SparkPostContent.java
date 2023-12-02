package com.arlosoft.macrodroid.utils.sparkpostutil;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SparkPostContent {
    private ArrayList<SparkPostFile> attachments;
    private SparkPostSender from;
    private String reply_to;
    private String subject;
    private String text;

    public SparkPostContent(SparkPostSender sparkPostSender, String str, String str2, String str3, ArrayList<SparkPostFile> arrayList, String str4) {
        this.from = sparkPostSender;
        this.subject = str;
        this.text = str2;
        this.attachments = arrayList;
        this.reply_to = str4;
    }

    public ArrayList<SparkPostFile> getAttachments() {
        return this.attachments;
    }

    public SparkPostSender getFrom() {
        return this.from;
    }

    public String getReply_to() {
        return this.reply_to;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getText() {
        return this.text;
    }
}
