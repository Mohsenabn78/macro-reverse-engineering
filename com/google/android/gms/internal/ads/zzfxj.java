package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfxj {
    private final OutputStream zza;

    private zzfxj(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzfxj zzb(OutputStream outputStream) {
        return new zzfxj(outputStream);
    }

    public final void zza(zzgkx zzgkxVar) throws IOException {
        try {
            zzgkxVar.zzaw(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
