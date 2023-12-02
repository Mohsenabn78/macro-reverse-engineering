package com.github.javiersantos.licensing;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class ResponseData {
    public String extra;
    public int nonce;
    public String packageName;
    public int responseCode;
    public long timestamp;
    public String userId;
    public String versionCode;

    public static ResponseData parse(String str) {
        int indexOf = str.indexOf(58);
        String str2 = "";
        if (-1 != indexOf) {
            String substring = str.substring(0, indexOf);
            if (indexOf < str.length()) {
                str2 = str.substring(indexOf + 1);
            }
            str = substring;
        }
        String[] split = TextUtils.split(str, Pattern.quote("|"));
        if (split.length >= 6) {
            ResponseData responseData = new ResponseData();
            responseData.extra = str2;
            responseData.responseCode = Integer.parseInt(split[0]);
            responseData.nonce = Integer.parseInt(split[1]);
            responseData.packageName = split[2];
            responseData.versionCode = split[3];
            responseData.userId = split[4];
            responseData.timestamp = Long.parseLong(split[5]);
            return responseData;
        }
        throw new IllegalArgumentException("Wrong number of fields.");
    }

    public String toString() {
        return TextUtils.join("|", new Object[]{Integer.valueOf(this.responseCode), Integer.valueOf(this.nonce), this.packageName, this.versionCode, this.userId, Long.valueOf(this.timestamp)});
    }
}
