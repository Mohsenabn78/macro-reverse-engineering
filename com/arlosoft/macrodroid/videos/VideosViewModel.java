package com.arlosoft.macrodroid.videos;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.videos.data.VideoInfo;
import com.arlosoft.macrodroid.videos.data.VideosData;
import com.arlosoft.macrodroid.videos.util.VideoHelper;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideosViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VideosViewModel extends ViewModel implements VideoClickedListener {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final VideoDataRepository f16431a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final VideoHelper f16432b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<VideosData> f16433c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final LiveData<VideosData> f16434d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideosViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
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
            MutableLiveData mutableLiveData;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    mutableLiveData = (MutableLiveData) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = VideosViewModel.this.f16433c;
                VideoDataRepository videoDataRepository = VideosViewModel.this.f16431a;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object videoData = videoDataRepository.getVideoData(this);
                if (videoData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                obj = videoData;
            }
            mutableLiveData.postValue(obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public VideosViewModel(@NotNull VideoDataRepository repository, @NotNull VideoHelper videoHelper) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(videoHelper, "videoHelper");
        this.f16431a = repository;
        this.f16432b = videoHelper;
        MutableLiveData<VideosData> mutableLiveData = new MutableLiveData<>();
        this.f16433c = mutableLiveData;
        this.f16434d = mutableLiveData;
        requestVideoData();
    }

    @NotNull
    public final LiveData<VideosData> getVideos() {
        return this.f16434d;
    }

    @Override // com.arlosoft.macrodroid.videos.VideoClickedListener
    public void onVideoClicked(@NotNull VideoInfo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        this.f16432b.openVideo(videoInfo);
    }

    public final void requestVideoData() {
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new a(null), 2, null);
    }
}
