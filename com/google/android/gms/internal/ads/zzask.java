package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzask extends zzath {
    private final long zzi;

    public zzask(zzart zzartVar, String str, String str2, zzanq zzanqVar, long j4, int i4, int i5) {
        super(zzartVar, "NMP1pkZrrrrQ0P+ZBWjqO+z0j/WpBuzawmkUKjAkUeiPRyMNSyS1dkwhVpRyfOJm", "AZMD/mGrEYmMNAgrqG/aC8rQLooaM7BFn42uxO3SldA=", zzanqVar, i4, 25);
        this.zzi = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke(null, new Object[0])).longValue();
        synchronized (this.zze) {
            this.zze.zzt(longValue);
            long j4 = this.zzi;
            if (j4 != 0) {
                this.zze.zzT(longValue - j4);
                this.zze.zzU(this.zzi);
            }
        }
    }
}
