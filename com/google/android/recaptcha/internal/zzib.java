package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzib<T> implements zzil<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzjp.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhy zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzhm zzn;
    private final zzjf zzo;
    private final zzga zzp;
    private final zzie zzq;
    private final zzht zzr;

    private zzib(int[] iArr, Object[] objArr, int i4, int i5, zzhy zzhyVar, boolean z3, boolean z4, int[] iArr2, int i6, int i7, zzie zzieVar, zzhm zzhmVar, zzjf zzjfVar, zzga zzgaVar, zzht zzhtVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i4;
        this.zzf = i5;
        this.zzi = zzhyVar instanceof zzgo;
        this.zzj = z3;
        boolean z5 = false;
        if (zzgaVar != null && zzgaVar.zzj(zzhyVar)) {
            z5 = true;
        }
        this.zzh = z5;
        this.zzk = iArr2;
        this.zzl = i6;
        this.zzm = i7;
        this.zzq = zzieVar;
        this.zzn = zzhmVar;
        this.zzo = zzjfVar;
        this.zzp = zzgaVar;
        this.zzg = zzhyVar;
        this.zzr = zzhtVar;
    }

    private static long zzA(Object obj, long j4) {
        return ((Long) zzjp.zzf(obj, j4)).longValue();
    }

    private final zzgs zzB(int i4) {
        int i5 = i4 / 3;
        return (zzgs) this.zzd[i5 + i5 + 1];
    }

    private final zzil zzC(int i4) {
        int i5 = i4 / 3;
        int i6 = i5 + i5;
        zzil zzilVar = (zzil) this.zzd[i6];
        if (zzilVar != null) {
            return zzilVar;
        }
        zzil zzb2 = zzih.zza().zzb((Class) this.zzd[i6 + 1]);
        this.zzd[i6] = zzb2;
        return zzb2;
    }

    private final Object zzD(Object obj, int i4, Object obj2, zzjf zzjfVar, Object obj3) {
        int i5 = this.zzc[i4];
        Object zzf = zzjp.zzf(obj, zzz(i4) & 1048575);
        if (zzf == null) {
            return obj2;
        }
        if (zzB(i4) == null) {
            return obj2;
        }
        zzhs zzhsVar = (zzhs) zzf;
        zzhr zzhrVar = (zzhr) zzE(i4);
        throw null;
    }

    private final Object zzE(int i4) {
        int i5 = i4 / 3;
        return this.zzd[i5 + i5];
    }

    private final Object zzF(Object obj, int i4) {
        zzil zzC = zzC(i4);
        int zzz = zzz(i4) & 1048575;
        if (!zzT(obj, i4)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, zzz);
        if (zzW(object)) {
            return object;
        }
        Object zze = zzC.zze();
        if (object != null) {
            zzC.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzG(Object obj, int i4, int i5) {
        zzil zzC = zzC(i5);
        if (!zzX(obj, i4, i5)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, zzz(i5) & 1048575);
        if (zzW(object)) {
            return object;
        }
        Object zze = zzC.zze();
        if (object != null) {
            zzC.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzH(Class cls, String str) {
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

    private static void zzI(Object obj) {
        if (zzW(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
    }

    private final void zzJ(Object obj, Object obj2, int i4) {
        if (!zzT(obj2, i4)) {
            return;
        }
        Unsafe unsafe = zzb;
        long zzz = zzz(i4) & 1048575;
        Object object = unsafe.getObject(obj2, zzz);
        if (object != null) {
            zzil zzC = zzC(i4);
            if (!zzT(obj, i4)) {
                if (!zzW(object)) {
                    unsafe.putObject(obj, zzz, object);
                } else {
                    Object zze = zzC.zze();
                    zzC.zzg(zze, object);
                    unsafe.putObject(obj, zzz, zze);
                }
                zzM(obj, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzz);
            if (!zzW(object2)) {
                Object zze2 = zzC.zze();
                zzC.zzg(zze2, object2);
                unsafe.putObject(obj, zzz, zze2);
                object2 = zze2;
            }
            zzC.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i4] + " is present but null: " + obj2.toString());
    }

    private final void zzK(Object obj, Object obj2, int i4) {
        int i5 = this.zzc[i4];
        if (!zzX(obj2, i5, i4)) {
            return;
        }
        Unsafe unsafe = zzb;
        long zzz = zzz(i4) & 1048575;
        Object object = unsafe.getObject(obj2, zzz);
        if (object != null) {
            zzil zzC = zzC(i4);
            if (!zzX(obj, i5, i4)) {
                if (!zzW(object)) {
                    unsafe.putObject(obj, zzz, object);
                } else {
                    Object zze = zzC.zze();
                    zzC.zzg(zze, object);
                    unsafe.putObject(obj, zzz, zze);
                }
                zzN(obj, i5, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzz);
            if (!zzW(object2)) {
                Object zze2 = zzC.zze();
                zzC.zzg(zze2, object2);
                unsafe.putObject(obj, zzz, zze2);
                object2 = zze2;
            }
            zzC.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i4] + " is present but null: " + obj2.toString());
    }

    private final void zzL(Object obj, int i4, zzik zzikVar) throws IOException {
        if (zzS(i4)) {
            zzjp.zzs(obj, i4 & 1048575, zzikVar.zzs());
        } else if (this.zzi) {
            zzjp.zzs(obj, i4 & 1048575, zzikVar.zzr());
        } else {
            zzjp.zzs(obj, i4 & 1048575, zzikVar.zzp());
        }
    }

    private final void zzM(Object obj, int i4) {
        int zzw = zzw(i4);
        long j4 = 1048575 & zzw;
        if (j4 == 1048575) {
            return;
        }
        zzjp.zzq(obj, j4, (1 << (zzw >>> 20)) | zzjp.zzc(obj, j4));
    }

    private final void zzN(Object obj, int i4, int i5) {
        zzjp.zzq(obj, zzw(i5) & 1048575, i4);
    }

    private final void zzO(Object obj, int i4, Object obj2) {
        zzb.putObject(obj, zzz(i4) & 1048575, obj2);
        zzM(obj, i4);
    }

    private final void zzP(Object obj, int i4, int i5, Object obj2) {
        zzb.putObject(obj, zzz(i5) & 1048575, obj2);
        zzN(obj, i4, i5);
    }

    private final void zzQ(zzjx zzjxVar, int i4, Object obj, int i5) throws IOException {
        if (obj == null) {
            return;
        }
        zzhr zzhrVar = (zzhr) zzE(i5);
        throw null;
    }

    private final boolean zzR(Object obj, Object obj2, int i4) {
        if (zzT(obj, i4) == zzT(obj2, i4)) {
            return true;
        }
        return false;
    }

    private static boolean zzS(int i4) {
        if ((i4 & 536870912) != 0) {
            return true;
        }
        return false;
    }

    private final boolean zzT(Object obj, int i4) {
        int zzw = zzw(i4);
        long j4 = zzw & 1048575;
        if (j4 == 1048575) {
            int zzz = zzz(i4);
            long j5 = zzz & 1048575;
            switch (zzy(zzz)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzjp.zza(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzjp.zzb(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzjp.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzjp.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzjp.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzjp.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzjp.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzjp.zzw(obj, j5);
                case 8:
                    Object zzf = zzjp.zzf(obj, j5);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    } else if (zzf instanceof zzez) {
                        if (zzez.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (zzjp.zzf(obj, j5) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzez.zzb.equals(zzjp.zzf(obj, j5))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzjp.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzjp.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzjp.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzjp.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzjp.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzjp.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzjp.zzf(obj, j5) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzjp.zzc(obj, j4) & (1 << (zzw >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzU(Object obj, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return zzT(obj, i4);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzV(Object obj, int i4, zzil zzilVar) {
        return zzilVar.zzl(zzjp.zzf(obj, i4 & 1048575));
    }

    private static boolean zzW(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgo) {
            return ((zzgo) obj).zzF();
        }
        return true;
    }

    private final boolean zzX(Object obj, int i4, int i5) {
        if (zzjp.zzc(obj, zzw(i5) & 1048575) == i4) {
            return true;
        }
        return false;
    }

    private static boolean zzY(Object obj, long j4) {
        return ((Boolean) zzjp.zzf(obj, j4)).booleanValue();
    }

    private static final void zzZ(int i4, Object obj, zzjx zzjxVar) throws IOException {
        if (obj instanceof String) {
            zzjxVar.zzG(i4, (String) obj);
        } else {
            zzjxVar.zzd(i4, (zzez) obj);
        }
    }

    static zzjg zzd(Object obj) {
        zzgo zzgoVar = (zzgo) obj;
        zzjg zzjgVar = zzgoVar.zzc;
        if (zzjgVar == zzjg.zzc()) {
            zzjg zzf = zzjg.zzf();
            zzgoVar.zzc = zzf;
            return zzf;
        }
        return zzjgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0287  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.recaptcha.internal.zzib zzm(java.lang.Class r31, com.google.android.recaptcha.internal.zzhv r32, com.google.android.recaptcha.internal.zzie r33, com.google.android.recaptcha.internal.zzhm r34, com.google.android.recaptcha.internal.zzjf r35, com.google.android.recaptcha.internal.zzga r36, com.google.android.recaptcha.internal.zzht r37) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzm(java.lang.Class, com.google.android.recaptcha.internal.zzhv, com.google.android.recaptcha.internal.zzie, com.google.android.recaptcha.internal.zzhm, com.google.android.recaptcha.internal.zzjf, com.google.android.recaptcha.internal.zzga, com.google.android.recaptcha.internal.zzht):com.google.android.recaptcha.internal.zzib");
    }

    private static double zzn(Object obj, long j4) {
        return ((Double) zzjp.zzf(obj, j4)).doubleValue();
    }

    private static float zzo(Object obj, long j4) {
        return ((Float) zzjp.zzf(obj, j4)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i4;
        int zzy;
        int zzy2;
        int zzz;
        int zzy3;
        int zzy4;
        int zzy5;
        int zzy6;
        int zzt;
        int zzh;
        int zzy7;
        int zzy8;
        int i5;
        int zzy9;
        int zzy10;
        int zzy11;
        int zzy12;
        Unsafe unsafe = zzb;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1048575;
        int i10 = 0;
        while (i7 < this.zzc.length) {
            int zzz2 = zzz(i7);
            int[] iArr = this.zzc;
            int i11 = iArr[i7];
            int zzy13 = zzy(zzz2);
            if (zzy13 <= 17) {
                int i12 = iArr[i7 + 2];
                int i13 = i12 & i6;
                int i14 = i12 >>> 20;
                if (i13 != i9) {
                    i10 = unsafe.getInt(obj, i13);
                    i9 = i13;
                }
                i4 = 1 << i14;
            } else {
                i4 = 0;
            }
            long j4 = zzz2 & i6;
            switch (zzy13) {
                case 0:
                    if ((i10 & i4) != 0) {
                        zzy = zzfk.zzy(i11 << 3);
                        zzy4 = zzy + 8;
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i10 & i4) != 0) {
                        zzy2 = zzfk.zzy(i11 << 3);
                        zzy4 = zzy2 + 4;
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i10 & i4) != 0) {
                        zzz = zzfk.zzz(unsafe.getLong(obj, j4));
                        zzy3 = zzfk.zzy(i11 << 3);
                        i8 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i10 & i4) != 0) {
                        zzz = zzfk.zzz(unsafe.getLong(obj, j4));
                        zzy3 = zzfk.zzy(i11 << 3);
                        i8 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i10 & i4) != 0) {
                        zzz = zzfk.zzu(unsafe.getInt(obj, j4));
                        zzy3 = zzfk.zzy(i11 << 3);
                        i8 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i10 & i4) != 0) {
                        zzy = zzfk.zzy(i11 << 3);
                        zzy4 = zzy + 8;
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i10 & i4) != 0) {
                        zzy2 = zzfk.zzy(i11 << 3);
                        zzy4 = zzy2 + 4;
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i10 & i4) != 0) {
                        zzy4 = zzfk.zzy(i11 << 3) + 1;
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i10 & i4) != 0) {
                        Object object = unsafe.getObject(obj, j4);
                        if (object instanceof zzez) {
                            int i15 = zzfk.zzb;
                            int zzd = ((zzez) object).zzd();
                            zzy5 = zzfk.zzy(zzd) + zzd;
                            zzy6 = zzfk.zzy(i11 << 3);
                            zzy4 = zzy6 + zzy5;
                            i8 += zzy4;
                            break;
                        } else {
                            zzz = zzfk.zzx((String) object);
                            zzy3 = zzfk.zzy(i11 << 3);
                            i8 += zzy3 + zzz;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if ((i10 & i4) != 0) {
                        zzy4 = zzin.zzn(i11, unsafe.getObject(obj, j4), zzC(i7));
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i10 & i4) != 0) {
                        int i16 = zzfk.zzb;
                        int zzd2 = ((zzez) unsafe.getObject(obj, j4)).zzd();
                        zzy5 = zzfk.zzy(zzd2) + zzd2;
                        zzy6 = zzfk.zzy(i11 << 3);
                        zzy4 = zzy6 + zzy5;
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i10 & i4) != 0) {
                        zzz = zzfk.zzy(unsafe.getInt(obj, j4));
                        zzy3 = zzfk.zzy(i11 << 3);
                        i8 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i10 & i4) != 0) {
                        zzz = zzfk.zzu(unsafe.getInt(obj, j4));
                        zzy3 = zzfk.zzy(i11 << 3);
                        i8 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i10 & i4) != 0) {
                        zzy2 = zzfk.zzy(i11 << 3);
                        zzy4 = zzy2 + 4;
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i10 & i4) != 0) {
                        zzy = zzfk.zzy(i11 << 3);
                        zzy4 = zzy + 8;
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i10 & i4) != 0) {
                        int i17 = unsafe.getInt(obj, j4);
                        zzy3 = zzfk.zzy(i11 << 3);
                        zzz = zzfk.zzy((i17 >> 31) ^ (i17 + i17));
                        i8 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i4 & i10) != 0) {
                        long j5 = unsafe.getLong(obj, j4);
                        i8 += zzfk.zzy(i11 << 3) + zzfk.zzz((j5 >> 63) ^ (j5 + j5));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i10 & i4) != 0) {
                        zzy4 = zzfk.zzt(i11, (zzhy) unsafe.getObject(obj, j4), zzC(i7));
                        i8 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzy4 = zzin.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzy4;
                    break;
                case 19:
                    zzy4 = zzin.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzy4;
                    break;
                case 20:
                    zzy4 = zzin.zzl(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzy4;
                    break;
                case 21:
                    zzy4 = zzin.zzw(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzy4;
                    break;
                case 22:
                    zzy4 = zzin.zzj(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzy4;
                    break;
                case 23:
                    zzy4 = zzin.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzy4;
                    break;
                case 24:
                    zzy4 = zzin.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzy4;
                    break;
                case 25:
                    zzy4 = zzin.zza(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzy4;
                    break;
                case 26:
                    zzt = zzin.zzt(i11, (List) unsafe.getObject(obj, j4));
                    i8 += zzt;
                    break;
                case 27:
                    zzt = zzin.zzo(i11, (List) unsafe.getObject(obj, j4), zzC(i7));
                    i8 += zzt;
                    break;
                case 28:
                    zzt = zzin.zzb(i11, (List) unsafe.getObject(obj, j4));
                    i8 += zzt;
                    break;
                case 29:
                    zzt = zzin.zzu(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 30:
                    zzt = zzin.zzc(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 31:
                    zzt = zzin.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 32:
                    zzt = zzin.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 33:
                    zzt = zzin.zzp(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 34:
                    zzt = zzin.zzr(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 35:
                    zzh = zzin.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 36:
                    zzh = zzin.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 37:
                    zzh = zzin.zzm((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 38:
                    zzh = zzin.zzx((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 39:
                    zzh = zzin.zzk((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 40:
                    zzh = zzin.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 41:
                    zzh = zzin.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 42:
                    int i18 = zzin.zza;
                    zzh = ((List) unsafe.getObject(obj, j4)).size();
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 43:
                    zzh = zzin.zzv((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 44:
                    zzh = zzin.zzd((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 45:
                    zzh = zzin.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 46:
                    zzh = zzin.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 47:
                    zzh = zzin.zzq((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 48:
                    zzh = zzin.zzs((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzy7 = zzfk.zzy(zzh);
                        zzy8 = zzfk.zzy(i11 << 3);
                        i5 = zzy8 + zzy7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 49:
                    zzt = zzin.zzi(i11, (List) unsafe.getObject(obj, j4), zzC(i7));
                    i8 += zzt;
                    break;
                case 50:
                    zzht.zza(i11, unsafe.getObject(obj, j4), zzE(i7));
                    break;
                case 51:
                    if (zzX(obj, i11, i7)) {
                        zzy9 = zzfk.zzy(i11 << 3);
                        zzt = zzy9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 52:
                    if (zzX(obj, i11, i7)) {
                        zzy10 = zzfk.zzy(i11 << 3);
                        zzt = zzy10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 53:
                    if (zzX(obj, i11, i7)) {
                        zzh = zzfk.zzz(zzA(obj, j4));
                        i5 = zzfk.zzy(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 54:
                    if (zzX(obj, i11, i7)) {
                        zzh = zzfk.zzz(zzA(obj, j4));
                        i5 = zzfk.zzy(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 55:
                    if (zzX(obj, i11, i7)) {
                        zzh = zzfk.zzu(zzq(obj, j4));
                        i5 = zzfk.zzy(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 56:
                    if (zzX(obj, i11, i7)) {
                        zzy9 = zzfk.zzy(i11 << 3);
                        zzt = zzy9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 57:
                    if (zzX(obj, i11, i7)) {
                        zzy10 = zzfk.zzy(i11 << 3);
                        zzt = zzy10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 58:
                    if (zzX(obj, i11, i7)) {
                        zzt = zzfk.zzy(i11 << 3) + 1;
                        i8 += zzt;
                    }
                    break;
                case 59:
                    if (zzX(obj, i11, i7)) {
                        Object object2 = unsafe.getObject(obj, j4);
                        if (object2 instanceof zzez) {
                            int i19 = zzfk.zzb;
                            int zzd3 = ((zzez) object2).zzd();
                            zzy11 = zzfk.zzy(zzd3) + zzd3;
                            zzy12 = zzfk.zzy(i11 << 3);
                            zzt = zzy12 + zzy11;
                            i8 += zzt;
                        } else {
                            zzh = zzfk.zzx((String) object2);
                            i5 = zzfk.zzy(i11 << 3);
                            i8 += i5 + zzh;
                        }
                    }
                    break;
                case 60:
                    if (zzX(obj, i11, i7)) {
                        zzt = zzin.zzn(i11, unsafe.getObject(obj, j4), zzC(i7));
                        i8 += zzt;
                    }
                    break;
                case 61:
                    if (zzX(obj, i11, i7)) {
                        int i20 = zzfk.zzb;
                        int zzd4 = ((zzez) unsafe.getObject(obj, j4)).zzd();
                        zzy11 = zzfk.zzy(zzd4) + zzd4;
                        zzy12 = zzfk.zzy(i11 << 3);
                        zzt = zzy12 + zzy11;
                        i8 += zzt;
                    }
                    break;
                case 62:
                    if (zzX(obj, i11, i7)) {
                        zzh = zzfk.zzy(zzq(obj, j4));
                        i5 = zzfk.zzy(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 63:
                    if (zzX(obj, i11, i7)) {
                        zzh = zzfk.zzu(zzq(obj, j4));
                        i5 = zzfk.zzy(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 64:
                    if (zzX(obj, i11, i7)) {
                        zzy10 = zzfk.zzy(i11 << 3);
                        zzt = zzy10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 65:
                    if (zzX(obj, i11, i7)) {
                        zzy9 = zzfk.zzy(i11 << 3);
                        zzt = zzy9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 66:
                    if (zzX(obj, i11, i7)) {
                        int zzq = zzq(obj, j4);
                        i5 = zzfk.zzy(i11 << 3);
                        zzh = zzfk.zzy((zzq >> 31) ^ (zzq + zzq));
                        i8 += i5 + zzh;
                    }
                    break;
                case 67:
                    if (zzX(obj, i11, i7)) {
                        long zzA = zzA(obj, j4);
                        i8 += zzfk.zzy(i11 << 3) + zzfk.zzz((zzA >> 63) ^ (zzA + zzA));
                    }
                    break;
                case 68:
                    if (zzX(obj, i11, i7)) {
                        zzt = zzfk.zzt(i11, (zzhy) unsafe.getObject(obj, j4), zzC(i7));
                        i8 += zzt;
                    }
                    break;
            }
            i7 += 3;
            i6 = 1048575;
        }
        int i21 = 0;
        zzjf zzjfVar = this.zzo;
        int zza2 = i8 + zzjfVar.zza(zzjfVar.zzd(obj));
        if (this.zzh) {
            zzge zzb2 = this.zzp.zzb(obj);
            for (int i22 = 0; i22 < zzb2.zza.zzb(); i22++) {
                Map.Entry zzg = zzb2.zza.zzg(i22);
                i21 += zzge.zza((zzgd) zzg.getKey(), zzg.getValue());
            }
            for (Map.Entry entry : zzb2.zza.zzc()) {
                i21 += zzge.zza((zzgd) entry.getKey(), entry.getValue());
            }
            return zza2 + i21;
        }
        return zza2;
    }

    private static int zzq(Object obj, long j4) {
        return ((Integer) zzjp.zzf(obj, j4)).intValue();
    }

    private final int zzr(Object obj, byte[] bArr, int i4, int i5, int i6, long j4, zzem zzemVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzE = zzE(i6);
        Object object = unsafe.getObject(obj, j4);
        if (zzht.zzb(object)) {
            zzhs zzb2 = zzhs.zza().zzb();
            zzht.zzc(zzb2, object);
            unsafe.putObject(obj, j4, zzb2);
        }
        zzhr zzhrVar = (zzhr) zzE;
        throw null;
    }

    private final int zzs(Object obj, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4, int i11, zzem zzemVar) throws IOException {
        Unsafe unsafe = zzb;
        long j5 = this.zzc[i11 + 2] & 1048575;
        switch (i10) {
            case 51:
                if (i8 == 1) {
                    unsafe.putObject(obj, j4, Double.valueOf(Double.longBitsToDouble(zzen.zzq(bArr, i4))));
                    int i12 = i4 + 8;
                    unsafe.putInt(obj, j5, i7);
                    return i12;
                }
                break;
            case 52:
                if (i8 == 5) {
                    unsafe.putObject(obj, j4, Float.valueOf(Float.intBitsToFloat(zzen.zzb(bArr, i4))));
                    int i13 = i4 + 4;
                    unsafe.putInt(obj, j5, i7);
                    return i13;
                }
                break;
            case 53:
            case 54:
                if (i8 == 0) {
                    int zzm = zzen.zzm(bArr, i4, zzemVar);
                    unsafe.putObject(obj, j4, Long.valueOf(zzemVar.zzb));
                    unsafe.putInt(obj, j5, i7);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i8 == 0) {
                    int zzj = zzen.zzj(bArr, i4, zzemVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(zzemVar.zza));
                    unsafe.putInt(obj, j5, i7);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i8 == 1) {
                    unsafe.putObject(obj, j4, Long.valueOf(zzen.zzq(bArr, i4)));
                    int i14 = i4 + 8;
                    unsafe.putInt(obj, j5, i7);
                    return i14;
                }
                break;
            case 57:
            case 64:
                if (i8 == 5) {
                    unsafe.putObject(obj, j4, Integer.valueOf(zzen.zzb(bArr, i4)));
                    int i15 = i4 + 4;
                    unsafe.putInt(obj, j5, i7);
                    return i15;
                }
                break;
            case 58:
                if (i8 == 0) {
                    int zzm2 = zzen.zzm(bArr, i4, zzemVar);
                    unsafe.putObject(obj, j4, Boolean.valueOf(zzemVar.zzb != 0));
                    unsafe.putInt(obj, j5, i7);
                    return zzm2;
                }
                break;
            case 59:
                if (i8 == 2) {
                    int zzj2 = zzen.zzj(bArr, i4, zzemVar);
                    int i16 = zzemVar.zza;
                    if (i16 == 0) {
                        unsafe.putObject(obj, j4, "");
                    } else if ((i9 & 536870912) != 0 && !zzju.zzf(bArr, zzj2, zzj2 + i16)) {
                        throw zzgy.zzd();
                    } else {
                        unsafe.putObject(obj, j4, new String(bArr, zzj2, i16, zzgw.zzb));
                        zzj2 += i16;
                    }
                    unsafe.putInt(obj, j5, i7);
                    return zzj2;
                }
                break;
            case 60:
                if (i8 == 2) {
                    Object zzG = zzG(obj, i7, i11);
                    int zzo = zzen.zzo(zzG, zzC(i11), bArr, i4, i5, zzemVar);
                    zzP(obj, i7, i11, zzG);
                    return zzo;
                }
                break;
            case 61:
                if (i8 == 2) {
                    int zza2 = zzen.zza(bArr, i4, zzemVar);
                    unsafe.putObject(obj, j4, zzemVar.zzc);
                    unsafe.putInt(obj, j5, i7);
                    return zza2;
                }
                break;
            case 63:
                if (i8 == 0) {
                    int zzj3 = zzen.zzj(bArr, i4, zzemVar);
                    int i17 = zzemVar.zza;
                    zzgs zzB = zzB(i11);
                    if (zzB != null && !zzB.zza()) {
                        zzd(obj).zzj(i6, Long.valueOf(i17));
                    } else {
                        unsafe.putObject(obj, j4, Integer.valueOf(i17));
                        unsafe.putInt(obj, j5, i7);
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i8 == 0) {
                    int zzj4 = zzen.zzj(bArr, i4, zzemVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(zzff.zzF(zzemVar.zza)));
                    unsafe.putInt(obj, j5, i7);
                    return zzj4;
                }
                break;
            case 67:
                if (i8 == 0) {
                    int zzm3 = zzen.zzm(bArr, i4, zzemVar);
                    unsafe.putObject(obj, j4, Long.valueOf(zzff.zzG(zzemVar.zzb)));
                    unsafe.putInt(obj, j5, i7);
                    return zzm3;
                }
                break;
            case 68:
                if (i8 == 3) {
                    Object zzG2 = zzG(obj, i7, i11);
                    int zzn = zzen.zzn(zzG2, zzC(i11), bArr, i4, i5, (i6 & (-8)) | 4, zzemVar);
                    zzP(obj, i7, i11, zzG2);
                    return zzn;
                }
                break;
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0211 -> B:113:0x0212). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0148 -> B:61:0x0149). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x01c3 -> B:93:0x01c4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzt(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.recaptcha.internal.zzem r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.recaptcha.internal.zzem):int");
    }

    private final int zzu(int i4) {
        if (i4 >= this.zze && i4 <= this.zzf) {
            return zzx(i4, 0);
        }
        return -1;
    }

    private final int zzv(int i4, int i5) {
        if (i4 >= this.zze && i4 <= this.zzf) {
            return zzx(i4, i5);
        }
        return -1;
    }

    private final int zzw(int i4) {
        return this.zzc[i4 + 2];
    }

    private final int zzx(int i4, int i5) {
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

    private static int zzy(int i4) {
        return (i4 >>> 20) & 255;
    }

    private final int zzz(int i4) {
        return this.zzc[i4 + 1];
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final int zza(Object obj) {
        int zzy;
        int zzy2;
        int zzz;
        int zzy3;
        int zzy4;
        int zzy5;
        int zzy6;
        int zzn;
        int zzy7;
        int zzz2;
        int zzy8;
        int zzy9;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i4 = 0;
            for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
                int zzz3 = zzz(i5);
                int zzy10 = zzy(zzz3);
                int i6 = this.zzc[i5];
                int i7 = zzz3 & 1048575;
                if (zzy10 >= zzgf.zzJ.zza() && zzy10 <= zzgf.zzW.zza()) {
                    int i8 = this.zzc[i5 + 2];
                }
                long j4 = i7;
                switch (zzy10) {
                    case 0:
                        if (zzT(obj, i5)) {
                            zzy = zzfk.zzy(i6 << 3);
                            zzn = zzy + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzT(obj, i5)) {
                            zzy2 = zzfk.zzy(i6 << 3);
                            zzn = zzy2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzT(obj, i5)) {
                            zzz = zzfk.zzz(zzjp.zzd(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzT(obj, i5)) {
                            zzz = zzfk.zzz(zzjp.zzd(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzT(obj, i5)) {
                            zzz = zzfk.zzu(zzjp.zzc(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzT(obj, i5)) {
                            zzy = zzfk.zzy(i6 << 3);
                            zzn = zzy + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzT(obj, i5)) {
                            zzy2 = zzfk.zzy(i6 << 3);
                            zzn = zzy2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzT(obj, i5)) {
                            zzy4 = zzfk.zzy(i6 << 3);
                            zzn = zzy4 + 1;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzT(obj, i5)) {
                            Object zzf = zzjp.zzf(obj, j4);
                            if (zzf instanceof zzez) {
                                int i9 = i6 << 3;
                                int i10 = zzfk.zzb;
                                int zzd = ((zzez) zzf).zzd();
                                zzy5 = zzfk.zzy(zzd) + zzd;
                                zzy6 = zzfk.zzy(i9);
                                zzn = zzy6 + zzy5;
                                i4 += zzn;
                                break;
                            } else {
                                zzz = zzfk.zzx((String) zzf);
                                zzy3 = zzfk.zzy(i6 << 3);
                                i4 += zzy3 + zzz;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (zzT(obj, i5)) {
                            zzn = zzin.zzn(i6, zzjp.zzf(obj, j4), zzC(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzT(obj, i5)) {
                            int i11 = i6 << 3;
                            int i12 = zzfk.zzb;
                            int zzd2 = ((zzez) zzjp.zzf(obj, j4)).zzd();
                            zzy5 = zzfk.zzy(zzd2) + zzd2;
                            zzy6 = zzfk.zzy(i11);
                            zzn = zzy6 + zzy5;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzT(obj, i5)) {
                            zzz = zzfk.zzy(zzjp.zzc(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzT(obj, i5)) {
                            zzz = zzfk.zzu(zzjp.zzc(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzT(obj, i5)) {
                            zzy2 = zzfk.zzy(i6 << 3);
                            zzn = zzy2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzT(obj, i5)) {
                            zzy = zzfk.zzy(i6 << 3);
                            zzn = zzy + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzT(obj, i5)) {
                            int zzc = zzjp.zzc(obj, j4);
                            zzy3 = zzfk.zzy(i6 << 3);
                            zzz = zzfk.zzy((zzc >> 31) ^ (zzc + zzc));
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzT(obj, i5)) {
                            long zzd3 = zzjp.zzd(obj, j4);
                            zzy7 = zzfk.zzy(i6 << 3);
                            zzz2 = zzfk.zzz((zzd3 + zzd3) ^ (zzd3 >> 63));
                            zzn = zzy7 + zzz2;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzT(obj, i5)) {
                            zzn = zzfk.zzt(i6, (zzhy) zzjp.zzf(obj, j4), zzC(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzn = zzin.zzg(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 19:
                        zzn = zzin.zze(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 20:
                        zzn = zzin.zzl(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 21:
                        zzn = zzin.zzw(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 22:
                        zzn = zzin.zzj(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 23:
                        zzn = zzin.zzg(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 24:
                        zzn = zzin.zze(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 25:
                        zzn = zzin.zza(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 26:
                        zzn = zzin.zzt(i6, (List) zzjp.zzf(obj, j4));
                        i4 += zzn;
                        break;
                    case 27:
                        zzn = zzin.zzo(i6, (List) zzjp.zzf(obj, j4), zzC(i5));
                        i4 += zzn;
                        break;
                    case 28:
                        zzn = zzin.zzb(i6, (List) zzjp.zzf(obj, j4));
                        i4 += zzn;
                        break;
                    case 29:
                        zzn = zzin.zzu(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 30:
                        zzn = zzin.zzc(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 31:
                        zzn = zzin.zze(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 32:
                        zzn = zzin.zzg(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 33:
                        zzn = zzin.zzp(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 34:
                        zzn = zzin.zzr(i6, (List) zzjp.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 35:
                        zzz = zzin.zzh((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i13 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i13);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzz = zzin.zzf((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i14 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i14);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzz = zzin.zzm((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i15 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i15);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzz = zzin.zzx((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i16 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i16);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzz = zzin.zzk((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i17 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i17);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzz = zzin.zzh((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i18 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i18);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzz = zzin.zzf((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i19 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i19);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i20 = zzin.zza;
                        zzz = ((List) unsafe.getObject(obj, j4)).size();
                        if (zzz > 0) {
                            int i21 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i21);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzz = zzin.zzv((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i22 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i22);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzz = zzin.zzd((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i23 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i23);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzz = zzin.zzf((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i24 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i24);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzz = zzin.zzh((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i25 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i25);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzz = zzin.zzq((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i26 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i26);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzz = zzin.zzs((List) unsafe.getObject(obj, j4));
                        if (zzz > 0) {
                            int i27 = i6 << 3;
                            zzy8 = zzfk.zzy(zzz);
                            zzy9 = zzfk.zzy(i27);
                            zzy3 = zzy9 + zzy8;
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        zzn = zzin.zzi(i6, (List) zzjp.zzf(obj, j4), zzC(i5));
                        i4 += zzn;
                        break;
                    case 50:
                        zzht.zza(i6, zzjp.zzf(obj, j4), zzE(i5));
                        break;
                    case 51:
                        if (zzX(obj, i6, i5)) {
                            zzy = zzfk.zzy(i6 << 3);
                            zzn = zzy + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzX(obj, i6, i5)) {
                            zzy2 = zzfk.zzy(i6 << 3);
                            zzn = zzy2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzX(obj, i6, i5)) {
                            zzz = zzfk.zzz(zzA(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzX(obj, i6, i5)) {
                            zzz = zzfk.zzz(zzA(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzX(obj, i6, i5)) {
                            zzz = zzfk.zzu(zzq(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzX(obj, i6, i5)) {
                            zzy = zzfk.zzy(i6 << 3);
                            zzn = zzy + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzX(obj, i6, i5)) {
                            zzy2 = zzfk.zzy(i6 << 3);
                            zzn = zzy2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzX(obj, i6, i5)) {
                            zzy4 = zzfk.zzy(i6 << 3);
                            zzn = zzy4 + 1;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzX(obj, i6, i5)) {
                            Object zzf2 = zzjp.zzf(obj, j4);
                            if (zzf2 instanceof zzez) {
                                int i28 = i6 << 3;
                                int i29 = zzfk.zzb;
                                int zzd4 = ((zzez) zzf2).zzd();
                                zzy5 = zzfk.zzy(zzd4) + zzd4;
                                zzy6 = zzfk.zzy(i28);
                                zzn = zzy6 + zzy5;
                                i4 += zzn;
                                break;
                            } else {
                                zzz = zzfk.zzx((String) zzf2);
                                zzy3 = zzfk.zzy(i6 << 3);
                                i4 += zzy3 + zzz;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (zzX(obj, i6, i5)) {
                            zzn = zzin.zzn(i6, zzjp.zzf(obj, j4), zzC(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzX(obj, i6, i5)) {
                            int i30 = i6 << 3;
                            int i31 = zzfk.zzb;
                            int zzd5 = ((zzez) zzjp.zzf(obj, j4)).zzd();
                            zzy5 = zzfk.zzy(zzd5) + zzd5;
                            zzy6 = zzfk.zzy(i30);
                            zzn = zzy6 + zzy5;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzX(obj, i6, i5)) {
                            zzz = zzfk.zzy(zzq(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzX(obj, i6, i5)) {
                            zzz = zzfk.zzu(zzq(obj, j4));
                            zzy3 = zzfk.zzy(i6 << 3);
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzX(obj, i6, i5)) {
                            zzy2 = zzfk.zzy(i6 << 3);
                            zzn = zzy2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzX(obj, i6, i5)) {
                            zzy = zzfk.zzy(i6 << 3);
                            zzn = zzy + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzX(obj, i6, i5)) {
                            int zzq = zzq(obj, j4);
                            zzy3 = zzfk.zzy(i6 << 3);
                            zzz = zzfk.zzy((zzq >> 31) ^ (zzq + zzq));
                            i4 += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzX(obj, i6, i5)) {
                            long zzA = zzA(obj, j4);
                            zzy7 = zzfk.zzy(i6 << 3);
                            zzz2 = zzfk.zzz((zzA + zzA) ^ (zzA >> 63));
                            zzn = zzy7 + zzz2;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzX(obj, i6, i5)) {
                            zzn = zzfk.zzt(i6, (zzhy) zzjp.zzf(obj, j4), zzC(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                }
            }
            zzjf zzjfVar = this.zzo;
            return i4 + zzjfVar.zza(zzjfVar.zzd(obj));
        }
        return zzp(obj);
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final int zzb(Object obj) {
        int i4;
        long doubleToLongBits;
        int i5;
        int floatToIntBits;
        int length = this.zzc.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 3) {
            int zzz = zzz(i7);
            int i8 = this.zzc[i7];
            long j4 = 1048575 & zzz;
            int i9 = 37;
            switch (zzy(zzz)) {
                case 0:
                    i4 = i6 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzjp.zza(obj, j4));
                    byte[] bArr = zzgw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 1:
                    i5 = i6 * 53;
                    floatToIntBits = Float.floatToIntBits(zzjp.zzb(obj, j4));
                    i6 = i5 + floatToIntBits;
                    break;
                case 2:
                    i4 = i6 * 53;
                    doubleToLongBits = zzjp.zzd(obj, j4);
                    byte[] bArr2 = zzgw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 3:
                    i4 = i6 * 53;
                    doubleToLongBits = zzjp.zzd(obj, j4);
                    byte[] bArr3 = zzgw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 4:
                    i5 = i6 * 53;
                    floatToIntBits = zzjp.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 5:
                    i4 = i6 * 53;
                    doubleToLongBits = zzjp.zzd(obj, j4);
                    byte[] bArr4 = zzgw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 6:
                    i5 = i6 * 53;
                    floatToIntBits = zzjp.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 7:
                    i5 = i6 * 53;
                    floatToIntBits = zzgw.zza(zzjp.zzw(obj, j4));
                    i6 = i5 + floatToIntBits;
                    break;
                case 8:
                    i5 = i6 * 53;
                    floatToIntBits = ((String) zzjp.zzf(obj, j4)).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 9:
                    Object zzf = zzjp.zzf(obj, j4);
                    if (zzf != null) {
                        i9 = zzf.hashCode();
                    }
                    i6 = (i6 * 53) + i9;
                    break;
                case 10:
                    i5 = i6 * 53;
                    floatToIntBits = zzjp.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 11:
                    i5 = i6 * 53;
                    floatToIntBits = zzjp.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 12:
                    i5 = i6 * 53;
                    floatToIntBits = zzjp.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 13:
                    i5 = i6 * 53;
                    floatToIntBits = zzjp.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 14:
                    i4 = i6 * 53;
                    doubleToLongBits = zzjp.zzd(obj, j4);
                    byte[] bArr5 = zzgw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 15:
                    i5 = i6 * 53;
                    floatToIntBits = zzjp.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 16:
                    i4 = i6 * 53;
                    doubleToLongBits = zzjp.zzd(obj, j4);
                    byte[] bArr6 = zzgw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 17:
                    Object zzf2 = zzjp.zzf(obj, j4);
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
                    floatToIntBits = zzjp.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 50:
                    i5 = i6 * 53;
                    floatToIntBits = zzjp.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 51:
                    if (zzX(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j4));
                        byte[] bArr7 = zzgw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = Float.floatToIntBits(zzo(obj, j4));
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzX(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr8 = zzgw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzX(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr9 = zzgw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzX(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr10 = zzgw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzgw.zza(zzY(obj, j4));
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = ((String) zzjp.zzf(obj, j4)).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzjp.zzf(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzjp.zzf(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzX(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr11 = zzgw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzX(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr12 = zzgw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzX(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzjp.zzf(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i6 * 53) + this.zzo.zzd(obj).hashCode();
        if (this.zzh) {
            return (hashCode * 53) + this.zzp.zzb(obj).zza.hashCode();
        }
        return hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x04e8, code lost:
        if (r0 == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x04ea, code lost:
        r31.putInt(r12, r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x04f0, code lost:
        r10 = r9.zzl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04f5, code lost:
        if (r10 >= r9.zzm) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x04f7, code lost:
        zzD(r34, r9.zzk[r10], null, r9.zzo, r34);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x050a, code lost:
        if (r7 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x050e, code lost:
        if (r6 != r37) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0515, code lost:
        throw com.google.android.recaptcha.internal.zzgy.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0518, code lost:
        if (r6 > r37) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x051a, code lost:
        if (r8 != r7) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x051c, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0521, code lost:
        throw com.google.android.recaptcha.internal.zzgy.zzg();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.recaptcha.internal.zzem r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzc(java.lang.Object, byte[], int, int, int, com.google.android.recaptcha.internal.zzem):int");
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final Object zze() {
        return ((zzgo) this.zzg).zzs();
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final void zzf(Object obj) {
        if (!zzW(obj)) {
            return;
        }
        if (obj instanceof zzgo) {
            zzgo zzgoVar = (zzgo) obj;
            zzgoVar.zzD(Integer.MAX_VALUE);
            zzgoVar.zza = 0;
            zzgoVar.zzB();
        }
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzz = zzz(i4);
            int i5 = 1048575 & zzz;
            int zzy = zzy(zzz);
            long j4 = i5;
            if (zzy != 9) {
                if (zzy != 60 && zzy != 68) {
                    switch (zzy) {
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
                            this.zzn.zzb(obj, j4);
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j4);
                            if (object != null) {
                                ((zzhs) object).zzc();
                                unsafe.putObject(obj, j4, object);
                                break;
                            } else {
                                break;
                            }
                    }
                } else if (zzX(obj, this.zzc[i4], i4)) {
                    zzC(i4).zzf(zzb.getObject(obj, j4));
                }
            }
            if (zzT(obj, i4)) {
                zzC(i4).zzf(zzb.getObject(obj, j4));
            }
        }
        this.zzo.zzm(obj);
        if (this.zzh) {
            this.zzp.zzf(obj);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final void zzg(Object obj, Object obj2) {
        zzI(obj);
        obj2.getClass();
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzz = zzz(i4);
            int i5 = this.zzc[i4];
            long j4 = 1048575 & zzz;
            switch (zzy(zzz)) {
                case 0:
                    if (zzT(obj2, i4)) {
                        zzjp.zzo(obj, j4, zzjp.zza(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzT(obj2, i4)) {
                        zzjp.zzp(obj, j4, zzjp.zzb(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzT(obj2, i4)) {
                        zzjp.zzr(obj, j4, zzjp.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzT(obj2, i4)) {
                        zzjp.zzr(obj, j4, zzjp.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzT(obj2, i4)) {
                        zzjp.zzq(obj, j4, zzjp.zzc(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzT(obj2, i4)) {
                        zzjp.zzr(obj, j4, zzjp.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzT(obj2, i4)) {
                        zzjp.zzq(obj, j4, zzjp.zzc(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzT(obj2, i4)) {
                        zzjp.zzm(obj, j4, zzjp.zzw(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzT(obj2, i4)) {
                        zzjp.zzs(obj, j4, zzjp.zzf(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzJ(obj, obj2, i4);
                    break;
                case 10:
                    if (zzT(obj2, i4)) {
                        zzjp.zzs(obj, j4, zzjp.zzf(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzT(obj2, i4)) {
                        zzjp.zzq(obj, j4, zzjp.zzc(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzT(obj2, i4)) {
                        zzjp.zzq(obj, j4, zzjp.zzc(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzT(obj2, i4)) {
                        zzjp.zzq(obj, j4, zzjp.zzc(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzT(obj2, i4)) {
                        zzjp.zzr(obj, j4, zzjp.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzT(obj2, i4)) {
                        zzjp.zzq(obj, j4, zzjp.zzc(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzT(obj2, i4)) {
                        zzjp.zzr(obj, j4, zzjp.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzJ(obj, obj2, i4);
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
                    this.zzn.zzc(obj, obj2, j4);
                    break;
                case 50:
                    int i6 = zzin.zza;
                    zzjp.zzs(obj, j4, zzht.zzc(zzjp.zzf(obj, j4), zzjp.zzf(obj2, j4)));
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
                    if (zzX(obj2, i5, i4)) {
                        zzjp.zzs(obj, j4, zzjp.zzf(obj2, j4));
                        zzN(obj, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzK(obj, obj2, i4);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzX(obj2, i5, i4)) {
                        zzjp.zzs(obj, j4, zzjp.zzf(obj2, j4));
                        zzN(obj, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzK(obj, obj2, i4);
                    break;
            }
        }
        zzin.zzE(this.zzo, obj, obj2);
        if (this.zzh) {
            zzin.zzD(this.zzp, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x0651 A[LOOP:2: B:180:0x064d->B:182:0x0651, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0665  */
    @Override // com.google.android.recaptcha.internal.zzil
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r18, com.google.android.recaptcha.internal.zzik r19, com.google.android.recaptcha.internal.zzfz r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1784
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzh(java.lang.Object, com.google.android.recaptcha.internal.zzik, com.google.android.recaptcha.internal.zzfz):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02ed, code lost:
        if (r0 != r24) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02ef, code lost:
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r15;
        r1 = r23;
        r6 = r25;
        r7 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0300, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x032c, code lost:
        if (r0 != r14) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x034f, code lost:
        if (r0 != r14) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    @Override // com.google.android.recaptcha.internal.zzil
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.recaptcha.internal.zzem r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzem):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x09e8  */
    @Override // com.google.android.recaptcha.internal.zzil
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzj(java.lang.Object r18, com.google.android.recaptcha.internal.zzjx r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2852
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzj(java.lang.Object, com.google.android.recaptcha.internal.zzjx):void");
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final boolean zzk(Object obj, Object obj2) {
        boolean zzY;
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzz = zzz(i4);
            long j4 = zzz & 1048575;
            switch (zzy(zzz)) {
                case 0:
                    if (zzR(obj, obj2, i4) && Double.doubleToLongBits(zzjp.zza(obj, j4)) == Double.doubleToLongBits(zzjp.zza(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzR(obj, obj2, i4) && Float.floatToIntBits(zzjp.zzb(obj, j4)) == Float.floatToIntBits(zzjp.zzb(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzR(obj, obj2, i4) && zzjp.zzd(obj, j4) == zzjp.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzR(obj, obj2, i4) && zzjp.zzd(obj, j4) == zzjp.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzR(obj, obj2, i4) && zzjp.zzc(obj, j4) == zzjp.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzR(obj, obj2, i4) && zzjp.zzd(obj, j4) == zzjp.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzR(obj, obj2, i4) && zzjp.zzc(obj, j4) == zzjp.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzR(obj, obj2, i4) && zzjp.zzw(obj, j4) == zzjp.zzw(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzR(obj, obj2, i4) && zzin.zzY(zzjp.zzf(obj, j4), zzjp.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzR(obj, obj2, i4) && zzin.zzY(zzjp.zzf(obj, j4), zzjp.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzR(obj, obj2, i4) && zzin.zzY(zzjp.zzf(obj, j4), zzjp.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzR(obj, obj2, i4) && zzjp.zzc(obj, j4) == zzjp.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzR(obj, obj2, i4) && zzjp.zzc(obj, j4) == zzjp.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzR(obj, obj2, i4) && zzjp.zzc(obj, j4) == zzjp.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzR(obj, obj2, i4) && zzjp.zzd(obj, j4) == zzjp.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzR(obj, obj2, i4) && zzjp.zzc(obj, j4) == zzjp.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzR(obj, obj2, i4) && zzjp.zzd(obj, j4) == zzjp.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzR(obj, obj2, i4) && zzin.zzY(zzjp.zzf(obj, j4), zzjp.zzf(obj2, j4))) {
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
                    zzY = zzin.zzY(zzjp.zzf(obj, j4), zzjp.zzf(obj2, j4));
                    break;
                case 50:
                    zzY = zzin.zzY(zzjp.zzf(obj, j4), zzjp.zzf(obj2, j4));
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
                    long zzw = zzw(i4) & 1048575;
                    if (zzjp.zzc(obj, zzw) == zzjp.zzc(obj2, zzw) && zzin.zzY(zzjp.zzf(obj, j4), zzjp.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzY) {
                return false;
            }
        }
        if (!this.zzo.zzd(obj).equals(this.zzo.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzp.zzb(obj).equals(this.zzp.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final boolean zzl(Object obj) {
        int i4;
        int i5;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.zzl) {
            int i9 = this.zzk[i8];
            int i10 = this.zzc[i9];
            int zzz = zzz(i9);
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
            if ((268435456 & zzz) != 0 && !zzU(obj, i9, i4, i5, i13)) {
                return false;
            }
            int zzy = zzy(zzz);
            if (zzy != 9 && zzy != 17) {
                if (zzy != 27) {
                    if (zzy != 60 && zzy != 68) {
                        if (zzy != 49) {
                            if (zzy == 50 && !((zzhs) zzjp.zzf(obj, zzz & 1048575)).isEmpty()) {
                                zzhr zzhrVar = (zzhr) zzE(i9);
                                throw null;
                            }
                        }
                    } else if (zzX(obj, i10, i9) && !zzV(obj, zzz, zzC(i9))) {
                        return false;
                    }
                }
                List list = (List) zzjp.zzf(obj, zzz & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzil zzC = zzC(i9);
                    for (int i14 = 0; i14 < list.size(); i14++) {
                        if (!zzC.zzl(list.get(i14))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzU(obj, i9, i4, i5, i13) && !zzV(obj, zzz, zzC(i9))) {
                return false;
            }
            i8++;
            i6 = i4;
            i7 = i5;
        }
        if (this.zzh && !this.zzp.zzb(obj).zzk()) {
            return false;
        }
        return true;
    }
}
