package com.arlosoft.macrodroid.translations.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Translation.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class Progress {
    public static final int $stable = 0;
    private final int translated;
    private final int untranslated;
    private final int words;

    public Progress(int i4, int i5, int i6) {
        this.translated = i4;
        this.untranslated = i5;
        this.words = i6;
    }

    public static /* synthetic */ Progress copy$default(Progress progress, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i4 = progress.translated;
        }
        if ((i7 & 2) != 0) {
            i5 = progress.untranslated;
        }
        if ((i7 & 4) != 0) {
            i6 = progress.words;
        }
        return progress.copy(i4, i5, i6);
    }

    public final int component1() {
        return this.translated;
    }

    public final int component2() {
        return this.untranslated;
    }

    public final int component3() {
        return this.words;
    }

    @NotNull
    public final Progress copy(int i4, int i5, int i6) {
        return new Progress(i4, i5, i6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Progress)) {
            return false;
        }
        Progress progress = (Progress) obj;
        if (this.translated == progress.translated && this.untranslated == progress.untranslated && this.words == progress.words) {
            return true;
        }
        return false;
    }

    public final int getTranslated() {
        return this.translated;
    }

    public final int getUntranslated() {
        return this.untranslated;
    }

    public final int getWords() {
        return this.words;
    }

    public int hashCode() {
        return (((this.translated * 31) + this.untranslated) * 31) + this.words;
    }

    @NotNull
    public String toString() {
        int i4 = this.translated;
        int i5 = this.untranslated;
        int i6 = this.words;
        return "Progress(translated=" + i4 + ", untranslated=" + i5 + ", words=" + i6 + ")";
    }
}
