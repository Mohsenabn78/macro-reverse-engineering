package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class Encoding {

    /* renamed from: a  reason: collision with root package name */
    private final String f18481a;

    private Encoding(@NonNull String str) {
        if (str != null) {
            this.f18481a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static Encoding of(@NonNull String str) {
        return new Encoding(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.f18481a.equals(((Encoding) obj).f18481a);
    }

    public String getName() {
        return this.f18481a;
    }

    public int hashCode() {
        return this.f18481a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f18481a + "\"}";
    }
}
