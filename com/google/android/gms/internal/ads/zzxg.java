package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzxg {
    @Nullable
    private zzxf zza;
    @Nullable
    private zzxo zzb;

    @Nullable
    public zzlj zzc() {
        throw null;
    }

    @CallSuper
    public void zzi() {
        this.zza = null;
        this.zzb = null;
    }

    public void zzj(zzk zzkVar) {
        throw null;
    }

    public boolean zzm() {
        throw null;
    }

    public abstract zzxh zzo(zzlk[] zzlkVarArr, zzvn zzvnVar, zzto zztoVar, zzcw zzcwVar) throws zzih;

    public abstract void zzp(@Nullable Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzxo zzq() {
        zzxo zzxoVar = this.zzb;
        zzdy.zzb(zzxoVar);
        return zzxoVar;
    }

    @CallSuper
    public final void zzr(zzxf zzxfVar, zzxo zzxoVar) {
        this.zza = zzxfVar;
        this.zzb = zzxoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzs() {
        zzxf zzxfVar = this.zza;
        if (zzxfVar != null) {
            zzxfVar.zzj();
        }
    }
}
