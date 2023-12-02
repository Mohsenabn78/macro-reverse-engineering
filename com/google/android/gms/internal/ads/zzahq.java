package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzahq extends zzahu {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    public static boolean zzd(zzfa zzfaVar) {
        return zzk(zzfaVar, zza);
    }

    private static boolean zzk(zzfa zzfaVar, byte[] bArr) {
        if (zzfaVar.zza() < 8) {
            return false;
        }
        int zzc = zzfaVar.zzc();
        byte[] bArr2 = new byte[8];
        zzfaVar.zzB(bArr2, 0, 8);
        zzfaVar.zzF(zzc);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    protected final long zza(zzfa zzfaVar) {
        return zzg(zzabr.zzc(zzfaVar.zzH()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zzb(boolean z3) {
        super.zzb(z3);
        if (z3) {
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfa zzfaVar, long j4, zzahr zzahrVar) throws zzcd {
        if (zzk(zzfaVar, zza)) {
            byte[] copyOf = Arrays.copyOf(zzfaVar.zzH(), zzfaVar.zzd());
            int i4 = copyOf[9] & 255;
            List zzd = zzabr.zzd(copyOf);
            if (zzahrVar.zza != null) {
                return true;
            }
            zzak zzakVar = new zzak();
            zzakVar.zzS("audio/opus");
            zzakVar.zzw(i4);
            zzakVar.zzT(48000);
            zzakVar.zzI(zzd);
            zzahrVar.zza = zzakVar.zzY();
            return true;
        } else if (zzk(zzfaVar, zzb)) {
            zzdy.zzb(zzahrVar.zza);
            if (this.zzc) {
                return true;
            }
            this.zzc = true;
            zzfaVar.zzG(8);
            zzbz zzb2 = zzacf.zzb(zzfsc.zzk(zzacf.zzc(zzfaVar, false, false).zzb));
            if (zzb2 == null) {
                return true;
            }
            zzak zzb3 = zzahrVar.zza.zzb();
            zzb3.zzM(zzb2.zzd(zzahrVar.zza.zzk));
            zzahrVar.zza = zzb3.zzY();
            return true;
        } else {
            zzdy.zzb(zzahrVar.zza);
            return false;
        }
    }
}
