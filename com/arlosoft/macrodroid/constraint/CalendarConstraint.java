package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.calendar.CalendarArrayAdapter;
import com.arlosoft.macrodroid.calendar.CalendarInfo;
import com.arlosoft.macrodroid.common.CalendarEvent;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.CalendarConstraintInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;
import java.util.Date;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class CalendarConstraint extends Constraint implements SupportsMagicText {
    public static final Parcelable.Creator<CalendarConstraint> CREATOR = new c();
    private String calendarAccount;
    private boolean enableRegex;
    private boolean ignoreCase;
    private int m_availability;
    private String m_calendarId;
    private String m_calendarName;
    private String m_detailText;
    private boolean m_entrySet;
    private boolean m_ignoreAllDay;
    private String m_titleText;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CheckBox f10167a;

        a(CheckBox checkBox) {
            this.f10167a = checkBox;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            this.f10167a.setEnabled(!z3);
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<CalendarConstraint> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CalendarConstraint createFromParcel(Parcel parcel) {
            return new CalendarConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CalendarConstraint[] newArray(int i4) {
            return new CalendarConstraint[i4];
        }
    }

    /* synthetic */ CalendarConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Y() {
        String str;
        Pair<String, List<CalendarInfo>> allCalendars = CalendarInfo.getAllCalendars(getContext());
        String str2 = allCalendars.first;
        List<CalendarInfo> list = allCalendars.second;
        if (list.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) getContext().getString(R.string.action_add_calendar_event_no_calendars), 1).show();
            return;
        }
        if (this.m_calendarId == null) {
            this.m_calendarId = str2;
        }
        int i4 = 0;
        while (true) {
            if (i4 < list.size()) {
                if (list.get(i4).id.equals(this.m_calendarId) && ((str = this.calendarAccount) == null || str.equals(list.get(i4).ownerAccount))) {
                    break;
                }
                i4++;
            } else {
                i4 = 0;
                break;
            }
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.calendar_configure);
        appCompatDialog.setTitle(getContext().getString(R.string.constraint_calendar_select_option));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.calendar_configure_title);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.calendar_configure_detail);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.calendar_configure_title_magic_text);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.calendar_configure_detail_magic_text);
        Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.calendar_configure_spinner);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.calendar_configure_in_event);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.calendar_configure_not_in_event);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.calendar_configure_availability_spinner);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.select_calendar_spinner);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.ignore_case);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.enable_regex);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.ignore_all_day);
        checkBox3.setChecked(this.m_ignoreAllDay);
        ((CheckBox) appCompatDialog.findViewById(R.id.check_in_advance)).setVisibility(8);
        ((CheckBox) appCompatDialog.findViewById(R.id.use_alarm)).setVisibility(8);
        ((TextView) appCompatDialog.findViewById(R.id.use_alarm_description)).setVisibility(8);
        spinner2.setSelection(this.m_availability);
        if (list.size() > 1) {
            spinner.setVisibility(0);
            CalendarArrayAdapter calendarArrayAdapter = new CalendarArrayAdapter(activity, list);
            calendarArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) calendarArrayAdapter);
            spinner.setSelection(i4);
        } else {
            spinner.setVisibility(8);
            textView.setVisibility(8);
        }
        radioButton.setChecked(this.m_entrySet);
        radioButton2.setChecked(!this.m_entrySet);
        checkBox.setEnabled(!this.enableRegex);
        checkBox.setChecked(this.ignoreCase);
        checkBox2.setChecked(this.enableRegex);
        checkBox2.setOnCheckedChangeListener(new a(checkBox));
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.y
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                CalendarConstraint.this.Z(compoundButton, z3);
            }
        });
        spinner.setOnItemSelectedListener(new b(list));
        String str3 = this.m_titleText;
        if (str3 != null) {
            editText.setText(str3);
            editText.setSelection(editText.length());
        }
        String str4 = this.m_detailText;
        if (str4 != null) {
            editText2.setText(str4);
            editText2.setSelection(editText2.length());
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalendarConstraint.this.a0(appCompatDialog, editText, editText2, spinner2, checkBox3, checkBox2, checkBox, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.b0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CalendarConstraint.c0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalendarConstraint.this.d0(activity, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.d0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CalendarConstraint.e0(editText2, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalendarConstraint.this.f0(activity, magicTextListener2, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(CompoundButton compoundButton, boolean z3) {
        this.m_entrySet = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(AppCompatDialog appCompatDialog, EditText editText, EditText editText2, Spinner spinner, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, View view) {
        appCompatDialog.cancel();
        this.m_titleText = editText.getText().toString();
        this.m_detailText = editText2.getText().toString();
        this.m_availability = spinner.getSelectedItemPosition();
        this.m_ignoreAllDay = checkBox.isChecked();
        this.enableRegex = checkBox2.isChecked();
        this.ignoreCase = checkBox3.isChecked();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), getDialogTheme(), isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), getDialogTheme(), isChildOfIterateDictionary());
    }

    private static CalendarEvent g0(Cursor cursor) {
        return new CalendarEvent(cursor.getString(0), cursor.getString(1), new Date(cursor.getLong(2)), new Date(cursor.getLong(3)), !cursor.getString(4).equals("0"), cursor.getInt(5), cursor.getString(6), cursor.getString(7));
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0186, code lost:
        if (com.arlosoft.macrodroid.utils.WildCardHelper.matches(r6.getDetail(), r8, r19.enableRegex, r19.ignoreCase) == false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0194 A[EDGE_INSN: B:66:0x0194->B:59:0x0194 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean h0(boolean r20, com.arlosoft.macrodroid.triggers.TriggerContextInfo r21) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.CalendarConstraint.h0(boolean, com.arlosoft.macrodroid.triggers.TriggerContextInfo):boolean");
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_CALENDAR") != 0) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_CALENDAR", getName(), true, false);
            return false;
        }
        boolean h02 = h0(false, triggerContextInfo);
        if (h02) {
            if (h02 == this.m_entrySet) {
                return true;
            }
            return false;
        } else if (!this.m_ignoreAllDay) {
            if (h0(true, triggerContextInfo) == this.m_entrySet) {
                return true;
            }
            return false;
        } else if (h02 == this.m_entrySet) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean checkOnImport() {
        if (!isValid()) {
            this.m_calendarId = "";
            this.m_calendarName = "";
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4;
        if (TextUtils.isEmpty(this.m_calendarId)) {
            return "[" + SelectableItem.r(R.string.select_calendar) + "]";
        }
        StringBuilder sb = new StringBuilder();
        if (this.m_entrySet) {
            i4 = R.string.constraint_calendar_in_event;
        } else {
            i4 = R.string.constraint_calendar_not_in_event;
        }
        sb.append(SelectableItem.r(i4));
        sb.append(": ");
        sb.append("(");
        sb.append(getContext().getResources().getStringArray(R.array.availability_options)[this.m_availability]);
        sb.append(")");
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.m_titleText);
        if (!TextUtils.isEmpty(this.m_calendarName)) {
            sb.append(" [");
            sb.append(this.m_calendarName);
            sb.append("]");
        }
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CalendarConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String str;
        if (!TextUtils.isEmpty(this.m_titleText)) {
            str = this.m_titleText;
        } else {
            str = this.m_detailText;
        }
        if (TextUtils.isEmpty(str)) {
            return getConfiguredName();
        }
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(str, 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_CALENDAR"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_titleText, this.m_detailText};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        String str;
        if (!TextUtils.isEmpty(this.m_titleText)) {
            str = this.m_titleText;
        } else {
            str = this.m_detailText;
        }
        if (TextUtils.isEmpty(str)) {
            return getConfiguredName();
        }
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(str, 200) + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Y();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        Cursor query;
        String str;
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_CALENDAR") != 0 || (query = getContext().getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), new String[]{Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID, "calendar_displayName", "account_name"}, null, null, null)) == null) {
            return true;
        }
        if (!TextUtils.isEmpty(this.m_calendarName)) {
            while (query.moveToNext()) {
                String string = query.getString(0);
                String string2 = query.getString(1);
                String string3 = query.getString(2);
                if (string2 != null && string2.equals(this.m_calendarName) && ((str = this.calendarAccount) == null || str.equals(string3))) {
                    this.m_calendarId = string;
                    query.close();
                    return true;
                }
            }
            this.m_calendarId = "";
            this.m_calendarName = "";
            query.close();
            return false;
        }
        while (query.moveToNext()) {
            String string4 = query.getString(0);
            String string5 = query.getString(1);
            if (this.m_calendarId.equals(string4)) {
                this.m_calendarName = string5;
                query.close();
                return true;
            }
        }
        this.m_calendarId = "";
        this.m_calendarName = "";
        query.close();
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_titleText = strArr[0];
            this.m_detailText = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.calendarAccount);
        parcel.writeString(this.m_calendarId);
        parcel.writeString(this.m_calendarName);
        parcel.writeInt(this.m_entrySet ? 1 : 0);
        parcel.writeString(this.m_titleText);
        parcel.writeString(this.m_detailText);
        parcel.writeInt(this.m_availability);
        parcel.writeInt(this.m_ignoreAllDay ? 1 : 0);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public CalendarConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private CalendarConstraint() {
        this.ignoreCase = true;
        this.m_entrySet = true;
    }

    private CalendarConstraint(Parcel parcel) {
        super(parcel);
        this.ignoreCase = true;
        this.calendarAccount = parcel.readString();
        this.m_calendarId = parcel.readString();
        this.m_calendarName = parcel.readString();
        this.m_entrySet = parcel.readInt() != 0;
        this.m_titleText = parcel.readString();
        this.m_detailText = parcel.readString();
        this.m_availability = parcel.readInt();
        this.m_ignoreAllDay = parcel.readInt() != 0;
        this.enableRegex = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f10169a;

        b(List list) {
            this.f10169a = list;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            CalendarConstraint.this.m_calendarId = ((CalendarInfo) this.f10169a.get(i4)).id;
            CalendarConstraint.this.m_calendarName = ((CalendarInfo) this.f10169a.get(i4)).name;
            CalendarConstraint.this.calendarAccount = ((CalendarInfo) this.f10169a.get(i4)).ownerAccount;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
