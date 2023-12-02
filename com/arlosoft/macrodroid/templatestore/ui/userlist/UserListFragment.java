package com.arlosoft.macrodroid.templatestore.ui.userlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.UserSubscription;
import com.arlosoft.macrodroid.databinding.FragmentTemplateStoreListNoSwipeRefreshBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider;
import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserListFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUserListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserListFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/userlist/UserListFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,131:1\n262#2,2:132\n262#2,2:134\n262#2,2:136\n262#2,2:138\n262#2,2:140\n262#2,2:142\n262#2,2:144\n262#2,2:146\n262#2,2:148\n262#2,2:150\n262#2,2:152\n262#2,2:154\n262#2,2:156\n*S KotlinDebug\n*F\n+ 1 UserListFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/userlist/UserListFragment\n*L\n73#1:132,2\n74#1:134,2\n75#1:136,2\n76#1:138,2\n80#1:140,2\n81#1:142,2\n82#1:144,2\n83#1:146,2\n87#1:148,2\n88#1:150,2\n89#1:152,2\n90#1:154,2\n108#1:156,2\n*E\n"})
/* loaded from: classes3.dex */
public final class UserListFragment extends MacroDroidDaggerBaseFragment implements UserListViewContract, TemplateStoreList {

    /* renamed from: b  reason: collision with root package name */
    private UserListAdapter f14241b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentTemplateStoreListNoSwipeRefreshBinding f14242c;
    @Inject
    public UserListPresenter presenter;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public MacroDroidRoomDatabase roomDatabase;
    @Inject
    public UserProvider userProvider;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: UserListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserListFragment newInstance() {
            return new UserListFragment();
        }
    }

    /* compiled from: UserListFragment.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserListFragment.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0123a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<BlockedUser> $blockedUsers;
            final /* synthetic */ List<UserSubscription> $userSubscriptions;
            int label;
            final /* synthetic */ UserListFragment this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: UserListFragment.kt */
            /* renamed from: com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0124a extends Lambda implements Function2<User, AvatarView, Unit> {
                final /* synthetic */ UserListFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0124a(UserListFragment userListFragment) {
                    super(2);
                    this.this$0 = userListFragment;
                }

                public final void a(@NotNull User user, @NotNull AvatarView avatarView) {
                    Intrinsics.checkNotNullParameter(user, "user");
                    Intrinsics.checkNotNullParameter(avatarView, "avatarView");
                    this.this$0.getPresenter().onUserClicked(user, avatarView);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ Unit mo1invoke(User user, AvatarView avatarView) {
                    a(user, avatarView);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0123a(UserListFragment userListFragment, List<UserSubscription> list, List<BlockedUser> list2, Continuation<? super C0123a> continuation) {
                super(2, continuation);
                this.this$0 = userListFragment;
                this.$userSubscriptions = list;
                this.$blockedUsers = list2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0123a(this.this$0, this.$userSubscriptions, this.$blockedUsers, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.f14241b = new UserListAdapter(this.this$0.getProfileImageProvider(), this.$userSubscriptions, this.$blockedUsers, new C0124a(this.this$0));
                    FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding = this.this$0.f14242c;
                    UserListAdapter userListAdapter = null;
                    if (fragmentTemplateStoreListNoSwipeRefreshBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentTemplateStoreListNoSwipeRefreshBinding = null;
                    }
                    RecyclerView recyclerView = fragmentTemplateStoreListNoSwipeRefreshBinding.updatesList;
                    UserListAdapter userListAdapter2 = this.this$0.f14241b;
                    if (userListAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        userListAdapter = userListAdapter2;
                    }
                    recyclerView.setAdapter(userListAdapter);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0123a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x006f A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L29
                if (r1 == r4) goto L25
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r8)
                goto L70
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1d:
                java.lang.Object r1 = r7.L$0
                java.util.List r1 = (java.util.List) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L57
            L25:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L3f
            L29:
                kotlin.ResultKt.throwOnFailure(r8)
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment r8 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.this
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r8 = r8.getRoomDatabase()
                com.arlosoft.macrodroid.database.room.UserSubscriptionDao r8 = r8.userSubscriptionDao()
                r7.label = r4
                java.lang.Object r8 = r8.getAllUserSubscriptions(r7)
                if (r8 != r0) goto L3f
                return r0
            L3f:
                r1 = r8
                java.util.List r1 = (java.util.List) r1
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment r8 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.this
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r8 = r8.getRoomDatabase()
                com.arlosoft.macrodroid.database.room.BlockedUserDao r8 = r8.blockedUserDao()
                r7.L$0 = r1
                r7.label = r3
                java.lang.Object r8 = r8.getAllBlockedUsers(r7)
                if (r8 != r0) goto L57
                return r0
            L57:
                java.util.List r8 = (java.util.List) r8
                kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment$a$a r4 = new com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment$a$a
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment r5 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.this
                r6 = 0
                r4.<init>(r5, r1, r8, r6)
                r7.L$0 = r6
                r7.label = r2
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r7)
                if (r8 != r0) goto L70
                return r0
            L70:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: UserListFragment.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UserListFragment.this.getPresenter().loadUsers();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserListFragment.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UserListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UserListFragment userListFragment, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = userListFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    UserListAdapter userListAdapter = this.this$0.f14241b;
                    if (userListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        userListAdapter = null;
                    }
                    userListAdapter.notifyDataSetChanged();
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

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0090 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto L91
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.L$0
                java.util.List r1 = (java.util.List) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L58
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L40
            L2a:
                kotlin.ResultKt.throwOnFailure(r7)
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment r7 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.this
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r7 = r7.getRoomDatabase()
                com.arlosoft.macrodroid.database.room.UserSubscriptionDao r7 = r7.userSubscriptionDao()
                r6.label = r4
                java.lang.Object r7 = r7.getAllUserSubscriptions(r6)
                if (r7 != r0) goto L40
                return r0
            L40:
                r1 = r7
                java.util.List r1 = (java.util.List) r1
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment r7 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.this
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r7 = r7.getRoomDatabase()
                com.arlosoft.macrodroid.database.room.BlockedUserDao r7 = r7.blockedUserDao()
                r6.L$0 = r1
                r6.label = r3
                java.lang.Object r7 = r7.getAllBlockedUsers(r6)
                if (r7 != r0) goto L58
                return r0
            L58:
                java.util.List r7 = (java.util.List) r7
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment r3 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.this
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListAdapter r3 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.access$getAdapter$p(r3)
                java.lang.String r4 = "adapter"
                r5 = 0
                if (r3 != 0) goto L69
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
                r3 = r5
            L69:
                r3.updateSubscriptions(r1)
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment r1 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.this
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListAdapter r1 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.access$getAdapter$p(r1)
                if (r1 != 0) goto L78
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
                r1 = r5
            L78:
                r1.updateBlockedUsers(r7)
                kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment$c$a r1 = new com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment$c$a
                com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment r3 = com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.this
                r1.<init>(r3, r5)
                r6.L$0 = r5
                r6.label = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6)
                if (r7 != r0) goto L91
                return r0
            L91:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @NotNull
    public final UserListPresenter getPresenter() {
        UserListPresenter userListPresenter = this.presenter;
        if (userListPresenter != null) {
            return userListPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    @NotNull
    public final ProfileImageProvider getProfileImageProvider() {
        ProfileImageProvider profileImageProvider = this.profileImageProvider;
        if (profileImageProvider != null) {
            return profileImageProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("profileImageProvider");
        return null;
    }

    @NotNull
    public final MacroDroidRoomDatabase getRoomDatabase() {
        MacroDroidRoomDatabase macroDroidRoomDatabase = this.roomDatabase;
        if (macroDroidRoomDatabase != null) {
            return macroDroidRoomDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("roomDatabase");
        return null;
    }

    @NotNull
    public final UserProvider getUserProvider() {
        UserProvider userProvider = this.userProvider;
        if (userProvider != null) {
            return userProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProvider");
        return null;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.userlist.UserListViewContract
    public void initialiseList() {
        e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new a(null), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding = null;
        }
        ViewCompat.setNestedScrollingEnabled(fragmentTemplateStoreListNoSwipeRefreshBinding.updatesList, false);
        UserListPresenter presenter = getPresenter();
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider");
        presenter.takeView(this, (SearchTermProvider) parentFragment, getUserProvider().getUser().getUserId());
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding2 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding2 = null;
        }
        AppCompatButton appCompatButton = fragmentTemplateStoreListNoSwipeRefreshBinding2.retryButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "binding.retryButton");
        ViewExtensionsKt.onClick$default(appCompatButton, null, new b(null), 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentTemplateStoreListNoSwipeRefreshBinding inflate = FragmentTemplateStoreListNoSwipeRefreshBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f14242c = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return inflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().dropView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.userlist.UserListViewContract
    public void refresh() {
        if (this.f14241b != null) {
            e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new c(null), 2, null);
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList
    public void scrollToTop() {
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding = null;
        }
        fragmentTemplateStoreListNoSwipeRefreshBinding.updatesList.smoothScrollToPosition(0);
    }

    public final void setPresenter(@NotNull UserListPresenter userListPresenter) {
        Intrinsics.checkNotNullParameter(userListPresenter, "<set-?>");
        this.presenter = userListPresenter;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setRoomDatabase(@NotNull MacroDroidRoomDatabase macroDroidRoomDatabase) {
        Intrinsics.checkNotNullParameter(macroDroidRoomDatabase, "<set-?>");
        this.roomDatabase = macroDroidRoomDatabase;
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.userlist.UserListViewContract
    public void showLoadDataError() {
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding = this.f14242c;
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding2 = null;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding = null;
        }
        LottieAnimationView lottieAnimationView = fragmentTemplateStoreListNoSwipeRefreshBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(8);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding3 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding3 = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListNoSwipeRefreshBinding3.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        linearLayout.setVisibility(8);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding4 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding4 = null;
        }
        LinearLayout linearLayout2 = fragmentTemplateStoreListNoSwipeRefreshBinding4.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
        linearLayout2.setVisibility(0);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding5 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListNoSwipeRefreshBinding2 = fragmentTemplateStoreListNoSwipeRefreshBinding5;
        }
        LinearLayout linearLayout3 = fragmentTemplateStoreListNoSwipeRefreshBinding2.pirateView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pirateView");
        linearLayout3.setVisibility(8);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.userlist.UserListViewContract
    public void showLoadingState(boolean z3) {
        int i4;
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding = this.f14242c;
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding2 = null;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListNoSwipeRefreshBinding.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        linearLayout.setVisibility(8);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding3 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding3 = null;
        }
        LinearLayout linearLayout2 = fragmentTemplateStoreListNoSwipeRefreshBinding3.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
        linearLayout2.setVisibility(8);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding4 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding4 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentTemplateStoreListNoSwipeRefreshBinding4.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        lottieAnimationView.setVisibility(i4);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding5 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListNoSwipeRefreshBinding2 = fragmentTemplateStoreListNoSwipeRefreshBinding5;
        }
        LinearLayout linearLayout3 = fragmentTemplateStoreListNoSwipeRefreshBinding2.pirateView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pirateView");
        linearLayout3.setVisibility(8);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.userlist.UserListViewContract
    public void showPirateUserError() {
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding = this.f14242c;
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding2 = null;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding = null;
        }
        LottieAnimationView lottieAnimationView = fragmentTemplateStoreListNoSwipeRefreshBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(8);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding3 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding3 = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListNoSwipeRefreshBinding3.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        linearLayout.setVisibility(8);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding4 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding4 = null;
        }
        LinearLayout linearLayout2 = fragmentTemplateStoreListNoSwipeRefreshBinding4.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
        linearLayout2.setVisibility(8);
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding5 = this.f14242c;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListNoSwipeRefreshBinding2 = fragmentTemplateStoreListNoSwipeRefreshBinding5;
        }
        LinearLayout linearLayout3 = fragmentTemplateStoreListNoSwipeRefreshBinding2.pirateView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pirateView");
        linearLayout3.setVisibility(0);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.userlist.UserListViewContract
    public void updateList(@Nullable PagedList<User> pagedList) {
        boolean z3;
        int i4;
        FragmentTemplateStoreListNoSwipeRefreshBinding fragmentTemplateStoreListNoSwipeRefreshBinding = this.f14242c;
        UserListAdapter userListAdapter = null;
        if (fragmentTemplateStoreListNoSwipeRefreshBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListNoSwipeRefreshBinding = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListNoSwipeRefreshBinding.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        boolean z4 = true;
        if (pagedList != null && pagedList.isEmpty()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        linearLayout.setVisibility(i4);
        if ((pagedList == null || pagedList.isEmpty()) ? false : false) {
            UserListAdapter userListAdapter2 = this.f14241b;
            if (userListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                userListAdapter = userListAdapter2;
            }
            userListAdapter.submitList(pagedList);
        }
    }
}
