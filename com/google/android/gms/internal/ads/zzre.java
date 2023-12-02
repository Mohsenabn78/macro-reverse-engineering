package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzre extends Handler {
    final /* synthetic */ zzrg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzre(zzrg zzrgVar, Looper looper) {
        super(looper);
        this.zza = zzrgVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        zzrg.zza(this.zza, message);
    }
}
