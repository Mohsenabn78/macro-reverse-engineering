package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class DialogGeofenceConstraintConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11073a;
    @NonNull
    public final RadioButton areaInsideOption;
    @NonNull
    public final RadioButton areaOutsideOption;
    @NonNull
    public final CheckBox locationUnknownCheckbox;
    @NonNull
    public final TextView updateFrequencyLink;
    @NonNull
    public final LinearLayout updateRateContainer;
    @NonNull
    public final TextView updateRateDescription;
    @NonNull
    public final TextView updateRateWarning;
    @NonNull
    public final TextView zoneNameButton;

    private DialogGeofenceConstraintConfigureBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f11073a = linearLayout;
        this.areaInsideOption = radioButton;
        this.areaOutsideOption = radioButton2;
        this.locationUnknownCheckbox = checkBox;
        this.updateFrequencyLink = textView;
        this.updateRateContainer = linearLayout2;
        this.updateRateDescription = textView2;
        this.updateRateWarning = textView3;
        this.zoneNameButton = textView4;
    }

    @NonNull
    public static DialogGeofenceConstraintConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.area_inside_option;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.area_inside_option);
        if (radioButton != null) {
            i4 = R.id.area_outside_option;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.area_outside_option);
            if (radioButton2 != null) {
                i4 = R.id.location_unknown_checkbox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.location_unknown_checkbox);
                if (checkBox != null) {
                    i4 = R.id.update_frequency_link;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.update_frequency_link);
                    if (textView != null) {
                        i4 = R.id.update_rate_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.update_rate_container);
                        if (linearLayout != null) {
                            i4 = R.id.update_rate_description;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.update_rate_description);
                            if (textView2 != null) {
                                i4 = R.id.update_rate_warning;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.update_rate_warning);
                                if (textView3 != null) {
                                    i4 = R.id.zone_name_button;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.zone_name_button);
                                    if (textView4 != null) {
                                        return new DialogGeofenceConstraintConfigureBinding((LinearLayout) view, radioButton, radioButton2, checkBox, textView, linearLayout, textView2, textView3, textView4);
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
    public static DialogGeofenceConstraintConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogGeofenceConstraintConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_geofence_constraint_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11073a;
    }
}
