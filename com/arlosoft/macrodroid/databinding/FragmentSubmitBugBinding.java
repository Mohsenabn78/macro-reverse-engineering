package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentSubmitBugBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11231a;
    @NonNull
    public final AppCompatEditText emailAddress;
    @NonNull
    public final TextView holidayWarning;
    @NonNull
    public final Button submitBug;

    private FragmentSubmitBugBinding(@NonNull FrameLayout frameLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView, @NonNull Button button) {
        this.f11231a = frameLayout;
        this.emailAddress = appCompatEditText;
        this.holidayWarning = textView;
        this.submitBug = button;
    }

    @NonNull
    public static FragmentSubmitBugBinding bind(@NonNull View view) {
        int i4 = R.id.email_address;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.email_address);
        if (appCompatEditText != null) {
            i4 = R.id.holiday_warning;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.holiday_warning);
            if (textView != null) {
                i4 = R.id.submit_bug;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.submit_bug);
                if (button != null) {
                    return new FragmentSubmitBugBinding((FrameLayout) view, appCompatEditText, textView, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentSubmitBugBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentSubmitBugBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_submit_bug, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11231a;
    }
}
