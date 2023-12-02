package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.action.info.LaunchHomeScreenActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class LaunchHomeScreenAction extends Action {
    public static final Parcelable.Creator<LaunchHomeScreenAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<LaunchHomeScreenAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LaunchHomeScreenAction createFromParcel(Parcel parcel) {
            return new LaunchHomeScreenAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LaunchHomeScreenAction[] newArray(int i4) {
            return new LaunchHomeScreenAction[i4];
        }
    }

    /* synthetic */ LaunchHomeScreenAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LaunchHomeScreenActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            SystemLog.logError("This device does not have support to handle the CATEGORY_HOME intent type", getMacroGuid().longValue());
        } catch (NullPointerException unused2) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("NPE when starting home. getContext() == " + getContext()));
        } catch (Exception e4) {
            SystemLog.logError("Failed to launch home screen: " + e4.toString(), getMacroGuid().longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    public LaunchHomeScreenAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private LaunchHomeScreenAction() {
    }

    private LaunchHomeScreenAction(Parcel parcel) {
        super(parcel);
    }
}
