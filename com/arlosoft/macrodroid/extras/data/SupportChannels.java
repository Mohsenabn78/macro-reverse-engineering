package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraPackage.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class SupportChannels {
    public static final int $stable = 8;
    @NotNull
    private final StringWithLanguages basicTitle;
    @NotNull
    private final Map<SupportChannelType, SupportChannel> channels;
    @NotNull
    private final StringWithLanguages premiumTitle;

    public SupportChannels(@NotNull StringWithLanguages premiumTitle, @NotNull StringWithLanguages basicTitle, @NotNull Map<SupportChannelType, SupportChannel> channels) {
        Intrinsics.checkNotNullParameter(premiumTitle, "premiumTitle");
        Intrinsics.checkNotNullParameter(basicTitle, "basicTitle");
        Intrinsics.checkNotNullParameter(channels, "channels");
        this.premiumTitle = premiumTitle;
        this.basicTitle = basicTitle;
        this.channels = channels;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SupportChannels copy$default(SupportChannels supportChannels, StringWithLanguages stringWithLanguages, StringWithLanguages stringWithLanguages2, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            stringWithLanguages = supportChannels.premiumTitle;
        }
        if ((i4 & 2) != 0) {
            stringWithLanguages2 = supportChannels.basicTitle;
        }
        if ((i4 & 4) != 0) {
            map = supportChannels.channels;
        }
        return supportChannels.copy(stringWithLanguages, stringWithLanguages2, map);
    }

    @NotNull
    public final StringWithLanguages component1() {
        return this.premiumTitle;
    }

    @NotNull
    public final StringWithLanguages component2() {
        return this.basicTitle;
    }

    @NotNull
    public final Map<SupportChannelType, SupportChannel> component3() {
        return this.channels;
    }

    @NotNull
    public final SupportChannels copy(@NotNull StringWithLanguages premiumTitle, @NotNull StringWithLanguages basicTitle, @NotNull Map<SupportChannelType, SupportChannel> channels) {
        Intrinsics.checkNotNullParameter(premiumTitle, "premiumTitle");
        Intrinsics.checkNotNullParameter(basicTitle, "basicTitle");
        Intrinsics.checkNotNullParameter(channels, "channels");
        return new SupportChannels(premiumTitle, basicTitle, channels);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SupportChannels)) {
            return false;
        }
        SupportChannels supportChannels = (SupportChannels) obj;
        if (Intrinsics.areEqual(this.premiumTitle, supportChannels.premiumTitle) && Intrinsics.areEqual(this.basicTitle, supportChannels.basicTitle) && Intrinsics.areEqual(this.channels, supportChannels.channels)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final StringWithLanguages getBasicTitle() {
        return this.basicTitle;
    }

    @NotNull
    public final Map<SupportChannelType, SupportChannel> getChannels() {
        return this.channels;
    }

    @NotNull
    public final StringWithLanguages getPremiumTitle() {
        return this.premiumTitle;
    }

    public int hashCode() {
        return (((this.premiumTitle.hashCode() * 31) + this.basicTitle.hashCode()) * 31) + this.channels.hashCode();
    }

    @NotNull
    public String toString() {
        StringWithLanguages stringWithLanguages = this.premiumTitle;
        StringWithLanguages stringWithLanguages2 = this.basicTitle;
        Map<SupportChannelType, SupportChannel> map = this.channels;
        return "SupportChannels(premiumTitle=" + stringWithLanguages + ", basicTitle=" + stringWithLanguages2 + ", channels=" + map + ")";
    }
}
