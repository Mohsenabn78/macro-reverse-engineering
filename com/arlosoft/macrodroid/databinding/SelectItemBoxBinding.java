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
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SelectItemBoxBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11356a;
    @NonNull
    public final CardView container;
    @NonNull
    public final FrameLayout selectItemContainer;
    @NonNull
    public final TextView selectItemHeading;
    @NonNull
    public final FrameLayout selectItemHeadingContainer;
    @NonNull
    public final TextView selectItemHelp;
    @NonNull
    public final ImageView selectItemIcon;
    @NonNull
    public final TextView selectItemInfoLabel;
    @NonNull
    public final TextView selectItemName;
    @NonNull
    public final LinearLayout selectItemRowFrame;

    private SelectItemBoxBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout) {
        this.f11356a = cardView;
        this.container = cardView2;
        this.selectItemContainer = frameLayout;
        this.selectItemHeading = textView;
        this.selectItemHeadingContainer = frameLayout2;
        this.selectItemHelp = textView2;
        this.selectItemIcon = imageView;
        this.selectItemInfoLabel = textView3;
        this.selectItemName = textView4;
        this.selectItemRowFrame = linearLayout;
    }

    @NonNull
    public static SelectItemBoxBinding bind(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i4 = R.id.select_item_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.select_item_container);
        if (frameLayout != null) {
            i4 = R.id.select_item_heading;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_heading);
            if (textView != null) {
                i4 = R.id.select_item_heading_container;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.select_item_heading_container);
                if (frameLayout2 != null) {
                    i4 = R.id.select_item_help;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_help);
                    if (textView2 != null) {
                        i4 = R.id.select_item_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.select_item_icon);
                        if (imageView != null) {
                            i4 = R.id.select_item_info_label;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_info_label);
                            if (textView3 != null) {
                                i4 = R.id.select_item_name;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_name);
                                if (textView4 != null) {
                                    i4 = R.id.select_item_row_frame;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.select_item_row_frame);
                                    if (linearLayout != null) {
                                        return new SelectItemBoxBinding(cardView, cardView, frameLayout, textView, frameLayout2, textView2, imageView, textView3, textView4, linearLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SelectItemBoxBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectItemBoxBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.select_item_box, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11356a;
    }
}
