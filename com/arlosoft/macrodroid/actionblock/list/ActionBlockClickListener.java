package com.arlosoft.macrodroid.actionblock.list;

import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.macro.Macro;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActionBlockAdapter.kt */
/* loaded from: classes.dex */
public interface ActionBlockClickListener {
    void onActionBlockClicked(@NotNull ActionBlock actionBlock);

    void onActionBlockLongClicked(@NotNull ActionBlock actionBlock);

    void onActionBlockNavigateToClicked(@NotNull Macro macro);
}
