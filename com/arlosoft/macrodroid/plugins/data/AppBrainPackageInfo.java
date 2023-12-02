package com.arlosoft.macrodroid.plugins.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppBrainPackageInfo.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class AppBrainPackageInfo {
    public static final int $stable = 0;
    @NotNull
    private final String description;
    @NotNull
    private final String developerName;
    @NotNull
    private final String iconUrl;
    @NotNull
    private final String name;
    @SerializedName("package")
    @NotNull
    private final String packageName;
    @NotNull
    private final String shortDescription;
    @NotNull
    private final String website;

    public AppBrainPackageInfo(@NotNull String packageName, @NotNull String name, @NotNull String shortDescription, @NotNull String description, @NotNull String iconUrl, @NotNull String website, @NotNull String developerName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortDescription, "shortDescription");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        this.packageName = packageName;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.iconUrl = iconUrl;
        this.website = website;
        this.developerName = developerName;
    }

    public static /* synthetic */ AppBrainPackageInfo copy$default(AppBrainPackageInfo appBrainPackageInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = appBrainPackageInfo.packageName;
        }
        if ((i4 & 2) != 0) {
            str2 = appBrainPackageInfo.name;
        }
        String str8 = str2;
        if ((i4 & 4) != 0) {
            str3 = appBrainPackageInfo.shortDescription;
        }
        String str9 = str3;
        if ((i4 & 8) != 0) {
            str4 = appBrainPackageInfo.description;
        }
        String str10 = str4;
        if ((i4 & 16) != 0) {
            str5 = appBrainPackageInfo.iconUrl;
        }
        String str11 = str5;
        if ((i4 & 32) != 0) {
            str6 = appBrainPackageInfo.website;
        }
        String str12 = str6;
        if ((i4 & 64) != 0) {
            str7 = appBrainPackageInfo.developerName;
        }
        return appBrainPackageInfo.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.packageName;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.shortDescription;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.iconUrl;
    }

    @NotNull
    public final String component6() {
        return this.website;
    }

    @NotNull
    public final String component7() {
        return this.developerName;
    }

    @NotNull
    public final AppBrainPackageInfo copy(@NotNull String packageName, @NotNull String name, @NotNull String shortDescription, @NotNull String description, @NotNull String iconUrl, @NotNull String website, @NotNull String developerName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortDescription, "shortDescription");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        return new AppBrainPackageInfo(packageName, name, shortDescription, description, iconUrl, website, developerName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppBrainPackageInfo)) {
            return false;
        }
        AppBrainPackageInfo appBrainPackageInfo = (AppBrainPackageInfo) obj;
        if (Intrinsics.areEqual(this.packageName, appBrainPackageInfo.packageName) && Intrinsics.areEqual(this.name, appBrainPackageInfo.name) && Intrinsics.areEqual(this.shortDescription, appBrainPackageInfo.shortDescription) && Intrinsics.areEqual(this.description, appBrainPackageInfo.description) && Intrinsics.areEqual(this.iconUrl, appBrainPackageInfo.iconUrl) && Intrinsics.areEqual(this.website, appBrainPackageInfo.website) && Intrinsics.areEqual(this.developerName, appBrainPackageInfo.developerName)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getDeveloperName() {
        return this.developerName;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getShortDescription() {
        return this.shortDescription;
    }

    @NotNull
    public final String getWebsite() {
        return this.website;
    }

    public int hashCode() {
        return (((((((((((this.packageName.hashCode() * 31) + this.name.hashCode()) * 31) + this.shortDescription.hashCode()) * 31) + this.description.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.website.hashCode()) * 31) + this.developerName.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.packageName;
        String str2 = this.name;
        String str3 = this.shortDescription;
        String str4 = this.description;
        String str5 = this.iconUrl;
        String str6 = this.website;
        String str7 = this.developerName;
        return "AppBrainPackageInfo(packageName=" + str + ", name=" + str2 + ", shortDescription=" + str3 + ", description=" + str4 + ", iconUrl=" + str5 + ", website=" + str6 + ", developerName=" + str7 + ")";
    }
}
