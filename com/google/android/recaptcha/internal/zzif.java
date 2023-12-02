package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzif {
    private static final zzie zza;
    private static final zzie zzb;

    static {
        zzie zzieVar;
        try {
            zzieVar = (zzie) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzieVar = null;
        }
        zza = zzieVar;
        zzb = new zzie();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzie zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzie zzb() {
        return zzb;
    }
}
