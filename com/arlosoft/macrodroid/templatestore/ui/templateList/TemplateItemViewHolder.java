package com.arlosoft.macrodroid.templatestore.ui.templateList;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.text.util.LinkifyCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper;
import com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateItemViewHolder;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.jsramraj.flags.Flags;
import com.varunest.sparkbutton.SparkButton2;
import com.varunest.sparkbutton.SparkEventListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateItemViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTemplateItemViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateItemViewHolder.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/TemplateItemViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,352:1\n262#2,2:353\n262#2,2:355\n262#2,2:357\n262#2,2:359\n262#2,2:361\n262#2,2:363\n262#2,2:365\n262#2,2:367\n262#2,2:369\n262#2,2:371\n262#2,2:373\n262#2,2:375\n262#2,2:377\n262#2,2:379\n*S KotlinDebug\n*F\n+ 1 TemplateItemViewHolder.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/TemplateItemViewHolder\n*L\n94#1:353,2\n107#1:355,2\n109#1:357,2\n163#1:359,2\n166#1:361,2\n170#1:363,2\n218#1:365,2\n248#1:367,2\n252#1:369,2\n256#1:371,2\n317#1:373,2\n332#1:375,2\n336#1:377,2\n147#1:379,2\n*E\n"})
/* loaded from: classes3.dex */
public final class TemplateItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TemplateItemPresenter f13949a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ProfileImageProvider f13950b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final UserProvider f13951c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final FlagProvider f13952d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f13953e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final List<MacroTemplate> f13954f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f13955g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f13956h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final TemplatesTranslationHelper f13957i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final String f13958j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final String f13959k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final String f13960l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final String f13961m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private CoroutineScope f13962n;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TemplateItemViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateItemViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroTemplate $item;
        final /* synthetic */ TextView $name;
        final /* synthetic */ Ref.ObjectRef<String> $translatedName;
        final /* synthetic */ TemplatesTranslationHelper $translator;
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateItemViewHolder.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateItemViewHolder$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0119a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TextView $name;
            final /* synthetic */ Ref.ObjectRef<String> $translatedName;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0119a(TextView textView, Ref.ObjectRef<String> objectRef, Continuation<? super C0119a> continuation) {
                super(2, continuation);
                this.$name = textView;
                this.$translatedName = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0119a(this.$name, this.$translatedName, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$name.setText(this.$translatedName.element);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0119a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.ObjectRef<String> objectRef, TemplatesTranslationHelper templatesTranslationHelper, MacroTemplate macroTemplate, TextView textView, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$translatedName = objectRef;
            this.$translator = templatesTranslationHelper;
            this.$item = macroTemplate;
            this.$name = textView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$translatedName, this.$translator, this.$item, this.$name, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Ref.ObjectRef<String> objectRef;
            T t3;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        this.$name.setAlpha(1.0f);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                t3 = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                objectRef = this.$translatedName;
                TemplatesTranslationHelper templatesTranslationHelper = this.$translator;
                String nameTranslated = this.$item.getNameTranslated();
                if (nameTranslated == null) {
                    nameTranslated = this.$item.getName();
                }
                this.L$0 = objectRef;
                this.label = 1;
                Object translateCoroutine = templatesTranslationHelper.translateCoroutine(nameTranslated, this);
                t3 = translateCoroutine;
                if (translateCoroutine == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            objectRef.element = t3;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            C0119a c0119a = new C0119a(this.$name, this.$translatedName, null);
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.withContext(main, c0119a, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.$name.setAlpha(1.0f);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateItemViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $description;
        final /* synthetic */ MacroTemplate $item;
        final /* synthetic */ Ref.ObjectRef<String> $translatedDescription;
        final /* synthetic */ TemplatesTranslationHelper $translator;
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateItemViewHolder.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TextView $description;
            final /* synthetic */ Ref.ObjectRef<String> $translatedDescription;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TextView textView, Ref.ObjectRef<String> objectRef, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$description = textView;
                this.$translatedDescription = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$description, this.$translatedDescription, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$description.setText(this.$translatedDescription.element);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.ObjectRef<String> objectRef, TemplatesTranslationHelper templatesTranslationHelper, MacroTemplate macroTemplate, TextView textView, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$translatedDescription = objectRef;
            this.$translator = templatesTranslationHelper;
            this.$item = macroTemplate;
            this.$description = textView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$translatedDescription, this.$translator, this.$item, this.$description, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Ref.ObjectRef<String> objectRef;
            T t3;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        this.$description.setAlpha(1.0f);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                t3 = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                objectRef = this.$translatedDescription;
                TemplatesTranslationHelper templatesTranslationHelper = this.$translator;
                String descriptionTranslated = this.$item.getDescriptionTranslated();
                if (descriptionTranslated == null) {
                    descriptionTranslated = this.$item.getDescription();
                }
                this.L$0 = objectRef;
                this.label = 1;
                Object translateCoroutine = templatesTranslationHelper.translateCoroutine(descriptionTranslated, this);
                t3 = translateCoroutine;
                if (translateCoroutine == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            objectRef.element = t3;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(this.$description, this.$translatedDescription, null);
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.$description.setAlpha(1.0f);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateItemViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroTemplate $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(MacroTemplate macroTemplate, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$item = macroTemplate;
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
                TemplateItemViewHolder.this.f13949a.flagClicked(this.$item);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateItemViewHolder.kt */
    @SourceDebugExtension({"SMAP\nTemplateItemViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateItemViewHolder.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/TemplateItemViewHolder$bind$12\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,352:1\n260#2:353\n262#2,2:354\n*S KotlinDebug\n*F\n+ 1 TemplateItemViewHolder.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/TemplateItemViewHolder$bind$12\n*L\n230#1:353\n234#1:354,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageView $expandAndMenuButton;
        final /* synthetic */ MacroTemplate $item;
        final /* synthetic */ ViewGroup $macroConfigContainer;
        int label;
        final /* synthetic */ TemplateItemViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ViewGroup viewGroup, TemplateItemViewHolder templateItemViewHolder, MacroTemplate macroTemplate, ImageView imageView, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$macroConfigContainer = viewGroup;
            this.this$0 = templateItemViewHolder;
            this.$item = macroTemplate;
            this.$expandAndMenuButton = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TemplateItemViewHolder templateItemViewHolder, MacroTemplate macroTemplate, ImageView imageView) {
            templateItemViewHolder.f13954f.add(macroTemplate);
            imageView.setImageResource(R.drawable.ic_more_vert_white_24dp);
            imageView.animate().alpha(1.0f).setDuration(200L);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$macroConfigContainer, this.this$0, this.$item, this.$expandAndMenuButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$macroConfigContainer.getVisibility() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    this.this$0.g(this.$item);
                    this.$macroConfigContainer.setVisibility(0);
                    ViewPropertyAnimator duration = this.$expandAndMenuButton.animate().alpha(0.3f).setDuration(200L);
                    final TemplateItemViewHolder templateItemViewHolder = this.this$0;
                    final MacroTemplate macroTemplate = this.$item;
                    final ImageView imageView = this.$expandAndMenuButton;
                    duration.withEndAction(new Runnable() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            TemplateItemViewHolder.d.c(TemplateItemViewHolder.this, macroTemplate, imageView);
                        }
                    });
                } else {
                    this.this$0.f13949a.menuClicked(this.$item);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateItemViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroTemplate $item;
        final /* synthetic */ Ref.ObjectRef<String> $translatedDescription;
        final /* synthetic */ Ref.ObjectRef<String> $translatedName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(MacroTemplate macroTemplate, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$item = macroTemplate;
            this.$translatedName = objectRef;
            this.$translatedDescription = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$item, this.$translatedName, this.$translatedDescription, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            MacroTemplate copy;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateItemPresenter templateItemPresenter = TemplateItemViewHolder.this.f13949a;
                MacroTemplate macroTemplate = this.$item;
                String str = this.$translatedName.element;
                if (str == null) {
                    str = macroTemplate.getName();
                }
                String str2 = this.$translatedDescription.element;
                if (str2 == null) {
                    str2 = this.$item.getDescription();
                }
                copy = macroTemplate.copy((r42 & 1) != 0 ? macroTemplate.name : str, (r42 & 2) != 0 ? macroTemplate.nameTranslated : null, (r42 & 4) != 0 ? macroTemplate.username : null, (r42 & 8) != 0 ? macroTemplate.description : str2, (r42 & 16) != 0 ? macroTemplate.descriptionTranslated : null, (r42 & 32) != 0 ? macroTemplate.translationLanguage : null, (r42 & 64) != 0 ? macroTemplate.json : null, (r42 & 128) != 0 ? macroTemplate.language : null, (r42 & 256) != 0 ? macroTemplate.rootOnlyVersion : 0, (r42 & 512) != 0 ? macroTemplate.timestamp : 0L, (r42 & 1024) != 0 ? macroTemplate.userImage : null, (r42 & 2048) != 0 ? macroTemplate.id : 0, (r42 & 4096) != 0 ? macroTemplate.userId : 0, (r42 & 8192) != 0 ? macroTemplate.flagCount : 0, (r42 & 16384) != 0 ? macroTemplate.commentCount : 0, (r42 & 32768) != 0 ? macroTemplate.starCount : 0, (r42 & 65536) != 0 ? macroTemplate.starred : false, (r42 & 131072) != 0 ? macroTemplate.macro : null, (r42 & 262144) != 0 ? macroTemplate.deleted : false, (r42 & 524288) != 0 ? macroTemplate.useTranslatedText : false, (r42 & 1048576) != 0 ? macroTemplate.categoryId : 0, (r42 & 2097152) != 0 ? macroTemplate.updated : 0L);
                templateItemPresenter.templateClicked(copy);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateItemViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroTemplate $item;
        final /* synthetic */ Ref.ObjectRef<String> $translatedDescription;
        final /* synthetic */ Ref.ObjectRef<String> $translatedName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(MacroTemplate macroTemplate, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$item = macroTemplate;
            this.$translatedName = objectRef;
            this.$translatedDescription = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$item, this.$translatedName, this.$translatedDescription, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            MacroTemplate copy;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateItemPresenter templateItemPresenter = TemplateItemViewHolder.this.f13949a;
                MacroTemplate macroTemplate = this.$item;
                String str = this.$translatedName.element;
                if (str == null) {
                    str = macroTemplate.getName();
                }
                String str2 = this.$translatedDescription.element;
                if (str2 == null) {
                    str2 = this.$item.getDescription();
                }
                copy = macroTemplate.copy((r42 & 1) != 0 ? macroTemplate.name : str, (r42 & 2) != 0 ? macroTemplate.nameTranslated : null, (r42 & 4) != 0 ? macroTemplate.username : null, (r42 & 8) != 0 ? macroTemplate.description : str2, (r42 & 16) != 0 ? macroTemplate.descriptionTranslated : null, (r42 & 32) != 0 ? macroTemplate.translationLanguage : null, (r42 & 64) != 0 ? macroTemplate.json : null, (r42 & 128) != 0 ? macroTemplate.language : null, (r42 & 256) != 0 ? macroTemplate.rootOnlyVersion : 0, (r42 & 512) != 0 ? macroTemplate.timestamp : 0L, (r42 & 1024) != 0 ? macroTemplate.userImage : null, (r42 & 2048) != 0 ? macroTemplate.id : 0, (r42 & 4096) != 0 ? macroTemplate.userId : 0, (r42 & 8192) != 0 ? macroTemplate.flagCount : 0, (r42 & 16384) != 0 ? macroTemplate.commentCount : 0, (r42 & 32768) != 0 ? macroTemplate.starCount : 0, (r42 & 65536) != 0 ? macroTemplate.starred : false, (r42 & 131072) != 0 ? macroTemplate.macro : null, (r42 & 262144) != 0 ? macroTemplate.deleted : false, (r42 & 524288) != 0 ? macroTemplate.useTranslatedText : false, (r42 & 1048576) != 0 ? macroTemplate.categoryId : 0, (r42 & 2097152) != 0 ? macroTemplate.updated : 0L);
                templateItemPresenter.templateClicked(copy);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateItemViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroTemplate $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(MacroTemplate macroTemplate, Continuation<? super g> continuation) {
            super(3, continuation);
            this.$item = macroTemplate;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(this.$item, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateItemViewHolder.this.f13949a.reportClicked(this.$item);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateItemViewHolder(@NotNull View itemView, @NotNull TemplateItemPresenter presenter, @NotNull ProfileImageProvider profileImageProvider, @NotNull UserProvider userProvider, @NotNull FlagProvider flagProvider, boolean z3, @NotNull List<MacroTemplate> listOfExpanded, boolean z4, boolean z5, @Nullable TemplatesTranslationHelper templatesTranslationHelper) {
        super(itemView);
        String str;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(flagProvider, "flagProvider");
        Intrinsics.checkNotNullParameter(listOfExpanded, "listOfExpanded");
        this.f13949a = presenter;
        this.f13950b = profileImageProvider;
        this.f13951c = userProvider;
        this.f13952d = flagProvider;
        this.f13953e = z3;
        this.f13954f = listOfExpanded;
        this.f13955g = z4;
        this.f13956h = z5;
        this.f13957i = templatesTranslationHelper;
        String string = itemView.getContext().getString(R.string.triggers);
        Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getString(R.string.triggers)");
        boolean z6 = true;
        String substring = string.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        this.f13958j = substring;
        String string2 = itemView.getContext().getString(R.string.actions);
        Intrinsics.checkNotNullExpressionValue(string2, "itemView.context.getString(R.string.actions)");
        String substring2 = string2.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        this.f13959k = substring2;
        String string3 = itemView.getContext().getString(R.string.constraints);
        Intrinsics.checkNotNullExpressionValue(string3, "itemView.context.getString(R.string.constraints)");
        String substring3 = string3.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
        this.f13960l = substring3;
        String language = Settings.getLocale(itemView.getContext()).getLanguage();
        if (language != null && language.length() != 0) {
            z6 = false;
        }
        if (!z6) {
            String language2 = Settings.getLocale(itemView.getContext()).getLanguage();
            Intrinsics.checkNotNullExpressionValue(language2, "getLocale(itemView.context).language");
            str = language2.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str = "en";
        }
        this.f13961m = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TemplateItemViewHolder this$0, MacroTemplate item, AvatarView avatarImage, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(avatarImage, "$avatarImage");
        this$0.f13949a.usernameClicked(item, avatarImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TemplateItemViewHolder this$0, MacroTemplate item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.f13949a.commentsClicked(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ProgressBar subscribingProgress, TemplateItemViewHolder this$0, MacroTemplate item, boolean z3, View view) {
        Intrinsics.checkNotNullParameter(subscribingProgress, "$subscribingProgress");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        subscribingProgress.setVisibility(0);
        this$0.f13949a.subscribeMacroClicked(item, !z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(MacroTemplate macroTemplate) {
        View findViewById = this.itemView.findViewById(R.id.triggers);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = this.itemView.findViewById(R.id.actions);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = this.itemView.findViewById(R.id.constraints);
        Intrinsics.checkNotNull(findViewById3);
        View findViewById4 = this.itemView.findViewById(R.id.constraintsContainer);
        Intrinsics.checkNotNull(findViewById4);
        View findViewById5 = this.itemView.findViewById(R.id.triggersLabel);
        Intrinsics.checkNotNull(findViewById5);
        View findViewById6 = this.itemView.findViewById(R.id.actionsLabel);
        Intrinsics.checkNotNull(findViewById6);
        View findViewById7 = this.itemView.findViewById(R.id.constraintsLabel);
        Intrinsics.checkNotNull(findViewById7);
        View findViewById8 = this.itemView.findViewById(R.id.description);
        Intrinsics.checkNotNull(findViewById8);
        Macro macro = macroTemplate.getMacro();
        Intrinsics.checkNotNull(macro);
        j(macro, (TextView) findViewById);
        String str = this.f13958j;
        ((TextView) findViewById5).setText(str + " -");
        Macro macro2 = macroTemplate.getMacro();
        Intrinsics.checkNotNull(macro2);
        h(macro2, (TextView) findViewById2);
        String str2 = this.f13959k;
        ((TextView) findViewById6).setText(str2 + " -");
        Macro macro3 = macroTemplate.getMacro();
        Intrinsics.checkNotNull(macro3);
        i(macro3, (TextView) findViewById3, (ViewGroup) findViewById4);
        String str3 = this.f13960l;
        ((TextView) findViewById7).setText(str3 + " -");
        ((TextView) findViewById8).setMaxLines(12);
    }

    private final void h(Macro macro, TextView textView) {
        String str = "";
        for (int i4 = 0; i4 < 8; i4++) {
            if (macro.getActions().size() > i4) {
                try {
                    str = str + macro.getActions().get(i4).getTemplateConfiguredName();
                    if (i4 < macro.getActions().size() - 1 && i4 < 7) {
                        str = str + ", ";
                    }
                } catch (Exception e4) {
                    FirebaseCrashlytics.getInstance().recordException(e4);
                }
            }
        }
        textView.setText(MDTextUtils.fromHtml(str));
    }

    private final void i(Macro macro, TextView textView, ViewGroup viewGroup) {
        boolean z3 = true;
        int i4 = 8;
        String str = "";
        if (macro.getConstraints().size() > 0) {
            viewGroup.setVisibility(0);
            for (int i5 = 0; i5 < 8; i5++) {
                if (macro.getConstraints().size() > i5) {
                    try {
                        str = str + macro.getConstraints().get(i5).getTemplateConfiguredName();
                        if (i5 < macro.getConstraints().size() - 1 && i5 < 7) {
                            str = str + ", ";
                        }
                    } catch (Exception e4) {
                        FirebaseCrashlytics.getInstance().recordException(e4);
                    }
                }
            }
        } else {
            viewGroup.setVisibility(8);
        }
        textView.setText(MDTextUtils.fromHtml(str));
        View findViewById = this.itemView.findViewById(R.id.constraintsDivider);
        Intrinsics.checkNotNull(findViewById);
        if (macro.getConstraints().size() <= 0) {
            z3 = false;
        }
        if (z3) {
            i4 = 0;
        }
        findViewById.setVisibility(i4);
    }

    private final void j(Macro macro, TextView textView) {
        String str = "";
        for (int i4 = 0; i4 < 8; i4++) {
            if (macro.getTriggerList().size() > i4) {
                try {
                    str = str + macro.getTriggerList().get(i4).getTemplateConfiguredName();
                    if (i4 < macro.getTriggerList().size() - 1 && i4 < 7) {
                        str = str + ", ";
                    }
                } catch (Exception e4) {
                    FirebaseCrashlytics.getInstance().recordException(e4);
                }
            }
        }
        textView.setText(MDTextUtils.fromHtml(str));
    }

    private final String k(int i4) {
        if (i4 < 100) {
            return String.valueOf(i4);
        }
        return "99+";
    }

    private final String l(int i4) {
        return String.valueOf(i4);
    }

    public final void bind(@NotNull final MacroTemplate item, boolean z3, final boolean z4, boolean z5) {
        int i4;
        String name;
        String description;
        int i5;
        int i6;
        TextView textView;
        ViewGroup viewGroup;
        TextView textView2;
        TextView textView3;
        ImageView imageView;
        TextView textView4;
        ViewGroup viewGroup2;
        TextView textView5;
        SparkButton2 sparkButton2;
        ImageView imageView2;
        TextView textView6;
        float f4;
        int i7;
        int i8;
        boolean z6;
        int i9;
        Unit unit;
        String str;
        int i10;
        boolean z7;
        int i11;
        TemplatesTranslationHelper templatesTranslationHelper;
        TemplatesTranslationHelper templatesTranslationHelper2;
        Intrinsics.checkNotNullParameter(item, "item");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        CoroutineScope coroutineScope = this.f13962n;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.f13962n = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        View findViewById = this.itemView.findViewById(R.id.cardView);
        Intrinsics.checkNotNull(findViewById);
        CardView cardView = (CardView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.name);
        Intrinsics.checkNotNull(findViewById2);
        TextView textView7 = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.description);
        Intrinsics.checkNotNull(findViewById3);
        TextView textView8 = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.subscribeButton);
        Intrinsics.checkNotNull(findViewById4);
        ImageView imageView3 = (ImageView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.userSubscriptionIndicator);
        Intrinsics.checkNotNull(findViewById5);
        ImageView imageView4 = (ImageView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R.id.subscribingProgress);
        Intrinsics.checkNotNull(findViewById6);
        final ProgressBar progressBar = (ProgressBar) findViewById6;
        View findViewById7 = this.itemView.findViewById(R.id.usernameEdit);
        Intrinsics.checkNotNull(findViewById7);
        TextView textView9 = (TextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R.id.userContainer);
        Intrinsics.checkNotNull(findViewById8);
        ViewGroup viewGroup3 = (ViewGroup) findViewById8;
        View findViewById9 = this.itemView.findViewById(R.id.commentsButton);
        Intrinsics.checkNotNull(findViewById9);
        ViewGroup viewGroup4 = (ViewGroup) findViewById9;
        View findViewById10 = this.itemView.findViewById(R.id.avatarImage);
        Intrinsics.checkNotNull(findViewById10);
        final AvatarView avatarView = (AvatarView) findViewById10;
        View findViewById11 = this.itemView.findViewById(R.id.commentCount);
        Intrinsics.checkNotNull(findViewById11);
        TextView textView10 = (TextView) findViewById11;
        View findViewById12 = this.itemView.findViewById(R.id.starRating);
        Intrinsics.checkNotNull(findViewById12);
        TextView textView11 = (TextView) findViewById12;
        View findViewById13 = this.itemView.findViewById(R.id.flagIcon);
        Intrinsics.checkNotNull(findViewById13);
        ImageView imageView5 = (ImageView) findViewById13;
        View findViewById14 = this.itemView.findViewById(R.id.reportCount);
        Intrinsics.checkNotNull(findViewById14);
        TextView textView12 = (TextView) findViewById14;
        View findViewById15 = this.itemView.findViewById(R.id.reportsPanel);
        Intrinsics.checkNotNull(findViewById15);
        ViewGroup viewGroup5 = (ViewGroup) findViewById15;
        View findViewById16 = this.itemView.findViewById(R.id.timeLabel);
        Intrinsics.checkNotNull(findViewById16);
        TextView textView13 = (TextView) findViewById16;
        View findViewById17 = this.itemView.findViewById(R.id.starIcon);
        Intrinsics.checkNotNull(findViewById17);
        SparkButton2 sparkButton22 = (SparkButton2) findViewById17;
        View findViewById18 = this.itemView.findViewById(R.id.expandAndMenuButton);
        Intrinsics.checkNotNull(findViewById18);
        ImageView imageView6 = (ImageView) findViewById18;
        View findViewById19 = this.itemView.findViewById(R.id.macroConfigContainer);
        Intrinsics.checkNotNull(findViewById19);
        ViewGroup viewGroup6 = (ViewGroup) findViewById19;
        View findViewById20 = this.itemView.findViewById(R.id.rootOnlyLabel);
        Intrinsics.checkNotNull(findViewById20);
        TextView textView14 = (TextView) findViewById20;
        if (this.f13956h && item.getFlagCount() == 0) {
            cardView.getLayoutParams().height = 0;
            return;
        }
        cardView.getLayoutParams().height = -2;
        if (z5) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView4.setVisibility(i4);
        if (item.getUseTranslatedText()) {
            if (item.getNameTranslated() == null) {
                item.getName();
            }
            name = item.getNameTranslated();
            if (name == null) {
                name = item.getName();
            }
        } else {
            name = item.getName();
        }
        textView7.setText(name);
        if (item.getUseTranslatedText()) {
            description = item.getDescriptionTranslated();
        } else {
            description = item.getDescription();
        }
        textView8.setText(description);
        progressBar.setVisibility(8);
        imageView3.setVisibility(0);
        if (z4) {
            i5 = R.drawable.ic_bell_ring_white_24dp;
        } else {
            i5 = R.drawable.ic_bell;
        }
        imageView3.setImageResource(i5);
        Context context = this.itemView.getContext();
        if (z4) {
            i6 = R.color.subscribed_indicator_color;
        } else {
            i6 = R.color.white;
        }
        ImageViewCompat.setImageTintList(imageView3, ColorStateList.valueOf(ContextCompat.getColor(context, i6)));
        if (item.getUseTranslatedText() && (templatesTranslationHelper = this.f13957i) != null) {
            textView7.setAlpha(0.5f);
            CoroutineScope coroutineScope2 = this.f13962n;
            if (coroutineScope2 != null) {
                templatesTranslationHelper2 = templatesTranslationHelper;
                textView = textView14;
                viewGroup = viewGroup3;
                textView2 = textView10;
                textView3 = textView11;
                imageView = imageView5;
                textView4 = textView12;
                viewGroup2 = viewGroup5;
                textView5 = textView13;
                sparkButton2 = sparkButton22;
                imageView2 = imageView3;
                textView6 = textView9;
                kotlinx.coroutines.e.e(coroutineScope2, null, null, new a(objectRef, templatesTranslationHelper, item, textView7, null), 3, null);
            } else {
                templatesTranslationHelper2 = templatesTranslationHelper;
                textView = textView14;
                viewGroup = viewGroup3;
                textView2 = textView10;
                textView3 = textView11;
                imageView = imageView5;
                textView4 = textView12;
                viewGroup2 = viewGroup5;
                textView5 = textView13;
                sparkButton2 = sparkButton22;
                imageView2 = imageView3;
                textView6 = textView9;
            }
            textView8.setAlpha(0.5f);
            CoroutineScope coroutineScope3 = this.f13962n;
            if (coroutineScope3 != null) {
                kotlinx.coroutines.e.e(coroutineScope3, null, null, new b(objectRef2, templatesTranslationHelper2, item, textView8, null), 3, null);
            }
        } else {
            textView = textView14;
            viewGroup = viewGroup3;
            textView2 = textView10;
            textView3 = textView11;
            imageView = imageView5;
            textView4 = textView12;
            viewGroup2 = viewGroup5;
            textView5 = textView13;
            sparkButton2 = sparkButton22;
            imageView2 = imageView3;
            textView6 = textView9;
        }
        LinkifyCompat.addLinks(textView8, 1);
        ViewExtensionsKt.onClick$default(textView8, null, new e(item, objectRef, objectRef2, null), 1, null);
        textView6.setText(item.getUsername());
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateItemViewHolder.d(TemplateItemViewHolder.this, item, avatarView, view);
            }
        });
        viewGroup4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateItemViewHolder.e(TemplateItemViewHolder.this, item, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateItemViewHolder.f(progressBar, this, item, z4, view);
            }
        });
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewExtensionsKt.onClick$default(itemView, null, new f(item, objectRef, objectRef2, null), 1, null);
        textView2.setText(k(item.getCommentCount()));
        final TextView textView15 = textView3;
        textView15.setText(l(item.getStarCount()));
        textView15.setTag(Integer.valueOf(item.getStarCount()));
        if (item.getUseTranslatedText()) {
            f4 = 0.3f;
        } else {
            f4 = 1.0f;
        }
        ImageView imageView7 = imageView;
        imageView7.setAlpha(f4);
        if (this.f13955g && item.getFlagCount() > 0) {
            textView4.setText(String.valueOf(item.getFlagCount()));
            ViewGroup viewGroup7 = viewGroup2;
            i7 = 0;
            viewGroup7.setVisibility(0);
            ViewExtensionsKt.onClick$default(viewGroup7, null, new g(item, null), 1, null);
            i8 = 8;
        } else {
            i7 = 0;
            i8 = 8;
            viewGroup2.setVisibility(8);
        }
        String substring = item.getLanguage().substring(i7, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (!Intrinsics.areEqual(substring, this.f13961m) && !Intrinsics.areEqual(item.getLanguage(), item.getTranslationLanguage())) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        imageView7.setVisibility(i9);
        Integer flagResourceFromLanguage = this.f13952d.getFlagResourceFromLanguage(item.getLanguage());
        if (flagResourceFromLanguage != null) {
            imageView7.setImageResource(flagResourceFromLanguage.intValue());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            try {
                imageView7.setImageBitmap(Flags.forCountry(item.getLanguage()).getBitmap());
            } catch (Exception unused) {
                imageView7.setImageResource(17170445);
            }
        }
        ViewExtensionsKt.onClick$default(imageView7, null, new c(item, null), 1, null);
        ViewExtensionsKt.expandTouchArea(imageView7, this.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small));
        if (item.getUpdated() > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.itemView.getContext().getString(R.string.updated_timestamp);
            Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getStri…string.updated_timestamp)");
            Object[] objArr = new Object[1];
            objArr[i7] = DateUtils.getRelativeTimeSpanString(item.getUpdated(), Calendar.getInstance().getTimeInMillis(), (long) ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + format;
        } else {
            str = "";
        }
        CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(item.getTimestamp(), Calendar.getInstance().getTimeInMillis(), (long) ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
        textView5.setText(((Object) relativeTimeSpanString) + str);
        SparkButton2 sparkButton23 = sparkButton2;
        sparkButton23.setChecked(item.getStarred());
        ViewExtensionsKt.expandTouchArea(sparkButton23, this.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small));
        sparkButton23.setEventListener(new SparkEventListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateItemViewHolder$bind$11
            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEvent(@NotNull ImageView button, boolean z8) {
                Intrinsics.checkNotNullParameter(button, "button");
                TemplateItemViewHolder.this.f13949a.starClicked(item);
                Object tag = textView15.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) tag).intValue();
                if (z8) {
                    int i12 = intValue + 1;
                    textView15.setTag(Integer.valueOf(i12));
                    textView15.setText(String.valueOf(i12));
                    return;
                }
                int i13 = intValue - 1;
                textView15.setTag(Integer.valueOf(i13));
                textView15.setText(String.valueOf(i13));
            }

            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEventAnimationEnd(@Nullable ImageView imageView8, boolean z8) {
            }

            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEventAnimationStart(@Nullable ImageView imageView8, boolean z8) {
            }
        });
        View itemView2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        if (!item.getDeleted()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        itemView2.setVisibility(i10);
        if (item.getDeleted()) {
            this.itemView.getLayoutParams().width = i7;
            this.itemView.getLayoutParams().height = i7;
        } else {
            this.itemView.getLayoutParams().width = -1;
            this.itemView.getLayoutParams().height = -2;
        }
        ProfileImageProvider profileImageProvider = this.f13950b;
        Intrinsics.checkNotNull(avatarView);
        profileImageProvider.loadImageFromUrl(avatarView, item.getUserImage(), item.getUsername());
        ViewExtensionsKt.onClick$default(imageView6, null, new d(viewGroup6, this, item, imageView6, null), 1, null);
        if (this.f13953e && !this.f13954f.contains(item)) {
            viewGroup6.setVisibility(i8);
            imageView6.setImageResource(R.drawable.ic_arrow_down);
            textView8.setMaxLines(4);
        } else {
            viewGroup6.setVisibility(i7);
            imageView6.setImageResource(R.drawable.ic_more_vert_white_24dp);
            g(item);
        }
        Macro macro = item.getMacro();
        if (macro != null && macro.isRootOnlyWithNoAdbHack()) {
            z7 = true;
        } else {
            z7 = false;
        }
        TextView textView16 = textView;
        if (z7) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView16.setVisibility(i11);
    }

    @Nullable
    public final CoroutineScope getGetTranslationScope() {
        return this.f13962n;
    }

    public final void setGetTranslationScope(@Nullable CoroutineScope coroutineScope) {
        this.f13962n = coroutineScope;
    }
}
