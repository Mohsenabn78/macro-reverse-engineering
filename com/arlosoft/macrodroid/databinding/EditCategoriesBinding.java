package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class EditCategoriesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f11185a;
    @NonNull
    public final ListView editCategoriesList;
    @NonNull
    public final FloatingActionButton fab;

    private EditCategoriesBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ListView listView, @NonNull FloatingActionButton floatingActionButton) {
        this.f11185a = coordinatorLayout;
        this.editCategoriesList = listView;
        this.fab = floatingActionButton;
    }

    @NonNull
    public static EditCategoriesBinding bind(@NonNull View view) {
        int i4 = R.id.edit_categories_list;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.edit_categories_list);
        if (listView != null) {
            i4 = R.id.fab;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
            if (floatingActionButton != null) {
                return new EditCategoriesBinding((CoordinatorLayout) view, listView, floatingActionButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EditCategoriesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EditCategoriesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.edit_categories, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f11185a;
    }
}
