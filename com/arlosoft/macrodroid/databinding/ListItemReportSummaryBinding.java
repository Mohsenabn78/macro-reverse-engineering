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
public final class ListItemReportSummaryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11309a;
    @NonNull
    public final TextView reportCount;
    @NonNull
    public final TextView starCount;
    @NonNull
    public final TextView starPerReportRatio;

    private ListItemReportSummaryBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11309a = linearLayout;
        this.reportCount = textView;
        this.starCount = textView2;
        this.starPerReportRatio = textView3;
    }

    @NonNull
    public static ListItemReportSummaryBinding bind(@NonNull View view) {
        int i4 = R.id.reportCount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.reportCount);
        if (textView != null) {
            i4 = R.id.starCount;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.starCount);
            if (textView2 != null) {
                i4 = R.id.starPerReportRatio;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.starPerReportRatio);
                if (textView3 != null) {
                    return new ListItemReportSummaryBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemReportSummaryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemReportSummaryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_report_summary, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11309a;
    }
}
