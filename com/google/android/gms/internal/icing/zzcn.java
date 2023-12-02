package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzcn {
    private final zzcm zza;

    private zzcn(zzcm zzcmVar) {
        zzdh.zzb(zzcmVar, "output");
        this.zza = zzcmVar;
        zzcmVar.zza = this;
    }

    public static zzcn zza(zzcm zzcmVar) {
        zzcn zzcnVar = zzcmVar.zza;
        if (zzcnVar != null) {
            return zzcnVar;
        }
        return new zzcn(zzcmVar);
    }

    public final void zzA(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzcm.zzv(list.get(i7).intValue());
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzk(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzb(i4, list.get(i5).intValue());
            i5++;
        }
    }

    public final void zzB(int i4, List<Boolean> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                list.get(i7).booleanValue();
                i6++;
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzj(list.get(i5).booleanValue() ? (byte) 1 : (byte) 0);
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzg(i4, list.get(i5).booleanValue());
            i5++;
        }
    }

    public final void zzC(int i4, List<String> list) throws IOException {
        int i5 = 0;
        if (list instanceof zzdo) {
            zzdo zzdoVar = (zzdo) list;
            while (i5 < list.size()) {
                Object zzg = zzdoVar.zzg(i5);
                if (zzg instanceof String) {
                    this.zza.zzh(i4, (String) zzg);
                } else {
                    this.zza.zzi(i4, (zzcf) zzg);
                }
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzh(i4, list.get(i5));
            i5++;
        }
    }

    public final void zzD(int i4, List<zzcf> list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.zza.zzi(i4, list.get(i5));
        }
    }

    public final void zzE(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzcm.zzw(list.get(i7).intValue());
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzl(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzc(i4, list.get(i5).intValue());
            i5++;
        }
    }

    public final void zzF(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                list.get(i7).intValue();
                i6 += 4;
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzm(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzd(i4, list.get(i5).intValue());
            i5++;
        }
    }

    public final void zzG(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                list.get(i7).longValue();
                i6 += 8;
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzo(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzf(i4, list.get(i5).longValue());
            i5++;
        }
    }

    public final void zzH(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int intValue = list.get(i7).intValue();
                i6 += zzcm.zzw((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                zzcm zzcmVar = this.zza;
                int intValue2 = list.get(i5).intValue();
                zzcmVar.zzl((intValue2 >> 31) ^ (intValue2 + intValue2));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            zzcm zzcmVar2 = this.zza;
            int intValue3 = list.get(i5).intValue();
            zzcmVar2.zzc(i4, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i5++;
        }
    }

    public final void zzI(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long longValue = list.get(i7).longValue();
                i6 += zzcm.zzx((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                zzcm zzcmVar = this.zza;
                long longValue2 = list.get(i5).longValue();
                zzcmVar.zzn((longValue2 >> 63) ^ (longValue2 + longValue2));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            zzcm zzcmVar2 = this.zza;
            long longValue3 = list.get(i5).longValue();
            zzcmVar2.zze(i4, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i5++;
        }
    }

    public final void zzb(int i4, int i5) throws IOException {
        this.zza.zzd(i4, i5);
    }

    public final void zzc(int i4, long j4) throws IOException {
        this.zza.zze(i4, j4);
    }

    public final void zzd(int i4, long j4) throws IOException {
        this.zza.zzf(i4, j4);
    }

    public final void zze(int i4, float f4) throws IOException {
        this.zza.zzd(i4, Float.floatToRawIntBits(f4));
    }

    public final void zzf(int i4, double d4) throws IOException {
        this.zza.zzf(i4, Double.doubleToRawLongBits(d4));
    }

    public final void zzg(int i4, int i5) throws IOException {
        this.zza.zzb(i4, i5);
    }

    public final void zzh(int i4, long j4) throws IOException {
        this.zza.zze(i4, j4);
    }

    public final void zzi(int i4, int i5) throws IOException {
        this.zza.zzb(i4, i5);
    }

    public final void zzj(int i4, long j4) throws IOException {
        this.zza.zzf(i4, j4);
    }

    public final void zzk(int i4, int i5) throws IOException {
        this.zza.zzd(i4, i5);
    }

    public final void zzl(int i4, boolean z3) throws IOException {
        this.zza.zzg(i4, z3);
    }

    public final void zzm(int i4, String str) throws IOException {
        this.zza.zzh(i4, str);
    }

    public final void zzn(int i4, zzcf zzcfVar) throws IOException {
        this.zza.zzi(i4, zzcfVar);
    }

    public final void zzo(int i4, int i5) throws IOException {
        this.zza.zzc(i4, i5);
    }

    public final void zzp(int i4, int i5) throws IOException {
        this.zza.zzc(i4, (i5 >> 31) ^ (i5 + i5));
    }

    public final void zzq(int i4, long j4) throws IOException {
        this.zza.zze(i4, (j4 >> 63) ^ (j4 + j4));
    }

    public final void zzr(int i4, Object obj, zzep zzepVar) throws IOException {
        zzee zzeeVar = (zzee) obj;
        zzck zzckVar = (zzck) this.zza;
        zzckVar.zzl((i4 << 3) | 2);
        zzbs zzbsVar = (zzbs) zzeeVar;
        int zzi = zzbsVar.zzi();
        if (zzi == -1) {
            zzi = zzepVar.zzd(zzbsVar);
            zzbsVar.zzj(zzi);
        }
        zzckVar.zzl(zzi);
        zzepVar.zzi(zzeeVar, zzckVar.zza);
    }

    public final void zzs(int i4, Object obj, zzep zzepVar) throws IOException {
        zzcm zzcmVar = this.zza;
        zzcmVar.zza(i4, 3);
        zzepVar.zzi((zzee) obj, zzcmVar.zza);
        zzcmVar.zza(i4, 4);
    }

    public final void zzt(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzcm.zzv(list.get(i7).intValue());
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzk(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzb(i4, list.get(i5).intValue());
            i5++;
        }
    }

    public final void zzu(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                list.get(i7).intValue();
                i6 += 4;
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzm(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzd(i4, list.get(i5).intValue());
            i5++;
        }
    }

    public final void zzv(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzcm.zzx(list.get(i7).longValue());
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzn(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zze(i4, list.get(i5).longValue());
            i5++;
        }
    }

    public final void zzw(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzcm.zzx(list.get(i7).longValue());
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzn(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zze(i4, list.get(i5).longValue());
            i5++;
        }
    }

    public final void zzx(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                list.get(i7).longValue();
                i6 += 8;
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzo(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzf(i4, list.get(i5).longValue());
            i5++;
        }
    }

    public final void zzy(int i4, List<Float> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                list.get(i7).floatValue();
                i6 += 4;
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzm(Float.floatToRawIntBits(list.get(i5).floatValue()));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzd(i4, Float.floatToRawIntBits(list.get(i5).floatValue()));
            i5++;
        }
    }

    public final void zzz(int i4, List<Double> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                list.get(i7).doubleValue();
                i6 += 8;
            }
            this.zza.zzl(i6);
            while (i5 < list.size()) {
                this.zza.zzo(Double.doubleToRawLongBits(list.get(i5).doubleValue()));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzf(i4, Double.doubleToRawLongBits(list.get(i5).doubleValue()));
            i5++;
        }
    }
}
