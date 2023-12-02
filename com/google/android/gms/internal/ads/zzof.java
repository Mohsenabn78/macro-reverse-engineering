package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzof {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzof zza(boolean z3) {
        this.zza = true;
        return this;
    }

    public final zzof zzb(boolean z3) {
        this.zzb = z3;
        return this;
    }

    public final zzof zzc(boolean z3) {
        this.zzc = z3;
        return this;
    }

    public final zzoh zzd() {
        if (!this.zza && (this.zzb || this.zzc)) {
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }
        return new zzoh(this, null);
    }
}
