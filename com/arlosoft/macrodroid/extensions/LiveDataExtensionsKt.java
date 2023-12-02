package com.arlosoft.macrodroid.extensions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveDataExtensions.kt */
/* loaded from: classes3.dex */
public final class LiveDataExtensionsKt {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LiveDataExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> extends Lambda implements Function1<T, Unit> {
        final /* synthetic */ Function2<T, K, R> $block;
        final /* synthetic */ LiveData<K> $liveData;
        final /* synthetic */ MediatorLiveData<R> $result;
        final /* synthetic */ LiveData<T> $this_combineWith;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(MediatorLiveData<R> mediatorLiveData, Function2<? super T, ? super K, ? extends R> function2, LiveData<T> liveData, LiveData<K> liveData2) {
            super(1);
            this.$result = mediatorLiveData;
            this.$block = function2;
            this.$this_combineWith = liveData;
            this.$liveData = liveData2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((a<T>) obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(T t3) {
            this.$result.setValue(this.$block.mo1invoke(this.$this_combineWith.getValue(), this.$liveData.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [K] */
    /* compiled from: LiveDataExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class b<K> extends Lambda implements Function1<K, Unit> {
        final /* synthetic */ Function2<T, K, R> $block;
        final /* synthetic */ LiveData<K> $liveData;
        final /* synthetic */ MediatorLiveData<R> $result;
        final /* synthetic */ LiveData<T> $this_combineWith;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(MediatorLiveData<R> mediatorLiveData, Function2<? super T, ? super K, ? extends R> function2, LiveData<T> liveData, LiveData<K> liveData2) {
            super(1);
            this.$result = mediatorLiveData;
            this.$block = function2;
            this.$this_combineWith = liveData;
            this.$liveData = liveData2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((b<K>) obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(K k4) {
            this.$result.setValue(this.$block.mo1invoke(this.$this_combineWith.getValue(), this.$liveData.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LiveDataExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> extends Lambda implements Function1<T, Unit> {
        final /* synthetic */ CoroutineScope $coroutineScope;
        final /* synthetic */ long $duration;
        final /* synthetic */ Ref.ObjectRef<Job> $job;
        final /* synthetic */ MediatorLiveData<T> $mld;
        final /* synthetic */ LiveData<T> $source;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LiveDataExtensions.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $duration;
            final /* synthetic */ MediatorLiveData<T> $mld;
            final /* synthetic */ LiveData<T> $source;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j4, MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$duration = j4;
                this.$mld = mediatorLiveData;
                this.$source = liveData;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$duration, this.$mld, this.$source, continuation);
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
                    long j4 = this.$duration;
                    this.label = 1;
                    if (DelayKt.delay(j4, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.$mld.setValue(this.$source.getValue());
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, long j4, MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData) {
            super(1);
            this.$job = objectRef;
            this.$coroutineScope = coroutineScope;
            this.$duration = j4;
            this.$mld = mediatorLiveData;
            this.$source = liveData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((c<T>) obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(T t3) {
            Job e4;
            Job job = this.$job.element;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Ref.ObjectRef<Job> objectRef = this.$job;
            e4 = e.e(this.$coroutineScope, null, null, new a(this.$duration, this.$mld, this.$source, null), 3, null);
            objectRef.element = (T) e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveDataExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f11988a;

        d(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f11988a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f11988a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f11988a.invoke(obj);
        }
    }

    @NotNull
    public static final <T, K, R> LiveData<R> combineWith(@NotNull LiveData<T> liveData, @NotNull LiveData<K> liveData2, @NotNull Function2<? super T, ? super K, ? extends R> block) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(liveData2, "liveData");
        Intrinsics.checkNotNullParameter(block, "block");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new d(new a(mediatorLiveData, block, liveData, liveData2)));
        mediatorLiveData.addSource(liveData2, new d(new b(mediatorLiveData, block, liveData, liveData2)));
        return mediatorLiveData;
    }

    @NotNull
    public static final <T> MediatorLiveData<T> debounce(@NotNull LiveData<T> liveData, long j4, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        MediatorLiveData<T> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(liveData, new d(new c(new Ref.ObjectRef(), coroutineScope, j4, mediatorLiveData, liveData)));
        return mediatorLiveData;
    }

    public static /* synthetic */ MediatorLiveData debounce$default(LiveData liveData, long j4, CoroutineScope coroutineScope, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = 1000;
        }
        return debounce(liveData, j4, coroutineScope);
    }

    @NotNull
    public static final <T> T requireValue(@NotNull LiveData<T> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        T value = liveData.getValue();
        if (value != null) {
            return value;
        }
        throw new NullPointerException("LiveData value is null!");
    }
}
