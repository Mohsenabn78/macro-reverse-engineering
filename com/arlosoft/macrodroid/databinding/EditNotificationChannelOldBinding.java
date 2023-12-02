package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class EditNotificationChannelOldBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f11196a;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final ListView notificationChannelList;

    private EditNotificationChannelOldBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull ListView listView) {
        this.f11196a = coordinatorLayout;
        this.fab = floatingActionButton;
        this.notificationChannelList = listView;
    }

    @NonNull
    public static EditNotificationChannelOldBinding bind(@NonNull View view) {
        int i4 = R.id.fab;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
        if (floatingActionButton != null) {
            i4 = R.id.notificationChannelList;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.notificationChannelList);
            if (listView != null) {
                return new EditNotificationChannelOldBinding((CoordinatorLayout) view, floatingActionButton, listView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EditNotificationChannelOldBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EditNotificationChannelOldBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.edit_notification_channel_old, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f11196a;
    }
}
