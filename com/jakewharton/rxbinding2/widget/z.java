package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: PopupMenuItemClickObservable.java */
/* loaded from: classes6.dex */
final class z extends Observable<MenuItem> {

    /* renamed from: a  reason: collision with root package name */
    private final PopupMenu f34445a;

    /* compiled from: PopupMenuItemClickObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements PopupMenu.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final PopupMenu f34446b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super MenuItem> f34447c;

        a(PopupMenu popupMenu, Observer<? super MenuItem> observer) {
            this.f34446b = popupMenu;
            this.f34447c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34446b.setOnMenuItemClickListener(null);
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (!isDisposed()) {
                this.f34447c.onNext(menuItem);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PopupMenu popupMenu) {
        this.f34445a = popupMenu;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super MenuItem> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34445a, observer);
        this.f34445a.setOnMenuItemClickListener(aVar);
        observer.onSubscribe(aVar);
    }
}
