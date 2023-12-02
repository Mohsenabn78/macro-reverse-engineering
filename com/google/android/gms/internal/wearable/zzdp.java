package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzdp {
    private static final Class zza;
    private static final zzee zzb;
    private static final zzee zzc;
    private static final zzee zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzeg();
    }

    public static zzee zzA() {
        return zzc;
    }

    public static zzee zzB() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzC(int i4, List list, zzbz zzbzVar, Object obj, zzee zzeeVar) {
        if (zzbzVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                if (zzbzVar.zza(intValue)) {
                    if (i6 != i5) {
                        list.set(i5, Integer.valueOf(intValue));
                    }
                    i5++;
                } else {
                    obj = zzD(i4, intValue, obj, zzeeVar);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzbzVar.zza(intValue2)) {
                    obj = zzD(i4, intValue2, obj, zzeeVar);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static Object zzD(int i4, int i5, Object obj, zzee zzeeVar) {
        if (obj == null) {
            obj = zzeeVar.zze();
        }
        zzeeVar.zzf(obj, i4, i5);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzE(zzbk zzbkVar, Object obj, Object obj2) {
        zzbkVar.zza(obj2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzF(zzee zzeeVar, Object obj, Object obj2) {
        zzeeVar.zzh(obj, zzeeVar.zzd(zzeeVar.zzc(obj), zzeeVar.zzc(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzbv.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzc(i4, list, z3);
        }
    }

    public static void zzI(int i4, List list, zzew zzewVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zze(i4, list);
        }
    }

    public static void zzJ(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzg(i4, list, z3);
        }
    }

    public static void zzK(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzj(i4, list, z3);
        }
    }

    public static void zzL(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzl(i4, list, z3);
        }
    }

    public static void zzM(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzn(i4, list, z3);
        }
    }

    public static void zzN(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzp(i4, list, z3);
        }
    }

    public static void zzO(int i4, List list, zzew zzewVar, zzdn zzdnVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((zzbf) zzewVar).zzq(i4, list.get(i5), zzdnVar);
            }
        }
    }

    public static void zzP(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzs(i4, list, z3);
        }
    }

    public static void zzQ(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzu(i4, list, z3);
        }
    }

    public static void zzR(int i4, List list, zzew zzewVar, zzdn zzdnVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((zzbf) zzewVar).zzv(i4, list.get(i5), zzdnVar);
            }
        }
    }

    public static void zzS(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzx(i4, list, z3);
        }
    }

    public static void zzT(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzz(i4, list, z3);
        }
    }

    public static void zzU(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzB(i4, list, z3);
        }
    }

    public static void zzV(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzD(i4, list, z3);
        }
    }

    public static void zzW(int i4, List list, zzew zzewVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzG(i4, list);
        }
    }

    public static void zzX(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzI(i4, list, z3);
        }
    }

    public static void zzY(int i4, List list, zzew zzewVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzewVar.zzK(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzZ(Object obj, Object obj2) {
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
        return size * (zzbe.zzA(i4 << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzaa(zzcx zzcxVar, Object obj, Object obj2, long j4) {
        zzeo.zzs(obj, j4, zzcx.zzb(zzeo.zzf(obj, j4), zzeo.zzf(obj2, j4)));
    }

    private static zzee zzab(boolean z3) {
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
            return (zzee) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z3));
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzbe.zzz(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzz += zzbe.zzt((zzaw) list.get(i5));
        }
        return zzz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzbe.zzz(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbw) {
            zzbw zzbwVar = (zzbw) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzv(zzbwVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzv(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbe.zzA(i4 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbe.zzA(i4 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i4, List list, zzdn zzdnVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += zzbe.zzu(i4, (zzdc) list.get(i6), zzdnVar);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzbe.zzz(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbw) {
            zzbw zzbwVar = (zzbw) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzv(zzbwVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzv(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(int i4, List list, boolean z3) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzbe.zzz(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcr) {
            zzcr zzcrVar = (zzcr) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzB(zzcrVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzB(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i4, Object obj, zzdn zzdnVar) {
        if (obj instanceof zzci) {
            int zzA = zzbe.zzA(i4 << 3);
            int zza2 = ((zzci) obj).zza();
            return zzA + zzbe.zzA(zza2) + zza2;
        }
        return zzbe.zzA(i4 << 3) + zzbe.zzx((zzdc) obj, zzdnVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i4, List list, zzdn zzdnVar) {
        int zzx;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzbe.zzz(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof zzci) {
                zzx = zzbe.zzw((zzci) obj);
            } else {
                zzx = zzbe.zzx((zzdc) obj, zzdnVar);
            }
            zzz += zzx;
        }
        return zzz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzbe.zzz(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbw) {
            zzbw zzbwVar = (zzbw) list;
            i4 = 0;
            while (i5 < size) {
                int zze = zzbwVar.zze(i5);
                i4 += zzbe.zzA((zze >> 31) ^ (zze + zze));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                int intValue = ((Integer) list.get(i5)).intValue();
                i4 += zzbe.zzA((intValue >> 31) ^ (intValue + intValue));
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzbe.zzz(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcr) {
            zzcr zzcrVar = (zzcr) list;
            i4 = 0;
            while (i5 < size) {
                long zze = zzcrVar.zze(i5);
                i4 += zzbe.zzB((zze >> 63) ^ (zze + zze));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                long longValue = ((Long) list.get(i5)).longValue();
                i4 += zzbe.zzB((longValue >> 63) ^ (longValue + longValue));
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i4, List list) {
        int zzy;
        int zzy2;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzbe.zzz(i4) * size;
        if (list instanceof zzck) {
            zzck zzckVar = (zzck) list;
            while (i5 < size) {
                Object zzf = zzckVar.zzf(i5);
                if (zzf instanceof zzaw) {
                    zzy2 = zzbe.zzt((zzaw) zzf);
                } else {
                    zzy2 = zzbe.zzy((String) zzf);
                }
                zzz += zzy2;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzaw) {
                    zzy = zzbe.zzt((zzaw) obj);
                } else {
                    zzy = zzbe.zzy((String) obj);
                }
                zzz += zzy;
                i5++;
            }
        }
        return zzz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzbe.zzz(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbw) {
            zzbw zzbwVar = (zzbw) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzA(zzbwVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzA(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzbe.zzz(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcr) {
            zzcr zzcrVar = (zzcr) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzB(zzcrVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbe.zzB(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    public static zzee zzz() {
        return zzb;
    }
}
