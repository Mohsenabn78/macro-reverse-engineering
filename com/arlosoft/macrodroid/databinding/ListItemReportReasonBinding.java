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
public final class ListItemReportReasonBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11308a;
    @NonNull
    public final TextView reasonCount;
    @NonNull
    public final TextView reasonText;

    private ListItemReportReasonBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11308a = linearLayout;
        this.reasonCount = textView;
        this.reasonText = textView2;
    }

    @NonNull
    public static ListItemReportReasonBinding bind(@NonNull View view) {
        int i4 = R.id.reasonCount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.reasonCount);
        if (textView != null) {
            i4 = R.id.reasonText;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.reasonText);
            if (textView2 != null) {
                return new ListItemReportReasonBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemReportReasonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemReportReasonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_report_reason, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11308a;
    }
}
