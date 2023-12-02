package com.arlosoft.macrodroid.actionblock.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes.dex */
public final class ActionBlockData implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<ActionBlockData> CREATOR = new Creator();
    private final long actionBlockGuid;
    @NotNull
    private final String actionBlockName;
    @NotNull
    private final HashMap<String, String> inputVarsMap;
    @NotNull
    private final HashMap<String, String> outputVarsMap;

    /* compiled from: ActionBlockData.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ActionBlockData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ActionBlockData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            HashMap hashMap = new HashMap(readInt);
            for (int i4 = 0; i4 != readInt; i4++) {
                hashMap.put(parcel.readString(), parcel.readString());
            }
            int readInt2 = parcel.readInt();
            HashMap hashMap2 = new HashMap(readInt2);
            for (int i5 = 0; i5 != readInt2; i5++) {
                hashMap2.put(parcel.readString(), parcel.readString());
            }
            return new ActionBlockData(readString, readLong, hashMap, hashMap2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ActionBlockData[] newArray(int i4) {
            return new ActionBlockData[i4];
        }
    }

    public ActionBlockData(@NotNull String actionBlockName, long j4, @NotNull HashMap<String, String> inputVarsMap, @NotNull HashMap<String, String> outputVarsMap) {
        Intrinsics.checkNotNullParameter(actionBlockName, "actionBlockName");
        Intrinsics.checkNotNullParameter(inputVarsMap, "inputVarsMap");
        Intrinsics.checkNotNullParameter(outputVarsMap, "outputVarsMap");
        this.actionBlockName = actionBlockName;
        this.actionBlockGuid = j4;
        this.inputVarsMap = inputVarsMap;
        this.outputVarsMap = outputVarsMap;
    }

    public static /* synthetic */ ActionBlockData copy$default(ActionBlockData actionBlockData, String str, long j4, HashMap hashMap, HashMap hashMap2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = actionBlockData.actionBlockName;
        }
        if ((i4 & 2) != 0) {
            j4 = actionBlockData.actionBlockGuid;
        }
        long j5 = j4;
        HashMap<String, String> hashMap3 = hashMap;
        if ((i4 & 4) != 0) {
            hashMap3 = actionBlockData.inputVarsMap;
        }
        HashMap hashMap4 = hashMap3;
        HashMap<String, String> hashMap5 = hashMap2;
        if ((i4 & 8) != 0) {
            hashMap5 = actionBlockData.outputVarsMap;
        }
        return actionBlockData.copy(str, j5, hashMap4, hashMap5);
    }

    @NotNull
    public final String component1() {
        return this.actionBlockName;
    }

    public final long component2() {
        return this.actionBlockGuid;
    }

    @NotNull
    public final HashMap<String, String> component3() {
        return this.inputVarsMap;
    }

    @NotNull
    public final HashMap<String, String> component4() {
        return this.outputVarsMap;
    }

    @NotNull
    public final ActionBlockData copy(@NotNull String actionBlockName, long j4, @NotNull HashMap<String, String> inputVarsMap, @NotNull HashMap<String, String> outputVarsMap) {
        Intrinsics.checkNotNullParameter(actionBlockName, "actionBlockName");
        Intrinsics.checkNotNullParameter(inputVarsMap, "inputVarsMap");
        Intrinsics.checkNotNullParameter(outputVarsMap, "outputVarsMap");
        return new ActionBlockData(actionBlockName, j4, inputVarsMap, outputVarsMap);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionBlockData)) {
            return false;
        }
        ActionBlockData actionBlockData = (ActionBlockData) obj;
        if (Intrinsics.areEqual(this.actionBlockName, actionBlockData.actionBlockName) && this.actionBlockGuid == actionBlockData.actionBlockGuid && Intrinsics.areEqual(this.inputVarsMap, actionBlockData.inputVarsMap) && Intrinsics.areEqual(this.outputVarsMap, actionBlockData.outputVarsMap)) {
            return true;
        }
        return false;
    }

    public final long getActionBlockGuid() {
        return this.actionBlockGuid;
    }

    @NotNull
    public final String getActionBlockName() {
        return this.actionBlockName;
    }

    @NotNull
    public final HashMap<String, String> getInputVarsMap() {
        return this.inputVarsMap;
    }

    @NotNull
    public final HashMap<String, String> getOutputVarsMap() {
        return this.outputVarsMap;
    }

    public int hashCode() {
        return (((((this.actionBlockName.hashCode() * 31) + androidx.compose.animation.a.a(this.actionBlockGuid)) * 31) + this.inputVarsMap.hashCode()) * 31) + this.outputVarsMap.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.actionBlockName;
        long j4 = this.actionBlockGuid;
        HashMap<String, String> hashMap = this.inputVarsMap;
        HashMap<String, String> hashMap2 = this.outputVarsMap;
        return "ActionBlockData(actionBlockName=" + str + ", actionBlockGuid=" + j4 + ", inputVarsMap=" + hashMap + ", outputVarsMap=" + hashMap2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.actionBlockName);
        out.writeLong(this.actionBlockGuid);
        HashMap<String, String> hashMap = this.inputVarsMap;
        out.writeInt(hashMap.size());
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            out.writeString(entry.getKey());
            out.writeString(entry.getValue());
        }
        HashMap<String, String> hashMap2 = this.outputVarsMap;
        out.writeInt(hashMap2.size());
        for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
            out.writeString(entry2.getKey());
            out.writeString(entry2.getValue());
        }
    }

    public /* synthetic */ ActionBlockData(String str, long j4, HashMap hashMap, HashMap hashMap2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j4, (i4 & 4) != 0 ? new HashMap() : hashMap, (i4 & 8) != 0 ? new HashMap() : hashMap2);
    }
}
