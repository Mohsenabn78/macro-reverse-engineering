package com.arlosoft.macrodroid.plugins.api;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UploadPluginBody.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class UploadPluginBody {
    public static final int $stable = 0;
    @NotNull
    private final String description;
    @NotNull
    private final String developerName;
    @NotNull
    private final String downloadLink;
    @Nullable
    private final String iconUrl;
    @NotNull
    private final String language;
    @NotNull
    private final String name;
    @NotNull
    private final String packageName;
    private final int userId;
    @NotNull
    private final String website;

    public UploadPluginBody(int i4, @NotNull String name, @NotNull String developerName, @NotNull String description, @NotNull String packageName, @NotNull String downloadLink, @Nullable String str, @NotNull String website, @NotNull String language) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(downloadLink, "downloadLink");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(language, "language");
        this.userId = i4;
        this.name = name;
        this.developerName = developerName;
        this.description = description;
        this.packageName = packageName;
        this.downloadLink = downloadLink;
        this.iconUrl = str;
        this.website = website;
        this.language = language;
    }

    public static /* synthetic */ UploadPluginBody copy$default(UploadPluginBody uploadPluginBody, int i4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i5, Object obj) {
        int i6;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        if ((i5 & 1) != 0) {
            i6 = uploadPluginBody.userId;
        } else {
            i6 = i4;
        }
        if ((i5 & 2) != 0) {
            str9 = uploadPluginBody.name;
        } else {
            str9 = str;
        }
        if ((i5 & 4) != 0) {
            str10 = uploadPluginBody.developerName;
        } else {
            str10 = str2;
        }
        if ((i5 & 8) != 0) {
            str11 = uploadPluginBody.description;
        } else {
            str11 = str3;
        }
        if ((i5 & 16) != 0) {
            str12 = uploadPluginBody.packageName;
        } else {
            str12 = str4;
        }
        if ((i5 & 32) != 0) {
            str13 = uploadPluginBody.downloadLink;
        } else {
            str13 = str5;
        }
        if ((i5 & 64) != 0) {
            str14 = uploadPluginBody.iconUrl;
        } else {
            str14 = str6;
        }
        if ((i5 & 128) != 0) {
            str15 = uploadPluginBody.website;
        } else {
            str15 = str7;
        }
        if ((i5 & 256) != 0) {
            str16 = uploadPluginBody.language;
        } else {
            str16 = str8;
        }
        return uploadPluginBody.copy(i6, str9, str10, str11, str12, str13, str14, str15, str16);
    }

    public final int component1() {
        return this.userId;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.developerName;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.packageName;
    }

    @NotNull
    public final String component6() {
        return this.downloadLink;
    }

    @Nullable
    public final String component7() {
        return this.iconUrl;
    }

    @NotNull
    public final String component8() {
        return this.website;
    }

    @NotNull
    public final String component9() {
        return this.language;
    }

    @NotNull
    public final UploadPluginBody copy(int i4, @NotNull String name, @NotNull String developerName, @NotNull String description, @NotNull String packageName, @NotNull String downloadLink, @Nullable String str, @NotNull String website, @NotNull String language) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(downloadLink, "downloadLink");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(language, "language");
        return new UploadPluginBody(i4, name, developerName, description, packageName, downloadLink, str, website, language);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadPluginBody)) {
            return false;
        }
        UploadPluginBody uploadPluginBody = (UploadPluginBody) obj;
        if (this.userId == uploadPluginBody.userId && Intrinsics.areEqual(this.name, uploadPluginBody.name) && Intrinsics.areEqual(this.developerName, uploadPluginBody.developerName) && Intrinsics.areEqual(this.description, uploadPluginBody.description) && Intrinsics.areEqual(this.packageName, uploadPluginBody.packageName) && Intrinsics.areEqual(this.downloadLink, uploadPluginBody.downloadLink) && Intrinsics.areEqual(this.iconUrl, uploadPluginBody.iconUrl) && Intrinsics.areEqual(this.website, uploadPluginBody.website) && Intrinsics.areEqual(this.language, uploadPluginBody.language)) {
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
    public final String getDownloadLink() {
        return this.downloadLink;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final int getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getWebsite() {
        return this.website;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.userId * 31) + this.name.hashCode()) * 31) + this.developerName.hashCode()) * 31) + this.description.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.downloadLink.hashCode()) * 31;
        String str = this.iconUrl;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((hashCode2 + hashCode) * 31) + this.website.hashCode()) * 31) + this.language.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.userId;
        String str = this.name;
        String str2 = this.developerName;
        String str3 = this.description;
        String str4 = this.packageName;
        String str5 = this.downloadLink;
        String str6 = this.iconUrl;
        String str7 = this.website;
        String str8 = this.language;
        return "UploadPluginBody(userId=" + i4 + ", name=" + str + ", developerName=" + str2 + ", description=" + str3 + ", packageName=" + str4 + ", downloadLink=" + str5 + ", iconUrl=" + str6 + ", website=" + str7 + ", language=" + str8 + ")";
    }
}
