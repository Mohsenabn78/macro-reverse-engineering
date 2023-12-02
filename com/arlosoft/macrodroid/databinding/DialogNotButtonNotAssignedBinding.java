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
public final class DialogNotButtonNotAssignedBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11102a;
    @NonNull
    public final Button buttonCreateMacro;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final TextView messageDialogMessage;

    private DialogNotButtonNotAssignedBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView) {
        this.f11102a = linearLayout;
        this.buttonCreateMacro = button;
        this.cancelButton = button2;
        this.messageDialogMessage = textView;
    }

    @NonNull
    public static DialogNotButtonNotAssignedBinding bind(@NonNull View view) {
        int i4 = R.id.button_create_macro;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.button_create_macro);
        if (button != null) {
            i4 = R.id.cancelButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button2 != null) {
                i4 = R.id.message_dialog_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.message_dialog_message);
                if (textView != null) {
                    return new DialogNotButtonNotAssignedBinding((LinearLayout) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogNotButtonNotAssignedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogNotButtonNotAssignedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_not_button_not_assigned, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11102a;
    }
}
