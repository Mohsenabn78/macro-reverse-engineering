package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.BluetoothTetheringAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BluetoothTetheringActionInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class BluetoothTetheringActionInfo extends ActionInfo {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final SelectableItemInfo f3772j = new BluetoothTetheringActionInfo();
    @StringRes

    /* renamed from: g  reason: collision with root package name */
    private final int f3773g = R.string.action_bluetooth_tethering;

    /* renamed from: h  reason: collision with root package name */
    private final int f3774h = R.drawable.ic_bluetooth_transfer;
    @StringRes

    /* renamed from: i  reason: collision with root package name */
    private final int f3775i = R.string.action_bluetooth_tethering_help;

    @NotNull
    public static final SelectableItemInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new BluetoothTetheringAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f3775i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f3774h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f3773g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    protected int maxSDKVersion() {
        return 29;
    }

    /* compiled from: BluetoothTetheringActionInfo.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectableItemInfo getInstance() {
            return BluetoothTetheringActionInfo.f3772j;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
