package com.arlosoft.macrodroid.extras.ui;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.databinding.ListItemExtraBinding;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState;
import com.arlosoft.macrodroid.extras.data.ExtraPermissions;
import com.arlosoft.macrodroid.extras.data.SupportChannel;
import com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener;
import com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joni.constants.internal.NodeType;
import xyz.kumaraswamy.autostart.Autostart;

/* compiled from: ExtrasAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nExtrasAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtrasAdapter.kt\ncom/arlosoft/macrodroid/extras/ui/ExtrasAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,450:1\n350#2,7:451\n350#2,7:458\n350#2,7:465\n350#2,7:472\n350#2,7:479\n350#2,7:486\n*S KotlinDebug\n*F\n+ 1 ExtrasAdapter.kt\ncom/arlosoft/macrodroid/extras/ui/ExtrasAdapter\n*L\n388#1:451,7\n396#1:458,7\n404#1:465,7\n421#1:472,7\n430#1:479,7\n439#1:486,7\n*E\n"})
/* loaded from: classes3.dex */
public final class ExtrasAdapter extends RecyclerView.Adapter<ExtraViewHolder> implements ListRefresher {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f12105a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ExtraPackageClickListener f12106b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private List<ExtraPackageWithPriceAndState> f12107c;

    /* compiled from: ExtrasAdapter.kt */
    @StabilityInferred(parameters = 0)
    @SourceDebugExtension({"SMAP\nExtrasAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtrasAdapter.kt\ncom/arlosoft/macrodroid/extras/ui/ExtrasAdapter$ExtraViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 CustomViewProperties.kt\norg/jetbrains/anko/CustomViewPropertiesKt\n*L\n1#1,450:1\n262#2,2:451\n262#2,2:453\n262#2,2:455\n262#2,2:458\n262#2,2:460\n262#2,2:462\n260#2:464\n262#2,2:465\n262#2,2:467\n262#2,2:469\n262#2,2:471\n262#2,2:473\n262#2,2:475\n262#2,2:477\n262#2,2:479\n262#2,2:481\n262#2,2:483\n262#2,2:499\n262#2,2:501\n262#2,2:503\n1#3:457\n1963#4,14:485\n78#5:505\n*S KotlinDebug\n*F\n+ 1 ExtrasAdapter.kt\ncom/arlosoft/macrodroid/extras/ui/ExtrasAdapter$ExtraViewHolder\n*L\n81#1:451,2\n87#1:453,2\n118#1:455,2\n123#1:458,2\n126#1:460,2\n129#1:462,2\n159#1:464\n160#1:465,2\n161#1:467,2\n163#1:469,2\n168#1:471,2\n173#1:473,2\n178#1:475,2\n183#1:477,2\n188#1:479,2\n193#1:481,2\n207#1:483,2\n212#1:499,2\n217#1:501,2\n220#1:503,2\n211#1:485,14\n346#1:505\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class ExtraViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListRefresher f12108a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final ListItemExtraBinding f12109b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final String f12110c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final ExtraPackageClickListener f12111d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Function0<Unit> function0, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$callback = function0;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$callback, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$callback.invoke();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends Lambda implements Function0<Unit> {
            final /* synthetic */ ViewGroup $container;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ViewGroup viewGroup) {
                super(0);
                this.$container = viewGroup;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                String packageName = this.$container.getContext().getPackageName();
                intent.setData(Uri.parse("package:" + packageName));
                intent.addFlags(268435456);
                try {
                    this.$container.getContext().startActivity(intent);
                } catch (Exception unused) {
                    ToastCompat.makeText(this.$container.getContext().getApplicationContext(), (CharSequence) this.$container.getContext().getString(R.string.cannot_launch_settings), 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class c extends Lambda implements Function0<Unit> {
            final /* synthetic */ ViewGroup $container;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(ViewGroup viewGroup) {
                super(0);
                this.$container = viewGroup;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    Context context = this.$container.getContext();
                    Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                } catch (Exception unused) {
                    ToastCompat.makeText(this.$container.getContext().getApplicationContext(), (CharSequence) this.$container.getContext().getString(R.string.cannot_launch_accessibility_settings), 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class d extends Lambda implements Function0<Unit> {
            final /* synthetic */ ViewGroup $container;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(ViewGroup viewGroup) {
                super(0);
                this.$container = viewGroup;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    Context context = this.$container.getContext();
                    Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                } catch (Exception unused) {
                    ToastCompat.makeText(this.$container.getContext().getApplicationContext(), (CharSequence) this.$container.getContext().getString(R.string.cannot_launch_accessibility_settings), 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class e extends Lambda implements Function0<Unit> {
            final /* synthetic */ ViewGroup $container;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(ViewGroup viewGroup) {
                super(0);
                this.$container = viewGroup;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    String packageName = this.$container.getContext().getPackageName();
                    intent.setData(Uri.parse("package:" + packageName));
                    intent.addFlags(268435456);
                    this.$container.getContext().startActivity(intent);
                } catch (Exception unused) {
                    Intent intent2 = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
                    intent2.addFlags(268435456);
                    this.$container.getContext().startActivity(intent2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class f extends Lambda implements Function0<Unit> {
            final /* synthetic */ ViewGroup $container;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(ViewGroup viewGroup) {
                super(0);
                this.$container = viewGroup;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    Intent putExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", this.$container.getContext().getPackageName());
                    Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Settings.ACTION_A…iner.context.packageName)");
                    this.$container.getContext().startActivity(putExtra);
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class g extends Lambda implements Function0<Unit> {
            final /* synthetic */ ViewGroup $container;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(ViewGroup viewGroup) {
                super(0);
                this.$container = viewGroup;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                intent.addFlags(268435456);
                this.$container.getContext().startActivity(intent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;

            h(Continuation<? super h> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new h(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12109b.weeklySubscriptionOption.setChecked(false);
                    ExtraViewHolder.this.f12109b.monthlySubscriptionOption.setChecked(true);
                    ExtraViewHolder.this.f12109b.yearlySubscriptionOption.setChecked(false);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;

            i(Continuation<? super i> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new i(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12109b.weeklySubscriptionOption.setChecked(false);
                    ExtraViewHolder.this.f12109b.monthlySubscriptionOption.setChecked(false);
                    ExtraViewHolder.this.f12109b.yearlySubscriptionOption.setChecked(true);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class j extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super j> continuation) {
                super(3, continuation);
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new j(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                ExtraPackageClickListener.PurchasePeriod purchasePeriod;
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (ExtraViewHolder.this.d(this.$extraPackage)) {
                        ExtraViewHolder.this.f12111d.onNeedsMacroDroidUpdate(this.$extraPackage.getMinVersionRemoteConfig());
                    } else {
                        if (ExtraViewHolder.this.f12109b.yearlySubscriptionOption.isChecked()) {
                            purchasePeriod = ExtraPackageClickListener.PurchasePeriod.YEARLY;
                        } else if (ExtraViewHolder.this.f12109b.monthlySubscriptionOption.isChecked()) {
                            purchasePeriod = ExtraPackageClickListener.PurchasePeriod.MONTHLY;
                        } else {
                            purchasePeriod = ExtraPackageClickListener.PurchasePeriod.WEEKLY;
                        }
                        ExtraViewHolder.this.f12111d.onPurchaseClick(this.$extraPackage, purchasePeriod);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ SupportChannel $telegramChannel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            k(SupportChannel supportChannel, Continuation<? super k> continuation) {
                super(3, continuation);
                this.$telegramChannel = supportChannel;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new k(this.$telegramChannel, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12111d.onTelegramClicked(this.$telegramChannel.getLink());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class l extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            l(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super l> continuation) {
                super(3, continuation);
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new l(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12111d.onEmailClicked(this.$extraPackage);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class m extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ SupportChannel $whatsappChannel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            m(SupportChannel supportChannel, Continuation<? super m> continuation) {
                super(3, continuation);
                this.$whatsappChannel = supportChannel;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new m(this.$whatsappChannel, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12111d.onWhatsAppClicked(this.$whatsappChannel.getLink());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class n extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            n(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super n> continuation) {
                super(3, continuation);
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new n(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12111d.onRetryValidationClicked(this.$extraPackage);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class o extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            o(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super o> continuation) {
                super(3, continuation);
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new o(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12111d.onManageSubscriptionClicked(this.$extraPackage.getExtra());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class p extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            p(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super p> continuation) {
                super(3, continuation);
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new p(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12111d.onInstallVersionUpdateClicked(this.$extraPackage);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class q extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;

            q(Continuation<? super q> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new q(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder extraViewHolder = ExtraViewHolder.this;
                    Context context = extraViewHolder.f12109b.getRoot().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
                    extraViewHolder.c(context);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class r extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            r(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super r> continuation) {
                super(3, continuation);
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new r(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12111d.onVersionHistoryClicked(this.$extraPackage.getExtra());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class s extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;

            s(Continuation<? super s> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new s(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtraViewHolder.this.f12109b.weeklySubscriptionOption.setChecked(true);
                    ExtraViewHolder.this.f12109b.monthlySubscriptionOption.setChecked(false);
                    ExtraViewHolder.this.f12109b.yearlySubscriptionOption.setChecked(false);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExtraViewHolder(@NotNull ListRefresher listRefresher, @NotNull ListItemExtraBinding binding, @NotNull String languageCode, @NotNull ExtraPackageClickListener clickListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(listRefresher, "listRefresher");
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.f12108a = listRefresher;
            this.f12109b = binding;
            this.f12110c = languageCode;
            this.f12111d = clickListener;
        }

        private final Button a(ViewGroup viewGroup, String str, Function0<Unit> function0) {
            Button button = new Button(viewGroup.getContext());
            button.setText(str);
            button.setAllCaps(false);
            Sdk27PropertiesKt.setTextColor(button, ContextCompat.getColor(viewGroup.getContext(), R.color.default_text_color_inverse));
            button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(viewGroup.getContext(), R.color.extra_setup_required)));
            ViewExtensionsKt.onClick$default(button, null, new a(function0, null), 1, null);
            viewGroup.addView(button);
            ViewExtensionsKt.setMarginTop(button, IntExtensionsKt.getPx(4));
            return button;
        }

        private final boolean b(ExtraPackage extraPackage, ViewGroup viewGroup) {
            boolean isIgnoringBatteryOptimizations;
            boolean canDrawOverlays;
            viewGroup.removeAllViews();
            for (String str : extraPackage.getPermissions()) {
                int hashCode = str.hashCode();
                if (hashCode != -1885735535) {
                    if (hashCode != -714151487) {
                        if (hashCode == 258614264 && str.equals(ExtraPermissions.PERMISSION_ACCESSIBILITY_UI_INTERACTION) && !Util.isUIInteractionAccessibilityEnabled(viewGroup.getContext())) {
                            String string = viewGroup.getContext().getString(R.string.md_ui_interaction);
                            Intrinsics.checkNotNullExpressionValue(string, "container.context.getStr…string.md_ui_interaction)");
                            a(viewGroup, string, new c(viewGroup));
                        }
                    } else if (str.equals(ExtraPermissions.PERMISSION_ACCESSIBILITY_MACRODROID) && !Util.isAccessibilityEnabled(viewGroup.getContext(), new String[0])) {
                        String string2 = viewGroup.getContext().getString(R.string.action_accessibility_service);
                        Intrinsics.checkNotNullExpressionValue(string2, "container.context.getStr…on_accessibility_service)");
                        a(viewGroup, string2, new d(viewGroup));
                    }
                } else if (str.equals(ExtraPermissions.PERMISSION_DRAW_OVER_OTHER_APPS) && Build.VERSION.SDK_INT >= 23) {
                    canDrawOverlays = Settings.canDrawOverlays(viewGroup.getContext());
                    if (!canDrawOverlays) {
                        String string3 = viewGroup.getContext().getString(R.string.requires_draw_overlays);
                        Intrinsics.checkNotNullExpressionValue(string3, "container.context.getStr…g.requires_draw_overlays)");
                        a(viewGroup, string3, new b(viewGroup));
                    }
                }
            }
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 23) {
                Object systemService = viewGroup.getContext().getSystemService("power");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(viewGroup.getContext().getPackageName());
                if (!isIgnoringBatteryOptimizations) {
                    String string4 = viewGroup.getContext().getString(R.string.ignore_battery_optimisations);
                    Intrinsics.checkNotNullExpressionValue(string4, "container.context.getStr…re_battery_optimisations)");
                    a(viewGroup, string4, new e(viewGroup));
                }
                if (i4 >= 26 && !NotificationManagerCompat.from(viewGroup.getContext()).areNotificationsEnabled()) {
                    String string5 = viewGroup.getContext().getString(R.string.configure_notifications);
                    Intrinsics.checkNotNullExpressionValue(string5, "container.context.getStr….configure_notifications)");
                    a(viewGroup, string5, new f(viewGroup));
                }
            }
            try {
                if (new Autostart(viewGroup.getContext()).getAutoStartState() == Autostart.State.DISABLED) {
                    String string6 = viewGroup.getContext().getString(R.string.troubleshoot_miui_autostart_must_be_enabled);
                    Intrinsics.checkNotNullExpressionValue(string6, "container.context.getStr…utostart_must_be_enabled)");
                    a(viewGroup, string6, new g(viewGroup));
                }
            } catch (Exception unused) {
            }
            if (viewGroup.getChildCount() <= 0) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(Context context) {
            try {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.arlosoft.macrodroid"));
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                }
            } catch (ActivityNotFoundException unused2) {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.arlosoft.macrodroid"));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
            if (extraPackageWithPriceAndState.getMinVersionRemoteConfig().getVersionCode() > 53800019) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x039a  */
        /* JADX WARN: Removed duplicated region for block: B:101:0x03ac  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x03b8  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x03ba  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x03c7  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x047a  */
        /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0228  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x022a  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x023c  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0250  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0252  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0255  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0257  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void bind(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r12) {
            /*
                Method dump skipped, instructions count: 1157
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.ui.ExtrasAdapter.ExtraViewHolder.bind(com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState):void");
        }
    }

    public ExtrasAdapter(@NotNull String languageCode, @NotNull ExtraPackageClickListener clickListener) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.f12105a = languageCode;
        this.f12106b = clickListener;
        this.f12107c = new ArrayList();
        setHasStableIds(true);
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ListRefresher
    public void forceRefresh() {
        notifyDataSetChanged();
    }

    @NotNull
    public final List<ExtraPackageWithPriceAndState> getExtras() {
        return this.f12107c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12107c.size();
    }

    public final void setExtras(@NotNull List<ExtraPackageWithPriceAndState> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.f12107c.clear();
        this.f12107c.addAll(extras);
        notifyDataSetChanged();
    }

    public final void updateExtra(@NotNull ExtraPackageWithPriceAndState extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Iterator<ExtraPackageWithPriceAndState> it = this.f12107c.iterator();
        int i4 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getExtra().getSubscriptionId(), extra.getExtra().getSubscriptionId())) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 != -1) {
            this.f12107c.set(i4, extra);
            notifyItemChanged(i4);
        }
    }

    public final void updateExtraPriceTextMonthly(@NotNull String subscriptionId, @NotNull SubscriptionPrice priceMonthly) {
        int i4;
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(priceMonthly, "priceMonthly");
        Iterator<ExtraPackageWithPriceAndState> it = this.f12107c.iterator();
        int i5 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getExtra().getSubscriptionId(), subscriptionId)) {
                    i4 = i5;
                    break;
                }
                i5++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 != -1) {
            List<ExtraPackageWithPriceAndState> list = this.f12107c;
            list.set(i4, ExtraPackageWithPriceAndState.copy$default(list.get(i4), null, null, null, priceMonthly, null, null, null, null, null, false, false, 2039, null));
            notifyItemChanged(i4);
        }
    }

    public final void updateExtraPriceTextWeekly(@NotNull String subscriptionId, @NotNull SubscriptionPrice priceWeekly) {
        int i4;
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(priceWeekly, "priceWeekly");
        Iterator<ExtraPackageWithPriceAndState> it = this.f12107c.iterator();
        int i5 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getExtra().getSubscriptionId(), subscriptionId)) {
                    i4 = i5;
                    break;
                }
                i5++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 != -1) {
            List<ExtraPackageWithPriceAndState> list = this.f12107c;
            list.set(i4, ExtraPackageWithPriceAndState.copy$default(list.get(i4), null, null, priceWeekly, null, null, null, null, null, null, false, false, 2043, null));
            notifyItemChanged(i4);
        }
    }

    public final void updateExtraPriceTextYearly(@NotNull String subscriptionId, @NotNull SubscriptionPrice priceYearly) {
        int i4;
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(priceYearly, "priceYearly");
        Iterator<ExtraPackageWithPriceAndState> it = this.f12107c.iterator();
        int i5 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getExtra().getSubscriptionId(), subscriptionId)) {
                    i4 = i5;
                    break;
                }
                i5++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 != -1) {
            List<ExtraPackageWithPriceAndState> list = this.f12107c;
            list.set(i4, ExtraPackageWithPriceAndState.copy$default(list.get(i4), null, null, null, null, priceYearly, null, null, null, null, false, false, NodeType.ALLOWED_IN_LB, null));
            notifyItemChanged(i4);
        }
    }

    public final void updateInstalledVersion(@NotNull String subscriptionId, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Iterator<ExtraPackageWithPriceAndState> it = this.f12107c.iterator();
        int i4 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getExtra().getSubscriptionId(), subscriptionId)) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 != -1) {
            List<ExtraPackageWithPriceAndState> list = this.f12107c;
            list.set(i4, ExtraPackageWithPriceAndState.copy$default(list.get(i4), null, null, null, null, null, num, null, null, null, false, false, 2015, null));
            notifyItemChanged(i4);
        }
    }

    public final void updateValidatingState(@NotNull String subscriptionId, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Iterator<ExtraPackageWithPriceAndState> it = this.f12107c.iterator();
        while (it.hasNext() && !Intrinsics.areEqual(it.next().getExtra().getSubscriptionId(), subscriptionId)) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ExtraViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f12107c.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ExtraViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemExtraBinding inflate = ListItemExtraBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ExtraViewHolder(this, inflate, this.f12105a, this.f12106b);
    }
}
