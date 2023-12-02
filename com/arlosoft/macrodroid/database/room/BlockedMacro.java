package com.arlosoft.macrodroid.database.room;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BlockedMacro.kt */
@StabilityInferred(parameters = 0)
@Entity(tableName = BlockedMacro.TABLE_NAME)
/* loaded from: classes3.dex */
public final class BlockedMacro {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TABLE_NAME = "BlockedMacro";
    @PrimaryKey

    /* renamed from: a  reason: collision with root package name */
    private final int f10774a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f10775b;

    /* compiled from: BlockedMacro.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BlockedMacro(int i4, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        this.f10774a = i4;
        this.f10775b = macroName;
    }

    public static /* synthetic */ BlockedMacro copy$default(BlockedMacro blockedMacro, int i4, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = blockedMacro.f10774a;
        }
        if ((i5 & 2) != 0) {
            str = blockedMacro.f10775b;
        }
        return blockedMacro.copy(i4, str);
    }

    public final int component1() {
        return this.f10774a;
    }

    @NotNull
    public final String component2() {
        return this.f10775b;
    }

    @NotNull
    public final BlockedMacro copy(int i4, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        return new BlockedMacro(i4, macroName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockedMacro)) {
            return false;
        }
        BlockedMacro blockedMacro = (BlockedMacro) obj;
        if (this.f10774a == blockedMacro.f10774a && Intrinsics.areEqual(this.f10775b, blockedMacro.f10775b)) {
            return true;
        }
        return false;
    }

    public final int getMacroId() {
        return this.f10774a;
    }

    @NotNull
    public final String getMacroName() {
        return this.f10775b;
    }

    public int hashCode() {
        return (this.f10774a * 31) + this.f10775b.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.f10774a;
        String str = this.f10775b;
        return "BlockedMacro(macroId=" + i4 + ", macroName=" + str + ")";
    }
}
