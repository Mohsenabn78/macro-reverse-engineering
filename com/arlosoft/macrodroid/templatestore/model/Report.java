package com.arlosoft.macrodroid.templatestore.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Report.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class Report {
    public static final int $stable = 0;
    private final int id;
    private final int macroId;
    private final int reasonCode;
    @NotNull
    private final String reasonText;
    private final int userId;

    public Report(int i4, int i5, int i6, int i7, @NotNull String reasonText) {
        Intrinsics.checkNotNullParameter(reasonText, "reasonText");
        this.id = i4;
        this.userId = i5;
        this.macroId = i6;
        this.reasonCode = i7;
        this.reasonText = reasonText;
    }

    public static /* synthetic */ Report copy$default(Report report, int i4, int i5, int i6, int i7, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = report.id;
        }
        if ((i8 & 2) != 0) {
            i5 = report.userId;
        }
        int i9 = i5;
        if ((i8 & 4) != 0) {
            i6 = report.macroId;
        }
        int i10 = i6;
        if ((i8 & 8) != 0) {
            i7 = report.reasonCode;
        }
        int i11 = i7;
        if ((i8 & 16) != 0) {
            str = report.reasonText;
        }
        return report.copy(i4, i9, i10, i11, str);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.userId;
    }

    public final int component3() {
        return this.macroId;
    }

    public final int component4() {
        return this.reasonCode;
    }

    @NotNull
    public final String component5() {
        return this.reasonText;
    }

    @NotNull
    public final Report copy(int i4, int i5, int i6, int i7, @NotNull String reasonText) {
        Intrinsics.checkNotNullParameter(reasonText, "reasonText");
        return new Report(i4, i5, i6, i7, reasonText);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Report)) {
            return false;
        }
        Report report = (Report) obj;
        if (this.id == report.id && this.userId == report.userId && this.macroId == report.macroId && this.reasonCode == report.reasonCode && Intrinsics.areEqual(this.reasonText, report.reasonText)) {
            return true;
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final int getMacroId() {
        return this.macroId;
    }

    public final int getReasonCode() {
        return this.reasonCode;
    }

    @NotNull
    public final String getReasonText() {
        return this.reasonText;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.userId) * 31) + this.macroId) * 31) + this.reasonCode) * 31) + this.reasonText.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.id;
        int i5 = this.userId;
        int i6 = this.macroId;
        int i7 = this.reasonCode;
        String str = this.reasonText;
        return "Report(id=" + i4 + ", userId=" + i5 + ", macroId=" + i6 + ", reasonCode=" + i7 + ", reasonText=" + str + ")";
    }
}
