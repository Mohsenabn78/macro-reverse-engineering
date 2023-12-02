package com.google.android.gms.ads;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzu;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class AdapterResponseInfo {

    /* renamed from: a  reason: collision with root package name */
    private final zzu f18973a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final AdError f18974b;

    private AdapterResponseInfo(zzu zzuVar) {
        AdError zza;
        this.f18973a = zzuVar;
        com.google.android.gms.ads.internal.client.zze zzeVar = zzuVar.zzc;
        if (zzeVar == null) {
            zza = null;
        } else {
            zza = zzeVar.zza();
        }
        this.f18974b = zza;
    }

    @Nullable
    public static AdapterResponseInfo zza(@Nullable zzu zzuVar) {
        if (zzuVar != null) {
            return new AdapterResponseInfo(zzuVar);
        }
        return null;
    }

    @Nullable
    public AdError getAdError() {
        return this.f18974b;
    }

    @NonNull
    public String getAdSourceId() {
        return this.f18973a.zzf;
    }

    @NonNull
    public String getAdSourceInstanceId() {
        return this.f18973a.zzh;
    }

    @NonNull
    public String getAdSourceInstanceName() {
        return this.f18973a.zzg;
    }

    @NonNull
    public String getAdSourceName() {
        return this.f18973a.zze;
    }

    @NonNull
    public String getAdapterClassName() {
        return this.f18973a.zza;
    }

    @NonNull
    public Bundle getCredentials() {
        return this.f18973a.zzd;
    }

    public long getLatencyMillis() {
        return this.f18973a.zzb;
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
    public final JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.f18973a.zza);
        jSONObject.put("Latency", this.f18973a.zzb);
        String adSourceName = getAdSourceName();
        if (adSourceName == null) {
            jSONObject.put("Ad Source Name", "null");
        } else {
            jSONObject.put("Ad Source Name", adSourceName);
        }
        String adSourceId = getAdSourceId();
        if (adSourceId == null) {
            jSONObject.put("Ad Source ID", "null");
        } else {
            jSONObject.put("Ad Source ID", adSourceId);
        }
        String adSourceInstanceName = getAdSourceInstanceName();
        if (adSourceInstanceName == null) {
            jSONObject.put("Ad Source Instance Name", "null");
        } else {
            jSONObject.put("Ad Source Instance Name", adSourceInstanceName);
        }
        String adSourceInstanceId = getAdSourceInstanceId();
        if (adSourceInstanceId == null) {
            jSONObject.put("Ad Source Instance ID", "null");
        } else {
            jSONObject.put("Ad Source Instance ID", adSourceInstanceId);
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.f18973a.zzd.keySet()) {
            jSONObject2.put(str, this.f18973a.zzd.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.f18974b;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzb());
        }
        return jSONObject;
    }
}
