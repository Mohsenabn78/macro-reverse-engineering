package com.arlosoft.macrodroid.action.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.PauseAction;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class PauseActionActivity extends MacroDroidDialogBaseActivity implements NumberPicker.Listener {

    /* renamed from: d  reason: collision with root package name */
    private Button f2905d;

    /* renamed from: e  reason: collision with root package name */
    private NumberPicker f2906e;

    /* renamed from: f  reason: collision with root package name */
    private NumberPicker f2907f;

    /* renamed from: g  reason: collision with root package name */
    private NumberPicker f2908g;

    /* renamed from: h  reason: collision with root package name */
    private Spinner f2909h;

    /* renamed from: i  reason: collision with root package name */
    private CheckBox f2910i;

    /* renamed from: j  reason: collision with root package name */
    private RadioGroup f2911j;

    /* renamed from: k  reason: collision with root package name */
    private RadioButton f2912k;

    /* renamed from: l  reason: collision with root package name */
    private RadioButton f2913l;

    /* renamed from: m  reason: collision with root package name */
    private MacroDroidVariable f2914m;

    /* renamed from: n  reason: collision with root package name */
    private DictionaryKeys f2915n;

    /* loaded from: classes2.dex */
    class a implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2916a;

        a(ViewGroup viewGroup) {
            this.f2916a = viewGroup;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            boolean z3 = false;
            this.f2916a.setVisibility(0);
            PauseActionActivity.this.f2911j.setVisibility(8);
            PauseActionActivity.this.f2914m = null;
            PauseActionActivity.this.f2915n = null;
            PauseActionActivity.this.f2905d.setEnabled((PauseActionActivity.this.f2906e.getValue() == 0 && PauseActionActivity.this.f2907f.getValue() == 0 && PauseActionActivity.this.f2908g.getValue() == 0) ? true : true);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            this.f2916a.setVisibility(8);
            PauseActionActivity.this.f2911j.setVisibility(0);
            PauseActionActivity.this.f2914m = macroDroidVariable;
            PauseActionActivity pauseActionActivity = PauseActionActivity.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            pauseActionActivity.f2915n = dictionaryKeys;
            PauseActionActivity.this.f2905d.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        int value = this.f2907f.getValue() + (this.f2906e.getValue() * 60);
        Intent intent = new Intent();
        intent.putExtra(PauseAction.UNIT_FOR_VARS_EXTRA, !this.f2912k.isChecked());
        intent.putExtra("Seconds", value);
        intent.putExtra(PauseAction.MILLI_SECONDS_EXTRA, this.f2908g.getValue());
        intent.putExtra(PauseAction.USE_ALARM_EXTRA, this.f2910i.isChecked());
        intent.putExtra("Variable", this.f2914m);
        intent.putExtra(PauseAction.DICTIONARY_KEYS_EXTRA, this.f2915n);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        finish();
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z3;
        boolean z4;
        int i4;
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.pause_action_view);
        setTitle(R.string.action_pause_delay_period);
        int i5 = 0;
        int intExtra = getIntent().getIntExtra(PauseAction.UNIT_FOR_VARS_EXTRA, 0);
        int intExtra2 = getIntent().getIntExtra("Seconds", 0);
        int intExtra3 = getIntent().getIntExtra(PauseAction.MILLI_SECONDS_EXTRA, 0);
        int i6 = intExtra2 / 60;
        int i7 = intExtra2 % 60;
        boolean booleanExtra = getIntent().getBooleanExtra(PauseAction.USE_ALARM_EXTRA, false);
        PauseAction pauseAction = (PauseAction) getIntent().getParcelableExtra("selectable_item");
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(getIntent().getLongExtra(Constants.EXTRA_MACRO_GUID, 0L));
        if (macroByGUID == null && (macroByGUID = (Macro) getIntent().getParcelableExtra("Macro")) == null) {
            SystemLog.logError("Could not launch wait before next config screen macro is null");
            ToastCompat.makeText(this, (int) R.string.error, 0).show();
            finish();
            return;
        }
        pauseAction.setMacro(macroByGUID);
        this.f2906e = (NumberPicker) findViewById(R.id.pause_action_minute_picker);
        this.f2907f = (NumberPicker) findViewById(R.id.pause_action_second_picker);
        this.f2908g = (NumberPicker) findViewById(R.id.pause_action_ms_picker);
        this.f2909h = (Spinner) findViewById(R.id.pause_action_spinner);
        this.f2910i = (CheckBox) findViewById(R.id.force_alarm_checkbox);
        this.f2911j = (RadioGroup) findViewById(R.id.variableUnitsContainer);
        this.f2912k = (RadioButton) findViewById(R.id.secondsRadioButton);
        this.f2913l = (RadioButton) findViewById(R.id.minutesRadioButton);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.pause_action_value_layout);
        this.f2914m = (MacroDroidVariable) getIntent().getParcelableExtra("Variable");
        this.f2915n = (DictionaryKeys) getIntent().getParcelableExtra(PauseAction.DICTIONARY_KEYS_EXTRA);
        this.f2906e.setValue(i6);
        this.f2906e.setMaximum(9999);
        this.f2906e.setMinimum(0);
        this.f2906e.setListener(this);
        this.f2907f.setValue(i7);
        this.f2907f.setListener(this);
        this.f2907f.setMaximum(999);
        this.f2907f.setMinimum(0);
        this.f2908g.setValue(intExtra3);
        this.f2908g.setMaximum(999);
        this.f2908g.setMinimum(0);
        this.f2908g.setIncrementStep(10);
        this.f2908g.setListener(this);
        RadioButton radioButton = this.f2912k;
        boolean z5 = true;
        if (intExtra != 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton.setChecked(z3);
        RadioButton radioButton2 = this.f2913l;
        if (intExtra == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        radioButton2.setChecked(z4);
        this.f2910i.setChecked(booleanExtra);
        Button button = (Button) findViewById(R.id.okButton);
        this.f2905d = button;
        if (this.f2906e.getValue() == 0 && this.f2907f.getValue() == 0 && this.f2908g.getValue() == 0) {
            z5 = false;
        }
        button.setEnabled(z5);
        this.f2905d.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PauseActionActivity.this.q(view);
            }
        });
        RadioGroup radioGroup = this.f2911j;
        if (this.f2914m != null) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        radioGroup.setVisibility(i4);
        if (this.f2914m != null) {
            i5 = 8;
        }
        viewGroup.setVisibility(i5);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.define_value));
        Spinner spinner = this.f2909h;
        if (this.f2914m != null) {
            str = this.f2914m.getName() + VariableHelper.getFormattedDictionaryKeys(this.f2915n);
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(this, R.style.Theme_App_Dialog_Action, pauseAction, spinner, macroByGUID, arrayList, str, "", false, new a(viewGroup));
        ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PauseActionActivity.this.r(view);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.common.NumberPicker.Listener
    public void valueUpdated() {
        boolean z3 = false;
        if (this.f2908g.getValue() < 0) {
            this.f2908g.setValue(0);
        }
        this.f2905d.setEnabled((this.f2906e.getValue() == 0 && this.f2907f.getValue() == 0 && this.f2908g.getValue() == 0) ? true : true);
    }
}
