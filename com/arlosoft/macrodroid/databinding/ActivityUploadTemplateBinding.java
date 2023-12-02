package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityUploadTemplateBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10975a;
    @NonNull
    public final LinearLayout emptyView;
    @NonNull
    public final ImageView emptyView1;
    @NonNull
    public final TextView macrolistEmptyLabel;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final Toolbar toolbar;

    private ActivityUploadTemplateBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull Toolbar toolbar) {
        this.f10975a = linearLayout;
        this.emptyView = linearLayout2;
        this.emptyView1 = imageView;
        this.macrolistEmptyLabel = textView;
        this.recyclerView = recyclerView;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ActivityUploadTemplateBinding bind(@NonNull View view) {
        int i4 = R.id.emptyView;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
        if (linearLayout != null) {
            i4 = R.id.empty_view;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.empty_view);
            if (imageView != null) {
                i4 = R.id.macrolist_emptyLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.macrolist_emptyLabel);
                if (textView != null) {
                    i4 = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView);
                    if (recyclerView != null) {
                        i4 = R.id.toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                        if (toolbar != null) {
                            return new ActivityUploadTemplateBinding((LinearLayout) view, linearLayout, imageView, textView, recyclerView, toolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityUploadTemplateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityUploadTemplateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_upload_template, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10975a;
    }
}
