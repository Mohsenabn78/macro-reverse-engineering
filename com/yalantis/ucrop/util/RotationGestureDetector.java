package com.yalantis.ucrop.util;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public class RotationGestureDetector {

    /* renamed from: a  reason: collision with root package name */
    private float f38485a;

    /* renamed from: b  reason: collision with root package name */
    private float f38486b;

    /* renamed from: c  reason: collision with root package name */
    private float f38487c;

    /* renamed from: d  reason: collision with root package name */
    private float f38488d;

    /* renamed from: e  reason: collision with root package name */
    private int f38489e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f38490f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f38491g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f38492h;

    /* renamed from: i  reason: collision with root package name */
    private OnRotationGestureListener f38493i;

    /* loaded from: classes6.dex */
    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);
    }

    /* loaded from: classes6.dex */
    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        @Override // com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.f38493i = onRotationGestureListener;
    }

    private float a(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        return b((float) Math.toDegrees((float) Math.atan2(f5 - f7, f4 - f6)), (float) Math.toDegrees((float) Math.atan2(f9 - f11, f8 - f10)));
    }

    private float b(float f4, float f5) {
        float f6 = (f5 % 360.0f) - (f4 % 360.0f);
        this.f38491g = f6;
        if (f6 < -180.0f) {
            this.f38491g = f6 + 360.0f;
        } else if (f6 > 180.0f) {
            this.f38491g = f6 - 360.0f;
        }
        return this.f38491g;
    }

    public float getAngle() {
        return this.f38491g;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            this.f38490f = -1;
                        }
                    } else {
                        this.f38485a = motionEvent.getX();
                        this.f38486b = motionEvent.getY();
                        this.f38490f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                        this.f38491g = 0.0f;
                        this.f38492h = true;
                    }
                } else if (this.f38489e != -1 && this.f38490f != -1 && motionEvent.getPointerCount() > this.f38490f) {
                    float x3 = motionEvent.getX(this.f38489e);
                    float y3 = motionEvent.getY(this.f38489e);
                    float x4 = motionEvent.getX(this.f38490f);
                    float y4 = motionEvent.getY(this.f38490f);
                    if (this.f38492h) {
                        this.f38491g = 0.0f;
                        this.f38492h = false;
                    } else {
                        a(this.f38485a, this.f38486b, this.f38487c, this.f38488d, x4, y4, x3, y3);
                    }
                    OnRotationGestureListener onRotationGestureListener = this.f38493i;
                    if (onRotationGestureListener != null) {
                        onRotationGestureListener.onRotation(this);
                    }
                    this.f38485a = x4;
                    this.f38486b = y4;
                    this.f38487c = x3;
                    this.f38488d = y3;
                }
            } else {
                this.f38489e = -1;
            }
        } else {
            this.f38487c = motionEvent.getX();
            this.f38488d = motionEvent.getY();
            this.f38489e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.f38491g = 0.0f;
            this.f38492h = true;
        }
        return true;
    }
}
