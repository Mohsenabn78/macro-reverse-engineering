package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class FragmentHttpRequestParamListBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f11226a;
    @NonNull
    public final FloatingActionButton addParamButton;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final TextView emptyView;
    @NonNull
    public final RecyclerView paramsRecyclerView;

    private FragmentHttpRequestParamListBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull TextView textView, @NonNull RecyclerView recyclerView) {
        this.f11226a = coordinatorLayout;
        this.addParamButton = floatingActionButton;
        this.coordinatorLayout = coordinatorLayout2;
        this.emptyView = textView;
        this.paramsRecyclerView = recyclerView;
    }

    @NonNull
    public static FragmentHttpRequestParamListBinding bind(@NonNull View view) {
        int i4 = R.id.addParamButton;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.addParamButton);
        if (floatingActionButton != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
            i4 = R.id.emptyView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.emptyView);
            if (textView != null) {
                i4 = R.id.paramsRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.paramsRecyclerView);
                if (recyclerView != null) {
                    return new FragmentHttpRequestParamListBinding(coordinatorLayout, floatingActionButton, coordinatorLayout, textView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentHttpRequestParamListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentHttpRequestParamListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_http_request_param_list, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f11226a;
    }
}
