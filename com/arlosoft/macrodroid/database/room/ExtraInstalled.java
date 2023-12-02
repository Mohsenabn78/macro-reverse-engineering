package com.arlosoft.macrodroid.database.room;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraInstalled.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Entity(tableName = ExtraInstalled.TABLE_NAME)
/* loaded from: classes3.dex */
public final class ExtraInstalled {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TABLE_NAME = "ExtraInstalled";
    @PrimaryKey
    @NotNull
    private final String id;
    private final int versionCode;
    @NotNull
    private final String versionString;

    /* compiled from: ExtraInstalled.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ExtraInstalled(@NotNull String id, @NotNull String versionString, int i4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(versionString, "versionString");
        this.id = id;
        this.versionString = versionString;
        this.versionCode = i4;
    }

    public static /* synthetic */ ExtraInstalled copy$default(ExtraInstalled extraInstalled, String str, String str2, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = extraInstalled.id;
        }
        if ((i5 & 2) != 0) {
            str2 = extraInstalled.versionString;
        }
        if ((i5 & 4) != 0) {
            i4 = extraInstalled.versionCode;
        }
        return extraInstalled.copy(str, str2, i4);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.versionString;
    }

    public final int component3() {
        return this.versionCode;
    }

    @NotNull
    public final ExtraInstalled copy(@NotNull String id, @NotNull String versionString, int i4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(versionString, "versionString");
        return new ExtraInstalled(id, versionString, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraInstalled)) {
            return false;
        }
        ExtraInstalled extraInstalled = (ExtraInstalled) obj;
        if (Intrinsics.areEqual(this.id, extraInstalled.id) && Intrinsics.areEqual(this.versionString, extraInstalled.versionString) && this.versionCode == extraInstalled.versionCode) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionString() {
        return this.versionString;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.versionString.hashCode()) * 31) + this.versionCode;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        String str2 = this.versionString;
        int i4 = this.versionCode;
        return "ExtraInstalled(id=" + str + ", versionString=" + str2 + ", versionCode=" + i4 + ")";
    }
}
