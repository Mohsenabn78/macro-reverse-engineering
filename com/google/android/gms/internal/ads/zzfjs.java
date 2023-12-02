package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzfjs implements zzfjt {
    private static final zzaon zza;

    static {
        zzanq zza2 = zzaon.zza();
        zza2.zzx(ExifInterface.LONGITUDE_EAST);
        zza = (zzaon) zza2.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzfjt
    public final zzaon zza() {
        return zza;
    }
}
