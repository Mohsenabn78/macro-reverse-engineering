package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzges {
    private final Class zza;
    private final Class zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzges(Class cls, Class cls2, zzger zzgerVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzges zzb(zzgeq zzgeqVar, Class cls, Class cls2) {
        return new zzgep(cls, cls2, zzgeqVar);
    }

    public abstract Object zza(zzfxn zzfxnVar) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
