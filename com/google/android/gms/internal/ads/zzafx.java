package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzafx implements zzaaw {
    public static final zzabd zza = new zzabd() { // from class: com.google.android.gms.internal.ads.zzafv
        @Override // com.google.android.gms.internal.ads.zzabd
        public final /* synthetic */ zzaaw[] zza(Uri uri, Map map) {
            int i4 = zzabc.zza;
            return new zzaaw[]{new zzafx(0)};
        }
    };
    private static final zzaek zzb = new zzaek() { // from class: com.google.android.gms.internal.ads.zzafw
    };
    private final zzfa zzc;
    private final zzabp zzd;
    private final zzabl zze;
    private final zzabn zzf;
    private final zzabz zzg;
    private zzaaz zzh;
    private zzabz zzi;
    private zzabz zzj;
    private int zzk;
    @Nullable
    private zzbz zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzafz zzq;
    private boolean zzr;

    public zzafx() {
        this(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0169  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "realTrackOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzf(com.google.android.gms.internal.ads.zzaax r17) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafx.zzf(com.google.android.gms.internal.ads.zzaax):int");
    }

    private final long zzg(long j4) {
        return this.zzm + ((j4 * AnimationKt.MillisToNanos) / this.zzd.zzd);
    }

    private final zzafz zzh(zzaax zzaaxVar, boolean z3) throws IOException {
        ((zzaam) zzaaxVar).zzm(this.zzc.zzH(), 0, 4, false);
        this.zzc.zzF(0);
        this.zzd.zza(this.zzc.zze());
        return new zzafs(zzaaxVar.zzd(), zzaaxVar.zzf(), this.zzd, false);
    }

    private static boolean zzi(int i4, long j4) {
        if ((i4 & (-128000)) == (j4 & (-128000))) {
            return true;
        }
        return false;
    }

    private final boolean zzj(zzaax zzaaxVar) throws IOException {
        zzafz zzafzVar = this.zzq;
        if (zzafzVar != null) {
            long zzb2 = zzafzVar.zzb();
            if (zzb2 != -1 && zzaaxVar.zze() > zzb2 - 4) {
                return true;
            }
        }
        try {
            if (!zzaaxVar.zzm(this.zzc.zzH(), 0, 4, true)) {
                return true;
            }
            return false;
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzk(zzaax zzaaxVar, boolean z3) throws IOException {
        int i4;
        int i5;
        int zzb2;
        int i6;
        zzaaxVar.zzj();
        if (zzaaxVar.zzf() == 0) {
            zzbz zza2 = this.zzf.zza(zzaaxVar, null);
            this.zzl = zza2;
            if (zza2 != null) {
                this.zze.zzb(zza2);
            }
            i5 = (int) zzaaxVar.zze();
            if (!z3) {
                ((zzaam) zzaaxVar).zzo(i5, false);
            }
            i4 = 0;
        } else {
            i4 = 0;
            i5 = 0;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (zzj(zzaaxVar)) {
                if (i7 <= 0) {
                    throw new EOFException();
                }
            } else {
                this.zzc.zzF(0);
                int zze = this.zzc.zze();
                if ((i4 != 0 && !zzi(zze, i4)) || (zzb2 = zzabq.zzb(zze)) == -1) {
                    if (true != z3) {
                        i6 = 131072;
                    } else {
                        i6 = 32768;
                    }
                    int i9 = i8 + 1;
                    if (i8 == i6) {
                        if (z3) {
                            return false;
                        }
                        throw zzcd.zza("Searched too many bytes.", null);
                    }
                    if (z3) {
                        zzaaxVar.zzj();
                        ((zzaam) zzaaxVar).zzl(i5 + i9, false);
                    } else {
                        ((zzaam) zzaaxVar).zzo(1, false);
                    }
                    i8 = i9;
                    i4 = 0;
                    i7 = 0;
                } else {
                    i7++;
                    if (i7 == 1) {
                        this.zzd.zza(zze);
                        i4 = zze;
                    } else if (i7 == 4) {
                        break;
                    }
                    ((zzaam) zzaaxVar).zzl(zzb2 - 4, false);
                }
            }
        }
        if (z3) {
            ((zzaam) zzaaxVar).zzo(i5 + i8, false);
        } else {
            zzaaxVar.zzj();
        }
        this.zzk = i4;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final int zza(zzaax zzaaxVar, zzabs zzabsVar) throws IOException {
        zzdy.zzb(this.zzi);
        int i4 = zzfj.zza;
        int zzf = zzf(zzaaxVar);
        if (zzf == -1 && (this.zzq instanceof zzaft)) {
            if (this.zzq.zze() != zzg(this.zzn)) {
                zzaft zzaftVar = (zzaft) this.zzq;
                throw null;
            }
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zzh = zzaazVar;
        zzabz zzv = zzaazVar.zzv(0, 1);
        this.zzi = zzv;
        this.zzj = zzv;
        this.zzh.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzc(long j4, long j5) {
        this.zzk = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = 0L;
        this.zzp = 0;
        zzafz zzafzVar = this.zzq;
        if (!(zzafzVar instanceof zzaft)) {
            return;
        }
        zzaft zzaftVar = (zzaft) zzafzVar;
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        return zzk(zzaaxVar, true);
    }

    public final void zze() {
        this.zzr = true;
    }

    public zzafx(int i4) {
        this.zzc = new zzfa(10);
        this.zzd = new zzabp();
        this.zze = new zzabl();
        this.zzm = -9223372036854775807L;
        this.zzf = new zzabn();
        zzaav zzaavVar = new zzaav();
        this.zzg = zzaavVar;
        this.zzj = zzaavVar;
    }
}
