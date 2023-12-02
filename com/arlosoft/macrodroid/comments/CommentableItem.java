package com.arlosoft.macrodroid.comments;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: CommentableItem.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public class CommentableItem implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<CommentableItem> CREATOR = new Creator();
    @NotNull
    private final String commenterName;

    /* compiled from: CommentableItem.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<CommentableItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommentableItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommentableItem(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommentableItem[] newArray(int i4) {
            return new CommentableItem[i4];
        }
    }

    public CommentableItem(@NotNull String commenterName) {
        Intrinsics.checkNotNullParameter(commenterName, "commenterName");
        this.commenterName = commenterName;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getCommenterName() {
        return this.commenterName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.commenterName);
    }
}
