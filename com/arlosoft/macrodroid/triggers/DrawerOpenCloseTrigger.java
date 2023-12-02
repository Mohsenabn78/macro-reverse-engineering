package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.DrawerOpenCloseTriggerInfo;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DrawerOpenCloseTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class DrawerOpenCloseTrigger extends Trigger {
    private static int triggerCount;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DrawerOpenCloseTrigger> CREATOR = new Parcelable.Creator<DrawerOpenCloseTrigger>() { // from class: com.arlosoft.macrodroid.triggers.DrawerOpenCloseTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DrawerOpenCloseTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DrawerOpenCloseTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DrawerOpenCloseTrigger[] newArray(int i4) {
            return new DrawerOpenCloseTrigger[i4];
        }
    };

    public /* synthetic */ DrawerOpenCloseTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        triggerCount--;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        triggerCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        return Companion.a()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return DrawerOpenCloseTriggerInfo.Companion.getInstance();
    }

    public final int getOption() {
        return this.option;
    }

    public final boolean isOpen() {
        if (this.option == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public DrawerOpenCloseTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DrawerOpenCloseTrigger() {
    }

    private DrawerOpenCloseTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: DrawerOpenCloseTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            String r4 = SelectableItem.r(R.string.trigger_drawer_open_close_drawer_openend);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigg…pen_close_drawer_openend)");
            String r5 = SelectableItem.r(R.string.trigger_drawer_open_close_drawer_closed);
            Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigg…open_close_drawer_closed)");
            return new String[]{r4, r5};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
