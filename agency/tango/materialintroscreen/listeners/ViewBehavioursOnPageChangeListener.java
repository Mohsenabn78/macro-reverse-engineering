package agency.tango.materialintroscreen.listeners;

import agency.tango.materialintroscreen.adapter.SlidesAdapter;
import agency.tango.materialintroscreen.animations.ViewTranslationWrapper;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ViewBehavioursOnPageChangeListener implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final SlidesAdapter f119a;

    /* renamed from: b  reason: collision with root package name */
    private List<IPageSelectedListener> f120b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<ViewTranslationWrapper> f121c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<IPageScrolledListener> f122d = new ArrayList();

    public ViewBehavioursOnPageChangeListener(SlidesAdapter slidesAdapter) {
        this.f119a = slidesAdapter;
    }

    private boolean a(int i4) {
        if (i4 == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i4, float f4, int i5) {
        if (a(i4)) {
            for (ViewTranslationWrapper viewTranslationWrapper : this.f121c) {
                viewTranslationWrapper.enterTranslate(f4);
            }
        } else if (this.f119a.isLastSlide(i4)) {
            for (ViewTranslationWrapper viewTranslationWrapper2 : this.f121c) {
                viewTranslationWrapper2.exitTranslate(f4);
            }
        } else {
            for (ViewTranslationWrapper viewTranslationWrapper3 : this.f121c) {
                viewTranslationWrapper3.defaultTranslate(f4);
            }
        }
        for (IPageScrolledListener iPageScrolledListener : this.f122d) {
            iPageScrolledListener.pageScrolled(i4, f4);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i4) {
        for (IPageSelectedListener iPageSelectedListener : this.f120b) {
            iPageSelectedListener.pageSelected(i4);
        }
    }

    public ViewBehavioursOnPageChangeListener registerOnPageScrolled(IPageScrolledListener iPageScrolledListener) {
        this.f122d.add(iPageScrolledListener);
        return this;
    }

    public ViewBehavioursOnPageChangeListener registerPageSelectedListener(IPageSelectedListener iPageSelectedListener) {
        this.f120b.add(iPageSelectedListener);
        return this;
    }

    public ViewBehavioursOnPageChangeListener registerViewTranslationWrapper(ViewTranslationWrapper viewTranslationWrapper) {
        this.f121c.add(viewTranslationWrapper);
        return this;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i4) {
    }
}
