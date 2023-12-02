package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemState;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder;

/* loaded from: classes6.dex */
public abstract class AbstractSwipeableItemViewHolder extends RecyclerView.ViewHolder implements SwipeableItemViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private SwipeableItemState f34006a;

    /* renamed from: b  reason: collision with root package name */
    private int f34007b;

    /* renamed from: c  reason: collision with root package name */
    private int f34008c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f34009d;

    /* renamed from: e  reason: collision with root package name */
    private float f34010e;

    /* renamed from: f  reason: collision with root package name */
    private float f34011f;

    /* renamed from: g  reason: collision with root package name */
    private float f34012g;

    /* renamed from: h  reason: collision with root package name */
    private float f34013h;

    /* renamed from: i  reason: collision with root package name */
    private float f34014i;

    /* renamed from: j  reason: collision with root package name */
    private float f34015j;

    public AbstractSwipeableItemViewHolder(@NonNull View view) {
        super(view);
        this.f34006a = new SwipeableItemState();
        this.f34007b = 0;
        this.f34008c = 0;
        this.f34009d = true;
        this.f34012g = -65536.0f;
        this.f34013h = -65537.0f;
        this.f34014i = 65536.0f;
        this.f34015j = 65537.0f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public int getAfterSwipeReaction() {
        return this.f34008c;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getMaxDownSwipeAmount() {
        return this.f34015j;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getMaxLeftSwipeAmount() {
        return this.f34012g;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getMaxRightSwipeAmount() {
        return this.f34014i;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getMaxUpSwipeAmount() {
        return this.f34013h;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getSwipeItemHorizontalSlideAmount() {
        return this.f34010e;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getSwipeItemVerticalSlideAmount() {
        return this.f34011f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public int getSwipeResult() {
        return this.f34007b;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    @NonNull
    public SwipeableItemState getSwipeState() {
        return this.f34006a;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public int getSwipeStateFlags() {
        return this.f34006a.getFlags();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    @NonNull
    public abstract View getSwipeableContainerView();

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public boolean isProportionalSwipeAmountModeEnabled() {
        return this.f34009d;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setAfterSwipeReaction(int i4) {
        this.f34008c = i4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setMaxDownSwipeAmount(float f4) {
        this.f34015j = f4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setMaxLeftSwipeAmount(float f4) {
        this.f34012g = f4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setMaxRightSwipeAmount(float f4) {
        this.f34014i = f4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setMaxUpSwipeAmount(float f4) {
        this.f34013h = f4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setProportionalSwipeAmountModeEnabled(boolean z3) {
        this.f34009d = z3;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setSwipeItemHorizontalSlideAmount(float f4) {
        this.f34010e = f4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setSwipeItemVerticalSlideAmount(float f4) {
        this.f34011f = f4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setSwipeResult(int i4) {
        this.f34007b = i4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setSwipeStateFlags(int i4) {
        this.f34006a.setFlags(i4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void onSlideAmountUpdated(float f4, float f5, boolean z3) {
    }
}
