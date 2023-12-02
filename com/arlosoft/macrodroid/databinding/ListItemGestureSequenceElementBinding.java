package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ListItemGestureSequenceElementBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11293a;
    @NonNull
    public final AppCompatEditText xLocation;
    @NonNull
    public final Button xMagicTextButton;
    @NonNull
    public final AppCompatEditText yLocation;
    @NonNull
    public final Button yMagicTextButton;

    private ListItemGestureSequenceElementBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button2) {
        this.f11293a = linearLayout;
        this.xLocation = appCompatEditText;
        this.xMagicTextButton = button;
        this.yLocation = appCompatEditText2;
        this.yMagicTextButton = button2;
    }

    @NonNull
    public static ListItemGestureSequenceElementBinding bind(@NonNull View view) {
        int i4 = R.id.xLocation;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.xLocation);
        if (appCompatEditText != null) {
            i4 = R.id.xMagicTextButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.xMagicTextButton);
            if (button != null) {
                i4 = R.id.yLocation;
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.yLocation);
                if (appCompatEditText2 != null) {
                    i4 = R.id.yMagicTextButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.yMagicTextButton);
                    if (button2 != null) {
                        return new ListItemGestureSequenceElementBinding((LinearLayout) view, appCompatEditText, button, appCompatEditText2, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemGestureSequenceElementBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemGestureSequenceElementBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_gesture_sequence_element, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11293a;
    }
}
