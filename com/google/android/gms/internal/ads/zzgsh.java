package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgsh {
    private static final zzgsh zza = new zzgsh(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzgsh(int i4, int[] iArr, Object[] objArr, boolean z3) {
        this.zze = -1;
        this.zzb = i4;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z3;
    }

    public static zzgsh zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgsh zze(zzgsh zzgshVar, zzgsh zzgshVar2) {
        int i4 = zzgshVar.zzb + zzgshVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzgshVar.zzc, i4);
        System.arraycopy(zzgshVar2.zzc, 0, copyOf, zzgshVar.zzb, zzgshVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgshVar.zzd, i4);
        System.arraycopy(zzgshVar2.zzd, 0, copyOf2, zzgshVar.zzb, zzgshVar2.zzb);
        return new zzgsh(i4, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgsh zzf() {
        return new zzgsh(0, new int[8], new Object[8], true);
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
        if (obj == null || !(obj instanceof zzgsh)) {
            return false;
        }
        zzgsh zzgshVar = (zzgsh) obj;
        int i4 = this.zzb;
        if (i4 == zzgshVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgshVar.zzc;
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    if (iArr[i5] != iArr2[i5]) {
                        break;
                    }
                    i5++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgshVar.zzd;
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
        int zzB;
        int zzA;
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
                                    i4 = zzgot.zzA(i9 << 3) + 4;
                                } else {
                                    throw new IllegalStateException(zzgpy.zza());
                                }
                            } else {
                                int i11 = i9 << 3;
                                int i12 = zzgot.zzf;
                                zzB = ((zzgsh) this.zzd[i7]).zza();
                                int zzA2 = zzgot.zzA(i11);
                                zzA = zzA2 + zzA2;
                            }
                        } else {
                            int i13 = zzgot.zzf;
                            int zzd = ((zzgoe) this.zzd[i7]).zzd();
                            i4 = zzgot.zzA(i9 << 3) + zzgot.zzA(zzd) + zzd;
                        }
                    } else {
                        ((Long) this.zzd[i7]).longValue();
                        i4 = zzgot.zzA(i9 << 3) + 8;
                    }
                    i6 += i4;
                } else {
                    int i14 = i9 << 3;
                    zzB = zzgot.zzB(((Long) this.zzd[i7]).longValue());
                    zzA = zzgot.zzA(i14);
                }
                i4 = zzA + zzB;
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
                int i7 = zzgot.zzf;
                int zzd = ((zzgoe) this.zzd[i6]).zzd();
                int zzA = zzgot.zzA(zzd) + zzd;
                int zzA2 = zzgot.zzA(16);
                int zzA3 = zzgot.zzA(this.zzc[i6] >>> 3);
                int zzA4 = zzgot.zzA(8);
                i5 += zzA4 + zzA4 + zzA2 + zzA3 + zzgot.zzA(24) + zzA;
            }
            this.zze = i5;
            return i5;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgsh zzd(zzgsh zzgshVar) {
        if (zzgshVar.equals(zza)) {
            return this;
        }
        zzg();
        int i4 = this.zzb + zzgshVar.zzb;
        zzl(i4);
        System.arraycopy(zzgshVar.zzc, 0, this.zzc, this.zzb, zzgshVar.zzb);
        System.arraycopy(zzgshVar.zzd, 0, this.zzd, this.zzb, zzgshVar.zzb);
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
            zzgqy.zzb(sb, i4, String.valueOf(this.zzc[i5] >>> 3), this.zzd[i5]);
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

    public final void zzk(zzgou zzgouVar) throws IOException {
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
                                    zzgouVar.zzk(i7, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(zzgpy.zza());
                                }
                            } else {
                                zzgouVar.zzE(i7);
                                ((zzgsh) obj).zzk(zzgouVar);
                                zzgouVar.zzh(i7);
                            }
                        } else {
                            zzgouVar.zzd(i7, (zzgoe) obj);
                        }
                    } else {
                        zzgouVar.zzm(i7, ((Long) obj).longValue());
                    }
                } else {
                    zzgouVar.zzt(i7, ((Long) obj).longValue());
                }
            }
        }
    }

    private zzgsh() {
        this(0, new int[8], new Object[8], true);
    }
}
