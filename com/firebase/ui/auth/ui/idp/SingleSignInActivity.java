package com.firebase.ui.auth.ui.idp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.remote.FacebookSignInHandler;
import com.firebase.ui.auth.data.remote.GenericIdpSignInHandler;
import com.firebase.ui.auth.data.remote.GoogleSignInHandler;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.InvisibleActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.idp.SocialProviderResponseHandler;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class SingleSignInActivity extends InvisibleActivityBase {

    /* renamed from: g  reason: collision with root package name */
    private SocialProviderResponseHandler f18131g;

    /* renamed from: h  reason: collision with root package name */
    private ProviderSignInBase<?> f18132h;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<IdpResponse> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f18133e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(HelperActivityBase helperActivityBase, String str) {
            super(helperActivityBase);
            this.f18133e = str;
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                SingleSignInActivity.this.finish(0, new Intent().putExtra(ExtraConstants.IDP_RESPONSE, IdpResponse.from(exc)));
            } else {
                SingleSignInActivity.this.f18131g.startSignIn(IdpResponse.from(exc));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            boolean z3;
            int i4 = 0;
            if (AuthUI.SOCIAL_PROVIDERS.contains(this.f18133e) && !SingleSignInActivity.this.getAuthUI().isUseEmulator()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3 && idpResponse.isSuccessful()) {
                SingleSignInActivity singleSignInActivity = SingleSignInActivity.this;
                if (idpResponse.isSuccessful()) {
                    i4 = -1;
                }
                singleSignInActivity.finish(i4, idpResponse.toIntent());
                return;
            }
            SingleSignInActivity.this.f18131g.startSignIn(idpResponse);
        }
    }

    /* loaded from: classes3.dex */
    class b extends ResourceObserver<IdpResponse> {
        b(HelperActivityBase helperActivityBase) {
            super(helperActivityBase);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                SingleSignInActivity.this.finish(0, new Intent().putExtra(ExtraConstants.IDP_RESPONSE, ((FirebaseAuthAnonymousUpgradeException) exc).getResponse()));
                return;
            }
            SingleSignInActivity.this.finish(0, IdpResponse.getErrorIntent(exc));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            SingleSignInActivity singleSignInActivity = SingleSignInActivity.this;
            singleSignInActivity.startSaveCredentials(singleSignInActivity.f18131g.getCurrentUser(), idpResponse, null);
        }
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters, User user) {
        return HelperActivityBase.h(context, SingleSignInActivity.class, flowParameters).putExtra(ExtraConstants.USER, user);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.HelperActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        this.f18131g.onActivityResult(i4, i5, intent);
        this.f18132h.onActivityResult(i4, i5, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.InvisibleActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        User user = User.getUser(getIntent());
        String providerId = user.getProviderId();
        AuthUI.IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(getFlowParams().providers, providerId);
        if (configFromIdps == null) {
            finish(0, IdpResponse.getErrorIntent(new FirebaseUiException(3, "Provider not enabled: " + providerId)));
            return;
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        SocialProviderResponseHandler socialProviderResponseHandler = (SocialProviderResponseHandler) viewModelProvider.get(SocialProviderResponseHandler.class);
        this.f18131g = socialProviderResponseHandler;
        socialProviderResponseHandler.init(getFlowParams());
        boolean isUseEmulator = getAuthUI().isUseEmulator();
        providerId.hashCode();
        if (!providerId.equals("google.com")) {
            if (!providerId.equals("facebook.com")) {
                if (!TextUtils.isEmpty(configFromIdps.getParams().getString(ExtraConstants.GENERIC_OAUTH_PROVIDER_ID))) {
                    this.f18132h = ((GenericIdpSignInHandler) viewModelProvider.get(GenericIdpSignInHandler.class)).initWith(configFromIdps);
                } else {
                    throw new IllegalStateException("Invalid provider id: " + providerId);
                }
            } else if (isUseEmulator) {
                this.f18132h = ((GenericIdpSignInHandler) viewModelProvider.get(GenericIdpSignInHandler.class)).initWith(GenericIdpSignInHandler.getGenericFacebookConfig());
            } else {
                this.f18132h = ((FacebookSignInHandler) viewModelProvider.get(FacebookSignInHandler.class)).initWith(configFromIdps);
            }
        } else if (isUseEmulator) {
            this.f18132h = ((GenericIdpSignInHandler) viewModelProvider.get(GenericIdpSignInHandler.class)).initWith(GenericIdpSignInHandler.getGenericGoogleConfig());
        } else {
            this.f18132h = ((GoogleSignInHandler) viewModelProvider.get(GoogleSignInHandler.class)).initWith(new GoogleSignInHandler.Params(configFromIdps, user.getEmail()));
        }
        this.f18132h.getOperation().observe(this, new a(this, providerId));
        this.f18131g.getOperation().observe(this, new b(this));
        if (this.f18131g.getOperation().getValue() == null) {
            this.f18132h.startSignIn(getAuth(), this, providerId);
        }
    }
}
