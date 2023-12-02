package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.UiModeManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.DarkThemeActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DarkThemeAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class DarkThemeAction extends Action {
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DarkThemeAction> CREATOR = new Parcelable.Creator<DarkThemeAction>() { // from class: com.arlosoft.macrodroid.action.DarkThemeAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DarkThemeAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DarkThemeAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DarkThemeAction[] newArray(int i4) {
            return new DarkThemeAction[i4];
        }
    };

    public /* synthetic */ DarkThemeAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void M(int i4) {
        boolean z3 = false;
        if (!RootToolsHelper.isAccessGiven()) {
            try {
                z3 = Settings.Secure.putInt(getContext().getContentResolver(), "ui_night_mode", i4);
            } catch (Exception unused) {
            }
            if (!z3) {
                Long macroGuid = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError("Could not set colour dark theme, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS", macroGuid.longValue());
                return;
            }
            return;
        }
        Util.runAsRoot(new String[]{"settings put secure ui_night_mode " + i4});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = Companion.a()[this.option];
        Intrinsics.checkNotNullExpressionValue(str, "getOptions()[option]");
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return DarkThemeActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        int i4;
        Object systemService = getContext().getSystemService("uimode");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
        UiModeManager uiModeManager = (UiModeManager) systemService;
        try {
            i4 = Settings.Secure.getInt(getContext().getContentResolver(), "ui_night_mode");
        } catch (Settings.SettingNotFoundException unused) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Could not find existing setting for ui_night_mode", macroGuid.longValue());
            i4 = 1;
        }
        for (int i5 = 1; i5 < 3; i5++) {
            uiModeManager.enableCarMode(0);
            int i6 = this.option;
            int i7 = 2;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i4 != 1) {
                        i7 = 1;
                    }
                    M(i7);
                } else {
                    M(1);
                }
            } else {
                M(2);
            }
            uiModeManager.disableCarMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public DarkThemeAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DarkThemeAction() {
    }

    private DarkThemeAction(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: DarkThemeAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            return new String[]{SelectableItem.r(R.string.enable), SelectableItem.r(R.string.disable), SelectableItem.r(R.string.toggle)};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
