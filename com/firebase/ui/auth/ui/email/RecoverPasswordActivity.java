package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.ImeHelper;
import com.firebase.ui.auth.util.ui.fieldvalidators.EmailFieldValidator;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.email.RecoverPasswordHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class RecoverPasswordActivity extends AppCompatBase implements View.OnClickListener, ImeHelper.DonePressedListener {

    /* renamed from: d  reason: collision with root package name */
    private RecoverPasswordHandler f18083d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f18084e;

    /* renamed from: f  reason: collision with root package name */
    private Button f18085f;

    /* renamed from: g  reason: collision with root package name */
    private TextInputLayout f18086g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f18087h;

    /* renamed from: i  reason: collision with root package name */
    private EmailFieldValidator f18088i;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<String> {
        a(HelperActivityBase helperActivityBase, int i4) {
            super(helperActivityBase, i4);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (!(exc instanceof FirebaseAuthInvalidUserException) && !(exc instanceof FirebaseAuthInvalidCredentialsException)) {
                RecoverPasswordActivity.this.f18086g.setError(RecoverPasswordActivity.this.getString(R.string.fui_error_unknown));
            } else {
                RecoverPasswordActivity.this.f18086g.setError(RecoverPasswordActivity.this.getString(R.string.fui_error_email_does_not_exist));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull String str) {
            RecoverPasswordActivity.this.f18086g.setError(null);
            RecoverPasswordActivity.this.p(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            RecoverPasswordActivity.this.finish(-1, new Intent());
        }
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters, String str) {
        return HelperActivityBase.h(context, RecoverPasswordActivity.class, flowParameters).putExtra(ExtraConstants.EMAIL, str);
    }

    private void o(String str, @Nullable ActionCodeSettings actionCodeSettings) {
        this.f18083d.startReset(str, actionCodeSettings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        new AlertDialog.Builder(this).setTitle(R.string.fui_title_confirm_recover_password).setMessage(getString(R.string.fui_confirm_recovery_body, str)).setOnDismissListener(new b()).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18085f.setEnabled(true);
        this.f18084e.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_done) {
            onDonePressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_forgot_password_layout);
        RecoverPasswordHandler recoverPasswordHandler = (RecoverPasswordHandler) new ViewModelProvider(this).get(RecoverPasswordHandler.class);
        this.f18083d = recoverPasswordHandler;
        recoverPasswordHandler.init(getFlowParams());
        this.f18083d.getOperation().observe(this, new a(this, R.string.fui_progress_dialog_sending));
        this.f18084e = (ProgressBar) findViewById(R.id.top_progress_bar);
        this.f18085f = (Button) findViewById(R.id.button_done);
        this.f18086g = (TextInputLayout) findViewById(R.id.email_layout);
        this.f18087h = (EditText) findViewById(R.id.email);
        this.f18088i = new EmailFieldValidator(this.f18086g);
        String stringExtra = getIntent().getStringExtra(ExtraConstants.EMAIL);
        if (stringExtra != null) {
            this.f18087h.setText(stringExtra);
        }
        ImeHelper.setImeOnDoneListener(this.f18087h, this);
        this.f18085f.setOnClickListener(this);
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this, getFlowParams(), (TextView) findViewById(R.id.email_footer_tos_and_pp_text));
    }

    @Override // com.firebase.ui.auth.util.ui.ImeHelper.DonePressedListener
    public void onDonePressed() {
        if (this.f18088i.validate(this.f18087h.getText())) {
            if (getFlowParams().passwordResetSettings != null) {
                o(this.f18087h.getText().toString(), getFlowParams().passwordResetSettings);
            } else {
                o(this.f18087h.getText().toString(), null);
            }
        }
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18085f.setEnabled(false);
        this.f18084e.setVisibility(0);
    }
}
