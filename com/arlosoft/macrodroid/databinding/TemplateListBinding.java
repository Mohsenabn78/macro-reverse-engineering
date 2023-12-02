package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class TemplateListBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11387a;
    @NonNull
    public final ListView templateListList;
    @NonNull
    public final ViewFlipper templateListViewflipper;

    private TemplateListBinding(@NonNull LinearLayout linearLayout, @NonNull ListView listView, @NonNull ViewFlipper viewFlipper) {
        this.f11387a = linearLayout;
        this.templateListList = listView;
        this.templateListViewflipper = viewFlipper;
    }

    @NonNull
    public static TemplateListBinding bind(@NonNull View view) {
        int i4 = R.id.template_list_list;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.template_list_list);
        if (listView != null) {
            i4 = R.id.template_list_viewflipper;
            ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.template_list_viewflipper);
            if (viewFlipper != null) {
                return new TemplateListBinding((LinearLayout) view, listView, viewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static TemplateListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TemplateListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.template_list, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11387a;
    }
}
