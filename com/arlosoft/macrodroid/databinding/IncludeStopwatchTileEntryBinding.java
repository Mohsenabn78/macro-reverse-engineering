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
public final class IncludeStopwatchTileEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11267a;
    @NonNull
    public final TextView stopwatchName;
    @NonNull
    public final TextView stopwatchTime;

    private IncludeStopwatchTileEntryBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11267a = linearLayout;
        this.stopwatchName = textView;
        this.stopwatchTime = textView2;
    }

    @NonNull
    public static IncludeStopwatchTileEntryBinding bind(@NonNull View view) {
        int i4 = R.id.stopwatchName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.stopwatchName);
        if (textView != null) {
            i4 = R.id.stopwatchTime;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.stopwatchTime);
            if (textView2 != null) {
                return new IncludeStopwatchTileEntryBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeStopwatchTileEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeStopwatchTileEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_stopwatch_tile_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11267a;
    }
}
