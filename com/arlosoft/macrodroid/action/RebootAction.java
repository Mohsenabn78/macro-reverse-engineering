package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.RebootActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import com.stericson.RootTools.RootTools;

/* loaded from: classes2.dex */
public class RebootAction extends Action {
    public static final Parcelable.Creator<RebootAction> CREATOR = new a();
    private boolean m_reboot;
    private boolean m_softReebot;
    private int option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<RebootAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RebootAction createFromParcel(Parcel parcel) {
            return new RebootAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RebootAction[] newArray(int i4) {
            return new RebootAction[i4];
        }
    }

    /* synthetic */ RebootAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_reboot_reboot), SelectableItem.r(R.string.action_reboot_power_off), SelectableItem.r(R.string.action_soft_reboot), SelectableItem.r(R.string.action_reboot_power_off_alternative)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        this.option = i4;
        boolean z4 = true;
        if (i4 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_softReebot = z3;
        if (i4 != 0) {
            z4 = false;
        }
        this.m_reboot = z4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.option == 3) {
            return 3;
        }
        if (this.m_softReebot) {
            return 2;
        }
        if (this.m_reboot) {
            return 0;
        }
        return 1;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String[] options = getOptions();
        if (this.option == 3) {
            return options[3];
        }
        if (this.m_softReebot) {
            return options[2];
        }
        if (this.m_reboot) {
            return options[0];
        }
        return options[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return RebootActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            try {
                if (this.option == 3) {
                    RootTools.getShell(true, 600000, Shell.ShellContext.SYSTEM_APP).add(new Command(0, 60000, "reboot -p"));
                } else if (this.m_softReebot) {
                    Util.runAsRoot(new String[]{"setprop ctl.restart zygote"});
                } else if (this.m_reboot) {
                    Runtime.getRuntime().exec("su");
                    RootTools.getShell(true).add(new Command(0, "am start -a android.intent.action.REBOOT"));
                } else {
                    Runtime.getRuntime().exec("su");
                    RootTools.getShell(true).add(new Command(0, "am start -a android.intent.action.ACTION_REQUEST_SHUTDOWN"));
                }
            } catch (Exception unused) {
            }
        } catch (Exception e4) {
            if (RootToolsHelper.isAccessGiven()) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Reboot Action failed on rooted device: " + e4.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_reboot ? 1 : 0);
        parcel.writeInt(this.m_softReebot ? 1 : 0);
        parcel.writeInt(this.option);
    }

    public RebootAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private RebootAction() {
        this.m_reboot = true;
    }

    private RebootAction(Parcel parcel) {
        super(parcel);
        this.m_reboot = parcel.readInt() != 0;
        this.m_softReebot = parcel.readInt() != 0;
        this.option = parcel.readInt();
    }
}
