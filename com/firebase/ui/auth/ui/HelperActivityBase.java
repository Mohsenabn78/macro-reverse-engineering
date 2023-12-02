package com.firebase.ui.auth.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.ui.credentials.CredentialSaveActivity;
import com.firebase.ui.auth.util.CredentialUtils;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.Preconditions;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class HelperActivityBase extends AppCompatActivity implements ProgressView {

    /* renamed from: c  reason: collision with root package name */
    private FlowParameters f18033c;

    /* JADX INFO: Access modifiers changed from: protected */
    public static Intent h(@NonNull Context context, @NonNull Class<? extends Activity> cls, @NonNull FlowParameters flowParameters) {
        Intent putExtra = new Intent((Context) Preconditions.checkNotNull(context, "context cannot be null", new Object[0]), (Class) Preconditions.checkNotNull(cls, "target activity cannot be null", new Object[0])).putExtra(ExtraConstants.FLOW_PARAMS, (Parcelable) Preconditions.checkNotNull(flowParameters, "flowParams cannot be null", new Object[0]));
        putExtra.setExtrasClassLoader(AuthUI.class.getClassLoader());
        return putExtra;
    }

    public void finish(int i4, @Nullable Intent intent) {
        setResult(i4, intent);
        finish();
    }

    public FirebaseAuth getAuth() {
        return getAuthUI().getAuth();
    }

    public AuthUI getAuthUI() {
        return AuthUI.getInstance(getFlowParams().appName);
    }

    public FlowParameters getFlowParams() {
        if (this.f18033c == null) {
            this.f18033c = FlowParameters.fromIntent(getIntent());
        }
        return this.f18033c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 102 || i5 == 5) {
            finish(i5, intent);
        }
    }

    public void startSaveCredentials(FirebaseUser firebaseUser, IdpResponse idpResponse, @Nullable String str) {
        startActivityForResult(CredentialSaveActivity.createIntent(this, getFlowParams(), CredentialUtils.buildCredential(firebaseUser, str, ProviderUtils.idpResponseToAccountType(idpResponse)), idpResponse), 102);
    }
}
