package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzdc {
    private static final Class<?> zzlv = zzdc();
    private static final zzds<?, ?> zzlw = zzf(false);
    private static final zzds<?, ?> zzlx = zzf(true);
    private static final zzds<?, ?> zzly = new zzdu();

    public static void zzb(int i4, List<Double> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzh(i4, list, z3);
    }

    public static void zzc(int i4, List<Float> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzg(i4, list, z3);
    }

    public static zzds<?, ?> zzcz() {
        return zzlw;
    }

    public static void zzd(int i4, List<Long> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzd(i4, list, z3);
    }

    public static zzds<?, ?> zzda() {
        return zzlx;
    }

    public static zzds<?, ?> zzdb() {
        return zzly;
    }

    private static Class<?> zzdc() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzdd() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zze(int i4, List<Long> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zze(i4, list, z3);
    }

    public static void zzf(int i4, List<Long> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzo(i4, list, z3);
    }

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzbc.class.isAssignableFrom(cls) && (cls2 = zzlv) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzh(int i4, List<Long> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzm(i4, list, z3);
    }

    public static void zzi(int i4, List<Integer> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzb(i4, list, z3);
    }

    public static void zzj(int i4, List<Integer> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzk(i4, list, z3);
    }

    public static void zzk(int i4, List<Integer> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzn(i4, list, z3);
    }

    public static void zzl(int i4, List<Integer> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzc(i4, list, z3);
    }

    public static void zzm(int i4, List<Integer> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzl(i4, list, z3);
    }

    public static void zzn(int i4, List<Integer> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzi(i4, list, z3);
    }

    public static void zzo(int i4, List<Boolean> list, zzel zzelVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzelVar.zzj(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i4, List<Long> list, boolean z3) {
        if (list.size() == 0) {
            return 0;
        }
        return zze(list) + (list.size() * zzaj.zzr(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i4, List<Long> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzaj.zzr(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(int i4, List<Long> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzaj.zzr(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzaj.zzr(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzaj.zzr(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzaj.zzr(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzaj.zzr(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzk(i4, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzh(i4, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzd(i4, true);
    }

    public static void zzb(int i4, List<String> list, zzel zzelVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzb(i4, list);
    }

    public static void zzc(int i4, List<zzw> list, zzel zzelVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzc(i4, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i4, List<?> list) {
        int zzk;
        int zzk2;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int zzr = zzaj.zzr(i4) * size;
        if (list instanceof zzbr) {
            zzbr zzbrVar = (zzbr) list;
            while (i5 < size) {
                Object zzae = zzbrVar.zzae(i5);
                if (zzae instanceof zzw) {
                    zzk2 = zzaj.zzc((zzw) zzae);
                } else {
                    zzk2 = zzaj.zzk((String) zzae);
                }
                zzr += zzk2;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzw) {
                    zzk = zzaj.zzc((zzw) obj);
                } else {
                    zzk = zzaj.zzk((String) obj);
                }
                zzr += zzk;
                i5++;
            }
        }
        return zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzbyVar = (zzby) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzf(zzbyVar.getLong(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzf(list.get(i5).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzbyVar = (zzby) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzg(zzbyVar.getLong(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzg(list.get(i5).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbeVar = (zzbe) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzx(zzbeVar.getInt(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzx(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbeVar = (zzbe) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzs(zzbeVar.getInt(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzs(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbeVar = (zzbe) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzt(zzbeVar.getInt(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzt(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbeVar = (zzbe) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzu(zzbeVar.getInt(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzu(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(List<?> list) {
        return list.size();
    }

    public static void zzg(int i4, List<Long> list, zzel zzelVar, boolean z3) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzf(i4, list, z3);
    }

    public static void zzb(int i4, List<?> list, zzel zzelVar, zzda zzdaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzb(i4, list, zzdaVar);
    }

    public static void zzc(int i4, List<?> list, zzel zzelVar, zzda zzdaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzc(i4, list, zzdaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzbyVar = (zzby) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzh(zzbyVar.getLong(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzaj.zzh(list.get(i5).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zzb(zzcd zzcdVar, T t3, T t4, long j4) {
        zzdy.zzb(t3, j4, zzcdVar.zzc(zzdy.zzp(t3, j4), zzdy.zzp(t4, j4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i4, List<zzw> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = size * zzaj.zzr(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzr += zzaj.zzc(list.get(i5));
        }
        return zzr;
    }

    private static zzds<?, ?> zzf(boolean z3) {
        try {
            Class<?> zzdd = zzdd();
            if (zzdd == null) {
                return null;
            }
            return (zzds) zzdd.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z3));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzax<FT>> void zzb(zzar<FT> zzarVar, T t3, T t4) {
        zzav<FT> zzb = zzarVar.zzb(t4);
        if (zzb.zzfj.isEmpty()) {
            return;
        }
        zzarVar.zzc(t3).zzb(zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i4, List<zzck> list, zzda zzdaVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += zzaj.zzd(i4, list.get(i6), zzdaVar);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zzb(zzds<UT, UB> zzdsVar, T t3, T t4) {
        zzdsVar.zzf(t3, zzdsVar.zzh(zzdsVar.zzr(t3), zzdsVar.zzr(t4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i4, Object obj, zzda zzdaVar) {
        if (obj instanceof zzbp) {
            return zzaj.zzb(i4, (zzbp) obj);
        }
        return zzaj.zzc(i4, (zzck) obj, zzdaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zzb(int i4, List<Integer> list, zzbf zzbfVar, UB ub, zzds<UT, UB> zzdsVar) {
        if (zzbfVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int intValue = list.get(i6).intValue();
                if (zzbfVar.zzad(intValue)) {
                    if (i6 != i5) {
                        list.set(i5, Integer.valueOf(intValue));
                    }
                    i5++;
                } else {
                    ub = (UB) zzb(i4, intValue, ub, zzdsVar);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzbfVar.zzad(intValue2)) {
                    ub = (UB) zzb(i4, intValue2, ub, zzdsVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i4, List<?> list, zzda zzdaVar) {
        int zzb;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = zzaj.zzr(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof zzbp) {
                zzb = zzaj.zzb((zzbp) obj);
            } else {
                zzb = zzaj.zzb((zzck) obj, zzdaVar);
            }
            zzr += zzb;
        }
        return zzr;
    }

    private static <UT, UB> UB zzb(int i4, int i5, UB ub, zzds<UT, UB> zzdsVar) {
        if (ub == null) {
            ub = zzdsVar.zzdk();
        }
        zzdsVar.zzb((zzds<UT, UB>) ub, i4, i5);
        return ub;
    }
}
