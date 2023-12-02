package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogHotspotOptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11075a;
    @NonNull
    public final CheckBox alternativeMechanism;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton disableHotspot;
    @NonNull
    public final RadioButton enableHotspot;
    @NonNull
    public final CheckBox forceLegacySetting;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton toggleHotspot;

    private DialogHotspotOptionsBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull CheckBox checkBox2, @NonNull Button button2, @NonNull RadioButton radioButton3) {
        this.f11075a = scrollView;
        this.alternativeMechanism = checkBox;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.disableHotspot = radioButton;
        this.enableHotspot = radioButton2;
        this.forceLegacySetting = checkBox2;
        this.okButton = button2;
        this.toggleHotspot = radioButton3;
    }

    @NonNull
    public static DialogHotspotOptionsBinding bind(@NonNull View view) {
        int i4 = R.id.alternative_mechanism;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.alternative_mechanism);
        if (checkBox != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    i4 = R.id.disable_hotspot;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.disable_hotspot);
                    if (radioButton != null) {
                        i4 = R.id.enable_hotspot;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.enable_hotspot);
                        if (radioButton2 != null) {
                            i4 = R.id.force_legacy_setting;
                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_legacy_setting);
                            if (checkBox2 != null) {
                                i4 = R.id.okButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button2 != null) {
                                    i4 = R.id.toggle_hotspot;
                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.toggle_hotspot);
                                    if (radioButton3 != null) {
                                        return new DialogHotspotOptionsBinding((ScrollView) view, checkBox, linearLayout, button, radioButton, radioButton2, checkBox2, button2, radioButton3);
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
    public static DialogHotspotOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogHotspotOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_hotspot_options, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11075a;
    }
}
