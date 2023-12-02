package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogBeaconNameBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11030a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button buttonDelete;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final TextInputEditText friendlyName;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextInputEditText uuid;
    @NonNull
    public final TextInputLayout uuidLayout;

    private DialogBeaconNameBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull TextInputEditText textInputEditText, @NonNull Button button3, @NonNull TextInputEditText textInputEditText2, @NonNull TextInputLayout textInputLayout) {
        this.f11030a = scrollView;
        this.buttonBar = linearLayout;
        this.buttonDelete = button;
        this.cancelButton = button2;
        this.friendlyName = textInputEditText;
        this.okButton = button3;
        this.uuid = textInputEditText2;
        this.uuidLayout = textInputLayout;
    }

    @NonNull
    public static DialogBeaconNameBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.button_delete;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.button_delete);
            if (button != null) {
                i4 = R.id.cancelButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button2 != null) {
                    i4 = R.id.friendly_name;
                    TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.friendly_name);
                    if (textInputEditText != null) {
                        i4 = R.id.okButton;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button3 != null) {
                            i4 = R.id.uuid;
                            TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.uuid);
                            if (textInputEditText2 != null) {
                                i4 = R.id.uuid_layout;
                                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.uuid_layout);
                                if (textInputLayout != null) {
                                    return new DialogBeaconNameBinding((ScrollView) view, linearLayout, button, button2, textInputEditText, button3, textInputEditText2, textInputLayout);
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
    public static DialogBeaconNameBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogBeaconNameBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_beacon_name, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11030a;
    }
}
