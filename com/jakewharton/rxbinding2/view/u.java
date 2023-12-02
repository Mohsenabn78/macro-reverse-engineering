package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import java.util.concurrent.Callable;

/* compiled from: ViewLongClickObservable.java */
/* loaded from: classes6.dex */
final class u extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34256a;

    /* renamed from: b  reason: collision with root package name */
    private final Callable<Boolean> f34257b;

    /* compiled from: ViewLongClickObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34258b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Object> f34259c;

        /* renamed from: d  reason: collision with root package name */
        private final Callable<Boolean> f34260d;

        a(View view, Callable<Boolean> callable, Observer<? super Object> observer) {
            this.f34258b = view;
            this.f34259c = observer;
            this.f34260d = callable;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34258b.setOnLongClickListener(null);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!isDisposed()) {
                try {
                    if (this.f34260d.call().booleanValue()) {
                        this.f34259c.onNext(Notification.INSTANCE);
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34259c.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(View view, Callable<Boolean> callable) {
        this.f34256a = view;
        this.f34257b = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34256a, this.f34257b, observer);
        observer.onSubscribe(aVar);
        this.f34256a.setOnLongClickListener(aVar);
    }
}
