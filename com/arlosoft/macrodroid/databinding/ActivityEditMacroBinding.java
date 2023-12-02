package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class ActivityEditMacroBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10939a;
    @NonNull
    public final FloatingActionButton acceptButton;
    @NonNull
    public final ImageButton actionBack;
    @NonNull
    public final FrameLayout allItemsContainer;
    @NonNull
    public final RecyclerView allItemsList;
    @NonNull
    public final AppBarLayout appBar;
    @NonNull
    public final BottomSheetVariablesBinding bottomBar;
    @NonNull
    public final FrameLayout contentOverlay;
    @NonNull
    public final ExpandableLayout descriptionExpandable;
    @NonNull
    public final LinearLayout disabledLabel;
    @NonNull
    public final FrameLayout disabledViewCover;
    @NonNull
    public final ImageView dismissButton;
    @NonNull
    public final CoordinatorLayout editMacroContainer;
    @NonNull
    public final ImageView expandCollapseButton;
    @NonNull
    public final ConstraintLayout infoBarBg;
    @NonNull
    public final AppCompatEditText macroDescription;
    @NonNull
    public final EditText macroNameText;
    @NonNull
    public final ImageView nearbyImage;
    @NonNull
    public final ExpandableLayout nearbySharePanel;
    @NonNull
    public final ProgressBar scanningSpinner;
    @NonNull
    public final ImageView searchDownButton;
    @NonNull
    public final ExpandableLayout searchExpandable;
    @NonNull
    public final EditText searchText;
    @NonNull
    public final ImageView searchUpButton;
    @NonNull
    public final TextView shareNearbyText;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final LinearLayout topLevelLayout;
    @NonNull
    public final RelativeLayout triggerOverlay;

    private ActivityEditMacroBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull ImageButton imageButton, @NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull AppBarLayout appBarLayout, @NonNull BottomSheetVariablesBinding bottomSheetVariablesBinding, @NonNull FrameLayout frameLayout2, @NonNull ExpandableLayout expandableLayout, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout3, @NonNull ImageView imageView, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull EditText editText, @NonNull ImageView imageView3, @NonNull ExpandableLayout expandableLayout2, @NonNull ProgressBar progressBar, @NonNull ImageView imageView4, @NonNull ExpandableLayout expandableLayout3, @NonNull EditText editText2, @NonNull ImageView imageView5, @NonNull TextView textView, @NonNull Toolbar toolbar, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout) {
        this.f10939a = coordinatorLayout;
        this.acceptButton = floatingActionButton;
        this.actionBack = imageButton;
        this.allItemsContainer = frameLayout;
        this.allItemsList = recyclerView;
        this.appBar = appBarLayout;
        this.bottomBar = bottomSheetVariablesBinding;
        this.contentOverlay = frameLayout2;
        this.descriptionExpandable = expandableLayout;
        this.disabledLabel = linearLayout;
        this.disabledViewCover = frameLayout3;
        this.dismissButton = imageView;
        this.editMacroContainer = coordinatorLayout2;
        this.expandCollapseButton = imageView2;
        this.infoBarBg = constraintLayout;
        this.macroDescription = appCompatEditText;
        this.macroNameText = editText;
        this.nearbyImage = imageView3;
        this.nearbySharePanel = expandableLayout2;
        this.scanningSpinner = progressBar;
        this.searchDownButton = imageView4;
        this.searchExpandable = expandableLayout3;
        this.searchText = editText2;
        this.searchUpButton = imageView5;
        this.shareNearbyText = textView;
        this.toolbar = toolbar;
        this.topLevelLayout = linearLayout2;
        this.triggerOverlay = relativeLayout;
    }

    @NonNull
    public static ActivityEditMacroBinding bind(@NonNull View view) {
        int i4 = R.id.acceptButton;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.acceptButton);
        if (floatingActionButton != null) {
            i4 = R.id.actionBack;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.actionBack);
            if (imageButton != null) {
                i4 = R.id.allItemsContainer;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.allItemsContainer);
                if (frameLayout != null) {
                    i4 = R.id.allItemsList;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.allItemsList);
                    if (recyclerView != null) {
                        i4 = R.id.appBar;
                        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBar);
                        if (appBarLayout != null) {
                            i4 = R.id.bottomBar;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.bottomBar);
                            if (findChildViewById != null) {
                                BottomSheetVariablesBinding bind = BottomSheetVariablesBinding.bind(findChildViewById);
                                i4 = R.id.content_overlay;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.content_overlay);
                                if (frameLayout2 != null) {
                                    i4 = R.id.descriptionExpandable;
                                    ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.descriptionExpandable);
                                    if (expandableLayout != null) {
                                        i4 = R.id.disabledLabel;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.disabledLabel);
                                        if (linearLayout != null) {
                                            i4 = R.id.disabledViewCover;
                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.disabledViewCover);
                                            if (frameLayout3 != null) {
                                                i4 = R.id.dismissButton;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dismissButton);
                                                if (imageView != null) {
                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                                    i4 = R.id.expand_collapse_button;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.expand_collapse_button);
                                                    if (imageView2 != null) {
                                                        i4 = R.id.infoBarBg;
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.infoBarBg);
                                                        if (constraintLayout != null) {
                                                            i4 = R.id.macroDescription;
                                                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.macroDescription);
                                                            if (appCompatEditText != null) {
                                                                i4 = R.id.macroNameText;
                                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.macroNameText);
                                                                if (editText != null) {
                                                                    i4 = R.id.nearbyImage;
                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.nearbyImage);
                                                                    if (imageView3 != null) {
                                                                        i4 = R.id.nearbySharePanel;
                                                                        ExpandableLayout expandableLayout2 = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.nearbySharePanel);
                                                                        if (expandableLayout2 != null) {
                                                                            i4 = R.id.scanningSpinner;
                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.scanningSpinner);
                                                                            if (progressBar != null) {
                                                                                i4 = R.id.search_down_button;
                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.search_down_button);
                                                                                if (imageView4 != null) {
                                                                                    i4 = R.id.searchExpandable;
                                                                                    ExpandableLayout expandableLayout3 = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.searchExpandable);
                                                                                    if (expandableLayout3 != null) {
                                                                                        i4 = R.id.search_text;
                                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.search_text);
                                                                                        if (editText2 != null) {
                                                                                            i4 = R.id.search_up_button;
                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.search_up_button);
                                                                                            if (imageView5 != null) {
                                                                                                i4 = R.id.shareNearbyText;
                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.shareNearbyText);
                                                                                                if (textView != null) {
                                                                                                    i4 = R.id.toolbar;
                                                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                                    if (toolbar != null) {
                                                                                                        i4 = R.id.topLevelLayout;
                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.topLevelLayout);
                                                                                                        if (linearLayout2 != null) {
                                                                                                            i4 = R.id.triggerOverlay;
                                                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.triggerOverlay);
                                                                                                            if (relativeLayout != null) {
                                                                                                                return new ActivityEditMacroBinding(coordinatorLayout, floatingActionButton, imageButton, frameLayout, recyclerView, appBarLayout, bind, frameLayout2, expandableLayout, linearLayout, frameLayout3, imageView, coordinatorLayout, imageView2, constraintLayout, appCompatEditText, editText, imageView3, expandableLayout2, progressBar, imageView4, expandableLayout3, editText2, imageView5, textView, toolbar, linearLayout2, relativeLayout);
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
    public static ActivityEditMacroBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityEditMacroBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_edit_macro, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10939a;
    }
}
