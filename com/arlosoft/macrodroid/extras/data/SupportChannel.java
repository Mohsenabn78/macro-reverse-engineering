package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraPackage.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class SupportChannel {
    public static final int $stable = 8;
    @Nullable
    private final StringWithLanguages label;
    @NotNull
    private final String link;
    private final boolean subscribersOnly;

    public SupportChannel(@NotNull String link, @Nullable StringWithLanguages stringWithLanguages, boolean z3) {
        Intrinsics.checkNotNullParameter(link, "link");
        this.link = link;
        this.label = stringWithLanguages;
        this.subscribersOnly = z3;
    }

    public static /* synthetic */ SupportChannel copy$default(SupportChannel supportChannel, String str, StringWithLanguages stringWithLanguages, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = supportChannel.link;
        }
        if ((i4 & 2) != 0) {
            stringWithLanguages = supportChannel.label;
        }
        if ((i4 & 4) != 0) {
            z3 = supportChannel.subscribersOnly;
        }
        return supportChannel.copy(str, stringWithLanguages, z3);
    }

    @NotNull
    public final String component1() {
        return this.link;
    }

    @Nullable
    public final StringWithLanguages component2() {
        return this.label;
    }

    public final boolean component3() {
        return this.subscribersOnly;
    }

    @NotNull
    public final SupportChannel copy(@NotNull String link, @Nullable StringWithLanguages stringWithLanguages, boolean z3) {
        Intrinsics.checkNotNullParameter(link, "link");
        return new SupportChannel(link, stringWithLanguages, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SupportChannel)) {
            return false;
        }
        SupportChannel supportChannel = (SupportChannel) obj;
        if (Intrinsics.areEqual(this.link, supportChannel.link) && Intrinsics.areEqual(this.label, supportChannel.label) && this.subscribersOnly == supportChannel.subscribersOnly) {
            return true;
        }
        return false;
    }

    @Nullable
    public final StringWithLanguages getLabel() {
        return this.label;
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }

    public final boolean getSubscribersOnly() {
        return this.subscribersOnly;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.link.hashCode() * 31;
        StringWithLanguages stringWithLanguages = this.label;
        if (stringWithLanguages == null) {
            hashCode = 0;
        } else {
            hashCode = stringWithLanguages.hashCode();
        }
        int i4 = (hashCode2 + hashCode) * 31;
        boolean z3 = this.subscribersOnly;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        return i4 + i5;
    }

    @NotNull
    public String toString() {
        String str = this.link;
        StringWithLanguages stringWithLanguages = this.label;
        boolean z3 = this.subscribersOnly;
        return "SupportChannel(link=" + str + ", label=" + stringWithLanguages + ", subscribersOnly=" + z3 + ")";
    }
}
