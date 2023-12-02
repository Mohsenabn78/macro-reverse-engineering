package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NonSwipeableViewPager;

/* loaded from: classes3.dex */
public final class ActivityReportBugBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10964a;
    @NonNull
    public final RelativeLayout loadingView;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final NonSwipeableViewPager viewPager;

    private ActivityReportBugBinding(@NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull NonSwipeableViewPager nonSwipeableViewPager) {
        this.f10964a = frameLayout;
        this.loadingView = relativeLayout;
        this.progressBar = progressBar;
        this.viewPager = nonSwipeableViewPager;
    }

    @NonNull
    public static ActivityReportBugBinding bind(@NonNull View view) {
        int i4 = R.id.loading_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.loading_view);
        if (relativeLayout != null) {
            i4 = R.id.progress_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_bar);
            if (progressBar != null) {
                i4 = R.id.viewPager;
                NonSwipeableViewPager nonSwipeableViewPager = (NonSwipeableViewPager) ViewBindings.findChildViewById(view, R.id.viewPager);
                if (nonSwipeableViewPager != null) {
                    return new ActivityReportBugBinding((FrameLayout) view, relativeLayout, progressBar, nonSwipeableViewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityReportBugBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityReportBugBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_report_bug, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10964a;
    }
}
