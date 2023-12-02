package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzim extends GmsClient {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f22817a;

    /* renamed from: b  reason: collision with root package name */
    private final zzff f22818b;

    /* renamed from: c  reason: collision with root package name */
    private final zzff f22819c;

    /* renamed from: d  reason: collision with root package name */
    private final zzff f22820d;

    /* renamed from: e  reason: collision with root package name */
    private final zzff f22821e;

    /* renamed from: f  reason: collision with root package name */
    private final zzff f22822f;

    /* renamed from: g  reason: collision with root package name */
    private final zzff f22823g;

    /* renamed from: h  reason: collision with root package name */
    private final zzff f22824h;

    /* renamed from: i  reason: collision with root package name */
    private final zzff f22825i;

    /* renamed from: j  reason: collision with root package name */
    private final zzff f22826j;

    /* renamed from: k  reason: collision with root package name */
    private final zzff f22827k;

    /* renamed from: l  reason: collision with root package name */
    private final zziu f22828l;

    /* renamed from: m  reason: collision with root package name */
    private final File f22829m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzim(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        super(context, looper, 14, clientSettings, connectionCallbacks, onConnectionFailedListener);
        com.google.android.gms.internal.wearable.zzh.zza();
        ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        zziu zza = zziu.zza(context);
        this.f22818b = new zzff();
        this.f22819c = new zzff();
        this.f22820d = new zzff();
        this.f22821e = new zzff();
        this.f22822f = new zzff();
        this.f22823g = new zzff();
        this.f22824h = new zzff();
        this.f22825i = new zzff();
        this.f22826j = new zzff();
        this.f22827k = new zzff();
        this.f22817a = (ExecutorService) Preconditions.checkNotNull(unconfigurableExecutorService);
        this.f22828l = zza;
        File file = new File(new File(context.getFilesDir(), "wearos_assets"), "streamtmp");
        file.mkdirs();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
        this.f22829m = file;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(@NonNull BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        int i4;
        if (!requiresGooglePlayServices()) {
            try {
                Bundle bundle = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
                if (bundle != null) {
                    i4 = bundle.getInt("com.google.android.wearable.api.version", 0);
                } else {
                    i4 = 0;
                }
                if (i4 < 8600000) {
                    Log.w("WearableClient", "The Wear OS app is out of date. Requires API version 8600000 but found " + i4);
                    Context context = getContext();
                    Context context2 = getContext();
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    triggerNotAvailable(connectionProgressReportCallbacks, 6, PendingIntent.getActivity(context, 0, intent, com.google.android.gms.internal.wearable.zzd.zza));
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                triggerNotAvailable(connectionProgressReportCallbacks, 16, null);
                return;
            }
        }
        super.connect(connectionProgressReportCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        if (queryLocalInterface instanceof zzfb) {
            return (zzfb) queryLocalInterface;
        }
        return new zzfb(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.wearable.zze.zzo;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 8600000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServicePackage() {
        if (this.f22828l.zzb("com.google.android.wearable.app.cn")) {
            return "com.google.android.wearable.app.cn";
        }
        return "com.google.android.gms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i4, IBinder iBinder, Bundle bundle, int i5) {
        if (Log.isLoggable("WearableClient", 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPostInitHandler: statusCode ");
            sb.append(i4);
        }
        if (i4 == 0) {
            this.f22818b.b(iBinder);
            this.f22819c.b(iBinder);
            this.f22820d.b(iBinder);
            this.f22822f.b(iBinder);
            this.f22823g.b(iBinder);
            this.f22824h.b(iBinder);
            this.f22825i.b(iBinder);
            this.f22826j.b(iBinder);
            this.f22827k.b(iBinder);
            this.f22821e.b(iBinder);
            i4 = 0;
        }
        super.onPostInitHandler(i4, iBinder, bundle, i5);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        if (!this.f22828l.zzb("com.google.android.wearable.app.cn")) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(BaseImplementation.ResultHolder resultHolder, MessageApi.MessageListener messageListener) throws RemoteException {
        this.f22823g.c(this, resultHolder, messageListener);
    }

    public final void zzB(BaseImplementation.ResultHolder resultHolder, MessageClient.RpcService rpcService) throws RemoteException {
        this.f22824h.c(this, resultHolder, rpcService);
    }

    public final void zzC(BaseImplementation.ResultHolder resultHolder, String str, Uri uri, long j4, long j5) {
        boolean z3;
        boolean z4;
        try {
            ExecutorService executorService = this.f22817a;
            Preconditions.checkNotNull(resultHolder);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(uri);
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "startOffset is negative: %s", Long.valueOf(j4));
            if (j5 >= -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "invalid length: %s", Long.valueOf(j5));
            executorService.execute(new zzil(this, uri, resultHolder, str, j4, j5));
        } catch (RuntimeException e4) {
            resultHolder.setFailedResult(new Status(8));
            throw e4;
        }
    }

    public final void zzp(BaseImplementation.ResultHolder resultHolder, CapabilityApi.CapabilityListener capabilityListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) throws RemoteException {
        this.f22827k.a(this, resultHolder, capabilityListener, zzit.zzk(listenerHolder, intentFilterArr));
    }

    public final void zzq(BaseImplementation.ResultHolder resultHolder, ChannelApi.ChannelListener channelListener, ListenerHolder listenerHolder, @Nullable String str, IntentFilter[] intentFilterArr) throws RemoteException {
        if (str == null) {
            this.f22820d.a(this, resultHolder, channelListener, zzit.zzm(listenerHolder, intentFilterArr));
            return;
        }
        this.f22820d.a(this, resultHolder, new zzhe(str, channelListener), zzit.zzn(listenerHolder, str, intentFilterArr));
    }

    public final void zzr(BaseImplementation.ResultHolder resultHolder, DataApi.DataListener dataListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) throws RemoteException {
        this.f22822f.a(this, resultHolder, dataListener, zzit.zzo(listenerHolder, intentFilterArr));
    }

    public final void zzs(BaseImplementation.ResultHolder resultHolder, MessageApi.MessageListener messageListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) throws RemoteException {
        this.f22823g.a(this, resultHolder, messageListener, zzit.zzp(listenerHolder, intentFilterArr));
    }

    public final void zzt(BaseImplementation.ResultHolder resultHolder, MessageClient.RpcService rpcService, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) throws RemoteException {
        this.f22824h.a(this, resultHolder, rpcService, zzit.zzq(listenerHolder, intentFilterArr));
    }

    public final void zzu(BaseImplementation.ResultHolder resultHolder, Asset asset) throws RemoteException {
        ((zzfb) getService()).zzr(new zzhz(resultHolder), asset);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzv(com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder r14, com.google.android.gms.wearable.PutDataRequest r15) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzim.zzv(com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder, com.google.android.gms.wearable.PutDataRequest):void");
    }

    public final void zzw(BaseImplementation.ResultHolder resultHolder, String str, Uri uri, boolean z3) {
        try {
            ExecutorService executorService = this.f22817a;
            Preconditions.checkNotNull(resultHolder);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(uri);
            executorService.execute(new zzik(this, uri, resultHolder, z3, str));
        } catch (RuntimeException e4) {
            resultHolder.setFailedResult(new Status(8));
            throw e4;
        }
    }

    public final void zzx(BaseImplementation.ResultHolder resultHolder, CapabilityApi.CapabilityListener capabilityListener) throws RemoteException {
        this.f22827k.c(this, resultHolder, capabilityListener);
    }

    public final void zzy(BaseImplementation.ResultHolder resultHolder, ChannelApi.ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.f22820d.c(this, resultHolder, channelListener);
            return;
        }
        this.f22820d.c(this, resultHolder, new zzhe(str, channelListener));
    }

    public final void zzz(BaseImplementation.ResultHolder resultHolder, DataApi.DataListener dataListener) throws RemoteException {
        this.f22822f.c(this, resultHolder, dataListener);
    }
}
