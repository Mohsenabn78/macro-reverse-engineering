package com.google.android.gms.internal.mlkit_translate;

import android.os.SystemClock;
import androidx.compose.animation.core.AnimationKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public class zzoo implements Closeable {
    private static final Map zza = new HashMap();
    private final String zzb;
    private int zzc;
    private double zzd;
    private long zze;
    private long zzf;
    private long zzg;

    private zzoo(String str) {
        this.zzf = 2147483647L;
        this.zzg = -2147483648L;
        this.zzb = str;
    }

    private final void zza() {
        this.zzc = 0;
        this.zzd = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.zzf = 2147483647L;
        this.zzg = -2147483648L;
    }

    public static zzoo zzd(String str) {
        zzom zzomVar;
        zzrf.zza();
        if (!zzrf.zzb()) {
            zzomVar = zzom.zza;
            return zzomVar;
        }
        Map map = zza;
        if (map.get(str) == null) {
            map.put(str, new zzoo(str));
        }
        return (zzoo) map.get(str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Did you forget to call start()?");
    }

    public void zzb(long j4) {
        zzc(j4 * 1000);
    }

    public void zzc(long j4) {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j5 = this.zze;
        if (j5 != 0 && elapsedRealtimeNanos - j5 >= AnimationKt.MillisToNanos) {
            zza();
        }
        this.zze = elapsedRealtimeNanos;
        this.zzc++;
        this.zzd += j4;
        this.zzf = Math.min(this.zzf, j4);
        this.zzg = Math.max(this.zzg, j4);
        if (this.zzc % 50 == 0) {
            String.format(Locale.US, "[%s] cur=%dus, counts=%d, min=%dus, max=%dus, avg=%dus", this.zzb, Long.valueOf(j4), Integer.valueOf(this.zzc), Long.valueOf(this.zzf), Long.valueOf(this.zzg), Integer.valueOf((int) (this.zzd / this.zzc)));
            zzrf.zza();
        }
        if (this.zzc % 500 == 0) {
            zza();
        }
    }
}
