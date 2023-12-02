package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfc implements zzdz {
    @Override // com.google.android.gms.internal.ads.zzdz
    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzei zzb(Looper looper, @Nullable Handler.Callback callback) {
        return new zzff(new Handler(looper, callback));
    }
}
