package com.arlosoft.macrodroid.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroExportData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class MacroExportData {
    public static final int $stable = 8;
    @Nullable
    private final Macro macro;
    private final int macroExportVersion;
    @Nullable
    private final List<UserIconData> userIcons;

    /* JADX WARN: Multi-variable type inference failed */
    public MacroExportData(int i4, @Nullable Macro macro, @Nullable List<? extends UserIconData> list) {
        this.macroExportVersion = i4;
        this.macro = macro;
        this.userIcons = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MacroExportData copy$default(MacroExportData macroExportData, int i4, Macro macro, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = macroExportData.macroExportVersion;
        }
        if ((i5 & 2) != 0) {
            macro = macroExportData.macro;
        }
        if ((i5 & 4) != 0) {
            list = macroExportData.userIcons;
        }
        return macroExportData.copy(i4, macro, list);
    }

    public final int component1() {
        return this.macroExportVersion;
    }

    @Nullable
    public final Macro component2() {
        return this.macro;
    }

    @Nullable
    public final List<UserIconData> component3() {
        return this.userIcons;
    }

    @NotNull
    public final MacroExportData copy(int i4, @Nullable Macro macro, @Nullable List<? extends UserIconData> list) {
        return new MacroExportData(i4, macro, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MacroExportData)) {
            return false;
        }
        MacroExportData macroExportData = (MacroExportData) obj;
        if (this.macroExportVersion == macroExportData.macroExportVersion && Intrinsics.areEqual(this.macro, macroExportData.macro) && Intrinsics.areEqual(this.userIcons, macroExportData.userIcons)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Macro getMacro() {
        return this.macro;
    }

    public final int getMacroExportVersion() {
        return this.macroExportVersion;
    }

    @Nullable
    public final List<UserIconData> getUserIcons() {
        return this.userIcons;
    }

    public int hashCode() {
        int hashCode;
        int i4 = this.macroExportVersion * 31;
        Macro macro = this.macro;
        int i5 = 0;
        if (macro == null) {
            hashCode = 0;
        } else {
            hashCode = macro.hashCode();
        }
        int i6 = (i4 + hashCode) * 31;
        List<UserIconData> list = this.userIcons;
        if (list != null) {
            i5 = list.hashCode();
        }
        return i6 + i5;
    }

    @NotNull
    public String toString() {
        int i4 = this.macroExportVersion;
        Macro macro = this.macro;
        List<UserIconData> list = this.userIcons;
        return "MacroExportData(macroExportVersion=" + i4 + ", macro=" + macro + ", userIcons=" + list + ")";
    }

    public /* synthetic */ MacroExportData(int i4, Macro macro, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, (i5 & 2) != 0 ? null : macro, (i5 & 4) != 0 ? null : list);
    }
}
