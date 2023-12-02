package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbmj implements zzcan {
    final /* synthetic */ zzbmk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmj(zzbmk zzbmkVar) {
        this.zza = zzbmkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzblg zzblgVar = (zzblg) obj;
        zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmi
            @Override // java.lang.Runnable
            public final void run() {
                zzblg zzblgVar2 = zzblgVar;
                zzblgVar2.zzr("/result", zzbii.zzo);
                zzblgVar2.zzc();
            }
        });
    }
}
