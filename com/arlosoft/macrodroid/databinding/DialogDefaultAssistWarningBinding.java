package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogDefaultAssistWarningBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11045a;
    @NonNull
    public final TextView alreadyConfiguredText;

    private DialogDefaultAssistWarningBinding(@NonNull ScrollView scrollView, @NonNull TextView textView) {
        this.f11045a = scrollView;
        this.alreadyConfiguredText = textView;
    }

    @NonNull
    public static DialogDefaultAssistWarningBinding bind(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.alreadyConfiguredText);
        if (textView != null) {
            return new DialogDefaultAssistWarningBinding((ScrollView) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.alreadyConfiguredText)));
    }

    @NonNull
    public static DialogDefaultAssistWarningBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogDefaultAssistWarningBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_default_assist_warning, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11045a;
    }
}
