package com.firebase.ui.auth.ui.credentials;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.InvisibleActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.smartlock.SmartLockHandler;
import com.google.android.gms.auth.api.credentials.Credential;

/* loaded from: classes3.dex */
public class CredentialSaveActivity extends InvisibleActivityBase {

    /* renamed from: g  reason: collision with root package name */
    private SmartLockHandler f18044g;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<IdpResponse> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ IdpResponse f18045e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(HelperActivityBase helperActivityBase, IdpResponse idpResponse) {
            super(helperActivityBase);
            this.f18045e = idpResponse;
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            CredentialSaveActivity.this.finish(-1, this.f18045e.toIntent());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            CredentialSaveActivity.this.finish(-1, idpResponse.toIntent());
        }
    }

    @NonNull
    public static Intent createIntent(Context context, FlowParameters flowParameters, Credential credential, IdpResponse idpResponse) {
        return HelperActivityBase.h(context, CredentialSaveActivity.class, flowParameters).putExtra(ExtraConstants.CREDENTIAL, credential).putExtra(ExtraConstants.IDP_RESPONSE, idpResponse);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.HelperActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        this.f18044g.onActivityResult(i4, i5);
    }

    @Override // com.firebase.ui.auth.ui.InvisibleActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        IdpResponse idpResponse = (IdpResponse) getIntent().getParcelableExtra(ExtraConstants.IDP_RESPONSE);
        Credential credential = (Credential) getIntent().getParcelableExtra(ExtraConstants.CREDENTIAL);
        SmartLockHandler smartLockHandler = (SmartLockHandler) new ViewModelProvider(this).get(SmartLockHandler.class);
        this.f18044g = smartLockHandler;
        smartLockHandler.init(getFlowParams());
        this.f18044g.setResponse(idpResponse);
        this.f18044g.getOperation().observe(this, new a(this, idpResponse));
        if (((Resource) this.f18044g.getOperation().getValue()) == null) {
            this.f18044g.saveCredentials(credential);
        }
    }
}
