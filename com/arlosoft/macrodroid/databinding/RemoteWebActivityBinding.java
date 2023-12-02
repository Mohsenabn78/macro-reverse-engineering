package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.gms.ads.AdView;

/* loaded from: classes3.dex */
public final class RemoteWebActivityBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11347a;
    @NonNull
    public final View adDivider;
    @NonNull
    public final AdView adView;
    @NonNull
    public final WebView remoteWebView;
    @NonNull
    public final Button retryButton;
    @NonNull
    public final ViewFlipper viewFlipper;

    private RemoteWebActivityBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull AdView adView, @NonNull WebView webView, @NonNull Button button, @NonNull ViewFlipper viewFlipper) {
        this.f11347a = linearLayout;
        this.adDivider = view;
        this.adView = adView;
        this.remoteWebView = webView;
        this.retryButton = button;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static RemoteWebActivityBinding bind(@NonNull View view) {
        int i4 = R.id.adDivider;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.adDivider);
        if (findChildViewById != null) {
            i4 = R.id.adView;
            AdView adView = (AdView) ViewBindings.findChildViewById(view, R.id.adView);
            if (adView != null) {
                i4 = R.id.remote_web_view;
                WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.remote_web_view);
                if (webView != null) {
                    i4 = R.id.retry_button;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.retry_button);
                    if (button != null) {
                        i4 = R.id.view_flipper;
                        ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.view_flipper);
                        if (viewFlipper != null) {
                            return new RemoteWebActivityBinding((LinearLayout) view, findChildViewById, adView, webView, button, viewFlipper);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static RemoteWebActivityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static RemoteWebActivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.remote_web_activity, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11347a;
    }
}
