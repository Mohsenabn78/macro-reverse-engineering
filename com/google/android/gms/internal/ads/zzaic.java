package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;
import com.google.common.primitives.SignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaic implements zzaij {
    private final zzez zza;
    private final zzfa zzb;
    @Nullable
    private final String zzc;
    private String zzd;
    private zzabz zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzam zzj;
    private int zzk;
    private long zzl;

    public zzaic() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zza(zzfa zzfaVar) {
        boolean z3;
        boolean z4;
        zzdy.zzb(this.zze);
        while (zzfaVar.zza() > 0) {
            int i4 = this.zzf;
            if (i4 != 0) {
                if (i4 != 1) {
                    int min = Math.min(zzfaVar.zza(), this.zzk - this.zzg);
                    this.zze.zzq(zzfaVar, min);
                    int i5 = this.zzg + min;
                    this.zzg = i5;
                    int i6 = this.zzk;
                    if (i5 == i6) {
                        long j4 = this.zzl;
                        if (j4 != -9223372036854775807L) {
                            this.zze.zzs(j4, 1, i6, 0, null);
                            this.zzl += this.zzi;
                        }
                        this.zzf = 0;
                    }
                } else {
                    byte[] zzH = this.zzb.zzH();
                    int min2 = Math.min(zzfaVar.zza(), 16 - this.zzg);
                    zzfaVar.zzB(zzH, this.zzg, min2);
                    int i7 = this.zzg + min2;
                    this.zzg = i7;
                    if (i7 == 16) {
                        this.zza.zzj(0);
                        zzzz zza = zzaaa.zza(this.zza);
                        zzam zzamVar = this.zzj;
                        if (zzamVar == null || zzamVar.zzz != 2 || zza.zza != zzamVar.zzA || !"audio/ac4".equals(zzamVar.zzm)) {
                            zzak zzakVar = new zzak();
                            zzakVar.zzH(this.zzd);
                            zzakVar.zzS("audio/ac4");
                            zzakVar.zzw(2);
                            zzakVar.zzT(zza.zza);
                            zzakVar.zzK(this.zzc);
                            zzam zzY = zzakVar.zzY();
                            this.zzj = zzY;
                            this.zze.zzk(zzY);
                        }
                        this.zzk = zza.zzb;
                        this.zzi = (zza.zzc * AnimationKt.MillisToNanos) / this.zzj.zzA;
                        this.zzb.zzF(0);
                        this.zze.zzq(this.zzb, 16);
                        this.zzf = 2;
                    }
                }
            } else {
                while (zzfaVar.zza() > 0) {
                    if (!this.zzh) {
                        if (zzfaVar.zzk() == 172) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.zzh = z3;
                    } else {
                        int zzk = zzfaVar.zzk();
                        if (zzk == 172) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.zzh = z4;
                        byte b4 = SignedBytes.MAX_POWER_OF_TWO;
                        if (zzk != 64) {
                            if (zzk == 65) {
                                zzk = 65;
                            }
                        }
                        this.zzf = 1;
                        zzfa zzfaVar2 = this.zzb;
                        zzfaVar2.zzH()[0] = -84;
                        byte[] zzH2 = zzfaVar2.zzH();
                        if (zzk == 65) {
                            b4 = 65;
                        }
                        zzH2[1] = b4;
                        this.zzg = 2;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        this.zzd = zzajvVar.zzb();
        this.zze = zzaazVar.zzv(zzajvVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzd(long j4, int i4) {
        if (j4 != -9223372036854775807L) {
            this.zzl = j4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
    }

    public zzaic(@Nullable String str) {
        zzez zzezVar = new zzez(new byte[16], 16);
        this.zza = zzezVar;
        this.zzb = new zzfa(zzezVar.zza);
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
    }
}
