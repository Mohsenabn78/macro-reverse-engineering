package com.koushikdutta.async.future;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import java.util.LinkedList;

/* loaded from: classes6.dex */
public class Continuation extends SimpleCancellable implements ContinuationCallback, Runnable, Cancellable {

    /* renamed from: d  reason: collision with root package name */
    CompletedCallback f34859d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f34860e;

    /* renamed from: f  reason: collision with root package name */
    LinkedList<ContinuationCallback> f34861f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f34862g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f34863h;

    /* renamed from: i  reason: collision with root package name */
    boolean f34864i;

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Cancellable f34865a;

        a(Cancellable cancellable) {
            this.f34865a = cancellable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34865a.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        boolean f34867a;

        b() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (this.f34867a) {
                return;
            }
            this.f34867a = true;
            Continuation.this.f34863h = false;
            if (exc == null) {
                Continuation.this.g();
            } else {
                Continuation.this.h(exc);
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements ContinuationCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DependentFuture f34869a;

        c(DependentFuture dependentFuture) {
            this.f34869a = dependentFuture;
        }

        @Override // com.koushikdutta.async.callback.ContinuationCallback
        public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
            this.f34869a.get();
            completedCallback.onCompleted(null);
        }
    }

    public Continuation() {
        this(null);
    }

    private ContinuationCallback f(ContinuationCallback continuationCallback) {
        if (continuationCallback instanceof DependentCancellable) {
            ((DependentCancellable) continuationCallback).setParent(this);
        }
        return continuationCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f34862g) {
            return;
        }
        while (this.f34861f.size() > 0 && !this.f34863h && !isDone() && !isCancelled()) {
            ContinuationCallback remove = this.f34861f.remove();
            try {
                try {
                    this.f34862g = true;
                    this.f34863h = true;
                    remove.onContinue(this, i());
                } catch (Exception e4) {
                    h(e4);
                }
            } finally {
                this.f34862g = false;
            }
        }
        if (this.f34863h || isDone() || isCancelled()) {
            return;
        }
        h(null);
    }

    private CompletedCallback i() {
        return new b();
    }

    public Continuation add(ContinuationCallback continuationCallback) {
        this.f34861f.add(f(continuationCallback));
        return this;
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.Cancellable
    public boolean cancel() {
        if (!super.cancel()) {
            return false;
        }
        Runnable runnable = this.f34860e;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        return true;
    }

    public CompletedCallback getCallback() {
        return this.f34859d;
    }

    public Runnable getCancelCallback() {
        return this.f34860e;
    }

    void h(Exception exc) {
        CompletedCallback completedCallback;
        if (setComplete() && (completedCallback = this.f34859d) != null) {
            completedCallback.onCompleted(exc);
        }
    }

    public Continuation insert(ContinuationCallback continuationCallback) {
        this.f34861f.add(0, f(continuationCallback));
        return this;
    }

    @Override // com.koushikdutta.async.callback.ContinuationCallback
    public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
        setCallback(completedCallback);
        start();
    }

    @Override // java.lang.Runnable
    public void run() {
        start();
    }

    public void setCallback(CompletedCallback completedCallback) {
        this.f34859d = completedCallback;
    }

    public void setCancelCallback(Runnable runnable) {
        this.f34860e = runnable;
    }

    public Continuation start() {
        if (!this.f34864i) {
            this.f34864i = true;
            g();
            return this;
        }
        throw new IllegalStateException("already started");
    }

    public Continuation(CompletedCallback completedCallback) {
        this(completedCallback, null);
    }

    public Continuation add(DependentFuture dependentFuture) {
        dependentFuture.setParent(this);
        add(new c(dependentFuture));
        return this;
    }

    public void setCancelCallback(Cancellable cancellable) {
        if (cancellable == null) {
            this.f34860e = null;
        } else {
            this.f34860e = new a(cancellable);
        }
    }

    public Continuation(CompletedCallback completedCallback, Runnable runnable) {
        this.f34861f = new LinkedList<>();
        this.f34860e = runnable;
        this.f34859d = completedCallback;
    }
}
