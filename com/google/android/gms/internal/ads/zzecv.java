package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzecv implements zzeci {
    private final Context zza;
    private final zzcop zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzecv(Context context, zzcop zzcopVar) {
        this.zza = context;
        this.zzb = zzcopVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan, zzefu {
        zzeeh zzeehVar = new zzeeh(zzeznVar, (zzbpt) zzecfVar.zzb, AdFormat.APP_OPEN_AD);
        zzcom zza = this.zzb.zza(new zzcrs(zzezzVar, zzeznVar, zzecfVar.zza), new zzddr(zzeehVar, null), new zzcon(zzeznVar.zzab));
        zzeehVar.zzb(zza.zzc());
        ((zzedy) zzecfVar.zzc).zzc(zza.zzi());
        return zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final void zzb(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan {
        try {
            ((zzbpt) zzecfVar.zzb).zzq(zzeznVar.zzaa);
            ((zzbpt) zzecfVar.zzb).zzi(zzeznVar.zzV, zzeznVar.zzw.toString(), zzezzVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzecu(zzecfVar, null), (zzboc) zzecfVar.zzc);
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading an app open RTB ad", e4);
            throw new zzfan(e4);
        }
    }
}
