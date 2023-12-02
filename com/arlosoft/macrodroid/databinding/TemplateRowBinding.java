package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class TemplateRowBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11388a;
    @NonNull
    public final TextView actionsOneChar;
    @NonNull
    public final TextView constraintsOneChar;
    @NonNull
    public final TextView macroActions;
    @NonNull
    public final LinearLayout macroActionsContainer;
    @NonNull
    public final TextView macroConstraints;
    @NonNull
    public final LinearLayout macroConstraintsContainer;
    @NonNull
    public final TextView macroTrigger;
    @NonNull
    public final LinearLayout macroTriggerContainer;
    @NonNull
    public final RelativeLayout templateRowBottomBar;
    @NonNull
    public final ImageButton templateRowMacroBadButton;
    @NonNull
    public final ViewFlipper templateRowMacroBadButtonFlipper;
    @NonNull
    public final ImageButton templateRowMacroDeleteButton;
    @NonNull
    public final ViewFlipper templateRowMacroDeleteButtonFlipper;
    @NonNull
    public final TextView templateRowMacroDescription;
    @NonNull
    public final ImageButton templateRowMacroEditButton;
    @NonNull
    public final ViewFlipper templateRowMacroEditButtonFlipper;
    @NonNull
    public final ImageButton templateRowMacroGoodButton;
    @NonNull
    public final ViewFlipper templateRowMacroGoodButtonFlipper;
    @NonNull
    public final TextView templateRowMacroName;
    @NonNull
    public final TextView templateRowMacroRootOnlyLabel;
    @NonNull
    public final TextView templateRowMacroUploadDate;
    @NonNull
    public final LinearLayout templateRowMacroUserTouchArea;
    @NonNull
    public final TextView templateRowMacroUsername;
    @NonNull
    public final TextView templateRowRating;
    @NonNull
    public final LinearLayout templateTile;
    @NonNull
    public final TextView triggerOneChar;

    private TemplateRowBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2, @NonNull TextView textView5, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout, @NonNull ImageButton imageButton, @NonNull ViewFlipper viewFlipper, @NonNull ImageButton imageButton2, @NonNull ViewFlipper viewFlipper2, @NonNull TextView textView6, @NonNull ImageButton imageButton3, @NonNull ViewFlipper viewFlipper3, @NonNull ImageButton imageButton4, @NonNull ViewFlipper viewFlipper4, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull LinearLayout linearLayout4, @NonNull TextView textView10, @NonNull TextView textView11, @NonNull LinearLayout linearLayout5, @NonNull TextView textView12) {
        this.f11388a = frameLayout;
        this.actionsOneChar = textView;
        this.constraintsOneChar = textView2;
        this.macroActions = textView3;
        this.macroActionsContainer = linearLayout;
        this.macroConstraints = textView4;
        this.macroConstraintsContainer = linearLayout2;
        this.macroTrigger = textView5;
        this.macroTriggerContainer = linearLayout3;
        this.templateRowBottomBar = relativeLayout;
        this.templateRowMacroBadButton = imageButton;
        this.templateRowMacroBadButtonFlipper = viewFlipper;
        this.templateRowMacroDeleteButton = imageButton2;
        this.templateRowMacroDeleteButtonFlipper = viewFlipper2;
        this.templateRowMacroDescription = textView6;
        this.templateRowMacroEditButton = imageButton3;
        this.templateRowMacroEditButtonFlipper = viewFlipper3;
        this.templateRowMacroGoodButton = imageButton4;
        this.templateRowMacroGoodButtonFlipper = viewFlipper4;
        this.templateRowMacroName = textView7;
        this.templateRowMacroRootOnlyLabel = textView8;
        this.templateRowMacroUploadDate = textView9;
        this.templateRowMacroUserTouchArea = linearLayout4;
        this.templateRowMacroUsername = textView10;
        this.templateRowRating = textView11;
        this.templateTile = linearLayout5;
        this.triggerOneChar = textView12;
    }

    @NonNull
    public static TemplateRowBinding bind(@NonNull View view) {
        int i4 = R.id.actions_one_char;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.actions_one_char);
        if (textView != null) {
            i4 = R.id.constraints_one_char;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.constraints_one_char);
            if (textView2 != null) {
                i4 = R.id.macroActions;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.macroActions);
                if (textView3 != null) {
                    i4 = R.id.macroActionsContainer;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroActionsContainer);
                    if (linearLayout != null) {
                        i4 = R.id.macroConstraints;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.macroConstraints);
                        if (textView4 != null) {
                            i4 = R.id.macroConstraintsContainer;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroConstraintsContainer);
                            if (linearLayout2 != null) {
                                i4 = R.id.macroTrigger;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.macroTrigger);
                                if (textView5 != null) {
                                    i4 = R.id.macroTriggerContainer;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroTriggerContainer);
                                    if (linearLayout3 != null) {
                                        i4 = R.id.templateRowBottomBar;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.templateRowBottomBar);
                                        if (relativeLayout != null) {
                                            i4 = R.id.template_row_macro_bad_button;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.template_row_macro_bad_button);
                                            if (imageButton != null) {
                                                i4 = R.id.template_row_macro_bad_button_flipper;
                                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.template_row_macro_bad_button_flipper);
                                                if (viewFlipper != null) {
                                                    i4 = R.id.template_row_macro_delete_button;
                                                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.template_row_macro_delete_button);
                                                    if (imageButton2 != null) {
                                                        i4 = R.id.template_row_macro_delete_button_flipper;
                                                        ViewFlipper viewFlipper2 = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.template_row_macro_delete_button_flipper);
                                                        if (viewFlipper2 != null) {
                                                            i4 = R.id.template_row_macro_description;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.template_row_macro_description);
                                                            if (textView6 != null) {
                                                                i4 = R.id.template_row_macro_edit_button;
                                                                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.template_row_macro_edit_button);
                                                                if (imageButton3 != null) {
                                                                    i4 = R.id.template_row_macro_edit_button_flipper;
                                                                    ViewFlipper viewFlipper3 = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.template_row_macro_edit_button_flipper);
                                                                    if (viewFlipper3 != null) {
                                                                        i4 = R.id.template_row_macro_good_button;
                                                                        ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, R.id.template_row_macro_good_button);
                                                                        if (imageButton4 != null) {
                                                                            i4 = R.id.template_row_macro_good_button_flipper;
                                                                            ViewFlipper viewFlipper4 = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.template_row_macro_good_button_flipper);
                                                                            if (viewFlipper4 != null) {
                                                                                i4 = R.id.template_row_macro_name;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.template_row_macro_name);
                                                                                if (textView7 != null) {
                                                                                    i4 = R.id.template_row_macro_root_only_label;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.template_row_macro_root_only_label);
                                                                                    if (textView8 != null) {
                                                                                        i4 = R.id.template_row_macro_upload_date;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.template_row_macro_upload_date);
                                                                                        if (textView9 != null) {
                                                                                            i4 = R.id.template_row_macro_user_touch_area;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.template_row_macro_user_touch_area);
                                                                                            if (linearLayout4 != null) {
                                                                                                i4 = R.id.template_row_macro_username;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.template_row_macro_username);
                                                                                                if (textView10 != null) {
                                                                                                    i4 = R.id.template_row_rating;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.template_row_rating);
                                                                                                    if (textView11 != null) {
                                                                                                        i4 = R.id.template_tile;
                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.template_tile);
                                                                                                        if (linearLayout5 != null) {
                                                                                                            i4 = R.id.trigger_one_char;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, R.id.trigger_one_char);
                                                                                                            if (textView12 != null) {
                                                                                                                return new TemplateRowBinding((FrameLayout) view, textView, textView2, textView3, linearLayout, textView4, linearLayout2, textView5, linearLayout3, relativeLayout, imageButton, viewFlipper, imageButton2, viewFlipper2, textView6, imageButton3, viewFlipper3, imageButton4, viewFlipper4, textView7, textView8, textView9, linearLayout4, textView10, textView11, linearLayout5, textView12);
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
    public static TemplateRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TemplateRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.template_row, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11388a;
    }
}
