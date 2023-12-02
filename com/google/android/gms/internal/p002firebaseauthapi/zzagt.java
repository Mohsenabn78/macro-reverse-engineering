package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagt  reason: invalid package */
/* loaded from: classes4.dex */
final class zzagt {
    private static final zzagr zza = new zzags();
    private static final zzagr zzb;

    static {
        zzagr zzagrVar;
        try {
            zzagrVar = (zzagr) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzagrVar = null;
        }
        zzb = zzagrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzagr zza() {
        zzagr zzagrVar = zzb;
        if (zzagrVar != null) {
            return zzagrVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzagr zzb() {
        return zza;
    }
}
