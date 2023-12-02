package com.firebase.ui.auth.data.remote;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.FirebaseUiUserCollisionException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.FirebaseAuthError;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.OAuthCredential;
import com.google.firebase.auth.OAuthProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class GenericIdpSignInHandler extends ProviderSignInBase<AuthUI.IdpConfig> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OAuthProvider f18002a;

        a(OAuthProvider oAuthProvider) {
            this.f18002a = oAuthProvider;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            if (!(exc instanceof FirebaseAuthException)) {
                GenericIdpSignInHandler.this.d(Resource.forFailure(exc));
                return;
            }
            FirebaseAuthError fromException = FirebaseAuthError.fromException((FirebaseAuthException) exc);
            if (exc instanceof FirebaseAuthUserCollisionException) {
                FirebaseAuthUserCollisionException firebaseAuthUserCollisionException = (FirebaseAuthUserCollisionException) exc;
                GenericIdpSignInHandler.this.d(Resource.forFailure(new FirebaseUiUserCollisionException(13, "Recoverable error.", this.f18002a.getProviderId(), firebaseAuthUserCollisionException.getEmail(), firebaseAuthUserCollisionException.getUpdatedCredential())));
            } else if (fromException == FirebaseAuthError.ERROR_WEB_CONTEXT_CANCELED) {
                GenericIdpSignInHandler.this.d(Resource.forFailure(new UserCancellationException()));
            } else {
                GenericIdpSignInHandler.this.d(Resource.forFailure(exc));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f18004a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OAuthProvider f18005b;

        b(boolean z3, OAuthProvider oAuthProvider) {
            this.f18004a = z3;
            this.f18005b = oAuthProvider;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(@NonNull AuthResult authResult) {
            GenericIdpSignInHandler.this.o(this.f18004a, this.f18005b.getProviderId(), authResult.getUser(), (OAuthCredential) authResult.getCredential(), authResult.getAdditionalUserInfo().isNewUser());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FirebaseAuth f18007a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FlowParameters f18008b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OAuthProvider f18009c;

        /* loaded from: classes3.dex */
        class a implements OnSuccessListener<List<String>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AuthCredential f18011a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f18012b;

            a(AuthCredential authCredential, String str) {
                this.f18011a = authCredential;
                this.f18012b = str;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            /* renamed from: a */
            public void onSuccess(List<String> list) {
                if (list.isEmpty()) {
                    GenericIdpSignInHandler.this.d(Resource.forFailure(new FirebaseUiException(3, "Unable to complete the linkingflow - the user is using unsupported providers.")));
                } else if (!list.contains(c.this.f18009c.getProviderId())) {
                    GenericIdpSignInHandler.this.d(Resource.forFailure(new FirebaseUiUserCollisionException(13, "Recoverable error.", c.this.f18009c.getProviderId(), this.f18012b, this.f18011a)));
                } else {
                    GenericIdpSignInHandler.this.m(this.f18011a);
                }
            }
        }

        c(FirebaseAuth firebaseAuth, FlowParameters flowParameters, OAuthProvider oAuthProvider) {
            this.f18007a = firebaseAuth;
            this.f18008b = flowParameters;
            this.f18009c = oAuthProvider;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            if (!(exc instanceof FirebaseAuthUserCollisionException)) {
                GenericIdpSignInHandler.this.d(Resource.forFailure(exc));
                return;
            }
            FirebaseAuthUserCollisionException firebaseAuthUserCollisionException = (FirebaseAuthUserCollisionException) exc;
            AuthCredential updatedCredential = firebaseAuthUserCollisionException.getUpdatedCredential();
            String email = firebaseAuthUserCollisionException.getEmail();
            ProviderUtils.fetchSortedProviders(this.f18007a, this.f18008b, email).addOnSuccessListener(new a(updatedCredential, email));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f18014a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OAuthProvider f18015b;

        d(boolean z3, OAuthProvider oAuthProvider) {
            this.f18014a = z3;
            this.f18015b = oAuthProvider;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(@NonNull AuthResult authResult) {
            GenericIdpSignInHandler.this.o(this.f18014a, this.f18015b.getProviderId(), authResult.getUser(), (OAuthCredential) authResult.getCredential(), authResult.getAdditionalUserInfo().isNewUser());
        }
    }

    public GenericIdpSignInHandler(Application application) {
        super(application);
    }

    @NonNull
    public static AuthUI.IdpConfig getGenericFacebookConfig() {
        return new AuthUI.IdpConfig.GenericOAuthProviderBuilder("facebook.com", UploadService.UPLOAD_FACEBOOK, R.layout.fui_idp_button_facebook).build();
    }

    @NonNull
    public static AuthUI.IdpConfig getGenericGoogleConfig() {
        return new AuthUI.IdpConfig.GenericOAuthProviderBuilder("google.com", "Google", R.layout.fui_idp_button_google).build();
    }

    private void l(FirebaseAuth firebaseAuth, HelperActivityBase helperActivityBase, OAuthProvider oAuthProvider, FlowParameters flowParameters) {
        firebaseAuth.getCurrentUser().startActivityForLinkWithProvider(helperActivityBase, oAuthProvider).addOnSuccessListener(new d(helperActivityBase.getAuthUI().isUseEmulator(), oAuthProvider)).addOnFailureListener(new c(firebaseAuth, flowParameters, oAuthProvider));
    }

    public OAuthProvider buildOAuthProvider(String str, FirebaseAuth firebaseAuth) {
        OAuthProvider.Builder newBuilder = OAuthProvider.newBuilder(str, firebaseAuth);
        ArrayList<String> stringArrayList = a().getParams().getStringArrayList(ExtraConstants.GENERIC_OAUTH_SCOPES);
        HashMap hashMap = (HashMap) a().getParams().getSerializable(ExtraConstants.GENERIC_OAUTH_CUSTOM_PARAMETERS);
        if (stringArrayList != null) {
            newBuilder.setScopes(stringArrayList);
        }
        if (hashMap != null) {
            newBuilder.addCustomParameters(hashMap);
        }
        return newBuilder.build();
    }

    @VisibleForTesting
    public void initializeForTesting(AuthUI.IdpConfig idpConfig) {
        c(idpConfig);
    }

    protected void m(@NonNull AuthCredential authCredential) {
        d(Resource.forFailure(new FirebaseAuthAnonymousUpgradeException(5, new IdpResponse.Builder().setPendingCredential(authCredential).build())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(FirebaseAuth firebaseAuth, HelperActivityBase helperActivityBase, OAuthProvider oAuthProvider) {
        firebaseAuth.startActivityForSignInWithProvider(helperActivityBase, oAuthProvider).addOnSuccessListener(new b(helperActivityBase.getAuthUI().isUseEmulator(), oAuthProvider)).addOnFailureListener(new a(oAuthProvider));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(boolean z3, @NonNull String str, @NonNull FirebaseUser firebaseUser, @NonNull OAuthCredential oAuthCredential, boolean z4) {
        p(z3, str, firebaseUser, oAuthCredential, z4, true);
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (i4 == 117) {
            IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
            if (fromResultIntent == null) {
                d(Resource.forFailure(new UserCancellationException()));
            } else {
                d(Resource.forSuccess(fromResultIntent));
            }
        }
    }

    protected void p(boolean z3, @NonNull String str, @NonNull FirebaseUser firebaseUser, @NonNull OAuthCredential oAuthCredential, boolean z4, boolean z5) {
        String accessToken = oAuthCredential.getAccessToken();
        if (accessToken == null && z3) {
            accessToken = "fake_access_token";
        }
        String secret = oAuthCredential.getSecret();
        if (secret == null && z3) {
            secret = "fake_secret";
        }
        IdpResponse.Builder secret2 = new IdpResponse.Builder(new User.Builder(str, firebaseUser.getEmail()).setName(firebaseUser.getDisplayName()).setPhotoUri(firebaseUser.getPhotoUrl()).build()).setToken(accessToken).setSecret(secret);
        if (z5) {
            secret2.setPendingCredential(oAuthCredential);
        }
        secret2.setNewUser(z4);
        d(Resource.forSuccess(secret2.build()));
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public final void startSignIn(@NonNull HelperActivityBase helperActivityBase) {
        d(Resource.forLoading());
        startSignIn(helperActivityBase.getAuth(), helperActivityBase, a().getProviderId());
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void startSignIn(@NonNull FirebaseAuth firebaseAuth, @NonNull HelperActivityBase helperActivityBase, @NonNull String str) {
        d(Resource.forLoading());
        FlowParameters flowParams = helperActivityBase.getFlowParams();
        OAuthProvider buildOAuthProvider = buildOAuthProvider(str, firebaseAuth);
        if (flowParams != null && AuthOperationManager.getInstance().canUpgradeAnonymous(firebaseAuth, flowParams)) {
            l(firebaseAuth, helperActivityBase, buildOAuthProvider, flowParams);
        } else {
            n(firebaseAuth, helperActivityBase, buildOAuthProvider);
        }
    }
}
