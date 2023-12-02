package agency.tango.materialintroscreen.adapter;

import agency.tango.materialintroscreen.LastEmptySlideFragment;
import agency.tango.materialintroscreen.SlideFragment;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SlidesAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<SlideFragment> f106a;

    public SlidesAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f106a = new ArrayList<>();
    }

    private boolean a() {
        if (this.f106a.size() > 0) {
            ArrayList<SlideFragment> arrayList = this.f106a;
            if (arrayList.get(arrayList.size() - 1) instanceof LastEmptySlideFragment) {
                return true;
            }
        }
        return false;
    }

    public void addEmptySlide(LastEmptySlideFragment lastEmptySlideFragment) {
        this.f106a.add(lastEmptySlideFragment);
        notifyDataSetChanged();
    }

    public void addItem(SlideFragment slideFragment) {
        this.f106a.add(slidesCount(), slideFragment);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f106a.size();
    }

    public int getLastItemPosition() {
        return slidesCount() - 1;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i4) {
        SlideFragment slideFragment = (SlideFragment) super.instantiateItem(viewGroup, i4);
        this.f106a.set(i4, slideFragment);
        return slideFragment;
    }

    public boolean isLastSlide(int i4) {
        if (i4 == slidesCount() - 1) {
            return true;
        }
        return false;
    }

    public boolean shouldFinish(int i4) {
        if (i4 == slidesCount()) {
            return true;
        }
        return false;
    }

    public int slidesCount() {
        if (a()) {
            return this.f106a.size() - 1;
        }
        return this.f106a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public SlideFragment getItem(int i4) {
        return this.f106a.get(i4);
    }
}
