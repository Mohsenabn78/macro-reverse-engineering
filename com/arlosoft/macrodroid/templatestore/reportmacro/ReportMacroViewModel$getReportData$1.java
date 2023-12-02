package com.arlosoft.macrodroid.templatestore.reportmacro;

import androidx.lifecycle.MutableLiveData;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.model.Report;
import com.arlosoft.macrodroid.templatestore.reportmacro.ReportEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.e;
import kotlin.collections.f;
import kotlin.collections.m;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReportMacroViewModel.kt */
@SourceDebugExtension({"SMAP\nReportMacroViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportMacroViewModel.kt\ncom/arlosoft/macrodroid/templatestore/reportmacro/ReportMacroViewModel$getReportData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,92:1\n1536#2:93\n1549#2:94\n1620#2,3:95\n766#2:98\n857#2,2:99\n1045#2:105\n1549#2:106\n1620#2,3:107\n125#3:101\n152#3,3:102\n*S KotlinDebug\n*F\n+ 1 ReportMacroViewModel.kt\ncom/arlosoft/macrodroid/templatestore/reportmacro/ReportMacroViewModel$getReportData$1\n*L\n54#1:93\n55#1:94\n55#1:95,3\n55#1:98\n55#1:99,2\n57#1:105\n58#1:106\n58#1:107,3\n57#1:101\n57#1:102,3\n*E\n"})
/* loaded from: classes3.dex */
public final class ReportMacroViewModel$getReportData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MacroTemplate $macroTemplate;
    int label;
    final /* synthetic */ ReportMacroViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportMacroViewModel$getReportData$1(ReportMacroViewModel reportMacroViewModel, MacroTemplate macroTemplate, Continuation<? super ReportMacroViewModel$getReportData$1> continuation) {
        super(2, continuation);
        this.this$0 = reportMacroViewModel;
        this.$macroTemplate = macroTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReportMacroViewModel$getReportData$1(this.this$0, this.$macroTemplate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Map eachCount;
        int collectionSizeOrDefault;
        List list;
        List listOf;
        List sortedWith;
        List plus;
        int collectionSizeOrDefault2;
        List plus2;
        MutableLiveData mutableLiveData;
        boolean z3;
        coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        try {
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                TemplateStoreApi templateStoreApi = this.this$0.f13670a;
                int id = this.$macroTemplate.getId();
                this.label = 1;
                obj = templateStoreApi.getReports(id, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            List list2 = (List) obj;
            final List list3 = list2;
            eachCount = m.eachCount(new Grouping<Report, Integer>() { // from class: com.arlosoft.macrodroid.templatestore.reportmacro.ReportMacroViewModel$getReportData$1$invokeSuspend$$inlined$groupingBy$1
                @Override // kotlin.collections.Grouping
                public Integer keyOf(Report report) {
                    return Integer.valueOf(report.getReasonCode());
                }

                @Override // kotlin.collections.Grouping
                @NotNull
                public Iterator<Report> sourceIterator() {
                    return list3.iterator();
                }
            });
            List<Report> list4 = list2;
            collectionSizeOrDefault = f.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Report report : list4) {
                arrayList.add(report.getReasonText());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((String) obj2).length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    arrayList2.add(obj2);
                }
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList2);
            listOf = e.listOf(new ReportEntry.Summary(this.$macroTemplate.getStarCount(), this.$macroTemplate.getFlagCount()));
            List list5 = listOf;
            ArrayList arrayList3 = new ArrayList(eachCount.size());
            for (Map.Entry entry : eachCount.entrySet()) {
                arrayList3.add(new ReportEntry.ReasonCodeWithCount(((Number) entry.getKey()).intValue(), ((Number) entry.getValue()).intValue()));
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.arlosoft.macrodroid.templatestore.reportmacro.ReportMacroViewModel$getReportData$1$invokeSuspend$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int compareValues;
                    compareValues = kotlin.comparisons.f.compareValues(Integer.valueOf(((ReportEntry.ReasonCodeWithCount) t3).getCount()), Integer.valueOf(((ReportEntry.ReasonCodeWithCount) t4).getCount()));
                    return compareValues;
                }
            });
            plus = CollectionsKt___CollectionsKt.plus((Collection) list5, (Iterable) sortedWith);
            List list6 = plus;
            List<String> list7 = list;
            collectionSizeOrDefault2 = f.collectionSizeOrDefault(list7, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
            for (String str : list7) {
                arrayList4.add(new ReportEntry.Comment(str));
            }
            plus2 = CollectionsKt___CollectionsKt.plus((Collection) list6, (Iterable) arrayList4);
            mutableLiveData = this.this$0.f13673d;
            mutableLiveData.postValue(new MacroReportData(this.$macroTemplate, plus2));
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReportMacroViewModel$getReportData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
