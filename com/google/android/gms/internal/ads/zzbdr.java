package com.google.android.gms.internal.ads;

import com.google.firebase.firestore.util.ExponentialBackoff;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbdr {
    public static final zzbcr zza = zzbcr.zzb("gads:ad_loader:timeout_ms", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
    public static final zzbcr zzb = zzbcr.zzb("gads:rendering:timeout_ms", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
    public static final zzbcr zzc = zzbcr.zzb("gads:resolve_future:default_timeout_ms", 30000);
}
