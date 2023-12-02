package com.github.javiersantos.licensing;

import android.content.Context;
import android.util.Log;
import com.github.javiersantos.licensing.util.URIQueryDecoder;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes3.dex */
public class ServerManagedPolicy implements Policy {

    /* renamed from: a  reason: collision with root package name */
    private long f18395a;

    /* renamed from: b  reason: collision with root package name */
    private long f18396b;

    /* renamed from: c  reason: collision with root package name */
    private long f18397c;

    /* renamed from: d  reason: collision with root package name */
    private long f18398d;

    /* renamed from: e  reason: collision with root package name */
    private long f18399e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f18400f;

    /* renamed from: g  reason: collision with root package name */
    private PreferenceObfuscator f18401g;

    public ServerManagedPolicy(Context context, Obfuscator obfuscator) {
        PreferenceObfuscator preferenceObfuscator = new PreferenceObfuscator(context.getSharedPreferences("com.github.javiersantos.licensing.ServerManagedPolicy", 0), obfuscator);
        this.f18401g = preferenceObfuscator;
        this.f18400f = Integer.parseInt(preferenceObfuscator.getString("lastResponse", Integer.toString(Policy.RETRY)));
        this.f18395a = Long.parseLong(this.f18401g.getString("validityTimestamp", "0"));
        this.f18396b = Long.parseLong(this.f18401g.getString("retryUntil", "0"));
        this.f18397c = Long.parseLong(this.f18401g.getString("maxRetries", "0"));
        this.f18398d = Long.parseLong(this.f18401g.getString("retryCount", "0"));
    }

    private Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            URIQueryDecoder.DecodeQuery(new URI(TypeDescription.Generic.OfWildcardType.SYMBOL + str), hashMap);
        } catch (URISyntaxException unused) {
            Log.w("ServerManagedPolicy", "Invalid syntax error while decoding extras data from server.");
        }
        return hashMap;
    }

    private void b(int i4) {
        this.f18399e = System.currentTimeMillis();
        this.f18400f = i4;
        this.f18401g.putString("lastResponse", Integer.toString(i4));
    }

    private void c(String str) {
        Long l4;
        try {
            l4 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("ServerManagedPolicy", "Licence retry count (GR) missing, grace period disabled");
            l4 = 0L;
            str = "0";
        }
        this.f18397c = l4.longValue();
        this.f18401g.putString("maxRetries", str);
    }

    private void d(long j4) {
        this.f18398d = j4;
        this.f18401g.putString("retryCount", Long.toString(j4));
    }

    private void e(String str) {
        Long l4;
        try {
            l4 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("ServerManagedPolicy", "License retry timestamp (GT) missing, grace period disabled");
            l4 = 0L;
            str = "0";
        }
        this.f18396b = l4.longValue();
        this.f18401g.putString("retryUntil", str);
    }

    private void f(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("ServerManagedPolicy", "License validity timestamp (VT) missing, caching for a minute");
            valueOf = Long.valueOf(System.currentTimeMillis() + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
            str = Long.toString(valueOf.longValue());
        }
        this.f18395a = valueOf.longValue();
        this.f18401g.putString("validityTimestamp", str);
    }

    @Override // com.github.javiersantos.licensing.Policy
    public boolean allowAccess() {
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = this.f18400f;
        if (i4 == 2954) {
            if (currentTimeMillis <= this.f18395a) {
                return true;
            }
        } else if (i4 == 3144 && currentTimeMillis < this.f18399e + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) {
            if (currentTimeMillis <= this.f18396b || this.f18398d <= this.f18397c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public long getMaxRetries() {
        return this.f18397c;
    }

    public long getRetryCount() {
        return this.f18398d;
    }

    public long getRetryUntil() {
        return this.f18396b;
    }

    public long getValidityTimestamp() {
        return this.f18395a;
    }

    @Override // com.github.javiersantos.licensing.Policy
    public void processServerResponse(int i4, ResponseData responseData) {
        if (i4 != 3144) {
            d(0L);
        } else {
            d(this.f18398d + 1);
        }
        if (i4 == 2954) {
            Map<String, String> a4 = a(responseData.extra);
            this.f18400f = i4;
            f(a4.get("VT"));
            e(a4.get("GT"));
            c(a4.get("GR"));
        } else if (i4 == 435) {
            f("0");
            e("0");
            c("0");
        }
        b(i4);
        this.f18401g.commit();
    }
}
