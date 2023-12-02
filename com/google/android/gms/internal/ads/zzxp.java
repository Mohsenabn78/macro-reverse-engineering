package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzxp {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzxi[] zzd = new zzxi[100];

    public zzxp(boolean z3, int i4) {
    }

    public final synchronized int zza() {
        return this.zzb * 65536;
    }

    public final synchronized zzxi zzb() {
        zzxi zzxiVar;
        this.zzb++;
        int i4 = this.zzc;
        if (i4 > 0) {
            zzxi[] zzxiVarArr = this.zzd;
            int i5 = i4 - 1;
            this.zzc = i5;
            zzxiVar = zzxiVarArr[i5];
            zzxiVar.getClass();
            zzxiVarArr[i5] = null;
        } else {
            zzxiVar = new zzxi(new byte[65536], 0);
            int i6 = this.zzb;
            zzxi[] zzxiVarArr2 = this.zzd;
            int length = zzxiVarArr2.length;
            if (i6 > length) {
                this.zzd = (zzxi[]) Arrays.copyOf(zzxiVarArr2, length + length);
                return zzxiVar;
            }
        }
        return zzxiVar;
    }

    public final synchronized void zzc(zzxi zzxiVar) {
        zzxi[] zzxiVarArr = this.zzd;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        zzxiVarArr[i4] = zzxiVar;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(@Nullable zzxj zzxjVar) {
        while (zzxjVar != null) {
            zzxi[] zzxiVarArr = this.zzd;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            zzxiVarArr[i4] = zzxjVar.zzc();
            this.zzb--;
            zzxjVar = zzxjVar.zzd();
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i4) {
        int i5 = this.zza;
        this.zza = i4;
        if (i4 < i5) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i4 = this.zza;
        int i5 = zzfj.zza;
        int max = Math.max(0, ((i4 + 65535) / 65536) - this.zzb);
        int i6 = this.zzc;
        if (max >= i6) {
            return;
        }
        Arrays.fill(this.zzd, max, i6, (Object) null);
        this.zzc = max;
    }
}
