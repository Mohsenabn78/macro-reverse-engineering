package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzxl {
    private final Handler zza;
    private final zzxn zzb;
    private boolean zzc;

    public zzxl(Handler handler, zzxn zzxnVar) {
        this.zza = handler;
        this.zzb = zzxnVar;
    }

    public final void zzc() {
        this.zzc = true;
    }
}
