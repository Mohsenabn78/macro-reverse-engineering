package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class HomeTileCustomStopwatchBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11250a;
    @NonNull
    public final IncludeStopwatchTileEntryBinding stopwatch1;
    @NonNull
    public final IncludeStopwatchTileEntryBinding stopwatch2;
    @NonNull
    public final IncludeStopwatchTileEntryBinding stopwatch3;
    @NonNull
    public final IncludeStopwatchTileEntryBinding stopwatch4;

    private HomeTileCustomStopwatchBinding(@NonNull LinearLayout linearLayout, @NonNull IncludeStopwatchTileEntryBinding includeStopwatchTileEntryBinding, @NonNull IncludeStopwatchTileEntryBinding includeStopwatchTileEntryBinding2, @NonNull IncludeStopwatchTileEntryBinding includeStopwatchTileEntryBinding3, @NonNull IncludeStopwatchTileEntryBinding includeStopwatchTileEntryBinding4) {
        this.f11250a = linearLayout;
        this.stopwatch1 = includeStopwatchTileEntryBinding;
        this.stopwatch2 = includeStopwatchTileEntryBinding2;
        this.stopwatch3 = includeStopwatchTileEntryBinding3;
        this.stopwatch4 = includeStopwatchTileEntryBinding4;
    }

    @NonNull
    public static HomeTileCustomStopwatchBinding bind(@NonNull View view) {
        int i4 = R.id.stopwatch1;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.stopwatch1);
        if (findChildViewById != null) {
            IncludeStopwatchTileEntryBinding bind = IncludeStopwatchTileEntryBinding.bind(findChildViewById);
            i4 = R.id.stopwatch2;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.stopwatch2);
            if (findChildViewById2 != null) {
                IncludeStopwatchTileEntryBinding bind2 = IncludeStopwatchTileEntryBinding.bind(findChildViewById2);
                i4 = R.id.stopwatch3;
                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.stopwatch3);
                if (findChildViewById3 != null) {
                    IncludeStopwatchTileEntryBinding bind3 = IncludeStopwatchTileEntryBinding.bind(findChildViewById3);
                    i4 = R.id.stopwatch4;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.stopwatch4);
                    if (findChildViewById4 != null) {
                        return new HomeTileCustomStopwatchBinding((LinearLayout) view, bind, bind2, bind3, IncludeStopwatchTileEntryBinding.bind(findChildViewById4));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static HomeTileCustomStopwatchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static HomeTileCustomStopwatchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.home_tile_custom_stopwatch, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11250a;
    }
}
