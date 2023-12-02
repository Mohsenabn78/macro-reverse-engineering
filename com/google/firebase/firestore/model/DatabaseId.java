package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes5.dex */
public final class DatabaseId implements Comparable<DatabaseId> {
    public static final String DEFAULT_DATABASE_ID = "(default)";
    public static final DatabaseId EMPTY = forDatabase("", "");

    /* renamed from: a  reason: collision with root package name */
    private final String f30944a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30945b;

    private DatabaseId(String str, String str2) {
        this.f30944a = str;
        this.f30945b = str2;
    }

    public static DatabaseId forDatabase(String str, String str2) {
        return new DatabaseId(str, str2);
    }

    public static DatabaseId forProject(String str) {
        return forDatabase(str, "(default)");
    }

    public static DatabaseId fromName(String str) {
        boolean z3;
        ResourcePath fromString = ResourcePath.fromString(str);
        if (fromString.length() > 3 && fromString.getSegment(0).equals("projects") && fromString.getSegment(2).equals("databases")) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Tried to parse an invalid resource name: %s", fromString);
        return new DatabaseId(fromString.getSegment(1), fromString.getSegment(3));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DatabaseId.class != obj.getClass()) {
            return false;
        }
        DatabaseId databaseId = (DatabaseId) obj;
        if (this.f30944a.equals(databaseId.f30944a) && this.f30945b.equals(databaseId.f30945b)) {
            return true;
        }
        return false;
    }

    public String getDatabaseId() {
        return this.f30945b;
    }

    public String getProjectId() {
        return this.f30944a;
    }

    public int hashCode() {
        return (this.f30944a.hashCode() * 31) + this.f30945b.hashCode();
    }

    public String toString() {
        return "DatabaseId(" + this.f30944a + ", " + this.f30945b + ")";
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull DatabaseId databaseId) {
        int compareTo = this.f30944a.compareTo(databaseId.f30944a);
        return compareTo != 0 ? compareTo : this.f30945b.compareTo(databaseId.f30945b);
    }
}
