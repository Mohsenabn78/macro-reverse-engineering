package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogSubmitPluginBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11135a;
    @NonNull
    public final TextInputEditText apkDownloadLink;
    @NonNull
    public final TextInputLayout apkDownloadLinkLayout;
    @NonNull
    public final ImageView appIcon;
    @NonNull
    public final TextView appName;
    @NonNull
    public final TextInputLayout descriptionInputLayout;
    @NonNull
    public final TextInputEditText descriptionText;
    @NonNull
    public final TextView packageName;

    private DialogSubmitPluginBinding(@NonNull LinearLayout linearLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputEditText textInputEditText2, @NonNull TextView textView2) {
        this.f11135a = linearLayout;
        this.apkDownloadLink = textInputEditText;
        this.apkDownloadLinkLayout = textInputLayout;
        this.appIcon = imageView;
        this.appName = textView;
        this.descriptionInputLayout = textInputLayout2;
        this.descriptionText = textInputEditText2;
        this.packageName = textView2;
    }

    @NonNull
    public static DialogSubmitPluginBinding bind(@NonNull View view) {
        int i4 = R.id.apkDownloadLink;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.apkDownloadLink);
        if (textInputEditText != null) {
            i4 = R.id.apkDownloadLinkLayout;
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.apkDownloadLinkLayout);
            if (textInputLayout != null) {
                i4 = R.id.appIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.appIcon);
                if (imageView != null) {
                    i4 = R.id.appName;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.appName);
                    if (textView != null) {
                        i4 = R.id.descriptionInputLayout;
                        TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.descriptionInputLayout);
                        if (textInputLayout2 != null) {
                            i4 = R.id.descriptionText;
                            TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.descriptionText);
                            if (textInputEditText2 != null) {
                                i4 = R.id.packageName;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.packageName);
                                if (textView2 != null) {
                                    return new DialogSubmitPluginBinding((LinearLayout) view, textInputEditText, textInputLayout, imageView, textView, textInputLayout2, textInputEditText2, textView2);
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
    public static DialogSubmitPluginBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSubmitPluginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_submit_plugin, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11135a;
    }
}
