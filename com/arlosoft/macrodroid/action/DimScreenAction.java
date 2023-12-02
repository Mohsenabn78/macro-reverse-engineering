package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.dim.DimOverlayService;
import com.arlosoft.macrodroid.action.info.DimScreenActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class DimScreenAction extends Action implements HasVariable, HasDictionaryKeys {
    public static final Parcelable.Creator<DimScreenAction> CREATOR = new c();
    private boolean m_dimScreenOn;
    private int m_percent;
    private MacroDroidVariable m_variable;
    private DictionaryKeys varDictionaryKeys;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient MacroDroidVariable workingVariable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2161a;

        a(ViewGroup viewGroup) {
            this.f2161a = viewGroup;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            this.f2161a.setVisibility(0);
            DimScreenAction.this.workingVariable = null;
            DimScreenAction.this.workingDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            this.f2161a.setVisibility(8);
            DimScreenAction.this.workingVariable = macroDroidVariable;
            DimScreenAction dimScreenAction = DimScreenAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            dimScreenAction.workingDictionaryKeys = dictionaryKeys;
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<DimScreenAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DimScreenAction createFromParcel(Parcel parcel) {
            return new DimScreenAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DimScreenAction[] newArray(int i4) {
            return new DimScreenAction[i4];
        }
    }

    /* synthetic */ DimScreenAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean T(Spinner spinner, View view, MotionEvent motionEvent) {
        if (spinner.getAdapter().getCount() > 1) {
            return false;
        }
        ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_integer_variables_defined, 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(RadioButton radioButton, Spinner spinner, SeekBar seekBar, AppCompatDialog appCompatDialog, View view) {
        this.m_dimScreenOn = radioButton.isChecked();
        spinner.getSelectedItemPosition();
        this.m_variable = this.workingVariable;
        this.varDictionaryKeys = this.workingDictionaryKeys;
        this.m_percent = seekBar.getProgress();
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W(View view, boolean z3) {
        view.setEnabled(z3);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                W(viewGroup.getChildAt(i4), z3);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (!this.m_dimScreenOn) {
            return SelectableItem.r(R.string.action_dim_screen_off);
        }
        if (this.m_variable != null) {
            return this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        }
        return this.m_percent + "%";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DimScreenActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        if (this.m_dimScreenOn) {
            return SelectableItem.r(R.string.action_dim_screen) + " (" + getExtendedDetail() + ")";
        }
        return SelectableItem.r(R.string.action_dim_screen_off);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    public MacroDroidVariable getVariable() {
        return this.m_variable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String str;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dim_dialog);
        appCompatDialog.setTitle(R.string.action_dim_screen);
        this.workingVariable = this.m_variable;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.dim_dialog_seek_bar);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.dim_dialog_spinner);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.dim_bar_layout);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.dim_percent_text);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.dim_dialog_on_radio_button);
        final ViewGroup viewGroup2 = (ViewGroup) appCompatDialog.findViewById(R.id.dim_dialog_values_layout);
        getAllIntegerVariables();
        int i4 = this.m_percent;
        textView.setText(this.m_percent + "%");
        radioButton.setChecked(this.m_dimScreenOn);
        ((RadioButton) appCompatDialog.findViewById(R.id.dim_dialog_off_radio_button)).setChecked(this.m_dimScreenOn ^ true);
        W(viewGroup2, this.m_dimScreenOn);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.u4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                DimScreenAction.W(viewGroup2, z3);
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.use_slider_value));
        Activity activity = getActivity();
        Macro macro = getMacro();
        if (this.m_variable != null) {
            str = this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str, "", false, new a(viewGroup));
        if (this.workingVariable == null) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        spinner.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.action.v4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean T;
                T = DimScreenAction.this.T(spinner, view, motionEvent);
                return T;
            }
        });
        seekBar.setProgress(Math.round(i4));
        seekBar.setOnSeekBarChangeListener(new b(textView));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.w4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DimScreenAction.this.U(radioButton, spinner, seekBar, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.x4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        getContext().stopService(new Intent(getContext(), DimOverlayService.class));
        if (this.m_dimScreenOn) {
            int i4 = this.m_percent;
            MacroDroidVariable macroDroidVariable = this.m_variable;
            if (macroDroidVariable != null) {
                MacroDroidVariable variableByName = getVariableByName(macroDroidVariable.getName());
                if (variableByName != null) {
                    Long longValue = variableByName.getLongValue(this.varDictionaryKeys);
                    if (longValue != null) {
                        i4 = Math.max(0, Math.min(longValue.intValue(), 100));
                    } else {
                        SystemLog.logError("Variable: " + this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys) + " was not found. Defaulting to 50%", getMacroGuid().longValue());
                    }
                } else {
                    SystemLog.logError("Variable: " + this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys) + " was not found. Defaulting to 50%", getMacroGuid().longValue());
                }
            }
            Intent intent = new Intent(getContext(), DimOverlayService.class);
            intent.putExtra(DimOverlayService.KEY_PERCENTAGE, i4);
            getContext().startService(intent);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(!this.m_dimScreenOn ? 1 : 0);
        parcel.writeInt(this.m_percent);
        parcel.writeParcelable(this.m_variable, i4);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public DimScreenAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_dimScreenOn = true;
    }

    private DimScreenAction() {
        this.m_percent = 50;
    }

    private DimScreenAction(Parcel parcel) {
        super(parcel);
        this.m_dimScreenOn = parcel.readInt() == 0;
        this.m_percent = parcel.readInt();
        this.m_variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* loaded from: classes2.dex */
    class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f2163a;

        b(TextView textView) {
            this.f2163a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            TextView textView = this.f2163a;
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
