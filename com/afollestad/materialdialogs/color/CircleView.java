package com.afollestad.materialdialogs.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.core.view.ViewCompat;
import com.afollestad.materialdialogs.util.DialogUtils;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes2.dex */
public class CircleView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f1071a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1072b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f1073c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f1074d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f1075e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1076f;

    public CircleView(Context context) {
        this(context, null, 0);
    }

    private Drawable a(int i4) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(b(shiftColorUp(i4)));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, shapeDrawable);
        return stateListDrawable;
    }

    @ColorInt
    private static int b(int i4) {
        return Color.argb(Math.round(Color.alpha(i4) * 0.7f), Color.red(i4), Color.green(i4), Color.blue(i4));
    }

    private void c(@ColorInt int i4) {
        this.f1075e.setColor(i4);
        this.f1073c.setColor(shiftColorDown(i4));
        setForeground(new RippleDrawable(new ColorStateList(new int[][]{new int[]{16842919}}, new int[]{shiftColorUp(i4)}), a(i4), null));
    }

    @ColorInt
    public static int shiftColor(@ColorInt int i4, @FloatRange(from = 0.0d, to = 2.0d) float f4) {
        if (f4 == 1.0f) {
            return i4;
        }
        Color.colorToHSV(i4, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * f4};
        return Color.HSVToColor(fArr);
    }

    @ColorInt
    public static int shiftColorDown(@ColorInt int i4) {
        return shiftColor(i4, 0.9f);
    }

    @ColorInt
    public static int shiftColorUp(@ColorInt int i4) {
        return shiftColor(i4, 1.1f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth() / 2;
        if (this.f1076f) {
            int i4 = measuredWidth - this.f1072b;
            int i5 = i4 - this.f1071a;
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, this.f1073c);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, i4, this.f1074d);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, i5, this.f1075e);
            return;
        }
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, this.f1075e);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i4);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

    @Override // android.view.View
    @Deprecated
    public void setActivated(boolean z3) {
        throw new IllegalStateException("Cannot use setActivated() on CircleView.");
    }

    @Override // android.view.View
    @Deprecated
    public void setBackground(Drawable drawable) {
        throw new IllegalStateException("Cannot use setBackground() on CircleView.");
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i4) {
        c(i4);
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        throw new IllegalStateException("Cannot use setBackgroundDrawable() on CircleView.");
    }

    @Override // android.view.View
    public void setBackgroundResource(@ColorRes int i4) {
        setBackgroundColor(DialogUtils.getColor(getContext(), i4));
    }

    @Override // android.view.View
    public void setSelected(boolean z3) {
        this.f1076f = z3;
        requestLayout();
        invalidate();
    }

    public void showHint(int i4) {
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i5 = iArr[1] + (height / 2);
        int i6 = iArr[0] + (width / 2);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            i6 = context.getResources().getDisplayMetrics().widthPixels - i6;
        }
        Toast makeText = Toast.makeText(context, String.format("#%06X", Integer.valueOf(i4 & 16777215)), 0);
        if (i5 < rect.height()) {
            makeText.setGravity(BadgeDrawable.TOP_END, i6, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Resources resources = getResources();
        this.f1071a = (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics());
        this.f1072b = (int) TypedValue.applyDimension(1, 5.0f, resources.getDisplayMetrics());
        Paint paint = new Paint();
        this.f1074d = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        Paint paint2 = new Paint();
        this.f1075e = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f1073c = paint3;
        paint3.setAntiAlias(true);
        c(-12303292);
        setWillNotDraw(false);
    }
}
