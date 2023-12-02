package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: TextViewEditorActionEventObservable.java */
/* loaded from: classes6.dex */
final class j0 extends Observable<TextViewEditorActionEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34378a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super TextViewEditorActionEvent> f34379b;

    /* compiled from: TextViewEditorActionEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements TextView.OnEditorActionListener {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f34380b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super TextViewEditorActionEvent> f34381c;

        /* renamed from: d  reason: collision with root package name */
        private final Predicate<? super TextViewEditorActionEvent> f34382d;

        a(TextView textView, Observer<? super TextViewEditorActionEvent> observer, Predicate<? super TextViewEditorActionEvent> predicate) {
            this.f34380b = textView;
            this.f34381c = observer;
            this.f34382d = predicate;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34380b.setOnEditorActionListener(null);
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
            TextViewEditorActionEvent create = TextViewEditorActionEvent.create(this.f34380b, i4, keyEvent);
            try {
                if (!isDisposed() && this.f34382d.test(create)) {
                    this.f34381c.onNext(create);
                    return true;
                }
                return false;
            } catch (Exception e4) {
                this.f34381c.onError(e4);
                dispose();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(TextView textView, Predicate<? super TextViewEditorActionEvent> predicate) {
        this.f34378a = textView;
        this.f34379b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super TextViewEditorActionEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34378a, observer, this.f34379b);
        observer.onSubscribe(aVar);
        this.f34378a.setOnEditorActionListener(aVar);
    }
}
