package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzedm extends zzbpg {
    final /* synthetic */ zzedn zza;
    private final zzecf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzedm(zzedn zzednVar, zzecf zzecfVar, zzedl zzedlVar) {
        this.zza = zzednVar;
        this.zzb = zzecfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zze(String str) throws RemoteException {
        ((zzedy) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzedy) this.zzb.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzedn.zze(this.zza, (View) ObjectWrapper.unwrap(iObjectWrapper));
        ((zzedy) this.zzb.zzc).zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzh(zzbof zzbofVar) throws RemoteException {
        zzedn.zzd(this.zza, zzbofVar);
        ((zzedy) this.zzb.zzc).zzo();
    }
}
