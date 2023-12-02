package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbbe {
    private final int zza;
    private final String zzb;
    private final Object zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbbe(int i4, String str, Object obj, zzbbd zzbbdVar) {
        this.zza = i4;
        this.zzb = str;
        this.zzc = obj;
        com.google.android.gms.ads.internal.client.zzba.zza().zzd(this);
    }

    public static zzbbe zzf(int i4, String str, float f4) {
        return new zzbbb(1, str, Float.valueOf(f4));
    }

    public static zzbbe zzg(int i4, String str, int i5) {
        return new zzbaz(1, str, Integer.valueOf(i5));
    }

    public static zzbbe zzh(int i4, String str, long j4) {
        return new zzbba(1, str, Long.valueOf(j4));
    }

    public static zzbbe zzi(int i4, String str, Boolean bool) {
        return new zzbay(i4, str, bool);
    }

    public static zzbbe zzj(int i4, String str, String str2) {
        return new zzbbc(1, str, str2);
    }

    public static zzbbe zzk(int i4, String str) {
        zzbbe zzj = zzj(1, "gads:sdk_core_constants:experiment_id", null);
        com.google.android.gms.ads.internal.client.zzba.zza().zzc(zzj);
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, Object obj);

    public final int zze() {
        return this.zza;
    }

    public final Object zzl() {
        return com.google.android.gms.ads.internal.client.zzba.zzc().zzb(this);
    }

    public final Object zzm() {
        return this.zzc;
    }

    public final String zzn() {
        return this.zzb;
    }
}
