package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaix implements zzaij {
    private final zzfa zza;
    private final zzabp zzb;
    @Nullable
    private final String zzc;
    private zzabz zzd;
    private String zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private long zzl;

    public zzaix() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zza(zzfa zzfaVar) {
        zzabp zzabpVar;
        boolean z3;
        boolean z4;
        zzdy.zzb(this.zzd);
        while (zzfaVar.zza() > 0) {
            int i4 = this.zzf;
            if (i4 != 0) {
                if (i4 != 1) {
                    int min = Math.min(zzfaVar.zza(), this.zzk - this.zzg);
                    this.zzd.zzq(zzfaVar, min);
                    int i5 = this.zzg + min;
                    this.zzg = i5;
                    int i6 = this.zzk;
                    if (i5 >= i6) {
                        long j4 = this.zzl;
                        if (j4 != -9223372036854775807L) {
                            this.zzd.zzs(j4, 1, i6, 0, null);
                            this.zzl += this.zzj;
                        }
                        this.zzg = 0;
                        this.zzf = 0;
                    }
                } else {
                    int min2 = Math.min(zzfaVar.zza(), 4 - this.zzg);
                    zzfaVar.zzB(this.zza.zzH(), this.zzg, min2);
                    int i7 = this.zzg + min2;
                    this.zzg = i7;
                    if (i7 >= 4) {
                        this.zza.zzF(0);
                        if (!this.zzb.zza(this.zza.zze())) {
                            this.zzg = 0;
                            this.zzf = 1;
                        } else {
                            this.zzk = this.zzb.zzc;
                            if (!this.zzh) {
                                this.zzj = (zzabpVar.zzg * AnimationKt.MillisToNanos) / zzabpVar.zzd;
                                zzak zzakVar = new zzak();
                                zzakVar.zzH(this.zze);
                                zzakVar.zzS(this.zzb.zzb);
                                zzakVar.zzL(4096);
                                zzakVar.zzw(this.zzb.zze);
                                zzakVar.zzT(this.zzb.zzd);
                                zzakVar.zzK(this.zzc);
                                this.zzd.zzk(zzakVar.zzY());
                                this.zzh = true;
                            }
                            this.zza.zzF(0);
                            this.zzd.zzq(this.zza, 4);
                            this.zzf = 2;
                        }
                    }
                }
            } else {
                byte[] zzH = zzfaVar.zzH();
                int zzc = zzfaVar.zzc();
                int zzd = zzfaVar.zzd();
                while (true) {
                    if (zzc < zzd) {
                        byte b4 = zzH[zzc];
                        if ((b4 & 255) == 255) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (this.zzi && (b4 & 224) == 224) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.zzi = z3;
                        if (z4) {
                            zzfaVar.zzF(zzc + 1);
                            this.zzi = false;
                            this.zza.zzH()[1] = zzH[zzc];
                            this.zzg = 2;
                            this.zzf = 1;
                            break;
                        }
                        zzc++;
                    } else {
                        zzfaVar.zzF(zzd);
                        break;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        this.zze = zzajvVar.zzb();
        this.zzd = zzaazVar.zzv(zzajvVar.zza(), 1);
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
        this.zzi = false;
        this.zzl = -9223372036854775807L;
    }

    public zzaix(@Nullable String str) {
        this.zzf = 0;
        zzfa zzfaVar = new zzfa(4);
        this.zza = zzfaVar;
        zzfaVar.zzH()[0] = -1;
        this.zzb = new zzabp();
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
    }
}
