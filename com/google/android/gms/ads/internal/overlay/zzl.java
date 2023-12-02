package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhe;
import com.google.android.gms.internal.ads.zzbqw;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzcgk;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgo;
import com.google.android.gms.internal.ads.zzebm;
import com.google.android.gms.internal.ads.zzebn;
import com.google.android.gms.internal.ads.zzfgw;
import com.google.android.gms.internal.ads.zzfmd;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzl extends zzbrs implements zzad {
    @VisibleForTesting

    /* renamed from: u  reason: collision with root package name */
    static final int f19221u = Color.argb(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    protected final Activity f19222a;
    @Nullable
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    AdOverlayInfoParcel f19223b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    zzcez f19224c;
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    zzh f19225d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    zzr f19226e;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    FrameLayout f19228g;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    WebChromeClient.CustomViewCallback f19229h;
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    zzg f19232k;

    /* renamed from: n  reason: collision with root package name */
    private Runnable f19235n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f19236o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f19237p;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    boolean f19227f = false;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    boolean f19230i = false;
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    boolean f19231j = false;
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    boolean f19233l = false;
    @VisibleForTesting

    /* renamed from: t  reason: collision with root package name */
    int f19241t = 1;

    /* renamed from: m  reason: collision with root package name */
    private final Object f19234m = new Object();

    /* renamed from: q  reason: collision with root package name */
    private boolean f19238q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f19239r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f19240s = true;

    public zzl(Activity activity) {
        this.f19222a = activity;
    }

    private final void b(Configuration configuration) {
        boolean z3;
        com.google.android.gms.ads.internal.zzj zzjVar;
        int i4;
        com.google.android.gms.ads.internal.zzj zzjVar2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
        boolean z4 = true;
        boolean z5 = false;
        if (adOverlayInfoParcel != null && (zzjVar2 = adOverlayInfoParcel.zzo) != null && zzjVar2.zzb) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean zze = com.google.android.gms.ads.internal.zzt.zzq().zze(this.f19222a, configuration);
        if ((!this.f19231j || z3) && !zze) {
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.f19223b;
            if (adOverlayInfoParcel2 != null && (zzjVar = adOverlayInfoParcel2.zzo) != null && zzjVar.zzg) {
                z5 = true;
            }
        } else {
            z4 = false;
        }
        Window window = this.f19222a.getWindow();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbb)).booleanValue()) {
            View decorView = window.getDecorView();
            if (z4) {
                if (z5) {
                    i4 = 5894;
                } else {
                    i4 = 5380;
                }
            } else {
                i4 = 256;
            }
            decorView.setSystemUiVisibility(i4);
        } else if (z4) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (z5) {
                window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            }
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }

    private static final void c(@Nullable zzfgw zzfgwVar, @Nullable View view) {
        if (zzfgwVar != null && view != null) {
            com.google.android.gms.ads.internal.zzt.zzA().zzh(zzfgwVar, view);
        }
    }

    protected final void a(boolean z3) throws zzf {
        zzcgm zzcgmVar;
        boolean z4;
        zzcgo zzcgoVar;
        String str;
        com.google.android.gms.ads.internal.zza zzaVar;
        if (!this.f19237p) {
            this.f19222a.requestWindowFeature(1);
        }
        Window window = this.f19222a.getWindow();
        if (window != null) {
            zzcez zzcezVar = this.f19223b.zzd;
            com.google.android.gms.ads.internal.zzb zzbVar = null;
            if (zzcezVar != null) {
                zzcgmVar = zzcezVar.zzN();
            } else {
                zzcgmVar = null;
            }
            boolean z5 = false;
            if (zzcgmVar != null && zzcgmVar.zzK()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f19233l = false;
            if (z4) {
                int i4 = this.f19223b.zzj;
                if (i4 == 6) {
                    if (this.f19222a.getResources().getConfiguration().orientation == 1) {
                        z5 = true;
                    }
                    this.f19233l = z5;
                } else if (i4 == 7) {
                    if (this.f19222a.getResources().getConfiguration().orientation == 2) {
                        z5 = true;
                    }
                    this.f19233l = z5;
                }
            }
            zzbzr.zze("Delay onShow to next orientation change: " + z5);
            zzA(this.f19223b.zzj);
            window.setFlags(16777216, 16777216);
            zzbzr.zze("Hardware acceleration on the AdActivity window enabled.");
            if (!this.f19231j) {
                this.f19232k.setBackgroundColor(-16777216);
            } else {
                this.f19232k.setBackgroundColor(f19221u);
            }
            this.f19222a.setContentView(this.f19232k);
            this.f19237p = true;
            if (z3) {
                try {
                    com.google.android.gms.ads.internal.zzt.zzz();
                    Activity activity = this.f19222a;
                    zzcez zzcezVar2 = this.f19223b.zzd;
                    if (zzcezVar2 != null) {
                        zzcgoVar = zzcezVar2.zzO();
                    } else {
                        zzcgoVar = null;
                    }
                    zzcez zzcezVar3 = this.f19223b.zzd;
                    if (zzcezVar3 != null) {
                        str = zzcezVar3.zzS();
                    } else {
                        str = null;
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
                    zzbzx zzbzxVar = adOverlayInfoParcel.zzm;
                    zzcez zzcezVar4 = adOverlayInfoParcel.zzd;
                    if (zzcezVar4 != null) {
                        zzaVar = zzcezVar4.zzj();
                    } else {
                        zzaVar = null;
                    }
                    zzcez zza = zzcfl.zza(activity, zzcgoVar, str, true, z4, null, null, zzbzxVar, null, null, zzaVar, zzawz.zza(), null, null, null);
                    this.f19224c = zza;
                    zzcgm zzN = zza.zzN();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.f19223b;
                    zzbhc zzbhcVar = adOverlayInfoParcel2.zzp;
                    zzbhe zzbheVar = adOverlayInfoParcel2.zze;
                    zzz zzzVar = adOverlayInfoParcel2.zzi;
                    zzcez zzcezVar5 = adOverlayInfoParcel2.zzd;
                    if (zzcezVar5 != null) {
                        zzbVar = zzcezVar5.zzN().zzd();
                    }
                    zzN.zzM(null, zzbhcVar, null, zzbheVar, zzzVar, true, null, zzbVar, null, null, null, null, null, null, null, null, null, null);
                    this.f19224c.zzN().zzA(new zzcgk() { // from class: com.google.android.gms.ads.internal.overlay.zzd
                        @Override // com.google.android.gms.internal.ads.zzcgk
                        public final void zza(boolean z6) {
                            zzcez zzcezVar6 = zzl.this.f19224c;
                            if (zzcezVar6 != null) {
                                zzcezVar6.zzX();
                            }
                        }
                    });
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.f19223b;
                    String str2 = adOverlayInfoParcel3.zzl;
                    if (str2 != null) {
                        this.f19224c.loadUrl(str2);
                    } else {
                        String str3 = adOverlayInfoParcel3.zzh;
                        if (str3 != null) {
                            this.f19224c.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str3, "text/html", "UTF-8", null);
                        } else {
                            throw new zzf("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzcez zzcezVar6 = this.f19223b.zzd;
                    if (zzcezVar6 != null) {
                        zzcezVar6.zzar(this);
                    }
                } catch (Exception e4) {
                    zzbzr.zzh("Error obtaining webview.", e4);
                    throw new zzf("Could not obtain webview for the overlay.", e4);
                }
            } else {
                zzcez zzcezVar7 = this.f19223b.zzd;
                this.f19224c = zzcezVar7;
                zzcezVar7.zzak(this.f19222a);
            }
            this.f19224c.zzaf(this);
            zzcez zzcezVar8 = this.f19223b.zzd;
            if (zzcezVar8 != null) {
                c(zzcezVar8.zzQ(), this.f19232k);
            }
            if (this.f19223b.zzk != 5) {
                ViewParent parent = this.f19224c.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.f19224c.zzF());
                }
                if (this.f19231j) {
                    this.f19224c.zzaj();
                }
                this.f19232k.addView(this.f19224c.zzF(), -1, -1);
            }
            if (!z3 && !this.f19233l) {
                zze();
            }
            if (this.f19223b.zzk != 5) {
                zzw(z4);
                if (this.f19224c.zzaw()) {
                    zzy(z4, true);
                    return;
                }
                return;
            }
            zzebm zzf = zzebn.zzf();
            zzf.zza(this.f19222a);
            zzf.zzb(this);
            zzf.zze(this.f19223b.zzr);
            zzf.zzc(this.f19223b.zzq);
            zzf.zzd(this.f19223b.zzs);
            try {
                zzf(zzf.zzf());
                return;
            } catch (RemoteException | zzf e5) {
                throw new zzf(e5.getMessage(), e5);
            }
        }
        throw new zzf("Invalid activity, no window available.");
    }

    public final void zzA(int i4) {
        if (this.f19222a.getApplicationInfo().targetSdkVersion >= ((Integer) zzba.zzc().zzb(zzbbm.zzfL)).intValue()) {
            if (this.f19222a.getApplicationInfo().targetSdkVersion <= ((Integer) zzba.zzc().zzb(zzbbm.zzfM)).intValue()) {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= ((Integer) zzba.zzc().zzb(zzbbm.zzfN)).intValue()) {
                    if (i5 <= ((Integer) zzba.zzc().zzb(zzbbm.zzfO)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.f19222a.setRequestedOrientation(i4);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzt(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z3) {
        if (z3) {
            this.f19232k.setBackgroundColor(0);
        } else {
            this.f19232k.setBackgroundColor(-16777216);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.f19222a);
        this.f19228g = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.f19228g.addView(view, -1, -1);
        this.f19222a.setContentView(this.f19228g);
        this.f19237p = true;
        this.f19229h = customViewCallback;
        this.f19227f = true;
    }

    public final void zzE() {
        synchronized (this.f19234m) {
            this.f19236o = true;
            Runnable runnable = this.f19235n;
            if (runnable != null) {
                zzfmd zzfmdVar = com.google.android.gms.ads.internal.util.zzs.zza;
                zzfmdVar.removeCallbacks(runnable);
                zzfmdVar.post(this.f19235n);
            }
        }
    }

    protected final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzo zzoVar;
        if (this.f19222a.isFinishing() && !this.f19238q) {
            this.f19238q = true;
            zzcez zzcezVar = this.f19224c;
            if (zzcezVar != null) {
                zzcezVar.zzW(this.f19241t - 1);
                synchronized (this.f19234m) {
                    if (!this.f19236o && this.f19224c.zzax()) {
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeA)).booleanValue() && !this.f19239r && (adOverlayInfoParcel = this.f19223b) != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
                            zzoVar.zzby();
                        }
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zze
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzl.this.zzc();
                            }
                        };
                        this.f19235n = runnable;
                        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(runnable, ((Long) zzba.zzc().zzb(zzbbm.zzaU)).longValue());
                        return;
                    }
                }
            }
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final boolean zzG() {
        this.f19241t = 1;
        if (this.f19224c == null) {
            return true;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && this.f19224c.canGoBack()) {
            this.f19224c.goBack();
            return false;
        }
        boolean zzaC = this.f19224c.zzaC();
        if (!zzaC) {
            this.f19224c.zzd("onbackblocked", Collections.emptyMap());
        }
        return zzaC;
    }

    public final void zzb() {
        this.f19241t = 3;
        this.f19222a.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.f19222a.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzc() {
        zzcez zzcezVar;
        zzo zzoVar;
        if (this.f19239r) {
            return;
        }
        this.f19239r = true;
        zzcez zzcezVar2 = this.f19224c;
        if (zzcezVar2 != null) {
            this.f19232k.removeView(zzcezVar2.zzF());
            zzh zzhVar = this.f19225d;
            if (zzhVar != null) {
                this.f19224c.zzak(zzhVar.zzd);
                this.f19224c.zzan(false);
                ViewGroup viewGroup = this.f19225d.zzc;
                View zzF = this.f19224c.zzF();
                zzh zzhVar2 = this.f19225d;
                viewGroup.addView(zzF, zzhVar2.zza, zzhVar2.zzb);
                this.f19225d = null;
            } else if (this.f19222a.getApplicationContext() != null) {
                this.f19224c.zzak(this.f19222a.getApplicationContext());
            }
            this.f19224c = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
        if (adOverlayInfoParcel != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
            zzoVar.zzf(this.f19241t);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.f19223b;
        if (adOverlayInfoParcel2 != null && (zzcezVar = adOverlayInfoParcel2.zzd) != null) {
            c(zzcezVar.zzQ(), this.f19223b.zzd.zzF());
        }
    }

    public final void zzd() {
        this.f19232k.f19219b = true;
    }

    protected final void zze() {
        this.f19224c.zzX();
    }

    public final void zzf(zzebn zzebnVar) throws zzf, RemoteException {
        zzbrm zzbrmVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
        if (adOverlayInfoParcel != null && (zzbrmVar = adOverlayInfoParcel.zzw) != null) {
            zzbrmVar.zzg(ObjectWrapper.wrap(zzebnVar));
            return;
        }
        throw new zzf("noioou");
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
        if (adOverlayInfoParcel != null && this.f19227f) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.f19228g != null) {
            this.f19222a.setContentView(this.f19232k);
            this.f19237p = true;
            this.f19228g.removeAllViews();
            this.f19228g = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.f19229h;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.f19229h = null;
        }
        this.f19227f = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzi() {
        this.f19241t = 1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzad
    public final void zzj() {
        this.f19241t = 2;
        this.f19222a.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzk(IObjectWrapper iObjectWrapper) {
        b((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[Catch: zzf -> 0x00f9, TryCatch #0 {zzf -> 0x00f9, blocks: (B:12:0x001b, B:14:0x0029, B:16:0x0032, B:17:0x0034, B:19:0x003c, B:20:0x004a, B:22:0x0051, B:28:0x005e, B:30:0x0062, B:32:0x0067, B:35:0x0075, B:37:0x0079, B:39:0x007f, B:40:0x0082, B:42:0x0088, B:43:0x008b, B:45:0x0091, B:47:0x0095, B:48:0x0098, B:50:0x009e, B:51:0x00a1, B:58:0x00d0, B:60:0x00d4, B:61:0x00db, B:62:0x00dc, B:64:0x00e0, B:66:0x00ed, B:25:0x0058, B:27:0x005c, B:33:0x0071, B:68:0x00f1, B:69:0x00f8), top: B:73:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ed A[Catch: zzf -> 0x00f9, TryCatch #0 {zzf -> 0x00f9, blocks: (B:12:0x001b, B:14:0x0029, B:16:0x0032, B:17:0x0034, B:19:0x003c, B:20:0x004a, B:22:0x0051, B:28:0x005e, B:30:0x0062, B:32:0x0067, B:35:0x0075, B:37:0x0079, B:39:0x007f, B:40:0x0082, B:42:0x0088, B:43:0x008b, B:45:0x0091, B:47:0x0095, B:48:0x0098, B:50:0x009e, B:51:0x00a1, B:58:0x00d0, B:60:0x00d4, B:61:0x00db, B:62:0x00dc, B:64:0x00e0, B:66:0x00ed, B:25:0x0058, B:27:0x005c, B:33:0x0071, B:68:0x00f1, B:69:0x00f8), top: B:73:0x001b }] */
    @Override // com.google.android.gms.internal.ads.zzbrt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zzl(android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzl(android.os.Bundle):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzm() {
        zzcez zzcezVar = this.f19224c;
        if (zzcezVar != null) {
            try {
                this.f19232k.removeView(zzcezVar.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.f19233l) {
            this.f19233l = false;
            zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzo() {
        zzo zzoVar;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
        if (adOverlayInfoParcel != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
            zzoVar.zzbo();
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeC)).booleanValue() && this.f19224c != null && (!this.f19222a.isFinishing() || this.f19225d == null)) {
            this.f19224c.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzp(int i4, String[] strArr, int[] iArr) {
        zzl zzlVar;
        if (i4 == 12345) {
            zzebm zzf = zzebn.zzf();
            zzf.zza(this.f19222a);
            if (this.f19223b.zzk == 5) {
                zzlVar = this;
            } else {
                zzlVar = null;
            }
            zzf.zzb(zzlVar);
            zzf.zze(this.f19223b.zzr);
            try {
                this.f19223b.zzw.zzf(strArr, iArr, ObjectWrapper.wrap(zzf.zzf()));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzr() {
        zzo zzoVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
        if (adOverlayInfoParcel != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
            zzoVar.zzbF();
        }
        b(this.f19222a.getResources().getConfiguration());
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeC)).booleanValue()) {
            zzcez zzcezVar = this.f19224c;
            if (zzcezVar != null && !zzcezVar.zzaz()) {
                this.f19224c.onResume();
            } else {
                zzbzr.zzj("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f19230i);
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzt() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeC)).booleanValue()) {
            zzcez zzcezVar = this.f19224c;
            if (zzcezVar != null && !zzcezVar.zzaz()) {
                this.f19224c.onResume();
            } else {
                zzbzr.zzj("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzu() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeC)).booleanValue() && this.f19224c != null && (!this.f19222a.isFinishing() || this.f19225d == null)) {
            this.f19224c.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzv() {
        zzo zzoVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19223b;
        if (adOverlayInfoParcel != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
            zzoVar.zze();
        }
    }

    public final void zzw(boolean z3) {
        boolean z4;
        int i4;
        int i5;
        int intValue = ((Integer) zzba.zzc().zzb(zzbbm.zzeF)).intValue();
        int i6 = 0;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzaX)).booleanValue() && !z3) {
            z4 = false;
        } else {
            z4 = true;
        }
        zzq zzqVar = new zzq();
        zzqVar.zzd = 50;
        if (true != z4) {
            i4 = 0;
        } else {
            i4 = intValue;
        }
        zzqVar.zza = i4;
        if (true != z4) {
            i6 = intValue;
        }
        zzqVar.zzb = i6;
        zzqVar.zzc = intValue;
        this.f19226e = new zzr(this.f19222a, zzqVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        if (true != z4) {
            i5 = 9;
        } else {
            i5 = 11;
        }
        layoutParams.addRule(i5);
        zzy(z3, this.f19223b.zzg);
        this.f19232k.addView(this.f19226e, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzx() {
        this.f19237p = true;
    }

    public final void zzy(boolean z3, boolean z4) {
        boolean z5;
        boolean z6;
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzj zzjVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzj zzjVar2;
        boolean z7 = true;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaV)).booleanValue() && (adOverlayInfoParcel2 = this.f19223b) != null && (zzjVar2 = adOverlayInfoParcel2.zzo) != null && zzjVar2.zzh) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaW)).booleanValue() && (adOverlayInfoParcel = this.f19223b) != null && (zzjVar = adOverlayInfoParcel.zzo) != null && zzjVar.zzi) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z3 && z4 && z5 && !z6) {
            new zzbqw(this.f19224c, "useCustomClose").zzg("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzr zzrVar = this.f19226e;
        if (zzrVar != null) {
            if (!z6 && (!z4 || z5)) {
                z7 = false;
            }
            zzrVar.zzb(z7);
        }
    }

    public final void zzz() {
        this.f19232k.removeView(this.f19226e);
        zzw(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzh(int i4, int i5, Intent intent) {
    }
}
