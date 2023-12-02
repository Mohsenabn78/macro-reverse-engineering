package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class IncludeRadioParamGroupBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11264a;
    @NonNull
    public final RadioGroup radioGroup;
    @NonNull
    public final TextView title;

    private IncludeRadioParamGroupBinding(@NonNull LinearLayout linearLayout, @NonNull RadioGroup radioGroup, @NonNull TextView textView) {
        this.f11264a = linearLayout;
        this.radioGroup = radioGroup;
        this.title = textView;
    }

    @NonNull
    public static IncludeRadioParamGroupBinding bind(@NonNull View view) {
        int i4 = R.id.radio_group;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.radio_group);
        if (radioGroup != null) {
            i4 = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
            if (textView != null) {
                return new IncludeRadioParamGroupBinding((LinearLayout) view, radioGroup, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeRadioParamGroupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeRadioParamGroupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_radio_param_group, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11264a;
    }
}
