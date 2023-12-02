package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.Toolbar;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ToolbarNavigationClickObservable.java */
@RequiresApi(21)
/* loaded from: classes6.dex */
final class o0 extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Toolbar f34413a;

    /* compiled from: ToolbarNavigationClickObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final Toolbar f34414b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Object> f34415c;

        a(Toolbar toolbar, Observer<? super Object> observer) {
            this.f34414b = toolbar;
            this.f34415c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34414b.setNavigationOnClickListener(null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!isDisposed()) {
                this.f34415c.onNext(Notification.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(Toolbar toolbar) {
        this.f34413a = toolbar;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34413a, observer);
        observer.onSubscribe(aVar);
        this.f34413a.setNavigationOnClickListener(aVar);
    }
}
