package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
final class zzcz extends com.google.android.gms.location.zzt {
    private final zzcs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcz(zzcs zzcsVar) {
        this.zza = zzcsVar;
    }

    @Override // com.google.android.gms.location.zzu
    public final void zzd(Location location) {
        this.zza.zza().notifyListener(new zzcx(this, location));
    }

    @Override // com.google.android.gms.location.zzu
    public final void zze() {
        this.zza.zza().notifyListener(new zzcy(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcz zzf(ListenerHolder listenerHolder) {
        this.zza.zzc(listenerHolder);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg() {
        this.zza.zza().clear();
    }
}
