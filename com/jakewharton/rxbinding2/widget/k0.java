package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: TextViewEditorActionObservable.java */
/* loaded from: classes6.dex */
final class k0 extends Observable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34387a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super Integer> f34388b;

    /* compiled from: TextViewEditorActionObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements TextView.OnEditorActionListener {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f34389b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Integer> f34390c;

        /* renamed from: d  reason: collision with root package name */
        private final Predicate<? super Integer> f34391d;

        a(TextView textView, Observer<? super Integer> observer, Predicate<? super Integer> predicate) {
            this.f34389b = textView;
            this.f34390c = observer;
            this.f34391d = predicate;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34389b.setOnEditorActionListener(null);
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
            try {
                if (!isDisposed() && this.f34391d.test(Integer.valueOf(i4))) {
                    this.f34390c.onNext(Integer.valueOf(i4));
                    return true;
                }
                return false;
            } catch (Exception e4) {
                this.f34390c.onError(e4);
                dispose();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(TextView textView, Predicate<? super Integer> predicate) {
        this.f34387a = textView;
        this.f34388b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Integer> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34387a, observer, this.f34388b);
        observer.onSubscribe(aVar);
        this.f34387a.setOnEditorActionListener(aVar);
    }
}
