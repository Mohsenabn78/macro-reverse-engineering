package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzgz extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private long zzf;
    private final Set zzg;
    private final Set zzh;
    private final Set zzi;
    private final Set zzj;
    private final Set zzk;
    private final Set zzl;
    @Nullable
    private zzlu zzm;

    @VisibleForTesting
    protected zzgz(Context context, Looper looper, ClientSettings clientSettings, @Nullable ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        this.zzg = new ArraySet();
        this.zzh = new ArraySet();
        this.zzi = new ArraySet();
        this.zzj = new ArraySet();
        this.zzk = new ArraySet();
        this.zzl = new ArraySet();
        zzme.zzc(context.getCacheDir());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zzG(int i4) {
        return new Status(i4, ConnectionsStatusCodes.getStatusCodeString(i4));
    }

    private final void zzH() {
        for (zzgh zzghVar : this.zzg) {
            zzghVar.zze();
        }
        for (zzgc zzgcVar : this.zzh) {
            zzgcVar.zza();
        }
        for (zzgl zzglVar : this.zzi) {
            zzglVar.zzf();
        }
        for (zzgl zzglVar2 : this.zzj) {
            zzglVar2.zzf();
        }
        for (zzgl zzglVar3 : this.zzk) {
            zzglVar3.zzf();
        }
        for (zzgl zzglVar4 : this.zzl) {
            zzglVar4.zzf();
        }
        this.zzg.clear();
        this.zzh.clear();
        this.zzi.clear();
        this.zzj.clear();
        this.zzk.clear();
        this.zzl.clear();
        zzlu zzluVar = this.zzm;
        if (zzluVar != null) {
            zzluVar.zzd();
            this.zzm = null;
        }
    }

    public static zzgz zzq(Context context, Looper looper, ClientSettings clientSettings, @Nullable ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzgz zzgzVar = new zzgz(context, looper, clientSettings, connectionsOptions, connectionCallbacks, onConnectionFailedListener);
        zzgzVar.zzf = zzgzVar.hashCode();
        return zzgzVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        if (queryLocalInterface instanceof zzke) {
            return (zzke) queryLocalInterface;
        }
        return new zzke(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzke) getService()).zzf(new zzfp());
            } catch (RemoteException e4) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e4);
            }
        }
        zzH();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{com.google.android.gms.nearby.zza.zzf, com.google.android.gms.nearby.zza.zzH, com.google.android.gms.nearby.zza.zzL, com.google.android.gms.nearby.zza.zzJ, com.google.android.gms.nearby.zza.zzM, com.google.android.gms.nearby.zza.zzI, com.google.android.gms.nearby.zza.zzg, com.google.android.gms.nearby.zza.zzK, com.google.android.gms.nearby.zza.zzh};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.zzf);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* bridge */ /* synthetic */ void onConnectedLocked(@NonNull IInterface iInterface) {
        super.onConnectedLocked((zzke) iInterface);
        this.zzm = new zzlu();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i4) {
        if (i4 == 1) {
            zzH();
            i4 = 1;
        }
        super.onConnectionSuspended(i4);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(BaseImplementation.ResultHolder resultHolder, String str, String str2, ListenerHolder listenerHolder, AdvertisingOptions advertisingOptions) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzk.add(zzfxVar);
        zzmr zzmrVar = new zzmr();
        zzmrVar.zzg(new zzgy(resultHolder));
        zzmrVar.zze(str);
        zzmrVar.zzh(str2);
        zzmrVar.zzf(advertisingOptions);
        zzmrVar.zzb(zzfxVar);
        ((zzke) getService()).zzk(zzmrVar.zzi());
    }

    public final void zzB(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder, AdvertisingOptions advertisingOptions) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzk.add(zzfxVar);
        zzmr zzmrVar = new zzmr();
        zzmrVar.zzg(new zzgy(resultHolder));
        zzmrVar.zzd(bArr);
        zzmrVar.zzh(str);
        zzmrVar.zzf(advertisingOptions);
        zzmrVar.zzb(zzfxVar);
        ((zzke) getService()).zzk(zzmrVar.zzi());
    }

    public final void zzC(BaseImplementation.ResultHolder resultHolder, String str, ListenerHolder listenerHolder, DiscoveryOptions discoveryOptions) throws RemoteException {
        zzgh zzghVar = new zzgh(listenerHolder);
        this.zzg.add(zzghVar);
        zzmv zzmvVar = new zzmv();
        zzmvVar.zzd(new zzgw(resultHolder));
        zzmvVar.zze(str);
        zzmvVar.zzc(discoveryOptions);
        zzmvVar.zza(zzghVar);
        ((zzke) getService()).zzl(zzmvVar.zzf());
    }

    public final void zzD() throws RemoteException {
        ((zzke) getService()).zzm(new zzmz());
    }

    public final void zzE() throws RemoteException {
        ((zzke) getService()).zzn(new zznb());
    }

    public final void zzF() throws RemoteException {
        ((zzke) getService()).zzo(new zznd());
    }

    public final void zzr(BaseImplementation.ResultHolder resultHolder, String str, ListenerHolder listenerHolder) throws RemoteException {
        zzgv zzgvVar = new zzgv(getContext(), listenerHolder, this.zzm);
        this.zzi.add(zzgvVar);
        zzfh zzfhVar = new zzfh();
        zzfhVar.zze(new zzgw(resultHolder));
        zzfhVar.zzd(str);
        zzfhVar.zzc(zzgvVar);
        ((zzke) getService()).zzd(zzfhVar.zzf());
    }

    public final void zzs(BaseImplementation.ResultHolder resultHolder, long j4) throws RemoteException {
        zzfl zzflVar = new zzfl();
        zzflVar.zzb(new zzgw(resultHolder));
        zzflVar.zza(j4);
        ((zzke) getService()).zze(zzflVar.zzc());
    }

    public final void zzt(String str) throws RemoteException {
        zzjk zzjkVar = new zzjk();
        zzjkVar.zza(str);
        ((zzke) getService()).zzg(zzjkVar.zzb());
    }

    public final void zzu(BaseImplementation.ResultHolder resultHolder, String str) throws RemoteException {
        zzmf zzmfVar = new zzmf();
        zzmfVar.zzb(new zzgw(resultHolder));
        zzmfVar.zza(str);
        ((zzke) getService()).zzh(zzmfVar.zzc());
    }

    public final void zzv(BaseImplementation.ResultHolder resultHolder, @Nullable String str, String str2, ListenerHolder listenerHolder) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzk.add(zzfxVar);
        zzmj zzmjVar = new zzmj();
        zzmjVar.zzi(new zzgw(resultHolder));
        zzmjVar.zzf(str);
        zzmjVar.zzh(str2);
        zzmjVar.zzb(zzfxVar);
        ((zzke) getService()).zzi(zzmjVar.zzj());
    }

    public final void zzw(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzk.add(zzfxVar);
        zzmj zzmjVar = new zzmj();
        zzmjVar.zzi(new zzgw(resultHolder));
        zzmjVar.zzd(bArr);
        zzmjVar.zzh(str);
        zzmjVar.zzb(zzfxVar);
        ((zzke) getService()).zzi(zzmjVar.zzj());
    }

    public final void zzx(BaseImplementation.ResultHolder resultHolder, String str, String str2, ListenerHolder listenerHolder, ConnectionOptions connectionOptions) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzk.add(zzfxVar);
        zzmj zzmjVar = new zzmj();
        zzmjVar.zzi(new zzgw(resultHolder));
        zzmjVar.zzf(str);
        zzmjVar.zzh(str2);
        zzmjVar.zzb(zzfxVar);
        zzmjVar.zzg(connectionOptions);
        ((zzke) getService()).zzi(zzmjVar.zzj());
    }

    public final void zzy(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder, ConnectionOptions connectionOptions) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzk.add(zzfxVar);
        zzmj zzmjVar = new zzmj();
        zzmjVar.zzi(new zzgw(resultHolder));
        zzmjVar.zzd(bArr);
        zzmjVar.zzh(str);
        zzmjVar.zzb(zzfxVar);
        zzmjVar.zzg(connectionOptions);
        ((zzke) getService()).zzi(zzmjVar.zzj());
    }

    public final void zzz(BaseImplementation.ResultHolder resultHolder, String[] strArr, Payload payload, boolean z3) throws RemoteException {
        Pair create;
        String absolutePath;
        try {
            int type = payload.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type == 3) {
                        try {
                            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                            ParcelFileDescriptor[] createPipe2 = ParcelFileDescriptor.createPipe();
                            zzma zzmaVar = new zzma();
                            zzmaVar.zzd(payload.getId());
                            zzmaVar.zzm(payload.getType());
                            zzmaVar.zzb(createPipe[0]);
                            zzmaVar.zzl(createPipe2[0]);
                            zzmaVar.zzh(payload.getOffset());
                            zzmaVar.zzj(0L);
                            create = Pair.create(zzmaVar.zzn(), zzsf.zzd(Pair.create(createPipe[1], createPipe2[1])));
                        } catch (IOException e4) {
                            Log.e("NearbyConnections", String.format("Unable to create PFD pipe for streaming payload %d from client to service.", Long.valueOf(payload.getId())), e4);
                            throw e4;
                        }
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())));
                        Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException);
                        throw illegalArgumentException;
                    }
                } else {
                    Payload.File asFile = payload.asFile();
                    zzsj.zzc(asFile, "File cannot be null for Payload.Type.FILE");
                    File asJavaFile = asFile.asJavaFile();
                    if (asJavaFile == null) {
                        absolutePath = null;
                    } else {
                        absolutePath = asJavaFile.getAbsolutePath();
                    }
                    zzma zzmaVar2 = new zzma();
                    zzmaVar2.zzd(payload.getId());
                    zzmaVar2.zzm(payload.getType());
                    zzmaVar2.zzb(asFile.asParcelFileDescriptor());
                    zzmaVar2.zzf(absolutePath);
                    zzmaVar2.zzg(asFile.getSize());
                    zzmaVar2.zzh(payload.getOffset());
                    zzmaVar2.zze(payload.zzf());
                    zzmaVar2.zzj(0L);
                    zzmaVar2.zzc(payload.zzd());
                    zzmaVar2.zzi(payload.zze());
                    create = Pair.create(zzmaVar2.zzn(), zzsf.zzc());
                }
            } else {
                zzma zzmaVar3 = new zzma();
                zzmaVar3.zzd(payload.getId());
                zzmaVar3.zzm(payload.getType());
                byte[] asBytes = payload.asBytes();
                if (asBytes != null && asBytes.length > 32768) {
                    zzlw zzlwVar = new zzlw();
                    zzlwVar.zza(asBytes);
                    zzmaVar3.zzk(zzlwVar.zzb());
                    zzmaVar3.zza(Arrays.copyOf(asBytes, 32768));
                } else {
                    zzmaVar3.zza(asBytes);
                }
                create = Pair.create(zzmaVar3.zzn(), zzsf.zzc());
            }
            zzmn zzmnVar = new zzmn();
            zzmnVar.zzc(new zzgw(resultHolder));
            zzmnVar.zzb(strArr);
            zzmnVar.zza((zzmc) create.first);
            ((zzke) getService()).zzj(zzmnVar.zzd());
            if (((zzsf) create.second).zzb()) {
                Object zza = ((zzsf) create.second).zza();
                zzlu zzluVar = this.zzm;
                if (zzluVar != null) {
                    Pair pair = (Pair) zza;
                    zzluVar.zzc(((Payload.Stream) Preconditions.checkNotNull(payload.asStream())).asInputStream(), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.first), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.second), (zzmc) create.first, payload.getId());
                }
            }
        } catch (IOException e5) {
            Log.w("NearbyConnectionsClient", "Failed to create a Parcelable Payload.", e5);
            resultHolder.setResult(zzG(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR));
        }
    }
}
