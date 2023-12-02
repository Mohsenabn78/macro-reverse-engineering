package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SendIntentActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class SendIntentAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<SendIntentAction> CREATOR = new a();
    private static final String TARGET_ACTIVITY = "Activity";
    private static final String TARGET_BROADCAST = "Broadcast";
    private static final String TARGET_SERVICE = "Service";
    private int EXTRA_TYPE_AUTO;
    private int EXTRA_TYPE_BOOLEAN;
    private int EXTRA_TYPE_DOUBLE;
    private int EXTRA_TYPE_FLOAT;
    private int EXTRA_TYPE_INT;
    private int EXTRA_TYPE_LONG;
    private int EXTRA_TYPE_STRING;
    private k6[] flags;
    private String m_action;
    private String m_class;
    private String m_className;
    private String m_data;
    private String m_extra1Name;
    private int m_extra1Type;
    private String m_extra1Value;
    private String m_extra2Name;
    private int m_extra2Type;
    private String m_extra2Value;
    private String m_extra3Name;
    private int m_extra3Type;
    private String m_extra3Value;
    private String m_extra4Name;
    private int m_extra4Type;
    private String m_extra4Value;
    private String m_extra5Name;
    private int m_extra5Type;
    private String m_extra5Value;
    private String m_extra6Name;
    private int m_extra6Type;
    private String m_extra6Value;
    private int m_flags;
    private String m_mimeType;
    private String m_packageName;
    private String m_target;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SendIntentAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SendIntentAction createFromParcel(Parcel parcel) {
            return new SendIntentAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SendIntentAction[] newArray(int i4) {
            return new SendIntentAction[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements MagicText.MagicTextListener {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f2478a;

        public b(EditText editText) {
            this.f2478a = editText;
        }

        @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
        public void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
            int max = Math.max(this.f2478a.getSelectionStart(), 0);
            int max2 = Math.max(this.f2478a.getSelectionEnd(), 0);
            Editable text = this.f2478a.getText();
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
        }
    }

    /* synthetic */ SendIntentAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(AppCompatDialog appCompatDialog, EditText editText, Spinner spinner, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, Spinner spinner2, EditText editText8, EditText editText9, Spinner spinner3, EditText editText10, EditText editText11, Spinner spinner4, EditText editText12, EditText editText13, Spinner spinner5, EditText editText14, EditText editText15, Spinner spinner6, EditText editText16, EditText editText17, Spinner spinner7, View view) {
        appCompatDialog.cancel();
        this.m_action = editText.getText().toString();
        this.m_target = spinner.getSelectedItem().toString();
        this.m_packageName = editText2.getText().toString();
        this.m_className = editText3.getText().toString();
        this.m_data = editText4.getText().toString();
        this.m_mimeType = editText5.getText().toString();
        this.m_extra1Name = editText6.getText().toString();
        this.m_extra1Value = editText7.getText().toString();
        this.m_extra1Type = spinner2.getSelectedItemPosition();
        this.m_extra2Name = editText8.getText().toString();
        this.m_extra2Value = editText9.getText().toString();
        this.m_extra2Type = spinner3.getSelectedItemPosition();
        this.m_extra3Name = editText10.getText().toString();
        this.m_extra3Value = editText11.getText().toString();
        this.m_extra3Type = spinner4.getSelectedItemPosition();
        this.m_extra4Name = editText12.getText().toString();
        this.m_extra4Value = editText13.getText().toString();
        this.m_extra4Type = spinner5.getSelectedItemPosition();
        this.m_extra5Name = editText14.getText().toString();
        this.m_extra5Value = editText15.getText().toString();
        this.m_extra5Type = spinner6.getSelectedItemPosition();
        this.m_extra6Name = editText16.getText().toString();
        this.m_extra6Value = editText17.getText().toString();
        this.m_extra6Type = spinner7.getSelectedItemPosition();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(EditText editText, View view) {
        m0(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Activity activity, EditText editText, View view) {
        MagicText.displaySelectionDialog(activity, new b(editText), getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Activity activity, EditText editText, View view) {
        MagicText.displaySelectionDialog(activity, new b(editText), getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Activity activity, EditText editText, View view) {
        MagicText.displaySelectionDialog(activity, new b(editText), getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Activity activity, EditText editText, View view) {
        MagicText.displaySelectionDialog(activity, new b(editText), getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Activity activity, EditText editText, View view) {
        MagicText.displaySelectionDialog(activity, new b(editText), getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Activity activity, EditText editText, View view) {
        MagicText.displaySelectionDialog(activity, new b(editText), getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Activity activity, EditText editText, View view) {
        MagicText.displaySelectionDialog(activity, new b(editText), getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Activity activity, EditText editText, View view) {
        MagicText.displaySelectionDialog(activity, new b(editText), getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(ArrayList arrayList, EditText editText, AppCompatDialog appCompatDialog, View view) {
        Iterator it = arrayList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            CheckBox checkBox = (CheckBox) it.next();
            if (checkBox.isChecked()) {
                i4 += ((Integer) checkBox.getTag()).intValue();
            }
        }
        this.m_flags = i4;
        editText.setText(String.valueOf(i4));
        appCompatDialog.dismiss();
    }

    private void m0(final EditText editText) {
        k6[] k6VarArr;
        boolean z3;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme_App_Dialog_Action);
        appCompatDialog.setContentView(R.layout.dialog_intent_flags);
        appCompatDialog.setTitle(R.string.intent_flags);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        appCompatDialog.setCanceledOnTouchOutside(false);
        appCompatDialog.setCancelable(false);
        LinearLayout linearLayout = (LinearLayout) appCompatDialog.findViewById(R.id.flagsContainer);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final ArrayList arrayList = new ArrayList();
        for (k6 k6Var : this.flags) {
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setText(k6Var.f4144a);
            checkBox.setTag(Integer.valueOf(k6Var.f4145b));
            int i4 = this.m_flags;
            int i5 = k6Var.f4145b;
            if ((i4 & i5) == i5) {
                z3 = true;
            } else {
                z3 = false;
            }
            checkBox.setChecked(z3);
            linearLayout.addView(checkBox);
            arrayList.add(checkBox);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ph
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendIntentAction.this.k0(arrayList, editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_action;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getHelpInfo() {
        return SelectableItem.r(R.string.action_send_intent_help);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getIcon() {
        return R.drawable.ic_android_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SendIntentActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getName() {
        return getContext().getString(R.string.action_send_intent);
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_data, this.m_extra1Value, this.m_extra2Value, this.m_extra3Value, this.m_extra4Value, this.m_extra5Value, this.m_extra6Value};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04d1  */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleItemSelected() {
        /*
            Method dump skipped, instructions count: 1474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SendIntentAction.handleItemSelected():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:120:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0335 A[Catch: Exception -> 0x035f, TryCatch #0 {Exception -> 0x035f, blocks: (B:118:0x030f, B:141:0x0347, B:142:0x034f, B:143:0x0357, B:125:0x0325, B:128:0x032d, B:131:0x0335), top: B:149:0x030f }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0357 A[Catch: Exception -> 0x035f, TRY_LEAVE, TryCatch #0 {Exception -> 0x035f, blocks: (B:118:0x030f, B:141:0x0347, B:142:0x034f, B:143:0x0357, B:125:0x0325, B:128:0x032d, B:131:0x0335), top: B:149:0x030f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014a  */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo r20) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SendIntentAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 7) {
            this.m_data = strArr[0];
            this.m_extra1Value = strArr[1];
            this.m_extra2Value = strArr[2];
            this.m_extra3Value = strArr[3];
            this.m_extra4Value = strArr[4];
            this.m_extra5Value = strArr[5];
            this.m_extra6Value = strArr[6];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_action);
        parcel.writeString(this.m_target);
        parcel.writeString(this.m_packageName);
        parcel.writeString(this.m_className);
        parcel.writeString(this.m_data);
        parcel.writeString(this.m_mimeType);
        parcel.writeString(this.m_class);
        parcel.writeString(this.m_extra1Name);
        parcel.writeString(this.m_extra1Value);
        parcel.writeInt(this.m_extra1Type);
        parcel.writeString(this.m_extra2Name);
        parcel.writeString(this.m_extra2Value);
        parcel.writeInt(this.m_extra2Type);
        parcel.writeString(this.m_extra3Name);
        parcel.writeString(this.m_extra3Value);
        parcel.writeInt(this.m_extra3Type);
        parcel.writeString(this.m_extra4Name);
        parcel.writeString(this.m_extra4Value);
        parcel.writeInt(this.m_extra4Type);
        parcel.writeString(this.m_extra5Name);
        parcel.writeString(this.m_extra5Value);
        parcel.writeInt(this.m_extra5Type);
        parcel.writeString(this.m_extra6Name);
        parcel.writeString(this.m_extra6Value);
        parcel.writeInt(this.m_extra6Type);
        parcel.writeInt(this.m_flags);
    }

    public SendIntentAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SendIntentAction() {
        this.EXTRA_TYPE_AUTO = 0;
        this.EXTRA_TYPE_STRING = 1;
        this.EXTRA_TYPE_BOOLEAN = 2;
        this.EXTRA_TYPE_INT = 3;
        this.EXTRA_TYPE_LONG = 4;
        this.EXTRA_TYPE_FLOAT = 5;
        this.EXTRA_TYPE_DOUBLE = 6;
        this.flags = new k6[]{new k6("FLAG_ACTIVITY_BROUGHT_TO_FRONT", 4194304), new k6("FLAG_ACTIVITY_CLEAR_TASK", 32768), new k6("FLAG_ACTIVITY_CLEAR_TOP", 67108864), new k6("FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET", 524288), new k6("FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS", 8388608), new k6("FLAG_ACTIVITY_FORWARD_RESULT", 33554432), new k6("FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY", 1048576), new k6("FLAG_ACTIVITY_LAUNCH_ADJACENT", 4096), new k6("FLAG_ACTIVITY_MATCH_EXTERNAL", 2048), new k6("FLAG_ACTIVITY_MULTIPLE_TASK", 134217728), new k6("FLAG_ACTIVITY_NEW_DOCUMENT", 524288), new k6("FLAG_ACTIVITY_NEW_TASK", 268435456), new k6("FLAG_ACTIVITY_NO_ANIMATION", 65536), new k6("FLAG_ACTIVITY_NO_HISTORY", 1073741824), new k6("FLAG_ACTIVITY_NO_USER_ACTION", 262144), new k6("FLAG_ACTIVITY_PREVIOUS_IS_TOP", 16777216), new k6("FLAG_ACTIVITY_REORDER_TO_FRONT", 131072), new k6("FLAG_ACTIVITY_REQUIRE_DEFAULT", 512), new k6("FLAG_ACTIVITY_REQUIRE_NON_BROWSER", 1024), new k6("FLAG_ACTIVITY_RESET_TASK_IF_NEEDED", 2097152), new k6("FLAG_ACTIVITY_RETAIN_IN_RECENTS", 8192), new k6("FLAG_ACTIVITY_SINGLE_TOP", 536870912), new k6("FLAG_ACTIVITY_TASK_ON_HOME", 16384), new k6("FLAG_DEBUG_LOG_RESOLUTION", 8), new k6("FLAG_DIRECT_BOOT_AUTO", 256), new k6("FLAG_EXCLUDE_STOPPED_PACKAGES", 16), new k6("FLAG_FROM_BACKGROUND", 4), new k6("FLAG_GRANT_PERSISTABLE_URI_PERMISSION", 64), new k6("FLAG_GRANT_PREFIX_URI_PERMISSION", 128), new k6("FLAG_GRANT_READ_URI_PERMISSION", 1), new k6("FLAG_GRANT_WRITE_URI_PERMISSION", 2), new k6("FLAG_INCLUDE_STOPPED_PACKAGES", 32), new k6("FLAG_RECEIVER_FOREGROUND", 268435456), new k6("FLAG_RECEIVER_NO_ABORT", 134217728), new k6("FLAG_RECEIVER_REGISTERED_ONLY", 1073741824), new k6("FLAG_RECEIVER_REPLACE_PENDING", 536870912), new k6("FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS", 2097152)};
    }

    private SendIntentAction(Parcel parcel) {
        super(parcel);
        this.EXTRA_TYPE_AUTO = 0;
        this.EXTRA_TYPE_STRING = 1;
        this.EXTRA_TYPE_BOOLEAN = 2;
        this.EXTRA_TYPE_INT = 3;
        this.EXTRA_TYPE_LONG = 4;
        this.EXTRA_TYPE_FLOAT = 5;
        this.EXTRA_TYPE_DOUBLE = 6;
        this.flags = new k6[]{new k6("FLAG_ACTIVITY_BROUGHT_TO_FRONT", 4194304), new k6("FLAG_ACTIVITY_CLEAR_TASK", 32768), new k6("FLAG_ACTIVITY_CLEAR_TOP", 67108864), new k6("FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET", 524288), new k6("FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS", 8388608), new k6("FLAG_ACTIVITY_FORWARD_RESULT", 33554432), new k6("FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY", 1048576), new k6("FLAG_ACTIVITY_LAUNCH_ADJACENT", 4096), new k6("FLAG_ACTIVITY_MATCH_EXTERNAL", 2048), new k6("FLAG_ACTIVITY_MULTIPLE_TASK", 134217728), new k6("FLAG_ACTIVITY_NEW_DOCUMENT", 524288), new k6("FLAG_ACTIVITY_NEW_TASK", 268435456), new k6("FLAG_ACTIVITY_NO_ANIMATION", 65536), new k6("FLAG_ACTIVITY_NO_HISTORY", 1073741824), new k6("FLAG_ACTIVITY_NO_USER_ACTION", 262144), new k6("FLAG_ACTIVITY_PREVIOUS_IS_TOP", 16777216), new k6("FLAG_ACTIVITY_REORDER_TO_FRONT", 131072), new k6("FLAG_ACTIVITY_REQUIRE_DEFAULT", 512), new k6("FLAG_ACTIVITY_REQUIRE_NON_BROWSER", 1024), new k6("FLAG_ACTIVITY_RESET_TASK_IF_NEEDED", 2097152), new k6("FLAG_ACTIVITY_RETAIN_IN_RECENTS", 8192), new k6("FLAG_ACTIVITY_SINGLE_TOP", 536870912), new k6("FLAG_ACTIVITY_TASK_ON_HOME", 16384), new k6("FLAG_DEBUG_LOG_RESOLUTION", 8), new k6("FLAG_DIRECT_BOOT_AUTO", 256), new k6("FLAG_EXCLUDE_STOPPED_PACKAGES", 16), new k6("FLAG_FROM_BACKGROUND", 4), new k6("FLAG_GRANT_PERSISTABLE_URI_PERMISSION", 64), new k6("FLAG_GRANT_PREFIX_URI_PERMISSION", 128), new k6("FLAG_GRANT_READ_URI_PERMISSION", 1), new k6("FLAG_GRANT_WRITE_URI_PERMISSION", 2), new k6("FLAG_INCLUDE_STOPPED_PACKAGES", 32), new k6("FLAG_RECEIVER_FOREGROUND", 268435456), new k6("FLAG_RECEIVER_NO_ABORT", 134217728), new k6("FLAG_RECEIVER_REGISTERED_ONLY", 1073741824), new k6("FLAG_RECEIVER_REPLACE_PENDING", 536870912), new k6("FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS", 2097152)};
        this.m_action = parcel.readString();
        this.m_target = parcel.readString();
        this.m_packageName = parcel.readString();
        this.m_className = parcel.readString();
        this.m_data = parcel.readString();
        this.m_mimeType = parcel.readString();
        this.m_class = parcel.readString();
        this.m_extra1Name = parcel.readString();
        this.m_extra1Value = parcel.readString();
        this.m_extra1Type = parcel.readInt();
        this.m_extra2Name = parcel.readString();
        this.m_extra2Value = parcel.readString();
        this.m_extra2Type = parcel.readInt();
        this.m_extra3Name = parcel.readString();
        this.m_extra3Value = parcel.readString();
        this.m_extra3Type = parcel.readInt();
        this.m_extra4Name = parcel.readString();
        this.m_extra4Value = parcel.readString();
        this.m_extra4Type = parcel.readInt();
        this.m_extra5Name = parcel.readString();
        this.m_extra5Value = parcel.readString();
        this.m_extra5Type = parcel.readInt();
        this.m_extra6Name = parcel.readString();
        this.m_extra6Value = parcel.readString();
        this.m_extra6Type = parcel.readInt();
        this.m_flags = parcel.readInt();
    }
}
