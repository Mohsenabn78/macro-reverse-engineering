package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
final class zzcw extends com.google.android.gms.location.zzq {
    private final zzcs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcw(zzcs zzcsVar) {
        this.zza = zzcsVar;
    }

    @Override // com.google.android.gms.location.zzr
    public final void zzd(LocationAvailability locationAvailability) throws RemoteException {
        this.zza.zza().notifyListener(new zzcu(this, locationAvailability));
    }

    @Override // com.google.android.gms.location.zzr
    public final void zze(LocationResult locationResult) throws RemoteException {
        this.zza.zza().notifyListener(new zzct(this, locationResult));
    }

    @Override // com.google.android.gms.location.zzr
    public final void zzf() {
        this.zza.zza().notifyListener(new zzcv(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcw zzg(ListenerHolder listenerHolder) {
        this.zza.zzc(listenerHolder);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh() {
        this.zza.zza().clear();
    }
}
