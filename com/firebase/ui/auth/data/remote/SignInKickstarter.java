package com.firebase.ui.auth.data.remote;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.ui.email.EmailActivity;
import com.firebase.ui.auth.ui.email.EmailLinkCatcherActivity;
import com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity;
import com.firebase.ui.auth.ui.idp.SingleSignInActivity;
import com.firebase.ui.auth.ui.phone.PhoneActivity;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.GoogleApiUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResponse;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SignInKickstarter extends SignInViewModelBase {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnFailureListener {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            SignInKickstarter.this.j(Resource.forFailure(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnSuccessListener<AuthResult> {
        b() {
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            SignInKickstarter.this.i(new IdpResponse.Builder(new User.Builder(authResult.getCredential().getProvider(), authResult.getUser().getEmail()).build()).build(), authResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements OnCompleteListener<CredentialRequestResponse> {
        c() {
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<CredentialRequestResponse> task) {
            try {
                SignInKickstarter.this.r(task.getResult(ApiException.class).getCredential());
            } catch (ResolvableApiException e4) {
                if (e4.getStatusCode() == 6) {
                    SignInKickstarter.this.j(Resource.forFailure(new PendingIntentRequiredException(e4.getResolution(), 101)));
                } else {
                    SignInKickstarter.this.t();
                }
            } catch (ApiException unused) {
                SignInKickstarter.this.t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Credential f18027a;

        d(Credential credential) {
            this.f18027a = credential;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            if ((exc instanceof FirebaseAuthInvalidUserException) || (exc instanceof FirebaseAuthInvalidCredentialsException)) {
                GoogleApiUtils.getCredentialsClient(SignInKickstarter.this.getApplication()).delete(this.f18027a);
            }
            SignInKickstarter.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18029a;

        e(IdpResponse idpResponse) {
            this.f18029a = idpResponse;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            SignInKickstarter.this.i(this.f18029a, authResult);
        }
    }

    public SignInKickstarter(Application application) {
        super(application);
    }

    private List<String> q() {
        ArrayList arrayList = new ArrayList();
        for (AuthUI.IdpConfig idpConfig : a().providers) {
            String providerId = idpConfig.getProviderId();
            if (providerId.equals("google.com")) {
                arrayList.add(ProviderUtils.providerIdToAccountType(providerId));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Credential credential) {
        String id = credential.getId();
        String password = credential.getPassword();
        if (TextUtils.isEmpty(password)) {
            if (credential.getAccountType() == null) {
                t();
                return;
            } else {
                s(ProviderUtils.accountTypeToProviderId(credential.getAccountType()), id);
                return;
            }
        }
        IdpResponse build = new IdpResponse.Builder(new User.Builder("password", id).build()).build();
        j(Resource.forLoading());
        e().signInWithEmailAndPassword(id, password).addOnSuccessListener(new e(build)).addOnFailureListener(new d(credential));
    }

    private void s(String str, String str2) {
        str.hashCode();
        if (!str.equals("phone")) {
            if (!str.equals("password")) {
                j(Resource.forFailure(new IntentRequiredException(SingleSignInActivity.createIntent(getApplication(), a(), new User.Builder(str, str2).build()), 109)));
                return;
            } else {
                j(Resource.forFailure(new IntentRequiredException(EmailActivity.createIntent(getApplication(), a(), str2), 106)));
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(ExtraConstants.PHONE, str2);
        j(Resource.forFailure(new IntentRequiredException(PhoneActivity.createIntent(getApplication(), a(), bundle), 107)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (!a().shouldShowProviderChoice()) {
            AuthUI.IdpConfig defaultOrFirstProvider = a().getDefaultOrFirstProvider();
            String providerId = defaultOrFirstProvider.getProviderId();
            providerId.hashCode();
            char c4 = 65535;
            switch (providerId.hashCode()) {
                case 106642798:
                    if (providerId.equals("phone")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 1216985755:
                    if (providerId.equals("password")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 2120171958:
                    if (providerId.equals("emailLink")) {
                        c4 = 2;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    j(Resource.forFailure(new IntentRequiredException(PhoneActivity.createIntent(getApplication(), a(), defaultOrFirstProvider.getParams()), 107)));
                    return;
                case 1:
                case 2:
                    j(Resource.forFailure(new IntentRequiredException(EmailActivity.createIntent(getApplication(), a()), 106)));
                    return;
                default:
                    s(providerId, null);
                    return;
            }
        }
        j(Resource.forFailure(new IntentRequiredException(AuthMethodPickerActivity.createIntent(getApplication(), a()), 105)));
    }

    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (i4 != 101) {
            if (i4 != 109) {
                switch (i4) {
                    case 105:
                    case 106:
                    case 107:
                        break;
                    default:
                        return;
                }
            }
            if (i5 != 113 && i5 != 114) {
                IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
                if (fromResultIntent == null) {
                    j(Resource.forFailure(new UserCancellationException()));
                    return;
                } else if (fromResultIntent.isSuccessful()) {
                    j(Resource.forSuccess(fromResultIntent));
                    return;
                } else if (fromResultIntent.getError().getErrorCode() == 5) {
                    g(fromResultIntent);
                    return;
                } else {
                    j(Resource.forFailure(fromResultIntent.getError()));
                    return;
                }
            }
            t();
        } else if (i5 == -1) {
            r((Credential) intent.getParcelableExtra(Credential.EXTRA_KEY));
        } else {
            t();
        }
    }

    public void start() {
        boolean z3;
        if (!TextUtils.isEmpty(a().emailLink)) {
            j(Resource.forFailure(new IntentRequiredException(EmailLinkCatcherActivity.createIntent(getApplication(), a()), 106)));
            return;
        }
        Task<AuthResult> pendingAuthResult = e().getPendingAuthResult();
        if (pendingAuthResult != null) {
            pendingAuthResult.addOnSuccessListener(new b()).addOnFailureListener(new a());
            return;
        }
        boolean z4 = true;
        if (ProviderUtils.getConfigFromIdps(a().providers, "password") != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        List<String> q4 = q();
        if (!z3 && q4.size() <= 0) {
            z4 = false;
        }
        if (a().enableCredentials && z4) {
            j(Resource.forLoading());
            GoogleApiUtils.getCredentialsClient(getApplication()).request(new CredentialRequest.Builder().setPasswordLoginSupported(z3).setAccountTypes((String[]) q4.toArray(new String[q4.size()])).build()).addOnCompleteListener(new c());
            return;
        }
        t();
    }
}
