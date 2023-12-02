package com.google.firebase.firestore.local;

import android.database.Cursor;
import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.NamedQuery;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Function;
import com.google.firestore.bundle.BundledQuery;
import com.google.protobuf.InvalidProtocolBufferException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class SQLiteBundleCache implements BundleCache {

    /* renamed from: a  reason: collision with root package name */
    private final SQLitePersistence f30703a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalSerializer f30704b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteBundleCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.f30703a = sQLitePersistence;
        this.f30704b = localSerializer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BundleMetadata c(String str, Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new BundleMetadata(str, cursor.getInt(0), new SnapshotVersion(new Timestamp(cursor.getLong(1), cursor.getInt(2))), cursor.getInt(3), cursor.getLong(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NamedQuery d(String str, Cursor cursor) {
        if (cursor != null) {
            try {
                return new NamedQuery(str, this.f30704b.decodeBundledQuery(BundledQuery.parseFrom(cursor.getBlob(2))), new SnapshotVersion(new Timestamp(cursor.getLong(0), cursor.getInt(1))));
            } catch (InvalidProtocolBufferException e4) {
                throw Assert.fail("NamedQuery failed to parse: %s", e4);
            }
        }
        return null;
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    @Nullable
    public BundleMetadata getBundleMetadata(final String str) {
        return (BundleMetadata) this.f30703a.x("SELECT schema_version, create_time_seconds, create_time_nanos, total_documents,  total_bytes FROM bundles WHERE bundle_id = ?").b(str).d(new Function() { // from class: com.google.firebase.firestore.local.f0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                BundleMetadata c4;
                c4 = SQLiteBundleCache.c(str, (Cursor) obj);
                return c4;
            }
        });
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    @Nullable
    public NamedQuery getNamedQuery(final String str) {
        return (NamedQuery) this.f30703a.x("SELECT read_time_seconds, read_time_nanos, bundled_query_proto FROM named_queries WHERE name = ?").b(str).d(new Function() { // from class: com.google.firebase.firestore.local.g0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                NamedQuery d4;
                d4 = SQLiteBundleCache.this.d(str, (Cursor) obj);
                return d4;
            }
        });
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public void saveBundleMetadata(BundleMetadata bundleMetadata) {
        this.f30703a.p("INSERT OR REPLACE INTO bundles (bundle_id, schema_version, create_time_seconds, create_time_nanos, total_documents, total_bytes) VALUES (?, ?, ?, ?, ?, ?)", bundleMetadata.getBundleId(), Integer.valueOf(bundleMetadata.getSchemaVersion()), Long.valueOf(bundleMetadata.getCreateTime().getTimestamp().getSeconds()), Integer.valueOf(bundleMetadata.getCreateTime().getTimestamp().getNanoseconds()), Integer.valueOf(bundleMetadata.getTotalDocuments()), Long.valueOf(bundleMetadata.getTotalBytes()));
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public void saveNamedQuery(NamedQuery namedQuery) {
        this.f30703a.p("INSERT OR REPLACE INTO named_queries (name, read_time_seconds, read_time_nanos, bundled_query_proto) VALUES (?, ?, ?, ?)", namedQuery.getName(), Long.valueOf(namedQuery.getReadTime().getTimestamp().getSeconds()), Integer.valueOf(namedQuery.getReadTime().getTimestamp().getNanoseconds()), this.f30704b.encodeBundledQuery(namedQuery.getBundledQuery()).toByteArray());
    }
}
