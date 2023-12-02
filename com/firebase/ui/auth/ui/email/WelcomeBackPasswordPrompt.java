package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.FirebaseAuthError;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.util.ui.ImeHelper;
import com.firebase.ui.auth.util.ui.TextHelper;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.email.WelcomeBackPasswordHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class WelcomeBackPasswordPrompt extends AppCompatBase implements View.OnClickListener, ImeHelper.DonePressedListener {

    /* renamed from: d  reason: collision with root package name */
    private IdpResponse f18113d;

    /* renamed from: e  reason: collision with root package name */
    private WelcomeBackPasswordHandler f18114e;

    /* renamed from: f  reason: collision with root package name */
    private Button f18115f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f18116g;

    /* renamed from: h  reason: collision with root package name */
    private TextInputLayout f18117h;

    /* renamed from: i  reason: collision with root package name */
    private EditText f18118i;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<IdpResponse> {
        a(HelperActivityBase helperActivityBase, int i4) {
            super(helperActivityBase, i4);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                WelcomeBackPasswordPrompt.this.finish(5, ((FirebaseAuthAnonymousUpgradeException) exc).getResponse().toIntent());
            } else if (!(exc instanceof FirebaseAuthException) || FirebaseAuthError.fromException((FirebaseAuthException) exc) != FirebaseAuthError.ERROR_USER_DISABLED) {
                TextInputLayout textInputLayout = WelcomeBackPasswordPrompt.this.f18117h;
                WelcomeBackPasswordPrompt welcomeBackPasswordPrompt = WelcomeBackPasswordPrompt.this;
                textInputLayout.setError(welcomeBackPasswordPrompt.getString(welcomeBackPasswordPrompt.p(exc)));
            } else {
                WelcomeBackPasswordPrompt.this.finish(0, IdpResponse.from(new FirebaseUiException(12)).toIntent());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            WelcomeBackPasswordPrompt welcomeBackPasswordPrompt = WelcomeBackPasswordPrompt.this;
            welcomeBackPasswordPrompt.startSaveCredentials(welcomeBackPasswordPrompt.f18114e.getCurrentUser(), idpResponse, WelcomeBackPasswordPrompt.this.f18114e.getPendingPassword());
        }
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters, IdpResponse idpResponse) {
        return HelperActivityBase.h(context, WelcomeBackPasswordPrompt.class, flowParameters).putExtra(ExtraConstants.IDP_RESPONSE, idpResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @StringRes
    public int p(Exception exc) {
        if (exc instanceof FirebaseAuthInvalidCredentialsException) {
            return R.string.fui_error_invalid_password;
        }
        return R.string.fui_error_unknown;
    }

    private void q() {
        startActivity(RecoverPasswordActivity.createIntent(this, getFlowParams(), this.f18113d.getEmail()));
    }

    private void r() {
        s(this.f18118i.getText().toString());
    }

    private void s(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f18117h.setError(getString(R.string.fui_error_invalid_password));
            return;
        }
        this.f18117h.setError(null);
        this.f18114e.startSignIn(this.f18113d.getEmail(), str, this.f18113d, ProviderUtils.getAuthCredential(this.f18113d));
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18115f.setEnabled(true);
        this.f18116g.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_done) {
            r();
        } else if (id == R.id.trouble_signing_in) {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_welcome_back_password_prompt_layout);
        getWindow().setSoftInputMode(4);
        IdpResponse fromResultIntent = IdpResponse.fromResultIntent(getIntent());
        this.f18113d = fromResultIntent;
        String email = fromResultIntent.getEmail();
        this.f18115f = (Button) findViewById(R.id.button_done);
        this.f18116g = (ProgressBar) findViewById(R.id.top_progress_bar);
        this.f18117h = (TextInputLayout) findViewById(R.id.password_layout);
        EditText editText = (EditText) findViewById(R.id.password);
        this.f18118i = editText;
        ImeHelper.setImeOnDoneListener(editText, this);
        String string = getString(R.string.fui_welcome_back_password_prompt_body, email);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        TextHelper.boldAllOccurencesOfText(spannableStringBuilder, string, email);
        ((TextView) findViewById(R.id.welcome_back_password_body)).setText(spannableStringBuilder);
        this.f18115f.setOnClickListener(this);
        findViewById(R.id.trouble_signing_in).setOnClickListener(this);
        WelcomeBackPasswordHandler welcomeBackPasswordHandler = (WelcomeBackPasswordHandler) new ViewModelProvider(this).get(WelcomeBackPasswordHandler.class);
        this.f18114e = welcomeBackPasswordHandler;
        welcomeBackPasswordHandler.init(getFlowParams());
        this.f18114e.getOperation().observe(this, new a(this, R.string.fui_progress_dialog_signing_in));
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this, getFlowParams(), (TextView) findViewById(R.id.email_footer_tos_and_pp_text));
    }

    @Override // com.firebase.ui.auth.util.ui.ImeHelper.DonePressedListener
    public void onDonePressed() {
        r();
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18115f.setEnabled(false);
        this.f18116g.setVisibility(0);
    }
}
