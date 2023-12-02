package com.arlosoft.macrodroid.templatestore.ui.userlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.database.room.UserSubscription;
import com.arlosoft.macrodroid.databinding.ItemTemplatesUserBinding;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.f;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserListAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUserListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserListAdapter.kt\ncom/arlosoft/macrodroid/templatestore/ui/userlist/UserListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n1549#2:53\n1620#2,3:54\n1549#2:57\n1620#2,3:58\n*S KotlinDebug\n*F\n+ 1 UserListAdapter.kt\ncom/arlosoft/macrodroid/templatestore/ui/userlist/UserListAdapter\n*L\n40#1:53\n40#1:54,3\n41#1:57\n41#1:58,3\n*E\n"})
/* loaded from: classes3.dex */
public final class UserListAdapter extends PagedListAdapter<User, UserItemViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ProfileImageProvider f14237a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private List<UserSubscription> f14238b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private List<BlockedUser> f14239c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function2<User, AvatarView, Unit> f14240d;

    /* compiled from: UserListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class UserDiffCallback extends DiffUtil.ItemCallback<User> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull User oldItem, @NotNull User newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull User oldItem, @NotNull User newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getUserId() == newItem.getUserId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserListAdapter(@NotNull ProfileImageProvider profileImageProvider, @NotNull List<UserSubscription> userSubscriptions, @NotNull List<BlockedUser> blockedUsers, @NotNull Function2<? super User, ? super AvatarView, Unit> userClickHandler) {
        super(new UserDiffCallback());
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(userSubscriptions, "userSubscriptions");
        Intrinsics.checkNotNullParameter(blockedUsers, "blockedUsers");
        Intrinsics.checkNotNullParameter(userClickHandler, "userClickHandler");
        this.f14237a = profileImageProvider;
        this.f14238b = userSubscriptions;
        this.f14239c = blockedUsers;
        this.f14240d = userClickHandler;
    }

    public final void updateBlockedUsers(@NotNull List<BlockedUser> blockedUsers) {
        Intrinsics.checkNotNullParameter(blockedUsers, "blockedUsers");
        this.f14239c = blockedUsers;
    }

    public final void updateSubscriptions(@NotNull List<UserSubscription> userSubscriptions) {
        Intrinsics.checkNotNullParameter(userSubscriptions, "userSubscriptions");
        this.f14238b = userSubscriptions;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull UserItemViewHolder holder, int i4) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        User item = getItem(i4);
        Intrinsics.checkNotNull(item);
        User user = item;
        List<UserSubscription> list = this.f14238b;
        collectionSizeOrDefault = f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (UserSubscription userSubscription : list) {
            arrayList.add(Integer.valueOf(userSubscription.getUserId()));
        }
        boolean contains = arrayList.contains(Integer.valueOf(user.getUserId()));
        List<BlockedUser> list2 = this.f14239c;
        collectionSizeOrDefault2 = f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (BlockedUser blockedUser : list2) {
            arrayList2.add(Integer.valueOf(blockedUser.getUserId()));
        }
        holder.bind(user, i4 % 2 == 0, contains, arrayList2.contains(Integer.valueOf(user.getUserId())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public UserItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemTemplatesUserBinding inflate = ItemTemplatesUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new UserItemViewHolder(inflate, this.f14237a, this.f14240d);
    }
}
