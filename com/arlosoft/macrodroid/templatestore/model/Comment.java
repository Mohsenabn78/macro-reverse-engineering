package com.arlosoft.macrodroid.templatestore.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Comment.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class Comment implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<Comment> CREATOR = new Creator();
    private final long editTimestamp;
    private final int id;
    private final int macroId;
    private final boolean pending;
    private final int pluginId;
    @NotNull
    private final String text;
    private final long timestamp;
    private final int userId;
    @NotNull
    private final String userImage;
    @NotNull
    private final String username;

    /* compiled from: Comment.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<Comment> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Comment createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Comment(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Comment[] newArray(int i4) {
            return new Comment[i4];
        }
    }

    public Comment(int i4, int i5, int i6, int i7, @NotNull String text, long j4, long j5, @NotNull String username, @NotNull String userImage, boolean z3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        this.id = i4;
        this.userId = i5;
        this.macroId = i6;
        this.pluginId = i7;
        this.text = text;
        this.timestamp = j4;
        this.editTimestamp = j5;
        this.username = username;
        this.userImage = userImage;
        this.pending = z3;
    }

    public static /* synthetic */ Comment copy$default(Comment comment, int i4, int i5, int i6, int i7, String str, long j4, long j5, String str2, String str3, boolean z3, int i8, Object obj) {
        int i9;
        int i10;
        int i11;
        int i12;
        String str4;
        long j6;
        long j7;
        String str5;
        String str6;
        boolean z4;
        if ((i8 & 1) != 0) {
            i9 = comment.id;
        } else {
            i9 = i4;
        }
        if ((i8 & 2) != 0) {
            i10 = comment.userId;
        } else {
            i10 = i5;
        }
        if ((i8 & 4) != 0) {
            i11 = comment.macroId;
        } else {
            i11 = i6;
        }
        if ((i8 & 8) != 0) {
            i12 = comment.pluginId;
        } else {
            i12 = i7;
        }
        if ((i8 & 16) != 0) {
            str4 = comment.text;
        } else {
            str4 = str;
        }
        if ((i8 & 32) != 0) {
            j6 = comment.timestamp;
        } else {
            j6 = j4;
        }
        if ((i8 & 64) != 0) {
            j7 = comment.editTimestamp;
        } else {
            j7 = j5;
        }
        if ((i8 & 128) != 0) {
            str5 = comment.username;
        } else {
            str5 = str2;
        }
        if ((i8 & 256) != 0) {
            str6 = comment.userImage;
        } else {
            str6 = str3;
        }
        if ((i8 & 512) != 0) {
            z4 = comment.pending;
        } else {
            z4 = z3;
        }
        return comment.copy(i9, i10, i11, i12, str4, j6, j7, str5, str6, z4);
    }

    public final int component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.pending;
    }

    public final int component2() {
        return this.userId;
    }

    public final int component3() {
        return this.macroId;
    }

    public final int component4() {
        return this.pluginId;
    }

    @NotNull
    public final String component5() {
        return this.text;
    }

    public final long component6() {
        return this.timestamp;
    }

    public final long component7() {
        return this.editTimestamp;
    }

    @NotNull
    public final String component8() {
        return this.username;
    }

    @NotNull
    public final String component9() {
        return this.userImage;
    }

    @NotNull
    public final Comment copy(int i4, int i5, int i6, int i7, @NotNull String text, long j4, long j5, @NotNull String username, @NotNull String userImage, boolean z3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        return new Comment(i4, i5, i6, i7, text, j4, j5, username, userImage, z3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Comment)) {
            return false;
        }
        Comment comment = (Comment) obj;
        if (this.id == comment.id && this.userId == comment.userId && this.macroId == comment.macroId && this.pluginId == comment.pluginId && Intrinsics.areEqual(this.text, comment.text) && this.timestamp == comment.timestamp && this.editTimestamp == comment.editTimestamp && Intrinsics.areEqual(this.username, comment.username) && Intrinsics.areEqual(this.userImage, comment.userImage) && this.pending == comment.pending) {
            return true;
        }
        return false;
    }

    public final long getEditTimestamp() {
        return this.editTimestamp;
    }

    public final int getId() {
        return this.id;
    }

    public final int getMacroId() {
        return this.macroId;
    }

    public final boolean getPending() {
        return this.pending;
    }

    public final int getPluginId() {
        return this.pluginId;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getUserImage() {
        return this.userImage;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((this.id * 31) + this.userId) * 31) + this.macroId) * 31) + this.pluginId) * 31) + this.text.hashCode()) * 31) + a.a(this.timestamp)) * 31) + a.a(this.editTimestamp)) * 31) + this.username.hashCode()) * 31) + this.userImage.hashCode()) * 31;
        boolean z3 = this.pending;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    @NotNull
    public String toString() {
        int i4 = this.id;
        int i5 = this.userId;
        int i6 = this.macroId;
        int i7 = this.pluginId;
        String str = this.text;
        long j4 = this.timestamp;
        long j5 = this.editTimestamp;
        String str2 = this.username;
        String str3 = this.userImage;
        boolean z3 = this.pending;
        return "Comment(id=" + i4 + ", userId=" + i5 + ", macroId=" + i6 + ", pluginId=" + i7 + ", text=" + str + ", timestamp=" + j4 + ", editTimestamp=" + j5 + ", username=" + str2 + ", userImage=" + str3 + ", pending=" + z3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.id);
        out.writeInt(this.userId);
        out.writeInt(this.macroId);
        out.writeInt(this.pluginId);
        out.writeString(this.text);
        out.writeLong(this.timestamp);
        out.writeLong(this.editTimestamp);
        out.writeString(this.username);
        out.writeString(this.userImage);
        out.writeInt(this.pending ? 1 : 0);
    }
}
