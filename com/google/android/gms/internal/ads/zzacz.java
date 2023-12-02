package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzacz extends zzade {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzacz(zzabz zzabzVar) {
        super(zzabzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    protected final boolean zza(zzfa zzfaVar) throws zzadd {
        String str;
        if (!this.zzc) {
            int zzk = zzfaVar.zzk();
            int i4 = zzk >> 4;
            this.zze = i4;
            if (i4 == 2) {
                int i5 = zzb[(zzk >> 2) & 3];
                zzak zzakVar = new zzak();
                zzakVar.zzS("audio/mpeg");
                zzakVar.zzw(1);
                zzakVar.zzT(i5);
                this.zza.zzk(zzakVar.zzY());
                this.zzd = true;
            } else if (i4 != 7 && i4 != 8) {
                if (i4 != 10) {
                    throw new zzadd("Audio format not supported: " + i4);
                }
            } else {
                zzak zzakVar2 = new zzak();
                if (i4 == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                zzakVar2.zzS(str);
                zzakVar2.zzw(1);
                zzakVar2.zzT(ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED);
                this.zza.zzk(zzakVar2.zzY());
                this.zzd = true;
            }
            this.zzc = true;
        } else {
            zzfaVar.zzG(1);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    protected final boolean zzb(zzfa zzfaVar, long j4) throws zzcd {
        if (this.zze == 2) {
            int zza = zzfaVar.zza();
            this.zza.zzq(zzfaVar, zza);
            this.zza.zzs(j4, 1, zza, 0, null);
            return true;
        }
        int zzk = zzfaVar.zzk();
        if (zzk == 0 && !this.zzd) {
            int zza2 = zzfaVar.zza();
            byte[] bArr = new byte[zza2];
            zzfaVar.zzB(bArr, 0, zza2);
            zzzt zza3 = zzzu.zza(bArr);
            zzak zzakVar = new zzak();
            zzakVar.zzS("audio/mp4a-latm");
            zzakVar.zzx(zza3.zzc);
            zzakVar.zzw(zza3.zzb);
            zzakVar.zzT(zza3.zza);
            zzakVar.zzI(Collections.singletonList(bArr));
            this.zza.zzk(zzakVar.zzY());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzk != 1) {
            return false;
        } else {
            int zza4 = zzfaVar.zza();
            this.zza.zzq(zzfaVar, zza4);
            this.zza.zzs(j4, 1, zza4, 0, null);
            return true;
        }
    }
}
