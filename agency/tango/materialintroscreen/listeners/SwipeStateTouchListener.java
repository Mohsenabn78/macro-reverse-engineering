package agency.tango.materialintroscreen.listeners;

import agency.tango.materialintroscreen.SlideFragment;
import agency.tango.materialintroscreen.adapter.SlidesAdapter;
import agency.tango.materialintroscreen.widgets.SwipeableViewPager;

/* loaded from: classes.dex */
public class SwipeStateTouchListener implements ITouchEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final SwipeableViewPager f117a;

    /* renamed from: b  reason: collision with root package name */
    private final SlidesAdapter f118b;

    public SwipeStateTouchListener(SwipeableViewPager swipeableViewPager, SlidesAdapter slidesAdapter) {
        this.f117a = swipeableViewPager;
        this.f118b = slidesAdapter;
    }

    @Override // agency.tango.materialintroscreen.listeners.ITouchEventListener
    public void process() {
        SlideFragment item = this.f118b.getItem(this.f117a.getCurrentItem());
        if (item.canMoveFurther() && !item.hasNeededPermissionsToGrant()) {
            this.f117a.setAllowedSwipeDirection(SwipeableViewPager.SwipeDirection.all);
        } else {
            this.f117a.setAllowedSwipeDirection(SwipeableViewPager.SwipeDirection.left);
        }
    }
}
