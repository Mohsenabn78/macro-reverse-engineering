package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzahm implements zzaaw {
    public static final zzabd zza = new zzabd() { // from class: com.google.android.gms.internal.ads.zzahl
        @Override // com.google.android.gms.internal.ads.zzabd
        public final /* synthetic */ zzaaw[] zza(Uri uri, Map map) {
            int i4 = zzabc.zza;
            return new zzaaw[]{new zzahm()};
        }
    };
    private zzaaz zzb;
    private zzahu zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zze(zzaax zzaaxVar) throws IOException {
        zzaho zzahoVar = new zzaho();
        if (zzahoVar.zzb(zzaaxVar, true) && (zzahoVar.zza & 2) == 2) {
            int min = Math.min(zzahoVar.zze, 8);
            zzfa zzfaVar = new zzfa(min);
            ((zzaam) zzaaxVar).zzm(zzfaVar.zzH(), 0, min, false);
            zzfaVar.zzF(0);
            if (zzfaVar.zza() >= 5 && zzfaVar.zzk() == 127 && zzfaVar.zzs() == 1179402563) {
                this.zzc = new zzahk();
            } else {
                zzfaVar.zzF(0);
                try {
                    if (zzacf.zzd(1, zzfaVar, true)) {
                        this.zzc = new zzahw();
                    }
                } catch (zzcd unused) {
                }
                zzfaVar.zzF(0);
                if (zzahq.zzd(zzfaVar)) {
                    this.zzc = new zzahq();
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final int zza(zzaax zzaaxVar, zzabs zzabsVar) throws IOException {
        zzdy.zzb(this.zzb);
        if (this.zzc == null) {
            if (zze(zzaaxVar)) {
                zzaaxVar.zzj();
            } else {
                throw zzcd.zza("Failed to determine bitstream type", null);
            }
        }
        if (!this.zzd) {
            zzabz zzv = this.zzb.zzv(0, 1);
            this.zzb.zzC();
            this.zzc.zzh(this.zzb, zzv);
            this.zzd = true;
        }
        return this.zzc.zze(zzaaxVar, zzabsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zzb = zzaazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzc(long j4, long j5) {
        zzahu zzahuVar = this.zzc;
        if (zzahuVar != null) {
            zzahuVar.zzj(j4, j5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        try {
            return zze(zzaaxVar);
        } catch (zzcd unused) {
            return false;
        }
    }
}
