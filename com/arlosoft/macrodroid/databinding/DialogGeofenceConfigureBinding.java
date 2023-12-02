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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogGeofenceConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11072a;
    @NonNull
    public final RadioButton areaEnterOption;
    @NonNull
    public final RadioButton areaExitOption;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox locationUnknownCheckbox;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView updateFrequencyLink;
    @NonNull
    public final LinearLayout updateRateContainer;
    @NonNull
    public final TextView updateRateDescription;
    @NonNull
    public final TextView zoneNameButton;

    private DialogGeofenceConfigureBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull Button button2, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11072a = linearLayout;
        this.areaEnterOption = radioButton;
        this.areaExitOption = radioButton2;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.locationUnknownCheckbox = checkBox;
        this.okButton = button2;
        this.updateFrequencyLink = textView;
        this.updateRateContainer = linearLayout3;
        this.updateRateDescription = textView2;
        this.zoneNameButton = textView3;
    }

    @NonNull
    public static DialogGeofenceConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.area_enter_option;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.area_enter_option);
        if (radioButton != null) {
            i4 = R.id.area_exit_option;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.area_exit_option);
            if (radioButton2 != null) {
                i4 = R.id.button_bar;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                if (linearLayout != null) {
                    i4 = R.id.cancelButton;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                    if (button != null) {
                        i4 = R.id.location_unknown_checkbox;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.location_unknown_checkbox);
                        if (checkBox != null) {
                            i4 = R.id.okButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button2 != null) {
                                i4 = R.id.update_frequency_link;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.update_frequency_link);
                                if (textView != null) {
                                    i4 = R.id.update_rate_container;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.update_rate_container);
                                    if (linearLayout2 != null) {
                                        i4 = R.id.update_rate_description;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.update_rate_description);
                                        if (textView2 != null) {
                                            i4 = R.id.zone_name_button;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.zone_name_button);
                                            if (textView3 != null) {
                                                return new DialogGeofenceConfigureBinding((LinearLayout) view, radioButton, radioButton2, linearLayout, button, checkBox, button2, textView, linearLayout2, textView2, textView3);
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
    public static DialogGeofenceConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogGeofenceConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_geofence_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11072a;
    }
}
