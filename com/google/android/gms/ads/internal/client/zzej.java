package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbkf;
import com.google.android.gms.internal.ads.zzbkn;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbnp;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbzg;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzfpw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzej {

    /* renamed from: i */
    private static zzej f19169i;

    /* renamed from: f */
    private zzco f19175f;

    /* renamed from: a */
    private final Object f19170a = new Object();

    /* renamed from: c */
    private boolean f19172c = false;

    /* renamed from: d */
    private boolean f19173d = false;

    /* renamed from: e */
    private final Object f19174e = new Object();
    @Nullable

    /* renamed from: g */
    private OnAdInspectorClosedListener f19176g = null;
    @NonNull

    /* renamed from: h */
    private RequestConfiguration f19177h = new RequestConfiguration.Builder().build();

    /* renamed from: b */
    private final ArrayList f19171b = new ArrayList();

    private zzej() {
    }

    private final void a(Context context) {
        if (this.f19175f == null) {
            this.f19175f = (zzco) new zzaq(zzay.zza(), context).d(context, false);
        }
    }

    private final void b(@NonNull RequestConfiguration requestConfiguration) {
        try {
            this.f19175f.zzu(new zzff(requestConfiguration));
        } catch (RemoteException e4) {
            zzbzr.zzh("Unable to set request configuration parcel.", e4);
        }
    }

    public static InitializationStatus k(List list) {
        AdapterStatus.State state;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbkf zzbkfVar = (zzbkf) it.next();
            String str = zzbkfVar.zza;
            if (zzbkfVar.zzb) {
                state = AdapterStatus.State.READY;
            } else {
                state = AdapterStatus.State.NOT_READY;
            }
            hashMap.put(str, new zzbkn(state, zzbkfVar.zzd, zzbkfVar.zzc));
        }
        return new zzbko(hashMap);
    }

    private final void l(Context context, @Nullable String str) {
        try {
            zzbnp.zza().zzb(context, null);
            this.f19175f.zzk();
            this.f19175f.zzl(null, ObjectWrapper.wrap(null));
        } catch (RemoteException e4) {
            zzbzr.zzk("MobileAdsSettingManager initialization failed", e4);
        }
    }

    public static zzej zzf() {
        zzej zzejVar;
        synchronized (zzej.class) {
            if (f19169i == null) {
                f19169i = new zzej();
            }
            zzejVar = f19169i;
        }
        return zzejVar;
    }

    public final /* synthetic */ void i(Context context, String str) {
        synchronized (this.f19174e) {
            l(context, null);
        }
    }

    public final /* synthetic */ void j(Context context, String str) {
        synchronized (this.f19174e) {
            l(context, null);
        }
    }

    public final float zza() {
        synchronized (this.f19174e) {
            zzco zzcoVar = this.f19175f;
            float f4 = 1.0f;
            if (zzcoVar == null) {
                return 1.0f;
            }
            try {
                f4 = zzcoVar.zze();
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to get app volume.", e4);
            }
            return f4;
        }
    }

    @NonNull
    public final RequestConfiguration zzc() {
        return this.f19177h;
    }

    public final InitializationStatus zze() {
        boolean z3;
        InitializationStatus k4;
        synchronized (this.f19174e) {
            if (this.f19175f != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                k4 = k(this.f19175f.zzg());
            } catch (RemoteException unused) {
                zzbzr.zzg("Unable to get Initialization status.");
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeb
                    @Override // com.google.android.gms.ads.initialization.InitializationStatus
                    public final Map getAdapterStatusMap() {
                        zzej zzejVar = zzej.this;
                        HashMap hashMap = new HashMap();
                        hashMap.put("com.google.android.gms.ads.MobileAds", new zzee(zzejVar));
                        return hashMap;
                    }
                };
            }
        }
        return k4;
    }

    public final String zzh() {
        boolean z3;
        String zzc;
        synchronized (this.f19174e) {
            if (this.f19175f != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzc = zzfpw.zzc(this.f19175f.zzf());
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to get internal version.", e4);
                return "";
            }
        }
        return zzc;
    }

    public final void zzl(Context context) {
        synchronized (this.f19174e) {
            a(context);
            try {
                this.f19175f.zzi();
            } catch (RemoteException unused) {
                zzbzr.zzg("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final void zzm(boolean z3) {
        boolean z4;
        String str;
        synchronized (this.f19174e) {
            if (this.f19175f != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkState(z4, "MobileAds.initialize() must be called prior to enable/disable Same App Key.");
            try {
                this.f19175f.zzj(z3);
            } catch (RemoteException e4) {
                if (z3) {
                    str = "enable";
                } else {
                    str = "disable";
                }
                zzbzr.zzh("Unable to " + str + " Same App Key.", e4);
                if (e4.getMessage() != null && e4.getMessage().toLowerCase(Locale.ROOT).contains("paid")) {
                    throw new IllegalStateException(e4);
                }
            }
        }
    }

    public final void zzn(Context context, @Nullable String str, @Nullable OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.f19170a) {
            if (this.f19172c) {
                if (onInitializationCompleteListener != null) {
                    this.f19171b.add(onInitializationCompleteListener);
                }
            } else if (this.f19173d) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.onInitializationComplete(zze());
                }
            } else {
                this.f19172c = true;
                if (onInitializationCompleteListener != null) {
                    this.f19171b.add(onInitializationCompleteListener);
                }
                if (context != null) {
                    synchronized (this.f19174e) {
                        try {
                            a(context);
                            this.f19175f.zzs(new zzei(this, null));
                            this.f19175f.zzo(new zzbnt());
                            if (this.f19177h.getTagForChildDirectedTreatment() != -1 || this.f19177h.getTagForUnderAgeOfConsent() != -1) {
                                b(this.f19177h);
                            }
                        } catch (RemoteException e4) {
                            zzbzr.zzk("MobileAdsSettingManager initialization failed", e4);
                        }
                        zzbbm.zza(context);
                        if (((Boolean) zzbdd.zza.zze()).booleanValue()) {
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjI)).booleanValue()) {
                                zzbzr.zze("Initializing on bg thread");
                                zzbzg.zza.execute(new Runnable(context, null) { // from class: com.google.android.gms.ads.internal.client.zzec
                                    public final /* synthetic */ Context zzb;

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzej.this.i(this.zzb, null);
                                    }
                                });
                            }
                        }
                        if (((Boolean) zzbdd.zzb.zze()).booleanValue()) {
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjI)).booleanValue()) {
                                zzbzg.zzb.execute(new Runnable(context, null) { // from class: com.google.android.gms.ads.internal.client.zzed
                                    public final /* synthetic */ Context zzb;

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzej.this.j(this.zzb, null);
                                    }
                                });
                            }
                        }
                        zzbzr.zze("Initializing on calling thread");
                        l(context, null);
                    }
                    return;
                }
                throw new IllegalArgumentException("Context cannot be null.");
            }
        }
    }

    public final void zzq(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.f19174e) {
            a(context);
            this.f19176g = onAdInspectorClosedListener;
            try {
                this.f19175f.zzm(new zzeg(null));
            } catch (RemoteException unused) {
                zzbzr.zzg("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final void zzr(Context context, String str) {
        boolean z3;
        synchronized (this.f19174e) {
            if (this.f19175f != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.f19175f.zzn(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to open debug menu.", e4);
            }
        }
    }

    public final void zzs(Class cls) {
        synchronized (this.f19174e) {
            try {
                this.f19175f.zzh(cls.getCanonicalName());
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to register RtbAdapter", e4);
            }
        }
    }

    public final void zzt(boolean z3) {
        boolean z4;
        synchronized (this.f19174e) {
            if (this.f19175f != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkState(z4, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.f19175f.zzp(z3);
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to set app mute state.", e4);
            }
        }
    }

    public final void zzu(float f4) {
        boolean z3;
        boolean z4 = true;
        if (f4 >= 0.0f && f4 <= 1.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.f19174e) {
            if (this.f19175f == null) {
                z4 = false;
            }
            Preconditions.checkState(z4, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.f19175f.zzq(f4);
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to set app volume.", e4);
            }
        }
    }

    public final void zzv(String str) {
        boolean z3;
        synchronized (this.f19174e) {
            if (this.f19175f != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MobileAds.initialize() must be called prior to setting the plugin.");
            try {
                this.f19175f.zzt(str);
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to set plugin.", e4);
            }
        }
    }

    public final void zzw(@NonNull RequestConfiguration requestConfiguration) {
        boolean z3;
        if (requestConfiguration != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Null passed to setRequestConfiguration.");
        synchronized (this.f19174e) {
            RequestConfiguration requestConfiguration2 = this.f19177h;
            this.f19177h = requestConfiguration;
            if (this.f19175f == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                b(requestConfiguration);
            }
        }
    }

    public final boolean zzx() {
        synchronized (this.f19174e) {
            zzco zzcoVar = this.f19175f;
            boolean z3 = false;
            if (zzcoVar == null) {
                return false;
            }
            try {
                z3 = zzcoVar.zzv();
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to get app mute state.", e4);
            }
            return z3;
        }
    }
}
