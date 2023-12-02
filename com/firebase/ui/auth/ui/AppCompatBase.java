package com.firebase.ui.auth.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.firebase.ui.auth.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class AppCompatBase extends HelperActivityBase {
    @SuppressLint({"SourceLockedOrientationActivity"})
    private void j() {
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@NonNull Fragment fragment, int i4, @NonNull String str) {
        l(fragment, i4, str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@NonNull Fragment fragment, int i4, @NonNull String str, boolean z3, boolean z4) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (z3) {
            beginTransaction.setCustomAnimations(R.anim.fui_slide_in_right, R.anim.fui_slide_out_left);
        }
        beginTransaction.replace(i4, fragment, str);
        if (z4) {
            beginTransaction.addToBackStack(null).commit();
        } else {
            beginTransaction.disallowAddToBackStack().commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setTheme(R.style.FirebaseUI);
        setTheme(getFlowParams().themeId);
        if (getFlowParams().lockOrientation) {
            j();
        }
    }
}
