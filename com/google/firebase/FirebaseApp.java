package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.arlosoft.macrodroid.action.activities.SelectionDialogActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.provider.FirebaseInitProvider;
import com.google.firebase.tracing.ComponentMonitor;
import com.google.firebase.tracing.FirebaseTrace;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class FirebaseApp {
    @NonNull
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";

    /* renamed from: k  reason: collision with root package name */
    private static final Object f28695k = new Object();
    @GuardedBy("LOCK")

    /* renamed from: l  reason: collision with root package name */
    static final Map<String, FirebaseApp> f28696l = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    private final Context f28697a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28698b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseOptions f28699c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentRuntime f28700d;

    /* renamed from: g  reason: collision with root package name */
    private final Lazy<DataCollectionConfigStorage> f28703g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DefaultHeartBeatController> f28704h;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f28701e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f28702f = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    private final List<BackgroundStateChangeListener> f28705i = new CopyOnWriteArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final List<FirebaseAppLifecycleListener> f28706j = new CopyOnWriteArrayList();

    @KeepForSdk
    /* loaded from: classes5.dex */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* loaded from: classes5.dex */
    public static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<GlobalBackgroundStateListener> f28707a = new AtomicReference<>();

        private GlobalBackgroundStateListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f28707a.get() == null) {
                    GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                    if (androidx.compose.animation.core.d.a(f28707a, null, globalBackgroundStateListener)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(globalBackgroundStateListener);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z3) {
            synchronized (FirebaseApp.f28695k) {
                Iterator it = new ArrayList(FirebaseApp.f28696l.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.f28701e.get()) {
                        firebaseApp.m(z3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes5.dex */
    public static class UserUnlockReceiver extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference<UserUnlockReceiver> f28708b = new AtomicReference<>();

        /* renamed from: a  reason: collision with root package name */
        private final Context f28709a;

        public UserUnlockReceiver(Context context) {
            this.f28709a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f28708b.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                if (androidx.compose.animation.core.d.a(f28708b, null, userUnlockReceiver)) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f28709a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f28695k) {
                for (FirebaseApp firebaseApp : FirebaseApp.f28696l.values()) {
                    firebaseApp.i();
                }
            }
            c();
        }
    }

    protected FirebaseApp(final Context context, String str, FirebaseOptions firebaseOptions) {
        this.f28697a = (Context) Preconditions.checkNotNull(context);
        this.f28698b = Preconditions.checkNotEmpty(str);
        this.f28699c = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        StartupTime startupTime = FirebaseInitProvider.getStartupTime();
        FirebaseTrace.pushTrace("Firebase");
        FirebaseTrace.pushTrace("ComponentDiscovery");
        List<Provider<ComponentRegistrar>> discoverLazy = ComponentDiscovery.forContext(context, ComponentDiscoveryService.class).discoverLazy();
        FirebaseTrace.popTrace();
        FirebaseTrace.pushTrace("Runtime");
        ComponentRuntime.Builder processor = ComponentRuntime.builder(UiExecutor.INSTANCE).addLazyComponentRegistrars(discoverLazy).addComponentRegistrar(new FirebaseCommonRegistrar()).addComponentRegistrar(new ExecutorsRegistrar()).addComponent(Component.of(context, Context.class, new Class[0])).addComponent(Component.of(this, FirebaseApp.class, new Class[0])).addComponent(Component.of(firebaseOptions, FirebaseOptions.class, new Class[0])).setProcessor(new ComponentMonitor());
        if (UserManagerCompat.isUserUnlocked(context) && FirebaseInitProvider.isCurrentlyInitializing()) {
            processor.addComponent(Component.of(startupTime, StartupTime.class, new Class[0]));
        }
        ComponentRuntime build = processor.build();
        this.f28700d = build;
        FirebaseTrace.popTrace();
        this.f28703g = new Lazy<>(new Provider() { // from class: com.google.firebase.a
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                DataCollectionConfigStorage j4;
                j4 = FirebaseApp.this.j(context);
                return j4;
            }
        });
        this.f28704h = build.getProvider(DefaultHeartBeatController.class);
        addBackgroundStateChangeListener(new BackgroundStateChangeListener() { // from class: com.google.firebase.b
            @Override // com.google.firebase.FirebaseApp.BackgroundStateChangeListener
            public final void onBackgroundStateChanged(boolean z3) {
                FirebaseApp.this.k(z3);
            }
        });
        FirebaseTrace.popTrace();
    }

    @VisibleForTesting
    public static void clearInstancesForTest() {
        synchronized (f28695k) {
            f28696l.clear();
        }
    }

    private void g() {
        Preconditions.checkState(!this.f28702f.get(), "FirebaseApp was deleted");
    }

    @NonNull
    public static List<FirebaseApp> getApps(@NonNull Context context) {
        ArrayList arrayList;
        synchronized (f28695k) {
            arrayList = new ArrayList(f28696l.values());
        }
        return arrayList;
    }

    @NonNull
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (f28695k) {
            firebaseApp = f28696l.get(DEFAULT_APP_NAME);
            if (firebaseApp != null) {
                firebaseApp.f28704h.get().registerHeartBeat();
            } else {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    private static List<String> h() {
        ArrayList arrayList = new ArrayList();
        synchronized (f28695k) {
            for (FirebaseApp firebaseApp : f28696l.values()) {
                arrayList.add(firebaseApp.getName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!UserManagerCompat.isUserUnlocked(this.f28697a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + getName());
            UserUnlockReceiver.b(this.f28697a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + getName());
        this.f28700d.initializeEagerComponents(isDefaultApp());
        this.f28704h.get().registerHeartBeat();
    }

    @Nullable
    public static FirebaseApp initializeApp(@NonNull Context context) {
        synchronized (f28695k) {
            if (f28696l.containsKey(DEFAULT_APP_NAME)) {
                return getInstance();
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return initializeApp(context, fromResource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DataCollectionConfigStorage j(Context context) {
        return new DataCollectionConfigStorage(context, getPersistenceKey(), (Publisher) this.f28700d.get(Publisher.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(boolean z3) {
        if (!z3) {
            this.f28704h.get().registerHeartBeat();
        }
    }

    private static String l(@NonNull String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z3) {
        for (BackgroundStateChangeListener backgroundStateChangeListener : this.f28705i) {
            backgroundStateChangeListener.onBackgroundStateChanged(z3);
        }
    }

    private void n() {
        for (FirebaseAppLifecycleListener firebaseAppLifecycleListener : this.f28706j) {
            firebaseAppLifecycleListener.onDeleted(this.f28698b, this.f28699c);
        }
    }

    @KeepForSdk
    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        g();
        if (this.f28701e.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.f28705i.add(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void addLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        g();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.f28706j.add(firebaseAppLifecycleListener);
    }

    public void delete() {
        if (!this.f28702f.compareAndSet(false, true)) {
            return;
        }
        synchronized (f28695k) {
            f28696l.remove(this.f28698b);
        }
        n();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.f28698b.equals(((FirebaseApp) obj).getName());
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        g();
        return (T) this.f28700d.get(cls);
    }

    @NonNull
    public Context getApplicationContext() {
        g();
        return this.f28697a;
    }

    @NonNull
    public String getName() {
        g();
        return this.f28698b;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        g();
        return this.f28699c;
    }

    @KeepForSdk
    public String getPersistenceKey() {
        return Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())) + Marker.ANY_NON_NULL_MARKER + Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.f28698b.hashCode();
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        g();
        return this.f28703g.get().isEnabled();
    }

    @KeepForSdk
    @VisibleForTesting
    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    @KeepForSdk
    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        g();
        this.f28705i.remove(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void removeLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        g();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.f28706j.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z3) {
        g();
        if (this.f28701e.compareAndSet(!z3, z3)) {
            boolean isInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z3 && isInBackground) {
                m(true);
            } else if (!z3 && isInBackground) {
                m(false);
            }
        }
    }

    @KeepForSdk
    public void setDataCollectionDefaultEnabled(Boolean bool) {
        g();
        this.f28703g.get().setEnabled(bool);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f28698b).add(SelectionDialogActivity.EXTRA_OPTIONS, this.f28699c).toString();
    }

    @KeepForSdk
    @Deprecated
    public void setDataCollectionDefaultEnabled(boolean z3) {
        setDataCollectionDefaultEnabled(Boolean.valueOf(z3));
    }

    @KeepForSdk
    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return Base64Utils.encodeUrlSafeNoPadding(str.getBytes(Charset.defaultCharset())) + Marker.ANY_NON_NULL_MARKER + Base64Utils.encodeUrlSafeNoPadding(firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset()));
    }

    @NonNull
    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        List<String> h4;
        String str2;
        synchronized (f28695k) {
            firebaseApp = f28696l.get(l(str));
            if (firebaseApp != null) {
                firebaseApp.f28704h.get().registerHeartBeat();
            } else {
                if (h().isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", h4);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
        }
        return firebaseApp;
    }

    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions, @NonNull String str) {
        FirebaseApp firebaseApp;
        GlobalBackgroundStateListener.b(context);
        String l4 = l(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f28695k) {
            Map<String, FirebaseApp> map = f28696l;
            boolean z3 = !map.containsKey(l4);
            Preconditions.checkState(z3, "FirebaseApp name " + l4 + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, l4, firebaseOptions);
            map.put(l4, firebaseApp);
        }
        firebaseApp.i();
        return firebaseApp;
    }
}
