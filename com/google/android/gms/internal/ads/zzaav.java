package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaav implements zzabz {
    private final byte[] zza = new byte[4096];

    @Override // com.google.android.gms.internal.ads.zzabz
    public final /* synthetic */ int zze(zzt zztVar, int i4, boolean z3) {
        return zzabx.zza(this, zztVar, i4, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final int zzf(zzt zztVar, int i4, boolean z3, int i5) throws IOException {
        int zza = zztVar.zza(this.zza, 0, Math.min(4096, i4));
        if (zza == -1) {
            if (z3) {
                return -1;
            }
            throw new EOFException();
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final /* synthetic */ void zzq(zzfa zzfaVar, int i4) {
        zzabx.zzb(this, zzfaVar, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzr(zzfa zzfaVar, int i4, int i5) {
        zzfaVar.zzG(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzk(zzam zzamVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzs(long j4, int i4, int i5, int i6, @Nullable zzaby zzabyVar) {
    }
}
