package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
class KeysMap {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f29554a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final int f29555b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29556c;

    public KeysMap(int i4, int i5) {
        this.f29555b = i4;
        this.f29556c = i5;
    }

    private String b(String str) {
        if (str != null) {
            return c(str, this.f29556c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String c(String str, int i4) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() > i4) {
                return trim.substring(0, i4);
            }
            return trim;
        }
        return str;
    }

    @NonNull
    public synchronized Map<String, String> a() {
        return Collections.unmodifiableMap(new HashMap(this.f29554a));
    }

    public synchronized boolean d(String str, String str2) {
        String b4 = b(str);
        if (this.f29554a.size() >= this.f29555b && !this.f29554a.containsKey(b4)) {
            Logger logger = Logger.getLogger();
            logger.w("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f29555b);
            return false;
        }
        String c4 = c(str2, this.f29556c);
        if (CommonUtils.nullSafeEquals(this.f29554a.get(b4), c4)) {
            return false;
        }
        Map<String, String> map = this.f29554a;
        if (str2 == null) {
            c4 = "";
        }
        map.put(b4, c4);
        return true;
    }

    public synchronized void e(Map<String, String> map) {
        String c4;
        int i4 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String b4 = b(entry.getKey());
            if (this.f29554a.size() >= this.f29555b && !this.f29554a.containsKey(b4)) {
                i4++;
            }
            String value = entry.getValue();
            Map<String, String> map2 = this.f29554a;
            if (value == null) {
                c4 = "";
            } else {
                c4 = c(value, this.f29556c);
            }
            map2.put(b4, c4);
        }
        if (i4 > 0) {
            Logger logger = Logger.getLogger();
            logger.w("Ignored " + i4 + " entries when adding custom keys. Maximum allowable: " + this.f29555b);
        }
    }
}
