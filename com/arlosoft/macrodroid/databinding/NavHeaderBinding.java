package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class NavHeaderBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11334a;
    @NonNull
    public final TextView headerTitle;
    @NonNull
    public final FrameLayout menuHeaderContainer;
    @NonNull
    public final ImageView menuProfileImage;
    @NonNull
    public final TextView navHeaderVersionInfo;

    private NavHeaderBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f11334a = frameLayout;
        this.headerTitle = textView;
        this.menuHeaderContainer = frameLayout2;
        this.menuProfileImage = imageView;
        this.navHeaderVersionInfo = textView2;
    }

    @NonNull
    public static NavHeaderBinding bind(@NonNull View view) {
        int i4 = R.id.headerTitle;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.headerTitle);
        if (textView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i4 = R.id.menu_profile_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.menu_profile_image);
            if (imageView != null) {
                i4 = R.id.nav_header_version_info;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.nav_header_version_info);
                if (textView2 != null) {
                    return new NavHeaderBinding(frameLayout, textView, frameLayout, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static NavHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static NavHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.nav_header, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11334a;
    }
}
