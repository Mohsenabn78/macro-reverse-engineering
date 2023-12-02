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
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public final class HomeTileCustomTemplateBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11251a;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final TextView userName;

    private HomeTileCustomTemplateBinding(@NonNull LinearLayout linearLayout, @NonNull AvatarView avatarView, @NonNull TextView textView) {
        this.f11251a = linearLayout;
        this.avatarImage = avatarView;
        this.userName = textView;
    }

    @NonNull
    public static HomeTileCustomTemplateBinding bind(@NonNull View view) {
        int i4 = R.id.avatarImage;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
        if (avatarView != null) {
            i4 = R.id.userName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.userName);
            if (textView != null) {
                return new HomeTileCustomTemplateBinding((LinearLayout) view, avatarView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static HomeTileCustomTemplateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static HomeTileCustomTemplateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.home_tile_custom_template, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11251a;
    }
}
