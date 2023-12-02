package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagy  reason: invalid package */
/* loaded from: classes4.dex */
final class zzagy implements zzaig {
    private static final zzagy zza = new zzagy();

    private zzagy() {
    }

    public static zzagy zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaig
    public final zzaif zzb(Class cls) {
        if (zzahd.class.isAssignableFrom(cls)) {
            try {
                return (zzaif) zzahd.zzv(cls.asSubclass(zzahd.class)).zzj(3, null, null);
            } catch (Exception e4) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e4);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaig
    public final boolean zzc(Class cls) {
        return zzahd.class.isAssignableFrom(cls);
    }
}
