package com.google.android.play.core.appupdate.internal;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzad implements zzaf {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f25171c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile zzaf f25172a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f25173b = f25171c;

    private zzad(zzaf zzafVar) {
        this.f25172a = zzafVar;
    }

    public static zzaf zzb(zzaf zzafVar) {
        zzafVar.getClass();
        if (zzafVar instanceof zzad) {
            return zzafVar;
        }
        return new zzad(zzafVar);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        Object obj = this.f25173b;
        Object obj2 = f25171c;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f25173b;
                if (obj == obj2) {
                    obj = this.f25172a.zza();
                    Object obj3 = this.f25173b;
                    if (obj3 != obj2 && obj3 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f25173b = obj;
                    this.f25172a = null;
                }
            }
        }
        return obj;
    }
}
