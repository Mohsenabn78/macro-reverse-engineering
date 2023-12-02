package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzdqf;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfwn;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class TaggingLibraryJsInterface {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19496a;

    /* renamed from: b  reason: collision with root package name */
    private final WebView f19497b;

    /* renamed from: c  reason: collision with root package name */
    private final zzaqs f19498c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19499d;

    /* renamed from: e  reason: collision with root package name */
    private final zzdqf f19500e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19501f;

    /* renamed from: g  reason: collision with root package name */
    private final zzfwn f19502g = zzcae.zze;

    /* renamed from: h  reason: collision with root package name */
    private final zzfgr f19503h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaggingLibraryJsInterface(WebView webView, zzaqs zzaqsVar, zzdqf zzdqfVar, zzfgr zzfgrVar) {
        this.f19497b = webView;
        Context context = webView.getContext();
        this.f19496a = context;
        this.f19498c = zzaqsVar;
        this.f19500e = zzdqfVar;
        zzbbm.zza(context);
        this.f19499d = ((Integer) zzba.zzc().zzb(zzbbm.zziV)).intValue();
        this.f19501f = ((Boolean) zzba.zzc().zzb(zzbbm.zziW)).booleanValue();
        this.f19503h = zzfgrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        boolean z3;
        CookieManager zzb = com.google.android.gms.ads.internal.zzt.zzq().zzb(this.f19496a);
        if (zzb != null) {
            z3 = zzb.acceptThirdPartyCookies(this.f19497b);
        } else {
            z3 = false;
        }
        bundle.putBoolean("accept_3p_cookie", z3);
        Context context = this.f19496a;
        AdFormat adFormat = AdFormat.BANNER;
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        QueryInfo.generate(context, adFormat, builder.build(), queryInfoGenerationCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(String str) {
        Uri parse = Uri.parse(str);
        try {
            parse = this.f19498c.zza(parse, this.f19496a, this.f19497b, null);
        } catch (zzaqt e4) {
            zzbzr.zzf("Failed to append the click signal to URL: ", e4);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "TaggingLibraryJsInterface.recordClick");
        }
        this.f19503h.zzc(parse.toString(), null);
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getClickSignals(String str) {
        try {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            String zze = this.f19498c.zzc().zze(this.f19496a, str, this.f19497b);
            if (this.f19501f) {
                zzf.zzc(this.f19500e, null, "csg", new Pair("clat", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - currentTimeMillis)));
            }
            return zze;
        } catch (RuntimeException e4) {
            zzbzr.zzh("Exception getting click signals. ", e4);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getClickSignalsWithTimeout(final String str, int i4) {
        if (i4 <= 0) {
            zzbzr.zzg("Invalid timeout for getting click signals. Timeout=" + i4);
            return "";
        }
        int min = Math.min(i4, this.f19499d);
        try {
            return (String) zzcae.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaq
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return TaggingLibraryJsInterface.this.getClickSignals(str);
                }
            }).get(min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e4) {
            zzbzr.zzh("Exception getting click signals with timeout. ", e4);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            if (!(e4 instanceof TimeoutException)) {
                return "";
            }
            return "17";
        }
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getQueryInfo() {
        com.google.android.gms.ads.internal.zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        final Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        final zzar zzarVar = new zzar(this, uuid);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziY)).booleanValue()) {
            this.f19502g.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzao
                @Override // java.lang.Runnable
                public final void run() {
                    TaggingLibraryJsInterface.this.b(bundle, zzarVar);
                }
            });
        } else {
            Context context = this.f19496a;
            AdFormat adFormat = AdFormat.BANNER;
            AdRequest.Builder builder = new AdRequest.Builder();
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
            QueryInfo.generate(context, adFormat, builder.build(), zzarVar);
        }
        return uuid;
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getViewSignals() {
        try {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            String zzh = this.f19498c.zzc().zzh(this.f19496a, this.f19497b, null);
            if (this.f19501f) {
                zzf.zzc(this.f19500e, null, "vsg", new Pair("vlat", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - currentTimeMillis)));
            }
            return zzh;
        } catch (RuntimeException e4) {
            zzbzr.zzh("Exception getting view signals. ", e4);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getViewSignalsWithTimeout(int i4) {
        if (i4 <= 0) {
            zzbzr.zzg("Invalid timeout for getting view signals. Timeout=" + i4);
            return "";
        }
        int min = Math.min(i4, this.f19499d);
        try {
            return (String) zzcae.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzap
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return TaggingLibraryJsInterface.this.getViewSignals();
                }
            }).get(min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e4) {
            zzbzr.zzh("Exception getting view signals with timeout. ", e4);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            if (!(e4 instanceof TimeoutException)) {
                return "";
            }
            return "17";
        }
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public void recordClick(final String str) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzja)).booleanValue() && !TextUtils.isEmpty(str)) {
            zzcae.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzan
                @Override // java.lang.Runnable
                public final void run() {
                    TaggingLibraryJsInterface.this.c(str);
                }
            });
        }
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public void reportTouchEvent(String str) {
        int i4;
        int i5;
        int i6;
        float f4;
        int i7;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i4 = jSONObject.getInt("x");
            i5 = jSONObject.getInt("y");
            i6 = jSONObject.getInt("duration_ms");
            f4 = (float) jSONObject.getDouble("force");
            int i8 = jSONObject.getInt("type");
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            i7 = -1;
                        } else {
                            i7 = 3;
                        }
                    } else {
                        i7 = 2;
                    }
                } else {
                    i7 = 1;
                }
            } else {
                i7 = 0;
            }
        } catch (RuntimeException | JSONException e4) {
            e = e4;
        }
        try {
            this.f19498c.zzd(MotionEvent.obtain(0L, i6, i7, i4, i5, f4, 1.0f, 0, 1.0f, 1.0f, 0, 0));
        } catch (RuntimeException e5) {
            e = e5;
            zzbzr.zzh("Failed to parse the touch string. ", e);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "TaggingLibraryJsInterface.reportTouchEvent");
        } catch (JSONException e6) {
            e = e6;
            zzbzr.zzh("Failed to parse the touch string. ", e);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "TaggingLibraryJsInterface.reportTouchEvent");
        }
    }
}
