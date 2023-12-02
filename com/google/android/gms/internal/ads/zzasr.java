package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzasr extends zzath {
    private final zzarl zzi;

    public zzasr(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5, zzarl zzarlVar) {
        super(zzartVar, "bdLwb+FSMvnkuJhbzKDCMXfu1B/xx4c1DUAXM+xzbUjcDvNDxjFjT1GT/o1T/BYK", "os/73Qwr79ouqjFLpLjJlgtKKsT75hksFSajjoaerIA=", zzanqVar, i4, 94);
        this.zzi = zzarlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int intValue = ((Integer) this.zzf.invoke(null, this.zzi.zza())).intValue();
        synchronized (this.zze) {
            this.zze.zzae(zzaoe.zza(intValue));
        }
    }
}
