package com.firebase.ui.auth.viewmodel.email;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.remote.ProfileMerger;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.TaskFailureLogger;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class WelcomeBackPasswordHandler extends SignInViewModelBase {

    /* renamed from: f  reason: collision with root package name */
    private String f18287f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnFailureListener {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            WelcomeBackPasswordHandler.this.j(Resource.forFailure(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18289a;

        b(AuthCredential authCredential) {
            this.f18289a = authCredential;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            WelcomeBackPasswordHandler.this.h(this.f18289a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements OnCompleteListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18291a;

        c(AuthCredential authCredential) {
            this.f18291a = authCredential;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                WelcomeBackPasswordHandler.this.h(this.f18291a);
            } else {
                WelcomeBackPasswordHandler.this.j(Resource.forFailure(task.getException()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements OnFailureListener {
        d() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            WelcomeBackPasswordHandler.this.j(Resource.forFailure(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18294a;

        e(IdpResponse idpResponse) {
            this.f18294a = idpResponse;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            WelcomeBackPasswordHandler.this.i(this.f18294a, authResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements Continuation<AuthResult, Task<AuthResult>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18296a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18297b;

        f(AuthCredential authCredential, IdpResponse idpResponse) {
            this.f18296a = authCredential;
            this.f18297b = idpResponse;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<AuthResult> then(@NonNull Task<AuthResult> task) throws Exception {
            AuthResult result = task.getResult(Exception.class);
            if (this.f18296a == null) {
                return Tasks.forResult(result);
            }
            return result.getUser().linkWithCredential(this.f18296a).continueWithTask(new ProfileMerger(this.f18297b)).addOnFailureListener(new TaskFailureLogger("WBPasswordHandler", "linkWithCredential+merge failed."));
        }
    }

    public WelcomeBackPasswordHandler(Application application) {
        super(application);
    }

    public String getPendingPassword() {
        return this.f18287f;
    }

    public void startSignIn(@NonNull String str, @NonNull String str2, @NonNull IdpResponse idpResponse, @Nullable AuthCredential authCredential) {
        IdpResponse build;
        j(Resource.forLoading());
        this.f18287f = str2;
        if (authCredential == null) {
            build = new IdpResponse.Builder(new User.Builder("password", str).build()).build();
        } else {
            build = new IdpResponse.Builder(idpResponse.getUser()).setPendingCredential(idpResponse.getCredentialForLinking()).setToken(idpResponse.getIdpToken()).setSecret(idpResponse.getIdpSecret()).build();
        }
        AuthOperationManager authOperationManager = AuthOperationManager.getInstance();
        if (authOperationManager.canUpgradeAnonymous(e(), a())) {
            AuthCredential credential = EmailAuthProvider.getCredential(str, str2);
            if (AuthUI.SOCIAL_PROVIDERS.contains(idpResponse.getProviderType())) {
                authOperationManager.safeLink(credential, authCredential, a()).addOnSuccessListener(new b(credential)).addOnFailureListener(new a());
                return;
            } else {
                authOperationManager.validateCredential(credential, a()).addOnCompleteListener(new c(credential));
                return;
            }
        }
        e().signInWithEmailAndPassword(str, str2).continueWithTask(new f(authCredential, build)).addOnSuccessListener(new e(build)).addOnFailureListener(new d()).addOnFailureListener(new TaskFailureLogger("WBPasswordHandler", "signInWithEmailAndPassword failed."));
    }
}
