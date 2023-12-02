package com.arlosoft.macrodroid.stopwatch;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemStopwatch;
import com.arlosoft.macrodroid.interfaces.HasStopwatch;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.stopwatch.StopWatchesActivity;
import com.arlosoft.macrodroid.stopwatch.StopwatchesAdapter;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class StopWatchesActivity extends MacroDroidBaseActivity implements StopwatchesAdapter.ClickHandler {

    /* renamed from: f  reason: collision with root package name */
    private StopwatchesAdapter f13592f;
    @BindView(R.id.infoCardDetail)
    TextView infoCardDetail;
    @BindView(R.id.infoCardGotIt)
    Button infoCardGotIt;
    @BindView(R.id.infoCardTitle)
    TextView infoCardTitle;
    @BindView(R.id.infoCardView)
    CardView infoCardView;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.view_flipper)
    ViewFlipper viewFlipper;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(View view) {
        Settings.hideInfoCardCellTowers(getApplicationContext());
        this.infoCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(EditText editText, List list, AppCompatDialog appCompatDialog, View view) {
        String obj = editText.getText().toString();
        if (list.contains(obj)) {
            K();
            return;
        }
        list.add(obj);
        StopWatch.setStopWatches(this, list);
        appCompatDialog.dismiss();
        if (list.size() > 0) {
            this.viewFlipper.setDisplayedChild(0);
            this.f13592f.setStopwatchNames(list);
            return;
        }
        this.viewFlipper.setDisplayedChild(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(String str, DialogInterface dialogInterface, int i4) {
        if (i4 == 0) {
            I(str);
        } else {
            v(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(EditText editText, String str, AppCompatDialog appCompatDialog, View view) {
        List<String> stopWatches = StopWatch.getStopWatches(this);
        String obj = editText.getText().toString();
        if (stopWatches.contains(obj)) {
            K();
            return;
        }
        H(str, obj);
        stopWatches.remove(str);
        stopWatches.add(obj);
        StopWatch.setStopWatches(this, stopWatches);
        appCompatDialog.dismiss();
        this.f13592f.setStopwatchNames(stopWatches);
    }

    private void H(String str, String str2) {
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosIncludingExtras()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                J(next, str, str2);
                L(next, str, str2);
                for (Constraint constraint : next.getConstraints()) {
                    u(constraint, str, str2);
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                Action next2 = it2.next();
                J(next2, str, str2);
                L(next2, str, str2);
                for (Constraint constraint2 : next2.getConstraints()) {
                    u(constraint2, str, str2);
                }
                if (next2 instanceof WaitUntilTriggerAction) {
                    Iterator<Trigger> it3 = ((WaitUntilTriggerAction) next2).getTriggersToWaitFor().iterator();
                    while (it3.hasNext()) {
                        Trigger next3 = it3.next();
                        J(next3, str, str2);
                        L(next3, str, str2);
                        for (Constraint constraint3 : next3.getConstraints()) {
                            u(constraint3, str, str2);
                        }
                    }
                }
            }
            for (Constraint constraint4 : macro.getConstraints()) {
                u(constraint4, str, str2);
            }
        }
        DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(MacroDroidApplication.getInstance());
        for (DrawerItem drawerItem : drawerConfiguration.drawerItems) {
            if (drawerItem instanceof DrawerItemStopwatch) {
                DrawerItemStopwatch drawerItemStopwatch = (DrawerItemStopwatch) drawerItem;
                if (drawerItemStopwatch.getStopwatchName().equals(str)) {
                    drawerItemStopwatch.setStopwatchName(str2);
                }
            }
        }
        Settings.setDrawerConfiguration(MacroDroidApplication.getInstance(), drawerConfiguration);
        MacroStore.getInstance().writeToJSON();
    }

    private void I(final String str) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_StopWatches);
        appCompatDialog.setContentView(R.layout.dialog_new_stopwatch);
        appCompatDialog.setTitle(R.string.local_variable_rename);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.name);
        editText.setText(str);
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: m0.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopWatchesActivity.this.E(editText, str, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: m0.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
        appCompatDialog.getWindow().setSoftInputMode(5);
    }

    private void J(SelectableItem selectableItem, String str, String str2) {
        if (selectableItem instanceof SupportsMagicText) {
            SupportsMagicText supportsMagicText = (SupportsMagicText) selectableItem;
            String[] possibleMagicText = supportsMagicText.getPossibleMagicText();
            for (int i4 = 0; i4 < possibleMagicText.length; i4++) {
                if (!TextUtils.isEmpty(possibleMagicText[i4])) {
                    if (possibleMagicText[i4].contains("stopwatch=" + str)) {
                        possibleMagicText[i4] = possibleMagicText[i4].replace("stopwatch=" + str, "stopwatch=" + str2);
                    }
                }
                if (!TextUtils.isEmpty(possibleMagicText[i4])) {
                    if (possibleMagicText[i4].contains("stopwatchtime=" + str)) {
                        possibleMagicText[i4] = possibleMagicText[i4].replace("stopwatchtime=" + str, "stopwatchtime=" + str2);
                    }
                }
            }
            supportsMagicText.setPossibleMagicText(possibleMagicText);
        }
    }

    private void K() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_StopWatches);
        builder.setTitle(R.string.error);
        builder.setMessage(R.string.action_stop_watch_already_exists);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: m0.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void L(SelectableItem selectableItem, String str, String str2) {
        if (selectableItem instanceof HasStopwatch) {
            HasStopwatch hasStopwatch = (HasStopwatch) selectableItem;
            if (str.equals(hasStopwatch.getStopwatchName())) {
                hasStopwatch.setStopwatchName(str2);
            }
        }
    }

    private void u(Constraint constraint, String str, String str2) {
        J(constraint, str, str2);
        L(constraint, str, str2);
        if (constraint instanceof LogicConstraint) {
            for (Constraint constraint2 : ((LogicConstraint) constraint).getConstraints()) {
                u(constraint2, str, str2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        r2 = r1.getActions().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r2.hasNext() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        r3 = r2.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if ((r3 instanceof com.arlosoft.macrodroid.action.StopWatchAction) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r7.equals(((com.arlosoft.macrodroid.action.StopWatchAction) r3).getStopwatchName()) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
        r1 = r1.getConstraints().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
        if (r1.hasNext() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
        r2 = r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        if ((r2 instanceof com.arlosoft.macrodroid.constraint.StopWatchConstraint) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
        if (r7.equals(((com.arlosoft.macrodroid.constraint.StopWatchConstraint) r2).getStopwatchName()) == false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v(final java.lang.String r7) {
        /*
            r6 = this;
            com.arlosoft.macrodroid.macro.MacroStore r0 = com.arlosoft.macrodroid.macro.MacroStore.getInstance()
            java.util.List r0 = r0.getAllCompletedMacros()
            java.util.Iterator r0 = r0.iterator()
        Lc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L88
            java.lang.Object r1 = r0.next()
            com.arlosoft.macrodroid.macro.Macro r1 = (com.arlosoft.macrodroid.macro.Macro) r1
            java.util.ArrayList r2 = r1.getTriggerList()
            java.util.Iterator r2 = r2.iterator()
        L20:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L3e
            java.lang.Object r3 = r2.next()
            com.arlosoft.macrodroid.triggers.Trigger r3 = (com.arlosoft.macrodroid.triggers.Trigger) r3
            boolean r5 = r3 instanceof com.arlosoft.macrodroid.triggers.StopwatchTrigger
            if (r5 == 0) goto L20
            com.arlosoft.macrodroid.triggers.StopwatchTrigger r3 = (com.arlosoft.macrodroid.triggers.StopwatchTrigger) r3
            java.lang.String r3 = r3.getStopwatchName()
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L20
            goto L89
        L3e:
            java.util.ArrayList r2 = r1.getActions()
            java.util.Iterator r2 = r2.iterator()
        L46:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L63
            java.lang.Object r3 = r2.next()
            com.arlosoft.macrodroid.action.Action r3 = (com.arlosoft.macrodroid.action.Action) r3
            boolean r5 = r3 instanceof com.arlosoft.macrodroid.action.StopWatchAction
            if (r5 == 0) goto L46
            com.arlosoft.macrodroid.action.StopWatchAction r3 = (com.arlosoft.macrodroid.action.StopWatchAction) r3
            java.lang.String r3 = r3.getStopwatchName()
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L46
            goto L89
        L63:
            java.util.List r1 = r1.getConstraints()
            java.util.Iterator r1 = r1.iterator()
        L6b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lc
            java.lang.Object r2 = r1.next()
            com.arlosoft.macrodroid.constraint.Constraint r2 = (com.arlosoft.macrodroid.constraint.Constraint) r2
            boolean r3 = r2 instanceof com.arlosoft.macrodroid.constraint.StopWatchConstraint
            if (r3 == 0) goto L6b
            com.arlosoft.macrodroid.constraint.StopWatchConstraint r2 = (com.arlosoft.macrodroid.constraint.StopWatchConstraint) r2
            java.lang.String r2 = r2.getStopwatchName()
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L6b
            goto L89
        L88:
            r4 = 0
        L89:
            if (r4 != 0) goto L8f
            r6.y(r7)
            goto Ld2
        L8f:
            androidx.appcompat.app.AlertDialog$Builder r0 = new androidx.appcompat.app.AlertDialog$Builder
            r1 = 2132017848(0x7f1402b8, float:1.9673986E38)
            r0.<init>(r6, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 2131953122(0x7f1305e2, float:1.9542706E38)
            java.lang.String r2 = r6.getString(r2)
            r1.append(r2)
            java.lang.String r2 = " "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            androidx.appcompat.app.AlertDialog$Builder r1 = r0.setTitle(r1)
            r2 = 2131955238(0x7f130e26, float:1.9546998E38)
            androidx.appcompat.app.AlertDialog$Builder r1 = r1.setMessage(r2)
            m0.e r2 = new m0.e
            r2.<init>()
            r7 = 17039370(0x104000a, float:2.42446E-38)
            androidx.appcompat.app.AlertDialog$Builder r7 = r1.setPositiveButton(r7, r2)
            r1 = 17039360(0x1040000, float:2.424457E-38)
            r2 = 0
            r7.setNegativeButton(r1, r2)
            r0.show()
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.stopwatch.StopWatchesActivity.v(java.lang.String):void");
    }

    private void w() {
        if (Settings.shouldHideInfoCardCellTowers(this)) {
            this.infoCardView.setVisibility(8);
            return;
        }
        this.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.stopwatches_primary));
        this.infoCardTitle.setText(R.string.stopwatches);
        this.infoCardDetail.setText(R.string.stopwatches_info_card);
        this.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: m0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopWatchesActivity.this.A(view);
            }
        });
    }

    private void x(@NonNull final List<String> list) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_StopWatches);
        appCompatDialog.setContentView(R.layout.dialog_new_stopwatch);
        appCompatDialog.setTitle(R.string.action_stop_watch_create_new);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.name);
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: m0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopWatchesActivity.this.B(editText, list, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: m0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
        appCompatDialog.getWindow().setSoftInputMode(5);
    }

    private void y(String str) {
        List<String> stopWatches = StopWatch.getStopWatches(this);
        stopWatches.remove(str);
        StopWatch.setStopWatches(this, stopWatches);
        StopWatch.cancelAlarmsForStopwatch(str);
        if (stopWatches.size() > 0) {
            this.viewFlipper.setDisplayedChild(0);
            this.f13592f.setStopwatchNames(stopWatches);
            return;
        }
        this.viewFlipper.setDisplayedChild(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(String str, DialogInterface dialogInterface, int i4) {
        y(str);
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_stopwatches);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.stopwatches);
        List<String> stopWatches = StopWatch.getStopWatches(this);
        this.f13592f = new StopwatchesAdapter(stopWatches, this, this);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.f13592f);
        if (stopWatches.size() > 0) {
            this.viewFlipper.setDisplayedChild(0);
        } else {
            this.viewFlipper.setDisplayedChild(1);
        }
        w();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f13592f.onClose();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.fab})
    public void onPlusButtonClicked() {
        x(StopWatch.getStopWatches(this));
    }

    @Override // com.arlosoft.macrodroid.stopwatch.StopwatchesAdapter.ClickHandler
    public void onStopWatchClicked(final String str) {
        String[] strArr = {getString(R.string.local_variable_rename), getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_StopWatches);
        builder.setTitle(str).setItems(strArr, new DialogInterface.OnClickListener() { // from class: m0.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopWatchesActivity.this.D(str, dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13593a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f13594b;

        a(Button button, EditText editText) {
            this.f13593a = button;
            this.f13594b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f13593a;
            if (this.f13594b.getText().length() > 0) {
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
        final /* synthetic */ Button f13596a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f13597b;

        b(Button button, EditText editText) {
            this.f13596a = button;
            this.f13597b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f13596a;
            if (this.f13597b.getText().length() > 0) {
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
