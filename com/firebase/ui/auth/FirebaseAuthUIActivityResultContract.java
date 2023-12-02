package com.firebase.ui.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;

/* loaded from: classes3.dex */
public class FirebaseAuthUIActivityResultContract extends ActivityResultContract<Intent, FirebaseAuthUIAuthenticationResult> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public Intent createIntent(@NonNull Context context, Intent intent) {
        return intent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public FirebaseAuthUIAuthenticationResult parseResult(int i4, @Nullable Intent intent) {
        return new FirebaseAuthUIAuthenticationResult(Integer.valueOf(i4), IdpResponse.fromResultIntent(intent));
    }
}
