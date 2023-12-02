package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SelectIconBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11353a;
    @NonNull
    public final Button addUserIconButton;
    @NonNull
    public final ProgressBar progressSpinner;
    @NonNull
    public final RecyclerView selectIconList;

    private SelectIconBinding(@NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView) {
        this.f11353a = frameLayout;
        this.addUserIconButton = button;
        this.progressSpinner = progressBar;
        this.selectIconList = recyclerView;
    }

    @NonNull
    public static SelectIconBinding bind(@NonNull View view) {
        int i4 = R.id.add_user_icon_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.add_user_icon_button);
        if (button != null) {
            i4 = R.id.progress_spinner;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_spinner);
            if (progressBar != null) {
                i4 = R.id.select_icon_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.select_icon_list);
                if (recyclerView != null) {
                    return new SelectIconBinding((FrameLayout) view, button, progressBar, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SelectIconBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectIconBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.select_icon, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11353a;
    }
}
