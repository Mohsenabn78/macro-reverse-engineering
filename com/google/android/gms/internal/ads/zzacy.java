package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzacy implements zzaaw {
    public static final zzabd zza = new zzabd() { // from class: com.google.android.gms.internal.ads.zzacx
        @Override // com.google.android.gms.internal.ads.zzabd
        public final /* synthetic */ zzaaw[] zza(Uri uri, Map map) {
            int i4 = zzabc.zza;
            return new zzaaw[]{new zzacy(0)};
        }
    };
    private final byte[] zzb;
    private final zzfa zzc;
    private final zzabe zzd;
    private zzaaz zze;
    private zzabz zzf;
    private int zzg;
    @Nullable
    private zzbz zzh;
    private zzabj zzi;
    private int zzj;
    private int zzk;
    private zzacw zzl;
    private int zzm;
    private long zzn;

    public zzacy() {
        this(0);
    }

    private final long zze(zzfa zzfaVar, boolean z3) {
        boolean z4;
        this.zzi.getClass();
        int zzc = zzfaVar.zzc();
        while (zzc <= zzfaVar.zzd() - 16) {
            zzfaVar.zzF(zzc);
            if (zzabf.zzc(zzfaVar, this.zzi, this.zzk, this.zzd)) {
                zzfaVar.zzF(zzc);
                return this.zzd.zza;
            }
            zzc++;
        }
        if (z3) {
            while (zzc <= zzfaVar.zzd() - this.zzj) {
                zzfaVar.zzF(zzc);
                try {
                    z4 = zzabf.zzc(zzfaVar, this.zzi, this.zzk, this.zzd);
                } catch (IndexOutOfBoundsException unused) {
                    z4 = false;
                }
                if (zzfaVar.zzc() <= zzfaVar.zzd() && z4) {
                    zzfaVar.zzF(zzc);
                    return this.zzd.zza;
                }
                zzc++;
            }
            zzfaVar.zzF(zzfaVar.zzd());
            return -1L;
        }
        zzfaVar.zzF(zzc);
        return -1L;
    }

    private final void zzf() {
        long j4 = this.zzn * AnimationKt.MillisToNanos;
        zzabj zzabjVar = this.zzi;
        int i4 = zzfj.zza;
        this.zzf.zzs(j4 / zzabjVar.zze, 1, this.zzm, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final int zza(zzaax zzaaxVar, zzabs zzabsVar) throws IOException {
        boolean zzn;
        zzabv zzabuVar;
        int i4 = this.zzg;
        boolean z3 = true;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            this.zzf.getClass();
                            zzabj zzabjVar = this.zzi;
                            zzabjVar.getClass();
                            zzacw zzacwVar = this.zzl;
                            if (zzacwVar != null && zzacwVar.zze()) {
                                return zzacwVar.zza(zzaaxVar, zzabsVar);
                            }
                            if (this.zzn == -1) {
                                this.zzn = zzabf.zzb(zzaaxVar, zzabjVar);
                                return 0;
                            }
                            zzfa zzfaVar = this.zzc;
                            int zzd = zzfaVar.zzd();
                            if (zzd < 32768) {
                                int zza2 = zzaaxVar.zza(zzfaVar.zzH(), zzd, 32768 - zzd);
                                if (zza2 != -1) {
                                    z3 = false;
                                }
                                if (!z3) {
                                    this.zzc.zzE(zzd + zza2);
                                } else if (this.zzc.zza() == 0) {
                                    zzf();
                                    return -1;
                                }
                            } else {
                                z3 = false;
                            }
                            zzfa zzfaVar2 = this.zzc;
                            int zzc = zzfaVar2.zzc();
                            int i5 = this.zzm;
                            int i6 = this.zzj;
                            if (i5 < i6) {
                                zzfaVar2.zzG(Math.min(i6 - i5, zzfaVar2.zza()));
                            }
                            long zze = zze(this.zzc, z3);
                            zzfa zzfaVar3 = this.zzc;
                            int zzc2 = zzfaVar3.zzc() - zzc;
                            zzfaVar3.zzF(zzc);
                            zzabx.zzb(this.zzf, this.zzc, zzc2);
                            this.zzm += zzc2;
                            if (zze != -1) {
                                zzf();
                                this.zzm = 0;
                                this.zzn = zze;
                            }
                            zzfa zzfaVar4 = this.zzc;
                            if (zzfaVar4.zza() >= 16) {
                                return 0;
                            }
                            int zza3 = zzfaVar4.zza();
                            System.arraycopy(zzfaVar4.zzH(), zzfaVar4.zzc(), zzfaVar4.zzH(), 0, zza3);
                            this.zzc.zzF(0);
                            this.zzc.zzE(zza3);
                            return 0;
                        }
                        zzaaxVar.zzj();
                        zzfa zzfaVar5 = new zzfa(2);
                        ((zzaam) zzaaxVar).zzm(zzfaVar5.zzH(), 0, 2, false);
                        int zzo = zzfaVar5.zzo();
                        if ((zzo >> 2) == 16382) {
                            zzaaxVar.zzj();
                            this.zzk = zzo;
                            zzaaz zzaazVar = this.zze;
                            int i7 = zzfj.zza;
                            long zzf = zzaaxVar.zzf();
                            long zzd2 = zzaaxVar.zzd();
                            zzabj zzabjVar2 = this.zzi;
                            zzabjVar2.getClass();
                            if (zzabjVar2.zzk != null) {
                                zzabuVar = new zzabh(zzabjVar2, zzf);
                            } else if (zzd2 != -1 && zzabjVar2.zzj > 0) {
                                zzacw zzacwVar2 = new zzacw(zzabjVar2, this.zzk, zzf, zzd2);
                                this.zzl = zzacwVar2;
                                zzabuVar = zzacwVar2.zzb();
                            } else {
                                zzabuVar = new zzabu(zzabjVar2.zza(), 0L);
                            }
                            zzaazVar.zzN(zzabuVar);
                            this.zzg = 5;
                            return 0;
                        }
                        zzaaxVar.zzj();
                        throw zzcd.zza("First frame does not start with sync code.", null);
                    }
                    zzabj zzabjVar3 = this.zzi;
                    do {
                        zzaaxVar.zzj();
                        zzez zzezVar = new zzez(new byte[4], 4);
                        zzaam zzaamVar = (zzaam) zzaaxVar;
                        zzaamVar.zzm(zzezVar.zza, 0, 4, false);
                        zzn = zzezVar.zzn();
                        int zzd3 = zzezVar.zzd(7);
                        int zzd4 = zzezVar.zzd(24) + 4;
                        if (zzd3 == 0) {
                            byte[] bArr = new byte[38];
                            zzaamVar.zzn(bArr, 0, 38, false);
                            zzabjVar3 = new zzabj(bArr, 4);
                        } else if (zzabjVar3 != null) {
                            if (zzd3 == 3) {
                                zzfa zzfaVar6 = new zzfa(zzd4);
                                zzaamVar.zzn(zzfaVar6.zzH(), 0, zzd4, false);
                                zzabjVar3 = zzabjVar3.zzf(zzabg.zzb(zzfaVar6));
                            } else if (zzd3 == 4) {
                                zzfa zzfaVar7 = new zzfa(zzd4);
                                zzaamVar.zzn(zzfaVar7.zzH(), 0, zzd4, false);
                                zzfaVar7.zzG(4);
                                zzabjVar3 = zzabjVar3.zzg(Arrays.asList(zzacf.zzc(zzfaVar7, false, false).zzb));
                            } else if (zzd3 == 6) {
                                zzfa zzfaVar8 = new zzfa(zzd4);
                                zzaamVar.zzn(zzfaVar8.zzH(), 0, zzd4, false);
                                zzfaVar8.zzG(4);
                                zzabjVar3 = zzabjVar3.zze(zzfsc.zzm(zzads.zzb(zzfaVar8)));
                            } else {
                                zzaamVar.zzo(zzd4, false);
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                        int i8 = zzfj.zza;
                        this.zzi = zzabjVar3;
                    } while (!zzn);
                    zzabjVar3.getClass();
                    this.zzj = Math.max(zzabjVar3.zzc, 6);
                    this.zzf.zzk(this.zzi.zzc(this.zzb, this.zzh));
                    this.zzg = 4;
                    return 0;
                }
                zzfa zzfaVar9 = new zzfa(4);
                ((zzaam) zzaaxVar).zzn(zzfaVar9.zzH(), 0, 4, false);
                if (zzfaVar9.zzs() == 1716281667) {
                    this.zzg = 3;
                    return 0;
                }
                throw zzcd.zza("Failed to read FLAC stream marker.", null);
            }
            ((zzaam) zzaaxVar).zzm(this.zzb, 0, 42, false);
            zzaaxVar.zzj();
            this.zzg = 2;
            return 0;
        }
        zzaaxVar.zzj();
        long zze2 = zzaaxVar.zze();
        zzbz zza4 = zzabg.zza(zzaaxVar, true);
        ((zzaam) zzaaxVar).zzo((int) (zzaaxVar.zze() - zze2), false);
        this.zzh = zza4;
        this.zzg = 1;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zze = zzaazVar;
        this.zzf = zzaazVar.zzv(0, 1);
        zzaazVar.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzc(long j4, long j5) {
        long j6 = 0;
        if (j4 == 0) {
            this.zzg = 0;
        } else {
            zzacw zzacwVar = this.zzl;
            if (zzacwVar != null) {
                zzacwVar.zzd(j5);
            }
        }
        if (j5 != 0) {
            j6 = -1;
        }
        this.zzn = j6;
        this.zzm = 0;
        this.zzc.zzC(0);
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        zzabg.zza(zzaaxVar, false);
        zzfa zzfaVar = new zzfa(4);
        ((zzaam) zzaaxVar).zzm(zzfaVar.zzH(), 0, 4, false);
        if (zzfaVar.zzs() != 1716281667) {
            return false;
        }
        return true;
    }

    public zzacy(int i4) {
        this.zzb = new byte[42];
        this.zzc = new zzfa(new byte[32768], 0);
        this.zzd = new zzabe();
        this.zzg = 0;
    }
}
