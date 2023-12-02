package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzin {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzjf zzc;
    private static final zzjf zzd;
    private static final zzjf zze;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        zzc = zzZ(false);
        zzd = zzZ(true);
        zze = new zzjh();
    }

    public static zzjf zzA() {
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzB(Object obj, int i4, List list, zzgs zzgsVar, Object obj2, zzjf zzjfVar) {
        if (zzgsVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                if (zzgsVar.zza()) {
                    if (i6 != i5) {
                        list.set(i5, Integer.valueOf(intValue));
                    }
                    i5++;
                } else {
                    obj2 = zzC(obj, i4, intValue, obj2, zzjfVar);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzgsVar.zza()) {
                    obj2 = zzC(obj, i4, intValue2, obj2, zzjfVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzC(Object obj, int i4, int i5, Object obj2, zzjf zzjfVar) {
        if (obj2 == null) {
            obj2 = zzjfVar.zzc(obj);
        }
        zzjfVar.zzl(obj2, i4, i5);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzD(zzga zzgaVar, Object obj, Object obj2) {
        zzge zzb2 = zzgaVar.zzb(obj2);
        if (!zzb2.zza.isEmpty()) {
            zzgaVar.zzc(obj).zzh(zzb2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzE(zzjf zzjfVar, Object obj, Object obj2) {
        zzjfVar.zzo(obj, zzjfVar.zze(zzjfVar.zzd(obj), zzjfVar.zzd(obj2)));
    }

    public static void zzF(Class cls) {
        Class cls2;
        if (!zzgo.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzG(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzc(i4, list, z3);
        }
    }

    public static void zzH(int i4, List list, zzjx zzjxVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zze(i4, list);
        }
    }

    public static void zzI(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzg(i4, list, z3);
        }
    }

    public static void zzJ(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzj(i4, list, z3);
        }
    }

    public static void zzK(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzl(i4, list, z3);
        }
    }

    public static void zzL(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzn(i4, list, z3);
        }
    }

    public static void zzM(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzp(i4, list, z3);
        }
    }

    public static void zzN(int i4, List list, zzjx zzjxVar, zzil zzilVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((zzfl) zzjxVar).zzq(i4, list.get(i5), zzilVar);
            }
        }
    }

    public static void zzO(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzs(i4, list, z3);
        }
    }

    public static void zzP(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzu(i4, list, z3);
        }
    }

    public static void zzQ(int i4, List list, zzjx zzjxVar, zzil zzilVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((zzfl) zzjxVar).zzv(i4, list.get(i5), zzilVar);
            }
        }
    }

    public static void zzR(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzy(i4, list, z3);
        }
    }

    public static void zzS(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzA(i4, list, z3);
        }
    }

    public static void zzT(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzC(i4, list, z3);
        }
    }

    public static void zzU(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzE(i4, list, z3);
        }
    }

    public static void zzV(int i4, List list, zzjx zzjxVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzH(i4, list);
        }
    }

    public static void zzW(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzJ(i4, list, z3);
        }
    }

    public static void zzX(int i4, List list, zzjx zzjxVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjxVar.zzL(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzY(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    private static zzjf zzZ(boolean z3) {
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
            return (zzjf) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z3));
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
        return size * (zzfk.zzy(i4 << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzfk.zzy(i4 << 3);
        for (int i5 = 0; i5 < list.size(); i5++) {
            int zzd2 = ((zzez) list.get(i5)).zzd();
            zzy += zzfk.zzy(zzd2) + zzd2;
        }
        return zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzfk.zzy(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgpVar = (zzgp) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzu(zzgpVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzu(((Integer) list.get(i5)).intValue());
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
        return size * (zzfk.zzy(i4 << 3) + 4);
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
        return size * (zzfk.zzy(i4 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, List list, zzil zzilVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += zzfk.zzt(i4, (zzhy) list.get(i6), zzilVar);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzfk.zzy(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgpVar = (zzgp) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzu(zzgpVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzu(((Integer) list.get(i5)).intValue());
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
        return zzm(list) + (list.size() * zzfk.zzy(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhn) {
            zzhn zzhnVar = (zzhn) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzz(zzhnVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzz(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(int i4, Object obj, zzil zzilVar) {
        if (obj instanceof zzhe) {
            int i5 = zzfk.zzb;
            int zza2 = ((zzhe) obj).zza();
            return zzfk.zzy(i4 << 3) + zzfk.zzy(zza2) + zza2;
        }
        return zzfk.zzy(i4 << 3) + zzfk.zzw((zzhy) obj, zzilVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i4, List list, zzil zzilVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzfk.zzy(i4 << 3) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof zzhe) {
                int zza2 = ((zzhe) obj).zza();
                zzy += zzfk.zzy(zza2) + zza2;
            } else {
                zzy += zzfk.zzw((zzhy) obj, zzilVar);
            }
        }
        return zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzfk.zzy(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgpVar = (zzgp) list;
            i4 = 0;
            while (i5 < size) {
                int zze2 = zzgpVar.zze(i5);
                i4 += zzfk.zzy((zze2 >> 31) ^ (zze2 + zze2));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                int intValue = ((Integer) list.get(i5)).intValue();
                i4 += zzfk.zzy((intValue >> 31) ^ (intValue + intValue));
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
        return zzs(list) + (size * zzfk.zzy(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhn) {
            zzhn zzhnVar = (zzhn) list;
            i4 = 0;
            while (i5 < size) {
                long zze2 = zzhnVar.zze(i5);
                i4 += zzfk.zzz((zze2 >> 63) ^ (zze2 + zze2));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                long longValue = ((Long) list.get(i5)).longValue();
                i4 += zzfk.zzz((longValue >> 63) ^ (longValue + longValue));
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
        int i6 = zzfk.zzb;
        boolean z3 = list instanceof zzhg;
        int zzy = zzfk.zzy(i4 << 3) * size;
        if (z3) {
            zzhg zzhgVar = (zzhg) list;
            while (i5 < size) {
                Object zzf = zzhgVar.zzf(i5);
                if (zzf instanceof zzez) {
                    int zzd2 = ((zzez) zzf).zzd();
                    zzy += zzfk.zzy(zzd2) + zzd2;
                } else {
                    zzy += zzfk.zzx((String) zzf);
                }
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzez) {
                    int zzd3 = ((zzez) obj).zzd();
                    zzy += zzfk.zzy(zzd3) + zzd3;
                } else {
                    zzy += zzfk.zzx((String) obj);
                }
                i5++;
            }
        }
        return zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzfk.zzy(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgpVar = (zzgp) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzy(zzgpVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzy(((Integer) list.get(i5)).intValue());
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
        return zzx(list) + (size * zzfk.zzy(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhn) {
            zzhn zzhnVar = (zzhn) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzz(zzhnVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzfk.zzz(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    public static zzjf zzy() {
        return zzc;
    }

    public static zzjf zzz() {
        return zzd;
    }
}
