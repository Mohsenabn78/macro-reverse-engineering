package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzgc {
    private static final zzga zza = new zzgb();
    private static final zzga zzb;

    static {
        zzga zzgaVar;
        try {
            zzgaVar = (zzga) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgaVar = null;
        }
        zzb = zzgaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzga zza() {
        zzga zzgaVar = zzb;
        if (zzgaVar != null) {
            return zzgaVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzga zzb() {
        return zza;
    }
}
