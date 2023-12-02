package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.DeleteMacroActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroDeletedEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ContinuePausedActionsHandler;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DeleteMacroAction extends Action {
    private long m_GUID;
    private transient List<Macro> m_macroList;
    private String m_macroName;
    private static final String THIS_MACRO = MacroDroidApplication.getInstance().getString(R.string.constraint_last_run_time_this_macro);
    public static final Parcelable.Creator<DeleteMacroAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DeleteMacroAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DeleteMacroAction createFromParcel(Parcel parcel) {
            return new DeleteMacroAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DeleteMacroAction[] newArray(int i4) {
            return new DeleteMacroAction[i4];
        }
    }

    /* synthetic */ DeleteMacroAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_GUID = this.m_macroList.get(i4).getGUID();
        this.m_macroName = this.m_macroList.get(i4).getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.m_GUID == 0) {
            return 0;
        }
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(false);
        this.m_macroList = allCompletedMacrosSorted;
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            if (getMacro().getGUID() == it.next().getGUID()) {
                it.remove();
            }
        }
        this.m_macroList.add(0, getMacro());
        for (int i4 = 0; i4 < this.m_macroList.size(); i4++) {
            if (this.m_GUID == this.m_macroList.get(i4).getGUID()) {
                return i4;
            }
        }
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_macroName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DeleteMacroActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.m_GUID);
        if (macroByGUID != null) {
            macroByGUID.cancelActiveMacro(getContext());
            SystemLog.logInfo("Deleting macro: " + macroByGUID, getMacro().getGUID());
            ContinuePausedActionsHandler.cancelAlarmsForMacro(getContext(), macroByGUID);
            MacroStore.getInstance().removeMacro(macroByGUID, true);
            EventBusUtils.getEventBus().post(new MacroDeletedEvent(macroByGUID.getGUID()));
            return;
        }
        SystemLog.logWarning("Attempted to delete macro that no longer exists (Ignoring)", 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(false);
        this.m_macroList = allCompletedMacrosSorted;
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            if (getMacro().getGUID() == it.next().getGUID()) {
                it.remove();
            }
        }
        this.m_macroList.add(0, getMacro());
        String[] strArr = new String[this.m_macroList.size()];
        for (int i4 = 0; i4 < this.m_macroList.size(); i4++) {
            if (getMacro().getGUID() == this.m_macroList.get(i4).getGUID()) {
                strArr[i4] = THIS_MACRO;
            } else {
                strArr[i4] = this.m_macroList.get(i4).getName();
            }
        }
        if (this.m_GUID == 0 && this.m_macroList.size() > 0) {
            this.m_GUID = this.m_macroList.get(0).getGUID();
            this.m_macroName = THIS_MACRO;
        }
        return strArr;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_macroName);
        parcel.writeLong(this.m_GUID);
    }

    public DeleteMacroAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DeleteMacroAction() {
    }

    private DeleteMacroAction(Parcel parcel) {
        super(parcel);
        this.m_macroName = parcel.readString();
        this.m_GUID = parcel.readLong();
    }
}
