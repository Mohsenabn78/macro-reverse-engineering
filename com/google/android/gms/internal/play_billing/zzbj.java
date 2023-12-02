package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
final class zzbj implements zzey {
    private final zzbi zza;

    private zzbj(zzbi zzbiVar) {
        byte[] bArr = zzcg.zzd;
        this.zza = zzbiVar;
        zzbiVar.zza = this;
    }

    public static zzbj zza(zzbi zzbiVar) {
        zzbj zzbjVar = zzbiVar.zza;
        if (zzbjVar != null) {
            return zzbjVar;
        }
        return new zzbj(zzbiVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzA(int i4, int i5) throws IOException {
        this.zza.zzp(i4, (i5 >> 31) ^ (i5 + i5));
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzB(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int intValue = ((Integer) list.get(i7)).intValue();
                i6 += zzbi.zzx((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                zzbi zzbiVar = this.zza;
                int intValue2 = ((Integer) list.get(i5)).intValue();
                zzbiVar.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            zzbi zzbiVar2 = this.zza;
            int intValue3 = ((Integer) list.get(i5)).intValue();
            zzbiVar2.zzp(i4, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzC(int i4, long j4) throws IOException {
        this.zza.zzr(i4, (j4 >> 63) ^ (j4 + j4));
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzD(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long longValue = ((Long) list.get(i7)).longValue();
                i6 += zzbi.zzy((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i6);
            while (i5 < list.size()) {
                zzbi zzbiVar = this.zza;
                long longValue2 = ((Long) list.get(i5)).longValue();
                zzbiVar.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            zzbi zzbiVar2 = this.zza;
            long longValue3 = ((Long) list.get(i5)).longValue();
            zzbiVar2.zzr(i4, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    @Deprecated
    public final void zzE(int i4) throws IOException {
        this.zza.zzo(i4, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzF(int i4, String str) throws IOException {
        this.zza.zzm(i4, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzG(int i4, List list) throws IOException {
        int i5 = 0;
        if (list instanceof zzcn) {
            zzcn zzcnVar = (zzcn) list;
            while (i5 < list.size()) {
                Object zzf = zzcnVar.zzf(i5);
                if (zzf instanceof String) {
                    this.zza.zzm(i4, (String) zzf);
                } else {
                    this.zza.zze(i4, (zzba) zzf);
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzH(int i4, int i5) throws IOException {
        this.zza.zzp(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzI(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbi.zzx(((Integer) list.get(i7)).intValue());
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzJ(int i4, long j4) throws IOException {
        this.zza.zzr(i4, j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzK(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbi.zzy(((Long) list.get(i7)).longValue());
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzb(int i4, boolean z3) throws IOException {
        this.zza.zzd(i4, z3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzd(int i4, zzba zzbaVar) throws IOException {
        this.zza.zze(i4, zzbaVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zze(int i4, List list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.zza.zze(i4, (zzba) list.get(i5));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzf(int i4, double d4) throws IOException {
        this.zza.zzh(i4, Double.doubleToRawLongBits(d4));
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    @Deprecated
    public final void zzh(int i4) throws IOException {
        this.zza.zzo(i4, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzi(int i4, int i5) throws IOException {
        this.zza.zzj(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzj(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbi.zzu(((Integer) list.get(i7)).intValue());
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzk(int i4, int i5) throws IOException {
        this.zza.zzf(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzm(int i4, long j4) throws IOException {
        this.zza.zzh(i4, j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzo(int i4, float f4) throws IOException {
        this.zza.zzf(i4, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzq(int i4, Object obj, zzdp zzdpVar) throws IOException {
        zzbi zzbiVar = this.zza;
        zzbiVar.zzo(i4, 3);
        zzdpVar.zzi((zzdf) obj, zzbiVar.zza);
        zzbiVar.zzo(i4, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzr(int i4, int i5) throws IOException {
        this.zza.zzj(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzs(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbi.zzu(((Integer) list.get(i7)).intValue());
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzt(int i4, long j4) throws IOException {
        this.zza.zzr(i4, j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzu(int i4, List list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zza.zzo(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzbi.zzy(((Long) list.get(i7)).longValue());
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzv(int i4, Object obj, zzdp zzdpVar) throws IOException {
        zzdf zzdfVar = (zzdf) obj;
        zzbf zzbfVar = (zzbf) this.zza;
        zzbfVar.zzq((i4 << 3) | 2);
        zzbfVar.zzq(((zzak) zzdfVar).zza(zzdpVar));
        zzdpVar.zzi(zzdfVar, zzbfVar.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzw(int i4, int i5) throws IOException {
        this.zza.zzf(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
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

    @Override // com.google.android.gms.internal.play_billing.zzey
    public final void zzy(int i4, long j4) throws IOException {
        this.zza.zzh(i4, j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzey
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
