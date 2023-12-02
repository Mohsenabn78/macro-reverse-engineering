package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdxi {
    @VisibleForTesting
    public zzfwm zza;
    private final zzcxz zzb;
    private final zzdwq zzc;
    private final zzfel zzd;
    private final zzfai zze;
    private final zzbzx zzf;
    private final zzfgb zzg;
    private final zzffy zzh;
    private final Context zzi;
    private final zzfwn zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxi(zzcxz zzcxzVar, zzdwq zzdwqVar, zzfel zzfelVar, zzfai zzfaiVar, zzbzx zzbzxVar, zzfgb zzfgbVar, zzffy zzffyVar, Context context, zzfwn zzfwnVar) {
        this.zzb = zzcxzVar;
        this.zzc = zzdwqVar;
        this.zzd = zzfelVar;
        this.zze = zzfaiVar;
        this.zzf = zzbzxVar;
        this.zzg = zzfgbVar;
        this.zzh = zzffyVar;
        this.zzi = context;
        this.zzj = zzfwnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbtm zza(zzbue zzbueVar, zzdyt zzdytVar) {
        Context context = this.zzi;
        zzdytVar.zzc.put("Content-Type", zzdytVar.zze);
        zzdytVar.zzc.put("User-Agent", com.google.android.gms.ads.internal.zzt.zzp().zzc(context, zzbueVar.zzb.zza));
        String str = zzdytVar.zza;
        int i4 = zzdytVar.zzb;
        Map map = zzdytVar.zzc;
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return new zzbtm(str, i4, bundle, zzdytVar.zzd, zzdytVar.zzf, zzbueVar.zzd, zzbueVar.zzh);
    }

    public final zzfwm zzc(final zzbue zzbueVar, final JSONObject jSONObject, final zzbuh zzbuhVar) {
        this.zzb.zzbA(zzbueVar);
        zzfec zzb = this.zzd.zzb(zzfef.PROXY, zzfwc.zzl(this.zzd.zzb(zzfef.PREPARE_HTTP_REQUEST, zzfwc.zzh(new zzdyx(jSONObject, zzbuhVar))).zze(new zzdyy(zzbueVar.zzg, this.zzh, zzffm.zza(this.zzi, 9))).zza(), new zzfov() { // from class: com.google.android.gms.internal.ads.zzdxg
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                return zzdxi.this.zza(zzbueVar, (zzdyt) obj);
            }
        }, this.zzj));
        final zzdwq zzdwqVar = this.zzc;
        zzfdq zza = zzb.zzf(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdxd
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdwq.this.zzc((zzbtm) obj);
            }
        }).zza();
        this.zza = zza;
        zzfwm zzm = zzfwc.zzm(this.zzd.zzb(zzfef.PRE_PROCESS, zza).zze(new zzfdo() { // from class: com.google.android.gms.internal.ads.zzdxf
            @Override // com.google.android.gms.internal.ads.zzfdo
            public final Object zza(Object obj) {
                return new zzdyg(zzdyu.zza(new InputStreamReader((InputStream) obj)), jSONObject, zzbuhVar);
            }
        }).zzf(com.google.android.gms.ads.internal.zzt.zzf().zza(this.zzi, this.zzf, this.zzg).zza("google.afma.response.normalize", zzdyg.zza, zzbmw.zzb)).zza(), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdxe
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdxi.this.zzd((InputStream) obj);
            }
        }, this.zzj);
        zzfwc.zzq(zzm, new zzdxh(this), this.zzj);
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzd(InputStream inputStream) throws Exception {
        return zzfwc.zzh(new zzezz(new zzezw(this.zze), zzezy.zza(new InputStreamReader(inputStream))));
    }
}
