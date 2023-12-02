package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SilentModeVibrateOffActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.LegacySystemCommands;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SilentModeVibrateOffAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class SilentModeVibrateOffAction extends Action {
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SilentModeVibrateOffAction> CREATOR = new Parcelable.Creator<SilentModeVibrateOffAction>() { // from class: com.arlosoft.macrodroid.action.SilentModeVibrateOffAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SilentModeVibrateOffAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SilentModeVibrateOffAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SilentModeVibrateOffAction[] newArray(int i4) {
            return new SilentModeVibrateOffAction[i4];
        }
    };

    public /* synthetic */ SilentModeVibrateOffAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
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
    @NotNull
    public String getExtendedDetail() {
        String str = Companion.a()[this.option];
        Intrinsics.checkNotNullExpressionValue(str, "getOptions()[option]");
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SilentModeVibrateOffActionInfo.Companion.getInstance();
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
        Object systemService = getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        if (this.option == 0) {
            audioManager.setRingerMode(0);
        } else {
            audioManager.setRingerMode(2);
        }
        if (Build.VERSION.SDK_INT == 23) {
            LegacySystemCommands.sendSystemCommandInt(getContext(), "vibrate_when_ringing", this.option, getMacro().getName());
        } else {
            Settings.System.putInt(getContext().getContentResolver(), "vibrate_when_ringing", this.option);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessNotificationPolicy() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLegacyHelperFile() {
        if (Build.VERSION.SDK_INT == 23) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public SilentModeVibrateOffAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SilentModeVibrateOffAction() {
    }

    private SilentModeVibrateOffAction(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: SilentModeVibrateOffAction.kt */
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
            return new String[]{SelectableItem.r(R.string.enable), SelectableItem.r(R.string.disable)};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
