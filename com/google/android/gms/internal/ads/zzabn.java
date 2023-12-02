package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabn {
    private final zzfa zza = new zzfa(10);

    @Nullable
    public final zzbz zza(zzaax zzaaxVar, @Nullable zzaek zzaekVar) throws IOException {
        zzbz zzbzVar = null;
        int i4 = 0;
        while (true) {
            try {
                ((zzaam) zzaaxVar).zzm(this.zza.zzH(), 0, 10, false);
                this.zza.zzF(0);
                if (this.zza.zzm() != 4801587) {
                    break;
                }
                this.zza.zzG(3);
                int zzj = this.zza.zzj();
                int i5 = zzj + 10;
                if (zzbzVar == null) {
                    byte[] bArr = new byte[i5];
                    System.arraycopy(this.zza.zzH(), 0, bArr, 0, 10);
                    ((zzaam) zzaaxVar).zzm(bArr, 10, zzj, false);
                    zzbzVar = zzaem.zza(bArr, i5, zzaekVar, new zzadn());
                } else {
                    ((zzaam) zzaaxVar).zzl(zzj, false);
                }
                i4 += i5;
            } catch (EOFException unused) {
            }
        }
        zzaaxVar.zzj();
        ((zzaam) zzaaxVar).zzl(i4, false);
        return zzbzVar;
    }
}
