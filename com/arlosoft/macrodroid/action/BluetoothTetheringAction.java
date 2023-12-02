package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.BluetoothTetheringActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.lang.reflect.Constructor;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BluetoothTetheringAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class BluetoothTetheringAction extends Action {
    @NotNull
    private final transient BroadcastReceiver connectReceiver;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<BluetoothTetheringAction> CREATOR = new Parcelable.Creator<BluetoothTetheringAction>() { // from class: com.arlosoft.macrodroid.action.BluetoothTetheringAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public BluetoothTetheringAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BluetoothTetheringAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public BluetoothTetheringAction[] newArray(int i4) {
            return new BluetoothTetheringAction[i4];
        }
    };

    public /* synthetic */ BluetoothTetheringAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void M() {
        BluetoothAdapter N = N();
        if (N != null && !N.isEnabled()) {
            if (this.option == 1) {
                return;
            }
            MacroDroidApplication.Companion.getInstance().registerReceiver(this.connectReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            N.enable();
            return;
        }
        setTetheringEnabledState(this.option, true);
    }

    @SuppressLint({"NewApi"})
    private final BluetoothAdapter N() {
        BluetoothManager bluetoothManager = (BluetoothManager) getContext().getSystemService("bluetooth");
        if (bluetoothManager != null) {
            return bluetoothManager.getAdapter();
        }
        return null;
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
        return BluetoothTetheringActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[]{"android.permission.BLUETOOTH_CONNECT"};
        }
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        try {
            M();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return Companion.a();
    }

    public final void setTetheringEnabledState(int i4, boolean z3) {
        BluetoothAdapter N = N();
        try {
            Constructor<?> bTPanCtor = Class.forName("android.bluetooth.BluetoothPan").getDeclaredConstructor(Context.class, BluetoothProfile.ServiceListener.class);
            if (bTPanCtor != null) {
                Intrinsics.checkNotNullExpressionValue(bTPanCtor, "bTPanCtor");
                bTPanCtor.setAccessible(true);
                bTPanCtor.newInstance(getContext(), new BTPanServiceListener(i4, z3, N));
            }
            Thread.sleep(250L);
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public BluetoothTetheringAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public BluetoothTetheringAction() {
        this.connectReceiver = new BroadcastReceiver() { // from class: com.arlosoft.macrodroid.action.BluetoothTetheringAction$connectReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                int i4;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual(intent.getAction(), "android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 12) {
                    try {
                        MacroDroidApplication.Companion.getInstance().unregisterReceiver(this);
                    } catch (Exception unused) {
                    }
                    BluetoothTetheringAction bluetoothTetheringAction = BluetoothTetheringAction.this;
                    i4 = bluetoothTetheringAction.option;
                    bluetoothTetheringAction.setTetheringEnabledState(i4, false);
                }
            }
        };
    }

    private BluetoothTetheringAction(Parcel parcel) {
        super(parcel);
        this.connectReceiver = new BroadcastReceiver() { // from class: com.arlosoft.macrodroid.action.BluetoothTetheringAction$connectReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                int i4;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual(intent.getAction(), "android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 12) {
                    try {
                        MacroDroidApplication.Companion.getInstance().unregisterReceiver(this);
                    } catch (Exception unused) {
                    }
                    BluetoothTetheringAction bluetoothTetheringAction = BluetoothTetheringAction.this;
                    i4 = bluetoothTetheringAction.option;
                    bluetoothTetheringAction.setTetheringEnabledState(i4, false);
                }
            }
        };
        this.option = parcel.readInt();
    }

    /* compiled from: BluetoothTetheringAction.kt */
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
