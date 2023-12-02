package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzahk extends zzahu {
    @Nullable
    private zzabj zza;
    @Nullable
    private zzahj zzb;

    private static boolean zzd(byte[] bArr) {
        if (bArr[0] != -1) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    protected final long zza(zzfa zzfaVar) {
        if (zzd(zzfaVar.zzH())) {
            int i4 = (zzfaVar.zzH()[2] & 255) >> 4;
            if (i4 != 6) {
                if (i4 == 7) {
                    i4 = 7;
                }
                int zza = zzabf.zza(zzfaVar, i4);
                zzfaVar.zzF(0);
                return zza;
            }
            zzfaVar.zzG(4);
            zzfaVar.zzu();
            int zza2 = zzabf.zza(zzfaVar, i4);
            zzfaVar.zzF(0);
            return zza2;
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zzb(boolean z3) {
        super.zzb(z3);
        if (z3) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfa zzfaVar, long j4, zzahr zzahrVar) {
        byte[] zzH = zzfaVar.zzH();
        zzabj zzabjVar = this.zza;
        if (zzabjVar == null) {
            zzabj zzabjVar2 = new zzabj(zzH, 17);
            this.zza = zzabjVar2;
            zzahrVar.zza = zzabjVar2.zzc(Arrays.copyOfRange(zzH, 9, zzfaVar.zzd()), null);
            return true;
        } else if ((zzH[0] & Byte.MAX_VALUE) == 3) {
            zzabi zzb = zzabg.zzb(zzfaVar);
            zzabj zzf = zzabjVar.zzf(zzb);
            this.zza = zzf;
            this.zzb = new zzahj(zzf, zzb);
            return true;
        } else if (!zzd(zzH)) {
            return true;
        } else {
            zzahj zzahjVar = this.zzb;
            if (zzahjVar != null) {
                zzahjVar.zza(j4);
                zzahrVar.zzb = this.zzb;
            }
            zzahrVar.zza.getClass();
            return false;
        }
    }
}
