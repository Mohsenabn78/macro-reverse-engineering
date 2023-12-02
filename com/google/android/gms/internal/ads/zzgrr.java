package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgrr {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzgsg zzc;
    private static final zzgsg zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzgsg zzgsgVar = null;
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
                zzgsgVar = (zzgsg) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzgsgVar;
        zzd = new zzgsi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzA(Object obj, int i4, List list, zzgpq zzgpqVar, Object obj2, zzgsg zzgsgVar) {
        if (zzgpqVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                if (zzgpqVar.zza(intValue)) {
                    if (i6 != i5) {
                        list.set(i5, Integer.valueOf(intValue));
                    }
                    i5++;
                } else {
                    obj2 = zzB(obj, i4, intValue, obj2, zzgsgVar);
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
                if (!zzgpqVar.zza(intValue2)) {
                    obj2 = zzB(obj, i4, intValue2, obj2, zzgsgVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzB(Object obj, int i4, int i5, Object obj2, zzgsg zzgsgVar) {
        if (obj2 == null) {
            obj2 = zzgsgVar.zzc(obj);
        }
        zzgsgVar.zzl(obj2, i4, i5);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzC(zzgsg zzgsgVar, Object obj, Object obj2) {
        zzgsgVar.zzo(obj, zzgsgVar.zze(zzgsgVar.zzd(obj), zzgsgVar.zzd(obj2)));
    }

    public static void zzD(Class cls) {
        Class cls2;
        if (!zzgpm.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzE(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public static void zzF(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzc(i4, list, z3);
        }
    }

    public static void zzG(int i4, List list, zzgou zzgouVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zze(i4, list);
        }
    }

    public static void zzH(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzg(i4, list, z3);
        }
    }

    public static void zzI(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzj(i4, list, z3);
        }
    }

    public static void zzJ(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzl(i4, list, z3);
        }
    }

    public static void zzK(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzn(i4, list, z3);
        }
    }

    public static void zzL(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzp(i4, list, z3);
        }
    }

    public static void zzM(int i4, List list, zzgou zzgouVar, zzgrp zzgrpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                zzgouVar.zzq(i4, list.get(i5), zzgrpVar);
            }
        }
    }

    public static void zzN(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzs(i4, list, z3);
        }
    }

    public static void zzO(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzu(i4, list, z3);
        }
    }

    public static void zzP(int i4, List list, zzgou zzgouVar, zzgrp zzgrpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                zzgouVar.zzv(i4, list.get(i5), zzgrpVar);
            }
        }
    }

    public static void zzQ(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzx(i4, list, z3);
        }
    }

    public static void zzR(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzz(i4, list, z3);
        }
    }

    public static void zzS(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzB(i4, list, z3);
        }
    }

    public static void zzT(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzD(i4, list, z3);
        }
    }

    public static void zzU(int i4, List list, zzgou zzgouVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzG(i4, list);
        }
    }

    public static void zzV(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzI(i4, list, z3);
        }
    }

    public static void zzW(int i4, List list, zzgou zzgouVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgouVar.zzK(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgot.zzA(i4 << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzA = size * zzgot.zzA(i4 << 3);
        for (int i5 = 0; i5 < list.size(); i5++) {
            int zzd2 = ((zzgoe) list.get(i5)).zzd();
            zzA += zzgot.zzA(zzd2) + zzd2;
        }
        return zzA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzgot.zzA(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzx(zzgpnVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzx(((Integer) list.get(i5)).intValue());
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
        return size * (zzgot.zzA(i4 << 3) + 4);
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
        return size * (zzgot.zzA(i4 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, List list, zzgrp zzgrpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += zzgot.zzw(i4, (zzgqw) list.get(i6), zzgrpVar);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzgot.zzA(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzx(zzgpnVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzx(((Integer) list.get(i5)).intValue());
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
        return zzm(list) + (list.size() * zzgot.zzA(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgql) {
            zzgql zzgqlVar = (zzgql) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzB(zzgqlVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzB(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(int i4, Object obj, zzgrp zzgrpVar) {
        if (obj instanceof zzgqc) {
            int i5 = zzgot.zzf;
            int zza2 = ((zzgqc) obj).zza();
            return zzgot.zzA(i4 << 3) + zzgot.zzA(zza2) + zza2;
        }
        return zzgot.zzA(i4 << 3) + zzgot.zzy((zzgqw) obj, zzgrpVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i4, List list, zzgrp zzgrpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzA = zzgot.zzA(i4 << 3) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof zzgqc) {
                int zza2 = ((zzgqc) obj).zza();
                zzA += zzgot.zzA(zza2) + zza2;
            } else {
                zzA += zzgot.zzy((zzgqw) obj, zzgrpVar);
            }
        }
        return zzA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzgot.zzA(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            i4 = 0;
            while (i5 < size) {
                int zze = zzgpnVar.zze(i5);
                i4 += zzgot.zzA((zze >> 31) ^ (zze + zze));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                int intValue = ((Integer) list.get(i5)).intValue();
                i4 += zzgot.zzA((intValue >> 31) ^ (intValue + intValue));
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
        return zzs(list) + (size * zzgot.zzA(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgql) {
            zzgql zzgqlVar = (zzgql) list;
            i4 = 0;
            while (i5 < size) {
                long zze = zzgqlVar.zze(i5);
                i4 += zzgot.zzB((zze >> 63) ^ (zze + zze));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                long longValue = ((Long) list.get(i5)).longValue();
                i4 += zzgot.zzB((longValue >> 63) ^ (longValue + longValue));
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
        boolean z3 = list instanceof zzgqe;
        int zzA = zzgot.zzA(i4 << 3) * size;
        if (z3) {
            zzgqe zzgqeVar = (zzgqe) list;
            while (i5 < size) {
                Object zzf = zzgqeVar.zzf(i5);
                if (zzf instanceof zzgoe) {
                    int zzd2 = ((zzgoe) zzf).zzd();
                    zzA += zzgot.zzA(zzd2) + zzd2;
                } else {
                    zzA += zzgot.zzz((String) zzf);
                }
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzgoe) {
                    int zzd3 = ((zzgoe) obj).zzd();
                    zzA += zzgot.zzA(zzd3) + zzd3;
                } else {
                    zzA += zzgot.zzz((String) obj);
                }
                i5++;
            }
        }
        return zzA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzgot.zzA(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzA(zzgpnVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzA(((Integer) list.get(i5)).intValue());
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
        return zzx(list) + (size * zzgot.zzA(i4 << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgql) {
            zzgql zzgqlVar = (zzgql) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzB(zzgqlVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzgot.zzB(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    public static zzgsg zzy() {
        return zzc;
    }

    public static zzgsg zzz() {
        return zzd;
    }
}
