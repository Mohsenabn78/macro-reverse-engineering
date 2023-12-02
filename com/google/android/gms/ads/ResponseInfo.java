package com.google.android.gms.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class ResponseInfo {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final zzdn f18986a;

    /* renamed from: b  reason: collision with root package name */
    private final List f18987b = new ArrayList();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private AdapterResponseInfo f18988c;

    private ResponseInfo(@Nullable zzdn zzdnVar) {
        this.f18986a = zzdnVar;
        if (zzdnVar != null) {
            try {
                List<zzu> zzj = zzdnVar.zzj();
                if (zzj != null) {
                    for (zzu zzuVar : zzj) {
                        AdapterResponseInfo zza = AdapterResponseInfo.zza(zzuVar);
                        if (zza != null) {
                            this.f18987b.add(zza);
                        }
                    }
                }
            } catch (RemoteException e4) {
                zzbzr.zzh("Could not forward getAdapterResponseInfo to ResponseInfo.", e4);
            }
        }
        zzdn zzdnVar2 = this.f18986a;
        if (zzdnVar2 != null) {
            try {
                zzu zzf = zzdnVar2.zzf();
                if (zzf != null) {
                    this.f18988c = AdapterResponseInfo.zza(zzf);
                }
            } catch (RemoteException e5) {
                zzbzr.zzh("Could not forward getLoadedAdapterResponse to ResponseInfo.", e5);
            }
        }
    }

    @Nullable
    public static ResponseInfo zza(@Nullable zzdn zzdnVar) {
        if (zzdnVar != null) {
            return new ResponseInfo(zzdnVar);
        }
        return null;
    }

    @NonNull
    public static ResponseInfo zzb(@Nullable zzdn zzdnVar) {
        return new ResponseInfo(zzdnVar);
    }

    @NonNull
    public List<AdapterResponseInfo> getAdapterResponses() {
        return this.f18987b;
    }

    @Nullable
    public AdapterResponseInfo getLoadedAdapterResponseInfo() {
        return this.f18988c;
    }

    @Nullable
    public String getMediationAdapterClassName() {
        try {
            zzdn zzdnVar = this.f18986a;
            if (zzdnVar != null) {
                return zzdnVar.zzg();
            }
            return null;
        } catch (RemoteException e4) {
            zzbzr.zzh("Could not forward getMediationAdapterClassName to ResponseInfo.", e4);
            return null;
        }
    }

    @NonNull
    public Bundle getResponseExtras() {
        try {
            zzdn zzdnVar = this.f18986a;
            if (zzdnVar != null) {
                return zzdnVar.zze();
            }
        } catch (RemoteException e4) {
            zzbzr.zzh("Could not forward getResponseExtras to ResponseInfo.", e4);
        }
        return new Bundle();
    }

    @Nullable
    public String getResponseId() {
        try {
            zzdn zzdnVar = this.f18986a;
            if (zzdnVar != null) {
                return zzdnVar.zzi();
            }
            return null;
        } catch (RemoteException e4) {
            zzbzr.zzh("Could not forward getResponseId to ResponseInfo.", e4);
            return null;
        }
    }

    @NonNull
    public String toString() {
        try {
            return zzd().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @Nullable
    @VisibleForTesting
    public final zzdn zzc() {
        return this.f18986a;
    }

    @NonNull
    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo adapterResponseInfo : this.f18987b) {
            jSONArray.put(adapterResponseInfo.zzb());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        AdapterResponseInfo adapterResponseInfo2 = this.f18988c;
        if (adapterResponseInfo2 != null) {
            jSONObject.put("Loaded Adapter Response", adapterResponseInfo2.zzb());
        }
        Bundle responseExtras = getResponseExtras();
        if (responseExtras != null) {
            jSONObject.put("Response Extras", zzay.zzb().zzh(responseExtras));
        }
        return jSONObject;
    }
}
