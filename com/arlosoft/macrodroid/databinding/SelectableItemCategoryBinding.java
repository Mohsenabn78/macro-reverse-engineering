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

/* loaded from: classes3.dex */
public final class SelectableItemCategoryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11360a;
    @NonNull
    public final LinearLayout background;
    @NonNull
    public final LinearLayout categoryContainer;
    @NonNull
    public final TextView categoryName;
    @NonNull
    public final View dividerBottom;
    @NonNull
    public final View dividerTop;
    @NonNull
    public final ImageView icon;

    private SelectableItemCategoryBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull View view, @NonNull View view2, @NonNull ImageView imageView) {
        this.f11360a = linearLayout;
        this.background = linearLayout2;
        this.categoryContainer = linearLayout3;
        this.categoryName = textView;
        this.dividerBottom = view;
        this.dividerTop = view2;
        this.icon = imageView;
    }

    @NonNull
    public static SelectableItemCategoryBinding bind(@NonNull View view) {
        int i4 = R.id.background;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.background);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view;
            i4 = R.id.category_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.category_name);
            if (textView != null) {
                i4 = R.id.divider_bottom;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.divider_bottom);
                if (findChildViewById != null) {
                    i4 = R.id.divider_top;
                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.divider_top);
                    if (findChildViewById2 != null) {
                        i4 = R.id.icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
                        if (imageView != null) {
                            return new SelectableItemCategoryBinding(linearLayout2, linearLayout, linearLayout2, textView, findChildViewById, findChildViewById2, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SelectableItemCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectableItemCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.selectable_item_category, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11360a;
    }
}
