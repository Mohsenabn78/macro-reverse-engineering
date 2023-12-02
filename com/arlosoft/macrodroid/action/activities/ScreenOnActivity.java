package com.arlosoft.macrodroid.action.activities;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.arlosoft.macrodroid.common.NonAppActivity;

/* loaded from: classes2.dex */
public class ScreenOnActivity extends NonAppActivity {

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScreenOnActivity.this.finish();
        }
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 27) {
            setTurnScreenOn(true);
            setShowWhenLocked(true);
        }
        getWindow().addFlags(2621569);
        new Handler().postDelayed(new a(), 500L);
    }
}
