package com.firebase.ui.auth.data.remote;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class AnonymousSignInHandler extends SingleProviderSignInHandler<FlowParameters> {
    @VisibleForTesting
    public FirebaseAuth mAuth;

    /* loaded from: classes3.dex */
    class a implements OnFailureListener {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            AnonymousSignInHandler.this.d(Resource.forFailure(exc));
        }
    }

    /* loaded from: classes3.dex */
    class b implements OnSuccessListener<AuthResult> {
        b() {
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            AnonymousSignInHandler anonymousSignInHandler = AnonymousSignInHandler.this;
            anonymousSignInHandler.d(Resource.forSuccess(anonymousSignInHandler.i(authResult.getAdditionalUserInfo().isNewUser())));
        }
    }

    public AnonymousSignInHandler(Application application) {
        super(application, AuthUI.ANONYMOUS_PROVIDER);
    }

    private FirebaseAuth h() {
        return AuthUI.getInstance(a().appName).getAuth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IdpResponse i(boolean z3) {
        return new IdpResponse.Builder(new User.Builder(AuthUI.ANONYMOUS_PROVIDER, null).build()).setNewUser(z3).build();
    }

    @Override // com.firebase.ui.auth.viewmodel.ViewModelBase
    protected void b() {
        this.mAuth = h();
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void startSignIn(@NonNull FirebaseAuth firebaseAuth, @NonNull HelperActivityBase helperActivityBase, @NonNull String str) {
        d(Resource.forLoading());
        this.mAuth.signInAnonymously().addOnSuccessListener(new b()).addOnFailureListener(new a());
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
    }
}
