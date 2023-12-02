package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public final class zznl {
    private static final zznl zza = new zznl(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zznl(int i4, int[] iArr, Object[] objArr, boolean z3) {
        this.zze = -1;
        this.zzb = i4;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z3;
    }

    public static zznl zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zznl zze(zznl zznlVar, zznl zznlVar2) {
        int i4 = zznlVar.zzb + zznlVar2.zzb;
        int[] copyOf = Arrays.copyOf(zznlVar.zzc, i4);
        System.arraycopy(zznlVar2.zzc, 0, copyOf, zznlVar.zzb, zznlVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zznlVar.zzd, i4);
        System.arraycopy(zznlVar2.zzd, 0, copyOf2, zznlVar.zzb, zznlVar2.zzb);
        return new zznl(i4, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zznl zzf() {
        return new zznl(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i4) {
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
        if (obj == null || !(obj instanceof zznl)) {
            return false;
        }
        zznl zznlVar = (zznl) obj;
        int i4 = this.zzb;
        if (i4 == zznlVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zznlVar.zzc;
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    if (iArr[i5] != iArr2[i5]) {
                        break;
                    }
                    i5++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zznlVar.zzd;
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
        int zzy;
        int zzx;
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
                                    i4 = zzki.zzx(i9 << 3) + 4;
                                } else {
                                    throw new IllegalStateException(zzll.zza());
                                }
                            } else {
                                int i11 = i9 << 3;
                                int i12 = zzki.zzb;
                                zzy = ((zznl) this.zzd[i7]).zza();
                                int zzx2 = zzki.zzx(i11);
                                zzx = zzx2 + zzx2;
                            }
                        } else {
                            int i13 = zzki.zzb;
                            int zzd = ((zzka) this.zzd[i7]).zzd();
                            i4 = zzki.zzx(i9 << 3) + zzki.zzx(zzd) + zzd;
                        }
                    } else {
                        ((Long) this.zzd[i7]).longValue();
                        i4 = zzki.zzx(i9 << 3) + 8;
                    }
                    i6 += i4;
                } else {
                    int i14 = i9 << 3;
                    zzy = zzki.zzy(((Long) this.zzd[i7]).longValue());
                    zzx = zzki.zzx(i14);
                }
                i4 = zzx + zzy;
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
                int i7 = zzki.zzb;
                int zzd = ((zzka) this.zzd[i6]).zzd();
                int zzx = zzki.zzx(zzd) + zzd;
                int zzx2 = zzki.zzx(16);
                int zzx3 = zzki.zzx(this.zzc[i6] >>> 3);
                int zzx4 = zzki.zzx(8);
                i5 += zzx4 + zzx4 + zzx2 + zzx3 + zzki.zzx(24) + zzx;
            }
            this.zze = i5;
            return i5;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zznl zzd(zznl zznlVar) {
        if (zznlVar.equals(zza)) {
            return this;
        }
        zzg();
        int i4 = this.zzb + zznlVar.zzb;
        zzl(i4);
        System.arraycopy(zznlVar.zzc, 0, this.zzc, this.zzb, zznlVar.zzb);
        System.arraycopy(zznlVar.zzd, 0, this.zzd, this.zzb, zznlVar.zzb);
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
            zzmk.zzb(sb, i4, String.valueOf(this.zzc[i5] >>> 3), this.zzd[i5]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i4, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i5 = this.zzb;
        iArr[i5] = i4;
        this.zzd[i5] = obj;
        this.zzb = i5 + 1;
    }

    public final void zzk(zzoc zzocVar) throws IOException {
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
                                    zzocVar.zzk(i7, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(zzll.zza());
                                }
                            } else {
                                zzocVar.zzE(i7);
                                ((zznl) obj).zzk(zzocVar);
                                zzocVar.zzh(i7);
                            }
                        } else {
                            zzocVar.zzd(i7, (zzka) obj);
                        }
                    } else {
                        zzocVar.zzm(i7, ((Long) obj).longValue());
                    }
                } else {
                    zzocVar.zzt(i7, ((Long) obj).longValue());
                }
            }
        }
    }

    private zznl() {
        this(0, new int[8], new Object[8], true);
    }
}
