package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes5.dex */
public abstract class Persistence {
    public static String DATA_MIGRATION_BUILD_OVERLAYS = "BUILD_OVERLAYS";

    /* renamed from: a  reason: collision with root package name */
    static final String f30690a = "Persistence";

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BundleCache a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract DocumentOverlayCache b(User user);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract IndexManager c(User user);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract MutationQueue d(User user, IndexManager indexManager);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract OverlayMigrationManager e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract RemoteDocumentCache f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract TargetCache g();

    public abstract ReferenceDelegate getReferenceDelegate();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <T> T h(String str, Supplier<T> supplier);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(String str, Runnable runnable);

    public abstract boolean isStarted();

    public abstract void shutdown();

    public abstract void start();
}
