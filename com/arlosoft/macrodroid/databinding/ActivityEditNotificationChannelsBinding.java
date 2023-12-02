package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ActivityEditNotificationChannelsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10940a;
    @NonNull
    public final FloatingActionButton addChannelFab;
    @NonNull
    public final TextView celltowersEmptyText;
    @NonNull
    public final FrameLayout emptyView;
    @NonNull
    public final RecyclerView recyclerView;

    private ActivityEditNotificationChannelsBinding(@NonNull FrameLayout frameLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull RecyclerView recyclerView) {
        this.f10940a = frameLayout;
        this.addChannelFab = floatingActionButton;
        this.celltowersEmptyText = textView;
        this.emptyView = frameLayout2;
        this.recyclerView = recyclerView;
    }

    @NonNull
    public static ActivityEditNotificationChannelsBinding bind(@NonNull View view) {
        int i4 = R.id.addChannelFab;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.addChannelFab);
        if (floatingActionButton != null) {
            i4 = R.id.celltowers_empty_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.celltowers_empty_text);
            if (textView != null) {
                i4 = R.id.emptyView;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
                if (frameLayout != null) {
                    i4 = R.id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
                    if (recyclerView != null) {
                        return new ActivityEditNotificationChannelsBinding((FrameLayout) view, floatingActionButton, textView, frameLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityEditNotificationChannelsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityEditNotificationChannelsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_edit_notification_channels, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10940a;
    }
}
