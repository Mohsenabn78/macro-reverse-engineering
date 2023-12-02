package com.google.android.gms.internal.icing;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzeh<T> implements zzep<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzfn.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final zzee zze;
    private final boolean zzf;
    private final boolean zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzds zzk;
    private final zzfd<?, ?> zzl;
    private final zzcq<?> zzm;
    private final zzej zzn;
    private final zzdz zzo;

    /* JADX WARN: Multi-variable type inference failed */
    private zzeh(int[] iArr, int[] iArr2, Object[] objArr, int i4, int i5, zzee zzeeVar, boolean z3, boolean z4, int[] iArr3, int i6, int i7, zzej zzejVar, zzds zzdsVar, zzfd<?, ?> zzfdVar, zzcq<?> zzcqVar, zzdz zzdzVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zzg = zzeeVar;
        boolean z5 = false;
        if (zzfdVar != 0 && zzfdVar.zza(i5)) {
            z5 = true;
        }
        this.zzf = z5;
        this.zzh = z4;
        this.zzi = iArr3;
        this.zzj = i6;
        this.zzn = i7;
        this.zzk = zzejVar;
        this.zzl = zzdsVar;
        this.zzm = zzfdVar;
        this.zze = i5;
        this.zzo = zzcqVar;
    }

    private final boolean zzA(T t3, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return zzB(t3, i4);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    private final boolean zzB(T t3, int i4) {
        int zzs = zzs(i4);
        long j4 = zzs & 1048575;
        if (j4 == 1048575) {
            int zzr = zzr(i4);
            long j5 = zzr & 1048575;
            switch (zzt(zzr)) {
                case 0:
                    if (zzfn.zzl(t3, j5) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return false;
                    }
                    return true;
                case 1:
                    if (zzfn.zzj(t3, j5) == 0.0f) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzfn.zzf(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzfn.zzf(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzfn.zzd(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzfn.zzf(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzfn.zzd(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzfn.zzh(t3, j5);
                case 8:
                    Object zzn = zzfn.zzn(t3, j5);
                    if (zzn instanceof String) {
                        if (((String) zzn).isEmpty()) {
                            return false;
                        }
                        return true;
                    } else if (zzn instanceof zzcf) {
                        if (zzcf.zzb.equals(zzn)) {
                            return false;
                        }
                        return true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (zzfn.zzn(t3, j5) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzcf.zzb.equals(zzfn.zzn(t3, j5))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzfn.zzd(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzfn.zzd(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzfn.zzd(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzfn.zzf(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzfn.zzd(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzfn.zzf(t3, j5) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzfn.zzn(t3, j5) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzfn.zzd(t3, j4) & (1 << (zzs >>> 20))) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private final void zzC(T t3, int i4) {
        int zzs = zzs(i4);
        long j4 = 1048575 & zzs;
        if (j4 == 1048575) {
            return;
        }
        zzfn.zze(t3, j4, (1 << (zzs >>> 20)) | zzfn.zzd(t3, j4));
    }

    private final boolean zzD(T t3, int i4, int i5) {
        if (zzfn.zzd(t3, zzs(i5) & 1048575) == i4) {
            return true;
        }
        return false;
    }

    private final void zzE(T t3, int i4, int i5) {
        zzfn.zze(t3, zzs(i5) & 1048575, i4);
    }

    private final void zzF(T t3, zzcn zzcnVar) throws IOException {
        int i4;
        if (!this.zzf) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i5 = 1048575;
            int i6 = 0;
            int i7 = 0;
            int i8 = 1048575;
            while (i6 < length) {
                int zzr = zzr(i6);
                int i9 = this.zzc[i6];
                int zzt = zzt(zzr);
                if (zzt <= 17) {
                    int i10 = this.zzc[i6 + 2];
                    int i11 = i10 & i5;
                    if (i11 != i8) {
                        i7 = unsafe.getInt(t3, i11);
                        i8 = i11;
                    }
                    i4 = 1 << (i10 >>> 20);
                } else {
                    i4 = 0;
                }
                long j4 = zzr & i5;
                switch (zzt) {
                    case 0:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzf(i9, zzfn.zzl(t3, j4));
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 1:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zze(i9, zzfn.zzj(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 2:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzc(i9, unsafe.getLong(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 3:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzh(i9, unsafe.getLong(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 4:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzi(i9, unsafe.getInt(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 5:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzj(i9, unsafe.getLong(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 6:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzk(i9, unsafe.getInt(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 7:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzl(i9, zzfn.zzh(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 8:
                        if ((i7 & i4) != 0) {
                            zzH(i9, unsafe.getObject(t3, j4), zzcnVar);
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 9:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzr(i9, unsafe.getObject(t3, j4), zzo(i6));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 10:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzn(i9, (zzcf) unsafe.getObject(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 11:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzo(i9, unsafe.getInt(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 12:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzg(i9, unsafe.getInt(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 13:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzb(i9, unsafe.getInt(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 14:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzd(i9, unsafe.getLong(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 15:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzp(i9, unsafe.getInt(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 16:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzq(i9, unsafe.getLong(t3, j4));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 17:
                        if ((i7 & i4) != 0) {
                            zzcnVar.zzs(i9, unsafe.getObject(t3, j4), zzo(i6));
                        } else {
                            continue;
                        }
                        i6 += 3;
                        i5 = 1048575;
                    case 18:
                        zzer.zzH(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 19:
                        zzer.zzI(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 20:
                        zzer.zzJ(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 21:
                        zzer.zzK(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 22:
                        zzer.zzO(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 23:
                        zzer.zzM(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 24:
                        zzer.zzR(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 25:
                        zzer.zzU(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        continue;
                        i6 += 3;
                        i5 = 1048575;
                    case 26:
                        zzer.zzV(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar);
                        break;
                    case 27:
                        zzer.zzX(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, zzo(i6));
                        break;
                    case 28:
                        zzer.zzW(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar);
                        break;
                    case 29:
                        zzer.zzP(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        break;
                    case 30:
                        zzer.zzT(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        break;
                    case 31:
                        zzer.zzS(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        break;
                    case 32:
                        zzer.zzN(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        break;
                    case 33:
                        zzer.zzQ(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        break;
                    case 34:
                        zzer.zzL(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, false);
                        break;
                    case 35:
                        zzer.zzH(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 36:
                        zzer.zzI(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 37:
                        zzer.zzJ(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 38:
                        zzer.zzK(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 39:
                        zzer.zzO(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 40:
                        zzer.zzM(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 41:
                        zzer.zzR(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 42:
                        zzer.zzU(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 43:
                        zzer.zzP(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 44:
                        zzer.zzT(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 45:
                        zzer.zzS(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 46:
                        zzer.zzN(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 47:
                        zzer.zzQ(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 48:
                        zzer.zzL(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, true);
                        break;
                    case 49:
                        zzer.zzY(this.zzc[i6], (List) unsafe.getObject(t3, j4), zzcnVar, zzo(i6));
                        break;
                    case 50:
                        zzG(zzcnVar, i9, unsafe.getObject(t3, j4), i6);
                        break;
                    case 51:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzf(i9, zzu(t3, j4));
                            break;
                        }
                        break;
                    case 52:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zze(i9, zzv(t3, j4));
                            break;
                        }
                        break;
                    case 53:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzc(i9, zzx(t3, j4));
                            break;
                        }
                        break;
                    case 54:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzh(i9, zzx(t3, j4));
                            break;
                        }
                        break;
                    case 55:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzi(i9, zzw(t3, j4));
                            break;
                        }
                        break;
                    case 56:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzj(i9, zzx(t3, j4));
                            break;
                        }
                        break;
                    case 57:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzk(i9, zzw(t3, j4));
                            break;
                        }
                        break;
                    case 58:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzl(i9, zzy(t3, j4));
                            break;
                        }
                        break;
                    case 59:
                        if (zzD(t3, i9, i6)) {
                            zzH(i9, unsafe.getObject(t3, j4), zzcnVar);
                            break;
                        }
                        break;
                    case 60:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzr(i9, unsafe.getObject(t3, j4), zzo(i6));
                            break;
                        }
                        break;
                    case 61:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzn(i9, (zzcf) unsafe.getObject(t3, j4));
                            break;
                        }
                        break;
                    case 62:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzo(i9, zzw(t3, j4));
                            break;
                        }
                        break;
                    case 63:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzg(i9, zzw(t3, j4));
                            break;
                        }
                        break;
                    case 64:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzb(i9, zzw(t3, j4));
                            break;
                        }
                        break;
                    case 65:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzd(i9, zzx(t3, j4));
                            break;
                        }
                        break;
                    case 66:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzp(i9, zzw(t3, j4));
                            break;
                        }
                        break;
                    case 67:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzq(i9, zzx(t3, j4));
                            break;
                        }
                        break;
                    case 68:
                        if (zzD(t3, i9, i6)) {
                            zzcnVar.zzs(i9, unsafe.getObject(t3, j4), zzo(i6));
                            break;
                        }
                        break;
                }
                i6 += 3;
                i5 = 1048575;
            }
            zzfd<?, ?> zzfdVar = this.zzl;
            zzfdVar.zzg(zzfdVar.zzb(t3), zzcnVar);
            return;
        }
        this.zzm.zzb(t3);
        throw null;
    }

    private final <K, V> void zzG(zzcn zzcnVar, int i4, Object obj, int i5) throws IOException {
        if (obj == null) {
            return;
        }
        zzdx zzdxVar = (zzdx) zzp(i5);
        throw null;
    }

    private static final void zzH(int i4, Object obj, zzcn zzcnVar) throws IOException {
        if (obj instanceof String) {
            zzcnVar.zzm(i4, (String) obj);
        } else {
            zzcnVar.zzn(i4, (zzcf) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzeh<T> zzg(Class<T> cls, zzeb zzebVar, zzej zzejVar, zzds zzdsVar, zzfd<?, ?> zzfdVar, zzcq<?> zzcqVar, zzdz zzdzVar) {
        if (zzebVar instanceof zzeo) {
            return zzh((zzeo) zzebVar, zzejVar, zzdsVar, zzfdVar, zzcqVar, zzdzVar);
        }
        zzfa zzfaVar = (zzfa) zzebVar;
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
    static <T> com.google.android.gms.internal.icing.zzeh<T> zzh(com.google.android.gms.internal.icing.zzeo r34, com.google.android.gms.internal.icing.zzej r35, com.google.android.gms.internal.icing.zzds r36, com.google.android.gms.internal.icing.zzfd<?, ?> r37, com.google.android.gms.internal.icing.zzcq<?> r38, com.google.android.gms.internal.icing.zzdz r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzeh.zzh(com.google.android.gms.internal.icing.zzeo, com.google.android.gms.internal.icing.zzej, com.google.android.gms.internal.icing.zzds, com.google.android.gms.internal.icing.zzfd, com.google.android.gms.internal.icing.zzcq, com.google.android.gms.internal.icing.zzdz):com.google.android.gms.internal.icing.zzeh");
    }

    private static Field zzj(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzk(T t3, T t4, int i4) {
        long zzr = zzr(i4) & 1048575;
        if (!zzB(t4, i4)) {
            return;
        }
        Object zzn = zzfn.zzn(t3, zzr);
        Object zzn2 = zzfn.zzn(t4, zzr);
        if (zzn != null && zzn2 != null) {
            zzfn.zzo(t3, zzr, zzdh.zzi(zzn, zzn2));
            zzC(t3, i4);
        } else if (zzn2 != null) {
            zzfn.zzo(t3, zzr, zzn2);
            zzC(t3, i4);
        }
    }

    private final void zzl(T t3, T t4, int i4) {
        Object obj;
        int zzr = zzr(i4);
        int i5 = this.zzc[i4];
        long j4 = zzr & 1048575;
        if (!zzD(t4, i5, i4)) {
            return;
        }
        if (zzD(t3, i5, i4)) {
            obj = zzfn.zzn(t3, j4);
        } else {
            obj = null;
        }
        Object zzn = zzfn.zzn(t4, j4);
        if (obj != null && zzn != null) {
            zzfn.zzo(t3, j4, zzdh.zzi(obj, zzn));
            zzE(t3, i5, i4);
        } else if (zzn != null) {
            zzfn.zzo(t3, j4, zzn);
            zzE(t3, i5, i4);
        }
    }

    private final int zzm(T t3) {
        int i4;
        int zzw;
        int zzw2;
        int zzw3;
        int zzx;
        int zzw4;
        int zzv;
        int zzw5;
        int zzw6;
        int zzc;
        int zzw7;
        int zzw8;
        int zzu;
        int zzw9;
        int i5;
        Unsafe unsafe = zzb;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1048575;
        for (int i9 = 0; i9 < this.zzc.length; i9 += 3) {
            int zzr = zzr(i9);
            int i10 = this.zzc[i9];
            int zzt = zzt(zzr);
            if (zzt <= 17) {
                int i11 = this.zzc[i9 + 2];
                int i12 = i11 & 1048575;
                i4 = 1 << (i11 >>> 20);
                if (i12 != i8) {
                    i7 = unsafe.getInt(t3, i12);
                    i8 = i12;
                }
            } else {
                i4 = 0;
            }
            long j4 = zzr & 1048575;
            switch (zzt) {
                case 0:
                    if ((i7 & i4) != 0) {
                        zzw = zzcm.zzw(i10 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if ((i7 & i4) != 0) {
                        zzw2 = zzcm.zzw(i10 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if ((i7 & i4) != 0) {
                        long j5 = unsafe.getLong(t3, j4);
                        zzw3 = zzcm.zzw(i10 << 3);
                        zzx = zzcm.zzx(j5);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if ((i7 & i4) != 0) {
                        long j6 = unsafe.getLong(t3, j4);
                        zzw3 = zzcm.zzw(i10 << 3);
                        zzx = zzcm.zzx(j6);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if ((i7 & i4) != 0) {
                        int i13 = unsafe.getInt(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzv(i13);
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 5:
                    if ((i7 & i4) != 0) {
                        zzw = zzcm.zzw(i10 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if ((i7 & i4) != 0) {
                        zzw2 = zzcm.zzw(i10 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if ((i7 & i4) != 0) {
                        zzw5 = zzcm.zzw(i10 << 3);
                        zzw8 = zzw5 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if ((i7 & i4) != 0) {
                        Object object = unsafe.getObject(t3, j4);
                        if (object instanceof zzcf) {
                            zzw6 = zzcm.zzw(i10 << 3);
                            zzc = ((zzcf) object).zzc();
                            zzw7 = zzcm.zzw(zzc);
                            i5 = zzw6 + zzw7 + zzc;
                            i6 += i5;
                        } else {
                            zzw4 = zzcm.zzw(i10 << 3);
                            zzv = zzcm.zzy((String) object);
                            i5 = zzw4 + zzv;
                            i6 += i5;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if ((i7 & i4) != 0) {
                        zzw8 = zzer.zzw(i10, unsafe.getObject(t3, j4), zzo(i9));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if ((i7 & i4) != 0) {
                        zzw6 = zzcm.zzw(i10 << 3);
                        zzc = ((zzcf) unsafe.getObject(t3, j4)).zzc();
                        zzw7 = zzcm.zzw(zzc);
                        i5 = zzw6 + zzw7 + zzc;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 11:
                    if ((i7 & i4) != 0) {
                        int i14 = unsafe.getInt(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzw(i14);
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 12:
                    if ((i7 & i4) != 0) {
                        int i15 = unsafe.getInt(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzv(i15);
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 13:
                    if ((i7 & i4) != 0) {
                        zzw2 = zzcm.zzw(i10 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if ((i7 & i4) != 0) {
                        zzw = zzcm.zzw(i10 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if ((i7 & i4) != 0) {
                        int i16 = unsafe.getInt(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzw((i16 >> 31) ^ (i16 + i16));
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 16:
                    if ((i7 & i4) != 0) {
                        long j7 = unsafe.getLong(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzx((j7 >> 63) ^ (j7 + j7));
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 17:
                    if ((i7 & i4) != 0) {
                        zzw8 = zzcm.zzE(i10, (zzee) unsafe.getObject(t3, j4), zzo(i9));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    zzw8 = zzer.zzs(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 19:
                    zzw8 = zzer.zzq(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 20:
                    zzw8 = zzer.zzc(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 21:
                    zzw8 = zzer.zze(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 22:
                    zzw8 = zzer.zzk(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 23:
                    zzw8 = zzer.zzs(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 24:
                    zzw8 = zzer.zzq(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 25:
                    zzw8 = zzer.zzu(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 26:
                    zzw8 = zzer.zzv(i10, (List) unsafe.getObject(t3, j4));
                    break;
                case 27:
                    zzw8 = zzer.zzx(i10, (List) unsafe.getObject(t3, j4), zzo(i9));
                    break;
                case 28:
                    zzw8 = zzer.zzy(i10, (List) unsafe.getObject(t3, j4));
                    break;
                case 29:
                    zzw8 = zzer.zzm(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 30:
                    zzw8 = zzer.zzi(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 31:
                    zzw8 = zzer.zzq(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 32:
                    zzw8 = zzer.zzs(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 33:
                    zzw8 = zzer.zzo(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 34:
                    zzw8 = zzer.zzg(i10, (List) unsafe.getObject(t3, j4), false);
                    break;
                case 35:
                    zzv = zzer.zzr((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 36:
                    zzv = zzer.zzp((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 37:
                    zzv = zzer.zzb((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 38:
                    zzv = zzer.zzd((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 39:
                    zzv = zzer.zzj((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 40:
                    zzv = zzer.zzr((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 41:
                    zzv = zzer.zzp((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 42:
                    zzv = zzer.zzt((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 43:
                    zzv = zzer.zzl((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 44:
                    zzv = zzer.zzh((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 45:
                    zzv = zzer.zzp((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 46:
                    zzv = zzer.zzr((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 47:
                    zzv = zzer.zzn((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 48:
                    zzv = zzer.zzf((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i10);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 49:
                    zzw8 = zzer.zzz(i10, (List) unsafe.getObject(t3, j4), zzo(i9));
                    break;
                case 50:
                    zzdz.zza(i10, unsafe.getObject(t3, j4), zzp(i9));
                    continue;
                case 51:
                    if (zzD(t3, i10, i9)) {
                        zzw = zzcm.zzw(i10 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (zzD(t3, i10, i9)) {
                        zzw2 = zzcm.zzw(i10 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (zzD(t3, i10, i9)) {
                        long zzx2 = zzx(t3, j4);
                        zzw3 = zzcm.zzw(i10 << 3);
                        zzx = zzcm.zzx(zzx2);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (zzD(t3, i10, i9)) {
                        long zzx3 = zzx(t3, j4);
                        zzw3 = zzcm.zzw(i10 << 3);
                        zzx = zzcm.zzx(zzx3);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (zzD(t3, i10, i9)) {
                        int zzw10 = zzw(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzv(zzw10);
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 56:
                    if (zzD(t3, i10, i9)) {
                        zzw = zzcm.zzw(i10 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (zzD(t3, i10, i9)) {
                        zzw2 = zzcm.zzw(i10 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (zzD(t3, i10, i9)) {
                        zzw5 = zzcm.zzw(i10 << 3);
                        zzw8 = zzw5 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (zzD(t3, i10, i9)) {
                        Object object2 = unsafe.getObject(t3, j4);
                        if (object2 instanceof zzcf) {
                            zzw6 = zzcm.zzw(i10 << 3);
                            zzc = ((zzcf) object2).zzc();
                            zzw7 = zzcm.zzw(zzc);
                            i5 = zzw6 + zzw7 + zzc;
                            i6 += i5;
                        } else {
                            zzw4 = zzcm.zzw(i10 << 3);
                            zzv = zzcm.zzy((String) object2);
                            i5 = zzw4 + zzv;
                            i6 += i5;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (zzD(t3, i10, i9)) {
                        zzw8 = zzer.zzw(i10, unsafe.getObject(t3, j4), zzo(i9));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (zzD(t3, i10, i9)) {
                        zzw6 = zzcm.zzw(i10 << 3);
                        zzc = ((zzcf) unsafe.getObject(t3, j4)).zzc();
                        zzw7 = zzcm.zzw(zzc);
                        i5 = zzw6 + zzw7 + zzc;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 62:
                    if (zzD(t3, i10, i9)) {
                        int zzw11 = zzw(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzw(zzw11);
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 63:
                    if (zzD(t3, i10, i9)) {
                        int zzw12 = zzw(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzv(zzw12);
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 64:
                    if (zzD(t3, i10, i9)) {
                        zzw2 = zzcm.zzw(i10 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (zzD(t3, i10, i9)) {
                        zzw = zzcm.zzw(i10 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (zzD(t3, i10, i9)) {
                        int zzw13 = zzw(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzw((zzw13 >> 31) ^ (zzw13 + zzw13));
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 67:
                    if (zzD(t3, i10, i9)) {
                        long zzx4 = zzx(t3, j4);
                        zzw4 = zzcm.zzw(i10 << 3);
                        zzv = zzcm.zzx((zzx4 >> 63) ^ (zzx4 + zzx4));
                        i5 = zzw4 + zzv;
                        i6 += i5;
                    } else {
                        continue;
                    }
                case 68:
                    if (zzD(t3, i10, i9)) {
                        zzw8 = zzcm.zzE(i10, (zzee) unsafe.getObject(t3, j4), zzo(i9));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i6 += zzw8;
        }
        zzfd<?, ?> zzfdVar = this.zzl;
        int zzf = i6 + zzfdVar.zzf(zzfdVar.zzb(t3));
        if (!this.zzf) {
            return zzf;
        }
        this.zzm.zzb(t3);
        throw null;
    }

    private final int zzn(T t3) {
        int zzw;
        int zzw2;
        int zzw3;
        int zzx;
        int zzw4;
        int zzv;
        int zzw5;
        int zzw6;
        int zzc;
        int zzw7;
        int zzw8;
        int zzu;
        int zzw9;
        int i4;
        Unsafe unsafe = zzb;
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzr = zzr(i6);
            int zzt = zzt(zzr);
            int i7 = this.zzc[i6];
            long j4 = zzr & 1048575;
            if (zzt >= zzcv.zzJ.zza() && zzt <= zzcv.zzW.zza()) {
                int i8 = this.zzc[i6 + 2];
            }
            switch (zzt) {
                case 0:
                    if (zzB(t3, i6)) {
                        zzw = zzcm.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzB(t3, i6)) {
                        zzw2 = zzcm.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzB(t3, i6)) {
                        long zzf = zzfn.zzf(t3, j4);
                        zzw3 = zzcm.zzw(i7 << 3);
                        zzx = zzcm.zzx(zzf);
                        i5 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzB(t3, i6)) {
                        long zzf2 = zzfn.zzf(t3, j4);
                        zzw3 = zzcm.zzw(i7 << 3);
                        zzx = zzcm.zzx(zzf2);
                        i5 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzB(t3, i6)) {
                        int zzd = zzfn.zzd(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzv(zzd);
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzB(t3, i6)) {
                        zzw = zzcm.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzB(t3, i6)) {
                        zzw2 = zzcm.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzB(t3, i6)) {
                        zzw5 = zzcm.zzw(i7 << 3);
                        zzw8 = zzw5 + 1;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzB(t3, i6)) {
                        break;
                    } else {
                        Object zzn = zzfn.zzn(t3, j4);
                        if (zzn instanceof zzcf) {
                            zzw6 = zzcm.zzw(i7 << 3);
                            zzc = ((zzcf) zzn).zzc();
                            zzw7 = zzcm.zzw(zzc);
                            i4 = zzw6 + zzw7 + zzc;
                            i5 += i4;
                            break;
                        } else {
                            zzw4 = zzcm.zzw(i7 << 3);
                            zzv = zzcm.zzy((String) zzn);
                            i4 = zzw4 + zzv;
                            i5 += i4;
                        }
                    }
                case 9:
                    if (zzB(t3, i6)) {
                        zzw8 = zzer.zzw(i7, zzfn.zzn(t3, j4), zzo(i6));
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzB(t3, i6)) {
                        zzw6 = zzcm.zzw(i7 << 3);
                        zzc = ((zzcf) zzfn.zzn(t3, j4)).zzc();
                        zzw7 = zzcm.zzw(zzc);
                        i4 = zzw6 + zzw7 + zzc;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzB(t3, i6)) {
                        int zzd2 = zzfn.zzd(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzw(zzd2);
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzB(t3, i6)) {
                        int zzd3 = zzfn.zzd(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzv(zzd3);
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzB(t3, i6)) {
                        zzw2 = zzcm.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzB(t3, i6)) {
                        zzw = zzcm.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzB(t3, i6)) {
                        int zzd4 = zzfn.zzd(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzw((zzd4 >> 31) ^ (zzd4 + zzd4));
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzB(t3, i6)) {
                        long zzf3 = zzfn.zzf(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzx((zzf3 >> 63) ^ (zzf3 + zzf3));
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzB(t3, i6)) {
                        zzw8 = zzcm.zzE(i7, (zzee) zzfn.zzn(t3, j4), zzo(i6));
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzw8 = zzer.zzs(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 19:
                    zzw8 = zzer.zzq(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 20:
                    zzw8 = zzer.zzc(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 21:
                    zzw8 = zzer.zze(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 22:
                    zzw8 = zzer.zzk(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 23:
                    zzw8 = zzer.zzs(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 24:
                    zzw8 = zzer.zzq(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 25:
                    zzw8 = zzer.zzu(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 26:
                    zzw8 = zzer.zzv(i7, (List) zzfn.zzn(t3, j4));
                    i5 += zzw8;
                    break;
                case 27:
                    zzw8 = zzer.zzx(i7, (List) zzfn.zzn(t3, j4), zzo(i6));
                    i5 += zzw8;
                    break;
                case 28:
                    zzw8 = zzer.zzy(i7, (List) zzfn.zzn(t3, j4));
                    i5 += zzw8;
                    break;
                case 29:
                    zzw8 = zzer.zzm(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 30:
                    zzw8 = zzer.zzi(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 31:
                    zzw8 = zzer.zzq(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 32:
                    zzw8 = zzer.zzs(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 33:
                    zzw8 = zzer.zzo(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 34:
                    zzw8 = zzer.zzg(i7, (List) zzfn.zzn(t3, j4), false);
                    i5 += zzw8;
                    break;
                case 35:
                    zzv = zzer.zzr((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzer.zzp((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzer.zzb((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzer.zzd((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzer.zzj((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzer.zzr((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzer.zzp((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzer.zzt((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzer.zzl((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzer.zzh((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzer.zzp((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzer.zzr((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzer.zzn((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzer.zzf((List) unsafe.getObject(t3, j4));
                    if (zzv > 0) {
                        zzu = zzcm.zzu(i7);
                        zzw9 = zzcm.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzw8 = zzer.zzz(i7, (List) zzfn.zzn(t3, j4), zzo(i6));
                    i5 += zzw8;
                    break;
                case 50:
                    zzdz.zza(i7, zzfn.zzn(t3, j4), zzp(i6));
                    break;
                case 51:
                    if (zzD(t3, i7, i6)) {
                        zzw = zzcm.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzD(t3, i7, i6)) {
                        zzw2 = zzcm.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzD(t3, i7, i6)) {
                        long zzx2 = zzx(t3, j4);
                        zzw3 = zzcm.zzw(i7 << 3);
                        zzx = zzcm.zzx(zzx2);
                        i5 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzD(t3, i7, i6)) {
                        long zzx3 = zzx(t3, j4);
                        zzw3 = zzcm.zzw(i7 << 3);
                        zzx = zzcm.zzx(zzx3);
                        i5 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzD(t3, i7, i6)) {
                        int zzw10 = zzw(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzv(zzw10);
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzD(t3, i7, i6)) {
                        zzw = zzcm.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzD(t3, i7, i6)) {
                        zzw2 = zzcm.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzD(t3, i7, i6)) {
                        zzw5 = zzcm.zzw(i7 << 3);
                        zzw8 = zzw5 + 1;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzD(t3, i7, i6)) {
                        break;
                    } else {
                        Object zzn2 = zzfn.zzn(t3, j4);
                        if (zzn2 instanceof zzcf) {
                            zzw6 = zzcm.zzw(i7 << 3);
                            zzc = ((zzcf) zzn2).zzc();
                            zzw7 = zzcm.zzw(zzc);
                            i4 = zzw6 + zzw7 + zzc;
                            i5 += i4;
                            break;
                        } else {
                            zzw4 = zzcm.zzw(i7 << 3);
                            zzv = zzcm.zzy((String) zzn2);
                            i4 = zzw4 + zzv;
                            i5 += i4;
                        }
                    }
                case 60:
                    if (zzD(t3, i7, i6)) {
                        zzw8 = zzer.zzw(i7, zzfn.zzn(t3, j4), zzo(i6));
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzD(t3, i7, i6)) {
                        zzw6 = zzcm.zzw(i7 << 3);
                        zzc = ((zzcf) zzfn.zzn(t3, j4)).zzc();
                        zzw7 = zzcm.zzw(zzc);
                        i4 = zzw6 + zzw7 + zzc;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzD(t3, i7, i6)) {
                        int zzw11 = zzw(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzw(zzw11);
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzD(t3, i7, i6)) {
                        int zzw12 = zzw(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzv(zzw12);
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzD(t3, i7, i6)) {
                        zzw2 = zzcm.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzD(t3, i7, i6)) {
                        zzw = zzcm.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzD(t3, i7, i6)) {
                        int zzw13 = zzw(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzw((zzw13 >> 31) ^ (zzw13 + zzw13));
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzD(t3, i7, i6)) {
                        long zzx4 = zzx(t3, j4);
                        zzw4 = zzcm.zzw(i7 << 3);
                        zzv = zzcm.zzx((zzx4 >> 63) ^ (zzx4 + zzx4));
                        i4 = zzw4 + zzv;
                        i5 += i4;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzD(t3, i7, i6)) {
                        zzw8 = zzcm.zzE(i7, (zzee) zzfn.zzn(t3, j4), zzo(i6));
                        i5 += zzw8;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzfd<?, ?> zzfdVar = this.zzl;
        return i5 + zzfdVar.zzf(zzfdVar.zzb(t3));
    }

    private final zzep zzo(int i4) {
        int i5 = i4 / 3;
        int i6 = i5 + i5;
        zzep zzepVar = (zzep) this.zzd[i6];
        if (zzepVar != null) {
            return zzepVar;
        }
        zzep<T> zzb2 = zzem.zza().zzb((Class) this.zzd[i6 + 1]);
        this.zzd[i6] = zzb2;
        return zzb2;
    }

    private final Object zzp(int i4) {
        int i5 = i4 / 3;
        return this.zzd[i5 + i5];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzq(Object obj, int i4, zzep zzepVar) {
        return zzepVar.zzf(zzfn.zzn(obj, i4 & 1048575));
    }

    private final int zzr(int i4) {
        return this.zzc[i4 + 1];
    }

    private final int zzs(int i4) {
        return this.zzc[i4 + 2];
    }

    private static int zzt(int i4) {
        return (i4 >>> 20) & 255;
    }

    private static <T> double zzu(T t3, long j4) {
        return ((Double) zzfn.zzn(t3, j4)).doubleValue();
    }

    private static <T> float zzv(T t3, long j4) {
        return ((Float) zzfn.zzn(t3, j4)).floatValue();
    }

    private static <T> int zzw(T t3, long j4) {
        return ((Integer) zzfn.zzn(t3, j4)).intValue();
    }

    private static <T> long zzx(T t3, long j4) {
        return ((Long) zzfn.zzn(t3, j4)).longValue();
    }

    private static <T> boolean zzy(T t3, long j4) {
        return ((Boolean) zzfn.zzn(t3, j4)).booleanValue();
    }

    private final boolean zzz(T t3, T t4, int i4) {
        if (zzB(t3, i4) == zzB(t4, i4)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final boolean zza(T t3, T t4) {
        boolean zzD;
        int length = this.zzc.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzr = zzr(i4);
            long j4 = zzr & 1048575;
            switch (zzt(zzr)) {
                case 0:
                    if (zzz(t3, t4, i4) && Double.doubleToLongBits(zzfn.zzl(t3, j4)) == Double.doubleToLongBits(zzfn.zzl(t4, j4))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzz(t3, t4, i4) && Float.floatToIntBits(zzfn.zzj(t3, j4)) == Float.floatToIntBits(zzfn.zzj(t4, j4))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzz(t3, t4, i4) && zzfn.zzf(t3, j4) == zzfn.zzf(t4, j4)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzz(t3, t4, i4) && zzfn.zzf(t3, j4) == zzfn.zzf(t4, j4)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzz(t3, t4, i4) && zzfn.zzd(t3, j4) == zzfn.zzd(t4, j4)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzz(t3, t4, i4) && zzfn.zzf(t3, j4) == zzfn.zzf(t4, j4)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzz(t3, t4, i4) && zzfn.zzd(t3, j4) == zzfn.zzd(t4, j4)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzz(t3, t4, i4) && zzfn.zzh(t3, j4) == zzfn.zzh(t4, j4)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzz(t3, t4, i4) && zzer.zzD(zzfn.zzn(t3, j4), zzfn.zzn(t4, j4))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzz(t3, t4, i4) && zzer.zzD(zzfn.zzn(t3, j4), zzfn.zzn(t4, j4))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzz(t3, t4, i4) && zzer.zzD(zzfn.zzn(t3, j4), zzfn.zzn(t4, j4))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzz(t3, t4, i4) && zzfn.zzd(t3, j4) == zzfn.zzd(t4, j4)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzz(t3, t4, i4) && zzfn.zzd(t3, j4) == zzfn.zzd(t4, j4)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzz(t3, t4, i4) && zzfn.zzd(t3, j4) == zzfn.zzd(t4, j4)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzz(t3, t4, i4) && zzfn.zzf(t3, j4) == zzfn.zzf(t4, j4)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzz(t3, t4, i4) && zzfn.zzd(t3, j4) == zzfn.zzd(t4, j4)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzz(t3, t4, i4) && zzfn.zzf(t3, j4) == zzfn.zzf(t4, j4)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzz(t3, t4, i4) && zzer.zzD(zzfn.zzn(t3, j4), zzfn.zzn(t4, j4))) {
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
                    zzD = zzer.zzD(zzfn.zzn(t3, j4), zzfn.zzn(t4, j4));
                    break;
                case 50:
                    zzD = zzer.zzD(zzfn.zzn(t3, j4), zzfn.zzn(t4, j4));
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
                    long zzs = zzs(i4) & 1048575;
                    if (zzfn.zzd(t3, zzs) == zzfn.zzd(t4, zzs) && zzer.zzD(zzfn.zzn(t3, j4), zzfn.zzn(t4, j4))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzD) {
                return false;
            }
        }
        if (!this.zzl.zzb(t3).equals(this.zzl.zzb(t4))) {
            return false;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzm.zzb(t3);
        this.zzm.zzb(t4);
        throw null;
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final int zzb(T t3) {
        int i4;
        int zze;
        int length = this.zzc.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int zzr = zzr(i6);
            int i7 = this.zzc[i6];
            long j4 = 1048575 & zzr;
            int i8 = 37;
            switch (zzt(zzr)) {
                case 0:
                    i4 = i5 * 53;
                    zze = zzdh.zze(Double.doubleToLongBits(zzfn.zzl(t3, j4)));
                    i5 = i4 + zze;
                    break;
                case 1:
                    i4 = i5 * 53;
                    zze = Float.floatToIntBits(zzfn.zzj(t3, j4));
                    i5 = i4 + zze;
                    break;
                case 2:
                    i4 = i5 * 53;
                    zze = zzdh.zze(zzfn.zzf(t3, j4));
                    i5 = i4 + zze;
                    break;
                case 3:
                    i4 = i5 * 53;
                    zze = zzdh.zze(zzfn.zzf(t3, j4));
                    i5 = i4 + zze;
                    break;
                case 4:
                    i4 = i5 * 53;
                    zze = zzfn.zzd(t3, j4);
                    i5 = i4 + zze;
                    break;
                case 5:
                    i4 = i5 * 53;
                    zze = zzdh.zze(zzfn.zzf(t3, j4));
                    i5 = i4 + zze;
                    break;
                case 6:
                    i4 = i5 * 53;
                    zze = zzfn.zzd(t3, j4);
                    i5 = i4 + zze;
                    break;
                case 7:
                    i4 = i5 * 53;
                    zze = zzdh.zzf(zzfn.zzh(t3, j4));
                    i5 = i4 + zze;
                    break;
                case 8:
                    i4 = i5 * 53;
                    zze = ((String) zzfn.zzn(t3, j4)).hashCode();
                    i5 = i4 + zze;
                    break;
                case 9:
                    Object zzn = zzfn.zzn(t3, j4);
                    if (zzn != null) {
                        i8 = zzn.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 10:
                    i4 = i5 * 53;
                    zze = zzfn.zzn(t3, j4).hashCode();
                    i5 = i4 + zze;
                    break;
                case 11:
                    i4 = i5 * 53;
                    zze = zzfn.zzd(t3, j4);
                    i5 = i4 + zze;
                    break;
                case 12:
                    i4 = i5 * 53;
                    zze = zzfn.zzd(t3, j4);
                    i5 = i4 + zze;
                    break;
                case 13:
                    i4 = i5 * 53;
                    zze = zzfn.zzd(t3, j4);
                    i5 = i4 + zze;
                    break;
                case 14:
                    i4 = i5 * 53;
                    zze = zzdh.zze(zzfn.zzf(t3, j4));
                    i5 = i4 + zze;
                    break;
                case 15:
                    i4 = i5 * 53;
                    zze = zzfn.zzd(t3, j4);
                    i5 = i4 + zze;
                    break;
                case 16:
                    i4 = i5 * 53;
                    zze = zzdh.zze(zzfn.zzf(t3, j4));
                    i5 = i4 + zze;
                    break;
                case 17:
                    Object zzn2 = zzfn.zzn(t3, j4);
                    if (zzn2 != null) {
                        i8 = zzn2.hashCode();
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
                    zze = zzfn.zzn(t3, j4).hashCode();
                    i5 = i4 + zze;
                    break;
                case 50:
                    i4 = i5 * 53;
                    zze = zzfn.zzn(t3, j4).hashCode();
                    i5 = i4 + zze;
                    break;
                case 51:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzdh.zze(Double.doubleToLongBits(zzu(t3, j4)));
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = Float.floatToIntBits(zzv(t3, j4));
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzdh.zze(zzx(t3, j4));
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzdh.zze(zzx(t3, j4));
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzw(t3, j4);
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzdh.zze(zzx(t3, j4));
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzw(t3, j4);
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzdh.zzf(zzy(t3, j4));
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = ((String) zzfn.zzn(t3, j4)).hashCode();
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzfn.zzn(t3, j4).hashCode();
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzfn.zzn(t3, j4).hashCode();
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzw(t3, j4);
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzw(t3, j4);
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzw(t3, j4);
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzdh.zze(zzx(t3, j4));
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzw(t3, j4);
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzdh.zze(zzx(t3, j4));
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzD(t3, i7, i6)) {
                        i4 = i5 * 53;
                        zze = zzfn.zzn(t3, j4).hashCode();
                        i5 = i4 + zze;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i5 * 53) + this.zzl.zzb(t3).hashCode();
        if (!this.zzf) {
            return hashCode;
        }
        this.zzm.zzb(t3);
        throw null;
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final void zzc(T t3, T t4) {
        t4.getClass();
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzr = zzr(i4);
            long j4 = 1048575 & zzr;
            int i5 = this.zzc[i4];
            switch (zzt(zzr)) {
                case 0:
                    if (zzB(t4, i4)) {
                        zzfn.zzm(t3, j4, zzfn.zzl(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzB(t4, i4)) {
                        zzfn.zzk(t3, j4, zzfn.zzj(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzB(t4, i4)) {
                        zzfn.zzg(t3, j4, zzfn.zzf(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzB(t4, i4)) {
                        zzfn.zzg(t3, j4, zzfn.zzf(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzB(t4, i4)) {
                        zzfn.zze(t3, j4, zzfn.zzd(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzB(t4, i4)) {
                        zzfn.zzg(t3, j4, zzfn.zzf(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzB(t4, i4)) {
                        zzfn.zze(t3, j4, zzfn.zzd(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzB(t4, i4)) {
                        zzfn.zzi(t3, j4, zzfn.zzh(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzB(t4, i4)) {
                        zzfn.zzo(t3, j4, zzfn.zzn(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzk(t3, t4, i4);
                    break;
                case 10:
                    if (zzB(t4, i4)) {
                        zzfn.zzo(t3, j4, zzfn.zzn(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzB(t4, i4)) {
                        zzfn.zze(t3, j4, zzfn.zzd(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzB(t4, i4)) {
                        zzfn.zze(t3, j4, zzfn.zzd(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzB(t4, i4)) {
                        zzfn.zze(t3, j4, zzfn.zzd(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzB(t4, i4)) {
                        zzfn.zzg(t3, j4, zzfn.zzf(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzB(t4, i4)) {
                        zzfn.zze(t3, j4, zzfn.zzd(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzB(t4, i4)) {
                        zzfn.zzg(t3, j4, zzfn.zzf(t4, j4));
                        zzC(t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzk(t3, t4, i4);
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
                    this.zzk.zzb(t3, t4, j4);
                    break;
                case 50:
                    zzer.zzG(this.zzo, t3, t4, j4);
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
                    if (zzD(t4, i5, i4)) {
                        zzfn.zzo(t3, j4, zzfn.zzn(t4, j4));
                        zzE(t3, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzl(t3, t4, i4);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzD(t4, i5, i4)) {
                        zzfn.zzo(t3, j4, zzfn.zzn(t4, j4));
                        zzE(t3, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzl(t3, t4, i4);
                    break;
            }
        }
        zzer.zzF(this.zzl, t3, t4);
        if (this.zzf) {
            zzer.zzE(this.zzm, t3, t4);
        }
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final int zzd(T t3) {
        if (this.zzg) {
            return zzn(t3);
        }
        return zzm(t3);
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final void zze(T t3) {
        int i4;
        int i5 = this.zzi;
        while (true) {
            i4 = this.zzj;
            if (i5 >= i4) {
                break;
            }
            long zzr = zzr(this.zzh[i5]) & 1048575;
            Object zzn = zzfn.zzn(t3, zzr);
            if (zzn != null) {
                ((zzdy) zzn).zzc();
                zzfn.zzo(t3, zzr, zzn);
            }
            i5++;
        }
        int length = this.zzh.length;
        while (i4 < length) {
            this.zzk.zza(t3, this.zzh[i4]);
            i4++;
        }
        this.zzl.zzc(t3);
        if (this.zzf) {
            this.zzm.zzc(t3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.icing.zzep
    public final boolean zzf(T t3) {
        int i4;
        int i5;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.zzi) {
            int i9 = this.zzh[i8];
            int i10 = this.zzc[i9];
            int zzr = zzr(i9);
            int i11 = this.zzc[i9 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i6) {
                if (i12 != 1048575) {
                    i7 = zzb.getInt(t3, i12);
                }
                i5 = i7;
                i4 = i12;
            } else {
                i4 = i6;
                i5 = i7;
            }
            if ((268435456 & zzr) != 0 && !zzA(t3, i9, i4, i5, i13)) {
                return false;
            }
            int zzt = zzt(zzr);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt != 60 && zzt != 68) {
                        if (zzt != 49) {
                            if (zzt == 50 && !((zzdy) zzfn.zzn(t3, zzr & 1048575)).isEmpty()) {
                                zzdx zzdxVar = (zzdx) zzp(i9);
                                throw null;
                            }
                        }
                    } else if (zzD(t3, i10, i9) && !zzq(t3, zzr, zzo(i9))) {
                        return false;
                    }
                }
                List list = (List) zzfn.zzn(t3, zzr & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzep zzo = zzo(i9);
                    for (int i14 = 0; i14 < list.size(); i14++) {
                        if (!zzo.zzf(list.get(i14))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzA(t3, i9, i4, i5, i13) && !zzq(t3, zzr, zzo(i9))) {
                return false;
            }
            i8++;
            i6 = i4;
            i7 = i5;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzm.zzb(t3);
        throw null;
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final void zzi(T t3, zzcn zzcnVar) throws IOException {
        if (this.zzg) {
            if (!this.zzf) {
                int length = this.zzc.length;
                for (int i4 = 0; i4 < length; i4 += 3) {
                    int zzr = zzr(i4);
                    int i5 = this.zzc[i4];
                    switch (zzt(zzr)) {
                        case 0:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzf(i5, zzfn.zzl(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (zzB(t3, i4)) {
                                zzcnVar.zze(i5, zzfn.zzj(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzc(i5, zzfn.zzf(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzh(i5, zzfn.zzf(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzi(i5, zzfn.zzd(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzj(i5, zzfn.zzf(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzk(i5, zzfn.zzd(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzl(i5, zzfn.zzh(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (zzB(t3, i4)) {
                                zzH(i5, zzfn.zzn(t3, zzr & 1048575), zzcnVar);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzr(i5, zzfn.zzn(t3, zzr & 1048575), zzo(i4));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzn(i5, (zzcf) zzfn.zzn(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzo(i5, zzfn.zzd(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzg(i5, zzfn.zzd(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzb(i5, zzfn.zzd(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzd(i5, zzfn.zzf(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzp(i5, zzfn.zzd(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzq(i5, zzfn.zzf(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (zzB(t3, i4)) {
                                zzcnVar.zzs(i5, zzfn.zzn(t3, zzr & 1048575), zzo(i4));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            zzer.zzH(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 19:
                            zzer.zzI(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 20:
                            zzer.zzJ(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 21:
                            zzer.zzK(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 22:
                            zzer.zzO(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 23:
                            zzer.zzM(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 24:
                            zzer.zzR(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 25:
                            zzer.zzU(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 26:
                            zzer.zzV(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar);
                            break;
                        case 27:
                            zzer.zzX(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, zzo(i4));
                            break;
                        case 28:
                            zzer.zzW(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar);
                            break;
                        case 29:
                            zzer.zzP(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 30:
                            zzer.zzT(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 31:
                            zzer.zzS(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 32:
                            zzer.zzN(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 33:
                            zzer.zzQ(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 34:
                            zzer.zzL(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, false);
                            break;
                        case 35:
                            zzer.zzH(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 36:
                            zzer.zzI(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 37:
                            zzer.zzJ(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 38:
                            zzer.zzK(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 39:
                            zzer.zzO(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 40:
                            zzer.zzM(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 41:
                            zzer.zzR(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 42:
                            zzer.zzU(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 43:
                            zzer.zzP(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 44:
                            zzer.zzT(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 45:
                            zzer.zzS(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 46:
                            zzer.zzN(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 47:
                            zzer.zzQ(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 48:
                            zzer.zzL(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, true);
                            break;
                        case 49:
                            zzer.zzY(this.zzc[i4], (List) zzfn.zzn(t3, zzr & 1048575), zzcnVar, zzo(i4));
                            break;
                        case 50:
                            zzG(zzcnVar, i5, zzfn.zzn(t3, zzr & 1048575), i4);
                            break;
                        case 51:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzf(i5, zzu(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zze(i5, zzv(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzc(i5, zzx(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzh(i5, zzx(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzi(i5, zzw(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzj(i5, zzx(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzk(i5, zzw(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzl(i5, zzy(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (zzD(t3, i5, i4)) {
                                zzH(i5, zzfn.zzn(t3, zzr & 1048575), zzcnVar);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzr(i5, zzfn.zzn(t3, zzr & 1048575), zzo(i4));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzn(i5, (zzcf) zzfn.zzn(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzo(i5, zzw(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzg(i5, zzw(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzb(i5, zzw(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzd(i5, zzx(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzp(i5, zzw(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzq(i5, zzx(t3, zzr & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (zzD(t3, i5, i4)) {
                                zzcnVar.zzs(i5, zzfn.zzn(t3, zzr & 1048575), zzo(i4));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                zzfd<?, ?> zzfdVar = this.zzl;
                zzfdVar.zzg(zzfdVar.zzb(t3), zzcnVar);
                return;
            }
            this.zzm.zzb(t3);
            throw null;
        }
        zzF(t3, zzcnVar);
    }
}
