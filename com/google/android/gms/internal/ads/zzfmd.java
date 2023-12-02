package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class zzfmd extends Handler {
    private final Looper zza;

    public zzfmd() {
        this.zza = Looper.getMainLooper();
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        zza(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void zza(Message message) {
        super.dispatchMessage(message);
    }

    public zzfmd(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }
}
