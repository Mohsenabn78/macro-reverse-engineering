package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransaction;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.email.CheckEmailFragment;
import com.firebase.ui.auth.ui.email.EmailLinkFragment;
import com.firebase.ui.auth.ui.email.RegisterEmailFragment;
import com.firebase.ui.auth.ui.email.TroubleSigningInFragment;
import com.firebase.ui.auth.ui.idp.WelcomeBackIdpPrompt;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.EmailLinkPersistenceManager;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.ActionCodeSettings;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailActivity extends AppCompatBase implements CheckEmailFragment.b, RegisterEmailFragment.c, EmailLinkFragment.c, TroubleSigningInFragment.a {
    public static Intent createIntent(Context context, FlowParameters flowParameters) {
        return HelperActivityBase.h(context, EmailActivity.class, flowParameters);
    }

    public static Intent createIntentForLinking(Context context, FlowParameters flowParameters, IdpResponse idpResponse) {
        return createIntent(context, flowParameters, idpResponse.getEmail()).putExtra(ExtraConstants.IDP_RESPONSE, idpResponse);
    }

    private void m(Exception exc) {
        finish(0, IdpResponse.getErrorIntent(new FirebaseUiException(3, exc.getMessage())));
    }

    private void n() {
        overridePendingTransition(R.anim.fui_slide_in_right, R.anim.fui_slide_out_left);
    }

    private void o(AuthUI.IdpConfig idpConfig, String str) {
        k(EmailLinkFragment.newInstance(str, (ActionCodeSettings) idpConfig.getParams().getParcelable(ExtraConstants.ACTION_CODE_SETTINGS)), R.id.fragment_register_email, EmailLinkFragment.TAG);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        throw new UnsupportedOperationException("Email fragments must handle progress updates.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.HelperActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 104 || i4 == 103) {
            finish(i5, intent);
        }
    }

    @Override // com.firebase.ui.auth.ui.email.TroubleSigningInFragment.a
    public void onClickResendEmail(String str) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
        o(ProviderUtils.getConfigFromIdpsOrThrow(getFlowParams().providers, "emailLink"), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_activity_register_email);
        if (bundle != null) {
            return;
        }
        String string = getIntent().getExtras().getString(ExtraConstants.EMAIL);
        IdpResponse idpResponse = (IdpResponse) getIntent().getExtras().getParcelable(ExtraConstants.IDP_RESPONSE);
        if (string != null && idpResponse != null) {
            AuthUI.IdpConfig configFromIdpsOrThrow = ProviderUtils.getConfigFromIdpsOrThrow(getFlowParams().providers, "emailLink");
            EmailLinkPersistenceManager.getInstance().saveIdpResponseForLinking(getApplication(), idpResponse);
            k(EmailLinkFragment.newInstance(string, (ActionCodeSettings) configFromIdpsOrThrow.getParams().getParcelable(ExtraConstants.ACTION_CODE_SETTINGS), idpResponse, configFromIdpsOrThrow.getParams().getBoolean(ExtraConstants.FORCE_SAME_DEVICE)), R.id.fragment_register_email, EmailLinkFragment.TAG);
            return;
        }
        AuthUI.IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(getFlowParams().providers, "password");
        if (configFromIdps != null) {
            string = configFromIdps.getParams().getString(ExtraConstants.DEFAULT_EMAIL);
        }
        k(CheckEmailFragment.newInstance(string), R.id.fragment_register_email, CheckEmailFragment.TAG);
    }

    @Override // com.firebase.ui.auth.ui.email.CheckEmailFragment.b
    public void onDeveloperFailure(Exception exc) {
        m(exc);
    }

    @Override // com.firebase.ui.auth.ui.email.CheckEmailFragment.b
    public void onExistingEmailUser(User user) {
        if (user.getProviderId().equals("emailLink")) {
            o(ProviderUtils.getConfigFromIdpsOrThrow(getFlowParams().providers, "emailLink"), user.getEmail());
            return;
        }
        startActivityForResult(WelcomeBackPasswordPrompt.createIntent(this, getFlowParams(), new IdpResponse.Builder(user).build()), 104);
        n();
    }

    @Override // com.firebase.ui.auth.ui.email.CheckEmailFragment.b
    public void onExistingIdpUser(User user) {
        startActivityForResult(WelcomeBackIdpPrompt.createIntent(this, getFlowParams(), user), 103);
        n();
    }

    @Override // com.firebase.ui.auth.ui.email.RegisterEmailFragment.c
    public void onMergeFailure(IdpResponse idpResponse) {
        finish(5, idpResponse.toIntent());
    }

    @Override // com.firebase.ui.auth.ui.email.CheckEmailFragment.b
    public void onNewUser(User user) {
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.email_layout);
        AuthUI.IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(getFlowParams().providers, "password");
        if (configFromIdps == null) {
            configFromIdps = ProviderUtils.getConfigFromIdps(getFlowParams().providers, "emailLink");
        }
        if (configFromIdps.getParams().getBoolean(ExtraConstants.ALLOW_NEW_EMAILS, true)) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (configFromIdps.getProviderId().equals("emailLink")) {
                o(configFromIdps, user.getEmail());
                return;
            }
            beginTransaction.replace(R.id.fragment_register_email, RegisterEmailFragment.newInstance(user), RegisterEmailFragment.TAG);
            if (textInputLayout != null) {
                String string = getString(R.string.fui_email_field_name);
                ViewCompat.setTransitionName(textInputLayout, string);
                beginTransaction.addSharedElement(textInputLayout, string);
            }
            beginTransaction.disallowAddToBackStack().commit();
            return;
        }
        textInputLayout.setError(getString(R.string.fui_error_email_does_not_exist));
    }

    @Override // com.firebase.ui.auth.ui.email.EmailLinkFragment.c
    public void onSendEmailFailure(Exception exc) {
        m(exc);
    }

    @Override // com.firebase.ui.auth.ui.email.EmailLinkFragment.c
    public void onTroubleSigningIn(String str) {
        l(TroubleSigningInFragment.newInstance(str), R.id.fragment_register_email, TroubleSigningInFragment.TAG, true, true);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(@StringRes int i4) {
        throw new UnsupportedOperationException("Email fragments must handle progress updates.");
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters, String str) {
        return HelperActivityBase.h(context, EmailActivity.class, flowParameters).putExtra(ExtraConstants.EMAIL, str);
    }
}
