package com.arlosoft.macrodroid.variables;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeyStrings;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.interfaces.HasVariableName;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.koushikdutta.ion.loader.MtpConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;
import org.apmem.tools.layouts.FlowLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MacroVariableAdapter.java */
/* loaded from: classes3.dex */
public class p extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f16358a;

    /* renamed from: b  reason: collision with root package name */
    private List<MacroDroidVariable> f16359b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, List<Macro>> f16360c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16361d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16362e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16363f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16364g;

    /* renamed from: h  reason: collision with root package name */
    private Macro f16365h;

    /* renamed from: i  reason: collision with root package name */
    private String f16366i;

    /* renamed from: j  reason: collision with root package name */
    private int f16367j = -1;

    /* renamed from: k  reason: collision with root package name */
    private com.arlosoft.macrodroid.variables.a f16368k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16369l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroVariableAdapter.java */
    /* loaded from: classes3.dex */
    public class b implements DictionaryEventListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f16372a;

        b(MacroDroidVariable macroDroidVariable) {
            this.f16372a = macroDroidVariable;
        }

        @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
        public void dictionaryDeleted() {
            MacroDroidVariableStore.getInstance().removeVariable(this.f16372a.getName());
            p.this.notifyDataSetChanged();
        }

        @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
        public void entriesCleared() {
            p.this.notifyDataSetChanged();
        }

        @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
        public void entryRemoved(@NonNull VariableValue.DictionaryEntry dictionaryEntry) {
            p.this.notifyDataSetChanged();
        }

        @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
        public void entryUpdated(@NonNull VariableValue.DictionaryEntry dictionaryEntry, @Nullable VariableValue.DictionaryEntry dictionaryEntry2) {
            p.this.notifyDataSetChanged();
        }

        @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
        public void refreshRequired() {
            p.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroVariableAdapter.java */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        CardView f16376a;

        /* renamed from: b  reason: collision with root package name */
        TextView f16377b;

        /* renamed from: c  reason: collision with root package name */
        TextView f16378c;

        /* renamed from: d  reason: collision with root package name */
        Button f16379d;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroVariableAdapter.java */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        TextView f16380a;

        /* renamed from: b  reason: collision with root package name */
        TextView f16381b;

        /* renamed from: c  reason: collision with root package name */
        Spinner f16382c;

        /* renamed from: d  reason: collision with root package name */
        ImageButton f16383d;

        /* renamed from: e  reason: collision with root package name */
        FlowLayout f16384e;

        /* renamed from: f  reason: collision with root package name */
        TextView f16385f;

        /* renamed from: g  reason: collision with root package name */
        TextView f16386g;

        e() {
        }
    }

    public p(Activity activity, Macro macro, boolean z3, com.arlosoft.macrodroid.variables.a aVar) {
        this.f16369l = true;
        this.f16358a = activity;
        this.f16365h = macro;
        H(macro);
        this.f16361d = activity.getResources().getColor(R.color.white);
        this.f16362e = activity.getResources().getColor(R.color.action_block_link);
        this.f16363f = activity.getResources().getDimensionPixelSize(R.dimen.margin_small);
        this.f16364g = activity.getResources().getDimensionPixelSize(R.dimen.margin_micro);
        this.f16369l = z3;
        this.f16368k = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(MacroDroidVariable macroDroidVariable, View view) {
        p(macroDroidVariable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(View view) {
        if (this.f16365h != null) {
            this.f16359b = MacroDroidVariableStore.getInstance().getAllVariables(this.f16365h, true);
        } else {
            this.f16359b = MacroDroidVariableStore.getInstance().getAllVariables(true);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(MacroDroidVariable macroDroidVariable, e eVar, View view) {
        if (this.f16359b.size() > 0) {
            if (!macroDroidVariable.isDictionary() && !macroDroidVariable.isArray()) {
                VariableHelper.promptForNewValue(this.f16358a, macroDroidVariable, null, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        p.this.B(view2);
                    }
                }, false, null);
                eVar.f16381b.clearFocus();
                return;
            }
            VariableHelper.showDictionaryEditScreen(this.f16358a, this.f16365h, macroDroidVariable, macroDroidVariable.getName(), macroDroidVariable.getName(), macroDroidVariable.getDictionary(), false, null, new ArrayList(), new b(macroDroidVariable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(Macro macro, View view) {
        G(macro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(Context context, MacroDroidVariable macroDroidVariable, List list, View view) {
        r(context, macroDroidVariable, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Macro macro) {
        if (macro.isActionBlock) {
            Activity activity = this.f16358a;
            activity.startActivity(ActionBlockEditActivity.getIntent(activity, true, (ActionBlock) macro, false));
            return;
        }
        Intent intent = new Intent(this.f16358a, EditMacroActivity.class);
        intent.putExtra("MacroId", macro.getId());
        this.f16358a.startActivity(intent);
    }

    private void G(Macro macro) {
        Cache cache = MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE);
        CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList == null) {
            categoryList = new CategoryList(new ArrayList());
        }
        Category categoryByName = categoryList.getCategoryByName(macro.getCategory());
        if (categoryByName != null && categoryByName.isLocked()) {
            CategoryPasswordHelper categoryPasswordHelper = new CategoryPasswordHelper(cache, null);
            Activity activity = this.f16358a;
            categoryPasswordHelper.promptForCategoryPassword(activity, activity.getString(R.string.enter_category_lock_password), "", Settings.getLockedCategoryPassword(this.f16358a), 0, new c(macro));
            return;
        }
        F(macro);
    }

    private static void I(SelectableItem selectableItem, String str) {
        List<String> keys;
        List<String> keys2;
        if (selectableItem instanceof SupportsMagicText) {
            SupportsMagicText supportsMagicText = (SupportsMagicText) selectableItem;
            String[] possibleMagicText = supportsMagicText.getPossibleMagicText();
            for (int i4 = 0; i4 < possibleMagicText.length; i4++) {
                if (!TextUtils.isEmpty(possibleMagicText[i4])) {
                    if (possibleMagicText[i4].contains("[v=" + str)) {
                        possibleMagicText[i4] = possibleMagicText[i4].replace("[v=" + str, "[lv=" + str);
                    }
                }
                if (!TextUtils.isEmpty(possibleMagicText[i4])) {
                    if (possibleMagicText[i4].contains("{v=" + str)) {
                        possibleMagicText[i4] = possibleMagicText[i4].replace("{v=" + str, "{lv=" + str);
                    }
                }
            }
            supportsMagicText.setPossibleMagicText(possibleMagicText);
        }
        if (selectableItem instanceof HasMultipleDictionaryKeys) {
            HasMultipleDictionaryKeys hasMultipleDictionaryKeys = (HasMultipleDictionaryKeys) selectableItem;
            DictionaryKeys[] dictionaryKeys = hasMultipleDictionaryKeys.getDictionaryKeys();
            if (dictionaryKeys != null) {
                for (DictionaryKeys dictionaryKeys2 : dictionaryKeys) {
                    if (dictionaryKeys2 != null && (keys2 = dictionaryKeys2.getKeys()) != null && !keys2.isEmpty()) {
                        for (int i5 = 0; i5 < keys2.size(); i5++) {
                            if (keys2.get(i5).contains("[v=" + str)) {
                                keys2.set(i5, keys2.get(i5).replace("[v=" + str, "[lv=" + str));
                            }
                            if (keys2.get(i5).contains("{v=" + str)) {
                                keys2.set(i5, keys2.get(i5).replace("{v=" + str, "{lv=" + str));
                            }
                        }
                    }
                }
            }
            hasMultipleDictionaryKeys.setDictionaryKeys(dictionaryKeys);
        }
        if (selectableItem instanceof HasDictionaryKeys) {
            HasDictionaryKeys hasDictionaryKeys = (HasDictionaryKeys) selectableItem;
            DictionaryKeys dictionaryKeys3 = hasDictionaryKeys.getDictionaryKeys();
            if (dictionaryKeys3 != null && (keys = dictionaryKeys3.getKeys()) != null && !keys.isEmpty()) {
                for (int i6 = 0; i6 < keys.size(); i6++) {
                    if (keys.get(i6).contains("[v=" + str)) {
                        keys.set(i6, keys.get(i6).replace("[v=" + str, "[lv=" + str));
                    }
                    if (keys.get(i6).contains("{v=" + str)) {
                        keys.set(i6, keys.get(i6).replace("{v=" + str, "{lv=" + str));
                    }
                }
            }
            hasDictionaryKeys.setDictionaryKeys(dictionaryKeys3);
        }
        if (selectableItem instanceof HasDictionaryKeyStrings) {
            HasDictionaryKeyStrings hasDictionaryKeyStrings = (HasDictionaryKeyStrings) selectableItem;
            List<String> dictionaryKeyStrings = hasDictionaryKeyStrings.getDictionaryKeyStrings();
            if (dictionaryKeyStrings != null) {
                for (int i7 = 0; i7 < dictionaryKeyStrings.size(); i7++) {
                    if (dictionaryKeyStrings.get(i7).contains("[v=" + str)) {
                        dictionaryKeyStrings.set(i7, dictionaryKeyStrings.get(i7).replace("[v=" + str, "[lv=" + str));
                    }
                    if (dictionaryKeyStrings.get(i7).contains("{v=" + str)) {
                        dictionaryKeyStrings.set(i7, dictionaryKeyStrings.get(i7).replace("{v=" + str, "{lv=" + str));
                    }
                }
            }
            hasDictionaryKeyStrings.setDictionaryKeyStrings(dictionaryKeyStrings);
        }
    }

    private void l(MacroDroidVariable macroDroidVariable, Macro macro) {
        if (macroDroidVariable != null && macro != null) {
            List<Macro> list = this.f16360c.get(macroDroidVariable.getName());
            boolean z3 = true;
            if (list == null) {
                list = new ArrayList<>();
            } else {
                Iterator<Macro> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().equals(macro)) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3) {
                list.add(macro);
                this.f16360c.put(macroDroidVariable.getName(), list);
            }
        }
    }

    private void m(Constraint constraint, Macro macro) {
        String[] possibleMagicText;
        if (constraint instanceof HasVariable) {
            l(((HasVariable) constraint).getVariable(), macro);
        }
        if (constraint instanceof HasVariables) {
            for (MacroDroidVariable macroDroidVariable : ((HasVariables) constraint).getVariables()) {
                l(macroDroidVariable, macro);
            }
        }
        if (constraint instanceof SupportsMagicText) {
            for (String str : ((SupportsMagicText) constraint).getPossibleMagicText()) {
                for (MacroDroidVariable macroDroidVariable2 : this.f16359b) {
                    if (!TextUtils.isEmpty(str)) {
                        if (!str.contains("[v=" + macroDroidVariable2.getName() + "]")) {
                            if (!str.contains("{v=" + macroDroidVariable2.getName() + "}")) {
                                if (!str.contains("[v=" + macroDroidVariable2.getName() + "[")) {
                                    if (str.contains("{v=" + macroDroidVariable2.getName() + "[")) {
                                    }
                                }
                            }
                        }
                        l(macroDroidVariable2, macro);
                        break;
                    }
                }
            }
        }
        if (constraint instanceof LogicConstraint) {
            for (Constraint constraint2 : ((LogicConstraint) constraint).getConstraints()) {
                m(constraint2, macro);
            }
        }
        n(constraint);
    }

    private void n(SelectableItem selectableItem) {
        DictionaryKeys[] dictionaryKeys;
        if (selectableItem instanceof HasDictionaryKeys) {
            HasDictionaryKeys hasDictionaryKeys = (HasDictionaryKeys) selectableItem;
            if (hasDictionaryKeys.getDictionaryKeys() != null) {
                for (String str : hasDictionaryKeys.getDictionaryKeys().getKeys()) {
                    if (str != null) {
                        for (MacroDroidVariable macroDroidVariable : this.f16359b) {
                            if (!TextUtils.isEmpty(str)) {
                                if (!str.contains("[v=" + macroDroidVariable.getName() + "]")) {
                                    if (!str.contains("{v=" + macroDroidVariable.getName() + "}")) {
                                        if (!str.contains("[v=" + macroDroidVariable.getName() + "[")) {
                                            if (str.contains("{v=" + macroDroidVariable.getName() + "[")) {
                                            }
                                        }
                                    }
                                }
                                l(macroDroidVariable, selectableItem.getMacro());
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (selectableItem instanceof HasDictionaryKeyStrings) {
            HasDictionaryKeyStrings hasDictionaryKeyStrings = (HasDictionaryKeyStrings) selectableItem;
            if (hasDictionaryKeyStrings.getDictionaryKeyStrings() != null) {
                for (String str2 : hasDictionaryKeyStrings.getDictionaryKeyStrings()) {
                    if (str2 != null) {
                        for (MacroDroidVariable macroDroidVariable2 : this.f16359b) {
                            if (!TextUtils.isEmpty(str2)) {
                                if (!str2.contains("[v=" + macroDroidVariable2.getName() + "]")) {
                                    if (!str2.contains("{v=" + macroDroidVariable2.getName() + "}")) {
                                        if (!str2.contains("[v=" + macroDroidVariable2.getName() + "[")) {
                                            if (str2.contains("{v=" + macroDroidVariable2.getName() + "[")) {
                                            }
                                        }
                                    }
                                }
                                l(macroDroidVariable2, selectableItem.getMacro());
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (selectableItem instanceof HasMultipleDictionaryKeys) {
            for (DictionaryKeys dictionaryKeys2 : ((HasMultipleDictionaryKeys) selectableItem).getDictionaryKeys()) {
                if (dictionaryKeys2 != null) {
                    for (String str3 : dictionaryKeys2.getKeys()) {
                        if (str3 != null) {
                            for (MacroDroidVariable macroDroidVariable3 : this.f16359b) {
                                if (!TextUtils.isEmpty(str3)) {
                                    if (!str3.contains("[v=" + macroDroidVariable3.getName() + "]")) {
                                        if (!str3.contains("{v=" + macroDroidVariable3.getName() + "}")) {
                                            if (!str3.contains("[v=" + macroDroidVariable3.getName() + "[")) {
                                                if (str3.contains("{v=" + macroDroidVariable3.getName() + "[")) {
                                                }
                                            }
                                        }
                                    }
                                    l(macroDroidVariable3, selectableItem.getMacro());
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void o(Trigger trigger, Macro macro) {
        String[] possibleMagicText;
        String[] strArr;
        String[] variableNames;
        MacroDroidVariable variableByName;
        String variableName;
        MacroDroidVariable variableByName2;
        if (trigger instanceof HasVariable) {
            l(((HasVariable) trigger).getVariable(), macro);
        }
        if ((trigger instanceof HasVariableName) && (variableName = ((HasVariableName) trigger).getVariableName()) != null && (variableByName2 = MacroDroidVariableStore.getInstance().getVariableByName(variableName)) != null) {
            l(variableByName2, macro);
        }
        if (trigger instanceof HasVariables) {
            for (MacroDroidVariable macroDroidVariable : ((HasVariables) trigger).getVariables()) {
                l(macroDroidVariable, macro);
            }
        }
        if (trigger instanceof HasVariableNames) {
            for (String str : ((HasVariableNames) trigger).getVariableNames()) {
                if (str != null && (variableByName = MacroDroidVariableStore.getInstance().getVariableByName(str)) != null) {
                    l(variableByName, macro);
                }
            }
        }
        boolean z3 = trigger instanceof SupportsMagicText;
        if (z3) {
            String[] possibleMagicText2 = ((SupportsMagicText) trigger).getPossibleMagicText();
            int length = possibleMagicText2.length;
            for (int i4 = 0; i4 < length; i4++) {
                String str2 = possibleMagicText2[i4];
                for (MacroDroidVariable macroDroidVariable2 : this.f16359b) {
                    if (!TextUtils.isEmpty(str2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("[v=");
                        strArr = possibleMagicText2;
                        sb.append(macroDroidVariable2.getName());
                        sb.append("]");
                        if (!str2.contains(sb.toString())) {
                            if (!str2.contains("{v=" + macroDroidVariable2.getName() + "}")) {
                                if (!str2.contains("[v=" + macroDroidVariable2.getName() + "[")) {
                                    if (!str2.contains("{v=" + macroDroidVariable2.getName() + "[")) {
                                    }
                                }
                            }
                        }
                        l(macroDroidVariable2, macro);
                    } else {
                        strArr = possibleMagicText2;
                    }
                    possibleMagicText2 = strArr;
                }
            }
        }
        if (z3) {
            for (String str3 : ((SupportsMagicText) trigger).getPossibleMagicText()) {
                for (MacroDroidVariable macroDroidVariable3 : this.f16359b) {
                    if (!TextUtils.isEmpty(str3)) {
                        if (!str3.contains("[v=" + macroDroidVariable3.getName() + "]")) {
                            if (!str3.contains("{v=" + macroDroidVariable3.getName() + "}")) {
                                if (!str3.contains("[v=" + macroDroidVariable3.getName() + "[")) {
                                    if (str3.contains("{v=" + macroDroidVariable3.getName() + "[")) {
                                    }
                                }
                            }
                        }
                        l(macroDroidVariable3, macro);
                    }
                }
            }
        }
        n(trigger);
        for (Constraint constraint : trigger.getConstraints()) {
            m(constraint, macro);
        }
    }

    private void p(final MacroDroidVariable macroDroidVariable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f16358a, R.style.Theme_App_Dialog_Variables);
        builder.setTitle(R.string.delete_variable);
        builder.setMessage(this.f16358a.getString(R.string.are_you_sure_delete_variable));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                p.this.v(macroDroidVariable, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private static void q(Constraint constraint, String str) {
        I(constraint, str);
        if (constraint instanceof LogicConstraint) {
            for (Constraint constraint2 : ((LogicConstraint) constraint).getConstraints()) {
                q(constraint2, str);
            }
        }
    }

    private void r(Context context, MacroDroidVariable macroDroidVariable, List<Macro> list) {
        macroDroidVariable.setLocalVar(true);
        if (list.get(0).isActionBlock) {
            macroDroidVariable.setIsActionBlockWorkingVar(true);
        }
        list.get(0).getLocalVariables().add(macroDroidVariable);
        MacroStore.getInstance().updateMacro(list.get(0), true);
        MacroDroidVariableStore.getInstance().removeVariable(macroDroidVariable.getName());
        if (this.f16365h != null) {
            this.f16359b = MacroDroidVariableStore.getInstance().getAllVariables(this.f16365h, true);
        } else {
            this.f16359b = MacroDroidVariableStore.getInstance().getAllVariables(true);
        }
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                I(next, macroDroidVariable.getName());
                for (Constraint constraint : next.getConstraints()) {
                    q(constraint, macroDroidVariable.getName());
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                Action next2 = it2.next();
                I(next2, macroDroidVariable.getName());
                for (Constraint constraint2 : next2.getConstraints()) {
                    q(constraint2, macroDroidVariable.getName());
                }
            }
            for (Constraint constraint3 : macro.getConstraints()) {
                q(constraint3, macroDroidVariable.getName());
            }
        }
        try {
            ToastCompat.makeText(context, (CharSequence) String.format(context.getString(R.string.variable_added_as_local_to_macro), list.get(0).getName()), 0).show();
        } catch (Exception unused) {
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(MacroDroidVariable macroDroidVariable, DialogInterface dialogInterface, int i4) {
        MacroDroidVariableStore.getInstance().removeVariable(macroDroidVariable.getName());
        if (this.f16365h != null) {
            this.f16359b = MacroDroidVariableStore.getInstance().getAllVariables(this.f16365h, true);
        } else {
            this.f16359b = MacroDroidVariableStore.getInstance().getAllVariables(true);
        }
        notifyDataSetChanged();
        this.f16368k.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        Settings.hideInfoCardVariables(view.getContext());
        this.f16369l = false;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        H(this.f16365h);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(MacroDroidVariable macroDroidVariable, View view) {
        VariableHelper.promptForNewName(this.f16358a, this.f16365h, macroDroidVariable, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.this.y(view2);
            }
        });
    }

    public void H(@Nullable Macro macro) {
        List<MacroDroidVariable> allVariables;
        String[] possibleMagicText;
        String[] variableNames;
        MacroDroidVariable variableByName;
        String variableName;
        MacroDroidVariable variableByName2;
        this.f16365h = macro;
        if (macro != null) {
            allVariables = MacroDroidVariableStore.getInstance().getAllVariables(macro, true);
        } else {
            allVariables = MacroDroidVariableStore.getInstance().getAllVariables(true);
        }
        this.f16359b = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : allVariables) {
            if (TextUtils.isEmpty(this.f16366i) || macroDroidVariable.getName().toLowerCase().contains(this.f16366i.toLowerCase())) {
                int i4 = this.f16367j;
                if (i4 < 0 || i4 == macroDroidVariable.getType()) {
                    this.f16359b.add(macroDroidVariable);
                }
            }
        }
        this.f16360c = new HashMap<>();
        for (Macro macro2 : MacroStore.getInstance().getAllMacrosWithActionBlocksSortedMacrosFirst()) {
            Iterator<Trigger> it = macro2.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                o(it.next(), macro2);
            }
            Iterator<Action> it2 = macro2.getActions().iterator();
            while (it2.hasNext()) {
                Action next = it2.next();
                if (next instanceof HasVariable) {
                    l(((HasVariable) next).getVariable(), macro2);
                }
                if (next instanceof HasVariables) {
                    for (MacroDroidVariable macroDroidVariable2 : ((HasVariables) next).getVariables()) {
                        l(macroDroidVariable2, macro2);
                    }
                }
                if ((next instanceof HasVariableName) && (variableName = ((HasVariableName) next).getVariableName()) != null && (variableByName2 = MacroDroidVariableStore.getInstance().getVariableByName(variableName)) != null) {
                    l(variableByName2, macro2);
                }
                if (next instanceof HasVariableNames) {
                    for (String str : ((HasVariableNames) next).getVariableNames()) {
                        if (str != null && (variableByName = MacroDroidVariableStore.getInstance().getVariableByName(str)) != null) {
                            l(variableByName, macro2);
                        }
                    }
                }
                if (next instanceof SupportsMagicText) {
                    for (String str2 : ((SupportsMagicText) next).getPossibleMagicText()) {
                        for (MacroDroidVariable macroDroidVariable3 : this.f16359b) {
                            if (!TextUtils.isEmpty(str2)) {
                                if (!str2.contains("[v=" + macroDroidVariable3.getName() + "]")) {
                                    if (!str2.contains("{v=" + macroDroidVariable3.getName() + "}")) {
                                        if (!str2.contains("[v=" + macroDroidVariable3.getName() + "[")) {
                                            if (str2.contains("{v=" + macroDroidVariable3.getName() + "[")) {
                                            }
                                        }
                                    }
                                }
                                l(macroDroidVariable3, macro2);
                            }
                        }
                    }
                }
                if (next instanceof WaitUntilTriggerAction) {
                    Iterator<Trigger> it3 = ((WaitUntilTriggerAction) next).getTriggersToWaitFor().iterator();
                    while (it3.hasNext()) {
                        o(it3.next(), macro2);
                    }
                }
                n(next);
                for (Constraint constraint : next.getConstraints()) {
                    m(constraint, macro2);
                }
            }
            for (Constraint constraint2 : macro2.getConstraints()) {
                m(constraint2, macro2);
            }
        }
    }

    public void J(String str) {
        this.f16366i = str;
    }

    public void K(int i4) {
        this.f16367j = i4;
    }

    public View L(int i4, View view, ViewGroup viewGroup) {
        final e eVar;
        int i5;
        final MacroDroidVariable macroDroidVariable = this.f16359b.get(i4);
        if (view != null && !(view.getTag() instanceof d)) {
            eVar = (e) view.getTag();
        } else {
            view = ((LayoutInflater) this.f16358a.getSystemService("layout_inflater")).inflate(R.layout.variable_cell, (ViewGroup) null);
            eVar = new e();
            eVar.f16380a = (TextView) view.findViewById(R.id.variable_cell_variable_name);
            eVar.f16381b = (TextView) view.findViewById(R.id.variable_cell_variable_value);
            eVar.f16382c = (Spinner) view.findViewById(R.id.variable_cell_variable_boolean_spinner);
            eVar.f16383d = (ImageButton) view.findViewById(R.id.variable_cell_delete_button);
            eVar.f16384e = (FlowLayout) view.findViewById(R.id.variable_cell_macro_list);
            eVar.f16385f = (TextView) view.findViewById(R.id.variable_cell_badge);
            eVar.f16386g = (TextView) view.findViewById(R.id.convert_to_local);
            view.setTag(eVar);
        }
        eVar.f16380a.setText(macroDroidVariable.getName());
        eVar.f16380a.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.this.z(macroDroidVariable, view2);
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16358a.getString(R.string.false_label));
        arrayList.add(this.f16358a.getString(R.string.true_label));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f16358a, (int) R.layout.simple_spinner_item_white_text_variables, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        eVar.f16382c.setAdapter((SpinnerAdapter) arrayAdapter);
        TextView textView = eVar.f16381b;
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.white));
        int type = macroDroidVariable.getType();
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4 || type == 5) {
                            eVar.f16382c.setVisibility(8);
                            eVar.f16381b.setVisibility(0);
                            eVar.f16381b.setText(String.format(this.f16358a.getString(R.string.variable_multi_entry_num_entries), Integer.valueOf(macroDroidVariable.getDictionary().getEntries().size())));
                        }
                    } else {
                        eVar.f16382c.setVisibility(8);
                        eVar.f16381b.setText(String.valueOf(macroDroidVariable.getDecimalValue()));
                        eVar.f16381b.setVisibility(0);
                        eVar.f16381b.setInputType(MtpConstants.FORMAT_SCRIPT);
                    }
                } else {
                    eVar.f16382c.setVisibility(8);
                    eVar.f16381b.setText(macroDroidVariable.getStringValueIgnoreMagicText().substring(0, Math.min(macroDroidVariable.getStringValueIgnoreMagicText().length(), 80)));
                    eVar.f16381b.setVisibility(0);
                    eVar.f16381b.setRawInputType(524288);
                    if (TextUtils.isEmpty(macroDroidVariable.getStringValueIgnoreMagicText())) {
                        String string = eVar.f16381b.getContext().getString(R.string.empty);
                        eVar.f16381b.setText(string.substring(0, 1).toUpperCase() + string.substring(1));
                        TextView textView2 = eVar.f16381b;
                        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), R.color.white_very_transparent));
                    }
                }
            } else {
                eVar.f16382c.setVisibility(8);
                eVar.f16381b.setText(String.valueOf(macroDroidVariable.getLongValue()));
                eVar.f16381b.setVisibility(0);
                eVar.f16381b.setRawInputType(2);
            }
        } else {
            eVar.f16382c.setVisibility(0);
            eVar.f16381b.setVisibility(8);
            eVar.f16382c.setSelection(macroDroidVariable.getBooleanValue() ? 1 : 0);
        }
        eVar.f16385f.setText(macroDroidVariable.getTypeAsString(this.f16358a));
        eVar.f16382c.setOnItemSelectedListener(new a(macroDroidVariable));
        eVar.f16383d.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.this.A(macroDroidVariable, view2);
            }
        });
        eVar.f16381b.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.this.C(macroDroidVariable, eVar, view2);
            }
        });
        eVar.f16384e.removeAllViews();
        final List<Macro> list = this.f16360c.get(macroDroidVariable.getName());
        if (list != null) {
            for (final Macro macro : list) {
                TextView textView3 = new TextView(this.f16358a);
                textView3.setText(macro.getName());
                if (macro.isActionBlock) {
                    i5 = this.f16362e;
                } else {
                    i5 = this.f16361d;
                }
                textView3.setTextColor(i5);
                textView3.setTextSize(12.0f);
                textView3.setPaintFlags(textView3.getPaintFlags() | 8);
                int i6 = this.f16363f;
                int i7 = this.f16364g;
                textView3.setPadding(i6, i7, i6, i7);
                eVar.f16384e.addView(textView3, -2, -2);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        p.this.D(macro, view2);
                    }
                });
            }
            if (list.size() == 1) {
                eVar.f16386g.setVisibility(0);
                TextView textView4 = eVar.f16386g;
                textView4.setPaintFlags(8 | textView4.getPaintFlags());
                final Context context = view.getContext();
                eVar.f16386g.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        p.this.E(context, macroDroidVariable, list, view2);
                    }
                });
            } else {
                eVar.f16386g.setVisibility(8);
            }
        } else {
            eVar.f16386g.setVisibility(8);
            TextView textView5 = new TextView(this.f16358a);
            textView5.setText("(" + this.f16358a.getString(R.string.not_used) + ")");
            textView5.setTextSize(12.0f);
            textView5.setTextColor(this.f16361d);
            int i8 = this.f16363f;
            int i9 = this.f16364g;
            textView5.setPadding(i8, i9, i8, i9);
            eVar.f16384e.addView(textView5);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16359b.size() + (this.f16369l ? 1 : 0);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return this.f16359b.get(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i4) {
        if (i4 == 0 && this.f16369l) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (getItemViewType(i4) == 0) {
            return u(i4, view, viewGroup);
        }
        return L(i4 - (this.f16369l ? 1 : 0), view, viewGroup);
    }

    public HashMap<String, List<Macro>> s() {
        return this.f16360c;
    }

    public int t(MacroDroidVariable macroDroidVariable) {
        for (int i4 = 0; i4 < this.f16359b.size(); i4++) {
            if (macroDroidVariable == this.f16359b.get(i4)) {
                return i4;
            }
        }
        return 0;
    }

    public View u(int i4, View view, ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) this.f16358a.getSystemService("layout_inflater")).inflate(R.layout.info_card_wrapper, viewGroup, false);
        d dVar = new d();
        dVar.f16376a = (CardView) inflate.findViewById(R.id.infoCardView);
        dVar.f16377b = (TextView) inflate.findViewById(R.id.infoCardTitle);
        dVar.f16378c = (TextView) inflate.findViewById(R.id.infoCardDetail);
        dVar.f16379d = (Button) inflate.findViewById(R.id.infoCardGotIt);
        dVar.f16376a.setCardBackgroundColor(ContextCompat.getColor(inflate.getContext(), R.color.variables_primary));
        dVar.f16377b.setText(R.string.variables);
        dVar.f16378c.setText(R.string.variables_info_card);
        dVar.f16379d.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.this.x(view2);
            }
        });
        inflate.getContext().getResources().getDimension(R.dimen.margin_tiny);
        ((ViewGroup.MarginLayoutParams) dVar.f16376a.getLayoutParams()).setMargins(0, 0, 0, 0);
        inflate.setTag(dVar);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroVariableAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f16370a;

        a(MacroDroidVariable macroDroidVariable) {
            this.f16370a = macroDroidVariable;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            boolean z3;
            MacroDroidVariableStore macroDroidVariableStore = MacroDroidVariableStore.getInstance();
            MacroDroidVariable macroDroidVariable = this.f16370a;
            if (i4 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            macroDroidVariableStore.variableUpdate(macroDroidVariable, new VariableValue.BooleanValue(z3, null), true, null);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroVariableAdapter.java */
    /* loaded from: classes3.dex */
    public class c implements CategoryPasswordHelper.PasswordListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Macro f16374a;

        c(Macro macro) {
            this.f16374a = macro;
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            p.this.F(this.f16374a);
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }
}
