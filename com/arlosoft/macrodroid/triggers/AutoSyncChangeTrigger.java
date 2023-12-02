package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.SyncStatusObserver;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.info.AutoSyncChangeTriggerInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class AutoSyncChangeTrigger extends Trigger {
    public static final Parcelable.Creator<AutoSyncChangeTrigger> CREATOR = new a();
    private static final int STATE_DISABLED = 1;
    private static final int STATE_ENABLED = 0;
    private static int s_enabledState = -1;
    private static Object s_statusChangeListener;
    private static int s_triggerCounter;
    private int m_option;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AutoSyncChangeTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AutoSyncChangeTrigger createFromParcel(Parcel parcel) {
            return new AutoSyncChangeTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AutoSyncChangeTrigger[] newArray(int i4) {
            return new AutoSyncChangeTrigger[i4];
        }
    }

    /* synthetic */ AutoSyncChangeTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static void O(int i4) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof AutoSyncChangeTrigger) && ((AutoSyncChangeTrigger) next).getOption() == i4 && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final Macro macro2 = (Macro) it2.next();
            new Handler(MacroDroidApplication.getInstance().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.c0
                @Override // java.lang.Runnable
                public final void run() {
                    AutoSyncChangeTrigger.Q(Macro.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(int i4) {
        int i5 = !ContentResolver.getMasterSyncAutomatically() ? 1 : 0;
        if (i5 != s_enabledState) {
            s_enabledState = i5;
            O(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(Macro macro) {
        macro.invokeActions(macro.getTriggerContextInfo());
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.enabled), MacroDroidApplication.getInstance().getString(R.string.disabled)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        Object obj;
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0 && (obj = s_statusChangeListener) != null) {
            ContentResolver.removeStatusChangeListener(obj);
            s_statusChangeListener = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_statusChangeListener = ContentResolver.addStatusChangeListener(1, new SyncStatusObserver() { // from class: com.arlosoft.macrodroid.triggers.b0
                @Override // android.content.SyncStatusObserver
                public final void onStatusChanged(int i4) {
                    AutoSyncChangeTrigger.P(i4);
                }
            });
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AutoSyncChangeTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public int getOption() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getTemplateConfiguredName() {
        return getName() + "(" + getExtendedDetail() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public AutoSyncChangeTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private AutoSyncChangeTrigger() {
    }

    private AutoSyncChangeTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
