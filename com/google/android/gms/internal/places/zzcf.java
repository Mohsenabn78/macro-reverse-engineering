package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
final class zzcf {
    private static final zzcd zzko = zzci();
    private static final zzcd zzkp = new zzcg();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcd zzcg() {
        return zzko;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcd zzch() {
        return zzkp;
    }

    private static zzcd zzci() {
        try {
            return (zzcd) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
