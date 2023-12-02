package com.koushikdutta.async.future;

/* loaded from: classes6.dex */
public class SimpleCancellable implements DependentCancellable {
    public static final Cancellable COMPLETED = new a();

    /* renamed from: a  reason: collision with root package name */
    boolean f34884a;

    /* renamed from: b  reason: collision with root package name */
    boolean f34885b;

    /* renamed from: c  reason: collision with root package name */
    private Cancellable f34886c;

    /* loaded from: classes6.dex */
    static class a extends SimpleCancellable {
        a() {
            setComplete();
        }

        @Override // com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.DependentCancellable
        public /* bridge */ /* synthetic */ DependentCancellable setParent(Cancellable cancellable) {
            return super.setParent(cancellable);
        }
    }

    @Override // com.koushikdutta.async.future.Cancellable
    public boolean cancel() {
        synchronized (this) {
            if (this.f34884a) {
                return false;
            }
            if (this.f34885b) {
                return true;
            }
            this.f34885b = true;
            Cancellable cancellable = this.f34886c;
            this.f34886c = null;
            if (cancellable != null) {
                cancellable.cancel();
            }
            a();
            b();
            return true;
        }
    }

    @Override // com.koushikdutta.async.future.Cancellable
    public boolean isCancelled() {
        boolean z3;
        Cancellable cancellable;
        synchronized (this) {
            if (!this.f34885b && ((cancellable = this.f34886c) == null || !cancellable.isCancelled())) {
                z3 = false;
            }
            z3 = true;
        }
        return z3;
    }

    @Override // com.koushikdutta.async.future.Cancellable
    public boolean isDone() {
        return this.f34884a;
    }

    public Cancellable reset() {
        cancel();
        this.f34884a = false;
        this.f34885b = false;
        return this;
    }

    public boolean setComplete() {
        synchronized (this) {
            if (this.f34885b) {
                return false;
            }
            if (this.f34884a) {
                return true;
            }
            this.f34884a = true;
            this.f34886c = null;
            c();
            b();
            return true;
        }
    }

    @Override // com.koushikdutta.async.future.DependentCancellable
    public SimpleCancellable setParent(Cancellable cancellable) {
        synchronized (this) {
            if (!isDone()) {
                this.f34886c = cancellable;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
    }

    protected void c() {
    }
}
