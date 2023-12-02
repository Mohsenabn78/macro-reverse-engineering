package com.arlosoft.macrodroid.variables;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableWithTypeSpinnerAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class VariableOrOption {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f16292a;

    /* compiled from: VariableWithTypeSpinnerAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Option extends VariableOrOption {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f16293b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16294c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Option(@NotNull String option, int i4) {
            super(option, null);
            Intrinsics.checkNotNullParameter(option, "option");
            this.f16293b = option;
            this.f16294c = i4;
        }

        public static /* synthetic */ Option copy$default(Option option, String str, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = option.f16293b;
            }
            if ((i5 & 2) != 0) {
                i4 = option.f16294c;
            }
            return option.copy(str, i4);
        }

        @NotNull
        public final String component1() {
            return this.f16293b;
        }

        public final int component2() {
            return this.f16294c;
        }

        @NotNull
        public final Option copy(@NotNull String option, int i4) {
            Intrinsics.checkNotNullParameter(option, "option");
            return new Option(option, i4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Option)) {
                return false;
            }
            Option option = (Option) obj;
            if (Intrinsics.areEqual(this.f16293b, option.f16293b) && this.f16294c == option.f16294c) {
                return true;
            }
            return false;
        }

        public final int getIndex() {
            return this.f16294c;
        }

        @NotNull
        public final String getOption() {
            return this.f16293b;
        }

        public int hashCode() {
            return (this.f16293b.hashCode() * 31) + this.f16294c;
        }

        @NotNull
        public String toString() {
            String str = this.f16293b;
            int i4 = this.f16294c;
            return "Option(option=" + str + ", index=" + i4 + ")";
        }
    }

    /* compiled from: VariableWithTypeSpinnerAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Variable extends VariableOrOption {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final MacroDroidVariable f16295b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final String f16296c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Variable(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.common.MacroDroidVariable r3, @org.jetbrains.annotations.NotNull java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "variable"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "suffixText"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = r3.getName()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                r1.append(r4)
                java.lang.String r0 = r1.toString()
                r1 = 0
                r2.<init>(r0, r1)
                r2.f16295b = r3
                r2.f16296c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableOrOption.Variable.<init>(com.arlosoft.macrodroid.common.MacroDroidVariable, java.lang.String):void");
        }

        public static /* synthetic */ Variable copy$default(Variable variable, MacroDroidVariable macroDroidVariable, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                macroDroidVariable = variable.f16295b;
            }
            if ((i4 & 2) != 0) {
                str = variable.f16296c;
            }
            return variable.copy(macroDroidVariable, str);
        }

        @NotNull
        public final MacroDroidVariable component1() {
            return this.f16295b;
        }

        @NotNull
        public final String component2() {
            return this.f16296c;
        }

        @NotNull
        public final Variable copy(@NotNull MacroDroidVariable variable, @NotNull String suffixText) {
            Intrinsics.checkNotNullParameter(variable, "variable");
            Intrinsics.checkNotNullParameter(suffixText, "suffixText");
            return new Variable(variable, suffixText);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Variable)) {
                return false;
            }
            Variable variable = (Variable) obj;
            if (Intrinsics.areEqual(this.f16295b, variable.f16295b) && Intrinsics.areEqual(this.f16296c, variable.f16296c)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getSuffixText() {
            return this.f16296c;
        }

        @NotNull
        public final MacroDroidVariable getVariable() {
            return this.f16295b;
        }

        public int hashCode() {
            return (this.f16295b.hashCode() * 31) + this.f16296c.hashCode();
        }

        @NotNull
        public String toString() {
            MacroDroidVariable macroDroidVariable = this.f16295b;
            String str = this.f16296c;
            return "Variable(variable=" + macroDroidVariable + ", suffixText=" + str + ")";
        }

        public /* synthetic */ Variable(MacroDroidVariable macroDroidVariable, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(macroDroidVariable, (i4 & 2) != 0 ? "" : str);
        }
    }

    public /* synthetic */ VariableOrOption(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @NotNull
    public final String getLabel() {
        return this.f16292a;
    }

    private VariableOrOption(String str) {
        this.f16292a = str;
    }
}
