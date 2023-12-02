package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class FragmentTemplateStoreBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f11232a;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final View barBottomSpace;
    @NonNull
    public final Spinner categoriesSpinner;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final ExpandableLayout infoBar;
    @NonNull
    public final FrameLayout infoBarBg;
    @NonNull
    public final Button infoBarButton;
    @NonNull
    public final ImageView infoBarDismissButton;
    @NonNull
    public final TextView infoText;
    @NonNull
    public final FrameLayout loadingBlocker;
    @NonNull
    public final LinearLayout pirateView;
    @NonNull
    public final LottieAnimationView sadFaceAnimation;
    @NonNull
    public final ImageView searchButton;
    @NonNull
    public final TabLayout tabBar;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ViewFlipper viewFlipper;
    @NonNull
    public final ViewPager viewPager;

    private FragmentTemplateStoreBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull Spinner spinner, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ExpandableLayout expandableLayout, @NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull ImageView imageView2, @NonNull TabLayout tabLayout, @NonNull Toolbar toolbar, @NonNull ViewFlipper viewFlipper, @NonNull ViewPager viewPager) {
        this.f11232a = coordinatorLayout;
        this.appBarLayout = appBarLayout;
        this.barBottomSpace = view;
        this.categoriesSpinner = spinner;
        this.coordinatorLayout = coordinatorLayout2;
        this.infoBar = expandableLayout;
        this.infoBarBg = frameLayout;
        this.infoBarButton = button;
        this.infoBarDismissButton = imageView;
        this.infoText = textView;
        this.loadingBlocker = frameLayout2;
        this.pirateView = linearLayout;
        this.sadFaceAnimation = lottieAnimationView;
        this.searchButton = imageView2;
        this.tabBar = tabLayout;
        this.toolbar = toolbar;
        this.viewFlipper = viewFlipper;
        this.viewPager = viewPager;
    }

    @NonNull
    public static FragmentTemplateStoreBinding bind(@NonNull View view) {
        int i4 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
        if (appBarLayout != null) {
            i4 = R.id.barBottomSpace;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.barBottomSpace);
            if (findChildViewById != null) {
                i4 = R.id.categoriesSpinner;
                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.categoriesSpinner);
                if (spinner != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                    i4 = R.id.infoBar;
                    ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.infoBar);
                    if (expandableLayout != null) {
                        i4 = R.id.infoBarBg;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.infoBarBg);
                        if (frameLayout != null) {
                            i4 = R.id.infoBarButton;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.infoBarButton);
                            if (button != null) {
                                i4 = R.id.infoBarDismissButton;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.infoBarDismissButton);
                                if (imageView != null) {
                                    i4 = R.id.infoText;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.infoText);
                                    if (textView != null) {
                                        i4 = R.id.loadingBlocker;
                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingBlocker);
                                        if (frameLayout2 != null) {
                                            i4 = R.id.pirateView;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pirateView);
                                            if (linearLayout != null) {
                                                i4 = R.id.sadFaceAnimation;
                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.sadFaceAnimation);
                                                if (lottieAnimationView != null) {
                                                    i4 = R.id.searchButton;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.searchButton);
                                                    if (imageView2 != null) {
                                                        i4 = R.id.tabBar;
                                                        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabBar);
                                                        if (tabLayout != null) {
                                                            i4 = R.id.toolbar;
                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                            if (toolbar != null) {
                                                                i4 = R.id.viewFlipper;
                                                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.viewFlipper);
                                                                if (viewFlipper != null) {
                                                                    i4 = R.id.viewPager;
                                                                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.viewPager);
                                                                    if (viewPager != null) {
                                                                        return new FragmentTemplateStoreBinding(coordinatorLayout, appBarLayout, findChildViewById, spinner, coordinatorLayout, expandableLayout, frameLayout, button, imageView, textView, frameLayout2, linearLayout, lottieAnimationView, imageView2, tabLayout, toolbar, viewFlipper, viewPager);
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
    public static FragmentTemplateStoreBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentTemplateStoreBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_template_store, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f11232a;
    }
}
