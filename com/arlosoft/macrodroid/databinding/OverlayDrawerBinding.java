package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.drawer.DrawerFrameLayout;
import com.arlosoft.macrodroid.drawer.MacroDroidDrawer;

/* loaded from: classes3.dex */
public final class OverlayDrawerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DrawerFrameLayout f11342a;
    @NonNull
    public final ImageView addButton;
    @NonNull
    public final View background;
    @NonNull
    public final LinearLayout drawer;
    @NonNull
    public final View drawerAnimFixerLtr;
    @NonNull
    public final View drawerAnimFixerRtl;
    @NonNull
    public final DrawerFrameLayout drawerContainer;
    @NonNull
    public final FrameLayout drawerDimmerContainer;
    @NonNull
    public final LinearLayout drawerHeader;
    @NonNull
    public final LinearLayout drawerWrapper;
    @NonNull
    public final MacroDroidDrawer macrodroidDrawer;
    @NonNull
    public final ImageView macrodroidIcon;
    @NonNull
    public final ImageView reorderButton;

    private OverlayDrawerBinding(@NonNull DrawerFrameLayout drawerFrameLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull View view2, @NonNull View view3, @NonNull DrawerFrameLayout drawerFrameLayout2, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull MacroDroidDrawer macroDroidDrawer, @NonNull ImageView imageView2, @NonNull ImageView imageView3) {
        this.f11342a = drawerFrameLayout;
        this.addButton = imageView;
        this.background = view;
        this.drawer = linearLayout;
        this.drawerAnimFixerLtr = view2;
        this.drawerAnimFixerRtl = view3;
        this.drawerContainer = drawerFrameLayout2;
        this.drawerDimmerContainer = frameLayout;
        this.drawerHeader = linearLayout2;
        this.drawerWrapper = linearLayout3;
        this.macrodroidDrawer = macroDroidDrawer;
        this.macrodroidIcon = imageView2;
        this.reorderButton = imageView3;
    }

    @NonNull
    public static OverlayDrawerBinding bind(@NonNull View view) {
        int i4 = R.id.add_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.add_button);
        if (imageView != null) {
            i4 = R.id.background;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.background);
            if (findChildViewById != null) {
                i4 = R.id.drawer;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.drawer);
                if (linearLayout != null) {
                    i4 = R.id.drawer_anim_fixer_ltr;
                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.drawer_anim_fixer_ltr);
                    if (findChildViewById2 != null) {
                        i4 = R.id.drawer_anim_fixer_rtl;
                        View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.drawer_anim_fixer_rtl);
                        if (findChildViewById3 != null) {
                            DrawerFrameLayout drawerFrameLayout = (DrawerFrameLayout) view;
                            i4 = R.id.drawer_dimmer_container;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.drawer_dimmer_container);
                            if (frameLayout != null) {
                                i4 = R.id.drawer_header;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.drawer_header);
                                if (linearLayout2 != null) {
                                    i4 = R.id.drawer_wrapper;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.drawer_wrapper);
                                    if (linearLayout3 != null) {
                                        i4 = R.id.macrodroid_drawer;
                                        MacroDroidDrawer macroDroidDrawer = (MacroDroidDrawer) ViewBindings.findChildViewById(view, R.id.macrodroid_drawer);
                                        if (macroDroidDrawer != null) {
                                            i4 = R.id.macrodroid_icon;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.macrodroid_icon);
                                            if (imageView2 != null) {
                                                i4 = R.id.reorder_button;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.reorder_button);
                                                if (imageView3 != null) {
                                                    return new OverlayDrawerBinding(drawerFrameLayout, imageView, findChildViewById, linearLayout, findChildViewById2, findChildViewById3, drawerFrameLayout, frameLayout, linearLayout2, linearLayout3, macroDroidDrawer, imageView2, imageView3);
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
    public static OverlayDrawerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static OverlayDrawerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.overlay_drawer, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public DrawerFrameLayout getRoot() {
        return this.f11342a;
    }
}
