package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraVersionHistoryEntry.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ExtraVersionHistoryEntry {
    public static final int $stable = 8;
    private final int versionCode;
    @NotNull
    private final StringWithLanguages versionDescription;
    @NotNull
    private final String versionString;

    public ExtraVersionHistoryEntry(@NotNull String versionString, int i4, @NotNull StringWithLanguages versionDescription) {
        Intrinsics.checkNotNullParameter(versionString, "versionString");
        Intrinsics.checkNotNullParameter(versionDescription, "versionDescription");
        this.versionString = versionString;
        this.versionCode = i4;
        this.versionDescription = versionDescription;
    }

    public static /* synthetic */ ExtraVersionHistoryEntry copy$default(ExtraVersionHistoryEntry extraVersionHistoryEntry, String str, int i4, StringWithLanguages stringWithLanguages, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = extraVersionHistoryEntry.versionString;
        }
        if ((i5 & 2) != 0) {
            i4 = extraVersionHistoryEntry.versionCode;
        }
        if ((i5 & 4) != 0) {
            stringWithLanguages = extraVersionHistoryEntry.versionDescription;
        }
        return extraVersionHistoryEntry.copy(str, i4, stringWithLanguages);
    }

    @NotNull
    public final String component1() {
        return this.versionString;
    }

    public final int component2() {
        return this.versionCode;
    }

    @NotNull
    public final StringWithLanguages component3() {
        return this.versionDescription;
    }

    @NotNull
    public final ExtraVersionHistoryEntry copy(@NotNull String versionString, int i4, @NotNull StringWithLanguages versionDescription) {
        Intrinsics.checkNotNullParameter(versionString, "versionString");
        Intrinsics.checkNotNullParameter(versionDescription, "versionDescription");
        return new ExtraVersionHistoryEntry(versionString, i4, versionDescription);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraVersionHistoryEntry)) {
            return false;
        }
        ExtraVersionHistoryEntry extraVersionHistoryEntry = (ExtraVersionHistoryEntry) obj;
        if (Intrinsics.areEqual(this.versionString, extraVersionHistoryEntry.versionString) && this.versionCode == extraVersionHistoryEntry.versionCode && Intrinsics.areEqual(this.versionDescription, extraVersionHistoryEntry.versionDescription)) {
            return true;
        }
        return false;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final StringWithLanguages getVersionDescription() {
        return this.versionDescription;
    }

    @NotNull
    public final String getVersionString() {
        return this.versionString;
    }

    public int hashCode() {
        return (((this.versionString.hashCode() * 31) + this.versionCode) * 31) + this.versionDescription.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.versionString;
        int i4 = this.versionCode;
        StringWithLanguages stringWithLanguages = this.versionDescription;
        return "ExtraVersionHistoryEntry(versionString=" + str + ", versionCode=" + i4 + ", versionDescription=" + stringWithLanguages + ")";
    }
}
