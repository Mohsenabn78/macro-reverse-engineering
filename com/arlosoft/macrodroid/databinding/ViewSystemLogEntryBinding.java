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
public final class ViewSystemLogEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11416a;
    @NonNull
    public final LinearLayout dateHeader;
    @NonNull
    public final LinearLayout dateHeaderBottom;
    @NonNull
    public final TextView dateText;
    @NonNull
    public final TextView dateTextBottom;
    @NonNull
    public final TextView logText;
    @NonNull
    public final TextView timeText;

    private ViewSystemLogEntryBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f11416a = linearLayout;
        this.dateHeader = linearLayout2;
        this.dateHeaderBottom = linearLayout3;
        this.dateText = textView;
        this.dateTextBottom = textView2;
        this.logText = textView3;
        this.timeText = textView4;
    }

    @NonNull
    public static ViewSystemLogEntryBinding bind(@NonNull View view) {
        int i4 = R.id.dateHeader;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.dateHeader);
        if (linearLayout != null) {
            i4 = R.id.dateHeaderBottom;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.dateHeaderBottom);
            if (linearLayout2 != null) {
                i4 = R.id.dateText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dateText);
                if (textView != null) {
                    i4 = R.id.dateTextBottom;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dateTextBottom);
                    if (textView2 != null) {
                        i4 = R.id.logText;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.logText);
                        if (textView3 != null) {
                            i4 = R.id.timeText;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.timeText);
                            if (textView4 != null) {
                                return new ViewSystemLogEntryBinding((LinearLayout) view, linearLayout, linearLayout2, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewSystemLogEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewSystemLogEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_system_log_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11416a;
    }
}
