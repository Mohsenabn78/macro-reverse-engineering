package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes3.dex */
public final class ListItemStopwatchBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11311a;
    @NonNull
    public final ImageView clearButton;
    @NonNull
    public final ImageView playPauseButton;
    @NonNull
    public final CardView stopwatchContainer;
    @NonNull
    public final ImageView stopwatchIcon;
    @NonNull
    public final FlowLayout stopwatchMacroList;
    @NonNull
    public final TextView stopwatchName;
    @NonNull
    public final TextView stopwatchTime;

    private ListItemStopwatchBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull CardView cardView2, @NonNull ImageView imageView3, @NonNull FlowLayout flowLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11311a = cardView;
        this.clearButton = imageView;
        this.playPauseButton = imageView2;
        this.stopwatchContainer = cardView2;
        this.stopwatchIcon = imageView3;
        this.stopwatchMacroList = flowLayout;
        this.stopwatchName = textView;
        this.stopwatchTime = textView2;
    }

    @NonNull
    public static ListItemStopwatchBinding bind(@NonNull View view) {
        int i4 = R.id.clear_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.clear_button);
        if (imageView != null) {
            i4 = R.id.play_pause_button;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.play_pause_button);
            if (imageView2 != null) {
                CardView cardView = (CardView) view;
                i4 = R.id.stopwatch_icon;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.stopwatch_icon);
                if (imageView3 != null) {
                    i4 = R.id.stopwatch_macro_list;
                    FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, R.id.stopwatch_macro_list);
                    if (flowLayout != null) {
                        i4 = R.id.stopwatch_name;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.stopwatch_name);
                        if (textView != null) {
                            i4 = R.id.stopwatch_time;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.stopwatch_time);
                            if (textView2 != null) {
                                return new ListItemStopwatchBinding(cardView, imageView, imageView2, cardView, imageView3, flowLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemStopwatchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemStopwatchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_stopwatch, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11311a;
    }
}
