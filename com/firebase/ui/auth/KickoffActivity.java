package com.firebase.ui.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.data.remote.SignInKickstarter;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.InvisibleActivityBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class KickoffActivity extends InvisibleActivityBase {

    /* renamed from: g  reason: collision with root package name */
    private SignInKickstarter f17963g;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<IdpResponse> {
        a(HelperActivityBase helperActivityBase) {
            super(helperActivityBase);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof UserCancellationException) {
                KickoffActivity.this.finish(0, null);
            } else if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                KickoffActivity.this.finish(0, new Intent().putExtra(ExtraConstants.IDP_RESPONSE, ((FirebaseAuthAnonymousUpgradeException) exc).getResponse()));
            } else {
                KickoffActivity.this.finish(0, IdpResponse.getErrorIntent(exc));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            KickoffActivity.this.finish(-1, idpResponse.toIntent());
        }
    }

    /* loaded from: classes3.dex */
    class b implements OnFailureListener {
        b() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            KickoffActivity.this.finish(0, IdpResponse.getErrorIntent(new FirebaseUiException(2, exc)));
        }
    }

    /* loaded from: classes3.dex */
    class c implements OnSuccessListener<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f17966a;

        c(Bundle bundle) {
            this.f17966a = bundle;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a */
        public void onSuccess(Void r12) {
            if (this.f17966a != null) {
                return;
            }
            KickoffActivity.this.f17963g.start();
        }
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters) {
        return HelperActivityBase.h(context, KickoffActivity.class, flowParameters);
    }

    public void invalidateEmailLink() {
        FlowParameters flowParams = getFlowParams();
        flowParams.emailLink = null;
        setIntent(getIntent().putExtra(ExtraConstants.FLOW_PARAMS, flowParams));
    }

    @Override // com.firebase.ui.auth.ui.HelperActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 106 && (i5 == 113 || i5 == 114)) {
            invalidateEmailLink();
        }
        this.f17963g.onActivityResult(i4, i5, intent);
    }

    @Override // com.firebase.ui.auth.ui.InvisibleActivityBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        Task<Void> forResult;
        super.onCreate(bundle);
        SignInKickstarter signInKickstarter = (SignInKickstarter) new ViewModelProvider(this).get(SignInKickstarter.class);
        this.f17963g = signInKickstarter;
        signInKickstarter.init(getFlowParams());
        this.f17963g.getOperation().observe(this, new a(this));
        if (getFlowParams().isPlayServicesRequired()) {
            forResult = GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(this);
        } else {
            forResult = Tasks.forResult(null);
        }
        forResult.addOnSuccessListener(this, new c(bundle)).addOnFailureListener(this, new b());
    }
}
