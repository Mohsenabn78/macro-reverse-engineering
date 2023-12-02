package com.google.android.gms.internal.consent_sdk;

import android.annotation.TargetApi;
import android.webkit.WebView;
import androidx.annotation.GuardedBy;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzce {
    @GuardedBy("WebViewUtil.class")
    private static Boolean zza;

    private zzce() {
    }

    @TargetApi(19)
    public static void zza(WebView webView, String str) {
        boolean booleanValue;
        String str2;
        synchronized (zzce.class) {
            if (zza == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zza = Boolean.TRUE;
                } catch (IllegalStateException unused) {
                    zza = Boolean.FALSE;
                }
            }
            booleanValue = zza.booleanValue();
        }
        if (!booleanValue) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "javascript:".concat(valueOf);
            } else {
                str2 = new String("javascript:");
            }
            webView.loadUrl(str2);
            return;
        }
        webView.evaluateJavascript(str, null);
    }
}
