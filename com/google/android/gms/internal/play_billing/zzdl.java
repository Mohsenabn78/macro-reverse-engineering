package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
final class zzdl {
    private static final zzdk zza;
    private static final zzdk zzb;

    static {
        zzdk zzdkVar;
        try {
            zzdkVar = (zzdk) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzdkVar = null;
        }
        zza = zzdkVar;
        zzb = new zzdk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdk zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdk zzb() {
        return zzb;
    }
}
