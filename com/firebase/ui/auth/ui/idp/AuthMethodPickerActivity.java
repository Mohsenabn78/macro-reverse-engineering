package com.firebase.ui.auth.ui.idp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.data.remote.AnonymousSignInHandler;
import com.firebase.ui.auth.data.remote.EmailSignInHandler;
import com.firebase.ui.auth.data.remote.FacebookSignInHandler;
import com.firebase.ui.auth.data.remote.GenericIdpSignInHandler;
import com.firebase.ui.auth.data.remote.GoogleSignInHandler;
import com.firebase.ui.auth.data.remote.PhoneSignInHandler;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.idp.SocialProviderResponseHandler;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class AuthMethodPickerActivity extends AppCompatBase {

    /* renamed from: d  reason: collision with root package name */
    private SocialProviderResponseHandler f18120d;

    /* renamed from: e  reason: collision with root package name */
    private List<ProviderSignInBase<?>> f18121e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f18122f;

    /* renamed from: g  reason: collision with root package name */
    private ViewGroup f18123g;

    /* renamed from: h  reason: collision with root package name */
    private AuthMethodPickerLayout f18124h;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<IdpResponse> {
        a(HelperActivityBase helperActivityBase, int i4) {
            super(helperActivityBase, i4);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof UserCancellationException) {
                return;
            }
            if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                AuthMethodPickerActivity.this.finish(5, ((FirebaseAuthAnonymousUpgradeException) exc).getResponse().toIntent());
            } else if (exc instanceof FirebaseUiException) {
                AuthMethodPickerActivity.this.finish(0, IdpResponse.from((FirebaseUiException) exc).toIntent());
            } else {
                Toast.makeText(AuthMethodPickerActivity.this, AuthMethodPickerActivity.this.getString(R.string.fui_error_unknown), 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            AuthMethodPickerActivity authMethodPickerActivity = AuthMethodPickerActivity.this;
            authMethodPickerActivity.startSaveCredentials(authMethodPickerActivity.f18120d.getCurrentUser(), idpResponse, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends ResourceObserver<IdpResponse> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f18126e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(HelperActivityBase helperActivityBase, String str) {
            super(helperActivityBase);
            this.f18126e = str;
        }

        private void c(@NonNull IdpResponse idpResponse) {
            boolean z3;
            int i4 = 0;
            if (AuthUI.SOCIAL_PROVIDERS.contains(this.f18126e) && !AuthMethodPickerActivity.this.getAuthUI().isUseEmulator()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!idpResponse.isSuccessful()) {
                AuthMethodPickerActivity.this.f18120d.startSignIn(idpResponse);
            } else if (z3) {
                AuthMethodPickerActivity.this.f18120d.startSignIn(idpResponse);
            } else {
                AuthMethodPickerActivity authMethodPickerActivity = AuthMethodPickerActivity.this;
                if (idpResponse.isSuccessful()) {
                    i4 = -1;
                }
                authMethodPickerActivity.finish(i4, idpResponse.toIntent());
            }
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                AuthMethodPickerActivity.this.finish(0, new Intent().putExtra(ExtraConstants.IDP_RESPONSE, IdpResponse.from(exc)));
            } else {
                c(IdpResponse.from(exc));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: d */
        public void b(@NonNull IdpResponse idpResponse) {
            c(idpResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProviderSignInBase f18128a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AuthUI.IdpConfig f18129b;

        c(ProviderSignInBase providerSignInBase, AuthUI.IdpConfig idpConfig) {
            this.f18128a = providerSignInBase;
            this.f18129b = idpConfig;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AuthMethodPickerActivity.this.i()) {
                Snackbar.make(AuthMethodPickerActivity.this.findViewById(16908290), AuthMethodPickerActivity.this.getString(R.string.fui_no_internet), -1).show();
            } else {
                this.f18128a.startSignIn(AuthMethodPickerActivity.this.getAuth(), AuthMethodPickerActivity.this, this.f18129b.getProviderId());
            }
        }
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters) {
        return HelperActivityBase.h(context, AuthMethodPickerActivity.class, flowParameters);
    }

    private void o(AuthUI.IdpConfig idpConfig, View view) {
        ProviderSignInBase<FlowParameters> initWith;
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        String providerId = idpConfig.getProviderId();
        AuthUI authUI = getAuthUI();
        providerId.hashCode();
        char c4 = 65535;
        switch (providerId.hashCode()) {
            case -2095811475:
                if (providerId.equals(AuthUI.ANONYMOUS_PROVIDER)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1536293812:
                if (providerId.equals("google.com")) {
                    c4 = 1;
                    break;
                }
                break;
            case -364826023:
                if (providerId.equals("facebook.com")) {
                    c4 = 2;
                    break;
                }
                break;
            case 106642798:
                if (providerId.equals("phone")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1216985755:
                if (providerId.equals("password")) {
                    c4 = 4;
                    break;
                }
                break;
            case 2120171958:
                if (providerId.equals("emailLink")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                initWith = ((AnonymousSignInHandler) viewModelProvider.get(AnonymousSignInHandler.class)).initWith(getFlowParams());
                break;
            case 1:
                if (authUI.isUseEmulator()) {
                    initWith = ((GenericIdpSignInHandler) viewModelProvider.get(GenericIdpSignInHandler.class)).initWith(GenericIdpSignInHandler.getGenericGoogleConfig());
                    break;
                } else {
                    initWith = ((GoogleSignInHandler) viewModelProvider.get(GoogleSignInHandler.class)).initWith(new GoogleSignInHandler.Params(idpConfig));
                    break;
                }
            case 2:
                if (authUI.isUseEmulator()) {
                    initWith = ((GenericIdpSignInHandler) viewModelProvider.get(GenericIdpSignInHandler.class)).initWith(GenericIdpSignInHandler.getGenericFacebookConfig());
                    break;
                } else {
                    initWith = ((FacebookSignInHandler) viewModelProvider.get(FacebookSignInHandler.class)).initWith(idpConfig);
                    break;
                }
            case 3:
                initWith = ((PhoneSignInHandler) viewModelProvider.get(PhoneSignInHandler.class)).initWith(idpConfig);
                break;
            case 4:
            case 5:
                initWith = ((EmailSignInHandler) viewModelProvider.get(EmailSignInHandler.class)).initWith(null);
                break;
            default:
                if (!TextUtils.isEmpty(idpConfig.getParams().getString(ExtraConstants.GENERIC_OAUTH_PROVIDER_ID))) {
                    initWith = ((GenericIdpSignInHandler) viewModelProvider.get(GenericIdpSignInHandler.class)).initWith(idpConfig);
                    break;
                } else {
                    throw new IllegalStateException("Unknown provider: " + providerId);
                }
        }
        this.f18121e.add(initWith);
        initWith.getOperation().observe(this, new b(this, providerId));
        view.setOnClickListener(new c(initWith, idpConfig));
    }

    private void p(List<AuthUI.IdpConfig> list) {
        int i4;
        new ViewModelProvider(this);
        this.f18121e = new ArrayList();
        for (AuthUI.IdpConfig idpConfig : list) {
            String providerId = idpConfig.getProviderId();
            providerId.hashCode();
            char c4 = 65535;
            switch (providerId.hashCode()) {
                case -2095811475:
                    if (providerId.equals(AuthUI.ANONYMOUS_PROVIDER)) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1536293812:
                    if (providerId.equals("google.com")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -364826023:
                    if (providerId.equals("facebook.com")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 106642798:
                    if (providerId.equals("phone")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 1216985755:
                    if (providerId.equals("password")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 2120171958:
                    if (providerId.equals("emailLink")) {
                        c4 = 5;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    i4 = R.layout.fui_provider_button_anonymous;
                    break;
                case 1:
                    i4 = R.layout.fui_idp_button_google;
                    break;
                case 2:
                    i4 = R.layout.fui_idp_button_facebook;
                    break;
                case 3:
                    i4 = R.layout.fui_provider_button_phone;
                    break;
                case 4:
                case 5:
                    i4 = R.layout.fui_provider_button_email;
                    break;
                default:
                    if (!TextUtils.isEmpty(idpConfig.getParams().getString(ExtraConstants.GENERIC_OAUTH_PROVIDER_ID))) {
                        i4 = idpConfig.getParams().getInt(ExtraConstants.GENERIC_OAUTH_BUTTON_ID);
                        break;
                    } else {
                        throw new IllegalStateException("Unknown provider: " + providerId);
                    }
            }
            View inflate = getLayoutInflater().inflate(i4, this.f18123g, false);
            o(idpConfig, inflate);
            this.f18123g.addView(inflate);
        }
    }

    private void q(List<AuthUI.IdpConfig> list) {
        boolean z3;
        Integer num;
        Map<String, Integer> providersButton = this.f18124h.getProvidersButton();
        for (AuthUI.IdpConfig idpConfig : list) {
            Integer num2 = providersButton.get(r(idpConfig.getProviderId()));
            if (num2 != null) {
                o(idpConfig, findViewById(num2.intValue()));
            } else {
                throw new IllegalStateException("No button found for auth provider: " + idpConfig.getProviderId());
            }
        }
        for (String str : providersButton.keySet()) {
            if (str != null) {
                Iterator<AuthUI.IdpConfig> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.equals(r(it.next().getProviderId()))) {
                            z3 = true;
                            break;
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (!z3 && (num = providersButton.get(str)) != null) {
                    findViewById(num.intValue()).setVisibility(8);
                }
            }
        }
    }

    @NonNull
    private String r(@NonNull String str) {
        if (str.equals("emailLink")) {
            return "password";
        }
        return str;
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        if (this.f18124h == null) {
            this.f18122f.setVisibility(4);
            for (int i4 = 0; i4 < this.f18123g.getChildCount(); i4++) {
                View childAt = this.f18123g.getChildAt(i4);
                childAt.setEnabled(true);
                childAt.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.HelperActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        this.f18120d.onActivityResult(i4, i5, intent);
        for (ProviderSignInBase<?> providerSignInBase : this.f18121e) {
            providerSignInBase.onActivityResult(i4, i5, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean z3;
        int tosPpView;
        super.onCreate(bundle);
        FlowParameters flowParams = getFlowParams();
        this.f18124h = flowParams.authMethodPickerLayout;
        SocialProviderResponseHandler socialProviderResponseHandler = (SocialProviderResponseHandler) new ViewModelProvider(this).get(SocialProviderResponseHandler.class);
        this.f18120d = socialProviderResponseHandler;
        socialProviderResponseHandler.init(flowParams);
        this.f18121e = new ArrayList();
        AuthMethodPickerLayout authMethodPickerLayout = this.f18124h;
        if (authMethodPickerLayout != null) {
            setContentView(authMethodPickerLayout.getMainLayout());
            q(flowParams.providers);
        } else {
            setContentView(R.layout.fui_auth_method_picker_layout);
            this.f18122f = (ProgressBar) findViewById(R.id.top_progress_bar);
            this.f18123g = (ViewGroup) findViewById(R.id.btn_holder);
            p(flowParams.providers);
            int i4 = flowParams.logoId;
            if (i4 == -1) {
                findViewById(R.id.logo).setVisibility(8);
                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.root);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                int i5 = R.id.container;
                constraintSet.setHorizontalBias(i5, 0.5f);
                constraintSet.setVerticalBias(i5, 0.5f);
                constraintSet.applyTo(constraintLayout);
            } else {
                ((ImageView) findViewById(R.id.logo)).setImageResource(i4);
            }
        }
        if (getFlowParams().isPrivacyPolicyUrlProvided() && getFlowParams().isTermsOfServiceUrlProvided()) {
            z3 = true;
        } else {
            z3 = false;
        }
        AuthMethodPickerLayout authMethodPickerLayout2 = this.f18124h;
        if (authMethodPickerLayout2 == null) {
            tosPpView = R.id.main_tos_and_pp;
        } else {
            tosPpView = authMethodPickerLayout2.getTosPpView();
        }
        if (tosPpView >= 0) {
            TextView textView = (TextView) findViewById(tosPpView);
            if (!z3) {
                textView.setVisibility(8);
            } else {
                PrivacyDisclosureUtils.setupTermsOfServiceAndPrivacyPolicyText(this, getFlowParams(), textView);
            }
        }
        this.f18120d.getOperation().observe(this, new a(this, R.string.fui_progress_dialog_signing_in));
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        if (this.f18124h == null) {
            this.f18122f.setVisibility(0);
            for (int i5 = 0; i5 < this.f18123g.getChildCount(); i5++) {
                View childAt = this.f18123g.getChildAt(i5);
                childAt.setEnabled(false);
                childAt.setAlpha(0.75f);
            }
        }
    }
}
