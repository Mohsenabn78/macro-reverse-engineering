package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes5.dex */
final class AutoValue_StaticSessionData_AppData extends StaticSessionData.AppData {

    /* renamed from: a  reason: collision with root package name */
    private final String f29937a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29938b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29939c;

    /* renamed from: d  reason: collision with root package name */
    private final String f29940d;

    /* renamed from: e  reason: collision with root package name */
    private final int f29941e;

    /* renamed from: f  reason: collision with root package name */
    private final DevelopmentPlatformProvider f29942f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int i4, DevelopmentPlatformProvider developmentPlatformProvider) {
        if (str != null) {
            this.f29937a = str;
            if (str2 != null) {
                this.f29938b = str2;
                if (str3 != null) {
                    this.f29939c = str3;
                    if (str4 != null) {
                        this.f29940d = str4;
                        this.f29941e = i4;
                        if (developmentPlatformProvider != null) {
                            this.f29942f = developmentPlatformProvider;
                            return;
                        }
                        throw new NullPointerException("Null developmentPlatformProvider");
                    }
                    throw new NullPointerException("Null installUuid");
                }
                throw new NullPointerException("Null versionName");
            }
            throw new NullPointerException("Null versionCode");
        }
        throw new NullPointerException("Null appIdentifier");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String appIdentifier() {
        return this.f29937a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public int deliveryMechanism() {
        return this.f29941e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public DevelopmentPlatformProvider developmentPlatformProvider() {
        return this.f29942f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.AppData)) {
            return false;
        }
        StaticSessionData.AppData appData = (StaticSessionData.AppData) obj;
        if (this.f29937a.equals(appData.appIdentifier()) && this.f29938b.equals(appData.versionCode()) && this.f29939c.equals(appData.versionName()) && this.f29940d.equals(appData.installUuid()) && this.f29941e == appData.deliveryMechanism() && this.f29942f.equals(appData.developmentPlatformProvider())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.f29937a.hashCode() ^ 1000003) * 1000003) ^ this.f29938b.hashCode()) * 1000003) ^ this.f29939c.hashCode()) * 1000003) ^ this.f29940d.hashCode()) * 1000003) ^ this.f29941e) * 1000003) ^ this.f29942f.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String installUuid() {
        return this.f29940d;
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f29937a + ", versionCode=" + this.f29938b + ", versionName=" + this.f29939c + ", installUuid=" + this.f29940d + ", deliveryMechanism=" + this.f29941e + ", developmentPlatformProvider=" + this.f29942f + "}";
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String versionCode() {
        return this.f29938b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String versionName() {
        return this.f29939c;
    }
}
