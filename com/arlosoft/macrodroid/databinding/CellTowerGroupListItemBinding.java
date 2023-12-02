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
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class CellTowerGroupListItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10994a;
    @NonNull
    public final ImageView cellTowerGroupListItemIcon;
    @NonNull
    public final TextView cellTowerGroupListItemName;
    @NonNull
    public final TextView cellTowerGroupListTowersLabel;
    @NonNull
    public final MaterialCardView container;

    private CellTowerGroupListItemBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialCardView materialCardView) {
        this.f10994a = frameLayout;
        this.cellTowerGroupListItemIcon = imageView;
        this.cellTowerGroupListItemName = textView;
        this.cellTowerGroupListTowersLabel = textView2;
        this.container = materialCardView;
    }

    @NonNull
    public static CellTowerGroupListItemBinding bind(@NonNull View view) {
        int i4 = R.id.cell_tower_group_list_item_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.cell_tower_group_list_item_icon);
        if (imageView != null) {
            i4 = R.id.cell_tower_group_list_item_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.cell_tower_group_list_item_name);
            if (textView != null) {
                i4 = R.id.cell_tower_group_list_towers_label;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.cell_tower_group_list_towers_label);
                if (textView2 != null) {
                    i4 = R.id.container;
                    MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.container);
                    if (materialCardView != null) {
                        return new CellTowerGroupListItemBinding((FrameLayout) view, imageView, textView, textView2, materialCardView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static CellTowerGroupListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellTowerGroupListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.cell_tower_group_list_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10994a;
    }
}
