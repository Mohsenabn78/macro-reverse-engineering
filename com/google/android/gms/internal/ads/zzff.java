package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzff implements zzei {
    @GuardedBy("messagePool")
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzff(Handler handler) {
        this.zzb = handler;
    }

    public static /* bridge */ /* synthetic */ void zzl(zzfe zzfeVar) {
        List list = zza;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(zzfeVar);
            }
        }
    }

    private static zzfe zzm() {
        zzfe zzfeVar;
        List list = zza;
        synchronized (list) {
            if (list.isEmpty()) {
                zzfeVar = new zzfe(null);
            } else {
                zzfeVar = (zzfe) list.remove(list.size() - 1);
            }
        }
        return zzfeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final Looper zza() {
        return this.zzb.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final zzeh zzb(int i4) {
        zzfe zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(i4), this);
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final zzeh zzc(int i4, @Nullable Object obj) {
        zzfe zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(i4, obj), this);
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final zzeh zzd(int i4, int i5, int i6) {
        zzfe zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(1, i5, i6), this);
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final void zze(@Nullable Object obj) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final void zzf(int i4) {
        this.zzb.removeMessages(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final boolean zzg(int i4) {
        return this.zzb.hasMessages(0);
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final boolean zzh(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final boolean zzi(int i4) {
        return this.zzb.sendEmptyMessage(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final boolean zzj(int i4, long j4) {
        return this.zzb.sendEmptyMessageAtTime(2, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzei
    public final boolean zzk(zzeh zzehVar) {
        return ((zzfe) zzehVar).zzc(this.zzb);
    }
}
