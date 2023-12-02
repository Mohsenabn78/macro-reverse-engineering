package com.arlosoft.macrodroid.settings;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ListItemNotificationChannelBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.notification.NotificationChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditNotificationChannelsActivity.kt */
/* loaded from: classes3.dex */
public final class u extends RecyclerView.ViewHolder {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ListItemNotificationChannelBinding f13573a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final com.arlosoft.macrodroid.settings.a f13574b;

    /* compiled from: EditNotificationChannelsActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ NotificationChannel $notificationChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(NotificationChannel notificationChannel, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$notificationChannel = notificationChannel;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$notificationChannel, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                u.this.f13574b.onChannelSelected(this.$notificationChannel);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(@NotNull ListItemNotificationChannelBinding binding, @NotNull com.arlosoft.macrodroid.settings.a channelSelectedCallback) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(channelSelectedCallback, "channelSelectedCallback");
        this.f13573a = binding;
        this.f13574b = channelSelectedCallback;
    }

    public final void b(@NotNull NotificationChannel notificationChannel) {
        Intrinsics.checkNotNullParameter(notificationChannel, "notificationChannel");
        this.f13573a.channelName.setText(notificationChannel.getChannelName());
        LinearLayout linearLayout = this.f13573a.container;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.container");
        ViewExtensionsKt.onClick$default(linearLayout, null, new a(notificationChannel, null), 1, null);
    }
}
