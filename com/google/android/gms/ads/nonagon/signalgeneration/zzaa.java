package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbcy;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbyf;
import com.google.android.gms.internal.ads.zzbyh;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcgu;
import com.google.android.gms.internal.ads.zzcuo;
import com.google.android.gms.internal.ads.zzdar;
import com.google.android.gms.internal.ads.zzdlx;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import com.google.android.gms.internal.ads.zzfag;
import com.google.android.gms.internal.ads.zzfbe;
import com.google.android.gms.internal.ads.zzffm;
import com.google.android.gms.internal.ads.zzffn;
import com.google.android.gms.internal.ads.zzffy;
import com.google.android.gms.internal.ads.zzfgb;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfov;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzfvi;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfvt;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import com.google.android.gms.internal.ads.zzfwn;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaa extends zzbyh {
    protected static final List C = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    protected static final List D = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List E = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    protected static final List F = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public static final /* synthetic */ int zze = 0;
    private final List A;
    private final List B;

    /* renamed from: a  reason: collision with root package name */
    private final zzcgu f19504a;

    /* renamed from: b  reason: collision with root package name */
    private Context f19505b;

    /* renamed from: c  reason: collision with root package name */
    private final zzaqs f19506c;

    /* renamed from: d  reason: collision with root package name */
    private final zzfbe f19507d;

    /* renamed from: f  reason: collision with root package name */
    private final zzfwn f19509f;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledExecutorService f19510g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private zzbsr f19511h;

    /* renamed from: l  reason: collision with root package name */
    private final zzc f19515l;

    /* renamed from: m  reason: collision with root package name */
    private final zzdqf f19516m;

    /* renamed from: n  reason: collision with root package name */
    private final zzfgr f19517n;

    /* renamed from: v  reason: collision with root package name */
    private final zzbzx f19525v;

    /* renamed from: w  reason: collision with root package name */
    private String f19526w;

    /* renamed from: y  reason: collision with root package name */
    private final List f19528y;

    /* renamed from: z  reason: collision with root package name */
    private final List f19529z;

    /* renamed from: e  reason: collision with root package name */
    private zzdpv f19508e = null;

    /* renamed from: i  reason: collision with root package name */
    private Point f19512i = new Point();

    /* renamed from: j  reason: collision with root package name */
    private Point f19513j = new Point();

    /* renamed from: k  reason: collision with root package name */
    private final Set f19514k = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: u  reason: collision with root package name */
    private final AtomicInteger f19524u = new AtomicInteger(0);

    /* renamed from: o  reason: collision with root package name */
    private final boolean f19518o = ((Boolean) zzba.zzc().zzb(zzbbm.zzgZ)).booleanValue();

    /* renamed from: p  reason: collision with root package name */
    private final boolean f19519p = ((Boolean) zzba.zzc().zzb(zzbbm.zzgY)).booleanValue();

    /* renamed from: q  reason: collision with root package name */
    private final boolean f19520q = ((Boolean) zzba.zzc().zzb(zzbbm.zzha)).booleanValue();

    /* renamed from: r  reason: collision with root package name */
    private final boolean f19521r = ((Boolean) zzba.zzc().zzb(zzbbm.zzhc)).booleanValue();

    /* renamed from: s  reason: collision with root package name */
    private final String f19522s = (String) zzba.zzc().zzb(zzbbm.zzhb);

    /* renamed from: t  reason: collision with root package name */
    private final String f19523t = (String) zzba.zzc().zzb(zzbbm.zzhd);

    /* renamed from: x  reason: collision with root package name */
    private final String f19527x = (String) zzba.zzc().zzb(zzbbm.zzhe);

    public zzaa(zzcgu zzcguVar, Context context, zzaqs zzaqsVar, zzfbe zzfbeVar, zzfwn zzfwnVar, ScheduledExecutorService scheduledExecutorService, zzdqf zzdqfVar, zzfgr zzfgrVar, zzbzx zzbzxVar) {
        List list;
        this.f19504a = zzcguVar;
        this.f19505b = context;
        this.f19506c = zzaqsVar;
        this.f19507d = zzfbeVar;
        this.f19509f = zzfwnVar;
        this.f19510g = scheduledExecutorService;
        this.f19515l = zzcguVar.zzm();
        this.f19516m = zzdqfVar;
        this.f19517n = zzfgrVar;
        this.f19525v = zzbzxVar;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhf)).booleanValue()) {
            this.f19528y = x((String) zzba.zzc().zzb(zzbbm.zzhg));
            this.f19529z = x((String) zzba.zzc().zzb(zzbbm.zzhh));
            this.A = x((String) zzba.zzc().zzb(zzbbm.zzhi));
            list = x((String) zzba.zzc().zzb(zzbbm.zzhj));
        } else {
            this.f19528y = C;
            this.f19529z = D;
            this.A = E;
            list = F;
        }
        this.B = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzffy F(zzfwm zzfwmVar, zzbym zzbymVar) {
        String str;
        if (!zzfgb.zza() || !((Boolean) zzbcy.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzffy zzb = ((zzh) zzfwc.zzo(zzfwmVar)).zzb();
            zzb.zzd(new ArrayList(Collections.singletonList(zzbymVar.zzb)));
            com.google.android.gms.ads.internal.client.zzl zzlVar = zzbymVar.zzd;
            if (zzlVar == null) {
                str = "";
            } else {
                str = zzlVar.zzp;
            }
            zzb.zzb(str);
            return zzb;
        } catch (ExecutionException e4) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void f(zzaa zzaaVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzaaVar.n((Uri) it.next())) {
                zzaaVar.f19524u.getAndIncrement();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void g(final zzaa zzaaVar, final String str, final String str2, final zzdpv zzdpvVar) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgK)).booleanValue()) {
            return;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgQ)).booleanValue()) {
            zzcae.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzi
                @Override // java.lang.Runnable
                public final void run() {
                    zzaa.this.i(str, str2, zzdpvVar);
                }
            });
        } else {
            zzaaVar.f19515l.zzd(str, str2, zzdpvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Uri p(Uri uri, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w(uri, "nas", str);
        }
        return uri;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final zzh q(Context context, String str, String str2, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        char c4;
        zzfag zzfagVar = new zzfag();
        if ("REWARDED".equals(str2)) {
            zzfagVar.zzo().zza(2);
        } else if ("REWARDED_INTERSTITIAL".equals(str2)) {
            zzfagVar.zzo().zza(3);
        }
        zzg zzn = this.f19504a.zzn();
        zzcuo zzcuoVar = new zzcuo();
        zzcuoVar.zze(context);
        if (str == null) {
            str = "adUnitId";
        }
        zzfagVar.zzs(str);
        if (zzlVar == null) {
            zzlVar = new com.google.android.gms.ads.internal.client.zzm().zza();
        }
        zzfagVar.zzE(zzlVar);
        if (zzqVar == null) {
            switch (str2.hashCode()) {
                case -1999289321:
                    if (str2.equals("NATIVE")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -428325382:
                    if (str2.equals("APP_OPEN_AD")) {
                        c4 = 4;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 543046670:
                    if (str2.equals("REWARDED")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1854800829:
                    if (str2.equals("REWARDED_INTERSTITIAL")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1951953708:
                    if (str2.equals("BANNER")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            if (c4 != 0) {
                if (c4 != 1 && c4 != 2) {
                    if (c4 != 3) {
                        if (c4 != 4) {
                            zzqVar = new com.google.android.gms.ads.internal.client.zzq();
                        } else {
                            zzqVar = com.google.android.gms.ads.internal.client.zzq.zzb();
                        }
                    } else {
                        zzqVar = com.google.android.gms.ads.internal.client.zzq.zzc();
                    }
                } else {
                    zzqVar = com.google.android.gms.ads.internal.client.zzq.zzd();
                }
            } else {
                zzqVar = new com.google.android.gms.ads.internal.client.zzq(context, AdSize.BANNER);
            }
        }
        zzfagVar.zzr(zzqVar);
        zzfagVar.zzx(true);
        zzcuoVar.zzi(zzfagVar.zzG());
        zzn.zza(zzcuoVar.zzj());
        zzac zzacVar = new zzac();
        zzacVar.zza(str2);
        zzn.zzb(new zzae(zzacVar, null));
        new zzdar();
        zzh zzc = zzn.zzc();
        this.f19508e = zzc.zza();
        return zzc;
    }

    private final zzfwm r(final String str) {
        final zzdlx[] zzdlxVarArr = new zzdlx[1];
        zzfwm zzm = zzfwc.zzm(this.f19507d.zza(), new zzfvj() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzk
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzaa.this.I(zzdlxVarArr, str, (zzdlx) obj);
            }
        }, this.f19509f);
        zzm.zzc(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
            @Override // java.lang.Runnable
            public final void run() {
                zzaa.this.h(zzdlxVarArr);
            }
        }, this.f19509f);
        return zzfwc.zze(zzfwc.zzl((zzfvt) zzfwc.zzn(zzfvt.zzv(zzm), ((Integer) zzba.zzc().zzb(zzbbm.zzhp)).intValue(), TimeUnit.MILLISECONDS, this.f19510g), new zzfov() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzv
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                int i4 = zzaa.zze;
                return ((JSONObject) obj).optString("nas");
            }
        }, this.f19509f), Exception.class, new zzfov() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzj
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                int i4 = zzaa.zze;
                zzbzr.zzh("", (Exception) obj);
                return null;
            }
        }, this.f19509f);
    }

    private final void s(List list, final IObjectWrapper iObjectWrapper, zzbsi zzbsiVar, boolean z3) {
        zzfwm zzb;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzho)).booleanValue()) {
            zzbzr.zzj("The updating URL feature is not enabled.");
            try {
                zzbsiVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e4) {
                zzbzr.zzh("", e4);
                return;
            }
        }
        Iterator it = list.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (n((Uri) it.next())) {
                i4++;
            }
        }
        if (i4 > 1) {
            zzbzr.zzj("Multiple google urls found: ".concat(String.valueOf(list)));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (!n(uri)) {
                zzbzr.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                zzb = zzfwc.zzh(uri);
            } else {
                zzb = this.f19509f.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzq
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzaa.this.A(uri, iObjectWrapper);
                    }
                });
                if (v()) {
                    zzb = zzfwc.zzm(zzb, new zzfvj() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzr
                        @Override // com.google.android.gms.internal.ads.zzfvj
                        public final zzfwm zza(Object obj) {
                            zzfwm zzl;
                            zzl = zzfwc.zzl(r0.r("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzfov() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzm
                                @Override // com.google.android.gms.internal.ads.zzfov
                                public final Object apply(Object obj2) {
                                    return zzaa.p(r2, (String) obj2);
                                }
                            }, zzaa.this.f19509f);
                            return zzl;
                        }
                    }, this.f19509f);
                } else {
                    zzbzr.zzi("Asset view map is empty.");
                }
            }
            arrayList.add(zzb);
        }
        zzfwc.zzq(zzfwc.zzd(arrayList), new zzy(this, zzbsiVar, z3), this.f19504a.zzA());
    }

    private final void t(final List list, final IObjectWrapper iObjectWrapper, zzbsi zzbsiVar, boolean z3) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzho)).booleanValue()) {
            try {
                zzbsiVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e4) {
                zzbzr.zzh("", e4);
                return;
            }
        }
        zzfwm zzb = this.f19509f.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzs
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzaa.this.c(list, iObjectWrapper);
            }
        });
        if (v()) {
            zzb = zzfwc.zzm(zzb, new zzfvj() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzt
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    return zzaa.this.J((ArrayList) obj);
                }
            }, this.f19509f);
        } else {
            zzbzr.zzi("Asset view map is empty.");
        }
        zzfwc.zzq(zzb, new zzx(this, zzbsiVar, z3), this.f19504a.zzA());
    }

    private static boolean u(@NonNull Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private final boolean v() {
        Map map;
        zzbsr zzbsrVar = this.f19511h;
        if (zzbsrVar != null && (map = zzbsrVar.zzb) != null && !map.isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri w(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf != -1) {
            int i4 = indexOf + 1;
            return Uri.parse(uri2.substring(0, i4) + str + "=" + str2 + "&" + uri2.substring(i4));
        }
        return uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private static final List x(String str) {
        String[] split = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzfpw.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Uri A(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.f19506c.zza(uri, this.f19505b, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzaqt e4) {
            zzbzr.zzk("", e4);
        }
        if (uri.getQueryParameter(TranslateLanguage.MALAY) != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzh E(zzbym zzbymVar) throws Exception {
        return q(this.f19505b, zzbymVar.zza, zzbymVar.zzb, zzbymVar.zzc, zzbymVar.zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm H() throws Exception {
        return q(this.f19505b, null, AdFormat.BANNER.name(), null, null).zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm I(zzdlx[] zzdlxVarArr, String str, zzdlx zzdlxVar) throws Exception {
        zzdlxVarArr[0] = zzdlxVar;
        Context context = this.f19505b;
        zzbsr zzbsrVar = this.f19511h;
        Map map = zzbsrVar.zzb;
        JSONObject zzd = zzbx.zzd(context, map, map, zzbsrVar.zza, null);
        JSONObject zzg = zzbx.zzg(this.f19505b, this.f19511h.zza);
        JSONObject zzf = zzbx.zzf(this.f19511h.zza);
        JSONObject zze2 = zzbx.zze(this.f19505b, this.f19511h.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd);
        jSONObject.put("ad_view_signal", zzg);
        jSONObject.put("scroll_view_signal", zzf);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbx.zzc(null, this.f19505b, this.f19513j, this.f19512i));
        }
        return zzdlxVar.zzd(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm J(final ArrayList arrayList) throws Exception {
        return zzfwc.zzl(r("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzfov() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzn
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                return zzaa.this.b(arrayList, (String) obj);
            }
        }, this.f19509f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList b(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (o(uri) && !TextUtils.isEmpty(str)) {
                arrayList.add(w(uri, "nas", str));
            } else {
                arrayList.add(uri);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList c(List list, IObjectWrapper iObjectWrapper) throws Exception {
        this.f19506c.zzc();
        String zzh = this.f19506c.zzc().zzh(this.f19505b, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        if (!TextUtils.isEmpty(zzh)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!o(uri)) {
                    zzbzr.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                    arrayList.add(uri);
                } else {
                    arrayList.add(w(uri, TranslateLanguage.MALAY, zzh));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void h(zzdlx[] zzdlxVarArr) {
        zzdlx zzdlxVar = zzdlxVarArr[0];
        if (zzdlxVar != null) {
            this.f19507d.zzb(zzfwc.zzh(zzdlxVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(String str, String str2, zzdpv zzdpvVar) {
        this.f19515l.zzd(str, str2, zzdpvVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean n(@NonNull Uri uri) {
        return u(uri, this.f19528y, this.f19529z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean o(@NonNull Uri uri) {
        return u(uri, this.A, this.B);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zze(IObjectWrapper iObjectWrapper, final zzbym zzbymVar, zzbyf zzbyfVar) {
        zzfwm zzh;
        zzfwm zzc;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.f19505b = context;
        zzffn zza = zzffm.zza(context, 22);
        zza.zzh();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjE)).booleanValue()) {
            zzfwn zzfwnVar = zzcae.zza;
            zzh = zzfwnVar.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzaa.this.E(zzbymVar);
                }
            });
            zzc = zzfwc.zzm(zzh, new zzfvj() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzp
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    return ((zzh) obj).zzc();
                }
            }, zzfwnVar);
        } else {
            zzh q4 = q(this.f19505b, zzbymVar.zza, zzbymVar.zzb, zzbymVar.zzc, zzbymVar.zzd);
            zzh = zzfwc.zzh(q4);
            zzc = q4.zzc();
        }
        zzfwc.zzq(zzc, new zzw(this, zzh, zzbymVar, zzbyfVar, zza, com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()), this.f19504a.zzA());
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzf(zzbsr zzbsrVar) {
        this.f19511h = zzbsrVar;
        this.f19507d.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsiVar) {
        s(list, iObjectWrapper, zzbsiVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsiVar) {
        t(list, iObjectWrapper, zzbsiVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    @SuppressLint({"AddJavascriptInterface"})
    public final void zzi(IObjectWrapper iObjectWrapper) {
        zzfwm zzc;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zziT)).booleanValue()) {
            return;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziU)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zziX)).booleanValue()) {
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzjE)).booleanValue()) {
                    zzc = zzfwc.zzk(new zzfvi() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzu
                        @Override // com.google.android.gms.internal.ads.zzfvi
                        public final zzfwm zza() {
                            return zzaa.this.H();
                        }
                    }, zzcae.zza);
                } else {
                    zzc = q(this.f19505b, null, AdFormat.BANNER.name(), null, null).zzc();
                }
                zzfwc.zzq(zzc, new zzz(this), this.f19504a.zzA());
            }
        }
        WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
        if (webView == null) {
            zzbzr.zzg("The webView cannot be null.");
        } else if (this.f19514k.contains(webView)) {
            zzbzr.zzi("This webview has already been registered.");
        } else {
            this.f19514k.add(webView);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.f19506c, this.f19516m, this.f19517n), "gmaSdk");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzj(IObjectWrapper iObjectWrapper) {
        View view;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzho)).booleanValue()) {
            return;
        }
        MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
        zzbsr zzbsrVar = this.f19511h;
        if (zzbsrVar == null) {
            view = null;
        } else {
            view = zzbsrVar.zza;
        }
        this.f19512i = zzbx.zza(motionEvent, view);
        if (motionEvent.getAction() == 0) {
            this.f19513j = this.f19512i;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.f19512i;
        obtain.setLocation(point.x, point.y);
        this.f19506c.zzd(obtain);
        obtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsiVar) {
        s(list, iObjectWrapper, zzbsiVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsiVar) {
        t(list, iObjectWrapper, zzbsiVar, false);
    }
}
