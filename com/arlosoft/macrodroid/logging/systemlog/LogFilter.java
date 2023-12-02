package com.arlosoft.macrodroid.logging.systemlog;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.database.room.LogLevel;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogFilter.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class LogFilter {
    @NotNull
    private final List<Long> disabledMacroIds;
    @NotNull
    private final List<String> disabledVariableNames;
    private final int logLevel;
    private final boolean showActions;
    private final boolean showConstraints;
    private final boolean showTriggers;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull
    private static final LogFilter defaultConfig = new LogFilter(LogLevel.INFO.getLevelInt(), true, true, true, null, null, 48, null);

    public LogFilter(int i4, boolean z3, boolean z4, boolean z5, @NotNull List<Long> disabledMacroIds, @NotNull List<String> disabledVariableNames) {
        Intrinsics.checkNotNullParameter(disabledMacroIds, "disabledMacroIds");
        Intrinsics.checkNotNullParameter(disabledVariableNames, "disabledVariableNames");
        this.logLevel = i4;
        this.showTriggers = z3;
        this.showActions = z4;
        this.showConstraints = z5;
        this.disabledMacroIds = disabledMacroIds;
        this.disabledVariableNames = disabledVariableNames;
    }

    public static /* synthetic */ LogFilter copy$default(LogFilter logFilter, int i4, boolean z3, boolean z4, boolean z5, List list, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = logFilter.logLevel;
        }
        if ((i5 & 2) != 0) {
            z3 = logFilter.showTriggers;
        }
        boolean z6 = z3;
        if ((i5 & 4) != 0) {
            z4 = logFilter.showActions;
        }
        boolean z7 = z4;
        if ((i5 & 8) != 0) {
            z5 = logFilter.showConstraints;
        }
        boolean z8 = z5;
        List<Long> list3 = list;
        if ((i5 & 16) != 0) {
            list3 = logFilter.disabledMacroIds;
        }
        List list4 = list3;
        List<String> list5 = list2;
        if ((i5 & 32) != 0) {
            list5 = logFilter.disabledVariableNames;
        }
        return logFilter.copy(i4, z6, z7, z8, list4, list5);
    }

    @NotNull
    public static final LogFilter getDefaultConfig() {
        return Companion.getDefaultConfig();
    }

    public final int component1() {
        return this.logLevel;
    }

    public final boolean component2() {
        return this.showTriggers;
    }

    public final boolean component3() {
        return this.showActions;
    }

    public final boolean component4() {
        return this.showConstraints;
    }

    @NotNull
    public final List<Long> component5() {
        return this.disabledMacroIds;
    }

    @NotNull
    public final List<String> component6() {
        return this.disabledVariableNames;
    }

    @NotNull
    public final LogFilter copy(int i4, boolean z3, boolean z4, boolean z5, @NotNull List<Long> disabledMacroIds, @NotNull List<String> disabledVariableNames) {
        Intrinsics.checkNotNullParameter(disabledMacroIds, "disabledMacroIds");
        Intrinsics.checkNotNullParameter(disabledVariableNames, "disabledVariableNames");
        return new LogFilter(i4, z3, z4, z5, disabledMacroIds, disabledVariableNames);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogFilter)) {
            return false;
        }
        LogFilter logFilter = (LogFilter) obj;
        if (this.logLevel == logFilter.logLevel && this.showTriggers == logFilter.showTriggers && this.showActions == logFilter.showActions && this.showConstraints == logFilter.showConstraints && Intrinsics.areEqual(this.disabledMacroIds, logFilter.disabledMacroIds) && Intrinsics.areEqual(this.disabledVariableNames, logFilter.disabledVariableNames)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<Long> getDisabledMacroIds() {
        return this.disabledMacroIds;
    }

    @NotNull
    public final List<String> getDisabledVariableNames() {
        return this.disabledVariableNames;
    }

    public final int getLogLevel() {
        return this.logLevel;
    }

    @NotNull
    public final LogLevel getLogLevelEnum() {
        return LogLevel.Companion.fromIntLevel(this.logLevel);
    }

    public final boolean getShowActions() {
        return this.showActions;
    }

    public final boolean getShowConstraints() {
        return this.showConstraints;
    }

    public final boolean getShowTriggers() {
        return this.showTriggers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i4 = this.logLevel * 31;
        boolean z3 = this.showTriggers;
        int i5 = 1;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int i7 = (i4 + i6) * 31;
        boolean z4 = this.showActions;
        int i8 = z4;
        if (z4 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z5 = this.showConstraints;
        if (!z5) {
            i5 = z5 ? 1 : 0;
        }
        return ((((i9 + i5) * 31) + this.disabledMacroIds.hashCode()) * 31) + this.disabledVariableNames.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.logLevel;
        boolean z3 = this.showTriggers;
        boolean z4 = this.showActions;
        boolean z5 = this.showConstraints;
        List<Long> list = this.disabledMacroIds;
        List<String> list2 = this.disabledVariableNames;
        return "LogFilter(logLevel=" + i4 + ", showTriggers=" + z3 + ", showActions=" + z4 + ", showConstraints=" + z5 + ", disabledMacroIds=" + list + ", disabledVariableNames=" + list2 + ")";
    }

    public /* synthetic */ LogFilter(int i4, boolean z3, boolean z4, boolean z5, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, z3, z4, z5, (i5 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i5 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }

    /* compiled from: LogFilter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LogFilter getDefaultConfig() {
            return LogFilter.defaultConfig;
        }

        @JvmStatic
        public static /* synthetic */ void getDefaultConfig$annotations() {
        }
    }
}
