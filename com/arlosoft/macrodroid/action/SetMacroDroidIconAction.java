package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetMacroDroidIconActionInfo;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import java.util.List;

/* loaded from: classes2.dex */
public class SetMacroDroidIconAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<SetMacroDroidIconAction> CREATOR = new a();
    private static final int ICON_TYPE_IMAGE = 0;
    private static final int ICON_TYPE_TEXT = 1;
    private static final int REQUEST_CODE_ICON_SELECT = 7824;
    private static final int REQUEST_CODE_SELECT_ICON = 9874583;
    private transient ImageView iconImage;
    private String iconText;
    private int iconType;
    private String m_imageResourceName;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetMacroDroidIconAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetMacroDroidIconAction createFromParcel(Parcel parcel) {
            return new SetMacroDroidIconAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetMacroDroidIconAction[] newArray(int i4) {
            return new SetMacroDroidIconAction[i4];
        }
    }

    /* synthetic */ SetMacroDroidIconAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void R() {
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_macrodroid_notification);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.notification_icon_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.notification_icon_text_magic_text_button);
        if (Build.VERSION.SDK_INT < 23) {
            ((RadioGroup) appCompatDialog.findViewById(R.id.icon_type_radio_group)).setVisibility(8);
            this.iconType = 0;
            this.iconText = "";
        }
        List<String> ringtoneSounds = Util.getRingtoneSounds(getContext(), 2, false);
        ringtoneSounds.add(0, getContext().getString(R.string.none));
        ringtoneSounds.add(0, getContext().getString(R.string.notification_default));
        String[] strArr = (String[]) ringtoneSounds.toArray(new String[0]);
        Util.getResId(getContext(), this.m_imageResourceName);
        editText.setText(this.iconText);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetMacroDroidIconAction.this.S(appCompatDialog, editText, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ak
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SetMacroDroidIconAction.U(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetMacroDroidIconAction.this.V(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.ck
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SetMacroDroidIconAction.this.W(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(AppCompatDialog appCompatDialog, EditText editText, View view) {
        appCompatDialog.dismiss();
        itemComplete();
        this.iconType = 1;
        this.iconText = editText.getText().toString();
        this.iconImage = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface) {
        this.iconImage = null;
    }

    private void X() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, false);
        activity.startActivityForResult(intent, REQUEST_CODE_SELECT_ICON);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.image), SelectableItem.r(R.string.text)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.iconType = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.iconType;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.iconType == 0) {
            return SelectableItem.r(R.string.image);
        }
        return this.iconText;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetMacroDroidIconActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.iconText};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == REQUEST_CODE_SELECT_ICON && i5 != 0) {
            this.m_imageResourceName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Build.VERSION.SDK_INT < 23) {
            X();
        } else {
            super.handleItemSelected();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        Settings.setMacroDroidIcon(getContext(), Util.getResId(getContext(), this.m_imageResourceName));
        Settings.setMacroDroidIconResourceName(getContext(), this.m_imageResourceName);
        if (this.iconType == 1) {
            str = g(this.iconText, triggerContextInfo);
            if (str.length() > 4) {
                str = str.substring(0, 4);
            }
        } else {
            str = "";
        }
        Settings.setMacroDroidIconTextString(getContext(), str);
        MacroDroidService.updateNotification(getContext(), true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.iconType == 1) {
            R();
        } else {
            X();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.iconText = strArr[0];
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_imageResourceName);
        parcel.writeInt(this.iconType);
        parcel.writeString(this.iconText);
    }

    public SetMacroDroidIconAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetMacroDroidIconAction() {
        this.iconType = 0;
        this.iconText = "";
    }

    private SetMacroDroidIconAction(Parcel parcel) {
        super(parcel);
        this.iconType = 0;
        this.iconText = "";
        this.m_imageResourceName = parcel.readString();
        this.iconType = parcel.readInt();
        this.iconText = parcel.readString();
    }
}
