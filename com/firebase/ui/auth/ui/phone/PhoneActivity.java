package com.firebase.ui.auth.ui.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.PhoneNumberVerificationRequiredException;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.FirebaseAuthError;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.phone.PhoneProviderResponseHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuthException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class PhoneActivity extends AppCompatBase {

    /* renamed from: d  reason: collision with root package name */
    private PhoneNumberVerificationHandler f18172d;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<IdpResponse> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ PhoneProviderResponseHandler f18173e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(HelperActivityBase helperActivityBase, int i4, PhoneProviderResponseHandler phoneProviderResponseHandler) {
            super(helperActivityBase, i4);
            this.f18173e = phoneProviderResponseHandler;
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            PhoneActivity.this.r(exc);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            PhoneActivity.this.startSaveCredentials(this.f18173e.getCurrentUser(), idpResponse, null);
        }
    }

    /* loaded from: classes3.dex */
    class b extends ResourceObserver<PhoneVerification> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ PhoneProviderResponseHandler f18175e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(HelperActivityBase helperActivityBase, int i4, PhoneProviderResponseHandler phoneProviderResponseHandler) {
            super(helperActivityBase, i4);
            this.f18175e = phoneProviderResponseHandler;
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (!(exc instanceof PhoneNumberVerificationRequiredException)) {
                PhoneActivity.this.r(exc);
                return;
            }
            if (PhoneActivity.this.getSupportFragmentManager().findFragmentByTag(SubmitConfirmationCodeFragment.TAG) == null) {
                PhoneActivity.this.s(((PhoneNumberVerificationRequiredException) exc).getPhoneNumber());
            }
            PhoneActivity.this.r(null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull PhoneVerification phoneVerification) {
            if (phoneVerification.isAutoVerified()) {
                Toast.makeText(PhoneActivity.this, R.string.fui_auto_verified, 1).show();
                FragmentManager supportFragmentManager = PhoneActivity.this.getSupportFragmentManager();
                if (supportFragmentManager.findFragmentByTag(SubmitConfirmationCodeFragment.TAG) != null) {
                    supportFragmentManager.popBackStack();
                }
            }
            this.f18175e.startSignIn(phoneVerification.getCredential(), new IdpResponse.Builder(new User.Builder("phone", null).setPhoneNumber(phoneVerification.getNumber()).build()).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18177a;

        static {
            int[] iArr = new int[FirebaseAuthError.values().length];
            f18177a = iArr;
            try {
                iArr[FirebaseAuthError.ERROR_INVALID_PHONE_NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18177a[FirebaseAuthError.ERROR_TOO_MANY_REQUESTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18177a[FirebaseAuthError.ERROR_QUOTA_EXCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18177a[FirebaseAuthError.ERROR_INVALID_VERIFICATION_CODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18177a[FirebaseAuthError.ERROR_SESSION_EXPIRED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters, Bundle bundle) {
        return HelperActivityBase.h(context, PhoneActivity.class, flowParameters).putExtra(ExtraConstants.PARAMS, bundle);
    }

    @NonNull
    private FragmentBase o() {
        FragmentBase fragmentBase = (CheckPhoneNumberFragment) getSupportFragmentManager().findFragmentByTag(CheckPhoneNumberFragment.TAG);
        if (fragmentBase == null || fragmentBase.getView() == null) {
            fragmentBase = (SubmitConfirmationCodeFragment) getSupportFragmentManager().findFragmentByTag(SubmitConfirmationCodeFragment.TAG);
        }
        if (fragmentBase != null && fragmentBase.getView() != null) {
            return fragmentBase;
        }
        throw new IllegalStateException("No fragments added");
    }

    private String p(FirebaseAuthError firebaseAuthError) {
        int i4 = c.f18177a[firebaseAuthError.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return firebaseAuthError.getDescription();
                        }
                        return getString(R.string.fui_error_session_expired);
                    }
                    return getString(R.string.fui_incorrect_code_dialog_body);
                }
                return getString(R.string.fui_error_quota_exceeded);
            }
            return getString(R.string.fui_error_too_many_attempts);
        }
        return getString(R.string.fui_invalid_phone_number);
    }

    @Nullable
    private TextInputLayout q() {
        CheckPhoneNumberFragment checkPhoneNumberFragment = (CheckPhoneNumberFragment) getSupportFragmentManager().findFragmentByTag(CheckPhoneNumberFragment.TAG);
        SubmitConfirmationCodeFragment submitConfirmationCodeFragment = (SubmitConfirmationCodeFragment) getSupportFragmentManager().findFragmentByTag(SubmitConfirmationCodeFragment.TAG);
        if (checkPhoneNumberFragment != null && checkPhoneNumberFragment.getView() != null) {
            return (TextInputLayout) checkPhoneNumberFragment.getView().findViewById(R.id.phone_layout);
        }
        if (submitConfirmationCodeFragment != null && submitConfirmationCodeFragment.getView() != null) {
            return (TextInputLayout) submitConfirmationCodeFragment.getView().findViewById(R.id.confirmation_code_layout);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(@Nullable Exception exc) {
        TextInputLayout q4 = q();
        if (q4 == null) {
            return;
        }
        if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
            finish(5, ((FirebaseAuthAnonymousUpgradeException) exc).getResponse().toIntent());
        } else if (exc instanceof FirebaseAuthException) {
            FirebaseAuthError fromException = FirebaseAuthError.fromException((FirebaseAuthException) exc);
            if (fromException == FirebaseAuthError.ERROR_USER_DISABLED) {
                finish(0, IdpResponse.from(new FirebaseUiException(12)).toIntent());
            } else {
                q4.setError(p(fromException));
            }
        } else if (exc != null) {
            q4.setError(p(FirebaseAuthError.ERROR_UNKNOWN));
        } else {
            q4.setError(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_phone, SubmitConfirmationCodeFragment.newInstance(str), SubmitConfirmationCodeFragment.TAG).addToBackStack(null).commit();
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        o().hideProgress();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_activity_register_phone);
        PhoneProviderResponseHandler phoneProviderResponseHandler = (PhoneProviderResponseHandler) new ViewModelProvider(this).get(PhoneProviderResponseHandler.class);
        phoneProviderResponseHandler.init(getFlowParams());
        phoneProviderResponseHandler.getOperation().observe(this, new a(this, R.string.fui_progress_dialog_signing_in, phoneProviderResponseHandler));
        PhoneNumberVerificationHandler phoneNumberVerificationHandler = (PhoneNumberVerificationHandler) new ViewModelProvider(this).get(PhoneNumberVerificationHandler.class);
        this.f18172d = phoneNumberVerificationHandler;
        phoneNumberVerificationHandler.init(getFlowParams());
        this.f18172d.onRestoreInstanceState(bundle);
        this.f18172d.getOperation().observe(this, new b(this, R.string.fui_verifying, phoneProviderResponseHandler));
        if (bundle != null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_phone, CheckPhoneNumberFragment.newInstance(getIntent().getExtras().getBundle(ExtraConstants.PARAMS)), CheckPhoneNumberFragment.TAG).disallowAddToBackStack().commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f18172d.onSaveInstanceState(bundle);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        o().showProgress(i4);
    }
}
