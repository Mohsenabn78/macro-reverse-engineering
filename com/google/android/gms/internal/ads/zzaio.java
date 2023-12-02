package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaio implements zzaij {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    @Nullable
    private final zzajy zzb;
    @Nullable
    private final zzfa zzc;
    private final boolean[] zzd;
    private final zzaim zze;
    @Nullable
    private final zzaiy zzf;
    private zzain zzg;
    private long zzh;
    private String zzi;
    private zzabz zzj;
    private boolean zzk;
    private long zzl;

    public zzaio() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zza(zzfa zzfaVar) {
        int i4;
        int i5;
        float f4;
        float f5;
        zzdy.zzb(this.zzg);
        zzdy.zzb(this.zzj);
        int zzc = zzfaVar.zzc();
        int zzd = zzfaVar.zzd();
        byte[] zzH = zzfaVar.zzH();
        this.zzh += zzfaVar.zza();
        this.zzj.zzq(zzfaVar, zzfaVar.zza());
        while (true) {
            int zza2 = zzfu.zza(zzH, zzc, zzd, this.zzd);
            if (zza2 == zzd) {
                break;
            }
            int i6 = zza2 + 3;
            int i7 = zzfaVar.zzH()[i6] & 255;
            int i8 = zza2 - zzc;
            if (!this.zzk) {
                if (i8 > 0) {
                    this.zze.zza(zzH, zzc, zza2);
                }
                if (i8 < 0) {
                    i5 = -i8;
                } else {
                    i5 = 0;
                }
                if (this.zze.zzc(i7, i5)) {
                    zzabz zzabzVar = this.zzj;
                    zzaim zzaimVar = this.zze;
                    int i9 = zzaimVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] copyOf = Arrays.copyOf(zzaimVar.zzc, zzaimVar.zza);
                    zzez zzezVar = new zzez(copyOf, copyOf.length);
                    zzezVar.zzm(i9);
                    zzezVar.zzm(4);
                    zzezVar.zzk();
                    zzezVar.zzl(8);
                    if (zzezVar.zzn()) {
                        zzezVar.zzl(4);
                        zzezVar.zzl(3);
                    }
                    int zzd2 = zzezVar.zzd(4);
                    if (zzd2 == 15) {
                        int zzd3 = zzezVar.zzd(8);
                        int zzd4 = zzezVar.zzd(8);
                        if (zzd4 == 0) {
                            zzer.zzf("H263Reader", "Invalid aspect ratio");
                            f5 = 1.0f;
                        } else {
                            f4 = zzd3 / zzd4;
                            f5 = f4;
                        }
                    } else if (zzd2 < 7) {
                        f4 = zza[zzd2];
                        f5 = f4;
                    } else {
                        zzer.zzf("H263Reader", "Invalid aspect ratio");
                        f5 = 1.0f;
                    }
                    if (zzezVar.zzn()) {
                        zzezVar.zzl(2);
                        zzezVar.zzl(1);
                        if (zzezVar.zzn()) {
                            zzezVar.zzl(15);
                            zzezVar.zzk();
                            zzezVar.zzl(15);
                            zzezVar.zzk();
                            zzezVar.zzl(15);
                            zzezVar.zzk();
                            zzezVar.zzl(3);
                            zzezVar.zzl(11);
                            zzezVar.zzk();
                            zzezVar.zzl(15);
                            zzezVar.zzk();
                        }
                    }
                    if (zzezVar.zzd(2) != 0) {
                        zzer.zzf("H263Reader", "Unhandled video object layer shape");
                    }
                    zzezVar.zzk();
                    int zzd5 = zzezVar.zzd(16);
                    zzezVar.zzk();
                    if (zzezVar.zzn()) {
                        if (zzd5 == 0) {
                            zzer.zzf("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            int i10 = zzd5 - 1;
                            int i11 = 0;
                            while (i10 > 0) {
                                i10 >>= 1;
                                i11++;
                            }
                            zzezVar.zzl(i11);
                        }
                    }
                    zzezVar.zzk();
                    int zzd6 = zzezVar.zzd(13);
                    zzezVar.zzk();
                    int zzd7 = zzezVar.zzd(13);
                    zzezVar.zzk();
                    zzezVar.zzk();
                    zzak zzakVar = new zzak();
                    zzakVar.zzH(str);
                    zzakVar.zzS("video/mp4v-es");
                    zzakVar.zzX(zzd6);
                    zzakVar.zzF(zzd7);
                    zzakVar.zzP(f5);
                    zzakVar.zzI(Collections.singletonList(copyOf));
                    zzabzVar.zzk(zzakVar.zzY());
                    this.zzk = true;
                }
            }
            this.zzg.zza(zzH, zzc, zza2);
            zzaiy zzaiyVar = this.zzf;
            if (i8 > 0) {
                zzaiyVar.zza(zzH, zzc, zza2);
                i4 = 0;
            } else {
                i4 = -i8;
            }
            if (this.zzf.zzd(i4)) {
                zzaiy zzaiyVar2 = this.zzf;
                int zzb = zzfu.zzb(zzaiyVar2.zza, zzaiyVar2.zzb);
                zzfa zzfaVar2 = this.zzc;
                int i12 = zzfj.zza;
                zzfaVar2.zzD(this.zzf.zza, zzb);
                this.zzb.zza(this.zzl, this.zzc);
            }
            if (i7 == 178) {
                if (zzfaVar.zzH()[zza2 + 2] == 1) {
                    this.zzf.zzc(178);
                }
                i7 = 178;
            }
            int i13 = zzd - zza2;
            this.zzg.zzb(this.zzh - i13, i13, this.zzk);
            this.zzg.zzc(i7, this.zzl);
            zzc = i6;
        }
        if (!this.zzk) {
            this.zze.zza(zzH, zzc, zzd);
        }
        this.zzg.zza(zzH, zzc, zzd);
        this.zzf.zza(zzH, zzc, zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        this.zzi = zzajvVar.zzb();
        zzabz zzv = zzaazVar.zzv(zzajvVar.zza(), 2);
        this.zzj = zzv;
        this.zzg = new zzain(zzv);
        this.zzb.zzb(zzaazVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzd(long j4, int i4) {
        if (j4 != -9223372036854775807L) {
            this.zzl = j4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        zzfu.zzf(this.zzd);
        this.zze.zzb();
        zzain zzainVar = this.zzg;
        if (zzainVar != null) {
            zzainVar.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaio(@Nullable zzajy zzajyVar) {
        this.zzb = zzajyVar;
        this.zzd = new boolean[4];
        this.zze = new zzaim(128);
        this.zzl = -9223372036854775807L;
        this.zzf = new zzaiy(178, 128);
        this.zzc = new zzfa();
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
    }
}
