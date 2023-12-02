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
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ListItemZoneBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11318a;
    @NonNull
    public final MaterialCardView container;
    @NonNull
    public final TextView radiusInfo;
    @NonNull
    public final LinearLayout topBar;
    @NonNull
    public final ImageView zoneImage;
    @NonNull
    public final TextView zoneName;

    private ListItemZoneBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f11318a = materialCardView;
        this.container = materialCardView2;
        this.radiusInfo = textView;
        this.topBar = linearLayout;
        this.zoneImage = imageView;
        this.zoneName = textView2;
    }

    @NonNull
    public static ListItemZoneBinding bind(@NonNull View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        int i4 = R.id.radius_info;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.radius_info);
        if (textView != null) {
            i4 = R.id.top_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.top_bar);
            if (linearLayout != null) {
                i4 = R.id.zone_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.zone_image);
                if (imageView != null) {
                    i4 = R.id.zone_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.zone_name);
                    if (textView2 != null) {
                        return new ListItemZoneBinding(materialCardView, materialCardView, textView, linearLayout, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemZoneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemZoneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_zone, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11318a;
    }
}
