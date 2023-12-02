package com.arlosoft.macrodroid.comments;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CommentsAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CommentsAdapter extends PagedListAdapter<Comment, CommentViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final CommentableItem f9811a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Comment, Unit> f9812b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function1<Comment, Unit> f9813c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function2<Comment, Boolean, Unit> f9814d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final User f9815e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final ProfileImageProvider f9816f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final List<BlockedUser> f9817g;

    /* compiled from: CommentsAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class CommentDiffCallback extends DiffUtil.ItemCallback<Comment> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        public boolean areContentsTheSame(@NotNull Comment oldItem, @NotNull Comment newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull Comment oldItem, @NotNull Comment newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommentsAdapter(@NotNull CommentableItem commentableItem, @NotNull Function1<? super Comment, Unit> editClickListener, @NotNull Function1<? super Comment, Unit> userClickListener, @NotNull Function2<? super Comment, ? super Boolean, Unit> commentClickListener, @NotNull User currentUser, @NotNull ProfileImageProvider profileImageProvider, @NotNull List<BlockedUser> blockedUsers) {
        super(new CommentDiffCallback());
        Intrinsics.checkNotNullParameter(commentableItem, "commentableItem");
        Intrinsics.checkNotNullParameter(editClickListener, "editClickListener");
        Intrinsics.checkNotNullParameter(userClickListener, "userClickListener");
        Intrinsics.checkNotNullParameter(commentClickListener, "commentClickListener");
        Intrinsics.checkNotNullParameter(currentUser, "currentUser");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(blockedUsers, "blockedUsers");
        this.f9811a = commentableItem;
        this.f9812b = editClickListener;
        this.f9813c = userClickListener;
        this.f9814d = commentClickListener;
        this.f9815e = currentUser;
        this.f9816f = profileImageProvider;
        this.f9817g = blockedUsers;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull CommentViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Comment item = getItem(i4);
        Intrinsics.checkNotNull(item);
        holder.bind(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public CommentViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new CommentViewHolder(parent, this.f9811a, this.f9812b, this.f9813c, this.f9814d, this.f9815e, this.f9816f, this.f9817g);
    }
}
