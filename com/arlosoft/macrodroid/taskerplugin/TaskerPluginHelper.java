package com.arlosoft.macrodroid.taskerplugin;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.comparisons.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: TaskerPluginHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTaskerPluginHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskerPluginHelper.kt\ncom/arlosoft/macrodroid/taskerplugin/TaskerPluginHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,125:1\n1045#2:126\n1045#2:127\n*S KotlinDebug\n*F\n+ 1 TaskerPluginHelper.kt\ncom/arlosoft/macrodroid/taskerplugin/TaskerPluginHelper\n*L\n92#1:126\n98#1:127\n*E\n"})
/* loaded from: classes3.dex */
public final class TaskerPluginHelper {
    public static final int $stable = 0;

    public final void displayPluginList(@NotNull final SelectableItem selectableItem, @NotNull Map<String, Plugin> pluginMap, @NotNull final PluginSelectedHandler selectedHandler) {
        List sortedWith;
        WindowManager.LayoutParams layoutParams;
        Object value;
        List sortedWith2;
        Object value2;
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(pluginMap, "pluginMap");
        Intrinsics.checkNotNullParameter(selectedHandler, "selectedHandler");
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PackageManager packageManager = selectableItem.getContext().getPackageManager();
        for (String str : pluginMap.keySet()) {
            value2 = s.getValue(pluginMap, str);
            Plugin plugin = (Plugin) value2;
            if (!linkedHashMap.containsKey(plugin.getPackageName())) {
                String packageName = plugin.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "plugin.packageName");
                linkedHashMap.put(packageName, new ArrayList());
            }
            ArrayList arrayList2 = (ArrayList) linkedHashMap.get(plugin.getPackageName());
            if (arrayList2 != null) {
                arrayList2.add(plugin);
            }
        }
        for (String str2 : linkedHashMap.keySet()) {
            value = s.getValue(linkedHashMap, str2);
            sortedWith2 = CollectionsKt___CollectionsKt.sortedWith((ArrayList) value, new Comparator() { // from class: com.arlosoft.macrodroid.taskerplugin.TaskerPluginHelper$displayPluginList$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int compareValues;
                    compareValues = f.compareValues(((Plugin) t3).getActivityLabel(SelectableItem.this.getContext()), ((Plugin) t4).getActivityLabel(SelectableItem.this.getContext()));
                    return compareValues;
                }
            });
            arrayList.add(new App(str2, packageManager.getApplicationLabel(packageManager.getApplicationInfo(str2, 128)).toString(), sortedWith2));
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.taskerplugin.TaskerPluginHelper$displayPluginList$$inlined$sortedBy$2
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int compareValues;
                String appName = ((App) t3).getAppName();
                Locale locale = Locale.ROOT;
                String lowerCase = appName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                String lowerCase2 = ((App) t4).getAppName().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                compareValues = f.compareValues(lowerCase, lowerCase2);
                return compareValues;
            }
        });
        Activity activity = selectableItem.getActivity();
        if (activity == null) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, selectableItem.getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_tasker_plugin_chooser);
        appCompatDialog.setTitle(R.string.select_plugin);
        RecyclerView recyclerView = (RecyclerView) appCompatDialog.findViewById(R.id.pluginList);
        PluginAdapter pluginAdapter = new PluginAdapter(sortedWith, new PluginSelectedListener() { // from class: com.arlosoft.macrodroid.taskerplugin.TaskerPluginHelper$displayPluginList$adapter$1
            @Override // com.arlosoft.macrodroid.taskerplugin.PluginSelectedListener
            public void pluginSelected(@NotNull Plugin plugin2) {
                Intrinsics.checkNotNullParameter(plugin2, "plugin");
                PluginSelectedHandler.this.onPluginSelected(plugin2);
                appCompatDialog.dismiss();
            }
        });
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        }
        if (recyclerView != null) {
            recyclerView.setAdapter(pluginAdapter);
        }
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        appCompatDialog.show();
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
    }
}
