package com.arlosoft.macrodroid.plugins.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.comments.CommentableItem;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PluginDetail.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class PluginDetail extends CommentableItem {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<PluginDetail> CREATOR = new Creator();
    private final int commentCount;
    @NotNull
    private final String description;
    @Nullable
    private final String descriptionTranslated;
    @NotNull
    private final String developerName;
    @NotNull
    private final String downloadLink;
    @NotNull
    private final String iconUrl;
    private final int id;
    @NotNull
    private final String language;
    @NotNull
    private final String name;
    @Nullable
    private final String nameTranslated;
    @NotNull
    private final String packageName;
    private final int starCount;
    private final boolean starred;
    private final long timestamp;
    @NotNull
    private final String translationLanguage;
    private final int userId;
    @NotNull
    private final String userImage;
    @NotNull
    private final String username;
    @NotNull
    private final String website;

    /* compiled from: PluginDetail.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PluginDetail> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PluginDetail createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PluginDetail(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PluginDetail[] newArray(int i4) {
            return new PluginDetail[i4];
        }
    }

    public /* synthetic */ PluginDetail(int i4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j4, int i5, int i6, int i7, String str12, String str13, boolean z3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, str, (i8 & 4) != 0 ? null : str2, str3, (i8 & 16) != 0 ? null : str4, (i8 & 32) != 0 ? "" : str5, str6, str7, str8, str9, str10, str11, (i8 & 4096) != 0 ? System.currentTimeMillis() : j4, (i8 & 8192) != 0 ? 0 : i5, (i8 & 16384) != 0 ? 0 : i6, (32768 & i8) != 0 ? 0 : i7, str12, str13, (i8 & 262144) != 0 ? false : z3);
    }

    public final int component1() {
        return this.id;
    }

    @NotNull
    public final String component10() {
        return this.iconUrl;
    }

    @NotNull
    public final String component11() {
        return this.website;
    }

    @NotNull
    public final String component12() {
        return this.downloadLink;
    }

    public final long component13() {
        return this.timestamp;
    }

    public final int component14() {
        return this.userId;
    }

    public final int component15() {
        return this.commentCount;
    }

    public final int component16() {
        return this.starCount;
    }

    @NotNull
    public final String component17() {
        return this.username;
    }

    @NotNull
    public final String component18() {
        return this.userImage;
    }

    public final boolean component19() {
        return this.starred;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final String component3() {
        return this.nameTranslated;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @Nullable
    public final String component5() {
        return this.descriptionTranslated;
    }

    @NotNull
    public final String component6() {
        return this.translationLanguage;
    }

    @NotNull
    public final String component7() {
        return this.language;
    }

    @NotNull
    public final String component8() {
        return this.packageName;
    }

    @NotNull
    public final String component9() {
        return this.developerName;
    }

    @NotNull
    public final PluginDetail copy(int i4, @NotNull String name, @Nullable String str, @NotNull String description, @Nullable String str2, @NotNull String translationLanguage, @NotNull String language, @NotNull String packageName, @NotNull String developerName, @NotNull String iconUrl, @NotNull String website, @NotNull String downloadLink, long j4, int i5, int i6, int i7, @NotNull String username, @NotNull String userImage, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(translationLanguage, "translationLanguage");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(downloadLink, "downloadLink");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        return new PluginDetail(i4, name, str, description, str2, translationLanguage, language, packageName, developerName, iconUrl, website, downloadLink, j4, i5, i6, i7, username, userImage, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginDetail)) {
            return false;
        }
        PluginDetail pluginDetail = (PluginDetail) obj;
        if (this.id == pluginDetail.id && Intrinsics.areEqual(this.name, pluginDetail.name) && Intrinsics.areEqual(this.nameTranslated, pluginDetail.nameTranslated) && Intrinsics.areEqual(this.description, pluginDetail.description) && Intrinsics.areEqual(this.descriptionTranslated, pluginDetail.descriptionTranslated) && Intrinsics.areEqual(this.translationLanguage, pluginDetail.translationLanguage) && Intrinsics.areEqual(this.language, pluginDetail.language) && Intrinsics.areEqual(this.packageName, pluginDetail.packageName) && Intrinsics.areEqual(this.developerName, pluginDetail.developerName) && Intrinsics.areEqual(this.iconUrl, pluginDetail.iconUrl) && Intrinsics.areEqual(this.website, pluginDetail.website) && Intrinsics.areEqual(this.downloadLink, pluginDetail.downloadLink) && this.timestamp == pluginDetail.timestamp && this.userId == pluginDetail.userId && this.commentCount == pluginDetail.commentCount && this.starCount == pluginDetail.starCount && Intrinsics.areEqual(this.username, pluginDetail.username) && Intrinsics.areEqual(this.userImage, pluginDetail.userImage) && this.starred == pluginDetail.starred) {
            return true;
        }
        return false;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDescriptionTranslated() {
        return this.descriptionTranslated;
    }

    @NotNull
    public final String getDeveloperName() {
        return this.developerName;
    }

    @NotNull
    public final String getDownloadLink() {
        return this.downloadLink;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNameTranslated() {
        return this.nameTranslated;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final int getStarCount() {
        return this.starCount;
    }

    public final boolean getStarred() {
        return this.starred;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getTranslationLanguage() {
        return this.translationLanguage;
    }

    public final int getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getUserImage() {
        return this.userImage;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    @NotNull
    public final String getWebsite() {
        return this.website;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.id * 31) + this.name.hashCode()) * 31;
        String str = this.nameTranslated;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((hashCode2 + hashCode) * 31) + this.description.hashCode()) * 31;
        String str2 = this.descriptionTranslated;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        int hashCode4 = (((((((((((((((((((((((((((hashCode3 + i4) * 31) + this.translationLanguage.hashCode()) * 31) + this.language.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.developerName.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.website.hashCode()) * 31) + this.downloadLink.hashCode()) * 31) + androidx.compose.animation.a.a(this.timestamp)) * 31) + this.userId) * 31) + this.commentCount) * 31) + this.starCount) * 31) + this.username.hashCode()) * 31) + this.userImage.hashCode()) * 31;
        boolean z3 = this.starred;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        return hashCode4 + i5;
    }

    @NotNull
    public String toString() {
        int i4 = this.id;
        String str = this.name;
        String str2 = this.nameTranslated;
        String str3 = this.description;
        String str4 = this.descriptionTranslated;
        String str5 = this.translationLanguage;
        String str6 = this.language;
        String str7 = this.packageName;
        String str8 = this.developerName;
        String str9 = this.iconUrl;
        String str10 = this.website;
        String str11 = this.downloadLink;
        long j4 = this.timestamp;
        int i5 = this.userId;
        int i6 = this.commentCount;
        int i7 = this.starCount;
        String str12 = this.username;
        String str13 = this.userImage;
        boolean z3 = this.starred;
        return "PluginDetail(id=" + i4 + ", name=" + str + ", nameTranslated=" + str2 + ", description=" + str3 + ", descriptionTranslated=" + str4 + ", translationLanguage=" + str5 + ", language=" + str6 + ", packageName=" + str7 + ", developerName=" + str8 + ", iconUrl=" + str9 + ", website=" + str10 + ", downloadLink=" + str11 + ", timestamp=" + j4 + ", userId=" + i5 + ", commentCount=" + i6 + ", starCount=" + i7 + ", username=" + str12 + ", userImage=" + str13 + ", starred=" + z3 + ")";
    }

    @NotNull
    public final PluginDetail updateCommentCount(boolean z3) {
        int i4;
        int i5 = this.id;
        String str = this.name;
        String str2 = this.nameTranslated;
        String str3 = this.description;
        String str4 = this.descriptionTranslated;
        String str5 = this.translationLanguage;
        String str6 = this.language;
        String str7 = this.packageName;
        String str8 = this.developerName;
        String str9 = this.iconUrl;
        String str10 = this.website;
        String str11 = this.downloadLink;
        long j4 = this.timestamp;
        int i6 = this.userId;
        int i7 = this.commentCount;
        if (z3) {
            i4 = i7 + 1;
        } else {
            i4 = i7 - 1;
        }
        return new PluginDetail(i5, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, j4, i6, i4, this.starCount, this.username, this.userImage, this.starred);
    }

    @NotNull
    public final PluginDetail updateStarRating(boolean z3) {
        int i4;
        int i5 = this.id;
        String str = this.name;
        String str2 = this.nameTranslated;
        String str3 = this.description;
        String str4 = this.descriptionTranslated;
        String str5 = this.translationLanguage;
        String str6 = this.language;
        String str7 = this.packageName;
        String str8 = this.developerName;
        String str9 = this.iconUrl;
        String str10 = this.website;
        String str11 = this.downloadLink;
        long j4 = this.timestamp;
        int i6 = this.userId;
        int i7 = this.commentCount;
        int i8 = this.starCount;
        if (z3) {
            i4 = i8 + 1;
        } else {
            i4 = i8 - 1;
        }
        return new PluginDetail(i5, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, j4, i6, i7, i4, this.username, this.userImage, z3);
    }

    @Override // com.arlosoft.macrodroid.comments.CommentableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.id);
        out.writeString(this.name);
        out.writeString(this.nameTranslated);
        out.writeString(this.description);
        out.writeString(this.descriptionTranslated);
        out.writeString(this.translationLanguage);
        out.writeString(this.language);
        out.writeString(this.packageName);
        out.writeString(this.developerName);
        out.writeString(this.iconUrl);
        out.writeString(this.website);
        out.writeString(this.downloadLink);
        out.writeLong(this.timestamp);
        out.writeInt(this.userId);
        out.writeInt(this.commentCount);
        out.writeInt(this.starCount);
        out.writeString(this.username);
        out.writeString(this.userImage);
        out.writeInt(this.starred ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginDetail(int i4, @NotNull String name, @Nullable String str, @NotNull String description, @Nullable String str2, @NotNull String translationLanguage, @NotNull String language, @NotNull String packageName, @NotNull String developerName, @NotNull String iconUrl, @NotNull String website, @NotNull String downloadLink, long j4, int i5, int i6, int i7, @NotNull String username, @NotNull String userImage, boolean z3) {
        super(username);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(translationLanguage, "translationLanguage");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(downloadLink, "downloadLink");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        this.id = i4;
        this.name = name;
        this.nameTranslated = str;
        this.description = description;
        this.descriptionTranslated = str2;
        this.translationLanguage = translationLanguage;
        this.language = language;
        this.packageName = packageName;
        this.developerName = developerName;
        this.iconUrl = iconUrl;
        this.website = website;
        this.downloadLink = downloadLink;
        this.timestamp = j4;
        this.userId = i5;
        this.commentCount = i6;
        this.starCount = i7;
        this.username = username;
        this.userImage = userImage;
        this.starred = z3;
    }
}
