package com.firebase.ui.auth.viewmodel.smartlock;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.util.CredentialUtils;
import com.firebase.ui.auth.util.GoogleApiUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes3.dex */
public class SmartLockHandler extends AuthViewModelBase<IdpResponse> {

    /* renamed from: f  reason: collision with root package name */
    private IdpResponse f18325f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnCompleteListener<Void> {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<Void> task) {
            if (task.isSuccessful()) {
                SmartLockHandler smartLockHandler = SmartLockHandler.this;
                smartLockHandler.d(Resource.forSuccess(smartLockHandler.f18325f));
            } else if (task.getException() instanceof ResolvableApiException) {
                SmartLockHandler.this.d(Resource.forFailure(new PendingIntentRequiredException(((ResolvableApiException) task.getException()).getResolution(), 100)));
            } else {
                Log.w("SmartLockViewModel", "Non-resolvable exception: " + task.getException());
                SmartLockHandler.this.d(Resource.forFailure(new FirebaseUiException(0, "Error when saving credential.", task.getException())));
            }
        }
    }

    public SmartLockHandler(Application application) {
        super(application);
    }

    private void k() {
        if (this.f18325f.getProviderType().equals("google.com")) {
            GoogleApiUtils.getCredentialsClient(getApplication()).delete(CredentialUtils.buildCredentialOrThrow(getCurrentUser(), "pass", ProviderUtils.providerIdToAccountType("google.com")));
        }
    }

    public void onActivityResult(int i4, int i5) {
        if (i4 == 100) {
            if (i5 == -1) {
                d(Resource.forSuccess(this.f18325f));
                return;
            }
            Log.e("SmartLockViewModel", "SAVE: Canceled by user.");
            d(Resource.forFailure(new FirebaseUiException(0, "Save canceled by user.")));
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void saveCredentials(FirebaseUser firebaseUser, @Nullable String str, @Nullable String str2) {
        saveCredentials(CredentialUtils.buildCredential(firebaseUser, str, str2));
    }

    public void setResponse(@NonNull IdpResponse idpResponse) {
        this.f18325f = idpResponse;
    }

    public void saveCredentials(@Nullable Credential credential) {
        if (!a().enableCredentials) {
            d(Resource.forSuccess(this.f18325f));
            return;
        }
        d(Resource.forLoading());
        if (credential == null) {
            d(Resource.forFailure(new FirebaseUiException(0, "Failed to build credential.")));
            return;
        }
        k();
        f().save(credential).addOnCompleteListener(new a());
    }
}
