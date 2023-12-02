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
public final class DialogQuickRunMacroBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11110a;
    @NonNull
    public final ImageView addButton;
    @NonNull
    public final ImageView editButton;
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

    private DialogQuickRunMacroBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout2, @NonNull SquareMinDimensionMaterialCardView squareMinDimensionMaterialCardView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout) {
        this.f11110a = frameLayout;
        this.addButton = imageView;
        this.editButton = imageView2;
        this.emptyText = textView;
        this.icon = imageView3;
        this.macroGrid = recyclerView;
        this.mainContainer = frameLayout2;
        this.tileContainer = squareMinDimensionMaterialCardView;
        this.title = textView2;
        this.topLevelContainer = constraintLayout;
    }

    @NonNull
    public static DialogQuickRunMacroBinding bind(@NonNull View view) {
        int i4 = R.id.addButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.addButton);
        if (imageView != null) {
            i4 = R.id.editButton;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.editButton);
            if (imageView2 != null) {
                i4 = R.id.emptyText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.emptyText);
                if (textView != null) {
                    i4 = R.id.icon;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
                    if (imageView3 != null) {
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
                                        return new DialogQuickRunMacroBinding(frameLayout, imageView, imageView2, textView, imageView3, recyclerView, frameLayout, squareMinDimensionMaterialCardView, textView2, constraintLayout);
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
    public static DialogQuickRunMacroBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogQuickRunMacroBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_quick_run_macro, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11110a;
    }
}
