package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogDeviceFacingBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11048a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox faceDownCheckbox;
    @NonNull
    public final CheckBox faceUpCheckbox;
    @NonNull
    public final ImageView indicatorFaceDown;
    @NonNull
    public final ImageView indicatorFaceUp;
    @NonNull
    public final ImageView indicatorSidewaysLeft;
    @NonNull
    public final ImageView indicatorSidewaysRight;
    @NonNull
    public final ImageView indicatorUpright;
    @NonNull
    public final ImageView indicatorUpsideDown;
    @NonNull
    public final Button okButton;
    @NonNull
    public final CheckBox screenOffCheckbox;
    @NonNull
    public final CheckBox sidewaysLeftCheckbox;
    @NonNull
    public final CheckBox sidewaysRightCheckbox;
    @NonNull
    public final CheckBox verticalUprightCheckbox;
    @NonNull
    public final CheckBox verticalUpsideDownCheckbox;

    private DialogDeviceFacingBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull Button button2, @NonNull CheckBox checkBox3, @NonNull CheckBox checkBox4, @NonNull CheckBox checkBox5, @NonNull CheckBox checkBox6, @NonNull CheckBox checkBox7) {
        this.f11048a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.faceDownCheckbox = checkBox;
        this.faceUpCheckbox = checkBox2;
        this.indicatorFaceDown = imageView;
        this.indicatorFaceUp = imageView2;
        this.indicatorSidewaysLeft = imageView3;
        this.indicatorSidewaysRight = imageView4;
        this.indicatorUpright = imageView5;
        this.indicatorUpsideDown = imageView6;
        this.okButton = button2;
        this.screenOffCheckbox = checkBox3;
        this.sidewaysLeftCheckbox = checkBox4;
        this.sidewaysRightCheckbox = checkBox5;
        this.verticalUprightCheckbox = checkBox6;
        this.verticalUpsideDownCheckbox = checkBox7;
    }

    @NonNull
    public static DialogDeviceFacingBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.face_down_checkbox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.face_down_checkbox);
                if (checkBox != null) {
                    i4 = R.id.face_up_checkbox;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.face_up_checkbox);
                    if (checkBox2 != null) {
                        i4 = R.id.indicator_face_down;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.indicator_face_down);
                        if (imageView != null) {
                            i4 = R.id.indicator_face_up;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.indicator_face_up);
                            if (imageView2 != null) {
                                i4 = R.id.indicator_sideways_left;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.indicator_sideways_left);
                                if (imageView3 != null) {
                                    i4 = R.id.indicator_sideways_right;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.indicator_sideways_right);
                                    if (imageView4 != null) {
                                        i4 = R.id.indicator_upright;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.indicator_upright);
                                        if (imageView5 != null) {
                                            i4 = R.id.indicator_upside_down;
                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.indicator_upside_down);
                                            if (imageView6 != null) {
                                                i4 = R.id.okButton;
                                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                if (button2 != null) {
                                                    i4 = R.id.screen_off_checkbox;
                                                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.screen_off_checkbox);
                                                    if (checkBox3 != null) {
                                                        i4 = R.id.sideways_left_checkbox;
                                                        CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.sideways_left_checkbox);
                                                        if (checkBox4 != null) {
                                                            i4 = R.id.sideways_right_checkbox;
                                                            CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.sideways_right_checkbox);
                                                            if (checkBox5 != null) {
                                                                i4 = R.id.vertical_upright_checkbox;
                                                                CheckBox checkBox6 = (CheckBox) ViewBindings.findChildViewById(view, R.id.vertical_upright_checkbox);
                                                                if (checkBox6 != null) {
                                                                    i4 = R.id.vertical_upside_down_checkbox;
                                                                    CheckBox checkBox7 = (CheckBox) ViewBindings.findChildViewById(view, R.id.vertical_upside_down_checkbox);
                                                                    if (checkBox7 != null) {
                                                                        return new DialogDeviceFacingBinding((LinearLayout) view, linearLayout, button, checkBox, checkBox2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, button2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7);
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
    public static DialogDeviceFacingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogDeviceFacingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_device_facing, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11048a;
    }
}
