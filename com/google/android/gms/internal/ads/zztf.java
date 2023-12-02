package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zztf {
    private static final AtomicLong zzd = new AtomicLong();
    public final zzgj zza;
    public final Uri zzb;
    public final Map zzc;

    public zztf(long j4, zzgj zzgjVar, Uri uri, Map map, long j5, long j6, long j7) {
        this.zza = zzgjVar;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
