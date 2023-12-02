package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class InsetDialogOnTouchListener implements View.OnTouchListener {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Dialog f23579a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23580b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23581c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23582d;

    public InsetDialogOnTouchListener(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.f23579a = dialog;
        this.f23580b = rect.left;
        this.f23581c = rect.top;
        this.f23582d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f23580b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f23581c + findViewById.getTop();
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i4 = this.f23582d;
            obtain.setLocation((-i4) - 1, (-i4) - 1);
        }
        view.performClick();
        return this.f23579a.onTouchEvent(obtain);
    }
}
