package com.firebase.ui.auth.viewmodel.phone;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.PhoneAuthCredential;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class PhoneProviderResponseHandler extends SignInViewModelBase {

    /* loaded from: classes3.dex */
    class a implements OnFailureListener {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            if (exc instanceof FirebaseAuthUserCollisionException) {
                PhoneProviderResponseHandler.this.h(((FirebaseAuthUserCollisionException) exc).getUpdatedCredential());
            } else {
                PhoneProviderResponseHandler.this.j(Resource.forFailure(exc));
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18323a;

        b(IdpResponse idpResponse) {
            this.f18323a = idpResponse;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            PhoneProviderResponseHandler.this.i(this.f18323a, authResult);
        }
    }

    public PhoneProviderResponseHandler(Application application) {
        super(application);
    }

    public void startSignIn(@NonNull PhoneAuthCredential phoneAuthCredential, @NonNull IdpResponse idpResponse) {
        if (!idpResponse.isSuccessful()) {
            j(Resource.forFailure(idpResponse.getError()));
        } else if (idpResponse.getProviderType().equals("phone")) {
            j(Resource.forLoading());
            AuthOperationManager.getInstance().signInAndLinkWithCredential(e(), a(), phoneAuthCredential).addOnSuccessListener(new b(idpResponse)).addOnFailureListener(new a());
        } else {
            throw new IllegalStateException("This handler cannot be used without a phone response.");
        }
    }
}
