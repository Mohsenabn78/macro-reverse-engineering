package com.arlosoft.macrodroid.taskerplugin;

import com.arlosoft.macrodroid.common.MacroDroidVariable;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TaskerVariableHandler.kt */
/* loaded from: classes3.dex */
public interface TaskerVariableHandler {
    @Nullable
    MacroDroidVariable getVariableByName(@NotNull String str);

    @NotNull
    Map<String, String> getVariableMap();
}
