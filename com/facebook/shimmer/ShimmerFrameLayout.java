package com.facebook.shimmer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.shimmer.Shimmer;

/* loaded from: classes3.dex */
public class ShimmerFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f17634a;

    /* renamed from: b  reason: collision with root package name */
    private final ShimmerDrawable f17635b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17636c;

    public ShimmerFrameLayout(Context context) {
        super(context);
        this.f17634a = new Paint();
        this.f17635b = new ShimmerDrawable();
        this.f17636c = true;
        a(context, null);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet) {
        Shimmer.Builder alphaHighlightBuilder;
        setWillNotDraw(false);
        this.f17635b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new Shimmer.AlphaHighlightBuilder().build());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            int i4 = R.styleable.ShimmerFrameLayout_shimmer_colored;
            if (obtainStyledAttributes.hasValue(i4) && obtainStyledAttributes.getBoolean(i4, false)) {
                alphaHighlightBuilder = new Shimmer.ColorHighlightBuilder();
            } else {
                alphaHighlightBuilder = new Shimmer.AlphaHighlightBuilder();
            }
            setShimmer(alphaHighlightBuilder.b(obtainStyledAttributes).build());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f17636c) {
            this.f17635b.draw(canvas);
        }
    }

    public void hideShimmer() {
        if (!this.f17636c) {
            return;
        }
        stopShimmer();
        this.f17636c = false;
        invalidate();
    }

    public boolean isShimmerStarted() {
        return this.f17635b.isShimmerStarted();
    }

    public boolean isShimmerVisible() {
        return this.f17636c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f17635b.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        this.f17635b.setBounds(0, 0, getWidth(), getHeight());
    }

    public ShimmerFrameLayout setShimmer(@Nullable Shimmer shimmer) {
        this.f17635b.setShimmer(shimmer);
        if (shimmer != null && shimmer.f17619o) {
            setLayerType(2, this.f17634a);
        } else {
            setLayerType(0, null);
        }
        return this;
    }

    public void showShimmer(boolean z3) {
        if (this.f17636c) {
            return;
        }
        this.f17636c = true;
        if (z3) {
            startShimmer();
        }
    }

    public void startShimmer() {
        this.f17635b.startShimmer();
    }

    public void stopShimmer() {
        this.f17635b.stopShimmer();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f17635b) {
            return false;
        }
        return true;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17634a = new Paint();
        this.f17635b = new ShimmerDrawable();
        this.f17636c = true;
        a(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f17634a = new Paint();
        this.f17635b = new ShimmerDrawable();
        this.f17636c = true;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f17634a = new Paint();
        this.f17635b = new ShimmerDrawable();
        this.f17636c = true;
        a(context, attributeSet);
    }
}
