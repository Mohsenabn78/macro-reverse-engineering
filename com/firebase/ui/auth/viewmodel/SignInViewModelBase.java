package com.firebase.ui.auth.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class SignInViewModelBase extends AuthViewModelBase<IdpResponse> {
    /* JADX INFO: Access modifiers changed from: protected */
    public SignInViewModelBase(Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@NonNull IdpResponse idpResponse) {
        j(Resource.forFailure(new FirebaseAuthAnonymousUpgradeException(5, idpResponse)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@NonNull AuthCredential authCredential) {
        g(new IdpResponse.Builder().setPendingCredential(authCredential).build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(@NonNull IdpResponse idpResponse, @NonNull AuthResult authResult) {
        j(Resource.forSuccess(idpResponse.withResult(authResult)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(Resource<IdpResponse> resource) {
        super.d(resource);
    }
}
