package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityExtrasBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10941a;
    @NonNull
    public final LinearLayout emptyState;
    @NonNull
    public final RecyclerView extrasList;
    @NonNull
    public final Button retryButton;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ViewFlipper viewFlipper;

    private ActivityExtrasBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull Button button, @NonNull Toolbar toolbar, @NonNull ViewFlipper viewFlipper) {
        this.f10941a = linearLayout;
        this.emptyState = linearLayout2;
        this.extrasList = recyclerView;
        this.retryButton = button;
        this.toolbar = toolbar;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static ActivityExtrasBinding bind(@NonNull View view) {
        int i4 = R.id.empty_state;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.empty_state);
        if (linearLayout != null) {
            i4 = R.id.extras_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.extras_list);
            if (recyclerView != null) {
                i4 = R.id.retry_button;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.retry_button);
                if (button != null) {
                    i4 = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (toolbar != null) {
                        i4 = R.id.view_flipper;
                        ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.view_flipper);
                        if (viewFlipper != null) {
                            return new ActivityExtrasBinding((LinearLayout) view, linearLayout, recyclerView, button, toolbar, viewFlipper);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityExtrasBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityExtrasBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_extras, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10941a;
    }
}
