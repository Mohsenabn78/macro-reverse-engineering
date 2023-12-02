package com.google.android.gms.internal.nearby;

import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzfx extends zzjv implements zzgl {
    private final ListenerHolder zza;
    private final Set zzb = new ArraySet();
    private final Set zzc = new ArraySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfx(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzjw
    public final void zzb(zzkr zzkrVar) {
        this.zza.notifyListener(new zzfu(this, zzkrVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzjw
    public final synchronized void zzc(zzkt zzktVar) {
        this.zzb.add(zzktVar.zzc());
        this.zza.notifyListener(new zzfr(this, zzktVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzjw
    public final synchronized void zzd(zzkz zzkzVar) {
        Status zzG;
        this.zzb.remove(zzkzVar.zzb());
        zzG = zzgz.zzG(zzkzVar.zza());
        if (zzG.isSuccess()) {
            this.zzc.add(zzkzVar.zzb());
        }
        this.zza.notifyListener(new zzfs(this, zzkzVar, zzG));
    }

    @Override // com.google.android.gms.internal.nearby.zzjw
    public final synchronized void zze(zzlb zzlbVar) {
        this.zzc.remove(zzlbVar.zza());
        this.zza.notifyListener(new zzft(this, zzlbVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzgl
    public final synchronized void zzf() {
        for (String str : this.zzb) {
            this.zza.notifyListener(new zzfv(this, str));
        }
        this.zzb.clear();
        for (String str2 : this.zzc) {
            this.zza.notifyListener(new zzfw(this, str2));
        }
        this.zzc.clear();
    }
}
