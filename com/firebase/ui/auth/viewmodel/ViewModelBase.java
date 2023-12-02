package com.firebase.ui.auth.viewmodel;

import android.app.Application;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.AndroidViewModel;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class ViewModelBase<T> extends AndroidViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f18254a;

    /* renamed from: b  reason: collision with root package name */
    private T f18255b;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewModelBase(Application application) {
        super(application);
        this.f18254a = new AtomicBoolean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T a() {
        return this.f18255b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public void c(T t3) {
        this.f18255b = t3;
    }

    public void init(T t3) {
        if (this.f18254a.compareAndSet(false, true)) {
            this.f18255b = t3;
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    @CallSuper
    public void onCleared() {
        this.f18254a.set(false);
    }

    protected void b() {
    }
}
