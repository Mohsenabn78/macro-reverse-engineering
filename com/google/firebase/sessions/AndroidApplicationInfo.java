package com.google.firebase.sessions;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApplicationInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J1\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/sessions/AndroidApplicationInfo;", "", "", "component1", "component2", "component3", "component4", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "versionName", "appBuildVersion", "deviceManufacturer", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "b", "getVersionName", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "getAppBuildVersion", "d", "getDeviceManufacturer", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class AndroidApplicationInfo {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f32061a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f32062b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f32063c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f32064d;

    public AndroidApplicationInfo(@NotNull String packageName, @NotNull String versionName, @NotNull String appBuildVersion, @NotNull String deviceManufacturer) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(appBuildVersion, "appBuildVersion");
        Intrinsics.checkNotNullParameter(deviceManufacturer, "deviceManufacturer");
        this.f32061a = packageName;
        this.f32062b = versionName;
        this.f32063c = appBuildVersion;
        this.f32064d = deviceManufacturer;
    }

    public static /* synthetic */ AndroidApplicationInfo copy$default(AndroidApplicationInfo androidApplicationInfo, String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = androidApplicationInfo.f32061a;
        }
        if ((i4 & 2) != 0) {
            str2 = androidApplicationInfo.f32062b;
        }
        if ((i4 & 4) != 0) {
            str3 = androidApplicationInfo.f32063c;
        }
        if ((i4 & 8) != 0) {
            str4 = androidApplicationInfo.f32064d;
        }
        return androidApplicationInfo.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.f32061a;
    }

    @NotNull
    public final String component2() {
        return this.f32062b;
    }

    @NotNull
    public final String component3() {
        return this.f32063c;
    }

    @NotNull
    public final String component4() {
        return this.f32064d;
    }

    @NotNull
    public final AndroidApplicationInfo copy(@NotNull String packageName, @NotNull String versionName, @NotNull String appBuildVersion, @NotNull String deviceManufacturer) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(appBuildVersion, "appBuildVersion");
        Intrinsics.checkNotNullParameter(deviceManufacturer, "deviceManufacturer");
        return new AndroidApplicationInfo(packageName, versionName, appBuildVersion, deviceManufacturer);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidApplicationInfo)) {
            return false;
        }
        AndroidApplicationInfo androidApplicationInfo = (AndroidApplicationInfo) obj;
        if (Intrinsics.areEqual(this.f32061a, androidApplicationInfo.f32061a) && Intrinsics.areEqual(this.f32062b, androidApplicationInfo.f32062b) && Intrinsics.areEqual(this.f32063c, androidApplicationInfo.f32063c) && Intrinsics.areEqual(this.f32064d, androidApplicationInfo.f32064d)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAppBuildVersion() {
        return this.f32063c;
    }

    @NotNull
    public final String getDeviceManufacturer() {
        return this.f32064d;
    }

    @NotNull
    public final String getPackageName() {
        return this.f32061a;
    }

    @NotNull
    public final String getVersionName() {
        return this.f32062b;
    }

    public int hashCode() {
        return (((((this.f32061a.hashCode() * 31) + this.f32062b.hashCode()) * 31) + this.f32063c.hashCode()) * 31) + this.f32064d.hashCode();
    }

    @NotNull
    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f32061a + ", versionName=" + this.f32062b + ", appBuildVersion=" + this.f32063c + ", deviceManufacturer=" + this.f32064d + ')';
    }
}
