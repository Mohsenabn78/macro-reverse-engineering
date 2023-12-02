package com.jakewharton.rxbinding2.widget;

import android.widget.PopupMenu;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: PopupMenuDismissObservable.java */
/* loaded from: classes6.dex */
final class y extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final PopupMenu f34442a;

    /* compiled from: PopupMenuDismissObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements PopupMenu.OnDismissListener {

        /* renamed from: b  reason: collision with root package name */
        private final PopupMenu f34443b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Object> f34444c;

        a(PopupMenu popupMenu, Observer<? super Object> observer) {
            this.f34443b = popupMenu;
            this.f34444c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34443b.setOnDismissListener(null);
        }

        @Override // android.widget.PopupMenu.OnDismissListener
        public void onDismiss(PopupMenu popupMenu) {
            if (!isDisposed()) {
                this.f34444c.onNext(Notification.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PopupMenu popupMenu) {
        this.f34442a = popupMenu;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34442a, observer);
        this.f34442a.setOnDismissListener(aVar);
        observer.onSubscribe(aVar);
    }
}
