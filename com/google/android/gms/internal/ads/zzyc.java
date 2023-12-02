package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzyc {
    public static final zzxw zza = new zzxw(0, -9223372036854775807L, null);
    public static final zzxw zzb = new zzxw(1, -9223372036854775807L, null);
    public static final zzxw zzc = new zzxw(2, -9223372036854775807L, null);
    public static final zzxw zzd = new zzxw(3, -9223372036854775807L, null);
    private final ExecutorService zze = zzfj.zzA("ExoPlayer:Loader:ProgressiveMediaPeriod");
    @Nullable
    private zzxx zzf;
    @Nullable
    private IOException zzg;

    public zzyc(String str) {
    }

    public static zzxw zzb(boolean z3, long j4) {
        return new zzxw(z3 ? 1 : 0, j4, null);
    }

    public final long zza(zzxy zzxyVar, zzxu zzxuVar, int i4) {
        Looper myLooper = Looper.myLooper();
        zzdy.zzb(myLooper);
        this.zzg = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzxx(this, myLooper, zzxyVar, zzxuVar, i4, elapsedRealtime).zzc(0L);
        return elapsedRealtime;
    }

    public final void zzg() {
        zzxx zzxxVar = this.zzf;
        zzdy.zzb(zzxxVar);
        zzxxVar.zza(false);
    }

    public final void zzh() {
        this.zzg = null;
    }

    public final void zzi(int i4) throws IOException {
        IOException iOException = this.zzg;
        if (iOException == null) {
            zzxx zzxxVar = this.zzf;
            if (zzxxVar != null) {
                zzxxVar.zzb(i4);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzj(@Nullable zzxz zzxzVar) {
        zzxx zzxxVar = this.zzf;
        if (zzxxVar != null) {
            zzxxVar.zza(true);
        }
        this.zze.execute(new zzya(zzxzVar));
        this.zze.shutdown();
    }

    public final boolean zzk() {
        if (this.zzg != null) {
            return true;
        }
        return false;
    }

    public final boolean zzl() {
        if (this.zzf != null) {
            return true;
        }
        return false;
    }
}
