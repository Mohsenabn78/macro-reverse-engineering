package com.google.android.gms.internal.ads;

import com.arlosoft.macrodroid.common.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfxs {
    public static final zzfxs zza = new zzfxs(Constants.ENABLED_LOG_PREFIX);
    public static final zzfxs zzb = new zzfxs(Constants.DISABLED_LOG_PREFIX);
    public static final zzfxs zzc = new zzfxs("DESTROYED");
    private final String zzd;

    private zzfxs(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
