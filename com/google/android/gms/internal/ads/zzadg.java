package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzadg implements zzaaw {
    private zzaaz zzb;
    private int zzc;
    private int zzd;
    private int zze;
    @Nullable
    private zzafa zzg;
    private zzaax zzh;
    private zzadj zzi;
    @Nullable
    private zzagy zzj;
    private final zzfa zza = new zzfa(6);
    private long zzf = -1;

    private final int zze(zzaax zzaaxVar) throws IOException {
        this.zza.zzC(2);
        ((zzaam) zzaaxVar).zzm(this.zza.zzH(), 0, 2, false);
        return this.zza.zzo();
    }

    private final void zzf() {
        zzg(new zzby[0]);
        zzaaz zzaazVar = this.zzb;
        zzaazVar.getClass();
        zzaazVar.zzC();
        this.zzb.zzN(new zzabu(-9223372036854775807L, 0L));
        this.zzc = 6;
    }

    private final void zzg(zzby... zzbyVarArr) {
        zzaaz zzaazVar = this.zzb;
        zzaazVar.getClass();
        zzabz zzv = zzaazVar.zzv(1024, 4);
        zzak zzakVar = new zzak();
        zzakVar.zzz(ImageUtils.MIME_TYPE_JPEG);
        zzakVar.zzM(new zzbz(-9223372036854775807L, zzbyVarArr));
        zzv.zzk(zzakVar.zzY());
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x015d  */
    @Override // com.google.android.gms.internal.ads.zzaaw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzaax r24, com.google.android.gms.internal.ads.zzabs r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadg.zza(com.google.android.gms.internal.ads.zzaax, com.google.android.gms.internal.ads.zzabs):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zzb = zzaazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzc(long j4, long j5) {
        if (j4 == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzagy zzagyVar = this.zzj;
            zzagyVar.getClass();
            zzagyVar.zzc(j4, j5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        if (zze(zzaaxVar) != 65496) {
            return false;
        }
        int zze = zze(zzaaxVar);
        this.zzd = zze;
        if (zze == 65504) {
            this.zza.zzC(2);
            zzaam zzaamVar = (zzaam) zzaaxVar;
            zzaamVar.zzm(this.zza.zzH(), 0, 2, false);
            zzaamVar.zzl(this.zza.zzo() - 2, false);
            zze = zze(zzaaxVar);
            this.zzd = zze;
        }
        if (zze == 65505) {
            zzaam zzaamVar2 = (zzaam) zzaaxVar;
            zzaamVar2.zzl(2, false);
            this.zza.zzC(6);
            zzaamVar2.zzm(this.zza.zzH(), 0, 6, false);
            if (this.zza.zzs() == 1165519206 && this.zza.zzo() == 0) {
                return true;
            }
        }
        return false;
    }
}
