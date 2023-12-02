package com.firebase.ui.auth.ui.idp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.remote.FacebookSignInHandler;
import com.firebase.ui.auth.data.remote.GenericIdpAnonymousUpgradeLinkingHandler;
import com.firebase.ui.auth.data.remote.GenericIdpSignInHandler;
import com.firebase.ui.auth.data.remote.GoogleSignInHandler;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.idp.LinkingSocialProviderResponseHandler;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class WelcomeBackIdpPrompt extends AppCompatBase {

    /* renamed from: d  reason: collision with root package name */
    private ProviderSignInBase<?> f18136d;

    /* renamed from: e  reason: collision with root package name */
    private Button f18137e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f18138f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18139g;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<IdpResponse> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ LinkingSocialProviderResponseHandler f18140e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(HelperActivityBase helperActivityBase, LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler) {
            super(helperActivityBase);
            this.f18140e = linkingSocialProviderResponseHandler;
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            this.f18140e.startSignIn(IdpResponse.from(exc));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            boolean z3;
            if (!WelcomeBackIdpPrompt.this.getAuthUI().isUseEmulator() && AuthUI.SOCIAL_PROVIDERS.contains(idpResponse.getProviderType())) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3 && !idpResponse.hasCredentialForLinking() && !this.f18140e.hasCredentialForLinking()) {
                WelcomeBackIdpPrompt.this.finish(-1, idpResponse.toIntent());
            } else {
                this.f18140e.startSignIn(idpResponse);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18142a;

        b(String str) {
            this.f18142a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WelcomeBackIdpPrompt.this.f18136d.startSignIn(WelcomeBackIdpPrompt.this.getAuth(), WelcomeBackIdpPrompt.this, this.f18142a);
        }
    }

    /* loaded from: classes3.dex */
    class c extends ResourceObserver<IdpResponse> {
        c(HelperActivityBase helperActivityBase) {
            super(helperActivityBase);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                WelcomeBackIdpPrompt.this.finish(5, ((FirebaseAuthAnonymousUpgradeException) exc).getResponse().toIntent());
                return;
            }
            WelcomeBackIdpPrompt.this.finish(0, IdpResponse.getErrorIntent(exc));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            WelcomeBackIdpPrompt.this.finish(-1, idpResponse.toIntent());
        }
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters, User user) {
        return createIntent(context, flowParameters, user, null);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18137e.setEnabled(true);
        this.f18138f.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.HelperActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        this.f18136d.onActivityResult(i4, i5, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setContentView(R.layout.fui_welcome_back_idp_prompt_layout);
        this.f18137e = (Button) findViewById(R.id.welcome_back_idp_button);
        this.f18138f = (ProgressBar) findViewById(R.id.top_progress_bar);
        this.f18139g = (TextView) findViewById(R.id.welcome_back_idp_prompt);
        User user = User.getUser(getIntent());
        IdpResponse fromResultIntent = IdpResponse.fromResultIntent(getIntent());
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler = (LinkingSocialProviderResponseHandler) viewModelProvider.get(LinkingSocialProviderResponseHandler.class);
        linkingSocialProviderResponseHandler.init(getFlowParams());
        if (fromResultIntent != null) {
            linkingSocialProviderResponseHandler.setRequestedSignInCredentialForEmail(ProviderUtils.getAuthCredential(fromResultIntent), user.getEmail());
        }
        String providerId = user.getProviderId();
        AuthUI.IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(getFlowParams().providers, providerId);
        if (configFromIdps == null) {
            finish(0, IdpResponse.getErrorIntent(new FirebaseUiException(3, "Firebase login unsuccessful. Account linking failed due to provider not enabled by application: " + providerId)));
            return;
        }
        String string2 = configFromIdps.getParams().getString(ExtraConstants.GENERIC_OAUTH_PROVIDER_ID);
        boolean isUseEmulator = getAuthUI().isUseEmulator();
        providerId.hashCode();
        if (!providerId.equals("google.com")) {
            if (!providerId.equals("facebook.com")) {
                if (TextUtils.equals(providerId, string2)) {
                    this.f18136d = ((GenericIdpAnonymousUpgradeLinkingHandler) viewModelProvider.get(GenericIdpAnonymousUpgradeLinkingHandler.class)).initWith(configFromIdps);
                    string = configFromIdps.getParams().getString(ExtraConstants.GENERIC_OAUTH_PROVIDER_NAME);
                } else {
                    throw new IllegalStateException("Invalid provider id: " + providerId);
                }
            } else {
                if (isUseEmulator) {
                    this.f18136d = ((GenericIdpAnonymousUpgradeLinkingHandler) viewModelProvider.get(GenericIdpAnonymousUpgradeLinkingHandler.class)).initWith(GenericIdpSignInHandler.getGenericFacebookConfig());
                } else {
                    this.f18136d = ((FacebookSignInHandler) viewModelProvider.get(FacebookSignInHandler.class)).initWith(configFromIdps);
                }
                string = getString(R.string.fui_idp_name_facebook);
            }
        } else {
            if (isUseEmulator) {
                this.f18136d = ((GenericIdpAnonymousUpgradeLinkingHandler) viewModelProvider.get(GenericIdpAnonymousUpgradeLinkingHandler.class)).initWith(GenericIdpSignInHandler.getGenericGoogleConfig());
            } else {
                this.f18136d = ((GoogleSignInHandler) viewModelProvider.get(GoogleSignInHandler.class)).initWith(new GoogleSignInHandler.Params(configFromIdps, user.getEmail()));
            }
            string = getString(R.string.fui_idp_name_google);
        }
        this.f18136d.getOperation().observe(this, new a(this, linkingSocialProviderResponseHandler));
        this.f18139g.setText(getString(R.string.fui_welcome_back_idp_prompt, user.getEmail(), string));
        this.f18137e.setOnClickListener(new b(providerId));
        linkingSocialProviderResponseHandler.getOperation().observe(this, new c(this));
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this, getFlowParams(), (TextView) findViewById(R.id.email_footer_tos_and_pp_text));
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18137e.setEnabled(false);
        this.f18138f.setVisibility(0);
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters, User user, @Nullable IdpResponse idpResponse) {
        return HelperActivityBase.h(context, WelcomeBackIdpPrompt.class, flowParameters).putExtra(ExtraConstants.IDP_RESPONSE, idpResponse).putExtra(ExtraConstants.USER, user);
    }
}
