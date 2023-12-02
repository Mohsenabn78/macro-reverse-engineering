package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityTemplateSearchBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10970a;
    @NonNull
    public final FrameLayout loadingBlocker;
    @NonNull
    public final FrameLayout templateListContainer;
    @NonNull
    public final Toolbar toolbar;

    private ActivityTemplateSearchBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull Toolbar toolbar) {
        this.f10970a = linearLayout;
        this.loadingBlocker = frameLayout;
        this.templateListContainer = frameLayout2;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ActivityTemplateSearchBinding bind(@NonNull View view) {
        int i4 = R.id.loadingBlocker;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingBlocker);
        if (frameLayout != null) {
            i4 = R.id.templateListContainer;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.templateListContainer);
            if (frameLayout2 != null) {
                i4 = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    return new ActivityTemplateSearchBinding((LinearLayout) view, frameLayout, frameLayout2, toolbar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityTemplateSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTemplateSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_template_search, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10970a;
    }
}
