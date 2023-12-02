package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public final class TabLayoutMediator {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TabLayout f24532a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f24533b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24534c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24535d;

    /* renamed from: e  reason: collision with root package name */
    private final TabConfigurationStrategy f24536e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.Adapter<?> f24537f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24538g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private TabLayoutOnPageChangeCallback f24539h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TabLayout.OnTabSelectedListener f24540i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f24541j;

    /* loaded from: classes5.dex */
    private class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        PagerAdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i4, int i5) {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i4, int i5) {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i4, int i5, int i6) {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i4, int i5) {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i4, int i5, @Nullable Object obj) {
            TabLayoutMediator.this.a();
        }
    }

    /* loaded from: classes5.dex */
    public interface TabConfigurationStrategy {
        void onConfigureTab(@NonNull TabLayout.Tab tab, int i4);
    }

    /* loaded from: classes5.dex */
    private static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f24543a;

        /* renamed from: b  reason: collision with root package name */
        private int f24544b;

        /* renamed from: c  reason: collision with root package name */
        private int f24545c;

        TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            this.f24543a = new WeakReference<>(tabLayout);
            a();
        }

        void a() {
            this.f24545c = 0;
            this.f24544b = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i4) {
            this.f24544b = this.f24545c;
            this.f24545c = i4;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i4, float f4, int i5) {
            boolean z3;
            TabLayout tabLayout = this.f24543a.get();
            if (tabLayout != null) {
                int i6 = this.f24545c;
                boolean z4 = false;
                if (i6 == 2 && this.f24544b != 1) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                tabLayout.setScrollPosition(i4, f4, z3, (i6 == 2 && this.f24544b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i4) {
            boolean z3;
            TabLayout tabLayout = this.f24543a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i4 && i4 < tabLayout.getTabCount()) {
                int i5 = this.f24545c;
                if (i5 != 0 && (i5 != 2 || this.f24544b != 0)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i4), z3);
            }
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabConfigurationStrategy);
    }

    void a() {
        this.f24532a.removeAllTabs();
        RecyclerView.Adapter<?> adapter = this.f24537f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i4 = 0; i4 < itemCount; i4++) {
                TabLayout.Tab newTab = this.f24532a.newTab();
                this.f24536e.onConfigureTab(newTab, i4);
                this.f24532a.addTab(newTab, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.f24533b.getCurrentItem(), this.f24532a.getTabCount() - 1);
                if (min != this.f24532a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f24532a;
                    tabLayout.selectTab(tabLayout.getTabAt(min));
                }
            }
        }
    }

    public void attach() {
        if (!this.f24538g) {
            RecyclerView.Adapter<?> adapter = this.f24533b.getAdapter();
            this.f24537f = adapter;
            if (adapter != null) {
                this.f24538g = true;
                TabLayoutOnPageChangeCallback tabLayoutOnPageChangeCallback = new TabLayoutOnPageChangeCallback(this.f24532a);
                this.f24539h = tabLayoutOnPageChangeCallback;
                this.f24533b.registerOnPageChangeCallback(tabLayoutOnPageChangeCallback);
                ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(this.f24533b, this.f24535d);
                this.f24540i = viewPagerOnTabSelectedListener;
                this.f24532a.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) viewPagerOnTabSelectedListener);
                if (this.f24534c) {
                    PagerAdapterObserver pagerAdapterObserver = new PagerAdapterObserver();
                    this.f24541j = pagerAdapterObserver;
                    this.f24537f.registerAdapterDataObserver(pagerAdapterObserver);
                }
                a();
                this.f24532a.setScrollPosition(this.f24533b.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        RecyclerView.Adapter<?> adapter;
        if (this.f24534c && (adapter = this.f24537f) != null) {
            adapter.unregisterAdapterDataObserver(this.f24541j);
            this.f24541j = null;
        }
        this.f24532a.removeOnTabSelectedListener(this.f24540i);
        this.f24533b.unregisterOnPageChangeCallback(this.f24539h);
        this.f24540i = null;
        this.f24539h = null;
        this.f24537f = null;
        this.f24538g = false;
    }

    public boolean isAttached() {
        return this.f24538g;
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z3, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, z3, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z3, boolean z4, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this.f24532a = tabLayout;
        this.f24533b = viewPager2;
        this.f24534c = z3;
        this.f24535d = z4;
        this.f24536e = tabConfigurationStrategy;
    }

    /* loaded from: classes5.dex */
    private static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager2 f24546a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f24547b;

        ViewPagerOnTabSelectedListener(ViewPager2 viewPager2, boolean z3) {
            this.f24546a = viewPager2;
            this.f24547b = z3;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull TabLayout.Tab tab) {
            this.f24546a.setCurrentItem(tab.getPosition(), this.f24547b);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }
}
