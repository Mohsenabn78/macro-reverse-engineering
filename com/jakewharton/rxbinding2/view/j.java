package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: MenuItemClickOnSubscribe.java */
/* loaded from: classes6.dex */
final class j extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final MenuItem f34213a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super MenuItem> f34214b;

    /* compiled from: MenuItemClickOnSubscribe.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem f34215b;

        /* renamed from: c  reason: collision with root package name */
        private final Predicate<? super MenuItem> f34216c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super Object> f34217d;

        a(MenuItem menuItem, Predicate<? super MenuItem> predicate, Observer<? super Object> observer) {
            this.f34215b = menuItem;
            this.f34216c = predicate;
            this.f34217d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34215b.setOnMenuItemClickListener(null);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (!isDisposed()) {
                try {
                    if (this.f34216c.test(this.f34215b)) {
                        this.f34217d.onNext(Notification.INSTANCE);
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34217d.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MenuItem menuItem, Predicate<? super MenuItem> predicate) {
        this.f34213a = menuItem;
        this.f34214b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34213a, this.f34214b, observer);
        observer.onSubscribe(aVar);
        this.f34213a.setOnMenuItemClickListener(aVar);
    }
}
