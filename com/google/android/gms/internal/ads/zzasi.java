package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzasi extends zzath {
    public zzasi(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5) {
        super(zzartVar, "61r5RjlUpp0Sx9otiMiZNQFewfAHPXct4XNb20i2Qy085lteyha1wknNg1lweS6E", "BxKk+MigL5QcJoHkNRs0ALc6QE50Izh8oVpecosSZ5s=", zzanqVar, i4, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzm(-1L);
        this.zze.zzl(-1L);
        int[] iArr = (int[]) this.zzf.invoke(null, this.zzb.zzb());
        synchronized (this.zze) {
            this.zze.zzm(iArr[0]);
            this.zze.zzl(iArr[1]);
            int i4 = iArr[2];
            if (i4 != Integer.MIN_VALUE) {
                this.zze.zzk(i4);
            }
        }
    }
}
