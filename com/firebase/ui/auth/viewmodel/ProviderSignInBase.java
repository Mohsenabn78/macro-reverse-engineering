package com.firebase.ui.auth.viewmodel;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.firebase.auth.FirebaseAuth;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class ProviderSignInBase<T> extends OperableViewModel<T, Resource<IdpResponse>> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ProviderSignInBase(Application application) {
        super(application);
    }

    public ProviderSignInBase<T> initWith(T t3) {
        super.init(t3);
        return this;
    }

    public abstract void onActivityResult(int i4, int i5, @Nullable Intent intent);

    public abstract void startSignIn(@NonNull HelperActivityBase helperActivityBase);

    public abstract void startSignIn(@NonNull FirebaseAuth firebaseAuth, @NonNull HelperActivityBase helperActivityBase, @NonNull String str);
}
