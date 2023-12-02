package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogEditCommentBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11052a;
    @NonNull
    public final AppCompatEditText commentText;
    @NonNull
    public final TextView title;
    @NonNull
    public final ImageView updateCommentButton;
    @NonNull
    public final LinearLayout uploadingLayout;
    @NonNull
    public final ProgressBar uploadingSpinner;

    private DialogEditCommentBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar) {
        this.f11052a = linearLayout;
        this.commentText = appCompatEditText;
        this.title = textView;
        this.updateCommentButton = imageView;
        this.uploadingLayout = linearLayout2;
        this.uploadingSpinner = progressBar;
    }

    @NonNull
    public static DialogEditCommentBinding bind(@NonNull View view) {
        int i4 = R.id.commentText;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.commentText);
        if (appCompatEditText != null) {
            i4 = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
            if (textView != null) {
                i4 = R.id.updateCommentButton;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.updateCommentButton);
                if (imageView != null) {
                    i4 = R.id.uploadingLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.uploadingLayout);
                    if (linearLayout != null) {
                        i4 = R.id.uploadingSpinner;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.uploadingSpinner);
                        if (progressBar != null) {
                            return new DialogEditCommentBinding((LinearLayout) view, appCompatEditText, textView, imageView, linearLayout, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogEditCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogEditCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_edit_comment, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11052a;
    }
}
