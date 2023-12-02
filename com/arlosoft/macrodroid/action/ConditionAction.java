package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.AddConditionActivity;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ConditionAction extends Action {
    private static final int REQUEST_CODE_ADD_CONDITION = 0;
    private boolean dontLogIfConditionIsFalse;
    private transient int m_childLevelOffset;
    private transient AppCompatDialog m_dialog;
    private transient List<Constraint> m_originalConstraintList;
    private transient Constraint selectedConstraint;
    private transient boolean tempIsOrCondition;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConditionAction() {
    }

    private boolean U(Constraint constraint, Constraint constraint2) {
        if (constraint.getConstraints() != null) {
            for (Constraint constraint3 : constraint.getConstraints()) {
                if (constraint2 == constraint3) {
                    constraint.removeConstraint(constraint3);
                    return true;
                } else if (U(constraint3, constraint2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void W(View view, final Constraint constraint, boolean z3, boolean z4, boolean z5) {
        ImageView imageView = (ImageView) view.findViewById(R.id.macro_edit_entry_icon);
        TextView textView = (TextView) view.findViewById(R.id.macro_edit_entry_name);
        TextView textView2 = (TextView) view.findViewById(R.id.macro_edit_entry_detail);
        View findViewById = view.findViewById(R.id.start_spacing);
        imageView.setImageDrawable(getActivity().getResources().getDrawable(constraint.getIcon()));
        imageView.setVisibility(0);
        textView.setText(constraint.getEditMacroConfiguredName());
        textView.setGravity(8388627);
        if (z5) {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_constraint_dark);
        } else {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_constraint);
        }
        findViewById.setVisibility(0);
        if (!z4) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.v3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ConditionAction.this.e0(constraint, view2);
                }
            });
        }
        if (z3) {
            findViewById.setBackgroundResource(R.drawable.constraint_link_end);
        } else {
            findViewById.setBackgroundResource(R.drawable.constraint_link_joiner);
        }
        if (constraint.getExtendedDetail() != null && constraint.getExtendedDetail().length() > 0) {
            textView2.setVisibility(0);
            textView2.setText(constraint.getExtendedDetail());
            return;
        }
        textView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(Constraint constraint, View view) {
        h0(constraint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(CheckBox checkBox, View view) {
        AppCompatDialog appCompatDialog = this.m_dialog;
        if (appCompatDialog != null) {
            this.m_originalConstraintList = null;
            appCompatDialog.dismiss();
            this.m_dialog = null;
        }
        this.dontLogIfConditionIsFalse = checkBox.isChecked();
        itemComplete();
        D(this.tempIsOrCondition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        E(this.m_originalConstraintList);
        Macro macro = this.m_macro;
        if (macro != null) {
            macro.setActionBeingConfigured(null);
        }
        AppCompatDialog appCompatDialog = this.m_dialog;
        if (appCompatDialog != null) {
            this.m_originalConstraintList = null;
            appCompatDialog.dismiss();
            this.m_dialog = null;
        }
        handleItemCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface) {
        Macro macro = this.m_macro;
        if (macro != null) {
            macro.setActionBeingConfigured(null);
        }
        if (this.m_dialog != null) {
            this.m_dialog = null;
        }
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Activity activity, View view) {
        AppCompatDialog appCompatDialog = this.m_dialog;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
            this.m_dialog = null;
        }
        if (activity != null) {
            Intent intent = new Intent(activity, AddConditionActivity.class);
            intent.putExtra("MacroId", this.m_macro.getId());
            intent.putExtra(Constants.EXTRA_PARENT_GUID, getSIGUID());
            activity.startActivityForResult(intent, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Constraint constraint, View view) {
        if (this.m_macro.getActions() != null && this.m_macro.getActions().size() > 0) {
            h0(constraint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(String[] strArr, Activity activity, Constraint constraint, DialogInterface dialogInterface, int i4) {
        String str = strArr[i4];
        if (str.equals(SelectableItem.r(R.string.add_constraint))) {
            Intent intent = new Intent(activity, AddConditionActivity.class);
            intent.putExtra("MacroId", this.m_macro.getId());
            intent.putExtra(Constants.EXTRA_PARENT_GUID, constraint.getSIGUID());
            activity.startActivityForResult(intent, 0);
        } else if (str.equals(SelectableItem.r(R.string.configure))) {
            constraint.setMacro(this.m_macro);
            constraint.setActivity(activity);
            constraint.onItemSelected();
            this.selectedConstraint = constraint;
        } else if (str.equals(SelectableItem.r(R.string.help))) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(constraint.getName());
            if (constraint.getInfo().supportsAdbHack()) {
                builder.setMessage(Util.appendAdbHackInfo(getContext(), getContext().getString(constraint.getInfo().getHelpInfo())));
            } else {
                builder.setMessage(constraint.getHelpInfo());
            }
            builder.setNegativeButton(17039370, (DialogInterface.OnClickListener) null);
            builder.show();
        } else if (str.equals(SelectableItem.r(R.string.delete))) {
            if (getConstraints().contains(constraint)) {
                removeConstraint(constraint);
            } else {
                for (Constraint constraint2 : getConstraints()) {
                    U(constraint2, constraint);
                }
            }
            configureConditionsList();
        }
    }

    private void g0(Constraint constraint, View view, boolean z3, int i4, boolean z4) {
        int i5;
        boolean z5;
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.topLevelExtrasContainer);
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.constraintContainer);
        View findViewById = view.findViewById(R.id.constraintLinkUnderAction);
        View findViewById2 = view.findViewById(R.id.macro_edit_entry_extras_joiner);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) findViewById.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += i4;
        findViewById.setLayoutParams(layoutParams);
        findViewById.setVisibility(0);
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById2.setVisibility(i5);
        viewGroup2.removeAllViews();
        Activity activity = getActivity();
        int i6 = 0;
        for (Constraint constraint2 : constraint.getConstraints()) {
            boolean z6 = true;
            i6++;
            MaterialCardView materialCardView = (MaterialCardView) activity.getLayoutInflater().inflate(R.layout.macro_edit_entry, viewGroup2, false);
            materialCardView.setCardBackgroundColor(activity.getResources().getColor(R.color.condition_primary));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) materialCardView.getLayoutParams();
            layoutParams2.leftMargin = i4;
            materialCardView.setLayoutParams(layoutParams2);
            if (i6 == constraint.getConstraints().size()) {
                z5 = true;
            } else {
                z5 = false;
            }
            W(materialCardView, constraint2, z5, false, z3);
            viewGroup2.addView(materialCardView);
            if (constraint2.getConstraints() != null && constraint2.getConstraints().size() > 0) {
                int i7 = this.m_childLevelOffset;
                if (i6 >= constraint.getConstraints().size()) {
                    z6 = false;
                }
                g0(constraint2, materialCardView, z3, i7, z6);
            }
        }
        viewGroup.setVisibility(0);
        viewGroup2.setVisibility(0);
    }

    private List<Action> getChildActions() {
        int i4;
        ArrayList arrayList = new ArrayList();
        Macro macro = getMacro();
        if (macro == null) {
            return arrayList;
        }
        ArrayList<Action> actions = macro.getActions();
        int indexOf = actions.indexOf(this);
        if (this instanceof IfConditionAction) {
            i4 = MacroListUtils.getEndIfIndex(actions, indexOf);
        } else if (this instanceof LoopAction) {
            i4 = MacroListUtils.getEndLoopIndex(actions, indexOf);
        } else {
            i4 = 0;
        }
        while (true) {
            indexOf++;
            if (indexOf < i4) {
                arrayList.add(actions.get(indexOf));
            } else {
                return arrayList;
            }
        }
    }

    private void h0(final Constraint constraint) {
        if (!checkActivityAlive()) {
            return;
        }
        this.selectedConstraint = null;
        final String[] strArr = constraint instanceof LogicConstraint ? new String[]{SelectableItem.r(R.string.add_constraint), SelectableItem.r(R.string.configure), SelectableItem.r(R.string.delete), SelectableItem.r(R.string.help)} : new String[]{SelectableItem.r(R.string.configure), SelectableItem.r(R.string.delete), SelectableItem.r(R.string.help)};
        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(constraint.getEditMacroConfiguredName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.u3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ConditionAction.this.f0(strArr, activity, constraint, dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(boolean z3, boolean z4) {
        final Activity activity = getActivity();
        if (z3 && this.m_originalConstraintList == null) {
            this.m_originalConstraintList = new ArrayList();
            for (Constraint constraint : getConstraints()) {
                Constraint createExactClone = constraint.createExactClone();
                createExactClone.setMacro(getMacro());
                this.m_originalConstraintList.add(createExactClone);
            }
        }
        if (!checkActivityAlive()) {
            return;
        }
        Macro macro = this.m_macro;
        if (macro != null) {
            macro.setActionBeingConfigured(this);
        }
        AppCompatDialog appCompatDialog = this.m_dialog;
        if (appCompatDialog != null && appCompatDialog.isShowing()) {
            try {
                this.m_dialog.dismiss();
            } catch (IllegalArgumentException unused) {
            }
        }
        if (z4) {
            this.tempIsOrCondition = n();
        }
        AppCompatDialog appCompatDialog2 = new AppCompatDialog(activity, getDialogTheme());
        this.m_dialog = appCompatDialog2;
        appCompatDialog2.setContentView(R.layout.dialog_parent_condition_configure);
        this.m_dialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.m_dialog.getWindow().getAttributes());
        layoutParams.width = -1;
        this.m_dialog.getWindow().setAttributes(layoutParams);
        this.m_childLevelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.constraint_level_offset);
        Spinner spinner = (Spinner) this.m_dialog.findViewById(R.id.conditions_and_or_selection);
        final CheckBox checkBox = (CheckBox) this.m_dialog.findViewById(R.id.dont_log_if_false_checkbox);
        ((TextView) this.m_dialog.findViewById(R.id.dialog_parent_condition_detail_text)).setText(X());
        checkBox.setChecked(this.dontLogIfConditionIsFalse);
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.and));
        arrayList.add(SelectableItem.r(R.string.or));
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), (int) R.layout.simple_spinner_item_white_text, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(this.tempIsOrCondition ? 1 : 0);
        spinner.setOnItemSelectedListener(new a());
        configureConditionsList();
        ((Button) this.m_dialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.q3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConditionAction.this.a0(checkBox, view);
            }
        });
        ((Button) this.m_dialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConditionAction.this.b0(view);
            }
        });
        this.m_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.s3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ConditionAction.this.c0(dialogInterface);
            }
        });
        ((ImageButton) this.m_dialog.findViewById(R.id.conditons_add_condition_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.t3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConditionAction.this.d0(activity, view);
            }
        });
        this.m_dialog.setCanceledOnTouchOutside(false);
        this.m_dialog.show();
    }

    protected abstract String X();

    protected abstract String Y();

    public void configureConditionsList() {
        int i4;
        boolean z3;
        MaterialCardView materialCardView;
        View view;
        int i5;
        ViewGroup viewGroup;
        if (this.m_dialog != null && checkActivityAlive()) {
            Spinner spinner = (Spinner) this.m_dialog.findViewById(R.id.conditions_and_or_selection);
            Button button = (Button) this.m_dialog.findViewById(R.id.okButton);
            LinearLayout linearLayout = (LinearLayout) this.m_dialog.findViewById(R.id.conditions_layout);
            linearLayout.removeAllViews();
            int i6 = 1;
            if (getConstraints().size() > 1) {
                i4 = 0;
            } else {
                i4 = 4;
            }
            spinner.setVisibility(i4);
            if (getConstraints().size() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
            Activity activity = getActivity();
            int size = getConstraints().size();
            int i7 = R.id.macro_edit_entry_icon;
            int i8 = R.id.macro_edit_entry_detail;
            int i9 = 8;
            ViewGroup viewGroup2 = null;
            if (size == 0) {
                MaterialCardView materialCardView2 = (MaterialCardView) activity.getLayoutInflater().inflate(R.layout.macro_edit_entry_bottom, (ViewGroup) null);
                TextView textView = (TextView) materialCardView2.findViewById(R.id.macro_edit_entry_name);
                materialCardView2.setCardBackgroundColor(activity.getResources().getColor(R.color.condition_primary));
                textView.setText("[" + SelectableItem.r(R.string.no_conditions) + "]");
                textView.setGravity(17);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.no_constraints_padding);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                ((ImageView) materialCardView2.findViewById(R.id.macro_edit_entry_icon)).setVisibility(8);
                ((TextView) materialCardView2.findViewById(R.id.macro_edit_entry_detail)).setVisibility(8);
                linearLayout.addView(materialCardView2);
                return;
            }
            int i10 = 0;
            while (i10 < getConstraints().size()) {
                if (i10 == getConstraints().size() - i6) {
                    materialCardView = (MaterialCardView) activity.getLayoutInflater().inflate(R.layout.macro_edit_entry_bottom, viewGroup2);
                } else {
                    materialCardView = (MaterialCardView) activity.getLayoutInflater().inflate(R.layout.macro_edit_entry, viewGroup2);
                }
                MaterialCardView materialCardView3 = materialCardView;
                TextView textView2 = (TextView) materialCardView3.findViewById(R.id.macro_edit_entry_name);
                TextView textView3 = (TextView) materialCardView3.findViewById(i8);
                ImageView imageView = (ImageView) materialCardView3.findViewById(i7);
                materialCardView3.setCardBackgroundColor(activity.getResources().getColor(R.color.condition_primary));
                if (i10 >= i6) {
                    linearLayout.addView(activity.getLayoutInflater().inflate(R.layout.divider, viewGroup2));
                }
                ImageView imageView2 = (ImageView) materialCardView3.findViewById(R.id.macro_edit_warning_icon);
                materialCardView3.setTag(getConstraints().get(i10));
                imageView.setBackgroundResource(R.drawable.circular_icon_background_condition);
                imageView.setImageDrawable(activity.getResources().getDrawable(getConstraints().get(i10).getIcon()));
                imageView.setVisibility(0);
                textView2.setText(getConstraints().get(i10).getEditMacroConfiguredName());
                textView2.setGravity(8388627);
                final Constraint constraint = getConstraints().get(i10);
                materialCardView3.setTag(constraint);
                if (constraint.isValid()) {
                    imageView2.setVisibility(i9);
                } else {
                    imageView2.setVisibility(0);
                }
                if (constraint.getExtendedDetail() != null && constraint.getExtendedDetail().length() > 0) {
                    textView3.setVisibility(0);
                    textView3.setText(getConstraints().get(i10).getExtendedDetail());
                } else {
                    textView3.setVisibility(i9);
                }
                materialCardView3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.p3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ConditionAction.this.Z(constraint, view2);
                    }
                });
                if (constraint.getConstraints() != null && constraint.getConstraints().size() > 0) {
                    i5 = i10;
                    view = materialCardView3;
                    viewGroup = null;
                    g0(constraint, materialCardView3, true, 0, false);
                } else {
                    view = materialCardView3;
                    i5 = i10;
                    viewGroup = null;
                }
                linearLayout.addView(view);
                i10 = i5 + 1;
                viewGroup2 = viewGroup;
                i9 = 8;
                i6 = 1;
                i7 = R.id.macro_edit_entry_icon;
                i8 = R.id.macro_edit_entry_detail;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doDisable() {
        for (Constraint constraint : getConstraints()) {
            constraint.disableConstraintCheckingThreadSafe();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doEnable() {
        for (Constraint constraint : getConstraints()) {
            constraint.enableConstraintCheckingThreadSafe();
        }
    }

    public boolean dontLogIfConditionIsFalse() {
        return this.dontLogIfConditionIsFalse;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == 0) {
            Constraint constraint = this.selectedConstraint;
            if (constraint != null) {
                constraint.handleActivityResult(activity, i4, i5, intent);
            }
            setActivity(activity);
            V(false, false);
            configureConditionsList();
            return;
        }
        Constraint constraint2 = this.selectedConstraint;
        if (constraint2 != null) {
            constraint2.handleActivityResult(activity, i4, i5, intent);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        for (Constraint constraint : getConstraints()) {
            if (!constraint.isValid()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        super.itemComplete();
        Macro macro = this.m_macro;
        if (macro != null) {
            macro.setActionBeingConfigured(null);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.dontLogIfConditionIsFalse ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConditionAction(Parcel parcel) {
        super(parcel);
        this.dontLogIfConditionIsFalse = parcel.readInt() == 1;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SpannableString getListModeNameCharSequence() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Y());
        spannableStringBuilder.append((CharSequence) "{");
        List<Action> childActions = getChildActions();
        int size = childActions.size();
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            Action action = childActions.get(i4);
            if (z3) {
                if (action instanceof EndParentAction) {
                    z3 = false;
                }
            } else if (action instanceof ElseAction) {
                if (spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                    spannableStringBuilder.delete(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                }
                spannableStringBuilder.append((CharSequence) "} ");
                spannableStringBuilder.append((CharSequence) SelectableItem.r(R.string.action_if_else));
                spannableStringBuilder.append((CharSequence) " {");
            } else if (action instanceof ElseIfConditionAction) {
                if (spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                    spannableStringBuilder.delete(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                }
                spannableStringBuilder.append((CharSequence) "} ");
                spannableStringBuilder.append((CharSequence) ((ElseIfConditionAction) action).Y());
                spannableStringBuilder.append((CharSequence) " {");
            } else if (action instanceof ParentAction) {
                spannableStringBuilder.append((CharSequence) action.getListModeName());
                z3 = true;
            } else {
                String listModeName = action.getListModeName();
                if (action.isEnabled()) {
                    spannableStringBuilder.append((CharSequence) listModeName);
                } else {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) listModeName);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity() != null ? getActivity() : getContext(), R.color.disabled_action_color)), length, spannableStringBuilder.length(), 33);
                }
                if (i4 < size - 1) {
                    spannableStringBuilder.append((CharSequence) ", ");
                }
            }
        }
        spannableStringBuilder.append((CharSequence) "}");
        return SpannableString.valueOf(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            ConditionAction conditionAction = ConditionAction.this;
            boolean z3 = true;
            if (i4 != 1) {
                z3 = false;
            }
            conditionAction.tempIsOrCondition = z3;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
