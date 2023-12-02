package com.h6ah4i.android.widget.advrecyclerview.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class ItemShadowDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final NinePatchDrawable f33719a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f33720b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33721c;

    public ItemShadowDecorator(@NonNull NinePatchDrawable ninePatchDrawable) {
        this(ninePatchDrawable, true);
    }

    private boolean a(View view) {
        Drawable background;
        if (view.getVisibility() != 0 || view.getAlpha() != 1.0f || (background = view.getBackground()) == null) {
            return false;
        }
        if (!this.f33721c && (background instanceof ColorDrawable) && ((ColorDrawable) background).getAlpha() == 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        if (childCount == 0) {
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            if (a(childAt)) {
                int translationX = (int) (childAt.getTranslationX() + 0.5f);
                int translationY = (int) (childAt.getTranslationY() + 0.5f);
                int left = childAt.getLeft() - this.f33720b.left;
                int right = childAt.getRight() + this.f33720b.right;
                this.f33719a.setBounds(left + translationX, (childAt.getTop() - this.f33720b.top) + translationY, right + translationX, childAt.getBottom() + this.f33720b.bottom + translationY);
                this.f33719a.draw(canvas);
            }
        }
    }

    public ItemShadowDecorator(@NonNull NinePatchDrawable ninePatchDrawable, boolean z3) {
        Rect rect = new Rect();
        this.f33720b = rect;
        this.f33719a = ninePatchDrawable;
        ninePatchDrawable.getPadding(rect);
        this.f33721c = z3;
    }
}
