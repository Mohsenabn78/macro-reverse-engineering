package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzco<T> implements zzda<T> {
    private static final int[] zzkq = new int[0];
    private static final Unsafe zzkr = zzdy.zzdn();
    private final int[] zzks;
    private final Object[] zzkt;
    private final int zzku;
    private final int zzkv;
    private final zzck zzkw;
    private final boolean zzkx;
    private final boolean zzky;
    private final boolean zzkz;
    private final boolean zzla;
    private final int[] zzlb;
    private final int zzlc;
    private final int zzld;
    private final zzcs zzle;
    private final zzbu zzlf;
    private final zzds<?, ?> zzlg;
    private final zzar<?> zzlh;
    private final zzcd zzli;

    private zzco(int[] iArr, Object[] objArr, int i4, int i5, zzck zzckVar, boolean z3, boolean z4, int[] iArr2, int i6, int i7, zzcs zzcsVar, zzbu zzbuVar, zzds<?, ?> zzdsVar, zzar<?> zzarVar, zzcd zzcdVar) {
        boolean z5;
        this.zzks = iArr;
        this.zzkt = objArr;
        this.zzku = i4;
        this.zzkv = i5;
        this.zzky = zzckVar instanceof zzbc;
        this.zzkz = z3;
        if (zzarVar != null && zzarVar.zzf(zzckVar)) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.zzkx = z5;
        this.zzla = false;
        this.zzlb = iArr2;
        this.zzlc = i6;
        this.zzld = i7;
        this.zzle = zzcsVar;
        this.zzlf = zzbuVar;
        this.zzlg = zzdsVar;
        this.zzlh = zzarVar;
        this.zzkw = zzckVar;
        this.zzli = zzcdVar;
    }

    private final zzda zzaf(int i4) {
        int i5 = (i4 / 3) << 1;
        zzda zzdaVar = (zzda) this.zzkt[i5];
        if (zzdaVar != null) {
            return zzdaVar;
        }
        zzda<T> zzf = zzcv.zzcq().zzf((Class) this.zzkt[i5 + 1]);
        this.zzkt[i5] = zzf;
        return zzf;
    }

    private final Object zzag(int i4) {
        return this.zzkt[(i4 / 3) << 1];
    }

    private final zzbf zzah(int i4) {
        return (zzbf) this.zzkt[((i4 / 3) << 1) + 1];
    }

    private final int zzai(int i4) {
        return this.zzks[i4 + 1];
    }

    private final int zzaj(int i4) {
        return this.zzks[i4 + 2];
    }

    private final int zzak(int i4) {
        if (i4 >= this.zzku && i4 <= this.zzkv) {
            return zzr(i4, 0);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzco<T> zzb(Class<T> cls, zzci zzciVar, zzcs zzcsVar, zzbu zzbuVar, zzds<?, ?> zzdsVar, zzar<?> zzarVar, zzcd zzcdVar) {
        int i4;
        int charAt;
        int charAt2;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr;
        int i9;
        int i10;
        char charAt3;
        int i11;
        char charAt4;
        int i12;
        char charAt5;
        int i13;
        char charAt6;
        int i14;
        char charAt7;
        int i15;
        char charAt8;
        int i16;
        char charAt9;
        int i17;
        char charAt10;
        int i18;
        int i19;
        boolean z3;
        int i20;
        zzcx zzcxVar;
        int i21;
        int objectFieldOffset;
        int i22;
        int i23;
        Class<?> cls2;
        String str;
        int i24;
        int i25;
        Field zzb;
        int i26;
        char charAt11;
        int i27;
        Field zzb2;
        Field zzb3;
        int i28;
        char charAt12;
        int i29;
        char charAt13;
        int i30;
        char charAt14;
        int i31;
        char charAt15;
        char charAt16;
        if (zzciVar instanceof zzcx) {
            zzcx zzcxVar2 = (zzcx) zzciVar;
            int i32 = 0;
            boolean z4 = zzcxVar2.zzcj() == zzbc.zze.zziu;
            String zzcr = zzcxVar2.zzcr();
            int length = zzcr.length();
            int charAt17 = zzcr.charAt(0);
            if (charAt17 >= 55296) {
                int i33 = charAt17 & 8191;
                int i34 = 1;
                int i35 = 13;
                while (true) {
                    i4 = i34 + 1;
                    charAt16 = zzcr.charAt(i34);
                    if (charAt16 < 55296) {
                        break;
                    }
                    i33 |= (charAt16 & 8191) << i35;
                    i35 += 13;
                    i34 = i4;
                }
                charAt17 = i33 | (charAt16 << i35);
            } else {
                i4 = 1;
            }
            int i36 = i4 + 1;
            int charAt18 = zzcr.charAt(i4);
            if (charAt18 >= 55296) {
                int i37 = charAt18 & 8191;
                int i38 = 13;
                while (true) {
                    i31 = i36 + 1;
                    charAt15 = zzcr.charAt(i36);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i37 |= (charAt15 & 8191) << i38;
                    i38 += 13;
                    i36 = i31;
                }
                charAt18 = i37 | (charAt15 << i38);
                i36 = i31;
            }
            if (charAt18 == 0) {
                iArr = zzkq;
                i9 = 0;
                i6 = 0;
                charAt = 0;
                i7 = 0;
                charAt2 = 0;
                i8 = 0;
            } else {
                int i39 = i36 + 1;
                int charAt19 = zzcr.charAt(i36);
                if (charAt19 >= 55296) {
                    int i40 = charAt19 & 8191;
                    int i41 = 13;
                    while (true) {
                        i17 = i39 + 1;
                        charAt10 = zzcr.charAt(i39);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i40 |= (charAt10 & 8191) << i41;
                        i41 += 13;
                        i39 = i17;
                    }
                    charAt19 = i40 | (charAt10 << i41);
                    i39 = i17;
                }
                int i42 = i39 + 1;
                int charAt20 = zzcr.charAt(i39);
                if (charAt20 >= 55296) {
                    int i43 = charAt20 & 8191;
                    int i44 = 13;
                    while (true) {
                        i16 = i42 + 1;
                        charAt9 = zzcr.charAt(i42);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i43 |= (charAt9 & 8191) << i44;
                        i44 += 13;
                        i42 = i16;
                    }
                    charAt20 = i43 | (charAt9 << i44);
                    i42 = i16;
                }
                int i45 = i42 + 1;
                charAt = zzcr.charAt(i42);
                if (charAt >= 55296) {
                    int i46 = charAt & 8191;
                    int i47 = 13;
                    while (true) {
                        i15 = i45 + 1;
                        charAt8 = zzcr.charAt(i45);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i46 |= (charAt8 & 8191) << i47;
                        i47 += 13;
                        i45 = i15;
                    }
                    charAt = i46 | (charAt8 << i47);
                    i45 = i15;
                }
                int i48 = i45 + 1;
                int charAt21 = zzcr.charAt(i45);
                if (charAt21 >= 55296) {
                    int i49 = charAt21 & 8191;
                    int i50 = 13;
                    while (true) {
                        i14 = i48 + 1;
                        charAt7 = zzcr.charAt(i48);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i49 |= (charAt7 & 8191) << i50;
                        i50 += 13;
                        i48 = i14;
                    }
                    charAt21 = i49 | (charAt7 << i50);
                    i48 = i14;
                }
                int i51 = i48 + 1;
                charAt2 = zzcr.charAt(i48);
                if (charAt2 >= 55296) {
                    int i52 = charAt2 & 8191;
                    int i53 = 13;
                    while (true) {
                        i13 = i51 + 1;
                        charAt6 = zzcr.charAt(i51);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i52 |= (charAt6 & 8191) << i53;
                        i53 += 13;
                        i51 = i13;
                    }
                    charAt2 = i52 | (charAt6 << i53);
                    i51 = i13;
                }
                int i54 = i51 + 1;
                int charAt22 = zzcr.charAt(i51);
                if (charAt22 >= 55296) {
                    int i55 = charAt22 & 8191;
                    int i56 = 13;
                    while (true) {
                        i12 = i54 + 1;
                        charAt5 = zzcr.charAt(i54);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i55 |= (charAt5 & 8191) << i56;
                        i56 += 13;
                        i54 = i12;
                    }
                    charAt22 = i55 | (charAt5 << i56);
                    i54 = i12;
                }
                int i57 = i54 + 1;
                int charAt23 = zzcr.charAt(i54);
                if (charAt23 >= 55296) {
                    int i58 = charAt23 & 8191;
                    int i59 = i57;
                    int i60 = 13;
                    while (true) {
                        i11 = i59 + 1;
                        charAt4 = zzcr.charAt(i59);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i58 |= (charAt4 & 8191) << i60;
                        i60 += 13;
                        i59 = i11;
                    }
                    charAt23 = i58 | (charAt4 << i60);
                    i5 = i11;
                } else {
                    i5 = i57;
                }
                int i61 = i5 + 1;
                int charAt24 = zzcr.charAt(i5);
                if (charAt24 >= 55296) {
                    int i62 = charAt24 & 8191;
                    int i63 = i61;
                    int i64 = 13;
                    while (true) {
                        i10 = i63 + 1;
                        charAt3 = zzcr.charAt(i63);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i62 |= (charAt3 & 8191) << i64;
                        i64 += 13;
                        i63 = i10;
                    }
                    charAt24 = i62 | (charAt3 << i64);
                    i61 = i10;
                }
                int i65 = (charAt19 << 1) + charAt20;
                i6 = charAt21;
                i7 = i65;
                i8 = charAt24;
                i32 = charAt19;
                i36 = i61;
                int i66 = charAt22;
                iArr = new int[charAt24 + charAt22 + charAt23];
                i9 = i66;
            }
            Unsafe unsafe = zzkr;
            Object[] zzcs = zzcxVar2.zzcs();
            Class<?> cls3 = zzcxVar2.zzcl().getClass();
            int i67 = i36;
            int[] iArr2 = new int[charAt2 * 3];
            Object[] objArr = new Object[charAt2 << 1];
            int i68 = i8 + i9;
            int i69 = i8;
            int i70 = i67;
            int i71 = i68;
            int i72 = 0;
            int i73 = 0;
            while (i70 < length) {
                int i74 = i70 + 1;
                int charAt25 = zzcr.charAt(i70);
                int i75 = length;
                if (charAt25 >= 55296) {
                    int i76 = charAt25 & 8191;
                    int i77 = i74;
                    int i78 = 13;
                    while (true) {
                        i30 = i77 + 1;
                        charAt14 = zzcr.charAt(i77);
                        i18 = i8;
                        if (charAt14 < 55296) {
                            break;
                        }
                        i76 |= (charAt14 & 8191) << i78;
                        i78 += 13;
                        i77 = i30;
                        i8 = i18;
                    }
                    charAt25 = i76 | (charAt14 << i78);
                    i19 = i30;
                } else {
                    i18 = i8;
                    i19 = i74;
                }
                int i79 = i19 + 1;
                int charAt26 = zzcr.charAt(i19);
                if (charAt26 >= 55296) {
                    int i80 = charAt26 & 8191;
                    int i81 = i79;
                    int i82 = 13;
                    while (true) {
                        i29 = i81 + 1;
                        charAt13 = zzcr.charAt(i81);
                        z3 = z4;
                        if (charAt13 < 55296) {
                            break;
                        }
                        i80 |= (charAt13 & 8191) << i82;
                        i82 += 13;
                        i81 = i29;
                        z4 = z3;
                    }
                    charAt26 = i80 | (charAt13 << i82);
                    i20 = i29;
                } else {
                    z3 = z4;
                    i20 = i79;
                }
                int i83 = charAt26 & 255;
                int i84 = i6;
                if ((charAt26 & 1024) != 0) {
                    iArr[i72] = i73;
                    i72++;
                }
                int i85 = charAt;
                if (i83 >= 51) {
                    int i86 = i20 + 1;
                    int charAt27 = zzcr.charAt(i20);
                    char c4 = 55296;
                    if (charAt27 >= 55296) {
                        int i87 = charAt27 & 8191;
                        int i88 = 13;
                        while (true) {
                            i28 = i86 + 1;
                            charAt12 = zzcr.charAt(i86);
                            if (charAt12 < c4) {
                                break;
                            }
                            i87 |= (charAt12 & 8191) << i88;
                            i88 += 13;
                            i86 = i28;
                            c4 = 55296;
                        }
                        charAt27 = i87 | (charAt12 << i88);
                        i86 = i28;
                    }
                    int i89 = i83 - 51;
                    int i90 = i86;
                    if (i89 == 9 || i89 == 17) {
                        objArr[((i73 / 3) << 1) + 1] = zzcs[i7];
                        i7++;
                    } else if (i89 == 12 && (charAt17 & 1) == 1) {
                        objArr[((i73 / 3) << 1) + 1] = zzcs[i7];
                        i7++;
                    }
                    int i91 = charAt27 << 1;
                    Object obj = zzcs[i91];
                    if (obj instanceof Field) {
                        zzb2 = (Field) obj;
                    } else {
                        zzb2 = zzb(cls3, (String) obj);
                        zzcs[i91] = zzb2;
                    }
                    zzcxVar = zzcxVar2;
                    String str2 = zzcr;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzb2);
                    int i92 = i91 + 1;
                    Object obj2 = zzcs[i92];
                    if (obj2 instanceof Field) {
                        zzb3 = (Field) obj2;
                    } else {
                        zzb3 = zzb(cls3, (String) obj2);
                        zzcs[i92] = zzb3;
                    }
                    cls2 = cls3;
                    i22 = i7;
                    i20 = i90;
                    str = str2;
                    i25 = 0;
                    i24 = (int) unsafe.objectFieldOffset(zzb3);
                    i23 = i32;
                } else {
                    zzcxVar = zzcxVar2;
                    String str3 = zzcr;
                    int i93 = i7 + 1;
                    Field zzb4 = zzb(cls3, (String) zzcs[i7]);
                    if (i83 == 9 || i83 == 17) {
                        i21 = 1;
                        objArr[((i73 / 3) << 1) + 1] = zzb4.getType();
                    } else {
                        if (i83 == 27 || i83 == 49) {
                            i21 = 1;
                            i27 = i93 + 1;
                            objArr[((i73 / 3) << 1) + 1] = zzcs[i93];
                        } else if (i83 == 12 || i83 == 30 || i83 == 44) {
                            i21 = 1;
                            if ((charAt17 & 1) == 1) {
                                i27 = i93 + 1;
                                objArr[((i73 / 3) << 1) + 1] = zzcs[i93];
                            }
                        } else {
                            if (i83 == 50) {
                                int i94 = i69 + 1;
                                iArr[i69] = i73;
                                int i95 = (i73 / 3) << 1;
                                int i96 = i93 + 1;
                                objArr[i95] = zzcs[i93];
                                if ((charAt26 & 2048) != 0) {
                                    i93 = i96 + 1;
                                    objArr[i95 + 1] = zzcs[i96];
                                    i69 = i94;
                                } else {
                                    i93 = i96;
                                    i21 = 1;
                                    i69 = i94;
                                }
                            }
                            i21 = 1;
                        }
                        i93 = i27;
                    }
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzb4);
                    if ((charAt17 & 1) != i21 || i83 > 17) {
                        i22 = i93;
                        i23 = i32;
                        cls2 = cls3;
                        str = str3;
                        i24 = 0;
                        i25 = 0;
                    } else {
                        int i97 = i20 + 1;
                        str = str3;
                        int charAt28 = str.charAt(i20);
                        if (charAt28 >= 55296) {
                            int i98 = charAt28 & 8191;
                            int i99 = 13;
                            while (true) {
                                i26 = i97 + 1;
                                charAt11 = str.charAt(i97);
                                if (charAt11 < 55296) {
                                    break;
                                }
                                i98 |= (charAt11 & 8191) << i99;
                                i99 += 13;
                                i97 = i26;
                            }
                            charAt28 = i98 | (charAt11 << i99);
                            i97 = i26;
                        }
                        int i100 = (i32 << 1) + (charAt28 / 32);
                        Object obj3 = zzcs[i100];
                        i22 = i93;
                        if (obj3 instanceof Field) {
                            zzb = (Field) obj3;
                        } else {
                            zzb = zzb(cls3, (String) obj3);
                            zzcs[i100] = zzb;
                        }
                        i23 = i32;
                        cls2 = cls3;
                        i24 = (int) unsafe.objectFieldOffset(zzb);
                        i25 = charAt28 % 32;
                        i20 = i97;
                    }
                    if (i83 >= 18 && i83 <= 49) {
                        iArr[i71] = objectFieldOffset;
                        i71++;
                    }
                }
                int i101 = i73 + 1;
                iArr2[i73] = charAt25;
                int i102 = i101 + 1;
                iArr2[i101] = objectFieldOffset | ((charAt26 & 256) != 0 ? 268435456 : 0) | ((charAt26 & 512) != 0 ? 536870912 : 0) | (i83 << 20);
                i73 = i102 + 1;
                iArr2[i102] = (i25 << 20) | i24;
                i32 = i23;
                zzcr = str;
                i70 = i20;
                cls3 = cls2;
                i6 = i84;
                length = i75;
                i8 = i18;
                z4 = z3;
                charAt = i85;
                i7 = i22;
                zzcxVar2 = zzcxVar;
            }
            return new zzco<>(iArr2, objArr, charAt, i6, zzcxVar2.zzcl(), z4, false, iArr, i8, i68, zzcsVar, zzbuVar, zzdsVar, zzarVar, zzcdVar);
        }
        ((zzdl) zzciVar).zzcj();
        int i103 = zzbc.zze.zzil;
        throw new NoSuchMethodError();
    }

    private final void zzc(T t3, T t4, int i4) {
        int zzai = zzai(i4);
        int i5 = this.zzks[i4];
        long j4 = zzai & 1048575;
        if (zzb((zzco<T>) t4, i5, i4)) {
            Object zzp = zzdy.zzp(t3, j4);
            Object zzp2 = zzdy.zzp(t4, j4);
            if (zzp != null && zzp2 != null) {
                zzdy.zzb(t3, j4, zzbd.zzb(zzp, zzp2));
                zzc((zzco<T>) t3, i5, i4);
            } else if (zzp2 != null) {
                zzdy.zzb(t3, j4, zzp2);
                zzc((zzco<T>) t3, i5, i4);
            }
        }
    }

    private static List<?> zze(Object obj, long j4) {
        return (List) zzdy.zzp(obj, j4);
    }

    private static <T> double zzf(T t3, long j4) {
        return ((Double) zzdy.zzp(t3, j4)).doubleValue();
    }

    private static <T> float zzg(T t3, long j4) {
        return ((Float) zzdy.zzp(t3, j4)).floatValue();
    }

    private static <T> int zzh(T t3, long j4) {
        return ((Integer) zzdy.zzp(t3, j4)).intValue();
    }

    private static <T> long zzi(T t3, long j4) {
        return ((Long) zzdy.zzp(t3, j4)).longValue();
    }

    private static <T> boolean zzj(T t3, long j4) {
        return ((Boolean) zzdy.zzp(t3, j4)).booleanValue();
    }

    private static zzdr zzo(Object obj) {
        zzbc zzbcVar = (zzbc) obj;
        zzdr zzdrVar = zzbcVar.zzih;
        if (zzdrVar == zzdr.zzdh()) {
            zzdr zzdi = zzdr.zzdi();
            zzbcVar.zzih = zzdi;
            return zzdi;
        }
        return zzdrVar;
    }

    private final int zzq(int i4, int i5) {
        if (i4 >= this.zzku && i4 <= this.zzkv) {
            return zzr(i4, i5);
        }
        return -1;
    }

    private final int zzr(int i4, int i5) {
        int length = (this.zzks.length / 3) - 1;
        while (i5 <= length) {
            int i6 = (length + i5) >>> 1;
            int i7 = i6 * 3;
            int i8 = this.zzks[i7];
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

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.places.zzdy.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.places.zzdy.zzo(r11, r6))) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzm(r10, r6) == com.google.android.gms.internal.places.zzdy.zzm(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0165, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018b, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.places.zzdy.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.places.zzdy.zzn(r11, r6))) goto L85;
     */
    @Override // com.google.android.gms.internal.places.zzda
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.equals(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final int hashCode(T t3) {
        int i4;
        int zzl;
        int length = this.zzks.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int zzai = zzai(i6);
            int i7 = this.zzks[i6];
            long j4 = 1048575 & zzai;
            int i8 = 37;
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    i4 = i5 * 53;
                    zzl = zzbd.zzl(Double.doubleToLongBits(zzdy.zzo(t3, j4)));
                    i5 = i4 + zzl;
                    break;
                case 1:
                    i4 = i5 * 53;
                    zzl = Float.floatToIntBits(zzdy.zzn(t3, j4));
                    i5 = i4 + zzl;
                    break;
                case 2:
                    i4 = i5 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t3, j4));
                    i5 = i4 + zzl;
                    break;
                case 3:
                    i4 = i5 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t3, j4));
                    i5 = i4 + zzl;
                    break;
                case 4:
                    i4 = i5 * 53;
                    zzl = zzdy.zzk(t3, j4);
                    i5 = i4 + zzl;
                    break;
                case 5:
                    i4 = i5 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t3, j4));
                    i5 = i4 + zzl;
                    break;
                case 6:
                    i4 = i5 * 53;
                    zzl = zzdy.zzk(t3, j4);
                    i5 = i4 + zzl;
                    break;
                case 7:
                    i4 = i5 * 53;
                    zzl = zzbd.zze(zzdy.zzm(t3, j4));
                    i5 = i4 + zzl;
                    break;
                case 8:
                    i4 = i5 * 53;
                    zzl = ((String) zzdy.zzp(t3, j4)).hashCode();
                    i5 = i4 + zzl;
                    break;
                case 9:
                    Object zzp = zzdy.zzp(t3, j4);
                    if (zzp != null) {
                        i8 = zzp.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 10:
                    i4 = i5 * 53;
                    zzl = zzdy.zzp(t3, j4).hashCode();
                    i5 = i4 + zzl;
                    break;
                case 11:
                    i4 = i5 * 53;
                    zzl = zzdy.zzk(t3, j4);
                    i5 = i4 + zzl;
                    break;
                case 12:
                    i4 = i5 * 53;
                    zzl = zzdy.zzk(t3, j4);
                    i5 = i4 + zzl;
                    break;
                case 13:
                    i4 = i5 * 53;
                    zzl = zzdy.zzk(t3, j4);
                    i5 = i4 + zzl;
                    break;
                case 14:
                    i4 = i5 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t3, j4));
                    i5 = i4 + zzl;
                    break;
                case 15:
                    i4 = i5 * 53;
                    zzl = zzdy.zzk(t3, j4);
                    i5 = i4 + zzl;
                    break;
                case 16:
                    i4 = i5 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t3, j4));
                    i5 = i4 + zzl;
                    break;
                case 17:
                    Object zzp2 = zzdy.zzp(t3, j4);
                    if (zzp2 != null) {
                        i8 = zzp2.hashCode();
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
                    zzl = zzdy.zzp(t3, j4).hashCode();
                    i5 = i4 + zzl;
                    break;
                case 50:
                    i4 = i5 * 53;
                    zzl = zzdy.zzp(t3, j4).hashCode();
                    i5 = i4 + zzl;
                    break;
                case 51:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzbd.zzl(Double.doubleToLongBits(zzf(t3, j4)));
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = Float.floatToIntBits(zzg(t3, j4));
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzbd.zzl(zzi(t3, j4));
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzbd.zzl(zzi(t3, j4));
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzh(t3, j4);
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzbd.zzl(zzi(t3, j4));
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzh(t3, j4);
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzbd.zze(zzj(t3, j4));
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = ((String) zzdy.zzp(t3, j4)).hashCode();
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzdy.zzp(t3, j4).hashCode();
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzdy.zzp(t3, j4).hashCode();
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzh(t3, j4);
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzh(t3, j4);
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzh(t3, j4);
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzbd.zzl(zzi(t3, j4));
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzh(t3, j4);
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzbd.zzl(zzi(t3, j4));
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzb((zzco<T>) t3, i7, i6)) {
                        i4 = i5 * 53;
                        zzl = zzdy.zzp(t3, j4).hashCode();
                        i5 = i4 + zzl;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i5 * 53) + this.zzlg.zzr(t3).hashCode();
        if (this.zzkx) {
            return (hashCode * 53) + this.zzlh.zzb(t3).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final T newInstance() {
        return (T) this.zzle.newInstance(this.zzkw);
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final void zzd(T t3, T t4) {
        t4.getClass();
        for (int i4 = 0; i4 < this.zzks.length; i4 += 3) {
            int zzai = zzai(i4);
            long j4 = 1048575 & zzai;
            int i5 = this.zzks[i4];
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb(t3, j4, zzdy.zzo(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzn(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzl(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzl(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzk(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzl(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzk(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb(t3, j4, zzdy.zzm(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb(t3, j4, zzdy.zzp(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzb(t3, t4, i4);
                    break;
                case 10:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb(t3, j4, zzdy.zzp(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzk(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzk(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzk(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzl(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzk(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzb((zzco<T>) t4, i4)) {
                        zzdy.zzb((Object) t3, j4, zzdy.zzl(t4, j4));
                        zzc((zzco<T>) t3, i4);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzb(t3, t4, i4);
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
                    this.zzlf.zzb(t3, t4, j4);
                    break;
                case 50:
                    zzdc.zzb(this.zzli, t3, t4, j4);
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
                    if (zzb((zzco<T>) t4, i5, i4)) {
                        zzdy.zzb(t3, j4, zzdy.zzp(t4, j4));
                        zzc((zzco<T>) t3, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzc(t3, t4, i4);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzb((zzco<T>) t4, i5, i4)) {
                        zzdy.zzb(t3, j4, zzdy.zzp(t4, j4));
                        zzc((zzco<T>) t3, i5, i4);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzc(t3, t4, i4);
                    break;
            }
        }
        if (this.zzkz) {
            return;
        }
        zzdc.zzb(this.zzlg, t3, t4);
        if (this.zzkx) {
            zzdc.zzb(this.zzlh, t3, t4);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.places.zzda
    public final int zzn(T t3) {
        int i4;
        int i5;
        long j4;
        int zze;
        int zzc;
        int zzl;
        int zzw;
        int zzm;
        int zzr;
        int zzt;
        int i6;
        int zzc2;
        int zzm2;
        int zzr2;
        int zzt2;
        int i7 = 267386880;
        int i8 = 1;
        if (this.zzkz) {
            Unsafe unsafe = zzkr;
            int i9 = 0;
            int i10 = 0;
            while (i9 < this.zzks.length) {
                int zzai = zzai(i9);
                int i11 = (zzai & i7) >>> 20;
                int i12 = this.zzks[i9];
                long j5 = zzai & 1048575;
                if (i11 >= zzaw.zzgw.id() && i11 <= zzaw.zzhj.id()) {
                    i6 = this.zzks[i9 + 2] & 1048575;
                } else {
                    i6 = 0;
                }
                switch (i11) {
                    case 0:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzc(i12, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 1:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzc(i12, 0.0f);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 2:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zze(i12, zzdy.zzl(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 3:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzf(i12, zzdy.zzl(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 4:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzh(i12, zzdy.zzk(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 5:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzh(i12, 0L);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 6:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzk(i12, 0);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 7:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzd(i12, true);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 8:
                        if (zzb((zzco<T>) t3, i9)) {
                            Object zzp = zzdy.zzp(t3, j5);
                            if (zzp instanceof zzw) {
                                zzc2 = zzaj.zzd(i12, (zzw) zzp);
                                break;
                            } else {
                                zzc2 = zzaj.zzc(i12, (String) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 9:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzdc.zzd(i12, zzdy.zzp(t3, j5), zzaf(i9));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 10:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzd(i12, (zzw) zzdy.zzp(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 11:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzi(i12, zzdy.zzk(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 12:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzm(i12, zzdy.zzk(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 13:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzl(i12, 0);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 14:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzi(i12, 0L);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 15:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzj(i12, zzdy.zzk(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 16:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzg(i12, zzdy.zzl(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 17:
                        if (zzb((zzco<T>) t3, i9)) {
                            zzc2 = zzaj.zzd(i12, (zzck) zzdy.zzp(t3, j5), zzaf(i9));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 18:
                        zzc2 = zzdc.zzx(i12, zze(t3, j5), false);
                        break;
                    case 19:
                        zzc2 = zzdc.zzw(i12, zze(t3, j5), false);
                        break;
                    case 20:
                        zzc2 = zzdc.zzp(i12, zze(t3, j5), false);
                        break;
                    case 21:
                        zzc2 = zzdc.zzq(i12, zze(t3, j5), false);
                        break;
                    case 22:
                        zzc2 = zzdc.zzt(i12, zze(t3, j5), false);
                        break;
                    case 23:
                        zzc2 = zzdc.zzx(i12, zze(t3, j5), false);
                        break;
                    case 24:
                        zzc2 = zzdc.zzw(i12, zze(t3, j5), false);
                        break;
                    case 25:
                        zzc2 = zzdc.zzy(i12, zze(t3, j5), false);
                        break;
                    case 26:
                        zzc2 = zzdc.zzd(i12, zze(t3, j5));
                        break;
                    case 27:
                        zzc2 = zzdc.zzd(i12, zze(t3, j5), zzaf(i9));
                        break;
                    case 28:
                        zzc2 = zzdc.zze(i12, (List<zzw>) zze(t3, j5));
                        break;
                    case 29:
                        zzc2 = zzdc.zzu(i12, zze(t3, j5), false);
                        break;
                    case 30:
                        zzc2 = zzdc.zzs(i12, zze(t3, j5), false);
                        break;
                    case 31:
                        zzc2 = zzdc.zzw(i12, zze(t3, j5), false);
                        break;
                    case 32:
                        zzc2 = zzdc.zzx(i12, zze(t3, j5), false);
                        break;
                    case 33:
                        zzc2 = zzdc.zzv(i12, zze(t3, j5), false);
                        break;
                    case 34:
                        zzc2 = zzdc.zzr(i12, zze(t3, j5), false);
                        break;
                    case 35:
                        zzm2 = zzdc.zzm((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 36:
                        zzm2 = zzdc.zzl((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 37:
                        zzm2 = zzdc.zze((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 38:
                        zzm2 = zzdc.zzf((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 39:
                        zzm2 = zzdc.zzi((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 40:
                        zzm2 = zzdc.zzm((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 41:
                        zzm2 = zzdc.zzl((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 42:
                        zzm2 = zzdc.zzn((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 43:
                        zzm2 = zzdc.zzj((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 44:
                        zzm2 = zzdc.zzh((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 45:
                        zzm2 = zzdc.zzl((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 46:
                        zzm2 = zzdc.zzm((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 47:
                        zzm2 = zzdc.zzk((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 48:
                        zzm2 = zzdc.zzg((List) unsafe.getObject(t3, j5));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t3, i6, zzm2);
                            }
                            zzr2 = zzaj.zzr(i12);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 49:
                        zzc2 = zzdc.zze(i12, zze(t3, j5), zzaf(i9));
                        break;
                    case 50:
                        zzc2 = this.zzli.zzc(i12, zzdy.zzp(t3, j5), zzag(i9));
                        break;
                    case 51:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzc(i12, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 52:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzc(i12, 0.0f);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 53:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zze(i12, zzi(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 54:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzf(i12, zzi(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 55:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzh(i12, zzh(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 56:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzh(i12, 0L);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 57:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzk(i12, 0);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 58:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzd(i12, true);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 59:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            Object zzp2 = zzdy.zzp(t3, j5);
                            if (zzp2 instanceof zzw) {
                                zzc2 = zzaj.zzd(i12, (zzw) zzp2);
                                break;
                            } else {
                                zzc2 = zzaj.zzc(i12, (String) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 60:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzdc.zzd(i12, zzdy.zzp(t3, j5), zzaf(i9));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 61:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzd(i12, (zzw) zzdy.zzp(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 62:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzi(i12, zzh(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 63:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzm(i12, zzh(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 64:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzl(i12, 0);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 65:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzi(i12, 0L);
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 66:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzj(i12, zzh(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 67:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzg(i12, zzi(t3, j5));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    case 68:
                        if (zzb((zzco<T>) t3, i12, i9)) {
                            zzc2 = zzaj.zzd(i12, (zzck) zzdy.zzp(t3, j5), zzaf(i9));
                            break;
                        } else {
                            continue;
                            i9 += 3;
                            i7 = 267386880;
                        }
                    default:
                        i9 += 3;
                        i7 = 267386880;
                }
                i10 += zzc2;
                i9 += 3;
                i7 = 267386880;
            }
            return i10 + zzb(this.zzlg, t3);
        }
        Unsafe unsafe2 = zzkr;
        int i13 = -1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < this.zzks.length) {
            int zzai2 = zzai(i14);
            int[] iArr = this.zzks;
            int i17 = iArr[i14];
            int i18 = (zzai2 & 267386880) >>> 20;
            if (i18 <= 17) {
                int i19 = iArr[i14 + 2];
                int i20 = i19 & 1048575;
                i5 = i8 << (i19 >>> 20);
                if (i20 != i13) {
                    i16 = unsafe2.getInt(t3, i20);
                    i13 = i20;
                }
                i4 = i19;
            } else {
                if (this.zzla && i18 >= zzaw.zzgw.id() && i18 <= zzaw.zzhj.id()) {
                    i4 = this.zzks[i14 + 2] & 1048575;
                } else {
                    i4 = 0;
                }
                i5 = 0;
            }
            long j6 = zzai2 & 1048575;
            switch (i18) {
                case 0:
                    j4 = 0;
                    if ((i16 & i5) != 0) {
                        i15 += zzaj.zzc(i17, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        break;
                    }
                    break;
                case 1:
                    j4 = 0;
                    if ((i16 & i5) != 0) {
                        i15 += zzaj.zzc(i17, 0.0f);
                        break;
                    }
                case 2:
                    j4 = 0;
                    if ((i16 & i5) != 0) {
                        zze = zzaj.zze(i17, unsafe2.getLong(t3, j6));
                        i15 += zze;
                    }
                    break;
                case 3:
                    j4 = 0;
                    if ((i16 & i5) != 0) {
                        zze = zzaj.zzf(i17, unsafe2.getLong(t3, j6));
                        i15 += zze;
                    }
                    break;
                case 4:
                    j4 = 0;
                    if ((i16 & i5) != 0) {
                        zze = zzaj.zzh(i17, unsafe2.getInt(t3, j6));
                        i15 += zze;
                    }
                    break;
                case 5:
                    j4 = 0;
                    if ((i16 & i5) != 0) {
                        zze = zzaj.zzh(i17, 0L);
                        i15 += zze;
                    }
                    break;
                case 6:
                    if ((i16 & i5) != 0) {
                        i15 += zzaj.zzk(i17, 0);
                        j4 = 0;
                        break;
                    }
                    j4 = 0;
                case 7:
                    if ((i16 & i5) != 0) {
                        i15 += zzaj.zzd(i17, true);
                        j4 = 0;
                        break;
                    }
                    j4 = 0;
                case 8:
                    if ((i16 & i5) != 0) {
                        Object object = unsafe2.getObject(t3, j6);
                        if (object instanceof zzw) {
                            zzc = zzaj.zzd(i17, (zzw) object);
                        } else {
                            zzc = zzaj.zzc(i17, (String) object);
                        }
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 9:
                    if ((i16 & i5) != 0) {
                        zzc = zzdc.zzd(i17, unsafe2.getObject(t3, j6), zzaf(i14));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 10:
                    if ((i16 & i5) != 0) {
                        zzc = zzaj.zzd(i17, (zzw) unsafe2.getObject(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 11:
                    if ((i16 & i5) != 0) {
                        zzc = zzaj.zzi(i17, unsafe2.getInt(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 12:
                    if ((i16 & i5) != 0) {
                        zzc = zzaj.zzm(i17, unsafe2.getInt(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 13:
                    if ((i16 & i5) != 0) {
                        zzl = zzaj.zzl(i17, 0);
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 14:
                    if ((i16 & i5) != 0) {
                        zzc = zzaj.zzi(i17, 0L);
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 15:
                    if ((i16 & i5) != 0) {
                        zzc = zzaj.zzj(i17, unsafe2.getInt(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 16:
                    if ((i16 & i5) != 0) {
                        zzc = zzaj.zzg(i17, unsafe2.getLong(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 17:
                    if ((i16 & i5) != 0) {
                        zzc = zzaj.zzd(i17, (zzck) unsafe2.getObject(t3, j6), zzaf(i14));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 18:
                    zzc = zzdc.zzx(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzc;
                    j4 = 0;
                    break;
                case 19:
                    zzw = zzdc.zzw(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 20:
                    zzw = zzdc.zzp(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 21:
                    zzw = zzdc.zzq(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 22:
                    zzw = zzdc.zzt(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 23:
                    zzw = zzdc.zzx(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 24:
                    zzw = zzdc.zzw(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 25:
                    zzw = zzdc.zzy(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 26:
                    zzc = zzdc.zzd(i17, (List) unsafe2.getObject(t3, j6));
                    i15 += zzc;
                    j4 = 0;
                    break;
                case 27:
                    zzc = zzdc.zzd(i17, (List<?>) unsafe2.getObject(t3, j6), zzaf(i14));
                    i15 += zzc;
                    j4 = 0;
                    break;
                case 28:
                    zzc = zzdc.zze(i17, (List) unsafe2.getObject(t3, j6));
                    i15 += zzc;
                    j4 = 0;
                    break;
                case 29:
                    zzc = zzdc.zzu(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzc;
                    j4 = 0;
                    break;
                case 30:
                    zzw = zzdc.zzs(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 31:
                    zzw = zzdc.zzw(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 32:
                    zzw = zzdc.zzx(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 33:
                    zzw = zzdc.zzv(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 34:
                    zzw = zzdc.zzr(i17, (List) unsafe2.getObject(t3, j6), false);
                    i15 += zzw;
                    j4 = 0;
                    break;
                case 35:
                    zzm = zzdc.zzm((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 36:
                    zzm = zzdc.zzl((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 37:
                    zzm = zzdc.zze((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 38:
                    zzm = zzdc.zzf((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 39:
                    zzm = zzdc.zzi((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 40:
                    zzm = zzdc.zzm((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 41:
                    zzm = zzdc.zzl((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 42:
                    zzm = zzdc.zzn((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 43:
                    zzm = zzdc.zzj((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 44:
                    zzm = zzdc.zzh((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 45:
                    zzm = zzdc.zzl((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 46:
                    zzm = zzdc.zzm((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 47:
                    zzm = zzdc.zzk((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 48:
                    zzm = zzdc.zzg((List) unsafe2.getObject(t3, j6));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t3, i4, zzm);
                        }
                        zzr = zzaj.zzr(i17);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 49:
                    zzc = zzdc.zze(i17, (List) unsafe2.getObject(t3, j6), zzaf(i14));
                    i15 += zzc;
                    j4 = 0;
                    break;
                case 50:
                    zzc = this.zzli.zzc(i17, unsafe2.getObject(t3, j6), zzag(i14));
                    i15 += zzc;
                    j4 = 0;
                    break;
                case 51:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzc(i17, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 52:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzl = zzaj.zzc(i17, 0.0f);
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 53:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zze(i17, zzi(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 54:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzf(i17, zzi(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 55:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzh(i17, zzh(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 56:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzh(i17, 0L);
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 57:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzl = zzaj.zzk(i17, 0);
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 58:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzl = zzaj.zzd(i17, true);
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 59:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        Object object2 = unsafe2.getObject(t3, j6);
                        if (object2 instanceof zzw) {
                            zzc = zzaj.zzd(i17, (zzw) object2);
                        } else {
                            zzc = zzaj.zzc(i17, (String) object2);
                        }
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 60:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzdc.zzd(i17, unsafe2.getObject(t3, j6), zzaf(i14));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 61:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzd(i17, (zzw) unsafe2.getObject(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 62:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzi(i17, zzh(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 63:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzm(i17, zzh(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 64:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzl = zzaj.zzl(i17, 0);
                        i15 += zzl;
                    }
                    j4 = 0;
                    break;
                case 65:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzi(i17, 0L);
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 66:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzj(i17, zzh(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 67:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzg(i17, zzi(t3, j6));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                case 68:
                    if (zzb((zzco<T>) t3, i17, i14)) {
                        zzc = zzaj.zzd(i17, (zzck) unsafe2.getObject(t3, j6), zzaf(i14));
                        i15 += zzc;
                    }
                    j4 = 0;
                    break;
                default:
                    j4 = 0;
                    break;
            }
            i14 += 3;
            i8 = 1;
        }
        int i21 = 0;
        int zzb = i15 + zzb(this.zzlg, t3);
        if (this.zzkx) {
            zzav<?> zzb2 = this.zzlh.zzb(t3);
            for (int i22 = 0; i22 < zzb2.zzfj.zzcu(); i22++) {
                Map.Entry<?, Object> zzam = zzb2.zzfj.zzam(i22);
                i21 += zzav.zzc((zzax) zzam.getKey(), zzam.getValue());
            }
            for (Map.Entry<?, Object> entry : zzb2.zzfj.zzcv()) {
                i21 += zzav.zzc((zzax) entry.getKey(), entry.getValue());
            }
            return zzb + i21;
        }
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.places.zzda] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.google.android.gms.internal.places.zzda] */
    /* JADX WARN: Type inference failed for: r6v15 */
    @Override // com.google.android.gms.internal.places.zzda
    public final boolean zzp(T t3) {
        int i4;
        boolean z3;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            boolean z4 = true;
            if (i6 < this.zzlc) {
                int i8 = this.zzlb[i6];
                int i9 = this.zzks[i8];
                int zzai = zzai(i8);
                if (!this.zzkz) {
                    int i10 = this.zzks[i8 + 2];
                    int i11 = i10 & 1048575;
                    i4 = 1 << (i10 >>> 20);
                    if (i11 != i5) {
                        i7 = zzkr.getInt(t3, i11);
                        i5 = i11;
                    }
                } else {
                    i4 = 0;
                }
                if ((268435456 & zzai) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 && !zzb((zzco<T>) t3, i8, i7, i4)) {
                    return false;
                }
                int i12 = (267386880 & zzai) >>> 20;
                if (i12 != 9 && i12 != 17) {
                    if (i12 != 27) {
                        if (i12 != 60 && i12 != 68) {
                            if (i12 != 49) {
                                if (i12 != 50) {
                                    continue;
                                } else {
                                    Map<?, ?> zzh = this.zzli.zzh(zzdy.zzp(t3, zzai & 1048575));
                                    if (!zzh.isEmpty()) {
                                        if (this.zzli.zzl(zzag(i8)).zzkl.zzdr() == zzem.MESSAGE) {
                                            Iterator<?> it = zzh.values().iterator();
                                            zzda<T> zzdaVar = 0;
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                Object next = it.next();
                                                if (zzdaVar == null) {
                                                    zzdaVar = zzcv.zzcq().zzf(next.getClass());
                                                }
                                                boolean zzp = zzdaVar.zzp(next);
                                                zzdaVar = zzdaVar;
                                                if (!zzp) {
                                                    z4 = false;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (!z4) {
                                        return false;
                                    }
                                }
                            }
                        } else if (zzb((zzco<T>) t3, i9, i8) && !zzb(t3, zzai, zzaf(i8))) {
                            return false;
                        }
                    }
                    List list = (List) zzdy.zzp(t3, zzai & 1048575);
                    if (!list.isEmpty()) {
                        ?? zzaf = zzaf(i8);
                        int i13 = 0;
                        while (true) {
                            if (i13 >= list.size()) {
                                break;
                            } else if (!zzaf.zzp(list.get(i13))) {
                                z4 = false;
                                break;
                            } else {
                                i13++;
                            }
                        }
                    }
                    if (!z4) {
                        return false;
                    }
                } else if (zzb((zzco<T>) t3, i8, i7, i4) && !zzb(t3, zzai, zzaf(i8))) {
                    return false;
                }
                i6++;
            } else if (this.zzkx && !this.zzlh.zzb(t3).isInitialized()) {
                return false;
            } else {
                return true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0490  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzc(T r18, com.google.android.gms.internal.places.zzel r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzc(java.lang.Object, com.google.android.gms.internal.places.zzel):void");
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final void zzd(T t3) {
        int i4;
        int i5 = this.zzlc;
        while (true) {
            i4 = this.zzld;
            if (i5 >= i4) {
                break;
            }
            long zzai = zzai(this.zzlb[i5]) & 1048575;
            Object zzp = zzdy.zzp(t3, zzai);
            if (zzp != null) {
                zzdy.zzb(t3, zzai, this.zzli.zzj(zzp));
            }
            i5++;
        }
        int length = this.zzlb.length;
        while (i4 < length) {
            this.zzlf.zzb(t3, this.zzlb[i4]);
            i4++;
        }
        this.zzlg.zzd(t3);
        if (this.zzkx) {
            this.zzlh.zzd(t3);
        }
    }

    private final boolean zzd(T t3, T t4, int i4) {
        return zzb((zzco<T>) t3, i4) == zzb((zzco<T>) t4, i4);
    }

    private static Field zzb(Class<?> cls, String str) {
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

    private final void zzb(T t3, T t4, int i4) {
        long zzai = zzai(i4) & 1048575;
        if (zzb((zzco<T>) t4, i4)) {
            Object zzp = zzdy.zzp(t3, zzai);
            Object zzp2 = zzdy.zzp(t4, zzai);
            if (zzp != null && zzp2 != null) {
                zzdy.zzb(t3, zzai, zzbd.zzb(zzp, zzp2));
                zzc((zzco<T>) t3, i4);
            } else if (zzp2 != null) {
                zzdy.zzb(t3, zzai, zzp2);
                zzc((zzco<T>) t3, i4);
            }
        }
    }

    private static <UT, UB> int zzb(zzds<UT, UB> zzdsVar, T t3) {
        return zzdsVar.zzn(zzdsVar.zzr(t3));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0a2a  */
    @Override // com.google.android.gms.internal.places.zzda
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(T r14, com.google.android.gms.internal.places.zzel r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, com.google.android.gms.internal.places.zzel):void");
    }

    private final void zzc(T t3, int i4) {
        if (this.zzkz) {
            return;
        }
        int zzaj = zzaj(i4);
        long j4 = zzaj & 1048575;
        zzdy.zzb((Object) t3, j4, zzdy.zzk(t3, j4) | (1 << (zzaj >>> 20)));
    }

    private final void zzc(T t3, int i4, int i5) {
        zzdy.zzb((Object) t3, zzaj(i5) & 1048575, i4);
    }

    private final <K, V> void zzb(zzel zzelVar, int i4, Object obj, int i5) throws IOException {
        if (obj != null) {
            zzelVar.zzb(i4, this.zzli.zzl(zzag(i5)), this.zzli.zzh(obj));
        }
    }

    private static <UT, UB> void zzb(zzds<UT, UB> zzdsVar, T t3, zzel zzelVar) throws IOException {
        zzdsVar.zzb(zzdsVar.zzr(t3), zzelVar);
    }

    private static int zzb(byte[] bArr, int i4, int i5, zzef zzefVar, Class<?> cls, zzr zzrVar) throws IOException {
        switch (zzcn.zzfi[zzefVar.ordinal()]) {
            case 1:
                int zzc = zzs.zzc(bArr, i4, zzrVar);
                zzrVar.zzeb = Boolean.valueOf(zzrVar.zzea != 0);
                return zzc;
            case 2:
                return zzs.zzf(bArr, i4, zzrVar);
            case 3:
                zzrVar.zzeb = Double.valueOf(zzs.zzd(bArr, i4));
                return i4 + 8;
            case 4:
            case 5:
                zzrVar.zzeb = Integer.valueOf(zzs.zzb(bArr, i4));
                return i4 + 4;
            case 6:
            case 7:
                zzrVar.zzeb = Long.valueOf(zzs.zzc(bArr, i4));
                return i4 + 8;
            case 8:
                zzrVar.zzeb = Float.valueOf(zzs.zze(bArr, i4));
                return i4 + 4;
            case 9:
            case 10:
            case 11:
                int zzb = zzs.zzb(bArr, i4, zzrVar);
                zzrVar.zzeb = Integer.valueOf(zzrVar.zzdz);
                return zzb;
            case 12:
            case 13:
                int zzc2 = zzs.zzc(bArr, i4, zzrVar);
                zzrVar.zzeb = Long.valueOf(zzrVar.zzea);
                return zzc2;
            case 14:
                return zzs.zzb(zzcv.zzcq().zzf(cls), bArr, i4, i5, zzrVar);
            case 15:
                int zzb2 = zzs.zzb(bArr, i4, zzrVar);
                zzrVar.zzeb = Integer.valueOf(zzai.zzm(zzrVar.zzdz));
                return zzb2;
            case 16:
                int zzc3 = zzs.zzc(bArr, i4, zzrVar);
                zzrVar.zzeb = Long.valueOf(zzai.zzb(zzrVar.zzea));
                return zzc3;
            case 17:
                return zzs.zze(bArr, i4, zzrVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0233 -> B:116:0x0234). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x016b -> B:67:0x016c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01e5 -> B:96:0x01e6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzb(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.places.zzr r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.places.zzr):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> int zzb(T t3, byte[] bArr, int i4, int i5, int i6, long j4, zzr zzrVar) throws IOException {
        Unsafe unsafe = zzkr;
        Object zzag = zzag(i6);
        Object object = unsafe.getObject(t3, j4);
        if (this.zzli.zzi(object)) {
            Object zzk = this.zzli.zzk(zzag);
            this.zzli.zzc(zzk, object);
            unsafe.putObject(t3, j4, zzk);
            object = zzk;
        }
        zzcb<?, ?> zzl = this.zzli.zzl(zzag);
        Map<?, ?> zzg = this.zzli.zzg(object);
        int zzb = zzs.zzb(bArr, i4, zzrVar);
        int i7 = zzrVar.zzdz;
        if (i7 >= 0 && i7 <= i5 - zzb) {
            int i8 = i7 + zzb;
            Object obj = (K) zzl.zzkk;
            Object obj2 = (V) zzl.zzkm;
            while (zzb < i8) {
                int i9 = zzb + 1;
                int i10 = bArr[zzb];
                if (i10 < 0) {
                    i9 = zzs.zzb(i10, bArr, i9, zzrVar);
                    i10 = zzrVar.zzdz;
                }
                int i11 = i9;
                int i12 = i10 >>> 3;
                int i13 = i10 & 7;
                if (i12 != 1) {
                    if (i12 == 2 && i13 == zzl.zzkl.zzds()) {
                        zzb = zzb(bArr, i11, i5, zzl.zzkl, zzl.zzkm.getClass(), zzrVar);
                        obj2 = zzrVar.zzeb;
                    }
                    zzb = zzs.zzb(i10, bArr, i11, i5, zzrVar);
                } else if (i13 == zzl.zzkj.zzds()) {
                    zzb = zzb(bArr, i11, i5, zzl.zzkj, (Class<?>) null, zzrVar);
                    obj = (K) zzrVar.zzeb;
                } else {
                    zzb = zzs.zzb(i10, bArr, i11, i5, zzrVar);
                }
            }
            if (zzb == i8) {
                zzg.put(obj, obj2);
                return i8;
            }
            throw zzbk.zzbt();
        }
        throw zzbk.zzbp();
    }

    private final int zzb(T t3, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4, int i11, zzr zzrVar) throws IOException {
        int zzc;
        Unsafe unsafe = zzkr;
        long j5 = this.zzks[i11 + 2] & 1048575;
        switch (i10) {
            case 51:
                if (i8 == 1) {
                    unsafe.putObject(t3, j4, Double.valueOf(zzs.zzd(bArr, i4)));
                    zzc = i4 + 8;
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 52:
                if (i8 == 5) {
                    unsafe.putObject(t3, j4, Float.valueOf(zzs.zze(bArr, i4)));
                    zzc = i4 + 4;
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 53:
            case 54:
                if (i8 == 0) {
                    zzc = zzs.zzc(bArr, i4, zzrVar);
                    unsafe.putObject(t3, j4, Long.valueOf(zzrVar.zzea));
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 55:
            case 62:
                if (i8 == 0) {
                    zzc = zzs.zzb(bArr, i4, zzrVar);
                    unsafe.putObject(t3, j4, Integer.valueOf(zzrVar.zzdz));
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 56:
            case 65:
                if (i8 == 1) {
                    unsafe.putObject(t3, j4, Long.valueOf(zzs.zzc(bArr, i4)));
                    zzc = i4 + 8;
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 57:
            case 64:
                if (i8 == 5) {
                    unsafe.putObject(t3, j4, Integer.valueOf(zzs.zzb(bArr, i4)));
                    zzc = i4 + 4;
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 58:
                if (i8 == 0) {
                    zzc = zzs.zzc(bArr, i4, zzrVar);
                    unsafe.putObject(t3, j4, Boolean.valueOf(zzrVar.zzea != 0));
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 59:
                if (i8 == 2) {
                    int zzb = zzs.zzb(bArr, i4, zzrVar);
                    int i12 = zzrVar.zzdz;
                    if (i12 == 0) {
                        unsafe.putObject(t3, j4, "");
                    } else if ((i9 & 536870912) != 0 && !zzea.zzf(bArr, zzb, zzb + i12)) {
                        throw zzbk.zzbu();
                    } else {
                        unsafe.putObject(t3, j4, new String(bArr, zzb, i12, zzbd.UTF_8));
                        zzb += i12;
                    }
                    unsafe.putInt(t3, j5, i7);
                    return zzb;
                }
                return i4;
            case 60:
                if (i8 == 2) {
                    int zzb2 = zzs.zzb(zzaf(i11), bArr, i4, i5, zzrVar);
                    Object object = unsafe.getInt(t3, j5) == i7 ? unsafe.getObject(t3, j4) : null;
                    if (object == null) {
                        unsafe.putObject(t3, j4, zzrVar.zzeb);
                    } else {
                        unsafe.putObject(t3, j4, zzbd.zzb(object, zzrVar.zzeb));
                    }
                    unsafe.putInt(t3, j5, i7);
                    return zzb2;
                }
                return i4;
            case 61:
                if (i8 == 2) {
                    zzc = zzs.zzf(bArr, i4, zzrVar);
                    unsafe.putObject(t3, j4, zzrVar.zzeb);
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 63:
                if (i8 == 0) {
                    int zzb3 = zzs.zzb(bArr, i4, zzrVar);
                    int i13 = zzrVar.zzdz;
                    zzbf zzah = zzah(i11);
                    if (zzah != null && !zzah.zzad(i13)) {
                        zzo(t3).zzc(i6, Long.valueOf(i13));
                        return zzb3;
                    }
                    unsafe.putObject(t3, j4, Integer.valueOf(i13));
                    zzc = zzb3;
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 66:
                if (i8 == 0) {
                    zzc = zzs.zzb(bArr, i4, zzrVar);
                    unsafe.putObject(t3, j4, Integer.valueOf(zzai.zzm(zzrVar.zzdz)));
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 67:
                if (i8 == 0) {
                    zzc = zzs.zzc(bArr, i4, zzrVar);
                    unsafe.putObject(t3, j4, Long.valueOf(zzai.zzb(zzrVar.zzea)));
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            case 68:
                if (i8 == 3) {
                    zzc = zzs.zzb(zzaf(i11), bArr, i4, i5, (i6 & (-8)) | 4, zzrVar);
                    Object object2 = unsafe.getInt(t3, j5) == i7 ? unsafe.getObject(t3, j4) : null;
                    if (object2 == null) {
                        unsafe.putObject(t3, j4, zzrVar.zzeb);
                    } else {
                        unsafe.putObject(t3, j4, zzbd.zzb(object2, zzrVar.zzeb));
                    }
                    unsafe.putInt(t3, j5, i7);
                    return zzc;
                }
                return i4;
            default:
                return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(T t3, byte[] bArr, int i4, int i5, int i6, zzr zzrVar) throws IOException {
        Unsafe unsafe;
        int i7;
        T t4;
        zzco<T> zzcoVar;
        int i8;
        int i9;
        int i10;
        int i11;
        zzbf zzah;
        byte b4;
        int i12;
        int zzak;
        int i13;
        int i14;
        int i15;
        T t5;
        int i16;
        zzr zzrVar2;
        int i17;
        int i18;
        int i19;
        zzr zzrVar3;
        int i20;
        zzr zzrVar4;
        int i21;
        int i22;
        zzr zzrVar5;
        int i23;
        int i24;
        int i25;
        zzco<T> zzcoVar2 = this;
        T t6 = t3;
        byte[] bArr2 = bArr;
        int i26 = i5;
        int i27 = i6;
        zzr zzrVar6 = zzrVar;
        Unsafe unsafe2 = zzkr;
        int i28 = i4;
        int i29 = -1;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = -1;
        while (true) {
            if (i28 < i26) {
                int i34 = i28 + 1;
                byte b5 = bArr2[i28];
                if (b5 < 0) {
                    i12 = zzs.zzb(b5, bArr2, i34, zzrVar6);
                    b4 = zzrVar6.zzdz;
                } else {
                    b4 = b5;
                    i12 = i34;
                }
                int i35 = b4 >>> 3;
                int i36 = b4 & 7;
                if (i35 > i29) {
                    zzak = zzcoVar2.zzq(i35, i30 / 3);
                } else {
                    zzak = zzcoVar2.zzak(i35);
                }
                int i37 = zzak;
                if (i37 == -1) {
                    i13 = i35;
                    i14 = i12;
                    i9 = b4;
                    unsafe = unsafe2;
                    i7 = i27;
                    i15 = 0;
                } else {
                    int[] iArr = zzcoVar2.zzks;
                    int i38 = iArr[i37 + 1];
                    int i39 = (i38 & 267386880) >>> 20;
                    int i40 = b4;
                    long j4 = i38 & 1048575;
                    if (i39 <= 17) {
                        int i41 = iArr[i37 + 2];
                        int i42 = 1 << (i41 >>> 20);
                        int i43 = i41 & 1048575;
                        if (i43 != i33) {
                            if (i33 != -1) {
                                unsafe2.putInt(t6, i33, i32);
                            }
                            i32 = unsafe2.getInt(t6, i43);
                            i33 = i43;
                        }
                        switch (i39) {
                            case 0:
                                i17 = i37;
                                i18 = i35;
                                i20 = i33;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                i21 = i12;
                                if (i36 == 1) {
                                    zzdy.zzb(t6, j4, zzs.zzd(bArr2, i21));
                                    i28 = i21 + 8;
                                    i32 |= i42;
                                    i33 = i20;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar4;
                                    i26 = i5;
                                    i27 = i6;
                                    break;
                                } else {
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 1:
                                i17 = i37;
                                i18 = i35;
                                i20 = i33;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                i21 = i12;
                                if (i36 == 5) {
                                    zzdy.zzb((Object) t6, j4, zzs.zze(bArr2, i21));
                                    i28 = i21 + 4;
                                    i32 |= i42;
                                    i33 = i20;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar4;
                                    i26 = i5;
                                    i27 = i6;
                                    break;
                                } else {
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 2:
                            case 3:
                                i17 = i37;
                                i18 = i35;
                                i20 = i33;
                                i19 = i40;
                                bArr2 = bArr;
                                i21 = i12;
                                if (i36 == 0) {
                                    int zzc = zzs.zzc(bArr2, i21, zzrVar);
                                    unsafe2.putLong(t3, j4, zzrVar.zzea);
                                    i32 |= i42;
                                    i28 = zzc;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar;
                                    i33 = i20;
                                    i26 = i5;
                                    i27 = i6;
                                    break;
                                } else {
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 4:
                            case 11:
                                i17 = i37;
                                i18 = i35;
                                i20 = i33;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                i21 = i12;
                                if (i36 == 0) {
                                    i28 = zzs.zzb(bArr2, i21, zzrVar4);
                                    unsafe2.putInt(t6, j4, zzrVar4.zzdz);
                                    i32 |= i42;
                                    i33 = i20;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar4;
                                    i26 = i5;
                                    i27 = i6;
                                    break;
                                } else {
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 5:
                            case 14:
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                if (i36 == 1) {
                                    i20 = i33;
                                    i21 = i12;
                                    unsafe2.putLong(t3, j4, zzs.zzc(bArr2, i12));
                                    i28 = i21 + 8;
                                    i32 |= i42;
                                    i33 = i20;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar4;
                                    i26 = i5;
                                    i27 = i6;
                                    break;
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 6:
                            case 13:
                                i22 = i5;
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar5 = zzrVar;
                                if (i36 == 5) {
                                    unsafe2.putInt(t6, j4, zzs.zzb(bArr2, i12));
                                    i28 = i12 + 4;
                                    i32 |= i42;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar5;
                                    i27 = i6;
                                    i26 = i22;
                                    break;
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 7:
                                i22 = i5;
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar5 = zzrVar;
                                if (i36 == 0) {
                                    int zzc2 = zzs.zzc(bArr2, i12, zzrVar5);
                                    zzdy.zzb(t6, j4, zzrVar5.zzea != 0);
                                    i32 |= i42;
                                    i28 = zzc2;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar5;
                                    i27 = i6;
                                    i26 = i22;
                                    break;
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 8:
                                i22 = i5;
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar5 = zzrVar;
                                if (i36 == 2) {
                                    if ((i38 & 536870912) == 0) {
                                        i28 = zzs.zzd(bArr2, i12, zzrVar5);
                                    } else {
                                        i28 = zzs.zze(bArr2, i12, zzrVar5);
                                    }
                                    unsafe2.putObject(t6, j4, zzrVar5.zzeb);
                                    i32 |= i42;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar5;
                                    i27 = i6;
                                    i26 = i22;
                                    break;
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 9:
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar5 = zzrVar;
                                if (i36 == 2) {
                                    i22 = i5;
                                    i28 = zzs.zzb(zzcoVar2.zzaf(i17), bArr2, i12, i22, zzrVar5);
                                    if ((i32 & i42) == 0) {
                                        unsafe2.putObject(t6, j4, zzrVar5.zzeb);
                                    } else {
                                        unsafe2.putObject(t6, j4, zzbd.zzb(unsafe2.getObject(t6, j4), zzrVar5.zzeb));
                                    }
                                    i32 |= i42;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar5;
                                    i27 = i6;
                                    i26 = i22;
                                    break;
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 10:
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                if (i36 == 2) {
                                    i28 = zzs.zzf(bArr2, i12, zzrVar4);
                                    unsafe2.putObject(t6, j4, zzrVar4.zzeb);
                                    i32 |= i42;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar4;
                                    i26 = i5;
                                    i27 = i6;
                                    break;
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 12:
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                if (i36 == 0) {
                                    i28 = zzs.zzb(bArr2, i12, zzrVar4);
                                    int i44 = zzrVar4.zzdz;
                                    zzbf zzah2 = zzcoVar2.zzah(i17);
                                    if (zzah2 != null && !zzah2.zzad(i44)) {
                                        zzo(t3).zzc(i19, Long.valueOf(i44));
                                        i31 = i19;
                                        i30 = i17;
                                        i29 = i18;
                                        zzrVar6 = zzrVar4;
                                        i26 = i5;
                                        i27 = i6;
                                    } else {
                                        unsafe2.putInt(t6, j4, i44);
                                        i32 |= i42;
                                        i31 = i19;
                                        i30 = i17;
                                        i29 = i18;
                                        zzrVar6 = zzrVar4;
                                        i26 = i5;
                                        i27 = i6;
                                        break;
                                    }
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                                break;
                            case 15:
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                if (i36 == 0) {
                                    i28 = zzs.zzb(bArr2, i12, zzrVar4);
                                    unsafe2.putInt(t6, j4, zzai.zzm(zzrVar4.zzdz));
                                    i32 |= i42;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar4;
                                    i26 = i5;
                                    i27 = i6;
                                    break;
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 16:
                                i17 = i37;
                                i18 = i35;
                                i19 = i40;
                                if (i36 == 0) {
                                    bArr2 = bArr;
                                    int zzc3 = zzs.zzc(bArr2, i12, zzrVar);
                                    zzrVar4 = zzrVar;
                                    unsafe2.putLong(t3, j4, zzai.zzb(zzrVar.zzea));
                                    i32 |= i42;
                                    i28 = zzc3;
                                    i31 = i19;
                                    i30 = i17;
                                    i29 = i18;
                                    zzrVar6 = zzrVar4;
                                    i26 = i5;
                                    i27 = i6;
                                    break;
                                } else {
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            case 17:
                                if (i36 == 3) {
                                    i28 = zzs.zzb(zzcoVar2.zzaf(i37), bArr, i12, i5, (i35 << 3) | 4, zzrVar);
                                    if ((i32 & i42) == 0) {
                                        zzrVar3 = zzrVar;
                                        unsafe2.putObject(t6, j4, zzrVar3.zzeb);
                                    } else {
                                        zzrVar3 = zzrVar;
                                        unsafe2.putObject(t6, j4, zzbd.zzb(unsafe2.getObject(t6, j4), zzrVar3.zzeb));
                                    }
                                    i32 |= i42;
                                    bArr2 = bArr;
                                    i26 = i5;
                                    i31 = i40;
                                    i30 = i37;
                                    i29 = i35;
                                    i27 = i6;
                                    zzrVar6 = zzrVar3;
                                    break;
                                } else {
                                    i17 = i37;
                                    i18 = i35;
                                    i19 = i40;
                                    i20 = i33;
                                    i21 = i12;
                                    i14 = i21;
                                    i15 = i17;
                                    unsafe = unsafe2;
                                    i33 = i20;
                                    i9 = i19;
                                    i13 = i18;
                                    i7 = i6;
                                    break;
                                }
                            default:
                                i17 = i37;
                                i18 = i35;
                                i20 = i33;
                                i19 = i40;
                                i21 = i12;
                                i14 = i21;
                                i15 = i17;
                                unsafe = unsafe2;
                                i33 = i20;
                                i9 = i19;
                                i13 = i18;
                                i7 = i6;
                                break;
                        }
                    } else {
                        int i45 = i33;
                        int i46 = i12;
                        bArr2 = bArr;
                        zzr zzrVar7 = zzrVar6;
                        if (i39 != 27) {
                            i23 = i32;
                            if (i39 <= 49) {
                                i13 = i35;
                                i25 = i40;
                                i15 = i37;
                                unsafe = unsafe2;
                                i28 = zzb((zzco<T>) t3, bArr, i46, i5, i40, i13, i36, i37, i38, i39, j4, zzrVar);
                                if (i28 == i46) {
                                    i7 = i6;
                                    i14 = i28;
                                } else {
                                    zzcoVar2 = this;
                                    t6 = t3;
                                    bArr2 = bArr;
                                    i29 = i13;
                                    i26 = i5;
                                    i27 = i6;
                                    zzrVar6 = zzrVar;
                                    i33 = i45;
                                    i30 = i15;
                                    i32 = i23;
                                    i31 = i25;
                                    unsafe2 = unsafe;
                                }
                            } else {
                                i13 = i35;
                                i24 = i46;
                                i25 = i40;
                                i15 = i37;
                                unsafe = unsafe2;
                                if (i39 != 50) {
                                    i28 = zzb((zzco<T>) t3, bArr, i24, i5, i25, i13, i36, i38, i39, j4, i15, zzrVar);
                                    if (i28 != i24) {
                                        zzcoVar2 = this;
                                        t6 = t3;
                                        i26 = i5;
                                        i27 = i6;
                                        i31 = i25;
                                        i29 = i13;
                                        i33 = i45;
                                        i30 = i15;
                                        i32 = i23;
                                        unsafe2 = unsafe;
                                        bArr2 = bArr;
                                        zzrVar6 = zzrVar;
                                    }
                                } else if (i36 == 2) {
                                    i28 = zzb((zzco<T>) t3, bArr, i24, i5, i15, j4, zzrVar);
                                    if (i28 != i24) {
                                        zzcoVar2 = this;
                                        t6 = t3;
                                        bArr2 = bArr;
                                        i29 = i13;
                                        i26 = i5;
                                        i27 = i6;
                                        zzrVar6 = zzrVar;
                                        i33 = i45;
                                        i30 = i15;
                                        i32 = i23;
                                        i31 = i25;
                                        unsafe2 = unsafe;
                                    }
                                } else {
                                    i7 = i6;
                                    i14 = i24;
                                }
                                i7 = i6;
                                i14 = i28;
                            }
                        } else if (i36 == 2) {
                            zzbh zzbhVar = (zzbh) unsafe2.getObject(t6, j4);
                            if (!zzbhVar.zzaa()) {
                                int size = zzbhVar.size();
                                zzbhVar = zzbhVar.zzh(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t6, j4, zzbhVar);
                            }
                            i28 = zzs.zzb(zzcoVar2.zzaf(i37), i40, bArr, i46, i5, zzbhVar, zzrVar);
                            i27 = i6;
                            i29 = i35;
                            i31 = i40;
                            i30 = i37;
                            zzrVar6 = zzrVar7;
                            i33 = i45;
                            i32 = i32;
                            i26 = i5;
                        } else {
                            i23 = i32;
                            i13 = i35;
                            i24 = i46;
                            i25 = i40;
                            i15 = i37;
                            unsafe = unsafe2;
                            i7 = i6;
                            i14 = i24;
                        }
                        i33 = i45;
                        i32 = i23;
                        i9 = i25;
                    }
                }
                if (i9 != i7 || i7 == 0) {
                    if (this.zzkx) {
                        zzrVar2 = zzrVar;
                        if (zzrVar2.zzec != zzap.zzao()) {
                            int i47 = i13;
                            if (zzrVar2.zzec.zzb(this.zzkw, i47) == null) {
                                i28 = zzs.zzb(i9, bArr, i14, i5, zzo(t3), zzrVar);
                                t6 = t3;
                                i26 = i5;
                                i31 = i9;
                                zzcoVar2 = this;
                                zzrVar6 = zzrVar2;
                                i29 = i47;
                                i30 = i15;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i27 = i7;
                            } else {
                                zzbc.zzc zzcVar = (zzbc.zzc) t3;
                                zzcVar.zzbm();
                                zzav<Object> zzavVar = zzcVar.zzik;
                                throw new NoSuchMethodError();
                            }
                        } else {
                            t5 = t3;
                            i16 = i13;
                        }
                    } else {
                        t5 = t3;
                        i16 = i13;
                        zzrVar2 = zzrVar;
                    }
                    i28 = zzs.zzb(i9, bArr, i14, i5, zzo(t3), zzrVar);
                    i31 = i9;
                    zzcoVar2 = this;
                    zzrVar6 = zzrVar2;
                    i29 = i16;
                    t6 = t5;
                    i30 = i15;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i26 = i5;
                    i27 = i7;
                } else {
                    zzcoVar = this;
                    t4 = t3;
                    i10 = i33;
                    i11 = -1;
                    i8 = i14;
                }
            } else {
                int i48 = i33;
                unsafe = unsafe2;
                i7 = i27;
                t4 = t6;
                zzcoVar = zzcoVar2;
                i8 = i28;
                i9 = i31;
                i10 = i48;
                i11 = -1;
            }
        }
        if (i10 != i11) {
            unsafe.putInt(t4, i10, i32);
        }
        Object obj = null;
        for (int i49 = zzcoVar.zzlc; i49 < zzcoVar.zzld; i49++) {
            int i50 = zzcoVar.zzlb[i49];
            zzds zzdsVar = zzcoVar.zzlg;
            int i51 = zzcoVar.zzks[i50];
            Object zzp = zzdy.zzp(t4, zzcoVar.zzai(i50) & 1048575);
            if (zzp != null && (zzah = zzcoVar.zzah(i50)) != null) {
                obj = zzb(i50, i51, zzcoVar.zzli.zzg(zzp), zzah, (zzbf) obj, (zzds<UT, zzbf>) zzdsVar);
            }
            obj = (zzdr) obj;
        }
        if (obj != null) {
            zzcoVar.zzlg.zzg(t4, obj);
        }
        if (i7 == 0) {
            if (i8 != i5) {
                throw zzbk.zzbt();
            }
        } else if (i8 > i5 || i9 != i7) {
            throw zzbk.zzbt();
        }
        return i8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x022e, code lost:
        if (r0 == r15) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0230, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e2, code lost:
        if (r0 == r15) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x020f, code lost:
        if (r0 == r15) goto L96;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    @Override // com.google.android.gms.internal.places.zzda
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.places.zzr r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, com.google.android.gms.internal.places.zzr):void");
    }

    private final <K, V, UT, UB> UB zzb(int i4, int i5, Map<K, V> map, zzbf zzbfVar, UB ub, zzds<UT, UB> zzdsVar) {
        zzcb<?, ?> zzl = this.zzli.zzl(zzag(i4));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzbfVar.zzad(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzdsVar.zzdk();
                }
                zzae zzk = zzw.zzk(zzcc.zzb(zzl, next.getKey(), next.getValue()));
                try {
                    zzcc.zzb(zzk.zzai(), zzl, next.getKey(), next.getValue());
                    zzdsVar.zzb((zzds<UT, UB>) ub, i5, zzk.zzah());
                    it.remove();
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzb(Object obj, int i4, zzda zzdaVar) {
        return zzdaVar.zzp(zzdy.zzp(obj, i4 & 1048575));
    }

    private static void zzb(int i4, Object obj, zzel zzelVar) throws IOException {
        if (obj instanceof String) {
            zzelVar.zzb(i4, (String) obj);
        } else {
            zzelVar.zzb(i4, (zzw) obj);
        }
    }

    private final boolean zzb(T t3, int i4, int i5, int i6) {
        if (this.zzkz) {
            return zzb((zzco<T>) t3, i4);
        }
        return (i5 & i6) != 0;
    }

    private final boolean zzb(T t3, int i4) {
        if (this.zzkz) {
            int zzai = zzai(i4);
            long j4 = zzai & 1048575;
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    return zzdy.zzo(t3, j4) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return zzdy.zzn(t3, j4) != 0.0f;
                case 2:
                    return zzdy.zzl(t3, j4) != 0;
                case 3:
                    return zzdy.zzl(t3, j4) != 0;
                case 4:
                    return zzdy.zzk(t3, j4) != 0;
                case 5:
                    return zzdy.zzl(t3, j4) != 0;
                case 6:
                    return zzdy.zzk(t3, j4) != 0;
                case 7:
                    return zzdy.zzm(t3, j4);
                case 8:
                    Object zzp = zzdy.zzp(t3, j4);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    } else if (zzp instanceof zzw) {
                        return !zzw.zzeg.equals(zzp);
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    return zzdy.zzp(t3, j4) != null;
                case 10:
                    return !zzw.zzeg.equals(zzdy.zzp(t3, j4));
                case 11:
                    return zzdy.zzk(t3, j4) != 0;
                case 12:
                    return zzdy.zzk(t3, j4) != 0;
                case 13:
                    return zzdy.zzk(t3, j4) != 0;
                case 14:
                    return zzdy.zzl(t3, j4) != 0;
                case 15:
                    return zzdy.zzk(t3, j4) != 0;
                case 16:
                    return zzdy.zzl(t3, j4) != 0;
                case 17:
                    return zzdy.zzp(t3, j4) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int zzaj = zzaj(i4);
        return (zzdy.zzk(t3, (long) (zzaj & 1048575)) & (1 << (zzaj >>> 20))) != 0;
    }

    private final boolean zzb(T t3, int i4, int i5) {
        return zzdy.zzk(t3, (long) (zzaj(i5) & 1048575)) == i4;
    }
}
