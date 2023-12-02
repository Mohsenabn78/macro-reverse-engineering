package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfvp extends zzfvb {
    @CheckForNull
    private zzfvo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfvp(zzfrx zzfrxVar, boolean z3, Executor executor, Callable callable) {
        super(zzfrxVar, z3, false);
        this.zza = new zzfvn(this, callable, executor);
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    protected final void zzr() {
        zzfvo zzfvoVar = this.zza;
        if (zzfvoVar != null) {
            zzfvoVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvb
    final void zzv() {
        zzfvo zzfvoVar = this.zza;
        if (zzfvoVar != null) {
            zzfvoVar.zzf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzfvb
    public final void zzz(int i4) {
        super.zzz(i4);
        if (i4 == 1) {
            this.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvb
    final void zzg(int i4, @CheckForNull Object obj) {
    }
}
