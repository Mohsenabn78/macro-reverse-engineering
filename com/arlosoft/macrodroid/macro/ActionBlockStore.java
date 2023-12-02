package com.arlosoft.macrodroid.macro;

import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockStore.kt */
/* loaded from: classes3.dex */
public interface ActionBlockStore {
    void addActionBlock(@NotNull ActionBlock actionBlock);

    void clearActionBlocksBeingImported();

    void deleteActionBlock(@NotNull ActionBlock actionBlock);

    void deleteAllActionBlocks();

    @Nullable
    ActionBlock getActionBlockByGuid(long j4);

    @Nullable
    ActionBlock getActionBlockByName(@NotNull String str);

    @NotNull
    List<ActionBlock> getActionBlocksBeingImported();

    @NotNull
    List<ActionBlock> getAllActionBlocks();

    @NotNull
    List<ActionBlock> getAllActionBlocksSorted();

    void updateActionBlock(@NotNull ActionBlock actionBlock);
}
