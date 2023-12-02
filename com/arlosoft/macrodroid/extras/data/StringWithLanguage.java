package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StringWithLanguages.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class StringWithLanguage {
    public static final int $stable = 0;
    @NotNull
    private final String languageCode;
    @NotNull
    private final String text;

    public StringWithLanguage(@NotNull String languageCode, @NotNull String text) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(text, "text");
        this.languageCode = languageCode;
        this.text = text;
    }

    public static /* synthetic */ StringWithLanguage copy$default(StringWithLanguage stringWithLanguage, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = stringWithLanguage.languageCode;
        }
        if ((i4 & 2) != 0) {
            str2 = stringWithLanguage.text;
        }
        return stringWithLanguage.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.languageCode;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final StringWithLanguage copy(@NotNull String languageCode, @NotNull String text) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(text, "text");
        return new StringWithLanguage(languageCode, text);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringWithLanguage)) {
            return false;
        }
        StringWithLanguage stringWithLanguage = (StringWithLanguage) obj;
        if (Intrinsics.areEqual(this.languageCode, stringWithLanguage.languageCode) && Intrinsics.areEqual(this.text, stringWithLanguage.text)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getLanguageCode() {
        return this.languageCode;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.languageCode.hashCode() * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.languageCode;
        String str2 = this.text;
        return "StringWithLanguage(languageCode=" + str + ", text=" + str2 + ")";
    }
}
