package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzea {

    /* renamed from: a  reason: collision with root package name */
    private final zzbnt f19152a;

    /* renamed from: b  reason: collision with root package name */
    private final zzp f19153b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f19154c;

    /* renamed from: d  reason: collision with root package name */
    private final VideoController f19155d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    final zzaz f19156e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private zza f19157f;

    /* renamed from: g  reason: collision with root package name */
    private AdListener f19158g;

    /* renamed from: h  reason: collision with root package name */
    private AdSize[] f19159h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private AppEventListener f19160i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private zzbu f19161j;

    /* renamed from: k  reason: collision with root package name */
    private VideoOptions f19162k;

    /* renamed from: l  reason: collision with root package name */
    private String f19163l;
    @NotOnlyInitialized

    /* renamed from: m  reason: collision with root package name */
    private final ViewGroup f19164m;

    /* renamed from: n  reason: collision with root package name */
    private int f19165n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f19166o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private OnPaidEventListener f19167p;

    public zzea(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzp.zza, null, 0);
    }

    private static zzq a(Context context, AdSize[] adSizeArr, int i4) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return zzq.zze();
            }
        }
        zzq zzqVar = new zzq(context, adSizeArr);
        zzqVar.zzj = b(i4);
        return zzqVar;
    }

    private static boolean b(int i4) {
        if (i4 == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(IObjectWrapper iObjectWrapper) {
        this.f19164m.addView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean zzA() {
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                return zzbuVar.zzY();
            }
            return false;
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            return false;
        }
    }

    public final AdSize[] zzB() {
        return this.f19159h;
    }

    public final AdListener zza() {
        return this.f19158g;
    }

    @Nullable
    public final AdSize zzb() {
        zzq zzg;
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null && (zzg = zzbuVar.zzg()) != null) {
                return com.google.android.gms.ads.zzb.zzc(zzg.zze, zzg.zzb, zzg.zza);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        AdSize[] adSizeArr = this.f19159h;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    @Nullable
    public final OnPaidEventListener zzc() {
        return this.f19167p;
    }

    @Nullable
    public final ResponseInfo zzd() {
        zzdn zzdnVar = null;
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                zzdnVar = zzbuVar.zzk();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        return ResponseInfo.zza(zzdnVar);
    }

    public final VideoController zzf() {
        return this.f19155d;
    }

    public final VideoOptions zzg() {
        return this.f19162k;
    }

    @Nullable
    public final AppEventListener zzh() {
        return this.f19160i;
    }

    @Nullable
    public final zzdq zzi() {
        zzbu zzbuVar = this.f19161j;
        if (zzbuVar != null) {
            try {
                return zzbuVar.zzl();
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
            }
        }
        return null;
    }

    public final String zzj() {
        zzbu zzbuVar;
        if (this.f19163l == null && (zzbuVar = this.f19161j) != null) {
            try {
                this.f19163l = zzbuVar.zzr();
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
            }
        }
        return this.f19163l;
    }

    public final void zzk() {
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                zzbuVar.zzx();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzm(zzdx zzdxVar) {
        zzbu zzbuVar;
        try {
            if (this.f19161j == null) {
                if (this.f19159h != null && this.f19163l != null) {
                    Context context = this.f19164m.getContext();
                    zzq a4 = a(context, this.f19159h, this.f19165n);
                    if ("search_v2".equals(a4.zza)) {
                        zzbuVar = (zzbu) new zzal(zzay.zza(), context, a4, this.f19163l).d(context, false);
                    } else {
                        zzbuVar = (zzbu) new zzaj(zzay.zza(), context, a4, this.f19163l, this.f19152a).d(context, false);
                    }
                    this.f19161j = zzbuVar;
                    zzbuVar.zzD(new zzg(this.f19156e));
                    zza zzaVar = this.f19157f;
                    if (zzaVar != null) {
                        this.f19161j.zzC(new zzb(zzaVar));
                    }
                    AppEventListener appEventListener = this.f19160i;
                    if (appEventListener != null) {
                        this.f19161j.zzG(new zzauo(appEventListener));
                    }
                    if (this.f19162k != null) {
                        this.f19161j.zzU(new zzfl(this.f19162k));
                    }
                    this.f19161j.zzP(new zzfe(this.f19167p));
                    this.f19161j.zzN(this.f19166o);
                    zzbu zzbuVar2 = this.f19161j;
                    if (zzbuVar2 != null) {
                        try {
                            final IObjectWrapper zzn = zzbuVar2.zzn();
                            if (zzn != null) {
                                if (((Boolean) zzbdd.zzf.zze()).booleanValue()) {
                                    if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                                        zzbzk.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzdy
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                zzea.this.d(zzn);
                                            }
                                        });
                                    }
                                }
                                this.f19164m.addView((View) ObjectWrapper.unwrap(zzn));
                            }
                        } catch (RemoteException e4) {
                            zzbzr.zzl("#007 Could not call remote method.", e4);
                        }
                    }
                } else {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
            }
            zzbu zzbuVar3 = this.f19161j;
            zzbuVar3.getClass();
            zzbuVar3.zzaa(this.f19153b.zza(this.f19164m.getContext(), zzdxVar));
        } catch (RemoteException e5) {
            zzbzr.zzl("#007 Could not call remote method.", e5);
        }
    }

    public final void zzn() {
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                zzbuVar.zzz();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzo() {
        if (this.f19154c.getAndSet(true)) {
            return;
        }
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                zzbuVar.zzA();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzp() {
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                zzbuVar.zzB();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzq(@Nullable zza zzaVar) {
        zzb zzbVar;
        try {
            this.f19157f = zzaVar;
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                if (zzaVar != null) {
                    zzbVar = new zzb(zzaVar);
                } else {
                    zzbVar = null;
                }
                zzbuVar.zzC(zzbVar);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzr(AdListener adListener) {
        this.f19158g = adListener;
        this.f19156e.zza(adListener);
    }

    public final void zzs(AdSize... adSizeArr) {
        if (this.f19159h == null) {
            zzt(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zzt(AdSize... adSizeArr) {
        this.f19159h = adSizeArr;
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                zzbuVar.zzF(a(this.f19164m.getContext(), this.f19159h, this.f19165n));
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        this.f19164m.requestLayout();
    }

    public final void zzu(String str) {
        if (this.f19163l == null) {
            this.f19163l = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void zzv(@Nullable AppEventListener appEventListener) {
        zzauo zzauoVar;
        try {
            this.f19160i = appEventListener;
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                if (appEventListener != null) {
                    zzauoVar = new zzauo(appEventListener);
                } else {
                    zzauoVar = null;
                }
                zzbuVar.zzG(zzauoVar);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzw(boolean z3) {
        this.f19166o = z3;
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                zzbuVar.zzN(z3);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzx(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.f19167p = onPaidEventListener;
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                zzbuVar.zzP(new zzfe(onPaidEventListener));
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzy(VideoOptions videoOptions) {
        zzfl zzflVar;
        this.f19162k = videoOptions;
        try {
            zzbu zzbuVar = this.f19161j;
            if (zzbuVar != null) {
                if (videoOptions == null) {
                    zzflVar = null;
                } else {
                    zzflVar = new zzfl(videoOptions);
                }
                zzbuVar.zzU(zzflVar);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final boolean zzz(zzbu zzbuVar) {
        try {
            IObjectWrapper zzn = zzbuVar.zzn();
            if (zzn == null || ((View) ObjectWrapper.unwrap(zzn)).getParent() != null) {
                return false;
            }
            this.f19164m.addView((View) ObjectWrapper.unwrap(zzn));
            this.f19161j = zzbuVar;
            return true;
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            return false;
        }
    }

    public zzea(ViewGroup viewGroup, int i4) {
        this(viewGroup, null, false, zzp.zza, null, i4);
    }

    public zzea(ViewGroup viewGroup, AttributeSet attributeSet, boolean z3) {
        this(viewGroup, attributeSet, z3, zzp.zza, null, 0);
    }

    public zzea(ViewGroup viewGroup, AttributeSet attributeSet, boolean z3, int i4) {
        this(viewGroup, attributeSet, z3, zzp.zza, null, i4);
    }

    @VisibleForTesting
    zzea(ViewGroup viewGroup, @Nullable AttributeSet attributeSet, boolean z3, zzp zzpVar, @Nullable zzbu zzbuVar, int i4) {
        zzq zzqVar;
        this.f19152a = new zzbnt();
        this.f19155d = new VideoController();
        this.f19156e = new zzdz(this);
        this.f19164m = viewGroup;
        this.f19153b = zzpVar;
        this.f19161j = null;
        this.f19154c = new AtomicBoolean(false);
        this.f19165n = i4;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzy zzyVar = new zzy(context, attributeSet);
                this.f19159h = zzyVar.zzb(z3);
                this.f19163l = zzyVar.zza();
                if (viewGroup.isInEditMode()) {
                    zzbzk zzb = zzay.zzb();
                    AdSize adSize = this.f19159h[0];
                    int i5 = this.f19165n;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzqVar = zzq.zze();
                    } else {
                        zzq zzqVar2 = new zzq(context, adSize);
                        zzqVar2.zzj = b(i5);
                        zzqVar = zzqVar2;
                    }
                    zzb.zzm(viewGroup, zzqVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e4) {
                zzay.zzb().zzl(viewGroup, new zzq(context, AdSize.BANNER), e4.getMessage(), e4.getMessage());
            }
        }
    }
}
