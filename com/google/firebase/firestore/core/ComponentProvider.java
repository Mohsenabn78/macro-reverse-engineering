package com.google.firebase.firestore.core;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.IndexBackfiller;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;

/* loaded from: classes5.dex */
public abstract class ComponentProvider {

    /* renamed from: a  reason: collision with root package name */
    private Persistence f30309a;

    /* renamed from: b  reason: collision with root package name */
    private LocalStore f30310b;

    /* renamed from: c  reason: collision with root package name */
    private SyncEngine f30311c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteStore f30312d;

    /* renamed from: e  reason: collision with root package name */
    private EventManager f30313e;

    /* renamed from: f  reason: collision with root package name */
    private ConnectivityMonitor f30314f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private IndexBackfiller f30315g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Scheduler f30316h;

    /* loaded from: classes5.dex */
    public static class Configuration {

        /* renamed from: a  reason: collision with root package name */
        private final Context f30317a;

        /* renamed from: b  reason: collision with root package name */
        private final AsyncQueue f30318b;

        /* renamed from: c  reason: collision with root package name */
        private final DatabaseInfo f30319c;

        /* renamed from: d  reason: collision with root package name */
        private final Datastore f30320d;

        /* renamed from: e  reason: collision with root package name */
        private final User f30321e;

        /* renamed from: f  reason: collision with root package name */
        private final int f30322f;

        /* renamed from: g  reason: collision with root package name */
        private final FirebaseFirestoreSettings f30323g;

        public Configuration(Context context, AsyncQueue asyncQueue, DatabaseInfo databaseInfo, Datastore datastore, User user, int i4, FirebaseFirestoreSettings firebaseFirestoreSettings) {
            this.f30317a = context;
            this.f30318b = asyncQueue;
            this.f30319c = databaseInfo;
            this.f30320d = datastore;
            this.f30321e = user;
            this.f30322f = i4;
            this.f30323g = firebaseFirestoreSettings;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public AsyncQueue a() {
            return this.f30318b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context b() {
            return this.f30317a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public DatabaseInfo c() {
            return this.f30319c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Datastore d() {
            return this.f30320d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public User e() {
            return this.f30321e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int f() {
            return this.f30322f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public FirebaseFirestoreSettings g() {
            return this.f30323g;
        }
    }

    protected abstract ConnectivityMonitor a(Configuration configuration);

    protected abstract EventManager b(Configuration configuration);

    protected abstract Scheduler c(Configuration configuration);

    protected abstract IndexBackfiller d(Configuration configuration);

    protected abstract LocalStore e(Configuration configuration);

    protected abstract Persistence f(Configuration configuration);

    protected abstract RemoteStore g(Configuration configuration);

    public EventManager getEventManager() {
        return (EventManager) Assert.hardAssertNonNull(this.f30313e, "eventManager not initialized yet", new Object[0]);
    }

    @Nullable
    public Scheduler getGarbageCollectionScheduler() {
        return this.f30316h;
    }

    @Nullable
    public IndexBackfiller getIndexBackfiller() {
        return this.f30315g;
    }

    public LocalStore getLocalStore() {
        return (LocalStore) Assert.hardAssertNonNull(this.f30310b, "localStore not initialized yet", new Object[0]);
    }

    public Persistence getPersistence() {
        return (Persistence) Assert.hardAssertNonNull(this.f30309a, "persistence not initialized yet", new Object[0]);
    }

    public RemoteStore getRemoteStore() {
        return (RemoteStore) Assert.hardAssertNonNull(this.f30312d, "remoteStore not initialized yet", new Object[0]);
    }

    public SyncEngine getSyncEngine() {
        return (SyncEngine) Assert.hardAssertNonNull(this.f30311c, "syncEngine not initialized yet", new Object[0]);
    }

    protected abstract SyncEngine h(Configuration configuration);

    /* JADX INFO: Access modifiers changed from: protected */
    public ConnectivityMonitor i() {
        return (ConnectivityMonitor) Assert.hardAssertNonNull(this.f30314f, "connectivityMonitor not initialized yet", new Object[0]);
    }

    public void initialize(Configuration configuration) {
        Persistence f4 = f(configuration);
        this.f30309a = f4;
        f4.start();
        this.f30310b = e(configuration);
        this.f30314f = a(configuration);
        this.f30312d = g(configuration);
        this.f30311c = h(configuration);
        this.f30313e = b(configuration);
        this.f30310b.start();
        this.f30312d.start();
        this.f30316h = c(configuration);
        this.f30315g = d(configuration);
    }
}
