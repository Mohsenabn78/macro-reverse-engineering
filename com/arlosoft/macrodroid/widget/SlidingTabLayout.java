package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class SlidingTabLayout extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private final int f16469a;

    /* renamed from: b  reason: collision with root package name */
    private int f16470b;

    /* renamed from: c  reason: collision with root package name */
    private int f16471c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<TextView> f16472d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f16473e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager.OnPageChangeListener f16474f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16475g;

    /* renamed from: h  reason: collision with root package name */
    private final SlidingTabStrip f16476h;

    /* loaded from: classes3.dex */
    public interface TabColorizer {
        int getDividerColor(int i4);

        int getIndicatorColor(int i4);
    }

    /* loaded from: classes3.dex */
    private class b implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f16477a;

        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i4) {
            this.f16477a = i4;
            if (SlidingTabLayout.this.f16474f != null) {
                SlidingTabLayout.this.f16474f.onPageScrollStateChanged(i4);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i4, float f4, int i5) {
            int i6;
            int childCount = SlidingTabLayout.this.f16476h.getChildCount();
            if (childCount != 0 && i4 >= 0 && i4 < childCount) {
                SlidingTabLayout.this.f16476h.b(i4, f4);
                View childAt = SlidingTabLayout.this.f16476h.getChildAt(i4);
                if (childAt != null) {
                    i6 = (int) (childAt.getWidth() * f4);
                } else {
                    i6 = 0;
                }
                SlidingTabLayout.this.h(i4, i6);
                if (SlidingTabLayout.this.f16474f != null) {
                    SlidingTabLayout.this.f16474f.onPageScrolled(i4, f4, i5);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i4) {
            if (this.f16477a == 0) {
                SlidingTabLayout.this.f16476h.b(i4, 0.0f);
                SlidingTabLayout.this.h(i4, 0);
            }
            if (SlidingTabLayout.this.f16474f != null) {
                SlidingTabLayout.this.f16474f.onPageSelected(i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i4 = 0; i4 < SlidingTabLayout.this.f16476h.getChildCount(); i4++) {
                if (view == SlidingTabLayout.this.f16476h.getChildAt(i4)) {
                    SlidingTabLayout.this.f16473e.setCurrentItem(i4);
                    return;
                }
            }
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    private TextView e(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        textView.setMaxLines(1);
        textView.setBackgroundResource(R.drawable.tab_background);
        int i4 = (int) (getResources().getDisplayMetrics().density * 16.0f);
        textView.setPadding(i4, i4, i4, i4);
        return textView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.arlosoft.macrodroid.widget.SlidingTabStrip, android.view.ViewGroup] */
    private void f() {
        View view;
        TextView textView;
        PagerAdapter adapter = this.f16473e.getAdapter();
        c cVar = new c();
        this.f16476h.removeAllViews();
        for (int i4 = 0; i4 < adapter.getCount(); i4++) {
            if (this.f16470b != 0) {
                view = LayoutInflater.from(getContext()).inflate(this.f16470b, (ViewGroup) this.f16476h, false);
                textView = (TextView) view.findViewById(this.f16471c);
                if (this.f16475g) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                }
            } else {
                view = null;
                textView = null;
            }
            if (view == null) {
                view = e(getContext());
                if (this.f16475g) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                }
            }
            if (textView == null && TextView.class.isInstance(view)) {
                textView = view;
            }
            this.f16472d.put(i4, textView);
            textView.setText(adapter.getPageTitle(i4));
            view.setOnClickListener(cVar);
            this.f16476h.addView(view);
        }
    }

    private void g() {
        int childCount = this.f16476h.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = this.f16476h.getChildAt(i4);
            if (childAt != null) {
                childAt.setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i4, int i5) {
        int childCount = this.f16476h.getChildCount();
        if (childCount != 0 && i4 >= 0 && i4 < childCount) {
            g();
            View childAt = this.f16476h.getChildAt(i4);
            if (childAt != null) {
                int left = childAt.getLeft() + i5;
                if (i4 > 0 || i5 > 0) {
                    left -= this.f16469a;
                }
                scrollTo(left, 0);
                childAt.setSelected(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewPager viewPager = this.f16473e;
        if (viewPager != null) {
            h(viewPager.getCurrentItem(), 0);
        }
    }

    public void setCustomTabColorizer(TabColorizer tabColorizer) {
        this.f16476h.setCustomTabColorizer(tabColorizer);
    }

    public void setCustomTabText(int i4, String str) {
        TextView textView = this.f16472d.get(i4);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setCustomTabView(int i4, int i5) {
        this.f16470b = i4;
        this.f16471c = i5;
    }

    public void setDividerColors(int... iArr) {
        this.f16476h.setDividerColors(iArr);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f16474f = onPageChangeListener;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.f16476h.setSelectedIndicatorColors(iArr);
    }

    public void setTabsEqualsWeight(boolean z3) {
        this.f16475g = z3;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f16476h.removeAllViews();
        this.f16473e = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new b());
            f();
        }
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f16472d = new SparseArray<>();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f16469a = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.f16476h = slidingTabStrip;
        addView(slidingTabStrip, -1, -1);
    }
}
