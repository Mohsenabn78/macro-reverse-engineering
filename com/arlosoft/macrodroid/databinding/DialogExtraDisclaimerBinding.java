package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: classes3.dex */
public final class DialogExtraDisclaimerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11061a;
    @NonNull
    public final Button acceptButton;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button declineButton;
    @NonNull
    public final ScrollView disclaimerScrollView;
    @NonNull
    public final TextView disclaimerText;
    @NonNull
    public final ShapeableImageView extraIcon;
    @NonNull
    public final TextView extraTitle;

    private DialogExtraDisclaimerBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull LinearLayout linearLayout2, @NonNull Button button2, @NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull ShapeableImageView shapeableImageView, @NonNull TextView textView2) {
        this.f11061a = linearLayout;
        this.acceptButton = button;
        this.buttonBar = linearLayout2;
        this.declineButton = button2;
        this.disclaimerScrollView = scrollView;
        this.disclaimerText = textView;
        this.extraIcon = shapeableImageView;
        this.extraTitle = textView2;
    }

    @NonNull
    public static DialogExtraDisclaimerBinding bind(@NonNull View view) {
        int i4 = R.id.acceptButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.acceptButton);
        if (button != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout != null) {
                i4 = R.id.declineButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.declineButton);
                if (button2 != null) {
                    i4 = R.id.disclaimer_scroll_view;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.disclaimer_scroll_view);
                    if (scrollView != null) {
                        i4 = R.id.disclaimer_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.disclaimer_text);
                        if (textView != null) {
                            i4 = R.id.extra_icon;
                            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, R.id.extra_icon);
                            if (shapeableImageView != null) {
                                i4 = R.id.extra_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.extra_title);
                                if (textView2 != null) {
                                    return new DialogExtraDisclaimerBinding((LinearLayout) view, button, linearLayout, button2, scrollView, textView, shapeableImageView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogExtraDisclaimerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogExtraDisclaimerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_extra_disclaimer, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11061a;
    }
}
