package com.arlosoft.macrodroid.database.room;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import org.jetbrains.annotations.NotNull;

/* compiled from: MacroDroidRoomDatabase.kt */
@StabilityInferred(parameters = 0)
@TypeConverters({Converters.class})
@Database(autoMigrations = {@AutoMigration(from = 1, to = 2), @AutoMigration(from = 2, to = 3), @AutoMigration(from = 3, to = 4)}, entities = {SystemLogEntry.class, UserSubscription.class, MacroSubscription.class, SubscriptionUpdateItem.class, BlockedUser.class, BlockedMacro.class, ExtraInstalled.class}, exportSchema = true, version = 4)
/* loaded from: classes3.dex */
public abstract class MacroDroidRoomDatabase extends RoomDatabase {
    public static final int $stable = 0;

    @NotNull
    public abstract BlockedMacroDao blockedMacroDao();

    @NotNull
    public abstract BlockedUserDao blockedUserDao();

    @NotNull
    public abstract ExtraInstalledDao extraInstalledDao();

    @NotNull
    public abstract MacroSubscriptionDao macroSubscriptionDao();

    @NotNull
    public abstract SubscriptionUpdateItemDao subscriptionUpdateItemDao();

    @NotNull
    public abstract SystemLogEntryDao systemLogEntryDao();

    @NotNull
    public abstract UserSubscriptionDao userSubscriptionDao();
}
