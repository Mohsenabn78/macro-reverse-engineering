package com.firebase.ui.auth.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.R;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class InvisibleFragmentBase extends FragmentBase {

    /* renamed from: c  reason: collision with root package name */
    protected FrameLayout f18039c;

    /* renamed from: e  reason: collision with root package name */
    private MaterialProgressBar f18041e;

    /* renamed from: d  reason: collision with root package name */
    private Handler f18040d = new Handler();

    /* renamed from: f  reason: collision with root package name */
    private long f18042f = 0;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InvisibleFragmentBase.this.f18042f = 0L;
            InvisibleFragmentBase.this.f18041e.setVisibility(8);
            InvisibleFragmentBase.this.f18039c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Runnable runnable) {
        this.f18040d.postDelayed(runnable, Math.max(750 - (System.currentTimeMillis() - this.f18042f), 0L));
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        d(new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        MaterialProgressBar materialProgressBar = new MaterialProgressBar(new ContextThemeWrapper(getContext(), getFlowParams().themeId));
        this.f18041e = materialProgressBar;
        materialProgressBar.setIndeterminate(true);
        this.f18041e.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.invisible_frame);
        this.f18039c = frameLayout;
        frameLayout.addView(this.f18041e, layoutParams);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        if (this.f18041e.getVisibility() == 0) {
            this.f18040d.removeCallbacksAndMessages(null);
            return;
        }
        this.f18042f = System.currentTimeMillis();
        this.f18041e.setVisibility(0);
    }
}
