package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SelectIconAndroidWearBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11352a;
    @NonNull
    public final View colorSelector;
    @NonNull
    public final ListView selectIconList;

    private SelectIconAndroidWearBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull ListView listView) {
        this.f11352a = linearLayout;
        this.colorSelector = view;
        this.selectIconList = listView;
    }

    @NonNull
    public static SelectIconAndroidWearBinding bind(@NonNull View view) {
        int i4 = R.id.colorSelector;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.colorSelector);
        if (findChildViewById != null) {
            i4 = R.id.select_icon_list;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.select_icon_list);
            if (listView != null) {
                return new SelectIconAndroidWearBinding((LinearLayout) view, findChildViewById, listView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SelectIconAndroidWearBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectIconAndroidWearBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.select_icon_android_wear, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11352a;
    }
}
