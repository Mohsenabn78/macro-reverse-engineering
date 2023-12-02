package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.TextHelper;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class WelcomeBackEmailLinkPrompt extends AppCompatBase implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private IdpResponse f18110d;

    /* renamed from: e  reason: collision with root package name */
    private Button f18111e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f18112f;

    public static Intent createIntent(Context context, FlowParameters flowParameters, IdpResponse idpResponse) {
        return HelperActivityBase.h(context, WelcomeBackEmailLinkPrompt.class, flowParameters).putExtra(ExtraConstants.IDP_RESPONSE, idpResponse);
    }

    private void m() {
        this.f18111e = (Button) findViewById(R.id.button_sign_in);
        this.f18112f = (ProgressBar) findViewById(R.id.top_progress_bar);
    }

    private void n() {
        TextView textView = (TextView) findViewById(R.id.welcome_back_email_link_body);
        String string = getString(R.string.fui_welcome_back_email_link_prompt_body, this.f18110d.getEmail(), this.f18110d.getProviderType());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        TextHelper.boldAllOccurencesOfText(spannableStringBuilder, string, this.f18110d.getEmail());
        TextHelper.boldAllOccurencesOfText(spannableStringBuilder, string, this.f18110d.getProviderType());
        textView.setText(spannableStringBuilder);
        if (Build.VERSION.SDK_INT >= 26) {
            textView.setJustificationMode(1);
        }
    }

    private void o() {
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this, getFlowParams(), (TextView) findViewById(R.id.email_footer_tos_and_pp_text));
    }

    private void p() {
        startActivityForResult(EmailActivity.createIntentForLinking(this, getFlowParams(), this.f18110d), 112);
    }

    private void setOnClickListeners() {
        this.f18111e.setOnClickListener(this);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18112f.setEnabled(true);
        this.f18112f.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.HelperActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        finish(i5, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_sign_in) {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_welcome_back_email_link_prompt_layout);
        this.f18110d = IdpResponse.fromResultIntent(getIntent());
        m();
        n();
        setOnClickListeners();
        o();
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18111e.setEnabled(false);
        this.f18112f.setVisibility(0);
    }
}
