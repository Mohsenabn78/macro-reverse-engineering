package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityNotificationBarPreferencesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NestedScrollView f10959a;
    @NonNull
    public final InfoCardBinding infoCard;

    private ActivityNotificationBarPreferencesBinding(@NonNull NestedScrollView nestedScrollView, @NonNull InfoCardBinding infoCardBinding) {
        this.f10959a = nestedScrollView;
        this.infoCard = infoCardBinding;
    }

    @NonNull
    public static ActivityNotificationBarPreferencesBinding bind(@NonNull View view) {
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.infoCard);
        if (findChildViewById != null) {
            return new ActivityNotificationBarPreferencesBinding((NestedScrollView) view, InfoCardBinding.bind(findChildViewById));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.infoCard)));
    }

    @NonNull
    public static ActivityNotificationBarPreferencesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityNotificationBarPreferencesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_notification_bar_preferences, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public NestedScrollView getRoot() {
        return this.f10959a;
    }
}
