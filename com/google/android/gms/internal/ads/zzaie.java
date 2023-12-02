package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaie implements zzaaw {
    public static final zzabd zza = new zzabd() { // from class: com.google.android.gms.internal.ads.zzaid
        @Override // com.google.android.gms.internal.ads.zzabd
        public final /* synthetic */ zzaaw[] zza(Uri uri, Map map) {
            int i4 = zzabc.zza;
            return new zzaaw[]{new zzaie(0)};
        }
    };
    private final zzaif zzb;
    private final zzfa zzc;
    private final zzfa zzd;
    private final zzez zze;
    private zzaaz zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;

    public zzaie() {
        this(0);
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final int zza(zzaax zzaaxVar, zzabs zzabsVar) throws IOException {
        zzdy.zzb(this.zzf);
        int zza2 = zzaaxVar.zza(this.zzc.zzH(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzN(new zzabu(-9223372036854775807L, 0L));
            this.zzj = true;
        }
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzF(0);
        this.zzc.zzE(zza2);
        if (!this.zzi) {
            this.zzb.zzd(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zzf = zzaazVar;
        this.zzb.zzb(zzaazVar, new zzajv(Integer.MIN_VALUE, 0, 1));
        zzaazVar.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzc(long j4, long j5) {
        this.zzi = false;
        this.zzb.zze();
        this.zzg = j5;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        int i4 = 0;
        while (true) {
            zzaam zzaamVar = (zzaam) zzaaxVar;
            zzaamVar.zzm(this.zzd.zzH(), 0, 10, false);
            this.zzd.zzF(0);
            if (this.zzd.zzm() != 4801587) {
                break;
            }
            this.zzd.zzG(3);
            int zzj = this.zzd.zzj();
            i4 += zzj + 10;
            zzaamVar.zzl(zzj, false);
        }
        zzaaxVar.zzj();
        zzaam zzaamVar2 = (zzaam) zzaaxVar;
        zzaamVar2.zzl(i4, false);
        if (this.zzh == -1) {
            this.zzh = i4;
        }
        int i5 = i4;
        int i6 = 0;
        int i7 = 0;
        do {
            zzaamVar2.zzm(this.zzd.zzH(), 0, 2, false);
            this.zzd.zzF(0);
            if (!zzaif.zzf(this.zzd.zzo())) {
                i5++;
                zzaaxVar.zzj();
                zzaamVar2.zzl(i5, false);
            } else {
                i6++;
                if (i6 >= 4 && i7 > 188) {
                    return true;
                }
                zzaamVar2.zzm(this.zzd.zzH(), 0, 4, false);
                this.zze.zzj(14);
                int zzd = this.zze.zzd(13);
                if (zzd <= 6) {
                    i5++;
                    zzaaxVar.zzj();
                    zzaamVar2.zzl(i5, false);
                } else {
                    zzaamVar2.zzl(zzd - 6, false);
                    i7 += zzd;
                }
            }
            i6 = 0;
            i7 = 0;
        } while (i5 - i4 < 8192);
        return false;
    }

    public zzaie(int i4) {
        this.zzb = new zzaif(true, null);
        this.zzc = new zzfa(2048);
        this.zzh = -1L;
        zzfa zzfaVar = new zzfa(10);
        this.zzd = zzfaVar;
        byte[] zzH = zzfaVar.zzH();
        this.zze = new zzez(zzH, zzH.length);
    }
}
