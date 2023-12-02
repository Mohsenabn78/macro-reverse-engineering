package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class z implements ac {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f25365c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile ac f25366a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f25367b = f25365c;

    private z(ac acVar) {
        this.f25366a = acVar;
    }

    public static ac b(ac acVar) {
        acVar.getClass();
        if (acVar instanceof z) {
            return acVar;
        }
        return new z(acVar);
    }

    @Override // com.google.android.play.integrity.internal.ac
    public final Object a() {
        Object obj = this.f25367b;
        Object obj2 = f25365c;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f25367b;
                if (obj == obj2) {
                    obj = this.f25366a.a();
                    Object obj3 = this.f25367b;
                    if (obj3 != obj2 && obj3 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f25367b = obj;
                    this.f25366a = null;
                }
            }
        }
        return obj;
    }
}
