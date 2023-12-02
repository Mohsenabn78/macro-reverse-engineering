package com.arlosoft.macrodroid.templatestore.ui.userlist;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.databinding.ItemTemplatesUserBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.utils.ConciseNumberFormatter;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserItemViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUserItemViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserItemViewHolder.kt\ncom/arlosoft/macrodroid/templatestore/ui/userlist/UserItemViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,56:1\n262#2,2:57\n262#2,2:59\n262#2,2:61\n*S KotlinDebug\n*F\n+ 1 UserItemViewHolder.kt\ncom/arlosoft/macrodroid/templatestore/ui/userlist/UserItemViewHolder\n*L\n37#1:57,2\n44#1:59,2\n49#1:61,2\n*E\n"})
/* loaded from: classes3.dex */
public final class UserItemViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ItemTemplatesUserBinding f14234a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ProfileImageProvider f14235b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function2<User, AvatarView, Unit> f14236c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserItemViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ User $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(User user, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$item = user;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$item, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = UserItemViewHolder.this.f14236c;
                User user = this.$item;
                AvatarView avatarView = UserItemViewHolder.this.f14234a.avatarImage;
                Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
                function2.mo1invoke(user, avatarView);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserItemViewHolder(@NotNull ItemTemplatesUserBinding binding, @NotNull ProfileImageProvider profileImageProvider, @NotNull Function2<? super User, ? super AvatarView, Unit> userClickHandler) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(userClickHandler, "userClickHandler");
        this.f14234a = binding;
        this.f14235b = profileImageProvider;
        this.f14236c = userClickHandler;
    }

    private final String a(int i4) {
        String format = ConciseNumberFormatter.format(i4);
        Intrinsics.checkNotNullExpressionValue(format, "format(rating.toLong())");
        return format;
    }

    public final void bind(@NotNull User item, boolean z3, boolean z4, boolean z5) {
        int i4;
        boolean z6;
        int i5;
        Intrinsics.checkNotNullParameter(item, "item");
        Context context = this.itemView.getContext();
        int i6 = R.color.card_bg_2;
        if (z3) {
            i4 = R.color.card_bg_2;
        } else {
            i4 = R.color.card_bg_1;
        }
        int color = ContextCompat.getColor(context, i4);
        Context context2 = this.itemView.getContext();
        if (!z3) {
            i6 = R.color.card_bg_1;
        }
        int color2 = ContextCompat.getColor(context2, i6);
        this.f14234a.cardView.setCardBackgroundColor(color);
        this.f14234a.rank.setBackgroundColor(color2);
        this.f14234a.name.setText(item.getUsername());
        ProfileImageProvider profileImageProvider = this.f14235b;
        AvatarView avatarView = this.f14234a.avatarImage;
        Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
        profileImageProvider.loadImageFromUrl(avatarView, item.getImage(), item.getUsername());
        this.f14234a.starRating.setText(a(item.getRating()));
        this.f14234a.numMacros.setText(String.valueOf(item.getNumMacros()));
        this.f14234a.rank.setText(String.valueOf(item.getUserRank()));
        CardView root = this.f14234a.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtensionsKt.onClick$default(root, null, new a(item, null), 1, null);
        int i7 = 8;
        if (z5) {
            this.f14234a.name.setPaintFlags(16);
            this.f14234a.description.setText(this.itemView.getContext().getString(R.string.template_store_user_is_blocked));
            TextView textView = this.f14234a.description;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.description");
            textView.setVisibility(0);
            this.f14234a.avatarImage.setAlpha(0.3f);
            this.f14234a.name.setAlpha(0.3f);
            this.f14234a.description.setAlpha(0.3f);
        } else {
            this.f14234a.name.setPaintFlags(1);
            this.f14234a.description.setText(item.getDescription());
            TextView textView2 = this.f14234a.description;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.description");
            if (item.getDescription().length() == 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (!z6) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            textView2.setVisibility(i5);
            this.f14234a.avatarImage.setAlpha(1.0f);
            this.f14234a.name.setAlpha(1.0f);
            this.f14234a.description.setAlpha(1.0f);
        }
        ImageView imageView = this.f14234a.subscriptionIndicator;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.subscriptionIndicator");
        if (z4) {
            i7 = 0;
        }
        imageView.setVisibility(i7);
    }
}
