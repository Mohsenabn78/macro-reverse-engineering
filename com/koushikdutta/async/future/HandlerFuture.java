package com.koushikdutta.async.future;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes6.dex */
public class HandlerFuture<T> extends SimpleFuture<T> {

    /* renamed from: i  reason: collision with root package name */
    Handler f34875i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements FutureCallback<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FutureCallback f34876a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.koushikdutta.async.future.HandlerFuture$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0181a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Exception f34878a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f34879b;

            RunnableC0181a(Exception exc, Object obj) {
                this.f34878a = exc;
                this.f34879b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                a.this.onCompleted(this.f34878a, this.f34879b);
            }
        }

        a(FutureCallback futureCallback) {
            this.f34876a = futureCallback;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        public void onCompleted(Exception exc, T t3) {
            if (Looper.myLooper() == HandlerFuture.this.f34875i.getLooper()) {
                this.f34876a.onCompleted(exc, t3);
            } else {
                HandlerFuture.this.f34875i.post(new RunnableC0181a(exc, t3));
            }
        }
    }

    public HandlerFuture() {
        Looper myLooper = Looper.myLooper();
        this.f34875i = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper);
    }

    @Override // com.koushikdutta.async.future.SimpleFuture, com.koushikdutta.async.future.Future
    public SimpleFuture<T> setCallback(FutureCallback<T> futureCallback) {
        return super.setCallback((FutureCallback) new a(futureCallback));
    }
}
