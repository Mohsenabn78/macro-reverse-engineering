package com.h6ah4i.android.widget.advrecyclerview.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class SimpleListDividerDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f33722a;

    /* renamed from: b  reason: collision with root package name */
    private final Drawable f33723b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33724c;

    /* renamed from: d  reason: collision with root package name */
    private final int f33725d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f33726e;

    public SimpleListDividerDecorator(@Nullable Drawable drawable, boolean z3) {
        this(drawable, null, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (this.f33726e) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(0, 0, this.f33725d, this.f33724c);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        float f4;
        float f5;
        int i4;
        int i5;
        RecyclerView recyclerView2 = recyclerView;
        int childCount = recyclerView.getChildCount();
        if (childCount == 0) {
            return;
        }
        boolean z3 = this.f33726e;
        float f6 = 1.0f;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = this.f33725d + 1.0f;
        }
        if (z3) {
            f5 = 1.0f;
        } else {
            f5 = this.f33724c + 1.0f;
        }
        int i6 = 0;
        while (i6 < childCount - 1) {
            View childAt = recyclerView2.getChildAt(i6);
            i6++;
            View childAt2 = recyclerView2.getChildAt(i6);
            if (childAt.getVisibility() == 0 && childAt2.getVisibility() == 0) {
                float bottom = childAt.getBottom() + childAt.getTranslationY();
                float top = childAt2.getTop() + childAt2.getTranslationY();
                float right = childAt.getRight() + childAt.getTranslationX();
                float left = childAt2.getLeft() + childAt2.getTranslationX();
                if ((this.f33724c != 0 && Math.abs(top - bottom) < f5) || (this.f33725d != 0 && Math.abs(left - right) < f4)) {
                    if (Math.abs((ViewCompat.getTranslationZ(childAt2) + ViewCompat.getElevation(childAt2)) - (ViewCompat.getTranslationZ(childAt) + ViewCompat.getElevation(childAt))) < f6) {
                        float alpha = childAt.getAlpha();
                        float alpha2 = childAt2.getAlpha();
                        int translationX = (int) (childAt.getTranslationX() + 0.5f);
                        int translationY = (int) (childAt.getTranslationY() + 0.5f);
                        if (this.f33724c != 0) {
                            int left2 = childAt.getLeft();
                            int right2 = childAt.getRight();
                            int bottom2 = childAt.getBottom();
                            if (this.f33726e) {
                                i5 = this.f33724c;
                            } else {
                                i5 = 0;
                            }
                            int i7 = bottom2 - i5;
                            this.f33722a.setAlpha((int) (((alpha + alpha2) * 127.5f) + 0.5f));
                            this.f33722a.setBounds(left2 + translationX, i7 + translationY, right2 + translationX, i7 + this.f33724c + translationY);
                            this.f33722a.draw(canvas);
                        }
                        if (this.f33725d != 0) {
                            int right3 = childAt.getRight();
                            if (this.f33726e) {
                                i4 = this.f33725d;
                            } else {
                                i4 = 0;
                            }
                            int i8 = right3 - i4;
                            int i9 = this.f33725d + i8;
                            int top2 = childAt.getTop();
                            int bottom3 = childAt.getBottom();
                            this.f33723b.setAlpha((int) (((alpha + alpha2) * 127.5f) + 0.5f));
                            this.f33723b.setBounds(i8 + translationX, top2 + translationY, i9 + translationX, bottom3 + translationY);
                            this.f33723b.draw(canvas);
                        }
                    }
                }
            }
            recyclerView2 = recyclerView;
            f6 = 1.0f;
        }
    }

    public SimpleListDividerDecorator(@Nullable Drawable drawable, @Nullable Drawable drawable2, boolean z3) {
        this.f33722a = drawable;
        this.f33723b = drawable2;
        this.f33724c = drawable != null ? drawable.getIntrinsicHeight() : 0;
        this.f33725d = drawable2 != null ? drawable2.getIntrinsicWidth() : 0;
        this.f33726e = z3;
    }
}
