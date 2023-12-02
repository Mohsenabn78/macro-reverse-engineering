package com.firebase.ui.auth.util.data;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class AuthOperationManager {

    /* renamed from: a  reason: collision with root package name */
    private static String f18207a = "FUIScratchApp";

    /* renamed from: b  reason: collision with root package name */
    private static AuthOperationManager f18208b;
    @VisibleForTesting
    public FirebaseAuth mScratchAuth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Continuation<AuthResult, Task<AuthResult>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AuthCredential f18209a;

        a(AuthCredential authCredential) {
            this.f18209a = authCredential;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<AuthResult> then(@NonNull Task<AuthResult> task) throws Exception {
            if (task.isSuccessful()) {
                return task.getResult().getUser().linkWithCredential(this.f18209a);
            }
            return task;
        }
    }

    private AuthOperationManager() {
    }

    private FirebaseApp a(FirebaseApp firebaseApp) {
        try {
            return FirebaseApp.getInstance(f18207a);
        } catch (IllegalStateException unused) {
            return FirebaseApp.initializeApp(firebaseApp.getApplicationContext(), firebaseApp.getOptions(), f18207a);
        }
    }

    private FirebaseAuth b(FlowParameters flowParameters) {
        if (this.mScratchAuth == null) {
            AuthUI authUI = AuthUI.getInstance(flowParameters.appName);
            this.mScratchAuth = FirebaseAuth.getInstance(a(authUI.getApp()));
            if (authUI.isUseEmulator()) {
                this.mScratchAuth.useEmulator(authUI.getEmulatorHost(), authUI.getEmulatorPort());
            }
        }
        return this.mScratchAuth;
    }

    public static synchronized AuthOperationManager getInstance() {
        AuthOperationManager authOperationManager;
        synchronized (AuthOperationManager.class) {
            if (f18208b == null) {
                f18208b = new AuthOperationManager();
            }
            authOperationManager = f18208b;
        }
        return authOperationManager;
    }

    public boolean canUpgradeAnonymous(FirebaseAuth firebaseAuth, FlowParameters flowParameters) {
        if (flowParameters.isAnonymousUpgradeEnabled() && firebaseAuth.getCurrentUser() != null && firebaseAuth.getCurrentUser().isAnonymous()) {
            return true;
        }
        return false;
    }

    public Task<AuthResult> createOrLinkUserWithEmailAndPassword(@NonNull FirebaseAuth firebaseAuth, @NonNull FlowParameters flowParameters, @NonNull String str, @NonNull String str2) {
        if (canUpgradeAnonymous(firebaseAuth, flowParameters)) {
            return firebaseAuth.getCurrentUser().linkWithCredential(EmailAuthProvider.getCredential(str, str2));
        }
        return firebaseAuth.createUserWithEmailAndPassword(str, str2);
    }

    @NonNull
    public Task<AuthResult> safeGenericIdpSignIn(@NonNull HelperActivityBase helperActivityBase, @NonNull OAuthProvider oAuthProvider, @NonNull FlowParameters flowParameters) {
        return b(flowParameters).startActivityForSignInWithProvider(helperActivityBase, oAuthProvider);
    }

    public Task<AuthResult> safeLink(AuthCredential authCredential, AuthCredential authCredential2, FlowParameters flowParameters) {
        return b(flowParameters).signInWithCredential(authCredential).continueWithTask(new a(authCredential2));
    }

    public Task<AuthResult> signInAndLinkWithCredential(@NonNull FirebaseAuth firebaseAuth, @NonNull FlowParameters flowParameters, @NonNull AuthCredential authCredential) {
        if (canUpgradeAnonymous(firebaseAuth, flowParameters)) {
            return firebaseAuth.getCurrentUser().linkWithCredential(authCredential);
        }
        return firebaseAuth.signInWithCredential(authCredential);
    }

    @NonNull
    public Task<AuthResult> validateCredential(AuthCredential authCredential, FlowParameters flowParameters) {
        return b(flowParameters).signInWithCredential(authCredential);
    }
}
