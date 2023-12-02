package com.arlosoft.macrodroid.action;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BluetoothTetheringAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class BTPanServiceListener implements BluetoothProfile.ServiceListener {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2092d;

    /* renamed from: a  reason: collision with root package name */
    private final int f2093a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2094b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final BluetoothAdapter f2095c;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: BluetoothTetheringAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getState() {
            return BTPanServiceListener.f2092d;
        }

        public final void setState(boolean z3) {
            BTPanServiceListener.f2092d = z3;
        }
    }

    public BTPanServiceListener(int i4, boolean z3, @Nullable BluetoothAdapter bluetoothAdapter) {
        this.f2093a = i4;
        this.f2094b = z3;
        this.f2095c = bluetoothAdapter;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int i4, @NotNull BluetoothProfile proxy) {
        boolean z3;
        BluetoothAdapter bluetoothAdapter;
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        try {
            int i5 = this.f2093a;
            if (i5 != 0) {
                if (i5 != 1) {
                    Object invoke = proxy.getClass().getMethod("isTetheringOn", new Class[0]).invoke(proxy, new Object[0]);
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
                    if (!((Boolean) invoke).booleanValue()) {
                    }
                }
                z3 = false;
                Class<?> cls = proxy.getClass();
                Class<?> TYPE = Boolean.TYPE;
                Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
                cls.getMethod("setBluetoothTethering", TYPE).invoke(proxy, Boolean.valueOf(z3));
                if (this.f2094b && !z3 && (bluetoothAdapter = this.f2095c) != null) {
                    bluetoothAdapter.disable();
                    return;
                }
                return;
            }
            z3 = true;
            Class<?> cls2 = proxy.getClass();
            Class<?> TYPE2 = Boolean.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE2, "TYPE");
            cls2.getMethod("setBluetoothTethering", TYPE2).invoke(proxy, Boolean.valueOf(z3));
            if (this.f2094b) {
            }
        } catch (Exception e4) {
            SystemLog.logError("Bluetooth tethering action failed: " + e4);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int i4) {
    }
}
