package com.firebase.ui.auth.data.remote;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.util.data.TaskFailureLogger;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class ProfileMerger implements Continuation<AuthResult, Task<AuthResult>> {

    /* renamed from: a  reason: collision with root package name */
    private final IdpResponse f18021a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Continuation<Void, Task<AuthResult>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AuthResult f18022a;

        a(AuthResult authResult) {
            this.f18022a = authResult;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<AuthResult> then(@NonNull Task<Void> task) {
            return Tasks.forResult(this.f18022a);
        }
    }

    public ProfileMerger(IdpResponse idpResponse) {
        this.f18021a = idpResponse;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.tasks.Continuation
    public Task<AuthResult> then(@NonNull Task<AuthResult> task) {
        AuthResult result = task.getResult();
        FirebaseUser user = result.getUser();
        String displayName = user.getDisplayName();
        Uri photoUrl = user.getPhotoUrl();
        if (!TextUtils.isEmpty(displayName) && photoUrl != null) {
            return Tasks.forResult(result);
        }
        User user2 = this.f18021a.getUser();
        if (TextUtils.isEmpty(displayName)) {
            displayName = user2.getName();
        }
        if (photoUrl == null) {
            photoUrl = user2.getPhotoUri();
        }
        return user.updateProfile(new UserProfileChangeRequest.Builder().setDisplayName(displayName).setPhotoUri(photoUrl).build()).addOnFailureListener(new TaskFailureLogger("ProfileMerger", "Error updating profile")).continueWithTask(new a(result));
    }
}
