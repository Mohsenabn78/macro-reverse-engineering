package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzdr {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzeg zzc;
    private static final zzeg zzd;
    private static final zzeg zze;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        zzc = zzX(false);
        zzd = zzX(true);
        zze = new zzei();
    }

    public static zzeg zzA() {
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzB(Object obj, int i4, int i5, Object obj2, zzeg zzegVar) {
        if (obj2 == null) {
            obj2 = zzegVar.zzc(obj);
        }
        zzegVar.zzf(obj2, i4, i5);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzC(zzeg zzegVar, Object obj, Object obj2) {
        zzegVar.zzh(obj, zzegVar.zze(zzegVar.zzd(obj), zzegVar.zzd(obj2)));
    }

    public static void zzD(Class cls) {
        Class cls2;
        if (!zzcb.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzE(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzc(i4, list, z3);
        }
    }

    public static void zzF(int i4, List list, zzey zzeyVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zze(i4, list);
        }
    }

    public static void zzG(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzg(i4, list, z3);
        }
    }

    public static void zzH(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzj(i4, list, z3);
        }
    }

    public static void zzI(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzl(i4, list, z3);
        }
    }

    public static void zzJ(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzn(i4, list, z3);
        }
    }

    public static void zzK(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzp(i4, list, z3);
        }
    }

    public static void zzL(int i4, List list, zzey zzeyVar, zzdp zzdpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((zzbj) zzeyVar).zzq(i4, list.get(i5), zzdpVar);
            }
        }
    }

    public static void zzM(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzs(i4, list, z3);
        }
    }

    public static void zzN(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzu(i4, list, z3);
        }
    }

    public static void zzO(int i4, List list, zzey zzeyVar, zzdp zzdpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((zzbj) zzeyVar).zzv(i4, list.get(i5), zzdpVar);
            }
        }
    }

    public static void zzP(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzx(i4, list, z3);
        }
    }

    public static void zzQ(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzz(i4, list, z3);
        }
    }

    public static void zzR(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzB(i4, list, z3);
        }
    }

    public static void zzS(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzD(i4, list, z3);
        }
    }

    public static void zzT(int i4, List list, zzey zzeyVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzG(i4, list);
        }
    }

    public static void zzU(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzI(i4, list, z3);
        }
    }

    public static void zzV(int i4, List list, zzey zzeyVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzeyVar.zzK(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzW(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    private static zzeg zzX(boolean z3) {
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
            return (zzeg) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z3));
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbi.zzx(i4 << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = size * zzbi.zzx(i4 << 3);
        for (int i5 = 0; i5 < list.size(); i5++) {
            int zzd2 = ((zzba) list.get(i5)).zzd();
            zzx += zzbi.zzx(zzd2) + zzd2;
        }
        return zzx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzbi.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcc) {
            zzcc zzccVar = (zzcc) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzu(zzccVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzu(((Integer) list.get(i5)).intValue());
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
        return size * (zzbi.zzx(i4 << 3) + 4);
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
        return size * (zzbi.zzx(i4 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, List list, zzdp zzdpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += zzbi.zzt(i4, (zzdf) list.get(i6), zzdpVar);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzbi.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcc) {
            zzcc zzccVar = (zzcc) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzu(zzccVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzu(((Integer) list.get(i5)).intValue());
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
        return zzm(list) + (list.size() * zzbi.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcu) {
            zzcu zzcuVar = (zzcu) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzy(zzcuVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzy(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(int i4, Object obj, zzdp zzdpVar) {
        if (obj instanceof zzcl) {
            int i5 = zzbi.zzb;
            int zza2 = ((zzcl) obj).zza();
            return zzbi.zzx(i4 << 3) + zzbi.zzx(zza2) + zza2;
        }
        return zzbi.zzx(i4 << 3) + zzbi.zzv((zzdf) obj, zzdpVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i4, List list, zzdp zzdpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = zzbi.zzx(i4 << 3) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof zzcl) {
                int zza2 = ((zzcl) obj).zza();
                zzx += zzbi.zzx(zza2) + zza2;
            } else {
                zzx += zzbi.zzv((zzdf) obj, zzdpVar);
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
        return zzq(list) + (size * zzbi.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcc) {
            zzcc zzccVar = (zzcc) list;
            i4 = 0;
            while (i5 < size) {
                int zze2 = zzccVar.zze(i5);
                i4 += zzbi.zzx((zze2 >> 31) ^ (zze2 + zze2));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                int intValue = ((Integer) list.get(i5)).intValue();
                i4 += zzbi.zzx((intValue >> 31) ^ (intValue + intValue));
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
        return zzs(list) + (size * zzbi.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcu) {
            zzcu zzcuVar = (zzcu) list;
            i4 = 0;
            while (i5 < size) {
                long zze2 = zzcuVar.zze(i5);
                i4 += zzbi.zzy((zze2 >> 63) ^ (zze2 + zze2));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                long longValue = ((Long) list.get(i5)).longValue();
                i4 += zzbi.zzy((longValue >> 63) ^ (longValue + longValue));
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
        int i6 = zzbi.zzb;
        boolean z3 = list instanceof zzcn;
        int zzx = zzbi.zzx(i4 << 3) * size;
        if (z3) {
            zzcn zzcnVar = (zzcn) list;
            while (i5 < size) {
                Object zzf = zzcnVar.zzf(i5);
                if (zzf instanceof zzba) {
                    int zzd2 = ((zzba) zzf).zzd();
                    zzx += zzbi.zzx(zzd2) + zzd2;
                } else {
                    zzx += zzbi.zzw((String) zzf);
                }
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzba) {
                    int zzd3 = ((zzba) obj).zzd();
                    zzx += zzbi.zzx(zzd3) + zzd3;
                } else {
                    zzx += zzbi.zzw((String) obj);
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
        return zzv(list) + (size * zzbi.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcc) {
            zzcc zzccVar = (zzcc) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzx(zzccVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzx(((Integer) list.get(i5)).intValue());
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
        return zzx(list) + (size * zzbi.zzx(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcu) {
            zzcu zzcuVar = (zzcu) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzy(zzcuVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzbi.zzy(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    public static zzeg zzy() {
        return zzc;
    }

    public static zzeg zzz() {
        return zzd;
    }
}
