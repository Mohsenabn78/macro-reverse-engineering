package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetQuickSettingsStateActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.QuickSettingSetToggleStateEvent;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.quicksettings.QuickSettingButton;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsActivity;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsArrayAdapter;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsData;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.lang.ref.WeakReference;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetQuickSettingsStateAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<SetQuickSettingsStateAction> CREATOR = new a();
    public static final int OPTION_TOGGLE_OFF = 1;
    public static final int OPTION_TOGGLE_ON = 0;
    private static final int REQUEST_CODE_QUICK_SETTINGS = 21765234;
    private static final int REQUEST_CODE_SELECT_ICON = 837834;
    private transient WeakReference<ImageView> iconRef;
    private int iconRes;
    private String iconResName;
    private transient QuickSettingsArrayAdapter itemsAdapter;
    private String label;
    private transient ListView listView;
    private int m_tileOption;
    private int m_toggleOption;
    private transient int selectedIconRes;
    private transient String selectedIconResName;
    private transient int selectedTileOption;
    private boolean setImage;
    private boolean setLabel;
    private boolean setToggleState;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetQuickSettingsStateAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetQuickSettingsStateAction createFromParcel(Parcel parcel) {
            return new SetQuickSettingsStateAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetQuickSettingsStateAction[] newArray(int i4) {
            return new SetQuickSettingsStateAction[i4];
        }
    }

    /* synthetic */ SetQuickSettingsStateAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Y() {
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_Action);
        appCompatDialog.setContentView(R.layout.dialog_quick_settings_trigger);
        appCompatDialog.setTitle(R.string.action_set_quick_settings_state);
        this.selectedTileOption = this.m_tileOption;
        this.listView = (ListView) appCompatDialog.findViewById(R.id.list);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.configure_tiles);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetQuickSettingsStateAction.j0(activity, view);
            }
        });
        QuickSettingsArrayAdapter quickSettingsArrayAdapter = new QuickSettingsArrayAdapter(appCompatDialog.getContext(), Z(), a0());
        this.itemsAdapter = quickSettingsArrayAdapter;
        this.listView.setAdapter((ListAdapter) quickSettingsArrayAdapter);
        this.listView.setChoiceMode(1);
        this.listView.setSelection(this.m_tileOption);
        this.listView.setItemChecked(this.m_tileOption, true);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.hk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetQuickSettingsStateAction.this.k0(appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ik
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetQuickSettingsStateAction.this.l0(appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    private String[] Z() {
        String str;
        QuickSettingsData quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        int length = getOptions().length;
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            if (quickSettingsData != null) {
                str = quickSettingsData.getQSButtonList().get(i4).getLabel();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = getOptions()[i4];
            }
            strArr[i4] = str;
        }
        return strArr;
    }

    private boolean[] a0() {
        QuickSettingsData quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData == null) {
            quickSettingsData = QuickSettingsData.createDefault();
        }
        List<QuickSettingButton> qSButtonList = quickSettingsData.getQSButtonList();
        boolean[] zArr = new boolean[16];
        for (int i4 = 0; i4 < qSButtonList.size(); i4++) {
            zArr[i4] = qSButtonList.get(i4).getEnabled();
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, CompoundButton compoundButton, boolean z3) {
        float f4;
        radioButton.setEnabled(z3);
        radioButton2.setEnabled(z3);
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        radioGroup.setAlpha(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(EditText editText, CompoundButton compoundButton, boolean z3) {
        float f4;
        editText.setEnabled(z3);
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        editText.setAlpha(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(ViewGroup viewGroup, ImageView imageView, CompoundButton compoundButton, boolean z3) {
        float f4;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        viewGroup.setAlpha(f4);
        imageView.setEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(Activity activity, View view) {
        Intent intent = new Intent(activity, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, false);
        activity.startActivityForResult(intent, REQUEST_CODE_SELECT_ICON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    public static String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.macrodroid_tile_1), SelectableItem.r(R.string.macrodroid_tile_2), SelectableItem.r(R.string.macrodroid_tile_3), SelectableItem.r(R.string.macrodroid_tile_4), SelectableItem.r(R.string.macrodroid_tile_5), SelectableItem.r(R.string.macrodroid_tile_6), SelectableItem.r(R.string.macrodroid_tile_7), SelectableItem.r(R.string.macrodroid_tile_8), SelectableItem.r(R.string.macrodroid_tile_9), SelectableItem.r(R.string.macrodroid_tile_10), SelectableItem.r(R.string.macrodroid_tile_11), SelectableItem.r(R.string.macrodroid_tile_12), SelectableItem.r(R.string.macrodroid_tile_13), SelectableItem.r(R.string.macrodroid_tile_14), SelectableItem.r(R.string.macrodroid_tile_15), SelectableItem.r(R.string.macrodroid_tile_16)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, Activity activity, RadioButton radioButton, EditText editText, AppCompatDialog appCompatDialog, View view) {
        if (!checkBox.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) {
            ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.action_set_bluetooth_invalid, 1).show();
            return;
        }
        this.m_tileOption = this.selectedTileOption;
        this.setLabel = checkBox.isChecked();
        this.setToggleState = checkBox2.isChecked();
        this.setImage = checkBox3.isChecked();
        this.m_toggleOption = !radioButton.isChecked();
        this.label = editText.getText().toString();
        this.iconRes = this.selectedIconRes;
        this.iconResName = this.selectedIconResName;
        itemComplete();
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(Activity activity, View view) {
        activity.startActivityForResult(new Intent(activity, QuickSettingsActivity.class), REQUEST_CODE_QUICK_SETTINGS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(AppCompatDialog appCompatDialog, View view) {
        this.selectedTileOption = this.listView.getCheckedItemPosition();
        appCompatDialog.dismiss();
        X();
        this.listView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(AppCompatDialog appCompatDialog, View view) {
        appCompatDialog.dismiss();
        this.listView = null;
    }

    protected void X() {
        boolean z3;
        float f4;
        float f5;
        final Activity activity = getActivity();
        if (this.iconRes == 0) {
            this.selectedIconRes = R.drawable.notification_icon_cog_box;
            this.iconRes = R.drawable.notification_icon_cog_box;
        }
        if (this.iconResName == null) {
            this.selectedIconResName = "notification_icon_cog_box";
            this.iconResName = "notification_icon_cog_box";
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_quick_tile_configure);
        appCompatDialog.setTitle(getOptions()[this.selectedTileOption]);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!activity.getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.setOnOffStateCheckBox);
        final RadioGroup radioGroup = (RadioGroup) appCompatDialog.findViewById(R.id.radioGroupOnOff);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.onRadioButton);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.offRadioButton);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.setLabelCheckBox);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.labelText);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.setIconCheckBox);
        final ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.icon_container);
        final ImageView imageView = (ImageView) appCompatDialog.findViewById(R.id.icon);
        Button button = (Button) appCompatDialog.findViewById(R.id.magicTextButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        this.iconRef = new WeakReference<>(imageView);
        checkBox.setChecked(this.setToggleState);
        checkBox2.setChecked(this.setLabel);
        checkBox3.setChecked(this.setImage);
        boolean z4 = true;
        if (this.m_toggleOption == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton.setChecked(z3);
        if (this.m_toggleOption != 1) {
            z4 = false;
        }
        radioButton2.setChecked(z4);
        editText.setText(this.label);
        radioButton.setEnabled(this.setToggleState);
        radioButton2.setEnabled(this.setToggleState);
        float f6 = 1.0f;
        if (this.setToggleState) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        radioGroup.setAlpha(f4);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.jk
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                SetQuickSettingsStateAction.c0(radioButton, radioButton2, radioGroup, compoundButton, z5);
            }
        });
        editText.setEnabled(this.setLabel);
        if (this.setLabel) {
            f5 = 1.0f;
        } else {
            f5 = 0.5f;
        }
        editText.setAlpha(f5);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.kk
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                SetQuickSettingsStateAction.d0(editText, compoundButton, z5);
            }
        });
        if (!this.setImage) {
            f6 = 0.5f;
        }
        viewGroup.setAlpha(f6);
        imageView.setEnabled(this.setImage);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.lk
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                SetQuickSettingsStateAction.e0(viewGroup, imageView, compoundButton, z5);
            }
        });
        imageView.setImageResource(Util.getResourceIdFromName(activity, this.iconResName));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.mk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetQuickSettingsStateAction.f0(activity, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.nk
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SetQuickSettingsStateAction.g0(editText, magicTextPair);
            }
        };
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ok
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetQuickSettingsStateAction.this.h0(activity, magicTextListener, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetQuickSettingsStateAction.this.i0(checkBox2, checkBox, checkBox3, activity, radioButton, editText, appCompatDialog, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return String.format(SelectableItem.r(R.string.action_set_quick_settings_state_with_tile_number), Integer.valueOf(this.m_tileOption + 1));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        int i4;
        StringBuilder sb = new StringBuilder();
        if (this.setToggleState) {
            if (this.m_toggleOption == 0) {
                i4 = R.string.on;
            } else {
                i4 = R.string.off;
            }
            sb.append(SelectableItem.r(i4));
            sb.append(", ");
        }
        if (this.setLabel) {
            sb.append(SelectableItem.r(R.string.label));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            if (this.label.isEmpty()) {
                str = SelectableItem.r(R.string.empty);
            } else {
                str = this.label;
            }
            sb.append(str);
            sb.append(", ");
        }
        if (this.setImage) {
            sb.append(SelectableItem.r(R.string.action_set_quick_tile_icon));
            sb.append(", ");
        }
        if (sb.length() >= 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetQuickSettingsStateActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.label};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        ImageView imageView;
        if (i4 == REQUEST_CODE_QUICK_SETTINGS && i5 == -1) {
            QuickSettingsArrayAdapter quickSettingsArrayAdapter = new QuickSettingsArrayAdapter(new ContextThemeWrapper(activity, (int) R.style.Theme_App_Dialog_Action), Z(), a0());
            this.itemsAdapter = quickSettingsArrayAdapter;
            this.listView.setAdapter((ListAdapter) quickSettingsArrayAdapter);
            this.listView.setSelection(this.m_tileOption);
            this.listView.setItemChecked(this.m_tileOption, true);
        }
        if (i4 == REQUEST_CODE_SELECT_ICON && i5 == -1) {
            this.selectedIconRes = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
            this.selectedIconResName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            WeakReference<ImageView> weakReference = this.iconRef;
            if (weakReference != null && (imageView = weakReference.get()) != null) {
                imageView.setImageResource(this.selectedIconRes);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        boolean toggleOn;
        Cache cache = MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE);
        QuickSettingsData quickSettingsData = (QuickSettingsData) cache.get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData != null) {
            int i4 = this.m_tileOption;
            if (i4 >= 0 && i4 < 16) {
                QuickSettingButton quickSettingButton = quickSettingsData.getQSButtonList().get(this.m_tileOption);
                quickSettingButton.getEnabled();
                String label = quickSettingButton.getLabel();
                int image = quickSettingButton.getImage();
                String imageName = quickSettingButton.getImageName();
                if (this.setToggleState) {
                    if (this.m_toggleOption == 0) {
                        toggleOn = true;
                    } else {
                        toggleOn = false;
                    }
                } else {
                    toggleOn = quickSettingButton.getToggleOn();
                }
                if (this.setLabel) {
                    label = MagicText.replaceMagicText(getContext(), this.label, triggerContextInfo, getMacro());
                }
                String str = label;
                if (this.setImage) {
                    image = this.iconRes;
                    imageName = this.iconResName;
                }
                boolean z3 = toggleOn;
                quickSettingsData.replaceButton(quickSettingButton, QuickSettingButton.create(str, image, quickSettingButton.getEnabled(), quickSettingButton.isToggle(), z3, quickSettingButton.getCollapseOnPress(), imageName));
                cache.put(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, quickSettingsData);
                EventBusUtils.getEventBus().post(new QuickSettingSetToggleStateEvent(this.m_tileOption + 1, toggleOn));
                return;
            }
            SystemLog.logError("Invalid tile number specified, please reconfigure the action.");
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.label = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_tileOption);
        parcel.writeInt(this.m_toggleOption);
        parcel.writeString(this.label);
        parcel.writeInt(this.iconRes);
        parcel.writeString(this.iconResName);
        parcel.writeInt(this.setToggleState ? 1 : 0);
        parcel.writeInt(this.setLabel ? 1 : 0);
        parcel.writeInt(this.setImage ? 1 : 0);
    }

    public SetQuickSettingsStateAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetQuickSettingsStateAction() {
        this.iconRef = null;
        this.selectedIconRes = this.iconRes;
        this.selectedIconResName = this.iconResName;
    }

    private SetQuickSettingsStateAction(Parcel parcel) {
        super(parcel);
        this.iconRef = null;
        this.selectedIconRes = this.iconRes;
        this.selectedIconResName = this.iconResName;
        this.m_tileOption = parcel.readInt();
        this.m_toggleOption = parcel.readInt();
        this.label = parcel.readString();
        this.iconRes = parcel.readInt();
        this.iconResName = parcel.readString();
        this.setToggleState = parcel.readInt() != 0;
        this.setLabel = parcel.readInt() != 0;
        this.setImage = parcel.readInt() != 0;
    }
}
