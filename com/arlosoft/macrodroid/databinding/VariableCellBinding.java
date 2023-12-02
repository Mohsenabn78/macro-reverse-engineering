package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes3.dex */
public final class VariableCellBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11398a;
    @NonNull
    public final TextView convertToLocal;
    @NonNull
    public final TextView variableCellBadge;
    @NonNull
    public final ImageButton variableCellDeleteButton;
    @NonNull
    public final FlowLayout variableCellMacroList;
    @NonNull
    public final LinearLayout variableCellMainContainer;
    @NonNull
    public final Spinner variableCellVariableBooleanSpinner;
    @NonNull
    public final TextView variableCellVariableName;
    @NonNull
    public final TextView variableCellVariableValue;

    private VariableCellBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageButton imageButton, @NonNull FlowLayout flowLayout, @NonNull LinearLayout linearLayout, @NonNull Spinner spinner, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f11398a = frameLayout;
        this.convertToLocal = textView;
        this.variableCellBadge = textView2;
        this.variableCellDeleteButton = imageButton;
        this.variableCellMacroList = flowLayout;
        this.variableCellMainContainer = linearLayout;
        this.variableCellVariableBooleanSpinner = spinner;
        this.variableCellVariableName = textView3;
        this.variableCellVariableValue = textView4;
    }

    @NonNull
    public static VariableCellBinding bind(@NonNull View view) {
        int i4 = R.id.convert_to_local;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.convert_to_local);
        if (textView != null) {
            i4 = R.id.variable_cell_badge;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.variable_cell_badge);
            if (textView2 != null) {
                i4 = R.id.variable_cell_delete_button;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.variable_cell_delete_button);
                if (imageButton != null) {
                    i4 = R.id.variable_cell_macro_list;
                    FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, R.id.variable_cell_macro_list);
                    if (flowLayout != null) {
                        i4 = R.id.variable_cell_main_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variable_cell_main_container);
                        if (linearLayout != null) {
                            i4 = R.id.variable_cell_variable_boolean_spinner;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.variable_cell_variable_boolean_spinner);
                            if (spinner != null) {
                                i4 = R.id.variable_cell_variable_name;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.variable_cell_variable_name);
                                if (textView3 != null) {
                                    i4 = R.id.variable_cell_variable_value;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.variable_cell_variable_value);
                                    if (textView4 != null) {
                                        return new VariableCellBinding((FrameLayout) view, textView, textView2, imageButton, flowLayout, linearLayout, spinner, textView3, textView4);
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
    public static VariableCellBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VariableCellBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.variable_cell, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11398a;
    }
}
