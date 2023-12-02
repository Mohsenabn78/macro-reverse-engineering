package com.google.firebase.sessions;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApplicationInfo.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b*\u0010+J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003JE\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/google/firebase/sessions/ApplicationInfo;", "", "", "component1", "component2", "component3", "component4", "Lcom/google/firebase/sessions/LogEnvironment;", "component5", "Lcom/google/firebase/sessions/AndroidApplicationInfo;", "component6", RemoteConfigConstants.RequestFieldKey.APP_ID, "deviceModel", "sessionSdkVersion", "osVersion", "logEnvironment", "androidAppInfo", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "b", "getDeviceModel", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "getSessionSdkVersion", "d", "getOsVersion", "e", "Lcom/google/firebase/sessions/LogEnvironment;", "getLogEnvironment", "()Lcom/google/firebase/sessions/LogEnvironment;", "f", "Lcom/google/firebase/sessions/AndroidApplicationInfo;", "getAndroidAppInfo", "()Lcom/google/firebase/sessions/AndroidApplicationInfo;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/sessions/LogEnvironment;Lcom/google/firebase/sessions/AndroidApplicationInfo;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class ApplicationInfo {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f32065a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f32066b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f32067c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f32068d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final LogEnvironment f32069e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final AndroidApplicationInfo f32070f;

    public ApplicationInfo(@NotNull String appId, @NotNull String deviceModel, @NotNull String sessionSdkVersion, @NotNull String osVersion, @NotNull LogEnvironment logEnvironment, @NotNull AndroidApplicationInfo androidAppInfo) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(sessionSdkVersion, "sessionSdkVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(logEnvironment, "logEnvironment");
        Intrinsics.checkNotNullParameter(androidAppInfo, "androidAppInfo");
        this.f32065a = appId;
        this.f32066b = deviceModel;
        this.f32067c = sessionSdkVersion;
        this.f32068d = osVersion;
        this.f32069e = logEnvironment;
        this.f32070f = androidAppInfo;
    }

    public static /* synthetic */ ApplicationInfo copy$default(ApplicationInfo applicationInfo, String str, String str2, String str3, String str4, LogEnvironment logEnvironment, AndroidApplicationInfo androidApplicationInfo, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = applicationInfo.f32065a;
        }
        if ((i4 & 2) != 0) {
            str2 = applicationInfo.f32066b;
        }
        String str5 = str2;
        if ((i4 & 4) != 0) {
            str3 = applicationInfo.f32067c;
        }
        String str6 = str3;
        if ((i4 & 8) != 0) {
            str4 = applicationInfo.f32068d;
        }
        String str7 = str4;
        if ((i4 & 16) != 0) {
            logEnvironment = applicationInfo.f32069e;
        }
        LogEnvironment logEnvironment2 = logEnvironment;
        if ((i4 & 32) != 0) {
            androidApplicationInfo = applicationInfo.f32070f;
        }
        return applicationInfo.copy(str, str5, str6, str7, logEnvironment2, androidApplicationInfo);
    }

    @NotNull
    public final String component1() {
        return this.f32065a;
    }

    @NotNull
    public final String component2() {
        return this.f32066b;
    }

    @NotNull
    public final String component3() {
        return this.f32067c;
    }

    @NotNull
    public final String component4() {
        return this.f32068d;
    }

    @NotNull
    public final LogEnvironment component5() {
        return this.f32069e;
    }

    @NotNull
    public final AndroidApplicationInfo component6() {
        return this.f32070f;
    }

    @NotNull
    public final ApplicationInfo copy(@NotNull String appId, @NotNull String deviceModel, @NotNull String sessionSdkVersion, @NotNull String osVersion, @NotNull LogEnvironment logEnvironment, @NotNull AndroidApplicationInfo androidAppInfo) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(sessionSdkVersion, "sessionSdkVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(logEnvironment, "logEnvironment");
        Intrinsics.checkNotNullParameter(androidAppInfo, "androidAppInfo");
        return new ApplicationInfo(appId, deviceModel, sessionSdkVersion, osVersion, logEnvironment, androidAppInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        if (Intrinsics.areEqual(this.f32065a, applicationInfo.f32065a) && Intrinsics.areEqual(this.f32066b, applicationInfo.f32066b) && Intrinsics.areEqual(this.f32067c, applicationInfo.f32067c) && Intrinsics.areEqual(this.f32068d, applicationInfo.f32068d) && this.f32069e == applicationInfo.f32069e && Intrinsics.areEqual(this.f32070f, applicationInfo.f32070f)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AndroidApplicationInfo getAndroidAppInfo() {
        return this.f32070f;
    }

    @NotNull
    public final String getAppId() {
        return this.f32065a;
    }

    @NotNull
    public final String getDeviceModel() {
        return this.f32066b;
    }

    @NotNull
    public final LogEnvironment getLogEnvironment() {
        return this.f32069e;
    }

    @NotNull
    public final String getOsVersion() {
        return this.f32068d;
    }

    @NotNull
    public final String getSessionSdkVersion() {
        return this.f32067c;
    }

    public int hashCode() {
        return (((((((((this.f32065a.hashCode() * 31) + this.f32066b.hashCode()) * 31) + this.f32067c.hashCode()) * 31) + this.f32068d.hashCode()) * 31) + this.f32069e.hashCode()) * 31) + this.f32070f.hashCode();
    }

    @NotNull
    public String toString() {
        return "ApplicationInfo(appId=" + this.f32065a + ", deviceModel=" + this.f32066b + ", sessionSdkVersion=" + this.f32067c + ", osVersion=" + this.f32068d + ", logEnvironment=" + this.f32069e + ", androidAppInfo=" + this.f32070f + ')';
    }
}
