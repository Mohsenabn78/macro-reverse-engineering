package com.google.android.gms.internal.nearby;

import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzgh extends zzkc {
    private final ListenerHolder zza;
    private final Set zzb = new ArraySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzg(zzlf zzlfVar) {
        if (zzlfVar.zza() == null) {
            return false;
        }
        if (zzlfVar.zzb() != null && !"__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(zzlfVar.zzb())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzkd
    public final synchronized void zzb(zzld zzldVar) {
        this.zza.notifyListener(new zzgd(this, zzldVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzkd
    public final synchronized void zzc(zzlf zzlfVar) {
        if (!zzg(zzlfVar)) {
            this.zzb.add(zzlfVar.zzb());
        }
        this.zza.notifyListener(new zzge(this, zzlfVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzkd
    public final synchronized void zzd(zzlh zzlhVar) {
        this.zzb.remove(zzlhVar.zza());
        this.zza.notifyListener(new zzgf(this, zzlhVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zze() {
        for (String str : this.zzb) {
            this.zza.notifyListener(new zzgg(this, str));
        }
        this.zzb.clear();
    }
}
