package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfbe {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzfwn zzc;

    public zzfbe(Callable callable, zzfwn zzfwnVar) {
        this.zzb = callable;
        this.zzc = zzfwnVar;
    }

    public final synchronized zzfwm zza() {
        zzc(1);
        return (zzfwm) this.zza.poll();
    }

    public final synchronized void zzb(zzfwm zzfwmVar) {
        this.zza.addFirst(zzfwmVar);
    }

    public final synchronized void zzc(int i4) {
        int size = i4 - this.zza.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }
}
