package com.arlosoft.macrodroid.database.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserSubscriptionDao.kt */
@Dao
/* loaded from: classes3.dex */
public interface UserSubscriptionDao {
    @Insert(onConflict = 1)
    @Nullable
    Object addUserSubscription(@NotNull UserSubscription userSubscription, @NotNull Continuation<? super Long> continuation);

    @Query("DELETE FROM UserSubscription")
    @Nullable
    Object clearAll(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM UserSubscription WHERE userId == :userId")
    @Nullable
    Object deleteUserSubscription(int i4, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM UserSubscription")
    @Nullable
    Object getAllUserSubscriptions(@NotNull Continuation<? super List<UserSubscription>> continuation);

    @Query("SELECT * FROM UserSubscription WHERE userId == :userId")
    @Nullable
    Object getSubscriptionByUserId(int i4, @NotNull Continuation<? super UserSubscription> continuation);
}
