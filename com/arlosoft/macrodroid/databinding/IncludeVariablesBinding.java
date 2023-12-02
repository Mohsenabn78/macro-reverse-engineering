package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.editscreen.LocalVarRecyclerView;

/* loaded from: classes3.dex */
public final class IncludeVariablesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11272a;
    @NonNull
    public final ImageButton addVariableButton;
    @NonNull
    public final TextView localVarsLabel;
    @NonNull
    public final LocalVarRecyclerView localVarsList;
    @NonNull
    public final TextView noVarsText;
    @NonNull
    public final FrameLayout varTitleLayout;

    private IncludeVariablesBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull TextView textView, @NonNull LocalVarRecyclerView localVarRecyclerView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout) {
        this.f11272a = linearLayout;
        this.addVariableButton = imageButton;
        this.localVarsLabel = textView;
        this.localVarsList = localVarRecyclerView;
        this.noVarsText = textView2;
        this.varTitleLayout = frameLayout;
    }

    @NonNull
    public static IncludeVariablesBinding bind(@NonNull View view) {
        int i4 = R.id.addVariableButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.addVariableButton);
        if (imageButton != null) {
            i4 = R.id.localVarsLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.localVarsLabel);
            if (textView != null) {
                i4 = R.id.localVarsList;
                LocalVarRecyclerView localVarRecyclerView = (LocalVarRecyclerView) ViewBindings.findChildViewById(view, R.id.localVarsList);
                if (localVarRecyclerView != null) {
                    i4 = R.id.noVarsText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.noVarsText);
                    if (textView2 != null) {
                        i4 = R.id.varTitleLayout;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.varTitleLayout);
                        if (frameLayout != null) {
                            return new IncludeVariablesBinding((LinearLayout) view, imageButton, textView, localVarRecyclerView, textView2, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeVariablesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeVariablesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_variables, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11272a;
    }
}
