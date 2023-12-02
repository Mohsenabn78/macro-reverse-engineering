package com.arlosoft.macrodroid.templatestore.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UploadMacroBody.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class UploadMacroBody {
    public static final int $stable = 0;
    private final int categoryId;
    @NotNull
    private final String description;
    @NotNull
    private final String json;
    @NotNull
    private final String language;
    @NotNull
    private final String name;
    private final int rootOnlyVersion;
    private final int userId;

    public UploadMacroBody(int i4, @NotNull String name, @NotNull String description, @NotNull String json, int i5, @NotNull String language, int i6) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(language, "language");
        this.userId = i4;
        this.name = name;
        this.description = description;
        this.json = json;
        this.categoryId = i5;
        this.language = language;
        this.rootOnlyVersion = i6;
    }

    public static /* synthetic */ UploadMacroBody copy$default(UploadMacroBody uploadMacroBody, int i4, String str, String str2, String str3, int i5, String str4, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i4 = uploadMacroBody.userId;
        }
        if ((i7 & 2) != 0) {
            str = uploadMacroBody.name;
        }
        String str5 = str;
        if ((i7 & 4) != 0) {
            str2 = uploadMacroBody.description;
        }
        String str6 = str2;
        if ((i7 & 8) != 0) {
            str3 = uploadMacroBody.json;
        }
        String str7 = str3;
        if ((i7 & 16) != 0) {
            i5 = uploadMacroBody.categoryId;
        }
        int i8 = i5;
        if ((i7 & 32) != 0) {
            str4 = uploadMacroBody.language;
        }
        String str8 = str4;
        if ((i7 & 64) != 0) {
            i6 = uploadMacroBody.rootOnlyVersion;
        }
        return uploadMacroBody.copy(i4, str5, str6, str7, i8, str8, i6);
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
        return this.description;
    }

    @NotNull
    public final String component4() {
        return this.json;
    }

    public final int component5() {
        return this.categoryId;
    }

    @NotNull
    public final String component6() {
        return this.language;
    }

    public final int component7() {
        return this.rootOnlyVersion;
    }

    @NotNull
    public final UploadMacroBody copy(int i4, @NotNull String name, @NotNull String description, @NotNull String json, int i5, @NotNull String language, int i6) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(language, "language");
        return new UploadMacroBody(i4, name, description, json, i5, language, i6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadMacroBody)) {
            return false;
        }
        UploadMacroBody uploadMacroBody = (UploadMacroBody) obj;
        if (this.userId == uploadMacroBody.userId && Intrinsics.areEqual(this.name, uploadMacroBody.name) && Intrinsics.areEqual(this.description, uploadMacroBody.description) && Intrinsics.areEqual(this.json, uploadMacroBody.json) && this.categoryId == uploadMacroBody.categoryId && Intrinsics.areEqual(this.language, uploadMacroBody.language) && this.rootOnlyVersion == uploadMacroBody.rootOnlyVersion) {
            return true;
        }
        return false;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getJson() {
        return this.json;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getRootOnlyVersion() {
        return this.rootOnlyVersion;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((((((this.userId * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.json.hashCode()) * 31) + this.categoryId) * 31) + this.language.hashCode()) * 31) + this.rootOnlyVersion;
    }

    @NotNull
    public String toString() {
        int i4 = this.userId;
        String str = this.name;
        String str2 = this.description;
        String str3 = this.json;
        int i5 = this.categoryId;
        String str4 = this.language;
        int i6 = this.rootOnlyVersion;
        return "UploadMacroBody(userId=" + i4 + ", name=" + str + ", description=" + str2 + ", json=" + str3 + ", categoryId=" + i5 + ", language=" + str4 + ", rootOnlyVersion=" + i6 + ")";
    }
}
