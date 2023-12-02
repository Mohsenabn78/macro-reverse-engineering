package com.arlosoft.macrodroid.plugins;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.plugins.PluginsViewModel;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.twofortyfouram.locale.sdk.host.api.PluginRegistry;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginsViewModel.kt */
@SourceDebugExtension({"SMAP\nPluginsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginsViewModel.kt\ncom/arlosoft/macrodroid/plugins/PluginsViewModel$getPluginList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,243:1\n1549#2:244\n1620#2,3:245\n1549#2:248\n1620#2,3:249\n1045#2:252\n*S KotlinDebug\n*F\n+ 1 PluginsViewModel.kt\ncom/arlosoft/macrodroid/plugins/PluginsViewModel$getPluginList$1\n*L\n211#1:244\n211#1:245,3\n212#1:248\n212#1:249,3\n231#1:252\n*E\n"})
/* loaded from: classes3.dex */
public final class PluginsViewModel$getPluginList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PluginsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginsViewModel$getPluginList$1(PluginsViewModel pluginsViewModel, Continuation<? super PluginsViewModel$getPluginList$1> continuation) {
        super(2, continuation);
        this.this$0 = pluginsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PluginsViewModel$getPluginList$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        List plus;
        List plus2;
        int collectionSizeOrDefault;
        List distinct;
        int collectionSizeOrDefault2;
        List distinct2;
        List plus3;
        List<String> distinct3;
        List sortedWith;
        String str;
        kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            context = this.this$0.f13091a;
            Map<String, Plugin> pluginMap = PluginRegistry.getInstance(context).getPluginMap(PluginType.SETTING);
            Intrinsics.checkNotNullExpressionValue(pluginMap, "getInstance(context).get…inMap(PluginType.SETTING)");
            context2 = this.this$0.f13091a;
            Map<String, Plugin> pluginMap2 = PluginRegistry.getInstance(context2).getPluginMap(PluginType.CONDITION);
            Intrinsics.checkNotNullExpressionValue(pluginMap2, "getInstance(context).get…Map(PluginType.CONDITION)");
            context3 = this.this$0.f13091a;
            Map<String, Plugin> pluginMap3 = PluginRegistry.getInstance(context3).getPluginMap(PluginType.EVENT);
            Intrinsics.checkNotNullExpressionValue(pluginMap3, "getInstance(context).get…uginMap(PluginType.EVENT)");
            context4 = this.this$0.f13091a;
            PackageManager packageManager = context4.getPackageManager();
            plus = CollectionsKt___CollectionsKt.plus((Collection) pluginMap.values(), (Iterable) pluginMap2.values());
            plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) pluginMap3.values());
            List<Plugin> list = plus2;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Plugin plugin : list) {
                arrayList.add(plugin.getPackageName());
            }
            distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryInte…ion.CREATE_SHORTCUT\"), 0)");
            List<ResolveInfo> list2 = queryIntentActivities;
            collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (ResolveInfo resolveInfo : list2) {
                arrayList2.add(resolveInfo.activityInfo.packageName);
            }
            distinct2 = CollectionsKt___CollectionsKt.distinct(arrayList2);
            plus3 = CollectionsKt___CollectionsKt.plus((Collection) distinct, (Iterable) distinct2);
            distinct3 = CollectionsKt___CollectionsKt.distinct(plus3);
            ArrayList arrayList3 = new ArrayList();
            for (String str2 : distinct3) {
                AppInfo appInfo = new AppInfo();
                appInfo.packageName = str2;
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 0);
                    Intrinsics.checkNotNullExpressionValue(applicationInfo, "packageManager.getApplicationInfo(pkg, 0)");
                    str = packageManager.getApplicationLabel(applicationInfo).toString();
                } catch (PackageManager.NameNotFoundException unused) {
                    str = null;
                }
                appInfo.applicationName = str;
                if (str != null) {
                    arrayList3.add(appInfo);
                }
            }
            SingleLiveEvent<PluginsViewModel.UiState> uiState = this.this$0.getUiState();
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.arlosoft.macrodroid.plugins.PluginsViewModel$getPluginList$1$invokeSuspend$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int compareValues;
                    compareValues = kotlin.comparisons.f.compareValues(((AppInfo) t3).applicationName, ((AppInfo) t4).applicationName);
                    return compareValues;
                }
            });
            uiState.postValue(new PluginsViewModel.UiState.ShowPluginListDialog(sortedWith));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PluginsViewModel$getPluginList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
