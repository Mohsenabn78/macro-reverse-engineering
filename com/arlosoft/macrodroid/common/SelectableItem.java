package com.arlosoft.macrodroid.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.util.Pair;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ConditionAction;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.interfaces.HasBooleanVariableName;
import com.arlosoft.macrodroid.interfaces.HasDecimalVariableName;
import com.arlosoft.macrodroid.interfaces.HasDictionaryVariableName;
import com.arlosoft.macrodroid.interfaces.HasIntegerVariableName;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.interfaces.HasVariableName;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public abstract class SelectableItem implements Parcelable {
    private static final int MIN_CLICK_DIFF_MS = 1000;
    private transient boolean hasCommentEdited;
    private transient boolean hasEdited;
    private transient boolean isCollapsed;
    private long m_SIGUID;
    private transient WeakReference<Activity> m_activityRef;
    protected String m_classType;
    private String m_comment;
    private List<Constraint> m_constraintList;
    private boolean m_isDisabled;
    private boolean m_isOrCondition;
    private transient long m_lastClickTime;
    protected transient Macro m_macro;
    protected transient boolean m_returnOnComplete;
    private transient String serializedFormBeforeEdit;

    public SelectableItem() {
        this.m_classType = getClass().getSimpleName();
        this.m_lastClickTime = 0L;
        this.hasEdited = false;
        this.hasCommentEdited = false;
        init();
        if (this.m_SIGUID == 0) {
            this.m_SIGUID = UUID.randomUUID().getLeastSignificantBits();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private boolean F(@NonNull String str, @Nullable String str2) {
        if (str2 == null) {
            return false;
        }
        return str2.toLowerCase().contains(str.toLowerCase());
    }

    private void f(VariableValue.Dictionary dictionary, ArrayList<VariableValue.Dictionary> arrayList, ArrayList<String> arrayList2) {
        for (VariableValue.DictionaryEntry dictionaryEntry : dictionary.getEntries()) {
            arrayList2.add(dictionaryEntry.getKey());
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                dictionary.setParentKeys(arrayList2);
                arrayList.add(dictionary);
                f((VariableValue.Dictionary) dictionaryEntry.getVariable(), arrayList, arrayList2);
            }
        }
    }

    @StringRes
    public static int getNoItemsText(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return R.string.no_constraints;
            }
            return R.string.no_actions;
        }
        return R.string.no_triggers;
    }

    private void i(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            t();
            return;
        }
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) activity);
        final String[] permissions = getPermissions();
        if (permissions.length == 0) {
            t();
        } else {
            rxPermissions.request(permissions).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.common.r0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SelectableItem.this.w(permissions, (Boolean) obj);
                }
            });
        }
    }

    private void init() {
        this.m_constraintList = new ArrayList();
    }

    @TargetApi(23)
    private void j() {
        if (!checkActivityAlive()) {
            return;
        }
        Activity activity = getActivity();
        if (!PermissionsHelper.checkForSpecialPermissions(activity, this, true, false)) {
            return;
        }
        i(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean q(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public static String r(int i4) {
        return MacroDroidApplication.getInstance().getString(i4);
    }

    public static void setSettingBoolean(Context context, String str, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str, z3);
        edit.apply();
    }

    private void u() {
        Activity activity = getActivity();
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private boolean v() {
        Macro macro = this.m_macro;
        if (macro != null) {
            return macro.isExcludedFromLog();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(String[] strArr, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            t();
        } else {
            PermissionsHelper.showNeedsPermission(getContext(), strArr[0], getConfiguredName(), true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(DialogInterface dialogInterface, int i4) {
        C(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(DialogInterface dialogInterface, int i4) {
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        if (checkActivityAlive()) {
            secondaryItemConfirmed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(boolean z3) {
        this.m_isOrCondition = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(List<Constraint> list) {
        this.m_constraintList = list;
    }

    public void addConstraint(Constraint constraint) {
        this.m_constraintList.add(constraint);
    }

    public void addVariable(MacroDroidVariable macroDroidVariable) {
        if (this.m_macro != null && macroDroidVariable.isLocalVar()) {
            this.m_macro.getLocalVariables().add(macroDroidVariable);
        } else {
            MacroDroidVariableStore.getInstance().addVariable(macroDroidVariable);
        }
    }

    public boolean allowConfigurationWithoutHelperFile() {
        return false;
    }

    @CallSuper
    public void anonymizeForTemplate() {
        for (Constraint constraint : getConstraints()) {
            constraint.anonymizeForTemplate();
        }
    }

    public void applyImport(boolean z3) {
        if (z3 && doesSupportPreApply()) {
            preApplyImport();
        } else {
            applyImport();
        }
    }

    public boolean canRunWhenInvalid() {
        return false;
    }

    public boolean checkActivityAlive() {
        Activity activity;
        WeakReference<Activity> weakReference = this.m_activityRef;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return false;
        }
        if (!(activity instanceof MacroDroidBaseActivity)) {
            return true;
        }
        return !((MacroDroidBaseActivity) activity).isDestroyedOrFinishing();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkAllPermissions() {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.SelectableItem.checkAllPermissions():boolean");
    }

    public boolean checkOnImport() {
        return true;
    }

    public void clearHasEdited() {
        this.hasEdited = false;
        this.hasCommentEdited = false;
        for (Constraint constraint : getConstraints()) {
            if (constraint != null) {
                constraint.clearHasEdited();
            }
        }
    }

    public boolean constraintsMet(TriggerContextInfo triggerContextInfo) {
        return constraintsMet(triggerContextInfo, false);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean doesSupportPreApply() {
        return false;
    }

    public void forceRemoveConstraint(Constraint constraint) {
        this.m_constraintList.remove(constraint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g(String str, TriggerContextInfo triggerContextInfo) {
        return MagicText.replaceMagicText(getContext(), str, triggerContextInfo, getMacro()).replace("\\n", "\n");
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.m_activityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public List<String> getAdbHackPermissionRequired() {
        return getInfo().getAdbHackPermissionRequired();
    }

    public ArrayList<MacroDroidVariable> getAllArrayVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
                if (macroDroidVariable.isArray()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllArrayVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllBooleanVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
                if (macroDroidVariable.isBoolean()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllBooleanVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllDecimalVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
                if (macroDroidVariable.isDecimal()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllDecimalVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllDictionaryAndArrayVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
                if (macroDroidVariable.isArray() || macroDroidVariable.isDictionary()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllDictionaryAndArrayVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllDictionaryOrArrayVariables(boolean z3) {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariables()) {
                if (z3 && macroDroidVariable.isArray()) {
                    arrayList.add(macroDroidVariable);
                } else if (!z3 && !macroDroidVariable.isArray()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllDictionaryAndArrayVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllDictionaryVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSortedForDirection(false)) {
                if (macroDroidVariable.isDictionary() && !macroDroidVariable.isArray()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllDictionaryVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllInputStringVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSortedForDirection(true)) {
                if (macroDroidVariable.isString()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllStringVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllInputVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            arrayList.addAll(macro.getLocalVariablesForDirection(true));
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllVariables(true));
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllIntegerVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
                if (macroDroidVariable.isInt()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllIntegerVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllOutputBooleanVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSortedForDirection(false)) {
                if (macroDroidVariable.isBoolean()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllBooleanVariables());
        return arrayList;
    }

    public ArrayList<VariableValue.Dictionary> getAllOutputDictionaryAndArrayVariableValues() {
        ArrayList<VariableValue.Dictionary> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSortedForDirection(false)) {
                if (macroDroidVariable.isArray() || macroDroidVariable.isDictionary()) {
                    arrayList.add(macroDroidVariable.getDictionary());
                    f(macroDroidVariable.getDictionary(), arrayList, new ArrayList<>());
                }
            }
        }
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllOutputStringVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSortedForDirection(false)) {
                if (macroDroidVariable.isString()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllStringVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllOutputVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            arrayList.addAll(macro.getLocalVariablesForDirection(false));
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllVariables(true));
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllOutputVariablesWithStrings() {
        ArrayList arrayList = new ArrayList();
        Macro macro = this.m_macro;
        if (macro != null) {
            arrayList.addAll(macro.getLocalVariablesForDirection(false));
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllVariables(true));
        ArrayList<MacroDroidVariable> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MacroDroidVariable macroDroidVariable = (MacroDroidVariable) it.next();
            if (macroDroidVariable.isString() || macroDroidVariable.isDictionary() || macroDroidVariable.isArray()) {
                arrayList2.add(macroDroidVariable);
            }
        }
        return arrayList2;
    }

    public ArrayList<MacroDroidVariable> getAllStringVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
                if (macroDroidVariable.isString()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllStringVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        Macro macro = this.m_macro;
        if (macro != null) {
            arrayList.addAll(macro.getLocalVariablesSorted());
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllVariables(true));
        return arrayList;
    }

    public AppCompatActivity getAppCompatActivity() {
        WeakReference<Activity> weakReference = this.m_activityRef;
        if (weakReference != null) {
            return (AppCompatActivity) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCheckedItemIndex() {
        return 0;
    }

    public String getCollapsedName() {
        return getConfiguredName();
    }

    public String getComment() {
        return this.m_comment;
    }

    public String getConfiguredName() {
        return getName();
    }

    public String getConfiguredNameFlowControl() {
        return getListModeName();
    }

    public List<Constraint> getConstraints() {
        if (this.m_constraintList == null) {
            this.m_constraintList = new ArrayList();
        }
        return this.m_constraintList;
    }

    public Context getContext() {
        return MacroDroidApplication.getInstance();
    }

    public int getDialogTheme() {
        return R.style.Theme_App_Dialog;
    }

    public String getEditMacroConfiguredName() {
        return getConfiguredName();
    }

    public String getEditModeWarning() {
        return null;
    }

    public String getExtendedDetail() {
        return "";
    }

    public boolean getHasCommentEdited() {
        return this.hasCommentEdited;
    }

    public String getHelpInfo() {
        return r(getInfo().getHelpInfo());
    }

    public int getIcon() {
        return getInfo().getIcon();
    }

    public int getImage() {
        return 0;
    }

    public abstract SelectableItemInfo getInfo();

    public String getListModeName() {
        return getConfiguredName();
    }

    public CharSequence getListModeNameCharSequence() {
        return getListModeName();
    }

    public String getLogEntryStart() {
        return "";
    }

    public Macro getMacro() {
        return this.m_macro;
    }

    public Long getMacroGuid() {
        Macro macro = this.m_macro;
        if (macro != null) {
            return Long.valueOf(macro.getGUID());
        }
        return 0L;
    }

    @NonNull
    public String getMacroName() {
        Macro macro = this.m_macro;
        if (macro != null) {
            return macro.getName();
        }
        SystemLog.logWarning("No macro set for " + getConfiguredName() + " cannot get macro name");
        return "";
    }

    public String getName() {
        return r(getInfo().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] getPermissions() {
        return new String[0];
    }

    public String[] getPermissionsOnImport() {
        return new String[0];
    }

    public String[] getRequiredPermissions() {
        return getPermissions();
    }

    public long getSIGUID() {
        if (this.m_SIGUID == 0) {
            this.m_SIGUID = UUID.randomUUID().getLeastSignificantBits();
        }
        return this.m_SIGUID;
    }

    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getListModeName();
    }

    public String getTemplateConfiguredName() {
        return getListModeName();
    }

    public int getTypeFromClass(HasVariableName hasVariableName) {
        if (hasVariableName instanceof HasBooleanVariableName) {
            return 0;
        }
        if (hasVariableName instanceof HasStringVariableName) {
            return 2;
        }
        if (hasVariableName instanceof HasIntegerVariableName) {
            return 1;
        }
        if (hasVariableName instanceof HasDecimalVariableName) {
            return 3;
        }
        if (!(hasVariableName instanceof HasDictionaryVariableName)) {
            return 2;
        }
        return 4;
    }

    public MacroDroidVariable getVariableByName(String str) {
        Macro macro = this.m_macro;
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariables()) {
                if (macroDroidVariable.getName().equals(str)) {
                    return macroDroidVariable;
                }
            }
        }
        return MacroDroidVariableStore.getInstance().getVariableByName(str);
    }

    public List<MacroDroidVariable> getVariablesOfType(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                return new ArrayList();
                            }
                            return getAllArrayVariables();
                        }
                        return getAllDictionaryVariables();
                    }
                    return getAllDecimalVariables();
                }
                return getAllStringVariables();
            }
            return getAllIntegerVariables();
        }
        return getAllBooleanVariables();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String h(String str, TriggerContextInfo triggerContextInfo) {
        return MagicText.replaceMagicText(getContext(), str, triggerContextInfo, getMacro());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleItemSelected() {
        String[] o4 = o();
        if (o4 != null && o4.length > 0) {
            k();
        } else {
            itemComplete();
        }
    }

    public boolean hasAllSpecialPermissions(Activity activity) {
        return PermissionsHelper.checkForSpecialPermissions(activity, this, true, false);
    }

    public boolean hasEdited() {
        return this.hasEdited;
    }

    public boolean hasOptions() {
        return true;
    }

    public IteratorType isChildOfIterateDictionary() {
        return IteratorType.NONE;
    }

    public boolean isCollapsed() {
        return this.isCollapsed;
    }

    public boolean isEnabled() {
        return !this.m_isDisabled;
    }

    public boolean isExperimental() {
        return getInfo().isExperimental();
    }

    public boolean isExtendedHtml() {
        return false;
    }

    public boolean isExtra() {
        Macro macro = this.m_macro;
        if (macro != null) {
            return macro.isExtra();
        }
        return false;
    }

    public boolean isProOnly() {
        return getInfo().isProOnly();
    }

    public boolean isRootOnly() {
        return getInfo().isRootOnly();
    }

    public boolean isRootOnlyWithNoAdbHack() {
        if (getInfo().isRootOnly() && !getInfo().supportsAdbHack()) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void itemComplete() {
        if (!this.hasEdited) {
            setHasEdited(!GsonUtils.getGsonBuilder(false, false).create().toJson(this).equals(this.serializedFormBeforeEdit));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        if (checkActivityAlive()) {
            l();
        }
    }

    protected AlertDialog l() {
        String[] o4 = o();
        if (o4 != null && o4.length != 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(p());
            builder.setSingleChoiceItems(o4, getCheckedItemIndex(), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.n0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    SelectableItem.this.x(dialogInterface, i4);
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.o0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    SelectableItem.this.y(dialogInterface, i4);
                }
            });
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.p0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    SelectableItem.this.z(dialogInterface, i4);
                }
            });
            AlertDialog create = builder.create();
            create.show();
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.common.q0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    SelectableItem.this.A(dialogInterface);
                }
            });
            if (o4.length > 50) {
                ListView listView = create.getListView();
                listView.setFastScrollEnabled(true);
                listView.setPadding(0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.fast_scroll_padding), 0);
                listView.setScrollBarStyle(33554432);
            }
            return create;
        }
        return null;
    }

    protected int m() {
        return R.style.Theme_App_Dialog;
    }

    public boolean matchesSearchText(String str) {
        boolean z3;
        if (!F(str, getConfiguredName()) && !F(str, getName()) && !F(str, getExtendedDetail()) && !F(str, getComment())) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            return true;
        }
        for (Constraint constraint : getConstraints()) {
            if (constraint.matchesSearchText(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n() {
        return this.m_isOrCondition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] o() {
        return null;
    }

    public void onItemSelected() {
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        firebaseCrashlytics.log("onItemSelected - " + getClass().getSimpleName());
        try {
            this.serializedFormBeforeEdit = GsonUtils.getGsonBuilder(false, false).create().toJson(this);
        } catch (Throwable th) {
            FirebaseAnalyticsEventLogger.log("Error in " + getClass().getSimpleName());
            FirebaseAnalyticsEventLogger.logHandledException(th);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > this.m_lastClickTime + 1000) {
            this.m_lastClickTime = currentTimeMillis;
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String p() {
        return getContext().getString(R.string.select_option);
    }

    public void permissionsDenied(String[] strArr, int[] iArr) {
        int i4 = 0;
        while (true) {
            if (i4 < iArr.length) {
                if (iArr[i4] == -1) {
                    break;
                }
                i4++;
            } else {
                i4 = 0;
                break;
            }
        }
        String permissionName = PermissionsHelper.getPermissionName(strArr[i4]);
        Context applicationContext = getContext().getApplicationContext();
        ToastCompat.makeText(applicationContext, (CharSequence) (permissionName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.permission_denied)), 0).show();
    }

    public void permissionsGranted() {
        t();
    }

    public void postApplyImport() {
        applyImport();
    }

    public void removeConstraint(Constraint constraint) {
        this.m_constraintList.remove(constraint);
        constraint.disableConstraintCheckingThreadSafe();
    }

    public boolean requiresAccessNotificationPolicy() {
        return false;
    }

    public boolean requiresAccessibility() {
        return false;
    }

    public boolean requiresCanDrawOverlays() {
        return false;
    }

    public boolean requiresCoarseLocationPermission() {
        for (String str : getPermissions()) {
            if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresDefaultAssist() {
        return false;
    }

    public boolean requiresDeviceAdmin() {
        return false;
    }

    public boolean requiresFineLocationPermission() {
        for (String str : getPermissions()) {
            if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresFingerprintGestureAccessibility() {
        return false;
    }

    public boolean requiresLegacyHelperFile() {
        return false;
    }

    public boolean requiresLocationServicesEnabled() {
        return false;
    }

    public boolean requiresNewHelperFile(int i4) {
        Pair<Integer, String> requiresNewHelperFileVersion = requiresNewHelperFileVersion();
        if (requiresNewHelperFileVersion == null || ((Integer) requiresNewHelperFileVersion.first).intValue() <= i4) {
            return false;
        }
        return true;
    }

    @Nullable
    public Pair<Integer, String> requiresNewHelperFileVersion() {
        return null;
    }

    public boolean requiresNotificationAccess() {
        return false;
    }

    public boolean requiresScheduleExactAlarm() {
        return false;
    }

    public boolean requiresUIInteractionAccessibility() {
        return false;
    }

    public boolean requiresUsageAccess() {
        return false;
    }

    public boolean requiresVolumeButtonAccessibility() {
        return false;
    }

    public boolean requiresWriteSettings() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Trigger> s() {
        if (getMacro() != null) {
            return getMacro().getTriggerList();
        }
        return new ArrayList();
    }

    public void setActivity(Activity activity) {
        this.m_activityRef = new WeakReference<>(activity);
    }

    public void setCollapsed(boolean z3) {
        this.isCollapsed = z3;
    }

    public void setComment(String str) {
        this.m_comment = str;
    }

    public void setEnabled(boolean z3) {
        this.m_isDisabled = !z3;
    }

    public void setGUID(long j4) {
        this.m_SIGUID = j4;
    }

    public void setHasCommentEdited(boolean z3) {
        this.hasCommentEdited = z3;
    }

    public void setHasEdited(boolean z3) {
        this.hasEdited = z3;
    }

    public void setMacro(Macro macro) {
        this.m_macro = macro;
        List<Constraint> list = this.m_constraintList;
        if (list != null) {
            for (Constraint constraint : list) {
                constraint.setMacro(this.m_macro);
            }
        }
    }

    public void setNewGUID() {
        this.m_SIGUID = UUID.randomUUID().getLeastSignificantBits();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        if (checkActivityAlive()) {
            u();
            handleItemSelected();
        }
    }

    public void variableClear(MacroDroidVariable macroDroidVariable) {
        variableUpdate(macroDroidVariable, VariableValue.createForType(macroDroidVariable.getType()));
    }

    public void variableUpdate(MacroDroidVariable macroDroidVariable, VariableValue variableValue) {
        Macro macro = this.m_macro;
        if (macro != null) {
            macro.variableUpdate(macroDroidVariable, variableValue);
        } else {
            MacroDroidVariableStore.getInstance().variableUpdate(macroDroidVariable, variableValue, !v(), getMacro());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.m_SIGUID);
        parcel.writeList(this.m_constraintList);
        parcel.writeInt(this.m_isOrCondition ? 1 : 0);
        parcel.writeInt(this.m_isDisabled ? 1 : 0);
        parcel.writeString(this.m_comment);
        parcel.writeInt(this.isCollapsed ? 1 : 0);
    }

    public boolean constraintsMet(TriggerContextInfo triggerContextInfo, boolean z3) {
        if (this.m_isDisabled) {
            return false;
        }
        if (getConstraints().size() == 0) {
            return true;
        }
        if (!this.m_isOrCondition) {
            for (Constraint constraint : getConstraints()) {
                if (constraint.isEnabled() && !constraint.checkOK(triggerContextInfo)) {
                    if (!getMacro().isExcludedFromLog()) {
                        if (!z3) {
                            SystemLog.logConstraint(getLogEntryStart() + getSystemLogEntryName(triggerContextInfo) + " did not invoke because constraint failed: " + constraint.getSystemLogEntryName(triggerContextInfo), getMacroGuid().longValue());
                        } else if (!(this instanceof ConditionAction) || !((ConditionAction) this).dontLogIfConditionIsFalse()) {
                            SystemLog.logConstraint(getLogEntryStart() + getSystemLogEntryName(triggerContextInfo) + " If condition failed: " + constraint.getConfiguredName() + " (" + this.m_macro.getName() + ")", getMacroGuid().longValue());
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        int i4 = 0;
        for (Constraint constraint2 : getConstraints()) {
            if (constraint2.isEnabled()) {
                i4++;
                if (constraint2.checkOK(triggerContextInfo)) {
                    return true;
                }
            }
        }
        if (i4 > 0 && !getMacro().isExcludedFromLog()) {
            SystemLog.logConstraint(getLogEntryStart() + getSystemLogEntryName(triggerContextInfo) + " did not invoke because no constraints were true (" + getName() + ")", getMacroGuid().longValue());
        }
        return i4 <= 0;
    }

    public void variableClear(MacroDroidVariable macroDroidVariable, List<String> list) {
        VariableValue.DictionaryEntry targetDictionaryEntry = macroDroidVariable.getTargetDictionaryEntry(list, false);
        if (targetDictionaryEntry != null) {
            variableUpdate(macroDroidVariable, VariableValue.createForType(targetDictionaryEntry.getVariable().getVariableType(), list));
        }
    }

    public void applyImport() {
        List<MacroDroidVariable> variables;
        Macro macro;
        Macro macro2;
        if (this instanceof HasVariable) {
            MacroDroidVariable variable = ((HasVariable) this).getVariable();
            if (variable != null && MacroDroidVariableStore.getInstance().getVariableByName(variable.getName()) == null && this.m_macro.findLocalVariableByName(variable.getName()) == null) {
                MacroDroidVariableStore.getInstance().addVariable(variable);
            }
        } else if ((this instanceof HasVariables) && (variables = ((HasVariables) this).getVariables()) != null) {
            for (MacroDroidVariable macroDroidVariable : variables) {
                if (macroDroidVariable != null && MacroDroidVariableStore.getInstance().getVariableByName(macroDroidVariable.getName()) == null && ((macro = this.m_macro) == null || macro.findLocalVariableByName(macroDroidVariable.getName()) == null)) {
                    MacroDroidVariableStore.getInstance().addVariable(macroDroidVariable);
                }
            }
        }
        if (this instanceof HasVariableName) {
            HasVariableName hasVariableName = (HasVariableName) this;
            String variableName = hasVariableName.getVariableName();
            if (variableName != null && MacroDroidVariableStore.getInstance().getVariableByName(variableName) == null && this.m_macro.findLocalVariableByName(variableName) == null) {
                MacroDroidVariableStore.getInstance().addVariable(new MacroDroidVariable(getTypeFromClass(hasVariableName), variableName));
            }
        } else if (this instanceof HasVariableNames) {
            HasVariableNames hasVariableNames = (HasVariableNames) this;
            String[] variableNames = hasVariableNames.getVariableNames();
            for (int i4 = 0; i4 < variableNames.length; i4++) {
                String str = variableNames[i4];
                if (str != null && !str.isEmpty() && MacroDroidVariableStore.getInstance().getVariableByName(str) == null && ((macro2 = this.m_macro) == null || macro2.findLocalVariableByName(str) == null)) {
                    MacroDroidVariableStore.getInstance().addVariable(new MacroDroidVariable(hasVariableNames.getVariableTypes()[i4].intValue(), str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SelectableItem(Parcel parcel) {
        this();
        init();
        this.m_SIGUID = parcel.readLong();
        this.m_constraintList = parcel.readArrayList(Constraint.class.getClassLoader());
        this.m_isOrCondition = parcel.readInt() != 0;
        this.m_isDisabled = parcel.readInt() != 0;
        this.m_comment = parcel.readString();
        this.isCollapsed = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(int i4) {
    }

    public void handleItemComplete(Object obj) {
    }

    public void moveItem(boolean z3) {
    }

    public void configureForExport() {
    }

    public void configureOnImport() {
    }

    public void handleItemCancel() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOptionsDialogCancelled() {
    }

    public void handleWarningClick() {
    }

    public void preApplyImport() {
    }

    public void refresh() {
    }

    protected void secondaryItemConfirmed() {
    }

    public void templateSelected() {
    }

    public void handleActivityResult(Activity activity, int i4, int i5, @Nullable Intent intent) {
    }
}
