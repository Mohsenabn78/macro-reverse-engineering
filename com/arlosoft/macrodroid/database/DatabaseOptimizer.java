package com.arlosoft.macrodroid.database;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DatabaseOptimizer.kt */
@StabilityInferred(parameters = 0)
@DelicateCoroutinesApi
/* loaded from: classes3.dex */
public final class DatabaseOptimizer {
    @NotNull
    public static final DatabaseOptimizer INSTANCE = new DatabaseOptimizer();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final CoroutineScope f10754a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DatabaseOptimizer.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $guid;
        final /* synthetic */ long $lastRunTime;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j4, long j5, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$guid = j4;
            this.$lastRunTime = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$guid, this.$lastRunTime, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Database.getInstance().setLastUpdateTime(this.$guid, this.$lastRunTime);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DatabaseOptimizer.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
                MacroDroidService.Companion companion = MacroDroidService.Companion;
                MacroDroidApplication companion2 = MacroDroidApplication.Companion.getInstance();
                this.label = 1;
                if (companion.updateLastRunTimeNotification(companion2, this) == coroutine_suspended) {
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

    private DatabaseOptimizer() {
    }

    @JvmStatic
    public static final void setLastUpdateTime(long j4, long j5) {
        Database.getInstance().refreshPreviousUpdateTime(j4);
        Database.getInstance().setLastUpdateTimeInstant(j4, j5);
        e.e(f10754a, null, null, new a(j4, j5, null), 3, null);
    }

    @JvmStatic
    public static final void updateNotificationWithRunTimes() {
        e.e(f10754a, null, null, new b(null), 3, null);
    }
}
