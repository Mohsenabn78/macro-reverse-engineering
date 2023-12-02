package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.DarkThemeConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DarkThemeConstraint.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class DarkThemeConstraint extends Constraint {
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DarkThemeConstraint> CREATOR = new Parcelable.Creator<DarkThemeConstraint>() { // from class: com.arlosoft.macrodroid.constraint.DarkThemeConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DarkThemeConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DarkThemeConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DarkThemeConstraint[] newArray(int i4) {
            return new DarkThemeConstraint[i4];
        }
    };

    public /* synthetic */ DarkThemeConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.enabled), SelectableItem.r(R.string.disabled)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r3.option == 1) goto L8;
     */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkOK(@org.jetbrains.annotations.Nullable com.arlosoft.macrodroid.triggers.TriggerContextInfo r4) {
        /*
            r3 = this;
            android.content.Context r4 = r3.getContext()
            java.lang.String r0 = "uimode"
            java.lang.Object r4 = r4.getSystemService(r0)
            java.lang.String r0 = "null cannot be cast to non-null type android.app.UiModeManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r0)
            android.app.UiModeManager r4 = (android.app.UiModeManager) r4
            r0 = 0
            int r4 = r4.getNightMode()     // Catch: java.lang.Exception -> L25
            r1 = 2
            r2 = 1
            if (r4 != r1) goto L1f
            int r4 = r3.option     // Catch: java.lang.Exception -> L25
            if (r4 != 0) goto L47
            goto L23
        L1f:
            int r4 = r3.option     // Catch: java.lang.Exception -> L25
            if (r4 != r2) goto L47
        L23:
            r0 = 1
            goto L47
        L25:
            r4 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Device does not have ui_night_mode flag, so DarkThemeConstraint cannot work: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            java.lang.Long r1 = r3.getMacroGuid()
            java.lang.String r2 = "macroGuid"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            long r1 = r1.longValue()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r4, r1)
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.DarkThemeConstraint.checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = getOptions()[this.option];
        Intrinsics.checkNotNullExpressionValue(str, "getOptions()[option]");
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return DarkThemeConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String extendedDetail = getExtendedDetail();
        return name + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public DarkThemeConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DarkThemeConstraint() {
    }

    private DarkThemeConstraint(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: DarkThemeConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
