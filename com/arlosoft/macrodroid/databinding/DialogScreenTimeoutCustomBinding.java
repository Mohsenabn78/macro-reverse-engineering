package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;

/* loaded from: classes3.dex */
public final class DialogScreenTimeoutCustomBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11118a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final NumberPicker screenTimeoutCustomMinutes;
    @NonNull
    public final NumberPicker screenTimeoutCustomSeconds;
    @NonNull
    public final TableLayout tableLayout1;

    private DialogScreenTimeoutCustomBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull NumberPicker numberPicker, @NonNull NumberPicker numberPicker2, @NonNull TableLayout tableLayout) {
        this.f11118a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.okButton = button2;
        this.screenTimeoutCustomMinutes = numberPicker;
        this.screenTimeoutCustomSeconds = numberPicker2;
        this.tableLayout1 = tableLayout;
    }

    @NonNull
    public static DialogScreenTimeoutCustomBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.okButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                if (button2 != null) {
                    i4 = R.id.screen_timeout_custom_minutes;
                    NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.screen_timeout_custom_minutes);
                    if (numberPicker != null) {
                        i4 = R.id.screen_timeout_custom_seconds;
                        NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.screen_timeout_custom_seconds);
                        if (numberPicker2 != null) {
                            i4 = R.id.tableLayout1;
                            TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view, R.id.tableLayout1);
                            if (tableLayout != null) {
                                return new DialogScreenTimeoutCustomBinding((LinearLayout) view, linearLayout, button, button2, numberPicker, numberPicker2, tableLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogScreenTimeoutCustomBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogScreenTimeoutCustomBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_screen_timeout_custom, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11118a;
    }
}
