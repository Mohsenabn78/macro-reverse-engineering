package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class TwitterwebviewBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11396a;
    @NonNull
    public final WebView webview;

    private TwitterwebviewBinding(@NonNull LinearLayout linearLayout, @NonNull WebView webView) {
        this.f11396a = linearLayout;
        this.webview = webView;
    }

    @NonNull
    public static TwitterwebviewBinding bind(@NonNull View view) {
        WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.webview);
        if (webView != null) {
            return new TwitterwebviewBinding((LinearLayout) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.webview)));
    }

    @NonNull
    public static TwitterwebviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TwitterwebviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.twitterwebview, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11396a;
    }
}
