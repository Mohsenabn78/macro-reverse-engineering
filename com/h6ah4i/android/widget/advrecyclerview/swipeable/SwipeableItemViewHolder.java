package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public interface SwipeableItemViewHolder {
    int getAfterSwipeReaction();

    float getMaxDownSwipeAmount();

    float getMaxLeftSwipeAmount();

    float getMaxRightSwipeAmount();

    float getMaxUpSwipeAmount();

    float getSwipeItemHorizontalSlideAmount();

    float getSwipeItemVerticalSlideAmount();

    int getSwipeResult();

    @NonNull
    SwipeableItemState getSwipeState();

    int getSwipeStateFlags();

    @NonNull
    View getSwipeableContainerView();

    boolean isProportionalSwipeAmountModeEnabled();

    void onSlideAmountUpdated(float f4, float f5, boolean z3);

    void setAfterSwipeReaction(int i4);

    void setMaxDownSwipeAmount(float f4);

    void setMaxLeftSwipeAmount(float f4);

    void setMaxRightSwipeAmount(float f4);

    void setMaxUpSwipeAmount(float f4);

    void setProportionalSwipeAmountModeEnabled(boolean z3);

    void setSwipeItemHorizontalSlideAmount(float f4);

    void setSwipeItemVerticalSlideAmount(float f4);

    void setSwipeResult(int i4);

    void setSwipeStateFlags(int i4);
}
