package com.arlosoft.macrodroid.templatestore.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.comments.CommentableItem;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.macro.Macro;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroTemplate.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class MacroTemplate extends CommentableItem {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<MacroTemplate> CREATOR = new Creator();
    private final int categoryId;
    private final int commentCount;
    private boolean deleted;
    @NotNull
    private final String description;
    @Nullable
    private final String descriptionTranslated;
    private final int flagCount;
    private final int id;
    @NotNull
    private final String json;
    @NotNull
    private final String language;
    @Nullable
    private Macro macro;
    @NotNull
    private final String name;
    @Nullable
    private final String nameTranslated;
    private final int rootOnlyVersion;
    private final int starCount;
    private final boolean starred;
    private final long timestamp;
    @NotNull
    private final String translationLanguage;
    private final long updated;
    private boolean useTranslatedText;
    private final int userId;
    @NotNull
    private final String userImage;
    @NotNull
    private final String username;

    /* compiled from: MacroTemplate.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<MacroTemplate> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MacroTemplate createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MacroTemplate(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, (Macro) parcel.readParcelable(MacroTemplate.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MacroTemplate[] newArray(int i4) {
            return new MacroTemplate[i4];
        }
    }

    public MacroTemplate() {
        this(null, null, null, null, null, null, null, null, 0, 0L, null, 0, 0, 0, 0, 0, false, null, false, false, 0, 0L, 4194303, null);
    }

    @NotNull
    public final MacroTemplate clearJsonData() {
        return new MacroTemplate(this.name, this.nameTranslated, this.username, this.description, this.descriptionTranslated, this.translationLanguage, "", this.language, this.rootOnlyVersion, this.timestamp, this.userImage, this.id, this.userId, this.flagCount, this.commentCount, this.starCount, this.starred, this.macro, this.deleted, this.useTranslatedText, 0, 0L, 3145728, null);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final long component10() {
        return this.timestamp;
    }

    @NotNull
    public final String component11() {
        return this.userImage;
    }

    public final int component12() {
        return this.id;
    }

    public final int component13() {
        return this.userId;
    }

    public final int component14() {
        return this.flagCount;
    }

    public final int component15() {
        return this.commentCount;
    }

    public final int component16() {
        return this.starCount;
    }

    public final boolean component17() {
        return this.starred;
    }

    @Nullable
    public final Macro component18() {
        return this.macro;
    }

    public final boolean component19() {
        return this.deleted;
    }

    @Nullable
    public final String component2() {
        return this.nameTranslated;
    }

    public final boolean component20() {
        return this.useTranslatedText;
    }

    public final int component21() {
        return this.categoryId;
    }

    public final long component22() {
        return this.updated;
    }

    @NotNull
    public final String component3() {
        return this.username;
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
        return this.json;
    }

    @NotNull
    public final String component8() {
        return this.language;
    }

    public final int component9() {
        return this.rootOnlyVersion;
    }

    @NotNull
    public final MacroTemplate copy(@NotNull String name, @Nullable String str, @NotNull String username, @NotNull String description, @Nullable String str2, @NotNull String translationLanguage, @NotNull String json, @NotNull String language, int i4, long j4, @NotNull String userImage, int i5, int i6, int i7, int i8, int i9, boolean z3, @Nullable Macro macro, boolean z4, boolean z5, int i10, long j5) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(translationLanguage, "translationLanguage");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        return new MacroTemplate(name, str, username, description, str2, translationLanguage, json, language, i4, j4, userImage, i5, i6, i7, i8, i9, z3, macro, z4, z5, i10, j5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MacroTemplate)) {
            return false;
        }
        MacroTemplate macroTemplate = (MacroTemplate) obj;
        if (Intrinsics.areEqual(this.name, macroTemplate.name) && Intrinsics.areEqual(this.nameTranslated, macroTemplate.nameTranslated) && Intrinsics.areEqual(this.username, macroTemplate.username) && Intrinsics.areEqual(this.description, macroTemplate.description) && Intrinsics.areEqual(this.descriptionTranslated, macroTemplate.descriptionTranslated) && Intrinsics.areEqual(this.translationLanguage, macroTemplate.translationLanguage) && Intrinsics.areEqual(this.json, macroTemplate.json) && Intrinsics.areEqual(this.language, macroTemplate.language) && this.rootOnlyVersion == macroTemplate.rootOnlyVersion && this.timestamp == macroTemplate.timestamp && Intrinsics.areEqual(this.userImage, macroTemplate.userImage) && this.id == macroTemplate.id && this.userId == macroTemplate.userId && this.flagCount == macroTemplate.flagCount && this.commentCount == macroTemplate.commentCount && this.starCount == macroTemplate.starCount && this.starred == macroTemplate.starred && Intrinsics.areEqual(this.macro, macroTemplate.macro) && this.deleted == macroTemplate.deleted && this.useTranslatedText == macroTemplate.useTranslatedText && this.categoryId == macroTemplate.categoryId && this.updated == macroTemplate.updated) {
            return true;
        }
        return false;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final boolean getDeleted() {
        return this.deleted;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDescriptionTranslated() {
        return this.descriptionTranslated;
    }

    public final int getFlagCount() {
        return this.flagCount;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getJson() {
        return this.json;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final Macro getMacro() {
        return this.macro;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getNameToDisplay() {
        boolean z3;
        String str = this.nameTranslated;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            return this.name;
        }
        return this.nameTranslated;
    }

    @Nullable
    public final String getNameTranslated() {
        return this.nameTranslated;
    }

    public final int getRootOnlyVersion() {
        return this.rootOnlyVersion;
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

    public final long getUpdated() {
        return this.updated;
    }

    public final boolean getUseTranslatedText() {
        return this.useTranslatedText;
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

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.name.hashCode() * 31;
        String str = this.nameTranslated;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode4 = (((((hashCode3 + hashCode) * 31) + this.username.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str2 = this.descriptionTranslated;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int hashCode5 = (((((((((((((((((((((((hashCode4 + hashCode2) * 31) + this.translationLanguage.hashCode()) * 31) + this.json.hashCode()) * 31) + this.language.hashCode()) * 31) + this.rootOnlyVersion) * 31) + a.a(this.timestamp)) * 31) + this.userImage.hashCode()) * 31) + this.id) * 31) + this.userId) * 31) + this.flagCount) * 31) + this.commentCount) * 31) + this.starCount) * 31;
        boolean z3 = this.starred;
        int i5 = 1;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int i7 = (hashCode5 + i6) * 31;
        Macro macro = this.macro;
        if (macro != null) {
            i4 = macro.hashCode();
        }
        int i8 = (i7 + i4) * 31;
        boolean z4 = this.deleted;
        int i9 = z4;
        if (z4 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z5 = this.useTranslatedText;
        if (!z5) {
            i5 = z5 ? 1 : 0;
        }
        return ((((i10 + i5) * 31) + this.categoryId) * 31) + a.a(this.updated);
    }

    public final void setDeleted(boolean z3) {
        this.deleted = z3;
    }

    @NotNull
    public final MacroTemplate setFlagCount(int i4) {
        return new MacroTemplate(this.name, this.nameTranslated, this.username, this.description, this.descriptionTranslated, this.translationLanguage, this.json, this.language, this.rootOnlyVersion, this.timestamp, this.userImage, this.id, this.userId, i4, this.commentCount, this.starCount, this.starred, this.macro, this.deleted, this.useTranslatedText, 0, 0L, 3145728, null);
    }

    public final void setMacro(@Nullable Macro macro) {
        this.macro = macro;
    }

    @NotNull
    public final MacroTemplate setUseTranslated(boolean z3) {
        return new MacroTemplate(this.name, this.nameTranslated, this.username, this.description, this.descriptionTranslated, this.translationLanguage, this.json, this.language, this.rootOnlyVersion, this.timestamp, this.userImage, this.id, this.userId, this.flagCount, this.commentCount, this.starCount, this.starred, this.macro, this.deleted, z3, 0, 0L, 3145728, null);
    }

    public final void setUseTranslatedText(boolean z3) {
        this.useTranslatedText = z3;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.nameTranslated;
        String str3 = this.username;
        String str4 = this.description;
        String str5 = this.descriptionTranslated;
        String str6 = this.translationLanguage;
        String str7 = this.json;
        String str8 = this.language;
        int i4 = this.rootOnlyVersion;
        long j4 = this.timestamp;
        String str9 = this.userImage;
        int i5 = this.id;
        int i6 = this.userId;
        int i7 = this.flagCount;
        int i8 = this.commentCount;
        int i9 = this.starCount;
        boolean z3 = this.starred;
        Macro macro = this.macro;
        boolean z4 = this.deleted;
        boolean z5 = this.useTranslatedText;
        int i10 = this.categoryId;
        long j5 = this.updated;
        return "MacroTemplate(name=" + str + ", nameTranslated=" + str2 + ", username=" + str3 + ", description=" + str4 + ", descriptionTranslated=" + str5 + ", translationLanguage=" + str6 + ", json=" + str7 + ", language=" + str8 + ", rootOnlyVersion=" + i4 + ", timestamp=" + j4 + ", userImage=" + str9 + ", id=" + i5 + ", userId=" + i6 + ", flagCount=" + i7 + ", commentCount=" + i8 + ", starCount=" + i9 + ", starred=" + z3 + ", macro=" + macro + ", deleted=" + z4 + ", useTranslatedText=" + z5 + ", categoryId=" + i10 + ", updated=" + j5 + ")";
    }

    @NotNull
    public final MacroTemplate updateCommentCount(boolean z3) {
        int i4;
        String str = this.name;
        String str2 = this.nameTranslated;
        String str3 = this.username;
        String str4 = this.description;
        String str5 = this.descriptionTranslated;
        String str6 = this.translationLanguage;
        String str7 = this.json;
        String str8 = this.language;
        int i5 = this.rootOnlyVersion;
        long j4 = this.timestamp;
        String str9 = this.userImage;
        int i6 = this.id;
        int i7 = this.userId;
        int i8 = this.flagCount;
        int i9 = this.commentCount;
        if (z3) {
            i4 = i9 + 1;
        } else {
            i4 = i9 - 1;
        }
        return new MacroTemplate(str, str2, str3, str4, str5, str6, str7, str8, i5, j4, str9, i6, i7, i8, i4, this.starCount, this.starred, this.macro, this.deleted, this.useTranslatedText, 0, 0L, 3145728, null);
    }

    @NotNull
    public final MacroTemplate updateDescription(@NotNull String descriptionText) {
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        return new MacroTemplate(this.name, this.nameTranslated, this.username, descriptionText, descriptionText, this.translationLanguage, this.json, this.language, this.rootOnlyVersion, this.timestamp, this.userImage, this.id, this.userId, this.flagCount, this.commentCount, this.starCount, this.starred, this.macro, this.deleted, this.useTranslatedText, 0, 0L, 3145728, null);
    }

    @NotNull
    public final MacroTemplate updateName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MacroTemplate(name, name, this.username, this.description, this.descriptionTranslated, this.translationLanguage, this.json, this.language, this.rootOnlyVersion, this.timestamp, this.userImage, this.id, this.userId, this.flagCount, this.commentCount, this.starCount, this.starred, this.macro, this.deleted, this.useTranslatedText, 0, 0L, 3145728, null);
    }

    @NotNull
    public final MacroTemplate updateStarRating(boolean z3) {
        String str = this.name;
        String str2 = this.nameTranslated;
        String str3 = this.username;
        String str4 = this.description;
        String str5 = this.descriptionTranslated;
        String str6 = this.translationLanguage;
        String str7 = this.json;
        String str8 = this.language;
        int i4 = this.rootOnlyVersion;
        long j4 = this.timestamp;
        String str9 = this.userImage;
        int i5 = this.id;
        int i6 = this.userId;
        int i7 = this.flagCount;
        int i8 = this.commentCount;
        int i9 = this.starCount;
        if (z3) {
            i9++;
        }
        return new MacroTemplate(str, str2, str3, str4, str5, str6, str7, str8, i4, j4, str9, i5, i6, i7, i8, i9, z3, this.macro, this.deleted, this.useTranslatedText, 0, 0L, 3145728, null);
    }

    @Override // com.arlosoft.macrodroid.comments.CommentableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.name);
        out.writeString(this.nameTranslated);
        out.writeString(this.username);
        out.writeString(this.description);
        out.writeString(this.descriptionTranslated);
        out.writeString(this.translationLanguage);
        out.writeString(this.json);
        out.writeString(this.language);
        out.writeInt(this.rootOnlyVersion);
        out.writeLong(this.timestamp);
        out.writeString(this.userImage);
        out.writeInt(this.id);
        out.writeInt(this.userId);
        out.writeInt(this.flagCount);
        out.writeInt(this.commentCount);
        out.writeInt(this.starCount);
        out.writeInt(this.starred ? 1 : 0);
        out.writeParcelable(this.macro, i4);
        out.writeInt(this.deleted ? 1 : 0);
        out.writeInt(this.useTranslatedText ? 1 : 0);
        out.writeInt(this.categoryId);
        out.writeLong(this.updated);
    }

    public /* synthetic */ MacroTemplate(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i4, long j4, String str9, int i5, int i6, int i7, int i8, int i9, boolean z3, Macro macro, boolean z4, boolean z5, int i10, long j5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? "" : str6, (i11 & 64) != 0 ? "" : str7, (i11 & 128) != 0 ? "" : str8, (i11 & 256) != 0 ? 0 : i4, (i11 & 512) != 0 ? System.currentTimeMillis() : j4, (i11 & 1024) == 0 ? str9 : "", (i11 & 2048) != 0 ? 0 : i5, (i11 & 4096) != 0 ? 0 : i6, (i11 & 8192) != 0 ? 0 : i7, (i11 & 16384) != 0 ? 0 : i8, (i11 & 32768) != 0 ? 0 : i9, (i11 & 65536) != 0 ? false : z3, (i11 & 131072) != 0 ? null : macro, (i11 & 262144) != 0 ? false : z4, (i11 & 524288) != 0 ? false : z5, (i11 & 1048576) != 0 ? 0 : i10, (i11 & 2097152) != 0 ? 0L : j5);
    }

    @NotNull
    public final MacroTemplate setDeleted() {
        return new MacroTemplate(this.name, this.nameTranslated, this.username, this.description, this.descriptionTranslated, this.translationLanguage, this.json, this.language, this.rootOnlyVersion, this.timestamp, this.userImage, this.id, this.userId, this.flagCount, this.commentCount, this.starCount, this.starred, this.macro, true, this.useTranslatedText, 0, 0L, 3145728, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MacroTemplate(@NotNull String name, @Nullable String str, @NotNull String username, @NotNull String description, @Nullable String str2, @NotNull String translationLanguage, @NotNull String json, @NotNull String language, int i4, long j4, @NotNull String userImage, int i5, int i6, int i7, int i8, int i9, boolean z3, @Nullable Macro macro, boolean z4, boolean z5, int i10, long j5) {
        super(username);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(translationLanguage, "translationLanguage");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        this.name = name;
        this.nameTranslated = str;
        this.username = username;
        this.description = description;
        this.descriptionTranslated = str2;
        this.translationLanguage = translationLanguage;
        this.json = json;
        this.language = language;
        this.rootOnlyVersion = i4;
        this.timestamp = j4;
        this.userImage = userImage;
        this.id = i5;
        this.userId = i6;
        this.flagCount = i7;
        this.commentCount = i8;
        this.starCount = i9;
        this.starred = z3;
        this.macro = macro;
        this.deleted = z4;
        this.useTranslatedText = z5;
        this.categoryId = i10;
        this.updated = j5;
    }
}
