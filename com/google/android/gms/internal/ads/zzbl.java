package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbl {
    @Nullable
    public final Uri zzc = null;
    @Nullable
    public final String zzd = null;
    public static final zzbl zza = new zzbl(new zzbk());
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);
    private static final String zzg = Integer.toString(2, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzbj
    };

    private zzbl(zzbk zzbkVar) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbl)) {
            return false;
        }
        Uri uri = ((zzbl) obj).zzc;
        if (zzfj.zzC(null, null) && zzfj.zzC(null, null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }
}
