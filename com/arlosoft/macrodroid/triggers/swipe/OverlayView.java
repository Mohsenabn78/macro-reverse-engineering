package com.arlosoft.macrodroid.triggers.swipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.swipe.OverlayView;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.badge.BadgeDrawable;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public abstract class OverlayView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private WindowManager.LayoutParams f15585a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15586b;

    /* renamed from: c  reason: collision with root package name */
    int f15587c;

    public OverlayView(OverlayService overlayService, int i4, int i5, int i6) {
        super(overlayService);
        this.f15587c = i6;
        this.f15586b = i4;
        setLongClickable(true);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: t0.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean e4;
                e4 = OverlayView.this.e(view);
                return e4;
            }
        });
        f();
    }

    private void b() {
        l();
        try {
            ((WindowManager) getContext().getSystemService("window")).addView(this, this.f15585a);
        } catch (WindowManager.BadTokenException e4) {
            SystemLog.logError("Screen Swipe Overlay failed: " + e4);
        } catch (SecurityException unused) {
            SystemLog.logError("Screen Swipe Overlay failed: requires SYSTEM_ALERT_WINDOW permission");
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (getContext().getString(R.string.trigger_swipe) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.action_failed_requires_permission)), 0).show();
        }
        super.setVisibility(8);
    }

    private void c() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.f15586b, this);
    }

    private boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean e(View view) {
        return onTouchEvent_LongPress();
    }

    private void f() {
        c();
        b();
        k();
    }

    private int getLayoutGravity() {
        int i4 = this.f15587c;
        if (i4 == 0) {
            return BadgeDrawable.TOP_START;
        }
        if (i4 == 1) {
            return BadgeDrawable.TOP_END;
        }
        return 0;
    }

    private boolean j(int i4) {
        return true;
    }

    private void k() {
        if (!d()) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    private void l() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, OverlayUtils.getOverlayType(), 786472, -3);
        this.f15585a = layoutParams;
        layoutParams.gravity = getLayoutGravity();
    }

    public void destroy() {
        try {
            ((WindowManager) getContext().getSystemService("window")).removeView(this);
        } catch (SecurityException unused) {
            SystemLog.logError("Screen Swipe Overlay failed: requires SYSTEM_ALERT_WINDOW permission");
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (getContext().getString(R.string.trigger_swipe) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.action_failed_requires_permission)), 0).show();
        }
    }

    public OverlayService getService() {
        return (OverlayService) getContext();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            h(motionEvent);
        } else if (motionEvent.getActionMasked() == 1) {
            i(motionEvent);
        } else if (motionEvent.getActionMasked() == 2) {
            g(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    protected boolean onTouchEvent_LongPress() {
        return false;
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        if (getVisibility() != i4 && j(i4)) {
            super.setVisibility(i4);
        }
    }

    protected void g(MotionEvent motionEvent) {
    }

    protected void h(MotionEvent motionEvent) {
    }

    protected void i(MotionEvent motionEvent) {
    }
}
