package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

/* loaded from: classes6.dex */
public class AspectRatioTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f38572a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f38573b;

    /* renamed from: c  reason: collision with root package name */
    private int f38574c;

    /* renamed from: d  reason: collision with root package name */
    private float f38575d;

    /* renamed from: e  reason: collision with root package name */
    private String f38576e;

    /* renamed from: f  reason: collision with root package name */
    private float f38577f;

    /* renamed from: g  reason: collision with root package name */
    private float f38578g;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    private void a(@ColorInt int i4) {
        Paint paint = this.f38573b;
        if (paint != null) {
            paint.setColor(i4);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i4, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget)}));
    }

    private void b(@NonNull TypedArray typedArray) {
        setGravity(1);
        this.f38576e = typedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.f38577f = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f4 = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.f38578g = f4;
        float f5 = this.f38577f;
        if (f5 != 0.0f && f4 != 0.0f) {
            this.f38575d = f5 / f4;
        } else {
            this.f38575d = 0.0f;
        }
        this.f38574c = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.f38573b = paint;
        paint.setStyle(Paint.Style.FILL);
        c();
        a(getResources().getColor(R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    private void c() {
        if (!TextUtils.isEmpty(this.f38576e)) {
            setText(this.f38576e);
        } else {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.f38577f), Integer.valueOf((int) this.f38578g)));
        }
    }

    private void d() {
        if (this.f38575d != 0.0f) {
            float f4 = this.f38577f;
            float f5 = this.f38578g;
            this.f38577f = f5;
            this.f38578g = f4;
            this.f38575d = f5 / f4;
        }
    }

    public float getAspectRatio(boolean z3) {
        if (z3) {
            d();
            c();
        }
        return this.f38575d;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.f38572a);
            Rect rect = this.f38572a;
            int i4 = rect.bottom;
            int i5 = this.f38574c;
            canvas.drawCircle((rect.right - rect.left) / 2.0f, i4 - i5, i5 / 2, this.f38573b);
        }
    }

    public void setActiveColor(@ColorInt int i4) {
        a(i4);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.f38576e = aspectRatio.getAspectRatioTitle();
        this.f38577f = aspectRatio.getAspectRatioX();
        float aspectRatioY = aspectRatio.getAspectRatioY();
        this.f38578g = aspectRatioY;
        float f4 = this.f38577f;
        if (f4 != 0.0f && aspectRatioY != 0.0f) {
            this.f38575d = f4 / aspectRatioY;
        } else {
            this.f38575d = 0.0f;
        }
        c();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38572a = new Rect();
        b(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f38572a = new Rect();
        b(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }
}
