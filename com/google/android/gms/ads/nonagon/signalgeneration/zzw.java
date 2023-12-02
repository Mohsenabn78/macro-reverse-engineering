package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbcy;
import com.google.android.gms.internal.ads.zzbyf;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import com.google.android.gms.internal.ads.zzffn;
import com.google.android.gms.internal.ads.zzffy;
import com.google.android.gms.internal.ads.zzfvy;
import com.google.android.gms.internal.ads.zzfwm;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzw implements zzfvy {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzfwm f19563a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzbym f19564b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbyf f19565c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzffn f19566d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ long f19567e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzaa f19568f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(zzaa zzaaVar, zzfwm zzfwmVar, zzbym zzbymVar, zzbyf zzbyfVar, zzffn zzffnVar, long j4) {
        this.f19568f = zzaaVar;
        this.f19563a = zzfwmVar;
        this.f19564b = zzbymVar;
        this.f19565c = zzbyfVar;
        this.f19566d = zzffnVar;
        this.f19567e = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzdqf zzdqfVar;
        zzdpv zzdpvVar;
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.f19567e;
        String message = th.getMessage();
        com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "SignalGeneratorImpl.generateSignals");
        zzaa zzaaVar = this.f19568f;
        zzdqfVar = zzaaVar.f19516m;
        zzdpvVar = zzaaVar.f19508e;
        zzf.zzc(zzdqfVar, zzdpvVar, "sgf", new Pair("sgf_reason", message), new Pair("tqgt", String.valueOf(currentTimeMillis)));
        zzffy F = zzaa.F(this.f19563a, this.f19564b);
        if (((Boolean) zzbcy.zze.zze()).booleanValue() && F != null) {
            zzffn zzffnVar = this.f19566d;
            zzffnVar.zzg(th);
            zzffnVar.zzf(false);
            F.zza(zzffnVar);
            F.zzg();
        }
        try {
            zzbyf zzbyfVar = this.f19565c;
            zzbyfVar.zzb("Internal error. " + message);
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        zzdqf zzdqfVar;
        zzdpv zzdpvVar;
        zzdpv zzdpvVar2;
        boolean z3;
        boolean z4;
        zzdqf zzdqfVar2;
        zzdpv zzdpvVar3;
        String str;
        String str2;
        String str3;
        String str4;
        Context context;
        zzbzx zzbzxVar;
        String str5;
        String str6;
        AtomicInteger atomicInteger;
        zzdqf zzdqfVar3;
        zzdpv zzdpvVar4;
        zzdqf zzdqfVar4;
        zzdpv zzdpvVar5;
        zzam zzamVar = (zzam) obj;
        zzffy F = zzaa.F(this.f19563a, this.f19564b);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzho)).booleanValue()) {
            try {
                this.f19565c.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e4) {
                zzbzr.zzg("QueryInfo generation has been disabled.".concat(e4.toString()));
            }
            if (((Boolean) zzbcy.zze.zze()).booleanValue() && F != null) {
                zzffn zzffnVar = this.f19566d;
                zzffnVar.zzc("QueryInfo generation has been disabled.");
                zzffnVar.zzf(false);
                F.zza(zzffnVar);
                F.zzg();
                return;
            }
            return;
        }
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.f19567e;
        try {
            try {
                if (zzamVar == null) {
                    this.f19565c.zzc(null, null, null);
                    zzaa zzaaVar = this.f19568f;
                    zzdqfVar4 = zzaaVar.f19516m;
                    zzdpvVar5 = zzaaVar.f19508e;
                    zzf.zzc(zzdqfVar4, zzdpvVar5, "sgs", new Pair("rid", Util.ANY_CONTACT_ID));
                    this.f19566d.zzf(true);
                    if (((Boolean) zzbcy.zze.zze()).booleanValue() && F != null) {
                        F.zza(this.f19566d);
                        F.zzg();
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(zzamVar.zzb);
                    String optString = jSONObject.optString(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, "");
                    if (TextUtils.isEmpty(optString)) {
                        zzbzr.zzj("The request ID is empty in request JSON.");
                        this.f19565c.zzb("Internal error: request ID is empty in request JSON.");
                        zzaa zzaaVar2 = this.f19568f;
                        zzdqfVar3 = zzaaVar2.f19516m;
                        zzdpvVar4 = zzaaVar2.f19508e;
                        zzf.zzc(zzdqfVar3, zzdpvVar4, "sgf", new Pair("sgf_reason", "rid_missing"));
                        zzffn zzffnVar2 = this.f19566d;
                        zzffnVar2.zzc("Request ID empty");
                        zzffnVar2.zzf(false);
                        if (((Boolean) zzbcy.zze.zze()).booleanValue() && F != null) {
                            F.zza(this.f19566d);
                            F.zzg();
                            return;
                        }
                        return;
                    }
                    zzaa zzaaVar3 = this.f19568f;
                    String str7 = zzamVar.zzb;
                    zzdpvVar2 = zzaaVar3.f19508e;
                    zzaa.g(zzaaVar3, optString, str7, zzdpvVar2);
                    Bundle bundle = zzamVar.zzc;
                    zzaa zzaaVar4 = this.f19568f;
                    z3 = zzaaVar4.f19521r;
                    if (z3 && bundle != null) {
                        str5 = zzaaVar4.f19523t;
                        if (bundle.getInt(str5, -1) == -1) {
                            zzaa zzaaVar5 = this.f19568f;
                            str6 = zzaaVar5.f19523t;
                            atomicInteger = zzaaVar5.f19524u;
                            bundle.putInt(str6, atomicInteger.get());
                        }
                    }
                    zzaa zzaaVar6 = this.f19568f;
                    z4 = zzaaVar6.f19520q;
                    if (z4 && bundle != null) {
                        str = zzaaVar6.f19522s;
                        if (TextUtils.isEmpty(bundle.getString(str))) {
                            str2 = this.f19568f.f19526w;
                            if (TextUtils.isEmpty(str2)) {
                                zzaa zzaaVar7 = this.f19568f;
                                com.google.android.gms.ads.internal.util.zzs zzp = com.google.android.gms.ads.internal.zzt.zzp();
                                zzaa zzaaVar8 = this.f19568f;
                                context = zzaaVar8.f19505b;
                                zzbzxVar = zzaaVar8.f19525v;
                                zzaaVar7.f19526w = zzp.zzc(context, zzbzxVar.zza);
                            }
                            zzaa zzaaVar9 = this.f19568f;
                            str3 = zzaaVar9.f19522s;
                            str4 = zzaaVar9.f19526w;
                            bundle.putString(str3, str4);
                        }
                    }
                    this.f19565c.zzc(zzamVar.zza, zzamVar.zzb, bundle);
                    zzaa zzaaVar10 = this.f19568f;
                    zzdqfVar2 = zzaaVar10.f19516m;
                    zzdpvVar3 = zzaaVar10.f19508e;
                    Pair[] pairArr = new Pair[2];
                    pairArr[0] = new Pair("tqgt", String.valueOf(currentTimeMillis));
                    String str8 = "na";
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zziZ)).booleanValue()) {
                        try {
                            str8 = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                        } catch (JSONException e5) {
                            zzbzr.zzh("Error retrieving JSONObject from the requestJson, ", e5);
                        }
                    }
                    pairArr[1] = new Pair("tpc", str8);
                    zzf.zzc(zzdqfVar2, zzdpvVar3, "sgs", pairArr);
                    this.f19566d.zzf(true);
                    if (((Boolean) zzbcy.zze.zze()).booleanValue() && F != null) {
                        F.zza(this.f19566d);
                        F.zzg();
                    }
                } catch (JSONException e6) {
                    zzbzr.zzj("Failed to create JSON object from the request string.");
                    zzbyf zzbyfVar = this.f19565c;
                    String obj2 = e6.toString();
                    zzbyfVar.zzb("Internal error for request JSON: " + obj2);
                    zzaa zzaaVar11 = this.f19568f;
                    zzdqfVar = zzaaVar11.f19516m;
                    zzdpvVar = zzaaVar11.f19508e;
                    zzf.zzc(zzdqfVar, zzdpvVar, "sgf", new Pair("sgf_reason", "request_invalid"));
                    zzffn zzffnVar3 = this.f19566d;
                    zzffnVar3.zzg(e6);
                    zzffnVar3.zzf(false);
                    com.google.android.gms.ads.internal.zzt.zzo().zzu(e6, "SignalGeneratorImpl.generateSignals.onSuccess");
                    if (((Boolean) zzbcy.zze.zze()).booleanValue() && F != null) {
                        F.zza(this.f19566d);
                        F.zzg();
                    }
                }
            } catch (Throwable th) {
                if (((Boolean) zzbcy.zze.zze()).booleanValue() && F != null) {
                    F.zza(this.f19566d);
                    F.zzg();
                }
                throw th;
            }
        } catch (RemoteException e7) {
            zzffn zzffnVar4 = this.f19566d;
            zzffnVar4.zzg(e7);
            zzffnVar4.zzf(false);
            zzbzr.zzh("", e7);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e7, "SignalGeneratorImpl.generateSignals.onSuccess");
            if (((Boolean) zzbcy.zze.zze()).booleanValue() && F != null) {
                F.zza(this.f19566d);
                F.zzg();
            }
        }
    }
}
