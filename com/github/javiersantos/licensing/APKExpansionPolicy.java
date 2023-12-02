package com.github.javiersantos.licensing;

import android.content.Context;
import android.util.Log;
import com.github.javiersantos.licensing.util.URIQueryDecoder;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes3.dex */
public class APKExpansionPolicy implements Policy {
    public static final int MAIN_FILE_URL_INDEX = 0;
    public static final int PATCH_FILE_URL_INDEX = 1;

    /* renamed from: a  reason: collision with root package name */
    private long f18357a;

    /* renamed from: b  reason: collision with root package name */
    private long f18358b;

    /* renamed from: c  reason: collision with root package name */
    private long f18359c;

    /* renamed from: d  reason: collision with root package name */
    private long f18360d;

    /* renamed from: f  reason: collision with root package name */
    private int f18362f;

    /* renamed from: g  reason: collision with root package name */
    private PreferenceObfuscator f18363g;

    /* renamed from: e  reason: collision with root package name */
    private long f18361e = 0;

    /* renamed from: h  reason: collision with root package name */
    private Vector<String> f18364h = new Vector<>();

    /* renamed from: i  reason: collision with root package name */
    private Vector<String> f18365i = new Vector<>();

    /* renamed from: j  reason: collision with root package name */
    private Vector<Long> f18366j = new Vector<>();

    public APKExpansionPolicy(Context context, Obfuscator obfuscator) {
        PreferenceObfuscator preferenceObfuscator = new PreferenceObfuscator(context.getSharedPreferences("com.github.javiersantos.licensing.APKExpansionPolicy", 0), obfuscator);
        this.f18363g = preferenceObfuscator;
        this.f18362f = Integer.parseInt(preferenceObfuscator.getString("lastResponse", Integer.toString(Policy.RETRY)));
        this.f18357a = Long.parseLong(this.f18363g.getString("validityTimestamp", "0"));
        this.f18358b = Long.parseLong(this.f18363g.getString("retryUntil", "0"));
        this.f18359c = Long.parseLong(this.f18363g.getString("maxRetries", "0"));
        this.f18360d = Long.parseLong(this.f18363g.getString("retryCount", "0"));
    }

    private Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            URIQueryDecoder.DecodeQuery(new URI(TypeDescription.Generic.OfWildcardType.SYMBOL + str), hashMap);
        } catch (URISyntaxException unused) {
            Log.w("APKExpansionPolicy", "Invalid syntax error while decoding extras data from server.");
        }
        return hashMap;
    }

    private void b(int i4) {
        this.f18361e = System.currentTimeMillis();
        this.f18362f = i4;
        this.f18363g.putString("lastResponse", Integer.toString(i4));
    }

    private void c(String str) {
        Long l4;
        try {
            l4 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "Licence retry count (GR) missing, grace period disabled");
            l4 = 0L;
            str = "0";
        }
        this.f18359c = l4.longValue();
        this.f18363g.putString("maxRetries", str);
    }

    private void d(long j4) {
        this.f18360d = j4;
        this.f18363g.putString("retryCount", Long.toString(j4));
    }

    private void e(String str) {
        Long l4;
        try {
            l4 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "License retry timestamp (GT) missing, grace period disabled");
            l4 = 0L;
            str = "0";
        }
        this.f18358b = l4.longValue();
        this.f18363g.putString("retryUntil", str);
    }

    private void f(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "License validity timestamp (VT) missing, caching for a minute");
            valueOf = Long.valueOf(System.currentTimeMillis() + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
            str = Long.toString(valueOf.longValue());
        }
        this.f18357a = valueOf.longValue();
        this.f18363g.putString("validityTimestamp", str);
    }

    @Override // com.github.javiersantos.licensing.Policy
    public boolean allowAccess() {
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = this.f18362f;
        if (i4 == 2954) {
            if (currentTimeMillis <= this.f18357a) {
                return true;
            }
        } else if (i4 == 3144 && currentTimeMillis < this.f18361e + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) {
            if (currentTimeMillis <= this.f18358b || this.f18360d <= this.f18359c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String getExpansionFileName(int i4) {
        if (i4 < this.f18365i.size()) {
            return this.f18365i.elementAt(i4);
        }
        return null;
    }

    public long getExpansionFileSize(int i4) {
        if (i4 < this.f18366j.size()) {
            return this.f18366j.elementAt(i4).longValue();
        }
        return -1L;
    }

    public String getExpansionURL(int i4) {
        if (i4 < this.f18364h.size()) {
            return this.f18364h.elementAt(i4);
        }
        return null;
    }

    public int getExpansionURLCount() {
        return this.f18364h.size();
    }

    public long getMaxRetries() {
        return this.f18359c;
    }

    public long getRetryCount() {
        return this.f18360d;
    }

    public long getRetryUntil() {
        return this.f18358b;
    }

    public long getValidityTimestamp() {
        return this.f18357a;
    }

    @Override // com.github.javiersantos.licensing.Policy
    public void processServerResponse(int i4, ResponseData responseData) {
        if (i4 != 3144) {
            d(0L);
        } else {
            d(this.f18360d + 1);
        }
        if (i4 == 2954) {
            Map<String, String> a4 = a(responseData.extra);
            this.f18362f = i4;
            f(Long.toString(System.currentTimeMillis() + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS));
            for (String str : a4.keySet()) {
                if (str.equals("VT")) {
                    f(a4.get(str));
                } else if (str.equals("GT")) {
                    e(a4.get(str));
                } else if (str.equals("GR")) {
                    c(a4.get(str));
                } else if (str.startsWith("FILE_URL")) {
                    setExpansionURL(Integer.parseInt(str.substring(8)) - 1, a4.get(str));
                } else if (str.startsWith("FILE_NAME")) {
                    setExpansionFileName(Integer.parseInt(str.substring(9)) - 1, a4.get(str));
                } else if (str.startsWith("FILE_SIZE")) {
                    setExpansionFileSize(Integer.parseInt(str.substring(9)) - 1, Long.parseLong(a4.get(str)));
                }
            }
        } else if (i4 == 435) {
            f("0");
            e("0");
            c("0");
        }
        b(i4);
        this.f18363g.commit();
    }

    public void resetPolicy() {
        this.f18363g.putString("lastResponse", Integer.toString(Policy.RETRY));
        e("0");
        c("0");
        d(Long.parseLong("0"));
        f("0");
        this.f18363g.commit();
    }

    public void setExpansionFileName(int i4, String str) {
        if (i4 >= this.f18365i.size()) {
            this.f18365i.setSize(i4 + 1);
        }
        this.f18365i.set(i4, str);
    }

    public void setExpansionFileSize(int i4, long j4) {
        if (i4 >= this.f18366j.size()) {
            this.f18366j.setSize(i4 + 1);
        }
        this.f18366j.set(i4, Long.valueOf(j4));
    }

    public void setExpansionURL(int i4, String str) {
        if (i4 >= this.f18364h.size()) {
            this.f18364h.setSize(i4 + 1);
        }
        this.f18364h.set(i4, str);
    }
}
