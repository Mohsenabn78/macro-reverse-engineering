package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: MenuItemActionViewEventObservable.java */
/* loaded from: classes6.dex */
final class i extends Observable<MenuItemActionViewEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final MenuItem f34208a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super MenuItemActionViewEvent> f34209b;

    /* compiled from: MenuItemActionViewEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements MenuItem.OnActionExpandListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem f34210b;

        /* renamed from: c  reason: collision with root package name */
        private final Predicate<? super MenuItemActionViewEvent> f34211c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super MenuItemActionViewEvent> f34212d;

        a(MenuItem menuItem, Predicate<? super MenuItemActionViewEvent> predicate, Observer<? super MenuItemActionViewEvent> observer) {
            this.f34210b = menuItem;
            this.f34211c = predicate;
            this.f34212d = observer;
        }

        private boolean b(MenuItemActionViewEvent menuItemActionViewEvent) {
            if (!isDisposed()) {
                try {
                    if (this.f34211c.test(menuItemActionViewEvent)) {
                        this.f34212d.onNext(menuItemActionViewEvent);
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34212d.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34210b.setOnActionExpandListener(null);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return b(MenuItemActionViewCollapseEvent.create(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return b(MenuItemActionViewExpandEvent.create(menuItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MenuItem menuItem, Predicate<? super MenuItemActionViewEvent> predicate) {
        this.f34208a = menuItem;
        this.f34209b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super MenuItemActionViewEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34208a, this.f34209b, observer);
        observer.onSubscribe(aVar);
        this.f34208a.setOnActionExpandListener(aVar);
    }
}
