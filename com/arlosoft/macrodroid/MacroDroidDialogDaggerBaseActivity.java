package com.arlosoft.macrodroid;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;

/* loaded from: classes2.dex */
public abstract class MacroDroidDialogDaggerBaseActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    private boolean f2006c = false;

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDestroyedOrFinishing() {
        if (!isFinishing() && !isDestroyed()) {
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AndroidInjection.inject(this);
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f2006c = true;
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
