package com.arlosoft.macrodroid.homescreen.quickrun;

import com.arlosoft.macrodroid.macro.Macro;
import org.jetbrains.annotations.NotNull;

/* compiled from: QuickRunMacroAdapter.kt */
/* loaded from: classes3.dex */
public interface MacroSelectionListener {
    void onMacroDeleted(@NotNull Macro macro);

    void onMacroSelected(@NotNull Macro macro);
}
