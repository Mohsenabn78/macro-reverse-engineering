package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.AmbientDisplayActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class AmbientDisplayAction extends Action {
    public static final Parcelable.Creator<AmbientDisplayAction> CREATOR = new a();
    private int m_option;
    private int m_settingOption;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<AmbientDisplayAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AmbientDisplayAction createFromParcel(Parcel parcel) {
            return new AmbientDisplayAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AmbientDisplayAction[] newArray(int i4) {
            return new AmbientDisplayAction[i4];
        }
    }

    /* synthetic */ AmbientDisplayAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] R() {
        return new String[]{SelectableItem.r(R.string.action_ambient_display_wake_for_notifications), SelectableItem.r(R.string.action_ambient_display_always_on)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(DialogInterface dialogInterface, int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.on), SelectableItem.r(R.string.off), SelectableItem.r(R.string.toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_settingOption = i4;
    }

    protected AlertDialog Q() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(getOptions(), this.m_option, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AmbientDisplayAction.this.S(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AmbientDisplayAction.this.T(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AmbientDisplayAction.this.U(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.s
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                AmbientDisplayAction.this.V(dialogInterface);
            }
        });
        return create;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_settingOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.action_ambient_display) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return R()[this.m_settingOption];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AmbientDisplayActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        boolean z3;
        boolean z4;
        if (this.m_settingOption == 0) {
            str = "doze_enabled";
        } else {
            str = "doze_always_on";
        }
        int i4 = this.m_option;
        boolean z5 = false;
        int i5 = 1;
        if (i4 != 1) {
            if (i4 != 2) {
                z3 = true;
            } else {
                if (Settings.Secure.getInt(getContext().getContentResolver(), str) != 0) {
                    z4 = true;
                    z3 = !z4;
                }
                z4 = false;
                z3 = !z4;
            }
        } else {
            z3 = false;
        }
        if (!RootToolsHelper.isAccessGiven()) {
            try {
                ContentResolver contentResolver = getContext().getContentResolver();
                if (!z3) {
                    i5 = 0;
                }
                z5 = Settings.Secure.putInt(contentResolver, str, i5);
            } catch (Exception unused) {
            }
            if (!z5) {
                SystemLog.logError("Could not set ambient display mode, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS", getMacroGuid().longValue());
            }
        } else if (z3) {
            Util.runAsRoot(new String[]{"settings put secure " + str + " 1"});
        } else {
            Util.runAsRoot(new String[]{"settings put secure " + str + " 0"});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Q();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_settingOption);
    }

    public AmbientDisplayAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private AmbientDisplayAction() {
        this.m_option = 0;
    }

    private AmbientDisplayAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_settingOption = parcel.readInt();
    }
}
