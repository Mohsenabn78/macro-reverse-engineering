package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zzaz;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@KeepName
/* loaded from: classes4.dex */
public class SignInHubActivity extends FragmentActivity {

    /* renamed from: h  reason: collision with root package name */
    private static boolean f19851h = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19852c = false;

    /* renamed from: d  reason: collision with root package name */
    private SignInConfiguration f19853d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19854e;

    /* renamed from: f  reason: collision with root package name */
    private int f19855f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f19856g;

    private final void i(int i4) {
        Status status = new Status(i4);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f19851h = false;
    }

    private final void k() {
        getSupportLoaderManager().initLoader(0, null, new zzc());
        f19851h = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (this.f19852c) {
            return;
        }
        setResult(0);
        if (i4 == 40962) {
            if (intent != null) {
                SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                    GoogleSignInAccount googleSignInAccount = signInAccount.getGoogleSignInAccount();
                    zzq.zzd(this).zzc(this.f19853d.zzu(), (GoogleSignInAccount) zzaz.checkNotNull(googleSignInAccount));
                    intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    intent.putExtra("googleSignInAccount", googleSignInAccount);
                    this.f19854e = true;
                    this.f19855f = i5;
                    this.f19856g = intent;
                    k();
                    return;
                } else if (intent.hasExtra("errorCode")) {
                    int intExtra = intent.getIntExtra("errorCode", 8);
                    if (intExtra == 13) {
                        intExtra = GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
                    }
                    i(intExtra);
                    return;
                }
            }
            i(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str2 = (String) zzaz.checkNotNull(intent.getAction());
        if ("com.google.android.gms.auth.NO_IMPL".equals(str2)) {
            i(GoogleSignInStatusCodes.SIGN_IN_FAILED);
        } else if (!str2.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !str2.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                str = "Unknown action: ".concat(valueOf);
            } else {
                str = new String("Unknown action: ");
            }
            Log.e("AuthSignInClient", str);
            finish();
        } else {
            SignInConfiguration signInConfiguration = (SignInConfiguration) ((Bundle) zzaz.checkNotNull(intent.getBundleExtra("config"))).getParcelable("config");
            if (signInConfiguration == null) {
                Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                setResult(0);
                finish();
                return;
            }
            this.f19853d = signInConfiguration;
            if (bundle == null) {
                if (f19851h) {
                    setResult(0);
                    i(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                    return;
                }
                f19851h = true;
                Intent intent2 = new Intent(str2);
                if (str2.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                    intent2.setPackage("com.google.android.gms");
                } else {
                    intent2.setPackage(getPackageName());
                }
                intent2.putExtra("config", this.f19853d);
                try {
                    startActivityForResult(intent2, 40962);
                    return;
                } catch (ActivityNotFoundException unused) {
                    this.f19852c = true;
                    Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                    i(17);
                    return;
                }
            }
            boolean z3 = bundle.getBoolean("signingInGoogleApiClients");
            this.f19854e = z3;
            if (z3) {
                this.f19855f = bundle.getInt("signInResultCode");
                this.f19856g = (Intent) zzaz.checkNotNull((Intent) bundle.getParcelable("signInResultData"));
                k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f19854e);
        if (this.f19854e) {
            bundle.putInt("signInResultCode", this.f19855f);
            bundle.putParcelable("signInResultData", this.f19856g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public class zzc implements LoaderManager.LoaderCallbacks<Void> {
        private zzc() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final Loader<Void> onCreateLoader(int i4, Bundle bundle) {
            return new zzd(SignInHubActivity.this, GoogleApiClient.getAllClients());
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final /* synthetic */ void onLoadFinished(Loader<Void> loader, Void r32) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f19855f, SignInHubActivity.this.f19856g);
            SignInHubActivity.this.finish();
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final void onLoaderReset(Loader<Void> loader) {
        }
    }
}
