package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.material.badge.BadgeDrawable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfnl {
    public static zzfnk zzj() {
        zzfmq zzfmqVar = new zzfmq();
        zzfmqVar.zzd(BadgeDrawable.BOTTOM_START);
        zzfmqVar.zze(-1.0f);
        zzfmqVar.zzc(0);
        zzfmqVar.zzf(false);
        return zzfmqVar;
    }

    public abstract float zza();

    public abstract int zzb();

    public abstract int zzc();

    public abstract int zzd();

    public abstract IBinder zze();

    @Nullable
    public abstract String zzf();

    @Nullable
    public abstract String zzg();

    @Nullable
    public abstract String zzh();

    public abstract boolean zzi();
}
