package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzyh {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((zzyg) obj).zza - ((zzyg) obj2).zza;
        }
    };
    private static final Comparator zzb = new Comparator() { // from class: com.google.android.gms.internal.ads.zzye
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((zzyg) obj).zzc, ((zzyg) obj2).zzc);
        }
    };
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzyg[] zzd = new zzyg[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzyh(int i4) {
    }

    public final float zza(float f4) {
        ArrayList arrayList;
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f5 = this.zzg;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzc.size(); i5++) {
            zzyg zzygVar = (zzyg) this.zzc.get(i5);
            i4 += zzygVar.zzb;
            if (i4 >= 0.5f * f5) {
                return zzygVar.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        return ((zzyg) this.zzc.get(arrayList.size() - 1)).zzc;
    }

    public final void zzb(int i4, float f4) {
        zzyg zzygVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i5 = this.zzh;
        if (i5 > 0) {
            zzyg[] zzygVarArr = this.zzd;
            int i6 = i5 - 1;
            this.zzh = i6;
            zzygVar = zzygVarArr[i6];
        } else {
            zzygVar = new zzyg(null);
        }
        int i7 = this.zzf;
        this.zzf = i7 + 1;
        zzygVar.zza = i7;
        zzygVar.zzb = i4;
        zzygVar.zzc = f4;
        this.zzc.add(zzygVar);
        this.zzg += i4;
        while (true) {
            int i8 = this.zzg;
            if (i8 > 2000) {
                int i9 = i8 - 2000;
                zzyg zzygVar2 = (zzyg) this.zzc.get(0);
                int i10 = zzygVar2.zzb;
                if (i10 <= i9) {
                    this.zzg -= i10;
                    this.zzc.remove(0);
                    int i11 = this.zzh;
                    if (i11 < 5) {
                        zzyg[] zzygVarArr2 = this.zzd;
                        this.zzh = i11 + 1;
                        zzygVarArr2[i11] = zzygVar2;
                    }
                } else {
                    zzygVar2.zzb = i10 - i9;
                    this.zzg -= i9;
                }
            } else {
                return;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
