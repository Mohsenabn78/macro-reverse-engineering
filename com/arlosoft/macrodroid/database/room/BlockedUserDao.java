package com.arlosoft.macrodroid.database.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BlockedUserDao.kt */
@Dao
/* loaded from: classes3.dex */
public interface BlockedUserDao {
    @Insert(onConflict = 1)
    @Nullable
    Object addBlockedUser(@NotNull BlockedUser blockedUser, @NotNull Continuation<? super Long> continuation);

    @Query("DELETE FROM BlockedUser")
    @Nullable
    Object clearAll(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM BlockedUser WHERE userId == :userId")
    @Nullable
    Object deleteBlockedUser(int i4, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM BlockedUser")
    @Nullable
    Object getAllBlockedUsers(@NotNull Continuation<? super List<BlockedUser>> continuation);

    @Query("SELECT EXISTS(SELECT * FROM BlockedUser WHERE userId == :userId)")
    @Nullable
    Object isUserBlocked(int i4, @NotNull Continuation<? super Boolean> continuation);
}
