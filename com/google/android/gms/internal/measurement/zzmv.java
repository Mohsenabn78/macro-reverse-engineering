package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzmv {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zznk zzc;
    private static final zznk zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zznk zznkVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zznkVar = (zznk) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zznkVar;
        zzd = new zznm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzA(Object obj, int i4, int i5, Object obj2, zznk zznkVar) {
        if (obj2 == null) {
            obj2 = zznkVar.zzc(obj);
        }
        zznkVar.zzf(obj2, i4, i5);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzB(zznk zznkVar, Object obj, Object obj2) {
        zznkVar.zzh(obj, zznkVar.zze(zznkVar.zzd(obj), zznkVar.zzd(obj2)));
    }

    public static void zzC(Class cls) {
        Class cls2;
        if (!zzlb.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzD(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzc(i4, list, z3);
        }
    }

    public static void zzE(int i4, List list, zzoc zzocVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zze(i4, list);
        }
    }

    public static void zzF(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzg(i4, list, z3);
        }
    }

    public static void zzG(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzj(i4, list, z3);
        }
    }

    public static void zzH(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzl(i4, list, z3);
        }
    }

    public static void zzI(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzn(i4, list, z3);
        }
    }

    public static void zzJ(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzp(i4, list, z3);
        }
    }

    public static void zzK(int i4, List list, zzoc zzocVar, zzmt zzmtVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((zzkj) zzocVar).zzq(i4, list.get(i5), zzmtVar);
            }
        }
    }

    public static void zzL(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzs(i4, list, z3);
        }
    }

    public static void zzM(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzu(i4, list, z3);
        }
    }

    public static void zzN(int i4, List list, zzoc zzocVar, zzmt zzmtVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((zzkj) zzocVar).zzv(i4, list.get(i5), zzmtVar);
            }
        }
    }

    public static void zzO(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzx(i4, list, z3);
        }
    }

    public static void zzP(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzz(i4, list, z3);
        }
    }

    public static void zzQ(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzB(i4, list, z3);
        }
    }

    public static void zzR(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzD(i4, list, z3);
        }
    }

    public static void zzS(int i4, List list, zzoc zzocVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzG(i4, list);
        }
    }

    public static void zzT(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzI(i4, list, z3);
        }
    }

    public static void zzU(int i4, List list, zzoc zzocVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzocVar.zzK(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzV(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzki.zzx(i4 << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = size * zzki.zzx(i4 << 3);
        for (int i5 = 0; i5 < list.size(); i5++) {
            int zzd2 = ((zzka) list.get(i5)).zzd();
            zzx += zzki.zzx(zzd2) + zzd2;
        }
        return zzx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzki.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlcVar = (zzlc) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzu(zzlcVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzu(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzki.zzx(i4 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzki.zzx(i4 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, List list, zzmt zzmtVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += zzki.zzt(i4, (zzmi) list.get(i6), zzmtVar);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzki.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlcVar = (zzlc) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzu(zzlcVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzu(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i4, List list, boolean z3) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzki.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlxVar = (zzlx) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzy(zzlxVar.zza(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzy(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(int i4, Object obj, zzmt zzmtVar) {
        if (obj instanceof zzlo) {
            int i5 = zzki.zzb;
            int zza2 = ((zzlo) obj).zza();
            return zzki.zzx(i4 << 3) + zzki.zzx(zza2) + zza2;
        }
        return zzki.zzx(i4 << 3) + zzki.zzv((zzmi) obj, zzmtVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i4, List list, zzmt zzmtVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = zzki.zzx(i4 << 3) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof zzlo) {
                int zza2 = ((zzlo) obj).zza();
                zzx += zzki.zzx(zza2) + zza2;
            } else {
                zzx += zzki.zzv((zzmi) obj, zzmtVar);
            }
        }
        return zzx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzki.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlcVar = (zzlc) list;
            i4 = 0;
            while (i5 < size) {
                int zze = zzlcVar.zze(i5);
                i4 += zzki.zzx((zze >> 31) ^ (zze + zze));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                int intValue = ((Integer) list.get(i5)).intValue();
                i4 += zzki.zzx((intValue >> 31) ^ (intValue + intValue));
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzki.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlxVar = (zzlx) list;
            i4 = 0;
            while (i5 < size) {
                long zza2 = zzlxVar.zza(i5);
                i4 += zzki.zzy((zza2 >> 63) ^ (zza2 + zza2));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                long longValue = ((Long) list.get(i5)).longValue();
                i4 += zzki.zzy((longValue >> 63) ^ (longValue + longValue));
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(int i4, List list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z3 = list instanceof zzlq;
        int zzx = zzki.zzx(i4 << 3) * size;
        if (z3) {
            zzlq zzlqVar = (zzlq) list;
            while (i5 < size) {
                Object zzf = zzlqVar.zzf(i5);
                if (zzf instanceof zzka) {
                    int zzd2 = ((zzka) zzf).zzd();
                    zzx += zzki.zzx(zzd2) + zzd2;
                } else {
                    zzx += zzki.zzw((String) zzf);
                }
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzka) {
                    int zzd3 = ((zzka) obj).zzd();
                    zzx += zzki.zzx(zzd3) + zzd3;
                } else {
                    zzx += zzki.zzw((String) obj);
                }
                i5++;
            }
        }
        return zzx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzki.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlcVar = (zzlc) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzx(zzlcVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzx(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzki.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlxVar = (zzlx) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzy(zzlxVar.zza(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzki.zzy(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    public static zznk zzy() {
        return zzc;
    }

    public static zznk zzz() {
        return zzd;
    }
}
