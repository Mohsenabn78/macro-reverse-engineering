package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzgvm extends zzgvp implements zzamw {
    zzamx zza;
    protected final String zzb = "moov";

    public zzgvm(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamw
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzamw
    public final void zzb(zzgvq zzgvqVar, ByteBuffer byteBuffer, long j4, zzamt zzamtVar) throws IOException {
        zzgvqVar.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzd = zzgvqVar;
        this.zzf = zzgvqVar.zzb();
        zzgvqVar.zze(zzgvqVar.zzb() + j4);
        this.zzg = zzgvqVar.zzb();
        this.zzc = zzamtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamw
    public final void zzc(zzamx zzamxVar) {
        this.zza = zzamxVar;
    }
}
