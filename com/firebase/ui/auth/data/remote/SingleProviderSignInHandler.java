package com.firebase.ui.auth.data.remote;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class SingleProviderSignInHandler<T> extends ProviderSignInBase<T> {

    /* renamed from: d  reason: collision with root package name */
    private final String f18031d;

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleProviderSignInHandler(Application application, String str) {
        super(application);
        this.f18031d = str;
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public final void startSignIn(@NonNull HelperActivityBase helperActivityBase) {
        startSignIn(helperActivityBase.getAuth(), helperActivityBase, this.f18031d);
    }
}
