package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.3.0 */
@DynamiteApi
/* loaded from: classes4.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzcb {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    zzgd f21422a = null;
    @GuardedBy("listenerMap")

    /* renamed from: b  reason: collision with root package name */
    private final Map f21423b = new ArrayMap();

    private final void a(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str) {
        zzb();
        this.f21422a.zzv().zzW(zzcfVar, str);
    }

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.f21422a != null) {
            return;
        }
        throw new IllegalStateException("Attempting to perform action before initialize.");
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void beginAdUnitExposure(@NonNull String str, long j4) throws RemoteException {
        zzb();
        this.f21422a.zzd().zzd(str, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        zzb();
        this.f21422a.zzq().zzA(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void clearMeasurementEnabled(long j4) throws RemoteException {
        zzb();
        this.f21422a.zzq().zzU(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void endAdUnitExposure(@NonNull String str, long j4) throws RemoteException {
        zzb();
        this.f21422a.zzd().zze(str, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void generateEventId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        long zzq = this.f21422a.zzv().zzq();
        zzb();
        this.f21422a.zzv().zzV(zzcfVar, zzq);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.f21422a.zzaB().zzp(new zzi(this, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        a(zzcfVar, this.f21422a.zzq().zzo());
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.f21422a.zzaB().zzp(new zzm(this, zzcfVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        a(zzcfVar, this.f21422a.zzq().zzp());
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        a(zzcfVar, this.f21422a.zzq().zzq());
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        String str;
        zzb();
        zzik zzq = this.f21422a.zzq();
        if (zzq.f21734a.zzw() != null) {
            str = zzq.f21734a.zzw();
        } else {
            try {
                str = zziq.zzc(zzq.f21734a.zzaw(), "google_app_id", zzq.f21734a.zzz());
            } catch (IllegalStateException e4) {
                zzq.f21734a.zzaA().zzd().zzb("getGoogleAppId failed with exception", e4);
                str = null;
            }
        }
        a(zzcfVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.f21422a.zzq().zzh(str);
        zzb();
        this.f21422a.zzv().zzU(zzcfVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getSessionId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        zzik zzq = this.f21422a.zzq();
        zzq.f21734a.zzaB().zzp(new zzhy(zzq, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcf zzcfVar, int i4) throws RemoteException {
        zzb();
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        this.f21422a.zzv().zzQ(zzcfVar, this.f21422a.zzq().zzi().booleanValue());
                        return;
                    }
                    this.f21422a.zzv().zzU(zzcfVar, this.f21422a.zzq().zzl().intValue());
                    return;
                }
                zzlp zzv = this.f21422a.zzv();
                double doubleValue = this.f21422a.zzq().zzj().doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", doubleValue);
                try {
                    zzcfVar.zze(bundle);
                    return;
                } catch (RemoteException e4) {
                    zzv.f21734a.zzaA().zzk().zzb("Error returning double value to wrapper", e4);
                    return;
                }
            }
            this.f21422a.zzv().zzV(zzcfVar, this.f21422a.zzq().zzm().longValue());
            return;
        }
        this.f21422a.zzv().zzW(zzcfVar, this.f21422a.zzq().zzr());
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getUserProperties(String str, String str2, boolean z3, com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.f21422a.zzaB().zzp(new zzk(this, zzcfVar, str, str2, z3));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void initForTests(@NonNull Map map) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcl zzclVar, long j4) throws RemoteException {
        zzgd zzgdVar = this.f21422a;
        if (zzgdVar == null) {
            this.f21422a = zzgd.zzp((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzclVar, Long.valueOf(j4));
        } else {
            zzgdVar.zzaA().zzk().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.f21422a.zzaB().zzp(new zzn(this, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z3, boolean z4, long j4) throws RemoteException {
        zzb();
        this.f21422a.zzq().zzE(str, str2, bundle, z3, z4, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcf zzcfVar, long j4) throws RemoteException {
        Bundle bundle2;
        zzb();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.f21422a.zzaB().zzp(new zzj(this, zzcfVar, new zzau(str2, new zzas(bundle), "app", j4), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logHealthData(int i4, @NonNull String str, @NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object unwrap;
        Object unwrap2;
        zzb();
        Object obj = null;
        if (iObjectWrapper == null) {
            unwrap = null;
        } else {
            unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            unwrap2 = null;
        } else {
            unwrap2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.f21422a.zzaA().l(i4, true, false, str, unwrap, unwrap2, obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityCreated(@NonNull IObjectWrapper iObjectWrapper, @NonNull Bundle bundle, long j4) throws RemoteException {
        zzb();
        zzij zzijVar = this.f21422a.zzq().f21847c;
        if (zzijVar != null) {
            this.f21422a.zzq().zzB();
            zzijVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityDestroyed(@NonNull IObjectWrapper iObjectWrapper, long j4) throws RemoteException {
        zzb();
        zzij zzijVar = this.f21422a.zzq().f21847c;
        if (zzijVar != null) {
            this.f21422a.zzq().zzB();
            zzijVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityPaused(@NonNull IObjectWrapper iObjectWrapper, long j4) throws RemoteException {
        zzb();
        zzij zzijVar = this.f21422a.zzq().f21847c;
        if (zzijVar != null) {
            this.f21422a.zzq().zzB();
            zzijVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityResumed(@NonNull IObjectWrapper iObjectWrapper, long j4) throws RemoteException {
        zzb();
        zzij zzijVar = this.f21422a.zzq().f21847c;
        if (zzijVar != null) {
            this.f21422a.zzq().zzB();
            zzijVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcf zzcfVar, long j4) throws RemoteException {
        zzb();
        zzij zzijVar = this.f21422a.zzq().f21847c;
        Bundle bundle = new Bundle();
        if (zzijVar != null) {
            this.f21422a.zzq().zzB();
            zzijVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e4) {
            this.f21422a.zzaA().zzk().zzb("Error returning bundle value to wrapper", e4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityStarted(@NonNull IObjectWrapper iObjectWrapper, long j4) throws RemoteException {
        zzb();
        if (this.f21422a.zzq().f21847c != null) {
            this.f21422a.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityStopped(@NonNull IObjectWrapper iObjectWrapper, long j4) throws RemoteException {
        zzb();
        if (this.f21422a.zzq().f21847c != null) {
            this.f21422a.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcf zzcfVar, long j4) throws RemoteException {
        zzb();
        zzcfVar.zze(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        zzhg zzhgVar;
        zzb();
        synchronized (this.f21423b) {
            zzhgVar = (zzhg) this.f21423b.get(Integer.valueOf(zzciVar.zzd()));
            if (zzhgVar == null) {
                zzhgVar = new zzp(this, zzciVar);
                this.f21423b.put(Integer.valueOf(zzciVar.zzd()), zzhgVar);
            }
        }
        this.f21422a.zzq().zzJ(zzhgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void resetAnalyticsData(long j4) throws RemoteException {
        zzb();
        this.f21422a.zzq().zzK(j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j4) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.f21422a.zzaA().zzd().zza("Conditional user property must not be null");
        } else {
            this.f21422a.zzq().zzQ(bundle, j4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConsent(@NonNull final Bundle bundle, final long j4) throws RemoteException {
        zzb();
        final zzik zzq = this.f21422a.zzq();
        zzq.f21734a.zzaB().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhj
            @Override // java.lang.Runnable
            public final void run() {
                zzik zzikVar = zzik.this;
                Bundle bundle2 = bundle;
                long j5 = j4;
                if (TextUtils.isEmpty(zzikVar.f21734a.zzh().zzm())) {
                    zzikVar.zzS(bundle2, 0, j5);
                } else {
                    zzikVar.f21734a.zzaA().zzl().zza("Using developer consent only; google app id found");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConsentThirdParty(@NonNull Bundle bundle, long j4) throws RemoteException {
        zzb();
        this.f21422a.zzq().zzS(bundle, -20, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setCurrentScreen(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2, long j4) throws RemoteException {
        zzb();
        this.f21422a.zzs().zzw((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setDataCollectionEnabled(boolean z3) throws RemoteException {
        zzb();
        zzik zzq = this.f21422a.zzq();
        zzq.zza();
        zzq.f21734a.zzaB().zzp(new zzih(zzq, z3));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        final Bundle bundle2;
        zzb();
        final zzik zzq = this.f21422a.zzq();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzq.f21734a.zzaB().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhk
            @Override // java.lang.Runnable
            public final void run() {
                zzik.this.d(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        zzb();
        zzo zzoVar = new zzo(this, zzciVar);
        if (this.f21422a.zzaB().zzs()) {
            this.f21422a.zzq().zzT(zzoVar);
        } else {
            this.f21422a.zzaB().zzp(new zzl(this, zzoVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzck zzckVar) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setMeasurementEnabled(boolean z3, long j4) throws RemoteException {
        zzb();
        this.f21422a.zzq().zzU(Boolean.valueOf(z3));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setMinimumSessionDuration(long j4) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setSessionTimeoutDuration(long j4) throws RemoteException {
        zzb();
        zzik zzq = this.f21422a.zzq();
        zzq.f21734a.zzaB().zzp(new zzho(zzq, j4));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setUserId(@NonNull final String str, long j4) throws RemoteException {
        zzb();
        final zzik zzq = this.f21422a.zzq();
        if (str != null && TextUtils.isEmpty(str)) {
            zzq.f21734a.zzaA().zzk().zza("User ID must be non-empty or null");
            return;
        }
        zzq.f21734a.zzaB().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhl
            @Override // java.lang.Runnable
            public final void run() {
                zzik zzikVar = zzik.this;
                if (zzikVar.f21734a.zzh().j(str)) {
                    zzikVar.f21734a.zzh().i();
                }
            }
        });
        zzq.zzX(null, Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID, str, true, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull IObjectWrapper iObjectWrapper, boolean z3, long j4) throws RemoteException {
        zzb();
        this.f21422a.zzq().zzX(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z3, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        zzhg zzhgVar;
        zzb();
        synchronized (this.f21423b) {
            zzhgVar = (zzhg) this.f21423b.remove(Integer.valueOf(zzciVar.zzd()));
        }
        if (zzhgVar == null) {
            zzhgVar = new zzp(this, zzciVar);
        }
        this.f21422a.zzq().zzZ(zzhgVar);
    }
}
