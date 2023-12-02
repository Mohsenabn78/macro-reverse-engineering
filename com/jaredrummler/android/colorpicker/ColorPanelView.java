package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Locale;

/* loaded from: classes6.dex */
public class ColorPanelView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f34451a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f34452b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f34453c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f34454d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f34455e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f34456f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f34457g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f34458h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f34459i;

    /* renamed from: j  reason: collision with root package name */
    private int f34460j;

    /* renamed from: k  reason: collision with root package name */
    private int f34461k;

    /* renamed from: l  reason: collision with root package name */
    private int f34462l;

    /* renamed from: m  reason: collision with root package name */
    private int f34463m;

    public ColorPanelView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPanelView);
        this.f34463m = obtainStyledAttributes.getInt(R.styleable.ColorPanelView_cpv_colorShape, 1);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.ColorPanelView_cpv_showOldColor, false);
        this.f34459i = z3;
        if (z3 && this.f34463m != 1) {
            throw new IllegalStateException("Color preview is only available in circle mode");
        }
        this.f34461k = obtainStyledAttributes.getColor(R.styleable.ColorPanelView_cpv_borderColor, -9539986);
        obtainStyledAttributes.recycle();
        if (this.f34461k == -9539986) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{16842808});
            this.f34461k = obtainStyledAttributes2.getColor(0, this.f34461k);
            obtainStyledAttributes2.recycle();
        }
        this.f34460j = c.a(context, 1.0f);
        Paint paint = new Paint();
        this.f34452b = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f34453c = paint2;
        paint2.setAntiAlias(true);
        if (this.f34459i) {
            this.f34455e = new Paint();
        }
        if (this.f34463m == 1) {
            Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.cpv_alpha)).getBitmap();
            Paint paint3 = new Paint();
            this.f34454d = paint3;
            paint3.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f34454d.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        }
    }

    private void b() {
        Rect rect = this.f34456f;
        int i4 = rect.left;
        int i5 = this.f34460j;
        this.f34458h = new RectF(i4 + i5, rect.top + i5, rect.right - i5, rect.bottom - i5);
    }

    private void c() {
        Rect rect = this.f34456f;
        int i4 = rect.left;
        int i5 = this.f34460j;
        this.f34457g = new Rect(i4 + i5, rect.top + i5, rect.right - i5, rect.bottom - i5);
        a aVar = new a(c.a(getContext(), 4.0f));
        this.f34451a = aVar;
        aVar.setBounds(Math.round(this.f34457g.left), Math.round(this.f34457g.top), Math.round(this.f34457g.right), Math.round(this.f34457g.bottom));
    }

    public int getBorderColor() {
        return this.f34461k;
    }

    public int getColor() {
        return this.f34462l;
    }

    @ColorShape
    public int getShape() {
        return this.f34463m;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f34452b.setColor(this.f34461k);
        this.f34453c.setColor(this.f34462l);
        int i4 = this.f34463m;
        if (i4 == 0) {
            if (this.f34460j > 0) {
                canvas.drawRect(this.f34456f, this.f34452b);
            }
            Drawable drawable = this.f34451a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            canvas.drawRect(this.f34457g, this.f34453c);
        } else if (i4 == 1) {
            int measuredWidth = getMeasuredWidth() / 2;
            if (this.f34460j > 0) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, this.f34452b);
            }
            if (Color.alpha(this.f34462l) < 255) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth - this.f34460j, this.f34454d);
            }
            if (this.f34459i) {
                canvas.drawArc(this.f34458h, 90.0f, 180.0f, true, this.f34455e);
                canvas.drawArc(this.f34458h, 270.0f, 180.0f, true, this.f34453c);
                return;
            }
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth - this.f34460j, this.f34453c);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6 = this.f34463m;
        if (i6 == 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i4), View.MeasureSpec.getSize(i5));
        } else if (i6 == 1) {
            super.onMeasure(i4, i4);
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        } else {
            super.onMeasure(i4, i5);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f34462l = bundle.getInt(TypedValues.Custom.S_COLOR);
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt(TypedValues.Custom.S_COLOR, this.f34462l);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (this.f34463m == 0 || this.f34459i) {
            Rect rect = new Rect();
            this.f34456f = rect;
            rect.left = getPaddingLeft();
            this.f34456f.right = i4 - getPaddingRight();
            this.f34456f.top = getPaddingTop();
            this.f34456f.bottom = i5 - getPaddingBottom();
            if (this.f34459i) {
                b();
            } else {
                c();
            }
        }
    }

    public void setBorderColor(int i4) {
        this.f34461k = i4;
        invalidate();
    }

    public void setColor(int i4) {
        this.f34462l = i4;
        invalidate();
    }

    public void setOriginalColor(@ColorInt int i4) {
        Paint paint = this.f34455e;
        if (paint != null) {
            paint.setColor(i4);
        }
    }

    public void setShape(@ColorShape int i4) {
        this.f34463m = i4;
        invalidate();
    }

    public void showHint() {
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i4 = iArr[1] + (height / 2);
        int i5 = iArr[0] + (width / 2);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            i5 = context.getResources().getDisplayMetrics().widthPixels - i5;
        }
        StringBuilder sb = new StringBuilder("#");
        if (Color.alpha(this.f34462l) != 255) {
            sb.append(Integer.toHexString(this.f34462l).toUpperCase(Locale.ENGLISH));
        } else {
            sb.append(String.format("%06X", Integer.valueOf(16777215 & this.f34462l)).toUpperCase(Locale.ENGLISH));
        }
        Toast makeText = Toast.makeText(context, sb.toString(), 0);
        if (i4 < rect.height()) {
            makeText.setGravity(BadgeDrawable.TOP_END, i5, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
    }

    public ColorPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPanelView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f34458h = new RectF();
        this.f34461k = -9539986;
        this.f34462l = -16777216;
        a(context, attributeSet);
    }
}
