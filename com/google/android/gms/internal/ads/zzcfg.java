package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
@VisibleForTesting(otherwise = 3)
/* loaded from: classes4.dex */
public class zzcfg extends WebViewClient implements zzcgm {
    public static final /* synthetic */ int zzb = 0;
    @Nullable
    private final zzebl zzB;
    private View.OnAttachStateChangeListener zzC;
    @Nullable
    protected zzbws zza;
    private final zzcez zzc;
    @Nullable
    private final zzawz zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzo zzh;
    private zzcgk zzi;
    private zzcgl zzj;
    private zzbhc zzk;
    private zzbhe zzl;
    private zzdcu zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private com.google.android.gms.ads.internal.overlay.zzz zzs;
    @Nullable
    private zzbqv zzt;
    private com.google.android.gms.ads.internal.zzb zzu;
    private boolean zzw;
    private boolean zzx;
    private int zzy;
    private boolean zzz;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private zzbqq zzv = null;
    private final HashSet zzA = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfr)).split(",")));

    @VisibleForTesting
    public zzcfg(zzcez zzcezVar, @Nullable zzawz zzawzVar, boolean z3, zzbqv zzbqvVar, @Nullable zzbqq zzbqqVar, @Nullable zzebl zzeblVar) {
        this.zzd = zzawzVar;
        this.zzc = zzcezVar;
        this.zzp = z3;
        this.zzt = zzbqvVar;
        this.zzB = zzeblVar;
    }

    @Nullable
    private static WebResourceResponse zzN() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaG)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    @Nullable
    private final WebResourceResponse zzO(String str, Map map) throws IOException {
        HttpURLConnection httpURLConnection;
        String trim;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i4 = 0;
            while (true) {
                i4++;
                if (i4 <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry entry : map.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        com.google.android.gms.ads.internal.zzt.zzp().zzf(this.zzc.getContext(), this.zzc.zzn().zza, false, httpURLConnection, false, 60000);
                        zzbzq zzbzqVar = new zzbzq(null);
                        zzbzqVar.zzc(httpURLConnection, null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzbzqVar.zze(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            break;
                        }
                        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                        if (headerField != null) {
                            if (headerField.startsWith("tel:")) {
                                return null;
                            }
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzbzr.zzj("Protocol is null");
                                return zzN();
                            } else if (!protocol.equals("http") && !protocol.equals(ProxyConfig.MATCH_HTTPS)) {
                                zzbzr.zzj("Unsupported scheme: " + protocol);
                                return zzN();
                            } else {
                                zzbzr.zze("Redirecting to " + headerField);
                                httpURLConnection.disconnect();
                                url = url2;
                            }
                        } else {
                            throw new IOException("Missing Location header in redirect");
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.zzt.zzp();
            String contentType = httpURLConnection.getContentType();
            String str2 = "";
            if (TextUtils.isEmpty(contentType)) {
                trim = "";
            } else {
                trim = contentType.split(";")[0].trim();
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            String contentType2 = httpURLConnection.getContentType();
            if (!TextUtils.isEmpty(contentType2)) {
                String[] split = contentType2.split(";");
                if (split.length != 1) {
                    int i5 = 1;
                    while (true) {
                        if (i5 >= split.length) {
                            break;
                        }
                        if (split[i5].trim().startsWith("charset")) {
                            String[] split2 = split[i5].trim().split("=");
                            if (split2.length > 1) {
                                str2 = split2[1].trim();
                                break;
                            }
                        }
                        i5++;
                    }
                }
            }
            String str3 = str2;
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            HashMap hashMap = new HashMap(headerFields.size());
            for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                if (entry2.getKey() != null && entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                    hashMap.put(entry2.getKey(), entry2.getValue().get(0));
                }
            }
            return com.google.android.gms.ads.internal.zzt.zzq().zzc(trim, str3, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzP(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                com.google.android.gms.ads.internal.util.zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbij) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzQ() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzC;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzR(final View view, final zzbws zzbwsVar, final int i4) {
        if (zzbwsVar.zzi() && i4 > 0) {
            zzbwsVar.zzg(view);
            if (zzbwsVar.zzi()) {
                com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfc
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcfg.this.zzo(view, zzbwsVar, i4);
                    }
                }, 100L);
            }
        }
    }

    private static final boolean zzS(zzcez zzcezVar) {
        if (zzcezVar.zzD() != null) {
            return zzcezVar.zzD().zzaj;
        }
        return false;
    }

    private static final boolean zzT(boolean z3, zzcez zzcezVar) {
        if (z3 && !zzcezVar.zzO().zzi() && !zzcezVar.zzS().equals("interstitial_mb")) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzf) {
            if (this.zzc.zzaz()) {
                com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                this.zzc.zzU();
                return;
            }
            this.zzw = true;
            zzcgl zzcglVar = this.zzj;
            if (zzcglVar != null) {
                zzcglVar.zza();
                this.zzj = null;
            }
            zzg();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i4, String str, String str2) {
        this.zzo = true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean didCrash;
        int rendererPriorityAtExit;
        zzcez zzcezVar = this.zzc;
        didCrash = renderProcessGoneDetail.didCrash();
        rendererPriorityAtExit = renderProcessGoneDetail.rendererPriorityAtExit();
        return zzcezVar.zzay(didCrash, rendererPriorityAtExit);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        } else {
            if (this.zzn && webView == this.zzc.zzG()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || ProxyConfig.MATCH_HTTPS.equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzbws zzbwsVar = this.zza;
                        if (zzbwsVar != null) {
                            zzbwsVar.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzdcu zzdcuVar = this.zzm;
                    if (zzdcuVar != null) {
                        zzdcuVar.zzr();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzc.zzG().willNotDraw()) {
                try {
                    zzaqs zzI = this.zzc.zzI();
                    if (zzI != null && zzI.zzf(parse)) {
                        Context context = this.zzc.getContext();
                        zzcez zzcezVar = this.zzc;
                        parse = zzI.zza(parse, context, (View) zzcezVar, zzcezVar.zzi());
                    }
                } catch (zzaqt unused) {
                    zzbzr.zzj("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzu;
                if (zzbVar != null && !zzbVar.zzc()) {
                    this.zzu.zzb(str);
                } else {
                    zzt(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", parse.toString(), null, null, null, null, null, null), true);
                }
            } else {
                zzbzr.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzA(zzcgk zzcgkVar) {
        this.zzi = zzcgkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzB(int i4, int i5) {
        zzbqq zzbqqVar = this.zzv;
        if (zzbqqVar != null) {
            zzbqqVar.zzd(i4, i5);
        }
    }

    public final void zzC(boolean z3) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzD(boolean z3) {
        synchronized (this.zzf) {
            this.zzr = z3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzE() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzp = true;
            zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfb
                @Override // java.lang.Runnable
                public final void run() {
                    zzcfg.this.zzn();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzF(boolean z3) {
        synchronized (this.zzf) {
            this.zzq = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzG(zzcgl zzcglVar) {
        this.zzj = zzcglVar;
    }

    public final void zzH(String str, zzbij zzbijVar) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzbijVar);
        }
    }

    public final void zzI(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbij> list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzbij zzbijVar : list) {
                if (predicate.apply(zzbijVar)) {
                    arrayList.add(zzbijVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final boolean zzJ() {
        boolean z3;
        synchronized (this.zzf) {
            z3 = this.zzr;
        }
        return z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final boolean zzK() {
        boolean z3;
        synchronized (this.zzf) {
            z3 = this.zzp;
        }
        return z3;
    }

    public final boolean zzL() {
        boolean z3;
        synchronized (this.zzf) {
            z3 = this.zzq;
        }
        return z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzM(@Nullable com.google.android.gms.ads.internal.client.zza zzaVar, @Nullable zzbhc zzbhcVar, @Nullable com.google.android.gms.ads.internal.overlay.zzo zzoVar, @Nullable zzbhe zzbheVar, @Nullable com.google.android.gms.ads.internal.overlay.zzz zzzVar, boolean z3, @Nullable zzbil zzbilVar, @Nullable com.google.android.gms.ads.internal.zzb zzbVar, @Nullable zzbqx zzbqxVar, @Nullable zzbws zzbwsVar, @Nullable final zzeba zzebaVar, @Nullable final zzfgr zzfgrVar, @Nullable zzdqa zzdqaVar, @Nullable zzfev zzfevVar, @Nullable zzbjb zzbjbVar, @Nullable final zzdcu zzdcuVar, @Nullable zzbja zzbjaVar, @Nullable zzbiu zzbiuVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zzc.getContext(), zzbwsVar, null) : zzbVar;
        this.zzv = new zzbqq(this.zzc, zzbqxVar);
        this.zza = zzbwsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaO)).booleanValue()) {
            zzz("/adMetadata", new zzbhb(zzbhcVar));
        }
        if (zzbheVar != null) {
            zzz("/appEvent", new zzbhd(zzbheVar));
        }
        zzz("/backButton", zzbii.zzj);
        zzz("/refresh", zzbii.zzk);
        zzz("/canOpenApp", zzbii.zzb);
        zzz("/canOpenURLs", zzbii.zza);
        zzz("/canOpenIntents", zzbii.zzc);
        zzz("/close", zzbii.zzd);
        zzz("/customClose", zzbii.zze);
        zzz("/instrument", zzbii.zzn);
        zzz("/delayPageLoaded", zzbii.zzp);
        zzz("/delayPageClosed", zzbii.zzq);
        zzz("/getLocationInfo", zzbii.zzr);
        zzz("/log", zzbii.zzg);
        zzz("/mraid", new zzbip(zzbVar2, this.zzv, zzbqxVar));
        zzbqv zzbqvVar = this.zzt;
        if (zzbqvVar != null) {
            zzz("/mraidLoaded", zzbqvVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzz("/open", new zzbit(zzbVar2, this.zzv, zzebaVar, zzdqaVar, zzfevVar));
        zzz("/precache", new zzcdm());
        zzz("/touch", zzbii.zzi);
        zzz("/video", zzbii.zzl);
        zzz("/videoMeta", zzbii.zzm);
        if (zzebaVar != null && zzfgrVar != null) {
            zzz("/click", new zzbij() { // from class: com.google.android.gms.internal.ads.zzfap
                @Override // com.google.android.gms.internal.ads.zzbij
                public final void zza(Object obj, Map map) {
                    zzdcu zzdcuVar2 = zzdcu.this;
                    zzfgr zzfgrVar2 = zzfgrVar;
                    zzeba zzebaVar2 = zzebaVar;
                    zzcez zzcezVar = (zzcez) obj;
                    zzbii.zzc(map, zzdcuVar2);
                    String str = (String) map.get("u");
                    if (str == null) {
                        zzbzr.zzj("URL missing from click GMSG.");
                    } else {
                        zzfwc.zzq(zzbii.zza(zzcezVar, str), new zzfaq(zzcezVar, zzfgrVar2, zzebaVar2), zzcae.zza);
                    }
                }
            });
            zzz("/httpTrack", new zzbij() { // from class: com.google.android.gms.internal.ads.zzfao
                @Override // com.google.android.gms.internal.ads.zzbij
                public final void zza(Object obj, Map map) {
                    zzfgr zzfgrVar2 = zzfgr.this;
                    zzeba zzebaVar2 = zzebaVar;
                    zzceq zzceqVar = (zzceq) obj;
                    String str = (String) map.get("u");
                    if (str == null) {
                        zzbzr.zzj("URL missing from httpTrack GMSG.");
                    } else if (!zzceqVar.zzD().zzaj) {
                        zzfgrVar2.zzc(str, null);
                    } else {
                        zzebaVar2.zzd(new zzebc(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), ((zzcfw) zzceqVar).zzP().zzb, str, 2));
                    }
                }
            });
        } else {
            zzz("/click", new zzbhk(zzdcuVar));
            zzz("/httpTrack", zzbii.zzf);
        }
        if (com.google.android.gms.ads.internal.zzt.zzn().zzu(this.zzc.getContext())) {
            zzz("/logScionEvent", new zzbio(this.zzc.getContext()));
        }
        if (zzbilVar != null) {
            zzz("/setInterstitialProperties", new zzbik(zzbilVar));
        }
        if (zzbjbVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
                zzz("/inspectorNetworkExtras", zzbjbVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziN)).booleanValue() && zzbjaVar != null) {
            zzz("/shareSheet", zzbjaVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziQ)).booleanValue() && zzbiuVar != null) {
            zzz("/inspectorOutOfContextTest", zzbiuVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjR)).booleanValue()) {
            zzz("/bindPlayStoreOverlay", zzbii.zzu);
            zzz("/presentPlayStoreOverlay", zzbii.zzv);
            zzz("/expandPlayStoreOverlay", zzbii.zzw);
            zzz("/collapsePlayStoreOverlay", zzbii.zzx);
            zzz("/closePlayStoreOverlay", zzbii.zzy);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcR)).booleanValue()) {
                zzz("/setPAIDPersonalizationEnabled", zzbii.zzA);
                zzz("/resetPAID", zzbii.zzz);
            }
        }
        this.zzg = zzaVar;
        this.zzh = zzoVar;
        this.zzk = zzbhcVar;
        this.zzl = zzbheVar;
        this.zzs = zzzVar;
        this.zzu = zzbVar3;
        this.zzm = zzdcuVar;
        this.zzn = z3;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zzc(String str, Map map) {
        zzawi zzb2;
        try {
            String zzc = zzbxy.zzc(str, this.zzc.getContext(), this.zzz);
            if (!zzc.equals(str)) {
                return zzO(zzc, map);
            }
            zzawl zza = zzawl.zza(Uri.parse(str));
            if (zza != null && (zzb2 = com.google.android.gms.ads.internal.zzt.zzc().zzb(zza)) != null && zzb2.zze()) {
                return new WebResourceResponse("", "", zzb2.zzc());
            }
            if (zzbzq.zzk() && ((Boolean) zzbdb.zzb.zze()).booleanValue()) {
                return zzO(str, map);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e4) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "AdWebViewClient.interceptRequest");
            return zzN();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final com.google.android.gms.ads.internal.zzb zzd() {
        return this.zzu;
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzw && this.zzy <= 0) || this.zzx || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && this.zzc.zzm() != null) {
                zzbbw.zza(this.zzc.zzm().zza(), this.zzc.zzk(), "awfllc");
            }
            zzcgk zzcgkVar = this.zzi;
            boolean z3 = false;
            if (!this.zzx && !this.zzo) {
                z3 = true;
            }
            zzcgkVar.zza(z3);
            this.zzi = null;
        }
        this.zzc.zzac();
    }

    public final void zzh() {
        zzbws zzbwsVar = this.zza;
        if (zzbwsVar != null) {
            zzbwsVar.zze();
            this.zza = null;
        }
        zzQ();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzp = false;
            this.zzq = false;
            this.zzs = null;
            this.zzu = null;
            this.zzt = null;
            zzbqq zzbqqVar = this.zzv;
            if (zzbqqVar != null) {
                zzbqqVar.zza(true);
                this.zzv = null;
            }
        }
    }

    public final void zzi(boolean z3) {
        this.zzz = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzj(Uri uri) {
        final String str;
        String path = uri.getPath();
        List list = (List) this.zze.get(path);
        if (path != null && list != null) {
            String encodedQuery = uri.getEncodedQuery();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfq)).booleanValue() && this.zzA.contains(path) && encodedQuery != null) {
                if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfs)).intValue()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                    zzfwc.zzq(com.google.android.gms.ads.internal.zzt.zzp().zzb(uri), new zzcfe(this, list, path, uri), zzcae.zze);
                    return;
                }
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            zzP(com.google.android.gms.ads.internal.util.zzs.zzL(uri), list, path);
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgz)).booleanValue() && com.google.android.gms.ads.internal.zzt.zzo().zzf() != null) {
            if (path != null && path.length() >= 2) {
                str = path.substring(1);
            } else {
                str = "null";
            }
            zzcae.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfa
                @Override // java.lang.Runnable
                public final void run() {
                    String str2 = str;
                    int i4 = zzcfg.zzb;
                    com.google.android.gms.ads.internal.zzt.zzo().zzf().zze(str2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzk() {
        zzawz zzawzVar = this.zzd;
        if (zzawzVar != null) {
            zzawzVar.zzc(10005);
        }
        this.zzx = true;
        zzg();
        this.zzc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzl() {
        synchronized (this.zzf) {
        }
        this.zzy++;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzm() {
        this.zzy--;
        zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn() {
        this.zzc.zzaa();
        com.google.android.gms.ads.internal.overlay.zzl zzL = this.zzc.zzL();
        if (zzL != null) {
            zzL.zzz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(View view, zzbws zzbwsVar, int i4) {
        zzR(view, zzbwsVar, i4 - 1);
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzp(int i4, int i5, boolean z3) {
        zzbqv zzbqvVar = this.zzt;
        if (zzbqvVar != null) {
            zzbqvVar.zzb(i4, i5);
        }
        zzbqq zzbqqVar = this.zzv;
        if (zzbqqVar != null) {
            zzbqqVar.zzc(i4, i5, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgm
    public final void zzq() {
        zzbws zzbwsVar = this.zza;
        if (zzbwsVar != null) {
            WebView zzG = this.zzc.zzG();
            if (ViewCompat.isAttachedToWindow(zzG)) {
                zzR(zzG, zzbwsVar, 10);
                return;
            }
            zzQ();
            zzcfd zzcfdVar = new zzcfd(this, zzbwsVar);
            this.zzC = zzcfdVar;
            ((View) this.zzc).addOnAttachStateChangeListener(zzcfdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzr() {
        zzdcu zzdcuVar = this.zzm;
        if (zzdcuVar != null) {
            zzdcuVar.zzr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzs() {
        zzdcu zzdcuVar = this.zzm;
        if (zzdcuVar != null) {
            zzdcuVar.zzs();
        }
    }

    public final void zzt(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z3) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        com.google.android.gms.ads.internal.overlay.zzo zzoVar;
        zzdcu zzdcuVar;
        boolean zzaA = this.zzc.zzaA();
        boolean zzT = zzT(zzaA, this.zzc);
        boolean z4 = true;
        if (!zzT && z3) {
            z4 = false;
        }
        if (zzT) {
            zzaVar = null;
        } else {
            zzaVar = this.zzg;
        }
        if (zzaA) {
            zzoVar = null;
        } else {
            zzoVar = this.zzh;
        }
        com.google.android.gms.ads.internal.overlay.zzz zzzVar = this.zzs;
        zzbzx zzn = this.zzc.zzn();
        zzcez zzcezVar = this.zzc;
        if (z4) {
            zzdcuVar = null;
        } else {
            zzdcuVar = this.zzm;
        }
        zzw(new AdOverlayInfoParcel(zzcVar, zzaVar, zzoVar, zzzVar, zzn, zzcezVar, zzdcuVar));
    }

    public final void zzu(com.google.android.gms.ads.internal.util.zzbr zzbrVar, String str, String str2, int i4) {
        zzcez zzcezVar = this.zzc;
        zzw(new AdOverlayInfoParcel(zzcezVar, zzcezVar.zzn(), zzbrVar, str, str2, 14, this.zzB));
    }

    public final void zzv(boolean z3, int i4, boolean z4) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzdcu zzdcuVar;
        zzebl zzeblVar;
        boolean zzT = zzT(this.zzc.zzaA(), this.zzc);
        boolean z5 = true;
        if (!zzT && z4) {
            z5 = false;
        }
        if (zzT) {
            zzaVar = null;
        } else {
            zzaVar = this.zzg;
        }
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.zzh;
        com.google.android.gms.ads.internal.overlay.zzz zzzVar = this.zzs;
        zzcez zzcezVar = this.zzc;
        zzbzx zzn = zzcezVar.zzn();
        if (z5) {
            zzdcuVar = null;
        } else {
            zzdcuVar = this.zzm;
        }
        if (zzS(this.zzc)) {
            zzeblVar = this.zzB;
        } else {
            zzeblVar = null;
        }
        zzw(new AdOverlayInfoParcel(zzaVar, zzoVar, zzzVar, zzcezVar, z3, i4, zzn, zzdcuVar, zzeblVar));
    }

    public final void zzw(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z3;
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbqq zzbqqVar = this.zzv;
        if (zzbqqVar != null) {
            z3 = zzbqqVar.zze();
        } else {
            z3 = false;
        }
        com.google.android.gms.ads.internal.zzt.zzi();
        com.google.android.gms.ads.internal.overlay.zzm.zza(this.zzc.getContext(), adOverlayInfoParcel, !z3);
        zzbws zzbwsVar = this.zza;
        if (zzbwsVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzbwsVar.zzh(str);
        }
    }

    public final void zzx(boolean z3, int i4, String str, boolean z4) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzcff zzcffVar;
        zzdcu zzdcuVar;
        zzebl zzeblVar;
        boolean zzaA = this.zzc.zzaA();
        boolean zzT = zzT(zzaA, this.zzc);
        boolean z5 = true;
        if (!zzT && z4) {
            z5 = false;
        }
        if (zzT) {
            zzaVar = null;
        } else {
            zzaVar = this.zzg;
        }
        if (zzaA) {
            zzcffVar = null;
        } else {
            zzcffVar = new zzcff(this.zzc, this.zzh);
        }
        zzbhc zzbhcVar = this.zzk;
        zzbhe zzbheVar = this.zzl;
        com.google.android.gms.ads.internal.overlay.zzz zzzVar = this.zzs;
        zzcez zzcezVar = this.zzc;
        zzbzx zzn = zzcezVar.zzn();
        if (z5) {
            zzdcuVar = null;
        } else {
            zzdcuVar = this.zzm;
        }
        if (zzS(this.zzc)) {
            zzeblVar = this.zzB;
        } else {
            zzeblVar = null;
        }
        zzw(new AdOverlayInfoParcel(zzaVar, zzcffVar, zzbhcVar, zzbheVar, zzzVar, zzcezVar, z3, i4, str, zzn, zzdcuVar, zzeblVar));
    }

    public final void zzy(boolean z3, int i4, String str, String str2, boolean z4) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzcff zzcffVar;
        zzdcu zzdcuVar;
        zzebl zzeblVar;
        boolean zzaA = this.zzc.zzaA();
        boolean zzT = zzT(zzaA, this.zzc);
        boolean z5 = true;
        if (!zzT && z4) {
            z5 = false;
        }
        if (zzT) {
            zzaVar = null;
        } else {
            zzaVar = this.zzg;
        }
        if (zzaA) {
            zzcffVar = null;
        } else {
            zzcffVar = new zzcff(this.zzc, this.zzh);
        }
        zzbhc zzbhcVar = this.zzk;
        zzbhe zzbheVar = this.zzl;
        com.google.android.gms.ads.internal.overlay.zzz zzzVar = this.zzs;
        zzcez zzcezVar = this.zzc;
        zzbzx zzn = zzcezVar.zzn();
        if (z5) {
            zzdcuVar = null;
        } else {
            zzdcuVar = this.zzm;
        }
        if (zzS(this.zzc)) {
            zzeblVar = this.zzB;
        } else {
            zzeblVar = null;
        }
        zzw(new AdOverlayInfoParcel(zzaVar, zzcffVar, zzbhcVar, zzbheVar, zzzVar, zzcezVar, z3, i4, str, str2, zzn, zzdcuVar, zzeblVar));
    }

    public final void zzz(String str, zzbij zzbijVar) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zze.put(str, list);
            }
            list.add(zzbijVar);
        }
    }
}
