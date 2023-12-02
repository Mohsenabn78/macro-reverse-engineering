package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.BlockTouchesActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BlockTouchesAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class BlockTouchesAction extends Action {
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<BlockTouchesAction> CREATOR = new Parcelable.Creator<BlockTouchesAction>() { // from class: com.arlosoft.macrodroid.action.BlockTouchesAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public BlockTouchesAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BlockTouchesAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public BlockTouchesAction[] newArray(int i4) {
            return new BlockTouchesAction[i4];
        }
    };

    public /* synthetic */ BlockTouchesAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(BlockTouchesAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.handleItemSelected();
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
        return BlockTouchesActionInfo.Companion.getInstance();
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
    public void handleItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Action);
        builder.setTitle(getName());
        builder.setMessage(getHelpInfo());
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.d1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                BlockTouchesAction.N(BlockTouchesAction.this, dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (((com.arlosoft.macrodroid.triggers.ScreenOnOffTrigger) r6).getScreenOn() != false) goto L24;
     */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(@org.jetbrains.annotations.Nullable com.arlosoft.macrodroid.triggers.TriggerContextInfo r6) {
        /*
            r5 = this;
            int r0 = r5.option
            r1 = 2
            if (r0 == 0) goto L7
            if (r0 != r1) goto L30
        L7:
            r0 = 0
            if (r6 == 0) goto Lf
            com.arlosoft.macrodroid.triggers.Trigger r2 = r6.getTrigger()
            goto L10
        Lf:
            r2 = r0
        L10:
            boolean r2 = r2 instanceof com.arlosoft.macrodroid.triggers.DeviceUnlockedTrigger
            if (r2 != 0) goto L61
            if (r6 == 0) goto L1a
            com.arlosoft.macrodroid.triggers.Trigger r0 = r6.getTrigger()
        L1a:
            boolean r0 = r0 instanceof com.arlosoft.macrodroid.triggers.ScreenOnOffTrigger
            if (r0 == 0) goto L30
            com.arlosoft.macrodroid.triggers.Trigger r6 = r6.getTrigger()
            java.lang.String r0 = "null cannot be cast to non-null type com.arlosoft.macrodroid.triggers.ScreenOnOffTrigger"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            com.arlosoft.macrodroid.triggers.ScreenOnOffTrigger r6 = (com.arlosoft.macrodroid.triggers.ScreenOnOffTrigger) r6
            boolean r6 = r6.getScreenOn()
            if (r6 == 0) goto L30
            goto L61
        L30:
            com.arlosoft.macrodroid.action.services.BlockTouchesService$Companion r6 = com.arlosoft.macrodroid.action.services.BlockTouchesService.Companion
            boolean r6 = r6.isEnabled()
            android.content.Context r0 = r5.getContext()
            android.content.Intent r2 = new android.content.Intent
            android.content.Context r3 = r5.getContext()
            java.lang.Class<com.arlosoft.macrodroid.action.services.BlockTouchesService> r4 = com.arlosoft.macrodroid.action.services.BlockTouchesService.class
            r2.<init>(r3, r4)
            r0.stopService(r2)
            int r0 = r5.option
            if (r0 == 0) goto L50
            if (r0 != r1) goto L60
            if (r6 != 0) goto L60
        L50:
            android.content.Intent r6 = new android.content.Intent
            android.content.Context r0 = r5.getContext()
            r6.<init>(r0, r4)
            android.content.Context r0 = r5.getContext()
            r0.startService(r6)
        L60:
            return
        L61:
            r6 = 2131951730(0x7f130072, float:1.9539883E38)
            java.lang.String r6 = com.arlosoft.macrodroid.common.SelectableItem.r(r6)
            java.lang.String r0 = "getString(R.string.actio…ches_trigger_log_warning)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logWarning(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.BlockTouchesAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public BlockTouchesAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public BlockTouchesAction() {
    }

    private BlockTouchesAction(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: BlockTouchesAction.kt */
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
