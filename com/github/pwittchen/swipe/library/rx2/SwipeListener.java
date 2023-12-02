package com.github.pwittchen.swipe.library.rx2;

import android.view.MotionEvent;

/* loaded from: classes3.dex */
public interface SwipeListener {
    boolean onSwipedDown(MotionEvent motionEvent);

    boolean onSwipedLeft(MotionEvent motionEvent);

    boolean onSwipedRight(MotionEvent motionEvent);

    boolean onSwipedUp(MotionEvent motionEvent);

    void onSwipingDown(MotionEvent motionEvent);

    void onSwipingLeft(MotionEvent motionEvent);

    void onSwipingRight(MotionEvent motionEvent);

    void onSwipingUp(MotionEvent motionEvent);
}
