package com.firebase.ui.auth.viewmodel.email;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.remote.ProfileMerger;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.EmailLinkParser;
import com.firebase.ui.auth.util.data.EmailLinkPersistenceManager;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.util.data.TaskFailureLogger;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes3.dex */
public class EmailLinkSignInHandler extends SignInViewModelBase {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnCompleteListener<ActionCodeResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18260a;

        a(String str) {
            this.f18260a = str;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<ActionCodeResult> task) {
            if (!task.isSuccessful()) {
                EmailLinkSignInHandler.this.j(Resource.forFailure(new FirebaseUiException(7)));
            } else if (!TextUtils.isEmpty(this.f18260a)) {
                EmailLinkSignInHandler.this.j(Resource.forFailure(new FirebaseUiException(10)));
            } else {
                EmailLinkSignInHandler.this.j(Resource.forFailure(new FirebaseUiException(9)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnCompleteListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EmailLinkPersistenceManager f18262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18263b;

        b(EmailLinkPersistenceManager emailLinkPersistenceManager, AuthCredential authCredential) {
            this.f18262a = emailLinkPersistenceManager;
            this.f18263b = authCredential;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<AuthResult> task) {
            this.f18262a.clearAllData(EmailLinkSignInHandler.this.getApplication());
            if (task.isSuccessful()) {
                EmailLinkSignInHandler.this.h(this.f18263b);
            } else {
                EmailLinkSignInHandler.this.j(Resource.forFailure(task.getException()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements OnFailureListener {
        c() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            EmailLinkSignInHandler.this.j(Resource.forFailure(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements OnSuccessListener<AuthResult> {
        d() {
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            FirebaseUser user = authResult.getUser();
            EmailLinkSignInHandler.this.i(new IdpResponse.Builder(new User.Builder("emailLink", user.getEmail()).setName(user.getDisplayName()).setPhotoUri(user.getPhotoUrl()).build()).build(), authResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements Continuation<AuthResult, Task<AuthResult>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EmailLinkPersistenceManager f18267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18268b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18269c;

        e(EmailLinkPersistenceManager emailLinkPersistenceManager, AuthCredential authCredential, IdpResponse idpResponse) {
            this.f18267a = emailLinkPersistenceManager;
            this.f18268b = authCredential;
            this.f18269c = idpResponse;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<AuthResult> then(@NonNull Task<AuthResult> task) {
            this.f18267a.clearAllData(EmailLinkSignInHandler.this.getApplication());
            if (!task.isSuccessful()) {
                return task;
            }
            return task.getResult().getUser().linkWithCredential(this.f18268b).continueWithTask(new ProfileMerger(this.f18269c)).addOnFailureListener(new TaskFailureLogger("EmailLinkSignInHandler", "linkWithCredential+merge failed."));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EmailLinkPersistenceManager f18271a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18272b;

        f(EmailLinkPersistenceManager emailLinkPersistenceManager, AuthCredential authCredential) {
            this.f18271a = emailLinkPersistenceManager;
            this.f18272b = authCredential;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            this.f18271a.clearAllData(EmailLinkSignInHandler.this.getApplication());
            if (exc instanceof FirebaseAuthUserCollisionException) {
                EmailLinkSignInHandler.this.h(this.f18272b);
            } else {
                EmailLinkSignInHandler.this.j(Resource.forFailure(exc));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements OnSuccessListener<AuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EmailLinkPersistenceManager f18274a;

        g(EmailLinkPersistenceManager emailLinkPersistenceManager) {
            this.f18274a = emailLinkPersistenceManager;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(AuthResult authResult) {
            this.f18274a.clearAllData(EmailLinkSignInHandler.this.getApplication());
            FirebaseUser user = authResult.getUser();
            EmailLinkSignInHandler.this.i(new IdpResponse.Builder(new User.Builder("emailLink", user.getEmail()).setName(user.getDisplayName()).setPhotoUri(user.getPhotoUrl()).build()).build(), authResult);
        }
    }

    public EmailLinkSignInHandler(Application application) {
        super(application);
    }

    private void u(@NonNull String str, @Nullable String str2) {
        e().checkActionCode(str).addOnCompleteListener(new a(str2));
    }

    private void v(EmailLinkPersistenceManager.SessionRecord sessionRecord) {
        w(sessionRecord.getEmail(), sessionRecord.getIdpResponseForLinking());
    }

    private void w(@NonNull String str, @Nullable IdpResponse idpResponse) {
        if (TextUtils.isEmpty(str)) {
            j(Resource.forFailure(new FirebaseUiException(6)));
            return;
        }
        AuthOperationManager authOperationManager = AuthOperationManager.getInstance();
        EmailLinkPersistenceManager emailLinkPersistenceManager = EmailLinkPersistenceManager.getInstance();
        String str2 = a().emailLink;
        if (idpResponse == null) {
            y(authOperationManager, emailLinkPersistenceManager, str, str2);
        } else {
            x(authOperationManager, emailLinkPersistenceManager, idpResponse, str2);
        }
    }

    private void x(AuthOperationManager authOperationManager, EmailLinkPersistenceManager emailLinkPersistenceManager, IdpResponse idpResponse, String str) {
        AuthCredential authCredential = ProviderUtils.getAuthCredential(idpResponse);
        AuthCredential credentialWithLink = EmailAuthProvider.getCredentialWithLink(idpResponse.getEmail(), str);
        if (authOperationManager.canUpgradeAnonymous(e(), a())) {
            authOperationManager.safeLink(credentialWithLink, authCredential, a()).addOnCompleteListener(new b(emailLinkPersistenceManager, authCredential));
        } else {
            e().signInWithCredential(credentialWithLink).continueWithTask(new e(emailLinkPersistenceManager, authCredential, idpResponse)).addOnSuccessListener(new d()).addOnFailureListener(new c());
        }
    }

    private void y(AuthOperationManager authOperationManager, EmailLinkPersistenceManager emailLinkPersistenceManager, String str, String str2) {
        authOperationManager.signInAndLinkWithCredential(e(), a(), EmailAuthProvider.getCredentialWithLink(str, str2)).addOnSuccessListener(new g(emailLinkPersistenceManager)).addOnFailureListener(new f(emailLinkPersistenceManager, EmailAuthProvider.getCredentialWithLink(str, str2)));
    }

    private boolean z(EmailLinkPersistenceManager.SessionRecord sessionRecord, String str) {
        if (sessionRecord != null && !TextUtils.isEmpty(sessionRecord.getSessionId()) && !TextUtils.isEmpty(str) && str.equals(sessionRecord.getSessionId())) {
            return false;
        }
        return true;
    }

    public void finishSignIn(String str) {
        j(Resource.forLoading());
        w(str, null);
    }

    public void startSignIn() {
        j(Resource.forLoading());
        String str = a().emailLink;
        if (!e().isSignInWithEmailLink(str)) {
            j(Resource.forFailure(new FirebaseUiException(7)));
            return;
        }
        EmailLinkPersistenceManager.SessionRecord retrieveSessionRecord = EmailLinkPersistenceManager.getInstance().retrieveSessionRecord(getApplication());
        EmailLinkParser emailLinkParser = new EmailLinkParser(str);
        String sessionId = emailLinkParser.getSessionId();
        String anonymousUserId = emailLinkParser.getAnonymousUserId();
        String oobCode = emailLinkParser.getOobCode();
        String providerId = emailLinkParser.getProviderId();
        boolean forceSameDeviceBit = emailLinkParser.getForceSameDeviceBit();
        if (z(retrieveSessionRecord, sessionId)) {
            if (TextUtils.isEmpty(sessionId)) {
                j(Resource.forFailure(new FirebaseUiException(7)));
            } else if (!forceSameDeviceBit && TextUtils.isEmpty(anonymousUserId)) {
                u(oobCode, providerId);
            } else {
                j(Resource.forFailure(new FirebaseUiException(8)));
            }
        } else if (anonymousUserId != null && (e().getCurrentUser() == null || (e().getCurrentUser().isAnonymous() && !anonymousUserId.equals(e().getCurrentUser().getUid())))) {
            j(Resource.forFailure(new FirebaseUiException(11)));
        } else {
            v(retrieveSessionRecord);
        }
    }
}
