package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzby extends Handler {
    private final Looper zza;

    public zzby() {
        this.zza = Looper.getMainLooper();
    }

    public zzby(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }
}
