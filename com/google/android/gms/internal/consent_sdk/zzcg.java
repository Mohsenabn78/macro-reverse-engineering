package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzcg<T> implements zzcl<T> {
    private static final Object zza = new Object();
    private volatile zzcl<T> zzb;
    private volatile Object zzc = zza;

    private zzcg(zzcl<T> zzclVar) {
        this.zzb = zzclVar;
    }

    public static <P extends zzcl<T>, T> zzcl<T> zza(P p4) {
        p4.getClass();
        if (p4 instanceof zzcg) {
            return p4;
        }
        return new zzcg(p4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzcl
    public final T zzb() {
        T t3 = (T) this.zzc;
        Object obj = zza;
        if (t3 == obj) {
            synchronized (this) {
                t3 = this.zzc;
                if (t3 == obj) {
                    t3 = this.zzb.zzb();
                    Object obj2 = this.zzc;
                    if (obj2 != obj && !(obj2 instanceof zzcj) && obj2 != t3) {
                        String valueOf = String.valueOf(obj2);
                        String valueOf2 = String.valueOf(t3);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.zzc = t3;
                    this.zzb = null;
                }
            }
        }
        return t3;
    }
}
