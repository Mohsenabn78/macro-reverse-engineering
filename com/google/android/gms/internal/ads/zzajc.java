package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzajc implements zzaah {
    private final zzfh zza;
    private final zzfa zzb = new zzfa();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzajc(zzfh zzfhVar, zzajb zzajbVar) {
        this.zza = zzfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final zzaag zza(zzaax zzaaxVar, long j4) throws IOException {
        int zzh;
        long j5;
        long zzf = zzaaxVar.zzf();
        int min = (int) Math.min(20000L, zzaaxVar.zzd() - zzf);
        this.zzb.zzC(min);
        ((zzaam) zzaaxVar).zzm(this.zzb.zzH(), 0, min, false);
        zzfa zzfaVar = this.zzb;
        int i4 = -1;
        long j6 = -9223372036854775807L;
        int i5 = -1;
        while (zzfaVar.zza() >= 4) {
            if (zzajd.zzh(zzfaVar.zzH(), zzfaVar.zzc()) != 442) {
                zzfaVar.zzG(1);
            } else {
                zzfaVar.zzG(4);
                long zzc = zzaje.zzc(zzfaVar);
                if (zzc != -9223372036854775807L) {
                    long zzb = this.zza.zzb(zzc);
                    if (zzb > j4) {
                        if (j6 == -9223372036854775807L) {
                            return zzaag.zzd(zzb, zzf);
                        }
                        j5 = i5;
                    } else if (100000 + zzb > j4) {
                        j5 = zzfaVar.zzc();
                    } else {
                        i5 = zzfaVar.zzc();
                        j6 = zzb;
                    }
                    return zzaag.zze(zzf + j5);
                }
                int zzd = zzfaVar.zzd();
                if (zzfaVar.zza() < 10) {
                    zzfaVar.zzF(zzd);
                } else {
                    zzfaVar.zzG(9);
                    int zzk = zzfaVar.zzk() & 7;
                    if (zzfaVar.zza() < zzk) {
                        zzfaVar.zzF(zzd);
                    } else {
                        zzfaVar.zzG(zzk);
                        if (zzfaVar.zza() < 4) {
                            zzfaVar.zzF(zzd);
                        } else {
                            if (zzajd.zzh(zzfaVar.zzH(), zzfaVar.zzc()) == 443) {
                                zzfaVar.zzG(4);
                                int zzo = zzfaVar.zzo();
                                if (zzfaVar.zza() < zzo) {
                                    zzfaVar.zzF(zzd);
                                } else {
                                    zzfaVar.zzG(zzo);
                                }
                            }
                            while (true) {
                                if (zzfaVar.zza() < 4 || (zzh = zzajd.zzh(zzfaVar.zzH(), zzfaVar.zzc())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzfaVar.zzG(4);
                                if (zzfaVar.zza() < 2) {
                                    zzfaVar.zzF(zzd);
                                    break;
                                }
                                zzfaVar.zzF(Math.min(zzfaVar.zzd(), zzfaVar.zzc() + zzfaVar.zzo()));
                            }
                        }
                    }
                }
                i4 = zzfaVar.zzc();
            }
        }
        if (j6 != -9223372036854775807L) {
            return zzaag.zzf(j6, zzf + i4);
        }
        return zzaag.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final void zzb() {
        zzfa zzfaVar = this.zzb;
        byte[] bArr = zzfj.zzf;
        int length = bArr.length;
        zzfaVar.zzD(bArr, 0);
    }
}
