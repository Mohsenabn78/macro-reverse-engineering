package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzf {
    private final zzal zza = zzao.zzg();
    private Boolean zzb;

    private zzf() {
    }

    public final zzf zza() {
        boolean z3;
        if (this.zzb == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzac.zzd(z3, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = Boolean.FALSE;
        return this;
    }

    public final zzf zzb() {
        boolean z3;
        if (this.zzb == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzac.zzd(z3, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = Boolean.TRUE;
        return this;
    }

    public final zzh zzc() {
        if (this.zzb != null) {
            return new zzh(this.zzb.booleanValue(), false, this.zza.zzd(), null);
        }
        throw new NullPointerException("Must call internal() or external() when building a SourcePolicy.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzf(zze zzeVar) {
    }
}
