package com.arlosoft.macrodroid;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes2.dex */
public abstract class MacroDroidDialogBaseActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    private boolean f2005c = false;

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f2005c = true;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PasswordProtection.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResumeFragments() {
        super.onResumeFragments();
        PasswordProtection.onResumeFragments(this);
    }
}
