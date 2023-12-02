package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import java.util.Set;

/* loaded from: classes5.dex */
final class AutoValue_ConfigUpdate extends ConfigUpdate {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f31873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ConfigUpdate(Set<String> set) {
        if (set != null) {
            this.f31873a = set;
            return;
        }
        throw new NullPointerException("Null updatedKeys");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConfigUpdate) {
            return this.f31873a.equals(((ConfigUpdate) obj).getUpdatedKeys());
        }
        return false;
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdate
    @NonNull
    public Set<String> getUpdatedKeys() {
        return this.f31873a;
    }

    public int hashCode() {
        return this.f31873a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ConfigUpdate{updatedKeys=" + this.f31873a + "}";
    }
}
