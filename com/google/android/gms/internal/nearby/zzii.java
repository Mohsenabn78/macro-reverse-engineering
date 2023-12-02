package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzii extends GoogleApi implements ConnectionsClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;
    private static final Api zzd;
    private zzfg zze;
    @Nullable
    private final zzkq zzf;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzhz zzhzVar = new zzhz();
        zzc = zzhzVar;
        zzd = new Api("Nearby.CONNECTIONS_API", zzhzVar, clientKey);
    }

    private zzii(Activity activity, @Nullable ConnectionsOptions connectionsOptions) {
        super(activity, (Api<Api.ApiOptions>) zzd, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzf = zzkq.zza(activity);
    }

    public static zzii zza(Activity activity, @Nullable ConnectionsOptions connectionsOptions) {
        zzii zziiVar = new zzii(activity, (ConnectionsOptions) null);
        zziiVar.zze = zzfg.zzd(zziiVar, null);
        return zziiVar;
    }

    public static zzii zzb(Context context, @Nullable ConnectionsOptions connectionsOptions) {
        zzii zziiVar = new zzii(context, (ConnectionsOptions) null);
        zziiVar.zze = zzfg.zzd(zziiVar, null);
        return zziiVar;
    }

    private final Task zzh(final zzie zzieVar) {
        return doWrite(TaskApiCall.builder().setMethodKey(1229).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzha
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzieVar.zza((zzgz) obj, new zzig(zzii.this, (TaskCompletionSource) obj2));
            }
        }).build());
    }

    private final Task zzi(final zzih zzihVar) {
        return doWrite(TaskApiCall.builder().setMethodKey(1229).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhy
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzii.zza;
                zzih.this.zza((zzgz) obj);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(String str) {
        this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzc(this, str, "connection")).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhr
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzgz zzgzVar = (zzgz) obj;
                int i4 = zzii.zza;
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzht
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzgz zzgzVar = (zzgz) obj;
                ((TaskCompletionSource) obj2).setResult(Boolean.TRUE);
            }
        }).setMethodKey(1268).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(String str) {
        zzfg zzfgVar = this.zze;
        zzfgVar.zzg(this, zzfgVar.zza(str, "connection"));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> acceptConnection(final String str, PayloadCallback payloadCallback) {
        final ListenerHolder registerListener = registerListener(payloadCallback, PayloadCallback.class.getName());
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                ((zzgz) obj).zzr(new zzig(zziiVar, (TaskCompletionSource) obj2), str, registerListener);
            }
        }).setMethodKey(1227).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> cancelPayload(final long j4) {
        return zzh(new zzie() { // from class: com.google.android.gms.internal.nearby.zzhs
            @Override // com.google.android.gms.internal.nearby.zzie
            public final void zza(zzgz zzgzVar, BaseImplementation.ResultHolder resultHolder) {
                long j5 = j4;
                int i4 = zzii.zza;
                zzgzVar.zzs(resultHolder, j5);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(final String str) {
        zzi(new zzih() { // from class: com.google.android.gms.internal.nearby.zzhq
            @Override // com.google.android.gms.internal.nearby.zzih
            public final void zza(zzgz zzgzVar) {
                String str2 = str;
                int i4 = zzii.zza;
                zzgzVar.zzt(str2);
            }
        });
        zzk(str);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> rejectConnection(final String str) {
        return zzh(new zzie() { // from class: com.google.android.gms.internal.nearby.zzhx
            @Override // com.google.android.gms.internal.nearby.zzie
            public final void zza(zzgz zzgzVar, BaseImplementation.ResultHolder resultHolder) {
                String str2 = str;
                int i4 = zzii.zza;
                zzgzVar.zzu(resultHolder, str2);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        final ListenerHolder registerListener = registerListener(new zzif(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzj(str2);
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                ((zzgz) obj).zzv(new zzig(zziiVar, (TaskCompletionSource) obj2), str, str2, registerListener);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzid(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final String str, final Payload payload) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                String str2 = str;
                ((zzgz) obj).zzz(new zzig(zziiVar, (TaskCompletionSource) obj2), new String[]{str2}, payload, false);
            }
        }).setMethodKey(1228).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback, final AdvertisingOptions advertisingOptions) {
        final ListenerHolder registerListener = registerListener(new zzif(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzb(this, new Object(), "advertising")).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                ((zzgz) obj).zzA(new zzig(zziiVar, (TaskCompletionSource) obj2), str, str2, registerListener, advertisingOptions);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzii.zza;
                ((zzgz) obj).zzD();
                ((TaskCompletionSource) obj2).setResult(Boolean.TRUE);
            }
        }).setMethodKey(1266).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startDiscovery(final String str, EndpointDiscoveryCallback endpointDiscoveryCallback, final DiscoveryOptions discoveryOptions) {
        final ListenerHolder zzb2 = this.zze.zzb(this, endpointDiscoveryCallback, "discovery");
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(zzb2).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                ((zzgz) obj).zzC(new zzig(zziiVar, (TaskCompletionSource) obj2), str, zzb2, discoveryOptions);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhk
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzii.zza;
                ((zzgz) obj).zzF();
                ((TaskCompletionSource) obj2).setResult(Boolean.TRUE);
            }
        }).setMethodKey(1267).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.internal.nearby.zzhl
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                zzii.this.zze(discoveryOptions, (Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.internal.nearby.zzhm
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Log.w("NearbyConnections", "Failed to start discovery.", exc);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.zze.zzf(this, "advertising");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        this.zze.zzf(this, "advertising");
        this.zze.zzf(this, "discovery").addOnSuccessListener(new zzhp(this));
        zzi(new zzih() { // from class: com.google.android.gms.internal.nearby.zzhn
            @Override // com.google.android.gms.internal.nearby.zzih
            public final void zza(zzgz zzgzVar) {
                int i4 = zzii.zza;
                zzgzVar.zzE();
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.nearby.zzho
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzii.this.zzf(task);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        this.zze.zzf(this, "discovery").addOnSuccessListener(new zzhp(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(DiscoveryOptions discoveryOptions, Void r22) {
        zzkq zzkqVar;
        if (!discoveryOptions.zzK() || (zzkqVar = this.zzf) == null) {
            return;
        }
        zzkqVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Task task) {
        this.zze.zzf(this, "connection");
        disconnectService();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(Void r12) {
        zzkq zzkqVar = this.zzf;
        if (zzkqVar != null) {
            zzkqVar.zzf();
        }
    }

    private zzii(Context context, @Nullable ConnectionsOptions connectionsOptions) {
        super(context, zzd, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzf = null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final List<String> list, final Payload payload) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhi
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                List list2 = list;
                ((zzgz) obj).zzz(new zzig(zziiVar, (TaskCompletionSource) obj2), (String[]) list2.toArray(new String[0]), payload, false);
            }
        }).setMethodKey(1228).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback, final ConnectionOptions connectionOptions) {
        final ListenerHolder registerListener = registerListener(new zzif(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzj(str2);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zzf).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhh
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                ((zzgz) obj).zzx(new zzig(zziiVar, (TaskCompletionSource) obj2), str, str2, registerListener, connectionOptions);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzia(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback, final AdvertisingOptions advertisingOptions) {
        final ListenerHolder registerListener = registerListener(new zzif(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzb(this, new Object(), "advertising")).setFeatures(com.google.android.gms.nearby.zza.zzf).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhv
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                ((zzgz) obj).zzB(new zzig(zziiVar, (TaskCompletionSource) obj2), bArr, str, registerListener, advertisingOptions);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhw
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzii.zza;
                ((zzgz) obj).zzD();
                ((TaskCompletionSource) obj2).setResult(Boolean.TRUE);
            }
        }).setMethodKey(1266).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback) {
        final ListenerHolder registerListener = registerListener(new zzif(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzj(str);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zzf).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhe
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                ((zzgz) obj).zzw(new zzig(zziiVar, (TaskCompletionSource) obj2), bArr, str, registerListener);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzic(this, str));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback, final ConnectionOptions connectionOptions) {
        final ListenerHolder registerListener = registerListener(new zzif(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzj(str);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zzf).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhb
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzii zziiVar = zzii.this;
                ((zzgz) obj).zzy(new zzig(zziiVar, (TaskCompletionSource) obj2), bArr, str, registerListener, connectionOptions);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzib(this, str));
    }
}
