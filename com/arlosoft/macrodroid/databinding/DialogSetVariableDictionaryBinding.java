package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogSetVariableDictionaryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11126a;
    @NonNull
    public final Button addEntryButton;
    @NonNull
    public final LinearLayout entriesContainer;

    private DialogSetVariableDictionaryBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull LinearLayout linearLayout2) {
        this.f11126a = linearLayout;
        this.addEntryButton = button;
        this.entriesContainer = linearLayout2;
    }

    @NonNull
    public static DialogSetVariableDictionaryBinding bind(@NonNull View view) {
        int i4 = R.id.addEntryButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addEntryButton);
        if (button != null) {
            i4 = R.id.entriesContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.entriesContainer);
            if (linearLayout != null) {
                return new DialogSetVariableDictionaryBinding((LinearLayout) view, button, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSetVariableDictionaryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSetVariableDictionaryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_set_variable_dictionary, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11126a;
    }
}
