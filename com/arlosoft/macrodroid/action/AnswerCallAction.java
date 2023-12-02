package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.android.internal.telephony.ITelephony;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.AcceptCallActivity;
import com.arlosoft.macrodroid.action.info.AnswerCallActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootTools.RootTools;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class AnswerCallAction extends Action {
    private int m_selectedIndex;
    private static final int[] s_delayValues = {0, 2, 5, 10};
    public static final Parcelable.Creator<AnswerCallAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<AnswerCallAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AnswerCallAction createFromParcel(Parcel parcel) {
            return new AnswerCallAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AnswerCallAction[] newArray(int i4) {
            return new AnswerCallAction[i4];
        }
    }

    /* synthetic */ AnswerCallAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void N() throws Exception {
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
        Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getITelephony", new Class[0]);
        declaredMethod.setAccessible(true);
        ITelephony iTelephony = (ITelephony) declaredMethod.invoke(telephonyManager, new Object[0]);
        iTelephony.silenceRinger();
        iTelephony.answerRingingCall();
    }

    private void O(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, 79));
        context.sendOrderedBroadcast(intent, "android.permission.CALL_PRIVILEGED");
        Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
        intent2.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
        context.sendOrderedBroadcast(intent2, "android.permission.CALL_PRIVILEGED");
    }

    private String[] P() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_answer_call_no_delay), MacroDroidApplication.getInstance().getString(R.string.action_answer_call_2_seconds), MacroDroidApplication.getInstance().getString(R.string.action_answer_call_5_seconds), MacroDroidApplication.getInstance().getString(R.string.action_answer_call_10_seconds)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                ((TelecomManager) getContext().getSystemService("telecom")).acceptRingingCall();
            } catch (SecurityException unused) {
                SystemLog.logError(getName() + " Requires android.permission.ANSWER_PHONE_CALLS permission", getMacroGuid().longValue());
                PermissionsHelper.showNeedsPermission(getContext(), "android.permission.ANSWER_PHONE_CALLS", getName(), true, false);
            }
        } else if (((TelephonyManager) getContext().getSystemService("phone")).getCallState() != 1) {
        } else {
            if (RootToolsHelper.isAccessGiven()) {
                try {
                    N();
                    return;
                } catch (Exception unused2) {
                    try {
                        RootTools.getShell(true).add(new Command(0, "input keyevent 5"));
                    } catch (Exception unused3) {
                    }
                    O(getContext());
                    return;
                }
            }
            Intent intent = new Intent(getContext(), AcceptCallActivity.class);
            intent.addFlags(276856832);
            getContext().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_selectedIndex = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_selectedIndex;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_selectedIndex == 0) {
            return "";
        }
        return getContext().getString(R.string.action_answer_call_delay) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + P()[this.m_selectedIndex];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AnswerCallActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 26) {
            return new String[]{"android.permission.ANSWER_PHONE_CALLS"};
        }
        return super.getPermissions();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.u0
            @Override // java.lang.Runnable
            public final void run() {
                AnswerCallAction.this.Q();
            }
        }, s_delayValues[this.m_selectedIndex] * 1000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return P();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.action_answer_call_delay_before_answering);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresNotificationAccess() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return false;
    }

    public void setDelayOption(int i4) {
        this.m_selectedIndex = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_selectedIndex);
    }

    public AnswerCallAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public AnswerCallAction() {
    }

    private AnswerCallAction(Parcel parcel) {
        super(parcel);
        this.m_selectedIndex = parcel.readInt();
    }
}
