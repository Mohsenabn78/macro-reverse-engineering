package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
final class zzmo {
    private static final zzmn zza;
    private static final zzmn zzb;

    static {
        zzmn zzmnVar;
        try {
            zzmnVar = (zzmn) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzmnVar = null;
        }
        zza = zzmnVar;
        zzb = new zzmn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmn zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmn zzb() {
        return zzb;
    }
}
