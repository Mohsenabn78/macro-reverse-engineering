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
public final class ListItemLogEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11298a;
    @NonNull
    public final LinearLayout dateHeader;
    @NonNull
    public final TextView dateText;
    @NonNull
    public final TextView logText;
    @NonNull
    public final TextView timestampText;

    private ListItemLogEntryBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11298a = linearLayout;
        this.dateHeader = linearLayout2;
        this.dateText = textView;
        this.logText = textView2;
        this.timestampText = textView3;
    }

    @NonNull
    public static ListItemLogEntryBinding bind(@NonNull View view) {
        int i4 = R.id.date_header;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.date_header);
        if (linearLayout != null) {
            i4 = R.id.date_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.date_text);
            if (textView != null) {
                i4 = R.id.log_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.log_text);
                if (textView2 != null) {
                    i4 = R.id.timestamp_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.timestamp_text);
                    if (textView3 != null) {
                        return new ListItemLogEntryBinding((LinearLayout) view, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemLogEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemLogEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_log_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11298a;
    }
}
