package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.database.room.UserSubscription;
import com.arlosoft.macrodroid.databinding.ListItemMyUserSubscriptionBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MyUserSubscriptionsAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MyUserSubscriptionsAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<UserSubscription> f13902a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ProfileImageProvider f13903b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function2<UserSubscription, Boolean, Unit> f13904c;

    /* compiled from: MyUserSubscriptionsAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemMyUserSubscriptionBinding f13905a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final ProfileImageProvider f13906b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final Function2<UserSubscription, Boolean, Unit> f13907c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MyUserSubscriptionsAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ UserSubscription $user;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UserSubscription userSubscription, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$user = userSubscription;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$user, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f13907c.mo1invoke(this.$user, Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MyUserSubscriptionsAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ UserSubscription $user;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(UserSubscription userSubscription, Continuation<? super b> continuation) {
                super(3, continuation);
                this.$user = userSubscription;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new b(this.$user, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f13907c.mo1invoke(this.$user, Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(@NotNull ListItemMyUserSubscriptionBinding binding, @NotNull ProfileImageProvider profileImageProvider, @NotNull Function2<? super UserSubscription, ? super Boolean, Unit> userClickListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
            Intrinsics.checkNotNullParameter(userClickListener, "userClickListener");
            this.f13905a = binding;
            this.f13906b = profileImageProvider;
            this.f13907c = userClickListener;
        }

        public final void bind(@NotNull UserSubscription user) {
            Intrinsics.checkNotNullParameter(user, "user");
            this.f13905a.maroName.setText(user.getUserName());
            CardView cardView = this.f13905a.cardView;
            Intrinsics.checkNotNullExpressionValue(cardView, "binding.cardView");
            ViewExtensionsKt.onClick$default(cardView, null, new a(user, null), 1, null);
            CardView cardView2 = this.f13905a.cardView;
            Intrinsics.checkNotNullExpressionValue(cardView2, "binding.cardView");
            ViewExtensionsKt.onLongClick$default(cardView2, null, false, new b(user, null), 3, null);
            ProfileImageProvider profileImageProvider = this.f13906b;
            AvatarView avatarView = this.f13905a.avatarImage;
            Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
            profileImageProvider.loadImageFromUrl(avatarView, user.getUserImage(), user.getUserName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MyUserSubscriptionsAdapter(@NotNull List<UserSubscription> updateItems, @NotNull ProfileImageProvider profileImageProvider, @NotNull Function2<? super UserSubscription, ? super Boolean, Unit> userClickListener) {
        Intrinsics.checkNotNullParameter(updateItems, "updateItems");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(userClickListener, "userClickListener");
        this.f13902a = updateItems;
        this.f13903b = profileImageProvider;
        this.f13904c = userClickListener;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13902a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f13902a.get(i4).getUserId();
    }

    public final void updateItems(@NotNull List<UserSubscription> updateItems) {
        Intrinsics.checkNotNullParameter(updateItems, "updateItems");
        this.f13902a = updateItems;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f13902a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemMyUserSubscriptionBinding inflate = ListItemMyUserSubscriptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f13903b, this.f13904c);
    }
}
