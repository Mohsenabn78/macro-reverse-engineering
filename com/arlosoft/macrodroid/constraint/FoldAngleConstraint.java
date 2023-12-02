package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.FoldAngleConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.receivers.HingeEventListener;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FoldAngleConstraint.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FoldAngleConstraint extends Constraint {
    public static final int OPTION_CLOSED = 1;
    public static final int OPTION_HALF_OPEN = 2;
    public static final int OPTION_OPEN = 0;
    private static int constraintCounter;
    @Nullable
    private static HingeEventListener hingeEventListener;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<FoldAngleConstraint> CREATOR = new Parcelable.Creator<FoldAngleConstraint>() { // from class: com.arlosoft.macrodroid.constraint.FoldAngleConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FoldAngleConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FoldAngleConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FoldAngleConstraint[] newArray(int i4) {
            return new FoldAngleConstraint[i4];
        }
    };
    @NotNull
    private static final Object lock = new Object();
    @NotNull
    private static HingeEventListener.HingeState hingeState = HingeEventListener.HingeState.OPEN;

    /* compiled from: FoldAngleConstraint.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HingeEventListener.HingeState.values().length];
            try {
                iArr[HingeEventListener.HingeState.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HingeEventListener.HingeState.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HingeEventListener.HingeState.OPEN_TO_90.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HingeEventListener.HingeState.CLOSED_TO_90.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ FoldAngleConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(HingeEventListener.HingeState hState) {
        Intrinsics.checkNotNullExpressionValue(hState, "hState");
        hingeState = hState;
    }

    private final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.constraint_fold_state_open), SelectableItem.r(R.string.constraint_fold_state_closed), SelectableItem.r(R.string.constraint_half_open_90_degrees)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[hingeState.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        if (this.option != 2) {
                            return false;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (this.option != 2) {
                    return false;
                }
            } else if (this.option != 1) {
                return false;
            }
        } else if (this.option != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void disableConstraintChecking() {
        synchronized (lock) {
            int i4 = constraintCounter - 1;
            constraintCounter = i4;
            if (i4 == 0) {
                HingeEventListener hingeEventListener2 = hingeEventListener;
                if (hingeEventListener2 != null) {
                    Object systemService = getContext().getSystemService("sensor");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
                    ((SensorManager) systemService).unregisterListener(hingeEventListener2);
                }
                hingeEventListener = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void enableConstraintChecking(boolean z3) {
        synchronized (lock) {
            if (constraintCounter == 0) {
                if (Build.VERSION.SDK_INT < 30) {
                    SystemLog.logError("Fold Angle is not supported on this device");
                } else {
                    HingeEventListener hingeEventListener2 = new HingeEventListener(getContext(), new HingeEventListener.OnHingeChangeListener() { // from class: com.arlosoft.macrodroid.constraint.j1
                        @Override // com.arlosoft.macrodroid.triggers.receivers.HingeEventListener.OnHingeChangeListener
                        public final void onHingeChange(HingeEventListener.HingeState hingeState2) {
                            FoldAngleConstraint.P(hingeState2);
                        }
                    });
                    Object systemService = getContext().getSystemService("sensor");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
                    SensorManager sensorManager = (SensorManager) systemService;
                    sensorManager.registerListener(hingeEventListener2, sensorManager.getDefaultSensor(36), 3);
                }
            }
            constraintCounter++;
        }
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
        return FoldAngleConstraintInfo.Companion.getInstance();
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
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public FoldAngleConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public FoldAngleConstraint() {
    }

    private FoldAngleConstraint(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: FoldAngleConstraint.kt */
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
