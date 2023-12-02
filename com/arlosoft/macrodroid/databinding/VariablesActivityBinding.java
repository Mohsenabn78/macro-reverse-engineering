package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class VariablesActivityBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f11405a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final LinearLayout filterPanel;
    @NonNull
    public final CheckBox localVariableCheckbox;
    @NonNull
    public final FrameLayout localVariableOptionLayout;
    @NonNull
    public final LinearLayout rootContainer;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final Spinner variableTypeSpinner;
    @NonNull
    public final ListView variablesActivityList;
    @NonNull
    public final LinearLayout variablesEmptyView;

    private VariablesActivityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull FloatingActionButton floatingActionButton, @NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull Toolbar toolbar, @NonNull Spinner spinner, @NonNull ListView listView, @NonNull LinearLayout linearLayout3) {
        this.f11405a = coordinatorLayout;
        this.animationView = lottieAnimationView;
        this.fab = floatingActionButton;
        this.filterPanel = linearLayout;
        this.localVariableCheckbox = checkBox;
        this.localVariableOptionLayout = frameLayout;
        this.rootContainer = linearLayout2;
        this.toolbar = toolbar;
        this.variableTypeSpinner = spinner;
        this.variablesActivityList = listView;
        this.variablesEmptyView = linearLayout3;
    }

    @NonNull
    public static VariablesActivityBinding bind(@NonNull View view) {
        int i4 = R.id.animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animation_view);
        if (lottieAnimationView != null) {
            i4 = R.id.fab;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
            if (floatingActionButton != null) {
                i4 = R.id.filterPanel;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.filterPanel);
                if (linearLayout != null) {
                    i4 = R.id.local_variable_checkbox;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.local_variable_checkbox);
                    if (checkBox != null) {
                        i4 = R.id.local_variable_option_layout;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.local_variable_option_layout);
                        if (frameLayout != null) {
                            i4 = R.id.rootContainer;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rootContainer);
                            if (linearLayout2 != null) {
                                i4 = R.id.toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                if (toolbar != null) {
                                    i4 = R.id.variableTypeSpinner;
                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.variableTypeSpinner);
                                    if (spinner != null) {
                                        i4 = R.id.variables_activity_list;
                                        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.variables_activity_list);
                                        if (listView != null) {
                                            i4 = R.id.variables_emptyView;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variables_emptyView);
                                            if (linearLayout3 != null) {
                                                return new VariablesActivityBinding((CoordinatorLayout) view, lottieAnimationView, floatingActionButton, linearLayout, checkBox, frameLayout, linearLayout2, toolbar, spinner, listView, linearLayout3);
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
    public static VariablesActivityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VariablesActivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.variables_activity, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f11405a;
    }
}
