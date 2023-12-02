package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzax  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzax extends zzap {
    static final zzap zza = new zzax(null, new Object[0], 0);
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzax(@CheckForNull Object obj, Object[] objArr, int i4) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v4, types: [int[]] */
    public static zzax zzg(int i4, Object[] objArr, zzao zzaoVar) {
        int i5;
        short[] sArr;
        Object[] objArr2;
        byte[] bArr;
        int i6 = i4;
        Object[] objArr3 = objArr;
        if (i6 == 0) {
            return (zzax) zza;
        }
        Object obj = null;
        if (i6 == 1) {
            Object obj2 = objArr3[0];
            obj2.getClass();
            Object obj3 = objArr3[1];
            obj3.getClass();
            zzae.zza(obj2, obj3);
            return new zzax(null, objArr3, 1);
        }
        zzu.zzb(i6, objArr3.length >> 1, FirebaseAnalytics.Param.INDEX);
        char c4 = 2;
        int max = Math.max(i6, 2);
        if (max < 751619276) {
            i5 = Integer.highestOneBit(max - 1);
            do {
                i5 += i5;
            } while (i5 * 0.7d < max);
        } else {
            i5 = 1073741824;
            if (max >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i6 == 1) {
            Object obj4 = objArr3[0];
            obj4.getClass();
            Object obj5 = objArr3[1];
            obj5.getClass();
            zzae.zza(obj4, obj5);
        } else {
            int i7 = i5 - 1;
            char c5 = 65535;
            if (i5 <= 128) {
                byte[] bArr2 = new byte[i5];
                Arrays.fill(bArr2, (byte) -1);
                int i8 = 0;
                for (int i9 = 0; i9 < i6; i9++) {
                    int i10 = i8 + i8;
                    int i11 = i9 + i9;
                    Object obj6 = objArr3[i11];
                    obj6.getClass();
                    Object obj7 = objArr3[i11 ^ 1];
                    obj7.getClass();
                    zzae.zza(obj6, obj7);
                    int zza2 = zzaf.zza(obj6.hashCode());
                    while (true) {
                        int i12 = zza2 & i7;
                        int i13 = bArr2[i12] & 255;
                        if (i13 == 255) {
                            bArr2[i12] = (byte) i10;
                            if (i8 < i9) {
                                objArr3[i10] = obj6;
                                objArr3[i10 ^ 1] = obj7;
                            }
                            i8++;
                        } else if (obj6.equals(objArr3[i13])) {
                            int i14 = i13 ^ 1;
                            Object obj8 = objArr3[i14];
                            obj8.getClass();
                            zzan zzanVar = new zzan(obj6, obj7, obj8);
                            objArr3[i14] = obj7;
                            obj = zzanVar;
                            break;
                        } else {
                            zza2 = i12 + 1;
                        }
                    }
                }
                if (i8 == i6) {
                    bArr = bArr2;
                    c4 = 2;
                    obj = bArr;
                } else {
                    sArr = new Object[]{bArr2, Integer.valueOf(i8), obj};
                }
            } else if (i5 <= 32768) {
                sArr = new short[i5];
                Arrays.fill(sArr, (short) -1);
                int i15 = 0;
                for (int i16 = 0; i16 < i6; i16++) {
                    int i17 = i15 + i15;
                    int i18 = i16 + i16;
                    Object obj9 = objArr3[i18];
                    obj9.getClass();
                    Object obj10 = objArr3[i18 ^ 1];
                    obj10.getClass();
                    zzae.zza(obj9, obj10);
                    int zza3 = zzaf.zza(obj9.hashCode());
                    while (true) {
                        int i19 = zza3 & i7;
                        char c6 = (char) sArr[i19];
                        if (c6 == 65535) {
                            sArr[i19] = (short) i17;
                            if (i15 < i16) {
                                objArr3[i17] = obj9;
                                objArr3[i17 ^ 1] = obj10;
                            }
                            i15++;
                        } else if (obj9.equals(objArr3[c6])) {
                            int i20 = c6 ^ 1;
                            Object obj11 = objArr3[i20];
                            obj11.getClass();
                            zzan zzanVar2 = new zzan(obj9, obj10, obj11);
                            objArr3[i20] = obj10;
                            obj = zzanVar2;
                            break;
                        } else {
                            zza3 = i19 + 1;
                        }
                    }
                }
                if (i15 != i6) {
                    c4 = 2;
                    objArr2 = new Object[]{sArr, Integer.valueOf(i15), obj};
                    obj = objArr2;
                }
            } else {
                sArr = new int[i5];
                Arrays.fill((int[]) sArr, -1);
                int i21 = 0;
                int i22 = 0;
                while (i21 < i6) {
                    int i23 = i22 + i22;
                    int i24 = i21 + i21;
                    Object obj12 = objArr3[i24];
                    obj12.getClass();
                    Object obj13 = objArr3[i24 ^ 1];
                    obj13.getClass();
                    zzae.zza(obj12, obj13);
                    int zza4 = zzaf.zza(obj12.hashCode());
                    while (true) {
                        int i25 = zza4 & i7;
                        ?? r15 = sArr[i25];
                        if (r15 == c5) {
                            sArr[i25] = i23;
                            if (i22 < i21) {
                                objArr3[i23] = obj12;
                                objArr3[i23 ^ 1] = obj13;
                            }
                            i22++;
                        } else if (obj12.equals(objArr3[r15])) {
                            int i26 = r15 ^ 1;
                            Object obj14 = objArr3[i26];
                            obj14.getClass();
                            zzan zzanVar3 = new zzan(obj12, obj13, obj14);
                            objArr3[i26] = obj13;
                            obj = zzanVar3;
                            break;
                        } else {
                            zza4 = i25 + 1;
                            c5 = 65535;
                        }
                    }
                    i21++;
                    c5 = 65535;
                }
                if (i22 != i6) {
                    c4 = 2;
                    objArr2 = new Object[]{sArr, Integer.valueOf(i22), obj};
                    obj = objArr2;
                }
            }
            bArr = sArr;
            c4 = 2;
            obj = bArr;
        }
        boolean z3 = obj instanceof Object[];
        Object obj15 = obj;
        if (z3) {
            Object[] objArr4 = (Object[]) obj;
            zzaoVar.zzc = (zzan) objArr4[c4];
            Object obj16 = objArr4[0];
            int intValue = ((Integer) objArr4[1]).intValue();
            objArr3 = Arrays.copyOf(objArr3, intValue + intValue);
            obj15 = obj16;
            i6 = intValue;
        }
        return new zzax(obj15, objArr3, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f A[RETURN] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzap, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto Lc
        L9:
            r10 = r3
            goto L9c
        Lc:
            r4 = 1
            if (r2 != r4) goto L22
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L9
            r10 = r1[r4]
            r10.getClass()
            goto L9c
        L22:
            if (r0 != 0) goto L25
            goto L9
        L25:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L51
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + (-1)
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r0)
        L38:
            r0 = r0 & r6
            r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L9
        L41:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L4e:
            int r0 = r0 + 1
            goto L38
        L51:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L7d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + (-1)
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r0)
        L63:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L9
        L6d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L7a:
            int r0 = r0 + 1
            goto L63
        L7d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r6)
        L89:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L90
            goto L9
        L90:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r3
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzax.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzap
    final zzai zza() {
        return new zzaw(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzap
    final zzaq zzd() {
        return new zzau(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzap
    final zzaq zze() {
        return new zzav(this, new zzaw(this.zzb, 0, this.zzd));
    }
}
