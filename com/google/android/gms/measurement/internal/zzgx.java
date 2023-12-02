package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgx extends zzgw {

    /* renamed from: b  reason: collision with root package name */
    private boolean f21735b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgx(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21734a.d();
    }

    protected abstract boolean b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (zzy()) {
            return;
        }
        throw new IllegalStateException("Not initialized");
    }

    public final void zzw() {
        if (!this.f21735b) {
            if (!b()) {
                this.f21734a.b();
                this.f21735b = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void zzx() {
        if (!this.f21735b) {
            a();
            this.f21734a.b();
            this.f21735b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzy() {
        if (this.f21735b) {
            return true;
        }
        return false;
    }

    protected void a() {
    }
}
