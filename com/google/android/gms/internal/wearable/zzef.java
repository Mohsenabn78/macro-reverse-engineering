package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzef {
    private static final zzef zza = new zzef(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzef(int i4, int[] iArr, Object[] objArr, boolean z3) {
        this.zze = -1;
        this.zzb = i4;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z3;
    }

    public static zzef zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzef zzd(zzef zzefVar, zzef zzefVar2) {
        int i4 = zzefVar.zzb + zzefVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzefVar.zzc, i4);
        System.arraycopy(zzefVar2.zzc, 0, copyOf, zzefVar.zzb, zzefVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzefVar.zzd, i4);
        System.arraycopy(zzefVar2.zzd, 0, copyOf2, zzefVar.zzb, zzefVar2.zzb);
        return new zzef(i4, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzef zze() {
        return new zzef(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzef)) {
            return false;
        }
        zzef zzefVar = (zzef) obj;
        int i4 = this.zzb;
        if (i4 == zzefVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzefVar.zzc;
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    if (iArr[i5] != iArr2[i5]) {
                        break;
                    }
                    i5++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzefVar.zzd;
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
        int i5 = (i4 + 527) * 31;
        int[] iArr = this.zzc;
        int i6 = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i4; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i5 + i7) * 31;
        Object[] objArr = this.zzd;
        int i10 = this.zzb;
        for (int i11 = 0; i11 < i10; i11++) {
            i6 = (i6 * 31) + objArr[i11].hashCode();
        }
        return i9 + i6;
    }

    public final int zza() {
        int zzA;
        int zzB;
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
                                    i4 = zzbe.zzA(i9 << 3) + 4;
                                } else {
                                    throw new IllegalStateException(zzcf.zza());
                                }
                            } else {
                                int zzz = zzbe.zzz(i9);
                                zzA = zzz + zzz;
                                zzB = ((zzef) this.zzd[i7]).zza();
                            }
                        } else {
                            int zzA2 = zzbe.zzA(i9 << 3);
                            int zzd = ((zzaw) this.zzd[i7]).zzd();
                            i6 += zzA2 + zzbe.zzA(zzd) + zzd;
                        }
                    } else {
                        ((Long) this.zzd[i7]).longValue();
                        i4 = zzbe.zzA(i9 << 3) + 8;
                    }
                    i6 += i4;
                } else {
                    long longValue = ((Long) this.zzd[i7]).longValue();
                    zzA = zzbe.zzA(i9 << 3);
                    zzB = zzbe.zzB(longValue);
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
                int i7 = this.zzc[i6];
                int zzA = zzbe.zzA(8);
                int zzd = ((zzaw) this.zzd[i6]).zzd();
                i5 += zzA + zzA + zzbe.zzA(16) + zzbe.zzA(i7 >>> 3) + zzbe.zzA(24) + zzbe.zzA(zzd) + zzd;
            }
            this.zze = i5;
            return i5;
        }
        return i4;
    }

    public final void zzf() {
        this.zzf = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.zzb; i5++) {
            zzde.zzb(sb, i4, String.valueOf(this.zzc[i5] >>> 3), this.zzd[i5]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(int i4, Object obj) {
        int i5;
        if (this.zzf) {
            int i6 = this.zzb;
            int[] iArr = this.zzc;
            if (i6 == iArr.length) {
                if (i6 < 4) {
                    i5 = 8;
                } else {
                    i5 = i6 >> 1;
                }
                int i7 = i6 + i5;
                this.zzc = Arrays.copyOf(iArr, i7);
                this.zzd = Arrays.copyOf(this.zzd, i7);
            }
            int[] iArr2 = this.zzc;
            int i8 = this.zzb;
            iArr2[i8] = i4;
            this.zzd[i8] = obj;
            this.zzb = i8 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zzew zzewVar) throws IOException {
        if (this.zzb != 0) {
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4];
                Object obj = this.zzd[i4];
                int i6 = i5 >>> 3;
                int i7 = i5 & 7;
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 != 2) {
                            if (i7 != 3) {
                                if (i7 == 5) {
                                    zzewVar.zzk(i6, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(zzcf.zza());
                                }
                            } else {
                                zzewVar.zzE(i6);
                                ((zzef) obj).zzi(zzewVar);
                                zzewVar.zzh(i6);
                            }
                        } else {
                            zzewVar.zzd(i6, (zzaw) obj);
                        }
                    } else {
                        zzewVar.zzm(i6, ((Long) obj).longValue());
                    }
                } else {
                    zzewVar.zzt(i6, ((Long) obj).longValue());
                }
            }
        }
    }

    private zzef() {
        this(0, new int[8], new Object[8], true);
    }
}
