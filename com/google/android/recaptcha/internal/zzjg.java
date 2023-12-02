package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzjg {
    private static final zzjg zza = new zzjg(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzjg(int i4, int[] iArr, Object[] objArr, boolean z3) {
        this.zze = -1;
        this.zzb = i4;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z3;
    }

    public static zzjg zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjg zze(zzjg zzjgVar, zzjg zzjgVar2) {
        int i4 = zzjgVar.zzb + zzjgVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzjgVar.zzc, i4);
        System.arraycopy(zzjgVar2.zzc, 0, copyOf, zzjgVar.zzb, zzjgVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzjgVar.zzd, i4);
        System.arraycopy(zzjgVar2.zzd, 0, copyOf2, zzjgVar.zzb, zzjgVar2.zzb);
        return new zzjg(i4, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjg zzf() {
        return new zzjg(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i4) {
        int[] iArr = this.zzc;
        if (i4 > iArr.length) {
            int i5 = this.zzb;
            int i6 = i5 + (i5 / 2);
            if (i6 >= i4) {
                i4 = i6;
            }
            if (i4 < 8) {
                i4 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i4);
            this.zzd = Arrays.copyOf(this.zzd, i4);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzjg)) {
            return false;
        }
        zzjg zzjgVar = (zzjg) obj;
        int i4 = this.zzb;
        if (i4 == zzjgVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzjgVar.zzc;
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    if (iArr[i5] != iArr2[i5]) {
                        break;
                    }
                    i5++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzjgVar.zzd;
                    int i6 = this.zzb;
                    for (int i7 = 0; i7 < i6; i7++) {
                        if (objArr[i7].equals(objArr2[i7])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.zzb;
        int i5 = i4 + 527;
        int[] iArr = this.zzc;
        int i6 = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i4; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i5 * 31) + i7;
        Object[] objArr = this.zzd;
        int i10 = this.zzb;
        for (int i11 = 0; i11 < i10; i11++) {
            i6 = (i6 * 31) + objArr[i11].hashCode();
        }
        return (i9 * 31) + i6;
    }

    public final int zza() {
        int zzz;
        int zzy;
        int i4;
        int i5 = this.zze;
        if (i5 == -1) {
            int i6 = 0;
            for (int i7 = 0; i7 < this.zzb; i7++) {
                int i8 = this.zzc[i7];
                int i9 = i8 >>> 3;
                int i10 = i8 & 7;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 == 5) {
                                    ((Integer) this.zzd[i7]).intValue();
                                    i4 = zzfk.zzy(i9 << 3) + 4;
                                } else {
                                    throw new IllegalStateException(zzgy.zza());
                                }
                            } else {
                                int i11 = i9 << 3;
                                int i12 = zzfk.zzb;
                                zzz = ((zzjg) this.zzd[i7]).zza();
                                int zzy2 = zzfk.zzy(i11);
                                zzy = zzy2 + zzy2;
                            }
                        } else {
                            int i13 = zzfk.zzb;
                            int zzd = ((zzez) this.zzd[i7]).zzd();
                            i4 = zzfk.zzy(i9 << 3) + zzfk.zzy(zzd) + zzd;
                        }
                    } else {
                        ((Long) this.zzd[i7]).longValue();
                        i4 = zzfk.zzy(i9 << 3) + 8;
                    }
                    i6 += i4;
                } else {
                    int i14 = i9 << 3;
                    zzz = zzfk.zzz(((Long) this.zzd[i7]).longValue());
                    zzy = zzfk.zzy(i14);
                }
                i4 = zzy + zzz;
                i6 += i4;
            }
            this.zze = i6;
            return i6;
        }
        return i5;
    }

    public final int zzb() {
        int i4 = this.zze;
        if (i4 == -1) {
            int i5 = 0;
            for (int i6 = 0; i6 < this.zzb; i6++) {
                int i7 = zzfk.zzb;
                int zzd = ((zzez) this.zzd[i6]).zzd();
                int zzy = zzfk.zzy(zzd) + zzd;
                int zzy2 = zzfk.zzy(16);
                int zzy3 = zzfk.zzy(this.zzc[i6] >>> 3);
                int zzy4 = zzfk.zzy(8);
                i5 += zzy4 + zzy4 + zzy2 + zzy3 + zzfk.zzy(24) + zzy;
            }
            this.zze = i5;
            return i5;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjg zzd(zzjg zzjgVar) {
        if (zzjgVar.equals(zza)) {
            return this;
        }
        zzg();
        int i4 = this.zzb + zzjgVar.zzb;
        zzm(i4);
        System.arraycopy(zzjgVar.zzc, 0, this.zzc, this.zzb, zzjgVar.zzb);
        System.arraycopy(zzjgVar.zzd, 0, this.zzd, this.zzb, zzjgVar.zzb);
        this.zzb = i4;
        return this;
    }

    final void zzg() {
        if (this.zzf) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.zzb; i5++) {
            zzia.zzb(sb, i4, String.valueOf(this.zzc[i5] >>> 3), this.zzd[i5]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i4, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i5 = this.zzb;
        iArr[i5] = i4;
        this.zzd[i5] = obj;
        this.zzb = i5 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(zzjx zzjxVar) throws IOException {
        for (int i4 = 0; i4 < this.zzb; i4++) {
            zzjxVar.zzw(this.zzc[i4] >>> 3, this.zzd[i4]);
        }
    }

    public final void zzl(zzjx zzjxVar) throws IOException {
        if (this.zzb != 0) {
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4];
                Object obj = this.zzd[i4];
                int i6 = i5 & 7;
                int i7 = i5 >>> 3;
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                if (i6 == 5) {
                                    zzjxVar.zzk(i7, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(zzgy.zza());
                                }
                            } else {
                                zzjxVar.zzF(i7);
                                ((zzjg) obj).zzl(zzjxVar);
                                zzjxVar.zzh(i7);
                            }
                        } else {
                            zzjxVar.zzd(i7, (zzez) obj);
                        }
                    } else {
                        zzjxVar.zzm(i7, ((Long) obj).longValue());
                    }
                } else {
                    zzjxVar.zzt(i7, ((Long) obj).longValue());
                }
            }
        }
    }

    private zzjg() {
        this(0, new int[8], new Object[8], true);
    }
}
