package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.melnykov.fab.FloatingActionButton;
import com.varunest.sparkbutton.SparkButton2;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class MacroListViewNewBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f11329a;
    @NonNull
    public final ImageView dismissButton;
    @NonNull
    public final ImageView emptyView;
    @NonNull
    public final SparkButton2 favouriteButton;
    @NonNull
    public final TextView favouritesHint;
    @NonNull
    public final ConstraintLayout infoBarBg;
    @NonNull
    public final FloatingActionButton macroListAddButton;
    @NonNull
    public final Button macroListGetMoreMacros;
    @NonNull
    public final LinearLayout macroListLimitContainer;
    @NonNull
    public final TextView macroListLimitText;
    @NonNull
    public final TextView macrolistEmptyLabel;
    @NonNull
    public final FrameLayout macrolistEmptyView;
    @NonNull
    public final ImageView nearbyImage;
    @NonNull
    public final ExpandableLayout nearbySharePanel;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final ProgressBar scanningSpinner;
    @NonNull
    public final TextView shareNearbyText;
    @NonNull
    public final LinearLayout titleContainer;
    @NonNull
    public final TextView titleText;
    @NonNull
    public final Toolbar toolbar;

    private MacroListViewNewBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull SparkButton2 sparkButton2, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Button button, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView3, @NonNull ExpandableLayout expandableLayout, @NonNull RecyclerView recyclerView, @NonNull ProgressBar progressBar, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2, @NonNull TextView textView5, @NonNull Toolbar toolbar) {
        this.f11329a = relativeLayout;
        this.dismissButton = imageView;
        this.emptyView = imageView2;
        this.favouriteButton = sparkButton2;
        this.favouritesHint = textView;
        this.infoBarBg = constraintLayout;
        this.macroListAddButton = floatingActionButton;
        this.macroListGetMoreMacros = button;
        this.macroListLimitContainer = linearLayout;
        this.macroListLimitText = textView2;
        this.macrolistEmptyLabel = textView3;
        this.macrolistEmptyView = frameLayout;
        this.nearbyImage = imageView3;
        this.nearbySharePanel = expandableLayout;
        this.recyclerView = recyclerView;
        this.scanningSpinner = progressBar;
        this.shareNearbyText = textView4;
        this.titleContainer = linearLayout2;
        this.titleText = textView5;
        this.toolbar = toolbar;
    }

    @NonNull
    public static MacroListViewNewBinding bind(@NonNull View view) {
        int i4 = R.id.dismissButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dismissButton);
        if (imageView != null) {
            i4 = R.id.empty_view;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.empty_view);
            if (imageView2 != null) {
                i4 = R.id.favouriteButton;
                SparkButton2 sparkButton2 = (SparkButton2) ViewBindings.findChildViewById(view, R.id.favouriteButton);
                if (sparkButton2 != null) {
                    i4 = R.id.favouritesHint;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.favouritesHint);
                    if (textView != null) {
                        i4 = R.id.infoBarBg;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.infoBarBg);
                        if (constraintLayout != null) {
                            i4 = R.id.macro_list_add_button;
                            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.macro_list_add_button);
                            if (floatingActionButton != null) {
                                i4 = R.id.macro_list_get_more_macros;
                                Button button = (Button) ViewBindings.findChildViewById(view, R.id.macro_list_get_more_macros);
                                if (button != null) {
                                    i4 = R.id.macro_list_limit_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macro_list_limit_container);
                                    if (linearLayout != null) {
                                        i4 = R.id.macro_list_limit_text;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.macro_list_limit_text);
                                        if (textView2 != null) {
                                            i4 = R.id.macrolist_emptyLabel;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.macrolist_emptyLabel);
                                            if (textView3 != null) {
                                                i4 = R.id.macrolist_emptyView;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.macrolist_emptyView);
                                                if (frameLayout != null) {
                                                    i4 = R.id.nearbyImage;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.nearbyImage);
                                                    if (imageView3 != null) {
                                                        i4 = R.id.nearbySharePanel;
                                                        ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.nearbySharePanel);
                                                        if (expandableLayout != null) {
                                                            i4 = R.id.recycler_view;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
                                                            if (recyclerView != null) {
                                                                i4 = R.id.scanningSpinner;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.scanningSpinner);
                                                                if (progressBar != null) {
                                                                    i4 = R.id.shareNearbyText;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.shareNearbyText);
                                                                    if (textView4 != null) {
                                                                        i4 = R.id.titleContainer;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.titleContainer);
                                                                        if (linearLayout2 != null) {
                                                                            i4 = R.id.titleText;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.titleText);
                                                                            if (textView5 != null) {
                                                                                i4 = R.id.toolbar;
                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                if (toolbar != null) {
                                                                                    return new MacroListViewNewBinding((RelativeLayout) view, imageView, imageView2, sparkButton2, textView, constraintLayout, floatingActionButton, button, linearLayout, textView2, textView3, frameLayout, imageView3, expandableLayout, recyclerView, progressBar, textView4, linearLayout2, textView5, toolbar);
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
    public static MacroListViewNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MacroListViewNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.macro_list_view_new, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.f11329a;
    }
}
