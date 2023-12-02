package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class OptionDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11340a;
    @NonNull
    public final Button button1;
    @NonNull
    public final Button button2;
    @NonNull
    public final Button button3;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final TextView optionDialogMessage;

    private OptionDialogBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.f11340a = linearLayout;
        this.button1 = button;
        this.button2 = button2;
        this.button3 = button3;
        this.buttonBar = linearLayout2;
        this.optionDialogMessage = textView;
    }

    @NonNull
    public static OptionDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_1;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.button_1);
        if (button != null) {
            i4 = R.id.button_2;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.button_2);
            if (button2 != null) {
                i4 = R.id.button_3;
                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.button_3);
                if (button3 != null) {
                    i4 = R.id.button_bar;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                    if (linearLayout != null) {
                        i4 = R.id.option_dialog_message;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.option_dialog_message);
                        if (textView != null) {
                            return new OptionDialogBinding((LinearLayout) view, button, button2, button3, linearLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static OptionDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static OptionDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.option_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11340a;
    }
}
