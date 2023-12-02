package com.arlosoft.macrodroid.interfaces;

import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import org.jetbrains.annotations.NotNull;

/* compiled from: InvokesActionBlocksViaIntent.kt */
/* loaded from: classes3.dex */
public interface InvokesActionBlocksViaIntent {
    @NotNull
    ActionBlockData getActionBlockData(@NotNull TriggerContextInfo triggerContextInfo);
}
