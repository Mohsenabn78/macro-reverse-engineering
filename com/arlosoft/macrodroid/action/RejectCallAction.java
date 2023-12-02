package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.android.internal.telephony.ITelephony;
import com.arlosoft.macrodroid.action.info.RejectCallActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class RejectCallAction extends Action {
    public static final Parcelable.Creator<RejectCallAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<RejectCallAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RejectCallAction createFromParcel(Parcel parcel) {
            return new RejectCallAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RejectCallAction[] newArray(int i4) {
            return new RejectCallAction[i4];
        }
    }

    /* synthetic */ RejectCallAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void M(Context context, Exception exc) {
        try {
            Intent intent = new Intent("android.intent.action.HEADSET_PLUG");
            intent.addFlags(1073741824);
            String stringExtra = intent.getStringExtra(RemoteConfigConstants.ResponseFieldKey.STATE);
            intent.putExtra(RemoteConfigConstants.ResponseFieldKey.STATE, 1);
            intent.putExtra("name", "Headset");
            context.sendOrderedBroadcast(intent, null);
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
            intent2.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, 79));
            context.sendOrderedBroadcast(intent2, "android.permission.CALL_PRIVILEGED");
            if (stringExtra.equals("1")) {
                intent.putExtra(RemoteConfigConstants.ResponseFieldKey.STATE, 0);
                context.sendOrderedBroadcast(intent, null);
            }
        } catch (Exception e4) {
            SystemLog.logError("Reject call mechanism 1 failed: " + exc.toString(), getMacroGuid().longValue());
            SystemLog.logError("Reject call mechanism 2 failed: " + e4.toString(), getMacroGuid().longValue());
            Util.runAsRoot(new String[]{"input keyevent 6"});
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return RejectCallActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new String[]{"android.permission.ANSWER_PHONE_CALLS"};
        }
        return new String[]{"android.permission.CALL_PHONE"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        boolean endCall;
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            try {
                endCall = ((TelecomManager) getContext().getSystemService("telecom")).endCall();
                SystemLog.logInfo("Call was ended: " + endCall);
            } catch (SecurityException e4) {
                SystemLog.logError("Reject Call Failed: " + e4.getMessage());
                PermissionsHelper.showNeedsPermission(getContext(), "android.permission.ANSWER_PHONE_CALLS", getName(), true, false);
            }
        } else if (i4 >= 27 && RootToolsHelper.isAccessGiven()) {
            Util.runAsRoot(new String[]{"input keyevent 6"});
        } else {
            try {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getITelephony", null);
                declaredMethod.setAccessible(true);
                ((ITelephony) declaredMethod.invoke(telephonyManager, new Object[0])).endCall();
            } catch (Exception e5) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Reject Call Failed: " + e5.getMessage()));
                M(getContext(), e5);
            }
        }
    }

    public RejectCallAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public RejectCallAction() {
    }

    private RejectCallAction(Parcel parcel) {
        super(parcel);
    }
}
