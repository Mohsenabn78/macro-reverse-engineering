package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.WebView;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbzr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzar extends QueryInfoGenerationCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f19551a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaggingLibraryJsInterface f19552b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.f19552b = taggingLibraryJsInterface;
        this.f19551a = str;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        WebView webView;
        zzbzr.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        String format = String.format("window.postMessage({'paw_id': '%1$s', 'error': '%2$s'}, '*');", this.f19551a, str);
        webView = this.f19552b.f19497b;
        webView.evaluateJavascript(format, null);
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        String format;
        WebView webView;
        String query = queryInfo.getQuery();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.f19551a);
            jSONObject.put("signal", query);
            format = String.format("window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            format = String.format("window.postMessage({'paw_id': '%1$s', 'signal': '%2$s'}, '*');", this.f19551a, queryInfo.getQuery());
        }
        webView = this.f19552b.f19497b;
        webView.evaluateJavascript(format, null);
    }
}
