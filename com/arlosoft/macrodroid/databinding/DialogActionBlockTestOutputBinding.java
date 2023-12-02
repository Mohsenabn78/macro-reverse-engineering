package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogActionBlockTestOutputBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11018a;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RecyclerView outputVars;

    private DialogActionBlockTestOutputBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull RecyclerView recyclerView) {
        this.f11018a = linearLayout;
        this.okButton = button;
        this.outputVars = recyclerView;
    }

    @NonNull
    public static DialogActionBlockTestOutputBinding bind(@NonNull View view) {
        int i4 = R.id.okButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
        if (button != null) {
            i4 = R.id.outputVars;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.outputVars);
            if (recyclerView != null) {
                return new DialogActionBlockTestOutputBinding((LinearLayout) view, button, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogActionBlockTestOutputBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogActionBlockTestOutputBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_action_block_test_output, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11018a;
    }
}
