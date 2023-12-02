package com.jakewharton.rxbinding2.widget;

import android.database.DataSetObserver;
import android.widget.Adapter;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: AdapterDataChangeObservable.java */
/* loaded from: classes6.dex */
final class b<T extends Adapter> extends InitialValueObservable<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f34316a;

    /* compiled from: AdapterDataChangeObservable.java */
    /* loaded from: classes6.dex */
    static final class a<T extends Adapter> extends MainThreadDisposable {

        /* renamed from: b  reason: collision with root package name */
        private final T f34317b;

        /* renamed from: c  reason: collision with root package name */
        final DataSetObserver f34318c;

        /* compiled from: AdapterDataChangeObservable.java */
        /* renamed from: com.jakewharton.rxbinding2.widget.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0177a extends DataSetObserver {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Observer f34319a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Adapter f34320b;

            C0177a(Observer observer, Adapter adapter) {
                this.f34319a = observer;
                this.f34320b = adapter;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                if (!a.this.isDisposed()) {
                    this.f34319a.onNext(this.f34320b);
                }
            }
        }

        a(T t3, Observer<? super T> observer) {
            this.f34317b = t3;
            this.f34318c = new C0177a(observer, t3);
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34317b.unregisterDataSetObserver(this.f34318c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(T t3) {
        this.f34316a = t3;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super T> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34316a, observer);
        this.f34316a.registerDataSetObserver(aVar.f34318c);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public T d() {
        return this.f34316a;
    }
}
