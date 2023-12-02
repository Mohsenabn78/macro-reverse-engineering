package com.firebase.ui.auth.viewmodel.idp;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
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
import com.firebase.ui.auth.util.FirebaseAuthError;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class SocialProviderResponseHandler extends SignInViewModelBase {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18313b;

        /* renamed from: com.firebase.ui.auth.viewmodel.idp.SocialProviderResponseHandler$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0149a implements OnFailureListener {
            C0149a() {
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(@NonNull Exception exc) {
                SocialProviderResponseHandler.this.j(Resource.forFailure(exc));
            }
        }

        /* loaded from: classes3.dex */
        class b implements OnSuccessListener<List<String>> {
            b() {
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            /* renamed from: a */
            public void onSuccess(List<String> list) {
                if (list.contains(a.this.f18312a.getProviderType())) {
                    a aVar = a.this;
                    SocialProviderResponseHandler.this.h(aVar.f18313b);
                } else if (list.isEmpty()) {
                    SocialProviderResponseHandler.this.j(Resource.forFailure(new FirebaseUiException(3, "No supported providers.")));
                } else {
                    SocialProviderResponseHandler.this.startWelcomeBackFlowForLinking(list.get(0), a.this.f18312a);
                }
            }
        }

        a(IdpResponse idpResponse, AuthCredential authCredential) {
            this.f18312a = idpResponse;
            this.f18313b = authCredential;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            boolean z3 = exc instanceof FirebaseAuthInvalidUserException;
            if ((exc instanceof FirebaseAuthException) && FirebaseAuthError.fromException((FirebaseAuthException) exc) == FirebaseAuthError.ERROR_USER_DISABLED) {
                z3 = true;
            }
            if (z3) {
                SocialProviderResponseHandler.this.j(Resource.forFailure(new FirebaseUiException(12)));
            } else if (exc instanceof FirebaseAuthUserCollisionException) {
                String email = this.f18312a.getEmail();
                if (email == null) {
                    SocialProviderResponseHandler.this.j(Resource.forFailure(exc));
                } else {
                    ProviderUtils.fetchSortedProviders(SocialProviderResponseHandler.this.e(), (FlowParameters) SocialProviderResponseHandler.this.a(), email).addOnSuccessListener(new b()).addOnFailureListener(new C0149a());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18317a;

        b(IdpResponse idpResponse) {
            this.f18317a = idpResponse;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            SocialProviderResponseHandler.this.i(this.f18317a, authResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements OnFailureListener {
        c() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            SocialProviderResponseHandler.this.j(Resource.forFailure(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements OnSuccessListener<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18320a;

        d(IdpResponse idpResponse) {
            this.f18320a = idpResponse;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(@NonNull List<String> list) {
            if (list.isEmpty()) {
                SocialProviderResponseHandler.this.j(Resource.forFailure(new FirebaseUiException(3, "No supported providers.")));
            } else {
                SocialProviderResponseHandler.this.startWelcomeBackFlowForLinking(list.get(0), this.f18320a);
            }
        }
    }

    public SocialProviderResponseHandler(Application application) {
        super(application);
    }

    private void u(@NonNull IdpResponse idpResponse) {
        ProviderUtils.fetchSortedProviders(e(), a(), idpResponse.getEmail()).addOnSuccessListener(new d(idpResponse)).addOnFailureListener(new c());
    }

    private boolean v(@NonNull String str) {
        if (!TextUtils.equals(str, "password") && !TextUtils.equals(str, "phone")) {
            return false;
        }
        return true;
    }

    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        FirebaseUiException error;
        if (i4 == 108) {
            IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
            if (i5 == -1) {
                j(Resource.forSuccess(fromResultIntent));
                return;
            }
            if (fromResultIntent == null) {
                error = new FirebaseUiException(0, "Link canceled by user.");
            } else {
                error = fromResultIntent.getError();
            }
            j(Resource.forFailure(error));
        }
    }

    public void startSignIn(@NonNull IdpResponse idpResponse) {
        if (!idpResponse.isSuccessful() && !idpResponse.isRecoverableErrorResponse()) {
            j(Resource.forFailure(idpResponse.getError()));
        } else if (!v(idpResponse.getProviderType())) {
            j(Resource.forLoading());
            if (idpResponse.hasCredentialForLinking()) {
                u(idpResponse);
                return;
            }
            AuthCredential authCredential = ProviderUtils.getAuthCredential(idpResponse);
            AuthOperationManager.getInstance().signInAndLinkWithCredential(e(), a(), authCredential).continueWithTask(new ProfileMerger(idpResponse)).addOnSuccessListener(new b(idpResponse)).addOnFailureListener(new a(idpResponse, authCredential));
        } else {
            throw new IllegalStateException("This handler cannot be used with email or phone providers");
        }
    }

    public void startWelcomeBackFlowForLinking(String str, IdpResponse idpResponse) {
        if (str != null) {
            if (str.equals("password")) {
                j(Resource.forFailure(new IntentRequiredException(WelcomeBackPasswordPrompt.createIntent(getApplication(), a(), idpResponse), 108)));
                return;
            } else if (str.equals("emailLink")) {
                j(Resource.forFailure(new IntentRequiredException(WelcomeBackEmailLinkPrompt.createIntent(getApplication(), a(), idpResponse), 112)));
                return;
            } else {
                j(Resource.forFailure(new IntentRequiredException(WelcomeBackIdpPrompt.createIntent(getApplication(), a(), new User.Builder(str, idpResponse.getEmail()).build(), idpResponse), 108)));
                return;
            }
        }
        throw new IllegalStateException("No provider even though we received a FirebaseAuthUserCollisionException");
    }
}
