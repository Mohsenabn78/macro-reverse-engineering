package com.arlosoft.macrodroid.events;

import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes3.dex */
public class MacroEnabledStateChangeEvent {
    public final boolean enable;
    public final Macro macro;

    public MacroEnabledStateChangeEvent(Macro macro, boolean z3) {
        this.macro = macro;
        this.enable = z3;
    }
}
