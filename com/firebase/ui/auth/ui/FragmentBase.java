package com.firebase.ui.auth.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.firebase.auth.FirebaseUser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class FragmentBase extends Fragment implements ProgressView {

    /* renamed from: b  reason: collision with root package name */
    private HelperActivityBase f18032b;

    public FlowParameters getFlowParams() {
        return this.f18032b.getFlowParams();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof HelperActivityBase) {
            this.f18032b = (HelperActivityBase) activity;
            return;
        }
        throw new IllegalStateException("Cannot use this fragment without the helper activity");
    }

    public void startSaveCredentials(FirebaseUser firebaseUser, IdpResponse idpResponse, @Nullable String str) {
        this.f18032b.startSaveCredentials(firebaseUser, idpResponse, str);
    }
}
