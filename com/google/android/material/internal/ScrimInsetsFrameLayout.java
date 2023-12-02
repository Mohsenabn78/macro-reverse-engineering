package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    Drawable f23872a;

    /* renamed from: b  reason: collision with root package name */
    Rect f23873b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f23874c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23875d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23876e;

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f23873b != null && this.f23872a != null) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.f23875d) {
                this.f23874c.set(0, 0, width, this.f23873b.top);
                this.f23872a.setBounds(this.f23874c);
                this.f23872a.draw(canvas);
            }
            if (this.f23876e) {
                this.f23874c.set(0, height - this.f23873b.bottom, width, height);
                this.f23872a.setBounds(this.f23874c);
                this.f23872a.draw(canvas);
            }
            Rect rect = this.f23874c;
            Rect rect2 = this.f23873b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f23872a.setBounds(this.f23874c);
            this.f23872a.draw(canvas);
            Rect rect3 = this.f23874c;
            Rect rect4 = this.f23873b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f23872a.setBounds(this.f23874c);
            this.f23872a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f23872a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f23872a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z3) {
        this.f23876e = z3;
    }

    public void setDrawTopInsetForeground(boolean z3) {
        this.f23875d = z3;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.f23872a = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f23874c = new Rect();
        this.f23875d = true;
        this.f23876e = true;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i4, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f23872a = obtainStyledAttributes.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ScrimInsetsFrameLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                boolean z3;
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (scrimInsetsFrameLayout.f23873b == null) {
                    scrimInsetsFrameLayout.f23873b = new Rect();
                }
                ScrimInsetsFrameLayout.this.f23873b.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout2 = ScrimInsetsFrameLayout.this;
                if (windowInsetsCompat.hasSystemWindowInsets() && ScrimInsetsFrameLayout.this.f23872a != null) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                scrimInsetsFrameLayout2.setWillNotDraw(z3);
                ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    protected void a(WindowInsetsCompat windowInsetsCompat) {
    }
}
