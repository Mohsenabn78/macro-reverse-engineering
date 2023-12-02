package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;

/* loaded from: classes6.dex */
public class GestureCropImageView extends CropImageView {
    private ScaleGestureDetector B;
    private RotationGestureDetector C;
    private GestureDetector D;
    private float E;
    private float F;
    private boolean G;
    private boolean H;
    private int I;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.p(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
            GestureCropImageView.this.postTranslate(-f4, -f5);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c extends RotationGestureDetector.SimpleOnRotationGestureListener {
        private c() {
        }

        @Override // com.yalantis.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener, com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            GestureCropImageView.this.postRotate(rotationGestureDetector.getAngle(), GestureCropImageView.this.E, GestureCropImageView.this.F);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.postScale(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.E, GestureCropImageView.this.F);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.G = true;
        this.H = true;
        this.I = 5;
    }

    private void s() {
        this.D = new GestureDetector(getContext(), new b(), null, true);
        this.B = new ScaleGestureDetector(getContext(), new d());
        this.C = new RotationGestureDetector(new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    public void e() {
        super.e();
        s();
    }

    public int getDoubleTapScaleSteps() {
        return this.I;
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.I));
    }

    public boolean isRotateEnabled() {
        return this.G;
    }

    public boolean isScaleEnabled() {
        return this.H;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.E = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.F = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.D.onTouchEvent(motionEvent);
        if (this.H) {
            this.B.onTouchEvent(motionEvent);
        }
        if (this.G) {
            this.C.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i4) {
        this.I = i4;
    }

    public void setRotateEnabled(boolean z3) {
        this.G = z3;
    }

    public void setScaleEnabled(boolean z3) {
        this.H = z3;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.G = true;
        this.H = true;
        this.I = 5;
    }
}
