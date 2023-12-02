package com.arlosoft.macrodroid.confirmation.validation;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraSubscriptionData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ExtraSubscriptions {
    public static final int $stable = 8;
    @NotNull
    private final Map<String, ExtraSubscriptionData> map;

    public ExtraSubscriptions(@NotNull Map<String, ExtraSubscriptionData> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraSubscriptions copy$default(ExtraSubscriptions extraSubscriptions, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = extraSubscriptions.map;
        }
        return extraSubscriptions.copy(map);
    }

    @NotNull
    public final Map<String, ExtraSubscriptionData> component1() {
        return this.map;
    }

    @NotNull
    public final ExtraSubscriptions copy(@NotNull Map<String, ExtraSubscriptionData> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new ExtraSubscriptions(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ExtraSubscriptions) && Intrinsics.areEqual(this.map, ((ExtraSubscriptions) obj).map)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<String, ExtraSubscriptionData> getMap() {
        return this.map;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    @NotNull
    public String toString() {
        Map<String, ExtraSubscriptionData> map = this.map;
        return "ExtraSubscriptions(map=" + map + ")";
    }
}
