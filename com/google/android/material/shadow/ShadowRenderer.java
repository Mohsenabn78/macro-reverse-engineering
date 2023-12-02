package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ShadowRenderer {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f24168i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f24169j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f24170k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f24171l = {0.0f, 0.0f, 0.5f, 1.0f};
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Paint f24172a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Paint f24173b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Paint f24174c;

    /* renamed from: d  reason: collision with root package name */
    private int f24175d;

    /* renamed from: e  reason: collision with root package name */
    private int f24176e;

    /* renamed from: f  reason: collision with root package name */
    private int f24177f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f24178g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f24179h;

    public ShadowRenderer() {
        this(-16777216);
    }

    public void drawCornerShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i4, float f4, float f5) {
        boolean z3;
        if (f5 < 0.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        Path path = this.f24178g;
        if (z3) {
            int[] iArr = f24170k;
            iArr[0] = 0;
            iArr[1] = this.f24177f;
            iArr[2] = this.f24176e;
            iArr[3] = this.f24175d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f4, f5);
            path.close();
            float f6 = -i4;
            rectF.inset(f6, f6);
            int[] iArr2 = f24170k;
            iArr2[0] = 0;
            iArr2[1] = this.f24175d;
            iArr2[2] = this.f24176e;
            iArr2[3] = this.f24177f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f7 = 1.0f - (i4 / width);
        float[] fArr = f24171l;
        fArr[1] = f7;
        fArr[2] = ((1.0f - f7) / 2.0f) + f7;
        this.f24173b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f24170k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z3) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f24179h);
        }
        canvas.drawArc(rectF, f4, f5, true, this.f24173b);
        canvas.restore();
    }

    public void drawEdgeShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i4) {
        rectF.bottom += i4;
        rectF.offset(0.0f, -i4);
        int[] iArr = f24168i;
        iArr[0] = this.f24177f;
        iArr[1] = this.f24176e;
        iArr[2] = this.f24175d;
        Paint paint = this.f24174c;
        float f4 = rectF.left;
        paint.setShader(new LinearGradient(f4, rectF.top, f4, rectF.bottom, iArr, f24169j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f24174c);
        canvas.restore();
    }

    @NonNull
    public Paint getShadowPaint() {
        return this.f24172a;
    }

    public void setShadowColor(int i4) {
        this.f24175d = ColorUtils.setAlphaComponent(i4, 68);
        this.f24176e = ColorUtils.setAlphaComponent(i4, 20);
        this.f24177f = ColorUtils.setAlphaComponent(i4, 0);
        this.f24172a.setColor(this.f24175d);
    }

    public ShadowRenderer(int i4) {
        this.f24178g = new Path();
        this.f24179h = new Paint();
        this.f24172a = new Paint();
        setShadowColor(i4);
        this.f24179h.setColor(0);
        Paint paint = new Paint(4);
        this.f24173b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f24174c = new Paint(paint);
    }
}
