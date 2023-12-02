package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

/* loaded from: classes5.dex */
final class AutoValue_InstallIdProvider_InstallIds extends InstallIdProvider.InstallIds {

    /* renamed from: a  reason: collision with root package name */
    private final String f29386a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29387b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_InstallIdProvider_InstallIds(String str, @Nullable String str2) {
        if (str != null) {
            this.f29386a = str;
            this.f29387b = str2;
            return;
        }
        throw new NullPointerException("Null crashlyticsInstallId");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallIdProvider.InstallIds)) {
            return false;
        }
        InstallIdProvider.InstallIds installIds = (InstallIdProvider.InstallIds) obj;
        if (this.f29386a.equals(installIds.getCrashlyticsInstallId())) {
            String str = this.f29387b;
            if (str == null) {
                if (installIds.getFirebaseInstallationId() == null) {
                    return true;
                }
            } else if (str.equals(installIds.getFirebaseInstallationId())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
    @NonNull
    public String getCrashlyticsInstallId() {
        return this.f29386a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
    @Nullable
    public String getFirebaseInstallationId() {
        return this.f29387b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.f29386a.hashCode() ^ 1000003) * 1000003;
        String str = this.f29387b;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f29386a + ", firebaseInstallationId=" + this.f29387b + "}";
    }
}
