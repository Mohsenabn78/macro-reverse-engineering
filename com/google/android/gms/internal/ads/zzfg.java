package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfg {
    private long[] zza;
    private Object[] zzb;
    private int zzc;
    private int zzd;

    public zzfg(int i4) {
        this.zza = new long[10];
        this.zzb = new Object[10];
    }

    @Nullable
    private final Object zzf() {
        boolean z3;
        if (this.zzd > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        Object[] objArr = this.zzb;
        int i4 = this.zzc;
        Object obj = objArr[i4];
        objArr[i4] = null;
        this.zzc = (i4 + 1) % objArr.length;
        this.zzd--;
        return obj;
    }

    public final synchronized int zza() {
        return this.zzd;
    }

    @Nullable
    public final synchronized Object zzb() {
        if (this.zzd == 0) {
            return null;
        }
        return zzf();
    }

    @Nullable
    public final synchronized Object zzc(long j4) {
        Object obj;
        obj = null;
        while (this.zzd > 0 && j4 - this.zza[this.zzc] >= 0) {
            obj = zzf();
        }
        return obj;
    }

    public final synchronized void zzd(long j4, Object obj) {
        int i4 = this.zzd;
        if (i4 > 0) {
            if (j4 <= this.zza[((this.zzc + i4) - 1) % this.zzb.length]) {
                zze();
            }
        }
        int length = this.zzb.length;
        if (this.zzd >= length) {
            int i5 = length + length;
            long[] jArr = new long[i5];
            Object[] objArr = new Object[i5];
            int i6 = this.zzc;
            int i7 = length - i6;
            System.arraycopy(this.zza, i6, jArr, 0, i7);
            System.arraycopy(this.zzb, this.zzc, objArr, 0, i7);
            int i8 = this.zzc;
            if (i8 > 0) {
                System.arraycopy(this.zza, 0, jArr, i7, i8);
                System.arraycopy(this.zzb, 0, objArr, i7, this.zzc);
            }
            this.zza = jArr;
            this.zzb = objArr;
            this.zzc = 0;
        }
        int i9 = this.zzc;
        int i10 = this.zzd;
        Object[] objArr2 = this.zzb;
        int length2 = (i9 + i10) % objArr2.length;
        this.zza[length2] = j4;
        objArr2[length2] = obj;
        this.zzd = i10 + 1;
    }

    public final synchronized void zze() {
        this.zzc = 0;
        this.zzd = 0;
        Arrays.fill(this.zzb, (Object) null);
    }

    public zzfg() {
        this(10);
    }
}
