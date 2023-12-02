package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ListItemStringManipulationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11312a;
    @NonNull
    public final View divider;
    @NonNull
    public final TextView stringManipulationDescription;
    @NonNull
    public final LinearLayout stringManipulationEntry;
    @NonNull
    public final TextView stringManipulationText;

    private ListItemStringManipulationBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f11312a = linearLayout;
        this.divider = view;
        this.stringManipulationDescription = textView;
        this.stringManipulationEntry = linearLayout2;
        this.stringManipulationText = textView2;
    }

    @NonNull
    public static ListItemStringManipulationBinding bind(@NonNull View view) {
        int i4 = R.id.divider;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.divider);
        if (findChildViewById != null) {
            i4 = R.id.string_manipulation_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.string_manipulation_description);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i4 = R.id.string_manipulation_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.string_manipulation_text);
                if (textView2 != null) {
                    return new ListItemStringManipulationBinding(linearLayout, findChildViewById, textView, linearLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemStringManipulationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemStringManipulationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_string_manipulation, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11312a;
    }
}
