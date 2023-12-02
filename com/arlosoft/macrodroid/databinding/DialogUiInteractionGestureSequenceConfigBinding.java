package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogUiInteractionGestureSequenceConfigBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NestedScrollView f11152a;
    @NonNull
    public final Button addEntryButton;
    @NonNull
    public final AppCompatEditText duration;
    @NonNull
    public final LinearLayout entriesLayout;
    @NonNull
    public final TextView msLabel;
    @NonNull
    public final Button msMagicTextButton;
    @NonNull
    public final RadioButton radioButtonPercent;
    @NonNull
    public final RadioButton radioButtonPixels;
    @NonNull
    public final Button removeEntryButton;
    @NonNull
    public final TextView resolutionLabel;
    @NonNull
    public final Button showTouchOverlayButton;
    @NonNull
    public final AppCompatEditText startXLocation;
    @NonNull
    public final Button startXMagicTextButton;
    @NonNull
    public final AppCompatEditText startYLocation;
    @NonNull
    public final Button startYMagicTextButton;
    @NonNull
    public final LinearLayout topLevelContainer;
    @NonNull
    public final CheckBox waitCheckbox;

    private DialogUiInteractionGestureSequenceConfigBinding(@NonNull NestedScrollView nestedScrollView, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull Button button2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull Button button3, @NonNull TextView textView2, @NonNull Button button4, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button5, @NonNull AppCompatEditText appCompatEditText3, @NonNull Button button6, @NonNull LinearLayout linearLayout2, @NonNull CheckBox checkBox) {
        this.f11152a = nestedScrollView;
        this.addEntryButton = button;
        this.duration = appCompatEditText;
        this.entriesLayout = linearLayout;
        this.msLabel = textView;
        this.msMagicTextButton = button2;
        this.radioButtonPercent = radioButton;
        this.radioButtonPixels = radioButton2;
        this.removeEntryButton = button3;
        this.resolutionLabel = textView2;
        this.showTouchOverlayButton = button4;
        this.startXLocation = appCompatEditText2;
        this.startXMagicTextButton = button5;
        this.startYLocation = appCompatEditText3;
        this.startYMagicTextButton = button6;
        this.topLevelContainer = linearLayout2;
        this.waitCheckbox = checkBox;
    }

    @NonNull
    public static DialogUiInteractionGestureSequenceConfigBinding bind(@NonNull View view) {
        int i4 = R.id.addEntryButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addEntryButton);
        if (button != null) {
            i4 = R.id.duration;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.duration);
            if (appCompatEditText != null) {
                i4 = R.id.entriesLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.entriesLayout);
                if (linearLayout != null) {
                    i4 = R.id.msLabel;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.msLabel);
                    if (textView != null) {
                        i4 = R.id.msMagicTextButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.msMagicTextButton);
                        if (button2 != null) {
                            i4 = R.id.radioButtonPercent;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonPercent);
                            if (radioButton != null) {
                                i4 = R.id.radioButtonPixels;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonPixels);
                                if (radioButton2 != null) {
                                    i4 = R.id.removeEntryButton;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.removeEntryButton);
                                    if (button3 != null) {
                                        i4 = R.id.resolution_label;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.resolution_label);
                                        if (textView2 != null) {
                                            i4 = R.id.showTouchOverlayButton;
                                            Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.showTouchOverlayButton);
                                            if (button4 != null) {
                                                i4 = R.id.start_x_location;
                                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.start_x_location);
                                                if (appCompatEditText2 != null) {
                                                    i4 = R.id.startXMagicTextButton;
                                                    Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.startXMagicTextButton);
                                                    if (button5 != null) {
                                                        i4 = R.id.start_y_location;
                                                        AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.start_y_location);
                                                        if (appCompatEditText3 != null) {
                                                            i4 = R.id.startYMagicTextButton;
                                                            Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.startYMagicTextButton);
                                                            if (button6 != null) {
                                                                i4 = R.id.topLevelContainer;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.topLevelContainer);
                                                                if (linearLayout2 != null) {
                                                                    i4 = R.id.waitCheckbox;
                                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.waitCheckbox);
                                                                    if (checkBox != null) {
                                                                        return new DialogUiInteractionGestureSequenceConfigBinding((NestedScrollView) view, button, appCompatEditText, linearLayout, textView, button2, radioButton, radioButton2, button3, textView2, button4, appCompatEditText2, button5, appCompatEditText3, button6, linearLayout2, checkBox);
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
    public static DialogUiInteractionGestureSequenceConfigBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUiInteractionGestureSequenceConfigBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ui_interaction_gesture_sequence_config, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public NestedScrollView getRoot() {
        return this.f11152a;
    }
}
