package agency.tango.materialintroscreen.widgets;

import agency.tango.materialintroscreen.adapter.SlidesAdapter;
import agency.tango.materialintroscreen.listeners.ITouchEventListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SwipeableViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private float f183a;

    /* renamed from: b  reason: collision with root package name */
    private SwipeDirection f184b;

    /* renamed from: c  reason: collision with root package name */
    List<ITouchEventListener> f185c;

    /* loaded from: classes.dex */
    public enum SwipeDirection {
        all,
        left,
        right,
        none
    }

    public SwipeableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f185c = new ArrayList();
        this.f184b = SwipeDirection.all;
    }

    private boolean a(MotionEvent motionEvent) {
        SwipeDirection swipeDirection = this.f184b;
        if (swipeDirection == SwipeDirection.all) {
            return true;
        }
        if (swipeDirection == SwipeDirection.none) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f183a = motionEvent.getX();
            return true;
        }
        if (motionEvent.getAction() == 2) {
            try {
                float x3 = motionEvent.getX() - this.f183a;
                if (x3 > 0.0f && this.f184b == SwipeDirection.right) {
                    return false;
                }
                if (x3 < 0.0f) {
                    if (this.f184b == SwipeDirection.left) {
                        return false;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return true;
    }

    public int getPreviousItem() {
        return getCurrentItem() - 1;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (ITouchEventListener iTouchEventListener : this.f185c) {
            iTouchEventListener.process();
        }
        if (a(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public SwipeableViewPager registerOnTouchEventListener(ITouchEventListener iTouchEventListener) {
        this.f185c.add(iTouchEventListener);
        return this;
    }

    public void setAllowedSwipeDirection(SwipeDirection swipeDirection) {
        this.f184b = swipeDirection;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public SlidesAdapter getAdapter() {
        return (SlidesAdapter) super.getAdapter();
    }
}
