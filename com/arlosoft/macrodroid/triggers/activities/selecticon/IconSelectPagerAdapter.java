package com.arlosoft.macrodroid.triggers.activities.selecticon;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.arlosoft.macrodroid.R;
import java.util.List;

/* loaded from: classes3.dex */
public class IconSelectPagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14619a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f14620b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f14621c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f14622d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f14623e;

    /* renamed from: f  reason: collision with root package name */
    private String f14624f;

    /* renamed from: g  reason: collision with root package name */
    private Long f14625g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14626h;

    public IconSelectPagerAdapter(Context context, FragmentManager fragmentManager, boolean z3, List<String> list, List<String> list2, boolean z4, String str, long j4, boolean z5) {
        super(fragmentManager);
        this.f14622d = new String[]{context.getString(R.string.select_icons_applications), context.getString(R.string.select_icons_user), context.getString(R.string.select_icons_macrodroid), context.getString(R.string.select_icons_notification), context.getString(R.string.select_icons_material_design), context.getString(R.string.text)};
        this.f14619a = z3;
        this.f14620b = list;
        this.f14621c = list2;
        this.f14623e = z4;
        this.f14624f = str;
        this.f14626h = z5;
        this.f14625g = Long.valueOf(j4);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.f14619a) {
            return this.f14620b.size() + 5 + (this.f14626h ? 1 : 0);
        }
        return (this.f14626h ? 1 : 0) + 3;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i4) {
        IconSelectFragment iconSelectFragment = new IconSelectFragment();
        Bundle bundle = new Bundle();
        if (this.f14619a) {
            if (i4 < this.f14620b.size()) {
                bundle.putString(IconSelectFragment.EXTRA_ICON_PACK_NAME, this.f14620b.get(i4));
            } else if (i4 == this.f14620b.size() + 1) {
                bundle.putInt(IconSelectFragment.EXTRA_ICON_TYPES, 1);
            } else if (this.f14626h && i4 == getCount() - 1) {
                return IconSelectFragmentText.newInstance(this.f14624f, this.f14625g.longValue());
            } else {
                bundle.putInt(IconSelectFragment.EXTRA_ICON_TYPES, i4 - this.f14620b.size());
            }
        } else if (i4 == 0) {
            bundle.putInt(IconSelectFragment.EXTRA_ICON_TYPES, 2);
        } else if (i4 == 1) {
            bundle.putInt(IconSelectFragment.EXTRA_ICON_TYPES, 3);
        } else if (i4 == 2) {
            bundle.putInt(IconSelectFragment.EXTRA_ICON_TYPES, 4);
        } else {
            return IconSelectFragmentText.newInstance(this.f14624f, this.f14625g.longValue());
        }
        bundle.putBoolean(IconSelectFragment.EXTRA_RETURN_RESULT, this.f14623e);
        iconSelectFragment.setArguments(bundle);
        return iconSelectFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i4) {
        if (this.f14619a) {
            if (i4 < this.f14620b.size()) {
                return this.f14621c.get(i4);
            }
            return this.f14622d[i4 - this.f14620b.size()];
        }
        return this.f14622d[i4 + 2];
    }

    public void setSearchText(String str) {
    }
}
