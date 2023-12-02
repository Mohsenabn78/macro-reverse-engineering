package com.firebase.ui.auth.viewmodel.email;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class RecoverPasswordHandler extends AuthViewModelBase<String> {

    /* loaded from: classes3.dex */
    class a implements OnCompleteListener<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18285a;

        a(String str) {
            this.f18285a = str;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<Void> task) {
            Resource forFailure;
            if (task.isSuccessful()) {
                forFailure = Resource.forSuccess(this.f18285a);
            } else {
                forFailure = Resource.forFailure(task.getException());
            }
            RecoverPasswordHandler.this.d(forFailure);
        }
    }

    public RecoverPasswordHandler(Application application) {
        super(application);
    }

    public void startReset(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        Task<Void> sendPasswordResetEmail;
        d(Resource.forLoading());
        if (actionCodeSettings != null) {
            sendPasswordResetEmail = e().sendPasswordResetEmail(str, actionCodeSettings);
        } else {
            sendPasswordResetEmail = e().sendPasswordResetEmail(str);
        }
        sendPasswordResetEmail.addOnCompleteListener(new a(str));
    }
}
