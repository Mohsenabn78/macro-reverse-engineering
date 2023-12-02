package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.NotificationAction;
import com.arlosoft.macrodroid.action.data.NotificationActionButton;
import com.arlosoft.macrodroid.action.info.NotificationActionInfo;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockConfigDialog;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockMacroAdapter;
import com.arlosoft.macrodroid.actionblock.common.RunnableItem;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.ReferenceSelfGUIDs;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.interfaces.UsesActionBlocks;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.notification.NotificationChannel;
import com.arlosoft.macrodroid.notification.NotificationChannelList;
import com.arlosoft.macrodroid.settings.EditNotificationChannelsActivity;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import com.google.android.material.textfield.TextInputLayout;
import com.thebluealliance.spectrum.SpectrumDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public class NotificationAction extends Action implements SupportsMagicText, UsesActionBlocks, ReferenceSelfGUIDs {
    public static final Parcelable.Creator<NotificationAction> CREATOR = new i();
    private static final int CUSTOM_CHANNEL = 2;
    private static final int HIGH_PRIORITY_CHANNEL = 1;
    private static final int ICON_TYPE_IMAGE = 0;
    private static final int ICON_TYPE_TEXT = 1;
    private static final int REQUEST_CODE_EDIT_NOTIFICATION_CHANNELS = 7823;
    private static final int REQUEST_CODE_ICON_SELECT = 7824;
    private static final int STANDARD_CHANNEL = 0;
    private static int notificationId = 20000000;
    private static int s_requestCodeStart = 385250;
    private ActionBlockData actionBlockData;
    protected boolean blockNextAction;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    transient NotificationChannelUtil f2314c;
    private transient Spinner channelSpinner;
    protected boolean disableHtml;
    private String iconText;
    private int iconType;
    private int m_iconBgColor;
    private transient ImageView m_iconImage;
    protected int m_imageResourceId;
    protected String m_imageResourceName;
    private long m_macroGUIDToRun;
    private int m_notificationChannelType;
    protected String m_notificationSubject;
    protected String m_notificationText;
    protected boolean m_overwriteExisting;
    private int m_priority;
    protected int m_ringtoneIndex;
    protected String m_ringtoneName;
    private boolean m_runMacroWhenPressed;
    protected boolean maintainSpaces;
    private ArrayList<NotificationActionButton> notificationActionButtons;
    private String notificationChannelName;
    protected boolean preventBackButtonClosing;
    private transient String tempNotificationChannelName;
    private transient ActionBlockData workingActionBlockData;
    private transient ArrayList<NotificationActionButton> workingNotificationActionButtons;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2315a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2316b;

        a(ViewGroup viewGroup, ViewGroup viewGroup2) {
            this.f2315a = viewGroup;
            this.f2316b = viewGroup2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            int i4;
            ViewGroup viewGroup = this.f2315a;
            int i5 = 0;
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            viewGroup.setVisibility(i4);
            ViewGroup viewGroup2 = this.f2316b;
            if (z3) {
                i5 = 8;
            }
            viewGroup2.setVisibility(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2318a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2319b;

        b(ViewGroup viewGroup, ViewGroup viewGroup2) {
            this.f2318a = viewGroup;
            this.f2319b = viewGroup2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            int i4;
            ViewGroup viewGroup = this.f2318a;
            int i5 = 8;
            if (z3) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            viewGroup.setVisibility(i4);
            ViewGroup viewGroup2 = this.f2319b;
            if (z3) {
                i5 = 0;
            }
            viewGroup2.setVisibility(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NotificationAction.this.getActivity().startActivityForResult(new Intent(NotificationAction.this.getActivity(), EditNotificationChannelsActivity.class), NotificationAction.REQUEST_CODE_EDIT_NOTIFICATION_CHANNELS);
        }
    }

    /* loaded from: classes2.dex */
    class i implements Parcelable.Creator<NotificationAction> {
        i() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NotificationAction createFromParcel(Parcel parcel) {
            return new NotificationAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NotificationAction[] newArray(int i4) {
            return new NotificationAction[i4];
        }
    }

    public NotificationAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_runMacroWhenPressed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(DialogInterface dialogInterface) {
        this.m_iconImage = null;
        this.channelSpinner = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(Activity activity, View view) {
        new SpectrumDialog.Builder(getContext()).setTitle(R.string.select_color).setColors(R.array.notification_colors).setSelectedColor(this.m_iconBgColor).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.action.vb
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                NotificationAction.this.y0(z3, i4);
            }
        }).build().show(((AppCompatActivity) activity).getSupportFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E0(Activity activity, View view) {
        if (activity != null) {
            Intent intent = new Intent(activity, IconSelectActivity.class);
            intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, false);
            activity.startActivityForResult(intent, REQUEST_CODE_ICON_SELECT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(Activity activity, AppCompatDialog appCompatDialog, LinearLayout linearLayout, List list, List list2, Button button, TextWatcher textWatcher, Button button2, View view) {
        NotificationActionButton notificationActionButton = new NotificationActionButton("", 0L, false, null);
        this.workingNotificationActionButtons.add(notificationActionButton);
        h0(activity, appCompatDialog.getContext(), linearLayout, this.workingNotificationActionButtons, notificationActionButton, list, list2, button, textWatcher);
        if (linearLayout.getChildCount() >= 3) {
            button.setVisibility(8);
        }
        button2.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(AppCompatDialog appCompatDialog, EditText editText, EditText editText2, CheckBox checkBox, CheckBox checkBox2, Spinner spinner, String[] strArr, Spinner spinner2, List list, Spinner spinner3, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, LinearLayout linearLayout, RadioButton radioButton, EditText editText3, View view) {
        appCompatDialog.dismiss();
        this.m_notificationText = editText.getText().toString();
        this.m_notificationSubject = editText2.getText().toString();
        this.m_overwriteExisting = checkBox.isChecked();
        this.m_runMacroWhenPressed = checkBox2.isChecked();
        int selectedItemPosition = spinner.getSelectedItemPosition();
        this.m_ringtoneIndex = selectedItemPosition;
        this.m_ringtoneName = strArr[selectedItemPosition];
        this.m_priority = ((spinner2.getAdapter().getCount() - 1) - spinner2.getSelectedItemPosition()) - 2;
        this.m_macroGUIDToRun = ((RunnableItem) list.get(spinner3.getSelectedItemPosition())).getGuid();
        int selectedItemPosition2 = this.channelSpinner.getSelectedItemPosition();
        this.m_notificationChannelType = selectedItemPosition2 < 2 ? selectedItemPosition2 : 2;
        Spinner spinner4 = this.channelSpinner;
        if (spinner4 != null) {
            this.notificationChannelName = (String) spinner4.getSelectedItem();
        }
        this.blockNextAction = checkBox3.isChecked();
        this.preventBackButtonClosing = checkBox4.isChecked();
        this.m_iconImage = null;
        this.channelSpinner = null;
        this.maintainSpaces = checkBox5.isChecked();
        this.actionBlockData = this.workingActionBlockData;
        this.disableHtml = !checkBox6.isChecked();
        this.notificationActionButtons = new ArrayList<>();
        for (int i4 = 0; i4 < linearLayout.getChildCount(); i4++) {
            View childAt = linearLayout.getChildAt(i4);
            this.notificationActionButtons.add(new NotificationActionButton(((TextView) childAt.findViewById(R.id.actionButtonLabel)).getText().toString(), ((RunnableItem) list.get(((Spinner) childAt.findViewById(R.id.macroSpinner)).getSelectedItemPosition())).getGuid(), ((CheckBox) childAt.findViewById(R.id.clearOnPress)).isChecked(), this.workingNotificationActionButtons.get(i4).getActionBlockData()));
        }
        this.iconType = !radioButton.isChecked();
        this.iconText = editText3.getText().toString();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(AppCompatDialog appCompatDialog, View view) {
        this.channelSpinner = null;
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    private void L0() {
        NotificationChannelList notificationChannelList = this.f2314c.getNotificationChannelList();
        ArrayList<NotificationChannel> arrayList = new ArrayList();
        arrayList.add(new NotificationChannel(SelectableItem.r(R.string.notification_channel_action), 3));
        arrayList.add(new NotificationChannel(SelectableItem.r(R.string.notification_channel_action_high_priority), 4));
        arrayList.addAll(notificationChannelList.getNotificationChannels());
        ArrayList arrayList2 = new ArrayList();
        for (NotificationChannel notificationChannel : arrayList) {
            arrayList2.add(notificationChannel.getChannelName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), (int) R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.channelSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.channelSpinner.setOnItemSelectedListener(new h(arrayList2));
        int i4 = this.m_notificationChannelType;
        if (i4 < 2) {
            this.channelSpinner.setSelection(i4);
        } else if (this.notificationChannelName != null) {
            int indexOf = arrayList2.indexOf(this.tempNotificationChannelName);
            if (indexOf < 0) {
                indexOf = arrayList2.indexOf(this.notificationChannelName);
            }
            if (indexOf >= 0) {
                this.channelSpinner.setSelection(indexOf);
            }
        } else {
            this.channelSpinner.setSelection(0);
        }
    }

    private void h0(final Activity activity, Context context, final LinearLayout linearLayout, final List<NotificationActionButton> list, final NotificationActionButton notificationActionButton, List<RunnableItem> list2, List<ActionBlock> list3, final Button button, TextWatcher textWatcher) {
        int i4 = 0;
        final View inflate = LayoutInflater.from(context).inflate(R.layout.include_notification_action_button, (ViewGroup) linearLayout, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.delete_button);
        final EditText editText = (EditText) inflate.findViewById(R.id.actionButtonLabel);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.macroSpinner);
        Button button2 = (Button) inflate.findViewById(R.id.configInputOutputParams);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.sb
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationAction.u0(editText, magicTextPair);
            }
        };
        ((Button) inflate.findViewById(R.id.actionButtonLabelMagicTextButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.tb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.this.v0(activity, magicTextListener, view);
            }
        });
        editText.setText(notificationActionButton.getLabel());
        linearLayout.addView(inflate);
        editText.addTextChangedListener(textWatcher);
        ((CheckBox) inflate.findViewById(R.id.clearOnPress)).setChecked(notificationActionButton.getClearOnPress());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ub
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.w0(linearLayout, inflate, button, list, notificationActionButton, view);
            }
        });
        spinner.setAdapter((SpinnerAdapter) new ActionBlockMacroAdapter(getActivity(), list2));
        spinner.setOnItemSelectedListener(new g(button2, list2, list3, notificationActionButton, activity));
        int i5 = 0;
        while (true) {
            if (i5 >= list2.size()) {
                break;
            } else if (notificationActionButton.getMacroGuid() == list2.get(i5).getGuid()) {
                list2.get(i5);
                i4 = i5;
                break;
            } else {
                i5++;
            }
        }
        spinner.setSelection(i4);
        list2.get(i4);
    }

    private void init() {
        MacroDroidApplication.appComponentInstance.inject(this);
    }

    private void l0() {
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        final Spinner spinner;
        CheckBox checkBox;
        int i9;
        CheckBox checkBox2;
        CheckBox checkBox3;
        Button button;
        boolean z5;
        int i10;
        int i11;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.configure_notification);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        EditText editText = (EditText) appCompatDialog.findViewById(R.id.configure_notification_notification_text);
        TextInputLayout textInputLayout = (TextInputLayout) appCompatDialog.findViewById(R.id.notification_text_input_layout);
        EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.configure_notification_subject_text);
        TextInputLayout textInputLayout2 = (TextInputLayout) appCompatDialog.findViewById(R.id.notification_subject_input_layout);
        CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.configure_notification_overwrite_checkbox);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.configure_notification_icon_background);
        Button button5 = (Button) appCompatDialog.findViewById(R.id.configure_notification_change_icon_button);
        Button button6 = (Button) appCompatDialog.findViewById(R.id.configure_notification_magic_subject_button);
        Button button7 = (Button) appCompatDialog.findViewById(R.id.configure_notification_magic_text_button);
        CheckBox checkBox5 = (CheckBox) appCompatDialog.findViewById(R.id.configure_notification_invoke_macro_checkbox);
        CheckBox checkBox6 = (CheckBox) appCompatDialog.findViewById(R.id.configure_notification_block_next_action);
        Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.configure_notification_invoke_macro_spinner);
        Button button8 = (Button) appCompatDialog.findViewById(R.id.configInputOutputParams);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.configure_notification_image_container);
        ViewGroup viewGroup2 = (ViewGroup) appCompatDialog.findViewById(R.id.notification_icon_text_layout);
        final Spinner spinner3 = (Spinner) appCompatDialog.findViewById(R.id.configure_notification_notification_sound);
        Spinner spinner4 = (Spinner) appCompatDialog.findViewById(R.id.configure_notification_priority_spinner);
        ViewGroup viewGroup3 = (ViewGroup) appCompatDialog.findViewById(R.id.notification_container);
        ViewGroup viewGroup4 = (ViewGroup) appCompatDialog.findViewById(R.id.sound_options_container);
        ViewGroup viewGroup5 = (ViewGroup) appCompatDialog.findViewById(R.id.notification_channel_container);
        this.channelSpinner = (Spinner) appCompatDialog.findViewById(R.id.notification_channels_spinner);
        Button button9 = (Button) appCompatDialog.findViewById(R.id.edit_notification_channels);
        Button button10 = (Button) appCompatDialog.findViewById(R.id.actionActionButtonButton);
        final LinearLayout linearLayout = (LinearLayout) appCompatDialog.findViewById(R.id.actionButtonsContainer);
        CheckBox checkBox7 = (CheckBox) appCompatDialog.findViewById(R.id.prevent_back_button_checkbox);
        ViewGroup viewGroup6 = (ViewGroup) appCompatDialog.findViewById(R.id.maintain_spaces_container);
        final CheckBox checkBox8 = (CheckBox) appCompatDialog.findViewById(R.id.html_check_box);
        CheckBox checkBox9 = (CheckBox) appCompatDialog.findViewById(R.id.maintain_spaces_checkbox);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.radio_button_use_icon);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.radio_button_use_text);
        final EditText editText3 = (EditText) appCompatDialog.findViewById(R.id.notification_icon_text);
        Button button11 = (Button) appCompatDialog.findViewById(R.id.notification_icon_text_magic_text_button);
        ViewGroup viewGroup7 = (ViewGroup) appCompatDialog.findViewById(R.id.icon_config_container);
        if (Build.VERSION.SDK_INT < 23) {
            ((RadioGroup) appCompatDialog.findViewById(R.id.icon_type_radio_group)).setVisibility(8);
            this.iconType = 0;
            this.iconText = "";
        }
        if (this.iconType == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton.setChecked(z3);
        if (this.iconType == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        radioButton2.setChecked(z4);
        radioButton.setOnCheckedChangeListener(new a(viewGroup, viewGroup2));
        radioButton2.setOnCheckedChangeListener(new b(viewGroup, viewGroup2));
        if (showIcon()) {
            viewGroup7.setVisibility(0);
            if (this.iconType == 0) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            viewGroup.setVisibility(i10);
            if (this.iconType == 1) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            viewGroup2.setVisibility(i11);
        } else {
            viewGroup7.setVisibility(8);
        }
        this.workingNotificationActionButtons.clear();
        for (int i12 = 0; i12 < this.notificationActionButtons.size(); i12++) {
            this.workingNotificationActionButtons.add(this.notificationActionButtons.get(i12));
        }
        if (k0()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        checkBox8.setVisibility(i4);
        checkBox8.setChecked(!this.disableHtml);
        if (k0()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        viewGroup6.setVisibility(i5);
        checkBox9.setChecked(this.maintainSpaces);
        if (N0()) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        viewGroup3.setVisibility(i6);
        if (O0()) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        viewGroup4.setVisibility(i7);
        if (M0()) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        viewGroup5.setVisibility(i8);
        List<String> ringtoneSounds = Util.getRingtoneSounds(getContext(), 2, false);
        ringtoneSounds.add(0, getContext().getString(R.string.none));
        ringtoneSounds.add(0, getContext().getString(R.string.notification_default));
        final String[] strArr = (String[]) ringtoneSounds.toArray(new String[0]);
        L0();
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, 17367048, strArr);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter((SpinnerAdapter) arrayAdapter);
        int i13 = this.m_ringtoneIndex;
        if (i13 < 2) {
            spinner3.setSelection(i13);
        } else {
            int i14 = 0;
            while (true) {
                if (i14 >= ringtoneSounds.size()) {
                    break;
                } else if (ringtoneSounds.get(i14).equals(this.m_ringtoneName)) {
                    spinner3.setSelection(i14);
                    break;
                } else {
                    i14++;
                }
            }
        }
        Spinner spinner5 = spinner4;
        spinner5.setSelection(((spinner4.getAdapter().getCount() - 1) - this.m_priority) - 2);
        spinner3.setOnItemSelectedListener(new c(activity));
        EditText editText4 = editText;
        editText4.setSingleLine(t0());
        if (!o0()) {
            checkBox = checkBox5;
            checkBox.setVisibility(8);
            spinner = spinner2;
            spinner.setVisibility(8);
        } else {
            spinner = spinner2;
            checkBox = checkBox5;
        }
        if (this.m_runMacroWhenPressed) {
            checkBox.setChecked(true);
            spinner.setEnabled(true);
        } else {
            checkBox.setChecked(false);
            spinner.setEnabled(false);
        }
        button9.setOnClickListener(new d());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.ob
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                spinner.setEnabled(z6);
            }
        });
        List<Macro> allCompletedMacrosExcludingOne = MacroStore.getInstance().getAllCompletedMacrosExcludingOne(getMacro(), true);
        List<ActionBlock> allActionBlocksSorted = p0().getAllActionBlocksSorted();
        final List<RunnableItem> arrayList = new ArrayList<>();
        final CheckBox checkBox10 = checkBox;
        arrayList.add(new RunnableItem("(" + getContext().getString(R.string.button_off) + ")", 0L, false));
        int i15 = 0;
        while (i15 < allActionBlocksSorted.size()) {
            ActionBlock actionBlock = allActionBlocksSorted.get(i15);
            arrayList.add(new RunnableItem(actionBlock.getName(), actionBlock.getGUID(), true));
            i15++;
            checkBox9 = checkBox9;
            spinner5 = spinner5;
        }
        final CheckBox checkBox11 = checkBox9;
        final Spinner spinner6 = spinner5;
        for (int i16 = 0; i16 < allCompletedMacrosExcludingOne.size(); i16++) {
            Macro macro = allCompletedMacrosExcludingOne.get(i16);
            arrayList.add(new RunnableItem(macro.getName(), macro.getGUID(), false));
        }
        if (!getMacro().isActionBlock) {
            arrayList.add(new RunnableItem(s0(), getMacro().getGUID(), false));
        }
        spinner.setAdapter((SpinnerAdapter) new ActionBlockMacroAdapter(getActivity(), arrayList));
        final Spinner spinner7 = spinner;
        List<ActionBlock> list = allActionBlocksSorted;
        CheckBox checkBox12 = checkBox4;
        spinner7.setOnItemSelectedListener(new e(button8, arrayList, allActionBlocksSorted, activity));
        int i17 = 0;
        while (true) {
            if (i17 < arrayList.size()) {
                if (this.m_macroGUIDToRun == arrayList.get(i17).getGuid()) {
                    break;
                }
                i17++;
            } else {
                i17 = 0;
                break;
            }
        }
        spinner7.setSelection(i17);
        ImageView imageView = (ImageView) appCompatDialog.findViewById(R.id.configure_notification_preview_image);
        this.m_iconImage = imageView;
        ((GradientDrawable) imageView.getBackground()).setColor(this.m_iconBgColor);
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.this.D0(activity, view);
            }
        });
        int resId = Util.getResId(getContext(), this.m_imageResourceName);
        if (resId == -1) {
            try {
                int i18 = this.m_imageResourceId;
                if (i18 > 0) {
                    this.m_iconImage.setImageResource(i18);
                } else {
                    this.m_iconImage.setImageResource(R.drawable.not_icon_setup);
                }
            } catch (Exception unused) {
                this.m_iconImage.setImageResource(R.drawable.not_icon_setup);
            }
        } else {
            this.m_iconImage.setImageResource(resId);
        }
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.E0(activity, view);
            }
        });
        textInputLayout.setHint(q0());
        textInputLayout2.setHint(r0());
        editText3.setText(this.iconText);
        String str = this.m_notificationText;
        if (str != null) {
            editText4.setText(str);
            editText4.setSelection(editText4.length());
        }
        String str2 = this.m_notificationSubject;
        EditText editText5 = editText2;
        if (str2 != null) {
            editText5.setText(str2);
            editText5.setSelection(editText5.length());
        }
        if (m0()) {
            checkBox12.setChecked(this.m_overwriteExisting);
            i9 = 8;
        } else {
            i9 = 8;
            checkBox12.setVisibility(8);
        }
        if (j0()) {
            checkBox2 = checkBox6;
            checkBox2.setChecked(this.blockNextAction);
        } else {
            checkBox2 = checkBox6;
            checkBox2.setVisibility(i9);
        }
        if (n0()) {
            checkBox3 = checkBox7;
            checkBox3.setChecked(this.preventBackButtonClosing);
        } else {
            checkBox3 = checkBox7;
            checkBox3.setVisibility(i9);
        }
        CheckBox checkBox13 = checkBox3;
        final TextWatcher fVar = new f(linearLayout, button2, editText4, editText5);
        editText4.addTextChangedListener(fVar);
        editText5.addTextChangedListener(fVar);
        int i19 = 0;
        while (i19 < this.notificationActionButtons.size()) {
            Context context = appCompatDialog.getContext();
            ArrayList<NotificationActionButton> arrayList2 = this.workingNotificationActionButtons;
            List<ActionBlock> list2 = list;
            h0(activity, context, linearLayout, arrayList2, arrayList2.get(i19), arrayList, list2, button10, fVar);
            i19++;
            editText4 = editText4;
            checkBox12 = checkBox12;
            checkBox2 = checkBox2;
            checkBox13 = checkBox13;
            editText5 = editText5;
            list = list2;
        }
        final CheckBox checkBox14 = checkBox12;
        final CheckBox checkBox15 = checkBox2;
        final EditText editText6 = editText5;
        final List<ActionBlock> list3 = list;
        final CheckBox checkBox16 = checkBox13;
        final EditText editText7 = editText4;
        if (linearLayout.getChildCount() < 3 && i0()) {
            button = button10;
        } else {
            button = button10;
            button.setVisibility(8);
        }
        final Button button12 = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.this.F0(activity, appCompatDialog, linearLayout, arrayList, list3, button12, fVar, button2, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.cc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.this.G0(appCompatDialog, editText7, editText6, checkBox14, checkBox10, spinner3, strArr, spinner6, arrayList, spinner7, checkBox15, checkBox16, checkBox11, checkBox8, linearLayout, radioButton, editText3, view);
            }
        });
        if (editText7.getText().length() > 0 && editText6.getText().length() > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        button2.setEnabled(z5);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.this.H0(appCompatDialog, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ec
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationAction.I0(editText6, magicTextPair);
            }
        };
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.this.J0(activity, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.qb
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationAction.K0(editText7, magicTextPair);
            }
        };
        button7.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.this.z0(activity, magicTextListener2, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener3 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.wb
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationAction.A0(editText3, magicTextPair);
            }
        };
        button11.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAction.this.B0(activity, magicTextListener3, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.yb
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                NotificationAction.this.C0(dialogInterface);
            }
        });
    }

    private ActionBlockStore p0() {
        return MacroStore.getInstance();
    }

    private final String s0() {
        return SelectableItem.r(R.string.constraint_last_run_time_this_macro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w0(LinearLayout linearLayout, View view, Button button, List list, NotificationActionButton notificationActionButton, View view2) {
        linearLayout.removeView(view);
        button.setVisibility(0);
        list.remove(notificationActionButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(boolean z3, int i4) {
        if (z3) {
            this.m_iconBgColor = i4;
            ((GradientDrawable) this.m_iconImage.getBackground()).setColor(this.m_iconBgColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    protected boolean M0() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    protected boolean N0() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return false;
    }

    protected boolean O0() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return false;
    }

    public ActionBlockData applyActionBlockLocalParams(ActionBlockData actionBlockData, TriggerContextInfo triggerContextInfo) {
        HashMap hashMap = new HashMap(actionBlockData.getInputVarsMap());
        for (String str : hashMap.keySet()) {
            if (((String) hashMap.get(str)).contains("lv=")) {
                hashMap.put(str, MagicText.replaceMagicText(MacroDroidApplication.getInstance(), (String) hashMap.get(str), triggerContextInfo, getMacro()));
            }
        }
        return new ActionBlockData(actionBlockData.getActionBlockName(), actionBlockData.getActionBlockGuid(), hashMap, actionBlockData.getOutputVarsMap());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:2|3|(1:5)|(1:7)(1:44)|8|(7:13|14|(6:17|(1:19)|20|(2:22|23)(1:25)|24|15)|26|(1:28)(1:33)|29|31)|34|(1:36)|37|38|(1:40)|41|14|(1:15)|26|(0)(0)|29|31) */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6 A[Catch: Exception -> 0x012f, TryCatch #0 {Exception -> 0x012f, blocks: (B:3:0x000f, B:5:0x0019, B:7:0x001e, B:9:0x002d, B:11:0x007c, B:14:0x0083, B:24:0x00aa, B:25:0x00b0, B:27:0x00b6, B:29:0x00df, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x011b, B:37:0x0123, B:36:0x011f, B:19:0x009b, B:23:0x00a7), top: B:43:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011b A[Catch: Exception -> 0x012f, TryCatch #0 {Exception -> 0x012f, blocks: (B:3:0x000f, B:5:0x0019, B:7:0x001e, B:9:0x002d, B:11:0x007c, B:14:0x0083, B:24:0x00aa, B:25:0x00b0, B:27:0x00b6, B:29:0x00df, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x011b, B:37:0x0123, B:36:0x011f, B:19:0x009b, B:23:0x00a7), top: B:43:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011f A[Catch: Exception -> 0x012f, TryCatch #0 {Exception -> 0x012f, blocks: (B:3:0x000f, B:5:0x0019, B:7:0x001e, B:9:0x002d, B:11:0x007c, B:14:0x0083, B:24:0x00aa, B:25:0x00b0, B:27:0x00b6, B:29:0x00df, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x011b, B:37:0x0123, B:36:0x011f, B:19:0x009b, B:23:0x00a7), top: B:43:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void displayNotification(android.content.Context r14, com.arlosoft.macrodroid.triggers.TriggerContextInfo r15, java.lang.String r16, java.lang.String r17, boolean r18, int r19, java.lang.String r20, android.app.PendingIntent r21, int r22, android.net.Uri r23, int r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.NotificationAction.displayNotification(android.content.Context, com.arlosoft.macrodroid.triggers.TriggerContextInfo, java.lang.String, java.lang.String, boolean, int, java.lang.String, android.app.PendingIntent, int, android.net.Uri, int, java.lang.String):void");
    }

    @Override // com.arlosoft.macrodroid.interfaces.UsesActionBlocks
    @NonNull
    public List<String> getActionBlockNames() {
        ArrayList arrayList = new ArrayList();
        List<ActionBlock> allActionBlocks = p0().getAllActionBlocks();
        if (this.m_macroGUIDToRun != 0) {
            Iterator<ActionBlock> it = allActionBlocks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActionBlock next = it.next();
                if (next.getGUID() == this.m_macroGUIDToRun) {
                    arrayList.add(next.getName());
                    break;
                }
            }
        }
        Iterator<NotificationActionButton> it2 = this.notificationActionButtons.iterator();
        while (it2.hasNext()) {
            NotificationActionButton next2 = it2.next();
            Iterator<ActionBlock> it3 = allActionBlocks.iterator();
            while (true) {
                if (it3.hasNext()) {
                    ActionBlock next3 = it3.next();
                    if (next3.getGUID() == next2.getMacroGuid()) {
                        arrayList.add(next3.getName());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_notificationText;
    }

    @Override // com.arlosoft.macrodroid.interfaces.ReferenceSelfGUIDs
    @NonNull
    public ArrayList<Long> getGUIDs() {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(this.m_macroGUIDToRun));
        Iterator<NotificationActionButton> it = this.notificationActionButtons.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getMacroGuid()));
        }
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return NotificationActionInfo.getInstance();
    }

    public String[] getPossibleMagicText() {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.iconText);
        arrayList.add(this.m_notificationText);
        arrayList.add(this.m_notificationSubject);
        Iterator<NotificationActionButton> it = this.notificationActionButtons.iterator();
        while (it.hasNext()) {
            NotificationActionButton next = it.next();
            arrayList.add(next.getLabel());
            if (next.getActionBlockData() != null) {
                HashMap<String, String> inputVarsMap = next.getActionBlockData().getInputVarsMap();
                for (String str2 : inputVarsMap.keySet()) {
                    if (inputVarsMap.get(str2) == null) {
                        str = "";
                    } else {
                        str = inputVarsMap.get(str2);
                    }
                    arrayList.add(str);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        String str = this.m_notificationSubject;
        if (str.length() > 2000) {
            str = str.substring(0, 2000);
        }
        String str2 = this.m_notificationText;
        if (str2.length() > 2000) {
            str2 = str2.substring(0, 2000);
        }
        return getName() + ": " + g(str, triggerContextInfo) + " / " + g(str2, triggerContextInfo);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == REQUEST_CODE_EDIT_NOTIFICATION_CHANNELS) {
            L0();
        } else if (i4 == REQUEST_CODE_ICON_SELECT && i5 != 0 && this.m_iconImage != null) {
            this.m_imageResourceId = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
            String stringExtra = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.m_imageResourceName = stringExtra;
            if (stringExtra != null) {
                if (this.m_iconImage != null) {
                    this.m_iconImage.setImageResource(Util.getResId(getContext(), this.m_imageResourceName));
                    return;
                }
                return;
            }
            int i6 = this.m_imageResourceId;
            if (i6 > 0) {
                this.m_iconImage.setImageResource(i6);
                this.m_imageResourceName = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        l0();
    }

    protected boolean i0() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo r23) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.NotificationAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    protected boolean j0() {
        return false;
    }

    protected boolean k0() {
        return false;
    }

    protected boolean m0() {
        return true;
    }

    protected boolean n0() {
        return false;
    }

    protected boolean o0() {
        return true;
    }

    protected String q0() {
        return SelectableItem.r(R.string.notification_text);
    }

    protected String r0() {
        return SelectableItem.r(R.string.title);
    }

    @Override // com.arlosoft.macrodroid.interfaces.ReferenceSelfGUIDs
    public void setGUIDs(@NonNull ArrayList<Long> arrayList) {
        this.m_macroGUIDToRun = arrayList.get(0).longValue();
        ArrayList<NotificationActionButton> arrayList2 = new ArrayList<>();
        Iterator<NotificationActionButton> it = this.notificationActionButtons.iterator();
        int i4 = 1;
        while (it.hasNext()) {
            NotificationActionButton next = it.next();
            arrayList2.add(next.copy(next.getLabel(), arrayList.get(i4).longValue(), next.getClearOnPress(), next.getActionBlockData()));
            i4++;
        }
        this.notificationActionButtons = arrayList2;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void setMacro(Macro macro, @Nullable Macro macro2, boolean z3) {
        if (macro != null) {
            if (macro2 != null) {
                if (!z3 && macro2.getGUID() == this.m_macroGUIDToRun) {
                    this.m_macroGUIDToRun = macro.getGUID();
                }
                Iterator<NotificationActionButton> it = this.notificationActionButtons.iterator();
                while (it.hasNext()) {
                    NotificationActionButton next = it.next();
                    if (!z3 && macro2.getGUID() == next.getMacroGuid()) {
                        next.setMacroGuid(macro.getGUID());
                    }
                }
            }
            super.setMacro(macro);
        }
    }

    public boolean setNotificationChannelRenamed(String str, String str2) {
        String str3 = this.notificationChannelName;
        if (str3 != null && str3.equals(str)) {
            this.notificationChannelName = str2;
            return true;
        }
        String str4 = this.tempNotificationChannelName;
        if (str4 != null && str4.equals(str)) {
            this.tempNotificationChannelName = str2;
        }
        return false;
    }

    public void setPossibleMagicText(String[] strArr) {
        String str;
        this.iconText = strArr[0];
        this.m_notificationText = strArr[1];
        this.m_notificationSubject = strArr[2];
        Iterator<NotificationActionButton> it = this.notificationActionButtons.iterator();
        int i4 = 3;
        while (it.hasNext()) {
            NotificationActionButton next = it.next();
            next.setLabel(strArr[i4]);
            i4++;
            if (next.getActionBlockData() != null) {
                HashMap<String, String> inputVarsMap = next.getActionBlockData().getInputVarsMap();
                for (String str2 : inputVarsMap.keySet()) {
                    if (strArr[i4].equals("")) {
                        str = null;
                    } else {
                        str = strArr[i4];
                    }
                    inputVarsMap.put(str2, str);
                    i4++;
                }
            }
        }
    }

    public boolean showIcon() {
        return true;
    }

    protected boolean t0() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_notificationText);
        parcel.writeInt(!this.m_overwriteExisting ? 1 : 0);
        parcel.writeString(this.m_notificationSubject);
        parcel.writeString(this.m_imageResourceName);
        parcel.writeInt(!this.m_runMacroWhenPressed ? 1 : 0);
        parcel.writeLong(this.m_macroGUIDToRun);
        parcel.writeParcelable(this.actionBlockData, i4);
        parcel.writeInt(this.m_imageResourceId);
        parcel.writeInt(this.m_iconBgColor);
        parcel.writeString(this.m_ringtoneName);
        parcel.writeInt(this.m_ringtoneIndex);
        parcel.writeInt(this.m_priority);
        parcel.writeInt(this.m_notificationChannelType);
        parcel.writeString(this.notificationChannelName);
        NotificationActionButton[] notificationActionButtonArr = new NotificationActionButton[this.notificationActionButtons.size()];
        this.notificationActionButtons.toArray(notificationActionButtonArr);
        parcel.writeParcelableArray(notificationActionButtonArr, i4);
        parcel.writeInt(this.iconType);
        parcel.writeString(this.iconText);
        parcel.writeInt(this.disableHtml ? 1 : 0);
    }

    public NotificationAction() {
        this.blockNextAction = false;
        this.preventBackButtonClosing = false;
        this.disableHtml = false;
        this.iconType = 0;
        this.iconText = "";
        this.notificationActionButtons = new ArrayList<>();
        this.workingNotificationActionButtons = new ArrayList<>();
        init();
        this.m_iconBgColor = ContextCompat.getColor(getContext(), R.color.md_red_500);
    }

    public NotificationAction(Parcel parcel) {
        super(parcel);
        this.blockNextAction = false;
        this.preventBackButtonClosing = false;
        this.disableHtml = false;
        this.iconType = 0;
        this.iconText = "";
        this.notificationActionButtons = new ArrayList<>();
        this.workingNotificationActionButtons = new ArrayList<>();
        init();
        this.m_notificationText = parcel.readString();
        this.m_overwriteExisting = parcel.readInt() == 0;
        this.m_notificationSubject = parcel.readString();
        this.m_imageResourceName = parcel.readString();
        this.m_runMacroWhenPressed = parcel.readInt() == 0;
        this.m_macroGUIDToRun = parcel.readLong();
        this.actionBlockData = (ActionBlockData) parcel.readParcelable(ActionBlockData.class.getClassLoader());
        this.m_imageResourceId = parcel.readInt();
        this.m_iconBgColor = parcel.readInt();
        this.m_ringtoneName = parcel.readString();
        this.m_ringtoneIndex = parcel.readInt();
        this.m_priority = parcel.readInt();
        this.m_notificationChannelType = parcel.readInt();
        this.notificationChannelName = parcel.readString();
        this.notificationActionButtons = new ArrayList<>();
        Parcelable[] readParcelableArray = parcel.readParcelableArray(NotificationActionButton.class.getClassLoader());
        if (readParcelableArray != null) {
            Collections.addAll(this.notificationActionButtons, (NotificationActionButton[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, NotificationActionButton[].class));
        }
        this.iconType = parcel.readInt();
        this.iconText = parcel.readString();
        this.disableHtml = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2321a = true;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f2322b;

        c(Activity activity) {
            this.f2322b = activity;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (!this.f2321a) {
                if (i4 > 1) {
                    Util.playRingtone(this.f2322b, i4 - 2, 2, 5);
                    return;
                }
                return;
            }
            this.f2321a = false;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2325a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f2326b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f2327c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f2328d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Function1<ActionBlockData, Unit> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Unit invoke(ActionBlockData actionBlockData) {
                NotificationAction.this.workingActionBlockData = actionBlockData;
                return null;
            }
        }

        e(Button button, List list, List list2, Activity activity) {
            this.f2325a = button;
            this.f2326b = list;
            this.f2327c = list2;
            this.f2328d = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Activity activity, ActionBlock actionBlock, View view) {
            ActionBlockConfigDialog.displayConfigurationDialog(activity, actionBlock, NotificationAction.this.workingActionBlockData, NotificationAction.this, new a());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            final ActionBlock actionBlock;
            ActionBlockData actionBlockData;
            Button button = this.f2325a;
            if (((RunnableItem) this.f2326b.get(i4)).isActionBlock()) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            button.setVisibility(i5);
            if (i4 > 0 && i4 <= this.f2327c.size()) {
                actionBlock = (ActionBlock) this.f2327c.get(i4 - 1);
            } else {
                actionBlock = null;
            }
            if (actionBlock != null) {
                NotificationAction notificationAction = NotificationAction.this;
                if (notificationAction.actionBlockData != null) {
                    actionBlockData = NotificationAction.this.actionBlockData;
                } else {
                    actionBlockData = new ActionBlockData(actionBlock.getName(), actionBlock.getGUID(), new HashMap(), new HashMap());
                }
                notificationAction.workingActionBlockData = actionBlockData;
                Button button2 = this.f2325a;
                final Activity activity = this.f2328d;
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NotificationAction.e.this.b(activity, actionBlock, view2);
                    }
                });
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2336a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f2337b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f2338c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ NotificationActionButton f2339d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Activity f2340e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Function1<ActionBlockData, Unit> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ NotificationActionButton f2342a;

            a(NotificationActionButton notificationActionButton) {
                this.f2342a = notificationActionButton;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Unit invoke(ActionBlockData actionBlockData) {
                this.f2342a.setActionBlockData(actionBlockData);
                return null;
            }
        }

        g(Button button, List list, List list2, NotificationActionButton notificationActionButton, Activity activity) {
            this.f2336a = button;
            this.f2337b = list;
            this.f2338c = list2;
            this.f2339d = notificationActionButton;
            this.f2340e = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Activity activity, ActionBlock actionBlock, ActionBlockData actionBlockData, NotificationActionButton notificationActionButton, View view) {
            ActionBlockConfigDialog.displayConfigurationDialog(activity, actionBlock, actionBlockData, NotificationAction.this, new a(notificationActionButton));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            ActionBlock actionBlock;
            final ActionBlockData actionBlockData;
            Button button = this.f2336a;
            if (((RunnableItem) this.f2337b.get(i4)).isActionBlock()) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            button.setVisibility(i5);
            if (i4 > 0 && i4 <= this.f2338c.size()) {
                actionBlock = (ActionBlock) this.f2338c.get(i4 - 1);
            } else {
                actionBlock = null;
            }
            final ActionBlock actionBlock2 = actionBlock;
            if (actionBlock2 != null) {
                if (this.f2339d.getActionBlockData() != null) {
                    actionBlockData = this.f2339d.getActionBlockData();
                } else {
                    actionBlockData = new ActionBlockData(actionBlock2.getName(), actionBlock2.getGUID(), new HashMap(), new HashMap());
                }
                this.f2339d.setActionBlockData(actionBlockData);
                Button button2 = this.f2336a;
                final Activity activity = this.f2340e;
                final NotificationActionButton notificationActionButton = this.f2339d;
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NotificationAction.g.this.b(activity, actionBlock2, actionBlockData, notificationActionButton, view2);
                    }
                });
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f2344a;

        h(List list) {
            this.f2344a = list;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            NotificationAction.this.tempNotificationChannelName = (String) this.f2344a.get(i4);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayout f2331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f2332b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2333c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f2334d;

        f(LinearLayout linearLayout, Button button, EditText editText, EditText editText2) {
            this.f2331a = linearLayout;
            this.f2332b = button;
            this.f2333c = editText;
            this.f2334d = editText2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            boolean z4 = false;
            int i4 = 0;
            while (true) {
                if (i4 < this.f2331a.getChildCount()) {
                    if (TextUtils.isEmpty(((TextView) this.f2331a.getChildAt(i4).findViewById(R.id.actionButtonLabel)).getText().toString())) {
                        z3 = false;
                        break;
                    }
                    i4++;
                } else {
                    z3 = true;
                    break;
                }
            }
            Button button = this.f2332b;
            if (z3 && this.f2333c.getText().length() > 0 && this.f2334d.getText().length() > 0) {
                z4 = true;
            }
            button.setEnabled(z4);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
