package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzacm implements zzaaw {
    private int zzc;
    private zzacn zze;
    private long zzh;
    @Nullable
    private zzacp zzi;
    private int zzm;
    private boolean zzn;
    private final zzfa zza = new zzfa(12);
    private final zzacl zzb = new zzacl(null);
    private zzaaz zzd = new zzaau();
    private zzacp[] zzg = new zzacp[0];
    private long zzk = -1;
    private long zzl = -1;
    private int zzj = -1;
    private long zzf = -9223372036854775807L;

    @Nullable
    private final zzacp zzf(int i4) {
        zzacp[] zzacpVarArr;
        for (zzacp zzacpVar : this.zzg) {
            if (zzacpVar.zzg(i4)) {
                return zzacpVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    @Override // com.google.android.gms.internal.ads.zzaaw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzaax r24, com.google.android.gms.internal.ads.zzabs r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 973
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacm.zza(com.google.android.gms.internal.ads.zzaax, com.google.android.gms.internal.ads.zzabs):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zzc = 0;
        this.zzd = zzaazVar;
        this.zzh = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzc(long j4, long j5) {
        int i4;
        this.zzh = -1L;
        this.zzi = null;
        for (zzacp zzacpVar : this.zzg) {
            zzacpVar.zzf(j4);
        }
        if (j4 == 0) {
            if (this.zzg.length == 0) {
                this.zzc = 0;
                return;
            }
            i4 = 3;
        } else {
            i4 = 6;
        }
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        ((zzaam) zzaaxVar).zzm(this.zza.zzH(), 0, 12, false);
        this.zza.zzF(0);
        if (this.zza.zzg() != 1179011410) {
            return false;
        }
        this.zza.zzG(4);
        if (this.zza.zzg() != 541677121) {
            return false;
        }
        return true;
    }
}
