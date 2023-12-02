package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.MessageDialogActivity;
import com.arlosoft.macrodroid.action.info.MessageDialogActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.List;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class MessageDialogAction extends NotificationAction implements BlockingAction {
    public static final Parcelable.Creator<MessageDialogAction> CREATOR = new a();
    protected String m_secondaryClassType;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<MessageDialogAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MessageDialogAction createFromParcel(Parcel parcel) {
            return new MessageDialogAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MessageDialogAction[] newArray(int i4) {
            return new MessageDialogAction[i4];
        }
    }

    /* synthetic */ MessageDialogAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean M0() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean N0() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean O0() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction, com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MessageDialogActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction, com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_notificationSubject, this.m_notificationText};
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean i0() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction, com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean j0() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean k0() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean m0() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean n0() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean o0() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected String q0() {
        return SelectableItem.r(R.string.enter_dialog_text);
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected String r0() {
        return SelectableItem.r(R.string.enter_dialog_subject);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction, com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_notificationSubject = strArr[0];
            this.m_notificationText = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    public boolean showIcon() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction
    protected boolean t0() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.NotificationAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_notificationText);
        parcel.writeInt(this.m_overwriteExisting ? 1 : 0);
        parcel.writeString(this.m_notificationSubject);
        parcel.writeString(this.m_imageResourceName);
        parcel.writeInt(this.blockNextAction ? 1 : 0);
        parcel.writeInt(this.preventBackButtonClosing ? 1 : 0);
        parcel.writeInt(this.maintainSpaces ? 1 : 0);
        parcel.writeInt(this.disableHtml ? 1 : 0);
    }

    public MessageDialogAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> stack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        String str;
        String g4 = g(this.m_notificationSubject, triggerContextInfo);
        String str2 = this.m_notificationText;
        if (str2 != null) {
            str = g(str2, triggerContextInfo).replace("\n", "<br/>");
            if (this.maintainSpaces) {
                str = str.replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "&nbsp;");
            }
        } else {
            str = "";
        }
        Intent intent = new Intent(getContext(), MessageDialogActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("Subject", g4);
        intent.putExtra("Message", str);
        intent.putExtra(MessageDialogActivity.RESOURCE_NAME, this.m_imageResourceName);
        intent.putExtra(MessageDialogActivity.RESOURCE_ID, this.m_imageResourceId);
        intent.putExtra("PreventBackButton", this.preventBackButtonClosing);
        intent.putExtra(Util.EXTRA_GUID, this.m_macro.getGUID());
        intent.putExtra(MessageDialogActivity.USE_HTML, !this.disableHtml);
        intent.putExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED, this.m_macro.getTriggerThatInvoked());
        intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
        intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, stack);
        intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z3);
        intent.putExtra(Constants.EXTRA_IS_TEST, z4);
        intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
        intent.putExtra(Constants.EXTRA_BLOCK_NEXT_ACTION, this.blockNextAction);
        getContext().startActivity(intent);
        int i5 = this.m_ringtoneIndex;
        Uri uri = null;
        if (i5 >= 2) {
            RingtoneManager ringtoneManager = new RingtoneManager(getContext());
            int i6 = 0;
            List<String> ringtoneSounds = Util.getRingtoneSounds(getContext(), 2, false);
            while (true) {
                if (i6 >= ringtoneSounds.size()) {
                    break;
                } else if (ringtoneSounds.get(i6).equals(this.m_ringtoneName)) {
                    ringtoneManager.setType(2);
                    Cursor cursor = ringtoneManager.getCursor();
                    Uri ringtoneUri = ringtoneManager.getRingtoneUri(i6);
                    cursor.close();
                    uri = ringtoneUri;
                    break;
                } else {
                    i6++;
                }
            }
        } else if (i5 != 1) {
            uri = RingtoneManager.getDefaultUri(2);
        }
        if (uri != null) {
            Ringtone ringtone = RingtoneManager.getRingtone(getContext(), uri);
            if (ringtone != null) {
                try {
                    ringtone.stop();
                    ringtone.setStreamType(5);
                    ringtone.play();
                    return;
                } catch (Exception e4) {
                    SystemLog.logError("Failed to play sound: " + e4.toString(), getMacroGuid().longValue());
                    return;
                }
            }
            SystemLog.logError("Ringtone not found - cannot play sound", getMacroGuid().longValue());
        }
    }

    private MessageDialogAction() {
        this.m_secondaryClassType = "MessageDialogAction";
    }

    private MessageDialogAction(Parcel parcel) {
        super(parcel);
        this.m_secondaryClassType = "MessageDialogAction";
        this.m_notificationText = parcel.readString();
        this.m_overwriteExisting = parcel.readInt() != 0;
        this.m_notificationSubject = parcel.readString();
        this.m_imageResourceName = parcel.readString();
        this.blockNextAction = parcel.readInt() != 0;
        this.preventBackButtonClosing = parcel.readInt() != 0;
        this.maintainSpaces = parcel.readInt() != 0;
        this.disableHtml = parcel.readInt() != 0;
    }
}
