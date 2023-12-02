package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DrawerItemStopwatchBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11182a;
    @NonNull
    public final ImageView clearButton;
    @NonNull
    public final ImageView dragHandle;
    @NonNull
    public final ImageView playPauseButton;
    @NonNull
    public final TextView stopwatchName;
    @NonNull
    public final TextView stopwatchTime;

    private DrawerItemStopwatchBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11182a = linearLayout;
        this.clearButton = imageView;
        this.dragHandle = imageView2;
        this.playPauseButton = imageView3;
        this.stopwatchName = textView;
        this.stopwatchTime = textView2;
    }

    @NonNull
    public static DrawerItemStopwatchBinding bind(@NonNull View view) {
        int i4 = R.id.clear_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.clear_button);
        if (imageView != null) {
            i4 = R.id.drag_handle;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.drag_handle);
            if (imageView2 != null) {
                i4 = R.id.play_pause_button;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.play_pause_button);
                if (imageView3 != null) {
                    i4 = R.id.stopwatch_name;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.stopwatch_name);
                    if (textView != null) {
                        i4 = R.id.stopwatch_time;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.stopwatch_time);
                        if (textView2 != null) {
                            return new DrawerItemStopwatchBinding((LinearLayout) view, imageView, imageView2, imageView3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DrawerItemStopwatchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DrawerItemStopwatchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.drawer_item_stopwatch, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11182a;
    }
}
