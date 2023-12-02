package com.arlosoft.macrodroid.settings;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.SetModeAction;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.ModeConstraint;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.ModeEnterExitTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class EditModesActivity extends MacroDroidBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private List<String> f13417f;

    /* renamed from: g  reason: collision with root package name */
    private ListView f13418g;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(View view) {
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(CardView cardView, View view) {
        Settings.setEditModeInfoCardHide(this, true);
        cardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(AdapterView adapterView, View view, int i4, long j4) {
        F(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(int i4, DialogInterface dialogInterface, int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    E(this.f13417f.get(i4));
                    return;
                }
                return;
            }
            v(i4);
            return;
        }
        this.f13417f.remove(i4);
        G();
    }

    private void E(String str) {
        Util.setMode(this, str);
    }

    private void F(final int i4) {
        String[] strArr = {getString(R.string.delete), getString(R.string.edit), getString(R.string.action_set_mode_set_mode)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(this.f13417f.get(i4)).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                EditModesActivity.this.D(i4, dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    private void G() {
        Settings.setModeList(this, Util.getModeListString(this.f13417f));
        refresh();
    }

    private void refresh() {
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(this));
        this.f13417f = modeListFromString;
        String[] strArr = new String[modeListFromString.size()];
        this.f13417f.toArray(strArr);
        this.f13418g.setAdapter((ListAdapter) new ArrayAdapter(this, (int) R.layout.list_item_mode, strArr));
        this.f13418g.setDivider(null);
        this.f13418g.setEmptyView(findViewById(R.id.edit_modes_no_entries));
        registerForContextMenu(this.f13418g);
        this.f13418g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.arlosoft.macrodroid.settings.l
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                EditModesActivity.this.C(adapterView, view, i4, j4);
            }
        });
    }

    private void u() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this);
        appCompatDialog.setContentView(R.layout.mode_name_dialog);
        appCompatDialog.setTitle(R.string.add_macrodroid_mode);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.mode_name_dialog_mode_name);
        editText.setHint(R.string.enter_mode_name);
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditModesActivity.this.w(appCompatDialog, editText, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private void v(final int i4) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this);
        appCompatDialog.setContentView(R.layout.mode_name_dialog);
        appCompatDialog.setTitle(R.string.enter_mode_name);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.mode_name_dialog_mode_name);
        editText.setHint(R.string.enter_mode_name);
        final String str = this.f13417f.get(i4);
        editText.setText(str);
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditModesActivity.this.y(appCompatDialog, editText, i4, str, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(AppCompatDialog appCompatDialog, EditText editText, View view) {
        appCompatDialog.cancel();
        this.f13417f.add(editText.getText().toString());
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(AppCompatDialog appCompatDialog, EditText editText, int i4, String str, View view) {
        appCompatDialog.cancel();
        String obj = editText.getText().toString();
        this.f13417f.set(i4, obj);
        boolean z3 = false;
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof ModeEnterExitTrigger) {
                    ModeEnterExitTrigger modeEnterExitTrigger = (ModeEnterExitTrigger) next;
                    if (modeEnterExitTrigger.getMode().equals(str)) {
                        modeEnterExitTrigger.setMode(obj);
                        z3 = true;
                    }
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                Action next2 = it2.next();
                if (next2 instanceof SetModeAction) {
                    SetModeAction setModeAction = (SetModeAction) next2;
                    if (setModeAction.getMode().equals(str)) {
                        setModeAction.setMode(obj);
                        z3 = true;
                    }
                }
            }
            for (Constraint constraint : macro.getConstraints()) {
                if (constraint instanceof ModeConstraint) {
                    ModeConstraint modeConstraint = (ModeConstraint) constraint;
                    if (modeConstraint.getMode().equals(str)) {
                        modeConstraint.setMode(obj);
                        z3 = true;
                    }
                }
            }
        }
        G();
        if (z3) {
            MacroStore.getInstance().writeToJSON();
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_modes);
        setTitle(R.string.edit_modes);
        this.f13418g = (ListView) findViewById(R.id.edit_modes_list);
        ((TextView) findViewById(R.id.infoCardTitle)).setText(R.string.edit_macrodroid_modes);
        ((TextView) findViewById(R.id.infoCardDetail)).setText(R.string.macrodroid_mode_info_card);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditModesActivity.this.A(view);
            }
        });
        final CardView cardView = (CardView) findViewById(R.id.infoCardView);
        Button button = (Button) findViewById(R.id.infoCardGotIt);
        cardView.setCardBackgroundColor(ContextCompat.getColor(getApplication(), R.color.modes_config_primary));
        if (!Settings.getEditModeInfoCardHide(this)) {
            cardView.setVisibility(0);
        } else {
            cardView.setVisibility(8);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditModesActivity.this.B(cardView, view);
            }
        });
        refresh();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13419a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f13420b;

        a(Button button, EditText editText) {
            this.f13419a = button;
            this.f13420b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f13419a;
            if (this.f13420b.getText().length() > 0) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13422a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f13423b;

        b(Button button, EditText editText) {
            this.f13422a = button;
            this.f13423b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f13422a;
            if (this.f13423b.getText().length() > 0) {
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
