package com.arlosoft.macrodroid.comments;

import android.text.format.DateUtils;
import android.text.util.Linkify;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.f;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CommentViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nCommentViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentViewHolder.kt\ncom/arlosoft/macrodroid/comments/CommentViewHolder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,131:1\n1549#2:132\n1620#2,3:133\n262#3,2:136\n262#3,2:138\n262#3,2:140\n262#3,2:142\n262#3,2:144\n*S KotlinDebug\n*F\n+ 1 CommentViewHolder.kt\ncom/arlosoft/macrodroid/comments/CommentViewHolder\n*L\n52#1:132\n52#1:133,3\n61#1:136,2\n69#1:138,2\n102#1:140,2\n114#1:142,2\n116#1:144,2\n*E\n"})
/* loaded from: classes3.dex */
public final class CommentViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final CommentableItem f9801a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Comment, Unit> f9802b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function1<Comment, Unit> f9803c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function2<Comment, Boolean, Unit> f9804d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final User f9805e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final ProfileImageProvider f9806f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final List<BlockedUser> f9807g;

    /* compiled from: CommentViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isBlocked;
        final /* synthetic */ Comment $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Comment comment, boolean z3, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$item = comment;
            this.$isBlocked = z3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$item, this.$isBlocked, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CommentViewHolder.this.f9804d.mo1invoke(this.$item, Boxing.boxBoolean(this.$isBlocked));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: CommentViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isBlocked;
        final /* synthetic */ Comment $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Comment comment, boolean z3, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$item = comment;
            this.$isBlocked = z3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$item, this.$isBlocked, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CommentViewHolder.this.f9804d.mo1invoke(this.$item, Boxing.boxBoolean(this.$isBlocked));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: CommentViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Comment $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Comment comment, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$item = comment;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$item, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CommentViewHolder.this.f9803c.invoke(this.$item);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: CommentViewHolder.kt */
    @SourceDebugExtension({"SMAP\nCommentViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentViewHolder.kt\ncom/arlosoft/macrodroid/comments/CommentViewHolder$bind$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,131:1\n262#2,2:132\n*S KotlinDebug\n*F\n+ 1 CommentViewHolder.kt\ncom/arlosoft/macrodroid/comments/CommentViewHolder$bind$5\n*L\n105#1:132,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $expandContainer;
        final /* synthetic */ TextView $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ViewGroup viewGroup, TextView textView, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$expandContainer = viewGroup;
            this.$text = textView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$expandContainer, this.$text, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$expandContainer.setVisibility(8);
                this.$text.setMaxLines(100);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: CommentViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Comment $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Comment comment, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$item = comment;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$item, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CommentViewHolder.this.f9802b.invoke(this.$item);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommentViewHolder(@NotNull ViewGroup parent, @NotNull CommentableItem commentableItem, @NotNull Function1<? super Comment, Unit> editClickListener, @NotNull Function1<? super Comment, Unit> userClickListener, @NotNull Function2<? super Comment, ? super Boolean, Unit> commentClickListener, @NotNull User currentUser, @NotNull ProfileImageProvider profileImageProvider, @NotNull List<BlockedUser> blockedUsers) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(commentableItem, "commentableItem");
        Intrinsics.checkNotNullParameter(editClickListener, "editClickListener");
        Intrinsics.checkNotNullParameter(userClickListener, "userClickListener");
        Intrinsics.checkNotNullParameter(commentClickListener, "commentClickListener");
        Intrinsics.checkNotNullParameter(currentUser, "currentUser");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(blockedUsers, "blockedUsers");
        this.f9801a = commentableItem;
        this.f9802b = editClickListener;
        this.f9803c = userClickListener;
        this.f9804d = commentClickListener;
        this.f9805e = currentUser;
        this.f9806f = profileImageProvider;
        this.f9807g = blockedUsers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(GestureDetectorCompat detector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(detector, "$detector");
        return detector.onTouchEvent(motionEvent);
    }

    public final void bind(@NotNull final Comment item) {
        int collectionSizeOrDefault;
        boolean z3;
        String username;
        boolean z4;
        int i4;
        Intrinsics.checkNotNullParameter(item, "item");
        View findViewById = this.itemView.findViewById(R.id.chatLine);
        Intrinsics.checkNotNull(findViewById);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.dateLayout);
        Intrinsics.checkNotNull(findViewById2);
        ViewGroup viewGroup2 = (ViewGroup) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.text);
        Intrinsics.checkNotNull(findViewById3);
        TextView textView = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.usernameEdit);
        Intrinsics.checkNotNull(findViewById4);
        TextView textView2 = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.editButton);
        Intrinsics.checkNotNull(findViewById5);
        TextView textView3 = (TextView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R.id.cardView);
        Intrinsics.checkNotNull(findViewById6);
        CardView cardView = (CardView) findViewById6;
        View findViewById7 = this.itemView.findViewById(R.id.avatarImage);
        Intrinsics.checkNotNull(findViewById7);
        AvatarView avatarView = (AvatarView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R.id.editedDate);
        Intrinsics.checkNotNull(findViewById8);
        TextView textView4 = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R.id.expandContainer);
        Intrinsics.checkNotNull(findViewById9);
        ViewGroup viewGroup3 = (ViewGroup) findViewById9;
        View findViewById10 = this.itemView.findViewById(R.id.expandButton);
        Intrinsics.checkNotNull(findViewById10);
        ImageView imageView = (ImageView) findViewById10;
        View findViewById11 = this.itemView.findViewById(R.id.date);
        Intrinsics.checkNotNull(findViewById11);
        TextView textView5 = (TextView) findViewById11;
        List<BlockedUser> list = this.f9807g;
        collectionSizeOrDefault = f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (BlockedUser blockedUser : list) {
            arrayList.add(Integer.valueOf(blockedUser.getUserId()));
        }
        final boolean contains = arrayList.contains(Integer.valueOf(item.getUserId()));
        if (this.f9805e.getUserId() == item.getUserId()) {
            viewGroup.setLayoutDirection(1);
            viewGroup2.setLayoutDirection(1);
            textView.setGravity(5);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            textView2.setGravity(5);
            ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 5;
            textView3.setVisibility(0);
        } else {
            viewGroup.setLayoutDirection(0);
            viewGroup2.setLayoutDirection(0);
            textView.setGravity(3);
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams3).gravity = 3;
            textView2.setGravity(3);
            ViewGroup.LayoutParams layoutParams4 = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams4).gravity = 3;
            textView3.setVisibility(8);
        }
        final GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(this.itemView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.arlosoft.macrodroid.comments.CommentViewHolder$bind$detector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(@NotNull MotionEvent e4) {
                Intrinsics.checkNotNullParameter(e4, "e");
                CommentViewHolder.this.f9804d.mo1invoke(item, Boolean.valueOf(contains));
                return false;
            }
        });
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.comments.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b4;
                b4 = CommentViewHolder.b(GestureDetectorCompat.this, view, motionEvent);
                return b4;
            }
        });
        ViewExtensionsKt.onClick$default(textView2, null, new a(item, contains, null), 1, null);
        ViewExtensionsKt.onClick$default(cardView, null, new b(item, contains, null), 1, null);
        ViewExtensionsKt.onClick$default(avatarView, null, new c(item, null), 1, null);
        ViewExtensionsKt.expandTouchArea(textView3, 300);
        this.f9806f.loadImageFromUrl(avatarView, item.getUserImage(), item.getUsername());
        if (item.getUsername().length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            username = this.itemView.getContext().getString(R.string.deleted_user_username);
        } else {
            username = item.getUsername();
        }
        textView2.setText(username);
        if (contains) {
            textView.setPaintFlags(1);
            textView.setTypeface(textView.getTypeface(), 2);
            textView.setAlpha(0.6f);
            textView.setText(this.itemView.getContext().getString(R.string.blocked_user_description));
        } else {
            textView.setTypeface(textView.getTypeface(), 0);
            textView.setAlpha(1.0f);
            if (item.getUsername().length() == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                i4 = 16;
            } else {
                i4 = 1;
            }
            textView.setPaintFlags(i4);
            if (item.getText().length() > 400) {
                textView.setMaxLines(3);
                viewGroup3.setVisibility(0);
                ViewExtensionsKt.onClick$default(imageView, null, new d(viewGroup3, textView, null), 1, null);
            }
            textView.setText(item.getText());
            Linkify.addLinks(textView, 15);
        }
        textView5.setText(DateUtils.getRelativeTimeSpanString(item.getTimestamp(), Calendar.getInstance().getTimeInMillis(), (long) ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS));
        if (item.getEditTimestamp() == 0) {
            textView4.setVisibility(8);
        } else {
            textView4.setVisibility(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.itemView.getContext().getString(R.string.edited_timestamp);
            Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getStri….string.edited_timestamp)");
            String format = String.format(string, Arrays.copyOf(new Object[]{DateUtils.getRelativeTimeSpanString(item.getEditTimestamp(), Calendar.getInstance().getTimeInMillis(), (long) ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView4.setText(format);
        }
        if (Intrinsics.areEqual(this.f9801a.getCommenterName(), item.getUsername())) {
            textView2.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.comments_username_color));
        } else {
            textView2.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.comments_username_other));
        }
        ViewExtensionsKt.onClick$default(textView3, null, new e(item, null), 1, null);
    }
}
