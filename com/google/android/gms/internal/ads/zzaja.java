package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaja implements zzajw {
    private final zzaij zza;
    private final zzez zzb = new zzez(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfh zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzaja(zzaij zzaijVar) {
        this.zza = zzaijVar;
    }

    private final void zzd(int i4) {
        this.zzc = i4;
        this.zzd = 0;
    }

    private final boolean zze(zzfa zzfaVar, @Nullable byte[] bArr, int i4) {
        int min = Math.min(zzfaVar.zza(), i4 - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzfaVar.zzG(min);
        } else {
            zzfaVar.zzB(bArr, this.zzd, min);
        }
        int i5 = this.zzd + min;
        this.zzd = i5;
        if (i5 == i4) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zza(zzfa zzfaVar, int i4) throws zzcd {
        long j4;
        int i5;
        int i6;
        zzdy.zzb(this.zze);
        int i7 = -1;
        int i8 = 2;
        int i9 = 1;
        if ((i4 & 1) != 0) {
            int i10 = this.zzc;
            if (i10 != 0 && i10 != 1) {
                if (i10 != 2) {
                    int i11 = this.zzj;
                    if (i11 != -1) {
                        zzer.zzf("PesReader", "Unexpected start indicator: expected " + i11 + " more bytes");
                    }
                    this.zza.zzc();
                } else {
                    zzer.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        int i12 = i4;
        while (zzfaVar.zza() > 0) {
            int i13 = this.zzc;
            if (i13 != 0) {
                int i14 = 0;
                if (i13 != i9) {
                    if (i13 != i8) {
                        int zza = zzfaVar.zza();
                        int i15 = this.zzj;
                        if (i15 != i7) {
                            i14 = zza - i15;
                        }
                        if (i14 > 0) {
                            zza -= i14;
                            zzfaVar.zzE(zzfaVar.zzc() + zza);
                        }
                        this.zza.zza(zzfaVar);
                        int i16 = this.zzj;
                        if (i16 != i7) {
                            int i17 = i16 - zza;
                            this.zzj = i17;
                            if (i17 == 0) {
                                this.zza.zzc();
                                zzd(i9);
                            }
                        }
                    } else {
                        if (zze(zzfaVar, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzfaVar, null, this.zzi)) {
                            this.zzb.zzj(0);
                            if (this.zzf) {
                                this.zzb.zzl(4);
                                long zzd = this.zzb.zzd(3);
                                this.zzb.zzl(i9);
                                int zzd2 = this.zzb.zzd(15) << 15;
                                this.zzb.zzl(i9);
                                long zzd3 = this.zzb.zzd(15);
                                this.zzb.zzl(i9);
                                if (!this.zzh && this.zzg) {
                                    this.zzb.zzl(4);
                                    this.zzb.zzl(i9);
                                    this.zzb.zzl(i9);
                                    long zzd4 = this.zzb.zzd(15);
                                    this.zzb.zzl(i9);
                                    i6 = zzd2;
                                    this.zze.zzb((this.zzb.zzd(3) << 30) | (this.zzb.zzd(15) << 15) | zzd4);
                                    this.zzh = true;
                                } else {
                                    i6 = zzd2;
                                }
                                j4 = this.zze.zzb((zzd << 30) | i6 | zzd3);
                            } else {
                                j4 = -9223372036854775807L;
                            }
                            if (true != this.zzk) {
                                i5 = 0;
                            } else {
                                i5 = 4;
                            }
                            i12 |= i5;
                            this.zza.zzd(j4, i12);
                            zzd(3);
                            i7 = -1;
                            i8 = 2;
                            i9 = 1;
                        }
                    }
                } else if (zze(zzfaVar, this.zzb.zza, 9)) {
                    int i18 = 0;
                    this.zzb.zzj(0);
                    int zzd5 = this.zzb.zzd(24);
                    i9 = 1;
                    if (zzd5 != 1) {
                        zzer.zzf("PesReader", "Unexpected start code prefix: " + zzd5);
                        i7 = -1;
                        this.zzj = -1;
                    } else {
                        this.zzb.zzl(8);
                        int zzd6 = this.zzb.zzd(16);
                        this.zzb.zzl(5);
                        this.zzk = this.zzb.zzn();
                        this.zzb.zzl(2);
                        this.zzf = this.zzb.zzn();
                        this.zzg = this.zzb.zzn();
                        this.zzb.zzl(6);
                        int zzd7 = this.zzb.zzd(8);
                        this.zzi = zzd7;
                        if (zzd6 == 0) {
                            this.zzj = -1;
                        } else {
                            int i19 = (zzd6 - 3) - zzd7;
                            this.zzj = i19;
                            if (i19 < 0) {
                                zzer.zzf("PesReader", "Found negative packet payload size: " + i19);
                                i7 = -1;
                                this.zzj = -1;
                                i18 = 2;
                            }
                        }
                        i7 = -1;
                        i18 = 2;
                    }
                    zzd(i18);
                } else {
                    i7 = -1;
                    i9 = 1;
                }
            } else {
                zzfaVar.zzG(zzfaVar.zza());
            }
            i8 = 2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzb(zzfh zzfhVar, zzaaz zzaazVar, zzajv zzajvVar) {
        this.zze = zzfhVar;
        this.zza.zzb(zzaazVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}
