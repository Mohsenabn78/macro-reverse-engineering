package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zznn;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzbh extends GoogleApi implements MessagesClient {

    /* renamed from: b */
    private static final Api.ClientKey f22440b;

    /* renamed from: c */
    private static final Api.AbstractClientBuilder f22441c;

    /* renamed from: d */
    private static final Api f22442d;
    public static final /* synthetic */ int zza = 0;

    /* renamed from: a */
    private final int f22443a;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f22440b = clientKey;
        zzav zzavVar = new zzav();
        f22441c = zzavVar;
        f22442d = new Api("Nearby.MESSAGES_API", zzavVar, clientKey);
    }

    public zzbh(Activity activity, @Nullable MessagesOptions messagesOptions) {
        super(activity, (Api<MessagesOptions>) f22442d, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.f22443a = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new zzbb(activity, this, null));
    }

    private final ListenerHolder h(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return registerListener(obj, obj.getClass().getName());
    }

    private final ListenerHolder i(TaskCompletionSource taskCompletionSource) {
        return registerListener(new zzay(this, taskCompletionSource), Status.class.getName());
    }

    private final Task j(ListenerHolder listenerHolder, final zzbc zzbcVar, final zzbc zzbcVar2, int i4) {
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.nearby.messages.internal.zzaq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzbh.this.d(zzbcVar, (zzai) obj, (TaskCompletionSource) obj2);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.nearby.messages.internal.zzar
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzbh.this.c(zzbcVar2, (zzai) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(i4).build());
    }

    private final Task k(Object obj, int i4) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Preconditions.checkNotNull(obj);
        doUnregisterEventListener(ListenerHolders.createListenerKey(obj, obj.getClass().getName()), i4).addOnCompleteListener(new zzaz(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task l(final zzbc zzbcVar, int i4) {
        return doWrite(TaskApiCall.builder().setMethodKey(i4).run(new RemoteCall() { // from class: com.google.android.gms.nearby.messages.internal.zzam
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzbh.this.g(zzbcVar, (zzai) obj, (TaskCompletionSource) obj2);
            }
        }).build());
    }

    public final /* synthetic */ void b(Message message, zzbe zzbeVar, PublishOptions publishOptions, zzai zzaiVar, ListenerHolder listenerHolder) throws RemoteException {
        zzaiVar.g(listenerHolder, zzae.zza(message), zzbeVar, publishOptions, this.f22443a);
    }

    public final /* synthetic */ void c(zzbc zzbcVar, zzai zzaiVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzbcVar.zza(zzaiVar, i(taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.GoogleApi
    public final ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder createClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            String str = ((MessagesOptions) getApiOptions()).zze;
        }
        return createClientSettingsBuilder;
    }

    public final /* synthetic */ void d(zzbc zzbcVar, zzai zzaiVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzbcVar.zza(zzaiVar, i(taskCompletionSource));
    }

    public final /* synthetic */ void e(ListenerHolder listenerHolder, zzbg zzbgVar, SubscribeOptions subscribeOptions, zzai zzaiVar, ListenerHolder listenerHolder2) throws RemoteException {
        zzaiVar.l(listenerHolder2, listenerHolder, zzbgVar, subscribeOptions, null, this.f22443a);
    }

    public final /* synthetic */ void f(PendingIntent pendingIntent, zzbg zzbgVar, SubscribeOptions subscribeOptions, zzai zzaiVar, ListenerHolder listenerHolder) throws RemoteException {
        zzaiVar.j(listenerHolder, pendingIntent, zzbgVar, subscribeOptions, this.f22443a);
    }

    public final /* synthetic */ void g(zzbc zzbcVar, zzai zzaiVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzbcVar.zza(zzaiVar, i(taskCompletionSource));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zznn.zzb(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message) {
        PublishOptions publishOptions = PublishOptions.DEFAULT;
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        ListenerHolder h4 = h(message);
        return j(h4, new zzau(this, message, new zzaw(this, h(publishOptions.getCallback()), h4), publishOptions), new zzak(message), 1291);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> registerStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        final ListenerHolder h4 = h(statusCallback);
        return j(h4, new zzbc() { // from class: com.google.android.gms.nearby.messages.internal.zzan
            @Override // com.google.android.gms.nearby.messages.internal.zzbc
            public final void zza(zzai zzaiVar, ListenerHolder listenerHolder) {
                ListenerHolder listenerHolder2 = ListenerHolder.this;
                int i4 = zzbh.zza;
                zzaiVar.h(listenerHolder, listenerHolder2);
            }
        }, new zzbc() { // from class: com.google.android.gms.nearby.messages.internal.zzao
            @Override // com.google.android.gms.nearby.messages.internal.zzbc
            public final void zza(zzai zzaiVar, ListenerHolder listenerHolder) {
                ListenerHolder listenerHolder2 = ListenerHolder.this;
                int i4 = zzbh.zza;
                zzaiVar.a(listenerHolder, listenerHolder2);
            }
        }, 1270);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent) {
        SubscribeOptions subscribeOptions = SubscribeOptions.DEFAULT;
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        ListenerHolder h4 = h(subscribeOptions.getCallback());
        return l(new zzaj(this, pendingIntent, h4 == null ? null : new zzbg(h4), subscribeOptions), 1288);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unpublish(Message message) {
        Preconditions.checkNotNull(message);
        return k(message, 1290);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unregisterStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return k(statusCallback, 1271);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(final PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        return l(new zzbc() { // from class: com.google.android.gms.nearby.messages.internal.zzal
            @Override // com.google.android.gms.nearby.messages.internal.zzbc
            public final void zza(zzai zzaiVar, ListenerHolder listenerHolder) {
                PendingIntent pendingIntent2 = pendingIntent;
                int i4 = zzbh.zza;
                zzaiVar.b(listenerHolder, pendingIntent2);
            }
        }, 1287);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(MessageListener messageListener) {
        Preconditions.checkNotNull(messageListener);
        return k(messageListener, 1286);
    }

    public zzbh(Context context, @Nullable MessagesOptions messagesOptions) {
        super(context, f22442d, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.f22443a = zzai.d(context);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message, PublishOptions publishOptions) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        ListenerHolder h4 = h(message);
        return j(h4, new zzau(this, message, new zzaw(this, h(publishOptions.getCallback()), h4), publishOptions), new zzak(message), 1291);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        ListenerHolder h4 = h(subscribeOptions.getCallback());
        return l(new zzaj(this, pendingIntent, h4 == null ? null : new zzbg(h4), subscribeOptions), 1288);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener) {
        SubscribeOptions subscribeOptions = SubscribeOptions.DEFAULT;
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder h4 = h(messageListener);
        ListenerHolder h5 = h(subscribeOptions.getCallback());
        return j(h4, new zzas(this, h4, new zzax(this, h5, h5), subscribeOptions), new zzat(h4), 1289);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder h4 = h(messageListener);
        ListenerHolder h5 = h(subscribeOptions.getCallback());
        return j(h4, new zzas(this, h4, new zzax(this, h5, h5), subscribeOptions), new zzat(h4), 1289);
    }
}
