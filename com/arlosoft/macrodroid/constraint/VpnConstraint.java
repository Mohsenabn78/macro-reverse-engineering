package com.arlosoft.macrodroid.constraint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.VpnConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VpnConstraint.kt */
@StabilityInferred(parameters = 0)
@TargetApi(21)
/* loaded from: classes3.dex */
public final class VpnConstraint extends Constraint {
    private static final int OPTION_DISABLED = 1;
    private static final int OPTION_ENABLED = 0;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<VpnConstraint> CREATOR = new Parcelable.Creator<VpnConstraint>() { // from class: com.arlosoft.macrodroid.constraint.VpnConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VpnConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VpnConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VpnConstraint[] newArray(int i4) {
            return new VpnConstraint[i4];
        }
    };

    public /* synthetic */ VpnConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] getOptions() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String r4 = SelectableItem.r(R.string.enabled);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.enabled)");
        String format = String.format(r4, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String r5 = SelectableItem.r(R.string.disabled);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.disabled)");
        String format2 = String.format(r5, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return new String[]{format, format2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        boolean z3;
        boolean z4;
        Object systemService = getContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network[] allNetworks = connectivityManager.getAllNetworks();
        Intrinsics.checkNotNullExpressionValue(allNetworks, "cm.allNetworks");
        int length = allNetworks.length;
        int i4 = 0;
        while (true) {
            if (i4 < length) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(allNetworks[i4]);
                if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    z3 = true;
                    break;
                }
                i4++;
            } else {
                z3 = false;
                break;
            }
        }
        if (this.option == 0) {
            return z3;
        }
        if (z3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return getOptions()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return VpnConstraintInfo.Companion.getInstance();
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
    @Nullable
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public VpnConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public VpnConstraint() {
    }

    private VpnConstraint(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: VpnConstraint.kt */
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
