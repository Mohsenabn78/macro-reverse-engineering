package com.arlosoft.macrodroid.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: NearFarListener.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NearFarListener {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final SensorManager f16062a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<NearFarChangedListener> f16063b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Object f16064c;

    /* compiled from: NearFarListener.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: NearFarListener.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Priority.values().length];
                try {
                    iArr[Priority.CONSTRAINT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Priority.TRIGGER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void addListener(@NotNull NearFarChangedListener listener, @NotNull Priority priority) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(priority, "priority");
            synchronized (NearFarListener.f16064c) {
                if (NearFarListener.f16063b.isEmpty()) {
                    NearFarListener.f16062a.registerListener(a.f16066a, NearFarListener.f16062a.getDefaultSensor(8), 3);
                }
                if (!NearFarListener.f16063b.contains(listener)) {
                    int i4 = WhenMappings.$EnumSwitchMapping$0[priority.ordinal()];
                    if (i4 != 1) {
                        if (i4 == 2) {
                            NearFarListener.f16063b.add(listener);
                        }
                    } else {
                        NearFarListener.f16063b.add(0, listener);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @JvmStatic
        public final void removeListener(@NotNull NearFarChangedListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            synchronized (NearFarListener.f16064c) {
                if (NearFarListener.f16063b.contains(listener)) {
                    NearFarListener.f16063b.remove(listener);
                }
                if (NearFarListener.f16063b.isEmpty()) {
                    NearFarListener.f16062a.unregisterListener(a.f16066a);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: NearFarListener.kt */
    /* loaded from: classes3.dex */
    public interface NearFarChangedListener {
        void onChange(boolean z3);
    }

    /* compiled from: NearFarListener.kt */
    /* loaded from: classes3.dex */
    public enum Priority {
        CONSTRAINT,
        TRIGGER
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NearFarListener.kt */
    /* loaded from: classes3.dex */
    public static final class a implements SensorEventListener {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f16066a = new a();

        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(@NotNull Sensor sensor, int i4) {
            Intrinsics.checkNotNullParameter(sensor, "sensor");
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(@NotNull SensorEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            boolean z3 = false;
            float f4 = event.values[0];
            Sensor defaultSensor = NearFarListener.f16062a.getDefaultSensor(8);
            Intrinsics.checkNotNull(defaultSensor);
            if (f4 < defaultSensor.getMaximumRange() / 2) {
                z3 = true;
            }
            synchronized (NearFarListener.f16064c) {
                Iterator it = NearFarListener.f16063b.iterator();
                while (it.hasNext()) {
                    ((NearFarChangedListener) it.next()).onChange(z3);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    static {
        Object systemService = MacroDroidApplication.Companion.getInstance().getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        f16062a = (SensorManager) systemService;
        f16063b = new ArrayList<>();
        f16064c = new Object();
    }

    @JvmStatic
    public static final void addListener(@NotNull NearFarChangedListener nearFarChangedListener, @NotNull Priority priority) {
        Companion.addListener(nearFarChangedListener, priority);
    }

    @JvmStatic
    public static final void removeListener(@NotNull NearFarChangedListener nearFarChangedListener) {
        Companion.removeListener(nearFarChangedListener);
    }
}
