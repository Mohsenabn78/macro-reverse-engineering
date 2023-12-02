package com.firebase.ui.auth.viewmodel.email;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.remote.ProfileMerger;
import com.firebase.ui.auth.ui.email.WelcomeBackEmailLinkPrompt;
import com.firebase.ui.auth.ui.email.WelcomeBackPasswordPrompt;
import com.firebase.ui.auth.ui.idp.WelcomeBackIdpPrompt;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.util.data.TaskFailureLogger;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailProviderResponseHandler extends SignInViewModelBase {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AuthOperationManager f18276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18277b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18278c;

        /* renamed from: com.firebase.ui.auth.viewmodel.email.EmailProviderResponseHandler$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0148a implements OnFailureListener {
            C0148a() {
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(@NonNull Exception exc) {
                EmailProviderResponseHandler.this.j(Resource.forFailure(exc));
            }
        }

        a(AuthOperationManager authOperationManager, String str, String str2) {
            this.f18276a = authOperationManager;
            this.f18277b = str;
            this.f18278c = str2;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            if (!(exc instanceof FirebaseAuthUserCollisionException)) {
                EmailProviderResponseHandler.this.j(Resource.forFailure(exc));
            } else if (this.f18276a.canUpgradeAnonymous(EmailProviderResponseHandler.this.e(), (FlowParameters) EmailProviderResponseHandler.this.a())) {
                EmailProviderResponseHandler.this.h(EmailAuthProvider.getCredential(this.f18277b, this.f18278c));
            } else {
                Log.w("EmailProviderResponseHa", "Got a collision error during a non-upgrade flow", exc);
                ProviderUtils.fetchTopProvider(EmailProviderResponseHandler.this.e(), (FlowParameters) EmailProviderResponseHandler.this.a(), this.f18277b).addOnSuccessListener(new c(this.f18277b)).addOnFailureListener(new C0148a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18281a;

        b(IdpResponse idpResponse) {
            this.f18281a = idpResponse;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            EmailProviderResponseHandler.this.i(this.f18281a, authResult);
        }
    }

    /* loaded from: classes3.dex */
    private class c implements OnSuccessListener<String> {

        /* renamed from: a  reason: collision with root package name */
        private final String f18283a;

        public c(String str) {
            this.f18283a = str;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(@Nullable String str) {
            if (str == null) {
                Log.w("EmailProviderResponseHa", "No providers known for user (" + this.f18283a + ") this email address may be reserved.");
                EmailProviderResponseHandler.this.j(Resource.forFailure(new FirebaseUiException(0)));
            } else if ("password".equalsIgnoreCase(str)) {
                EmailProviderResponseHandler.this.j(Resource.forFailure(new IntentRequiredException(WelcomeBackPasswordPrompt.createIntent(EmailProviderResponseHandler.this.getApplication(), (FlowParameters) EmailProviderResponseHandler.this.a(), new IdpResponse.Builder(new User.Builder("password", this.f18283a).build()).build()), 104)));
            } else if ("emailLink".equalsIgnoreCase(str)) {
                EmailProviderResponseHandler.this.j(Resource.forFailure(new IntentRequiredException(WelcomeBackEmailLinkPrompt.createIntent(EmailProviderResponseHandler.this.getApplication(), (FlowParameters) EmailProviderResponseHandler.this.a(), new IdpResponse.Builder(new User.Builder("emailLink", this.f18283a).build()).build()), 112)));
            } else {
                EmailProviderResponseHandler.this.j(Resource.forFailure(new IntentRequiredException(WelcomeBackIdpPrompt.createIntent(EmailProviderResponseHandler.this.getApplication(), (FlowParameters) EmailProviderResponseHandler.this.a(), new User.Builder(str, this.f18283a).build()), 103)));
            }
        }
    }

    public EmailProviderResponseHandler(Application application) {
        super(application);
    }

    public void startSignIn(@NonNull IdpResponse idpResponse, @NonNull String str) {
        if (!idpResponse.isSuccessful()) {
            j(Resource.forFailure(idpResponse.getError()));
        } else if (idpResponse.getProviderType().equals("password")) {
            j(Resource.forLoading());
            AuthOperationManager authOperationManager = AuthOperationManager.getInstance();
            String email = idpResponse.getEmail();
            authOperationManager.createOrLinkUserWithEmailAndPassword(e(), a(), email, str).continueWithTask(new ProfileMerger(idpResponse)).addOnFailureListener(new TaskFailureLogger("EmailProviderResponseHa", "Error creating user")).addOnSuccessListener(new b(idpResponse)).addOnFailureListener(new a(authOperationManager, email, str));
        } else {
            throw new IllegalStateException("This handler can only be used with the email provider");
        }
    }
}
