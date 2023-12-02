package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

/* loaded from: classes5.dex */
final class AutoValue_LibraryVersion extends LibraryVersion {

    /* renamed from: a  reason: collision with root package name */
    private final String f31863a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31864b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LibraryVersion(String str, String str2) {
        if (str != null) {
            this.f31863a = str;
            if (str2 != null) {
                this.f31864b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public String b() {
        return this.f31863a;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public String c() {
        return this.f31864b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        if (this.f31863a.equals(libraryVersion.b()) && this.f31864b.equals(libraryVersion.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f31863a.hashCode() ^ 1000003) * 1000003) ^ this.f31864b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f31863a + ", version=" + this.f31864b + "}";
    }
}
