package com.google.firebase.firestore.local;

import android.database.Cursor;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public class SQLiteOverlayMigrationManager implements OverlayMigrationManager {

    /* renamed from: a  reason: collision with root package name */
    private final SQLitePersistence f30733a;

    public SQLiteOverlayMigrationManager(SQLitePersistence sQLitePersistence) {
        this.f30733a = sQLitePersistence;
    }

    private void d() {
        this.f30733a.i("build overlays", new Runnable() { // from class: com.google.firebase.firestore.local.i1
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteOverlayMigrationManager.this.g();
            }
        });
    }

    private Set<String> e() {
        final HashSet hashSet = new HashSet();
        this.f30733a.x("SELECT DISTINCT uid FROM mutation_queues").e(new Consumer() { // from class: com.google.firebase.firestore.local.k1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteOverlayMigrationManager.h(hashSet, (Cursor) obj);
            }
        });
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (!f()) {
            return;
        }
        Set<String> e4 = e();
        RemoteDocumentCache f4 = this.f30733a.f();
        for (String str : e4) {
            User user = new User(str);
            SQLitePersistence sQLitePersistence = this.f30733a;
            MutationQueue d4 = sQLitePersistence.d(user, sQLitePersistence.c(user));
            HashSet hashSet = new HashSet();
            for (MutationBatch mutationBatch : d4.j()) {
                hashSet.addAll(mutationBatch.getKeys());
            }
            new LocalDocumentsView(f4, d4, this.f30733a.b(user), this.f30733a.c(user)).o(hashSet);
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Set set, Cursor cursor) {
        set.add(cursor.getString(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Boolean[] boolArr, Cursor cursor) {
        try {
            if (Persistence.DATA_MIGRATION_BUILD_OVERLAYS.equals(cursor.getString(0))) {
                boolArr[0] = Boolean.TRUE;
            }
        } catch (IllegalArgumentException e4) {
            throw Assert.fail("SQLitePersistence.DataMigration failed to parse: %s", e4);
        }
    }

    private void j() {
        this.f30733a.p("DELETE FROM data_migrations WHERE migration_name = ?", Persistence.DATA_MIGRATION_BUILD_OVERLAYS);
    }

    @VisibleForTesting
    boolean f() {
        final Boolean[] boolArr = {Boolean.FALSE};
        this.f30733a.x("SELECT migration_name FROM data_migrations").e(new Consumer() { // from class: com.google.firebase.firestore.local.j1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteOverlayMigrationManager.i(boolArr, (Cursor) obj);
            }
        });
        return boolArr[0].booleanValue();
    }

    @Override // com.google.firebase.firestore.local.OverlayMigrationManager
    public void run() {
        d();
    }
}
