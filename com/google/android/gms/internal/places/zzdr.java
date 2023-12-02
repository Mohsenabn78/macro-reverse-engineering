package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzdr {
    private static final zzdr zzmh = new zzdr(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzdy;
    private int zzii;
    private Object[] zzkt;
    private int[] zzmi;

    private zzdr() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdr zzb(zzdr zzdrVar, zzdr zzdrVar2) {
        int i4 = zzdrVar.count + zzdrVar2.count;
        int[] copyOf = Arrays.copyOf(zzdrVar.zzmi, i4);
        System.arraycopy(zzdrVar2.zzmi, 0, copyOf, zzdrVar.count, zzdrVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzdrVar.zzkt, i4);
        System.arraycopy(zzdrVar2.zzkt, 0, copyOf2, zzdrVar.count, zzdrVar2.count);
        return new zzdr(i4, copyOf, copyOf2, true);
    }

    public static zzdr zzdh() {
        return zzmh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdr zzdi() {
        return new zzdr();
    }

    public final boolean equals(Object obj) {
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzdr)) {
            return false;
        }
        zzdr zzdrVar = (zzdr) obj;
        int i4 = this.count;
        if (i4 == zzdrVar.count) {
            int[] iArr = this.zzmi;
            int[] iArr2 = zzdrVar.zzmi;
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    if (iArr[i5] != iArr2[i5]) {
                        z3 = false;
                        break;
                    }
                    i5++;
                } else {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                Object[] objArr = this.zzkt;
                Object[] objArr2 = zzdrVar.zzkt;
                int i6 = this.count;
                int i7 = 0;
                while (true) {
                    if (i7 < i6) {
                        if (!objArr[i7].equals(objArr2[i7])) {
                            z4 = false;
                            break;
                        }
                        i7++;
                    } else {
                        z4 = true;
                        break;
                    }
                }
                if (z4) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.count;
        int i5 = (i4 + 527) * 31;
        int[] iArr = this.zzmi;
        int i6 = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i4; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i5 + i7) * 31;
        Object[] objArr = this.zzkt;
        int i10 = this.count;
        for (int i11 = 0; i11 < i10; i11++) {
            i6 = (i6 * 31) + objArr[i11].hashCode();
        }
        return i9 + i6;
    }

    public final void zzab() {
        this.zzdy = false;
    }

    public final int zzbh() {
        int zzf;
        int i4 = this.zzii;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.count; i6++) {
            int i7 = this.zzmi[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            if (i9 == 5) {
                                zzf = zzaj.zzk(i8, ((Integer) this.zzkt[i6]).intValue());
                            } else {
                                throw new IllegalStateException(zzbk.zzbs());
                            }
                        } else {
                            zzf = (zzaj.zzr(i8) << 1) + ((zzdr) this.zzkt[i6]).zzbh();
                        }
                    } else {
                        zzf = zzaj.zzd(i8, (zzw) this.zzkt[i6]);
                    }
                } else {
                    zzf = zzaj.zzh(i8, ((Long) this.zzkt[i6]).longValue());
                }
            } else {
                zzf = zzaj.zzf(i8, ((Long) this.zzkt[i6]).longValue());
            }
            i5 += zzf;
        }
        this.zzii = i5;
        return i5;
    }

    public final void zzc(zzel zzelVar) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (zzelVar.zzam() == zzbc.zze.zziw) {
            for (int i4 = 0; i4 < this.count; i4++) {
                zzc(this.zzmi[i4], this.zzkt[i4], zzelVar);
            }
            return;
        }
        for (int i5 = this.count - 1; i5 >= 0; i5--) {
            zzc(this.zzmi[i5], this.zzkt[i5], zzelVar);
        }
    }

    public final int zzdj() {
        int i4 = this.zzii;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.count; i6++) {
            i5 += zzaj.zze(this.zzmi[i6] >>> 3, (zzw) this.zzkt[i6]);
        }
        this.zzii = i5;
        return i5;
    }

    private zzdr(int i4, int[] iArr, Object[] objArr, boolean z3) {
        this.zzii = -1;
        this.count = i4;
        this.zzmi = iArr;
        this.zzkt = objArr;
        this.zzdy = z3;
    }

    private static void zzc(int i4, Object obj, zzel zzelVar) throws IOException {
        int i5 = i4 >>> 3;
        int i6 = i4 & 7;
        if (i6 == 0) {
            zzelVar.zzj(i5, ((Long) obj).longValue());
        } else if (i6 == 1) {
            zzelVar.zzd(i5, ((Long) obj).longValue());
        } else if (i6 == 2) {
            zzelVar.zzb(i5, (zzw) obj);
        } else if (i6 != 3) {
            if (i6 == 5) {
                zzelVar.zzg(i5, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzbk.zzbs());
        } else if (zzelVar.zzam() == zzbc.zze.zziw) {
            zzelVar.zzaa(i5);
            ((zzdr) obj).zzc(zzelVar);
            zzelVar.zzab(i5);
        } else {
            zzelVar.zzab(i5);
            ((zzdr) obj).zzc(zzelVar);
            zzelVar.zzaa(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzel zzelVar) throws IOException {
        if (zzelVar.zzam() == zzbc.zze.zzix) {
            for (int i4 = this.count - 1; i4 >= 0; i4--) {
                zzelVar.zzb(this.zzmi[i4] >>> 3, this.zzkt[i4]);
            }
            return;
        }
        for (int i5 = 0; i5 < this.count; i5++) {
            zzelVar.zzb(this.zzmi[i5] >>> 3, this.zzkt[i5]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.count; i5++) {
            zzcl.zzb(sb, i4, String.valueOf(this.zzmi[i5] >>> 3), this.zzkt[i5]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(int i4, Object obj) {
        if (this.zzdy) {
            int i5 = this.count;
            int[] iArr = this.zzmi;
            if (i5 == iArr.length) {
                int i6 = i5 + (i5 < 4 ? 8 : i5 >> 1);
                this.zzmi = Arrays.copyOf(iArr, i6);
                this.zzkt = Arrays.copyOf(this.zzkt, i6);
            }
            int[] iArr2 = this.zzmi;
            int i7 = this.count;
            iArr2[i7] = i4;
            this.zzkt[i7] = obj;
            this.count = i7 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
