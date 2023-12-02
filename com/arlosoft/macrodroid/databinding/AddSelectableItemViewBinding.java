package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class AddSelectableItemViewBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10981a;
    @NonNull
    public final RecyclerView addSelectableItemList;
    @NonNull
    public final FrameLayout contentOverlay;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final RelativeLayout triggerOverlay;

    private AddSelectableItemViewBinding(@NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout2, @NonNull Toolbar toolbar, @NonNull RelativeLayout relativeLayout) {
        this.f10981a = frameLayout;
        this.addSelectableItemList = recyclerView;
        this.contentOverlay = frameLayout2;
        this.toolbar = toolbar;
        this.triggerOverlay = relativeLayout;
    }

    @NonNull
    public static AddSelectableItemViewBinding bind(@NonNull View view) {
        int i4 = R.id.add_selectable_item_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.add_selectable_item_list);
        if (recyclerView != null) {
            i4 = R.id.content_overlay;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.content_overlay);
            if (frameLayout != null) {
                i4 = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    i4 = R.id.triggerOverlay;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.triggerOverlay);
                    if (relativeLayout != null) {
                        return new AddSelectableItemViewBinding((FrameLayout) view, recyclerView, frameLayout, toolbar, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AddSelectableItemViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AddSelectableItemViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.add_selectable_item_view, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10981a;
    }
}
