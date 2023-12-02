package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.MacroEnabledTriggerInfo;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroEnabledTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MacroEnabledTrigger extends Trigger {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MacroEnabledTrigger> CREATOR = new Parcelable.Creator<MacroEnabledTrigger>() { // from class: com.arlosoft.macrodroid.triggers.MacroEnabledTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroEnabledTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MacroEnabledTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroEnabledTrigger[] newArray(int i4) {
            return new MacroEnabledTrigger[i4];
        }
    };

    public /* synthetic */ MacroEnabledTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(MacroEnabledTrigger this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.getMacro().invokeActions(this$0.getMacro().getTriggerContextInfo());
        } catch (Exception e4) {
            Long macroGuid = this$0.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Enabled trigger failed: " + e4, macroGuid.longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (constraintsMet(new TriggerContextInfo(this))) {
            Macro macro = getMacro();
            boolean z3 = false;
            if (macro != null && macro.canInvoke(getMacro().getTriggerContextInfo())) {
                z3 = true;
            }
            if (z3) {
                getMacro().setTriggerThatInvoked(this);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.a5
                    @Override // java.lang.Runnable
                    public final void run() {
                        MacroEnabledTrigger.N(MacroEnabledTrigger.this);
                    }
                });
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return MacroEnabledTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
    }

    public MacroEnabledTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public MacroEnabledTrigger() {
    }

    private MacroEnabledTrigger(Parcel parcel) {
        super(parcel);
    }

    /* compiled from: MacroEnabledTrigger.kt */
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

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }
}
