package com.firebase.ui.auth.viewmodel;

import android.app.Application;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.util.GoogleApiUtils;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class AuthViewModelBase<T> extends OperableViewModel<FlowParameters, Resource<T>> {

    /* renamed from: d  reason: collision with root package name */
    private CredentialsClient f18247d;

    /* renamed from: e  reason: collision with root package name */
    private FirebaseAuth f18248e;

    /* JADX INFO: Access modifiers changed from: protected */
    public AuthViewModelBase(Application application) {
        super(application);
    }

    @Override // com.firebase.ui.auth.viewmodel.ViewModelBase
    protected void b() {
        this.f18248e = FirebaseAuth.getInstance(FirebaseApp.getInstance(((FlowParameters) a()).appName));
        this.f18247d = GoogleApiUtils.getCredentialsClient(getApplication());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FirebaseAuth e() {
        return this.f18248e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CredentialsClient f() {
        return this.f18247d;
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.f18248e.getCurrentUser();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public void initializeForTesting(FlowParameters flowParameters, FirebaseAuth firebaseAuth, CredentialsClient credentialsClient) {
        c(flowParameters);
        this.f18248e = firebaseAuth;
        this.f18247d = credentialsClient;
    }
}
