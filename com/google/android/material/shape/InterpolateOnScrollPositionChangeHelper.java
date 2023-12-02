package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class InterpolateOnScrollPositionChangeHelper {

    /* renamed from: a  reason: collision with root package name */
    private View f24184a;

    /* renamed from: b  reason: collision with root package name */
    private MaterialShapeDrawable f24185b;

    /* renamed from: c  reason: collision with root package name */
    private ScrollView f24186c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f24187d = new int[2];

    /* renamed from: e  reason: collision with root package name */
    private final int[] f24188e = new int[2];

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f24189f = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper.1
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            InterpolateOnScrollPositionChangeHelper.this.updateInterpolationForScreenPosition();
        }
    };

    public InterpolateOnScrollPositionChangeHelper(View view, MaterialShapeDrawable materialShapeDrawable, ScrollView scrollView) {
        this.f24184a = view;
        this.f24185b = materialShapeDrawable;
        this.f24186c = scrollView;
    }

    public void setContainingScrollView(ScrollView scrollView) {
        this.f24186c = scrollView;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable materialShapeDrawable) {
        this.f24185b = materialShapeDrawable;
    }

    public void startListeningForScrollChanges(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.f24189f);
    }

    public void stopListeningForScrollChanges(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.f24189f);
    }

    public void updateInterpolationForScreenPosition() {
        ScrollView scrollView = this.f24186c;
        if (scrollView == null) {
            return;
        }
        if (scrollView.getChildCount() != 0) {
            this.f24186c.getLocationInWindow(this.f24187d);
            this.f24186c.getChildAt(0).getLocationInWindow(this.f24188e);
            int top = (this.f24184a.getTop() - this.f24187d[1]) + this.f24188e[1];
            int height = this.f24184a.getHeight();
            int height2 = this.f24186c.getHeight();
            if (top < 0) {
                this.f24185b.setInterpolation(Math.max(0.0f, Math.min(1.0f, (top / height) + 1.0f)));
                this.f24184a.invalidate();
                return;
            }
            int i4 = top + height;
            if (i4 > height2) {
                this.f24185b.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - ((i4 - height2) / height))));
                this.f24184a.invalidate();
                return;
            } else if (this.f24185b.getInterpolation() != 1.0f) {
                this.f24185b.setInterpolation(1.0f);
                this.f24184a.invalidate();
                return;
            } else {
                return;
            }
        }
        throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
    }
}
