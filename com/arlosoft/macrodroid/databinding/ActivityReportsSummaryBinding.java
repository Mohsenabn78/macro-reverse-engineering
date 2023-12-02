package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityReportsSummaryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10965a;
    @NonNull
    public final Button clearReportsButton;
    @NonNull
    public final RecyclerView commentsRecyclerView;
    @NonNull
    public final Button deleteMacroButton;
    @NonNull
    public final Toolbar toolbar;

    private ActivityReportsSummaryBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull RecyclerView recyclerView, @NonNull Button button2, @NonNull Toolbar toolbar) {
        this.f10965a = linearLayout;
        this.clearReportsButton = button;
        this.commentsRecyclerView = recyclerView;
        this.deleteMacroButton = button2;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ActivityReportsSummaryBinding bind(@NonNull View view) {
        int i4 = R.id.clearReportsButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.clearReportsButton);
        if (button != null) {
            i4 = R.id.commentsRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.commentsRecyclerView);
            if (recyclerView != null) {
                i4 = R.id.deleteMacroButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.deleteMacroButton);
                if (button2 != null) {
                    i4 = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (toolbar != null) {
                        return new ActivityReportsSummaryBinding((LinearLayout) view, button, recyclerView, button2, toolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityReportsSummaryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityReportsSummaryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_reports_summary, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10965a;
    }
}
