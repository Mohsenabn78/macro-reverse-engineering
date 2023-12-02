package com.arlosoft.macrodroid.templatestore.ui.subscription;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.database.room.SubcriptionUpdateType;
import com.arlosoft.macrodroid.database.room.SubscriptionUpdateItem;
import com.arlosoft.macrodroid.databinding.ListItemSubscriptionUpdateBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.subscription.TemplateUpdatesAdapter;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateUpdatesAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplateUpdatesAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<SubscriptionUpdateItem> f13863a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ProfileImageProvider f13864b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function1<SubscriptionUpdateItem, Unit> f13865c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function1<SubscriptionUpdateItem, Unit> f13866d;

    /* compiled from: TemplateUpdatesAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemSubscriptionUpdateBinding f13867a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final ProfileImageProvider f13868b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final Function1<SubscriptionUpdateItem, Unit> f13869c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final Function1<SubscriptionUpdateItem, Unit> f13870d;

        /* compiled from: TemplateUpdatesAdapter.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SubcriptionUpdateType.values().length];
                try {
                    iArr[SubcriptionUpdateType.TYPE_MACRO_UPDATED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SubcriptionUpdateType.TYPE_MACRO_DELETED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SubcriptionUpdateType.TYPE_MACRO_NEW_COMMENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SubcriptionUpdateType.TYPE_USER_NEW_MACRO.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateUpdatesAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ SubscriptionUpdateItem $updateItem;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SubscriptionUpdateItem subscriptionUpdateItem, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$updateItem = subscriptionUpdateItem;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$updateItem, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f13869c.invoke(this.$updateItem);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(@NotNull ListItemSubscriptionUpdateBinding binding, @NotNull ProfileImageProvider profileImageProvider, @NotNull Function1<? super SubscriptionUpdateItem, Unit> updateClickListener, @NotNull Function1<? super SubscriptionUpdateItem, Unit> userClickListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
            Intrinsics.checkNotNullParameter(updateClickListener, "updateClickListener");
            Intrinsics.checkNotNullParameter(userClickListener, "userClickListener");
            this.f13867a = binding;
            this.f13868b = profileImageProvider;
            this.f13869c = updateClickListener;
            this.f13870d = userClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ViewHolder this$0, SubscriptionUpdateItem updateItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(updateItem, "$updateItem");
            this$0.f13870d.invoke(updateItem);
        }

        public final void bind(@NotNull final SubscriptionUpdateItem updateItem) {
            Intrinsics.checkNotNullParameter(updateItem, "updateItem");
            this.f13867a.timeLabel.setText(String.valueOf(DateUtils.getRelativeTimeSpanString(updateItem.getTimestamp(), Calendar.getInstance().getTimeInMillis(), (long) ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS)));
            this.f13867a.userNameLabel.setText(updateItem.getUsername());
            ProfileImageProvider profileImageProvider = this.f13868b;
            AvatarView avatarView = this.f13867a.avatarImage;
            Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
            profileImageProvider.loadImageFromUrl(avatarView, updateItem.getUserImage(), updateItem.getUsername());
            int i4 = WhenMappings.$EnumSwitchMapping$0[updateItem.getType().ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            this.f13867a.icon.setImageResource(R.drawable.ic_plus_circle_white_48dp);
                            ListItemSubscriptionUpdateBinding listItemSubscriptionUpdateBinding = this.f13867a;
                            TextView textView = listItemSubscriptionUpdateBinding.title;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String string = listItemSubscriptionUpdateBinding.updateText.getContext().getString(R.string.template_store_subscribed_macro_new_macro_from_user);
                            Intrinsics.checkNotNullExpressionValue(string, "binding.updateText.conte…acro_new_macro_from_user)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{updateItem.getUsername()}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                            textView.setText(format);
                            this.f13867a.updateText.setText(updateItem.getMacroName());
                        }
                    } else {
                        this.f13867a.icon.setImageResource(R.drawable.ic_insert_comment_white_24dp);
                        ListItemSubscriptionUpdateBinding listItemSubscriptionUpdateBinding2 = this.f13867a;
                        TextView textView2 = listItemSubscriptionUpdateBinding2.title;
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String string2 = listItemSubscriptionUpdateBinding2.updateText.getContext().getString(R.string.template_store_subscribed_macro_new_comment);
                        Intrinsics.checkNotNullExpressionValue(string2, "binding.updateText.conte…cribed_macro_new_comment)");
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{updateItem.getMacroName()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                        textView2.setText(format2);
                        this.f13867a.updateText.setText(updateItem.getComment());
                    }
                } else {
                    this.f13867a.icon.setImageResource(R.drawable.ic_delete_white_24dp);
                    ListItemSubscriptionUpdateBinding listItemSubscriptionUpdateBinding3 = this.f13867a;
                    listItemSubscriptionUpdateBinding3.title.setText(listItemSubscriptionUpdateBinding3.updateText.getContext().getString(R.string.template_store_subscribed_macro_deleted_heading));
                    this.f13867a.updateText.setText(updateItem.getMacroName());
                }
            } else {
                this.f13867a.icon.setImageResource(R.drawable.ic_refresh_white_24dp);
                ListItemSubscriptionUpdateBinding listItemSubscriptionUpdateBinding4 = this.f13867a;
                listItemSubscriptionUpdateBinding4.title.setText(listItemSubscriptionUpdateBinding4.updateText.getContext().getString(R.string.template_store_subscribed_macro_updated_heading));
                this.f13867a.updateText.setText(updateItem.getMacroName());
            }
            CardView cardView = this.f13867a.cardView;
            Intrinsics.checkNotNullExpressionValue(cardView, "binding.cardView");
            ViewExtensionsKt.onClick$default(cardView, null, new a(updateItem, null), 1, null);
            this.f13867a.userContainer.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TemplateUpdatesAdapter.ViewHolder.b(TemplateUpdatesAdapter.ViewHolder.this, updateItem, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TemplateUpdatesAdapter(@NotNull List<SubscriptionUpdateItem> updateItems, @NotNull ProfileImageProvider profileImageProvider, @NotNull Function1<? super SubscriptionUpdateItem, Unit> updateClickListener, @NotNull Function1<? super SubscriptionUpdateItem, Unit> userClickListener) {
        Intrinsics.checkNotNullParameter(updateItems, "updateItems");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(updateClickListener, "updateClickListener");
        Intrinsics.checkNotNullParameter(userClickListener, "userClickListener");
        this.f13863a = updateItems;
        this.f13864b = profileImageProvider;
        this.f13865c = updateClickListener;
        this.f13866d = userClickListener;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13863a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f13863a.get(i4).getId();
    }

    public final void updateItems(@NotNull List<SubscriptionUpdateItem> updateItems) {
        Intrinsics.checkNotNullParameter(updateItems, "updateItems");
        this.f13863a = updateItems;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f13863a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemSubscriptionUpdateBinding inflate = ListItemSubscriptionUpdateBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f13864b, this.f13865c, this.f13866d);
    }
}
