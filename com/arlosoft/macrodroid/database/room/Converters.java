package com.arlosoft.macrodroid.database.room;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.TypeConverter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Converters.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class Converters {
    public static final int $stable = 0;

    @TypeConverter
    @NotNull
    public final LogLevel idToSleepNoteIcon(int i4) {
        return LogLevel.Companion.fromIntLevel(i4);
    }

    @TypeConverter
    @NotNull
    public final LogFlag indexToLogFlag(int i4) {
        return LogFlag.values()[i4];
    }

    @TypeConverter
    @NotNull
    public final SubcriptionUpdateType indexToSubscriptionUpdateType(int i4) {
        return SubcriptionUpdateType.values()[i4];
    }

    @TypeConverter
    public final int logFlagToIndex(@NotNull LogFlag logFlag) {
        Intrinsics.checkNotNullParameter(logFlag, "logFlag");
        return logFlag.ordinal();
    }

    @TypeConverter
    public final int sleepNoteIconToId(@NotNull LogLevel sleepNoteIcon) {
        Intrinsics.checkNotNullParameter(sleepNoteIcon, "sleepNoteIcon");
        return sleepNoteIcon.getLevelInt();
    }

    @TypeConverter
    public final int subscriptionUpdateTypeToIndex(@NotNull SubcriptionUpdateType updateType) {
        Intrinsics.checkNotNullParameter(updateType, "updateType");
        return updateType.ordinal();
    }
}
