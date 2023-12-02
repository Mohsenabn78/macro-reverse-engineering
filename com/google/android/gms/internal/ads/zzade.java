package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
abstract class zzade {
    protected final zzabz zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzade(zzabz zzabzVar) {
        this.zza = zzabzVar;
    }

    protected abstract boolean zza(zzfa zzfaVar) throws zzcd;

    protected abstract boolean zzb(zzfa zzfaVar, long j4) throws zzcd;

    public final boolean zzf(zzfa zzfaVar, long j4) throws zzcd {
        if (zza(zzfaVar) && zzb(zzfaVar, j4)) {
            return true;
        }
        return false;
    }
}
