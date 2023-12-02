package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes5.dex */
final class AutoValue_StaticSessionData_OsData extends StaticSessionData.OsData {

    /* renamed from: a  reason: collision with root package name */
    private final String f29952a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29953b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f29954c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_OsData(String str, String str2, boolean z3) {
        if (str != null) {
            this.f29952a = str;
            if (str2 != null) {
                this.f29953b = str2;
                this.f29954c = z3;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.OsData)) {
            return false;
        }
        StaticSessionData.OsData osData = (StaticSessionData.OsData) obj;
        if (this.f29952a.equals(osData.osRelease()) && this.f29953b.equals(osData.osCodeName()) && this.f29954c == osData.isRooted()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((this.f29952a.hashCode() ^ 1000003) * 1000003) ^ this.f29953b.hashCode()) * 1000003;
        if (this.f29954c) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return hashCode ^ i4;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public boolean isRooted() {
        return this.f29954c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public String osCodeName() {
        return this.f29953b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public String osRelease() {
        return this.f29952a;
    }

    public String toString() {
        return "OsData{osRelease=" + this.f29952a + ", osCodeName=" + this.f29953b + ", isRooted=" + this.f29954c + "}";
    }
}
