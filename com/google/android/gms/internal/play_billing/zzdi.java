package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzdi<T> implements zzdp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzeq.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzdf zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzct zzm;
    private final zzeg zzn;
    private final zzbo zzo;
    private final zzdk zzp;
    private final zzda zzq;

    private zzdi(int[] iArr, Object[] objArr, int i4, int i5, zzdf zzdfVar, boolean z3, boolean z4, int[] iArr2, int i6, int i7, zzdk zzdkVar, zzct zzctVar, zzeg zzegVar, zzbo zzboVar, zzda zzdaVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i4;
        this.zzf = i5;
        this.zzi = z3;
        boolean z5 = false;
        if (zzboVar != null && zzboVar.zzc(zzdfVar)) {
            z5 = true;
        }
        this.zzh = z5;
        this.zzj = iArr2;
        this.zzk = i6;
        this.zzl = i7;
        this.zzp = zzdkVar;
        this.zzm = zzctVar;
        this.zzn = zzegVar;
        this.zzo = zzboVar;
        this.zzg = zzdfVar;
        this.zzq = zzdaVar;
    }

    private final zzce zzA(int i4) {
        int i5 = i4 / 3;
        return (zzce) this.zzd[i5 + i5 + 1];
    }

    private final zzdp zzB(int i4) {
        int i5 = i4 / 3;
        int i6 = i5 + i5;
        zzdp zzdpVar = (zzdp) this.zzd[i6];
        if (zzdpVar != null) {
            return zzdpVar;
        }
        zzdp zzb2 = zzdn.zza().zzb((Class) this.zzd[i6 + 1]);
        this.zzd[i6] = zzb2;
        return zzb2;
    }

    private final Object zzC(int i4) {
        int i5 = i4 / 3;
        return this.zzd[i5 + i5];
    }

    private final Object zzD(Object obj, int i4) {
        zzdp zzB = zzB(i4);
        int zzy = zzy(i4) & 1048575;
        if (!zzP(obj, i4)) {
            return zzB.zze();
        }
        Object object = zzb.getObject(obj, zzy);
        if (zzS(object)) {
            return object;
        }
        Object zze = zzB.zze();
        if (object != null) {
            zzB.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzE(Object obj, int i4, int i5) {
        zzdp zzB = zzB(i5);
        if (!zzT(obj, i4, i5)) {
            return zzB.zze();
        }
        Object object = zzb.getObject(obj, zzy(i5) & 1048575);
        if (zzS(object)) {
            return object;
        }
        Object zze = zzB.zze();
        if (object != null) {
            zzB.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzF(Class cls, String str) {
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

    private static void zzG(Object obj) {
        if (zzS(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
    }

    private final void zzH(Object obj, Object obj2, int i4) {
        if (!zzP(obj2, i4)) {
            return;
        }
        Unsafe unsafe = zzb;
        long zzy = zzy(i4) & 1048575;
        Object object = unsafe.getObject(obj2, zzy);
        if (object != null) {
            zzdp zzB = zzB(i4);
            if (!zzP(obj, i4)) {
                if (!zzS(object)) {
                    unsafe.putObject(obj, zzy, object);
                } else {
                    Object zze = zzB.zze();
                    zzB.zzg(zze, object);
                    unsafe.putObject(obj, zzy, zze);
                }
                zzJ(obj, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzy);
            if (!zzS(object2)) {
                Object zze2 = zzB.zze();
                zzB.zzg(zze2, object2);
                unsafe.putObject(obj, zzy, zze2);
                object2 = zze2;
            }
            zzB.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i4] + " is present but null: " + obj2.toString());
    }

    private final void zzI(Object obj, Object obj2, int i4) {
        int i5 = this.zzc[i4];
        if (!zzT(obj2, i5, i4)) {
            return;
        }
        Unsafe unsafe = zzb;
        long zzy = zzy(i4) & 1048575;
        Object object = unsafe.getObject(obj2, zzy);
        if (object != null) {
            zzdp zzB = zzB(i4);
            if (!zzT(obj, i5, i4)) {
                if (!zzS(object)) {
                    unsafe.putObject(obj, zzy, object);
                } else {
                    Object zze = zzB.zze();
                    zzB.zzg(zze, object);
                    unsafe.putObject(obj, zzy, zze);
                }
                zzK(obj, i5, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzy);
            if (!zzS(object2)) {
                Object zze2 = zzB.zze();
                zzB.zzg(zze2, object2);
                unsafe.putObject(obj, zzy, zze2);
                object2 = zze2;
            }
            zzB.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i4] + " is present but null: " + obj2.toString());
    }

    private final void zzJ(Object obj, int i4) {
        int zzv = zzv(i4);
        long j4 = 1048575 & zzv;
        if (j4 == 1048575) {
            return;
        }
        zzeq.zzq(obj, j4, (1 << (zzv >>> 20)) | zzeq.zzc(obj, j4));
    }

    private final void zzK(Object obj, int i4, int i5) {
        zzeq.zzq(obj, zzv(i5) & 1048575, i4);
    }

    private final void zzL(Object obj, int i4, Object obj2) {
        zzb.putObject(obj, zzy(i4) & 1048575, obj2);
        zzJ(obj, i4);
    }

    private final void zzM(Object obj, int i4, int i5, Object obj2) {
        zzb.putObject(obj, zzy(i5) & 1048575, obj2);
        zzK(obj, i4, i5);
    }

    private final void zzN(zzey zzeyVar, int i4, Object obj, int i5) throws IOException {
        if (obj == null) {
            return;
        }
        zzcy zzcyVar = (zzcy) zzC(i5);
        throw null;
    }

    private final boolean zzO(Object obj, Object obj2, int i4) {
        if (zzP(obj, i4) == zzP(obj2, i4)) {
            return true;
        }
        return false;
    }

    private final boolean zzP(Object obj, int i4) {
        int zzv = zzv(i4);
        long j4 = zzv & 1048575;
        if (j4 == 1048575) {
            int zzy = zzy(i4);
            long j5 = zzy & 1048575;
            switch (zzx(zzy)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzeq.zza(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzeq.zzb(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzeq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzeq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzeq.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzeq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzeq.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzeq.zzw(obj, j5);
                case 8:
                    Object zzf = zzeq.zzf(obj, j5);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    } else if (zzf instanceof zzba) {
                        if (zzba.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (zzeq.zzf(obj, j5) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzba.zzb.equals(zzeq.zzf(obj, j5))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzeq.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzeq.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzeq.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzeq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzeq.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzeq.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzeq.zzf(obj, j5) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzeq.zzc(obj, j4) & (1 << (zzv >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzQ(Object obj, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return zzP(obj, i4);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzR(Object obj, int i4, zzdp zzdpVar) {
        return zzdpVar.zzk(zzeq.zzf(obj, i4 & 1048575));
    }

    private static boolean zzS(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzcb) {
            return ((zzcb) obj).zzs();
        }
        return true;
    }

    private final boolean zzT(Object obj, int i4, int i5) {
        if (zzeq.zzc(obj, zzv(i5) & 1048575) == i4) {
            return true;
        }
        return false;
    }

    private static boolean zzU(Object obj, long j4) {
        return ((Boolean) zzeq.zzf(obj, j4)).booleanValue();
    }

    private static final void zzV(int i4, Object obj, zzey zzeyVar) throws IOException {
        if (obj instanceof String) {
            zzeyVar.zzF(i4, (String) obj);
        } else {
            zzeyVar.zzd(i4, (zzba) obj);
        }
    }

    static zzeh zzd(Object obj) {
        zzcb zzcbVar = (zzcb) obj;
        zzeh zzehVar = zzcbVar.zzc;
        if (zzehVar == zzeh.zzc()) {
            zzeh zzf = zzeh.zzf();
            zzcbVar.zzc = zzf;
            return zzf;
        }
        return zzehVar;
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
    public static com.google.android.gms.internal.play_billing.zzdi zzl(java.lang.Class r31, com.google.android.gms.internal.play_billing.zzdc r32, com.google.android.gms.internal.play_billing.zzdk r33, com.google.android.gms.internal.play_billing.zzct r34, com.google.android.gms.internal.play_billing.zzeg r35, com.google.android.gms.internal.play_billing.zzbo r36, com.google.android.gms.internal.play_billing.zzda r37) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdi.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzdc, com.google.android.gms.internal.play_billing.zzdk, com.google.android.gms.internal.play_billing.zzct, com.google.android.gms.internal.play_billing.zzeg, com.google.android.gms.internal.play_billing.zzbo, com.google.android.gms.internal.play_billing.zzda):com.google.android.gms.internal.play_billing.zzdi");
    }

    private static double zzm(Object obj, long j4) {
        return ((Double) zzeq.zzf(obj, j4)).doubleValue();
    }

    private static float zzn(Object obj, long j4) {
        return ((Float) zzeq.zzf(obj, j4)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzo(Object obj) {
        int i4;
        int zzx;
        int zzx2;
        int zzy;
        int zzx3;
        int zzx4;
        int zzx5;
        int zzx6;
        int zzt;
        int zzh;
        int zzx7;
        int zzx8;
        int i5;
        int zzx9;
        int zzx10;
        int zzx11;
        int zzx12;
        Unsafe unsafe = zzb;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1048575;
        int i10 = 0;
        while (i7 < this.zzc.length) {
            int zzy2 = zzy(i7);
            int[] iArr = this.zzc;
            int i11 = iArr[i7];
            int zzx13 = zzx(zzy2);
            if (zzx13 <= 17) {
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
            long j4 = zzy2 & i6;
            switch (zzx13) {
                case 0:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx = zzbi.zzx(i11 << 3);
                        zzx4 = zzx + 8;
                        i8 += zzx4;
                        break;
                    }
                case 1:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx2 = zzbi.zzx(i11 << 3);
                        zzx4 = zzx2 + 4;
                        i8 += zzx4;
                        break;
                    }
                case 2:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzy = zzbi.zzy(unsafe.getLong(obj, j4));
                        zzx3 = zzbi.zzx(i11 << 3);
                        i8 += zzx3 + zzy;
                        break;
                    }
                case 3:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzy = zzbi.zzy(unsafe.getLong(obj, j4));
                        zzx3 = zzbi.zzx(i11 << 3);
                        i8 += zzx3 + zzy;
                        break;
                    }
                case 4:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzy = zzbi.zzu(unsafe.getInt(obj, j4));
                        zzx3 = zzbi.zzx(i11 << 3);
                        i8 += zzx3 + zzy;
                        break;
                    }
                case 5:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx = zzbi.zzx(i11 << 3);
                        zzx4 = zzx + 8;
                        i8 += zzx4;
                        break;
                    }
                case 6:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx2 = zzbi.zzx(i11 << 3);
                        zzx4 = zzx2 + 4;
                        i8 += zzx4;
                        break;
                    }
                case 7:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx4 = zzbi.zzx(i11 << 3) + 1;
                        i8 += zzx4;
                        break;
                    }
                case 8:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j4);
                        if (object instanceof zzba) {
                            int i15 = zzbi.zzb;
                            int zzd = ((zzba) object).zzd();
                            zzx5 = zzbi.zzx(zzd) + zzd;
                            zzx6 = zzbi.zzx(i11 << 3);
                            zzx4 = zzx6 + zzx5;
                            i8 += zzx4;
                            break;
                        } else {
                            zzy = zzbi.zzw((String) object);
                            zzx3 = zzbi.zzx(i11 << 3);
                            i8 += zzx3 + zzy;
                            break;
                        }
                    }
                case 9:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx4 = zzdr.zzn(i11, unsafe.getObject(obj, j4), zzB(i7));
                        i8 += zzx4;
                        break;
                    }
                case 10:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        int i16 = zzbi.zzb;
                        int zzd2 = ((zzba) unsafe.getObject(obj, j4)).zzd();
                        zzx5 = zzbi.zzx(zzd2) + zzd2;
                        zzx6 = zzbi.zzx(i11 << 3);
                        zzx4 = zzx6 + zzx5;
                        i8 += zzx4;
                        break;
                    }
                case 11:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzy = zzbi.zzx(unsafe.getInt(obj, j4));
                        zzx3 = zzbi.zzx(i11 << 3);
                        i8 += zzx3 + zzy;
                        break;
                    }
                case 12:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzy = zzbi.zzu(unsafe.getInt(obj, j4));
                        zzx3 = zzbi.zzx(i11 << 3);
                        i8 += zzx3 + zzy;
                        break;
                    }
                case 13:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx2 = zzbi.zzx(i11 << 3);
                        zzx4 = zzx2 + 4;
                        i8 += zzx4;
                        break;
                    }
                case 14:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx = zzbi.zzx(i11 << 3);
                        zzx4 = zzx + 8;
                        i8 += zzx4;
                        break;
                    }
                case 15:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        int i17 = unsafe.getInt(obj, j4);
                        zzx3 = zzbi.zzx(i11 << 3);
                        zzy = zzbi.zzx((i17 >> 31) ^ (i17 + i17));
                        i8 += zzx3 + zzy;
                        break;
                    }
                case 16:
                    if ((i4 & i10) == 0) {
                        break;
                    } else {
                        long j5 = unsafe.getLong(obj, j4);
                        i8 += zzbi.zzx(i11 << 3) + zzbi.zzy((j5 >> 63) ^ (j5 + j5));
                        break;
                    }
                case 17:
                    if ((i10 & i4) == 0) {
                        break;
                    } else {
                        zzx4 = zzbi.zzt(i11, (zzdf) unsafe.getObject(obj, j4), zzB(i7));
                        i8 += zzx4;
                        break;
                    }
                case 18:
                    zzx4 = zzdr.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzx4;
                    break;
                case 19:
                    zzx4 = zzdr.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzx4;
                    break;
                case 20:
                    zzx4 = zzdr.zzl(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzx4;
                    break;
                case 21:
                    zzx4 = zzdr.zzw(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzx4;
                    break;
                case 22:
                    zzx4 = zzdr.zzj(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzx4;
                    break;
                case 23:
                    zzx4 = zzdr.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzx4;
                    break;
                case 24:
                    zzx4 = zzdr.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzx4;
                    break;
                case 25:
                    zzx4 = zzdr.zza(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzx4;
                    break;
                case 26:
                    zzt = zzdr.zzt(i11, (List) unsafe.getObject(obj, j4));
                    i8 += zzt;
                    break;
                case 27:
                    zzt = zzdr.zzo(i11, (List) unsafe.getObject(obj, j4), zzB(i7));
                    i8 += zzt;
                    break;
                case 28:
                    zzt = zzdr.zzb(i11, (List) unsafe.getObject(obj, j4));
                    i8 += zzt;
                    break;
                case 29:
                    zzt = zzdr.zzu(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 30:
                    zzt = zzdr.zzc(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 31:
                    zzt = zzdr.zze(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 32:
                    zzt = zzdr.zzg(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 33:
                    zzt = zzdr.zzp(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 34:
                    zzt = zzdr.zzr(i11, (List) unsafe.getObject(obj, j4), false);
                    i8 += zzt;
                    break;
                case 35:
                    zzh = zzdr.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 36:
                    zzh = zzdr.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 37:
                    zzh = zzdr.zzm((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 38:
                    zzh = zzdr.zzx((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 39:
                    zzh = zzdr.zzk((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 40:
                    zzh = zzdr.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 41:
                    zzh = zzdr.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 42:
                    int i18 = zzdr.zza;
                    zzh = ((List) unsafe.getObject(obj, j4)).size();
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 43:
                    zzh = zzdr.zzv((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 44:
                    zzh = zzdr.zzd((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 45:
                    zzh = zzdr.zzf((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 46:
                    zzh = zzdr.zzh((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 47:
                    zzh = zzdr.zzq((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 48:
                    zzh = zzdr.zzs((List) unsafe.getObject(obj, j4));
                    if (zzh > 0) {
                        zzx7 = zzbi.zzx(zzh);
                        zzx8 = zzbi.zzx(i11 << 3);
                        i5 = zzx8 + zzx7;
                        i8 += i5 + zzh;
                    }
                    break;
                case 49:
                    zzt = zzdr.zzi(i11, (List) unsafe.getObject(obj, j4), zzB(i7));
                    i8 += zzt;
                    break;
                case 50:
                    zzda.zza(i11, unsafe.getObject(obj, j4), zzC(i7));
                    break;
                case 51:
                    if (zzT(obj, i11, i7)) {
                        zzx9 = zzbi.zzx(i11 << 3);
                        zzt = zzx9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 52:
                    if (zzT(obj, i11, i7)) {
                        zzx10 = zzbi.zzx(i11 << 3);
                        zzt = zzx10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 53:
                    if (zzT(obj, i11, i7)) {
                        zzh = zzbi.zzy(zzz(obj, j4));
                        i5 = zzbi.zzx(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 54:
                    if (zzT(obj, i11, i7)) {
                        zzh = zzbi.zzy(zzz(obj, j4));
                        i5 = zzbi.zzx(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 55:
                    if (zzT(obj, i11, i7)) {
                        zzh = zzbi.zzu(zzp(obj, j4));
                        i5 = zzbi.zzx(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 56:
                    if (zzT(obj, i11, i7)) {
                        zzx9 = zzbi.zzx(i11 << 3);
                        zzt = zzx9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 57:
                    if (zzT(obj, i11, i7)) {
                        zzx10 = zzbi.zzx(i11 << 3);
                        zzt = zzx10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 58:
                    if (zzT(obj, i11, i7)) {
                        zzt = zzbi.zzx(i11 << 3) + 1;
                        i8 += zzt;
                    }
                    break;
                case 59:
                    if (zzT(obj, i11, i7)) {
                        Object object2 = unsafe.getObject(obj, j4);
                        if (object2 instanceof zzba) {
                            int i19 = zzbi.zzb;
                            int zzd3 = ((zzba) object2).zzd();
                            zzx11 = zzbi.zzx(zzd3) + zzd3;
                            zzx12 = zzbi.zzx(i11 << 3);
                            zzt = zzx12 + zzx11;
                            i8 += zzt;
                        } else {
                            zzh = zzbi.zzw((String) object2);
                            i5 = zzbi.zzx(i11 << 3);
                            i8 += i5 + zzh;
                        }
                    }
                    break;
                case 60:
                    if (zzT(obj, i11, i7)) {
                        zzt = zzdr.zzn(i11, unsafe.getObject(obj, j4), zzB(i7));
                        i8 += zzt;
                    }
                    break;
                case 61:
                    if (zzT(obj, i11, i7)) {
                        int i20 = zzbi.zzb;
                        int zzd4 = ((zzba) unsafe.getObject(obj, j4)).zzd();
                        zzx11 = zzbi.zzx(zzd4) + zzd4;
                        zzx12 = zzbi.zzx(i11 << 3);
                        zzt = zzx12 + zzx11;
                        i8 += zzt;
                    }
                    break;
                case 62:
                    if (zzT(obj, i11, i7)) {
                        zzh = zzbi.zzx(zzp(obj, j4));
                        i5 = zzbi.zzx(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 63:
                    if (zzT(obj, i11, i7)) {
                        zzh = zzbi.zzu(zzp(obj, j4));
                        i5 = zzbi.zzx(i11 << 3);
                        i8 += i5 + zzh;
                    }
                    break;
                case 64:
                    if (zzT(obj, i11, i7)) {
                        zzx10 = zzbi.zzx(i11 << 3);
                        zzt = zzx10 + 4;
                        i8 += zzt;
                    }
                    break;
                case 65:
                    if (zzT(obj, i11, i7)) {
                        zzx9 = zzbi.zzx(i11 << 3);
                        zzt = zzx9 + 8;
                        i8 += zzt;
                    }
                    break;
                case 66:
                    if (zzT(obj, i11, i7)) {
                        int zzp = zzp(obj, j4);
                        i5 = zzbi.zzx(i11 << 3);
                        zzh = zzbi.zzx((zzp >> 31) ^ (zzp + zzp));
                        i8 += i5 + zzh;
                    }
                    break;
                case 67:
                    if (zzT(obj, i11, i7)) {
                        long zzz = zzz(obj, j4);
                        i8 += zzbi.zzx(i11 << 3) + zzbi.zzy((zzz >> 63) ^ (zzz + zzz));
                    }
                    break;
                case 68:
                    if (zzT(obj, i11, i7)) {
                        zzt = zzbi.zzt(i11, (zzdf) unsafe.getObject(obj, j4), zzB(i7));
                        i8 += zzt;
                    }
                    break;
            }
            i7 += 3;
            i6 = 1048575;
        }
        zzeg zzegVar = this.zzn;
        int zza2 = i8 + zzegVar.zza(zzegVar.zzd(obj));
        if (!this.zzh) {
            return zza2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private static int zzp(Object obj, long j4) {
        return ((Integer) zzeq.zzf(obj, j4)).intValue();
    }

    private final int zzq(Object obj, byte[] bArr, int i4, int i5, int i6, long j4, zzan zzanVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzC = zzC(i6);
        Object object = unsafe.getObject(obj, j4);
        if (!((zzcz) object).zze()) {
            zzcz zzb2 = zzcz.zza().zzb();
            zzda.zzb(zzb2, object);
            unsafe.putObject(obj, j4, zzb2);
        }
        zzcy zzcyVar = (zzcy) zzC;
        throw null;
    }

    private final int zzr(Object obj, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4, int i11, zzan zzanVar) throws IOException {
        Unsafe unsafe = zzb;
        long j5 = this.zzc[i11 + 2] & 1048575;
        switch (i10) {
            case 51:
                if (i8 == 1) {
                    unsafe.putObject(obj, j4, Double.valueOf(Double.longBitsToDouble(zzao.zzp(bArr, i4))));
                    int i12 = i4 + 8;
                    unsafe.putInt(obj, j5, i7);
                    return i12;
                }
                break;
            case 52:
                if (i8 == 5) {
                    unsafe.putObject(obj, j4, Float.valueOf(Float.intBitsToFloat(zzao.zzb(bArr, i4))));
                    int i13 = i4 + 4;
                    unsafe.putInt(obj, j5, i7);
                    return i13;
                }
                break;
            case 53:
            case 54:
                if (i8 == 0) {
                    int zzm = zzao.zzm(bArr, i4, zzanVar);
                    unsafe.putObject(obj, j4, Long.valueOf(zzanVar.zzb));
                    unsafe.putInt(obj, j5, i7);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i8 == 0) {
                    int zzj = zzao.zzj(bArr, i4, zzanVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(zzanVar.zza));
                    unsafe.putInt(obj, j5, i7);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i8 == 1) {
                    unsafe.putObject(obj, j4, Long.valueOf(zzao.zzp(bArr, i4)));
                    int i14 = i4 + 8;
                    unsafe.putInt(obj, j5, i7);
                    return i14;
                }
                break;
            case 57:
            case 64:
                if (i8 == 5) {
                    unsafe.putObject(obj, j4, Integer.valueOf(zzao.zzb(bArr, i4)));
                    int i15 = i4 + 4;
                    unsafe.putInt(obj, j5, i7);
                    return i15;
                }
                break;
            case 58:
                if (i8 == 0) {
                    int zzm2 = zzao.zzm(bArr, i4, zzanVar);
                    unsafe.putObject(obj, j4, Boolean.valueOf(zzanVar.zzb != 0));
                    unsafe.putInt(obj, j5, i7);
                    return zzm2;
                }
                break;
            case 59:
                if (i8 == 2) {
                    int zzj2 = zzao.zzj(bArr, i4, zzanVar);
                    int i16 = zzanVar.zza;
                    if (i16 == 0) {
                        unsafe.putObject(obj, j4, "");
                    } else if ((i9 & 536870912) != 0 && !zzev.zze(bArr, zzj2, zzj2 + i16)) {
                        throw zzci.zzc();
                    } else {
                        unsafe.putObject(obj, j4, new String(bArr, zzj2, i16, zzcg.zzb));
                        zzj2 += i16;
                    }
                    unsafe.putInt(obj, j5, i7);
                    return zzj2;
                }
                break;
            case 60:
                if (i8 == 2) {
                    Object zzE = zzE(obj, i7, i11);
                    int zzo = zzao.zzo(zzE, zzB(i11), bArr, i4, i5, zzanVar);
                    zzM(obj, i7, i11, zzE);
                    return zzo;
                }
                break;
            case 61:
                if (i8 == 2) {
                    int zza2 = zzao.zza(bArr, i4, zzanVar);
                    unsafe.putObject(obj, j4, zzanVar.zzc);
                    unsafe.putInt(obj, j5, i7);
                    return zza2;
                }
                break;
            case 63:
                if (i8 == 0) {
                    int zzj3 = zzao.zzj(bArr, i4, zzanVar);
                    int i17 = zzanVar.zza;
                    zzce zzA = zzA(i11);
                    if (zzA != null && !zzA.zza(i17)) {
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
                    int zzj4 = zzao.zzj(bArr, i4, zzanVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(zzbe.zzb(zzanVar.zza)));
                    unsafe.putInt(obj, j5, i7);
                    return zzj4;
                }
                break;
            case 67:
                if (i8 == 0) {
                    int zzm3 = zzao.zzm(bArr, i4, zzanVar);
                    unsafe.putObject(obj, j4, Long.valueOf(zzbe.zzc(zzanVar.zzb)));
                    unsafe.putInt(obj, j5, i7);
                    return zzm3;
                }
                break;
            case 68:
                if (i8 == 3) {
                    Object zzE2 = zzE(obj, i7, i11);
                    int zzn = zzao.zzn(zzE2, zzB(i11), bArr, i4, i5, (i6 & (-8)) | 4, zzanVar);
                    zzM(obj, i7, i11, zzE2);
                    return zzn;
                }
                break;
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x0216 -> B:114:0x0217). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x0264 -> B:134:0x0265). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x019b -> B:82:0x019c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzs(java.lang.Object r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.play_billing.zzan r30) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdi.zzs(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.play_billing.zzan):int");
    }

    private final int zzt(int i4) {
        if (i4 >= this.zze && i4 <= this.zzf) {
            return zzw(i4, 0);
        }
        return -1;
    }

    private final int zzu(int i4, int i5) {
        if (i4 >= this.zze && i4 <= this.zzf) {
            return zzw(i4, i5);
        }
        return -1;
    }

    private final int zzv(int i4) {
        return this.zzc[i4 + 2];
    }

    private final int zzw(int i4, int i5) {
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

    private static int zzx(int i4) {
        return (i4 >>> 20) & 255;
    }

    private final int zzy(int i4) {
        return this.zzc[i4 + 1];
    }

    private static long zzz(Object obj, long j4) {
        return ((Long) zzeq.zzf(obj, j4)).longValue();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final int zza(Object obj) {
        int zzx;
        int zzx2;
        int zzy;
        int zzx3;
        int zzx4;
        int zzx5;
        int zzx6;
        int zzn;
        int zzx7;
        int zzy2;
        int zzx8;
        int zzx9;
        if (this.zzi) {
            Unsafe unsafe = zzb;
            int i4 = 0;
            for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
                int zzy3 = zzy(i5);
                int zzx10 = zzx(zzy3);
                int i6 = this.zzc[i5];
                int i7 = zzy3 & 1048575;
                if (zzx10 >= zzbt.zzJ.zza() && zzx10 <= zzbt.zzW.zza()) {
                    int i8 = this.zzc[i5 + 2];
                }
                long j4 = i7;
                switch (zzx10) {
                    case 0:
                        if (zzP(obj, i5)) {
                            zzx = zzbi.zzx(i6 << 3);
                            zzn = zzx + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzP(obj, i5)) {
                            zzx2 = zzbi.zzx(i6 << 3);
                            zzn = zzx2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzP(obj, i5)) {
                            zzy = zzbi.zzy(zzeq.zzd(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzP(obj, i5)) {
                            zzy = zzbi.zzy(zzeq.zzd(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzP(obj, i5)) {
                            zzy = zzbi.zzu(zzeq.zzc(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzP(obj, i5)) {
                            zzx = zzbi.zzx(i6 << 3);
                            zzn = zzx + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzP(obj, i5)) {
                            zzx2 = zzbi.zzx(i6 << 3);
                            zzn = zzx2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzP(obj, i5)) {
                            zzx4 = zzbi.zzx(i6 << 3);
                            zzn = zzx4 + 1;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzP(obj, i5)) {
                            Object zzf = zzeq.zzf(obj, j4);
                            if (zzf instanceof zzba) {
                                int i9 = i6 << 3;
                                int i10 = zzbi.zzb;
                                int zzd = ((zzba) zzf).zzd();
                                zzx5 = zzbi.zzx(zzd) + zzd;
                                zzx6 = zzbi.zzx(i9);
                                zzn = zzx6 + zzx5;
                                i4 += zzn;
                                break;
                            } else {
                                zzy = zzbi.zzw((String) zzf);
                                zzx3 = zzbi.zzx(i6 << 3);
                                i4 += zzx3 + zzy;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (zzP(obj, i5)) {
                            zzn = zzdr.zzn(i6, zzeq.zzf(obj, j4), zzB(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzP(obj, i5)) {
                            int i11 = i6 << 3;
                            int i12 = zzbi.zzb;
                            int zzd2 = ((zzba) zzeq.zzf(obj, j4)).zzd();
                            zzx5 = zzbi.zzx(zzd2) + zzd2;
                            zzx6 = zzbi.zzx(i11);
                            zzn = zzx6 + zzx5;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzP(obj, i5)) {
                            zzy = zzbi.zzx(zzeq.zzc(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzP(obj, i5)) {
                            zzy = zzbi.zzu(zzeq.zzc(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzP(obj, i5)) {
                            zzx2 = zzbi.zzx(i6 << 3);
                            zzn = zzx2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzP(obj, i5)) {
                            zzx = zzbi.zzx(i6 << 3);
                            zzn = zzx + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzP(obj, i5)) {
                            int zzc = zzeq.zzc(obj, j4);
                            zzx3 = zzbi.zzx(i6 << 3);
                            zzy = zzbi.zzx((zzc >> 31) ^ (zzc + zzc));
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzP(obj, i5)) {
                            long zzd3 = zzeq.zzd(obj, j4);
                            zzx7 = zzbi.zzx(i6 << 3);
                            zzy2 = zzbi.zzy((zzd3 + zzd3) ^ (zzd3 >> 63));
                            zzn = zzx7 + zzy2;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzP(obj, i5)) {
                            zzn = zzbi.zzt(i6, (zzdf) zzeq.zzf(obj, j4), zzB(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzn = zzdr.zzg(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 19:
                        zzn = zzdr.zze(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 20:
                        zzn = zzdr.zzl(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 21:
                        zzn = zzdr.zzw(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 22:
                        zzn = zzdr.zzj(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 23:
                        zzn = zzdr.zzg(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 24:
                        zzn = zzdr.zze(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 25:
                        zzn = zzdr.zza(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 26:
                        zzn = zzdr.zzt(i6, (List) zzeq.zzf(obj, j4));
                        i4 += zzn;
                        break;
                    case 27:
                        zzn = zzdr.zzo(i6, (List) zzeq.zzf(obj, j4), zzB(i5));
                        i4 += zzn;
                        break;
                    case 28:
                        zzn = zzdr.zzb(i6, (List) zzeq.zzf(obj, j4));
                        i4 += zzn;
                        break;
                    case 29:
                        zzn = zzdr.zzu(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 30:
                        zzn = zzdr.zzc(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 31:
                        zzn = zzdr.zze(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 32:
                        zzn = zzdr.zzg(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 33:
                        zzn = zzdr.zzp(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 34:
                        zzn = zzdr.zzr(i6, (List) zzeq.zzf(obj, j4), false);
                        i4 += zzn;
                        break;
                    case 35:
                        zzy = zzdr.zzh((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i13 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i13);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzy = zzdr.zzf((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i14 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i14);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzy = zzdr.zzm((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i15 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i15);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzy = zzdr.zzx((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i16 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i16);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzy = zzdr.zzk((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i17 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i17);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzy = zzdr.zzh((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i18 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i18);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzy = zzdr.zzf((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i19 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i19);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i20 = zzdr.zza;
                        zzy = ((List) unsafe.getObject(obj, j4)).size();
                        if (zzy > 0) {
                            int i21 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i21);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzy = zzdr.zzv((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i22 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i22);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzy = zzdr.zzd((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i23 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i23);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzy = zzdr.zzf((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i24 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i24);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzy = zzdr.zzh((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i25 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i25);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzy = zzdr.zzq((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i26 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i26);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzy = zzdr.zzs((List) unsafe.getObject(obj, j4));
                        if (zzy > 0) {
                            int i27 = i6 << 3;
                            zzx8 = zzbi.zzx(zzy);
                            zzx9 = zzbi.zzx(i27);
                            zzx3 = zzx9 + zzx8;
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        zzn = zzdr.zzi(i6, (List) zzeq.zzf(obj, j4), zzB(i5));
                        i4 += zzn;
                        break;
                    case 50:
                        zzda.zza(i6, zzeq.zzf(obj, j4), zzC(i5));
                        break;
                    case 51:
                        if (zzT(obj, i6, i5)) {
                            zzx = zzbi.zzx(i6 << 3);
                            zzn = zzx + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzT(obj, i6, i5)) {
                            zzx2 = zzbi.zzx(i6 << 3);
                            zzn = zzx2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzT(obj, i6, i5)) {
                            zzy = zzbi.zzy(zzz(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzT(obj, i6, i5)) {
                            zzy = zzbi.zzy(zzz(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzT(obj, i6, i5)) {
                            zzy = zzbi.zzu(zzp(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzT(obj, i6, i5)) {
                            zzx = zzbi.zzx(i6 << 3);
                            zzn = zzx + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzT(obj, i6, i5)) {
                            zzx2 = zzbi.zzx(i6 << 3);
                            zzn = zzx2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzT(obj, i6, i5)) {
                            zzx4 = zzbi.zzx(i6 << 3);
                            zzn = zzx4 + 1;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzT(obj, i6, i5)) {
                            Object zzf2 = zzeq.zzf(obj, j4);
                            if (zzf2 instanceof zzba) {
                                int i28 = i6 << 3;
                                int i29 = zzbi.zzb;
                                int zzd4 = ((zzba) zzf2).zzd();
                                zzx5 = zzbi.zzx(zzd4) + zzd4;
                                zzx6 = zzbi.zzx(i28);
                                zzn = zzx6 + zzx5;
                                i4 += zzn;
                                break;
                            } else {
                                zzy = zzbi.zzw((String) zzf2);
                                zzx3 = zzbi.zzx(i6 << 3);
                                i4 += zzx3 + zzy;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (zzT(obj, i6, i5)) {
                            zzn = zzdr.zzn(i6, zzeq.zzf(obj, j4), zzB(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzT(obj, i6, i5)) {
                            int i30 = i6 << 3;
                            int i31 = zzbi.zzb;
                            int zzd5 = ((zzba) zzeq.zzf(obj, j4)).zzd();
                            zzx5 = zzbi.zzx(zzd5) + zzd5;
                            zzx6 = zzbi.zzx(i30);
                            zzn = zzx6 + zzx5;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzT(obj, i6, i5)) {
                            zzy = zzbi.zzx(zzp(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzT(obj, i6, i5)) {
                            zzy = zzbi.zzu(zzp(obj, j4));
                            zzx3 = zzbi.zzx(i6 << 3);
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzT(obj, i6, i5)) {
                            zzx2 = zzbi.zzx(i6 << 3);
                            zzn = zzx2 + 4;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzT(obj, i6, i5)) {
                            zzx = zzbi.zzx(i6 << 3);
                            zzn = zzx + 8;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzT(obj, i6, i5)) {
                            int zzp = zzp(obj, j4);
                            zzx3 = zzbi.zzx(i6 << 3);
                            zzy = zzbi.zzx((zzp >> 31) ^ (zzp + zzp));
                            i4 += zzx3 + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzT(obj, i6, i5)) {
                            long zzz = zzz(obj, j4);
                            zzx7 = zzbi.zzx(i6 << 3);
                            zzy2 = zzbi.zzy((zzz + zzz) ^ (zzz >> 63));
                            zzn = zzx7 + zzy2;
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzT(obj, i6, i5)) {
                            zzn = zzbi.zzt(i6, (zzdf) zzeq.zzf(obj, j4), zzB(i5));
                            i4 += zzn;
                            break;
                        } else {
                            break;
                        }
                }
            }
            zzeg zzegVar = this.zzn;
            return i4 + zzegVar.zza(zzegVar.zzd(obj));
        }
        return zzo(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final int zzb(Object obj) {
        int i4;
        long doubleToLongBits;
        int i5;
        int floatToIntBits;
        int length = this.zzc.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 3) {
            int zzy = zzy(i7);
            int i8 = this.zzc[i7];
            long j4 = 1048575 & zzy;
            int i9 = 37;
            switch (zzx(zzy)) {
                case 0:
                    i4 = i6 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzeq.zza(obj, j4));
                    byte[] bArr = zzcg.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 1:
                    i5 = i6 * 53;
                    floatToIntBits = Float.floatToIntBits(zzeq.zzb(obj, j4));
                    i6 = i5 + floatToIntBits;
                    break;
                case 2:
                    i4 = i6 * 53;
                    doubleToLongBits = zzeq.zzd(obj, j4);
                    byte[] bArr2 = zzcg.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 3:
                    i4 = i6 * 53;
                    doubleToLongBits = zzeq.zzd(obj, j4);
                    byte[] bArr3 = zzcg.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 4:
                    i5 = i6 * 53;
                    floatToIntBits = zzeq.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 5:
                    i4 = i6 * 53;
                    doubleToLongBits = zzeq.zzd(obj, j4);
                    byte[] bArr4 = zzcg.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 6:
                    i5 = i6 * 53;
                    floatToIntBits = zzeq.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 7:
                    i5 = i6 * 53;
                    floatToIntBits = zzcg.zza(zzeq.zzw(obj, j4));
                    i6 = i5 + floatToIntBits;
                    break;
                case 8:
                    i5 = i6 * 53;
                    floatToIntBits = ((String) zzeq.zzf(obj, j4)).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 9:
                    Object zzf = zzeq.zzf(obj, j4);
                    if (zzf != null) {
                        i9 = zzf.hashCode();
                    }
                    i6 = (i6 * 53) + i9;
                    break;
                case 10:
                    i5 = i6 * 53;
                    floatToIntBits = zzeq.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 11:
                    i5 = i6 * 53;
                    floatToIntBits = zzeq.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 12:
                    i5 = i6 * 53;
                    floatToIntBits = zzeq.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 13:
                    i5 = i6 * 53;
                    floatToIntBits = zzeq.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 14:
                    i4 = i6 * 53;
                    doubleToLongBits = zzeq.zzd(obj, j4);
                    byte[] bArr5 = zzcg.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 15:
                    i5 = i6 * 53;
                    floatToIntBits = zzeq.zzc(obj, j4);
                    i6 = i5 + floatToIntBits;
                    break;
                case 16:
                    i4 = i6 * 53;
                    doubleToLongBits = zzeq.zzd(obj, j4);
                    byte[] bArr6 = zzcg.zzd;
                    i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 17:
                    Object zzf2 = zzeq.zzf(obj, j4);
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
                    floatToIntBits = zzeq.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 50:
                    i5 = i6 * 53;
                    floatToIntBits = zzeq.zzf(obj, j4).hashCode();
                    i6 = i5 + floatToIntBits;
                    break;
                case 51:
                    if (zzT(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j4));
                        byte[] bArr7 = zzcg.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j4));
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzT(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzz(obj, j4);
                        byte[] bArr8 = zzcg.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzT(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzz(obj, j4);
                        byte[] bArr9 = zzcg.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzT(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzz(obj, j4);
                        byte[] bArr10 = zzcg.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzcg.zza(zzU(obj, j4));
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = ((String) zzeq.zzf(obj, j4)).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzeq.zzf(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzeq.zzf(obj, j4).hashCode();
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzT(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzz(obj, j4);
                        byte[] bArr11 = zzcg.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzp(obj, j4);
                        i6 = i5 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzT(obj, i8, i7)) {
                        i4 = i6 * 53;
                        doubleToLongBits = zzz(obj, j4);
                        byte[] bArr12 = zzcg.zzd;
                        i6 = i4 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzT(obj, i8, i7)) {
                        i5 = i6 * 53;
                        floatToIntBits = zzeq.zzf(obj, j4).hashCode();
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
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0401, code lost:
        if (r6 == 1048575) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0403, code lost:
        r27.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0409, code lost:
        r2 = r8.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x040d, code lost:
        if (r2 >= r8.zzl) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x040f, code lost:
        r4 = r8.zzj[r2];
        r5 = r8.zzc[r4];
        r5 = com.google.android.gms.internal.play_billing.zzeq.zzf(r12, r8.zzy(r4) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0421, code lost:
        if (r5 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0428, code lost:
        if (r8.zzA(r4) != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x042a, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x042d, code lost:
        r5 = (com.google.android.gms.internal.play_billing.zzcz) r5;
        r0 = (com.google.android.gms.internal.play_billing.zzcy) r8.zzC(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0435, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0436, code lost:
        if (r9 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x043a, code lost:
        if (r0 != r32) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0441, code lost:
        throw com.google.android.gms.internal.play_billing.zzci.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0444, code lost:
        if (r0 > r32) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0446, code lost:
        if (r3 != r9) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0448, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x044d, code lost:
        throw com.google.android.gms.internal.play_billing.zzci.zze();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.play_billing.zzan r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1140
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdi.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzan):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final Object zze() {
        return ((zzcb) this.zzg).zzh();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzf(Object obj) {
        if (!zzS(obj)) {
            return;
        }
        if (obj instanceof zzcb) {
            zzcb zzcbVar = (zzcb) obj;
            zzcbVar.zzp(Integer.MAX_VALUE);
            zzcbVar.zza = 0;
            zzcbVar.zzn();
        }
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzy = zzy(i4);
            int i5 = 1048575 & zzy;
            int zzx = zzx(zzy);
            long j4 = i5;
            if (zzx != 9) {
                if (zzx != 60 && zzx != 68) {
                    switch (zzx) {
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
                            this.zzm.zza(obj, j4);
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j4);
                            if (object != null) {
                                ((zzcz) object).zzc();
                                unsafe.putObject(obj, j4, object);
                                break;
                            } else {
                                break;
                            }
                    }
                } else if (zzT(obj, this.zzc[i4], i4)) {
                    zzB(i4).zzf(zzb.getObject(obj, j4));
                }
            }
            if (zzP(obj, i4)) {
                zzB(i4).zzf(zzb.getObject(obj, j4));
            }
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzg(Object obj, Object obj2) {
        zzG(obj);
        obj2.getClass();
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzy = zzy(i4);
            int i5 = this.zzc[i4];
            long j4 = 1048575 & zzy;
            switch (zzx(zzy)) {
                case 0:
                    if (zzP(obj2, i4)) {
                        zzeq.zzo(obj, j4, zzeq.zza(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzP(obj2, i4)) {
                        zzeq.zzp(obj, j4, zzeq.zzb(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzP(obj2, i4)) {
                        zzeq.zzr(obj, j4, zzeq.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzP(obj2, i4)) {
                        zzeq.zzr(obj, j4, zzeq.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzP(obj2, i4)) {
                        zzeq.zzq(obj, j4, zzeq.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzP(obj2, i4)) {
                        zzeq.zzr(obj, j4, zzeq.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzP(obj2, i4)) {
                        zzeq.zzq(obj, j4, zzeq.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzP(obj2, i4)) {
                        zzeq.zzm(obj, j4, zzeq.zzw(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzP(obj2, i4)) {
                        zzeq.zzs(obj, j4, zzeq.zzf(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i4);
                    break;
                case 10:
                    if (zzP(obj2, i4)) {
                        zzeq.zzs(obj, j4, zzeq.zzf(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzP(obj2, i4)) {
                        zzeq.zzq(obj, j4, zzeq.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzP(obj2, i4)) {
                        zzeq.zzq(obj, j4, zzeq.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzP(obj2, i4)) {
                        zzeq.zzq(obj, j4, zzeq.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzP(obj2, i4)) {
                        zzeq.zzr(obj, j4, zzeq.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzP(obj2, i4)) {
                        zzeq.zzq(obj, j4, zzeq.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzP(obj2, i4)) {
                        zzeq.zzr(obj, j4, zzeq.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i4);
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
                    this.zzm.zzb(obj, obj2, j4);
                    break;
                case 50:
                    int i6 = zzdr.zza;
                    zzeq.zzs(obj, j4, zzda.zzb(zzeq.zzf(obj, j4), zzeq.zzf(obj2, j4)));
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
                    if (zzT(obj2, i5, i4)) {
                        zzeq.zzs(obj, j4, zzeq.zzf(obj2, j4));
                        zzK(obj, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i4);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzT(obj2, i5, i4)) {
                        zzeq.zzs(obj, j4, zzeq.zzf(obj2, j4));
                        zzK(obj, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i4);
                    break;
            }
        }
        zzdr.zzC(this.zzn, obj, obj2);
        if (!this.zzh) {
            return;
        }
        this.zzo.zza(obj2);
        throw null;
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
    @Override // com.google.android.gms.internal.play_billing.zzdp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.play_billing.zzan r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdi.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.play_billing.zzan):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzi(Object obj, zzey zzeyVar) throws IOException {
        int i4;
        int i5 = 1048575;
        if (this.zzi) {
            if (!this.zzh) {
                int length = this.zzc.length;
                for (int i6 = 0; i6 < length; i6 += 3) {
                    int zzy = zzy(i6);
                    int i7 = this.zzc[i6];
                    switch (zzx(zzy)) {
                        case 0:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzf(i7, zzeq.zza(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzo(i7, zzeq.zzb(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzt(i7, zzeq.zzd(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzJ(i7, zzeq.zzd(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzr(i7, zzeq.zzc(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzm(i7, zzeq.zzd(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzk(i7, zzeq.zzc(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzb(i7, zzeq.zzw(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (zzP(obj, i6)) {
                                zzV(i7, zzeq.zzf(obj, zzy & 1048575), zzeyVar);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzv(i7, zzeq.zzf(obj, zzy & 1048575), zzB(i6));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzd(i7, (zzba) zzeq.zzf(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzH(i7, zzeq.zzc(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzi(i7, zzeq.zzc(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzw(i7, zzeq.zzc(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzy(i7, zzeq.zzd(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzA(i7, zzeq.zzc(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzC(i7, zzeq.zzd(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (zzP(obj, i6)) {
                                zzeyVar.zzq(i7, zzeq.zzf(obj, zzy & 1048575), zzB(i6));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            zzdr.zzG(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 19:
                            zzdr.zzK(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 20:
                            zzdr.zzN(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 21:
                            zzdr.zzV(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 22:
                            zzdr.zzM(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 23:
                            zzdr.zzJ(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 24:
                            zzdr.zzI(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 25:
                            zzdr.zzE(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 26:
                            zzdr.zzT(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar);
                            break;
                        case 27:
                            zzdr.zzO(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, zzB(i6));
                            break;
                        case 28:
                            zzdr.zzF(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar);
                            break;
                        case 29:
                            zzdr.zzU(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 30:
                            zzdr.zzH(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 31:
                            zzdr.zzP(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 32:
                            zzdr.zzQ(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 33:
                            zzdr.zzR(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 34:
                            zzdr.zzS(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, false);
                            break;
                        case 35:
                            zzdr.zzG(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 36:
                            zzdr.zzK(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 37:
                            zzdr.zzN(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 38:
                            zzdr.zzV(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 39:
                            zzdr.zzM(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 40:
                            zzdr.zzJ(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 41:
                            zzdr.zzI(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 42:
                            zzdr.zzE(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 43:
                            zzdr.zzU(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 44:
                            zzdr.zzH(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 45:
                            zzdr.zzP(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 46:
                            zzdr.zzQ(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 47:
                            zzdr.zzR(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 48:
                            zzdr.zzS(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, true);
                            break;
                        case 49:
                            zzdr.zzL(i7, (List) zzeq.zzf(obj, zzy & 1048575), zzeyVar, zzB(i6));
                            break;
                        case 50:
                            zzN(zzeyVar, i7, zzeq.zzf(obj, zzy & 1048575), i6);
                            break;
                        case 51:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzf(i7, zzm(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzo(i7, zzn(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzt(i7, zzz(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzJ(i7, zzz(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzr(i7, zzp(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzm(i7, zzz(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzk(i7, zzp(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzb(i7, zzU(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (zzT(obj, i7, i6)) {
                                zzV(i7, zzeq.zzf(obj, zzy & 1048575), zzeyVar);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzv(i7, zzeq.zzf(obj, zzy & 1048575), zzB(i6));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzd(i7, (zzba) zzeq.zzf(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzH(i7, zzp(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzi(i7, zzp(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzw(i7, zzp(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzy(i7, zzz(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzA(i7, zzp(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzC(i7, zzz(obj, zzy & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (zzT(obj, i7, i6)) {
                                zzeyVar.zzq(i7, zzeq.zzf(obj, zzy & 1048575), zzB(i6));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                zzeg zzegVar = this.zzn;
                zzegVar.zzi(zzegVar.zzd(obj), zzeyVar);
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
                int zzy2 = zzy(i8);
                int[] iArr = this.zzc;
                int i11 = iArr[i8];
                int zzx = zzx(zzy2);
                if (zzx <= 17) {
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
                long j4 = zzy2 & i5;
                switch (zzx) {
                    case 0:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzf(i11, zzeq.zza(obj, j4));
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 1:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzo(i11, zzeq.zzb(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 2:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzt(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 3:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzJ(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 4:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzr(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 5:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzm(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 6:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzk(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 7:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzb(i11, zzeq.zzw(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 8:
                        if ((i10 & i4) != 0) {
                            zzV(i11, unsafe.getObject(obj, j4), zzeyVar);
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 9:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzv(i11, unsafe.getObject(obj, j4), zzB(i8));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 10:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzd(i11, (zzba) unsafe.getObject(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 11:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzH(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 12:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzi(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 13:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzw(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 14:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzy(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 15:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzA(i11, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 16:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzC(i11, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 17:
                        if ((i10 & i4) != 0) {
                            zzeyVar.zzq(i11, unsafe.getObject(obj, j4), zzB(i8));
                        } else {
                            continue;
                        }
                        i8 += 3;
                        i5 = 1048575;
                    case 18:
                        zzdr.zzG(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 19:
                        zzdr.zzK(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 20:
                        zzdr.zzN(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 21:
                        zzdr.zzV(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 22:
                        zzdr.zzM(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 23:
                        zzdr.zzJ(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 24:
                        zzdr.zzI(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 25:
                        zzdr.zzE(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        continue;
                        i8 += 3;
                        i5 = 1048575;
                    case 26:
                        zzdr.zzT(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar);
                        break;
                    case 27:
                        zzdr.zzO(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, zzB(i8));
                        break;
                    case 28:
                        zzdr.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar);
                        break;
                    case 29:
                        zzdr.zzU(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        break;
                    case 30:
                        zzdr.zzH(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        break;
                    case 31:
                        zzdr.zzP(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        break;
                    case 32:
                        zzdr.zzQ(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        break;
                    case 33:
                        zzdr.zzR(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        break;
                    case 34:
                        zzdr.zzS(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, false);
                        break;
                    case 35:
                        zzdr.zzG(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 36:
                        zzdr.zzK(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 37:
                        zzdr.zzN(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 38:
                        zzdr.zzV(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 39:
                        zzdr.zzM(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 40:
                        zzdr.zzJ(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 41:
                        zzdr.zzI(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 42:
                        zzdr.zzE(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 43:
                        zzdr.zzU(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 44:
                        zzdr.zzH(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 45:
                        zzdr.zzP(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 46:
                        zzdr.zzQ(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 47:
                        zzdr.zzR(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 48:
                        zzdr.zzS(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, true);
                        break;
                    case 49:
                        zzdr.zzL(this.zzc[i8], (List) unsafe.getObject(obj, j4), zzeyVar, zzB(i8));
                        break;
                    case 50:
                        zzN(zzeyVar, i11, unsafe.getObject(obj, j4), i8);
                        break;
                    case 51:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzf(i11, zzm(obj, j4));
                            break;
                        }
                        break;
                    case 52:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzo(i11, zzn(obj, j4));
                            break;
                        }
                        break;
                    case 53:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzt(i11, zzz(obj, j4));
                            break;
                        }
                        break;
                    case 54:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzJ(i11, zzz(obj, j4));
                            break;
                        }
                        break;
                    case 55:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzr(i11, zzp(obj, j4));
                            break;
                        }
                        break;
                    case 56:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzm(i11, zzz(obj, j4));
                            break;
                        }
                        break;
                    case 57:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzk(i11, zzp(obj, j4));
                            break;
                        }
                        break;
                    case 58:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzb(i11, zzU(obj, j4));
                            break;
                        }
                        break;
                    case 59:
                        if (zzT(obj, i11, i8)) {
                            zzV(i11, unsafe.getObject(obj, j4), zzeyVar);
                            break;
                        }
                        break;
                    case 60:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzv(i11, unsafe.getObject(obj, j4), zzB(i8));
                            break;
                        }
                        break;
                    case 61:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzd(i11, (zzba) unsafe.getObject(obj, j4));
                            break;
                        }
                        break;
                    case 62:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzH(i11, zzp(obj, j4));
                            break;
                        }
                        break;
                    case 63:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzi(i11, zzp(obj, j4));
                            break;
                        }
                        break;
                    case 64:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzw(i11, zzp(obj, j4));
                            break;
                        }
                        break;
                    case 65:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzy(i11, zzz(obj, j4));
                            break;
                        }
                        break;
                    case 66:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzA(i11, zzp(obj, j4));
                            break;
                        }
                        break;
                    case 67:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzC(i11, zzz(obj, j4));
                            break;
                        }
                        break;
                    case 68:
                        if (zzT(obj, i11, i8)) {
                            zzeyVar.zzq(i11, unsafe.getObject(obj, j4), zzB(i8));
                            break;
                        }
                        break;
                }
                i8 += 3;
                i5 = 1048575;
            }
            zzeg zzegVar2 = this.zzn;
            zzegVar2.zzi(zzegVar2.zzd(obj), zzeyVar);
        } else {
            this.zzo.zza(obj);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzW;
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzy = zzy(i4);
            long j4 = zzy & 1048575;
            switch (zzx(zzy)) {
                case 0:
                    if (zzO(obj, obj2, i4) && Double.doubleToLongBits(zzeq.zza(obj, j4)) == Double.doubleToLongBits(zzeq.zza(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzO(obj, obj2, i4) && Float.floatToIntBits(zzeq.zzb(obj, j4)) == Float.floatToIntBits(zzeq.zzb(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzO(obj, obj2, i4) && zzeq.zzd(obj, j4) == zzeq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzO(obj, obj2, i4) && zzeq.zzd(obj, j4) == zzeq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzO(obj, obj2, i4) && zzeq.zzc(obj, j4) == zzeq.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzO(obj, obj2, i4) && zzeq.zzd(obj, j4) == zzeq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzO(obj, obj2, i4) && zzeq.zzc(obj, j4) == zzeq.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzO(obj, obj2, i4) && zzeq.zzw(obj, j4) == zzeq.zzw(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzO(obj, obj2, i4) && zzdr.zzW(zzeq.zzf(obj, j4), zzeq.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzO(obj, obj2, i4) && zzdr.zzW(zzeq.zzf(obj, j4), zzeq.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzO(obj, obj2, i4) && zzdr.zzW(zzeq.zzf(obj, j4), zzeq.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzO(obj, obj2, i4) && zzeq.zzc(obj, j4) == zzeq.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzO(obj, obj2, i4) && zzeq.zzc(obj, j4) == zzeq.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzO(obj, obj2, i4) && zzeq.zzc(obj, j4) == zzeq.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzO(obj, obj2, i4) && zzeq.zzd(obj, j4) == zzeq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzO(obj, obj2, i4) && zzeq.zzc(obj, j4) == zzeq.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzO(obj, obj2, i4) && zzeq.zzd(obj, j4) == zzeq.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzO(obj, obj2, i4) && zzdr.zzW(zzeq.zzf(obj, j4), zzeq.zzf(obj2, j4))) {
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
                    zzW = zzdr.zzW(zzeq.zzf(obj, j4), zzeq.zzf(obj2, j4));
                    break;
                case 50:
                    zzW = zzdr.zzW(zzeq.zzf(obj, j4), zzeq.zzf(obj2, j4));
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
                    long zzv = zzv(i4) & 1048575;
                    if (zzeq.zzc(obj, zzv) == zzeq.zzc(obj2, zzv) && zzdr.zzW(zzeq.zzf(obj, j4), zzeq.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzW) {
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

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final boolean zzk(Object obj) {
        int i4;
        int i5;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.zzk) {
            int i9 = this.zzj[i8];
            int i10 = this.zzc[i9];
            int zzy = zzy(i9);
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
            if ((268435456 & zzy) != 0 && !zzQ(obj, i9, i4, i5, i13)) {
                return false;
            }
            int zzx = zzx(zzy);
            if (zzx != 9 && zzx != 17) {
                if (zzx != 27) {
                    if (zzx != 60 && zzx != 68) {
                        if (zzx != 49) {
                            if (zzx == 50 && !((zzcz) zzeq.zzf(obj, zzy & 1048575)).isEmpty()) {
                                zzcy zzcyVar = (zzcy) zzC(i9);
                                throw null;
                            }
                        }
                    } else if (zzT(obj, i10, i9) && !zzR(obj, zzy, zzB(i9))) {
                        return false;
                    }
                }
                List list = (List) zzeq.zzf(obj, zzy & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzdp zzB = zzB(i9);
                    for (int i14 = 0; i14 < list.size(); i14++) {
                        if (!zzB.zzk(list.get(i14))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzQ(obj, i9, i4, i5, i13) && !zzR(obj, zzy, zzB(i9))) {
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
}
