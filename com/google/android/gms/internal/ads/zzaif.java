package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaif implements zzaij {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzez zzc = new zzez(new byte[7], 7);
    private final zzfa zzd = new zzfa(Arrays.copyOf(zza, 10));
    @Nullable
    private final String zze;
    private String zzf;
    private zzabz zzg;
    private zzabz zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzabz zzu;
    private long zzv;

    public zzaif(boolean z3, @Nullable String str) {
        zzh();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = -9223372036854775807L;
        this.zzt = -9223372036854775807L;
        this.zzb = z3;
        this.zze = str;
    }

    public static boolean zzf(int i4) {
        if ((i4 & 65526) == 65520) {
            return true;
        }
        return false;
    }

    private final void zzg() {
        this.zzm = false;
        zzh();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzi() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private final void zzj(zzabz zzabzVar, long j4, int i4, int i5) {
        this.zzi = 4;
        this.zzj = i4;
        this.zzu = zzabzVar;
        this.zzv = j4;
        this.zzs = i5;
    }

    private final boolean zzk(zzfa zzfaVar, byte[] bArr, int i4) {
        int min = Math.min(zzfaVar.zza(), i4 - this.zzj);
        zzfaVar.zzB(bArr, this.zzj, min);
        int i5 = this.zzj + min;
        this.zzj = i5;
        if (i5 == i4) {
            return true;
        }
        return false;
    }

    private static final boolean zzl(byte b4, byte b5) {
        return zzf((b5 & 255) | 65280);
    }

    private static final boolean zzm(zzfa zzfaVar, byte[] bArr, int i4) {
        if (zzfaVar.zza() < i4) {
            return false;
        }
        zzfaVar.zzB(bArr, 0, i4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zza(zzfa zzfaVar) throws zzcd {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z3;
        this.zzg.getClass();
        int i8 = zzfj.zza;
        while (zzfaVar.zza() > 0) {
            int i9 = this.zzi;
            int i10 = 13;
            int i11 = 2;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            int min = Math.min(zzfaVar.zza(), this.zzs - this.zzj);
                            this.zzu.zzq(zzfaVar, min);
                            int i12 = this.zzj + min;
                            this.zzj = i12;
                            int i13 = this.zzs;
                            if (i12 == i13) {
                                long j4 = this.zzt;
                                if (j4 != -9223372036854775807L) {
                                    this.zzu.zzs(j4, 1, i13, 0, null);
                                    this.zzt += this.zzv;
                                }
                                zzh();
                            }
                        } else {
                            if (true != this.zzl) {
                                i4 = 5;
                            } else {
                                i4 = 7;
                            }
                            if (zzk(zzfaVar, this.zzc.zza, i4)) {
                                this.zzc.zzj(0);
                                if (!this.zzq) {
                                    int zzd = this.zzc.zzd(2) + 1;
                                    if (zzd != 2) {
                                        zzer.zzf("AdtsReader", "Detected audio object type: " + zzd + ", but assuming AAC LC.");
                                    }
                                    this.zzc.zzl(5);
                                    int zzd2 = this.zzc.zzd(3);
                                    int i14 = this.zzo;
                                    byte[] bArr = {(byte) (((i14 >> 1) & 7) | 16), (byte) (((zzd2 << 3) & 120) | ((i14 << 7) & 128))};
                                    zzzt zza2 = zzzu.zza(bArr);
                                    zzak zzakVar = new zzak();
                                    zzakVar.zzH(this.zzf);
                                    zzakVar.zzS("audio/mp4a-latm");
                                    zzakVar.zzx(zza2.zzc);
                                    zzakVar.zzw(zza2.zzb);
                                    zzakVar.zzT(zza2.zza);
                                    zzakVar.zzI(Collections.singletonList(bArr));
                                    zzakVar.zzK(this.zze);
                                    zzam zzY = zzakVar.zzY();
                                    this.zzr = 1024000000 / zzY.zzA;
                                    this.zzg.zzk(zzY);
                                    this.zzq = true;
                                } else {
                                    this.zzc.zzl(10);
                                }
                                this.zzc.zzl(4);
                                int zzd3 = this.zzc.zzd(13) - 7;
                                if (this.zzl) {
                                    zzd3 -= 2;
                                }
                                zzj(this.zzg, this.zzr, 0, zzd3);
                            }
                        }
                    } else if (zzk(zzfaVar, this.zzd.zzH(), 10)) {
                        this.zzh.zzq(this.zzd, 10);
                        this.zzd.zzF(6);
                        zzj(this.zzh, 0L, 10, 10 + this.zzd.zzj());
                    }
                } else if (zzfaVar.zza() != 0) {
                    zzez zzezVar = this.zzc;
                    zzezVar.zza[0] = zzfaVar.zzH()[zzfaVar.zzc()];
                    zzezVar.zzj(2);
                    int zzd4 = this.zzc.zzd(4);
                    int i15 = this.zzo;
                    if (i15 != -1 && zzd4 != i15) {
                        zzg();
                    } else {
                        if (!this.zzm) {
                            this.zzm = true;
                            this.zzn = this.zzp;
                            this.zzo = zzd4;
                        }
                        zzi();
                    }
                }
            } else {
                byte[] zzH = zzfaVar.zzH();
                int zzc = zzfaVar.zzc();
                int zzd5 = zzfaVar.zzd();
                while (true) {
                    if (zzc < zzd5) {
                        i5 = zzc + 1;
                        i6 = zzH[zzc] & 255;
                        if (this.zzk == 512 && zzl((byte) -1, (byte) i6)) {
                            if (!this.zzm) {
                                int i16 = i5 - 2;
                                zzfaVar.zzF(i16 + 1);
                                if (zzm(zzfaVar, this.zzc.zza, 1)) {
                                    this.zzc.zzj(4);
                                    int zzd6 = this.zzc.zzd(1);
                                    int i17 = this.zzn;
                                    if (i17 == -1 || zzd6 == i17) {
                                        if (this.zzo != -1) {
                                            if (!zzm(zzfaVar, this.zzc.zza, 1)) {
                                                break;
                                            }
                                            this.zzc.zzj(i11);
                                            if (this.zzc.zzd(4) == this.zzo) {
                                                zzfaVar.zzF(i16 + 2);
                                            }
                                        }
                                        if (!zzm(zzfaVar, this.zzc.zza, 4)) {
                                            break;
                                        }
                                        this.zzc.zzj(14);
                                        int zzd7 = this.zzc.zzd(i10);
                                        if (zzd7 >= 7) {
                                            byte[] zzH2 = zzfaVar.zzH();
                                            int zzd8 = zzfaVar.zzd();
                                            int i18 = i16 + zzd7;
                                            if (i18 < zzd8) {
                                                byte b4 = zzH2[i18];
                                                if (b4 == -1) {
                                                    int i19 = i18 + 1;
                                                    if (i19 == zzd8) {
                                                        break;
                                                    }
                                                    byte b5 = zzH2[i19];
                                                    if (zzl((byte) -1, b5) && ((b5 & 8) >> 3) == zzd6) {
                                                        break;
                                                    }
                                                } else if (b4 == 73) {
                                                    int i20 = i18 + 1;
                                                    if (i20 == zzd8) {
                                                        break;
                                                    } else if (zzH2[i20] == 68) {
                                                        int i21 = i18 + 2;
                                                        if (i21 == zzd8) {
                                                            break;
                                                        } else if (zzH2[i21] == 51) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        int i22 = this.zzk;
                        int i23 = i22 | i6;
                        if (i23 != 329) {
                            if (i23 != 511) {
                                if (i23 != 836) {
                                    if (i23 != 1075) {
                                        if (i22 != 256) {
                                            this.zzk = 256;
                                            zzc = i5 - 1;
                                            i10 = 13;
                                            i11 = 2;
                                        } else {
                                            zzc = i5;
                                            i10 = 13;
                                            i11 = 2;
                                        }
                                    } else {
                                        this.zzi = 2;
                                        this.zzj = 3;
                                        this.zzs = 0;
                                        this.zzd.zzF(0);
                                        zzfaVar.zzF(i5);
                                        break;
                                    }
                                } else {
                                    i7 = 1024;
                                }
                            } else {
                                i7 = 512;
                            }
                        } else {
                            i7 = 768;
                        }
                        this.zzk = i7;
                        zzc = i5;
                        i10 = 13;
                        i11 = 2;
                    } else {
                        zzfaVar.zzF(zzc);
                        break;
                    }
                }
                this.zzp = (i6 & 8) >> 3;
                if (1 != ((i6 & 1) ^ 1)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                this.zzl = z3;
                if (!this.zzm) {
                    this.zzi = 1;
                    this.zzj = 0;
                } else {
                    zzi();
                }
                zzfaVar.zzF(i5);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        this.zzf = zzajvVar.zzb();
        zzabz zzv = zzaazVar.zzv(zzajvVar.zza(), 1);
        this.zzg = zzv;
        this.zzu = zzv;
        if (this.zzb) {
            zzajvVar.zzc();
            zzabz zzv2 = zzaazVar.zzv(zzajvVar.zza(), 5);
            this.zzh = zzv2;
            zzak zzakVar = new zzak();
            zzakVar.zzH(zzajvVar.zzb());
            zzakVar.zzS("application/id3");
            zzv2.zzk(zzakVar.zzY());
            return;
        }
        this.zzh = new zzaav();
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzd(long j4, int i4) {
        if (j4 != -9223372036854775807L) {
            this.zzt = j4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        this.zzt = -9223372036854775807L;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
    }
}
