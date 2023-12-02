package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgqz<T> implements zzgrp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgsq.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgqw zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzgqk zzm;
    private final zzgsg zzn;
    private final zzgoz zzo;
    private final int zzp;
    private final zzgrb zzq;
    private final zzgqr zzr;

    private zzgqz(int[] iArr, Object[] objArr, int i4, int i5, zzgqw zzgqwVar, int i6, boolean z3, int[] iArr2, int i7, int i8, zzgrb zzgrbVar, zzgqk zzgqkVar, zzgsg zzgsgVar, zzgoz zzgozVar, zzgqr zzgqrVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i4;
        this.zzf = i5;
        this.zzi = zzgqwVar instanceof zzgpm;
        this.zzp = i6;
        boolean z4 = false;
        if (zzgozVar != null && zzgozVar.zzh(zzgqwVar)) {
            z4 = true;
        }
        this.zzh = z4;
        this.zzj = iArr2;
        this.zzk = i7;
        this.zzl = i8;
        this.zzq = zzgrbVar;
        this.zzm = zzgqkVar;
        this.zzn = zzgsgVar;
        this.zzo = zzgozVar;
        this.zzg = zzgqwVar;
        this.zzr = zzgqrVar;
    }

    private static long zzA(Object obj, long j4) {
        return ((Long) zzgsq.zzh(obj, j4)).longValue();
    }

    private final zzgpq zzB(int i4) {
        int i5 = i4 / 3;
        return (zzgpq) this.zzd[i5 + i5 + 1];
    }

    private final zzgrp zzC(int i4) {
        int i5 = i4 / 3;
        int i6 = i5 + i5;
        zzgrp zzgrpVar = (zzgrp) this.zzd[i6];
        if (zzgrpVar != null) {
            return zzgrpVar;
        }
        zzgrp zzb2 = zzgre.zza().zzb((Class) this.zzd[i6 + 1]);
        this.zzd[i6] = zzb2;
        return zzb2;
    }

    private final Object zzD(Object obj, int i4, Object obj2, zzgsg zzgsgVar, Object obj3) {
        int i5 = this.zzc[i4];
        Object zzh = zzgsq.zzh(obj, zzz(i4) & 1048575);
        if (zzh == null) {
            return obj2;
        }
        if (zzB(i4) == null) {
            return obj2;
        }
        zzgqq zzgqqVar = (zzgqq) zzh;
        zzgqp zzgqpVar = (zzgqp) zzE(i4);
        throw null;
    }

    private final Object zzE(int i4) {
        int i5 = i4 / 3;
        return this.zzd[i5 + i5];
    }

    private final Object zzF(Object obj, int i4) {
        zzgrp zzC = zzC(i4);
        int zzz = zzz(i4) & 1048575;
        if (!zzS(obj, i4)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, zzz);
        if (zzV(object)) {
            return object;
        }
        Object zze = zzC.zze();
        if (object != null) {
            zzC.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzG(Object obj, int i4, int i5) {
        zzgrp zzC = zzC(i5);
        if (!zzW(obj, i4, i5)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, zzz(i5) & 1048575);
        if (zzV(object)) {
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
        if (zzV(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
    }

    private final void zzJ(Object obj, Object obj2, int i4) {
        if (!zzS(obj2, i4)) {
            return;
        }
        Unsafe unsafe = zzb;
        long zzz = zzz(i4) & 1048575;
        Object object = unsafe.getObject(obj2, zzz);
        if (object != null) {
            zzgrp zzC = zzC(i4);
            if (!zzS(obj, i4)) {
                if (!zzV(object)) {
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
            if (!zzV(object2)) {
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
        if (!zzW(obj2, i5, i4)) {
            return;
        }
        Unsafe unsafe = zzb;
        long zzz = zzz(i4) & 1048575;
        Object object = unsafe.getObject(obj2, zzz);
        if (object != null) {
            zzgrp zzC = zzC(i4);
            if (!zzW(obj, i5, i4)) {
                if (!zzV(object)) {
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
            if (!zzV(object2)) {
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

    private final void zzL(Object obj, int i4, zzgrh zzgrhVar) throws IOException {
        if (zzR(i4)) {
            zzgsq.zzv(obj, i4 & 1048575, zzgrhVar.zzs());
        } else if (this.zzi) {
            zzgsq.zzv(obj, i4 & 1048575, zzgrhVar.zzr());
        } else {
            zzgsq.zzv(obj, i4 & 1048575, zzgrhVar.zzp());
        }
    }

    private final void zzM(Object obj, int i4) {
        int zzw = zzw(i4);
        long j4 = 1048575 & zzw;
        if (j4 == 1048575) {
            return;
        }
        zzgsq.zzt(obj, j4, (1 << (zzw >>> 20)) | zzgsq.zzd(obj, j4));
    }

    private final void zzN(Object obj, int i4, int i5) {
        zzgsq.zzt(obj, zzw(i5) & 1048575, i4);
    }

    private final void zzO(Object obj, int i4, Object obj2) {
        zzb.putObject(obj, zzz(i4) & 1048575, obj2);
        zzM(obj, i4);
    }

    private final void zzP(Object obj, int i4, int i5, Object obj2) {
        zzb.putObject(obj, zzz(i5) & 1048575, obj2);
        zzN(obj, i4, i5);
    }

    private final boolean zzQ(Object obj, Object obj2, int i4) {
        if (zzS(obj, i4) == zzS(obj2, i4)) {
            return true;
        }
        return false;
    }

    private static boolean zzR(int i4) {
        if ((i4 & 536870912) != 0) {
            return true;
        }
        return false;
    }

    private final boolean zzS(Object obj, int i4) {
        int zzw = zzw(i4);
        long j4 = zzw & 1048575;
        if (j4 == 1048575) {
            int zzz = zzz(i4);
            long j5 = zzz & 1048575;
            switch (zzy(zzz)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzgsq.zzb(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzgsq.zzc(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzgsq.zzf(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzgsq.zzf(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzgsq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzgsq.zzf(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzgsq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzgsq.zzz(obj, j5);
                case 8:
                    Object zzh = zzgsq.zzh(obj, j5);
                    if (zzh instanceof String) {
                        if (((String) zzh).isEmpty()) {
                            return false;
                        }
                        return true;
                    } else if (zzh instanceof zzgoe) {
                        if (zzgoe.zzb.equals(zzh)) {
                            return false;
                        }
                        return true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (zzgsq.zzh(obj, j5) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzgoe.zzb.equals(zzgsq.zzh(obj, j5))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzgsq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzgsq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzgsq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzgsq.zzf(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzgsq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzgsq.zzf(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzgsq.zzh(obj, j5) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzgsq.zzd(obj, j4) & (1 << (zzw >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzT(Object obj, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return zzS(obj, i4);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzU(Object obj, int i4, zzgrp zzgrpVar) {
        return zzgrpVar.zzk(zzgsq.zzh(obj, i4 & 1048575));
    }

    private static boolean zzV(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgpm) {
            return ((zzgpm) obj).zzaY();
        }
        return true;
    }

    private final boolean zzW(Object obj, int i4, int i5) {
        if (zzgsq.zzd(obj, zzw(i5) & 1048575) == i4) {
            return true;
        }
        return false;
    }

    private static boolean zzX(Object obj, long j4) {
        return ((Boolean) zzgsq.zzh(obj, j4)).booleanValue();
    }

    private final void zzY(zzgou zzgouVar, int i4, Object obj, int i5) throws IOException {
        if (obj == null) {
            return;
        }
        zzgqp zzgqpVar = (zzgqp) zzE(i5);
        throw null;
    }

    private static final void zzZ(int i4, Object obj, zzgou zzgouVar) throws IOException {
        if (obj instanceof String) {
            zzgouVar.zzF(i4, (String) obj);
        } else {
            zzgouVar.zzd(i4, (zzgoe) obj);
        }
    }

    static zzgsh zzd(Object obj) {
        zzgpm zzgpmVar = (zzgpm) obj;
        zzgsh zzgshVar = zzgpmVar.zzc;
        if (zzgshVar == zzgsh.zzc()) {
            zzgsh zzf = zzgsh.zzf();
            zzgpmVar.zzc = zzf;
            return zzf;
        }
        return zzgshVar;
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
    public static com.google.android.gms.internal.ads.zzgqz zzl(java.lang.Class r30, com.google.android.gms.internal.ads.zzgqt r31, com.google.android.gms.internal.ads.zzgrb r32, com.google.android.gms.internal.ads.zzgqk r33, com.google.android.gms.internal.ads.zzgsg r34, com.google.android.gms.internal.ads.zzgoz r35, com.google.android.gms.internal.ads.zzgqr r36) {
        /*
            Method dump skipped, instructions count: 995
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzl(java.lang.Class, com.google.android.gms.internal.ads.zzgqt, com.google.android.gms.internal.ads.zzgrb, com.google.android.gms.internal.ads.zzgqk, com.google.android.gms.internal.ads.zzgsg, com.google.android.gms.internal.ads.zzgoz, com.google.android.gms.internal.ads.zzgqr):com.google.android.gms.internal.ads.zzgqz");
    }

    private static double zzn(Object obj, long j4) {
        return ((Double) zzgsq.zzh(obj, j4)).doubleValue();
    }

    private static float zzo(Object obj, long j4) {
        return ((Float) zzgsq.zzh(obj, j4)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i4;
        int zzA;
        int zzA2;
        int zzB;
        int zzA3;
        int zzA4;
        int zzA5;
        int zzA6;
        int zzt;
        int zzh;
        int zzA7;
        int zzA8;
        int i5;
        int zzA9;
        int zzA10;
        int zzA11;
        int zzA12;
        Unsafe unsafe = zzb;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1048575;
        int i10 = 0;
        while (i7 < this.zzc.length) {
            int zzz = zzz(i7);
            int[] iArr = this.zzc;
            int i11 = iArr[i7];
            int zzy = zzy(zzz);
            if (zzy <= 17) {
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
            long j4 = zzz & i6;
            switch (zzy) {
                case 0:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA = zzgot.zzA(i11 << 3);
                        zzA4 = zzA + 8;
                        i8 += zzA4;
                        break;
                    }
                case 1:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA2 = zzgot.zzA(i11 << 3);
                        zzA4 = zzA2 + 4;
                        i8 += zzA4;
                        break;
                    }
                case 2:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzB = zzgot.zzB(unsafe.getLong(obj, j4));
                        zzA3 = zzgot.zzA(i11 << 3);
                        i8 += zzA3 + zzB;
                        break;
                    }
                case 3:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzB = zzgot.zzB(unsafe.getLong(obj, j4));
                        zzA3 = zzgot.zzA(i11 << 3);
                        i8 += zzA3 + zzB;
                        break;
                    }
                case 4:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzB = zzgot.zzx(unsafe.getInt(obj, j4));
                        zzA3 = zzgot.zzA(i11 << 3);
                        i8 += zzA3 + zzB;
                        break;
                    }
                case 5:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA = zzgot.zzA(i11 << 3);
                        zzA4 = zzA + 8;
                        i8 += zzA4;
                        break;
                    }
                case 6:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA2 = zzgot.zzA(i11 << 3);
                        zzA4 = zzA2 + 4;
                        i8 += zzA4;
                        break;
                    }
                case 7:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA4 = zzgot.zzA(i11 << 3) + 1;
                        i8 += zzA4;
                        break;
                    }
                case 8:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j4);
                        if (object instanceof zzgoe) {
                            int i15 = zzgot.zzf;
                            int zzd = ((zzgoe) object).zzd();
                            zzA5 = zzgot.zzA(zzd) + zzd;
                            zzA6 = zzgot.zzA(i11 << 3);
                            zzA4 = zzA6 + zzA5;
                            i8 += zzA4;
                            break;
                        } else {
                            zzB = zzgot.zzz((String) object);
                            zzA3 = zzgot.zzA(i11 << 3);
                            i8 += zzA3 + zzB;
                            break;
                        }
                    }
                case 9:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA4 = zzgrr.zzn(i11, unsafe.getObject(obj, j4), zzC(i7));
                        i8 += zzA4;
                        break;
                    }
                case 10:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        int i16 = zzgot.zzf;
                        int zzd2 = ((zzgoe) unsafe.getObject(obj, j4)).zzd();
                        zzA5 = zzgot.zzA(zzd2) + zzd2;
                        zzA6 = zzgot.zzA(i11 << 3);
                        zzA4 = zzA6 + zzA5;
                        i8 += zzA4;
                        break;
                    }
                case 11:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzB = zzgot.zzA(unsafe.getInt(obj, j4));
                        zzA3 = zzgot.zzA(i11 << 3);
                        i8 += zzA3 + zzB;
                        break;
                    }
                case 12:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzB = zzgot.zzx(unsafe.getInt(obj, j4));
                        zzA3 = zzgot.zzA(i11 << 3);
                        i8 += zzA3 + zzB;
                        break;
                    }
                case 13:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA2 = zzgot.zzA(i11 << 3);
                        zzA4 = zzA2 + 4;
                        i8 += zzA4;
                        break;
                    }
                case 14:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA = zzgot.zzA(i11 << 3);
                        zzA4 = zzA + 8;
                        i8 += zzA4;
                        break;
                    }
                case 15:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        int i17 = unsafe.getInt(obj, j4);
                        zzA3 = zzgot.zzA(i11 << 3);
                        zzB = zzgot.zzA((i17 >> 31) ^ (i17 + i17));
                        i8 += zzA3 + zzB;
                        break;
                    }
                case 16:
                    if ((i4 & i10) == 0) {
                        break;
                    } else {
                        long j5 = unsafe.getLong(obj, j4);
                        i8 += zzgot.zzA(i11 << 3) + zzgot.zzB((j5 >> 63) ^ (j5 + j5));
                        break;
                    }
                case 17:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzA4 = zzgot.zzw(i11, (zzgqw) unsafe.getObject(obj, j4), zzC(i7));
                        i8 += zzA4;
                        break;
                    }
                case 18:
                    zzA4 = zzgrr.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzA4;
                    break;
                case 19:
                    zzA4 = zzgrr.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzA4;
                    break;
                case 20:
                    zzA4 = zzgrr.zzl(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzA4;
                    break;
                case 21:
                    zzA4 = zzgrr.zzw(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzA4;
                    break;
                case 22:
                    zzA4 = zzgrr.zzj(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzA4;
                    break;
                case 23:
                    zzA4 = zzgrr.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzA4;
                    break;
                case 24:
                    zzA4 = zzgrr.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzA4;
                    break;
                case 25:
                    zzA4 = zzgrr.zza(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzA4;
                    break;
                case 26:
                    zzt = zzgrr.zzt(i11, (List) unsafe.getObject(obj, j4));
                    i8 += zzt;
                    break;
                case 27:
                    zzt = zzgrr.zzo(i11, (List) unsafe.getObject(obj, j4), zzC(i7));
                    i8 += zzt;
                    break;
                case 28:
                    zzt = zzgrr.zzb(i11, (List) unsafe.getObject(obj, j4));
                    i8 += zzt;
                    break;
                case 29:
                    zzt = zzgrr.zzu(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 30:
                    zzt = zzgrr.zzc(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 31:
                    zzt = zzgrr.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 32:
                    zzt = zzgrr.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 33:
                    zzt = zzgrr.zzp(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 34:
                    zzt = zzgrr.zzr(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 35:
                    zzh = zzgrr.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 36:
                    zzh = zzgrr.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 37:
                    zzh = zzgrr.zzm((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 38:
                    zzh = zzgrr.zzx((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 39:
                    zzh = zzgrr.zzk((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 40:
                    zzh = zzgrr.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 41:
                    zzh = zzgrr.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 42:
                    int i18 = zzgrr.zza;
                    zzh = ((List) unsafe.getObject(obj, j4)).size();
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 43:
                    zzh = zzgrr.zzv((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 44:
                    zzh = zzgrr.zzd((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 45:
                    zzh = zzgrr.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 46:
                    zzh = zzgrr.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 47:
                    zzh = zzgrr.zzq((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 48:
                    zzh = zzgrr.zzs((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzA7 = zzgot.zzA(zzh);
                        zzA8 = zzgot.zzA(i11 << 3);
                        i5 = zzA8 + zzA7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 49:
                    zzt = zzgrr.zzi(i11, (List) unsafe.getObject(obj, j4), zzC(i7));
                    i8 += zzt;
                    break;
                case 50:
                    zzgqr.zza(i11, unsafe.getObject(obj, j4), zzE(i7));
                    break;
                case 51:
                    if (zzW(obj, i11, i7)) {
                        zzA9 = zzgot.zzA(i11 << 3);
                        zzt = zzA9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 52:
                    if (zzW(obj, i11, i7)) {
                        zzA10 = zzgot.zzA(i11 << 3);
                        zzt = zzA10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 53:
                    if (zzW(obj, i11, i7)) {
                        zzh = zzgot.zzB(zzA(obj, j4));
                        i5 = zzgot.zzA(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 54:
                    if (zzW(obj, i11, i7)) {
                        zzh = zzgot.zzB(zzA(obj, j4));
                        i5 = zzgot.zzA(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 55:
                    if (zzW(obj, i11, i7)) {
                        zzh = zzgot.zzx(zzq(obj, j4));
                        i5 = zzgot.zzA(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 56:
                    if (zzW(obj, i11, i7)) {
                        zzA9 = zzgot.zzA(i11 << 3);
                        zzt = zzA9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 57:
                    if (zzW(obj, i11, i7)) {
                        zzA10 = zzgot.zzA(i11 << 3);
                        zzt = zzA10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 58:
                    if (zzW(obj, i11, i7)) {
                        zzt = zzgot.zzA(i11 << 3) + 1;
                        i8 += zzt;
                    }
                    break;
                case 59:
                    if (zzW(obj, i11, i7)) {
                        Object object2 = unsafe.getObject(obj, j4);
                        if (object2 instanceof zzgoe) {
                            int i19 = zzgot.zzf;
                            int zzd3 = ((zzgoe) object2).zzd();
                            zzA11 = zzgot.zzA(zzd3) + zzd3;
                            zzA12 = zzgot.zzA(i11 << 3);
                            zzt = zzA12 + zzA11;
                            i8 += zzt;
                        } else {
                            zzh = zzgot.zzz((String) object2);
                            i5 = zzgot.zzA(i11 << 3);
                            i8 += i5 + zzh;
                        }
                    }
                    break;
                case 60:
                    if (zzW(obj, i11, i7)) {
                        zzt = zzgrr.zzn(i11, unsafe.getObject(obj, j4), zzC(i7));
                        i8 += zzt;
                    }
                    break;
                case 61:
                    if (zzW(obj, i11, i7)) {
                        int i20 = zzgot.zzf;
                        int zzd4 = ((zzgoe) unsafe.getObject(obj, j4)).zzd();
                        zzA11 = zzgot.zzA(zzd4) + zzd4;
                        zzA12 = zzgot.zzA(i11 << 3);
                        zzt = zzA12 + zzA11;
                        i8 += zzt;
                    }
                    break;
                case 62:
                    if (zzW(obj, i11, i7)) {
                        zzh = zzgot.zzA(zzq(obj, j4));
                        i5 = zzgot.zzA(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 63:
                    if (zzW(obj, i11, i7)) {
                        zzh = zzgot.zzx(zzq(obj, j4));
                        i5 = zzgot.zzA(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 64:
                    if (zzW(obj, i11, i7)) {
                        zzA10 = zzgot.zzA(i11 << 3);
                        zzt = zzA10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 65:
                    if (zzW(obj, i11, i7)) {
                        zzA9 = zzgot.zzA(i11 << 3);
                        zzt = zzA9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 66:
                    if (zzW(obj, i11, i7)) {
                        int zzq = zzq(obj, j4);
                        i5 = zzgot.zzA(i11 << 3);
                        zzh = zzgot.zzA((zzq >> 31) ^ (zzq + zzq));
                        i8 += i5 + zzh;
                    }
                    break;
                case 67:
                    if (zzW(obj, i11, i7)) {
                        long zzA13 = zzA(obj, j4);
                        i8 += zzgot.zzA(i11 << 3) + zzgot.zzB((zzA13 >> 63) ^ (zzA13 + zzA13));
                    }
                    break;
                case 68:
                    if (zzW(obj, i11, i7)) {
                        zzt = zzgot.zzw(i11, (zzgqw) unsafe.getObject(obj, j4), zzC(i7));
                        i8 += zzt;
                    }
                    break;
            }
            i7 += 3;
            i6 = 1048575;
        }
        zzgsg zzgsgVar = this.zzn;
        int zza2 = i8 + zzgsgVar.zza(zzgsgVar.zzd(obj));
        if (!this.zzh) {
            return zza2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private static int zzq(Object obj, long j4) {
        return ((Integer) zzgsq.zzh(obj, j4)).intValue();
    }

    private final int zzr(Object obj, byte[] bArr, int i4, int i5, int i6, long j4, zzgnq zzgnqVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzE = zzE(i6);
        Object object = unsafe.getObject(obj, j4);
        if (zzgqr.zzb(object)) {
            zzgqq zzb2 = zzgqq.zza().zzb();
            zzgqr.zzc(zzb2, object);
            unsafe.putObject(obj, j4, zzb2);
        }
        zzgqp zzgqpVar = (zzgqp) zzE;
        throw null;
    }

    private final int zzs(Object obj, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4, int i11, zzgnq zzgnqVar) throws IOException {
        Unsafe unsafe = zzb;
        long j5 = this.zzc[i11 + 2] & 1048575;
        switch (i10) {
            case 51:
                if (i8 == 1) {
                    unsafe.putObject(obj, j4, Double.valueOf(Double.longBitsToDouble(zzgnr.zzp(bArr, i4))));
                    int i12 = i4 + 8;
                    unsafe.putInt(obj, j5, i7);
                    return i12;
                }
                break;
            case 52:
                if (i8 == 5) {
                    unsafe.putObject(obj, j4, Float.valueOf(Float.intBitsToFloat(zzgnr.zzb(bArr, i4))));
                    int i13 = i4 + 4;
                    unsafe.putInt(obj, j5, i7);
                    return i13;
                }
                break;
            case 53:
            case 54:
                if (i8 == 0) {
                    int zzm = zzgnr.zzm(bArr, i4, zzgnqVar);
                    unsafe.putObject(obj, j4, Long.valueOf(zzgnqVar.zzb));
                    unsafe.putInt(obj, j5, i7);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i8 == 0) {
                    int zzj = zzgnr.zzj(bArr, i4, zzgnqVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(zzgnqVar.zza));
                    unsafe.putInt(obj, j5, i7);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i8 == 1) {
                    unsafe.putObject(obj, j4, Long.valueOf(zzgnr.zzp(bArr, i4)));
                    int i14 = i4 + 8;
                    unsafe.putInt(obj, j5, i7);
                    return i14;
                }
                break;
            case 57:
            case 64:
                if (i8 == 5) {
                    unsafe.putObject(obj, j4, Integer.valueOf(zzgnr.zzb(bArr, i4)));
                    int i15 = i4 + 4;
                    unsafe.putInt(obj, j5, i7);
                    return i15;
                }
                break;
            case 58:
                if (i8 == 0) {
                    int zzm2 = zzgnr.zzm(bArr, i4, zzgnqVar);
                    unsafe.putObject(obj, j4, Boolean.valueOf(zzgnqVar.zzb != 0));
                    unsafe.putInt(obj, j5, i7);
                    return zzm2;
                }
                break;
            case 59:
                if (i8 == 2) {
                    int zzj2 = zzgnr.zzj(bArr, i4, zzgnqVar);
                    int i16 = zzgnqVar.zza;
                    if (i16 == 0) {
                        unsafe.putObject(obj, j4, "");
                    } else if ((i9 & 536870912) != 0 && !zzgsv.zzj(bArr, zzj2, zzj2 + i16)) {
                        throw zzgpy.zzd();
                    } else {
                        unsafe.putObject(obj, j4, new String(bArr, zzj2, i16, zzgpw.zzb));
                        zzj2 += i16;
                    }
                    unsafe.putInt(obj, j5, i7);
                    return zzj2;
                }
                break;
            case 60:
                if (i8 == 2) {
                    Object zzG = zzG(obj, i7, i11);
                    int zzo = zzgnr.zzo(zzG, zzC(i11), bArr, i4, i5, zzgnqVar);
                    zzP(obj, i7, i11, zzG);
                    return zzo;
                }
                break;
            case 61:
                if (i8 == 2) {
                    int zza2 = zzgnr.zza(bArr, i4, zzgnqVar);
                    unsafe.putObject(obj, j4, zzgnqVar.zzc);
                    unsafe.putInt(obj, j5, i7);
                    return zza2;
                }
                break;
            case 63:
                if (i8 == 0) {
                    int zzj3 = zzgnr.zzj(bArr, i4, zzgnqVar);
                    int i17 = zzgnqVar.zza;
                    zzgpq zzB = zzB(i11);
                    if (zzB != null && !zzB.zza(i17)) {
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
                    int zzj4 = zzgnr.zzj(bArr, i4, zzgnqVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(zzgom.zzF(zzgnqVar.zza)));
                    unsafe.putInt(obj, j5, i7);
                    return zzj4;
                }
                break;
            case 67:
                if (i8 == 0) {
                    int zzm3 = zzgnr.zzm(bArr, i4, zzgnqVar);
                    unsafe.putObject(obj, j4, Long.valueOf(zzgom.zzG(zzgnqVar.zzb)));
                    unsafe.putInt(obj, j5, i7);
                    return zzm3;
                }
                break;
            case 68:
                if (i8 == 3) {
                    Object zzG2 = zzG(obj, i7, i11);
                    int zzn = zzgnr.zzn(zzG2, zzC(i11), bArr, i4, i5, (i6 & (-8)) | 4, zzgnqVar);
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
    private final int zzt(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.ads.zzgnq r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzgnq):int");
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

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final int zza(Object obj) {
        int zzA;
        int zzA2;
        int zzB;
        int zzA3;
        int zzA4;
        int zzA5;
        int zzA6;
        int zzn;
        int zzA7;
        int zzB2;
        int zzA8;
        int zzA9;
        zzgsw zzgswVar = zzgsw.zza;
        if (this.zzp - 1 != 0) {
            Unsafe unsafe = zzb;
            int i4 = 0;
            for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
                int zzz = zzz(i5);
                int zzy = zzy(zzz);
                int i6 = this.zzc[i5];
                int i7 = zzz & 1048575;
                if (zzy >= zzgpe.zzJ.zza() && zzy <= zzgpe.zzW.zza()) {
                    int i8 = this.zzc[i5 + 2];
                }
                long j4 = i7;
                switch (zzy) {
                    case 0:
                        if (zzS(obj, i5)) {
                            zzA = zzgot.zzA(i6 << 3);
                            zzn = zzA + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzS(obj, i5)) {
                            zzA2 = zzgot.zzA(i6 << 3);
                            zzn = zzA2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzS(obj, i5)) {
                            zzB = zzgot.zzB(zzgsq.zzf(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzS(obj, i5)) {
                            zzB = zzgot.zzB(zzgsq.zzf(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzS(obj, i5)) {
                            zzB = zzgot.zzx(zzgsq.zzd(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzS(obj, i5)) {
                            zzA = zzgot.zzA(i6 << 3);
                            zzn = zzA + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzS(obj, i5)) {
                            zzA2 = zzgot.zzA(i6 << 3);
                            zzn = zzA2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzS(obj, i5)) {
                            zzA4 = zzgot.zzA(i6 << 3);
                            zzn = zzA4 + 1;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzS(obj, i5)) {
                            Object zzh = zzgsq.zzh(obj, j4);
                            if (zzh instanceof zzgoe) {
                                int i9 = i6 << 3;
                                int i10 = zzgot.zzf;
                                int zzd = ((zzgoe) zzh).zzd();
                                zzA5 = zzgot.zzA(zzd) + zzd;
                                zzA6 = zzgot.zzA(i9);
                                zzn = zzA6 + zzA5;
                                i4 += zzn;
                                break;
                            } else {
                                zzB = zzgot.zzz((String) zzh);
                                zzA3 = zzgot.zzA(i6 << 3);
                                i4 += zzA3 + zzB;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (zzS(obj, i5)) {
                            zzn = zzgrr.zzn(i6, zzgsq.zzh(obj, j4), zzC(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzS(obj, i5)) {
                            int i11 = i6 << 3;
                            int i12 = zzgot.zzf;
                            int zzd2 = ((zzgoe) zzgsq.zzh(obj, j4)).zzd();
                            zzA5 = zzgot.zzA(zzd2) + zzd2;
                            zzA6 = zzgot.zzA(i11);
                            zzn = zzA6 + zzA5;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzS(obj, i5)) {
                            zzB = zzgot.zzA(zzgsq.zzd(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzS(obj, i5)) {
                            zzB = zzgot.zzx(zzgsq.zzd(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzS(obj, i5)) {
                            zzA2 = zzgot.zzA(i6 << 3);
                            zzn = zzA2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzS(obj, i5)) {
                            zzA = zzgot.zzA(i6 << 3);
                            zzn = zzA + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzS(obj, i5)) {
                            int zzd3 = zzgsq.zzd(obj, j4);
                            zzA3 = zzgot.zzA(i6 << 3);
                            zzB = zzgot.zzA((zzd3 >> 31) ^ (zzd3 + zzd3));
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzS(obj, i5)) {
                            long zzf = zzgsq.zzf(obj, j4);
                            zzA7 = zzgot.zzA(i6 << 3);
                            zzB2 = zzgot.zzB((zzf + zzf) ^ (zzf >> 63));
                            zzn = zzA7 + zzB2;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzS(obj, i5)) {
                            zzn = zzgot.zzw(i6, (zzgqw) zzgsq.zzh(obj, j4), zzC(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzn = zzgrr.zzg(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 19:
                        zzn = zzgrr.zze(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 20:
                        zzn = zzgrr.zzl(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 21:
                        zzn = zzgrr.zzw(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 22:
                        zzn = zzgrr.zzj(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 23:
                        zzn = zzgrr.zzg(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 24:
                        zzn = zzgrr.zze(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 25:
                        zzn = zzgrr.zza(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 26:
                        zzn = zzgrr.zzt(i6, (List) zzgsq.zzh(obj, j4));
                        i4 += zzn;
                        break;
                    case 27:
                        zzn = zzgrr.zzo(i6, (List) zzgsq.zzh(obj, j4), zzC(i5));
                        i4 += zzn;
                        break;
                    case 28:
                        zzn = zzgrr.zzb(i6, (List) zzgsq.zzh(obj, j4));
                        i4 += zzn;
                        break;
                    case 29:
                        zzn = zzgrr.zzu(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 30:
                        zzn = zzgrr.zzc(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 31:
                        zzn = zzgrr.zze(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 32:
                        zzn = zzgrr.zzg(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 33:
                        zzn = zzgrr.zzp(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 34:
                        zzn = zzgrr.zzr(i6, (List) zzgsq.zzh(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 35:
                        zzB = zzgrr.zzh((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i13 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i13);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzB = zzgrr.zzf((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i14 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i14);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzB = zzgrr.zzm((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i15 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i15);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzB = zzgrr.zzx((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i16 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i16);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzB = zzgrr.zzk((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i17 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i17);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzB = zzgrr.zzh((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i18 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i18);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzB = zzgrr.zzf((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i19 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i19);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i20 = zzgrr.zza;
                        zzB = ((List) unsafe.getObject(obj, j4)).size();
                        if (zzB > 0) {
                            int i21 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i21);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzB = zzgrr.zzv((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i22 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i22);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzB = zzgrr.zzd((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i23 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i23);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzB = zzgrr.zzf((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i24 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i24);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzB = zzgrr.zzh((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i25 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i25);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzB = zzgrr.zzq((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i26 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i26);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzB = zzgrr.zzs((List) unsafe.getObject(obj, j4));
                        if (zzB > 0) {
                            int i27 = i6 << 3;
                            zzA8 = zzgot.zzA(zzB);
                            zzA9 = zzgot.zzA(i27);
                            zzA3 = zzA9 + zzA8;
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        zzn = zzgrr.zzi(i6, (List) zzgsq.zzh(obj, j4), zzC(i5));
                        i4 += zzn;
                        break;
                    case 50:
                        zzgqr.zza(i6, zzgsq.zzh(obj, j4), zzE(i5));
                        break;
                    case 51:
                        if (zzW(obj, i6, i5)) {
                            zzA = zzgot.zzA(i6 << 3);
                            zzn = zzA + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzW(obj, i6, i5)) {
                            zzA2 = zzgot.zzA(i6 << 3);
                            zzn = zzA2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzW(obj, i6, i5)) {
                            zzB = zzgot.zzB(zzA(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzW(obj, i6, i5)) {
                            zzB = zzgot.zzB(zzA(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzW(obj, i6, i5)) {
                            zzB = zzgot.zzx(zzq(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzW(obj, i6, i5)) {
                            zzA = zzgot.zzA(i6 << 3);
                            zzn = zzA + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzW(obj, i6, i5)) {
                            zzA2 = zzgot.zzA(i6 << 3);
                            zzn = zzA2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzW(obj, i6, i5)) {
                            zzA4 = zzgot.zzA(i6 << 3);
                            zzn = zzA4 + 1;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzW(obj, i6, i5)) {
                            Object zzh2 = zzgsq.zzh(obj, j4);
                            if (zzh2 instanceof zzgoe) {
                                int i28 = i6 << 3;
                                int i29 = zzgot.zzf;
                                int zzd4 = ((zzgoe) zzh2).zzd();
                                zzA5 = zzgot.zzA(zzd4) + zzd4;
                                zzA6 = zzgot.zzA(i28);
                                zzn = zzA6 + zzA5;
                                i4 += zzn;
                                break;
                            } else {
                                zzB = zzgot.zzz((String) zzh2);
                                zzA3 = zzgot.zzA(i6 << 3);
                                i4 += zzA3 + zzB;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (zzW(obj, i6, i5)) {
                            zzn = zzgrr.zzn(i6, zzgsq.zzh(obj, j4), zzC(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzW(obj, i6, i5)) {
                            int i30 = i6 << 3;
                            int i31 = zzgot.zzf;
                            int zzd5 = ((zzgoe) zzgsq.zzh(obj, j4)).zzd();
                            zzA5 = zzgot.zzA(zzd5) + zzd5;
                            zzA6 = zzgot.zzA(i30);
                            zzn = zzA6 + zzA5;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzW(obj, i6, i5)) {
                            zzB = zzgot.zzA(zzq(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzW(obj, i6, i5)) {
                            zzB = zzgot.zzx(zzq(obj, j4));
                            zzA3 = zzgot.zzA(i6 << 3);
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzW(obj, i6, i5)) {
                            zzA2 = zzgot.zzA(i6 << 3);
                            zzn = zzA2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzW(obj, i6, i5)) {
                            zzA = zzgot.zzA(i6 << 3);
                            zzn = zzA + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzW(obj, i6, i5)) {
                            int zzq = zzq(obj, j4);
                            zzA3 = zzgot.zzA(i6 << 3);
                            zzB = zzgot.zzA((zzq >> 31) ^ (zzq + zzq));
                            i4 += zzA3 + zzB;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzW(obj, i6, i5)) {
                            long zzA10 = zzA(obj, j4);
                            zzA7 = zzgot.zzA(i6 << 3);
                            zzB2 = zzgot.zzB((zzA10 + zzA10) ^ (zzA10 >> 63));
                            zzn = zzA7 + zzB2;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzW(obj, i6, i5)) {
                            zzn = zzgot.zzw(i6, (zzgqw) zzgsq.zzh(obj, j4), zzC(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                }
            }
            zzgsg zzgsgVar = this.zzn;
            return i4 + zzgsgVar.zza(zzgsgVar.zzd(obj));
        }
        return zzp(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
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
                    doubleToLongBits = Double.doubleToLongBits(zzgsq.zzb(obj, j4));
                    byte[] bArr = zzgpw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 1:
                    i5 = i6 * 53;
                    floatToIntBits = Float.floatToIntBits(zzgsq.zzc(obj, j4));
                    i6 = i5 + floatToIntBits;
                    break;
                case 2:
                    i4 = i6 * 53;
                    doubleToLongBits = zzgsq.zzf(obj, j4);
                    byte[] bArr2 = zzgpw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 3:
                    i4 = i6 * 53;
                    doubleToLongBits = zzgsq.zzf(obj, j4);
                    byte[] bArr3 = zzgpw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 4:
                    i5 = i6 * 53;
                    floatToIntBits = zzgsq.zzd(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 5:
                    i4 = i6 * 53;
                    doubleToLongBits = zzgsq.zzf(obj, j4);
                    byte[] bArr4 = zzgpw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 6:
                    i5 = i6 * 53;
                    floatToIntBits = zzgsq.zzd(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 7:
                    i5 = i6 * 53;
                    floatToIntBits = zzgpw.zza(zzgsq.zzz(obj, j4));
                    i6 = i5 + floatToIntBits;
                    break;
                case 8:
                    i5 = i6 * 53;
                    floatToIntBits = ((String) zzgsq.zzh(obj, j4)).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 9:
                    Object zzh = zzgsq.zzh(obj, j4);
                    if (zzh != null) {
                        i9 = zzh.hashCode();
                    }
                    i6 = (i6 * 53) + i9;
                    break;
                case 10:
                    i5 = i6 * 53;
                    floatToIntBits = zzgsq.zzh(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 11:
                    i5 = i6 * 53;
                    floatToIntBits = zzgsq.zzd(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 12:
                    i5 = i6 * 53;
                    floatToIntBits = zzgsq.zzd(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 13:
                    i5 = i6 * 53;
                    floatToIntBits = zzgsq.zzd(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 14:
                    i4 = i6 * 53;
                    doubleToLongBits = zzgsq.zzf(obj, j4);
                    byte[] bArr5 = zzgpw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 15:
                    i5 = i6 * 53;
                    floatToIntBits = zzgsq.zzd(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 16:
                    i4 = i6 * 53;
                    doubleToLongBits = zzgsq.zzf(obj, j4);
                    byte[] bArr6 = zzgpw.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 17:
                    Object zzh2 = zzgsq.zzh(obj, j4);
                    if (zzh2 != null) {
                        i9 = zzh2.hashCode();
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
                    floatToIntBits = zzgsq.zzh(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 50:
                    i5 = i6 * 53;
                    floatToIntBits = zzgsq.zzh(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 51:
                    if (zzW(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j4));
                        byte[] bArr7 = zzgpw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = Float.floatToIntBits(zzo(obj, j4));
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzW(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr8 = zzgpw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzW(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr9 = zzgpw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzW(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr10 = zzgpw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzgpw.zza(zzX(obj, j4));
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = ((String) zzgsq.zzh(obj, j4)).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzgsq.zzh(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzgsq.zzh(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzW(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr11 = zzgpw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzq(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzW(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzA(obj, j4);
                        byte[] bArr12 = zzgpw.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzW(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzgsq.zzh(obj, j4).hashCode();
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
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0407, code lost:
        if (r0 == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0409, code lost:
        r26.putInt(r12, r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x040f, code lost:
        r10 = r8.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0414, code lost:
        if (r10 >= r8.zzl) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0416, code lost:
        zzD(r28, r8.zzj[r10], null, r8.zzn, r28);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0429, code lost:
        if (r9 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x042d, code lost:
        if (r6 != r31) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0434, code lost:
        throw com.google.android.gms.internal.ads.zzgpy.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0437, code lost:
        if (r6 > r31) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0439, code lost:
        if (r7 != r9) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x043b, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0440, code lost:
        throw com.google.android.gms.internal.ads.zzgpy.zzg();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.ads.zzgnq r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgnq):int");
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final Object zze() {
        return ((zzgpm) this.zzg).zzaD();
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final void zzf(Object obj) {
        if (!zzV(obj)) {
            return;
        }
        if (obj instanceof zzgpm) {
            zzgpm zzgpmVar = (zzgpm) obj;
            zzgpmVar.zzaV(Integer.MAX_VALUE);
            zzgpmVar.zza = 0;
            zzgpmVar.zzaT();
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
                            this.zzm.zzb(obj, j4);
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j4);
                            if (object != null) {
                                ((zzgqq) object).zzc();
                                unsafe.putObject(obj, j4, object);
                                break;
                            } else {
                                break;
                            }
                    }
                } else if (zzW(obj, this.zzc[i4], i4)) {
                    zzC(i4).zzf(zzb.getObject(obj, j4));
                }
            }
            if (zzS(obj, i4)) {
                zzC(i4).zzf(zzb.getObject(obj, j4));
            }
        }
        this.zzn.zzm(obj);
        if (this.zzh) {
            this.zzo.zze(obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final void zzg(Object obj, Object obj2) {
        zzI(obj);
        obj2.getClass();
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzz = zzz(i4);
            int i5 = this.zzc[i4];
            long j4 = 1048575 & zzz;
            switch (zzy(zzz)) {
                case 0:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzr(obj, j4, zzgsq.zzb(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzs(obj, j4, zzgsq.zzc(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzu(obj, j4, zzgsq.zzf(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzu(obj, j4, zzgsq.zzf(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzt(obj, j4, zzgsq.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzu(obj, j4, zzgsq.zzf(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzt(obj, j4, zzgsq.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzp(obj, j4, zzgsq.zzz(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzv(obj, j4, zzgsq.zzh(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzJ(obj, obj2, i4);
                    break;
                case 10:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzv(obj, j4, zzgsq.zzh(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzt(obj, j4, zzgsq.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzt(obj, j4, zzgsq.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzt(obj, j4, zzgsq.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzu(obj, j4, zzgsq.zzf(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzt(obj, j4, zzgsq.zzd(obj2, j4));
                        zzM(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzS(obj2, i4)) {
                        zzgsq.zzu(obj, j4, zzgsq.zzf(obj2, j4));
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
                    this.zzm.zzc(obj, obj2, j4);
                    break;
                case 50:
                    int i6 = zzgrr.zza;
                    zzgsq.zzv(obj, j4, zzgqr.zzc(zzgsq.zzh(obj, j4), zzgsq.zzh(obj2, j4)));
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
                    if (zzW(obj2, i5, i4)) {
                        zzgsq.zzv(obj, j4, zzgsq.zzh(obj2, j4));
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
                    if (zzW(obj2, i5, i4)) {
                        zzgsq.zzv(obj, j4, zzgsq.zzh(obj2, j4));
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
        zzgrr.zzC(this.zzn, obj, obj2);
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
    @Override // com.google.android.gms.internal.ads.zzgrp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.ads.zzgrh r19, com.google.android.gms.internal.ads.zzgoy r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzgrh, com.google.android.gms.internal.ads.zzgoy):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02e6, code lost:
        if (r0 != r15) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x030a, code lost:
        if (r0 != r15) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02a3, code lost:
        if (r0 != r5) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02a5, code lost:
        r15 = r28;
        r14 = r29;
        r12 = r30;
        r13 = r32;
        r11 = r33;
        r1 = r19;
        r2 = r22;
        r6 = r25;
        r7 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02b9, code lost:
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzgrp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r29, byte[] r30, int r31, int r32, com.google.android.gms.internal.ads.zzgnq r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 906
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzi(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzgnq):void");
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzE;
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzz = zzz(i4);
            long j4 = zzz & 1048575;
            switch (zzy(zzz)) {
                case 0:
                    if (zzQ(obj, obj2, i4) && Double.doubleToLongBits(zzgsq.zzb(obj, j4)) == Double.doubleToLongBits(zzgsq.zzb(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzQ(obj, obj2, i4) && Float.floatToIntBits(zzgsq.zzc(obj, j4)) == Float.floatToIntBits(zzgsq.zzc(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzf(obj, j4) == zzgsq.zzf(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzf(obj, j4) == zzgsq.zzf(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzd(obj, j4) == zzgsq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzf(obj, j4) == zzgsq.zzf(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzd(obj, j4) == zzgsq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzz(obj, j4) == zzgsq.zzz(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzQ(obj, obj2, i4) && zzgrr.zzE(zzgsq.zzh(obj, j4), zzgsq.zzh(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzQ(obj, obj2, i4) && zzgrr.zzE(zzgsq.zzh(obj, j4), zzgsq.zzh(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzQ(obj, obj2, i4) && zzgrr.zzE(zzgsq.zzh(obj, j4), zzgsq.zzh(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzd(obj, j4) == zzgsq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzd(obj, j4) == zzgsq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzd(obj, j4) == zzgsq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzf(obj, j4) == zzgsq.zzf(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzd(obj, j4) == zzgsq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzQ(obj, obj2, i4) && zzgsq.zzf(obj, j4) == zzgsq.zzf(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzQ(obj, obj2, i4) && zzgrr.zzE(zzgsq.zzh(obj, j4), zzgsq.zzh(obj2, j4))) {
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
                    zzE = zzgrr.zzE(zzgsq.zzh(obj, j4), zzgsq.zzh(obj2, j4));
                    break;
                case 50:
                    zzE = zzgrr.zzE(zzgsq.zzh(obj, j4), zzgsq.zzh(obj2, j4));
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
                    if (zzgsq.zzd(obj, zzw) == zzgsq.zzd(obj2, zzw) && zzgrr.zzE(zzgsq.zzh(obj, j4), zzgsq.zzh(obj2, j4))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzE) {
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

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final boolean zzk(Object obj) {
        int i4;
        int i5;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.zzk) {
            int i9 = this.zzj[i8];
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
            if ((268435456 & zzz) != 0 && !zzT(obj, i9, i4, i5, i13)) {
                return false;
            }
            int zzy = zzy(zzz);
            if (zzy != 9 && zzy != 17) {
                if (zzy != 27) {
                    if (zzy != 60 && zzy != 68) {
                        if (zzy != 49) {
                            if (zzy == 50 && !((zzgqq) zzgsq.zzh(obj, zzz & 1048575)).isEmpty()) {
                                zzgqp zzgqpVar = (zzgqp) zzE(i9);
                                throw null;
                            }
                        }
                    } else if (zzW(obj, i10, i9) && !zzU(obj, zzz, zzC(i9))) {
                        return false;
                    }
                }
                List list = (List) zzgsq.zzh(obj, zzz & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgrp zzC = zzC(i9);
                    for (int i14 = 0; i14 < list.size(); i14++) {
                        if (!zzC.zzk(list.get(i14))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzT(obj, i9, i4, i5, i13) && !zzU(obj, zzz, zzC(i9))) {
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

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final void zzm(Object obj, zzgou zzgouVar) throws IOException {
        int i4;
        zzgsw zzgswVar = zzgsw.zza;
        int i5 = 1048575;
        if (this.zzp - 1 != 0) {
            if (!this.zzh) {
                int length = this.zzc.length;
                for (int i6 = 0; i6 < length; i6 += 3) {
                    int zzz = zzz(i6);
                    int i7 = this.zzc[i6];
                    switch (zzy(zzz)) {
                        case 0:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzf(i7, zzgsq.zzb(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzo(i7, zzgsq.zzc(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzt(i7, zzgsq.zzf(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzJ(i7, zzgsq.zzf(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzr(i7, zzgsq.zzd(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzm(i7, zzgsq.zzf(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzk(i7, zzgsq.zzd(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzb(i7, zzgsq.zzz(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (zzS(obj, i6)) {
                                zzZ(i7, zzgsq.zzh(obj, zzz & 1048575), zzgouVar);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzv(i7, zzgsq.zzh(obj, zzz & 1048575), zzC(i6));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzd(i7, (zzgoe) zzgsq.zzh(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzH(i7, zzgsq.zzd(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzi(i7, zzgsq.zzd(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzw(i7, zzgsq.zzd(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzy(i7, zzgsq.zzf(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzA(i7, zzgsq.zzd(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzC(i7, zzgsq.zzf(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (zzS(obj, i6)) {
                                zzgouVar.zzq(i7, zzgsq.zzh(obj, zzz & 1048575), zzC(i6));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            zzgrr.zzH(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 19:
                            zzgrr.zzL(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 20:
                            zzgrr.zzO(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 21:
                            zzgrr.zzW(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 22:
                            zzgrr.zzN(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 23:
                            zzgrr.zzK(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 24:
                            zzgrr.zzJ(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 25:
                            zzgrr.zzF(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 26:
                            zzgrr.zzU(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar);
                            break;
                        case 27:
                            zzgrr.zzP(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, zzC(i6));
                            break;
                        case 28:
                            zzgrr.zzG(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar);
                            break;
                        case 29:
                            zzgrr.zzV(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 30:
                            zzgrr.zzI(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 31:
                            zzgrr.zzQ(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 32:
                            zzgrr.zzR(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 33:
                            zzgrr.zzS(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 34:
                            zzgrr.zzT(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, false);
                            break;
                        case 35:
                            zzgrr.zzH(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 36:
                            zzgrr.zzL(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 37:
                            zzgrr.zzO(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 38:
                            zzgrr.zzW(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 39:
                            zzgrr.zzN(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 40:
                            zzgrr.zzK(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 41:
                            zzgrr.zzJ(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 42:
                            zzgrr.zzF(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 43:
                            zzgrr.zzV(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 44:
                            zzgrr.zzI(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 45:
                            zzgrr.zzQ(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 46:
                            zzgrr.zzR(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 47:
                            zzgrr.zzS(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 48:
                            zzgrr.zzT(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, true);
                            break;
                        case 49:
                            zzgrr.zzM(i7, (List) zzgsq.zzh(obj, zzz & 1048575), zzgouVar, zzC(i6));
                            break;
                        case 50:
                            zzY(zzgouVar, i7, zzgsq.zzh(obj, zzz & 1048575), i6);
                            break;
                        case 51:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzf(i7, zzn(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzo(i7, zzo(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzt(i7, zzA(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzJ(i7, zzA(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzr(i7, zzq(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzm(i7, zzA(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzk(i7, zzq(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzb(i7, zzX(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (zzW(obj, i7, i6)) {
                                zzZ(i7, zzgsq.zzh(obj, zzz & 1048575), zzgouVar);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzv(i7, zzgsq.zzh(obj, zzz & 1048575), zzC(i6));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzd(i7, (zzgoe) zzgsq.zzh(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzH(i7, zzq(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzi(i7, zzq(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzw(i7, zzq(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzy(i7, zzA(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzA(i7, zzq(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzC(i7, zzA(obj, zzz & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (zzW(obj, i7, i6)) {
                                zzgouVar.zzq(i7, zzgsq.zzh(obj, zzz & 1048575), zzC(i6));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                zzgsg zzgsgVar = this.zzn;
                zzgsgVar.zzr(zzgsgVar.zzd(obj), zzgouVar);
                return;
            }
            this.zzo.zza(obj);
            throw null;
        } else if (!this.zzh) {
            int length2 = this.zzc.length;
            Unsafe unsafe = zzb;
            int i8 = 0;
            int i9 = 1048575;
            int i10 = 0;
            while (i8 < length2) {
                int zzz2 = zzz(i8);
                int[] iArr = this.zzc;
                int i11 = iArr[i8];
                int zzy = zzy(zzz2);
                if (zzy <= 17) {
                    int i12 = iArr[i8 + 2];
                    int i13 = i12 & i5;
                    if (i13 != i9) {
                        i10 = unsafe.getInt(obj, i13);
                        i9 = i13;
                    }
                    i4 = 1 << (i12 >>> 20);
                } else {
                    i4 = 0;
                }
                long j4 = zzz2 & i5;
                switch (zzy) {
                    case 0:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzf(i11, zzgsq.zzb(obj, j4));
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 1:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzo(i11, zzgsq.zzc(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 2:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzt(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 3:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzJ(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 4:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzr(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 5:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzm(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 6:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzk(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 7:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzb(i11, zzgsq.zzz(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 8:
                        if ((i10 & i4) != 0) {
                            zzZ(i11, unsafe.getObject(obj, j4), zzgouVar);
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 9:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzv(i11, unsafe.getObject(obj, j4), zzC(i8));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 10:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzd(i11, (zzgoe) unsafe.getObject(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 11:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzH(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 12:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzi(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 13:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzw(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 14:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzy(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 15:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzA(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 16:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzC(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 17:
                        if ((i10 & i4) != 0) {
                            zzgouVar.zzq(i11, unsafe.getObject(obj, j4), zzC(i8));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 18:
                        zzgrr.zzH(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 19:
                        zzgrr.zzL(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 20:
                        zzgrr.zzO(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 21:
                        zzgrr.zzW(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 22:
                        zzgrr.zzN(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 23:
                        zzgrr.zzK(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 24:
                        zzgrr.zzJ(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 25:
                        zzgrr.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 26:
                        zzgrr.zzU(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar);
                        break;
                    case 27:
                        zzgrr.zzP(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, zzC(i8));
                        break;
                    case 28:
                        zzgrr.zzG(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar);
                        break;
                    case 29:
                        zzgrr.zzV(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        break;
                    case 30:
                        zzgrr.zzI(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        break;
                    case 31:
                        zzgrr.zzQ(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        break;
                    case 32:
                        zzgrr.zzR(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        break;
                    case 33:
                        zzgrr.zzS(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        break;
                    case 34:
                        zzgrr.zzT(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, false);
                        break;
                    case 35:
                        zzgrr.zzH(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 36:
                        zzgrr.zzL(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 37:
                        zzgrr.zzO(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 38:
                        zzgrr.zzW(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 39:
                        zzgrr.zzN(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 40:
                        zzgrr.zzK(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 41:
                        zzgrr.zzJ(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 42:
                        zzgrr.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 43:
                        zzgrr.zzV(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 44:
                        zzgrr.zzI(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 45:
                        zzgrr.zzQ(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 46:
                        zzgrr.zzR(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 47:
                        zzgrr.zzS(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 48:
                        zzgrr.zzT(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, true);
                        break;
                    case 49:
                        zzgrr.zzM(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzgouVar, zzC(i8));
                        break;
                    case 50:
                        zzY(zzgouVar, i11, unsafe.getObject(obj, j4), i8);
                        break;
                    case 51:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzf(i11, zzn(obj, j4));
                            break;
                        }
                        break;
                    case 52:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzo(i11, zzo(obj, j4));
                            break;
                        }
                        break;
                    case 53:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzt(i11, zzA(obj, j4));
                            break;
                        }
                        break;
                    case 54:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzJ(i11, zzA(obj, j4));
                            break;
                        }
                        break;
                    case 55:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzr(i11, zzq(obj, j4));
                            break;
                        }
                        break;
                    case 56:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzm(i11, zzA(obj, j4));
                            break;
                        }
                        break;
                    case 57:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzk(i11, zzq(obj, j4));
                            break;
                        }
                        break;
                    case 58:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzb(i11, zzX(obj, j4));
                            break;
                        }
                        break;
                    case 59:
                        if (zzW(obj, i11, i8)) {
                            zzZ(i11, unsafe.getObject(obj, j4), zzgouVar);
                            break;
                        }
                        break;
                    case 60:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzv(i11, unsafe.getObject(obj, j4), zzC(i8));
                            break;
                        }
                        break;
                    case 61:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzd(i11, (zzgoe) unsafe.getObject(obj, j4));
                            break;
                        }
                        break;
                    case 62:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzH(i11, zzq(obj, j4));
                            break;
                        }
                        break;
                    case 63:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzi(i11, zzq(obj, j4));
                            break;
                        }
                        break;
                    case 64:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzw(i11, zzq(obj, j4));
                            break;
                        }
                        break;
                    case 65:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzy(i11, zzA(obj, j4));
                            break;
                        }
                        break;
                    case 66:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzA(i11, zzq(obj, j4));
                            break;
                        }
                        break;
                    case 67:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzC(i11, zzA(obj, j4));
                            break;
                        }
                        break;
                    case 68:
                        if (zzW(obj, i11, i8)) {
                            zzgouVar.zzq(i11, unsafe.getObject(obj, j4), zzC(i8));
                            break;
                        }
                        break;
                }
                i8 += 3;
                i5 = 1048575;
            }
            zzgsg zzgsgVar2 = this.zzn;
            zzgsgVar2.zzr(zzgsgVar2.zzd(obj), zzgouVar);
        } else {
            this.zzo.zza(obj);
            throw null;
        }
    }
}
