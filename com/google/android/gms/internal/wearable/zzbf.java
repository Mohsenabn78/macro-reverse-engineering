package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbf implements zzew {
    private final zzbe zza;

    private zzbf(zzbe zzbeVar) {
        zzcd.zzf(zzbeVar, "output");
        this.zza = zzbeVar;
        zzbeVar.zza = this;
    }

    public static zzbf zza(zzbe zzbeVar) {
        zzbf zzbfVar = zzbeVar.zza;
        if (zzbfVar != null) {
            return zzbfVar;
        }
        return new zzbf(zzbeVar);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzA(int i4, int i5) throws IOException {
        this.zza.zzp(i4, (i5 >> 31) ^ (i5 + i5));
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzB(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int intValue = ((Integer) list.get(i7)).intValue();
                i6 += zzbe.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                zzbe zzbeVar = this.zza;
                int intValue2 = ((Integer) list.get(i5)).intValue();
                zzbeVar.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            zzbe zzbeVar2 = this.zza;
            int intValue3 = ((Integer) list.get(i5)).intValue();
            zzbeVar2.zzp(i4, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzC(int i4, long j4) throws IOException {
        this.zza.zzr(i4, (j4 >> 63) ^ (j4 + j4));
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzD(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long longValue = ((Long) list.get(i7)).longValue();
                i6 += zzbe.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                zzbe zzbeVar = this.zza;
                long longValue2 = ((Long) list.get(i5)).longValue();
                zzbeVar.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            zzbe zzbeVar2 = this.zza;
            long longValue3 = ((Long) list.get(i5)).longValue();
            zzbeVar2.zzr(i4, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    @Deprecated
    public final void zzE(int i4) throws IOException {
        this.zza.zzo(i4, 3);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzF(int i4, String str) throws IOException {
        this.zza.zzm(i4, str);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzG(int i4, List list) throws IOException {
        int i5 = 0;
        if (list instanceof zzck) {
            zzck zzckVar = (zzck) list;
            while (i5 < list.size()) {
                Object zzf = zzckVar.zzf(i5);
                if (zzf instanceof String) {
                    this.zza.zzm(i4, (String) zzf);
                } else {
                    this.zza.zze(i4, (zzaw) zzf);
                }
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzm(i4, (String) list.get(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzH(int i4, int i5) throws IOException {
        this.zza.zzp(i4, i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzI(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbe.zzA(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzq(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzp(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzJ(int i4, long j4) throws IOException {
        this.zza.zzr(i4, j4);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzK(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbe.zzB(((Long) list.get(i7)).longValue());
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzs(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzr(i4, ((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzb(int i4, boolean z3) throws IOException {
        this.zza.zzd(i4, z3);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzc(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Boolean) list.get(i7)).booleanValue();
                i6++;
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i5)).booleanValue() ? (byte) 1 : (byte) 0);
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzd(i4, ((Boolean) list.get(i5)).booleanValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzd(int i4, zzaw zzawVar) throws IOException {
        this.zza.zze(i4, zzawVar);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zze(int i4, List list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.zza.zze(i4, (zzaw) list.get(i5));
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzf(int i4, double d4) throws IOException {
        this.zza.zzh(i4, Double.doubleToRawLongBits(d4));
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzg(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Double) list.get(i7)).doubleValue();
                i6 += 8;
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzh(i4, Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    @Deprecated
    public final void zzh(int i4) throws IOException {
        this.zza.zzo(i4, 4);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzi(int i4, int i5) throws IOException {
        this.zza.zzj(i4, i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzj(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbe.zzv(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzk(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzj(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzk(int i4, int i5) throws IOException {
        this.zza.zzf(i4, i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzl(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).intValue();
                i6 += 4;
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzg(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzf(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzm(int i4, long j4) throws IOException {
        this.zza.zzh(i4, j4);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzn(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).longValue();
                i6 += 8;
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzi(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzh(i4, ((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzo(int i4, float f4) throws IOException {
        this.zza.zzf(i4, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzp(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Float) list.get(i7)).floatValue();
                i6 += 4;
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzf(i4, Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzq(int i4, Object obj, zzdn zzdnVar) throws IOException {
        zzbe zzbeVar = this.zza;
        zzbeVar.zzo(i4, 3);
        zzdnVar.zzi((zzdc) obj, zzbeVar.zza);
        zzbeVar.zzo(i4, 4);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzr(int i4, int i5) throws IOException {
        this.zza.zzj(i4, i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzs(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbe.zzv(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzk(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzj(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzt(int i4, long j4) throws IOException {
        this.zza.zzr(i4, j4);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzu(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbe.zzB(((Long) list.get(i7)).longValue());
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzs(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzr(i4, ((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzv(int i4, Object obj, zzdn zzdnVar) throws IOException {
        Object obj2 = (zzdc) obj;
        zzbb zzbbVar = (zzbb) this.zza;
        zzbbVar.zzq((i4 << 3) | 2);
        zzag zzagVar = (zzag) obj2;
        int zzH = zzagVar.zzH();
        if (zzH == -1) {
            zzH = zzdnVar.zza(zzagVar);
            zzagVar.zzK(zzH);
        }
        zzbbVar.zzq(zzH);
        zzdnVar.zzi(obj2, zzbbVar.zza);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzw(int i4, int i5) throws IOException {
        this.zza.zzf(i4, i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzx(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).intValue();
                i6 += 4;
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzg(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzf(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzy(int i4, long j4) throws IOException {
        this.zza.zzh(i4, j4);
    }

    @Override // com.google.android.gms.internal.wearable.zzew
    public final void zzz(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).longValue();
                i6 += 8;
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                this.zza.zzi(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzh(i4, ((Long) list.get(i5)).longValue());
            i5++;
        }
    }
}
