package com.arlosoft.macrodroid.extras.data;

import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraMacroSetData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ExtraMacroSetData {
    public static final int $stable = 0;
    private final long checkTime;
    @NotNull
    private final String chunk;
    @NotNull
    private final String expiryTime;
    @NotNull
    private final String macroSet;
    @Nullable
    private final String message;
    private final int status;

    public ExtraMacroSetData(int i4, @NotNull String macroSet, @NotNull String chunk, long j4, @NotNull String expiryTime, @Nullable String str) {
        Intrinsics.checkNotNullParameter(macroSet, "macroSet");
        Intrinsics.checkNotNullParameter(chunk, "chunk");
        Intrinsics.checkNotNullParameter(expiryTime, "expiryTime");
        this.status = i4;
        this.macroSet = macroSet;
        this.chunk = chunk;
        this.checkTime = j4;
        this.expiryTime = expiryTime;
        this.message = str;
    }

    public static /* synthetic */ ExtraMacroSetData copy$default(ExtraMacroSetData extraMacroSetData, int i4, String str, String str2, long j4, String str3, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = extraMacroSetData.status;
        }
        if ((i5 & 2) != 0) {
            str = extraMacroSetData.macroSet;
        }
        String str5 = str;
        if ((i5 & 4) != 0) {
            str2 = extraMacroSetData.chunk;
        }
        String str6 = str2;
        if ((i5 & 8) != 0) {
            j4 = extraMacroSetData.checkTime;
        }
        long j5 = j4;
        if ((i5 & 16) != 0) {
            str3 = extraMacroSetData.expiryTime;
        }
        String str7 = str3;
        if ((i5 & 32) != 0) {
            str4 = extraMacroSetData.message;
        }
        return extraMacroSetData.copy(i4, str5, str6, j5, str7, str4);
    }

    public final int component1() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.macroSet;
    }

    @NotNull
    public final String component3() {
        return this.chunk;
    }

    public final long component4() {
        return this.checkTime;
    }

    @NotNull
    public final String component5() {
        return this.expiryTime;
    }

    @Nullable
    public final String component6() {
        return this.message;
    }

    @NotNull
    public final ExtraMacroSetData copy(int i4, @NotNull String macroSet, @NotNull String chunk, long j4, @NotNull String expiryTime, @Nullable String str) {
        Intrinsics.checkNotNullParameter(macroSet, "macroSet");
        Intrinsics.checkNotNullParameter(chunk, "chunk");
        Intrinsics.checkNotNullParameter(expiryTime, "expiryTime");
        return new ExtraMacroSetData(i4, macroSet, chunk, j4, expiryTime, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraMacroSetData)) {
            return false;
        }
        ExtraMacroSetData extraMacroSetData = (ExtraMacroSetData) obj;
        if (this.status == extraMacroSetData.status && Intrinsics.areEqual(this.macroSet, extraMacroSetData.macroSet) && Intrinsics.areEqual(this.chunk, extraMacroSetData.chunk) && this.checkTime == extraMacroSetData.checkTime && Intrinsics.areEqual(this.expiryTime, extraMacroSetData.expiryTime) && Intrinsics.areEqual(this.message, extraMacroSetData.message)) {
            return true;
        }
        return false;
    }

    public final long getCheckTime() {
        return this.checkTime;
    }

    @NotNull
    public final String getChunk() {
        return this.chunk;
    }

    @NotNull
    public final String getExpiryTime() {
        return this.expiryTime;
    }

    @NotNull
    public final String getMacroSet() {
        return this.macroSet;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((this.status * 31) + this.macroSet.hashCode()) * 31) + this.chunk.hashCode()) * 31) + a.a(this.checkTime)) * 31) + this.expiryTime.hashCode()) * 31;
        String str = this.message;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        int i4 = this.status;
        String str = this.macroSet;
        String str2 = this.chunk;
        long j4 = this.checkTime;
        String str3 = this.expiryTime;
        String str4 = this.message;
        return "ExtraMacroSetData(status=" + i4 + ", macroSet=" + str + ", chunk=" + str2 + ", checkTime=" + j4 + ", expiryTime=" + str3 + ", message=" + str4 + ")";
    }
}
