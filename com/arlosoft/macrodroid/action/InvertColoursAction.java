package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.InvertColoursActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class InvertColoursAction extends Action {
    public static final Parcelable.Creator<InvertColoursAction> CREATOR = new a();
    private int m_option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<InvertColoursAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InvertColoursAction createFromParcel(Parcel parcel) {
            return new InvertColoursAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InvertColoursAction[] newArray(int i4) {
            return new InvertColoursAction[i4];
        }
    }

    /* synthetic */ InvertColoursAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.on), SelectableItem.r(R.string.off), SelectableItem.r(R.string.toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.action_invert_colours) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return InvertColoursActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        boolean z4;
        int i4 = this.m_option;
        boolean z5 = false;
        int i5 = 1;
        if (i4 != 1) {
            if (i4 != 2) {
                z3 = true;
            } else {
                if (Settings.Secure.getInt(getContext().getContentResolver(), "accessibility_display_inversion_enabled") != 0) {
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
                z5 = Settings.Secure.putInt(contentResolver, "accessibility_display_inversion_enabled", i5);
            } catch (Exception unused) {
            }
            if (!z5) {
                SystemLog.logError("Could not set colour inversion, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS", getMacroGuid().longValue());
            }
        } else if (z3) {
            Util.runAsRoot(new String[]{"settings put secure accessibility_display_inversion_enabled 1"});
        } else {
            Util.runAsRoot(new String[]{"settings put secure accessibility_display_inversion_enabled 0"});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void setState(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public InvertColoursAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private InvertColoursAction() {
        this.m_option = 0;
    }

    private InvertColoursAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
