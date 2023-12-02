package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.dx.cf.attrib.AttCode;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class AdError {
    @NonNull
    public static final String UNDEFINED_DOMAIN = "undefined";

    /* renamed from: a  reason: collision with root package name */
    private final int f18950a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f18951b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f18952c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AdError f18953d;

    public AdError(int i4, @NonNull String str, @NonNull String str2, @Nullable AdError adError) {
        this.f18950a = i4;
        this.f18951b = str;
        this.f18952c = str2;
        this.f18953d = adError;
    }

    @Nullable
    public AdError getCause() {
        return this.f18953d;
    }

    public int getCode() {
        return this.f18950a;
    }

    @NonNull
    public String getDomain() {
        return this.f18952c;
    }

    @NonNull
    public String getMessage() {
        return this.f18951b;
    }

    @NonNull
    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @NonNull
    public final com.google.android.gms.ads.internal.client.zze zza() {
        com.google.android.gms.ads.internal.client.zze zzeVar;
        if (this.f18953d == null) {
            zzeVar = null;
        } else {
            AdError adError = this.f18953d;
            zzeVar = new com.google.android.gms.ads.internal.client.zze(adError.f18950a, adError.f18951b, adError.f18952c, null, null);
        }
        return new com.google.android.gms.ads.internal.client.zze(this.f18950a, this.f18951b, this.f18952c, zzeVar, null);
    }

    @NonNull
    public JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AttCode.ATTRIBUTE_NAME, this.f18950a);
        jSONObject.put("Message", this.f18951b);
        jSONObject.put("Domain", this.f18952c);
        AdError adError = this.f18953d;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzb());
        }
        return jSONObject;
    }

    public AdError(int i4, @NonNull String str, @NonNull String str2) {
        this(i4, str, str2, null);
    }
}
