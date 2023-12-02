package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.DisableCameraActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DisableCameraAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class DisableCameraAction extends Action {
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DisableCameraAction> CREATOR = new Parcelable.Creator<DisableCameraAction>() { // from class: com.arlosoft.macrodroid.action.DisableCameraAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DisableCameraAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DisableCameraAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DisableCameraAction[] newArray(int i4) {
            return new DisableCameraAction[i4];
        }
    };

    public /* synthetic */ DisableCameraAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
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
    @Nullable
    public String getEditModeWarning() {
        if (!isValid()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String r4 = SelectableItem.r(R.string.feature_only_available_up_to_android_version);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.featu…le_up_to_android_version)");
            String format = String.format(r4, Arrays.copyOf(new Object[]{10}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return null;
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
        return DisableCameraActionInfo.Companion.getInstance();
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
        ComponentName componentName = new ComponentName(getContext(), MacroDroidDeviceAdminReceiver.class);
        Object systemService = getContext().getSystemService("device_policy");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) systemService;
        boolean z3 = false;
        if (Build.VERSION.SDK_INT >= 29) {
            int i4 = this.option;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        HelperSystemCommands.sendEnableDisableCamera(context, 2);
                        Long macroGuid = getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid, "getMacroGuid()");
                        SystemLog.logInfo("Sending request to Helper File to toggle camera enabled state", macroGuid.longValue());
                        return;
                    }
                    return;
                }
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                HelperSystemCommands.sendEnableDisableCamera(context2, 0);
                Long macroGuid2 = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid2, "getMacroGuid()");
                SystemLog.logInfo("Sending request to Helper File to disable camera", macroGuid2.longValue());
                return;
            }
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            HelperSystemCommands.sendEnableDisableCamera(context3, 1);
            Long macroGuid3 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid3, "getMacroGuid()");
            SystemLog.logInfo("Sending request to Helper File to enable camera", macroGuid3.longValue());
            return;
        }
        try {
            int i5 = this.option;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        if (!devicePolicyManager.getCameraDisabled(componentName)) {
                            z3 = true;
                        }
                        devicePolicyManager.setCameraDisabled(componentName, z3);
                    }
                } else {
                    devicePolicyManager.setCameraDisabled(componentName, true);
                }
            } else {
                devicePolicyManager.setCameraDisabled(componentName, false);
            }
        } catch (SecurityException e4) {
            Long macroGuid4 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid4, "getMacroGuid()");
            SystemLog.logError("Could not set camera enabled state: " + e4, macroGuid4.longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (Build.VERSION.SDK_INT <= 29) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresDeviceAdmin() {
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public Pair<Integer, String> requiresNewHelperFileVersion() {
        return new Pair<>(4, "1.4");
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public DisableCameraAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DisableCameraAction() {
    }

    private DisableCameraAction(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: DisableCameraAction.kt */
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
