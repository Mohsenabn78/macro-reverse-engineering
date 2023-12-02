package com.firebase.ui.auth.ui.phone;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.firebase.ui.auth.data.model.PhoneNumberVerificationRequiredException;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class PhoneNumberVerificationHandler extends AuthViewModelBase<PhoneVerification> {

    /* renamed from: f  reason: collision with root package name */
    private String f18178f;

    /* renamed from: g  reason: collision with root package name */
    private PhoneAuthProvider.ForceResendingToken f18179g;

    /* loaded from: classes3.dex */
    class a extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18180a;

        a(String str) {
            this.f18180a = str;
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onCodeSent(@NonNull String str, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            PhoneNumberVerificationHandler.this.f18178f = str;
            PhoneNumberVerificationHandler.this.f18179g = forceResendingToken;
            PhoneNumberVerificationHandler.this.d(Resource.forFailure(new PhoneNumberVerificationRequiredException(this.f18180a)));
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            PhoneNumberVerificationHandler.this.d(Resource.forSuccess(new PhoneVerification(this.f18180a, phoneAuthCredential, true)));
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onVerificationFailed(@NonNull FirebaseException firebaseException) {
            PhoneNumberVerificationHandler.this.d(Resource.forFailure(firebaseException));
        }
    }

    public PhoneNumberVerificationHandler(Application application) {
        super(application);
    }

    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        if (this.f18178f == null && bundle != null) {
            this.f18178f = bundle.getString("verification_id");
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putString("verification_id", this.f18178f);
    }

    public void submitVerificationCode(String str, String str2) {
        d(Resource.forSuccess(new PhoneVerification(str, PhoneAuthProvider.getCredential(this.f18178f, str2), false)));
    }

    public void verifyPhoneNumber(@NonNull Activity activity, String str, boolean z3) {
        d(Resource.forLoading());
        PhoneAuthOptions.Builder callbacks = PhoneAuthOptions.newBuilder(e()).setPhoneNumber(str).setTimeout(120L, TimeUnit.SECONDS).setActivity(activity).setCallbacks(new a(str));
        if (z3) {
            callbacks.setForceResendingToken(this.f18179g);
        }
        PhoneAuthProvider.verifyPhoneNumber(callbacks.build());
    }
}
