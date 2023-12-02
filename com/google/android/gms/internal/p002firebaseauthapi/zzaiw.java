package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaiw {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzajo zzc;
    private static final zzajo zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzajo zzajoVar = null;
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
                zzajoVar = (zzajo) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzajoVar;
        zzd = new zzajq();
    }

    public static void zzA(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzu(i4, list, z3);
        }
    }

    public static void zzB(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzx(i4, list, z3);
        }
    }

    public static void zzC(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzz(i4, list, z3);
        }
    }

    public static void zzD(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzB(i4, list, z3);
        }
    }

    public static void zzE(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzD(i4, list, z3);
        }
    }

    public static void zzF(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzI(i4, list, z3);
        }
    }

    public static void zzG(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzK(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzx(zzaheVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzx(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzagl.zzA(i4 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i4, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzagl.zzA(i4 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzx(zzaheVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzx(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahx) {
            zzahx zzahxVar = (zzahx) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzB(zzahxVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzB(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i4, Object obj, zzaiu zzaiuVar) {
        if (obj instanceof zzaho) {
            int i5 = zzagl.zzf;
            int zza2 = ((zzaho) obj).zza();
            return zzagl.zzA(i4 << 3) + zzagl.zzA(zza2) + zza2;
        }
        return zzagl.zzA(i4 << 3) + zzagl.zzy((zzaii) obj, zzaiuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            i4 = 0;
            while (i5 < size) {
                int zze = zzaheVar.zze(i5);
                i4 += zzagl.zzA((zze >> 31) ^ (zze + zze));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                int intValue = ((Integer) list.get(i5)).intValue();
                i4 += zzagl.zzA((intValue >> 31) ^ (intValue + intValue));
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahx) {
            zzahx zzahxVar = (zzahx) list;
            i4 = 0;
            while (i5 < size) {
                long zze = zzahxVar.zze(i5);
                i4 += zzagl.zzB((zze >> 63) ^ (zze + zze));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                long longValue = ((Long) list.get(i5)).longValue();
                i4 += zzagl.zzB((longValue >> 63) ^ (longValue + longValue));
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzA(zzaheVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzA(((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahx) {
            zzahx zzahxVar = (zzahx) list;
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzB(zzahxVar.zze(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += zzagl.zzB(((Long) list.get(i5)).longValue());
                i5++;
            }
        }
        return i4;
    }

    public static zzajo zzm() {
        return zzc;
    }

    public static zzajo zzn() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i4, List list, zzahh zzahhVar, Object obj2, zzajo zzajoVar) {
        if (zzahhVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                if (zzahhVar.zza()) {
                    if (i6 != i5) {
                        list.set(i5, Integer.valueOf(intValue));
                    }
                    i5++;
                } else {
                    obj2 = zzp(obj, i4, intValue, obj2, zzajoVar);
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
                if (!zzahhVar.zza()) {
                    obj2 = zzp(obj, i4, intValue2, obj2, zzajoVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzp(Object obj, int i4, int i5, Object obj2, zzajo zzajoVar) {
        if (obj2 == null) {
            obj2 = zzajoVar.zzc(obj);
        }
        zzajoVar.zzl(obj2, i4, i5);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(zzajo zzajoVar, Object obj, Object obj2) {
        zzajoVar.zzo(obj, zzajoVar.zze(zzajoVar.zzd(obj), zzajoVar.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzahd.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzs(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public static void zzt(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzc(i4, list, z3);
        }
    }

    public static void zzu(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzg(i4, list, z3);
        }
    }

    public static void zzv(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzj(i4, list, z3);
        }
    }

    public static void zzw(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzl(i4, list, z3);
        }
    }

    public static void zzx(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzn(i4, list, z3);
        }
    }

    public static void zzy(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzp(i4, list, z3);
        }
    }

    public static void zzz(int i4, List list, zzagm zzagmVar, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagmVar.zzs(i4, list, z3);
        }
    }
}
