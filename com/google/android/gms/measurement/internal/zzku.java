package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzku extends zzkt {

    /* renamed from: c  reason: collision with root package name */
    private boolean f22017c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzku(zzlh zzlhVar) {
        super(zzlhVar);
        this.f22016b.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        if (b()) {
            return;
        }
        throw new IllegalStateException("Not initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        if (this.f22017c) {
            return true;
        }
        return false;
    }

    protected abstract boolean c();

    public final void zzX() {
        if (!this.f22017c) {
            c();
            this.f22016b.h();
            this.f22017c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
