package com.arlosoft.macrodroid.utils.sparkpostutil;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SparkPostEmailJsonRequest {
    public static final String API_BASE_URL = "https://api.sparkpost.com/api/v1/";
    public static final String EMAIL_API_PATH = "transmissions?num_rcpt_errors=3";
    private SparkPostContent content;
    private ArrayList<SparkPostRecipient> recipients;

    public SparkPostEmailJsonRequest(String str, String str2, ArrayList<SparkPostRecipient> arrayList, SparkPostSender sparkPostSender, String str3, ArrayList<SparkPostFile> arrayList2, String str4) {
        this.recipients = arrayList;
        this.content = new SparkPostContent(sparkPostSender, str, str2, str3, arrayList2, formatReplyToEmailAddress(str4));
    }

    private String formatReplyToEmailAddress(String str) {
        if (str != null && str.length() > 0) {
            if (!str.startsWith("<")) {
                str = "<" + str;
            }
            if (!str.endsWith(">")) {
                return str + ">";
            }
            return str;
        }
        return str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public SparkPostEmailJsonRequest(String str, String str2, String str3, String str4, String str5) {
        SparkPostRecipient sparkPostRecipient = new SparkPostRecipient(str3);
        ArrayList<SparkPostRecipient> arrayList = new ArrayList<>();
        this.recipients = arrayList;
        arrayList.add(sparkPostRecipient);
        this.content = new SparkPostContent(new SparkPostSender("feedback@sparkpostbox.com", str5), str, str2, null, null, null);
    }
}
