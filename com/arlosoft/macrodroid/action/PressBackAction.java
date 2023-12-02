package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.action.info.PressBackActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.MacroDroidAccessibilityServiceJellyBean;

/* loaded from: classes2.dex */
public class PressBackAction extends Action {
    public static final Parcelable.Creator<PressBackAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<PressBackAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PressBackAction createFromParcel(Parcel parcel) {
            return new PressBackAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PressBackAction[] newArray(int i4) {
            return new PressBackAction[i4];
        }
    }

    /* synthetic */ PressBackAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PressBackActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            if (Util.isMacroDroidAccessibilityEnabled(getContext())) {
                Intent intent = new Intent(getContext(), MacroDroidAccessibilityServiceJellyBean.class);
                intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 1);
                getContext().startService(intent);
            } else {
                Util.runAsRoot(new String[]{"input keyevent 4"});
            }
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
            SystemLog.logError("Press back failed: " + e4.toString());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessibility() {
        return true;
    }

    public PressBackAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private PressBackAction() {
    }

    private PressBackAction(Parcel parcel) {
        super(parcel);
    }
}
