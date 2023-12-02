package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.arlosoft.macrodroid.R;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes3.dex */
public final class SelectIconTopLevelBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11355a;
    @NonNull
    public final LinearLayout infoCard;
    @NonNull
    public final TextView infoCardDetail;
    @NonNull
    public final Button infoCardGotIt;
    @NonNull
    public final Button infoCardSearch;
    @NonNull
    public final TextView infoCardTitle;
    @NonNull
    public final CardView infoCardView;
    @NonNull
    public final SearchView searchView;
    @NonNull
    public final ViewPager selectIconTopLevelViewPager;
    @NonNull
    public final TabLayout tabs;
    @NonNull
    public final TextView toggleBgColor;

    private SelectIconTopLevelBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView2, @NonNull CardView cardView, @NonNull SearchView searchView, @NonNull ViewPager viewPager, @NonNull TabLayout tabLayout, @NonNull TextView textView3) {
        this.f11355a = linearLayout;
        this.infoCard = linearLayout2;
        this.infoCardDetail = textView;
        this.infoCardGotIt = button;
        this.infoCardSearch = button2;
        this.infoCardTitle = textView2;
        this.infoCardView = cardView;
        this.searchView = searchView;
        this.selectIconTopLevelViewPager = viewPager;
        this.tabs = tabLayout;
        this.toggleBgColor = textView3;
    }

    @NonNull
    public static SelectIconTopLevelBinding bind(@NonNull View view) {
        int i4 = R.id.info_card;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.info_card);
        if (linearLayout != null) {
            i4 = R.id.infoCardDetail;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.infoCardDetail);
            if (textView != null) {
                i4 = R.id.infoCardGotIt;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.infoCardGotIt);
                if (button != null) {
                    i4 = R.id.info_card_search;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.info_card_search);
                    if (button2 != null) {
                        i4 = R.id.infoCardTitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.infoCardTitle);
                        if (textView2 != null) {
                            i4 = R.id.infoCardView;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.infoCardView);
                            if (cardView != null) {
                                i4 = R.id.searchView;
                                SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, R.id.searchView);
                                if (searchView != null) {
                                    i4 = R.id.select_icon_top_level_view_pager;
                                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.select_icon_top_level_view_pager);
                                    if (viewPager != null) {
                                        i4 = R.id.tabs;
                                        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabs);
                                        if (tabLayout != null) {
                                            i4 = R.id.toggle_bg_color;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.toggle_bg_color);
                                            if (textView3 != null) {
                                                return new SelectIconTopLevelBinding((LinearLayout) view, linearLayout, textView, button, button2, textView2, cardView, searchView, viewPager, tabLayout, textView3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SelectIconTopLevelBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectIconTopLevelBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.select_icon_top_level, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11355a;
    }
}
