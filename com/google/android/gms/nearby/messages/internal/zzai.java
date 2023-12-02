package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.nearby.zznn;
import com.google.android.gms.internal.nearby.zznp;
import com.google.android.gms.internal.nearby.zzns;
import com.google.android.gms.internal.nearby.zznt;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzai extends GmsClient {

    /* renamed from: a  reason: collision with root package name */
    private final zznt f22425a;

    /* renamed from: b  reason: collision with root package name */
    private final ClientAppContext f22426b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22427c;

    @TargetApi(14)
    private zzai(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        super(context, looper, 62, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f22425a = new zznt();
        String realClientPackageName = clientSettings.getRealClientPackageName();
        int d4 = d(context);
        if (messagesOptions != null) {
            this.f22426b = new ClientAppContext(1, realClientPackageName, null, false, d4, null);
            this.f22427c = messagesOptions.zzc;
            return;
        }
        this.f22426b = new ClientAppContext(1, realClientPackageName, null, false, d4, null);
        this.f22427c = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        if (context instanceof Service) {
            return 3;
        }
        return 0;
    }

    public static zzai zzq(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        zzai zzaiVar = new zzai(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings, messagesOptions);
        if (d(context) == 1 && PlatformVersion.isAtLeastIceCreamSandwich()) {
            Activity activity = (Activity) context;
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName());
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new zzah(activity, zzaiVar, null));
        }
        return zzaiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        zznp zznpVar = new zznp(listenerHolder);
        if (!this.f22425a.zze(listenerKey)) {
            zznpVar.zzd(new Status(0));
            return;
        }
        zzcb zzcbVar = new zzcb(zznpVar, (IBinder) this.f22425a.zza(listenerKey));
        zzcbVar.zzd = false;
        ((zzs) getService()).zzg(zzcbVar);
        this.f22425a.zzd(listenerKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(ListenerHolder listenerHolder, PendingIntent pendingIntent) throws RemoteException {
        ((zzs) getService()).zzj(new zzcg(null, new zznp(listenerHolder), pendingIntent));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        zznp zznpVar = new zznp(listenerHolder);
        if (!this.f22425a.zze(listenerKey)) {
            zznpVar.zzd(new Status(0));
            return;
        }
        ((zzs) getService()).zzj(new zzcg((IBinder) this.f22425a.zza(listenerKey), zznpVar, null));
        this.f22425a.zzd(listenerKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        if (queryLocalInterface instanceof zzs) {
            return (zzs) queryLocalInterface;
        }
        return new zzs(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        try {
            e(2);
        } catch (RemoteException e4) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e4);
            }
        }
        this.f22425a.zzb();
        super.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(int i4) throws RemoteException {
        String str;
        if (i4 != 1) {
            str = "CLIENT_DISCONNECTED";
        } else {
            str = "ACTIVITY_STOPPED";
        }
        if (isConnected()) {
            zzj zzjVar = new zzj(1, null, i4);
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                String.format("Emitting client lifecycle event %s", str);
            }
            ((zzs) getService()).zze(zzjVar);
        } else if (Log.isLoggable("NearbyMessagesClient", 3)) {
            String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void f(ListenerHolder listenerHolder, zzae zzaeVar, @Nullable zzu zzuVar, PublishOptions publishOptions) throws RemoteException {
        g(listenerHolder, zzaeVar, zzuVar, publishOptions, this.f22426b.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(ListenerHolder listenerHolder, zzae zzaeVar, @Nullable zzu zzuVar, PublishOptions publishOptions, int i4) throws RemoteException {
        ((zzs) getService()).zzf(new zzbz(2, zzaeVar, publishOptions.getStrategy(), new zznp(listenerHolder), null, null, false, zzuVar, false, null, i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        getServiceRequestExtraArgs.putInt("NearbyPermissions", this.f22427c);
        getServiceRequestExtraArgs.putParcelable("ClientAppContext", this.f22426b);
        return getServiceRequestExtraArgs;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        if (!this.f22425a.zze(listenerKey)) {
            this.f22425a.zzc(listenerKey, new zzns(listenerHolder2));
        }
        zzcb zzcbVar = new zzcb(new zznp(listenerHolder), (IBinder) this.f22425a.zza(listenerKey));
        zzcbVar.zzd = true;
        ((zzs) getService()).zzg(zzcbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void i(ListenerHolder listenerHolder, PendingIntent pendingIntent, @Nullable zzaa zzaaVar, SubscribeOptions subscribeOptions) throws RemoteException {
        j(listenerHolder, pendingIntent, zzaaVar, subscribeOptions, this.f22426b.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(ListenerHolder listenerHolder, PendingIntent pendingIntent, @Nullable zzaa zzaaVar, SubscribeOptions subscribeOptions, int i4) throws RemoteException {
        ((zzs) getService()).zzh(new SubscribeRequest(null, subscribeOptions.getStrategy(), new zznp(listenerHolder), subscribeOptions.getFilter(), pendingIntent, null, zzaaVar, false, 0, this.f22426b.zze));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void k(ListenerHolder listenerHolder, ListenerHolder listenerHolder2, @Nullable zzaa zzaaVar, SubscribeOptions subscribeOptions, @Nullable byte[] bArr) throws RemoteException {
        l(listenerHolder, listenerHolder2, zzaaVar, subscribeOptions, null, this.f22426b.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(ListenerHolder listenerHolder, ListenerHolder listenerHolder2, @Nullable zzaa zzaaVar, SubscribeOptions subscribeOptions, @Nullable byte[] bArr, int i4) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        if (!this.f22425a.zze(listenerKey)) {
            this.f22425a.zzc(listenerKey, new zznn(listenerHolder2));
        }
        ((zzs) getService()).zzh(new SubscribeRequest((IBinder) this.f22425a.zza(listenerKey), subscribeOptions.getStrategy(), new zznp(listenerHolder), subscribeOptions.getFilter(), null, null, zzaaVar, false, 0, i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(ListenerHolder listenerHolder, zzae zzaeVar) throws RemoteException {
        ((zzs) getService()).zzi(new zzce(1, zzaeVar, new zznp(listenerHolder), null, null, false, null));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }
}
