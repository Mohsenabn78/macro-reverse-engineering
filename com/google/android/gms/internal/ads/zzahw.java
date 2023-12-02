package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzahw extends zzahu {
    @Nullable
    private zzahv zza;
    private int zzb;
    private boolean zzc;
    @Nullable
    private zzace zzd;
    @Nullable
    private zzacc zze;

    @Override // com.google.android.gms.internal.ads.zzahu
    protected final long zza(zzfa zzfaVar) {
        int i4;
        int i5 = 0;
        if ((zzfaVar.zzH()[0] & 1) == 1) {
            return -1L;
        }
        byte b4 = zzfaVar.zzH()[0];
        zzahv zzahvVar = this.zza;
        zzdy.zzb(zzahvVar);
        if (!zzahvVar.zzd[(b4 >> 1) & (255 >>> (8 - zzahvVar.zze))].zza) {
            i4 = zzahvVar.zza.zze;
        } else {
            i4 = zzahvVar.zza.zzf;
        }
        if (this.zzc) {
            i5 = (this.zzb + i4) / 4;
        }
        if (zzfaVar.zzb() < zzfaVar.zzd() + 4) {
            byte[] copyOf = Arrays.copyOf(zzfaVar.zzH(), zzfaVar.zzd() + 4);
            zzfaVar.zzD(copyOf, copyOf.length);
        } else {
            zzfaVar.zzE(zzfaVar.zzd() + 4);
        }
        long j4 = i5;
        byte[] zzH = zzfaVar.zzH();
        zzH[zzfaVar.zzd() - 4] = (byte) (j4 & 255);
        zzH[zzfaVar.zzd() - 3] = (byte) ((j4 >>> 8) & 255);
        zzH[zzfaVar.zzd() - 2] = (byte) ((j4 >>> 16) & 255);
        zzH[zzfaVar.zzd() - 1] = (byte) ((j4 >>> 24) & 255);
        this.zzc = true;
        this.zzb = i4;
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zzb(boolean z3) {
        super.zzb(z3);
        if (z3) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfa zzfaVar, long j4, zzahr zzahrVar) throws IOException {
        zzahv zzahvVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        zzace zzaceVar;
        long j5;
        int i9;
        int i10;
        int i11;
        boolean z3;
        if (this.zza != null) {
            zzahrVar.zza.getClass();
            return false;
        }
        zzace zzaceVar2 = this.zzd;
        int i12 = 4;
        if (zzaceVar2 == null) {
            zzacf.zzd(1, zzfaVar, false);
            int zzh = zzfaVar.zzh();
            int zzk = zzfaVar.zzk();
            int zzh2 = zzfaVar.zzh();
            int zzg = zzfaVar.zzg();
            if (zzg <= 0) {
                i9 = -1;
            } else {
                i9 = zzg;
            }
            int zzg2 = zzfaVar.zzg();
            if (zzg2 <= 0) {
                i10 = -1;
            } else {
                i10 = zzg2;
            }
            int zzg3 = zzfaVar.zzg();
            if (zzg3 <= 0) {
                i11 = -1;
            } else {
                i11 = zzg3;
            }
            int zzk2 = zzfaVar.zzk();
            int pow = (int) Math.pow(2.0d, zzk2 & 15);
            int pow2 = (int) Math.pow(2.0d, (zzk2 & 240) >> 4);
            if (1 != (zzfaVar.zzk() & 1)) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.zzd = new zzace(zzh, zzk, zzh2, i9, i10, i11, pow, pow2, z3, Arrays.copyOf(zzfaVar.zzH(), zzfaVar.zzd()));
        } else {
            zzacc zzaccVar = this.zze;
            if (zzaccVar == null) {
                this.zze = zzacf.zzc(zzfaVar, true, true);
            } else {
                byte[] bArr = new byte[zzfaVar.zzd()];
                System.arraycopy(zzfaVar.zzH(), 0, bArr, 0, zzfaVar.zzd());
                int i13 = zzaceVar2.zza;
                int i14 = 5;
                zzacf.zzd(5, zzfaVar, false);
                int zzk3 = zzfaVar.zzk() + 1;
                zzacb zzacbVar = new zzacb(zzfaVar.zzH());
                zzacbVar.zzc(zzfaVar.zzc() * 8);
                int i15 = 0;
                while (true) {
                    int i16 = 2;
                    int i17 = 16;
                    if (i15 < zzk3) {
                        if (zzacbVar.zzb(24) == 5653314) {
                            int zzb = zzacbVar.zzb(16);
                            int zzb2 = zzacbVar.zzb(24);
                            if (!zzacbVar.zzd()) {
                                boolean zzd = zzacbVar.zzd();
                                for (int i18 = 0; i18 < zzb2; i18++) {
                                    if (zzd) {
                                        if (zzacbVar.zzd()) {
                                            zzacbVar.zzc(5);
                                        }
                                    } else {
                                        zzacbVar.zzc(5);
                                    }
                                }
                            } else {
                                zzacbVar.zzc(5);
                                for (int i19 = 0; i19 < zzb2; i19 += zzacbVar.zzb(zzacf.zza(zzb2 - i19))) {
                                }
                            }
                            int zzb3 = zzacbVar.zzb(i12);
                            if (zzb3 <= 2) {
                                if (zzb3 != 1) {
                                    if (zzb3 != 2) {
                                        zzaceVar = zzaceVar2;
                                        i15++;
                                        zzaceVar2 = zzaceVar;
                                        i12 = 4;
                                    }
                                } else {
                                    i16 = zzb3;
                                }
                                zzacbVar.zzc(32);
                                zzacbVar.zzc(32);
                                int zzb4 = zzacbVar.zzb(i12) + 1;
                                zzacbVar.zzc(1);
                                if (i16 == 1) {
                                    if (zzb != 0) {
                                        zzaceVar = zzaceVar2;
                                        j5 = (long) Math.floor(Math.pow(zzb2, 1.0d / zzb));
                                    } else {
                                        zzaceVar = zzaceVar2;
                                        j5 = 0;
                                    }
                                } else {
                                    zzaceVar = zzaceVar2;
                                    j5 = zzb2 * zzb;
                                }
                                zzacbVar.zzc((int) (j5 * zzb4));
                                i15++;
                                zzaceVar2 = zzaceVar;
                                i12 = 4;
                            } else {
                                throw zzcd.zza("lookup type greater than 2 not decodable: " + zzb3, null);
                            }
                        } else {
                            throw zzcd.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzacbVar.zza(), null);
                        }
                    } else {
                        zzace zzaceVar3 = zzaceVar2;
                        int i20 = 6;
                        int zzb5 = zzacbVar.zzb(6) + 1;
                        for (int i21 = 0; i21 < zzb5; i21++) {
                            if (zzacbVar.zzb(16) != 0) {
                                throw zzcd.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i22 = 1;
                        int zzb6 = zzacbVar.zzb(6) + 1;
                        int i23 = 0;
                        while (true) {
                            int i24 = 3;
                            if (i23 < zzb6) {
                                int zzb7 = zzacbVar.zzb(i17);
                                if (zzb7 != 0) {
                                    if (zzb7 == i22) {
                                        int zzb8 = zzacbVar.zzb(i14);
                                        int[] iArr = new int[zzb8];
                                        int i25 = -1;
                                        for (int i26 = 0; i26 < zzb8; i26++) {
                                            int zzb9 = zzacbVar.zzb(4);
                                            iArr[i26] = zzb9;
                                            if (zzb9 > i25) {
                                                i25 = zzb9;
                                            }
                                        }
                                        int i27 = i25 + 1;
                                        int[] iArr2 = new int[i27];
                                        int i28 = 0;
                                        while (i28 < i27) {
                                            iArr2[i28] = zzacbVar.zzb(i24) + 1;
                                            int zzb10 = zzacbVar.zzb(i16);
                                            if (zzb10 > 0) {
                                                i8 = 8;
                                                zzacbVar.zzc(8);
                                            } else {
                                                i8 = 8;
                                            }
                                            int i29 = zzb6;
                                            int i30 = 0;
                                            for (int i31 = 1; i30 < (i31 << zzb10); i31 = 1) {
                                                zzacbVar.zzc(i8);
                                                i30++;
                                                i8 = 8;
                                            }
                                            i28++;
                                            zzb6 = i29;
                                            i16 = 2;
                                            i24 = 3;
                                        }
                                        i7 = zzb6;
                                        zzacbVar.zzc(2);
                                        int zzb11 = zzacbVar.zzb(4);
                                        int i32 = 0;
                                        int i33 = 0;
                                        for (int i34 = 0; i34 < zzb8; i34++) {
                                            i32 += iArr2[iArr[i34]];
                                            while (i33 < i32) {
                                                zzacbVar.zzc(zzb11);
                                                i33++;
                                            }
                                        }
                                    } else {
                                        throw zzcd.zza("floor type greater than 1 not decodable: " + zzb7, null);
                                    }
                                } else {
                                    i7 = zzb6;
                                    int i35 = 8;
                                    zzacbVar.zzc(8);
                                    zzacbVar.zzc(16);
                                    zzacbVar.zzc(16);
                                    zzacbVar.zzc(6);
                                    zzacbVar.zzc(8);
                                    int zzb12 = zzacbVar.zzb(4) + 1;
                                    int i36 = 0;
                                    while (i36 < zzb12) {
                                        zzacbVar.zzc(i35);
                                        i36++;
                                        i35 = 8;
                                    }
                                }
                                i23++;
                                zzb6 = i7;
                                i20 = 6;
                                i17 = 16;
                                i16 = 2;
                                i22 = 1;
                                i14 = 5;
                            } else {
                                int i37 = 1;
                                int zzb13 = zzacbVar.zzb(i20) + 1;
                                int i38 = 0;
                                while (i38 < zzb13) {
                                    if (zzacbVar.zzb(16) <= 2) {
                                        zzacbVar.zzc(24);
                                        zzacbVar.zzc(24);
                                        zzacbVar.zzc(24);
                                        int zzb14 = zzacbVar.zzb(i20) + i37;
                                        int i39 = 8;
                                        zzacbVar.zzc(8);
                                        int[] iArr3 = new int[zzb14];
                                        for (int i40 = 0; i40 < zzb14; i40++) {
                                            int zzb15 = zzacbVar.zzb(3);
                                            if (zzacbVar.zzd()) {
                                                i6 = zzacbVar.zzb(5);
                                            } else {
                                                i6 = 0;
                                            }
                                            iArr3[i40] = (i6 * 8) + zzb15;
                                        }
                                        int i41 = 0;
                                        while (i41 < zzb14) {
                                            int i42 = 0;
                                            while (i42 < i39) {
                                                if ((iArr3[i41] & (1 << i42)) != 0) {
                                                    zzacbVar.zzc(i39);
                                                }
                                                i42++;
                                                i39 = 8;
                                            }
                                            i41++;
                                            i39 = 8;
                                        }
                                        i38++;
                                        i20 = 6;
                                        i37 = 1;
                                    } else {
                                        throw zzcd.zza("residueType greater than 2 is not decodable", null);
                                    }
                                }
                                int zzb16 = zzacbVar.zzb(i20) + 1;
                                for (int i43 = 0; i43 < zzb16; i43++) {
                                    int zzb17 = zzacbVar.zzb(16);
                                    if (zzb17 != 0) {
                                        zzer.zzc("VorbisUtil", "mapping type other than 0 not supported: " + zzb17);
                                    } else {
                                        if (zzacbVar.zzd()) {
                                            i4 = 1;
                                            i5 = zzacbVar.zzb(4) + 1;
                                        } else {
                                            i4 = 1;
                                            i5 = 1;
                                        }
                                        if (zzacbVar.zzd()) {
                                            int zzb18 = zzacbVar.zzb(8) + i4;
                                            for (int i44 = 0; i44 < zzb18; i44++) {
                                                int i45 = i13 - 1;
                                                zzacbVar.zzc(zzacf.zza(i45));
                                                zzacbVar.zzc(zzacf.zza(i45));
                                            }
                                        }
                                        if (zzacbVar.zzb(2) == 0) {
                                            if (i5 > 1) {
                                                for (int i46 = 0; i46 < i13; i46++) {
                                                    zzacbVar.zzc(4);
                                                }
                                            }
                                            for (int i47 = 0; i47 < i5; i47++) {
                                                zzacbVar.zzc(8);
                                                zzacbVar.zzc(8);
                                                zzacbVar.zzc(8);
                                            }
                                        } else {
                                            throw zzcd.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                    }
                                }
                                int zzb19 = zzacbVar.zzb(6) + 1;
                                zzacd[] zzacdVarArr = new zzacd[zzb19];
                                for (int i48 = 0; i48 < zzb19; i48++) {
                                    zzacdVarArr[i48] = new zzacd(zzacbVar.zzd(), zzacbVar.zzb(16), zzacbVar.zzb(16), zzacbVar.zzb(8));
                                }
                                if (zzacbVar.zzd()) {
                                    zzahvVar = new zzahv(zzaceVar3, zzaccVar, bArr, zzacdVarArr, zzacf.zza(zzb19 - 1));
                                } else {
                                    throw zzcd.zza("framing bit after modes not set as expected", null);
                                }
                            }
                        }
                    }
                }
            }
        }
        zzahvVar = null;
        this.zza = zzahvVar;
        if (zzahvVar == null) {
            return true;
        }
        zzace zzaceVar4 = zzahvVar.zza;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzaceVar4.zzg);
        arrayList.add(zzahvVar.zzc);
        zzbz zzb20 = zzacf.zzb(zzfsc.zzk(zzahvVar.zzb.zzb));
        zzak zzakVar = new zzak();
        zzakVar.zzS("audio/vorbis");
        zzakVar.zzv(zzaceVar4.zzd);
        zzakVar.zzO(zzaceVar4.zzc);
        zzakVar.zzw(zzaceVar4.zza);
        zzakVar.zzT(zzaceVar4.zzb);
        zzakVar.zzI(arrayList);
        zzakVar.zzM(zzb20);
        zzahrVar.zza = zzakVar.zzY();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zzi(long j4) {
        boolean z3;
        super.zzi(j4);
        int i4 = 0;
        if (j4 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzc = z3;
        zzace zzaceVar = this.zzd;
        if (zzaceVar != null) {
            i4 = zzaceVar.zze;
        }
        this.zzb = i4;
    }
}
