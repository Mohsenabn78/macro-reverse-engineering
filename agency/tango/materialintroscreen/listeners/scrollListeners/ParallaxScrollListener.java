package agency.tango.materialintroscreen.listeners.scrollListeners;

import agency.tango.materialintroscreen.SlideFragment;
import agency.tango.materialintroscreen.adapter.SlidesAdapter;
import agency.tango.materialintroscreen.listeners.IPageScrolledListener;
import agency.tango.materialintroscreen.parallax.Parallaxable;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ParallaxScrollListener implements IPageScrolledListener {

    /* renamed from: a  reason: collision with root package name */
    private SlidesAdapter f125a;

    public ParallaxScrollListener(SlidesAdapter slidesAdapter) {
        this.f125a = slidesAdapter;
    }

    @Nullable
    private SlideFragment a(int i4) {
        if (i4 < this.f125a.getLastItemPosition()) {
            return this.f125a.getItem(i4 + 1);
        }
        return null;
    }

    @Override // agency.tango.materialintroscreen.listeners.IPageScrolledListener
    public void pageScrolled(int i4, float f4) {
        if (i4 != this.f125a.slidesCount()) {
            SlideFragment item = this.f125a.getItem(i4);
            SlideFragment a4 = a(i4);
            boolean z3 = item instanceof Parallaxable;
            if (z3) {
                item.setOffset(f4);
            }
            if (a4 != null && z3) {
                a4.setOffset(f4 - 1.0f);
            }
        }
    }
}
