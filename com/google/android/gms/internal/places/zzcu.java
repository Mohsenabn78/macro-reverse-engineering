package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
final class zzcu {
    private static final zzcs zzlj = zzcp();
    private static final zzcs zzlk = new zzcr();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcs zzcn() {
        return zzlj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcs zzco() {
        return zzlk;
    }

    private static zzcs zzcp() {
        try {
            return (zzcs) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
