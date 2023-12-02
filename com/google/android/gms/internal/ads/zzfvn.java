package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfvn extends zzfvo {
    final /* synthetic */ zzfvp zza;
    private final Callable zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvn(zzfvp zzfvpVar, Callable callable, Executor executor) {
        super(zzfvpVar, executor);
        this.zza = zzfvpVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    final String zzb() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfvo
    final void zzc(Object obj) {
        this.zza.zzd(obj);
    }
}
