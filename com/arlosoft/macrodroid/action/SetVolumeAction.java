package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.SetVolumeAction;
import com.arlosoft.macrodroid.action.activities.SetVolumeActivity;
import com.arlosoft.macrodroid.action.info.SetVolumeActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.BluetoothTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetVolumeAction extends Action implements HasVariables, HasMultipleDictionaryKeys {
    public static final int MAX_AUDIO_LEVEL = 100;
    private static final int NO_VOLUME_VALUE = -1;
    private boolean m_forceVibrateOff;
    private boolean[] m_streamIndexArray;
    private int[] m_streamVolumeArray;
    private MacroDroidVariable[] m_variables;
    private int m_volume;
    private boolean setInForeground;
    private DictionaryKeys[] varDictionaryKeys;
    public static final int[] s_streamConstants = {4, 3, 5, 2, 1, 0, 6, 10};
    public static final Parcelable.Creator<SetVolumeAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetVolumeAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetVolumeAction createFromParcel(Parcel parcel) {
            return new SetVolumeAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetVolumeAction[] newArray(int i4) {
            return new SetVolumeAction[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        CheckBox f2551a;

        /* renamed from: b  reason: collision with root package name */
        Spinner f2552b;

        /* renamed from: c  reason: collision with root package name */
        SeekBar f2553c;

        /* renamed from: d  reason: collision with root package name */
        TextView f2554d;

        b() {
        }
    }

    /* synthetic */ SetVolumeAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void S() {
        int[] iArr = s_streamConstants;
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        if (this.m_streamIndexArray.length > iArr.length) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                boolean[] zArr2 = this.m_streamIndexArray;
                if (i4 < zArr2.length) {
                    if (i4 != 3) {
                        zArr[i5] = zArr2[i4];
                        i5++;
                    }
                    i4++;
                } else {
                    boolean[] zArr3 = new boolean[s_streamConstants.length];
                    this.m_streamIndexArray = zArr3;
                    System.arraycopy(zArr, 0, zArr3, 0, length);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public void W(TriggerContextInfo triggerContextInfo) {
        int[] iArr;
        int streamMaxVolume;
        double d4;
        MacroDroidVariable macroDroidVariable;
        ArrayList<String> arrayList;
        Long longValue;
        if (this.setInForeground) {
            SetVolumeActivity.invoke(getContext(), this.m_streamIndexArray, this.m_streamVolumeArray, this.m_variables, this.varDictionaryKeys, getMacroGuid().longValue());
            return;
        }
        String[] audioStreams = getAudioStreams();
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.m_volume != -1) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.m_streamVolumeArray;
                if (i4 >= iArr2.length) {
                    break;
                }
                iArr2[i4] = this.m_volume;
                i4++;
            }
            this.m_volume = -1;
        }
        int i5 = 0;
        while (true) {
            boolean[] zArr = this.m_streamIndexArray;
            if (i5 < zArr.length) {
                if (zArr[i5]) {
                    try {
                        iArr = s_streamConstants;
                        streamMaxVolume = audioManager.getStreamMaxVolume(iArr[i5]);
                        if (streamMaxVolume == 0) {
                            SystemLog.logError("Max volume for " + audioStreams[i5] + " is zero", getMacroGuid().longValue());
                            d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        } else {
                            d4 = 100 / streamMaxVolume;
                        }
                        macroDroidVariable = this.m_variables[i5];
                    } catch (Exception e4) {
                        e = e4;
                    }
                    if (macroDroidVariable != null) {
                        MacroDroidVariable variableByName = getVariableByName(macroDroidVariable.getName());
                        if (variableByName != null) {
                            if (this.varDictionaryKeys[i5] != null) {
                                try {
                                    arrayList = VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.varDictionaryKeys[i5].getKeys(), triggerContextInfo, getMacro());
                                } catch (Exception e5) {
                                    e = e5;
                                    SystemLog.logError("Set volume failed for channel " + getAudioStreams()[i5] + ": " + e.toString(), getMacroGuid().longValue());
                                    i5++;
                                }
                            } else {
                                arrayList = null;
                            }
                            if (variableByName.getLongValue(arrayList) != null) {
                                try {
                                    audioManager.setStreamVolume(iArr[i5], (int) (((streamMaxVolume * longValue.longValue()) + (d4 / 2.0d)) / 100.0d), 0);
                                } catch (Exception e6) {
                                    SystemLog.logError("Set volume failed: " + e6.toString(), getMacroGuid().longValue());
                                }
                            } else {
                                SystemLog.logError("Set volume failed, variable not found: " + this.m_variables[i5].getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys[i5]), getMacroGuid().longValue());
                            }
                        } else {
                            SystemLog.logError("Set volume failed, variable not found: " + this.m_variables[i5].getName(), getMacroGuid().longValue());
                        }
                    } else {
                        try {
                        } catch (Exception e7) {
                            e = e7;
                        }
                        try {
                            audioManager.setStreamVolume(iArr[i5], (int) (((streamMaxVolume * this.m_streamVolumeArray[i5]) + (d4 / 2.0d)) / 100.0d), 0);
                        } catch (Exception e8) {
                            e = e8;
                            try {
                                SystemLog.logError("Set volume failed: " + e.toString(), getMacroGuid().longValue());
                            } catch (Exception e9) {
                                e = e9;
                                SystemLog.logError("Set volume failed for channel " + getAudioStreams()[i5] + ": " + e.toString(), getMacroGuid().longValue());
                                i5++;
                            }
                            i5++;
                        }
                        i5++;
                    }
                }
                i5++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(c cVar, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        boolean[] e4 = cVar.e();
        int[] g4 = cVar.g();
        MacroDroidVariable[] f4 = cVar.f();
        this.setInForeground = checkBox.isChecked();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_streamIndexArray;
            if (i4 < zArr.length) {
                zArr[i4] = e4[i4];
                this.m_streamVolumeArray[i4] = g4[i4];
                this.m_variables[i4] = f4[i4];
                i4++;
            } else {
                appCompatDialog.dismiss();
                itemComplete();
                return;
            }
        }
    }

    public static String[] getAudioStreams() {
        return new String[]{SelectableItem.r(R.string.action_set_volume_alarm), SelectableItem.r(R.string.action_set_volume_music), SelectableItem.r(R.string.action_set_volume_notification), SelectableItem.r(R.string.action_set_volume_ringer), SelectableItem.r(R.string.action_set_volume_system_sounds), SelectableItem.r(R.string.action_set_volume_voice_call), SelectableItem.r(R.string.action_set_volume_bluetooth_voice), SelectableItem.r(R.string.action_set_volume_accessibility_channel)};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys
    @NonNull
    public DictionaryKeys[] getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String[] audioStreams = getAudioStreams();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_streamIndexArray;
            if (i4 >= zArr.length) {
                break;
            }
            if (zArr[i4]) {
                sb.append(audioStreams[i4]);
                sb.append(" = ");
                if (this.m_variables[i4] != null) {
                    sb.append(this.m_variables[i4].getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys[i4]) + ", ");
                } else {
                    sb.append(this.m_streamVolumeArray[i4]);
                    sb.append("%, ");
                }
            }
            i4++;
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(", ")) {
            return sb2.substring(0, sb2.length() - 2);
        }
        return sb2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetVolumeActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariables
    public List<MacroDroidVariable> getVariables() {
        MacroDroidVariable[] macroDroidVariableArr;
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.m_variables) {
            if (macroDroidVariable != null) {
                arrayList.add(macroDroidVariable);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        S();
        if (this.m_volume != -1) {
            int i4 = 0;
            while (true) {
                int[] iArr = this.m_streamVolumeArray;
                if (i4 >= iArr.length) {
                    break;
                }
                iArr[i4] = this.m_volume;
                i4++;
            }
            this.m_volume = -1;
        }
        Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.system_volume_dialog);
        appCompatDialog.setTitle(R.string.action_set_volume);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.set_volume_set_in_forground);
        ListView listView = (ListView) appCompatDialog.findViewById(R.id.set_volume_streamList);
        final c cVar = new c(new ContextThemeWrapper(activity, (int) R.style.Theme_App_Dialog_Action), this.m_streamIndexArray, this.m_streamVolumeArray, this.m_variables);
        checkBox.setChecked(this.setInForeground);
        listView.setAdapter((ListAdapter) cVar);
        listView.setItemsCanFocus(false);
        listView.setChoiceMode(2);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.tl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetVolumeAction.this.U(cVar, checkBox, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ul
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -1;
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    @SuppressLint({"NewApi"})
    public void invokeAction(final TriggerContextInfo triggerContextInfo) {
        boolean isNotificationPolicyAccessGranted;
        S();
        if (requiresAccessNotificationPolicy()) {
            isNotificationPolicyAccessGranted = ((NotificationManager) getContext().getSystemService("notification")).isNotificationPolicyAccessGranted();
            if (!isNotificationPolicyAccessGranted) {
                PermissionsHelper.showNeedsSpecialPermission(getContext(), getName(), 7);
            }
        }
        W(triggerContextInfo);
        if (triggerContextInfo != null && triggerContextInfo.getTriggerClass() != null && triggerContextInfo.getTriggerClass().equals(BluetoothTrigger.class.getSimpleName())) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.vl
                @Override // java.lang.Runnable
                public final void run() {
                    SetVolumeAction.this.W(triggerContextInfo);
                }
            }, 1000L);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessNotificationPolicy() {
        if (Settings.getIgnoreDoNotDisturb(getContext()) || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return this.setInForeground;
    }

    public void setChannelEnabled(int i4, boolean z3) {
        int i5 = 0;
        while (true) {
            int[] iArr = s_streamConstants;
            if (i5 < iArr.length) {
                if (iArr[i5] == i4) {
                    this.m_streamIndexArray[i5] = z3;
                }
                i5++;
            } else {
                return;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys
    public void setDictionaryKeys(@NonNull DictionaryKeys[] dictionaryKeysArr) {
        this.varDictionaryKeys = dictionaryKeysArr;
    }

    public void setVolume(int i4) {
        this.m_volume = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_streamIndexArray.length);
        parcel.writeBooleanArray(this.m_streamIndexArray);
        parcel.writeInt(this.m_volume);
        parcel.writeInt(this.m_forceVibrateOff ? 1 : 0);
        parcel.writeInt(this.m_streamVolumeArray.length);
        parcel.writeIntArray(this.m_streamVolumeArray);
        parcel.writeParcelableArray(this.m_variables, i4);
        parcel.writeParcelableArray(this.varDictionaryKeys, i4);
        parcel.writeInt(this.setInForeground ? 1 : 0);
    }

    public SetVolumeAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetVolumeAction() {
        int[] iArr = s_streamConstants;
        this.m_streamIndexArray = new boolean[iArr.length];
        this.m_streamVolumeArray = new int[iArr.length];
        this.m_variables = new MacroDroidVariable[iArr.length];
        this.varDictionaryKeys = new DictionaryKeys[iArr.length];
        this.m_volume = -1;
    }

    private SetVolumeAction(Parcel parcel) {
        super(parcel);
        int[] iArr = s_streamConstants;
        this.m_streamIndexArray = new boolean[iArr.length];
        this.m_streamVolumeArray = new int[iArr.length];
        this.m_variables = new MacroDroidVariable[iArr.length];
        this.varDictionaryKeys = new DictionaryKeys[iArr.length];
        boolean[] zArr = new boolean[parcel.readInt()];
        this.m_streamIndexArray = zArr;
        parcel.readBooleanArray(zArr);
        this.m_volume = parcel.readInt();
        this.m_forceVibrateOff = parcel.readInt() != 0;
        int[] iArr2 = new int[parcel.readInt()];
        this.m_streamVolumeArray = iArr2;
        parcel.readIntArray(iArr2);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(MacroDroidVariable.class.getClassLoader());
        this.m_variables = new MacroDroidVariable[readParcelableArray.length];
        for (int i4 = 0; i4 < readParcelableArray.length; i4++) {
            this.m_variables[i4] = (MacroDroidVariable) readParcelableArray[i4];
        }
        Parcelable[] readParcelableArray2 = parcel.readParcelableArray(DictionaryKeys.class.getClassLoader());
        this.varDictionaryKeys = new DictionaryKeys[s_streamConstants.length];
        for (int i5 = 0; i5 < readParcelableArray2.length; i5++) {
            this.varDictionaryKeys[i5] = (DictionaryKeys) readParcelableArray2[i5];
        }
        this.setInForeground = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final LayoutInflater f2555a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f2556b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f2557c;

        /* renamed from: d  reason: collision with root package name */
        private final MacroDroidVariable[] f2558d;

        /* renamed from: e  reason: collision with root package name */
        private final List<MacroDroidVariable> f2559e;

        /* loaded from: classes2.dex */
        class a implements VariableHelper.VariableSelectedListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f2561a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f2562b;

            a(b bVar, int i4) {
                this.f2561a = bVar;
                this.f2562b = i4;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NonNull String str) {
                this.f2561a.f2553c.setVisibility(0);
                this.f2561a.f2554d.setVisibility(0);
                c.this.f2558d[this.f2562b] = null;
                SetVolumeAction.this.varDictionaryKeys[this.f2562b] = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
                DictionaryKeys dictionaryKeys;
                this.f2561a.f2553c.setVisibility(8);
                this.f2561a.f2554d.setVisibility(8);
                c.this.f2558d[this.f2562b] = macroDroidVariable;
                DictionaryKeys[] dictionaryKeysArr = SetVolumeAction.this.varDictionaryKeys;
                int i4 = this.f2562b;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                dictionaryKeysArr[i4] = dictionaryKeys;
            }
        }

        public c(Context context, boolean[] zArr, int[] iArr, MacroDroidVariable[] macroDroidVariableArr) {
            this.f2555a = LayoutInflater.from(context);
            this.f2556b = Arrays.copyOf(zArr, zArr.length);
            this.f2557c = Arrays.copyOf(iArr, iArr.length);
            this.f2558d = (MacroDroidVariable[]) Arrays.copyOf(macroDroidVariableArr, macroDroidVariableArr.length);
            ArrayList<MacroDroidVariable> allIntegerVariables = SetVolumeAction.this.getAllIntegerVariables();
            this.f2559e = allIntegerVariables;
            allIntegerVariables.addAll(SetVolumeAction.this.getAllDecimalVariables());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(int i4, b bVar, CompoundButton compoundButton, boolean z3) {
            float f4;
            this.f2556b[i4] = z3;
            bVar.f2552b.setEnabled(z3);
            Spinner spinner = bVar.f2552b;
            if (z3) {
                f4 = 1.0f;
            } else {
                f4 = 0.5f;
            }
            spinner.setAlpha(f4);
            bVar.f2553c.setEnabled(z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean i(b bVar, View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1 && bVar.f2552b.getAdapter().getCount() <= 1) {
                ToastCompat.makeText(SetVolumeAction.this.getContext(), (int) R.string.no_integer_variables_defined, 0).show();
            }
            return false;
        }

        public boolean[] e() {
            return this.f2556b;
        }

        public MacroDroidVariable[] f() {
            return this.f2558d;
        }

        public int[] g() {
            return this.f2557c;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return Math.min(SetVolumeAction.getAudioStreams().length, this.f2556b.length);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(final int i4, View view, ViewGroup viewGroup) {
            final b bVar;
            View view2;
            float f4;
            String str;
            int i5;
            int i6 = 0;
            if (view == null) {
                view2 = this.f2555a.inflate(R.layout.set_volume_list_item, viewGroup, false);
                bVar = new b();
                bVar.f2551a = (CheckBox) view2.findViewById(R.id.set_volume_list_item_checkbox);
                bVar.f2552b = (Spinner) view2.findViewById(R.id.set_volume_list_item_spinner);
                bVar.f2553c = (SeekBar) view2.findViewById(R.id.set_volume_seekbar);
                bVar.f2554d = (TextView) view2.findViewById(R.id.set_volume_value);
                view2.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            bVar.f2552b.setOnItemSelectedListener(null);
            bVar.f2551a.setOnCheckedChangeListener(null);
            bVar.f2551a.setChecked(this.f2556b[i4]);
            Spinner spinner = bVar.f2552b;
            if (this.f2556b[i4]) {
                f4 = 1.0f;
            } else {
                f4 = 0.5f;
            }
            spinner.setAlpha(f4);
            bVar.f2552b.setEnabled(this.f2556b[i4]);
            bVar.f2553c.setEnabled(this.f2556b[i4]);
            bVar.f2551a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.wl
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    SetVolumeAction.c.this.h(i4, bVar, compoundButton, z3);
                }
            });
            new ArrayList().add(SelectableItem.r(R.string.use_slider_value));
            ArrayList arrayList = new ArrayList();
            arrayList.add(SelectableItem.r(R.string.use_slider_value));
            Activity activity = SetVolumeAction.this.getActivity();
            SetVolumeAction setVolumeAction = SetVolumeAction.this;
            Spinner spinner2 = bVar.f2552b;
            Macro macro = setVolumeAction.getMacro();
            if (this.f2558d[i4] != null) {
                str = this.f2558d[i4].getName() + VariableHelper.getFormattedDictionaryKeys(SetVolumeAction.this.varDictionaryKeys[i4]);
            } else {
                str = null;
            }
            VariableHelper.configureNumberVarSpinner(activity, R.style.Theme_App_Dialog_Action, setVolumeAction, spinner2, macro, arrayList, str, "", false, new a(bVar, i4));
            SeekBar seekBar = bVar.f2553c;
            if (this.f2558d[i4] != null) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            seekBar.setVisibility(i5);
            TextView textView = bVar.f2554d;
            if (this.f2558d[i4] != null) {
                i6 = 8;
            }
            textView.setVisibility(i6);
            bVar.f2552b.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.action.xl
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean i7;
                    i7 = SetVolumeAction.c.this.i(bVar, view3, motionEvent);
                    return i7;
                }
            });
            bVar.f2553c.setOnSeekBarChangeListener(null);
            bVar.f2553c.setProgress(this.f2557c[i4]);
            bVar.f2554d.setText(this.f2557c[i4] + "%");
            bVar.f2553c.setOnSeekBarChangeListener(new b(i4, bVar));
            bVar.f2551a.setText(SetVolumeAction.getAudioStreams()[i4]);
            return view2;
        }

        /* loaded from: classes2.dex */
        class b implements SeekBar.OnSeekBarChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f2564a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f2565b;

            b(int i4, b bVar) {
                this.f2564a = i4;
                this.f2565b = bVar;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
                c.this.f2557c[this.f2564a] = i4;
                TextView textView = this.f2565b.f2554d;
                textView.setText(i4 + "%");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        }
    }
}
