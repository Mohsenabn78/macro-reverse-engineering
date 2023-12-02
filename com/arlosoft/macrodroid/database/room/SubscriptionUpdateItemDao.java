package com.arlosoft.macrodroid.database.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SubscriptionUpdateItemDao.kt */
@Dao
/* loaded from: classes3.dex */
public interface SubscriptionUpdateItemDao {
    @Insert(onConflict = 1)
    @Nullable
    Object addSubscriptionUpdateItem(@NotNull SubscriptionUpdateItem subscriptionUpdateItem, @NotNull Continuation<? super Long> continuation);

    @Query("DELETE FROM SubscriptionUpdateItem")
    @Nullable
    Object clearAll(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM SubscriptionUpdateItem WHERE id == :id")
    @Nullable
    Object deleteSubscriptionUpdateItem(long j4, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM SubscriptionUpdateItem ORDER BY timestamp DESC")
    @Nullable
    Object getAllSubscriptionUpdateItems(@NotNull Continuation<? super List<SubscriptionUpdateItem>> continuation);
}
