package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.info.DarkThemeTriggerInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DarkThemeTrigger extends Trigger {
    public static final Parcelable.Creator<DarkThemeTrigger> CREATOR = new b();
    private static final int STATE_DISABLED = 1;
    private static final int STATE_ENABLED = 0;
    private static ContentObserver s_contentObserver = null;
    private static int s_enabledState = -1;
    private static int s_triggerCounter;
    private int m_option;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            int i4 = 0;
            if (Settings.Secure.getInt(MacroDroidApplication.getInstance().getContentResolver(), "ui_night_mode", 0) != 2) {
                i4 = 1;
            }
            if (i4 != DarkThemeTrigger.s_enabledState) {
                int unused = DarkThemeTrigger.s_enabledState = i4;
                DarkThemeTrigger.Q(i4);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<DarkThemeTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DarkThemeTrigger createFromParcel(Parcel parcel) {
            return new DarkThemeTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DarkThemeTrigger[] newArray(int i4) {
            return new DarkThemeTrigger[i4];
        }
    }

    /* synthetic */ DarkThemeTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(int i4) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof DarkThemeTrigger) && ((DarkThemeTrigger) next).getOption() == i4 && next.constraintsMet()) {
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
            new Handler(MacroDroidApplication.getInstance().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.m2
                @Override // java.lang.Runnable
                public final void run() {
                    DarkThemeTrigger.R(Macro.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(Macro macro) {
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
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0 && s_contentObserver != null) {
            getContext().getContentResolver().unregisterContentObserver(s_contentObserver);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_contentObserver = new a(new Handler());
            getContext().getContentResolver().registerContentObserver(Settings.Secure.getUriFor("ui_night_mode"), true, s_contentObserver);
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
        return DarkThemeTriggerInfo.getInstance();
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

    public DarkThemeTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DarkThemeTrigger() {
    }

    private DarkThemeTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
