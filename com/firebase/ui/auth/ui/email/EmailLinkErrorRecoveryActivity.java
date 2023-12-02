package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.email.EmailLinkCrossDeviceLinkingFragment;
import com.firebase.ui.auth.ui.email.EmailLinkPromptEmailFragment;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailLinkErrorRecoveryActivity extends AppCompatBase implements EmailLinkPromptEmailFragment.b, EmailLinkCrossDeviceLinkingFragment.a {
    public static Intent createIntent(Context context, FlowParameters flowParameters, int i4) {
        return HelperActivityBase.h(context, EmailLinkErrorRecoveryActivity.class, flowParameters).putExtra("com.firebase.ui.auth.ui.email.recoveryTypeKey", i4);
    }

    @Override // com.firebase.ui.auth.ui.email.EmailLinkCrossDeviceLinkingFragment.a
    public void completeCrossDeviceEmailLinkFlow() {
        l(EmailLinkPromptEmailFragment.newInstance(), R.id.fragment_register_email, EmailLinkCrossDeviceLinkingFragment.TAG, true, true);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        throw new UnsupportedOperationException("Fragments must handle progress updates.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean z3;
        Fragment newInstance;
        super.onCreate(bundle);
        setContentView(R.layout.fui_activity_register_email);
        if (bundle != null) {
            return;
        }
        if (getIntent().getIntExtra("com.firebase.ui.auth.ui.email.recoveryTypeKey", -1) == 116) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            newInstance = EmailLinkCrossDeviceLinkingFragment.newInstance();
        } else {
            newInstance = EmailLinkPromptEmailFragment.newInstance();
        }
        k(newInstance, R.id.fragment_register_email, EmailLinkPromptEmailFragment.TAG);
    }

    @Override // com.firebase.ui.auth.ui.email.EmailLinkPromptEmailFragment.b
    public void onEmailPromptSuccess(IdpResponse idpResponse) {
        finish(-1, idpResponse.toIntent());
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(@StringRes int i4) {
        throw new UnsupportedOperationException("Fragments must handle progress updates.");
    }
}
