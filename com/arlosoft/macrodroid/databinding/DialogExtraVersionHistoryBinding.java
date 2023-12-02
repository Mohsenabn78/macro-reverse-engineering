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
public final class DialogExtraVersionHistoryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11062a;
    @NonNull
    public final ShapeableImageView extraIcon;
    @NonNull
    public final TextView extraTitle;
    @NonNull
    public final Button okButton;
    @NonNull
    public final ScrollView versionHistoryScrollView;
    @NonNull
    public final TextView versionHistoryText;

    private DialogExtraVersionHistoryBinding(@NonNull LinearLayout linearLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull TextView textView, @NonNull Button button, @NonNull ScrollView scrollView, @NonNull TextView textView2) {
        this.f11062a = linearLayout;
        this.extraIcon = shapeableImageView;
        this.extraTitle = textView;
        this.okButton = button;
        this.versionHistoryScrollView = scrollView;
        this.versionHistoryText = textView2;
    }

    @NonNull
    public static DialogExtraVersionHistoryBinding bind(@NonNull View view) {
        int i4 = R.id.extra_icon;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, R.id.extra_icon);
        if (shapeableImageView != null) {
            i4 = R.id.extra_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.extra_title);
            if (textView != null) {
                i4 = R.id.ok_button;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.ok_button);
                if (button != null) {
                    i4 = R.id.version_history_scroll_view;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.version_history_scroll_view);
                    if (scrollView != null) {
                        i4 = R.id.version_history_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.version_history_text);
                        if (textView2 != null) {
                            return new DialogExtraVersionHistoryBinding((LinearLayout) view, shapeableImageView, textView, button, scrollView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogExtraVersionHistoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogExtraVersionHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_extra_version_history, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11062a;
    }
}
