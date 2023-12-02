package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagm  reason: invalid package */
/* loaded from: classes4.dex */
final class zzagm {
    private final zzagl zza;

    private zzagm(zzagl zzaglVar) {
        byte[] bArr = zzahj.zzd;
        this.zza = zzaglVar;
        zzaglVar.zze = this;
    }

    public static zzagm zza(zzagl zzaglVar) {
        zzagm zzagmVar = zzaglVar.zze;
        if (zzagmVar != null) {
            return zzagmVar;
        }
        return new zzagm(zzaglVar);
    }

    public final void zzA(int i4, int i5) throws IOException {
        this.zza.zzr(i4, (i5 >> 31) ^ (i5 + i5));
    }

    public final void zzB(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int intValue = ((Integer) list.get(i7)).intValue();
                i6 += zzagl.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                zzagl zzaglVar = this.zza;
                int intValue2 = ((Integer) list.get(i5)).intValue();
                zzaglVar.zzs((intValue2 >> 31) ^ (intValue2 + intValue2));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            zzagl zzaglVar2 = this.zza;
            int intValue3 = ((Integer) list.get(i5)).intValue();
            zzaglVar2.zzr(i4, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i5++;
        }
    }

    public final void zzC(int i4, long j4) throws IOException {
        this.zza.zzt(i4, (j4 >> 63) ^ (j4 + j4));
    }

    public final void zzD(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long longValue = ((Long) list.get(i7)).longValue();
                i6 += zzagl.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                zzagl zzaglVar = this.zza;
                long longValue2 = ((Long) list.get(i5)).longValue();
                zzaglVar.zzu((longValue2 >> 63) ^ (longValue2 + longValue2));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            zzagl zzaglVar2 = this.zza;
            long longValue3 = ((Long) list.get(i5)).longValue();
            zzaglVar2.zzt(i4, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i5++;
        }
    }

    @Deprecated
    public final void zzE(int i4) throws IOException {
        this.zza.zzq(i4, 3);
    }

    public final void zzF(int i4, String str) throws IOException {
        this.zza.zzo(i4, str);
    }

    public final void zzG(int i4, List list) throws IOException {
        int i5 = 0;
        if (list instanceof zzahq) {
            zzahq zzahqVar = (zzahq) list;
            while (i5 < list.size()) {
                Object zzf = zzahqVar.zzf(i5);
                if (zzf instanceof String) {
                    this.zza.zzo(i4, (String) zzf);
                } else {
                    this.zza.zzL(i4, (zzafy) zzf);
                }
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzo(i4, (String) list.get(i5));
            i5++;
        }
    }

    public final void zzH(int i4, int i5) throws IOException {
        this.zza.zzr(i4, i5);
    }

    public final void zzI(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzagl.zzA(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzs(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzr(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public final void zzJ(int i4, long j4) throws IOException {
        this.zza.zzt(i4, j4);
    }

    public final void zzK(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzagl.zzB(((Long) list.get(i7)).longValue());
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzu(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzt(i4, ((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    public final void zzb(int i4, boolean z3) throws IOException {
        this.zza.zzK(i4, z3);
    }

    public final void zzc(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Boolean) list.get(i7)).booleanValue();
                i6++;
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzJ(((Boolean) list.get(i5)).booleanValue() ? (byte) 1 : (byte) 0);
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzK(i4, ((Boolean) list.get(i5)).booleanValue());
            i5++;
        }
    }

    public final void zzd(int i4, zzafy zzafyVar) throws IOException {
        this.zza.zzL(i4, zzafyVar);
    }

    public final void zze(int i4, List list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.zza.zzL(i4, (zzafy) list.get(i5));
        }
    }

    public final void zzf(int i4, double d4) throws IOException {
        this.zza.zzj(i4, Double.doubleToRawLongBits(d4));
    }

    public final void zzg(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Double) list.get(i7)).doubleValue();
                i6 += 8;
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzj(i4, Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
            i5++;
        }
    }

    @Deprecated
    public final void zzh(int i4) throws IOException {
        this.zza.zzq(i4, 4);
    }

    public final void zzi(int i4, int i5) throws IOException {
        this.zza.zzl(i4, i5);
    }

    public final void zzj(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzagl.zzx(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzm(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzl(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public final void zzk(int i4, int i5) throws IOException {
        this.zza.zzh(i4, i5);
    }

    public final void zzl(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).intValue();
                i6 += 4;
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzi(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzh(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public final void zzm(int i4, long j4) throws IOException {
        this.zza.zzj(i4, j4);
    }

    public final void zzn(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).longValue();
                i6 += 8;
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzk(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzj(i4, ((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    public final void zzo(int i4, float f4) throws IOException {
        this.zza.zzh(i4, Float.floatToRawIntBits(f4));
    }

    public final void zzp(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Float) list.get(i7)).floatValue();
                i6 += 4;
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzh(i4, Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
            i5++;
        }
    }

    public final void zzq(int i4, Object obj, zzaiu zzaiuVar) throws IOException {
        zzagl zzaglVar = this.zza;
        zzaglVar.zzq(i4, 3);
        zzaiuVar.zzm((zzaii) obj, zzaglVar.zze);
        zzaglVar.zzq(i4, 4);
    }

    public final void zzr(int i4, int i5) throws IOException {
        this.zza.zzl(i4, i5);
    }

    public final void zzs(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzagl.zzx(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzm(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzl(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public final void zzt(int i4, long j4) throws IOException {
        this.zza.zzt(i4, j4);
    }

    public final void zzu(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzagl.zzB(((Long) list.get(i7)).longValue());
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzu(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzt(i4, ((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    public final void zzv(int i4, Object obj, zzaiu zzaiuVar) throws IOException {
        this.zza.zzn(i4, (zzaii) obj, zzaiuVar);
    }

    public final void zzw(int i4, int i5) throws IOException {
        this.zza.zzh(i4, i5);
    }

    public final void zzx(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).intValue();
                i6 += 4;
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzi(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzh(i4, ((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public final void zzy(int i4, long j4) throws IOException {
        this.zza.zzj(i4, j4);
    }

    public final void zzz(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzq(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).longValue();
                i6 += 8;
            }
            this.zza.zzs(i6);
            while (i5 < list.size()) {
                this.zza.zzk(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzj(i4, ((Long) list.get(i5)).longValue());
            i5++;
        }
    }
}
