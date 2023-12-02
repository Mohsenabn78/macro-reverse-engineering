package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes3.dex */
public final class FragmentBugDetailBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11220a;
    @NonNull
    public final Button continueButton;
    @NonNull
    public final AppCompatEditText descriptionText;
    @NonNull
    public final FlowLayout screenshotsContainer;

    private FragmentBugDetailBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull FlowLayout flowLayout) {
        this.f11220a = linearLayout;
        this.continueButton = button;
        this.descriptionText = appCompatEditText;
        this.screenshotsContainer = flowLayout;
    }

    @NonNull
    public static FragmentBugDetailBinding bind(@NonNull View view) {
        int i4 = R.id.continueButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.continueButton);
        if (button != null) {
            i4 = R.id.description_text;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.description_text);
            if (appCompatEditText != null) {
                i4 = R.id.screenshotsContainer;
                FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, R.id.screenshotsContainer);
                if (flowLayout != null) {
                    return new FragmentBugDetailBinding((LinearLayout) view, button, appCompatEditText, flowLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentBugDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBugDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bug_detail, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11220a;
    }
}
