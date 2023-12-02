package com.firebase.ui.auth.data.remote;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.WebDialog;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class FacebookSignInHandler extends SingleProviderSignInHandler<AuthUI.IdpConfig> {

    /* renamed from: e  reason: collision with root package name */
    private List<String> f17994e;

    /* renamed from: f  reason: collision with root package name */
    private final FacebookCallback<LoginResult> f17995f;

    /* renamed from: g  reason: collision with root package name */
    private final CallbackManager f17996g;

    /* loaded from: classes3.dex */
    private class b implements FacebookCallback<LoginResult> {
        private b() {
        }
    }

    public FacebookSignInHandler(Application application) {
        super(application, "facebook.com");
        this.f17995f = new b();
        this.f17996g = CallbackManager.Factory.create();
    }

    @Override // com.firebase.ui.auth.viewmodel.ViewModelBase
    protected void b() {
        Collection stringArrayList = a().getParams().getStringArrayList(ExtraConstants.FACEBOOK_PERMISSIONS);
        if (stringArrayList == null) {
            stringArrayList = Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(stringArrayList);
        if (!arrayList.contains("email")) {
            arrayList.add("email");
        }
        if (!arrayList.contains("public_profile")) {
            arrayList.add("public_profile");
        }
        this.f17994e = arrayList;
        LoginManager.getInstance().registerCallback(this.f17996g, this.f17995f);
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        this.f17996g.onActivityResult(i4, i5, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.viewmodel.ViewModelBase, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        LoginManager.getInstance().unregisterCallback(this.f17996g);
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void startSignIn(@NonNull FirebaseAuth firebaseAuth, @NonNull HelperActivityBase helperActivityBase, @NonNull String str) {
        WebDialog.setWebDialogTheme(helperActivityBase.getFlowParams().themeId);
        LoginManager.getInstance().logInWithReadPermissions(helperActivityBase, this.f17994e);
    }
}
