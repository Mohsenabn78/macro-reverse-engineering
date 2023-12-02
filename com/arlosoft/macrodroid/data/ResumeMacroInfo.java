package com.arlosoft.macrodroid.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResumeMacroInfo.kt */
@StabilityInferred(parameters = 0)
@Parcelize
/* loaded from: classes3.dex */
public final class ResumeMacroInfo implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<ResumeMacroInfo> CREATOR = new Creator();

    /* renamed from: a  reason: collision with root package name */
    private final long f10712a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10713b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final TriggerContextInfo f10714c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10715d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Stack<Integer> f10716e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final ResumeMacroInfo f10717f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f10718g;

    /* compiled from: ResumeMacroInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ResumeMacroInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ResumeMacroInfo createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            TriggerContextInfo triggerContextInfo = (TriggerContextInfo) parcel.readParcelable(ResumeMacroInfo.class.getClassLoader());
            boolean z3 = parcel.readInt() != 0;
            Stack stack = (Stack) parcel.readSerializable();
            ResumeMacroInfo createFromParcel = parcel.readInt() == 0 ? null : ResumeMacroInfo.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt2);
                for (int i4 = 0; i4 != readInt2; i4++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            return new ResumeMacroInfo(readLong, readInt, triggerContextInfo, z3, stack, createFromParcel, linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ResumeMacroInfo[] newArray(int i4) {
            return new ResumeMacroInfo[i4];
        }
    }

    public ResumeMacroInfo(long j4, int i4, @Nullable TriggerContextInfo triggerContextInfo, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        this.f10712a = j4;
        this.f10713b = i4;
        this.f10714c = triggerContextInfo;
        this.f10715d = z3;
        this.f10716e = skipEndifIndexStack;
        this.f10717f = resumeMacroInfo;
        this.f10718g = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResumeMacroInfo copy$default(ResumeMacroInfo resumeMacroInfo, long j4, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo2, Map map, int i5, Object obj) {
        long j5;
        int i6;
        TriggerContextInfo triggerContextInfo2;
        boolean z4;
        Stack<Integer> stack2;
        ResumeMacroInfo resumeMacroInfo3;
        Map<String, String> map2;
        if ((i5 & 1) != 0) {
            j5 = resumeMacroInfo.f10712a;
        } else {
            j5 = j4;
        }
        if ((i5 & 2) != 0) {
            i6 = resumeMacroInfo.f10713b;
        } else {
            i6 = i4;
        }
        if ((i5 & 4) != 0) {
            triggerContextInfo2 = resumeMacroInfo.f10714c;
        } else {
            triggerContextInfo2 = triggerContextInfo;
        }
        if ((i5 & 8) != 0) {
            z4 = resumeMacroInfo.f10715d;
        } else {
            z4 = z3;
        }
        if ((i5 & 16) != 0) {
            stack2 = resumeMacroInfo.f10716e;
        } else {
            stack2 = stack;
        }
        if ((i5 & 32) != 0) {
            resumeMacroInfo3 = resumeMacroInfo.f10717f;
        } else {
            resumeMacroInfo3 = resumeMacroInfo2;
        }
        if ((i5 & 64) != 0) {
            map2 = resumeMacroInfo.f10718g;
        } else {
            map2 = map;
        }
        return resumeMacroInfo.copy(j5, i6, triggerContextInfo2, z4, stack2, resumeMacroInfo3, map2);
    }

    public final long component1() {
        return this.f10712a;
    }

    public final int component2() {
        return this.f10713b;
    }

    @Nullable
    public final TriggerContextInfo component3() {
        return this.f10714c;
    }

    public final boolean component4() {
        return this.f10715d;
    }

    @NotNull
    public final Stack<Integer> component5() {
        return this.f10716e;
    }

    @Nullable
    public final ResumeMacroInfo component6() {
        return this.f10717f;
    }

    @Nullable
    public final Map<String, String> component7() {
        return this.f10718g;
    }

    @NotNull
    public final ResumeMacroInfo copy(long j4, int i4, @Nullable TriggerContextInfo triggerContextInfo, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        return new ResumeMacroInfo(j4, i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo, map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResumeMacroInfo)) {
            return false;
        }
        ResumeMacroInfo resumeMacroInfo = (ResumeMacroInfo) obj;
        if (this.f10712a == resumeMacroInfo.f10712a && this.f10713b == resumeMacroInfo.f10713b && Intrinsics.areEqual(this.f10714c, resumeMacroInfo.f10714c) && this.f10715d == resumeMacroInfo.f10715d && Intrinsics.areEqual(this.f10716e, resumeMacroInfo.f10716e) && Intrinsics.areEqual(this.f10717f, resumeMacroInfo.f10717f) && Intrinsics.areEqual(this.f10718g, resumeMacroInfo.f10718g)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Map<String, String> getActionBlockOutputParameters() {
        return this.f10718g;
    }

    @Nullable
    public final TriggerContextInfo getContextInfo() {
        return this.f10714c;
    }

    public final boolean getForceEvenIfNotEnabled() {
        return this.f10715d;
    }

    public final long getMacroGuid() {
        return this.f10712a;
    }

    @Nullable
    public final ResumeMacroInfo getNestedResumeMacroInfo() {
        return this.f10717f;
    }

    public final int getNextAction() {
        return this.f10713b;
    }

    @NotNull
    public final Stack<Integer> getSkipEndifIndexStack() {
        return this.f10716e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int a4 = ((a.a(this.f10712a) * 31) + this.f10713b) * 31;
        TriggerContextInfo triggerContextInfo = this.f10714c;
        int i4 = 0;
        if (triggerContextInfo == null) {
            hashCode = 0;
        } else {
            hashCode = triggerContextInfo.hashCode();
        }
        int i5 = (a4 + hashCode) * 31;
        boolean z3 = this.f10715d;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int hashCode3 = (((i5 + i6) * 31) + this.f10716e.hashCode()) * 31;
        ResumeMacroInfo resumeMacroInfo = this.f10717f;
        if (resumeMacroInfo == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = resumeMacroInfo.hashCode();
        }
        int i7 = (hashCode3 + hashCode2) * 31;
        Map<String, String> map = this.f10718g;
        if (map != null) {
            i4 = map.hashCode();
        }
        return i7 + i4;
    }

    @NotNull
    public String toString() {
        long j4 = this.f10712a;
        int i4 = this.f10713b;
        TriggerContextInfo triggerContextInfo = this.f10714c;
        boolean z3 = this.f10715d;
        Stack<Integer> stack = this.f10716e;
        ResumeMacroInfo resumeMacroInfo = this.f10717f;
        Map<String, String> map = this.f10718g;
        return "ResumeMacroInfo(macroGuid=" + j4 + ", nextAction=" + i4 + ", contextInfo=" + triggerContextInfo + ", forceEvenIfNotEnabled=" + z3 + ", skipEndifIndexStack=" + stack + ", nestedResumeMacroInfo=" + resumeMacroInfo + ", actionBlockOutputParameters=" + map + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f10712a);
        out.writeInt(this.f10713b);
        out.writeParcelable(this.f10714c, i4);
        out.writeInt(this.f10715d ? 1 : 0);
        out.writeSerializable(this.f10716e);
        ResumeMacroInfo resumeMacroInfo = this.f10717f;
        if (resumeMacroInfo == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            resumeMacroInfo.writeToParcel(out, i4);
        }
        Map<String, String> map = this.f10718g;
        if (map == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeString(entry.getValue());
        }
    }

    public /* synthetic */ ResumeMacroInfo(long j4, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo, Map map, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j4, i4, triggerContextInfo, z3, stack, resumeMacroInfo, (i5 & 64) != 0 ? null : map);
    }
}
