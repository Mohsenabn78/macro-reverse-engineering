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
public final class ListItemCategoryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11289a;
    @NonNull
    public final TextView categoryName;
    @NonNull
    public final ImageView lockImage;

    private ListItemCategoryBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f11289a = linearLayout;
        this.categoryName = textView;
        this.lockImage = imageView;
    }

    @NonNull
    public static ListItemCategoryBinding bind(@NonNull View view) {
        int i4 = R.id.categoryName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.categoryName);
        if (textView != null) {
            i4 = R.id.lockImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.lockImage);
            if (imageView != null) {
                return new ListItemCategoryBinding((LinearLayout) view, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_category, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11289a;
    }
}
