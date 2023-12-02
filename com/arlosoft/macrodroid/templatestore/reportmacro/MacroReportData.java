package com.arlosoft.macrodroid.templatestore.reportmacro;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportMacroViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MacroReportData {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MacroTemplate f13652a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<ReportEntry> f13653b;

    /* JADX WARN: Multi-variable type inference failed */
    public MacroReportData(@NotNull MacroTemplate macroTemplate, @NotNull List<? extends ReportEntry> entries) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.f13652a = macroTemplate;
        this.f13653b = entries;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MacroReportData copy$default(MacroReportData macroReportData, MacroTemplate macroTemplate, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            macroTemplate = macroReportData.f13652a;
        }
        if ((i4 & 2) != 0) {
            list = macroReportData.f13653b;
        }
        return macroReportData.copy(macroTemplate, list);
    }

    @NotNull
    public final MacroTemplate component1() {
        return this.f13652a;
    }

    @NotNull
    public final List<ReportEntry> component2() {
        return this.f13653b;
    }

    @NotNull
    public final MacroReportData copy(@NotNull MacroTemplate macroTemplate, @NotNull List<? extends ReportEntry> entries) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new MacroReportData(macroTemplate, entries);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MacroReportData)) {
            return false;
        }
        MacroReportData macroReportData = (MacroReportData) obj;
        if (Intrinsics.areEqual(this.f13652a, macroReportData.f13652a) && Intrinsics.areEqual(this.f13653b, macroReportData.f13653b)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<ReportEntry> getEntries() {
        return this.f13653b;
    }

    @NotNull
    public final MacroTemplate getMacroTemplate() {
        return this.f13652a;
    }

    public int hashCode() {
        return (this.f13652a.hashCode() * 31) + this.f13653b.hashCode();
    }

    @NotNull
    public String toString() {
        MacroTemplate macroTemplate = this.f13652a;
        List<ReportEntry> list = this.f13653b;
        return "MacroReportData(macroTemplate=" + macroTemplate + ", entries=" + list + ")";
    }
}
