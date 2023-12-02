package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzajj implements zzajw {
    private final zzaji zza;
    private final zzfa zzb = new zzfa(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzajj(zzaji zzajiVar) {
        this.zza = zzajiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zza(zzfa zzfaVar, int i4) {
        int i5;
        boolean z3;
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = zzfaVar.zzc() + zzfaVar.zzk();
        } else {
            i5 = -1;
        }
        if (this.zzf) {
            if (i6 == 0) {
                return;
            }
            this.zzf = false;
            zzfaVar.zzF(i5);
            this.zzd = 0;
        }
        while (zzfaVar.zza() > 0) {
            int i7 = this.zzd;
            if (i7 < 3) {
                if (i7 == 0) {
                    int zzk = zzfaVar.zzk();
                    zzfaVar.zzF(zzfaVar.zzc() - 1);
                    if (zzk == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int min = Math.min(zzfaVar.zza(), 3 - this.zzd);
                zzfaVar.zzB(this.zzb.zzH(), this.zzd, min);
                int i8 = this.zzd + min;
                this.zzd = i8;
                if (i8 == 3) {
                    this.zzb.zzF(0);
                    this.zzb.zzE(3);
                    this.zzb.zzG(1);
                    int zzk2 = this.zzb.zzk();
                    int zzk3 = this.zzb.zzk();
                    if ((zzk2 & 128) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.zze = z3;
                    this.zzc = (((zzk2 & 15) << 8) | zzk3) + 3;
                    int zzb = this.zzb.zzb();
                    int i9 = this.zzc;
                    if (zzb < i9) {
                        int zzb2 = this.zzb.zzb();
                        this.zzb.zzz(Math.min((int) InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i9, zzb2 + zzb2)));
                    }
                }
            } else {
                int min2 = Math.min(zzfaVar.zza(), this.zzc - i7);
                zzfaVar.zzB(this.zzb.zzH(), this.zzd, min2);
                int i10 = this.zzd + min2;
                this.zzd = i10;
                int i11 = this.zzc;
                if (i10 != i11) {
                    continue;
                } else {
                    if (this.zze) {
                        if (zzfj.zzd(this.zzb.zzH(), 0, i11, -1) != 0) {
                            this.zzf = true;
                            return;
                        }
                        this.zzb.zzE(this.zzc - 4);
                    } else {
                        this.zzb.zzE(i11);
                    }
                    this.zzb.zzF(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzb(zzfh zzfhVar, zzaaz zzaazVar, zzajv zzajvVar) {
        this.zza.zzb(zzfhVar, zzaazVar, zzajvVar);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzc() {
        this.zzf = true;
    }
}
