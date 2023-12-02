package com.arlosoft.macrodroid.action.activities;

import android.os.Bundle;
import android.view.WindowManager;
import com.arlosoft.macrodroid.common.NonAppActivity;

/* loaded from: classes2.dex */
public class UpdateBrightnessActivity extends NonAppActivity {
    public static final String BRIGHTNESS_EXTRA = "Brightness";

    /* loaded from: classes2.dex */
    class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
            }
            UpdateBrightnessActivity.this.finish();
        }
    }

    private void h(int i4) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (i4 < 0) {
            attributes.screenBrightness = -1.0f;
        } else {
            attributes.screenBrightness = i4 / 255.0f;
        }
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        h(getIntent().getIntExtra(BRIGHTNESS_EXTRA, 127));
        new a().start();
    }
}
