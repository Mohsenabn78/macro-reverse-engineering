package com.arlosoft.macrodroid.clipboard.logcat;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.e;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogcatClipboardDetector.kt */
@StabilityInferred(parameters = 0)
@RequiresApi(29)
/* loaded from: classes3.dex */
public final class LogcatClipboardDetector {
    public static final int IGNORE_MULTIPLE_WINDOWS_MS = 1000;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f9783a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private CompletableJob f9784b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Listener f9785c;

    /* renamed from: d  reason: collision with root package name */
    private long f9786d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9787e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Flow<String> f9788f;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: LogcatClipboardDetector.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LogcatClipboardDetector.kt */
    /* loaded from: classes3.dex */
    public interface Listener {
        void onClipboardEvent();
    }

    /* compiled from: LogcatClipboardDetector.kt */
    @SourceDebugExtension({"SMAP\nLogcatClipboardDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogcatClipboardDetector.kt\ncom/arlosoft/macrodroid/clipboard/logcat/LogcatClipboardDetector$logcatFlow$1\n+ 2 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,82:1\n52#2:83\n1#3:84\n1313#4,2:85\n*S KotlinDebug\n*F\n+ 1 LogcatClipboardDetector.kt\ncom/arlosoft/macrodroid/clipboard/logcat/LogcatClipboardDetector$logcatFlow$1\n*L\n34#1:83\n34#1:84\n34#1:85,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v11, types: [java.io.Closeable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            BufferedReader bufferedReader;
            Iterator<String> it;
            FlowCollector flowCollector;
            BufferedReader bufferedReader2;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
                if (i4 != 0) {
                    if (i4 == 1) {
                        it = (Iterator) this.L$2;
                        ?? r32 = (Closeable) this.L$1;
                        flowCollector = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        bufferedReader2 = r32;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                    Runtime.getRuntime().exec("logcat -c").waitFor();
                    InputStream inputStream = Runtime.getRuntime().exec("logcat ClipboardService:I *:S").getInputStream();
                    Intrinsics.checkNotNullExpressionValue(inputStream, "getRuntime().exec(\"logca…\n            .inputStream");
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                    if (inputStreamReader instanceof BufferedReader) {
                        bufferedReader = (BufferedReader) inputStreamReader;
                    } else {
                        bufferedReader = new BufferedReader(inputStreamReader, 8192);
                    }
                    it = TextStreamsKt.lineSequence(bufferedReader).iterator();
                    flowCollector = flowCollector2;
                    bufferedReader2 = bufferedReader;
                }
                while (it.hasNext()) {
                    this.L$0 = flowCollector;
                    this.L$1 = bufferedReader2;
                    this.L$2 = it;
                    this.label = 1;
                    if (flowCollector.emit(it.next(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader2, null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader2, th);
                    throw th2;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull FlowCollector<? super String> flowCollector, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: LogcatClipboardDetector.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LogcatClipboardDetector.kt */
        /* loaded from: classes3.dex */
        public static final class a implements FlowCollector<String> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LogcatClipboardDetector f9789a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: LogcatClipboardDetector.kt */
            /* renamed from: com.arlosoft.macrodroid.clipboard.logcat.LogcatClipboardDetector$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0095a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ LogcatClipboardDetector this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0095a(LogcatClipboardDetector logcatClipboardDetector, Continuation<? super C0095a> continuation) {
                    super(2, continuation);
                    this.this$0 = logcatClipboardDetector;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C0095a(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        Listener listener = this.this$0.f9785c;
                        if (listener != null) {
                            listener.onClipboardEvent();
                            return Unit.INSTANCE;
                        }
                        return null;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C0095a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            a(LogcatClipboardDetector logcatClipboardDetector) {
                this.f9789a = logcatClipboardDetector;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            /* renamed from: a */
            public final Object emit(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
                boolean contains$default;
                boolean contains$default2;
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "Denying", false, 2, (Object) null);
                if (contains$default) {
                    String packageName = this.f9789a.f9783a.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) packageName, false, 2, (Object) null);
                    if (contains$default2) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.f9789a.f9786d > 1000) {
                            this.f9789a.f9786d = currentTimeMillis;
                            return BuildersKt.withContext(Dispatchers.getMain(), new C0095a(this.f9789a, null), continuation);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }

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
                Flow flow = LogcatClipboardDetector.this.f9788f;
                a aVar = new a(LogcatClipboardDetector.this);
                this.label = 1;
                if (flow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public LogcatClipboardDetector(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9783a = context;
        this.f9784b = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.f9788f = FlowKt.flow(new a(null));
    }

    private final CoroutineContext a() {
        if (this.f9784b.isActive()) {
            Job.DefaultImpls.cancel$default((Job) this.f9784b, (CancellationException) null, 1, (Object) null);
        }
        this.f9784b = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        return Dispatchers.getIO().plus(this.f9784b);
    }

    public final void dispose() {
        this.f9785c = null;
        stopDetecting();
    }

    public final boolean isStarted() {
        return this.f9787e;
    }

    public final void registerListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f9785c = listener;
    }

    public final void startDetecting() {
        this.f9787e = true;
        e.e(CoroutineScopeKt.CoroutineScope(a()), Dispatchers.getIO(), null, new b(null), 2, null);
    }

    public final void stopDetecting() {
        this.f9787e = false;
        if (this.f9784b.isActive()) {
            Job.DefaultImpls.cancel$default((Job) this.f9784b, (CancellationException) null, 1, (Object) null);
        }
    }
}
