package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbf  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzbf implements zzcb {
    private final OutputStream zza;

    private zzbf(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzcb zza(OutputStream outputStream) {
        return new zzbf(outputStream);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final void zzb(zzry zzryVar) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final void zzc(zztp zztpVar) throws IOException {
        try {
            zztpVar.zzp(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
