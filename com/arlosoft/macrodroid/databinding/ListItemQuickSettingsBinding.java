package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ListItemQuickSettingsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11306a;
    @NonNull
    public final TextView buttonLabel;
    @NonNull
    public final RadioButton buttonOption;
    @NonNull
    public final CheckBox collapseOnPress;
    @NonNull
    public final MaterialCardView container;
    @NonNull
    public final ImageView editImage;
    @NonNull
    public final TextView enabledState;
    @NonNull
    public final ImageView image;
    @NonNull
    public final AppCompatEditText tileLabel;
    @NonNull
    public final SwitchCompat tileSwitch;
    @NonNull
    public final RadioButton toggleOption;

    private ListItemQuickSettingsBinding(@NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull RadioButton radioButton, @NonNull CheckBox checkBox, @NonNull MaterialCardView materialCardView2, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull AppCompatEditText appCompatEditText, @NonNull SwitchCompat switchCompat, @NonNull RadioButton radioButton2) {
        this.f11306a = materialCardView;
        this.buttonLabel = textView;
        this.buttonOption = radioButton;
        this.collapseOnPress = checkBox;
        this.container = materialCardView2;
        this.editImage = imageView;
        this.enabledState = textView2;
        this.image = imageView2;
        this.tileLabel = appCompatEditText;
        this.tileSwitch = switchCompat;
        this.toggleOption = radioButton2;
    }

    @NonNull
    public static ListItemQuickSettingsBinding bind(@NonNull View view) {
        int i4 = R.id.button_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.button_label);
        if (textView != null) {
            i4 = R.id.button_option;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.button_option);
            if (radioButton != null) {
                i4 = R.id.collapse_on_press;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.collapse_on_press);
                if (checkBox != null) {
                    MaterialCardView materialCardView = (MaterialCardView) view;
                    i4 = R.id.editImage;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.editImage);
                    if (imageView != null) {
                        i4 = R.id.enabled_state;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.enabled_state);
                        if (textView2 != null) {
                            i4 = R.id.image;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.image);
                            if (imageView2 != null) {
                                i4 = R.id.tile_label;
                                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.tile_label);
                                if (appCompatEditText != null) {
                                    i4 = R.id.tile_switch;
                                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.tile_switch);
                                    if (switchCompat != null) {
                                        i4 = R.id.toggle_option;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.toggle_option);
                                        if (radioButton2 != null) {
                                            return new ListItemQuickSettingsBinding(materialCardView, textView, radioButton, checkBox, materialCardView, imageView, textView2, imageView2, appCompatEditText, switchCompat, radioButton2);
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
    public static ListItemQuickSettingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemQuickSettingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_quick_settings, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11306a;
    }
}
