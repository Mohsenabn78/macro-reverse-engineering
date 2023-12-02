package com.arlosoft.macrodroid.database.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroSubscriptionDao.kt */
@Dao
/* loaded from: classes3.dex */
public interface MacroSubscriptionDao {
    @Insert(onConflict = 1)
    @Nullable
    Object addMacroSubscription(@NotNull MacroSubscription macroSubscription, @NotNull Continuation<? super Long> continuation);

    @Query("DELETE FROM MacroSubscription")
    @Nullable
    Object clearAll(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM MacroSubscription WHERE macroId == :macroId")
    @Nullable
    Object deleteMacroSubscription(int i4, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM MacroSubscription")
    @Nullable
    Object getAllMacroSubscriptions(@NotNull Continuation<? super List<MacroSubscription>> continuation);

    @Query("SELECT * FROM MacroSubscription WHERE macroId == :macroId")
    @Nullable
    Object getSubscriptionByMacroId(int i4, @NotNull Continuation<? super MacroSubscription> continuation);
}
