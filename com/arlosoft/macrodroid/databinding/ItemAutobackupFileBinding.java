package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ItemAutobackupFileBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11275a;
    @NonNull
    public final ImageView cellTowerGroupListItemIcon;
    @NonNull
    public final MaterialCardView container;
    @NonNull
    public final TextView fileName;
    @NonNull
    public final TextView infoLabel;

    private ItemAutobackupFileBinding(@NonNull MaterialCardView materialCardView, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11275a = materialCardView;
        this.cellTowerGroupListItemIcon = imageView;
        this.container = materialCardView2;
        this.fileName = textView;
        this.infoLabel = textView2;
    }

    @NonNull
    public static ItemAutobackupFileBinding bind(@NonNull View view) {
        int i4 = R.id.cell_tower_group_list_item_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.cell_tower_group_list_item_icon);
        if (imageView != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            i4 = R.id.fileName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.fileName);
            if (textView != null) {
                i4 = R.id.infoLabel;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.infoLabel);
                if (textView2 != null) {
                    return new ItemAutobackupFileBinding(materialCardView, imageView, materialCardView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ItemAutobackupFileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemAutobackupFileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.item_autobackup_file, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11275a;
    }
}
