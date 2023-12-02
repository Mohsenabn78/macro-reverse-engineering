package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetScreenTimeoutActionInfo;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class SetScreenTimeoutAction extends Action {
    private int m_customValueDelay;
    private int m_timeoutDelay;
    private String m_timeoutDelayString;
    private transient int timeoutDelaySelected;
    private transient String timeoutStringSelected;
    private static final int CUSTOM_VALUE = -99;
    private static final int[] s_delayValues = {15, 30, 60, 120, 300, 600, 1800, -1, CUSTOM_VALUE};
    public static final Parcelable.Creator<SetScreenTimeoutAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetScreenTimeoutAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetScreenTimeoutAction createFromParcel(Parcel parcel) {
            return new SetScreenTimeoutAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetScreenTimeoutAction[] newArray(int i4) {
            return new SetScreenTimeoutAction[i4];
        }
    }

    /* synthetic */ SetScreenTimeoutAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(NumberPicker numberPicker, NumberPicker numberPicker2, AppCompatDialog appCompatDialog, View view) {
        this.m_customValueDelay = (numberPicker.getValue() * 60) + numberPicker2.getValue();
        this.m_timeoutDelayString = this.timeoutStringSelected;
        this.m_timeoutDelay = this.timeoutDelaySelected;
        appCompatDialog.dismiss();
        itemComplete();
    }

    private void Q() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_screen_timeout_custom);
        appCompatDialog.setTitle(R.string.action_set_screen_timeout);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.screen_timeout_custom_minutes);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.screen_timeout_custom_seconds);
        numberPicker.setValue(this.m_customValueDelay / 60);
        numberPicker2.setValue(this.m_customValueDelay % 60);
        numberPicker.setMinimum(0);
        numberPicker2.setMinimum(0);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetScreenTimeoutAction.this.O(numberPicker, numberPicker2, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.sk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_screen_timeout_15s), SelectableItem.r(R.string.seconds_30), SelectableItem.r(R.string.minute_1), SelectableItem.r(R.string.minutes_2), SelectableItem.r(R.string.minutes_5), SelectableItem.r(R.string.minutes_10), SelectableItem.r(R.string.minutes_30), SelectableItem.r(R.string.action_set_screen_timeout_never), SelectableItem.r(R.string.action_set_screen_timeout_custom)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.timeoutStringSelected = getOptions()[i4];
        this.timeoutDelaySelected = s_delayValues[i4];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int i4 = 0;
        while (true) {
            int[] iArr = s_delayValues;
            if (i4 < iArr.length) {
                if (this.m_timeoutDelay == iArr[i4]) {
                    this.timeoutStringSelected = getOptions()[i4];
                    this.timeoutDelaySelected = this.m_timeoutDelay;
                    return i4;
                }
                i4++;
            } else {
                this.timeoutStringSelected = getOptions()[0];
                this.timeoutDelaySelected = iArr[0];
                return 0;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String r4;
        String r5;
        String r6;
        String str = "";
        if (this.m_timeoutDelay == CUSTOM_VALUE) {
            int i4 = this.m_customValueDelay;
            int i5 = i4 / 60;
            int i6 = i4 % 60;
            if (i5 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (i6 == 1) {
                    r6 = SelectableItem.r(R.string.second);
                } else {
                    r6 = SelectableItem.r(R.string.seconds);
                }
                sb.append(r6);
                return sb.toString().toLowerCase();
            } else if (i5 == 1) {
                return "1 " + SelectableItem.r(R.string.minute);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i5);
                sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (i5 == 1) {
                    r4 = SelectableItem.r(R.string.minute);
                } else {
                    r4 = SelectableItem.r(R.string.minutes);
                }
                sb2.append(r4);
                if (i6 != 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb3.append(i6);
                    sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    if (i6 == 1) {
                        r5 = SelectableItem.r(R.string.second);
                    } else {
                        r5 = SelectableItem.r(R.string.seconds);
                    }
                    sb3.append(r5);
                    str = sb3.toString();
                }
                sb2.append(str);
                return sb2.toString().toLowerCase();
            }
        }
        String str2 = this.m_timeoutDelayString;
        if (str2 == null) {
            return "";
        }
        return str2.toLowerCase();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetScreenTimeoutActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4;
        boolean canWrite;
        if (Build.VERSION.SDK_INT >= 23) {
            canWrite = Settings.System.canWrite(getContext());
            if (!canWrite) {
                PermissionsHelper.showNeedsSpecialPermission(getContext(), getName(), 1);
                return;
            }
        }
        int i5 = this.m_timeoutDelay;
        if (i5 == CUSTOM_VALUE) {
            i5 = this.m_customValueDelay;
        }
        int i6 = Integer.MAX_VALUE;
        try {
            ContentResolver contentResolver = getContext().getContentResolver();
            if (i5 > 0) {
                i4 = i5 * 1000;
            } else {
                i4 = Integer.MAX_VALUE;
            }
            Settings.System.putInt(contentResolver, "screen_off_timeout", i4);
        } catch (IllegalArgumentException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal argument cannot set screen timout to: ");
            if (i5 > 0) {
                i6 = i5 * 1000;
            }
            sb.append(i6);
            SystemLog.logError(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.action_set_screen_timeout_select);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.timeoutDelaySelected;
        if (i4 == CUSTOM_VALUE) {
            Q();
            return;
        }
        this.m_timeoutDelayString = this.timeoutStringSelected;
        this.m_timeoutDelay = i4;
        itemComplete();
    }

    public void setTimeoutIndex(int i4) {
        if (i4 >= 0) {
            int[] iArr = s_delayValues;
            if (i4 < iArr.length) {
                this.m_timeoutDelay = iArr[i4];
                this.m_timeoutDelayString = getOptions()[i4];
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_timeoutDelay);
        parcel.writeString(this.m_timeoutDelayString);
        parcel.writeInt(this.m_customValueDelay);
    }

    public SetScreenTimeoutAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetScreenTimeoutAction() {
        this.m_timeoutDelay = s_delayValues[0];
    }

    private SetScreenTimeoutAction(Parcel parcel) {
        super(parcel);
        this.m_timeoutDelay = parcel.readInt();
        this.m_timeoutDelayString = parcel.readString();
        this.m_customValueDelay = parcel.readInt();
    }
}
