package com.firebase.ui.auth.ui.email;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public class CheckEmailHandler extends AuthViewModelBase<User> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnCompleteListener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18055a;

        a(String str) {
            this.f18055a = str;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<String> task) {
            if (task.isSuccessful()) {
                CheckEmailHandler.this.d(Resource.forSuccess(new User.Builder(task.getResult(), this.f18055a).build()));
            } else {
                CheckEmailHandler.this.d(Resource.forFailure(task.getException()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements OnCompleteListener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18057a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Credential f18058b;

        b(String str, Credential credential) {
            this.f18057a = str;
            this.f18058b = credential;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<String> task) {
            if (task.isSuccessful()) {
                CheckEmailHandler.this.d(Resource.forSuccess(new User.Builder(task.getResult(), this.f18057a).setName(this.f18058b.getName()).setPhotoUri(this.f18058b.getProfilePictureUri()).build()));
            } else {
                CheckEmailHandler.this.d(Resource.forFailure(task.getException()));
            }
        }
    }

    public CheckEmailHandler(Application application) {
        super(application);
    }

    public void fetchCredential() {
        d(Resource.forFailure(new PendingIntentRequiredException(Credentials.getClient(getApplication()).getHintPickerIntent(new HintRequest.Builder().setEmailAddressIdentifierSupported(true).build()), 101)));
    }

    public void fetchProvider(String str) {
        d(Resource.forLoading());
        ProviderUtils.fetchTopProvider(e(), a(), str).addOnCompleteListener(new a(str));
    }

    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (i4 == 101 && i5 == -1) {
            d(Resource.forLoading());
            Credential credential = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
            String id = credential.getId();
            ProviderUtils.fetchTopProvider(e(), a(), id).addOnCompleteListener(new b(id, credential));
        }
    }
}
