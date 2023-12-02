package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajn  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzajn extends RuntimeException {
    public zzajn(zzaii zzaiiVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzahl zza() {
        return new zzahl(getMessage());
    }
}
