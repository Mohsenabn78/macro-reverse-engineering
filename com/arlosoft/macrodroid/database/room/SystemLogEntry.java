package com.arlosoft.macrodroid.database.room;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemLogEntry.kt */
@StabilityInferred(parameters = 0)
@Parcelize
@Entity(tableName = SystemLogEntry.TABLE_NAME)
/* loaded from: classes3.dex */
public final class SystemLogEntry implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final String TABLE_NAME = "SystemLogEntry";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final LogLevel f10875a;

    /* renamed from: b  reason: collision with root package name */
    private final long f10876b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f10877c;

    /* renamed from: d  reason: collision with root package name */
    private final long f10878d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f10879e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f10880f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f10881g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final LogFlag f10882h;
    @PrimaryKey(autoGenerate = true)

    /* renamed from: i  reason: collision with root package name */
    private final long f10883i;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Parcelable.Creator<SystemLogEntry> CREATOR = new Creator();

    /* compiled from: SystemLogEntry.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SystemLogEntry.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<SystemLogEntry> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemLogEntry createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SystemLogEntry(LogLevel.valueOf(parcel.readString()), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), LogFlag.valueOf(parcel.readString()), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemLogEntry[] newArray(int i4) {
            return new SystemLogEntry[i4];
        }
    }

    public SystemLogEntry(@NotNull LogLevel logLevel, long j4, @NotNull String logText, long j5, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull LogFlag flag, long j6) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(logText, "logText");
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.f10875a = logLevel;
        this.f10876b = j4;
        this.f10877c = logText;
        this.f10878d = j5;
        this.f10879e = str;
        this.f10880f = str2;
        this.f10881g = str3;
        this.f10882h = flag;
        this.f10883i = j6;
    }

    public static /* synthetic */ SystemLogEntry copy$default(SystemLogEntry systemLogEntry, LogLevel logLevel, long j4, String str, long j5, String str2, String str3, String str4, LogFlag logFlag, long j6, int i4, Object obj) {
        LogLevel logLevel2;
        long j7;
        String str5;
        long j8;
        String str6;
        String str7;
        String str8;
        LogFlag logFlag2;
        long j9;
        if ((i4 & 1) != 0) {
            logLevel2 = systemLogEntry.f10875a;
        } else {
            logLevel2 = logLevel;
        }
        if ((i4 & 2) != 0) {
            j7 = systemLogEntry.f10876b;
        } else {
            j7 = j4;
        }
        if ((i4 & 4) != 0) {
            str5 = systemLogEntry.f10877c;
        } else {
            str5 = str;
        }
        if ((i4 & 8) != 0) {
            j8 = systemLogEntry.f10878d;
        } else {
            j8 = j5;
        }
        if ((i4 & 16) != 0) {
            str6 = systemLogEntry.f10879e;
        } else {
            str6 = str2;
        }
        if ((i4 & 32) != 0) {
            str7 = systemLogEntry.f10880f;
        } else {
            str7 = str3;
        }
        if ((i4 & 64) != 0) {
            str8 = systemLogEntry.f10881g;
        } else {
            str8 = str4;
        }
        if ((i4 & 128) != 0) {
            logFlag2 = systemLogEntry.f10882h;
        } else {
            logFlag2 = logFlag;
        }
        if ((i4 & 256) != 0) {
            j9 = systemLogEntry.f10883i;
        } else {
            j9 = j6;
        }
        return systemLogEntry.copy(logLevel2, j7, str5, j8, str6, str7, str8, logFlag2, j9);
    }

    @NotNull
    public final LogLevel component1() {
        return this.f10875a;
    }

    public final long component2() {
        return this.f10876b;
    }

    @NotNull
    public final String component3() {
        return this.f10877c;
    }

    public final long component4() {
        return this.f10878d;
    }

    @Nullable
    public final String component5() {
        return this.f10879e;
    }

    @Nullable
    public final String component6() {
        return this.f10880f;
    }

    @Nullable
    public final String component7() {
        return this.f10881g;
    }

    @NotNull
    public final LogFlag component8() {
        return this.f10882h;
    }

    public final long component9() {
        return this.f10883i;
    }

    @NotNull
    public final SystemLogEntry copy(@NotNull LogLevel logLevel, long j4, @NotNull String logText, long j5, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull LogFlag flag, long j6) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(logText, "logText");
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new SystemLogEntry(logLevel, j4, logText, j5, str, str2, str3, flag, j6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemLogEntry)) {
            return false;
        }
        SystemLogEntry systemLogEntry = (SystemLogEntry) obj;
        if (this.f10875a == systemLogEntry.f10875a && this.f10876b == systemLogEntry.f10876b && Intrinsics.areEqual(this.f10877c, systemLogEntry.f10877c) && this.f10878d == systemLogEntry.f10878d && Intrinsics.areEqual(this.f10879e, systemLogEntry.f10879e) && Intrinsics.areEqual(this.f10880f, systemLogEntry.f10880f) && Intrinsics.areEqual(this.f10881g, systemLogEntry.f10881g) && this.f10882h == systemLogEntry.f10882h && this.f10883i == systemLogEntry.f10883i) {
            return true;
        }
        return false;
    }

    @NotNull
    public final LogFlag getFlag() {
        return this.f10882h;
    }

    @Nullable
    public final String getGeofenceId() {
        return this.f10880f;
    }

    public final long getId() {
        return this.f10883i;
    }

    @NotNull
    public final LogLevel getLogLevel() {
        return this.f10875a;
    }

    @NotNull
    public final String getLogText() {
        return this.f10877c;
    }

    public final long getMacroId() {
        return this.f10878d;
    }

    public final long getTimeStamp() {
        return this.f10876b;
    }

    @Nullable
    public final String getVariableName() {
        return this.f10879e;
    }

    @Nullable
    public final String getWebLink() {
        return this.f10881g;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((((this.f10875a.hashCode() * 31) + androidx.compose.animation.a.a(this.f10876b)) * 31) + this.f10877c.hashCode()) * 31) + androidx.compose.animation.a.a(this.f10878d)) * 31;
        String str = this.f10879e;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode3 + hashCode) * 31;
        String str2 = this.f10880f;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.f10881g;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return ((((i6 + i4) * 31) + this.f10882h.hashCode()) * 31) + androidx.compose.animation.a.a(this.f10883i);
    }

    @NotNull
    public String toString() {
        LogLevel logLevel = this.f10875a;
        long j4 = this.f10876b;
        String str = this.f10877c;
        long j5 = this.f10878d;
        String str2 = this.f10879e;
        String str3 = this.f10880f;
        String str4 = this.f10881g;
        LogFlag logFlag = this.f10882h;
        long j6 = this.f10883i;
        return "SystemLogEntry(logLevel=" + logLevel + ", timeStamp=" + j4 + ", logText=" + str + ", macroId=" + j5 + ", variableName=" + str2 + ", geofenceId=" + str3 + ", webLink=" + str4 + ", flag=" + logFlag + ", id=" + j6 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f10875a.name());
        out.writeLong(this.f10876b);
        out.writeString(this.f10877c);
        out.writeLong(this.f10878d);
        out.writeString(this.f10879e);
        out.writeString(this.f10880f);
        out.writeString(this.f10881g);
        out.writeString(this.f10882h.name());
        out.writeLong(this.f10883i);
    }

    public /* synthetic */ SystemLogEntry(LogLevel logLevel, long j4, String str, long j5, String str2, String str3, String str4, LogFlag logFlag, long j6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(logLevel, j4, str, j5, (i4 & 16) != 0 ? null : str2, (i4 & 32) != 0 ? null : str3, (i4 & 64) != 0 ? null : str4, (i4 & 128) != 0 ? LogFlag.NONE : logFlag, (i4 & 256) != 0 ? 0L : j6);
    }
}
