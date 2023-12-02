package com.firebase.ui.auth.viewmodel.email;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.ContinueUrlBuilder;
import com.firebase.ui.auth.util.data.EmailLinkPersistenceManager;
import com.firebase.ui.auth.util.data.SessionUtils;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes3.dex */
public class EmailLinkSendEmailHandler extends AuthViewModelBase<String> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements OnCompleteListener<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18256a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18257b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18258c;

        a(String str, String str2, String str3) {
            this.f18256a = str;
            this.f18257b = str2;
            this.f18258c = str3;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<Void> task) {
            if (!task.isSuccessful()) {
                EmailLinkSendEmailHandler.this.d(Resource.forFailure(task.getException()));
                return;
            }
            EmailLinkPersistenceManager.getInstance().saveEmail(EmailLinkSendEmailHandler.this.getApplication(), this.f18256a, this.f18257b, this.f18258c);
            EmailLinkSendEmailHandler.this.d(Resource.forSuccess(this.f18256a));
        }
    }

    public EmailLinkSendEmailHandler(Application application) {
        super(application);
    }

    private ActionCodeSettings i(@NonNull ActionCodeSettings actionCodeSettings, @NonNull String str, @NonNull String str2, @Nullable IdpResponse idpResponse, boolean z3) {
        ContinueUrlBuilder continueUrlBuilder = new ContinueUrlBuilder(actionCodeSettings.getUrl());
        continueUrlBuilder.appendSessionId(str);
        continueUrlBuilder.appendAnonymousUserId(str2);
        continueUrlBuilder.appendForceSameDeviceBit(z3);
        if (idpResponse != null) {
            continueUrlBuilder.appendProviderId(idpResponse.getProviderType());
        }
        return ActionCodeSettings.newBuilder().setUrl(continueUrlBuilder.build()).setHandleCodeInApp(true).setAndroidPackageName(actionCodeSettings.getAndroidPackageName(), actionCodeSettings.getAndroidInstallApp(), actionCodeSettings.getAndroidMinimumVersion()).setIOSBundleId(actionCodeSettings.getIOSBundle()).build();
    }

    public void sendSignInLinkToEmail(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings, @Nullable IdpResponse idpResponse, boolean z3) {
        String str2;
        if (e() == null) {
            return;
        }
        d(Resource.forLoading());
        if (AuthOperationManager.getInstance().canUpgradeAnonymous(e(), a())) {
            str2 = e().getCurrentUser().getUid();
        } else {
            str2 = null;
        }
        String generateRandomAlphaNumericString = SessionUtils.generateRandomAlphaNumericString(10);
        e().sendSignInLinkToEmail(str, i(actionCodeSettings, generateRandomAlphaNumericString, str2, idpResponse, z3)).addOnCompleteListener(new a(str, generateRandomAlphaNumericString, str2));
    }
}
