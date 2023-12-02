package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* loaded from: classes5.dex */
public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f23594h = R.style.Widget_MaterialComponents_MaterialDivider;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private Drawable f23595a;

    /* renamed from: b  reason: collision with root package name */
    private int f23596b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private int f23597c;

    /* renamed from: d  reason: collision with root package name */
    private int f23598d;

    /* renamed from: e  reason: collision with root package name */
    private int f23599e;

    /* renamed from: f  reason: collision with root package name */
    private int f23600f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f23601g;

    public MaterialDividerItemDecoration(@NonNull Context context, int i4) {
        this(context, null, i4);
    }

    private void a(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int height;
        int i4;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i4 = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i4, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            i4 = 0;
        }
        int i5 = i4 + this.f23599e;
        int i6 = height - this.f23600f;
        int childCount = recyclerView.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = recyclerView.getChildAt(i7);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.f23601g);
            int round = this.f23601g.right + Math.round(childAt.getTranslationX());
            this.f23595a.setBounds((round - this.f23595a.getIntrinsicWidth()) - this.f23596b, i5, round, i6);
            this.f23595a.draw(canvas);
        }
        canvas.restore();
    }

    private void b(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int width;
        int i4;
        int i5;
        int i6;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i4 = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i4, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            i4 = 0;
        }
        boolean z3 = true;
        if (ViewCompat.getLayoutDirection(recyclerView) != 1) {
            z3 = false;
        }
        if (z3) {
            i5 = this.f23600f;
        } else {
            i5 = this.f23599e;
        }
        int i7 = i4 + i5;
        if (z3) {
            i6 = this.f23599e;
        } else {
            i6 = this.f23600f;
        }
        int i8 = width - i6;
        int childCount = recyclerView.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = recyclerView.getChildAt(i9);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.f23601g);
            int round = this.f23601g.bottom + Math.round(childAt.getTranslationY());
            this.f23595a.setBounds(i7, (round - this.f23595a.getIntrinsicHeight()) - this.f23596b, i8, round);
            this.f23595a.draw(canvas);
        }
        canvas.restore();
    }

    @ColorInt
    public int getDividerColor() {
        return this.f23597c;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f23600f;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f23599e;
    }

    @Px
    public int getDividerThickness() {
        return this.f23596b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
        if (this.f23598d == 1) {
            rect.bottom = this.f23595a.getIntrinsicHeight() + this.f23596b;
        } else {
            rect.right = this.f23595a.getIntrinsicWidth() + this.f23596b;
        }
    }

    public int getOrientation() {
        return this.f23598d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        if (this.f23598d == 1) {
            b(canvas, recyclerView);
        } else {
            a(canvas, recyclerView);
        }
    }

    public void setDividerColor(@ColorInt int i4) {
        this.f23597c = i4;
        Drawable wrap = DrawableCompat.wrap(this.f23595a);
        this.f23595a = wrap;
        DrawableCompat.setTint(wrap, i4);
    }

    public void setDividerColorResource(@NonNull Context context, @ColorRes int i4) {
        setDividerColor(ContextCompat.getColor(context, i4));
    }

    public void setDividerInsetEnd(@Px int i4) {
        this.f23600f = i4;
    }

    public void setDividerInsetEndResource(@NonNull Context context, @DimenRes int i4) {
        setDividerInsetEnd(context.getResources().getDimensionPixelOffset(i4));
    }

    public void setDividerInsetStart(@Px int i4) {
        this.f23599e = i4;
    }

    public void setDividerInsetStartResource(@NonNull Context context, @DimenRes int i4) {
        setDividerInsetStart(context.getResources().getDimensionPixelOffset(i4));
    }

    public void setDividerThickness(@Px int i4) {
        this.f23596b = i4;
    }

    public void setDividerThicknessResource(@NonNull Context context, @DimenRes int i4) {
        setDividerThickness(context.getResources().getDimensionPixelSize(i4));
    }

    public void setOrientation(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("Invalid orientation: " + i4 + ". It should be either HORIZONTAL or VERTICAL");
        }
        this.f23598d = i4;
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        this(context, attributeSet, R.attr.materialDividerStyle, i4);
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        this.f23601g = new Rect();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.MaterialDivider, i4, f23594h, new int[0]);
        this.f23597c = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.f23596b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, context.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f23599e = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.f23600f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        obtainStyledAttributes.recycle();
        this.f23595a = new ShapeDrawable();
        setDividerColor(this.f23597c);
        setOrientation(i5);
    }
}
