package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzava {
    private final float zza;
    private final float zzb;
    private final float zzc;
    private final float zzd;
    private final int zze;

    @VisibleForTesting
    public zzava(float f4, float f5, float f6, float f7, int i4) {
        this.zza = f4;
        this.zzb = f5;
        this.zzc = f4 + f6;
        this.zzd = f5 + f7;
        this.zze = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zza() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzc() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zze() {
        return this.zze;
    }
}
