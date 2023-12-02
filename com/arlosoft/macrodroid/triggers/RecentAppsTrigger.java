package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.info.RecentAppsTriggerInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class RecentAppsTrigger extends Trigger {
    private static final String PACKAGE_ANDROID_SYSTEM_UI = "com.android.systemui";
    private static final String PACKAGE_NEXUS_LAUNCHER = "com.google.android.apps.nexuslauncher";
    public static final Parcelable.Creator<RecentAppsTrigger> CREATOR = new a();
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<RecentAppsTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RecentAppsTrigger createFromParcel(Parcel parcel) {
            return new RecentAppsTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RecentAppsTrigger[] newArray(int i4) {
            return new RecentAppsTrigger[i4];
        }
    }

    /* synthetic */ RecentAppsTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(Macro macro) {
        macro.invokeActions(macro.getTriggerContextInfo());
    }

    public static void handleWindowChanged(String str, String str2) {
        if (str.equals(PACKAGE_ANDROID_SYSTEM_UI) && str2.endsWith("RecentsActivity")) {
            ArrayList<Macro> arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof RecentAppsTrigger) && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                for (final Macro macro2 : arrayList) {
                    mainThreadHandler.post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.x6
                        @Override // java.lang.Runnable
                        public final void run() {
                            RecentAppsTrigger.N(Macro.this);
                        }
                    });
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (!isValid()) {
            return String.format(SelectableItem.r(R.string.feature_only_available_up_to_android_version), 8);
        }
        return super.getEditModeWarning();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return RecentAppsTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (Build.VERSION.SDK_INT <= 27) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessibility() {
        return true;
    }

    public RecentAppsTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public RecentAppsTrigger() {
    }

    private RecentAppsTrigger(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
