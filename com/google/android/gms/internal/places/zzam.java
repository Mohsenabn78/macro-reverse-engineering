package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzam implements zzel {
    private final zzaj zzem;

    private zzam(zzaj zzajVar) {
        zzaj zzajVar2 = (zzaj) zzbd.zzb(zzajVar, "output");
        this.zzem = zzajVar2;
        zzajVar2.zzes = this;
    }

    public static zzam zzb(zzaj zzajVar) {
        zzam zzamVar = zzajVar.zzes;
        return zzamVar != null ? zzamVar : new zzam(zzajVar);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzaa(int i4) throws IOException {
        this.zzem.zzc(i4, 3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzab(int i4) throws IOException {
        this.zzem.zzc(i4, 4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final int zzam() {
        return zzbc.zze.zziw;
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i4, boolean z3) throws IOException {
        this.zzem.zzc(i4, z3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzd(int i4, int i5) throws IOException {
        this.zzem.zzd(i4, i5);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zze(int i4, int i5) throws IOException {
        this.zzem.zze(i4, i5);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzf(int i4, int i5) throws IOException {
        this.zzem.zzf(i4, i5);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzg(int i4, int i5) throws IOException {
        this.zzem.zzg(i4, i5);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzh(int i4, List<Double> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzc(list.get(i7).doubleValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzb(list.get(i5).doubleValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzb(i4, list.get(i5).doubleValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzi(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzx(list.get(i7).intValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzn(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzd(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzj(int i4, long j4) throws IOException {
        this.zzem.zzb(i4, j4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzk(int i4, long j4) throws IOException {
        this.zzem.zzd(i4, j4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzl(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzw(list.get(i7).intValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzq(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzg(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzm(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzj(list.get(i7).longValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zze(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzd(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzn(int i4, int i5) throws IOException {
        this.zzem.zzg(i4, i5);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzo(int i4, int i5) throws IOException {
        this.zzem.zzd(i4, i5);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i4, long j4) throws IOException {
        this.zzem.zzc(i4, j4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzd(int i4, long j4) throws IOException {
        this.zzem.zzd(i4, j4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zze(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzg(list.get(i7).longValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzc(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzb(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzf(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzi(list.get(i7).longValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zze(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzd(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzg(int i4, List<Float> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zze(list.get(i7).floatValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzd(list.get(i5).floatValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzb(i4, list.get(i5).floatValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, float f4) throws IOException {
        this.zzem.zzb(i4, f4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i4, Object obj, zzda zzdaVar) throws IOException {
        zzaj zzajVar = this.zzem;
        zzajVar.zzc(i4, 3);
        zzdaVar.zzb((zzck) obj, zzajVar.zzes);
        zzajVar.zzc(i4, 4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzd(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzf(list.get(i7).longValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzc(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzb(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzj(int i4, List<Boolean> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzd(list.get(i7).booleanValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzc(list.get(i5).booleanValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzc(i4, list.get(i5).booleanValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzk(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzt(list.get(i7).intValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzo(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zze(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzn(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzu(list.get(i7).intValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzp(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzf(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzo(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzh(list.get(i7).longValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzd(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzc(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, double d4) throws IOException {
        this.zzem.zzb(i4, d4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, long j4) throws IOException {
        this.zzem.zzb(i4, j4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, String str) throws IOException {
        this.zzem.zzb(i4, str);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, zzw zzwVar) throws IOException {
        this.zzem.zzb(i4, zzwVar);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzv(list.get(i7).intValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzq(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzg(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, Object obj, zzda zzdaVar) throws IOException {
        this.zzem.zzb(i4, (zzck) obj, zzdaVar);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, Object obj) throws IOException {
        if (obj instanceof zzw) {
            this.zzem.zzc(i4, (zzw) obj);
        } else {
            this.zzem.zzb(i4, (zzck) obj);
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.zzem.zzc(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzaj.zzs(list.get(i7).intValue());
            }
            this.zzem.zzo(i6);
            while (i5 < list.size()) {
                this.zzem.zzn(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzd(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i4, List<zzw> list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.zzem.zzb(i4, list.get(i5));
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i4, List<?> list, zzda zzdaVar) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzc(i4, list.get(i5), zzdaVar);
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, List<String> list) throws IOException {
        int i5 = 0;
        if (list instanceof zzbr) {
            zzbr zzbrVar = (zzbr) list;
            while (i5 < list.size()) {
                Object zzae = zzbrVar.zzae(i5);
                if (zzae instanceof String) {
                    this.zzem.zzb(i4, (String) zzae);
                } else {
                    this.zzem.zzb(i4, (zzw) zzae);
                }
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zzem.zzb(i4, list.get(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i4, List<?> list, zzda zzdaVar) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzb(i4, list.get(i5), zzdaVar);
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final <K, V> void zzb(int i4, zzcb<K, V> zzcbVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzem.zzc(i4, 2);
            this.zzem.zzo(zzcc.zzb(zzcbVar, entry.getKey(), entry.getValue()));
            zzcc.zzb(this.zzem, zzcbVar, entry.getKey(), entry.getValue());
        }
    }
}
