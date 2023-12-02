package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes4.dex */
public class GoogleApiManager implements Handler.Callback {
    @Nullable
    @GuardedBy("lock")

    /* renamed from: r  reason: collision with root package name */
    private static GoogleApiManager f20051r;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private TelemetryData f20054c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private TelemetryLoggingClient f20055d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f20056e;

    /* renamed from: f  reason: collision with root package name */
    private final GoogleApiAvailability f20057f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.gms.common.internal.zal f20058g;
    @NotOnlyInitialized

    /* renamed from: n  reason: collision with root package name */
    private final Handler f20065n;

    /* renamed from: o  reason: collision with root package name */
    private volatile boolean f20066o;
    @NonNull
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: p  reason: collision with root package name */
    private static final Status f20049p = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: q  reason: collision with root package name */
    private static final Object f20050q = new Object();

    /* renamed from: a  reason: collision with root package name */
    private long f20052a = 10000;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20053b = false;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f20059h = new AtomicInteger(1);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f20060i = new AtomicInteger(0);

    /* renamed from: j  reason: collision with root package name */
    private final Map f20061j = new ConcurrentHashMap(5, 0.75f, 1);
    @Nullable
    @GuardedBy("lock")

    /* renamed from: k  reason: collision with root package name */
    private zaae f20062k = null;
    @GuardedBy("lock")

    /* renamed from: l  reason: collision with root package name */
    private final Set f20063l = new ArraySet();

    /* renamed from: m  reason: collision with root package name */
    private final Set f20064m = new ArraySet();

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f20066o = true;
        this.f20056e = context;
        com.google.android.gms.internal.base.zau zauVar = new com.google.android.gms.internal.base.zau(looper, this);
        this.f20065n = zauVar;
        this.f20057f = googleApiAvailability;
        this.f20058g = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.f20066o = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status e(ApiKey apiKey, ConnectionResult connectionResult) {
        String zaa2 = apiKey.zaa();
        String valueOf = String.valueOf(connectionResult);
        return new Status(connectionResult, "API: " + zaa2 + " is not available on this device. Connection failed with: " + valueOf);
    }

    @ResultIgnorabilityUnspecified
    @WorkerThread
    private final zabq f(GoogleApi googleApi) {
        ApiKey apiKey = googleApi.getApiKey();
        zabq zabqVar = (zabq) this.f20061j.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            this.f20061j.put(apiKey, zabqVar);
        }
        if (zabqVar.zaz()) {
            this.f20064m.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    @WorkerThread
    private final TelemetryLoggingClient g() {
        if (this.f20055d == null) {
            this.f20055d = TelemetryLogging.getClient(this.f20056e);
        }
        return this.f20055d;
    }

    @WorkerThread
    private final void h() {
        TelemetryData telemetryData = this.f20054c;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || c()) {
                g().log(telemetryData);
            }
            this.f20054c = null;
        }
    }

    private final void i(TaskCompletionSource taskCompletionSource, int i4, GoogleApi googleApi) {
        zacd a4;
        if (i4 != 0 && (a4 = zacd.a(this, i4, googleApi.getApiKey())) != null) {
            Task task = taskCompletionSource.getTask();
            final Handler handler = this.f20065n;
            handler.getClass();
            task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.zabk
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, a4);
        }
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (f20050q) {
            GoogleApiManager googleApiManager = f20051r;
            if (googleApiManager != null) {
                googleApiManager.f20060i.incrementAndGet();
                Handler handler = googleApiManager.f20065n;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    @NonNull
    public static GoogleApiManager zaj() {
        GoogleApiManager googleApiManager;
        synchronized (f20050q) {
            Preconditions.checkNotNull(f20051r, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = f20051r;
        }
        return googleApiManager;
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public static GoogleApiManager zak(@NonNull Context context) {
        GoogleApiManager googleApiManager;
        synchronized (f20050q) {
            if (f20051r == null) {
                f20051r = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = f20051r;
        }
        return googleApiManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(@NonNull zaae zaaeVar) {
        synchronized (f20050q) {
            if (this.f20062k == zaaeVar) {
                this.f20062k = null;
                this.f20063l.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean c() {
        if (this.f20053b) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int zaa2 = this.f20058g.zaa(this.f20056e, 203400000);
        if (zaa2 != -1 && zaa2 != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ResultIgnorabilityUnspecified
    public final boolean d(ConnectionResult connectionResult, int i4) {
        return this.f20057f.zah(this.f20056e, connectionResult, i4);
    }

    @Override // android.os.Handler.Callback
    @WorkerThread
    public final boolean handleMessage(@NonNull Message message) {
        ApiKey apiKey;
        ApiKey apiKey2;
        ApiKey apiKey3;
        ApiKey apiKey4;
        int i4 = message.what;
        long j4 = 300000;
        zabq zabqVar = null;
        switch (i4) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j4 = 10000;
                }
                this.f20052a = j4;
                this.f20065n.removeMessages(12);
                for (ApiKey apiKey5 : this.f20061j.keySet()) {
                    Handler handler = this.f20065n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, apiKey5), this.f20052a);
                }
                break;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator it = zalVar.zab().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        ApiKey apiKey6 = (ApiKey) it.next();
                        zabq zabqVar2 = (zabq) this.f20061j.get(apiKey6);
                        if (zabqVar2 == null) {
                            zalVar.zac(apiKey6, new ConnectionResult(13), null);
                            break;
                        } else if (zabqVar2.x()) {
                            zalVar.zac(apiKey6, ConnectionResult.RESULT_SUCCESS, zabqVar2.zaf().getEndpointPackageName());
                        } else {
                            ConnectionResult zad = zabqVar2.zad();
                            if (zad != null) {
                                zalVar.zac(apiKey6, zad, null);
                            } else {
                                zabqVar2.zat(zalVar);
                                zabqVar2.zao();
                            }
                        }
                    }
                }
            case 3:
                for (zabq zabqVar3 : this.f20061j.values()) {
                    zabqVar3.zan();
                    zabqVar3.zao();
                }
                break;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq zabqVar4 = (zabq) this.f20061j.get(zachVar.zac.getApiKey());
                if (zabqVar4 == null) {
                    zabqVar4 = f(zachVar.zac);
                }
                if (zabqVar4.zaz() && this.f20060i.get() != zachVar.zab) {
                    zachVar.zaa.zad(zaa);
                    zabqVar4.zav();
                    break;
                } else {
                    zabqVar4.zap(zachVar.zaa);
                    break;
                }
            case 5:
                int i5 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it2 = this.f20061j.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zabq zabqVar5 = (zabq) it2.next();
                        if (zabqVar5.zab() == i5) {
                            zabqVar = zabqVar5;
                        }
                    }
                }
                if (zabqVar != null) {
                    if (connectionResult.getErrorCode() == 13) {
                        String errorString = this.f20057f.getErrorString(connectionResult.getErrorCode());
                        String errorMessage = connectionResult.getErrorMessage();
                        zabq.q(zabqVar, new Status(17, "Error resolution was canceled by the user, original error message: " + errorString + ": " + errorMessage));
                        break;
                    } else {
                        zabq.q(zabqVar, e(zabq.p(zabqVar), connectionResult));
                        break;
                    }
                } else {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i5 + " while trying to fail enqueued calls.", new Exception());
                    break;
                }
            case 6:
                if (this.f20056e.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.f20056e.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabl(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.f20052a = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                f((GoogleApi) message.obj);
                break;
            case 9:
                if (this.f20061j.containsKey(message.obj)) {
                    ((zabq) this.f20061j.get(message.obj)).zau();
                    break;
                }
                break;
            case 10:
                for (ApiKey apiKey7 : this.f20064m) {
                    zabq zabqVar6 = (zabq) this.f20061j.remove(apiKey7);
                    if (zabqVar6 != null) {
                        zabqVar6.zav();
                    }
                }
                this.f20064m.clear();
                break;
            case 11:
                if (this.f20061j.containsKey(message.obj)) {
                    ((zabq) this.f20061j.get(message.obj)).zaw();
                    break;
                }
                break;
            case 12:
                if (this.f20061j.containsKey(message.obj)) {
                    ((zabq) this.f20061j.get(message.obj)).zaA();
                    break;
                }
                break;
            case 14:
                zaaf zaafVar = (zaaf) message.obj;
                ApiKey a4 = zaafVar.a();
                if (!this.f20061j.containsKey(a4)) {
                    zaafVar.b().setResult(Boolean.FALSE);
                    break;
                } else {
                    zaafVar.b().setResult(Boolean.valueOf(zabq.w((zabq) this.f20061j.get(a4), false)));
                    break;
                }
            case 15:
                zabs zabsVar = (zabs) message.obj;
                Map map = this.f20061j;
                apiKey = zabsVar.f20253a;
                if (map.containsKey(apiKey)) {
                    Map map2 = this.f20061j;
                    apiKey2 = zabsVar.f20253a;
                    zabq.t((zabq) map2.get(apiKey2), zabsVar);
                    break;
                }
                break;
            case 16:
                zabs zabsVar2 = (zabs) message.obj;
                Map map3 = this.f20061j;
                apiKey3 = zabsVar2.f20253a;
                if (map3.containsKey(apiKey3)) {
                    Map map4 = this.f20061j;
                    apiKey4 = zabsVar2.f20253a;
                    zabq.u((zabq) map4.get(apiKey4), zabsVar2);
                    break;
                }
                break;
            case 17:
                h();
                break;
            case 18:
                zace zaceVar = (zace) message.obj;
                if (zaceVar.f20274c == 0) {
                    g().log(new TelemetryData(zaceVar.f20273b, Arrays.asList(zaceVar.f20272a)));
                    break;
                } else {
                    TelemetryData telemetryData = this.f20054c;
                    if (telemetryData != null) {
                        List zab = telemetryData.zab();
                        if (telemetryData.zaa() == zaceVar.f20273b && (zab == null || zab.size() < zaceVar.f20275d)) {
                            this.f20054c.zac(zaceVar.f20272a);
                        } else {
                            this.f20065n.removeMessages(17);
                            h();
                        }
                    }
                    if (this.f20054c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zaceVar.f20272a);
                        this.f20054c = new TelemetryData(zaceVar.f20273b, arrayList);
                        Handler handler2 = this.f20065n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), zaceVar.f20274c);
                        break;
                    }
                }
                break;
            case 19:
                this.f20053b = false;
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i4);
                return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zabq q(ApiKey apiKey) {
        return (zabq) this.f20061j.get(apiKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(MethodInvocation methodInvocation, int i4, long j4, int i5) {
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(18, new zace(methodInvocation, i4, j4, i5)));
    }

    public final void zaA(@NonNull zaae zaaeVar) {
        synchronized (f20050q) {
            if (this.f20062k != zaaeVar) {
                this.f20062k = zaaeVar;
                this.f20063l.clear();
            }
            this.f20063l.addAll(zaaeVar.h());
        }
    }

    public final int zaa() {
        return this.f20059h.getAndIncrement();
    }

    @NonNull
    public final Task zam(@NonNull Iterable iterable) {
        zal zalVar = new zal(iterable);
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(2, zalVar));
        return zalVar.zaa();
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public final Task zan(@NonNull GoogleApi googleApi) {
        zaaf zaafVar = new zaaf(googleApi.getApiKey());
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(14, zaafVar));
        return zaafVar.b().getTask();
    }

    @NonNull
    public final Task zao(@NonNull GoogleApi googleApi, @NonNull RegisterListenerMethod registerListenerMethod, @NonNull UnregisterListenerMethod unregisterListenerMethod, @NonNull Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        i(taskCompletionSource, registerListenerMethod.zaa(), googleApi);
        zaf zafVar = new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(8, new zach(zafVar, this.f20060i.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final Task zap(@NonNull GoogleApi googleApi, @NonNull ListenerHolder.ListenerKey listenerKey, int i4) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        i(taskCompletionSource, i4, googleApi);
        zah zahVar = new zah(listenerKey, taskCompletionSource);
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(13, new zach(zahVar, this.f20060i.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final void zau(@NonNull GoogleApi googleApi, int i4, @NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zae zaeVar = new zae(i4, apiMethodImpl);
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(4, new zach(zaeVar, this.f20060i.get(), googleApi)));
    }

    public final void zav(@NonNull GoogleApi googleApi, int i4, @NonNull TaskApiCall taskApiCall, @NonNull TaskCompletionSource taskCompletionSource, @NonNull StatusExceptionMapper statusExceptionMapper) {
        i(taskCompletionSource, taskApiCall.zaa(), googleApi);
        zag zagVar = new zag(i4, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(4, new zach(zagVar, this.f20060i.get(), googleApi)));
    }

    public final void zax(@NonNull ConnectionResult connectionResult, int i4) {
        if (!d(connectionResult, i4)) {
            Handler handler = this.f20065n;
            handler.sendMessage(handler.obtainMessage(5, i4, 0, connectionResult));
        }
    }

    public final void zay() {
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void zaz(@NonNull GoogleApi googleApi) {
        Handler handler = this.f20065n;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }
}
