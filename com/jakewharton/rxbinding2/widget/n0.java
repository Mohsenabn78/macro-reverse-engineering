package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ToolbarItemClickObservable.java */
@RequiresApi(21)
/* loaded from: classes6.dex */
final class n0 extends Observable<MenuItem> {

    /* renamed from: a  reason: collision with root package name */
    private final Toolbar f34407a;

    /* compiled from: ToolbarItemClickObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements Toolbar.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final Toolbar f34408b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super MenuItem> f34409c;

        a(Toolbar toolbar, Observer<? super MenuItem> observer) {
            this.f34408b = toolbar;
            this.f34409c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34408b.setOnMenuItemClickListener(null);
        }

        @Override // android.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (!isDisposed()) {
                this.f34409c.onNext(menuItem);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(Toolbar toolbar) {
        this.f34407a = toolbar;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super MenuItem> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34407a, observer);
        observer.onSubscribe(aVar);
        this.f34407a.setOnMenuItemClickListener(aVar);
    }
}
