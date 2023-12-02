package com.github.pwittchen.swipe.library.rx2;

import android.view.MotionEvent;

/* loaded from: classes3.dex */
public abstract class SimpleSwipeListener implements SwipeListener {
    @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
    public boolean onSwipedDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
    public boolean onSwipedLeft(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
    public boolean onSwipedRight(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
    public boolean onSwipedUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
    public void onSwipingDown(MotionEvent motionEvent) {
    }

    @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
    public void onSwipingLeft(MotionEvent motionEvent) {
    }

    @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
    public void onSwipingRight(MotionEvent motionEvent) {
    }

    @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
    public void onSwipingUp(MotionEvent motionEvent) {
    }
}
