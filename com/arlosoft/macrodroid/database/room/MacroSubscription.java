package com.arlosoft.macrodroid.database.room;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroSubscription.kt */
@StabilityInferred(parameters = 0)
@Entity(tableName = MacroSubscription.TABLE_NAME)
/* loaded from: classes3.dex */
public final class MacroSubscription {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TABLE_NAME = "MacroSubscription";
    @PrimaryKey

    /* renamed from: a  reason: collision with root package name */
    private final int f10832a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f10833b;

    /* compiled from: MacroSubscription.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MacroSubscription(int i4, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        this.f10832a = i4;
        this.f10833b = macroName;
    }

    public static /* synthetic */ MacroSubscription copy$default(MacroSubscription macroSubscription, int i4, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = macroSubscription.f10832a;
        }
        if ((i5 & 2) != 0) {
            str = macroSubscription.f10833b;
        }
        return macroSubscription.copy(i4, str);
    }

    public final int component1() {
        return this.f10832a;
    }

    @NotNull
    public final String component2() {
        return this.f10833b;
    }

    @NotNull
    public final MacroSubscription copy(int i4, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        return new MacroSubscription(i4, macroName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MacroSubscription)) {
            return false;
        }
        MacroSubscription macroSubscription = (MacroSubscription) obj;
        if (this.f10832a == macroSubscription.f10832a && Intrinsics.areEqual(this.f10833b, macroSubscription.f10833b)) {
            return true;
        }
        return false;
    }

    public final int getMacroId() {
        return this.f10832a;
    }

    @NotNull
    public final String getMacroName() {
        return this.f10833b;
    }

    public int hashCode() {
        return (this.f10832a * 31) + this.f10833b.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.f10832a;
        String str = this.f10833b;
        return "MacroSubscription(macroId=" + i4 + ", macroName=" + str + ")";
    }
}
