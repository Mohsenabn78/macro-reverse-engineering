package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcey extends WebChromeClient {
    private final zzcez zza;

    public zzcey(zzcez zzcezVar) {
        this.zza = zzcezVar;
    }

    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcez)) {
            return webView.getContext();
        }
        zzcez zzcezVar = (zzcez) webView;
        Activity zzi = zzcezVar.zzi();
        if (zzi != null) {
            return zzi;
        }
        return zzcezVar.getContext();
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcez)) {
            zzbzr.zzj("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzl zzL = ((zzcez) webView).zzL();
        if (zzL == null) {
            zzbzr.zzj("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzL.zzb();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i4 = zzcex.zza[consoleMessage.messageLevel().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3 && i4 != 4) {
                    if (i4 != 5) {
                        zzbzr.zzi(str);
                    } else {
                        zzbzr.zze(str);
                    }
                } else {
                    zzbzr.zzi(str);
                }
            } else {
                zzbzr.zzj(str);
            }
        } else {
            zzbzr.zzg(str);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z3, boolean z4, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzH() != null) {
            webView2.setWebViewClient(this.zza.zzH());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j4, long j5, long j6, WebStorage.QuotaUpdater quotaUpdater) {
        long j7 = 5242880 - j6;
        if (j7 <= 0) {
            quotaUpdater.updateQuota(j4);
            return;
        }
        if (j4 == 0) {
            if (j5 > j7 || j5 > 1048576) {
                j5 = 0;
            }
        } else if (j5 == 0) {
            j5 = Math.min(j4 + Math.min((long) PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j7), 1048576L);
        } else {
            if (j5 <= Math.min(1048576 - j4, j7)) {
                j4 += j5;
            }
            j5 = j4;
        }
        quotaUpdater.updateQuota(j5);
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z3;
        if (callback != null) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (!com.google.android.gms.ads.internal.util.zzs.zzw(this.zza.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                com.google.android.gms.ads.internal.zzt.zzp();
                if (!com.google.android.gms.ads.internal.util.zzs.zzw(this.zza.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z3 = false;
                    callback.invoke(str, z3, true);
                }
            }
            z3 = true;
            callback.invoke(str, z3, true);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzl zzL = this.zza.zzL();
        if (zzL == null) {
            zzbzr.zzj("Could not get ad overlay when hiding custom view.");
        } else {
            zzL.zzg();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i4, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzl zzL = this.zza.zzL();
        if (zzL == null) {
            zzbzr.zzj("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzL.zzC(view, customViewCallback);
        zzL.zzA(i4);
    }

    protected final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z3) {
        zzcez zzcezVar;
        com.google.android.gms.ads.internal.zzb zzd;
        try {
            zzcezVar = this.zza;
        } catch (WindowManager.BadTokenException e4) {
            zzbzr.zzk("Fail to display Dialog.", e4);
        }
        if (zzcezVar != null && zzcezVar.zzN() != null && this.zza.zzN().zzd() != null && (zzd = this.zza.zzN().zzd()) != null && !zzd.zzc()) {
            zzd.zzb("window." + str + "('" + str3 + "')");
            return false;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder zzG = com.google.android.gms.ads.internal.util.zzs.zzG(context);
        zzG.setTitle(str2);
        if (z3) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str3);
            EditText editText = new EditText(context);
            editText.setText(str4);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            zzG.setView(linearLayout).setPositiveButton(17039370, new zzcew(jsPromptResult, editText)).setNegativeButton(17039360, new zzcev(jsPromptResult)).setOnCancelListener(new zzceu(jsPromptResult)).create().show();
        } else {
            zzG.setMessage(str3).setPositiveButton(17039370, new zzcet(jsResult)).setNegativeButton(17039360, new zzces(jsResult)).setOnCancelListener(new zzcer(jsResult)).create().show();
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
