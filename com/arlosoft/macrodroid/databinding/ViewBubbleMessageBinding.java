package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ViewBubbleMessageBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f11411a;
    @NonNull
    public final ImageView imageViewShowCase;
    @NonNull
    public final ImageView imageViewShowCaseClose;
    @NonNull
    public final LinearLayout layoutTexts;
    @NonNull
    public final ConstraintLayout showCaseMessageViewLayout;
    @NonNull
    public final TextView textViewShowCaseText;
    @NonNull
    public final TextView textViewShowCaseTitle;

    private ViewBubbleMessageBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11411a = constraintLayout;
        this.imageViewShowCase = imageView;
        this.imageViewShowCaseClose = imageView2;
        this.layoutTexts = linearLayout;
        this.showCaseMessageViewLayout = constraintLayout2;
        this.textViewShowCaseText = textView;
        this.textViewShowCaseTitle = textView2;
    }

    @NonNull
    public static ViewBubbleMessageBinding bind(@NonNull View view) {
        int i4 = R.id.imageViewShowCase;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageViewShowCase);
        if (imageView != null) {
            i4 = R.id.imageViewShowCaseClose;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageViewShowCaseClose);
            if (imageView2 != null) {
                i4 = R.id.layoutTexts;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layoutTexts);
                if (linearLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i4 = R.id.textViewShowCaseText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textViewShowCaseText);
                    if (textView != null) {
                        i4 = R.id.textViewShowCaseTitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textViewShowCaseTitle);
                        if (textView2 != null) {
                            return new ViewBubbleMessageBinding(constraintLayout, imageView, imageView2, linearLayout, constraintLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewBubbleMessageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewBubbleMessageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_bubble_message, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.f11411a;
    }
}
