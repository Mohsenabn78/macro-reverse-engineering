package com.google.firebase.firestore.auth;

import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public final class User {
    public static final User UNAUTHENTICATED = new User(null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f30261a;

    public User(@Nullable String str) {
        this.f30261a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || User.class != obj.getClass()) {
            return false;
        }
        String str = this.f30261a;
        String str2 = ((User) obj).f30261a;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getUid() {
        return this.f30261a;
    }

    public int hashCode() {
        String str = this.f30261a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isAuthenticated() {
        if (this.f30261a != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "User(uid:" + this.f30261a + ")";
    }
}
