package com.arlosoft.macrodroid.logcat;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogcatMessage.kt */
@StabilityInferred(parameters = 0)
@Parcelize
/* loaded from: classes3.dex */
public final class LogcatMessage implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<LogcatMessage> CREATOR = new Creator();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f12637a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f12638b;

    /* compiled from: LogcatMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<LogcatMessage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LogcatMessage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LogcatMessage(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LogcatMessage[] newArray(int i4) {
            return new LogcatMessage[i4];
        }
    }

    public LogcatMessage(@NotNull String component, @NotNull String message) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(message, "message");
        this.f12637a = component;
        this.f12638b = message;
    }

    public static /* synthetic */ LogcatMessage copy$default(LogcatMessage logcatMessage, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = logcatMessage.f12637a;
        }
        if ((i4 & 2) != 0) {
            str2 = logcatMessage.f12638b;
        }
        return logcatMessage.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f12637a;
    }

    @NotNull
    public final String component2() {
        return this.f12638b;
    }

    @NotNull
    public final LogcatMessage copy(@NotNull String component, @NotNull String message) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(message, "message");
        return new LogcatMessage(component, message);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogcatMessage)) {
            return false;
        }
        LogcatMessage logcatMessage = (LogcatMessage) obj;
        if (Intrinsics.areEqual(this.f12637a, logcatMessage.f12637a) && Intrinsics.areEqual(this.f12638b, logcatMessage.f12638b)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getComponent() {
        return this.f12637a;
    }

    @NotNull
    public final String getMessage() {
        return this.f12638b;
    }

    public int hashCode() {
        return (this.f12637a.hashCode() * 31) + this.f12638b.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f12637a;
        String str2 = this.f12638b;
        return "LogcatMessage(component=" + str + ", message=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f12637a);
        out.writeString(this.f12638b);
    }
}
