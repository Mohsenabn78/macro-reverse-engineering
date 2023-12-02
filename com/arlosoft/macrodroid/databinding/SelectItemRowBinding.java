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

/* loaded from: classes3.dex */
public final class SelectItemRowBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11358a;
    @NonNull
    public final FrameLayout selectItemContainer;
    @NonNull
    public final TextView selectItemExperimentalLabel1;
    @NonNull
    public final TextView selectItemHeading;
    @NonNull
    public final FrameLayout selectItemHeadingContainer;
    @NonNull
    public final TextView selectItemHelp;
    @NonNull
    public final ImageView selectItemIcon;
    @NonNull
    public final View selectItemIconBackground;
    @NonNull
    public final TextView selectItemInfoLabel;
    @NonNull
    public final TextView selectItemName;
    @NonNull
    public final LinearLayout selectItemRowFrame;

    private SelectItemRowBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull View view, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull LinearLayout linearLayout2) {
        this.f11358a = linearLayout;
        this.selectItemContainer = frameLayout;
        this.selectItemExperimentalLabel1 = textView;
        this.selectItemHeading = textView2;
        this.selectItemHeadingContainer = frameLayout2;
        this.selectItemHelp = textView3;
        this.selectItemIcon = imageView;
        this.selectItemIconBackground = view;
        this.selectItemInfoLabel = textView4;
        this.selectItemName = textView5;
        this.selectItemRowFrame = linearLayout2;
    }

    @NonNull
    public static SelectItemRowBinding bind(@NonNull View view) {
        int i4 = R.id.select_item_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.select_item_container);
        if (frameLayout != null) {
            i4 = R.id.select_item_experimental_label_1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_experimental_label_1);
            if (textView != null) {
                i4 = R.id.select_item_heading;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_heading);
                if (textView2 != null) {
                    i4 = R.id.select_item_heading_container;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.select_item_heading_container);
                    if (frameLayout2 != null) {
                        i4 = R.id.select_item_help;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_help);
                        if (textView3 != null) {
                            i4 = R.id.select_item_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.select_item_icon);
                            if (imageView != null) {
                                i4 = R.id.select_item_icon_background;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.select_item_icon_background);
                                if (findChildViewById != null) {
                                    i4 = R.id.select_item_info_label;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_info_label);
                                    if (textView4 != null) {
                                        i4 = R.id.select_item_name;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.select_item_name);
                                        if (textView5 != null) {
                                            LinearLayout linearLayout = (LinearLayout) view;
                                            return new SelectItemRowBinding(linearLayout, frameLayout, textView, textView2, frameLayout2, textView3, imageView, findChildViewById, textView4, textView5, linearLayout);
                                        }
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
    public static SelectItemRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectItemRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.select_item_row, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11358a;
    }
}
