package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes3.dex */
public final class ListItemCelltowerRecordBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11290a;
    @NonNull
    public final TextView cellTowerId;
    @NonNull
    public final CardView cellTowerRecordCard;
    @NonNull
    public final TextView cellTowerTime;
    @NonNull
    public final FlowLayout flowLayout;
    @NonNull
    public final LinearLayout headerBg;
    @NonNull
    public final TextView ignoredLabel;

    private ListItemCelltowerRecordBinding(@NonNull CardView cardView, @NonNull TextView textView, @NonNull CardView cardView2, @NonNull TextView textView2, @NonNull FlowLayout flowLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView3) {
        this.f11290a = cardView;
        this.cellTowerId = textView;
        this.cellTowerRecordCard = cardView2;
        this.cellTowerTime = textView2;
        this.flowLayout = flowLayout;
        this.headerBg = linearLayout;
        this.ignoredLabel = textView3;
    }

    @NonNull
    public static ListItemCelltowerRecordBinding bind(@NonNull View view) {
        int i4 = R.id.cell_tower_id;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.cell_tower_id);
        if (textView != null) {
            CardView cardView = (CardView) view;
            i4 = R.id.cell_tower_time;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.cell_tower_time);
            if (textView2 != null) {
                i4 = R.id.flow_layout;
                FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, R.id.flow_layout);
                if (flowLayout != null) {
                    i4 = R.id.header_bg;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.header_bg);
                    if (linearLayout != null) {
                        i4 = R.id.ignored_label;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.ignored_label);
                        if (textView3 != null) {
                            return new ListItemCelltowerRecordBinding(cardView, textView, cardView, textView2, flowLayout, linearLayout, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemCelltowerRecordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemCelltowerRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_celltower_record, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11290a;
    }
}
