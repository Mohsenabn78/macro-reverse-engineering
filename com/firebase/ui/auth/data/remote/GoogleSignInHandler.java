package com.firebase.ui.auth.data.remote;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.firebase.auth.FirebaseAuth;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class GoogleSignInHandler extends SingleProviderSignInHandler<Params> {

    /* renamed from: e  reason: collision with root package name */
    private AuthUI.IdpConfig f18017e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f18018f;

    /* loaded from: classes3.dex */
    public static final class Params {

        /* renamed from: a  reason: collision with root package name */
        private final AuthUI.IdpConfig f18019a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final String f18020b;

        public Params(AuthUI.IdpConfig idpConfig) {
            this(idpConfig, null);
        }

        public Params(AuthUI.IdpConfig idpConfig, @Nullable String str) {
            this.f18019a = idpConfig;
            this.f18020b = str;
        }
    }

    public GoogleSignInHandler(Application application) {
        super(application, "google.com");
    }

    private static IdpResponse e(GoogleSignInAccount googleSignInAccount) {
        return new IdpResponse.Builder(new User.Builder("google.com", googleSignInAccount.getEmail()).setName(googleSignInAccount.getDisplayName()).setPhotoUri(googleSignInAccount.getPhotoUrl()).build()).setToken(googleSignInAccount.getIdToken()).build();
    }

    private GoogleSignInOptions f() {
        GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder((GoogleSignInOptions) this.f18017e.getParams().getParcelable(ExtraConstants.GOOGLE_SIGN_IN_OPTIONS));
        if (!TextUtils.isEmpty(this.f18018f)) {
            builder.setAccountName(this.f18018f);
        }
        return builder.build();
    }

    private void start() {
        d(Resource.forLoading());
        d(Resource.forFailure(new IntentRequiredException(GoogleSignIn.getClient(getApplication(), f()).getSignInIntent(), 110)));
    }

    @Override // com.firebase.ui.auth.viewmodel.ViewModelBase
    protected void b() {
        Params a4 = a();
        this.f18017e = a4.f18019a;
        this.f18018f = a4.f18020b;
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (i4 != 110) {
            return;
        }
        try {
            d(Resource.forSuccess(e(GoogleSignIn.getSignedInAccountFromIntent(intent).getResult(ApiException.class))));
        } catch (ApiException e4) {
            if (e4.getStatusCode() == 5) {
                this.f18018f = null;
                start();
            } else if (e4.getStatusCode() == 12502) {
                start();
            } else if (e4.getStatusCode() == 12501) {
                d(Resource.forFailure(new UserCancellationException()));
            } else {
                if (e4.getStatusCode() == 10) {
                    Log.w("GoogleSignInHandler", "Developer error: this application is misconfigured. Check your SHA1 and package name in the Firebase console.");
                }
                d(Resource.forFailure(new FirebaseUiException(4, "Code: " + e4.getStatusCode() + ", message: " + e4.getMessage())));
            }
        }
    }

    @Override // com.firebase.ui.auth.viewmodel.ProviderSignInBase
    public void startSignIn(@NonNull FirebaseAuth firebaseAuth, @NonNull HelperActivityBase helperActivityBase, @NonNull String str) {
        start();
    }
}
