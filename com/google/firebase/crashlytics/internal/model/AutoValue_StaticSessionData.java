package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes5.dex */
final class AutoValue_StaticSessionData extends StaticSessionData {

    /* renamed from: a  reason: collision with root package name */
    private final StaticSessionData.AppData f29934a;

    /* renamed from: b  reason: collision with root package name */
    private final StaticSessionData.OsData f29935b;

    /* renamed from: c  reason: collision with root package name */
    private final StaticSessionData.DeviceData f29936c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData(StaticSessionData.AppData appData, StaticSessionData.OsData osData, StaticSessionData.DeviceData deviceData) {
        if (appData != null) {
            this.f29934a = appData;
            if (osData != null) {
                this.f29935b = osData;
                if (deviceData != null) {
                    this.f29936c = deviceData;
                    return;
                }
                throw new NullPointerException("Null deviceData");
            }
            throw new NullPointerException("Null osData");
        }
        throw new NullPointerException("Null appData");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.AppData appData() {
        return this.f29934a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.DeviceData deviceData() {
        return this.f29936c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData)) {
            return false;
        }
        StaticSessionData staticSessionData = (StaticSessionData) obj;
        if (this.f29934a.equals(staticSessionData.appData()) && this.f29935b.equals(staticSessionData.osData()) && this.f29936c.equals(staticSessionData.deviceData())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f29934a.hashCode() ^ 1000003) * 1000003) ^ this.f29935b.hashCode()) * 1000003) ^ this.f29936c.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.OsData osData() {
        return this.f29935b;
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f29934a + ", osData=" + this.f29935b + ", deviceData=" + this.f29936c + "}";
    }
}
