package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import java.util.concurrent.Callable;

/* compiled from: AdapterViewItemLongClickObservable.java */
/* loaded from: classes6.dex */
final class f extends Observable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34345a;

    /* renamed from: b  reason: collision with root package name */
    private final Callable<Boolean> f34346b;

    /* compiled from: AdapterViewItemLongClickObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements AdapterView.OnItemLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final AdapterView<?> f34347b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Integer> f34348c;

        /* renamed from: d  reason: collision with root package name */
        private final Callable<Boolean> f34349d;

        a(AdapterView<?> adapterView, Observer<? super Integer> observer, Callable<Boolean> callable) {
            this.f34347b = adapterView;
            this.f34348c = observer;
            this.f34349d = callable;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34347b.setOnItemLongClickListener(null);
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (!isDisposed()) {
                try {
                    if (this.f34349d.call().booleanValue()) {
                        this.f34348c.onNext(Integer.valueOf(i4));
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34348c.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AdapterView<?> adapterView, Callable<Boolean> callable) {
        this.f34345a = adapterView;
        this.f34346b = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Integer> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34345a, observer, this.f34346b);
        observer.onSubscribe(aVar);
        this.f34345a.setOnItemLongClickListener(aVar);
    }
}
