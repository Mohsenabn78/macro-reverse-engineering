package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DatabaseId;

/* loaded from: classes5.dex */
public final class DatabaseInfo {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseId f30328a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30329b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30330c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f30331d;

    public DatabaseInfo(DatabaseId databaseId, String str, String str2, boolean z3) {
        this.f30328a = databaseId;
        this.f30329b = str;
        this.f30330c = str2;
        this.f30331d = z3;
    }

    public DatabaseId getDatabaseId() {
        return this.f30328a;
    }

    public String getHost() {
        return this.f30330c;
    }

    public String getPersistenceKey() {
        return this.f30329b;
    }

    public boolean isSslEnabled() {
        return this.f30331d;
    }

    public String toString() {
        return "DatabaseInfo(databaseId:" + this.f30328a + " host:" + this.f30330c + ")";
    }
}
