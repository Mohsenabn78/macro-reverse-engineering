package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.TorchConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TorchConstraint.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TorchConstraint extends Constraint {
    private int option;
    @NotNull
    private final transient TorchConstraint$torchCallback$1 torchCallback;
    private transient boolean torchOn;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<TorchConstraint> CREATOR = new Parcelable.Creator<TorchConstraint>() { // from class: com.arlosoft.macrodroid.constraint.TorchConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public TorchConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TorchConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public TorchConstraint[] newArray(int i4) {
            return new TorchConstraint[i4];
        }
    };

    public /* synthetic */ TorchConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.on), SelectableItem.r(R.string.off)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        if (this.option == 0) {
            return this.torchOn;
        }
        return !this.torchOn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void disableConstraintChecking() {
        super.disableConstraintChecking();
        Object systemService = getContext().getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        ((CameraManager) systemService).unregisterTorchCallback(this.torchCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void enableConstraintChecking(boolean z3) {
        super.enableConstraintChecking(z3);
        Object systemService = getContext().getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        ((CameraManager) systemService).registerTorchCallback(this.torchCallback, (Handler) null);
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
        return TorchConstraintInfo.Companion.getInstance();
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

    public TorchConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.arlosoft.macrodroid.constraint.TorchConstraint$torchCallback$1] */
    public TorchConstraint() {
        this.torchCallback = new CameraManager.TorchCallback() { // from class: com.arlosoft.macrodroid.constraint.TorchConstraint$torchCallback$1
            @Override // android.hardware.camera2.CameraManager.TorchCallback
            public void onTorchModeChanged(@NotNull String cameraId, boolean z3) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                super.onTorchModeChanged(cameraId, z3);
                TorchConstraint.this.torchOn = z3;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.arlosoft.macrodroid.constraint.TorchConstraint$torchCallback$1] */
    private TorchConstraint(Parcel parcel) {
        super(parcel);
        this.torchCallback = new CameraManager.TorchCallback() { // from class: com.arlosoft.macrodroid.constraint.TorchConstraint$torchCallback$1
            @Override // android.hardware.camera2.CameraManager.TorchCallback
            public void onTorchModeChanged(@NotNull String cameraId, boolean z3) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                super.onTorchModeChanged(cameraId, z3);
                TorchConstraint.this.torchOn = z3;
            }
        };
        this.option = parcel.readInt();
    }

    /* compiled from: TorchConstraint.kt */
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
