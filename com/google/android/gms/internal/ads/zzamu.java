package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzamu extends zzgvp {
    private static final zzgvw zza = zzgvw.zzb(zzamu.class);

    public zzamu(zzgvq zzgvqVar, zzamt zzamtVar) throws IOException {
        zzf(zzgvqVar, zzgvqVar.zzc(), zzamtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgvp
    public final String toString() {
        String obj = this.zzd.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgvp, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}
