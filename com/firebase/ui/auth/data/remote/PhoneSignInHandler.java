package com.firebase.ui.auth.data.remote;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.phone.PhoneActivity;
import com.google.firebase.auth.FirebaseAuth;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class PhoneSignInHandler extends SingleProviderSignInHandler<AuthUI.IdpConfig> {
    public PhoneSignInHandler(Application application) {
        super(application, "phone");
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (i4 == 107) {
            IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
            if (fromResultIntent == null) {
                d(Resource.forFailure(new UserCancellationException()));
            } else {
                d(Resource.forSuccess(fromResultIntent));
            }
        }
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void startSignIn(@NonNull FirebaseAuth firebaseAuth, @NonNull HelperActivityBase helperActivityBase, @NonNull String str) {
        helperActivityBase.startActivityForResult(PhoneActivity.createIntent(helperActivityBase, helperActivityBase.getFlowParams(), a().getParams()), 107);
    }
}
