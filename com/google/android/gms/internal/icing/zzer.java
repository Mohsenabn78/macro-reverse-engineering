package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzer {
    private static final Class<?> zza;
    private static final zzfd<?, ?> zzb;
    private static final zzfd<?, ?> zzc;
    private static final zzfd<?, ?> zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzZ(false);
        zzc = zzZ(true);
        zzd = new zzff();
    }

    public static zzfd<?, ?> zzA() {
        return zzb;
    }

    public static zzfd<?, ?> zzB() {
        return zzc;
    }

    public static zzfd<?, ?> zzC() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzD(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzct<FT>> void zzE(zzcq<FT> zzcqVar, T t3, T t4) {
        zzcqVar.zzb(t4);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zzF(zzfd<UT, UB> zzfdVar, T t3, T t4) {
        zzfdVar.zza(t3, zzfdVar.zzd(zzfdVar.zzb(t3), zzfdVar.zzb(t4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zzG(zzdz zzdzVar, T t3, T t4, long j4) {
        zzdy zzdyVar = (zzdy) zzfn.zzn(t3, j4);
        zzdy zzdyVar2 = (zzdy) zzfn.zzn(t4, j4);
        if (!zzdyVar2.isEmpty()) {
            if (!zzdyVar.zzd()) {
                zzdyVar = zzdyVar.zzb();
            }
            zzdyVar.zza(zzdyVar2);
        }
        zzfn.zzo(t3, j4, zzdyVar);
    }

    public static void zzH(int i4, List<Double> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzz(i4, list, z3);
        }
    }

    public static void zzI(int i4, List<Float> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzy(i4, list, z3);
        }
    }

    public static void zzJ(int i4, List<Long> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzv(i4, list, z3);
        }
    }

    public static void zzK(int i4, List<Long> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzw(i4, list, z3);
        }
    }

    public static void zzL(int i4, List<Long> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzI(i4, list, z3);
        }
    }

    public static void zzM(int i4, List<Long> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzx(i4, list, z3);
        }
    }

    public static void zzN(int i4, List<Long> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzG(i4, list, z3);
        }
    }

    public static void zzO(int i4, List<Integer> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzt(i4, list, z3);
        }
    }

    public static void zzP(int i4, List<Integer> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzE(i4, list, z3);
        }
    }

    public static void zzQ(int i4, List<Integer> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzH(i4, list, z3);
        }
    }

    public static void zzR(int i4, List<Integer> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzu(i4, list, z3);
        }
    }

    public static void zzS(int i4, List<Integer> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzF(i4, list, z3);
        }
    }

    public static void zzT(int i4, List<Integer> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzA(i4, list, z3);
        }
    }

    public static void zzU(int i4, List<Boolean> list, zzcn zzcnVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzB(i4, list, z3);
        }
    }

    public static void zzV(int i4, List<String> list, zzcn zzcnVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzC(i4, list);
        }
    }

    public static void zzW(int i4, List<zzcf> list, zzcn zzcnVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcnVar.zzD(i4, list);
        }
    }

    public static void zzX(int i4, List<?> list, zzcn zzcnVar, zzep zzepVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                zzcnVar.zzr(i4, list.get(i5), zzepVar);
            }
        }
    }

    public static void zzY(int i4, List<?> list, zzcn zzcnVar, zzep zzepVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                zzcnVar.zzs(i4, list.get(i5), zzepVar);
            }
        }
    }

    private static zzfd<?, ?> zzZ(boolean z3) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzfd) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z3));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzda.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdtVar = (zzdt) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzx(zzdtVar.zzf(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzx(list.get(i5).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4, List<Long> list, boolean z3) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzcm.zzu(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdtVar = (zzdt) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzx(zzdtVar.zzf(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzx(list.get(i5).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i4, List<Long> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzcm.zzu(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdtVar = (zzdt) list;
            i4 = 0;
            while (i5 < size) {
                long zzf = zzdtVar.zzf(i5);
                i4 += zzcm.zzx((zzf >> 63) ^ (zzf + zzf));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                long longValue = list.get(i5).longValue();
                i4 += zzcm.zzx((longValue >> 63) ^ (longValue + longValue));
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i4, List<Long> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzcm.zzu(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdb) {
            zzdb zzdbVar = (zzdb) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzv(zzdbVar.zzd(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzv(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzcm.zzu(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdb) {
            zzdb zzdbVar = (zzdb) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzv(zzdbVar.zzd(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzv(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzcm.zzu(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdb) {
            zzdb zzdbVar = (zzdb) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzw(zzdbVar.zzd(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzcm.zzw(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzcm.zzu(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdb) {
            zzdb zzdbVar = (zzdb) list;
            i4 = 0;
            while (i5 < size) {
                int zzd2 = zzdbVar.zzd(i5);
                i4 += zzcm.zzw((zzd2 >> 31) ^ (zzd2 + zzd2));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                int intValue = list.get(i5).intValue();
                i4 += zzcm.zzw((intValue >> 31) ^ (intValue + intValue));
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzcm.zzu(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(List<?> list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzcm.zzw(i4 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(List<?> list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzcm.zzw(i4 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzcm.zzw(i4 << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i4, List<?> list) {
        int zzy;
        int zzy2;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int zzu = zzcm.zzu(i4) * size;
        if (list instanceof zzdo) {
            zzdo zzdoVar = (zzdo) list;
            while (i5 < size) {
                Object zzg = zzdoVar.zzg(i5);
                if (zzg instanceof zzcf) {
                    zzy2 = zzcm.zzA((zzcf) zzg);
                } else {
                    zzy2 = zzcm.zzy((String) zzg);
                }
                zzu += zzy2;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzcf) {
                    zzy = zzcm.zzA((zzcf) obj);
                } else {
                    zzy = zzcm.zzy((String) obj);
                }
                zzu += zzy;
                i5++;
            }
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i4, Object obj, zzep zzepVar) {
        if (obj instanceof zzdm) {
            int zzw = zzcm.zzw(i4 << 3);
            int zza2 = ((zzdm) obj).zza();
            return zzw + zzcm.zzw(zza2) + zza2;
        }
        return zzcm.zzw(i4 << 3) + zzcm.zzB((zzee) obj, zzepVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i4, List<?> list, zzep zzepVar) {
        int zzB;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzcm.zzu(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof zzdm) {
                zzB = zzcm.zzz((zzdm) obj);
            } else {
                zzB = zzcm.zzB((zzee) obj, zzepVar);
            }
            zzu += zzB;
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(int i4, List<zzcf> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = size * zzcm.zzu(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzu += zzcm.zzA(list.get(i5));
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(int i4, List<zzee> list, zzep zzepVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += zzcm.zzE(i4, list.get(i6), zzepVar);
        }
        return i5;
    }
}
