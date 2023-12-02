package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.SquareMinDimensionMaterialCardView;

/* loaded from: classes3.dex */
public final class DialogFavouritesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11064a;
    @NonNull
    public final TextView emptyText;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final RecyclerView macroGrid;
    @NonNull
    public final FrameLayout mainContainer;
    @NonNull
    public final SquareMinDimensionMaterialCardView tileContainer;
    @NonNull
    public final TextView title;
    @NonNull
    public final ConstraintLayout topLevelContainer;

    private DialogFavouritesBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout2, @NonNull SquareMinDimensionMaterialCardView squareMinDimensionMaterialCardView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout) {
        this.f11064a = frameLayout;
        this.emptyText = textView;
        this.icon = imageView;
        this.macroGrid = recyclerView;
        this.mainContainer = frameLayout2;
        this.tileContainer = squareMinDimensionMaterialCardView;
        this.title = textView2;
        this.topLevelContainer = constraintLayout;
    }

    @NonNull
    public static DialogFavouritesBinding bind(@NonNull View view) {
        int i4 = R.id.emptyText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.emptyText);
        if (textView != null) {
            i4 = R.id.icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
            if (imageView != null) {
                i4 = R.id.macroGrid;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.macroGrid);
                if (recyclerView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i4 = R.id.tileContainer;
                    SquareMinDimensionMaterialCardView squareMinDimensionMaterialCardView = (SquareMinDimensionMaterialCardView) ViewBindings.findChildViewById(view, R.id.tileContainer);
                    if (squareMinDimensionMaterialCardView != null) {
                        i4 = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                        if (textView2 != null) {
                            i4 = R.id.topLevelContainer;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.topLevelContainer);
                            if (constraintLayout != null) {
                                return new DialogFavouritesBinding(frameLayout, textView, imageView, recyclerView, frameLayout, squareMinDimensionMaterialCardView, textView2, constraintLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogFavouritesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogFavouritesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_favourites, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11064a;
    }
}
