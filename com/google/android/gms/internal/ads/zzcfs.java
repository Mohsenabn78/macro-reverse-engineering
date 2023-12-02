package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzfmd;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
@SuppressLint({"ViewConstructor"})
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzcfs extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcez {
    public static final /* synthetic */ int zza = 0;
    private boolean zzA;
    private boolean zzB;
    private zzbee zzC;
    private zzbec zzD;
    private zzavn zzE;
    private int zzF;
    private int zzG;
    private zzbcb zzH;
    private final zzbcb zzI;
    private zzbcb zzJ;
    private final zzbcc zzK;
    private int zzL;
    private com.google.android.gms.ads.internal.overlay.zzl zzM;
    private boolean zzN;
    private final com.google.android.gms.ads.internal.util.zzci zzO;
    private int zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    private Map zzT;
    private final WindowManager zzU;
    private final zzawz zzV;
    private final zzcgn zzb;
    private final zzaqs zzc;
    private final zzbco zzd;
    private final zzbzx zze;
    private com.google.android.gms.ads.internal.zzl zzf;
    private final com.google.android.gms.ads.internal.zza zzg;
    private final DisplayMetrics zzh;
    private final float zzi;
    private zzezn zzj;
    private zzezq zzk;
    private boolean zzl;
    private boolean zzm;
    private zzcfg zzn;
    private com.google.android.gms.ads.internal.overlay.zzl zzo;
    private zzfgw zzp;
    private zzcgo zzq;
    private final String zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private Boolean zzw;
    private boolean zzx;
    private final String zzy;
    private zzcfv zzz;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public zzcfs(zzcgn zzcgnVar, zzcgo zzcgoVar, String str, boolean z3, boolean z4, zzaqs zzaqsVar, zzbco zzbcoVar, zzbzx zzbzxVar, zzbce zzbceVar, com.google.android.gms.ads.internal.zzl zzlVar, com.google.android.gms.ads.internal.zza zzaVar, zzawz zzawzVar, zzezn zzeznVar, zzezq zzezqVar) {
        super(zzcgnVar);
        zzezq zzezqVar2;
        this.zzl = false;
        this.zzm = false;
        this.zzx = true;
        this.zzy = "";
        this.zzP = -1;
        this.zzQ = -1;
        this.zzR = -1;
        this.zzS = -1;
        this.zzb = zzcgnVar;
        this.zzq = zzcgoVar;
        this.zzr = str;
        this.zzu = z3;
        this.zzc = zzaqsVar;
        this.zzd = zzbcoVar;
        this.zze = zzbzxVar;
        this.zzf = zzlVar;
        this.zzg = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzU = windowManager;
        com.google.android.gms.ads.internal.zzt.zzp();
        DisplayMetrics zzq = com.google.android.gms.ads.internal.util.zzs.zzq(windowManager);
        this.zzh = zzq;
        this.zzi = zzq.density;
        this.zzV = zzawzVar;
        this.zzj = zzeznVar;
        this.zzk = zzezqVar;
        this.zzO = new com.google.android.gms.ads.internal.util.zzci(zzcgnVar.zza(), this, this, null);
        setBackgroundColor(0);
        final WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e4) {
            zzbzr.zzh("Unable to enable Javascript.", e4);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjX)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzt.zzp().zzc(zzcgnVar, zzbzxVar.zza));
        com.google.android.gms.ads.internal.zzt.zzp();
        final Context context = getContext();
        com.google.android.gms.ads.internal.util.zzcb.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WebSettings webSettings = settings;
                Context context2 = context;
                zzfmd zzfmdVar = zzs.zza;
                webSettings.setDatabasePath(context2.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaH)).booleanValue()) {
                    webSettings.setTextZoom(100);
                }
                webSettings.setAllowContentAccess(false);
                return Boolean.TRUE;
            }
        });
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzaS();
        addJavascriptInterface(new zzcfz(this, new zzcfy(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzba();
        zzbcc zzbccVar = new zzbcc(new zzbce(true, "make_wv", this.zzr));
        this.zzK = zzbccVar;
        zzbccVar.zza().zzc(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && (zzezqVar2 = this.zzk) != null && zzezqVar2.zzb != null) {
            zzbccVar.zza().zzd("gqi", this.zzk.zzb);
        }
        zzbccVar.zza();
        zzbcb zzf = zzbce.zzf();
        this.zzI = zzf;
        zzbccVar.zzb("native:view_create", zzf);
        this.zzJ = null;
        this.zzH = null;
        com.google.android.gms.ads.internal.util.zzce.zza().zzb(zzcgnVar);
        com.google.android.gms.ads.internal.zzt.zzo().zzr();
    }

    private final synchronized void zzaS() {
        zzezn zzeznVar = this.zzj;
        if (zzeznVar != null && zzeznVar.zzan) {
            zzbzr.zze("Disabling hardware acceleration on an overlay.");
            zzaU();
            return;
        }
        if (!this.zzu && !this.zzq.zzi()) {
            zzbzr.zze("Enabling hardware acceleration on an AdView.");
            zzaW();
            return;
        }
        zzbzr.zze("Enabling hardware acceleration on an overlay.");
        zzaW();
    }

    private final synchronized void zzaT() {
        if (!this.zzN) {
            this.zzN = true;
            com.google.android.gms.ads.internal.zzt.zzo().zzq();
        }
    }

    private final synchronized void zzaU() {
        if (!this.zzv) {
            setLayerType(1, null);
        }
        this.zzv = true;
    }

    private final void zzaV(boolean z3) {
        String str;
        HashMap hashMap = new HashMap();
        if (true != z3) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("isVisible", str);
        zzd("onAdVisibilityChanged", hashMap);
    }

    private final synchronized void zzaW() {
        if (this.zzv) {
            setLayerType(0, null);
        }
        this.zzv = false;
    }

    private final synchronized void zzaX(String str) {
        try {
            super.loadUrl("about:blank");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "AdWebViewImpl.loadUrlUnsafe");
            zzbzr.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzaY() {
        zzbbw.zza(this.zzK.zza(), this.zzI, "aeh2");
    }

    private final synchronized void zzaZ() {
        Map map = this.zzT;
        if (map != null) {
            for (zzcdl zzcdlVar : map.values()) {
                zzcdlVar.release();
            }
        }
        this.zzT = null;
    }

    private final void zzba() {
        zzbcc zzbccVar = this.zzK;
        if (zzbccVar == null) {
            return;
        }
        zzbce zza2 = zzbccVar.zza();
        zzbbu zzf = com.google.android.gms.ads.internal.zzt.zzo().zzf();
        if (zzf != null) {
            zzf.zzf(zza2);
        }
    }

    private final synchronized void zzbb() {
        Boolean zzk = com.google.android.gms.ads.internal.zzt.zzo().zzk();
        this.zzw = zzk;
        if (zzk == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaQ(Boolean.TRUE);
            } catch (IllegalStateException unused) {
                zzaQ(Boolean.FALSE);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcez
    public final synchronized void destroy() {
        zzba();
        this.zzO.zza();
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzo;
        if (zzlVar != null) {
            zzlVar.zzb();
            this.zzo.zzm();
            this.zzo = null;
        }
        this.zzp = null;
        this.zzn.zzh();
        this.zzE = null;
        this.zzf = null;
        setOnClickListener(null);
        setOnTouchListener(null);
        if (this.zzt) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzy().zzd(this);
        zzaZ();
        this.zzt = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjt)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Initiating WebView self destruct sequence in 3...");
            com.google.android.gms.ads.internal.util.zze.zza("Loading blank page in WebView, 2...");
            zzaX("about:blank");
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
        zzU();
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(String str, ValueCallback valueCallback) {
        if (zzaz()) {
            zzbzr.zzl("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzt) {
                    this.zzn.zzh();
                    com.google.android.gms.ads.internal.zzt.zzy().zzd(this);
                    zzaZ();
                    zzaT();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcez
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzaz()) {
            super.loadData(str, str2, str3);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcez
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!zzaz()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcez
    public final synchronized void loadUrl(String str) {
        if (!zzaz()) {
            super.loadUrl(str);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcfg zzcfgVar = this.zzn;
        if (zzcfgVar != null) {
            zzcfgVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaz()) {
            this.zzO.zzc();
        }
        boolean z3 = this.zzA;
        zzcfg zzcfgVar = this.zzn;
        if (zzcfgVar != null && zzcfgVar.zzL()) {
            if (!this.zzB) {
                this.zzn.zza();
                this.zzn.zzb();
                this.zzB = true;
            }
            zzaR();
            z3 = true;
        }
        zzaV(z3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzcfg zzcfgVar;
        synchronized (this) {
            if (!zzaz()) {
                this.zzO.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzB && (zzcfgVar = this.zzn) != null && zzcfgVar.zzL() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzn.zza();
                this.zzn.zzb();
                this.zzB = false;
            }
        }
        zzaV(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzs.zzP(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            zzbzr.zze("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (zzaz()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue <= 0.0f || canScrollVertically(-1)) {
                if (axisValue >= 0.0f || canScrollVertically(1)) {
                    if (axisValue2 <= 0.0f || canScrollHorizontally(-1)) {
                        if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zzaR = zzaR();
        com.google.android.gms.ads.internal.overlay.zzl zzL = zzL();
        if (zzL != null && zzaR) {
            zzL.zzn();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01bf A[Catch: all -> 0x01e5, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000d, B:10:0x0013, B:12:0x0017, B:15:0x0021, B:17:0x0029, B:20:0x002e, B:22:0x0036, B:24:0x0048, B:27:0x004d, B:29:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:47:0x008c, B:41:0x007d, B:44:0x0082, B:50:0x0099, B:52:0x00a1, B:54:0x00b3, B:57:0x00b8, B:59:0x00d4, B:61:0x00dd, B:60:0x00d9, B:64:0x00e2, B:66:0x00ea, B:69:0x00f5, B:78:0x011b, B:80:0x0122, B:85:0x012a, B:87:0x013c, B:89:0x014a, B:93:0x0157, B:96:0x015c, B:98:0x01a7, B:99:0x01ab, B:101:0x01b2, B:106:0x01bf, B:108:0x01c5, B:109:0x01c8, B:111:0x01cc, B:112:0x01d5, B:115:0x01e0), top: B:121:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013c A[Catch: all -> 0x01e5, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000d, B:10:0x0013, B:12:0x0017, B:15:0x0021, B:17:0x0029, B:20:0x002e, B:22:0x0036, B:24:0x0048, B:27:0x004d, B:29:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:47:0x008c, B:41:0x007d, B:44:0x0082, B:50:0x0099, B:52:0x00a1, B:54:0x00b3, B:57:0x00b8, B:59:0x00d4, B:61:0x00dd, B:60:0x00d9, B:64:0x00e2, B:66:0x00ea, B:69:0x00f5, B:78:0x011b, B:80:0x0122, B:85:0x012a, B:87:0x013c, B:89:0x014a, B:93:0x0157, B:96:0x015c, B:98:0x01a7, B:99:0x01ab, B:101:0x01b2, B:106:0x01bf, B:108:0x01c5, B:109:0x01c8, B:111:0x01cc, B:112:0x01d5, B:115:0x01e0), top: B:121:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015c A[Catch: all -> 0x01e5, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000d, B:10:0x0013, B:12:0x0017, B:15:0x0021, B:17:0x0029, B:20:0x002e, B:22:0x0036, B:24:0x0048, B:27:0x004d, B:29:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:47:0x008c, B:41:0x007d, B:44:0x0082, B:50:0x0099, B:52:0x00a1, B:54:0x00b3, B:57:0x00b8, B:59:0x00d4, B:61:0x00dd, B:60:0x00d9, B:64:0x00e2, B:66:0x00ea, B:69:0x00f5, B:78:0x011b, B:80:0x0122, B:85:0x012a, B:87:0x013c, B:89:0x014a, B:93:0x0157, B:96:0x015c, B:98:0x01a7, B:99:0x01ab, B:101:0x01b2, B:106:0x01bf, B:108:0x01c5, B:109:0x01c8, B:111:0x01cc, B:112:0x01d5, B:115:0x01e0), top: B:121:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void onMeasure(int r9, int r10) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcez
    public final void onPause() {
        if (zzaz()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e4) {
            zzbzr.zzh("Could not pause webview.", e4);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcez
    public final void onResume() {
        if (zzaz()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e4) {
            zzbzr.zzh("Could not resume webview.", e4);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzn.zzL() && !this.zzn.zzJ()) {
            synchronized (this) {
                zzbee zzbeeVar = this.zzC;
                if (zzbeeVar != null) {
                    zzbeeVar.zzd(motionEvent);
                }
            }
        } else {
            zzaqs zzaqsVar = this.zzc;
            if (zzaqsVar != null) {
                zzaqsVar.zzd(motionEvent);
            }
            zzbco zzbcoVar = this.zzd;
            if (zzbcoVar != null) {
                zzbcoVar.zzb(motionEvent);
            }
        }
        if (zzaz()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcez
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcfg) {
            this.zzn = (zzcfg) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzaz()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e4) {
            zzbzr.zzh("Could not stop loading webview.", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final synchronized void zzA(int i4) {
        this.zzL = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final synchronized void zzC(zzcfv zzcfvVar) {
        if (this.zzz != null) {
            zzbzr.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzz = zzcfvVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzceq
    public final zzezn zzD() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final Context zzE() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final WebViewClient zzH() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcgh
    public final zzaqs zzI() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized zzavn zzJ() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized zzbee zzK() {
        return this.zzC;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized com.google.android.gms.ads.internal.overlay.zzl zzL() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized com.google.android.gms.ads.internal.overlay.zzl zzM() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final /* synthetic */ zzcgm zzN() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcgg
    public final synchronized zzcgo zzO() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcfw
    public final zzezq zzP() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized zzfgw zzQ() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final zzfwm zzR() {
        zzbco zzbcoVar = this.zzd;
        if (zzbcoVar == null) {
            return zzfwc.zzh(null);
        }
        return zzbcoVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized String zzS() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzT(zzezn zzeznVar, zzezq zzezqVar) {
        this.zzj = zzeznVar;
        this.zzk = zzezqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzU() {
        com.google.android.gms.ads.internal.util.zze.zza("Destroying WebView!");
        zzaT();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcfr(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzV() {
        zzaY();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zze.zza);
        zzd("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzW(int i4) {
        if (i4 == 0) {
            zzbbw.zza(this.zzK.zza(), this.zzI, "aebb2");
        }
        zzaY();
        this.zzK.zza();
        this.zzK.zza().zzd("close_type", String.valueOf(i4));
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i4));
        hashMap.put("version", this.zze.zza);
        zzd("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzX() {
        if (this.zzH == null) {
            zzbbw.zza(this.zzK.zza(), this.zzI, "aes2");
            this.zzK.zza();
            zzbcb zzf = zzbce.zzf();
            this.zzH = zzf;
            this.zzK.zzb("native:view_show", zzf);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zze.zza);
        zzd("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzY() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzZ(boolean z3) {
        this.zzn.zzi(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final void zza(String str) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized boolean zzaA() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzaB() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized boolean zzaC() {
        return this.zzx;
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaD(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z3) {
        this.zzn.zzt(zzcVar, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaE(com.google.android.gms.ads.internal.util.zzbr zzbrVar, String str, String str2, int i4) {
        this.zzn.zzu(zzbrVar, str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaF(boolean z3, int i4, boolean z4) {
        this.zzn.zzv(z3, i4, z4);
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaG(boolean z3, int i4, String str, boolean z4) {
        this.zzn.zzx(z3, i4, str, z4);
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaH(boolean z3, int i4, String str, String str2, boolean z4) {
        this.zzn.zzy(z3, i4, str, str2, z4);
    }

    public final zzcfg zzaJ() {
        return this.zzn;
    }

    @VisibleForTesting
    final synchronized Boolean zzaK() {
        return this.zzw;
    }

    protected final synchronized void zzaN(String str, ValueCallback valueCallback) {
        if (!zzaz()) {
            evaluateJavascript(str, null);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaO(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzaK() == null) {
                zzbb();
            }
            if (zzaK().booleanValue()) {
                zzaN(str, null);
                return;
            } else {
                zzaP("javascript:".concat(str));
                return;
            }
        }
        zzaP("javascript:".concat(str));
    }

    protected final synchronized void zzaP(String str) {
        if (!zzaz()) {
            loadUrl(str);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @VisibleForTesting
    final void zzaQ(Boolean bool) {
        synchronized (this) {
            this.zzw = bool;
        }
        com.google.android.gms.ads.internal.zzt.zzo().zzv(bool);
    }

    public final boolean zzaR() {
        int i4;
        int i5;
        boolean z3 = false;
        if (!this.zzn.zzK() && !this.zzn.zzL()) {
            return false;
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics = this.zzh;
        int zzv = zzbzk.zzv(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics2 = this.zzh;
        int zzv2 = zzbzk.zzv(displayMetrics2, displayMetrics2.heightPixels);
        Activity zza2 = this.zzb.zza();
        if (zza2 != null && zza2.getWindow() != null) {
            com.google.android.gms.ads.internal.zzt.zzp();
            int[] zzM = com.google.android.gms.ads.internal.util.zzs.zzM(zza2);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            int zzv3 = zzbzk.zzv(this.zzh, zzM[0]);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            i5 = zzbzk.zzv(this.zzh, zzM[1]);
            i4 = zzv3;
        } else {
            i4 = zzv;
            i5 = zzv2;
        }
        int i6 = this.zzQ;
        if (i6 == zzv && this.zzP == zzv2 && this.zzR == i4 && this.zzS == i5) {
            return false;
        }
        z3 = (i6 == zzv && this.zzP == zzv2) ? true : true;
        this.zzQ = zzv;
        this.zzP = zzv2;
        this.zzR = i4;
        this.zzS = i5;
        new zzbqw(this, "").zzi(zzv, zzv2, i4, i5, this.zzh.density, this.zzU.getDefaultDisplay().getRotation());
        return z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzaa() {
        this.zzO.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzab(String str, String str2, String str3) {
        String str4;
        if (!zzaz()) {
            String[] strArr = new String[1];
            String str5 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzQ);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", str5);
                jSONObject.put("sdk", "Google Mobile Ads");
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "12.4.51-000");
                str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
            } catch (JSONException e4) {
                zzbzr.zzk("Unable to build MRAID_ENV", e4);
                str4 = null;
            }
            strArr[0] = str4;
            super.loadDataWithBaseURL(str, zzcgf.zza(str2, strArr), "text/html", "UTF-8", null);
            return;
        }
        zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzac() {
        if (this.zzJ == null) {
            this.zzK.zza();
            zzbcb zzf = zzbce.zzf();
            this.zzJ = zzf;
            this.zzK.zzb("native:view_load", zzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzad(String str, zzbij zzbijVar) {
        zzcfg zzcfgVar = this.zzn;
        if (zzcfgVar != null) {
            zzcfgVar.zzz(str, zzbijVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzae() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzaf(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zzo = zzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzag(zzcgo zzcgoVar) {
        this.zzq = zzcgoVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzah(zzavn zzavnVar) {
        this.zzE = zzavnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzai(boolean z3) {
        this.zzx = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzaj() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzak(Context context) {
        this.zzb.setBaseContext(context);
        this.zzO.zze(this.zzb.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzal(boolean z3) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzo;
        if (zzlVar != null) {
            zzlVar.zzy(this.zzn.zzK(), z3);
        } else {
            this.zzs = z3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzam(zzbec zzbecVar) {
        this.zzD = zzbecVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzan(boolean z3) {
        String str;
        boolean z4 = this.zzu;
        this.zzu = z3;
        zzaS();
        if (z3 != z4) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzR)).booleanValue() || !this.zzq.zzi()) {
                zzbqw zzbqwVar = new zzbqw(this, "");
                if (true != z3) {
                    str = "default";
                } else {
                    str = "expanded";
                }
                zzbqwVar.zzk(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzao(zzbee zzbeeVar) {
        this.zzC = zzbeeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzap(zzfgw zzfgwVar) {
        this.zzp = zzfgwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzaq(int i4) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzo;
        if (zzlVar != null) {
            zzlVar.zzA(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzar(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zzM = zzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzas(boolean z3) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar;
        int i4 = this.zzF;
        int i5 = 1;
        if (true != z3) {
            i5 = -1;
        }
        int i6 = i4 + i5;
        this.zzF = i6;
        if (i6 <= 0 && (zzlVar = this.zzo) != null) {
            zzlVar.zzE();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized void zzat(boolean z3) {
        if (z3) {
            setBackgroundColor(0);
        }
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzo;
        if (zzlVar != null) {
            zzlVar.zzB(z3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzau(String str, zzbij zzbijVar) {
        zzcfg zzcfgVar = this.zzn;
        if (zzcfgVar != null) {
            zzcfgVar.zzH(str, zzbijVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzav(String str, Predicate predicate) {
        zzcfg zzcfgVar = this.zzn;
        if (zzcfgVar != null) {
            zzcfgVar.zzI(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized boolean zzaw() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized boolean zzax() {
        if (this.zzF > 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzay(final boolean z3, final int i4) {
        destroy();
        this.zzV.zzb(new zzawy() { // from class: com.google.android.gms.internal.ads.zzcfp
            @Override // com.google.android.gms.internal.ads.zzawy
            public final void zza(zzayo zzayoVar) {
                boolean z4 = z3;
                int i5 = i4;
                int i6 = zzcfs.zza;
                zzbat zza2 = zzbau.zza();
                if (zza2.zzc() != z4) {
                    zza2.zza(z4);
                }
                zza2.zzb(i5);
                zzayoVar.zzj((zzbau) zza2.zzal());
            }
        });
        this.zzV.zzc(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final synchronized boolean zzaz() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final void zzb(String str, String str2) {
        zzaO(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final synchronized void zzbj() {
        com.google.android.gms.ads.internal.zzl zzlVar = this.zzf;
        if (zzlVar != null) {
            zzlVar.zzbj();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final synchronized void zzbk() {
        com.google.android.gms.ads.internal.zzl zzlVar = this.zzf;
        if (zzlVar != null) {
            zzlVar.zzbk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final synchronized String zzbl() {
        zzezq zzezqVar = this.zzk;
        if (zzezqVar != null) {
            return zzezqVar.zzb;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final synchronized String zzbm() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzc(zzatz zzatzVar) {
        boolean z3;
        synchronized (this) {
            z3 = zzatzVar.zzj;
            this.zzA = z3;
        }
        zzaV(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final void zzd(String str, Map map) {
        try {
            zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzbzr.zzj("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zzbzr.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzaO(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final synchronized int zzf() {
        return this.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final int zzg() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final int zzh() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcga, com.google.android.gms.internal.ads.zzcca
    public final Activity zzi() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final zzbcb zzk() {
        return this.zzI;
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final void zzl(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final zzbcc zzm() {
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcgi, com.google.android.gms.internal.ads.zzcca
    public final zzbzx zzn() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final zzcbp zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final synchronized zzcdl zzp(String str) {
        Map map = this.zzT;
        if (map == null) {
            return null;
        }
        return (zzcdl) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final synchronized zzcfv zzq() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzr() {
        zzcfg zzcfgVar = this.zzn;
        if (zzcfgVar != null) {
            zzcfgVar.zzr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzs() {
        zzcfg zzcfgVar = this.zzn;
        if (zzcfgVar != null) {
            zzcfgVar.zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final synchronized void zzt(String str, zzcdl zzcdlVar) {
        if (this.zzT == null) {
            this.zzT = new HashMap();
        }
        this.zzT.put(str, zzcdlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzu() {
        com.google.android.gms.ads.internal.overlay.zzl zzL = zzL();
        if (zzL != null) {
            zzL.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzv(boolean z3, long j4) {
        String str;
        HashMap hashMap = new HashMap(2);
        if (true != z3) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, str);
        hashMap.put("duration", Long.toString(j4));
        zzd("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final synchronized void zzw() {
        zzbec zzbecVar = this.zzD;
        if (zzbecVar != null) {
            final zzdky zzdkyVar = (zzdky) zzbecVar;
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdkw
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdky.this.zzd();
                    } catch (RemoteException e4) {
                        zzbzr.zzl("#007 Could not call remote method.", e4);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzz(boolean z3) {
        this.zzn.zzC(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcgj
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final WebView zzG() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzB(int i4) {
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzx(int i4) {
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzy(int i4) {
    }
}
