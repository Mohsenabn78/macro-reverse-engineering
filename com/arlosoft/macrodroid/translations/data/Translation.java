package com.arlosoft.macrodroid.translations.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Translation.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class Translation {
    public static final int $stable = 0;
    @SerializedName("code")
    @NotNull
    private final String languageCode;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("progress")
    @NotNull
    private final Progress progress;
    @SerializedName("source")
    @NotNull
    private final String source;

    public Translation(@NotNull String languageCode, @NotNull String name, @NotNull String source, @NotNull Progress progress) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.languageCode = languageCode;
        this.name = name;
        this.source = source;
        this.progress = progress;
    }

    public static /* synthetic */ Translation copy$default(Translation translation, String str, String str2, String str3, Progress progress, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = translation.languageCode;
        }
        if ((i4 & 2) != 0) {
            str2 = translation.name;
        }
        if ((i4 & 4) != 0) {
            str3 = translation.source;
        }
        if ((i4 & 8) != 0) {
            progress = translation.progress;
        }
        return translation.copy(str, str2, str3, progress);
    }

    @NotNull
    public final String component1() {
        return this.languageCode;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.source;
    }

    @NotNull
    public final Progress component4() {
        return this.progress;
    }

    @NotNull
    public final Translation copy(@NotNull String languageCode, @NotNull String name, @NotNull String source, @NotNull Progress progress) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(progress, "progress");
        return new Translation(languageCode, name, source, progress);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Translation)) {
            return false;
        }
        Translation translation = (Translation) obj;
        if (Intrinsics.areEqual(this.languageCode, translation.languageCode) && Intrinsics.areEqual(this.name, translation.name) && Intrinsics.areEqual(this.source, translation.source) && Intrinsics.areEqual(this.progress, translation.progress)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getLanguageCode() {
        return this.languageCode;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Progress getProgress() {
        return this.progress;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        return (((((this.languageCode.hashCode() * 31) + this.name.hashCode()) * 31) + this.source.hashCode()) * 31) + this.progress.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.languageCode;
        String str2 = this.name;
        String str3 = this.source;
        Progress progress = this.progress;
        return "Translation(languageCode=" + str + ", name=" + str2 + ", source=" + str3 + ", progress=" + progress + ")";
    }
}
