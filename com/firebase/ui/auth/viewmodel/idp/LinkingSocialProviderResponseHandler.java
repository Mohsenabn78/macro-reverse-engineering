package com.firebase.ui.auth.viewmodel.idp;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class LinkingSocialProviderResponseHandler extends SignInViewModelBase {

    /* renamed from: f  reason: collision with root package name */
    private AuthCredential f18299f;

    /* renamed from: g  reason: collision with root package name */
    private String f18300g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnFailureListener {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            Resource.forFailure(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18302a;

        b(IdpResponse idpResponse) {
            this.f18302a = idpResponse;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            LinkingSocialProviderResponseHandler.this.i(this.f18302a, authResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements OnFailureListener {
        c() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            LinkingSocialProviderResponseHandler.this.j(Resource.forFailure(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18305a;

        d(AuthCredential authCredential) {
            this.f18305a = authCredential;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            LinkingSocialProviderResponseHandler.this.h(this.f18305a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements OnCompleteListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18307a;

        e(IdpResponse idpResponse) {
            this.f18307a = idpResponse;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                LinkingSocialProviderResponseHandler.this.i(this.f18307a, task.getResult());
            } else {
                LinkingSocialProviderResponseHandler.this.j(Resource.forFailure(task.getException()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements Continuation<AuthResult, Task<AuthResult>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements Continuation<AuthResult, AuthResult> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AuthResult f18310a;

            a(AuthResult authResult) {
                this.f18310a = authResult;
            }

            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public AuthResult then(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    return task.getResult();
                }
                return this.f18310a;
            }
        }

        f() {
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<AuthResult> then(@NonNull Task<AuthResult> task) {
            AuthResult result = task.getResult();
            if (LinkingSocialProviderResponseHandler.this.f18299f == null) {
                return Tasks.forResult(result);
            }
            return result.getUser().linkWithCredential(LinkingSocialProviderResponseHandler.this.f18299f).continueWith(new a(result));
        }
    }

    public LinkingSocialProviderResponseHandler(Application application) {
        super(application);
    }

    private boolean q(@NonNull String str) {
        if (AuthUI.SUPPORTED_OAUTH_PROVIDERS.contains(str) && this.f18299f != null && e().getCurrentUser() != null && !e().getCurrentUser().isAnonymous()) {
            return true;
        }
        return false;
    }

    private boolean r(@NonNull String str) {
        if (!TextUtils.equals(str, "password") && !TextUtils.equals(str, "phone")) {
            return false;
        }
        return true;
    }

    public boolean hasCredentialForLinking() {
        if (this.f18299f != null) {
            return true;
        }
        return false;
    }

    public void setRequestedSignInCredentialForEmail(@Nullable AuthCredential authCredential, @Nullable String str) {
        this.f18299f = authCredential;
        this.f18300g = str;
    }

    public void startSignIn(@NonNull IdpResponse idpResponse) {
        if (!idpResponse.isSuccessful()) {
            j(Resource.forFailure(idpResponse.getError()));
        } else if (!r(idpResponse.getProviderType())) {
            String str = this.f18300g;
            if (str != null && !str.equals(idpResponse.getEmail())) {
                j(Resource.forFailure(new FirebaseUiException(6)));
                return;
            }
            j(Resource.forLoading());
            if (q(idpResponse.getProviderType())) {
                e().getCurrentUser().linkWithCredential(this.f18299f).addOnSuccessListener(new b(idpResponse)).addOnFailureListener(new a());
                return;
            }
            AuthOperationManager authOperationManager = AuthOperationManager.getInstance();
            AuthCredential authCredential = ProviderUtils.getAuthCredential(idpResponse);
            if (authOperationManager.canUpgradeAnonymous(e(), a())) {
                AuthCredential authCredential2 = this.f18299f;
                if (authCredential2 == null) {
                    h(authCredential);
                    return;
                } else {
                    authOperationManager.safeLink(authCredential, authCredential2, a()).addOnSuccessListener(new d(authCredential)).addOnFailureListener(new c());
                    return;
                }
            }
            e().signInWithCredential(authCredential).continueWithTask(new f()).addOnCompleteListener(new e(idpResponse));
        } else {
            throw new IllegalStateException("This handler cannot be used to link email or phone providers.");
        }
    }
}
