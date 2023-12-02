package com.arlosoft.macrodroid.database.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BlockedMacroDao.kt */
@Dao
/* loaded from: classes3.dex */
public interface BlockedMacroDao {
    @Insert(onConflict = 1)
    @Nullable
    Object addBlockedMacro(@NotNull BlockedMacro blockedMacro, @NotNull Continuation<? super Long> continuation);

    @Query("DELETE FROM BlockedMacro")
    @Nullable
    Object clearAll(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM BlockedMacro WHERE macroId == :macroId")
    @Nullable
    Object deleteBlockedMacro(int i4, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM BlockedMacro")
    @Nullable
    Object getAllBlockedMacro(@NotNull Continuation<? super List<BlockedMacro>> continuation);
}
