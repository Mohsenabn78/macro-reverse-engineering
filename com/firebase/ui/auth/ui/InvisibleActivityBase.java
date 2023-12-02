package com.firebase.ui.auth.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.R;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class InvisibleActivityBase extends HelperActivityBase {

    /* renamed from: e  reason: collision with root package name */
    private MaterialProgressBar f18035e;

    /* renamed from: d  reason: collision with root package name */
    private Handler f18034d = new Handler();

    /* renamed from: f  reason: collision with root package name */
    private long f18036f = 0;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InvisibleActivityBase.this.f18036f = 0L;
            InvisibleActivityBase.this.f18035e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InvisibleActivityBase.this.finish();
        }
    }

    private void l(Runnable runnable) {
        this.f18034d.postDelayed(runnable, Math.max(750 - (System.currentTimeMillis() - this.f18036f), 0L));
    }

    @Override // com.firebase.ui.auth.ui.HelperActivityBase
    public void finish(int i4, @Nullable Intent intent) {
        setResult(i4, intent);
        l(new b());
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        l(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_activity_invisible);
        MaterialProgressBar materialProgressBar = new MaterialProgressBar(new ContextThemeWrapper(this, getFlowParams().themeId));
        this.f18035e = materialProgressBar;
        materialProgressBar.setIndeterminate(true);
        this.f18035e.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ((FrameLayout) findViewById(R.id.invisible_frame)).addView(this.f18035e, layoutParams);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        if (this.f18035e.getVisibility() == 0) {
            this.f18034d.removeCallbacksAndMessages(null);
            return;
        }
        this.f18036f = System.currentTimeMillis();
        this.f18035e.setVisibility(0);
    }
}
