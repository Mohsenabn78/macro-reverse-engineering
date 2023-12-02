package com.firebase.ui.auth.data.remote;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthCredential;
import com.google.firebase.auth.OAuthProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class GenericIdpAnonymousUpgradeLinkingHandler extends GenericIdpSignInHandler {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnFailureListener {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            GenericIdpAnonymousUpgradeLinkingHandler.this.d(Resource.forFailure(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f17999a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OAuthProvider f18000b;

        b(boolean z3, OAuthProvider oAuthProvider) {
            this.f17999a = z3;
            this.f18000b = oAuthProvider;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            GenericIdpAnonymousUpgradeLinkingHandler.this.o(this.f17999a, this.f18000b.getProviderId(), authResult.getUser(), (OAuthCredential) authResult.getCredential(), true);
        }
    }

    public GenericIdpAnonymousUpgradeLinkingHandler(Application application) {
        super(application);
    }

    private void r(HelperActivityBase helperActivityBase, OAuthProvider oAuthProvider, FlowParameters flowParameters) {
        AuthOperationManager.getInstance().safeGenericIdpSignIn(helperActivityBase, oAuthProvider, flowParameters).addOnSuccessListener(new b(helperActivityBase.getAuthUI().isUseEmulator(), oAuthProvider)).addOnFailureListener(new a());
    }

    @Override // com.firebase.ui.auth.data.remote.GenericIdpSignInHandler, com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void startSignIn(@NonNull FirebaseAuth firebaseAuth, @NonNull HelperActivityBase helperActivityBase, @NonNull String str) {
        d(Resource.forLoading());
        FlowParameters flowParams = helperActivityBase.getFlowParams();
        OAuthProvider buildOAuthProvider = buildOAuthProvider(str, firebaseAuth);
        if (flowParams != null && AuthOperationManager.getInstance().canUpgradeAnonymous(firebaseAuth, flowParams)) {
            r(helperActivityBase, buildOAuthProvider, flowParams);
        } else {
            n(firebaseAuth, helperActivityBase, buildOAuthProvider);
        }
    }
}
