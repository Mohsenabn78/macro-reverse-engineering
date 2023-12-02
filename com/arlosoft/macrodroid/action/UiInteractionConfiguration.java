package com.arlosoft.macrodroid.action;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIInteractionAction.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes2.dex */
public abstract class UiInteractionConfiguration implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    private final String type;

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class ClearSelection extends UiInteractionConfiguration {
        public static final int $stable = 0;
        @NotNull
        public static final ClearSelection INSTANCE = new ClearSelection();
        @NotNull
        public static final Parcelable.Creator<ClearSelection> CREATOR = new Creator();

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<ClearSelection> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ClearSelection createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return ClearSelection.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ClearSelection[] newArray(int i4) {
                return new ClearSelection[i4];
            }
        }

        private ClearSelection() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    @SourceDebugExtension({"SMAP\nUIInteractionAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UiInteractionConfiguration$Click\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2410:1\n1#2:2411\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class Click extends UiInteractionConfiguration {
        public static final int TEXT_MATCH_ANY = 0;
        public static final int TEXT_MATCH_EXACT = 1;
        private final boolean blocking;
        private final boolean checkOverlays;
        private final int clickOption;
        @Nullable
        private final String contentDescription;
        private final boolean longClick;
        @Nullable
        private final VariableWithDictionaryKeys returnVariable;
        @Nullable
        private final String textContent;
        private final int textMatchOption;
        @Nullable
        private final String viewId;
        @Nullable
        private final String xVarName;
        private final boolean xyPercentages;
        @Nullable
        private final Point xyPoint;
        @Nullable
        private final String yVarName;
        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator<Click> CREATOR = new Creator();

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Click> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Click createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Click(parcel.readInt(), parcel.readInt() != 0, (Point) parcel.readParcelable(Click.class.getClassLoader()), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : VariableWithDictionaryKeys.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Click[] newArray(int i4) {
                return new Click[i4];
            }
        }

        public /* synthetic */ Click(int i4, boolean z3, Point point, boolean z4, String str, String str2, String str3, int i5, String str4, String str5, boolean z5, VariableWithDictionaryKeys variableWithDictionaryKeys, boolean z6, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(i4, z3, point, z4, str, str2, str3, (i6 & 128) != 0 ? 0 : i5, str4, str5, z5, variableWithDictionaryKeys, (i6 & 4096) != 0 ? false : z6);
        }

        public final int component1() {
            return this.clickOption;
        }

        @Nullable
        public final String component10() {
            return this.viewId;
        }

        public final boolean component11() {
            return this.blocking;
        }

        @Nullable
        public final VariableWithDictionaryKeys component12() {
            return this.returnVariable;
        }

        public final boolean component13() {
            return this.checkOverlays;
        }

        public final boolean component2() {
            return this.longClick;
        }

        @Nullable
        public final Point component3() {
            return this.xyPoint;
        }

        public final boolean component4() {
            return this.xyPercentages;
        }

        @Nullable
        public final String component5() {
            return this.xVarName;
        }

        @Nullable
        public final String component6() {
            return this.yVarName;
        }

        @Nullable
        public final String component7() {
            return this.textContent;
        }

        public final int component8() {
            return this.textMatchOption;
        }

        @Nullable
        public final String component9() {
            return this.contentDescription;
        }

        @NotNull
        public final Click copy(int i4, boolean z3, @Nullable Point point, boolean z4, @Nullable String str, @Nullable String str2, @Nullable String str3, int i5, @Nullable String str4, @Nullable String str5, boolean z5, @Nullable VariableWithDictionaryKeys variableWithDictionaryKeys, boolean z6) {
            return new Click(i4, z3, point, z4, str, str2, str3, i5, str4, str5, z5, variableWithDictionaryKeys, z6);
        }

        @Override // com.arlosoft.macrodroid.action.UiInteractionConfiguration
        @NotNull
        public String describe() {
            Integer num;
            String str = this.viewId;
            String str2 = this.contentDescription;
            String str3 = this.textContent;
            Point point = this.xyPoint;
            Integer num2 = null;
            if (point != null) {
                num = Integer.valueOf(point.x);
            } else {
                num = null;
            }
            Point point2 = this.xyPoint;
            if (point2 != null) {
                num2 = Integer.valueOf(point2.y);
            }
            return "id: " + str + "\n\ncontentDescription: " + str2 + "\n\ntext: " + str3 + "\n\nx,y: " + num + ", " + num2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Click)) {
                return false;
            }
            Click click = (Click) obj;
            if (this.clickOption == click.clickOption && this.longClick == click.longClick && Intrinsics.areEqual(this.xyPoint, click.xyPoint) && this.xyPercentages == click.xyPercentages && Intrinsics.areEqual(this.xVarName, click.xVarName) && Intrinsics.areEqual(this.yVarName, click.yVarName) && Intrinsics.areEqual(this.textContent, click.textContent) && this.textMatchOption == click.textMatchOption && Intrinsics.areEqual(this.contentDescription, click.contentDescription) && Intrinsics.areEqual(this.viewId, click.viewId) && this.blocking == click.blocking && Intrinsics.areEqual(this.returnVariable, click.returnVariable) && this.checkOverlays == click.checkOverlays) {
                return true;
            }
            return false;
        }

        public final boolean getBlocking() {
            return this.blocking;
        }

        public final boolean getCheckOverlays() {
            return this.checkOverlays;
        }

        public final int getClickOption() {
            return this.clickOption;
        }

        @Nullable
        public final String getContentDescription() {
            return this.contentDescription;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
            if (r0 == null) goto L27;
         */
        @Override // com.arlosoft.macrodroid.action.UiInteractionConfiguration
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String getExtendedDetail(@org.jetbrains.annotations.NotNull android.content.res.Resources r8) {
            /*
                Method dump skipped, instructions count: 255
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click.getExtendedDetail(android.content.res.Resources):java.lang.String");
        }

        public final boolean getLongClick() {
            return this.longClick;
        }

        @Nullable
        public final VariableWithDictionaryKeys getReturnVariable() {
            return this.returnVariable;
        }

        @Nullable
        public final String getTextContent() {
            return this.textContent;
        }

        public final int getTextMatchOption() {
            return this.textMatchOption;
        }

        @Nullable
        public final String getViewId() {
            return this.viewId;
        }

        @Nullable
        public final String getXVarName() {
            return this.xVarName;
        }

        public final boolean getXyPercentages() {
            return this.xyPercentages;
        }

        @Nullable
        public final Point getXyPoint() {
            return this.xyPoint;
        }

        @Nullable
        public final String getYVarName() {
            return this.yVarName;
        }

        @Override // com.arlosoft.macrodroid.action.UiInteractionConfiguration
        public boolean handlesOwnAsync() {
            return this.blocking;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int i4 = this.clickOption * 31;
            boolean z3 = this.longClick;
            int i5 = 1;
            int i6 = z3;
            if (z3 != 0) {
                i6 = 1;
            }
            int i7 = (i4 + i6) * 31;
            Point point = this.xyPoint;
            int i8 = 0;
            if (point == null) {
                hashCode = 0;
            } else {
                hashCode = point.hashCode();
            }
            int i9 = (i7 + hashCode) * 31;
            boolean z4 = this.xyPercentages;
            int i10 = z4;
            if (z4 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            String str = this.xVarName;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i12 = (i11 + hashCode2) * 31;
            String str2 = this.yVarName;
            if (str2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str2.hashCode();
            }
            int i13 = (i12 + hashCode3) * 31;
            String str3 = this.textContent;
            if (str3 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str3.hashCode();
            }
            int i14 = (((i13 + hashCode4) * 31) + this.textMatchOption) * 31;
            String str4 = this.contentDescription;
            if (str4 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str4.hashCode();
            }
            int i15 = (i14 + hashCode5) * 31;
            String str5 = this.viewId;
            if (str5 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str5.hashCode();
            }
            int i16 = (i15 + hashCode6) * 31;
            boolean z5 = this.blocking;
            int i17 = z5;
            if (z5 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            VariableWithDictionaryKeys variableWithDictionaryKeys = this.returnVariable;
            if (variableWithDictionaryKeys != null) {
                i8 = variableWithDictionaryKeys.hashCode();
            }
            int i19 = (i18 + i8) * 31;
            boolean z6 = this.checkOverlays;
            if (!z6) {
                i5 = z6 ? 1 : 0;
            }
            return i19 + i5;
        }

        @NotNull
        public String toString() {
            int i4 = this.clickOption;
            boolean z3 = this.longClick;
            Point point = this.xyPoint;
            boolean z4 = this.xyPercentages;
            String str = this.xVarName;
            String str2 = this.yVarName;
            String str3 = this.textContent;
            int i5 = this.textMatchOption;
            String str4 = this.contentDescription;
            String str5 = this.viewId;
            boolean z5 = this.blocking;
            VariableWithDictionaryKeys variableWithDictionaryKeys = this.returnVariable;
            boolean z6 = this.checkOverlays;
            return "Click(clickOption=" + i4 + ", longClick=" + z3 + ", xyPoint=" + point + ", xyPercentages=" + z4 + ", xVarName=" + str + ", yVarName=" + str2 + ", textContent=" + str3 + ", textMatchOption=" + i5 + ", contentDescription=" + str4 + ", viewId=" + str5 + ", blocking=" + z5 + ", returnVariable=" + variableWithDictionaryKeys + ", checkOverlays=" + z6 + ")";
        }

        @NotNull
        public final Click withTextAndViewId(@NotNull String newText, @NotNull String newViewId) {
            Intrinsics.checkNotNullParameter(newText, "newText");
            Intrinsics.checkNotNullParameter(newViewId, "newViewId");
            return new Click(this.clickOption, this.longClick, this.xyPoint, this.xyPercentages, this.xVarName, this.yVarName, newText, this.textMatchOption, this.contentDescription, newViewId, this.blocking, this.returnVariable, this.checkOverlays);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.clickOption);
            out.writeInt(this.longClick ? 1 : 0);
            out.writeParcelable(this.xyPoint, i4);
            out.writeInt(this.xyPercentages ? 1 : 0);
            out.writeString(this.xVarName);
            out.writeString(this.yVarName);
            out.writeString(this.textContent);
            out.writeInt(this.textMatchOption);
            out.writeString(this.contentDescription);
            out.writeString(this.viewId);
            out.writeInt(this.blocking ? 1 : 0);
            VariableWithDictionaryKeys variableWithDictionaryKeys = this.returnVariable;
            if (variableWithDictionaryKeys == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                variableWithDictionaryKeys.writeToParcel(out, i4);
            }
            out.writeInt(this.checkOverlays ? 1 : 0);
        }

        public Click(int i4, boolean z3, @Nullable Point point, boolean z4, @Nullable String str, @Nullable String str2, @Nullable String str3, int i5, @Nullable String str4, @Nullable String str5, boolean z5, @Nullable VariableWithDictionaryKeys variableWithDictionaryKeys, boolean z6) {
            super(null);
            this.clickOption = i4;
            this.longClick = z3;
            this.xyPoint = point;
            this.xyPercentages = z4;
            this.xVarName = str;
            this.yVarName = str2;
            this.textContent = str3;
            this.textMatchOption = i5;
            this.contentDescription = str4;
            this.viewId = str5;
            this.blocking = z5;
            this.returnVariable = variableWithDictionaryKeys;
            this.checkOverlays = z6;
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class Copy extends UiInteractionConfiguration {
        public static final int $stable = 0;
        @NotNull
        public static final Copy INSTANCE = new Copy();
        @NotNull
        public static final Parcelable.Creator<Copy> CREATOR = new Creator();

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Copy> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Copy createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Copy.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Copy[] newArray(int i4) {
                return new Copy[i4];
            }
        }

        private Copy() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class Cut extends UiInteractionConfiguration {
        public static final int $stable = 0;
        @NotNull
        public static final Cut INSTANCE = new Cut();
        @NotNull
        public static final Parcelable.Creator<Cut> CREATOR = new Creator();

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Cut> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Cut createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Cut.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Cut[] newArray(int i4) {
                return new Cut[i4];
            }
        }

        private Cut() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class Gesture extends UiInteractionConfiguration {
        public static final int $stable = 0;
        @NotNull
        public static final Parcelable.Creator<Gesture> CREATOR = new Creator();
        private final int durationMs;
        @Nullable
        private final String durationVarName;
        private final int endX;
        private final int endY;
        private final int startX;
        private final int startY;
        private final boolean waitBeforeNext;
        @Nullable
        private final String xEndVarName;
        @Nullable
        private final String xStartVarName;
        private final boolean xyPercentages;
        @Nullable
        private final String yEndVarName;
        @Nullable
        private final String yStartVarName;

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Gesture> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Gesture createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Gesture(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Gesture[] newArray(int i4) {
                return new Gesture[i4];
            }
        }

        public Gesture(int i4, int i5, int i6, int i7, boolean z3, int i8, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z4) {
            super(null);
            this.startX = i4;
            this.startY = i5;
            this.endX = i6;
            this.endY = i7;
            this.xyPercentages = z3;
            this.durationMs = i8;
            this.xStartVarName = str;
            this.yStartVarName = str2;
            this.xEndVarName = str3;
            this.yEndVarName = str4;
            this.durationVarName = str5;
            this.waitBeforeNext = z4;
        }

        public static /* synthetic */ Gesture copy$default(Gesture gesture, int i4, int i5, int i6, int i7, boolean z3, int i8, String str, String str2, String str3, String str4, String str5, boolean z4, int i9, Object obj) {
            int i10;
            int i11;
            int i12;
            int i13;
            boolean z5;
            int i14;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            boolean z6;
            if ((i9 & 1) != 0) {
                i10 = gesture.startX;
            } else {
                i10 = i4;
            }
            if ((i9 & 2) != 0) {
                i11 = gesture.startY;
            } else {
                i11 = i5;
            }
            if ((i9 & 4) != 0) {
                i12 = gesture.endX;
            } else {
                i12 = i6;
            }
            if ((i9 & 8) != 0) {
                i13 = gesture.endY;
            } else {
                i13 = i7;
            }
            if ((i9 & 16) != 0) {
                z5 = gesture.xyPercentages;
            } else {
                z5 = z3;
            }
            if ((i9 & 32) != 0) {
                i14 = gesture.durationMs;
            } else {
                i14 = i8;
            }
            if ((i9 & 64) != 0) {
                str6 = gesture.xStartVarName;
            } else {
                str6 = str;
            }
            if ((i9 & 128) != 0) {
                str7 = gesture.yStartVarName;
            } else {
                str7 = str2;
            }
            if ((i9 & 256) != 0) {
                str8 = gesture.xEndVarName;
            } else {
                str8 = str3;
            }
            if ((i9 & 512) != 0) {
                str9 = gesture.yEndVarName;
            } else {
                str9 = str4;
            }
            if ((i9 & 1024) != 0) {
                str10 = gesture.durationVarName;
            } else {
                str10 = str5;
            }
            if ((i9 & 2048) != 0) {
                z6 = gesture.waitBeforeNext;
            } else {
                z6 = z4;
            }
            return gesture.copy(i10, i11, i12, i13, z5, i14, str6, str7, str8, str9, str10, z6);
        }

        public final int component1() {
            return this.startX;
        }

        @Nullable
        public final String component10() {
            return this.yEndVarName;
        }

        @Nullable
        public final String component11() {
            return this.durationVarName;
        }

        public final boolean component12() {
            return this.waitBeforeNext;
        }

        public final int component2() {
            return this.startY;
        }

        public final int component3() {
            return this.endX;
        }

        public final int component4() {
            return this.endY;
        }

        public final boolean component5() {
            return this.xyPercentages;
        }

        public final int component6() {
            return this.durationMs;
        }

        @Nullable
        public final String component7() {
            return this.xStartVarName;
        }

        @Nullable
        public final String component8() {
            return this.yStartVarName;
        }

        @Nullable
        public final String component9() {
            return this.xEndVarName;
        }

        @NotNull
        public final Gesture copy(int i4, int i5, int i6, int i7, boolean z3, int i8, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z4) {
            return new Gesture(i4, i5, i6, i7, z3, i8, str, str2, str3, str4, str5, z4);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Gesture)) {
                return false;
            }
            Gesture gesture = (Gesture) obj;
            if (this.startX == gesture.startX && this.startY == gesture.startY && this.endX == gesture.endX && this.endY == gesture.endY && this.xyPercentages == gesture.xyPercentages && this.durationMs == gesture.durationMs && Intrinsics.areEqual(this.xStartVarName, gesture.xStartVarName) && Intrinsics.areEqual(this.yStartVarName, gesture.yStartVarName) && Intrinsics.areEqual(this.xEndVarName, gesture.xEndVarName) && Intrinsics.areEqual(this.yEndVarName, gesture.yEndVarName) && Intrinsics.areEqual(this.durationVarName, gesture.durationVarName) && this.waitBeforeNext == gesture.waitBeforeNext) {
                return true;
            }
            return false;
        }

        public final int getDurationMs() {
            return this.durationMs;
        }

        @Nullable
        public final String getDurationVarName() {
            return this.durationVarName;
        }

        public final int getEndX() {
            return this.endX;
        }

        public final int getEndY() {
            return this.endY;
        }

        @Override // com.arlosoft.macrodroid.action.UiInteractionConfiguration
        @NotNull
        public String getExtendedDetail(@NotNull Resources res) {
            String str;
            Intrinsics.checkNotNullParameter(res, "res");
            if (this.xyPercentages) {
                str = "%";
            } else {
                str = "";
            }
            Object obj = this.durationVarName;
            if (obj == null) {
                obj = Integer.valueOf(this.durationMs);
            }
            String string = res.getString(R.string.milliseconds_capital);
            Object obj2 = this.xStartVarName;
            if (obj2 == null) {
                obj2 = Integer.valueOf(this.startX);
            }
            Object obj3 = this.yStartVarName;
            if (obj3 == null) {
                obj3 = Integer.valueOf(this.startY);
            }
            Object obj4 = this.xEndVarName;
            if (obj4 == null) {
                obj4 = Integer.valueOf(this.endX);
            }
            Object obj5 = this.yEndVarName;
            if (obj5 == null) {
                obj5 = Integer.valueOf(this.endY);
            }
            return obj + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + string + ": " + obj2 + str + "," + obj3 + str + " -> " + obj4 + str + "," + obj5 + str;
        }

        public final int getStartX() {
            return this.startX;
        }

        public final int getStartY() {
            return this.startY;
        }

        public final boolean getWaitBeforeNext() {
            return this.waitBeforeNext;
        }

        @Nullable
        public final String getXEndVarName() {
            return this.xEndVarName;
        }

        @Nullable
        public final String getXStartVarName() {
            return this.xStartVarName;
        }

        public final boolean getXyPercentages() {
            return this.xyPercentages;
        }

        @Nullable
        public final String getYEndVarName() {
            return this.yEndVarName;
        }

        @Nullable
        public final String getYStartVarName() {
            return this.yStartVarName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int i4 = ((((((this.startX * 31) + this.startY) * 31) + this.endX) * 31) + this.endY) * 31;
            boolean z3 = this.xyPercentages;
            int i5 = 1;
            int i6 = z3;
            if (z3 != 0) {
                i6 = 1;
            }
            int i7 = (((i4 + i6) * 31) + this.durationMs) * 31;
            String str = this.xStartVarName;
            int i8 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i9 = (i7 + hashCode) * 31;
            String str2 = this.yStartVarName;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i10 = (i9 + hashCode2) * 31;
            String str3 = this.xEndVarName;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i11 = (i10 + hashCode3) * 31;
            String str4 = this.yEndVarName;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i12 = (i11 + hashCode4) * 31;
            String str5 = this.durationVarName;
            if (str5 != null) {
                i8 = str5.hashCode();
            }
            int i13 = (i12 + i8) * 31;
            boolean z4 = this.waitBeforeNext;
            if (!z4) {
                i5 = z4 ? 1 : 0;
            }
            return i13 + i5;
        }

        @NotNull
        public String toString() {
            int i4 = this.startX;
            int i5 = this.startY;
            int i6 = this.endX;
            int i7 = this.endY;
            boolean z3 = this.xyPercentages;
            int i8 = this.durationMs;
            String str = this.xStartVarName;
            String str2 = this.yStartVarName;
            String str3 = this.xEndVarName;
            String str4 = this.yEndVarName;
            String str5 = this.durationVarName;
            boolean z4 = this.waitBeforeNext;
            return "Gesture(startX=" + i4 + ", startY=" + i5 + ", endX=" + i6 + ", endY=" + i7 + ", xyPercentages=" + z3 + ", durationMs=" + i8 + ", xStartVarName=" + str + ", yStartVarName=" + str2 + ", xEndVarName=" + str3 + ", yEndVarName=" + str4 + ", durationVarName=" + str5 + ", waitBeforeNext=" + z4 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.startX);
            out.writeInt(this.startY);
            out.writeInt(this.endX);
            out.writeInt(this.endY);
            out.writeInt(this.xyPercentages ? 1 : 0);
            out.writeInt(this.durationMs);
            out.writeString(this.xStartVarName);
            out.writeString(this.yStartVarName);
            out.writeString(this.xEndVarName);
            out.writeString(this.yEndVarName);
            out.writeString(this.durationVarName);
            out.writeInt(this.waitBeforeNext ? 1 : 0);
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class GestureEntry implements Parcelable {
        public static final int $stable = 0;
        @NotNull
        public static final Parcelable.Creator<GestureEntry> CREATOR = new Creator();
        private final int endX;
        private final int endY;
        @Nullable
        private final String xEndVarName;
        @Nullable
        private final String yEndVarName;

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<GestureEntry> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final GestureEntry createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GestureEntry(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final GestureEntry[] newArray(int i4) {
                return new GestureEntry[i4];
            }
        }

        public GestureEntry(int i4, int i5, @Nullable String str, @Nullable String str2) {
            this.endX = i4;
            this.endY = i5;
            this.xEndVarName = str;
            this.yEndVarName = str2;
        }

        public static /* synthetic */ GestureEntry copy$default(GestureEntry gestureEntry, int i4, int i5, String str, String str2, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4 = gestureEntry.endX;
            }
            if ((i6 & 2) != 0) {
                i5 = gestureEntry.endY;
            }
            if ((i6 & 4) != 0) {
                str = gestureEntry.xEndVarName;
            }
            if ((i6 & 8) != 0) {
                str2 = gestureEntry.yEndVarName;
            }
            return gestureEntry.copy(i4, i5, str, str2);
        }

        public final int component1() {
            return this.endX;
        }

        public final int component2() {
            return this.endY;
        }

        @Nullable
        public final String component3() {
            return this.xEndVarName;
        }

        @Nullable
        public final String component4() {
            return this.yEndVarName;
        }

        @NotNull
        public final GestureEntry copy(int i4, int i5, @Nullable String str, @Nullable String str2) {
            return new GestureEntry(i4, i5, str, str2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GestureEntry)) {
                return false;
            }
            GestureEntry gestureEntry = (GestureEntry) obj;
            if (this.endX == gestureEntry.endX && this.endY == gestureEntry.endY && Intrinsics.areEqual(this.xEndVarName, gestureEntry.xEndVarName) && Intrinsics.areEqual(this.yEndVarName, gestureEntry.yEndVarName)) {
                return true;
            }
            return false;
        }

        public final int getEndX() {
            return this.endX;
        }

        public final int getEndY() {
            return this.endY;
        }

        @Nullable
        public final String getXEndVarName() {
            return this.xEndVarName;
        }

        @Nullable
        public final String getYEndVarName() {
            return this.yEndVarName;
        }

        public int hashCode() {
            int hashCode;
            int i4 = ((this.endX * 31) + this.endY) * 31;
            String str = this.xEndVarName;
            int i5 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i6 = (i4 + hashCode) * 31;
            String str2 = this.yEndVarName;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            return i6 + i5;
        }

        @NotNull
        public String toString() {
            int i4 = this.endX;
            int i5 = this.endY;
            String str = this.xEndVarName;
            String str2 = this.yEndVarName;
            return "GestureEntry(endX=" + i4 + ", endY=" + i5 + ", xEndVarName=" + str + ", yEndVarName=" + str2 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.endX);
            out.writeInt(this.endY);
            out.writeString(this.xEndVarName);
            out.writeString(this.yEndVarName);
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class GestureSequence extends UiInteractionConfiguration {
        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator<GestureSequence> CREATOR = new Creator();
        private final int durationMs;
        @Nullable
        private final String durationVarName;
        @NotNull
        private final List<GestureEntry> gestures;
        private final int startX;
        private final int startY;
        private final boolean waitBeforeNext;
        @Nullable
        private final String xStartVarName;
        private final boolean xyPercentages;
        @Nullable
        private final String yStartVarName;

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<GestureSequence> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final GestureSequence createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                boolean z3 = parcel.readInt() != 0;
                int readInt3 = parcel.readInt();
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                boolean z4 = parcel.readInt() != 0;
                int readInt4 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt4);
                for (int i4 = 0; i4 != readInt4; i4++) {
                    arrayList.add(GestureEntry.CREATOR.createFromParcel(parcel));
                }
                return new GestureSequence(readInt, readInt2, z3, readInt3, readString, readString2, readString3, z4, arrayList);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final GestureSequence[] newArray(int i4) {
                return new GestureSequence[i4];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GestureSequence(int i4, int i5, boolean z3, int i6, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z4, @NotNull List<GestureEntry> gestures) {
            super(null);
            Intrinsics.checkNotNullParameter(gestures, "gestures");
            this.startX = i4;
            this.startY = i5;
            this.xyPercentages = z3;
            this.durationMs = i6;
            this.xStartVarName = str;
            this.yStartVarName = str2;
            this.durationVarName = str3;
            this.waitBeforeNext = z4;
            this.gestures = gestures;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GestureSequence copy$default(GestureSequence gestureSequence, int i4, int i5, boolean z3, int i6, String str, String str2, String str3, boolean z4, List list, int i7, Object obj) {
            int i8;
            int i9;
            boolean z5;
            int i10;
            String str4;
            String str5;
            String str6;
            boolean z6;
            List<GestureEntry> list2;
            if ((i7 & 1) != 0) {
                i8 = gestureSequence.startX;
            } else {
                i8 = i4;
            }
            if ((i7 & 2) != 0) {
                i9 = gestureSequence.startY;
            } else {
                i9 = i5;
            }
            if ((i7 & 4) != 0) {
                z5 = gestureSequence.xyPercentages;
            } else {
                z5 = z3;
            }
            if ((i7 & 8) != 0) {
                i10 = gestureSequence.durationMs;
            } else {
                i10 = i6;
            }
            if ((i7 & 16) != 0) {
                str4 = gestureSequence.xStartVarName;
            } else {
                str4 = str;
            }
            if ((i7 & 32) != 0) {
                str5 = gestureSequence.yStartVarName;
            } else {
                str5 = str2;
            }
            if ((i7 & 64) != 0) {
                str6 = gestureSequence.durationVarName;
            } else {
                str6 = str3;
            }
            if ((i7 & 128) != 0) {
                z6 = gestureSequence.waitBeforeNext;
            } else {
                z6 = z4;
            }
            if ((i7 & 256) != 0) {
                list2 = gestureSequence.gestures;
            } else {
                list2 = list;
            }
            return gestureSequence.copy(i8, i9, z5, i10, str4, str5, str6, z6, list2);
        }

        public final int component1() {
            return this.startX;
        }

        public final int component2() {
            return this.startY;
        }

        public final boolean component3() {
            return this.xyPercentages;
        }

        public final int component4() {
            return this.durationMs;
        }

        @Nullable
        public final String component5() {
            return this.xStartVarName;
        }

        @Nullable
        public final String component6() {
            return this.yStartVarName;
        }

        @Nullable
        public final String component7() {
            return this.durationVarName;
        }

        public final boolean component8() {
            return this.waitBeforeNext;
        }

        @NotNull
        public final List<GestureEntry> component9() {
            return this.gestures;
        }

        @NotNull
        public final GestureSequence copy(int i4, int i5, boolean z3, int i6, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z4, @NotNull List<GestureEntry> gestures) {
            Intrinsics.checkNotNullParameter(gestures, "gestures");
            return new GestureSequence(i4, i5, z3, i6, str, str2, str3, z4, gestures);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GestureSequence)) {
                return false;
            }
            GestureSequence gestureSequence = (GestureSequence) obj;
            if (this.startX == gestureSequence.startX && this.startY == gestureSequence.startY && this.xyPercentages == gestureSequence.xyPercentages && this.durationMs == gestureSequence.durationMs && Intrinsics.areEqual(this.xStartVarName, gestureSequence.xStartVarName) && Intrinsics.areEqual(this.yStartVarName, gestureSequence.yStartVarName) && Intrinsics.areEqual(this.durationVarName, gestureSequence.durationVarName) && this.waitBeforeNext == gestureSequence.waitBeforeNext && Intrinsics.areEqual(this.gestures, gestureSequence.gestures)) {
                return true;
            }
            return false;
        }

        public final int getDurationMs() {
            return this.durationMs;
        }

        @Nullable
        public final String getDurationVarName() {
            return this.durationVarName;
        }

        @Override // com.arlosoft.macrodroid.action.UiInteractionConfiguration
        @NotNull
        public String getExtendedDetail(@NotNull Resources res) {
            Intrinsics.checkNotNullParameter(res, "res");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = res.getString(R.string.ui_interaction_gesture_sequence_number_of_swipes);
            Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.u…equence_number_of_swipes)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.gestures.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }

        @NotNull
        public final List<GestureEntry> getGestures() {
            return this.gestures;
        }

        public final int getStartX() {
            return this.startX;
        }

        public final int getStartY() {
            return this.startY;
        }

        public final boolean getWaitBeforeNext() {
            return this.waitBeforeNext;
        }

        @Nullable
        public final String getXStartVarName() {
            return this.xStartVarName;
        }

        public final boolean getXyPercentages() {
            return this.xyPercentages;
        }

        @Nullable
        public final String getYStartVarName() {
            return this.yStartVarName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i4 = ((this.startX * 31) + this.startY) * 31;
            boolean z3 = this.xyPercentages;
            int i5 = 1;
            int i6 = z3;
            if (z3 != 0) {
                i6 = 1;
            }
            int i7 = (((i4 + i6) * 31) + this.durationMs) * 31;
            String str = this.xStartVarName;
            int i8 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i9 = (i7 + hashCode) * 31;
            String str2 = this.yStartVarName;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i10 = (i9 + hashCode2) * 31;
            String str3 = this.durationVarName;
            if (str3 != null) {
                i8 = str3.hashCode();
            }
            int i11 = (i10 + i8) * 31;
            boolean z4 = this.waitBeforeNext;
            if (!z4) {
                i5 = z4 ? 1 : 0;
            }
            return ((i11 + i5) * 31) + this.gestures.hashCode();
        }

        @NotNull
        public String toString() {
            int i4 = this.startX;
            int i5 = this.startY;
            boolean z3 = this.xyPercentages;
            int i6 = this.durationMs;
            String str = this.xStartVarName;
            String str2 = this.yStartVarName;
            String str3 = this.durationVarName;
            boolean z4 = this.waitBeforeNext;
            List<GestureEntry> list = this.gestures;
            return "GestureSequence(startX=" + i4 + ", startY=" + i5 + ", xyPercentages=" + z3 + ", durationMs=" + i6 + ", xStartVarName=" + str + ", yStartVarName=" + str2 + ", durationVarName=" + str3 + ", waitBeforeNext=" + z4 + ", gestures=" + list + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.startX);
            out.writeInt(this.startY);
            out.writeInt(this.xyPercentages ? 1 : 0);
            out.writeInt(this.durationMs);
            out.writeString(this.xStartVarName);
            out.writeString(this.yStartVarName);
            out.writeString(this.durationVarName);
            out.writeInt(this.waitBeforeNext ? 1 : 0);
            List<GestureEntry> list = this.gestures;
            out.writeInt(list.size());
            for (GestureEntry gestureEntry : list) {
                gestureEntry.writeToParcel(out, i4);
            }
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class Paste extends UiInteractionConfiguration {
        public static final int $stable = 0;
        @NotNull
        public static final Parcelable.Creator<Paste> CREATOR = new Creator();
        private final boolean forceClear;
        @NotNull
        private final String text;
        private final boolean useClipboard;

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Paste> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Paste createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Paste(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Paste[] newArray(int i4) {
                return new Paste[i4];
            }
        }

        public /* synthetic */ Paste(boolean z3, boolean z4, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(z3, z4, (i4 & 4) != 0 ? "" : str);
        }

        public static /* synthetic */ Paste copy$default(Paste paste, boolean z3, boolean z4, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z3 = paste.useClipboard;
            }
            if ((i4 & 2) != 0) {
                z4 = paste.forceClear;
            }
            if ((i4 & 4) != 0) {
                str = paste.text;
            }
            return paste.copy(z3, z4, str);
        }

        public final boolean component1() {
            return this.useClipboard;
        }

        public final boolean component2() {
            return this.forceClear;
        }

        @NotNull
        public final String component3() {
            return this.text;
        }

        @NotNull
        public final Paste copy(boolean z3, boolean z4, @NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Paste(z3, z4, text);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Paste)) {
                return false;
            }
            Paste paste = (Paste) obj;
            if (this.useClipboard == paste.useClipboard && this.forceClear == paste.forceClear && Intrinsics.areEqual(this.text, paste.text)) {
                return true;
            }
            return false;
        }

        @Override // com.arlosoft.macrodroid.action.UiInteractionConfiguration
        @NotNull
        public String getExtendedDetail(@NotNull Resources res) {
            Intrinsics.checkNotNullParameter(res, "res");
            if (this.useClipboard) {
                String string = res.getString(R.string.clipboard_text);
                Intrinsics.checkNotNullExpressionValue(string, "{\n                res.ge…board_text)\n            }");
                return string;
            }
            return this.text;
        }

        public final boolean getForceClear() {
            return this.forceClear;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public final boolean getUseClipboard() {
            return this.useClipboard;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z3 = this.useClipboard;
            int i4 = 1;
            ?? r02 = z3;
            if (z3) {
                r02 = 1;
            }
            int i5 = r02 * 31;
            boolean z4 = this.forceClear;
            if (!z4) {
                i4 = z4 ? 1 : 0;
            }
            return ((i5 + i4) * 31) + this.text.hashCode();
        }

        @NotNull
        public String toString() {
            boolean z3 = this.useClipboard;
            boolean z4 = this.forceClear;
            String str = this.text;
            return "Paste(useClipboard=" + z3 + ", forceClear=" + z4 + ", text=" + str + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.useClipboard ? 1 : 0);
            out.writeInt(this.forceClear ? 1 : 0);
            out.writeString(this.text);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paste(boolean z3, boolean z4, @NotNull String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.useClipboard = z3;
            this.forceClear = z4;
            this.text = text;
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class PressBack extends UiInteractionConfiguration {
        public static final int $stable = 0;
        @NotNull
        public static final PressBack INSTANCE = new PressBack();
        @NotNull
        public static final Parcelable.Creator<PressBack> CREATOR = new Creator();

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<PressBack> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PressBack createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return PressBack.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PressBack[] newArray(int i4) {
                return new PressBack[i4];
            }
        }

        private PressBack() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class PressEnter extends UiInteractionConfiguration {
        public static final int $stable = 0;
        @NotNull
        public static final PressEnter INSTANCE = new PressEnter();
        @NotNull
        public static final Parcelable.Creator<PressEnter> CREATOR = new Creator();

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<PressEnter> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PressEnter createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return PressEnter.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PressEnter[] newArray(int i4) {
                return new PressEnter[i4];
            }
        }

        private PressEnter() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    public /* synthetic */ UiInteractionConfiguration(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public String describe() {
        return "";
    }

    @NotNull
    public String getExtendedDetail(@NotNull Resources res) {
        Intrinsics.checkNotNullParameter(res, "res");
        return "";
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public boolean handlesOwnAsync() {
        return false;
    }

    private UiInteractionConfiguration() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        this.type = simpleName;
    }
}
