package com.facebook.stetho.server.http;

import androidx.annotation.Nullable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class LightHttpMessage {
    public final ArrayList<String> headerNames = new ArrayList<>();
    public final ArrayList<String> headerValues = new ArrayList<>();

    public void addHeader(String str, String str2) {
        this.headerNames.add(str);
        this.headerValues.add(str2);
    }

    @Nullable
    public String getFirstHeaderValue(String str) {
        int size = this.headerNames.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (str.equals(this.headerNames.get(i4))) {
                return this.headerValues.get(i4);
            }
        }
        return null;
    }

    public void reset() {
        this.headerNames.clear();
        this.headerValues.clear();
    }
}
