package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.uwb.RangingCapabilities;
import com.google.android.gms.nearby.uwb.RangingParameters;
import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbAddress;
import com.google.android.gms.nearby.uwb.UwbClient;
import com.google.android.gms.nearby.uwb.UwbComplexChannel;
import com.google.android.gms.nearby.uwb.UwbDevice;
import com.google.android.gms.nearby.uwb.UwbRangeDataNtfConfig;
import com.google.android.gms.nearby.uwb.UwbStatusCodes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzrv extends GoogleApi implements UwbClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api zzb = new Api("Nearby.UWB_API", new zzri(), new Api.ClientKey());
    @Nullable
    private UwbAddress zzc;
    @Nullable
    private UwbComplexChannel zzd;

    public zzrv(@NonNull Context context, com.google.android.gms.nearby.uwb.zze zzeVar) {
        super(context, zzb, zzeVar, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> addControlee(final UwbAddress uwbAddress) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzrv zzrvVar = zzrv.this;
                UwbAddress uwbAddress2 = uwbAddress;
                zznu zznuVar = new zznu();
                zzqr zzqrVar = new zzqr();
                zzqrVar.zza(uwbAddress2.getAddress());
                zznuVar.zza(zzqrVar.zzb());
                zznuVar.zzb(new zzrn(zzrvVar, (TaskCompletionSource) obj2));
                ((zzor) ((zzqv) obj).getService()).zzd(zznuVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzR).setMethodKey(1316).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<UwbComplexChannel> getComplexChannel() {
        if (((com.google.android.gms.nearby.uwb.zze) getApiOptions()).zza() == 2) {
            return Tasks.forException(new ApiException(new Status(UwbStatusCodes.INVALID_API_CALL)));
        }
        UwbComplexChannel uwbComplexChannel = this.zzd;
        if (uwbComplexChannel != null) {
            return Tasks.forResult(uwbComplexChannel);
        }
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzoc zzocVar = new zzoc();
                zzocVar.zza(new zzrm(zzrv.this, (TaskCompletionSource) obj2));
                ((zzor) ((zzqv) obj).getService()).zzf(zzocVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzQ).setMethodKey(1303).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<UwbAddress> getLocalAddress() {
        UwbAddress uwbAddress = this.zzc;
        if (uwbAddress != null) {
            return Tasks.forResult(uwbAddress);
        }
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrb
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzog zzogVar = new zzog();
                zzogVar.zza(new zzrl(zzrv.this, (TaskCompletionSource) obj2));
                ((zzor) ((zzqv) obj).getService()).zzg(zzogVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzQ).setMethodKey(1302).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<RangingCapabilities> getRangingCapabilities() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzre
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzok zzokVar = new zzok();
                zzokVar.zza(new zzrk(zzrv.this, (TaskCompletionSource) obj2));
                ((zzor) ((zzqv) obj).getService()).zzh(zzokVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzQ).setMethodKey(1301).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Boolean> isAvailable() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzph zzphVar = new zzph();
                zzphVar.zza(new zzrj(zzrv.this, (TaskCompletionSource) obj2));
                ((zzor) ((zzqv) obj).getService()).zzi(zzphVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzQ).setMethodKey(1300).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> removeControlee(final UwbAddress uwbAddress) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzrv zzrvVar = zzrv.this;
                UwbAddress uwbAddress2 = uwbAddress;
                zzqf zzqfVar = new zzqf();
                zzqr zzqrVar = new zzqr();
                zzqrVar.zza(uwbAddress2.getAddress());
                zzqfVar.zza(zzqrVar.zzb());
                zzqfVar.zzb(new zzrn(zzrvVar, (TaskCompletionSource) obj2));
                ((zzor) ((zzqv) obj).getService()).zzj(zzqfVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzS).setMethodKey(1317).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> startRanging(final RangingParameters rangingParameters, RangingSessionCallback rangingSessionCallback) {
        final UwbAddress uwbAddress = this.zzc;
        UwbComplexChannel uwbComplexChannel = this.zzd;
        if (uwbAddress == null) {
            return Tasks.forException(new ApiException(new Status(UwbStatusCodes.INVALID_API_CALL)));
        }
        if (uwbComplexChannel == null && rangingParameters.getComplexChannel() == null) {
            return Tasks.forException(new ApiException(new Status(UwbStatusCodes.INVALID_API_CALL)));
        }
        final zzru zzruVar = new zzru(this, rangingSessionCallback);
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzra
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzrv.this.zze(uwbAddress, rangingParameters, zzruVar, (zzqv) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(1304).setFeatures(com.google.android.gms.nearby.zza.zzQ).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> stopRanging(final RangingSessionCallback rangingSessionCallback) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrh
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzrv.this.zzf(rangingSessionCallback, (zzqv) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(1305).setFeatures(com.google.android.gms.nearby.zza.zzQ).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(UwbAddress uwbAddress, RangingParameters rangingParameters, zzru zzruVar, zzqv zzqvVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzry[] zzryVarArr;
        zzor zzorVar = (zzor) zzqvVar.getService();
        zzqj zzqjVar = new zzqj();
        UwbComplexChannel uwbComplexChannel = this.zzd;
        zzpz zzpzVar = new zzpz();
        zzpzVar.zzf(rangingParameters.getSessionId());
        zzpzVar.zzh(rangingParameters.getUwbConfigId());
        zzpzVar.zze(rangingParameters.getRangingUpdateRate());
        int i4 = 0;
        if (rangingParameters.getPeerDevices().isEmpty()) {
            zzryVarArr = new zzry[0];
        } else {
            zzryVarArr = new zzry[rangingParameters.getPeerDevices().size()];
            for (UwbDevice uwbDevice : rangingParameters.getPeerDevices()) {
                zzrw zzrwVar = new zzrw();
                zzqr zzqrVar = new zzqr();
                zzqrVar.zza(uwbDevice.getAddress().getAddress());
                zzrwVar.zza(zzqrVar.zzb());
                zzryVarArr[i4] = zzrwVar.zzb();
                i4++;
            }
        }
        zzpzVar.zzc(zzryVarArr);
        zzrw zzrwVar2 = new zzrw();
        zzqr zzqrVar2 = new zzqr();
        zzqrVar2.zza(uwbAddress.getAddress());
        zzrwVar2.zza(zzqrVar2.zzb());
        zzpzVar.zzb(zzrwVar2.zzb());
        byte[] sessionKeyInfo = rangingParameters.getSessionKeyInfo();
        if (sessionKeyInfo != null) {
            zzpzVar.zzg(sessionKeyInfo);
        }
        UwbComplexChannel complexChannel = rangingParameters.getComplexChannel();
        if (complexChannel != null) {
            uwbComplexChannel = complexChannel;
        }
        if (uwbComplexChannel != null) {
            zzqw zzqwVar = new zzqw();
            zzqwVar.zza(uwbComplexChannel.getChannel());
            zzqwVar.zzb(uwbComplexChannel.getPreambleIndex());
            zzpzVar.zza(zzqwVar.zzc());
        }
        UwbRangeDataNtfConfig uwbRangeDataNtfConfig = rangingParameters.getUwbRangeDataNtfConfig();
        if (uwbRangeDataNtfConfig == null) {
            uwbRangeDataNtfConfig = new UwbRangeDataNtfConfig.Builder().build();
        }
        zzpr zzprVar = new zzpr();
        zzprVar.zzc(uwbRangeDataNtfConfig.getRangeDataNtfConfigType());
        zzprVar.zzb(uwbRangeDataNtfConfig.getNtfProximityNear());
        zzprVar.zza(uwbRangeDataNtfConfig.getNtfProximityFar());
        zzpzVar.zzd(zzprVar.zzd());
        zzqjVar.zzb(zzpzVar.zzi());
        zzqjVar.zza(zzruVar);
        zzqjVar.zzc(new zzrn(this, taskCompletionSource));
        zzorVar.zzk(zzqjVar.zzd());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(RangingSessionCallback rangingSessionCallback, zzqv zzqvVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzqn zzqnVar = new zzqn();
        zzqnVar.zza(new zzrn(this, taskCompletionSource));
        ((zzor) zzqvVar.getService()).zzl(zzqnVar.zzb());
        doUnregisterEventListener(ListenerHolders.createListenerKey(rangingSessionCallback, RangingSessionCallback.class.getName()), 1305);
        this.zzc = null;
        this.zzd = null;
    }
}
