package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.SwitchPlus;
import com.google.android.material.card.MaterialCardView;
import com.varunest.sparkbutton.SparkButton2;

/* loaded from: classes3.dex */
public final class MacroListRowBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11328a;
    @NonNull
    public final TextView actionsOneChar;
    @NonNull
    public final View blocker;
    @NonNull
    public final RelativeLayout cardInfoContainer;
    @NonNull
    public final TextView constraintsOneChar;
    @NonNull
    public final TextView description;
    @NonNull
    public final View dividerLine;
    @NonNull
    public final SwitchPlus enabledSwitch;
    @NonNull
    public final TextView lastEditedTime;
    @NonNull
    public final TextView lastInvokedTime;
    @NonNull
    public final TextView macroActions;
    @NonNull
    public final LinearLayout macroActionsContainer;
    @NonNull
    public final MaterialCardView macroCardView;
    @NonNull
    public final TextView macroConstraints;
    @NonNull
    public final LinearLayout macroConstraintsContainer;
    @NonNull
    public final TextView macroNameText;
    @NonNull
    public final ConstraintLayout macroTitleBar;
    @NonNull
    public final TextView macroTrigger;
    @NonNull
    public final LinearLayout macroTriggerContainer;
    @NonNull
    public final SparkButton2 starIcon;
    @NonNull
    public final LinearLayout topContainer;
    @NonNull
    public final TextView triggerOneChar;

    private MacroListRowBinding(@NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull View view, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view2, @NonNull SwitchPlus switchPlus, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull LinearLayout linearLayout, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView7, @NonNull LinearLayout linearLayout2, @NonNull TextView textView8, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView9, @NonNull LinearLayout linearLayout3, @NonNull SparkButton2 sparkButton2, @NonNull LinearLayout linearLayout4, @NonNull TextView textView10) {
        this.f11328a = materialCardView;
        this.actionsOneChar = textView;
        this.blocker = view;
        this.cardInfoContainer = relativeLayout;
        this.constraintsOneChar = textView2;
        this.description = textView3;
        this.dividerLine = view2;
        this.enabledSwitch = switchPlus;
        this.lastEditedTime = textView4;
        this.lastInvokedTime = textView5;
        this.macroActions = textView6;
        this.macroActionsContainer = linearLayout;
        this.macroCardView = materialCardView2;
        this.macroConstraints = textView7;
        this.macroConstraintsContainer = linearLayout2;
        this.macroNameText = textView8;
        this.macroTitleBar = constraintLayout;
        this.macroTrigger = textView9;
        this.macroTriggerContainer = linearLayout3;
        this.starIcon = sparkButton2;
        this.topContainer = linearLayout4;
        this.triggerOneChar = textView10;
    }

    @NonNull
    public static MacroListRowBinding bind(@NonNull View view) {
        int i4 = R.id.actions_one_char;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.actions_one_char);
        if (textView != null) {
            i4 = R.id.blocker;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.blocker);
            if (findChildViewById != null) {
                i4 = R.id.card_info_container;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.card_info_container);
                if (relativeLayout != null) {
                    i4 = R.id.constraints_one_char;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.constraints_one_char);
                    if (textView2 != null) {
                        i4 = R.id.description;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.description);
                        if (textView3 != null) {
                            i4 = R.id.divider_line;
                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.divider_line);
                            if (findChildViewById2 != null) {
                                i4 = R.id.enabledSwitch;
                                SwitchPlus switchPlus = (SwitchPlus) ViewBindings.findChildViewById(view, R.id.enabledSwitch);
                                if (switchPlus != null) {
                                    i4 = R.id.lastEditedTime;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.lastEditedTime);
                                    if (textView4 != null) {
                                        i4 = R.id.lastInvokedTime;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.lastInvokedTime);
                                        if (textView5 != null) {
                                            i4 = R.id.macroActions;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.macroActions);
                                            if (textView6 != null) {
                                                i4 = R.id.macroActionsContainer;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroActionsContainer);
                                                if (linearLayout != null) {
                                                    MaterialCardView materialCardView = (MaterialCardView) view;
                                                    i4 = R.id.macroConstraints;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.macroConstraints);
                                                    if (textView7 != null) {
                                                        i4 = R.id.macroConstraintsContainer;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroConstraintsContainer);
                                                        if (linearLayout2 != null) {
                                                            i4 = R.id.macroNameText;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.macroNameText);
                                                            if (textView8 != null) {
                                                                i4 = R.id.macro_title_bar;
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.macro_title_bar);
                                                                if (constraintLayout != null) {
                                                                    i4 = R.id.macroTrigger;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.macroTrigger);
                                                                    if (textView9 != null) {
                                                                        i4 = R.id.macroTriggerContainer;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroTriggerContainer);
                                                                        if (linearLayout3 != null) {
                                                                            i4 = R.id.starIcon;
                                                                            SparkButton2 sparkButton2 = (SparkButton2) ViewBindings.findChildViewById(view, R.id.starIcon);
                                                                            if (sparkButton2 != null) {
                                                                                i4 = R.id.topContainer;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.topContainer);
                                                                                if (linearLayout4 != null) {
                                                                                    i4 = R.id.trigger_one_char;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.trigger_one_char);
                                                                                    if (textView10 != null) {
                                                                                        return new MacroListRowBinding(materialCardView, textView, findChildViewById, relativeLayout, textView2, textView3, findChildViewById2, switchPlus, textView4, textView5, textView6, linearLayout, materialCardView, textView7, linearLayout2, textView8, constraintLayout, textView9, linearLayout3, sparkButton2, linearLayout4, textView10);
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
    public static MacroListRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MacroListRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.macro_list_row, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11328a;
    }
}
