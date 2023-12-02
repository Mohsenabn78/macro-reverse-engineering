package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class CellTowerListRowBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10995a;
    @NonNull
    public final CheckBox cellTowerListRowCheckbox;
    @NonNull
    public final TextView cellTowerListRowItemCount;
    @NonNull
    public final MaterialCardView cellTowerRow;
    @NonNull
    public final TextView cellidName;

    private CellTowerListRowBinding(@NonNull FrameLayout frameLayout, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull MaterialCardView materialCardView, @NonNull TextView textView2) {
        this.f10995a = frameLayout;
        this.cellTowerListRowCheckbox = checkBox;
        this.cellTowerListRowItemCount = textView;
        this.cellTowerRow = materialCardView;
        this.cellidName = textView2;
    }

    @NonNull
    public static CellTowerListRowBinding bind(@NonNull View view) {
        int i4 = R.id.cell_tower_list_row_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cell_tower_list_row_checkbox);
        if (checkBox != null) {
            i4 = R.id.cell_tower_list_row_item_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.cell_tower_list_row_item_count);
            if (textView != null) {
                i4 = R.id.cell_tower_row;
                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.cell_tower_row);
                if (materialCardView != null) {
                    i4 = R.id.cellid_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.cellid_name);
                    if (textView2 != null) {
                        return new CellTowerListRowBinding((FrameLayout) view, checkBox, textView, materialCardView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static CellTowerListRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellTowerListRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.cell_tower_list_row, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10995a;
    }
}
