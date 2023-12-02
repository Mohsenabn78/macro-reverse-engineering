package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdrp implements zzdqz {
    private final long zza;
    private final zzdre zzb;
    private final zzeze zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdrp(long j4, Context context, zzdre zzdreVar, zzcgu zzcguVar, String str) {
        this.zza = j4;
        this.zzb = zzdreVar;
        zzezg zzu = zzcguVar.zzu();
        zzu.zzb(context);
        zzu.zza(str);
        this.zzc = zzu.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        try {
            this.zzc.zzf(zzlVar, new zzdrn(this));
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final void zzc() {
        try {
            this.zzc.zzk(new zzdro(this));
            this.zzc.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final void zza() {
    }
}
