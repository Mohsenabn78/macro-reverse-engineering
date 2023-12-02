package com.arlosoft.macrodroid;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.google.android.gms.ads.MobileAds;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class LauncherActivity extends MacroDroidDaggerBaseActivity {
    @Inject

    /* renamed from: f  reason: collision with root package name */
    PremiumStatusHandler f2002f;

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity
    protected boolean l() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_launcher);
        if (!this.f2002f.getPremiumStatus().isPro()) {
            MobileAds.initialize(getApplicationContext());
        }
        System.currentTimeMillis();
        findViewById(R.id.mImage).startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in_slow));
    }
}
