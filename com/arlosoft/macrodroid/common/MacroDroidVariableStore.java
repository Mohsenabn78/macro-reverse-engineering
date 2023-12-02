package com.arlosoft.macrodroid.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.AtomicFile;
import com.android.dex.DexFormat;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.interfaces.HasVariableName;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.Debouncer;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class MacroDroidVariableStore {

    /* renamed from: f  reason: collision with root package name */
    private static MacroDroidVariableStore f9874f;

    /* renamed from: b  reason: collision with root package name */
    private VariableUpdatedListener f9876b;

    /* renamed from: c  reason: collision with root package name */
    private List<VariableUpdatedListener> f9877c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final Debouncer f9878d = new Debouncer();

    /* renamed from: e  reason: collision with root package name */
    private final Object f9879e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, MacroDroidVariable> f9875a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String json = MacroDroidVariableStore.this.getJson();
            MacroDroidVariableStore.this.q("variablesAtomic.json", json);
            MacroDroidVariableStore.this.q("variablesAtomicBackup.json", json);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends TypeToken<List<MacroDroidVariable>> {
        b() {
        }
    }

    private MacroDroidVariableStore() {
        h();
    }

    private boolean e(Constraint constraint, MacroDroidVariable macroDroidVariable) {
        MacroDroidVariable variable;
        if ((constraint instanceof HasVariable) && (variable = ((HasVariable) constraint).getVariable()) != null && variable.getName().equals(macroDroidVariable.getName())) {
            return true;
        }
        if (constraint instanceof LogicConstraint) {
            for (Constraint constraint2 : ((LogicConstraint) constraint).getConstraints()) {
                if (e(constraint2, macroDroidVariable)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void f(String str) {
        try {
            File file = new File(MacroDroidApplication.getInstance().getFilesDir().getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private Context g() {
        return MacroDroidApplication.getInstance();
    }

    public static synchronized MacroDroidVariableStore getInstance() {
        MacroDroidVariableStore macroDroidVariableStore;
        synchronized (MacroDroidVariableStore.class) {
            if (f9874f == null) {
                f9874f = new MacroDroidVariableStore();
            }
            macroDroidVariableStore = f9874f;
        }
        return macroDroidVariableStore;
    }

    private void h() {
        synchronized (this.f9879e) {
            if (!k() && !Settings.getAtomicVarFileMigrated(g())) {
                SystemLog.logInfoDontTrigger("Attempting variable store migration (V1 -> V2)");
                if (l()) {
                    persistData();
                    f("variables.json");
                    f("variables.json.backup");
                    SystemLog.logInfoDontTrigger("Variable data migration complete (V1 -> V2)");
                } else {
                    SystemLog.logInfoDontTrigger("No legacy V1 variable data found");
                }
                Settings.setAtomicVarFileMigrated(g(), true);
            }
        }
    }

    private synchronized boolean i(String str) {
        String replace;
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            try {
                fileInputStream = g().openFileInput(str);
                FirebaseAnalyticsEventLogger.log("Variable file stream length = " + fileInputStream.getChannel().size());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                char[] cArr = new char[1048576];
                for (int read = bufferedReader.read(cArr, 0, 1048576); read > 0; read = bufferedReader.read(cArr, 0, 1048576)) {
                    sb.append(cArr, 0, read);
                }
                bufferedReader.close();
                replace = sb.toString().replace(DexFormat.MAGIC_SUFFIX, "");
                importJsonFromString(replace);
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
            } catch (FileNotFoundException unused2) {
                Log.w("MacroDroidVariableStore", "No variable data file found: " + str);
                try {
                    fileInputStream.close();
                } catch (Exception unused3) {
                }
                return false;
            }
        } catch (Exception e4) {
            SystemLog.logErrorDontTrigger("Failed to load variables: " + e4.toString());
            SystemLog.logErrorDontTrigger("" + replace);
            FirebaseAnalyticsEventLogger.log("VARIABLE IMPORT FAILED (JSON length = " + replace.length() + "): " + replace);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to import variables: ");
            sb2.append(e4.toString());
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException(sb2.toString()));
            try {
                fileInputStream.close();
            } catch (Exception unused4) {
            }
            return false;
        }
        return true;
    }

    private boolean j(String str) {
        try {
            String str2 = new String(new AtomicFile(new File(g().getFilesDir(), str)).readFully(), "UTF-8");
            if (str2.isEmpty()) {
                SystemLog.logVerboseDontTrigger("No variable data found in: " + str);
                return false;
            }
            boolean importJsonFromString = importJsonFromString(str2);
            SystemLog.logVerboseDontTrigger("Variables extracted: " + importJsonFromString);
            return true;
        } catch (FileNotFoundException unused) {
            SystemLog.logVerboseDontTrigger("No variable file found:" + str);
            return false;
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
            SystemLog.logErrorDontTrigger("Failed to load variables from atomic file: " + str + ", " + e4.toString());
            return false;
        }
    }

    private boolean k() {
        boolean j4 = j("variablesAtomic.json");
        if (!j4) {
            boolean j5 = j("variablesAtomicBackup.json");
            FirebaseAnalyticsEventLogger.logLoadedVariabledFromAtomicBackup();
            return j5;
        }
        return j4;
    }

    private boolean l() {
        boolean i4 = i("variables.json");
        if (!i4) {
            FirebaseAnalyticsEventLogger.log("Failed to load variables from legacy variable file");
            SystemLog.logVerboseDontTrigger("Failed to load variables from variable file");
            i4 = i("variables.json.backup");
            if (i4) {
                SystemLog.logVerboseDontTrigger("Loaded variables from legacy variable backup");
            } else {
                SystemLog.logVerboseDontTrigger("Failed to load variables from legacy backup variable file");
            }
        } else {
            SystemLog.logVerboseDontTrigger("Loaded variables from legacy file");
        }
        return i4;
    }

    private boolean m(SelectableItem selectableItem, MacroDroidVariable macroDroidVariable) {
        String[] possibleMagicText;
        if (selectableItem instanceof HasVariable) {
            MacroDroidVariable variable = ((HasVariable) selectableItem).getVariable();
            if (variable != null && variable.getName().equals(macroDroidVariable.getName())) {
                return true;
            }
        } else if (selectableItem instanceof HasVariables) {
            for (MacroDroidVariable macroDroidVariable2 : ((HasVariables) selectableItem).getVariables()) {
                if (macroDroidVariable2 != null && macroDroidVariable2.getName().equals(macroDroidVariable.getName())) {
                    return true;
                }
            }
        } else if (selectableItem instanceof HasVariableName) {
            String variableName = ((HasVariableName) selectableItem).getVariableName();
            if (variableName != null && variableName.equals(macroDroidVariable.getName())) {
                return true;
            }
        } else if (selectableItem instanceof HasVariableNames) {
            for (String str : Arrays.asList(((HasVariableNames) selectableItem).getVariableNames())) {
                if (str != null && str.equals(macroDroidVariable.getName())) {
                    return true;
                }
            }
        }
        if (selectableItem instanceof SupportsMagicText) {
            for (String str2 : ((SupportsMagicText) selectableItem).getPossibleMagicText()) {
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.contains("[v=" + macroDroidVariable.getName())) {
                        if (str2.contains("{v=" + macroDroidVariable.getName())) {
                        }
                    }
                    return true;
                }
            }
        }
        for (Constraint constraint : selectableItem.getConstraints()) {
            if (e(constraint, macroDroidVariable)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int n(Locale locale, MacroDroidVariable macroDroidVariable, MacroDroidVariable macroDroidVariable2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(macroDroidVariable.getName(), macroDroidVariable2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int o(Locale locale, MacroDroidVariable macroDroidVariable, MacroDroidVariable macroDroidVariable2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(macroDroidVariable.getName(), macroDroidVariable2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int p(Locale locale, MacroDroidVariable macroDroidVariable, MacroDroidVariable macroDroidVariable2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(macroDroidVariable.getName(), macroDroidVariable2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, String str2) {
        synchronized (this.f9879e) {
            AtomicFile atomicFile = new AtomicFile(new File(g().getFilesDir(), str));
            try {
                FileOutputStream startWrite = atomicFile.startWrite();
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(startWrite, "UTF-8");
                    outputStreamWriter.write(str2);
                    outputStreamWriter.flush();
                    atomicFile.finishWrite(startWrite);
                    outputStreamWriter.close();
                    outputStreamWriter.close();
                    if (startWrite != null) {
                        startWrite.close();
                    }
                } catch (Throwable th) {
                    if (startWrite != null) {
                        try {
                            startWrite.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                SystemLog.logErrorDontTrigger("Failed to persist variable data: " + e4.toString());
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to persist variable data: " + e4.toString()));
            }
        }
    }

    private List<MacroDroidVariable> r(List<MacroDroidVariable> list) {
        final Locale locale = Settings.getLocale(g());
        Collections.sort(list, new Comparator() { // from class: com.arlosoft.macrodroid.common.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int p4;
                p4 = MacroDroidVariableStore.p(locale, (MacroDroidVariable) obj, (MacroDroidVariable) obj2);
                return p4;
            }
        });
        return list;
    }

    public void addStopWatchVariableUpdatedListener(VariableUpdatedListener variableUpdatedListener) {
        this.f9877c.add(variableUpdatedListener);
    }

    public void addVariable(MacroDroidVariable macroDroidVariable) {
        this.f9875a.put(macroDroidVariable.getName(), macroDroidVariable);
        persistData();
    }

    public void clearAllVariables() {
        this.f9875a.clear();
        persistData();
    }

    public List<MacroDroidVariable> getAllArrayVariables() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 5) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllBooleanVariables() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 0) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllDecimalVariables() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 3) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllDictionaryAndArrayVariables() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 5 || macroDroidVariable.getType() == 4) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllDictionaryOrArrayVariables(boolean z3) {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 5 || macroDroidVariable.getType() == 4) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllDictionaryVariables() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 4) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllIntegerVariables() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 1) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllNumericalVariables() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 1 || macroDroidVariable.getType() == 3) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllNumericalVariablesWithChildren() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 1 || macroDroidVariable.getType() == 3 || macroDroidVariable.getHasNumericalChildren()) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllStringVariables() {
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            if (macroDroidVariable.getType() == 2) {
                arrayList.add(macroDroidVariable);
            }
        }
        return r(arrayList);
    }

    public List<MacroDroidVariable> getAllVariables(boolean z3) {
        ArrayList arrayList = new ArrayList(this.f9875a.values());
        if (z3) {
            final Locale locale = Settings.getLocale(g());
            Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.common.k
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int n4;
                    n4 = MacroDroidVariableStore.n(locale, (MacroDroidVariable) obj, (MacroDroidVariable) obj2);
                    return n4;
                }
            });
        }
        return arrayList;
    }

    public String getJson() {
        try {
            return GsonUtils.getGsonBuilder().create().toJson(getAllVariables(true));
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ERROR - Getting JSON far variable store: " + e4.getMessage()));
            return "";
        }
    }

    @Nullable
    public String getJsonFromAtomicFile() {
        try {
            return new String(new AtomicFile(new File(g().getFilesDir(), "variablesAtomic.json")).readFully(), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public MacroDroidVariable getVariableByName(String str) {
        return this.f9875a.get(str);
    }

    public List<MacroDroidVariable> getVariablesOfType(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return getAllDecimalVariables();
                }
                return getAllStringVariables();
            }
            return getAllIntegerVariables();
        }
        return getAllBooleanVariables();
    }

    public boolean importJsonFromString(String str) {
        for (MacroDroidVariable macroDroidVariable : (List) GsonUtils.getGsonBuilder().serializeSpecialFloatingPointValues().setLenient().create().fromJson(str, new b().getType())) {
            this.f9875a.put(macroDroidVariable.getName(), macroDroidVariable);
        }
        if (this.f9875a.size() > 0) {
            return true;
        }
        return false;
    }

    public synchronized void persistData() {
        this.f9878d.debounce(Void.class, new a(), 500L, TimeUnit.MILLISECONDS);
    }

    public void removeStopWatchVariableUpdatedListener(VariableUpdatedListener variableUpdatedListener) {
        this.f9877c.remove(variableUpdatedListener);
    }

    public void removeVariable(String str) {
        this.f9875a.remove(str);
        persistData();
    }

    public void resetAllVariables() {
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            macroDroidVariable.setVariableValue(VariableValue.createForType(macroDroidVariable.getType()), false, null, null);
        }
    }

    public void setVariableUpdatedListener(VariableUpdatedListener variableUpdatedListener) {
        this.f9876b = variableUpdatedListener;
    }

    public void setVariables(List<MacroDroidVariable> list) {
        this.f9875a.clear();
        for (MacroDroidVariable macroDroidVariable : list) {
            this.f9875a.put(macroDroidVariable.getName(), macroDroidVariable);
        }
    }

    public void variableUpdate(MacroDroidVariable macroDroidVariable, VariableValue variableValue, boolean z3, Macro macro) {
        VariableValue variableValueNoMagicText;
        VariableValue.DictionaryEntry targetDictionaryEntry = macroDroidVariable.getTargetDictionaryEntry(variableValue.getParentKeys(), true);
        if (targetDictionaryEntry != null) {
            variableValueNoMagicText = targetDictionaryEntry.getVariable();
        } else {
            variableValueNoMagicText = macroDroidVariable.getVariableValueNoMagicText();
        }
        if (variableValueNoMagicText.equals(variableValue)) {
            return;
        }
        macroDroidVariable.setVariableValue(variableValue, z3, variableValueNoMagicText, macro);
        persistData();
        VariableUpdatedListener variableUpdatedListener = this.f9876b;
        if (variableUpdatedListener != null) {
            variableUpdatedListener.variableValueUpdated(macroDroidVariable, variableValue, variableValueNoMagicText, 0L);
        }
        for (VariableUpdatedListener variableUpdatedListener2 : this.f9877c) {
            variableUpdatedListener2.variableValueUpdated(macroDroidVariable, variableValue, variableValueNoMagicText, 0L);
        }
    }

    public void variablesetName(MacroDroidVariable macroDroidVariable, String str) {
        String name = macroDroidVariable.getName();
        macroDroidVariable.setName(str);
        this.f9875a.remove(name);
        this.f9875a.put(str, macroDroidVariable);
        persistData();
    }

    public List<MacroDroidVariable> getAllVariables(Macro macro, boolean z3) {
        boolean z4;
        boolean z5;
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : this.f9875a.values()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (true) {
                z4 = true;
                if (it.hasNext()) {
                    if (m(it.next(), macroDroidVariable)) {
                        z5 = true;
                        break;
                    }
                } else {
                    z5 = false;
                    break;
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (m(it2.next(), macroDroidVariable)) {
                        z5 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            Iterator<Constraint> it3 = macro.getConstraints().iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (m(it3.next(), macroDroidVariable)) {
                        break;
                    }
                } else {
                    z4 = z5;
                    break;
                }
            }
            if (z4) {
                arrayList.add(macroDroidVariable);
            }
        }
        if (z3) {
            final Locale locale = Settings.getLocale(g());
            Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.common.j
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int o4;
                    o4 = MacroDroidVariableStore.o(locale, (MacroDroidVariable) obj, (MacroDroidVariable) obj2);
                    return o4;
                }
            });
        }
        return arrayList;
    }
}
