package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzxd extends zzxg {
    @Nullable
    private zzxc zza;

    protected abstract Pair zzb(zzxc zzxcVar, int[][][] iArr, int[] iArr2, zzto zztoVar, zzcw zzcwVar) throws zzih;

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxh zzo(zzlk[] zzlkVarArr, zzvn zzvnVar, zzto zztoVar, zzcw zzcwVar) throws zzih {
        boolean z3;
        boolean z4;
        zzfsc zzl;
        int[] iArr;
        boolean z5;
        int[] iArr2 = new int[3];
        zzcy[][] zzcyVarArr = new zzcy[3];
        int[][][] iArr3 = new int[3][];
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = zzvnVar.zzc;
            zzcyVarArr[i4] = new zzcy[i5];
            iArr3[i4] = new int[i5];
        }
        int i6 = 2;
        int[] iArr4 = new int[2];
        for (int i7 = 0; i7 < 2; i7++) {
            iArr4[i7] = zzlkVarArr[i7].zze();
        }
        int i8 = 0;
        while (i8 < zzvnVar.zzc) {
            zzcy zzb = zzvnVar.zzb(i8);
            int i9 = zzb.zzd;
            int i10 = 0;
            int i11 = 2;
            int i12 = 0;
            boolean z6 = true;
            while (i10 < i6) {
                zzlk zzlkVar = zzlkVarArr[i10];
                int i13 = 0;
                for (int i14 = 0; i14 <= 0; i14++) {
                    i13 = Math.max(i13, zzlkVar.zzR(zzb.zzb(i14)) & 7);
                }
                if (iArr2[i10] == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (i13 <= i12) {
                    if (i13 == i12 && i9 == 5 && !z6 && z5) {
                        i11 = i10;
                        i12 = i13;
                        z6 = true;
                    }
                } else {
                    z6 = z5;
                    i11 = i10;
                    i12 = i13;
                }
                i10++;
                i6 = 2;
            }
            if (i11 == i6) {
                iArr = new int[1];
            } else {
                zzlk zzlkVar2 = zzlkVarArr[i11];
                int[] iArr5 = new int[1];
                for (int i15 = 0; i15 <= 0; i15++) {
                    iArr5[i15] = zzlkVar2.zzR(zzb.zzb(i15));
                }
                iArr = iArr5;
            }
            int i16 = iArr2[i11];
            zzcyVarArr[i11][i16] = zzb;
            iArr3[i11][i16] = iArr;
            iArr2[i11] = i16 + 1;
            i8++;
            i6 = 2;
        }
        zzvn[] zzvnVarArr = new zzvn[i6];
        String[] strArr = new String[i6];
        int[] iArr6 = new int[i6];
        int i17 = 0;
        while (i17 < i6) {
            int i18 = iArr2[i17];
            zzvnVarArr[i17] = new zzvn((zzcy[]) zzfj.zzG(zzcyVarArr[i17], i18));
            iArr3[i17] = (int[][]) zzfj.zzG(iArr3[i17], i18);
            strArr[i17] = zzlkVarArr[i17].zzN();
            iArr6[i17] = zzlkVarArr[i17].zzb();
            i17++;
            i6 = 2;
        }
        zzxc zzxcVar = new zzxc(strArr, iArr6, zzvnVarArr, iArr4, iArr3, new zzvn((zzcy[]) zzfj.zzG(zzcyVarArr[2], iArr2[2])));
        Pair zzb2 = zzb(zzxcVar, iArr3, iArr4, zztoVar, zzcwVar);
        zzxe[] zzxeVarArr = (zzxe[]) zzb2.second;
        List[] listArr = new List[zzxeVarArr.length];
        for (int i19 = 0; i19 < zzxeVarArr.length; i19++) {
            zzxe zzxeVar = zzxeVarArr[i19];
            if (zzxeVar != null) {
                zzl = zzfsc.zzm(zzxeVar);
            } else {
                zzl = zzfsc.zzl();
            }
            listArr[i19] = zzl;
        }
        zzfrz zzfrzVar = new zzfrz();
        for (int i20 = 0; i20 < 2; i20++) {
            zzvn zzd = zzxcVar.zzd(i20);
            List list = listArr[i20];
            for (int i21 = 0; i21 < zzd.zzc; i21++) {
                zzcy zzb3 = zzd.zzb(i21);
                if (zzxcVar.zza(i20, i21, false) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                int i22 = zzb3.zzb;
                int[] iArr7 = new int[1];
                boolean[] zArr = new boolean[1];
                for (int i23 = 0; i23 <= 0; i23++) {
                    iArr7[i23] = zzxcVar.zzb(i20, i21, i23) & 7;
                    int i24 = 0;
                    while (true) {
                        if (i24 < list.size()) {
                            zzxe zzxeVar2 = (zzxe) list.get(i24);
                            if (zzxeVar2.zze().equals(zzb3) && zzxeVar2.zzb(i23) != -1) {
                                z4 = true;
                                break;
                            }
                            i24++;
                        } else {
                            z4 = false;
                            break;
                        }
                    }
                    zArr[i23] = z4;
                }
                zzfrzVar.zzf(new zzdg(zzb3, z3, iArr7, zArr));
            }
        }
        zzvn zze = zzxcVar.zze();
        for (int i25 = 0; i25 < zze.zzc; i25++) {
            zzcy zzb4 = zze.zzb(i25);
            int i26 = zzb4.zzb;
            int[] iArr8 = new int[1];
            Arrays.fill(iArr8, 0);
            zzfrzVar.zzf(new zzdg(zzb4, false, iArr8, new boolean[1]));
        }
        return new zzxh((zzll[]) zzb2.first, (zzxa[]) zzb2.second, new zzdh(zzfrzVar.zzi()), zzxcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzp(@Nullable Object obj) {
        this.zza = (zzxc) obj;
    }
}
