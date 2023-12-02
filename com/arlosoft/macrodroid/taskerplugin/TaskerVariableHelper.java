package com.arlosoft.macrodroid.taskerplugin;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.core.util.SparseArrayKt;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e;
import kotlin.collections.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: TaskerVariableHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTaskerVariableHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskerVariableHelper.kt\ncom/arlosoft/macrodroid/taskerplugin/TaskerVariableHelper\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,235:1\n262#2,2:236\n429#3:238\n502#3,5:239\n1549#4:244\n1620#4,3:245\n76#5,4:248\n*S KotlinDebug\n*F\n+ 1 TaskerVariableHelper.kt\ncom/arlosoft/macrodroid/taskerplugin/TaskerVariableHelper\n*L\n79#1:236,2\n142#1:238\n142#1:239,5\n174#1:244\n174#1:245,3\n178#1:248,4\n*E\n"})
/* loaded from: classes3.dex */
public final class TaskerVariableHelper {
    public static final int $stable = 0;

    /* compiled from: TaskerVariableHelper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArrayHandlingOption.values().length];
            try {
                iArr[ArrayHandlingOption.FIRST_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArrayHandlingOption.COMMA_SEPARATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArrayHandlingOption.NEW_LINE_SEPARATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final String c(String str, TaskerVariableHandler taskerVariableHandler) {
        String str2;
        boolean a4;
        String c4;
        String str3 = taskerVariableHandler.getVariableMap().get(str);
        if (str3 == null) {
            Map<String, String> variableMap = taskerVariableHandler.getVariableMap();
            str3 = variableMap.get(str + "()");
            if (str3 == null) {
                a4 = TaskerVariableHelperKt.a(str);
                if (a4) {
                    Map<String, String> variableMap2 = taskerVariableHandler.getVariableMap();
                    c4 = TaskerVariableHelperKt.c(str);
                    str3 = variableMap2.get(c4 + "()");
                }
            }
        }
        if (str3 == null) {
            MacroDroidVariable variableByName = taskerVariableHandler.getVariableByName(str);
            if (variableByName != null) {
                str2 = variableByName.getName();
            } else {
                str2 = null;
            }
            return str2;
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(RadioButton radioButton, RadioButton radioButton2, Pair pluginInstanceDataPair, CheckBox blockActionsCheckBox, SelectableItem selectableItem, AppCompatDialog dialog, View view) {
        ArrayHandlingOption arrayHandlingOption;
        Intrinsics.checkNotNullParameter(pluginInstanceDataPair, "$pluginInstanceDataPair");
        Intrinsics.checkNotNullParameter(blockActionsCheckBox, "$blockActionsCheckBox");
        Intrinsics.checkNotNullParameter(selectableItem, "$selectableItem");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNull(radioButton);
        if (radioButton.isChecked()) {
            arrayHandlingOption = ArrayHandlingOption.FIRST_ELEMENT;
        } else {
            Intrinsics.checkNotNull(radioButton2);
            if (radioButton2.isChecked()) {
                arrayHandlingOption = ArrayHandlingOption.COMMA_SEPARATED;
            } else {
                arrayHandlingOption = ArrayHandlingOption.NEW_LINE_SEPARATED;
            }
        }
        selectableItem.handleItemComplete(new TaskerVariableData(pluginInstanceDataPair, arrayHandlingOption, blockActionsCheckBox.isChecked()));
        dialog.dismiss();
    }

    public final void setVariables(@NotNull Bundle variables, @NotNull TaskerVariableHandler taskerVariableHandler, @NotNull SelectableItem selectableItem, @NotNull ArrayHandlingOption arrayHandlingOption) {
        List sorted;
        int i4;
        String str;
        MacroDroidVariable variableByName;
        List mutableList;
        List listOf;
        List listOf2;
        Sequence asSequence;
        List list;
        int collectionSizeOrDefault;
        String joinToString$default;
        MacroDroidVariable variableByName2;
        boolean a4;
        String obj;
        boolean b4;
        String obj2;
        String obj3;
        String obj4;
        String obj5;
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(taskerVariableHandler, "taskerVariableHandler");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(arrayHandlingOption, "arrayHandlingOption");
        Set<String> keySet = variables.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "variables.keySet()");
        sorted = CollectionsKt___CollectionsKt.sorted(keySet);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator it = sorted.iterator();
        while (true) {
            i4 = 2;
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            String key = (String) it.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            String c4 = c(key, taskerVariableHandler);
            if (c4 != null && (variableByName2 = selectableItem.getVariableByName(c4)) != null) {
                a4 = TaskerVariableHelperKt.a(key);
                String str3 = "";
                if (a4) {
                    if (variableByName2.isString() && arrayHandlingOption == ArrayHandlingOption.FIRST_ELEMENT) {
                        b4 = TaskerVariableHelperKt.b(key);
                        if (b4) {
                            Object obj6 = variables.get(key);
                            if (obj6 != null && (obj2 = obj6.toString()) != null) {
                                str3 = obj2;
                            }
                            selectableItem.variableUpdate(variableByName2, new VariableValue.StringValue(str3, null, 2, null));
                        }
                    } else {
                        if (hashMap2.get(c4) == null) {
                            hashMap2.put(c4, new HashMap());
                        }
                        if (hashMap.get(c4) == null) {
                            hashMap.put(c4, new SparseArray());
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = key.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            char charAt = key.charAt(i5);
                            if (Character.isDigit(charAt)) {
                                sb.append(charAt);
                            }
                        }
                        String sb2 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
                        int parseInt = Integer.parseInt(sb2);
                        SparseArray sparseArray = (SparseArray) hashMap.get(c4);
                        if (sparseArray != null) {
                            Object obj7 = variables.get(key);
                            if (obj7 != null) {
                                str2 = obj7.toString();
                            }
                            sparseArray.put(parseInt, str2);
                        }
                        HashMap hashMap3 = (HashMap) hashMap2.get(c4);
                        if (hashMap3 != null) {
                            Object obj8 = variables.get(key);
                            if (obj8 != null && (obj = obj8.toString()) != null) {
                                str3 = obj;
                            }
                            String str4 = (String) hashMap3.put(key, str3);
                        }
                    }
                } else if (variableByName2.isDictionary()) {
                    if (hashMap2.get(c4) == null) {
                        hashMap2.put(c4, new HashMap());
                    }
                    HashMap hashMap4 = (HashMap) hashMap2.get(c4);
                    if (hashMap4 != null) {
                        Object obj9 = variables.get(key);
                        if (obj9 != null && (obj3 = obj9.toString()) != null) {
                            str3 = obj3;
                        }
                        String str5 = (String) hashMap4.put(key, str3);
                    }
                } else if (variableByName2.isArray()) {
                    if (hashMap.get(c4) == null) {
                        hashMap.put(c4, new SparseArray());
                    }
                    SparseArray sparseArray2 = (SparseArray) hashMap.get(c4);
                    if (sparseArray2 != null) {
                        Object obj10 = variables.get(key);
                        if (obj10 != null && (obj4 = obj10.toString()) != null) {
                            str3 = obj4;
                        }
                        sparseArray2.put(0, str3);
                    }
                } else {
                    Object obj11 = variables.get(key);
                    if (obj11 != null && (obj5 = obj11.toString()) != null) {
                        str3 = obj5;
                    }
                    selectableItem.variableUpdate(variableByName2, new VariableValue.StringValue(str3, null, 2, null));
                }
            }
        }
        if (WhenMappings.$EnumSwitchMapping$0[arrayHandlingOption.ordinal()] == 2) {
            str = ",";
        } else {
            str = "\\n";
        }
        for (String str6 : hashMap.keySet()) {
            SparseArray sparseArray3 = (SparseArray) hashMap.get(str6);
            if (sparseArray3 != null) {
                MacroDroidVariable variableByName3 = selectableItem.getVariableByName(str6);
                if (variableByName3 != null && variableByName3.isString()) {
                    asSequence = SequencesKt__SequencesKt.asSequence(SparseArrayKt.valueIterator(sparseArray3));
                    list = SequencesKt___SequencesKt.toList(asSequence);
                    List<String> list2 = list;
                    collectionSizeOrDefault = f.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (String str7 : list2) {
                        arrayList.add(str7);
                    }
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, str, null, null, 0, null, null, 62, null);
                    selectableItem.variableUpdate(variableByName3, new VariableValue.StringValue(joinToString$default, null, i4, null));
                } else if (variableByName3 != null && variableByName3.isArray()) {
                    VariableValue.Dictionary dictionary = new VariableValue.Dictionary(new ArrayList(), true, null, 4, null);
                    int size = sparseArray3.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        int keyAt = sparseArray3.keyAt(i6);
                        listOf2 = e.listOf(String.valueOf(keyAt));
                        dictionary.setEntry(new VariableValue.DictionaryEntry(String.valueOf(keyAt), new VariableValue.StringValue((String) sparseArray3.valueAt(i6), listOf2), null, 4, null));
                    }
                    selectableItem.variableUpdate(variableByName3, dictionary);
                }
                i4 = 2;
            }
        }
        for (String str8 : hashMap2.keySet()) {
            HashMap hashMap5 = (HashMap) hashMap2.get(str8);
            if (hashMap5 != null && (variableByName = selectableItem.getVariableByName(str8)) != null && variableByName.isDictionary()) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) variableByName.getDictionary().getEntries());
                VariableValue.Dictionary dictionary2 = new VariableValue.Dictionary(mutableList, false, null, 6, null);
                for (Map.Entry entry : hashMap5.entrySet()) {
                    String str9 = (String) entry.getKey();
                    listOf = e.listOf(str9.toString());
                    dictionary2.setEntry(new VariableValue.DictionaryEntry(str9, new VariableValue.StringValue((String) entry.getValue(), listOf), null, 4, null));
                }
                selectableItem.variableUpdate(variableByName, dictionary2);
            }
        }
    }

    public final void showVariableList(@NotNull Activity activity, @NotNull final SelectableItem selectableItem, @NotNull String[] relevantVariables, @NotNull TaskerVariableHandler variableHandler, @NotNull final Pair<Plugin, PluginInstanceData> pluginInstanceDataPair, @NotNull ArrayHandlingOption selectedArrayHandlingOption, boolean z3, boolean z4) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(relevantVariables, "relevantVariables");
        Intrinsics.checkNotNullParameter(variableHandler, "variableHandler");
        Intrinsics.checkNotNullParameter(pluginInstanceDataPair, "pluginInstanceDataPair");
        Intrinsics.checkNotNullParameter(selectedArrayHandlingOption, "selectedArrayHandlingOption");
        if (!selectableItem.checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, selectableItem.getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_tasker_variables);
        RecyclerView recyclerView = (RecyclerView) appCompatDialog.findViewById(R.id.variablesList);
        if (recyclerView != null) {
            recyclerView.setLayerType(1, null);
        }
        appCompatDialog.setTitle(R.string.variables);
        RecyclerView recyclerView2 = (RecyclerView) appCompatDialog.findViewById(R.id.variablesList);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        View findViewById = appCompatDialog.findViewById(R.id.borderImage);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.arrayHandlingLabel);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.radioButtonFirstElement);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.radioButtonCommaSeparated);
        RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.radioButtonNewLineSeparated);
        View findViewById2 = appCompatDialog.findViewById(R.id.blockActionsCheckBox);
        Intrinsics.checkNotNull(findViewById2);
        final CheckBox checkBox = (CheckBox) findViewById2;
        if (z3) {
            checkBox.setVisibility(8);
        } else {
            checkBox.setChecked(z4);
        }
        if (findViewById != null) {
            if (z3) {
                i5 = R.drawable.trigger_border;
            } else {
                i5 = R.drawable.action_border;
            }
            findViewById.setBackgroundResource(i5);
        }
        if (textView != null) {
            if (z3) {
                i4 = R.color.trigger_accent;
            } else {
                i4 = R.color.actions_accent;
            }
            textView.setTextColor(ContextCompat.getColor(activity, i4));
        }
        int i6 = WhenMappings.$EnumSwitchMapping$0[selectedArrayHandlingOption.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3 && radioButton3 != null) {
                    radioButton3.setChecked(true);
                }
            } else if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
        } else if (radioButton != null) {
            radioButton.setChecked(true);
        }
        TaskerVariableAdapter taskerVariableAdapter = new TaskerVariableAdapter(relevantVariables, variableHandler.getVariableMap(), activity, selectableItem, selectableItem.getDialogTheme());
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(taskerVariableAdapter);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: n0.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskerVariableHelper.d(AppCompatDialog.this, view);
                }
            });
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: n0.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskerVariableHelper.e(radioButton, radioButton2, pluginInstanceDataPair, checkBox, selectableItem, appCompatDialog, view);
                }
            });
        }
        appCompatDialog.show();
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
    }
}
