package com.arlosoft.macrodroid.action.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityServiceKt;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotificationActionButton.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes2.dex */
public final class NotificationActionButton implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<NotificationActionButton> CREATOR = new Creator();
    @SerializedName(alternate = {"d"}, value = "actionBlockData")
    @Nullable
    private ActionBlockData actionBlockData;
    @SerializedName(alternate = {CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT}, value = "clearOnPress")
    private final boolean clearOnPress;
    @SerializedName(alternate = {"a"}, value = Constants.ScionAnalytics.PARAM_LABEL)
    @NotNull
    private String label;
    @SerializedName(alternate = {"b"}, value = UIInteractionAccessibilityServiceKt.EXTRA_MACRO_GUID)
    private long macroGuid;

    /* compiled from: NotificationActionButton.kt */
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<NotificationActionButton> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationActionButton createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NotificationActionButton(parcel.readString(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : ActionBlockData.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationActionButton[] newArray(int i4) {
            return new NotificationActionButton[i4];
        }
    }

    public NotificationActionButton(@NotNull String label, long j4, boolean z3, @Nullable ActionBlockData actionBlockData) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.macroGuid = j4;
        this.clearOnPress = z3;
        this.actionBlockData = actionBlockData;
    }

    public static /* synthetic */ NotificationActionButton copy$default(NotificationActionButton notificationActionButton, String str, long j4, boolean z3, ActionBlockData actionBlockData, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = notificationActionButton.label;
        }
        if ((i4 & 2) != 0) {
            j4 = notificationActionButton.macroGuid;
        }
        long j5 = j4;
        if ((i4 & 4) != 0) {
            z3 = notificationActionButton.clearOnPress;
        }
        boolean z4 = z3;
        if ((i4 & 8) != 0) {
            actionBlockData = notificationActionButton.actionBlockData;
        }
        return notificationActionButton.copy(str, j5, z4, actionBlockData);
    }

    @NotNull
    public final String component1() {
        return this.label;
    }

    public final long component2() {
        return this.macroGuid;
    }

    public final boolean component3() {
        return this.clearOnPress;
    }

    @Nullable
    public final ActionBlockData component4() {
        return this.actionBlockData;
    }

    @NotNull
    public final NotificationActionButton copy(@NotNull String label, long j4, boolean z3, @Nullable ActionBlockData actionBlockData) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new NotificationActionButton(label, j4, z3, actionBlockData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationActionButton)) {
            return false;
        }
        NotificationActionButton notificationActionButton = (NotificationActionButton) obj;
        if (Intrinsics.areEqual(this.label, notificationActionButton.label) && this.macroGuid == notificationActionButton.macroGuid && this.clearOnPress == notificationActionButton.clearOnPress && Intrinsics.areEqual(this.actionBlockData, notificationActionButton.actionBlockData)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final ActionBlockData getActionBlockData() {
        return this.actionBlockData;
    }

    public final boolean getClearOnPress() {
        return this.clearOnPress;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public final long getMacroGuid() {
        return this.macroGuid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.label.hashCode() * 31) + a.a(this.macroGuid)) * 31;
        boolean z3 = this.clearOnPress;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (hashCode2 + i4) * 31;
        ActionBlockData actionBlockData = this.actionBlockData;
        if (actionBlockData == null) {
            hashCode = 0;
        } else {
            hashCode = actionBlockData.hashCode();
        }
        return i5 + hashCode;
    }

    public final void setActionBlockData(@Nullable ActionBlockData actionBlockData) {
        this.actionBlockData = actionBlockData;
    }

    public final void setLabel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.label = str;
    }

    public final void setMacroGuid(long j4) {
        this.macroGuid = j4;
    }

    @NotNull
    public String toString() {
        String str = this.label;
        long j4 = this.macroGuid;
        boolean z3 = this.clearOnPress;
        ActionBlockData actionBlockData = this.actionBlockData;
        return "NotificationActionButton(label=" + str + ", macroGuid=" + j4 + ", clearOnPress=" + z3 + ", actionBlockData=" + actionBlockData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.label);
        out.writeLong(this.macroGuid);
        out.writeInt(this.clearOnPress ? 1 : 0);
        ActionBlockData actionBlockData = this.actionBlockData;
        if (actionBlockData == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        actionBlockData.writeToParcel(out, i4);
    }

    public /* synthetic */ NotificationActionButton(String str, long j4, boolean z3, ActionBlockData actionBlockData, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j4, z3, (i4 & 8) != 0 ? null : actionBlockData);
    }
}
