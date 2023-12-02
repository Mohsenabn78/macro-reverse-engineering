package com.firebase.ui.auth.ui.email;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.InvisibleActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.email.EmailLinkSignInHandler;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailLinkCatcherActivity extends InvisibleActivityBase {

    /* renamed from: g  reason: collision with root package name */
    private EmailLinkSignInHandler f18060g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends ResourceObserver<IdpResponse> {
        a(HelperActivityBase helperActivityBase) {
            super(helperActivityBase);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof UserCancellationException) {
                EmailLinkCatcherActivity.this.finish(0, null);
            } else if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                EmailLinkCatcherActivity.this.finish(0, new Intent().putExtra(ExtraConstants.IDP_RESPONSE, ((FirebaseAuthAnonymousUpgradeException) exc).getResponse()));
            } else if (exc instanceof FirebaseUiException) {
                int errorCode = ((FirebaseUiException) exc).getErrorCode();
                if (errorCode != 8 && errorCode != 7 && errorCode != 11) {
                    if (errorCode == 9 || errorCode == 6) {
                        EmailLinkCatcherActivity.this.q(115);
                        return;
                    } else if (errorCode == 10) {
                        EmailLinkCatcherActivity.this.q(116);
                        return;
                    } else {
                        return;
                    }
                }
                EmailLinkCatcherActivity.this.o(errorCode).show();
            } else if (exc instanceof FirebaseAuthInvalidCredentialsException) {
                EmailLinkCatcherActivity.this.q(115);
            } else {
                EmailLinkCatcherActivity.this.finish(0, IdpResponse.getErrorIntent(exc));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            EmailLinkCatcherActivity.this.finish(-1, idpResponse.toIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f18062a;

        b(int i4) {
            this.f18062a = i4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            EmailLinkCatcherActivity.this.finish(this.f18062a, null);
        }
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters) {
        return HelperActivityBase.h(context, EmailLinkCatcherActivity.class, flowParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog o(int i4) {
        String string;
        String string2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (i4 == 11) {
            string = getString(R.string.fui_email_link_different_anonymous_user_header);
            string2 = getString(R.string.fui_email_link_different_anonymous_user_message);
        } else if (i4 == 7) {
            string = getString(R.string.fui_email_link_invalid_link_header);
            string2 = getString(R.string.fui_email_link_invalid_link_message);
        } else {
            string = getString(R.string.fui_email_link_wrong_device_header);
            string2 = getString(R.string.fui_email_link_wrong_device_message);
        }
        return builder.setTitle(string).setMessage(string2).setPositiveButton(R.string.fui_email_link_dismiss_button, new b(i4)).create();
    }

    private void p() {
        EmailLinkSignInHandler emailLinkSignInHandler = (EmailLinkSignInHandler) new ViewModelProvider(this).get(EmailLinkSignInHandler.class);
        this.f18060g = emailLinkSignInHandler;
        emailLinkSignInHandler.init(getFlowParams());
        this.f18060g.getOperation().observe(this, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i4) {
        if (i4 != 116 && i4 != 115) {
            throw new IllegalStateException("Invalid flow param. It must be either RequestCodes.EMAIL_LINK_CROSS_DEVICE_LINKING_FLOW or RequestCodes.EMAIL_LINK_PROMPT_FOR_EMAIL_FLOW");
        }
        startActivityForResult(EmailLinkErrorRecoveryActivity.createIntent(getApplicationContext(), getFlowParams(), i4), i4);
    }

    @Override // com.firebase.ui.auth.ui.HelperActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 115 || i4 == 116) {
            IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
            if (i5 == -1) {
                finish(-1, fromResultIntent.toIntent());
            } else {
                finish(0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.InvisibleActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p();
        if (getFlowParams().emailLink != null) {
            this.f18060g.startSignIn();
        }
    }
}
