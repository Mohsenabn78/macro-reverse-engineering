package com.arlosoft.macrodroid.logging.systemlog;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import androidx.paging.PagingLiveData;
import androidx.paging.PagingSource;
import androidx.sqlite.db.SimpleSQLiteQuery;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.database.room.LogFlag;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.database.room.SystemLogEntryDao;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemLogViewModel.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSystemLogViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemLogViewModel.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,270:1\n766#2:271\n857#2,2:272\n1549#2:274\n1620#2,3:275\n1549#2:278\n1620#2,3:279\n766#2:282\n857#2,2:283\n766#2:286\n857#2,2:287\n1549#2:289\n1620#2,3:290\n1#3:285\n*S KotlinDebug\n*F\n+ 1 SystemLogViewModel.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogViewModel\n*L\n82#1:271\n82#1:272,2\n82#1:274\n82#1:275,3\n86#1:278\n86#1:279,3\n86#1:282\n86#1:283,2\n266#1:286\n266#1:287,2\n266#1:289\n266#1:290,3\n*E\n"})
/* loaded from: classes3.dex */
public final class SystemLogViewModel extends ViewModel implements LifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12718a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MacroDroidRoomDatabase f12719b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final SystemLogHelper f12720c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final SimpleDateFormat f12721d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private String f12722e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final SingleLiveEvent<Unit> f12723f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final SingleLiveEvent<String> f12724g;

    /* renamed from: h  reason: collision with root package name */
    private LogFilter f12725h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<LogFilter> f12726i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final LiveData<LogFilter> f12727j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final MutableLiveData<Pair<Integer, Integer>> f12728k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final LiveData<Pair<Integer, Integer>> f12729l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<Pair<Integer, Integer>> f12730m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final LiveData<Pair<Integer, Integer>> f12731n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private SimpleSQLiteQuery f12732o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12733p;

    /* renamed from: q  reason: collision with root package name */
    private long f12734q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private LiveData<PagingData<SystemLogEntry>> f12735r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                SystemLogEntryDao systemLogEntryDao = SystemLogViewModel.this.f12719b.systemLogEntryDao();
                this.label = 1;
                if (systemLogEntryDao.clearAll(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            SystemLogViewModel.this.getRefreshEvent().postValue(null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: SystemLogViewModel.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!SystemLogViewModel.this.getSingleMacroMode()) {
                    SystemLogViewModel systemLogViewModel = SystemLogViewModel.this;
                    LogFilter systemLogFilter = Settings.getSystemLogFilter(systemLogViewModel.f12718a);
                    Intrinsics.checkNotNullExpressionValue(systemLogFilter, "getSystemLogFilter(context)");
                    systemLogViewModel.g(systemLogFilter, false);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                SystemLogHelper systemLogHelper = SystemLogViewModel.this.f12720c;
                LogLevel fromIntLevel = LogLevel.Companion.fromIntLevel(SystemLogViewModel.this.getInternalFilter().getLogLevel());
                this.label = 1;
                obj = systemLogHelper.createLogFile(fromIntLevel, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            String str = (String) obj;
            if (str != null) {
                SystemLogViewModel.this.getShareLogEvent().postValue(str);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            boolean z3;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if ((SystemLogViewModel.this.f12718a.getResources().getConfiguration().uiMode & 48) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                SystemLogHelper systemLogHelper = SystemLogViewModel.this.f12720c;
                LogLevel fromIntLevel = LogLevel.Companion.fromIntLevel(SystemLogViewModel.this.getInternalFilter().getLogLevel());
                this.label = 1;
                obj = systemLogHelper.createHtmlLogFile(z3, fromIntLevel, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            String str = (String) obj;
            if (str != null) {
                SystemLogViewModel.this.getShareLogEvent().postValue(str);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: SystemLogViewModel.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function0<PagingSource<Integer, SystemLogEntry>> {
        e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PagingSource<Integer, SystemLogEntry> invoke() {
            return SystemLogViewModel.this.f12719b.systemLogEntryDao().getFiltered(SystemLogViewModel.this.getSqlQuery());
        }
    }

    /* compiled from: SystemLogViewModel.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<PagingData<SystemLogEntry>, PagingData<SystemLogEntry>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SystemLogViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<SystemLogEntry, Continuation<? super Boolean>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SystemLogViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SystemLogViewModel systemLogViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = systemLogViewModel;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: a */
            public final Object mo1invoke(@NotNull SystemLogEntry systemLogEntry, @Nullable Continuation<? super Boolean> continuation) {
                return ((a) create(systemLogEntry, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                a aVar = new a(this.this$0, continuation);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                boolean z3;
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    SystemLogEntry systemLogEntry = (SystemLogEntry) this.L$0;
                    if (this.this$0.c(systemLogEntry) && this.this$0.b(systemLogEntry)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    return Boxing.boxBoolean(z3);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final PagingData<SystemLogEntry> invoke(@NotNull PagingData<SystemLogEntry> pagingData) {
            Intrinsics.checkNotNullParameter(pagingData, "pagingData");
            return PagingDataTransforms.filter(pagingData, new a(SystemLogViewModel.this, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogViewModel.kt */
    @SourceDebugExtension({"SMAP\nSystemLogViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemLogViewModel.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogViewModel$updateFilter$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,270:1\n2976#2,5:271\n2976#2,5:276\n*S KotlinDebug\n*F\n+ 1 SystemLogViewModel.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogViewModel$updateFilter$1\n*L\n141#1:271,5\n153#1:276,5\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r4v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<Macro> allMacros = MacroStore.getInstance().getAllCompletedMacros();
                Intrinsics.checkNotNullExpressionValue(allMacros, "allMacros");
                SystemLogViewModel systemLogViewModel = SystemLogViewModel.this;
                int i5 = 0;
                int i6 = 0;
                for (Macro macro : allMacros) {
                    try {
                        i4 = systemLogViewModel.getInternalFilter().getDisabledMacroIds().contains(Boxing.boxLong(macro.getGUID()));
                    } catch (Exception unused) {
                        systemLogViewModel.setInternalFilter(LogFilter.Companion.getDefaultConfig());
                        i4 = 0;
                    }
                    i6 += i4;
                }
                SystemLogViewModel.this.f12728k.postValue(new Pair(Boxing.boxInt(allMacros.size() - i6), Boxing.boxInt(allMacros.size())));
                List<MacroDroidVariable> allVariables = MacroDroidVariableStore.getInstance().getAllVariables(false);
                Intrinsics.checkNotNullExpressionValue(allVariables, "allVariables");
                SystemLogViewModel systemLogViewModel2 = SystemLogViewModel.this;
                for (MacroDroidVariable macroDroidVariable : allVariables) {
                    i5 += systemLogViewModel2.getInternalFilter().getDisabledVariableNames().contains(macroDroidVariable.getName()) ? 1 : 0;
                }
                SystemLogViewModel.this.f12730m.postValue(new Pair(Boxing.boxInt(allVariables.size() - i5), Boxing.boxInt(allVariables.size())));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemLogViewModel.this.getRefreshEvent().postValue(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public SystemLogViewModel(@ApplicationContext @NotNull Context context, @NotNull MacroDroidRoomDatabase roomDatabase, @NotNull SystemLogHelper systemLogHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        Intrinsics.checkNotNullParameter(systemLogHelper, "systemLogHelper");
        this.f12718a = context;
        this.f12719b = roomDatabase;
        this.f12720c = systemLogHelper;
        this.f12721d = new SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale.getDefault());
        this.f12722e = "";
        this.f12723f = new SingleLiveEvent<>();
        this.f12724g = new SingleLiveEvent<>();
        this.f12725h = Settings.getSystemLogFilter(context);
        MutableLiveData<LogFilter> mutableLiveData = new MutableLiveData<>(this.f12725h);
        this.f12726i = mutableLiveData;
        this.f12727j = mutableLiveData;
        MutableLiveData<Pair<Integer, Integer>> mutableLiveData2 = new MutableLiveData<>(new Pair(0, 0));
        this.f12728k = mutableLiveData2;
        this.f12729l = mutableLiveData2;
        MutableLiveData<Pair<Integer, Integer>> mutableLiveData3 = new MutableLiveData<>(new Pair(0, 0));
        this.f12730m = mutableLiveData3;
        this.f12731n = mutableLiveData3;
        LogFilter internalFilter = this.f12725h;
        Intrinsics.checkNotNullExpressionValue(internalFilter, "internalFilter");
        this.f12732o = a(internalFilter);
        this.f12735r = Transformations.map(PagingLiveData.getLiveData(new Pager(new PagingConfig(200, 0, false, 0, 0, 0, 62, null), null, new e(), 2, null)), new f());
    }

    private final SimpleSQLiteQuery a(LogFilter logFilter) {
        String str;
        String str2 = "SELECT * FROM SystemLogEntry WHERE logLevel >= " + logFilter.getLogLevel() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        if (!this.f12733p) {
            str = str2 + "AND ( flag = " + LogFlag.NONE.ordinal();
        } else {
            str = str2 + "AND macroId = " + this.f12734q + " AND ( flag = " + LogFlag.NONE.ordinal();
        }
        if (logFilter.getShowTriggers()) {
            str = str + " OR flag=" + LogFlag.TRIGGER.ordinal();
        }
        if (logFilter.getShowActions()) {
            str = str + " OR flag=" + LogFlag.ACTION.ordinal();
        }
        if (logFilter.getShowConstraints()) {
            str = str + " OR flag=" + LogFlag.CONSTRAINT.ordinal();
        }
        return new SimpleSQLiteQuery(((str + " OR flag=" + LogFlag.LOCAL_VARIABLE.ordinal() + " OR flag=" + LogFlag.GLOBAL_VARIABLE.ordinal()) + ") ") + "ORDER BY timeStamp DESC, id DESC", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(SystemLogEntry systemLogEntry) {
        String str;
        boolean contains;
        boolean z3;
        if (this.f12733p) {
            return true;
        }
        if (!this.f12725h.getDisabledMacroIds().contains(Long.valueOf(systemLogEntry.getMacroId())) || systemLogEntry.getFlag() == LogFlag.GLOBAL_VARIABLE) {
            List<String> disabledVariableNames = this.f12725h.getDisabledVariableNames();
            String variableName = systemLogEntry.getVariableName();
            if (variableName != null) {
                str = d(variableName);
            } else {
                str = null;
            }
            contains = CollectionsKt___CollectionsKt.contains(disabledVariableNames, str);
            if (!contains || systemLogEntry.getFlag() != LogFlag.GLOBAL_VARIABLE) {
                z3 = false;
                return !z3;
            }
        }
        z3 = true;
        return !z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(SystemLogEntry systemLogEntry) {
        boolean z3;
        boolean contains$default;
        if (this.f12722e.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return true;
        }
        String logText = systemLogEntry.getLogText();
        Locale locale = Locale.ROOT;
        String lowerCase = logText.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String lowerCase2 = this.f12722e.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null);
        if (contains$default) {
            return true;
        }
        return false;
    }

    private final String d(String str) {
        boolean contains$default;
        int indexOf$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "[", false, 2, (Object) null);
        if (contains$default) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "[", 0, false, 6, (Object) null);
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
        if (r7 != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Set<com.arlosoft.macrodroid.common.MacroDroidVariable> e(com.arlosoft.macrodroid.common.SelectableItem r19, java.util.List<com.arlosoft.macrodroid.common.MacroDroidVariable> r20) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.logging.systemlog.SystemLogViewModel.e(com.arlosoft.macrodroid.common.SelectableItem, java.util.List):java.util.Set");
    }

    private final List<String> f(Macro macro) {
        int collectionSizeOrDefault;
        List<MacroDroidVariable> allVariables = MacroDroidVariableStore.getInstance().getAllVariables(false);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        macro.getAllConstraints();
        Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
        while (it.hasNext()) {
            Trigger trigger = it.next();
            Intrinsics.checkNotNullExpressionValue(trigger, "trigger");
            Intrinsics.checkNotNullExpressionValue(allVariables, "allVariables");
            linkedHashSet.addAll(e(trigger, allVariables));
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            Action action = it2.next();
            Intrinsics.checkNotNullExpressionValue(action, "action");
            Intrinsics.checkNotNullExpressionValue(allVariables, "allVariables");
            linkedHashSet.addAll(e(action, allVariables));
        }
        for (Constraint constraint : macro.getAllConstraints()) {
            Intrinsics.checkNotNullExpressionValue(constraint, "constraint");
            Intrinsics.checkNotNullExpressionValue(allVariables, "allVariables");
            linkedHashSet.addAll(e(constraint, allVariables));
        }
        ArrayList<MacroDroidVariable> arrayList = new ArrayList();
        for (Object obj : linkedHashSet) {
            if (!((MacroDroidVariable) obj).isLocalVar()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (MacroDroidVariable macroDroidVariable : arrayList) {
            arrayList2.add(macroDroidVariable.getName());
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(LogFilter internalFilter, boolean z3) {
        this.f12725h = internalFilter;
        Intrinsics.checkNotNullExpressionValue(internalFilter, "internalFilter");
        this.f12732o = a(internalFilter);
        if (z3 && !this.f12733p) {
            Settings.setSystemLogFilter(this.f12718a, this.f12725h);
        }
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new g(null), 3, null);
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new h(null), 3, null);
    }

    static /* synthetic */ void h(SystemLogViewModel systemLogViewModel, LogFilter logFilter, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = true;
        }
        systemLogViewModel.g(logFilter, z3);
    }

    public final void clearLog() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new a(null), 3, null);
    }

    public final void filterForSingleMacro(long j4) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        this.f12733p = true;
        this.f12734q = j4;
        List<Macro> allMacros = MacroStore.getInstance().getAllMacros();
        Intrinsics.checkNotNullExpressionValue(allMacros, "allMacros");
        ArrayList<Macro> arrayList = new ArrayList();
        Iterator<T> it = allMacros.iterator();
        while (true) {
            boolean z3 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Macro) next).getGUID() != j4) {
                z3 = true;
            }
            if (z3) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (Macro macro : arrayList) {
            arrayList2.add(Long.valueOf(macro.getGUID()));
        }
        List<MacroDroidVariable> allVariables = MacroDroidVariableStore.getInstance().getAllVariables(false);
        Macro macro2 = MacroStore.getInstance().getMacroByGUID(j4);
        Intrinsics.checkNotNullExpressionValue(macro2, "macro");
        List<String> f4 = f(macro2);
        Intrinsics.checkNotNullExpressionValue(allVariables, "allVariables");
        List<MacroDroidVariable> list = allVariables;
        collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        for (MacroDroidVariable macroDroidVariable : list) {
            arrayList3.add(macroDroidVariable.getName());
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            if (!f4.contains((String) obj)) {
                arrayList4.add(obj);
            }
        }
        LogFilter internalFilter = this.f12725h;
        Intrinsics.checkNotNullExpressionValue(internalFilter, "internalFilter");
        h(this, LogFilter.copy$default(internalFilter, LogLevel.VERBOSE.getLevelInt(), false, false, false, arrayList2, arrayList4, 14, null), false, 2, null);
    }

    @NotNull
    public final LiveData<LogFilter> getFilter() {
        return this.f12727j;
    }

    public final LogFilter getInternalFilter() {
        return this.f12725h;
    }

    @NotNull
    public final SimpleDateFormat getLogDateTimeFormat() {
        return this.f12721d;
    }

    @NotNull
    public final LiveData<Pair<Integer, Integer>> getMacroCount() {
        return this.f12729l;
    }

    @NotNull
    public final LiveData<PagingData<SystemLogEntry>> getPageLiveData() {
        return this.f12735r;
    }

    @NotNull
    public final SingleLiveEvent<Unit> getRefreshEvent() {
        return this.f12723f;
    }

    @NotNull
    public final String getSearchText() {
        return this.f12722e;
    }

    @NotNull
    public final SingleLiveEvent<String> getShareLogEvent() {
        return this.f12724g;
    }

    public final boolean getSingleMacroMode() {
        return this.f12733p;
    }

    @NotNull
    public final SimpleSQLiteQuery getSqlQuery() {
        return this.f12732o;
    }

    @NotNull
    public final LiveData<Pair<Integer, Integer>> getVariableCount() {
        return this.f12731n;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new b(null), 3, null);
    }

    public final void onShareClicked() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new c(null), 2, null);
    }

    public final void onShareHtmlClicked() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new d(null), 2, null);
    }

    public final void setFilterActionsEnabled(boolean z3) {
        LogFilter internalFilter = this.f12725h;
        Intrinsics.checkNotNullExpressionValue(internalFilter, "internalFilter");
        h(this, LogFilter.copy$default(internalFilter, 0, false, z3, false, null, null, 59, null), false, 2, null);
    }

    public final void setFilterConstraintsEnabled(boolean z3) {
        LogFilter internalFilter = this.f12725h;
        Intrinsics.checkNotNullExpressionValue(internalFilter, "internalFilter");
        h(this, LogFilter.copy$default(internalFilter, 0, false, false, z3, null, null, 55, null), false, 2, null);
    }

    public final void setFilterLogLevel(int i4) {
        LogFilter internalFilter = this.f12725h;
        Intrinsics.checkNotNullExpressionValue(internalFilter, "internalFilter");
        h(this, LogFilter.copy$default(internalFilter, i4, false, false, false, null, null, 62, null), false, 2, null);
    }

    public final void setFilterTriggersEnabled(boolean z3) {
        LogFilter internalFilter = this.f12725h;
        Intrinsics.checkNotNullExpressionValue(internalFilter, "internalFilter");
        h(this, LogFilter.copy$default(internalFilter, 0, z3, false, false, null, null, 61, null), false, 2, null);
    }

    public final void setInternalFilter(LogFilter logFilter) {
        this.f12725h = logFilter;
    }

    public final void setPageLiveData(@NotNull LiveData<PagingData<SystemLogEntry>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.f12735r = liveData;
    }

    public final void setSearchText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f12722e = str;
    }

    public final void setSingleMacroMode(boolean z3) {
        this.f12733p = z3;
    }

    public final void setSqlQuery(@NotNull SimpleSQLiteQuery simpleSQLiteQuery) {
        Intrinsics.checkNotNullParameter(simpleSQLiteQuery, "<set-?>");
        this.f12732o = simpleSQLiteQuery;
    }

    public final void updateSearchText(@NotNull String searchText) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        this.f12722e = searchText;
        this.f12723f.postValue(null);
    }
}
