package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzail  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzail<T> implements zzaiu<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzajy.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzaii zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzahw zzm;
    private final zzajo zzn;
    private final zzagr zzo;
    private final zzain zzp;
    private final zzaid zzq;

    private zzail(int[] iArr, Object[] objArr, int i4, int i5, zzaii zzaiiVar, int i6, boolean z3, int[] iArr2, int i7, int i8, zzain zzainVar, zzahw zzahwVar, zzajo zzajoVar, zzagr zzagrVar, zzaid zzaidVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i4;
        this.zzf = i5;
        this.zzi = zzaiiVar instanceof zzahd;
        boolean z4 = false;
        if (zzagrVar != null && zzagrVar.zzh(zzaiiVar)) {
            z4 = true;
        }
        this.zzh = z4;
        this.zzj = iArr2;
        this.zzk = i7;
        this.zzl = i8;
        this.zzp = zzainVar;
        this.zzm = zzahwVar;
        this.zzn = zzajoVar;
        this.zzo = zzagrVar;
        this.zzg = zzaiiVar;
        this.zzq = zzaidVar;
    }

    private final Object zzA(Object obj, int i4) {
        zzaiu zzx = zzx(i4);
        int zzu = zzu(i4) & 1048575;
        if (!zzN(obj, i4)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzB(Object obj, int i4, int i5) {
        zzaiu zzx = zzx(i5);
        if (!zzR(obj, i4, i5)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i5) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzD(Object obj) {
        if (zzQ(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
    }

    private final void zzE(Object obj, Object obj2, int i4) {
        if (!zzN(obj2, i4)) {
            return;
        }
        Unsafe unsafe = zzb;
        long zzu = zzu(i4) & 1048575;
        Object object = unsafe.getObject(obj2, zzu);
        if (object != null) {
            zzaiu zzx = zzx(i4);
            if (!zzN(obj, i4)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, zzu, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, zzu, zze);
                }
                zzH(obj, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzu);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, zzu, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i4] + " is present but null: " + obj2.toString());
    }

    private final void zzF(Object obj, Object obj2, int i4) {
        int i5 = this.zzc[i4];
        if (!zzR(obj2, i5, i4)) {
            return;
        }
        Unsafe unsafe = zzb;
        long zzu = zzu(i4) & 1048575;
        Object object = unsafe.getObject(obj2, zzu);
        if (object != null) {
            zzaiu zzx = zzx(i4);
            if (!zzR(obj, i5, i4)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, zzu, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, zzu, zze);
                }
                zzI(obj, i5, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzu);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, zzu, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i4] + " is present but null: " + obj2.toString());
    }

    private final void zzG(Object obj, int i4, zzait zzaitVar) throws IOException {
        if (zzM(i4)) {
            zzajy.zzs(obj, i4 & 1048575, zzaitVar.zzs());
        } else if (this.zzi) {
            zzajy.zzs(obj, i4 & 1048575, zzaitVar.zzr());
        } else {
            zzajy.zzs(obj, i4 & 1048575, zzaitVar.zzp());
        }
    }

    private final void zzH(Object obj, int i4) {
        int zzr = zzr(i4);
        long j4 = 1048575 & zzr;
        if (j4 == 1048575) {
            return;
        }
        zzajy.zzq(obj, j4, (1 << (zzr >>> 20)) | zzajy.zzc(obj, j4));
    }

    private final void zzI(Object obj, int i4, int i5) {
        zzajy.zzq(obj, zzr(i5) & 1048575, i4);
    }

    private final void zzJ(Object obj, int i4, Object obj2) {
        zzb.putObject(obj, zzu(i4) & 1048575, obj2);
        zzH(obj, i4);
    }

    private final void zzK(Object obj, int i4, int i5, Object obj2) {
        zzb.putObject(obj, zzu(i5) & 1048575, obj2);
        zzI(obj, i4, i5);
    }

    private final boolean zzL(Object obj, Object obj2, int i4) {
        if (zzN(obj, i4) == zzN(obj2, i4)) {
            return true;
        }
        return false;
    }

    private static boolean zzM(int i4) {
        if ((i4 & 536870912) != 0) {
            return true;
        }
        return false;
    }

    private final boolean zzN(Object obj, int i4) {
        int zzr = zzr(i4);
        long j4 = zzr & 1048575;
        if (j4 == 1048575) {
            int zzu = zzu(i4);
            long j5 = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzajy.zza(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzajy.zzb(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzajy.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzajy.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzajy.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzajy.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzajy.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzajy.zzw(obj, j5);
                case 8:
                    Object zzf = zzajy.zzf(obj, j5);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    } else if (zzf instanceof zzafy) {
                        if (zzafy.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (zzajy.zzf(obj, j5) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzafy.zzb.equals(zzajy.zzf(obj, j5))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzajy.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzajy.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzajy.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzajy.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzajy.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzajy.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzajy.zzf(obj, j5) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzajy.zzc(obj, j4) & (1 << (zzr >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzO(Object obj, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return zzN(obj, i4);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzP(Object obj, int i4, zzaiu zzaiuVar) {
        return zzaiuVar.zzk(zzajy.zzf(obj, i4 & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzahd) {
            return ((zzahd) obj).zzL();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i4, int i5) {
        if (zzajy.zzc(obj, zzr(i5) & 1048575) == i4) {
            return true;
        }
        return false;
    }

    private static boolean zzS(Object obj, long j4) {
        return ((Boolean) zzajy.zzf(obj, j4)).booleanValue();
    }

    private static final void zzT(int i4, Object obj, zzagm zzagmVar) throws IOException {
        if (obj instanceof String) {
            zzagmVar.zzF(i4, (String) obj);
        } else {
            zzagmVar.zzd(i4, (zzafy) obj);
        }
    }

    static zzajp zzd(Object obj) {
        zzahd zzahdVar = (zzahd) obj;
        zzajp zzajpVar = zzahdVar.zzc;
        if (zzajpVar == zzajp.zzc()) {
            zzajp zzf = zzajp.zzf();
            zzahdVar.zzc = zzf;
            return zzf;
        }
        return zzajpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:123:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x026c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.p002firebaseauthapi.zzail zzl(java.lang.Class r30, com.google.android.gms.internal.p002firebaseauthapi.zzaif r31, com.google.android.gms.internal.p002firebaseauthapi.zzain r32, com.google.android.gms.internal.p002firebaseauthapi.zzahw r33, com.google.android.gms.internal.p002firebaseauthapi.zzajo r34, com.google.android.gms.internal.p002firebaseauthapi.zzagr r35, com.google.android.gms.internal.p002firebaseauthapi.zzaid r36) {
        /*
            Method dump skipped, instructions count: 1004
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzail.zzl(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzaif, com.google.android.gms.internal.firebase-auth-api.zzain, com.google.android.gms.internal.firebase-auth-api.zzahw, com.google.android.gms.internal.firebase-auth-api.zzajo, com.google.android.gms.internal.firebase-auth-api.zzagr, com.google.android.gms.internal.firebase-auth-api.zzaid):com.google.android.gms.internal.firebase-auth-api.zzail");
    }

    private static double zzn(Object obj, long j4) {
        return ((Double) zzajy.zzf(obj, j4)).doubleValue();
    }

    private static float zzo(Object obj, long j4) {
        return ((Float) zzajy.zzf(obj, j4)).floatValue();
    }

    private static int zzp(Object obj, long j4) {
        return ((Integer) zzajy.zzf(obj, j4)).intValue();
    }

    private final int zzq(int i4) {
        if (i4 >= this.zze && i4 <= this.zzf) {
            return zzs(i4, 0);
        }
        return -1;
    }

    private final int zzr(int i4) {
        return this.zzc[i4 + 2];
    }

    private final int zzs(int i4, int i5) {
        int length = (this.zzc.length / 3) - 1;
        while (i5 <= length) {
            int i6 = (length + i5) >>> 1;
            int i7 = i6 * 3;
            int i8 = this.zzc[i7];
            if (i4 == i8) {
                return i7;
            }
            if (i4 < i8) {
                length = i6 - 1;
            } else {
                i5 = i6 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i4) {
        return (i4 >>> 20) & 255;
    }

    private final int zzu(int i4) {
        return this.zzc[i4 + 1];
    }

    private static long zzv(Object obj, long j4) {
        return ((Long) zzajy.zzf(obj, j4)).longValue();
    }

    private final zzahh zzw(int i4) {
        int i5 = i4 / 3;
        return (zzahh) this.zzd[i5 + i5 + 1];
    }

    private final zzaiu zzx(int i4) {
        int i5 = i4 / 3;
        int i6 = i5 + i5;
        zzaiu zzaiuVar = (zzaiu) this.zzd[i6];
        if (zzaiuVar != null) {
            return zzaiuVar;
        }
        zzaiu zzb2 = zzaiq.zza().zzb((Class) this.zzd[i6 + 1]);
        this.zzd[i6] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i4, Object obj2, zzajo zzajoVar, Object obj3) {
        int i5 = this.zzc[i4];
        Object zzf = zzajy.zzf(obj, zzu(i4) & 1048575);
        if (zzf == null) {
            return obj2;
        }
        if (zzw(i4) == null) {
            return obj2;
        }
        zzaic zzaicVar = (zzaic) zzf;
        zzaib zzaibVar = (zzaib) zzz(i4);
        throw null;
    }

    private final Object zzz(int i4) {
        int i5 = i4 / 3;
        return this.zzd[i5 + i5];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final int zza(Object obj) {
        int i4;
        int i5;
        int i6;
        int zzA;
        int zzA2;
        int zzB;
        int zzA3;
        int zzA4;
        int zzA5;
        int zzA6;
        int zzh;
        int zzA7;
        int zzB2;
        int size;
        int zzl;
        int zzA8;
        int zzA9;
        int zzA10;
        int i7;
        int zzA11;
        int zzA12;
        int i8;
        int i9;
        Unsafe unsafe = zzb;
        boolean z3 = false;
        int i10 = 1048575;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < this.zzc.length) {
            int zzu = zzu(i13);
            int zzt = zzt(zzu);
            int[] iArr = this.zzc;
            int i15 = iArr[i13];
            int i16 = iArr[i13 + 2];
            int i17 = i16 & i10;
            if (zzt <= 17) {
                if (i17 != i11) {
                    if (i17 == i10) {
                        i9 = 0;
                    } else {
                        i9 = unsafe.getInt(obj, i17);
                    }
                    i12 = i9;
                    i11 = i17;
                }
                i6 = 1 << (i16 >>> 20);
                i4 = i11;
                i5 = i12;
            } else {
                i4 = i11;
                i5 = i12;
                i6 = 0;
            }
            int i18 = zzu & i10;
            if (zzt >= zzagw.zzJ.zza()) {
                zzagw.zzW.zza();
            }
            long j4 = i18;
            switch (zzt) {
                case 0:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzA = zzagl.zzA(i15 << 3);
                        zzh = zzA + 8;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzA2 = zzagl.zzA(i15 << 3);
                        zzh = zzA2 + 4;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzB = zzagl.zzB(unsafe.getLong(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzB = zzagl.zzB(unsafe.getLong(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzB = zzagl.zzx(unsafe.getInt(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzA = zzagl.zzA(i15 << 3);
                        zzh = zzA + 8;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzA2 = zzagl.zzA(i15 << 3);
                        zzh = zzA2 + 4;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzA4 = zzagl.zzA(i15 << 3);
                        zzh = zzA4 + 1;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        Object object = unsafe.getObject(obj, j4);
                        if (object instanceof zzafy) {
                            int i19 = zzagl.zzf;
                            int zzd = ((zzafy) object).zzd();
                            zzA5 = zzagl.zzA(zzd) + zzd;
                            zzA6 = zzagl.zzA(i15 << 3);
                            zzh = zzA6 + zzA5;
                            i14 += zzh;
                            break;
                        } else {
                            zzB = zzagl.zzz((String) object);
                            zzA3 = zzagl.zzA(i15 << 3);
                            i7 = zzA3 + zzB;
                            i14 += i7;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzh = zzaiw.zzh(i15, unsafe.getObject(obj, j4), zzx(i13));
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        int i20 = zzagl.zzf;
                        int zzd2 = ((zzafy) unsafe.getObject(obj, j4)).zzd();
                        zzA5 = zzagl.zzA(zzd2) + zzd2;
                        zzA6 = zzagl.zzA(i15 << 3);
                        zzh = zzA6 + zzA5;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzB = zzagl.zzA(unsafe.getInt(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzB = zzagl.zzx(unsafe.getInt(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzA2 = zzagl.zzA(i15 << 3);
                        zzh = zzA2 + 4;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzA = zzagl.zzA(i15 << 3);
                        zzh = zzA + 8;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        int i21 = unsafe.getInt(obj, j4);
                        zzA3 = zzagl.zzA(i15 << 3);
                        zzB = zzagl.zzA((i21 >> 31) ^ (i21 + i21));
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        long j5 = unsafe.getLong(obj, j4);
                        zzA7 = zzagl.zzA(i15 << 3);
                        zzB2 = zzagl.zzB((j5 >> 63) ^ (j5 + j5));
                        zzA9 = zzA7 + zzB2;
                        i14 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzO(obj, i13, i4, i5, i6)) {
                        zzh = zzagl.zzw(i15, (zzaii) unsafe.getObject(obj, j4), zzx(i13));
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzh = zzaiw.zzd(i15, (List) unsafe.getObject(obj, j4), z3);
                    i14 += zzh;
                    break;
                case 19:
                    zzh = zzaiw.zzb(i15, (List) unsafe.getObject(obj, j4), z3);
                    i14 += zzh;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j4);
                    int i22 = zzaiw.zza;
                    if (list.size() != 0) {
                        zzA3 = zzaiw.zzg(list);
                        zzB = list.size() * zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    }
                    i7 = 0;
                    i14 += i7;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j4);
                    int i23 = zzaiw.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzl = zzaiw.zzl(list2);
                        zzA8 = zzagl.zzA(i15 << 3);
                        zzh = zzl + (size * zzA8);
                        i14 += zzh;
                        break;
                    }
                    zzh = 0;
                    i14 += zzh;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j4);
                    int i24 = zzaiw.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzl = zzaiw.zzf(list3);
                        zzA8 = zzagl.zzA(i15 << 3);
                        zzh = zzl + (size * zzA8);
                        i14 += zzh;
                        break;
                    }
                    zzh = 0;
                    i14 += zzh;
                case 23:
                    zzh = zzaiw.zzd(i15, (List) unsafe.getObject(obj, j4), z3);
                    i14 += zzh;
                    break;
                case 24:
                    zzh = zzaiw.zzb(i15, (List) unsafe.getObject(obj, j4), z3);
                    i14 += zzh;
                    break;
                case 25:
                    int i25 = zzaiw.zza;
                    int size2 = ((List) unsafe.getObject(obj, j4)).size();
                    if (size2 != 0) {
                        zzh = size2 * (zzagl.zzA(i15 << 3) + 1);
                        i14 += zzh;
                        break;
                    }
                    zzh = 0;
                    i14 += zzh;
                case 26:
                    List list4 = (List) unsafe.getObject(obj, j4);
                    int i26 = zzaiw.zza;
                    int size3 = list4.size();
                    if (size3 == 0) {
                        zzA9 = 0;
                    } else {
                        boolean z4 = list4 instanceof zzahq;
                        zzA9 = zzagl.zzA(i15 << 3) * size3;
                        if (z4) {
                            zzahq zzahqVar = (zzahq) list4;
                            for (int i27 = 0; i27 < size3; i27++) {
                                Object zzf = zzahqVar.zzf(i27);
                                if (zzf instanceof zzafy) {
                                    int zzd3 = ((zzafy) zzf).zzd();
                                    zzA9 += zzagl.zzA(zzd3) + zzd3;
                                } else {
                                    zzA9 += zzagl.zzz((String) zzf);
                                }
                            }
                        } else {
                            for (int i28 = 0; i28 < size3; i28++) {
                                Object obj2 = list4.get(i28);
                                if (obj2 instanceof zzafy) {
                                    int zzd4 = ((zzafy) obj2).zzd();
                                    zzA9 += zzagl.zzA(zzd4) + zzd4;
                                } else {
                                    zzA9 += zzagl.zzz((String) obj2);
                                }
                            }
                        }
                    }
                    i14 += zzA9;
                    break;
                case 27:
                    List list5 = (List) unsafe.getObject(obj, j4);
                    zzaiu zzx = zzx(i13);
                    int i29 = zzaiw.zza;
                    int size4 = list5.size();
                    if (size4 == 0) {
                        zzA10 = 0;
                    } else {
                        zzA10 = zzagl.zzA(i15 << 3) * size4;
                        for (int i30 = 0; i30 < size4; i30++) {
                            Object obj3 = list5.get(i30);
                            if (obj3 instanceof zzaho) {
                                int zza2 = ((zzaho) obj3).zza();
                                zzA10 += zzagl.zzA(zza2) + zza2;
                            } else {
                                zzA10 += zzagl.zzy((zzaii) obj3, zzx);
                            }
                        }
                    }
                    i14 += zzA10;
                    break;
                case 28:
                    List list6 = (List) unsafe.getObject(obj, j4);
                    int i31 = zzaiw.zza;
                    int size5 = list6.size();
                    if (size5 != 0) {
                        i7 = size5 * zzagl.zzA(i15 << 3);
                        for (int i32 = 0; i32 < list6.size(); i32++) {
                            int zzd5 = ((zzafy) list6.get(i32)).zzd();
                            i7 += zzagl.zzA(zzd5) + zzd5;
                        }
                        i14 += i7;
                        break;
                    }
                    i7 = 0;
                    i14 += i7;
                case 29:
                    List list7 = (List) unsafe.getObject(obj, j4);
                    int i33 = zzaiw.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzl = zzaiw.zzk(list7);
                        zzA8 = zzagl.zzA(i15 << 3);
                        zzh = zzl + (size * zzA8);
                        i14 += zzh;
                        break;
                    }
                    zzh = 0;
                    i14 += zzh;
                case 30:
                    List list8 = (List) unsafe.getObject(obj, j4);
                    int i34 = zzaiw.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzl = zzaiw.zza(list8);
                        zzA8 = zzagl.zzA(i15 << 3);
                        zzh = zzl + (size * zzA8);
                        i14 += zzh;
                        break;
                    }
                    zzh = 0;
                    i14 += zzh;
                case 31:
                    zzh = zzaiw.zzb(i15, (List) unsafe.getObject(obj, j4), z3);
                    i14 += zzh;
                    break;
                case 32:
                    zzh = zzaiw.zzd(i15, (List) unsafe.getObject(obj, j4), z3);
                    i14 += zzh;
                    break;
                case 33:
                    List list9 = (List) unsafe.getObject(obj, j4);
                    int i35 = zzaiw.zza;
                    size = list9.size();
                    if (size != 0) {
                        zzl = zzaiw.zzi(list9);
                        zzA8 = zzagl.zzA(i15 << 3);
                        zzh = zzl + (size * zzA8);
                        i14 += zzh;
                        break;
                    }
                    zzh = 0;
                    i14 += zzh;
                case 34:
                    List list10 = (List) unsafe.getObject(obj, j4);
                    int i36 = zzaiw.zza;
                    size = list10.size();
                    if (size != 0) {
                        zzl = zzaiw.zzj(list10);
                        zzA8 = zzagl.zzA(i15 << 3);
                        zzh = zzl + (size * zzA8);
                        i14 += zzh;
                        break;
                    }
                    zzh = 0;
                    i14 += zzh;
                case 35:
                    zzB = zzaiw.zze((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzB = zzaiw.zzc((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzB = zzaiw.zzg((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzB = zzaiw.zzl((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzB = zzaiw.zzf((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzB = zzaiw.zze((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzB = zzaiw.zzc((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    int i37 = zzaiw.zza;
                    zzB = ((List) unsafe.getObject(obj, j4)).size();
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzB = zzaiw.zzk((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzB = zzaiw.zza((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzB = zzaiw.zzc((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzB = zzaiw.zze((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzB = zzaiw.zzi((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzB = zzaiw.zzj((List) unsafe.getObject(obj, j4));
                    if (zzB > 0) {
                        zzA11 = zzagl.zzA(zzB);
                        zzA12 = zzagl.zzA(i15 << 3);
                        zzA3 = zzA12 + zzA11;
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list11 = (List) unsafe.getObject(obj, j4);
                    zzaiu zzx2 = zzx(i13);
                    int i38 = zzaiw.zza;
                    int size6 = list11.size();
                    if (size6 == 0) {
                        i8 = 0;
                    } else {
                        i8 = 0;
                        for (int i39 = 0; i39 < size6; i39++) {
                            i8 += zzagl.zzw(i15, (zzaii) list11.get(i39), zzx2);
                        }
                    }
                    i14 += i8;
                    break;
                case 50:
                    zzaic zzaicVar = (zzaic) unsafe.getObject(obj, j4);
                    zzaib zzaibVar = (zzaib) zzz(i13);
                    if (zzaicVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzaicVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                        break;
                    }
                case 51:
                    if (zzR(obj, i15, i13)) {
                        zzA = zzagl.zzA(i15 << 3);
                        zzh = zzA + 8;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i15, i13)) {
                        zzA2 = zzagl.zzA(i15 << 3);
                        zzh = zzA2 + 4;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i15, i13)) {
                        zzB = zzagl.zzB(zzv(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i15, i13)) {
                        zzB = zzagl.zzB(zzv(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i15, i13)) {
                        zzB = zzagl.zzx(zzp(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i15, i13)) {
                        zzA = zzagl.zzA(i15 << 3);
                        zzh = zzA + 8;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i15, i13)) {
                        zzA2 = zzagl.zzA(i15 << 3);
                        zzh = zzA2 + 4;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i15, i13)) {
                        zzA4 = zzagl.zzA(i15 << 3);
                        zzh = zzA4 + 1;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i15, i13)) {
                        Object object2 = unsafe.getObject(obj, j4);
                        if (object2 instanceof zzafy) {
                            int i40 = zzagl.zzf;
                            int zzd6 = ((zzafy) object2).zzd();
                            zzA5 = zzagl.zzA(zzd6) + zzd6;
                            zzA6 = zzagl.zzA(i15 << 3);
                            zzh = zzA6 + zzA5;
                            i14 += zzh;
                            break;
                        } else {
                            zzB = zzagl.zzz((String) object2);
                            zzA3 = zzagl.zzA(i15 << 3);
                            i7 = zzA3 + zzB;
                            i14 += i7;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i15, i13)) {
                        zzh = zzaiw.zzh(i15, unsafe.getObject(obj, j4), zzx(i13));
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i15, i13)) {
                        int i41 = zzagl.zzf;
                        int zzd7 = ((zzafy) unsafe.getObject(obj, j4)).zzd();
                        zzA5 = zzagl.zzA(zzd7) + zzd7;
                        zzA6 = zzagl.zzA(i15 << 3);
                        zzh = zzA6 + zzA5;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i15, i13)) {
                        zzB = zzagl.zzA(zzp(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i15, i13)) {
                        zzB = zzagl.zzx(zzp(obj, j4));
                        zzA3 = zzagl.zzA(i15 << 3);
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i15, i13)) {
                        zzA2 = zzagl.zzA(i15 << 3);
                        zzh = zzA2 + 4;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i15, i13)) {
                        zzA = zzagl.zzA(i15 << 3);
                        zzh = zzA + 8;
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i15, i13)) {
                        int zzp = zzp(obj, j4);
                        zzA3 = zzagl.zzA(i15 << 3);
                        zzB = zzagl.zzA((zzp >> 31) ^ (zzp + zzp));
                        i7 = zzA3 + zzB;
                        i14 += i7;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i15, i13)) {
                        long zzv = zzv(obj, j4);
                        zzA7 = zzagl.zzA(i15 << 3);
                        zzB2 = zzagl.zzB((zzv >> 63) ^ (zzv + zzv));
                        zzA9 = zzA7 + zzB2;
                        i14 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i15, i13)) {
                        zzh = zzagl.zzw(i15, (zzaii) unsafe.getObject(obj, j4), zzx(i13));
                        i14 += zzh;
                        break;
                    } else {
                        break;
                    }
            }
            i13 += 3;
            i11 = i4;
            i12 = i5;
            z3 = false;
            i10 = 1048575;
        }
        zzajo zzajoVar = this.zzn;
        int zza3 = i14 + zzajoVar.zza(zzajoVar.zzd(obj));
        if (!this.zzh) {
            return zza3;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final int zzb(Object obj) {
        int i4;
        long doubleToLongBits;
        int i5;
        int floatToIntBits;
        int length = this.zzc.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 3) {
            int zzu = zzu(i7);
            int i8 = this.zzc[i7];
            long j4 = 1048575 & zzu;
            int i9 = 37;
            switch (zzt(zzu)) {
                case 0:
                    i4 = i6 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzajy.zza(obj, j4));
                    byte[] bArr = zzahj.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 1:
                    i5 = i6 * 53;
                    floatToIntBits = Float.floatToIntBits(zzajy.zzb(obj, j4));
                    i6 = i5 + floatToIntBits;
                    break;
                case 2:
                    i4 = i6 * 53;
                    doubleToLongBits = zzajy.zzd(obj, j4);
                    byte[] bArr2 = zzahj.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 3:
                    i4 = i6 * 53;
                    doubleToLongBits = zzajy.zzd(obj, j4);
                    byte[] bArr3 = zzahj.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 4:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 5:
                    i4 = i6 * 53;
                    doubleToLongBits = zzajy.zzd(obj, j4);
                    byte[] bArr4 = zzahj.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 6:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 7:
                    i5 = i6 * 53;
                    floatToIntBits = zzahj.zza(zzajy.zzw(obj, j4));
                    i6 = i5 + floatToIntBits;
                    break;
                case 8:
                    i5 = i6 * 53;
                    floatToIntBits = ((String) zzajy.zzf(obj, j4)).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 9:
                    Object zzf = zzajy.zzf(obj, j4);
                    if (zzf != null) {
                        i9 = zzf.hashCode();
                    }
                    i6 = (i6 * 53) + i9;
                    break;
                case 10:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 11:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 12:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 13:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 14:
                    i4 = i6 * 53;
                    doubleToLongBits = zzajy.zzd(obj, j4);
                    byte[] bArr5 = zzahj.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 15:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 16:
                    i4 = i6 * 53;
                    doubleToLongBits = zzajy.zzd(obj, j4);
                    byte[] bArr6 = zzahj.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 17:
                    Object zzf2 = zzajy.zzf(obj, j4);
                    if (zzf2 != null) {
                        i9 = zzf2.hashCode();
                    }
                    i6 = (i6 * 53) + i9;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 50:
                    i5 = i6 * 53;
                    floatToIntBits = zzajy.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j4));
                        byte[] bArr7 = zzahj.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = Float.floatToIntBits(zzo(obj, j4));
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzv(obj, j4);
                        byte[] bArr8 = zzahj.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzv(obj, j4);
                        byte[] bArr9 = zzahj.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzv(obj, j4);
                        byte[] bArr10 = zzahj.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzahj.zza(zzS(obj, j4));
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = ((String) zzajy.zzf(obj, j4)).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzajy.zzf(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzajy.zzf(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzv(obj, j4);
                        byte[] bArr11 = zzahj.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzv(obj, j4);
                        byte[] bArr12 = zzahj.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzajy.zzf(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i6 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x0c10, code lost:
        if (r5 == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x0c12, code lost:
        r12.putInt(r7, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x0c16, code lost:
        r11 = r6.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x0c1b, code lost:
        if (r11 >= r6.zzl) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x0c1d, code lost:
        zzy(r34, r6.zzj[r11], null, r6.zzn, r34);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x0c30, code lost:
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x0c34, code lost:
        if (r9 != r37) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x0c3b, code lost:
        throw com.google.android.gms.internal.p002firebaseauthapi.zzahl.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x0c3e, code lost:
        if (r9 > r37) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:0x0c40, code lost:
        if (r10 != r8) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:0x0c42, code lost:
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x0c47, code lost:
        throw com.google.android.gms.internal.p002firebaseauthapi.zzahl.zzg();
     */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x063f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:198:0x0545 -> B:199:0x0546). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:230:0x05ec -> B:231:0x05ed). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:250:0x063c -> B:251:0x063d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.p002firebaseauthapi.zzafl r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzail.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzafl):int");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final Object zze() {
        return ((zzahd) this.zzg).zzw();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzf(Object obj) {
        if (!zzQ(obj)) {
            return;
        }
        if (obj instanceof zzahd) {
            zzahd zzahdVar = (zzahd) obj;
            zzahdVar.zzI(Integer.MAX_VALUE);
            zzahdVar.zza = 0;
            zzahdVar.zzG();
        }
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzu = zzu(i4);
            int i5 = 1048575 & zzu;
            int zzt = zzt(zzu);
            long j4 = i5;
            if (zzt != 9) {
                if (zzt != 60 && zzt != 68) {
                    switch (zzt) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.zzm.zzb(obj, j4);
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j4);
                            if (object != null) {
                                ((zzaic) object).zzc();
                                unsafe.putObject(obj, j4, object);
                                break;
                            } else {
                                break;
                            }
                    }
                } else if (zzR(obj, this.zzc[i4], i4)) {
                    zzx(i4).zzf(zzb.getObject(obj, j4));
                }
            }
            if (zzN(obj, i4)) {
                zzx(i4).zzf(zzb.getObject(obj, j4));
            }
        }
        this.zzn.zzm(obj);
        if (this.zzh) {
            this.zzo.zze(obj);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzu = zzu(i4);
            int i5 = this.zzc[i4];
            long j4 = 1048575 & zzu;
            switch (zzt(zzu)) {
                case 0:
                    if (zzN(obj2, i4)) {
                        zzajy.zzo(obj, j4, zzajy.zza(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzN(obj2, i4)) {
                        zzajy.zzp(obj, j4, zzajy.zzb(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzN(obj2, i4)) {
                        zzajy.zzr(obj, j4, zzajy.zzd(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzN(obj2, i4)) {
                        zzajy.zzr(obj, j4, zzajy.zzd(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzN(obj2, i4)) {
                        zzajy.zzq(obj, j4, zzajy.zzc(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzN(obj2, i4)) {
                        zzajy.zzr(obj, j4, zzajy.zzd(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzN(obj2, i4)) {
                        zzajy.zzq(obj, j4, zzajy.zzc(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzN(obj2, i4)) {
                        zzajy.zzm(obj, j4, zzajy.zzw(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzN(obj2, i4)) {
                        zzajy.zzs(obj, j4, zzajy.zzf(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i4);
                    break;
                case 10:
                    if (zzN(obj2, i4)) {
                        zzajy.zzs(obj, j4, zzajy.zzf(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzN(obj2, i4)) {
                        zzajy.zzq(obj, j4, zzajy.zzc(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzN(obj2, i4)) {
                        zzajy.zzq(obj, j4, zzajy.zzc(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzN(obj2, i4)) {
                        zzajy.zzq(obj, j4, zzajy.zzc(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzN(obj2, i4)) {
                        zzajy.zzr(obj, j4, zzajy.zzd(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzN(obj2, i4)) {
                        zzajy.zzq(obj, j4, zzajy.zzc(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzN(obj2, i4)) {
                        zzajy.zzr(obj, j4, zzajy.zzd(obj2, j4));
                        zzH(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i4);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzc(obj, obj2, j4);
                    break;
                case 50:
                    int i6 = zzaiw.zza;
                    zzajy.zzs(obj, j4, zzaid.zzb(zzajy.zzf(obj, j4), zzajy.zzf(obj2, j4)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzR(obj2, i5, i4)) {
                        zzajy.zzs(obj, j4, zzajy.zzf(obj2, j4));
                        zzI(obj, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzF(obj, obj2, i4);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i5, i4)) {
                        zzajy.zzs(obj, j4, zzajy.zzf(obj2, j4));
                        zzI(obj, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i4);
                    break;
            }
        }
        zzaiw.zzq(this.zzn, obj, obj2);
        if (!this.zzh) {
            return;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x0621 A[Catch: all -> 0x0616, TryCatch #3 {all -> 0x0616, blocks: (B:157:0x05ef, B:171:0x061c, B:173:0x0621, B:174:0x0626), top: B:199:0x05ef }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0659 A[LOOP:3: B:189:0x0655->B:191:0x0659, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x062c A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.p002firebaseauthapi.zzait r19, com.google.android.gms.internal.p002firebaseauthapi.zzagq r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzail.zzh(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzait, com.google.android.gms.internal.firebase-auth-api.zzagq):void");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzi(Object obj, byte[] bArr, int i4, int i5, zzafl zzaflVar) throws IOException {
        zzc(obj, bArr, i4, i5, 0, zzaflVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzs;
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzu = zzu(i4);
            long j4 = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i4) && Double.doubleToLongBits(zzajy.zza(obj, j4)) == Double.doubleToLongBits(zzajy.zza(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzL(obj, obj2, i4) && Float.floatToIntBits(zzajy.zzb(obj, j4)) == Float.floatToIntBits(zzajy.zzb(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzL(obj, obj2, i4) && zzajy.zzd(obj, j4) == zzajy.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzL(obj, obj2, i4) && zzajy.zzd(obj, j4) == zzajy.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzL(obj, obj2, i4) && zzajy.zzc(obj, j4) == zzajy.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzL(obj, obj2, i4) && zzajy.zzd(obj, j4) == zzajy.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzL(obj, obj2, i4) && zzajy.zzc(obj, j4) == zzajy.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzL(obj, obj2, i4) && zzajy.zzw(obj, j4) == zzajy.zzw(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzL(obj, obj2, i4) && zzaiw.zzs(zzajy.zzf(obj, j4), zzajy.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzL(obj, obj2, i4) && zzaiw.zzs(zzajy.zzf(obj, j4), zzajy.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzL(obj, obj2, i4) && zzaiw.zzs(zzajy.zzf(obj, j4), zzajy.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzL(obj, obj2, i4) && zzajy.zzc(obj, j4) == zzajy.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzL(obj, obj2, i4) && zzajy.zzc(obj, j4) == zzajy.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzL(obj, obj2, i4) && zzajy.zzc(obj, j4) == zzajy.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzL(obj, obj2, i4) && zzajy.zzd(obj, j4) == zzajy.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzL(obj, obj2, i4) && zzajy.zzc(obj, j4) == zzajy.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzL(obj, obj2, i4) && zzajy.zzd(obj, j4) == zzajy.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzL(obj, obj2, i4) && zzaiw.zzs(zzajy.zzf(obj, j4), zzajy.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzs = zzaiw.zzs(zzajy.zzf(obj, j4), zzajy.zzf(obj2, j4));
                    break;
                case 50:
                    zzs = zzaiw.zzs(zzajy.zzf(obj, j4), zzajy.zzf(obj2, j4));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzr = zzr(i4) & 1048575;
                    if (zzajy.zzc(obj, zzr) == zzajy.zzc(obj2, zzr) && zzaiw.zzs(zzajy.zzf(obj, j4), zzajy.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzs) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final boolean zzk(Object obj) {
        int i4;
        int i5;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.zzk) {
            int i9 = this.zzj[i8];
            int i10 = this.zzc[i9];
            int zzu = zzu(i9);
            int i11 = this.zzc[i9 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i6) {
                if (i12 != 1048575) {
                    i7 = zzb.getInt(obj, i12);
                }
                i5 = i7;
                i4 = i12;
            } else {
                i4 = i6;
                i5 = i7;
            }
            if ((268435456 & zzu) != 0 && !zzO(obj, i9, i4, i5, i13)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt != 60 && zzt != 68) {
                        if (zzt != 49) {
                            if (zzt == 50 && !((zzaic) zzajy.zzf(obj, zzu & 1048575)).isEmpty()) {
                                zzaib zzaibVar = (zzaib) zzz(i9);
                                throw null;
                            }
                        }
                    } else if (zzR(obj, i10, i9) && !zzP(obj, zzu, zzx(i9))) {
                        return false;
                    }
                }
                List list = (List) zzajy.zzf(obj, zzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzaiu zzx = zzx(i9);
                    for (int i14 = 0; i14 < list.size(); i14++) {
                        if (!zzx.zzk(list.get(i14))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzO(obj, i9, i4, i5, i13) && !zzP(obj, zzu, zzx(i9))) {
                return false;
            }
            i8++;
            i6 = i4;
            i7 = i5;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzm(Object obj, zzagm zzagmVar) throws IOException {
        int i4;
        int i5;
        int i6;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i7 = 1048575;
            int i8 = 1048575;
            int i9 = 0;
            int i10 = 0;
            while (i10 < length) {
                int zzu = zzu(i10);
                int[] iArr = this.zzc;
                int i11 = iArr[i10];
                int zzt = zzt(zzu);
                if (zzt <= 17) {
                    int i12 = iArr[i10 + 2];
                    int i13 = i12 & i7;
                    if (i13 != i8) {
                        i9 = i13 == i7 ? 0 : unsafe.getInt(obj, i13);
                        i8 = i13;
                    }
                    i4 = i8;
                    i5 = i9;
                    i6 = 1 << (i12 >>> 20);
                } else {
                    i4 = i8;
                    i5 = i9;
                    i6 = 0;
                }
                long j4 = zzu & i7;
                switch (zzt) {
                    case 0:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzf(i11, zzajy.zza(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzo(i11, zzajy.zzb(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzt(i11, unsafe.getLong(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzJ(i11, unsafe.getLong(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzr(i11, unsafe.getInt(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzm(i11, unsafe.getLong(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzk(i11, unsafe.getInt(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzb(i11, zzajy.zzw(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzT(i11, unsafe.getObject(obj, j4), zzagmVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzv(i11, unsafe.getObject(obj, j4), zzx(i10));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzd(i11, (zzafy) unsafe.getObject(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzH(i11, unsafe.getInt(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzi(i11, unsafe.getInt(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzw(i11, unsafe.getInt(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzy(i11, unsafe.getLong(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzA(i11, unsafe.getInt(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzC(i11, unsafe.getLong(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzO(obj, i10, i4, i5, i6)) {
                            zzagmVar.zzq(i11, unsafe.getObject(obj, j4), zzx(i10));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzaiw.zzu(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 19:
                        zzaiw.zzy(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 20:
                        zzaiw.zzA(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 21:
                        zzaiw.zzG(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 22:
                        zzaiw.zzz(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 23:
                        zzaiw.zzx(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 24:
                        zzaiw.zzw(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 25:
                        zzaiw.zzt(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 26:
                        int i14 = this.zzc[i10];
                        List list = (List) unsafe.getObject(obj, j4);
                        int i15 = zzaiw.zza;
                        if (list != null && !list.isEmpty()) {
                            zzagmVar.zzG(i14, list);
                            break;
                        }
                        break;
                    case 27:
                        int i16 = this.zzc[i10];
                        List list2 = (List) unsafe.getObject(obj, j4);
                        zzaiu zzx = zzx(i10);
                        int i17 = zzaiw.zza;
                        if (list2 != null && !list2.isEmpty()) {
                            for (int i18 = 0; i18 < list2.size(); i18++) {
                                zzagmVar.zzv(i16, list2.get(i18), zzx);
                            }
                            break;
                        }
                        break;
                    case 28:
                        int i19 = this.zzc[i10];
                        List list3 = (List) unsafe.getObject(obj, j4);
                        int i20 = zzaiw.zza;
                        if (list3 != null && !list3.isEmpty()) {
                            zzagmVar.zze(i19, list3);
                            break;
                        }
                        break;
                    case 29:
                        zzaiw.zzF(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 30:
                        zzaiw.zzv(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 31:
                        zzaiw.zzB(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 32:
                        zzaiw.zzC(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 33:
                        zzaiw.zzD(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 34:
                        zzaiw.zzE(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, false);
                        break;
                    case 35:
                        zzaiw.zzu(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 36:
                        zzaiw.zzy(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 37:
                        zzaiw.zzA(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 38:
                        zzaiw.zzG(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 39:
                        zzaiw.zzz(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 40:
                        zzaiw.zzx(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 41:
                        zzaiw.zzw(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 42:
                        zzaiw.zzt(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 43:
                        zzaiw.zzF(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 44:
                        zzaiw.zzv(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 45:
                        zzaiw.zzB(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 46:
                        zzaiw.zzC(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 47:
                        zzaiw.zzD(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 48:
                        zzaiw.zzE(this.zzc[i10], (List) unsafe.getObject(obj, j4), zzagmVar, true);
                        break;
                    case 49:
                        int i21 = this.zzc[i10];
                        List list4 = (List) unsafe.getObject(obj, j4);
                        zzaiu zzx2 = zzx(i10);
                        int i22 = zzaiw.zza;
                        if (list4 != null && !list4.isEmpty()) {
                            for (int i23 = 0; i23 < list4.size(); i23++) {
                                zzagmVar.zzq(i21, list4.get(i23), zzx2);
                            }
                            break;
                        }
                        break;
                    case 50:
                        if (unsafe.getObject(obj, j4) != null) {
                            zzaib zzaibVar = (zzaib) zzz(i10);
                            throw null;
                        }
                        break;
                    case 51:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzf(i11, zzn(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzo(i11, zzo(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzt(i11, zzv(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzJ(i11, zzv(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzr(i11, zzp(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzm(i11, zzv(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzk(i11, zzp(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzb(i11, zzS(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzR(obj, i11, i10)) {
                            zzT(i11, unsafe.getObject(obj, j4), zzagmVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzv(i11, unsafe.getObject(obj, j4), zzx(i10));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzd(i11, (zzafy) unsafe.getObject(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzH(i11, zzp(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzi(i11, zzp(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzw(i11, zzp(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzy(i11, zzv(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzA(i11, zzp(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzC(i11, zzv(obj, j4));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzR(obj, i11, i10)) {
                            zzagmVar.zzq(i11, unsafe.getObject(obj, j4), zzx(i10));
                            break;
                        } else {
                            break;
                        }
                }
                i10 += 3;
                i8 = i4;
                i9 = i5;
                i7 = 1048575;
            }
            zzajo zzajoVar = this.zzn;
            zzajoVar.zzr(zzajoVar.zzd(obj), zzagmVar);
            return;
        }
        this.zzo.zza(obj);
        throw null;
    }
}
