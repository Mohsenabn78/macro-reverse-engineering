package com.firebase.ui.auth.viewmodel;

import android.app.Application;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class OperableViewModel<I, O> extends ViewModelBase<I> {

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<O> f18249c;

    /* JADX INFO: Access modifiers changed from: protected */
    public OperableViewModel(Application application) {
        super(application);
        this.f18249c = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(O o4) {
        this.f18249c.setValue(o4);
    }

    public LiveData<O> getOperation() {
        return this.f18249c;
    }
}
