package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.action.services.AndroidWearService;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.AndroidWearTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: AndroidWearHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAndroidWearHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidWearHelper.kt\ncom/arlosoft/macrodroid/utils/AndroidWearHelper\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,49:1\n37#2,2:50\n37#2,2:52\n*S KotlinDebug\n*F\n+ 1 AndroidWearHelper.kt\ncom/arlosoft/macrodroid/utils/AndroidWearHelper\n*L\n41#1:50,2\n42#1:52,2\n*E\n"})
/* loaded from: classes3.dex */
public final class AndroidWearHelper {
    public static final int $stable = 0;
    @NotNull
    public static final AndroidWearHelper INSTANCE = new AndroidWearHelper();

    private AndroidWearHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final Context context, final boolean z3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                AndroidWearHelper.d(context, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, boolean z3) {
        long[] longArray;
        Intrinsics.checkNotNullParameter(context, "$context");
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Set<String> disabledCategories = Settings.getDisabledCategories(context);
        for (Macro macro : allCompletedMacros) {
            if (macro.isEnabled() && !disabledCategories.contains(macro.getCategory())) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof AndroidWearTrigger) && ((AndroidWearTrigger) next).getOption() == 0 && next.constraintsMet()) {
                        String name = macro.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "macro.name");
                        arrayList.add(name);
                        AndroidWearTrigger androidWearTrigger = (AndroidWearTrigger) next;
                        String resourceName = androidWearTrigger.getResourceName();
                        Intrinsics.checkNotNullExpressionValue(resourceName, "trigger.resourceName");
                        arrayList2.add(resourceName);
                        arrayList3.add(Long.valueOf(androidWearTrigger.getIconBgColor()));
                    }
                }
            }
        }
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList3);
        AndroidWearService.requestSyncMacros(context, (String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), longArray, z3);
    }

    @JvmStatic
    public static final void updateMacroList(@NotNull final Context context, final boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        MacroDroidService.Companion.getUpdateNotificationDebouncer().debounce(Void.class, new Runnable() { // from class: com.arlosoft.macrodroid.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                AndroidWearHelper.c(context, z3);
            }
        }, 500L, TimeUnit.MILLISECONDS);
    }
}
