package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.IconTextView;

/* loaded from: classes3.dex */
public final class SelectAndroidWearIconListRowBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11350a;
    @NonNull
    public final IconTextView selectAndroidWearIcon1;
    @NonNull
    public final IconTextView selectAndroidWearIcon2;
    @NonNull
    public final IconTextView selectAndroidWearIcon3;
    @NonNull
    public final IconTextView selectAndroidWearIcon4;

    private SelectAndroidWearIconListRowBinding(@NonNull LinearLayout linearLayout, @NonNull IconTextView iconTextView, @NonNull IconTextView iconTextView2, @NonNull IconTextView iconTextView3, @NonNull IconTextView iconTextView4) {
        this.f11350a = linearLayout;
        this.selectAndroidWearIcon1 = iconTextView;
        this.selectAndroidWearIcon2 = iconTextView2;
        this.selectAndroidWearIcon3 = iconTextView3;
        this.selectAndroidWearIcon4 = iconTextView4;
    }

    @NonNull
    public static SelectAndroidWearIconListRowBinding bind(@NonNull View view) {
        int i4 = R.id.select_android_wear_icon_1;
        IconTextView iconTextView = (IconTextView) ViewBindings.findChildViewById(view, R.id.select_android_wear_icon_1);
        if (iconTextView != null) {
            i4 = R.id.select_android_wear_icon_2;
            IconTextView iconTextView2 = (IconTextView) ViewBindings.findChildViewById(view, R.id.select_android_wear_icon_2);
            if (iconTextView2 != null) {
                i4 = R.id.select_android_wear_icon_3;
                IconTextView iconTextView3 = (IconTextView) ViewBindings.findChildViewById(view, R.id.select_android_wear_icon_3);
                if (iconTextView3 != null) {
                    i4 = R.id.select_android_wear_icon_4;
                    IconTextView iconTextView4 = (IconTextView) ViewBindings.findChildViewById(view, R.id.select_android_wear_icon_4);
                    if (iconTextView4 != null) {
                        return new SelectAndroidWearIconListRowBinding((LinearLayout) view, iconTextView, iconTextView2, iconTextView3, iconTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SelectAndroidWearIconListRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectAndroidWearIconListRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.select_android_wear_icon_list_row, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11350a;
    }
}
