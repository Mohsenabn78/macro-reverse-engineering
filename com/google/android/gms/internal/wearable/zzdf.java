package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzdf<T> implements zzdn<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzeo.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzdc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzcq zzm;
    private final zzee zzn;
    private final zzbk zzo;
    private final zzdh zzp;
    private final zzcx zzq;

    private zzdf(int[] iArr, Object[] objArr, int i4, int i5, zzdc zzdcVar, boolean z3, boolean z4, int[] iArr2, int i6, int i7, zzdh zzdhVar, zzcq zzcqVar, zzee zzeeVar, zzbk zzbkVar, zzcx zzcxVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i4;
        this.zzf = i5;
        this.zzi = z3;
        boolean z5 = false;
        if (zzbkVar != null && zzbkVar.zzc(zzdcVar)) {
            z5 = true;
        }
        this.zzh = z5;
        this.zzj = iArr2;
        this.zzk = i6;
        this.zzl = i7;
        this.zzp = zzdhVar;
        this.zzm = zzcqVar;
        this.zzn = zzeeVar;
        this.zzo = zzbkVar;
        this.zzg = zzdcVar;
        this.zzq = zzcxVar;
    }

    private static int zzA(int i4) {
        return (i4 >>> 20) & 255;
    }

    private final int zzB(int i4) {
        return this.zzc[i4 + 1];
    }

    private static long zzC(Object obj, long j4) {
        return ((Long) zzeo.zzf(obj, j4)).longValue();
    }

    private final zzbz zzD(int i4) {
        int i5 = i4 / 3;
        return (zzbz) this.zzd[i5 + i5 + 1];
    }

    private final zzdn zzE(int i4) {
        int i5 = i4 / 3;
        int i6 = i5 + i5;
        zzdn zzdnVar = (zzdn) this.zzd[i6];
        if (zzdnVar != null) {
            return zzdnVar;
        }
        zzdn zzb2 = zzdk.zza().zzb((Class) this.zzd[i6 + 1]);
        this.zzd[i6] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i4) {
        int i5 = i4 / 3;
        return this.zzd[i5 + i5];
    }

    private static Field zzG(Class cls, String str) {
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

    private final void zzH(Object obj, Object obj2, int i4) {
        long zzB = zzB(i4) & 1048575;
        if (!zzO(obj2, i4)) {
            return;
        }
        Object zzf = zzeo.zzf(obj, zzB);
        Object zzf2 = zzeo.zzf(obj2, zzB);
        if (zzf != null && zzf2 != null) {
            zzeo.zzs(obj, zzB, zzcd.zzg(zzf, zzf2));
            zzJ(obj, i4);
        } else if (zzf2 != null) {
            zzeo.zzs(obj, zzB, zzf2);
            zzJ(obj, i4);
        }
    }

    private final void zzI(Object obj, Object obj2, int i4) {
        Object obj3;
        int zzB = zzB(i4);
        int i5 = this.zzc[i4];
        long j4 = zzB & 1048575;
        if (!zzR(obj2, i5, i4)) {
            return;
        }
        if (zzR(obj, i5, i4)) {
            obj3 = zzeo.zzf(obj, j4);
        } else {
            obj3 = null;
        }
        Object zzf = zzeo.zzf(obj2, j4);
        if (obj3 != null && zzf != null) {
            zzeo.zzs(obj, j4, zzcd.zzg(obj3, zzf));
            zzK(obj, i5, i4);
        } else if (zzf != null) {
            zzeo.zzs(obj, j4, zzf);
            zzK(obj, i5, i4);
        }
    }

    private final void zzJ(Object obj, int i4) {
        int zzy = zzy(i4);
        long j4 = 1048575 & zzy;
        if (j4 == 1048575) {
            return;
        }
        zzeo.zzq(obj, j4, (1 << (zzy >>> 20)) | zzeo.zzc(obj, j4));
    }

    private final void zzK(Object obj, int i4, int i5) {
        zzeo.zzq(obj, zzy(i5) & 1048575, i4);
    }

    private final void zzL(Object obj, zzew zzewVar) throws IOException {
        int i4;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i5 = 1048575;
            int i6 = 0;
            int i7 = 0;
            int i8 = 1048575;
            while (i6 < length) {
                int zzB = zzB(i6);
                int[] iArr = this.zzc;
                int i9 = iArr[i6];
                int zzA = zzA(zzB);
                if (zzA <= 17) {
                    int i10 = iArr[i6 + 2];
                    int i11 = i10 & i5;
                    if (i11 != i8) {
                        i7 = unsafe.getInt(obj, i11);
                        i8 = i11;
                    }
                    i4 = 1 << (i10 >>> 20);
                } else {
                    i4 = 0;
                }
                long j4 = zzB & i5;
                switch (zzA) {
                    case 0:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzf(i9, zzeo.zza(obj, j4));
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 1:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzo(i9, zzeo.zzb(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 2:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzt(i9, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 3:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzJ(i9, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 4:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzr(i9, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 5:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzm(i9, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 6:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzk(i9, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 7:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzb(i9, zzeo.zzw(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 8:
                        if ((i7 & i4) != 0) {
                            zzT(i9, unsafe.getObject(obj, j4), zzewVar);
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 9:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzv(i9, unsafe.getObject(obj, j4), zzE(i6));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 10:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzd(i9, (zzaw) unsafe.getObject(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 11:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzH(i9, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 12:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzi(i9, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 13:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzw(i9, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 14:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzy(i9, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 15:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzA(i9, unsafe.getInt(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 16:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzC(i9, unsafe.getLong(obj, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 17:
                        if ((i7 & i4) != 0) {
                            zzewVar.zzq(i9, unsafe.getObject(obj, j4), zzE(i6));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 18:
                        zzdp.zzJ(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 19:
                        zzdp.zzN(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 20:
                        zzdp.zzQ(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 21:
                        zzdp.zzY(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 22:
                        zzdp.zzP(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 23:
                        zzdp.zzM(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 24:
                        zzdp.zzL(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 25:
                        zzdp.zzH(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 26:
                        zzdp.zzW(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar);
                        break;
                    case 27:
                        zzdp.zzR(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, zzE(i6));
                        break;
                    case 28:
                        zzdp.zzI(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar);
                        break;
                    case 29:
                        zzdp.zzX(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        break;
                    case 30:
                        zzdp.zzK(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        break;
                    case 31:
                        zzdp.zzS(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        break;
                    case 32:
                        zzdp.zzT(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        break;
                    case 33:
                        zzdp.zzU(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        break;
                    case 34:
                        zzdp.zzV(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, false);
                        break;
                    case 35:
                        zzdp.zzJ(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 36:
                        zzdp.zzN(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 37:
                        zzdp.zzQ(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 38:
                        zzdp.zzY(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 39:
                        zzdp.zzP(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 40:
                        zzdp.zzM(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 41:
                        zzdp.zzL(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 42:
                        zzdp.zzH(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 43:
                        zzdp.zzX(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 44:
                        zzdp.zzK(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 45:
                        zzdp.zzS(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 46:
                        zzdp.zzT(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 47:
                        zzdp.zzU(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 48:
                        zzdp.zzV(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, true);
                        break;
                    case 49:
                        zzdp.zzO(this.zzc[i6], (List) unsafe.getObject(obj, j4), zzewVar, zzE(i6));
                        break;
                    case 50:
                        zzM(zzewVar, i9, unsafe.getObject(obj, j4), i6);
                        break;
                    case 51:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzf(i9, zzn(obj, j4));
                            break;
                        }
                        break;
                    case 52:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzo(i9, zzo(obj, j4));
                            break;
                        }
                        break;
                    case 53:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzt(i9, zzC(obj, j4));
                            break;
                        }
                        break;
                    case 54:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzJ(i9, zzC(obj, j4));
                            break;
                        }
                        break;
                    case 55:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzr(i9, zzr(obj, j4));
                            break;
                        }
                        break;
                    case 56:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzm(i9, zzC(obj, j4));
                            break;
                        }
                        break;
                    case 57:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzk(i9, zzr(obj, j4));
                            break;
                        }
                        break;
                    case 58:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzb(i9, zzS(obj, j4));
                            break;
                        }
                        break;
                    case 59:
                        if (zzR(obj, i9, i6)) {
                            zzT(i9, unsafe.getObject(obj, j4), zzewVar);
                            break;
                        }
                        break;
                    case 60:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzv(i9, unsafe.getObject(obj, j4), zzE(i6));
                            break;
                        }
                        break;
                    case 61:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzd(i9, (zzaw) unsafe.getObject(obj, j4));
                            break;
                        }
                        break;
                    case 62:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzH(i9, zzr(obj, j4));
                            break;
                        }
                        break;
                    case 63:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzi(i9, zzr(obj, j4));
                            break;
                        }
                        break;
                    case 64:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzw(i9, zzr(obj, j4));
                            break;
                        }
                        break;
                    case 65:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzy(i9, zzC(obj, j4));
                            break;
                        }
                        break;
                    case 66:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzA(i9, zzr(obj, j4));
                            break;
                        }
                        break;
                    case 67:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzC(i9, zzC(obj, j4));
                            break;
                        }
                        break;
                    case 68:
                        if (zzR(obj, i9, i6)) {
                            zzewVar.zzq(i9, unsafe.getObject(obj, j4), zzE(i6));
                            break;
                        }
                        break;
                }
                i6 += 3;
                i5 = 1048575;
            }
            zzee zzeeVar = this.zzn;
            zzeeVar.zzi(zzeeVar.zzc(obj), zzewVar);
            return;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private final void zzM(zzew zzewVar, int i4, Object obj, int i5) throws IOException {
        if (obj == null) {
            return;
        }
        zzcv zzcvVar = (zzcv) zzF(i5);
        throw null;
    }

    private final boolean zzN(Object obj, Object obj2, int i4) {
        if (zzO(obj, i4) == zzO(obj2, i4)) {
            return true;
        }
        return false;
    }

    private final boolean zzO(Object obj, int i4) {
        int zzy = zzy(i4);
        long j4 = zzy & 1048575;
        if (j4 == 1048575) {
            int zzB = zzB(i4);
            long j5 = zzB & 1048575;
            switch (zzA(zzB)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzeo.zza(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzeo.zzb(obj, j5)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzeo.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzeo.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzeo.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzeo.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzeo.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzeo.zzw(obj, j5);
                case 8:
                    Object zzf = zzeo.zzf(obj, j5);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    } else if (zzf instanceof zzaw) {
                        if (zzaw.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (zzeo.zzf(obj, j5) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzaw.zzb.equals(zzeo.zzf(obj, j5))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzeo.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzeo.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzeo.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzeo.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzeo.zzc(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzeo.zzd(obj, j5) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzeo.zzf(obj, j5) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzeo.zzc(obj, j4) & (1 << (zzy >>> 20))) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private final boolean zzP(Object obj, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return zzO(obj, i4);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzQ(Object obj, int i4, zzdn zzdnVar) {
        return zzdnVar.zzk(zzeo.zzf(obj, i4 & 1048575));
    }

    private final boolean zzR(Object obj, int i4, int i5) {
        if (zzeo.zzc(obj, zzy(i5) & 1048575) == i4) {
            return true;
        }
        return false;
    }

    private static boolean zzS(Object obj, long j4) {
        return ((Boolean) zzeo.zzf(obj, j4)).booleanValue();
    }

    private static final void zzT(int i4, Object obj, zzew zzewVar) throws IOException {
        if (obj instanceof String) {
            zzewVar.zzF(i4, (String) obj);
        } else {
            zzewVar.zzd(i4, (zzaw) obj);
        }
    }

    static zzef zzd(Object obj) {
        zzbv zzbvVar = (zzbv) obj;
        zzef zzefVar = zzbvVar.zzc;
        if (zzefVar == zzef.zzc()) {
            zzef zze = zzef.zze();
            zzbvVar.zzc = zze;
            return zze;
        }
        return zzefVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdf zzl(Class cls, zzcz zzczVar, zzdh zzdhVar, zzcq zzcqVar, zzee zzeeVar, zzbk zzbkVar, zzcx zzcxVar) {
        if (zzczVar instanceof zzdm) {
            return zzm((zzdm) zzczVar, zzdhVar, zzcqVar, zzeeVar, zzbkVar, zzcxVar);
        }
        zzeb zzebVar = (zzeb) zzczVar;
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0385  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.wearable.zzdf zzm(com.google.android.gms.internal.wearable.zzdm r34, com.google.android.gms.internal.wearable.zzdh r35, com.google.android.gms.internal.wearable.zzcq r36, com.google.android.gms.internal.wearable.zzee r37, com.google.android.gms.internal.wearable.zzbk r38, com.google.android.gms.internal.wearable.zzcx r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzdf.zzm(com.google.android.gms.internal.wearable.zzdm, com.google.android.gms.internal.wearable.zzdh, com.google.android.gms.internal.wearable.zzcq, com.google.android.gms.internal.wearable.zzee, com.google.android.gms.internal.wearable.zzbk, com.google.android.gms.internal.wearable.zzcx):com.google.android.gms.internal.wearable.zzdf");
    }

    private static double zzn(Object obj, long j4) {
        return ((Double) zzeo.zzf(obj, j4)).doubleValue();
    }

    private static float zzo(Object obj, long j4) {
        return ((Float) zzeo.zzf(obj, j4)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i4;
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int i5;
        int zzu;
        int zzi;
        int zzz;
        int zzA8;
        int i6;
        int zzA9;
        int zzA10;
        int zzA11;
        int zzB2;
        int zzA12;
        int zzd2;
        int zzA13;
        int i7;
        Unsafe unsafe = zzb;
        int i8 = 1048575;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1048575;
        while (i9 < this.zzc.length) {
            int zzB3 = zzB(i9);
            int[] iArr = this.zzc;
            int i13 = iArr[i9];
            int zzA14 = zzA(zzB3);
            if (zzA14 <= 17) {
                int i14 = iArr[i9 + 2];
                int i15 = i14 & i8;
                i4 = 1 << (i14 >>> 20);
                if (i15 != i12) {
                    i11 = unsafe.getInt(obj, i15);
                    i12 = i15;
                }
            } else {
                i4 = 0;
            }
            long j4 = zzB3 & i8;
            switch (zzA14) {
                case 0:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA = zzbe.zzA(i13 << 3);
                        zzA5 = zzA + 8;
                        i10 += zzA5;
                        break;
                    }
                case 1:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA2 = zzbe.zzA(i13 << 3);
                        zzA5 = zzA2 + 4;
                        i10 += zzA5;
                        break;
                    }
                case 2:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        long j5 = unsafe.getLong(obj, j4);
                        zzA3 = zzbe.zzA(i13 << 3);
                        zzB = zzbe.zzB(j5);
                        i10 += zzA3 + zzB;
                        break;
                    }
                case 3:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        long j6 = unsafe.getLong(obj, j4);
                        zzA3 = zzbe.zzA(i13 << 3);
                        zzB = zzbe.zzB(j6);
                        i10 += zzA3 + zzB;
                        break;
                    }
                case 4:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        int i16 = unsafe.getInt(obj, j4);
                        zzA4 = zzbe.zzA(i13 << 3);
                        zzv = zzbe.zzv(i16);
                        i5 = zzA4 + zzv;
                        i10 += i5;
                        break;
                    }
                case 5:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA = zzbe.zzA(i13 << 3);
                        zzA5 = zzA + 8;
                        i10 += zzA5;
                        break;
                    }
                case 6:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA2 = zzbe.zzA(i13 << 3);
                        zzA5 = zzA2 + 4;
                        i10 += zzA5;
                        break;
                    }
                case 7:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA5 = zzbe.zzA(i13 << 3) + 1;
                        i10 += zzA5;
                        break;
                    }
                case 8:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j4);
                        if (object instanceof zzaw) {
                            zzA6 = zzbe.zzA(i13 << 3);
                            zzd = ((zzaw) object).zzd();
                            zzA7 = zzbe.zzA(zzd);
                            i5 = zzA6 + zzA7 + zzd;
                            i10 += i5;
                            break;
                        } else {
                            zzA4 = zzbe.zzA(i13 << 3);
                            zzv = zzbe.zzy((String) object);
                            i5 = zzA4 + zzv;
                            i10 += i5;
                        }
                    }
                case 9:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA5 = zzdp.zzo(i13, unsafe.getObject(obj, j4), zzE(i9));
                        i10 += zzA5;
                        break;
                    }
                case 10:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA6 = zzbe.zzA(i13 << 3);
                        zzd = ((zzaw) unsafe.getObject(obj, j4)).zzd();
                        zzA7 = zzbe.zzA(zzd);
                        i5 = zzA6 + zzA7 + zzd;
                        i10 += i5;
                        break;
                    }
                case 11:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        int i17 = unsafe.getInt(obj, j4);
                        zzA4 = zzbe.zzA(i13 << 3);
                        zzv = zzbe.zzA(i17);
                        i5 = zzA4 + zzv;
                        i10 += i5;
                        break;
                    }
                case 12:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        int i18 = unsafe.getInt(obj, j4);
                        zzA4 = zzbe.zzA(i13 << 3);
                        zzv = zzbe.zzv(i18);
                        i5 = zzA4 + zzv;
                        i10 += i5;
                        break;
                    }
                case 13:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA2 = zzbe.zzA(i13 << 3);
                        zzA5 = zzA2 + 4;
                        i10 += zzA5;
                        break;
                    }
                case 14:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA = zzbe.zzA(i13 << 3);
                        zzA5 = zzA + 8;
                        i10 += zzA5;
                        break;
                    }
                case 15:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        int i19 = unsafe.getInt(obj, j4);
                        zzA4 = zzbe.zzA(i13 << 3);
                        zzv = zzbe.zzA((i19 >> 31) ^ (i19 + i19));
                        i5 = zzA4 + zzv;
                        i10 += i5;
                        break;
                    }
                case 16:
                    if ((i4 & i11) == 0) {
                        break;
                    } else {
                        long j7 = unsafe.getLong(obj, j4);
                        i10 += zzbe.zzA(i13 << 3) + zzbe.zzB((j7 >> 63) ^ (j7 + j7));
                        break;
                    }
                case 17:
                    if ((i11 & i4) == 0) {
                        break;
                    } else {
                        zzA5 = zzbe.zzu(i13, (zzdc) unsafe.getObject(obj, j4), zzE(i9));
                        i10 += zzA5;
                        break;
                    }
                case 18:
                    zzA5 = zzdp.zzh(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzA5;
                    break;
                case 19:
                    zzA5 = zzdp.zzf(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzA5;
                    break;
                case 20:
                    zzA5 = zzdp.zzm(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzA5;
                    break;
                case 21:
                    zzA5 = zzdp.zzx(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzA5;
                    break;
                case 22:
                    zzA5 = zzdp.zzk(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzA5;
                    break;
                case 23:
                    zzA5 = zzdp.zzh(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzA5;
                    break;
                case 24:
                    zzA5 = zzdp.zzf(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzA5;
                    break;
                case 25:
                    zzA5 = zzdp.zza(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzA5;
                    break;
                case 26:
                    zzu = zzdp.zzu(i13, (List) unsafe.getObject(obj, j4));
                    i10 += zzu;
                    break;
                case 27:
                    zzu = zzdp.zzp(i13, (List) unsafe.getObject(obj, j4), zzE(i9));
                    i10 += zzu;
                    break;
                case 28:
                    zzu = zzdp.zzc(i13, (List) unsafe.getObject(obj, j4));
                    i10 += zzu;
                    break;
                case 29:
                    zzu = zzdp.zzv(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzu;
                    break;
                case 30:
                    zzu = zzdp.zzd(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzu;
                    break;
                case 31:
                    zzu = zzdp.zzf(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzu;
                    break;
                case 32:
                    zzu = zzdp.zzh(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzu;
                    break;
                case 33:
                    zzu = zzdp.zzq(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzu;
                    break;
                case 34:
                    zzu = zzdp.zzs(i13, (List) unsafe.getObject(obj, j4), false);
                    i10 += zzu;
                    break;
                case 35:
                    zzi = zzdp.zzi((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 36:
                    zzi = zzdp.zzg((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 37:
                    zzi = zzdp.zzn((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 38:
                    zzi = zzdp.zzy((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 39:
                    zzi = zzdp.zzl((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 40:
                    zzi = zzdp.zzi((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 41:
                    zzi = zzdp.zzg((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 42:
                    zzi = zzdp.zzb((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 43:
                    zzi = zzdp.zzw((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 44:
                    zzi = zzdp.zze((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 45:
                    zzi = zzdp.zzg((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 46:
                    zzi = zzdp.zzi((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 47:
                    zzi = zzdp.zzr((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 48:
                    zzi = zzdp.zzt((List) unsafe.getObject(obj, j4));
                    if (zzi > 0) {
                        zzz = zzbe.zzz(i13);
                        zzA8 = zzbe.zzA(zzi);
                        i6 = zzz + zzA8;
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 49:
                    zzu = zzdp.zzj(i13, (List) unsafe.getObject(obj, j4), zzE(i9));
                    i10 += zzu;
                    break;
                case 50:
                    zzcx.zza(i13, unsafe.getObject(obj, j4), zzF(i9));
                    break;
                case 51:
                    if (zzR(obj, i13, i9)) {
                        zzA9 = zzbe.zzA(i13 << 3);
                        zzu = zzA9 + 8;
                        i10 += zzu;
                    }
                    break;
                case 52:
                    if (zzR(obj, i13, i9)) {
                        zzA10 = zzbe.zzA(i13 << 3);
                        zzu = zzA10 + 4;
                        i10 += zzu;
                    }
                    break;
                case 53:
                    if (zzR(obj, i13, i9)) {
                        long zzC = zzC(obj, j4);
                        zzA11 = zzbe.zzA(i13 << 3);
                        zzB2 = zzbe.zzB(zzC);
                        i10 += zzA11 + zzB2;
                    }
                    break;
                case 54:
                    if (zzR(obj, i13, i9)) {
                        long zzC2 = zzC(obj, j4);
                        zzA11 = zzbe.zzA(i13 << 3);
                        zzB2 = zzbe.zzB(zzC2);
                        i10 += zzA11 + zzB2;
                    }
                    break;
                case 55:
                    if (zzR(obj, i13, i9)) {
                        int zzr = zzr(obj, j4);
                        i6 = zzbe.zzA(i13 << 3);
                        zzi = zzbe.zzv(zzr);
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 56:
                    if (zzR(obj, i13, i9)) {
                        zzA9 = zzbe.zzA(i13 << 3);
                        zzu = zzA9 + 8;
                        i10 += zzu;
                    }
                    break;
                case 57:
                    if (zzR(obj, i13, i9)) {
                        zzA10 = zzbe.zzA(i13 << 3);
                        zzu = zzA10 + 4;
                        i10 += zzu;
                    }
                    break;
                case 58:
                    if (zzR(obj, i13, i9)) {
                        zzu = zzbe.zzA(i13 << 3) + 1;
                        i10 += zzu;
                    }
                    break;
                case 59:
                    if (zzR(obj, i13, i9)) {
                        Object object2 = unsafe.getObject(obj, j4);
                        if (object2 instanceof zzaw) {
                            zzA12 = zzbe.zzA(i13 << 3);
                            zzd2 = ((zzaw) object2).zzd();
                            zzA13 = zzbe.zzA(zzd2);
                            i7 = zzA12 + zzA13 + zzd2;
                            i10 += i7;
                        } else {
                            i6 = zzbe.zzA(i13 << 3);
                            zzi = zzbe.zzy((String) object2);
                            i7 = i6 + zzi;
                            i10 += i7;
                        }
                    }
                    break;
                case 60:
                    if (zzR(obj, i13, i9)) {
                        zzu = zzdp.zzo(i13, unsafe.getObject(obj, j4), zzE(i9));
                        i10 += zzu;
                    }
                    break;
                case 61:
                    if (zzR(obj, i13, i9)) {
                        zzA12 = zzbe.zzA(i13 << 3);
                        zzd2 = ((zzaw) unsafe.getObject(obj, j4)).zzd();
                        zzA13 = zzbe.zzA(zzd2);
                        i7 = zzA12 + zzA13 + zzd2;
                        i10 += i7;
                    }
                    break;
                case 62:
                    if (zzR(obj, i13, i9)) {
                        int zzr2 = zzr(obj, j4);
                        i6 = zzbe.zzA(i13 << 3);
                        zzi = zzbe.zzA(zzr2);
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 63:
                    if (zzR(obj, i13, i9)) {
                        int zzr3 = zzr(obj, j4);
                        i6 = zzbe.zzA(i13 << 3);
                        zzi = zzbe.zzv(zzr3);
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 64:
                    if (zzR(obj, i13, i9)) {
                        zzA10 = zzbe.zzA(i13 << 3);
                        zzu = zzA10 + 4;
                        i10 += zzu;
                    }
                    break;
                case 65:
                    if (zzR(obj, i13, i9)) {
                        zzA9 = zzbe.zzA(i13 << 3);
                        zzu = zzA9 + 8;
                        i10 += zzu;
                    }
                    break;
                case 66:
                    if (zzR(obj, i13, i9)) {
                        int zzr4 = zzr(obj, j4);
                        i6 = zzbe.zzA(i13 << 3);
                        zzi = zzbe.zzA((zzr4 >> 31) ^ (zzr4 + zzr4));
                        i7 = i6 + zzi;
                        i10 += i7;
                    }
                    break;
                case 67:
                    if (zzR(obj, i13, i9)) {
                        long zzC3 = zzC(obj, j4);
                        i10 += zzbe.zzA(i13 << 3) + zzbe.zzB((zzC3 >> 63) ^ (zzC3 + zzC3));
                    }
                    break;
                case 68:
                    if (zzR(obj, i13, i9)) {
                        zzu = zzbe.zzu(i13, (zzdc) unsafe.getObject(obj, j4), zzE(i9));
                        i10 += zzu;
                    }
                    break;
            }
            i9 += 3;
            i8 = 1048575;
        }
        zzee zzeeVar = this.zzn;
        int zza2 = i10 + zzeeVar.zza(zzeeVar.zzc(obj));
        if (!this.zzh) {
            return zza2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private final int zzq(Object obj) {
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int zzo;
        int zzz;
        int zzA8;
        int i4;
        Unsafe unsafe = zzb;
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzB2 = zzB(i6);
            int zzA9 = zzA(zzB2);
            int i7 = this.zzc[i6];
            long j4 = zzB2 & 1048575;
            if (zzA9 >= zzbp.zzJ.zza() && zzA9 <= zzbp.zzW.zza()) {
                int i8 = this.zzc[i6 + 2];
            }
            switch (zzA9) {
                case 0:
                    if (zzO(obj, i6)) {
                        zzA = zzbe.zzA(i7 << 3);
                        zzo = zzA + 8;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj, i6)) {
                        zzA2 = zzbe.zzA(i7 << 3);
                        zzo = zzA2 + 4;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj, i6)) {
                        long zzd2 = zzeo.zzd(obj, j4);
                        zzA3 = zzbe.zzA(i7 << 3);
                        zzB = zzbe.zzB(zzd2);
                        i5 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj, i6)) {
                        long zzd3 = zzeo.zzd(obj, j4);
                        zzA3 = zzbe.zzA(i7 << 3);
                        zzB = zzbe.zzB(zzd3);
                        i5 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj, i6)) {
                        int zzc = zzeo.zzc(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzv(zzc);
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj, i6)) {
                        zzA = zzbe.zzA(i7 << 3);
                        zzo = zzA + 8;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj, i6)) {
                        zzA2 = zzbe.zzA(i7 << 3);
                        zzo = zzA2 + 4;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj, i6)) {
                        zzA5 = zzbe.zzA(i7 << 3);
                        zzo = zzA5 + 1;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzO(obj, i6)) {
                        break;
                    } else {
                        Object zzf = zzeo.zzf(obj, j4);
                        if (zzf instanceof zzaw) {
                            zzA6 = zzbe.zzA(i7 << 3);
                            zzd = ((zzaw) zzf).zzd();
                            zzA7 = zzbe.zzA(zzd);
                            i4 = zzA6 + zzA7 + zzd;
                            i5 += i4;
                            break;
                        } else {
                            zzA4 = zzbe.zzA(i7 << 3);
                            zzv = zzbe.zzy((String) zzf);
                            i4 = zzA4 + zzv;
                            i5 += i4;
                        }
                    }
                case 9:
                    if (zzO(obj, i6)) {
                        zzo = zzdp.zzo(i7, zzeo.zzf(obj, j4), zzE(i6));
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzO(obj, i6)) {
                        zzA6 = zzbe.zzA(i7 << 3);
                        zzd = ((zzaw) zzeo.zzf(obj, j4)).zzd();
                        zzA7 = zzbe.zzA(zzd);
                        i4 = zzA6 + zzA7 + zzd;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj, i6)) {
                        int zzc2 = zzeo.zzc(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzA(zzc2);
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj, i6)) {
                        int zzc3 = zzeo.zzc(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzv(zzc3);
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj, i6)) {
                        zzA2 = zzbe.zzA(i7 << 3);
                        zzo = zzA2 + 4;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj, i6)) {
                        zzA = zzbe.zzA(i7 << 3);
                        zzo = zzA + 8;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj, i6)) {
                        int zzc4 = zzeo.zzc(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzA((zzc4 >> 31) ^ (zzc4 + zzc4));
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj, i6)) {
                        long zzd4 = zzeo.zzd(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzB((zzd4 >> 63) ^ (zzd4 + zzd4));
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzO(obj, i6)) {
                        zzo = zzbe.zzu(i7, (zzdc) zzeo.zzf(obj, j4), zzE(i6));
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzo = zzdp.zzh(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 19:
                    zzo = zzdp.zzf(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 20:
                    zzo = zzdp.zzm(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 21:
                    zzo = zzdp.zzx(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 22:
                    zzo = zzdp.zzk(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 23:
                    zzo = zzdp.zzh(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 24:
                    zzo = zzdp.zzf(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 25:
                    zzo = zzdp.zza(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 26:
                    zzo = zzdp.zzu(i7, (List) zzeo.zzf(obj, j4));
                    i5 += zzo;
                    break;
                case 27:
                    zzo = zzdp.zzp(i7, (List) zzeo.zzf(obj, j4), zzE(i6));
                    i5 += zzo;
                    break;
                case 28:
                    zzo = zzdp.zzc(i7, (List) zzeo.zzf(obj, j4));
                    i5 += zzo;
                    break;
                case 29:
                    zzo = zzdp.zzv(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 30:
                    zzo = zzdp.zzd(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 31:
                    zzo = zzdp.zzf(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 32:
                    zzo = zzdp.zzh(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 33:
                    zzo = zzdp.zzq(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 34:
                    zzo = zzdp.zzs(i7, (List) zzeo.zzf(obj, j4), false);
                    i5 += zzo;
                    break;
                case 35:
                    zzv = zzdp.zzi((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzdp.zzg((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzdp.zzn((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzdp.zzy((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzdp.zzl((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzdp.zzi((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzdp.zzg((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzdp.zzb((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzdp.zzw((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzdp.zze((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzdp.zzg((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzdp.zzi((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzdp.zzr((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzdp.zzt((List) unsafe.getObject(obj, j4));
                    if (zzv > 0) {
                        zzz = zzbe.zzz(i7);
                        zzA8 = zzbe.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzo = zzdp.zzj(i7, (List) zzeo.zzf(obj, j4), zzE(i6));
                    i5 += zzo;
                    break;
                case 50:
                    zzcx.zza(i7, zzeo.zzf(obj, j4), zzF(i6));
                    break;
                case 51:
                    if (zzR(obj, i7, i6)) {
                        zzA = zzbe.zzA(i7 << 3);
                        zzo = zzA + 8;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i7, i6)) {
                        zzA2 = zzbe.zzA(i7 << 3);
                        zzo = zzA2 + 4;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i7, i6)) {
                        long zzC = zzC(obj, j4);
                        zzA3 = zzbe.zzA(i7 << 3);
                        zzB = zzbe.zzB(zzC);
                        i5 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i7, i6)) {
                        long zzC2 = zzC(obj, j4);
                        zzA3 = zzbe.zzA(i7 << 3);
                        zzB = zzbe.zzB(zzC2);
                        i5 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i7, i6)) {
                        int zzr = zzr(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzv(zzr);
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i7, i6)) {
                        zzA = zzbe.zzA(i7 << 3);
                        zzo = zzA + 8;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i7, i6)) {
                        zzA2 = zzbe.zzA(i7 << 3);
                        zzo = zzA2 + 4;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i7, i6)) {
                        zzA5 = zzbe.zzA(i7 << 3);
                        zzo = zzA5 + 1;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzR(obj, i7, i6)) {
                        break;
                    } else {
                        Object zzf2 = zzeo.zzf(obj, j4);
                        if (zzf2 instanceof zzaw) {
                            zzA6 = zzbe.zzA(i7 << 3);
                            zzd = ((zzaw) zzf2).zzd();
                            zzA7 = zzbe.zzA(zzd);
                            i4 = zzA6 + zzA7 + zzd;
                            i5 += i4;
                            break;
                        } else {
                            zzA4 = zzbe.zzA(i7 << 3);
                            zzv = zzbe.zzy((String) zzf2);
                            i4 = zzA4 + zzv;
                            i5 += i4;
                        }
                    }
                case 60:
                    if (zzR(obj, i7, i6)) {
                        zzo = zzdp.zzo(i7, zzeo.zzf(obj, j4), zzE(i6));
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i7, i6)) {
                        zzA6 = zzbe.zzA(i7 << 3);
                        zzd = ((zzaw) zzeo.zzf(obj, j4)).zzd();
                        zzA7 = zzbe.zzA(zzd);
                        i4 = zzA6 + zzA7 + zzd;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i7, i6)) {
                        int zzr2 = zzr(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzA(zzr2);
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i7, i6)) {
                        int zzr3 = zzr(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzv(zzr3);
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i7, i6)) {
                        zzA2 = zzbe.zzA(i7 << 3);
                        zzo = zzA2 + 4;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i7, i6)) {
                        zzA = zzbe.zzA(i7 << 3);
                        zzo = zzA + 8;
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i7, i6)) {
                        int zzr4 = zzr(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzA((zzr4 >> 31) ^ (zzr4 + zzr4));
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i7, i6)) {
                        long zzC3 = zzC(obj, j4);
                        zzA4 = zzbe.zzA(i7 << 3);
                        zzv = zzbe.zzB((zzC3 >> 63) ^ (zzC3 + zzC3));
                        i4 = zzA4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i7, i6)) {
                        zzo = zzbe.zzu(i7, (zzdc) zzeo.zzf(obj, j4), zzE(i6));
                        i5 += zzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzee zzeeVar = this.zzn;
        return i5 + zzeeVar.zza(zzeeVar.zzc(obj));
    }

    private static int zzr(Object obj, long j4) {
        return ((Integer) zzeo.zzf(obj, j4)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i4, int i5, int i6, long j4, zzaj zzajVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i6);
        Object object = unsafe.getObject(obj, j4);
        if (!((zzcw) object).zze()) {
            zzcw zzb2 = zzcw.zza().zzb();
            zzcx.zzb(zzb2, object);
            unsafe.putObject(obj, j4, zzb2);
        }
        zzcv zzcvVar = (zzcv) zzF;
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4, int i11, zzaj zzajVar) throws IOException {
        Unsafe unsafe = zzb;
        long j5 = this.zzc[i11 + 2] & 1048575;
        switch (i10) {
            case 51:
                if (i8 == 1) {
                    unsafe.putObject(obj, j4, Double.valueOf(Double.longBitsToDouble(zzak.zzn(bArr, i4))));
                    unsafe.putInt(obj, j5, i7);
                    return i4 + 8;
                }
                break;
            case 52:
                if (i8 == 5) {
                    unsafe.putObject(obj, j4, Float.valueOf(Float.intBitsToFloat(zzak.zzb(bArr, i4))));
                    unsafe.putInt(obj, j5, i7);
                    return i4 + 4;
                }
                break;
            case 53:
            case 54:
                if (i8 == 0) {
                    int zzm = zzak.zzm(bArr, i4, zzajVar);
                    unsafe.putObject(obj, j4, Long.valueOf(zzajVar.zzb));
                    unsafe.putInt(obj, j5, i7);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i8 == 0) {
                    int zzj = zzak.zzj(bArr, i4, zzajVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(zzajVar.zza));
                    unsafe.putInt(obj, j5, i7);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i8 == 1) {
                    unsafe.putObject(obj, j4, Long.valueOf(zzak.zzn(bArr, i4)));
                    unsafe.putInt(obj, j5, i7);
                    return i4 + 8;
                }
                break;
            case 57:
            case 64:
                if (i8 == 5) {
                    unsafe.putObject(obj, j4, Integer.valueOf(zzak.zzb(bArr, i4)));
                    unsafe.putInt(obj, j5, i7);
                    return i4 + 4;
                }
                break;
            case 58:
                if (i8 == 0) {
                    int zzm2 = zzak.zzm(bArr, i4, zzajVar);
                    unsafe.putObject(obj, j4, Boolean.valueOf(zzajVar.zzb != 0));
                    unsafe.putInt(obj, j5, i7);
                    return zzm2;
                }
                break;
            case 59:
                if (i8 == 2) {
                    int zzj2 = zzak.zzj(bArr, i4, zzajVar);
                    int i12 = zzajVar.zza;
                    if (i12 == 0) {
                        unsafe.putObject(obj, j4, "");
                    } else if ((i9 & 536870912) != 0 && !zzet.zzf(bArr, zzj2, zzj2 + i12)) {
                        throw zzcf.zzc();
                    } else {
                        unsafe.putObject(obj, j4, new String(bArr, zzj2, i12, zzcd.zzb));
                        zzj2 += i12;
                    }
                    unsafe.putInt(obj, j5, i7);
                    return zzj2;
                }
                break;
            case 60:
                if (i8 == 2) {
                    int zzd = zzak.zzd(zzE(i11), bArr, i4, i5, zzajVar);
                    Object object = unsafe.getInt(obj, j5) == i7 ? unsafe.getObject(obj, j4) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j4, zzajVar.zzc);
                    } else {
                        unsafe.putObject(obj, j4, zzcd.zzg(object, zzajVar.zzc));
                    }
                    unsafe.putInt(obj, j5, i7);
                    return zzd;
                }
                break;
            case 61:
                if (i8 == 2) {
                    int zza2 = zzak.zza(bArr, i4, zzajVar);
                    unsafe.putObject(obj, j4, zzajVar.zzc);
                    unsafe.putInt(obj, j5, i7);
                    return zza2;
                }
                break;
            case 63:
                if (i8 == 0) {
                    int zzj3 = zzak.zzj(bArr, i4, zzajVar);
                    int i13 = zzajVar.zza;
                    zzbz zzD = zzD(i11);
                    if (zzD != null && !zzD.zza(i13)) {
                        zzd(obj).zzh(i6, Long.valueOf(i13));
                    } else {
                        unsafe.putObject(obj, j4, Integer.valueOf(i13));
                        unsafe.putInt(obj, j5, i7);
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i8 == 0) {
                    int zzj4 = zzak.zzj(bArr, i4, zzajVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(zzba.zzb(zzajVar.zza)));
                    unsafe.putInt(obj, j5, i7);
                    return zzj4;
                }
                break;
            case 67:
                if (i8 == 0) {
                    int zzm3 = zzak.zzm(bArr, i4, zzajVar);
                    unsafe.putObject(obj, j4, Long.valueOf(zzba.zzc(zzajVar.zzb)));
                    unsafe.putInt(obj, j5, i7);
                    return zzm3;
                }
                break;
            case 68:
                if (i8 == 3) {
                    int zzc = zzak.zzc(zzE(i11), bArr, i4, i5, (i6 & (-8)) | 4, zzajVar);
                    Object object2 = unsafe.getInt(obj, j5) == i7 ? unsafe.getObject(obj, j4) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj, j4, zzajVar.zzc);
                    } else {
                        unsafe.putObject(obj, j4, zzcd.zzg(object2, zzajVar.zzc));
                    }
                    unsafe.putInt(obj, j5, i7);
                    return zzc;
                }
                break;
        }
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v21, types: [int] */
    private final int zzu(Object obj, byte[] bArr, int i4, int i5, zzaj zzajVar) throws IOException {
        byte b4;
        int i6;
        int zzw;
        int i7;
        int i8;
        Unsafe unsafe;
        int i9;
        int i10;
        int i11;
        int zzm;
        int zzd;
        int i12;
        int i13;
        int i14;
        zzdf<T> zzdfVar = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i15 = i5;
        zzaj zzajVar2 = zzajVar;
        Unsafe unsafe2 = zzb;
        int i16 = 1048575;
        int i17 = -1;
        int i18 = i4;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        int i22 = 1048575;
        while (i18 < i15) {
            int i23 = i18 + 1;
            byte b5 = bArr2[i18];
            if (b5 < 0) {
                i6 = zzak.zzk(b5, bArr2, i23, zzajVar2);
                b4 = zzajVar2.zza;
            } else {
                b4 = b5;
                i6 = i23;
            }
            int i24 = b4 >>> 3;
            int i25 = b4 & 7;
            if (i24 > i19) {
                zzw = zzdfVar.zzx(i24, i20 / 3);
            } else {
                zzw = zzdfVar.zzw(i24);
            }
            int i26 = zzw;
            if (i26 == i17) {
                i7 = i6;
                i8 = i24;
                unsafe = unsafe2;
                i9 = 0;
            } else {
                int[] iArr = zzdfVar.zzc;
                int i27 = iArr[i26 + 1];
                int zzA = zzA(i27);
                long j4 = i27 & i16;
                if (zzA <= 17) {
                    int i28 = iArr[i26 + 2];
                    int i29 = 1 << (i28 >>> 20);
                    int i30 = i28 & 1048575;
                    if (i30 != i22) {
                        if (i22 != 1048575) {
                            unsafe2.putInt(obj2, i22, i21);
                        }
                        if (i30 != 1048575) {
                            i21 = unsafe2.getInt(obj2, i30);
                        }
                        i22 = i30;
                    }
                    switch (zzA) {
                        case 0:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i11 = i6;
                            i8 = i24;
                            if (i25 == 1) {
                                zzeo.zzo(obj2, j4, Double.longBitsToDouble(zzak.zzn(bArr2, i11)));
                                i18 = i11 + 8;
                                i21 |= i29;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 1:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i11 = i6;
                            i8 = i24;
                            if (i25 == 5) {
                                zzeo.zzp(obj2, j4, Float.intBitsToFloat(zzak.zzb(bArr2, i11)));
                                i18 = i11 + 4;
                                i21 |= i29;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 2:
                        case 3:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i11 = i6;
                            i8 = i24;
                            if (i25 == 0) {
                                zzm = zzak.zzm(bArr2, i11, zzajVar2);
                                unsafe2.putLong(obj, j4, zzajVar2.zzb);
                                i21 |= i29;
                                i18 = zzm;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 4:
                        case 11:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i11 = i6;
                            i8 = i24;
                            if (i25 == 0) {
                                i18 = zzak.zzj(bArr2, i11, zzajVar2);
                                unsafe2.putInt(obj2, j4, zzajVar2.zza);
                                i21 |= i29;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 5:
                        case 14:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i8 = i24;
                            if (i25 == 1) {
                                i11 = i6;
                                unsafe2.putLong(obj, j4, zzak.zzn(bArr2, i6));
                                i18 = i11 + 8;
                                i21 |= i29;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 6:
                        case 13:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i8 = i24;
                            if (i25 == 5) {
                                unsafe2.putInt(obj2, j4, zzak.zzb(bArr2, i6));
                                i18 = i6 + 4;
                                i21 |= i29;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 7:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i8 = i24;
                            if (i25 == 0) {
                                i18 = zzak.zzm(bArr2, i6, zzajVar2);
                                zzeo.zzm(obj2, j4, zzajVar2.zzb != 0);
                                i21 |= i29;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 8:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i8 = i24;
                            if (i25 == 2) {
                                if ((536870912 & i27) == 0) {
                                    i18 = zzak.zzg(bArr2, i6, zzajVar2);
                                } else {
                                    i18 = zzak.zzh(bArr2, i6, zzajVar2);
                                }
                                unsafe2.putObject(obj2, j4, zzajVar2.zzc);
                                i21 |= i29;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 9:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i8 = i24;
                            if (i25 == 2) {
                                zzd = zzak.zzd(zzdfVar.zzE(i10), bArr2, i6, i15, zzajVar2);
                                Object object = unsafe2.getObject(obj2, j4);
                                if (object == null) {
                                    unsafe2.putObject(obj2, j4, zzajVar2.zzc);
                                } else {
                                    unsafe2.putObject(obj2, j4, zzcd.zzg(object, zzajVar2.zzc));
                                }
                                i21 |= i29;
                                i18 = zzd;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 10:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i8 = i24;
                            if (i25 == 2) {
                                zzd = zzak.zza(bArr2, i6, zzajVar2);
                                unsafe2.putObject(obj2, j4, zzajVar2.zzc);
                                i21 |= i29;
                                i18 = zzd;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 12:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i8 = i24;
                            if (i25 == 0) {
                                zzd = zzak.zzj(bArr2, i6, zzajVar2);
                                unsafe2.putInt(obj2, j4, zzajVar2.zza);
                                i21 |= i29;
                                i18 = zzd;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 15:
                            zzajVar2 = zzajVar;
                            i10 = i26;
                            i8 = i24;
                            if (i25 == 0) {
                                zzd = zzak.zzj(bArr2, i6, zzajVar2);
                                unsafe2.putInt(obj2, j4, zzba.zzb(zzajVar2.zza));
                                i21 |= i29;
                                i18 = zzd;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                        case 16:
                            if (i25 != 0) {
                                i8 = i24;
                                i10 = i26;
                                i11 = i6;
                                i7 = i11;
                                unsafe = unsafe2;
                                i9 = i10;
                                break;
                            } else {
                                zzajVar2 = zzajVar;
                                zzm = zzak.zzm(bArr2, i6, zzajVar2);
                                i10 = i26;
                                i8 = i24;
                                unsafe2.putLong(obj, j4, zzba.zzc(zzajVar2.zzb));
                                i21 |= i29;
                                i18 = zzm;
                                i20 = i10;
                                i19 = i8;
                                break;
                            }
                        default:
                            i8 = i24;
                            i10 = i26;
                            i11 = i6;
                            i7 = i11;
                            unsafe = unsafe2;
                            i9 = i10;
                            break;
                    }
                } else {
                    zzajVar2 = zzajVar;
                    i10 = i26;
                    int i31 = i6;
                    i8 = i24;
                    if (zzA == 27) {
                        if (i25 == 2) {
                            zzcc zzccVar = (zzcc) unsafe2.getObject(obj2, j4);
                            if (!zzccVar.zzc()) {
                                int size = zzccVar.size();
                                zzccVar = zzccVar.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj2, j4, zzccVar);
                            }
                            i18 = zzak.zze(zzdfVar.zzE(i10), b4, bArr, i31, i5, zzccVar, zzajVar);
                            i21 = i21;
                            i20 = i10;
                            i19 = i8;
                        } else {
                            i12 = i31;
                            i13 = i21;
                            i14 = i22;
                            unsafe = unsafe2;
                            i9 = i10;
                        }
                    } else if (zzA <= 49) {
                        i13 = i21;
                        i14 = i22;
                        unsafe = unsafe2;
                        i9 = i10;
                        i18 = zzv(obj, bArr, i31, i5, b4, i8, i25, i10, i27, zzA, j4, zzajVar);
                        if (i18 != i31) {
                            obj2 = obj;
                            bArr2 = bArr;
                            i15 = i5;
                            zzajVar2 = zzajVar;
                            i22 = i14;
                            i19 = i8;
                            i21 = i13;
                            i20 = i9;
                            unsafe2 = unsafe;
                            i17 = -1;
                            i16 = 1048575;
                            zzdfVar = this;
                        } else {
                            i7 = i18;
                            i22 = i14;
                            i21 = i13;
                        }
                    } else {
                        i12 = i31;
                        i13 = i21;
                        i14 = i22;
                        unsafe = unsafe2;
                        i9 = i10;
                        if (zzA != 50) {
                            i18 = zzt(obj, bArr, i12, i5, b4, i8, i25, i27, zzA, j4, i9, zzajVar);
                            if (i18 != i12) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i15 = i5;
                                zzajVar2 = zzajVar;
                                i22 = i14;
                                i19 = i8;
                                i21 = i13;
                                i20 = i9;
                                unsafe2 = unsafe;
                                i17 = -1;
                                i16 = 1048575;
                                zzdfVar = this;
                            } else {
                                i7 = i18;
                                i22 = i14;
                                i21 = i13;
                            }
                        } else if (i25 == 2) {
                            i18 = zzs(obj, bArr, i12, i5, i9, j4, zzajVar);
                            if (i18 != i12) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i15 = i5;
                                zzajVar2 = zzajVar;
                                i22 = i14;
                                i19 = i8;
                                i21 = i13;
                                i20 = i9;
                                unsafe2 = unsafe;
                                i17 = -1;
                                i16 = 1048575;
                                zzdfVar = this;
                            } else {
                                i7 = i18;
                                i22 = i14;
                                i21 = i13;
                            }
                        }
                    }
                    i7 = i12;
                    i22 = i14;
                    i21 = i13;
                }
                i17 = -1;
                i16 = 1048575;
            }
            i18 = zzak.zzi(b4, bArr, i7, i5, zzd(obj), zzajVar);
            zzdfVar = this;
            obj2 = obj;
            bArr2 = bArr;
            i15 = i5;
            zzajVar2 = zzajVar;
            i19 = i8;
            i20 = i9;
            unsafe2 = unsafe;
            i17 = -1;
            i16 = 1048575;
        }
        int i32 = i21;
        int i33 = i22;
        Unsafe unsafe3 = unsafe2;
        if (i33 != 1048575) {
            unsafe3.putInt(obj, i33, i32);
        }
        if (i18 == i5) {
            return i18;
        }
        throw zzcf.zze();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x021a -> B:120:0x021b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x014f -> B:67:0x0150). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01cc -> B:100:0x01cd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzv(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.wearable.zzaj r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzdf.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.wearable.zzaj):int");
    }

    private final int zzw(int i4) {
        if (i4 >= this.zze && i4 <= this.zzf) {
            return zzz(i4, 0);
        }
        return -1;
    }

    private final int zzx(int i4, int i5) {
        if (i4 >= this.zze && i4 <= this.zzf) {
            return zzz(i4, i5);
        }
        return -1;
    }

    private final int zzy(int i4) {
        return this.zzc[i4 + 2];
    }

    private final int zzz(int i4, int i5) {
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

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final int zza(Object obj) {
        if (this.zzi) {
            return zzq(obj);
        }
        return zzp(obj);
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final int zzb(Object obj) {
        int i4;
        int zzc;
        int length = this.zzc.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int zzB = zzB(i6);
            int i7 = this.zzc[i6];
            long j4 = 1048575 & zzB;
            int i8 = 37;
            switch (zzA(zzB)) {
                case 0:
                    i4 = i5 * 53;
                    zzc = zzcd.zzc(Double.doubleToLongBits(zzeo.zza(obj, j4)));
                    i5 = i4 + zzc;
                    break;
                case 1:
                    i4 = i5 * 53;
                    zzc = Float.floatToIntBits(zzeo.zzb(obj, j4));
                    i5 = i4 + zzc;
                    break;
                case 2:
                    i4 = i5 * 53;
                    zzc = zzcd.zzc(zzeo.zzd(obj, j4));
                    i5 = i4 + zzc;
                    break;
                case 3:
                    i4 = i5 * 53;
                    zzc = zzcd.zzc(zzeo.zzd(obj, j4));
                    i5 = i4 + zzc;
                    break;
                case 4:
                    i4 = i5 * 53;
                    zzc = zzeo.zzc(obj, j4);
                    i5 = i4 + zzc;
                    break;
                case 5:
                    i4 = i5 * 53;
                    zzc = zzcd.zzc(zzeo.zzd(obj, j4));
                    i5 = i4 + zzc;
                    break;
                case 6:
                    i4 = i5 * 53;
                    zzc = zzeo.zzc(obj, j4);
                    i5 = i4 + zzc;
                    break;
                case 7:
                    i4 = i5 * 53;
                    zzc = zzcd.zza(zzeo.zzw(obj, j4));
                    i5 = i4 + zzc;
                    break;
                case 8:
                    i4 = i5 * 53;
                    zzc = ((String) zzeo.zzf(obj, j4)).hashCode();
                    i5 = i4 + zzc;
                    break;
                case 9:
                    Object zzf = zzeo.zzf(obj, j4);
                    if (zzf != null) {
                        i8 = zzf.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 10:
                    i4 = i5 * 53;
                    zzc = zzeo.zzf(obj, j4).hashCode();
                    i5 = i4 + zzc;
                    break;
                case 11:
                    i4 = i5 * 53;
                    zzc = zzeo.zzc(obj, j4);
                    i5 = i4 + zzc;
                    break;
                case 12:
                    i4 = i5 * 53;
                    zzc = zzeo.zzc(obj, j4);
                    i5 = i4 + zzc;
                    break;
                case 13:
                    i4 = i5 * 53;
                    zzc = zzeo.zzc(obj, j4);
                    i5 = i4 + zzc;
                    break;
                case 14:
                    i4 = i5 * 53;
                    zzc = zzcd.zzc(zzeo.zzd(obj, j4));
                    i5 = i4 + zzc;
                    break;
                case 15:
                    i4 = i5 * 53;
                    zzc = zzeo.zzc(obj, j4);
                    i5 = i4 + zzc;
                    break;
                case 16:
                    i4 = i5 * 53;
                    zzc = zzcd.zzc(zzeo.zzd(obj, j4));
                    i5 = i4 + zzc;
                    break;
                case 17:
                    Object zzf2 = zzeo.zzf(obj, j4);
                    if (zzf2 != null) {
                        i8 = zzf2.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
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
                    i4 = i5 * 53;
                    zzc = zzeo.zzf(obj, j4).hashCode();
                    i5 = i4 + zzc;
                    break;
                case 50:
                    i4 = i5 * 53;
                    zzc = zzeo.zzf(obj, j4).hashCode();
                    i5 = i4 + zzc;
                    break;
                case 51:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzcd.zzc(Double.doubleToLongBits(zzn(obj, j4)));
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = Float.floatToIntBits(zzo(obj, j4));
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzcd.zzc(zzC(obj, j4));
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzcd.zzc(zzC(obj, j4));
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzr(obj, j4);
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzcd.zzc(zzC(obj, j4));
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzr(obj, j4);
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzcd.zza(zzS(obj, j4));
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = ((String) zzeo.zzf(obj, j4)).hashCode();
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzeo.zzf(obj, j4).hashCode();
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzeo.zzf(obj, j4).hashCode();
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzr(obj, j4);
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzr(obj, j4);
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzr(obj, j4);
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzcd.zzc(zzC(obj, j4));
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzr(obj, j4);
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzcd.zzc(zzC(obj, j4));
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i7, i6)) {
                        i4 = i5 * 53;
                        zzc = zzeo.zzf(obj, j4).hashCode();
                        i5 = i4 + zzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i5 * 53) + this.zzn.zzc(obj).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0368, code lost:
        if (r0 != r21) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x036a, code lost:
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r9 = r35;
        r1 = r18;
        r3 = r19;
        r5 = r21;
        r2 = r24;
        r6 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0384, code lost:
        r2 = r0;
        r7 = r18;
        r6 = r25;
        r0 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x03b4, code lost:
        if (r0 != r15) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03d9, code lost:
        if (r0 != r15) goto L212;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.wearable.zzaj r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzdf.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.wearable.zzaj):int");
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final Object zze() {
        return ((zzbv) this.zzg).zzG(4, null, null);
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzf(Object obj) {
        int i4;
        int i5 = this.zzk;
        while (true) {
            i4 = this.zzl;
            if (i5 >= i4) {
                break;
            }
            long zzB = zzB(this.zzj[i5]) & 1048575;
            Object zzf = zzeo.zzf(obj, zzB);
            if (zzf != null) {
                ((zzcw) zzf).zzc();
                zzeo.zzs(obj, zzB, zzf);
            }
            i5++;
        }
        int length = this.zzj.length;
        while (i4 < length) {
            this.zzm.zza(obj, this.zzj[i4]);
            i4++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzB = zzB(i4);
            long j4 = 1048575 & zzB;
            int i5 = this.zzc[i4];
            switch (zzA(zzB)) {
                case 0:
                    if (zzO(obj2, i4)) {
                        zzeo.zzo(obj, j4, zzeo.zza(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj2, i4)) {
                        zzeo.zzp(obj, j4, zzeo.zzb(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj2, i4)) {
                        zzeo.zzr(obj, j4, zzeo.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj2, i4)) {
                        zzeo.zzr(obj, j4, zzeo.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj2, i4)) {
                        zzeo.zzq(obj, j4, zzeo.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj2, i4)) {
                        zzeo.zzr(obj, j4, zzeo.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj2, i4)) {
                        zzeo.zzq(obj, j4, zzeo.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj2, i4)) {
                        zzeo.zzm(obj, j4, zzeo.zzw(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzO(obj2, i4)) {
                        zzeo.zzs(obj, j4, zzeo.zzf(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i4);
                    break;
                case 10:
                    if (zzO(obj2, i4)) {
                        zzeo.zzs(obj, j4, zzeo.zzf(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj2, i4)) {
                        zzeo.zzq(obj, j4, zzeo.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj2, i4)) {
                        zzeo.zzq(obj, j4, zzeo.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj2, i4)) {
                        zzeo.zzq(obj, j4, zzeo.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj2, i4)) {
                        zzeo.zzr(obj, j4, zzeo.zzd(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj2, i4)) {
                        zzeo.zzq(obj, j4, zzeo.zzc(obj2, j4));
                        zzJ(obj, i4);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj2, i4)) {
                        zzeo.zzr(obj, j4, zzeo.zzd(obj2, j4));
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
                    zzdp.zzaa(this.zzq, obj, obj2, j4);
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
                        zzeo.zzs(obj, j4, zzeo.zzf(obj2, j4));
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
                    if (zzR(obj2, i5, i4)) {
                        zzeo.zzs(obj, j4, zzeo.zzf(obj2, j4));
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
        zzdp.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzdp.zzE(this.zzo, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzh(Object obj, byte[] bArr, int i4, int i5, zzaj zzajVar) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i4, i5, zzajVar);
        } else {
            zzc(obj, bArr, i4, i5, 0, zzajVar);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzi(Object obj, zzew zzewVar) throws IOException {
        if (this.zzi) {
            if (!this.zzh) {
                int length = this.zzc.length;
                for (int i4 = 0; i4 < length; i4 += 3) {
                    int zzB = zzB(i4);
                    int i5 = this.zzc[i4];
                    switch (zzA(zzB)) {
                        case 0:
                            if (zzO(obj, i4)) {
                                zzewVar.zzf(i5, zzeo.zza(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (zzO(obj, i4)) {
                                zzewVar.zzo(i5, zzeo.zzb(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (zzO(obj, i4)) {
                                zzewVar.zzt(i5, zzeo.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (zzO(obj, i4)) {
                                zzewVar.zzJ(i5, zzeo.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (zzO(obj, i4)) {
                                zzewVar.zzr(i5, zzeo.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (zzO(obj, i4)) {
                                zzewVar.zzm(i5, zzeo.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (zzO(obj, i4)) {
                                zzewVar.zzk(i5, zzeo.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (zzO(obj, i4)) {
                                zzewVar.zzb(i5, zzeo.zzw(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (zzO(obj, i4)) {
                                zzT(i5, zzeo.zzf(obj, zzB & 1048575), zzewVar);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (zzO(obj, i4)) {
                                zzewVar.zzv(i5, zzeo.zzf(obj, zzB & 1048575), zzE(i4));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (zzO(obj, i4)) {
                                zzewVar.zzd(i5, (zzaw) zzeo.zzf(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (zzO(obj, i4)) {
                                zzewVar.zzH(i5, zzeo.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (zzO(obj, i4)) {
                                zzewVar.zzi(i5, zzeo.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (zzO(obj, i4)) {
                                zzewVar.zzw(i5, zzeo.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (zzO(obj, i4)) {
                                zzewVar.zzy(i5, zzeo.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (zzO(obj, i4)) {
                                zzewVar.zzA(i5, zzeo.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (zzO(obj, i4)) {
                                zzewVar.zzC(i5, zzeo.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (zzO(obj, i4)) {
                                zzewVar.zzq(i5, zzeo.zzf(obj, zzB & 1048575), zzE(i4));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            zzdp.zzJ(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 19:
                            zzdp.zzN(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 20:
                            zzdp.zzQ(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 21:
                            zzdp.zzY(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 22:
                            zzdp.zzP(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 23:
                            zzdp.zzM(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 24:
                            zzdp.zzL(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 25:
                            zzdp.zzH(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 26:
                            zzdp.zzW(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar);
                            break;
                        case 27:
                            zzdp.zzR(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, zzE(i4));
                            break;
                        case 28:
                            zzdp.zzI(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar);
                            break;
                        case 29:
                            zzdp.zzX(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 30:
                            zzdp.zzK(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 31:
                            zzdp.zzS(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 32:
                            zzdp.zzT(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 33:
                            zzdp.zzU(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 34:
                            zzdp.zzV(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, false);
                            break;
                        case 35:
                            zzdp.zzJ(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 36:
                            zzdp.zzN(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 37:
                            zzdp.zzQ(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 38:
                            zzdp.zzY(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 39:
                            zzdp.zzP(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 40:
                            zzdp.zzM(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 41:
                            zzdp.zzL(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 42:
                            zzdp.zzH(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 43:
                            zzdp.zzX(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 44:
                            zzdp.zzK(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 45:
                            zzdp.zzS(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 46:
                            zzdp.zzT(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 47:
                            zzdp.zzU(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 48:
                            zzdp.zzV(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, true);
                            break;
                        case 49:
                            zzdp.zzO(i5, (List) zzeo.zzf(obj, zzB & 1048575), zzewVar, zzE(i4));
                            break;
                        case 50:
                            zzM(zzewVar, i5, zzeo.zzf(obj, zzB & 1048575), i4);
                            break;
                        case 51:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzf(i5, zzn(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzo(i5, zzo(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzt(i5, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzJ(i5, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzr(i5, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzm(i5, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzk(i5, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzb(i5, zzS(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (zzR(obj, i5, i4)) {
                                zzT(i5, zzeo.zzf(obj, zzB & 1048575), zzewVar);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzv(i5, zzeo.zzf(obj, zzB & 1048575), zzE(i4));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzd(i5, (zzaw) zzeo.zzf(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzH(i5, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzi(i5, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzw(i5, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzy(i5, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzA(i5, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzC(i5, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (zzR(obj, i5, i4)) {
                                zzewVar.zzq(i5, zzeo.zzf(obj, zzB & 1048575), zzE(i4));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                zzee zzeeVar = this.zzn;
                zzeeVar.zzi(zzeeVar.zzc(obj), zzewVar);
                return;
            }
            this.zzo.zza(obj);
            throw null;
        }
        zzL(obj, zzewVar);
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzZ;
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzB = zzB(i4);
            long j4 = zzB & 1048575;
            switch (zzA(zzB)) {
                case 0:
                    if (zzN(obj, obj2, i4) && Double.doubleToLongBits(zzeo.zza(obj, j4)) == Double.doubleToLongBits(zzeo.zza(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzN(obj, obj2, i4) && Float.floatToIntBits(zzeo.zzb(obj, j4)) == Float.floatToIntBits(zzeo.zzb(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzN(obj, obj2, i4) && zzeo.zzd(obj, j4) == zzeo.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzN(obj, obj2, i4) && zzeo.zzd(obj, j4) == zzeo.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzN(obj, obj2, i4) && zzeo.zzc(obj, j4) == zzeo.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzN(obj, obj2, i4) && zzeo.zzd(obj, j4) == zzeo.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzN(obj, obj2, i4) && zzeo.zzc(obj, j4) == zzeo.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzN(obj, obj2, i4) && zzeo.zzw(obj, j4) == zzeo.zzw(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzN(obj, obj2, i4) && zzdp.zzZ(zzeo.zzf(obj, j4), zzeo.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzN(obj, obj2, i4) && zzdp.zzZ(zzeo.zzf(obj, j4), zzeo.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzN(obj, obj2, i4) && zzdp.zzZ(zzeo.zzf(obj, j4), zzeo.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzN(obj, obj2, i4) && zzeo.zzc(obj, j4) == zzeo.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzN(obj, obj2, i4) && zzeo.zzc(obj, j4) == zzeo.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzN(obj, obj2, i4) && zzeo.zzc(obj, j4) == zzeo.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzN(obj, obj2, i4) && zzeo.zzd(obj, j4) == zzeo.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzN(obj, obj2, i4) && zzeo.zzc(obj, j4) == zzeo.zzc(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzN(obj, obj2, i4) && zzeo.zzd(obj, j4) == zzeo.zzd(obj2, j4)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzN(obj, obj2, i4) && zzdp.zzZ(zzeo.zzf(obj, j4), zzeo.zzf(obj2, j4))) {
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
                    zzZ = zzdp.zzZ(zzeo.zzf(obj, j4), zzeo.zzf(obj2, j4));
                    break;
                case 50:
                    zzZ = zzdp.zzZ(zzeo.zzf(obj, j4), zzeo.zzf(obj2, j4));
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
                    long zzy = zzy(i4) & 1048575;
                    if (zzeo.zzc(obj, zzy) == zzeo.zzc(obj2, zzy) && zzdp.zzZ(zzeo.zzf(obj, j4), zzeo.zzf(obj2, j4))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzZ) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final boolean zzk(Object obj) {
        int i4;
        int i5;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.zzk) {
            int i9 = this.zzj[i8];
            int i10 = this.zzc[i9];
            int zzB = zzB(i9);
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
            if ((268435456 & zzB) != 0 && !zzP(obj, i9, i4, i5, i13)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA != 60 && zzA != 68) {
                        if (zzA != 49) {
                            if (zzA == 50 && !((zzcw) zzeo.zzf(obj, zzB & 1048575)).isEmpty()) {
                                zzcv zzcvVar = (zzcv) zzF(i9);
                                throw null;
                            }
                        }
                    } else if (zzR(obj, i10, i9) && !zzQ(obj, zzB, zzE(i9))) {
                        return false;
                    }
                }
                List list = (List) zzeo.zzf(obj, zzB & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzdn zzE = zzE(i9);
                    for (int i14 = 0; i14 < list.size(); i14++) {
                        if (!zzE.zzk(list.get(i14))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzP(obj, i9, i4, i5, i13) && !zzQ(obj, zzB, zzE(i9))) {
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
