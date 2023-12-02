package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmi  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzmi extends RuntimeException {
    public zzmi(String str) {
        super(str);
    }

    public static Object zza(zzmh zzmhVar) {
        try {
            return zzmhVar.zza();
        } catch (Exception e4) {
            throw new zzmi(e4);
        }
    }

    public zzmi(String str, Throwable th) {
        super(str, th);
    }

    public zzmi(Throwable th) {
        super(th);
    }
}
