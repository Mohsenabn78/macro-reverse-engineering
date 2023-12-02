package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzek {
    private static final zzej zza;
    private static final zzej zzb;

    static {
        zzej zzejVar;
        try {
            zzejVar = (zzej) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzejVar = null;
        }
        zza = zzejVar;
        zzb = new zzej();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzej zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzej zzb() {
        return zzb;
    }
}
