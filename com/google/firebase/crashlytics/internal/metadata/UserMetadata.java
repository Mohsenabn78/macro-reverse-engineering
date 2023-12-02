package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.compose.animation.core.d;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public class UserMetadata {
    public static final String INTERNAL_KEYDATA_FILENAME = "internal-keys";
    public static final String KEYDATA_FILENAME = "keys";
    @VisibleForTesting
    public static final int MAX_ATTRIBUTES = 64;
    @VisibleForTesting
    public static final int MAX_ATTRIBUTE_SIZE = 1024;
    @VisibleForTesting
    public static final int MAX_INTERNAL_KEY_SIZE = 8192;
    public static final String USERDATA_FILENAME = "user-data";

    /* renamed from: a  reason: collision with root package name */
    private final MetaDataStore f29588a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsBackgroundWorker f29589b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29590c;

    /* renamed from: d  reason: collision with root package name */
    private final SerializeableKeysMap f29591d = new SerializeableKeysMap(false);

    /* renamed from: e  reason: collision with root package name */
    private final SerializeableKeysMap f29592e = new SerializeableKeysMap(true);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicMarkableReference<String> f29593f = new AtomicMarkableReference<>(null, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class SerializeableKeysMap {

        /* renamed from: a  reason: collision with root package name */
        final AtomicMarkableReference<KeysMap> f29594a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference<Callable<Void>> f29595b = new AtomicReference<>(null);

        /* renamed from: c  reason: collision with root package name */
        private final boolean f29596c;

        public SerializeableKeysMap(boolean z3) {
            int i4;
            this.f29596c = z3;
            if (z3) {
                i4 = 8192;
            } else {
                i4 = 1024;
            }
            this.f29594a = new AtomicMarkableReference<>(new KeysMap(64, i4), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Void c() throws Exception {
            this.f29595b.set(null);
            e();
            return null;
        }

        private void d() {
            Callable callable = new Callable() { // from class: com.google.firebase.crashlytics.internal.metadata.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void c4;
                    c4 = UserMetadata.SerializeableKeysMap.this.c();
                    return c4;
                }
            };
            if (d.a(this.f29595b, null, callable)) {
                UserMetadata.this.f29589b.submit(callable);
            }
        }

        private void e() {
            Map<String, String> map;
            synchronized (this) {
                if (this.f29594a.isMarked()) {
                    map = this.f29594a.getReference().a();
                    AtomicMarkableReference<KeysMap> atomicMarkableReference = this.f29594a;
                    atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                } else {
                    map = null;
                }
            }
            if (map != null) {
                UserMetadata.this.f29588a.l(UserMetadata.this.f29590c, map, this.f29596c);
            }
        }

        public Map<String, String> b() {
            return this.f29594a.getReference().a();
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                if (!this.f29594a.getReference().d(str, str2)) {
                    return false;
                }
                AtomicMarkableReference<KeysMap> atomicMarkableReference = this.f29594a;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                d();
                return true;
            }
        }

        public void g(Map<String, String> map) {
            synchronized (this) {
                this.f29594a.getReference().e(map);
                AtomicMarkableReference<KeysMap> atomicMarkableReference = this.f29594a;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
            }
            d();
        }
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        this.f29590c = str;
        this.f29588a = new MetaDataStore(fileStore);
        this.f29589b = crashlyticsBackgroundWorker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object e() throws Exception {
        f();
        return null;
    }

    private void f() {
        boolean z3;
        String str;
        synchronized (this.f29593f) {
            z3 = false;
            if (this.f29593f.isMarked()) {
                str = getUserId();
                this.f29593f.set(str, false);
                z3 = true;
            } else {
                str = null;
            }
        }
        if (z3) {
            this.f29588a.m(this.f29590c, str);
        }
    }

    public static UserMetadata loadFromExistingSession(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        MetaDataStore metaDataStore = new MetaDataStore(fileStore);
        UserMetadata userMetadata = new UserMetadata(str, fileStore, crashlyticsBackgroundWorker);
        userMetadata.f29591d.f29594a.getReference().e(metaDataStore.g(str, false));
        userMetadata.f29592e.f29594a.getReference().e(metaDataStore.g(str, true));
        userMetadata.f29593f.set(metaDataStore.h(str), false);
        return userMetadata;
    }

    @Nullable
    public static String readUserId(String str, FileStore fileStore) {
        return new MetaDataStore(fileStore).h(str);
    }

    public Map<String, String> getCustomKeys() {
        return this.f29591d.b();
    }

    public Map<String, String> getInternalKeys() {
        return this.f29592e.b();
    }

    @Nullable
    public String getUserId() {
        return this.f29593f.getReference();
    }

    public boolean setCustomKey(String str, String str2) {
        return this.f29591d.f(str, str2);
    }

    public void setCustomKeys(Map<String, String> map) {
        this.f29591d.g(map);
    }

    public boolean setInternalKey(String str, String str2) {
        return this.f29592e.f(str, str2);
    }

    public void setUserId(String str) {
        String c4 = KeysMap.c(str, 1024);
        synchronized (this.f29593f) {
            if (CommonUtils.nullSafeEquals(c4, this.f29593f.getReference())) {
                return;
            }
            this.f29593f.set(c4, true);
            this.f29589b.submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.metadata.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object e4;
                    e4 = UserMetadata.this.e();
                    return e4;
                }
            });
        }
    }
}
