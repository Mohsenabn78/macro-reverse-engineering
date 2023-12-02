package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.hanks.htextview.scale.ScaleTextView;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class FragmentHomeBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DrawerLayout f11224a;
    @NonNull
    public final Button addDaysButton;
    @NonNull
    public final FrameLayout addDaysButtonContainer;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final View barBottomSpace;
    @NonNull
    public final Button configureButton;
    @NonNull
    public final TextView daysRemainingText;
    @NonNull
    public final ImageButton drawMenuToggle;
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final LinearLayout flashSaleBar;
    @NonNull
    public final ScaleTextView flashSaleText;
    @NonNull
    public final TextView flashSaleTimeRemaining;
    @NonNull
    public final LinearLayout freeDaysInfoContainer;
    @NonNull
    public final RecyclerView homeScreenGrid;
    @NonNull
    public final ExpandableLayout infoBar;
    @NonNull
    public final FrameLayout infoBarBg;
    @NonNull
    public final ImageView infoBarDismissButton;
    @NonNull
    public final ImageView infoIcon;
    @NonNull
    public final TextView infoText;
    @NonNull
    public final NavigationView navigationView;
    @NonNull
    public final SwitchCompat onOffSwitch;
    @NonNull
    public final ShimmerFrameLayout shimmerLayout;
    @NonNull
    public final TextView titleText;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final LinearLayout topLevelLayout;
    @NonNull
    public final LinearLayout upgradeBar;
    @NonNull
    public final Button upgradeButton;
    @NonNull
    public final TextView upgradeReason;

    private FragmentHomeBinding(@NonNull DrawerLayout drawerLayout, @NonNull Button button, @NonNull FrameLayout frameLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull Button button2, @NonNull TextView textView, @NonNull ImageButton imageButton, @NonNull DrawerLayout drawerLayout2, @NonNull LinearLayout linearLayout, @NonNull ScaleTextView scaleTextView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull ExpandableLayout expandableLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView3, @NonNull NavigationView navigationView, @NonNull SwitchCompat switchCompat, @NonNull ShimmerFrameLayout shimmerFrameLayout, @NonNull TextView textView4, @NonNull Toolbar toolbar, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull Button button3, @NonNull TextView textView5) {
        this.f11224a = drawerLayout;
        this.addDaysButton = button;
        this.addDaysButtonContainer = frameLayout;
        this.appBarLayout = appBarLayout;
        this.barBottomSpace = view;
        this.configureButton = button2;
        this.daysRemainingText = textView;
        this.drawMenuToggle = imageButton;
        this.drawerLayout = drawerLayout2;
        this.flashSaleBar = linearLayout;
        this.flashSaleText = scaleTextView;
        this.flashSaleTimeRemaining = textView2;
        this.freeDaysInfoContainer = linearLayout2;
        this.homeScreenGrid = recyclerView;
        this.infoBar = expandableLayout;
        this.infoBarBg = frameLayout2;
        this.infoBarDismissButton = imageView;
        this.infoIcon = imageView2;
        this.infoText = textView3;
        this.navigationView = navigationView;
        this.onOffSwitch = switchCompat;
        this.shimmerLayout = shimmerFrameLayout;
        this.titleText = textView4;
        this.toolbar = toolbar;
        this.topLevelLayout = linearLayout3;
        this.upgradeBar = linearLayout4;
        this.upgradeButton = button3;
        this.upgradeReason = textView5;
    }

    @NonNull
    public static FragmentHomeBinding bind(@NonNull View view) {
        int i4 = R.id.addDaysButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addDaysButton);
        if (button != null) {
            i4 = R.id.addDaysButtonContainer;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.addDaysButtonContainer);
            if (frameLayout != null) {
                i4 = R.id.appBarLayout;
                AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
                if (appBarLayout != null) {
                    i4 = R.id.barBottomSpace;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.barBottomSpace);
                    if (findChildViewById != null) {
                        i4 = R.id.configureButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configureButton);
                        if (button2 != null) {
                            i4 = R.id.daysRemainingText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.daysRemainingText);
                            if (textView != null) {
                                i4 = R.id.drawMenuToggle;
                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.drawMenuToggle);
                                if (imageButton != null) {
                                    DrawerLayout drawerLayout = (DrawerLayout) view;
                                    i4 = R.id.flashSaleBar;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.flashSaleBar);
                                    if (linearLayout != null) {
                                        i4 = R.id.flashSaleText;
                                        ScaleTextView scaleTextView = (ScaleTextView) ViewBindings.findChildViewById(view, R.id.flashSaleText);
                                        if (scaleTextView != null) {
                                            i4 = R.id.flashSaleTimeRemaining;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.flashSaleTimeRemaining);
                                            if (textView2 != null) {
                                                i4 = R.id.free_days_info_container;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.free_days_info_container);
                                                if (linearLayout2 != null) {
                                                    i4 = R.id.homeScreenGrid;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.homeScreenGrid);
                                                    if (recyclerView != null) {
                                                        i4 = R.id.infoBar;
                                                        ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.infoBar);
                                                        if (expandableLayout != null) {
                                                            i4 = R.id.infoBarBg;
                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.infoBarBg);
                                                            if (frameLayout2 != null) {
                                                                i4 = R.id.infoBarDismissButton;
                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.infoBarDismissButton);
                                                                if (imageView != null) {
                                                                    i4 = R.id.infoIcon;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.infoIcon);
                                                                    if (imageView2 != null) {
                                                                        i4 = R.id.infoText;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.infoText);
                                                                        if (textView3 != null) {
                                                                            i4 = R.id.navigationView;
                                                                            NavigationView navigationView = (NavigationView) ViewBindings.findChildViewById(view, R.id.navigationView);
                                                                            if (navigationView != null) {
                                                                                i4 = R.id.onOffSwitch;
                                                                                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.onOffSwitch);
                                                                                if (switchCompat != null) {
                                                                                    i4 = R.id.shimmerLayout;
                                                                                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) ViewBindings.findChildViewById(view, R.id.shimmerLayout);
                                                                                    if (shimmerFrameLayout != null) {
                                                                                        i4 = R.id.titleText;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.titleText);
                                                                                        if (textView4 != null) {
                                                                                            i4 = R.id.toolbar;
                                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                            if (toolbar != null) {
                                                                                                i4 = R.id.topLevelLayout;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.topLevelLayout);
                                                                                                if (linearLayout3 != null) {
                                                                                                    i4 = R.id.upgradeBar;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.upgradeBar);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        i4 = R.id.upgradeButton;
                                                                                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.upgradeButton);
                                                                                                        if (button3 != null) {
                                                                                                            i4 = R.id.upgradeReason;
                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.upgradeReason);
                                                                                                            if (textView5 != null) {
                                                                                                                return new FragmentHomeBinding(drawerLayout, button, frameLayout, appBarLayout, findChildViewById, button2, textView, imageButton, drawerLayout, linearLayout, scaleTextView, textView2, linearLayout2, recyclerView, expandableLayout, frameLayout2, imageView, imageView2, textView3, navigationView, switchCompat, shimmerFrameLayout, textView4, toolbar, linearLayout3, linearLayout4, button3, textView5);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentHomeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentHomeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public DrawerLayout getRoot() {
        return this.f11224a;
    }
}
