package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
final class zzdb {
    private static final zzda zza;
    private static final zzda zzb;

    static {
        zzda zzdaVar;
        try {
            zzdaVar = (zzda) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzdaVar = null;
        }
        zza = zzdaVar;
        zzb = new zzda();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzda zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzda zzb() {
        return zzb;
    }
}
