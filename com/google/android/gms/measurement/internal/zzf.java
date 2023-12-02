package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzf extends zze {

    /* renamed from: b  reason: collision with root package name */
    private boolean f21561b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21734a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        if (this.f21561b) {
            return true;
        }
        return false;
    }

    protected abstract boolean c();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza() {
        if (b()) {
            return;
        }
        throw new IllegalStateException("Not initialized");
    }

    public final void zzb() {
        if (!this.f21561b) {
            if (!c()) {
                this.f21734a.b();
                this.f21561b = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void zzc() {
        if (!this.f21561b) {
            a();
            this.f21734a.b();
            this.f21561b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    @WorkerThread
    protected void a() {
    }
}
