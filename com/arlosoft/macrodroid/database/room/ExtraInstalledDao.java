package com.arlosoft.macrodroid.database.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraInstalledDao.kt */
@Dao
/* loaded from: classes3.dex */
public interface ExtraInstalledDao {
    @Insert(onConflict = 1)
    @Nullable
    Object addInstalledExtra(@NotNull ExtraInstalled extraInstalled, @NotNull Continuation<? super Long> continuation);

    @Query("DELETE FROM ExtraInstalled")
    @Nullable
    Object clearAll(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM ExtraInstalled WHERE id == :id")
    @Nullable
    Object deleteInstalledExtra(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM ExtraInstalled WHERE id == :id LIMIT 1")
    @Nullable
    Object getInstalledExtraById(@NotNull String str, @NotNull Continuation<? super ExtraInstalled> continuation);
}
