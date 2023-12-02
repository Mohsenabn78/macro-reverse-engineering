package com.arlosoft.macrodroid.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class VariablesHelper {

    /* loaded from: classes3.dex */
    public interface VariableCreatedListener {
        void variableCreated(MacroDroidVariable macroDroidVariable);
    }

    public static void createNewVariable(Activity activity, Spinner spinner, SelectableItem selectableItem, int i4, @Nullable VariableCreatedListener variableCreatedListener) {
        createNewVariable(activity, spinner, selectableItem, i4, 2, false, false, variableCreatedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(EditText editText, SelectableItem selectableItem, Activity activity, int i4, RadioButton radioButton, boolean z3, VariableCreatedListener variableCreatedListener, boolean z4, Spinner spinner, AppCompatDialog appCompatDialog, View view) {
        String obj = editText.getText().toString();
        if (selectableItem.getMacro().findLocalVariableByName(obj) != null) {
            g(activity);
            return;
        }
        MacroDroidVariable macroDroidVariable = new MacroDroidVariable(i4, obj, radioButton.isChecked());
        macroDroidVariable.setIsInput(false);
        selectableItem.addVariable(macroDroidVariable);
        if (z3 || variableCreatedListener == null) {
            List<MacroDroidVariable> variablesOfType = selectableItem.getVariablesOfType(i4);
            ArrayList arrayList = new ArrayList();
            if (z4) {
                arrayList.add(0, activity.getString(R.string.none));
            }
            int i5 = 0;
            int i6 = 0;
            for (MacroDroidVariable macroDroidVariable2 : variablesOfType) {
                if (obj.equals(macroDroidVariable2.getName())) {
                    i5 = i6 + (z4 ? 1 : 0);
                }
                arrayList.add(macroDroidVariable2.getName());
                i6++;
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(activity, (int) R.layout.simple_spinner_item, arrayList);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
            spinner.setSelection(i5, false);
        }
        if (variableCreatedListener != null) {
            variableCreatedListener.variableCreated(macroDroidVariable);
        }
        appCompatDialog.dismiss();
    }

    private static void g(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog_Variables);
        builder.setTitle(R.string.variable_creation_failed);
        builder.setMessage(R.string.variable_already_exists);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public static void createNewVariable(Activity activity, Spinner spinner, SelectableItem selectableItem, int i4, boolean z3, @Nullable VariableCreatedListener variableCreatedListener) {
        createNewVariable(activity, spinner, selectableItem, i4, 2, z3, false, variableCreatedListener);
    }

    public static void createNewVariable(Activity activity, Spinner spinner, SelectableItem selectableItem, int i4, int i5, @Nullable VariableCreatedListener variableCreatedListener) {
        createNewVariable(activity, spinner, selectableItem, i4, i5, false, false, variableCreatedListener);
    }

    public static void createNewVariable(final Activity activity, final Spinner spinner, final SelectableItem selectableItem, int i4, final int i5, final boolean z3, final boolean z4, @Nullable final VariableCreatedListener variableCreatedListener) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
        appCompatDialog.setContentView(R.layout.variable_new_variable_dialog);
        appCompatDialog.setTitle(R.string.action_set_variable_create);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.variable_new_variable_dialog_name);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.radio_button_local);
        ((ViewGroup) appCompatDialog.findViewById(R.id.type_container)).setVisibility(8);
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariablesHelper.d(editText, selectableItem, activity, i5, radioButton, z4, variableCreatedListener, z3, spinner, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f16088a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f16089b;

        a(Button button, EditText editText) {
            this.f16088a = button;
            this.f16089b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f16088a;
            if (this.f16089b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
