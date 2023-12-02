package com.google.android.material.textfield;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class CutoutDrawable extends MaterialShapeDrawable {
    @NonNull
    private final RectF A;
    private int B;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    private final Paint f24565z;

    CutoutDrawable() {
        this(null);
    }

    private void E(@NonNull Canvas canvas) {
        if (!L(getCallback())) {
            canvas.restoreToCount(this.B);
        }
    }

    private void F(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (L(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
                return;
            }
            return;
        }
        H(canvas);
    }

    private void H(@NonNull Canvas canvas) {
        this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
    }

    private void K() {
        this.f24565z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f24565z.setColor(-1);
        this.f24565z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean L(Drawable.Callback callback) {
        return callback instanceof View;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D() {
        return !this.A.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        I(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void I(float f4, float f5, float f6, float f7) {
        RectF rectF = this.A;
        if (f4 != rectF.left || f5 != rectF.top || f6 != rectF.right || f7 != rectF.bottom) {
            rectF.set(f4, f5, f6, f7);
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(@NonNull RectF rectF) {
        I(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        F(canvas);
        super.draw(canvas);
        E(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void p(@NonNull Canvas canvas) {
        if (this.A.isEmpty()) {
            super.p(canvas);
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.p(canvas2);
        canvas2.drawRect(this.A, this.f24565z);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CutoutDrawable(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new ShapeAppearanceModel() : shapeAppearanceModel);
        this.f24565z = new Paint(1);
        K();
        this.A = new RectF();
    }
}
