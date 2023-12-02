package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogAccessibilityInfoBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11015a;

    private DialogAccessibilityInfoBinding(@NonNull ScrollView scrollView) {
        this.f11015a = scrollView;
    }

    @NonNull
    public static DialogAccessibilityInfoBinding bind(@NonNull View view) {
        if (view != null) {
            return new DialogAccessibilityInfoBinding((ScrollView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DialogAccessibilityInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAccessibilityInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_accessibility_info, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11015a;
    }
}
