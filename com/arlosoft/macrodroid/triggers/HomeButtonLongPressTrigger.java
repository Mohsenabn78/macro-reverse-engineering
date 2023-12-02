package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.info.HomeButtonLongPressTriggerInfo;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HomeButtonLongPressTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HomeButtonLongPressTrigger extends Trigger {
    private static int triggerCount;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<HomeButtonLongPressTrigger> CREATOR = new Parcelable.Creator<HomeButtonLongPressTrigger>() { // from class: com.arlosoft.macrodroid.triggers.HomeButtonLongPressTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public HomeButtonLongPressTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HomeButtonLongPressTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public HomeButtonLongPressTrigger[] newArray(int i4) {
            return new HomeButtonLongPressTrigger[i4];
        }
    };

    public /* synthetic */ HomeButtonLongPressTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        triggerCount--;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        triggerCount++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getEditModeWarning() {
        if (!isValid()) {
            return SelectableItem.r(R.string.requires_assist_and_voice_input);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return HomeButtonLongPressTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        if (Build.VERSION.SDK_INT >= 24) {
            PermissionsHelper.showDefaultAssistRequiredDialog(getActivity(), false, false);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return ApplicationChecker.isMacroDroidAssistDefault(getContext());
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresDefaultAssist() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
    }

    public HomeButtonLongPressTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public HomeButtonLongPressTrigger() {
    }

    private HomeButtonLongPressTrigger(Parcel parcel) {
        super(parcel);
    }

    /* compiled from: HomeButtonLongPressTrigger.kt */
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
