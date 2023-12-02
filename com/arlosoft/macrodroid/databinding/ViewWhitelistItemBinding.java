package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ViewWhitelistItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f11420a;
    @NonNull
    public final TextView ipAddress;

    private ViewWhitelistItemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f11420a = textView;
        this.ipAddress = textView2;
    }

    @NonNull
    public static ViewWhitelistItemBinding bind(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new ViewWhitelistItemBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ViewWhitelistItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewWhitelistItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_whitelist_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public TextView getRoot() {
        return this.f11420a;
    }
}
