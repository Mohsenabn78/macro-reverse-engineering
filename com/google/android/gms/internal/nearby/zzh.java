package com.google.android.gms.internal.nearby;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class zzh extends Handler {
    private final Looper zza;

    public zzh() {
        this.zza = Looper.getMainLooper();
    }

    public zzh(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }
}
