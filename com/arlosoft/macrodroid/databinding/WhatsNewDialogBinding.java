package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class WhatsNewDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11426a;
    @NonNull
    public final FrameLayout loadingBlocker;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView titleText;
    @NonNull
    public final ScrollView whatsNewDialogScrollView;
    @NonNull
    public final TextView whatsNewText;

    private WhatsNewDialogBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull TextView textView, @NonNull ScrollView scrollView, @NonNull TextView textView2) {
        this.f11426a = linearLayout;
        this.loadingBlocker = frameLayout;
        this.okButton = button;
        this.titleText = textView;
        this.whatsNewDialogScrollView = scrollView;
        this.whatsNewText = textView2;
    }

    @NonNull
    public static WhatsNewDialogBinding bind(@NonNull View view) {
        int i4 = R.id.loadingBlocker;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingBlocker);
        if (frameLayout != null) {
            i4 = R.id.okButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
            if (button != null) {
                i4 = R.id.titleText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.titleText);
                if (textView != null) {
                    i4 = R.id.whats_new_dialog_scroll_view;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.whats_new_dialog_scroll_view);
                    if (scrollView != null) {
                        i4 = R.id.whatsNewText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.whatsNewText);
                        if (textView2 != null) {
                            return new WhatsNewDialogBinding((LinearLayout) view, frameLayout, button, textView, scrollView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static WhatsNewDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WhatsNewDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.whats_new_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11426a;
    }
}
