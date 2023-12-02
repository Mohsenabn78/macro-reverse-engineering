package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzc  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzc extends Handler {
    private final Looper zza;

    public zzc() {
        this.zza = Looper.getMainLooper();
    }

    public zzc(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }
}
