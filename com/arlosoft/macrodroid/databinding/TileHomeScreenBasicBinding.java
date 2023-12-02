package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class TileHomeScreenBasicBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11389a;
    @NonNull
    public final LinearLayout clickableContainer;
    @NonNull
    public final FrameLayout customContent;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final MaterialCardView tileContainer;
    @NonNull
    public final TextView title;

    private TileHomeScreenBasicBinding(@NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView) {
        this.f11389a = materialCardView;
        this.clickableContainer = linearLayout;
        this.customContent = frameLayout;
        this.icon = imageView;
        this.tileContainer = materialCardView2;
        this.title = textView;
    }

    @NonNull
    public static TileHomeScreenBasicBinding bind(@NonNull View view) {
        int i4 = R.id.clickableContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.clickableContainer);
        if (linearLayout != null) {
            i4 = R.id.customContent;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.customContent);
            if (frameLayout != null) {
                i4 = R.id.icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
                if (imageView != null) {
                    MaterialCardView materialCardView = (MaterialCardView) view;
                    i4 = R.id.title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (textView != null) {
                        return new TileHomeScreenBasicBinding(materialCardView, linearLayout, frameLayout, imageView, materialCardView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static TileHomeScreenBasicBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TileHomeScreenBasicBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.tile_home_screen_basic, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11389a;
    }
}
