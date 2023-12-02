package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbe  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzbe {
    private final InputStream zza;

    private zzbe(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzbe zzc(byte[] bArr) {
        return new zzbe(new ByteArrayInputStream(bArr));
    }

    public final zzry zza() throws IOException {
        try {
            return zzry.zzc(this.zza, zzagq.zza());
        } finally {
            this.zza.close();
        }
    }

    public final zztp zzb() throws IOException {
        try {
            return zztp.zzf(this.zza, zzagq.zza());
        } finally {
            this.zza.close();
        }
    }
}
