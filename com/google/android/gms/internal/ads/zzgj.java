package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgj {
    public static final /* synthetic */ int zzj = 0;
    public final Uri zza;
    public final int zzb;
    @Nullable
    public final byte[] zzc;
    public final Map zzd;
    @Deprecated
    public final long zze;
    public final long zzf;
    public final long zzg;
    @Nullable
    public final String zzh;
    public final int zzi;

    static {
        zzbq.zzb("media3.datasource");
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        long j4 = this.zzf;
        long j5 = this.zzg;
        int i4 = this.zzi;
        return "DataSpec[GET" + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + valueOf + ", " + j4 + ", " + j5 + ", null, " + i4 + "]";
    }

    public final boolean zza(int i4) {
        if ((this.zzi & i4) == i4) {
            return true;
        }
        return false;
    }

    public zzgj(Uri uri) {
        this(uri, 0L, 1, null, Collections.emptyMap(), 0L, -1L, null, 0, null);
    }

    @Deprecated
    public zzgj(Uri uri, @Nullable byte[] bArr, long j4, long j5, long j6, @Nullable String str, int i4) {
        this(uri, j4 - j5, 1, null, Collections.emptyMap(), j5, j6, null, i4, null);
    }

    private zzgj(Uri uri, long j4, int i4, @Nullable byte[] bArr, Map map, long j5, long j6, @Nullable String str, int i5, @Nullable Object obj) {
        long j7 = j4 + j5;
        boolean z3 = false;
        zzdy.zzd(j7 >= 0);
        zzdy.zzd(j5 >= 0);
        if (j6 <= 0) {
            j6 = j6 == -1 ? -1L : j6;
            zzdy.zzd(z3);
            this.zza = uri;
            this.zzb = 1;
            this.zzc = null;
            this.zzd = Collections.unmodifiableMap(new HashMap(map));
            this.zzf = j5;
            this.zze = j7;
            this.zzg = j6;
            this.zzh = null;
            this.zzi = i5;
        }
        z3 = true;
        zzdy.zzd(z3);
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zzf = j5;
        this.zze = j7;
        this.zzg = j6;
        this.zzh = null;
        this.zzi = i5;
    }
}
