package com.google.android.gms.internal.nearby;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.uwb.RangingMeasurement;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzru extends zzow {
    final /* synthetic */ zzrv zza;
    private final ListenerHolder zzb;
    private final RangingSessionCallback zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzru(zzrv zzrvVar, RangingSessionCallback rangingSessionCallback) {
        this.zza = zzrvVar;
        this.zzb = zzrvVar.registerListener(rangingSessionCallback, RangingSessionCallback.class.getName());
        this.zzc = rangingSessionCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ RangingPosition zzb(zzru zzruVar, zzqd zzqdVar) {
        RangingMeasurement rangingMeasurement;
        RangingMeasurement rangingMeasurement2;
        RangingMeasurement zzi = zzi(zzqdVar.zzd());
        if (zzqdVar.zzc() != null) {
            rangingMeasurement = zzi(zzqdVar.zzc());
        } else {
            rangingMeasurement = null;
        }
        if (zzqdVar.zze() != null) {
            rangingMeasurement2 = zzi(zzqdVar.zze());
        } else {
            rangingMeasurement2 = null;
        }
        return new RangingPosition(zzi, rangingMeasurement, rangingMeasurement2, zzqdVar.zzb(), zzqdVar.zza());
    }

    @SuppressLint({"WrongConstant"})
    private static final RangingMeasurement zzi(zzpx zzpxVar) {
        return new RangingMeasurement(zzpxVar.zzb(), zzpxVar.zza());
    }

    @Override // com.google.android.gms.internal.nearby.zzox
    public final void zzd(final zzpl zzplVar) {
        int i4 = zzrv.zza;
        final Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.nearby.zzro
            @Override // java.lang.Runnable
            public final void run() {
                zzru.this.zzh(zzplVar);
            }
        };
        this.zza.doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrp
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzqv zzqvVar = (zzqv) obj;
                runnable.run();
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzqv zzqvVar = (zzqv) obj;
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).withHolder(this.zzb).setFeatures(com.google.android.gms.nearby.zza.zzQ).setMethodKey(1304).build());
    }

    @Override // com.google.android.gms.internal.nearby.zzox
    public final void zze(zzpn zzpnVar) {
        int i4 = zzrv.zza;
        this.zzb.notifyListener(new zzrs(this, zzpnVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzox
    @SuppressLint({"WrongConstant"})
    public final void zzf(zzpp zzppVar) {
        int i4 = zzrv.zza;
        this.zzb.notifyListener(new zzrt(this, zzppVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(zzpl zzplVar) {
        this.zzb.notifyListener(new zzrr(this, zzplVar));
    }
}
