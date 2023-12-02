package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetNFCActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class SetNFCAction extends Action {
    public static final Parcelable.Creator<SetNFCAction> CREATOR = new a();
    private int m_state;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetNFCAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetNFCAction createFromParcel(Parcel parcel) {
            return new SetNFCAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetNFCAction[] newArray(int i4) {
            return new SetNFCAction[i4];
        }
    }

    /* synthetic */ SetNFCAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_nfc_on), SelectableItem.r(R.string.action_set_nfc_off), SelectableItem.r(R.string.action_set_nfc_toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_state;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetNFCActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        Method declaredMethod;
        if (RootToolsHelper.isAccessGiven()) {
            Util.runAsRoot(new String[]{"pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS"});
        }
        NfcAdapter defaultAdapter = ((NfcManager) getContext().getSystemService("nfc")).getDefaultAdapter();
        if (defaultAdapter != null) {
            boolean isEnabled = defaultAdapter.isEnabled();
            int i4 = this.m_state;
            if (i4 != 0) {
                if (i4 == 1 || i4 != 2) {
                    z3 = false;
                } else {
                    z3 = !isEnabled;
                }
            } else {
                z3 = true;
            }
            if (z3 != isEnabled) {
                try {
                    Class<?> cls = Class.forName(defaultAdapter.getClass().getName());
                    if (z3) {
                        declaredMethod = cls.getDeclaredMethod("enable", new Class[0]);
                    } else {
                        declaredMethod = cls.getDeclaredMethod("disable", new Class[0]);
                    }
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(defaultAdapter, new Object[0]);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        SystemLog.logError("NFC Adapter is null - NFC Action failed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
    }

    public SetNFCAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetNFCAction() {
        this.m_state = 0;
    }

    private SetNFCAction(Parcel parcel) {
        super(parcel);
        this.m_state = parcel.readInt();
    }
}
