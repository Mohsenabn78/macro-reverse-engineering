package com.arlosoft.macrodroid.action;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.UiInteractionConfiguration;
import com.arlosoft.macrodroid.action.info.UIInteractionActionInfo;
import com.arlosoft.macrodroid.action.receivers.UiInteractionNotificationPressReceiver;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityServiceKt;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.toast.CustomToastHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.uiinteraction.UIInteractionResultCache;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlinx.android.parcel.Parcelize;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIInteractionAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUIInteractionAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 View.kt\nandroidx/core/view/ViewKt\n+ 6 Collections.kt\norg/jetbrains/anko/collections/CollectionsKt\n+ 7 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,2410:1\n1855#2,2:2411\n1549#2:2413\n1620#2,3:2414\n1855#2,2:2424\n1549#2:2433\n1620#2,3:2434\n1549#2:2437\n1620#2,3:2438\n1549#2:2441\n1620#2,3:2442\n37#3,2:2417\n3792#4:2419\n4307#4,2:2420\n262#5,2:2422\n262#5,2:2426\n38#6,5:2428\n26#7:2445\n*S KotlinDebug\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction\n*L\n604#1:2411,2\n654#1:2413\n654#1:2414,3\n1835#1:2424,2\n2233#1:2433\n2233#1:2434,3\n2264#1:2437\n2264#1:2438,3\n2277#1:2441\n2277#1:2442,3\n654#1:2417,2\n690#1:2419\n690#1:2420,2\n1082#1:2422,2\n1860#1:2426,2\n2178#1:2428,5\n2303#1:2445\n*E\n"})
/* loaded from: classes2.dex */
public final class UIInteractionAction extends Action implements BlockingAction, HasVariableNames, SupportsMagicText {
    private static final long CLICK_RESULT_TIMEOUT_MS = 1500;
    private static final int REQUEST_CODE_UI_INTERACTION_NOTIFICATION = 47632;
    private static int serviceRequestId;
    private int action;
    @Inject
    public transient PremiumStatusHandler premiumStatusHandler;
    private transient int transientClickOption;
    private transient boolean transientLongClick;
    @Nullable
    private UiInteractionConfiguration uiInteractionConfiguration;
    @Inject
    public transient UIInteractionResultCache uiInteractionResultCache;
    private transient boolean wasPointerOverlayEnabledBefore;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<UIInteractionAction> CREATOR = new Parcelable.Creator<UIInteractionAction>() { // from class: com.arlosoft.macrodroid.action.UIInteractionAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public UIInteractionAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UIInteractionAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public UIInteractionAction[] newArray(int i4) {
            return new UIInteractionAction[i4];
        }
    };

    /* compiled from: UIInteractionAction.kt */
    @StabilityInferred(parameters = 0)
    @Parcelize
    /* loaded from: classes2.dex */
    public static final class UIInteractionOption implements Parcelable {
        public static final int $stable = 0;
        @NotNull
        public static final Parcelable.Creator<UIInteractionOption> CREATOR = new Creator();

        /* renamed from: a  reason: collision with root package name */
        private final int f2726a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f2727b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2728c;

        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<UIInteractionOption> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UIInteractionOption createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new UIInteractionOption(parcel.readInt(), parcel.readString(), parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UIInteractionOption[] newArray(int i4) {
                return new UIInteractionOption[i4];
            }
        }

        public UIInteractionOption(int i4, @NotNull String name, int i5) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f2726a = i4;
            this.f2727b = name;
            this.f2728c = i5;
        }

        public static /* synthetic */ UIInteractionOption copy$default(UIInteractionOption uIInteractionOption, int i4, String str, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4 = uIInteractionOption.f2726a;
            }
            if ((i6 & 2) != 0) {
                str = uIInteractionOption.f2727b;
            }
            if ((i6 & 4) != 0) {
                i5 = uIInteractionOption.f2728c;
            }
            return uIInteractionOption.copy(i4, str, i5);
        }

        public final int component1() {
            return this.f2726a;
        }

        @NotNull
        public final String component2() {
            return this.f2727b;
        }

        public final int component3() {
            return this.f2728c;
        }

        @NotNull
        public final UIInteractionOption copy(int i4, @NotNull String name, int i5) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new UIInteractionOption(i4, name, i5);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UIInteractionOption)) {
                return false;
            }
            UIInteractionOption uIInteractionOption = (UIInteractionOption) obj;
            if (this.f2726a == uIInteractionOption.f2726a && Intrinsics.areEqual(this.f2727b, uIInteractionOption.f2727b) && this.f2728c == uIInteractionOption.f2728c) {
                return true;
            }
            return false;
        }

        public final int getId() {
            return this.f2726a;
        }

        public final int getMinSdk() {
            return this.f2728c;
        }

        @NotNull
        public final String getName() {
            return this.f2727b;
        }

        public int hashCode() {
            return (((this.f2726a * 31) + this.f2727b.hashCode()) * 31) + this.f2728c;
        }

        @NotNull
        public String toString() {
            int i4 = this.f2726a;
            String str = this.f2727b;
            int i5 = this.f2728c;
            return "UIInteractionOption(id=" + i4 + ", name=" + str + ", minSdk=" + i5 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.f2726a);
            out.writeString(this.f2727b);
            out.writeInt(this.f2728c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MagicText.MagicTextListener magicTextListener, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$magicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$magicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displayNumericalVarSelectionDialog(UIInteractionAction.this.getActivity(), UIInteractionAction.this.getMacro(), this.$magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MagicText.MagicTextListener magicTextListener, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$magicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$magicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displayNumericalVarSelectionDialog(UIInteractionAction.this.getActivity(), UIInteractionAction.this.getMacro(), this.$magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements Function1<UiInteractionConfiguration.Click, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UIInteractionAction.kt */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UIInteractionAction this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UIInteractionAction uIInteractionAction, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = uIInteractionAction;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                int i4 = this.label;
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (this.this$0.getActivity() != null) {
                    Intent intent = new Intent(this.this$0.getActivity(), this.this$0.getActivity().getClass());
                    intent.setFlags(603979776);
                    this.this$0.getActivity().startActivity(intent);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        c() {
            super(1);
        }

        public final void a(UiInteractionConfiguration.Click click) {
            UIInteractionAction.this.uiInteractionConfiguration = click;
            UIInteractionAction.this.itemComplete();
            MacroStore.getInstance().writeToJSON();
            kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new a(UIInteractionAction.this, null), 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UiInteractionConfiguration.Click click) {
            a(click);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo) {
            super(0);
            this.$nextAction = i4;
            this.$contextInfo = triggerContextInfo;
            this.$forceEvenIfNotEnabled = z3;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            UIInteractionAction.this.getMacro().invokeActions(UIInteractionAction.this.getMacro().getActions(), this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
        }
    }

    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        final /* synthetic */ long $waitDuration;
        int label;
        final /* synthetic */ UIInteractionAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j4, UIInteractionAction uIInteractionAction, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$waitDuration = j4;
            this.this$0 = uIInteractionAction;
            this.$nextAction = i4;
            this.$contextInfo = triggerContextInfo;
            this.$forceEvenIfNotEnabled = z3;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.$waitDuration, this.this$0, this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                long j4 = this.$waitDuration;
                if (j4 > 0) {
                    this.label = 1;
                    if (DelayKt.delay(j4 + 100, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            this.this$0.getMacro().invokeActions(this.this$0.getMacro().getActions(), this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class f extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Button $addBooleanVariableButton;
        final /* synthetic */ Spinner $booleanVariableSpinner;
        final /* synthetic */ ViewGroup $saveToVariableContainer;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Spinner spinner, Button button, ViewGroup viewGroup, Continuation<? super f> continuation) {
            super(4, continuation);
            this.$booleanVariableSpinner = spinner;
            this.$addBooleanVariableButton = button;
            this.$saveToVariableContainer = viewGroup;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            f fVar = new f(this.$booleanVariableSpinner, this.$addBooleanVariableButton, this.$saveToVariableContainer, continuation);
            fVar.Z$0 = z3;
            return fVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UIInteractionAction.Z0(this.$booleanVariableSpinner, this.$addBooleanVariableButton, this.$saveToVariableContainer, this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ RadioButton $blockRadioButton;
        final /* synthetic */ UiInteractionConfiguration.Click $clickConfig;
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ Ref.ObjectRef<VariableWithDictionaryKeys> $variableToUse;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Ref.ObjectRef<VariableWithDictionaryKeys> objectRef, RadioButton radioButton, UiInteractionConfiguration.Click click, AppCompatDialog appCompatDialog, Continuation<? super g> continuation) {
            super(3, continuation);
            this.$variableToUse = objectRef;
            this.$blockRadioButton = radioButton;
            this.$clickConfig = click;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(this.$variableToUse, this.$blockRadioButton, this.$clickConfig, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            UiInteractionConfiguration.Click copy;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UIInteractionAction uIInteractionAction = UIInteractionAction.this;
                copy = r3.copy((r28 & 1) != 0 ? r3.clickOption : 0, (r28 & 2) != 0 ? r3.longClick : false, (r28 & 4) != 0 ? r3.xyPoint : null, (r28 & 8) != 0 ? r3.xyPercentages : false, (r28 & 16) != 0 ? r3.xVarName : null, (r28 & 32) != 0 ? r3.yVarName : null, (r28 & 64) != 0 ? r3.textContent : null, (r28 & 128) != 0 ? r3.textMatchOption : 0, (r28 & 256) != 0 ? r3.contentDescription : null, (r28 & 512) != 0 ? r3.viewId : null, (r28 & 1024) != 0 ? r3.blocking : this.$blockRadioButton.isChecked(), (r28 & 2048) != 0 ? r3.returnVariable : this.$variableToUse.element, (r28 & 4096) != 0 ? this.$clickConfig.checkOverlays : false);
                uIInteractionAction.uiInteractionConfiguration = copy;
                this.$dialog.dismiss();
                UIInteractionAction.this.itemComplete();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(AppCompatDialog appCompatDialog, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
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
            int i4;
            String str;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    i4 = Settings.System.getInt(UIInteractionAction.this.getContext().getContentResolver(), "pointer_location");
                } catch (Exception unused) {
                    i4 = 0;
                }
                if (i4 == 0) {
                    str = "1";
                } else {
                    str = "0";
                }
                Context context = UIInteractionAction.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                HelperSystemCommands.sendSystemSetting(context, HelperCommandsKt.HELPER_SETTING_TYPE_SYSTEM, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT, "pointer_location", str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class j extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ EditText $endX;
        final /* synthetic */ EditText $endY;
        final /* synthetic */ Point $point;
        final /* synthetic */ EditText $startX;
        final /* synthetic */ EditText $startY;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(EditText editText, Point point, EditText editText2, EditText editText3, EditText editText4, Continuation<? super j> continuation) {
            super(4, continuation);
            this.$startX = editText;
            this.$point = point;
            this.$startY = editText2;
            this.$endX = editText3;
            this.$endY = editText4;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            j jVar = new j(this.$startX, this.$point, this.$startY, this.$endX, this.$endY, continuation);
            jVar.Z$0 = z3;
            return jVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.Z$0) {
                    UIInteractionAction.this.M0(this.$startX, this.$point.x);
                    UIInteractionAction.this.M0(this.$startY, this.$point.y);
                    UIInteractionAction.this.M0(this.$endX, this.$point.x);
                    UIInteractionAction.this.M0(this.$endY, this.$point.y);
                } else {
                    UIInteractionAction.this.L0(this.$startX, this.$point.x);
                    UIInteractionAction.this.L0(this.$startY, this.$point.y);
                    UIInteractionAction.this.L0(this.$endX, this.$point.x);
                    UIInteractionAction.this.L0(this.$endY, this.$point.y);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        k(Continuation<? super k> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            String str;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    i4 = Settings.System.getInt(UIInteractionAction.this.getContext().getContentResolver(), "pointer_location");
                } catch (Exception unused) {
                    i4 = 0;
                }
                if (i4 == 0) {
                    str = "1";
                } else {
                    str = "0";
                }
                Context context = UIInteractionAction.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                HelperSystemCommands.sendSystemSetting(context, HelperCommandsKt.HELPER_SETTING_TYPE_SYSTEM, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT, "pointer_location", str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class l extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(MagicText.MagicTextListener magicTextListener, Continuation<? super l> continuation) {
            super(3, continuation);
            this.$magicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new l(this.$magicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displayNumericalVarSelectionDialog(UIInteractionAction.this.getActivity(), UIInteractionAction.this.getMacro(), this.$magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class m extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(MagicText.MagicTextListener magicTextListener, Continuation<? super m> continuation) {
            super(3, continuation);
            this.$magicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new m(this.$magicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displayNumericalVarSelectionDialog(UIInteractionAction.this.getActivity(), UIInteractionAction.this.getMacro(), this.$magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    @SourceDebugExtension({"SMAP\nUIInteractionAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$showGestureSequenceOptionsDialog$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,2410:1\n262#2,2:2411\n*S KotlinDebug\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$showGestureSequenceOptionsDialog$4\n*L\n1827#1:2411,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class n extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinearLayout $entriesLayout;
        final /* synthetic */ Button $removeEntryButton;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(LinearLayout linearLayout, Button button, Continuation<? super n> continuation) {
            super(3, continuation);
            this.$entriesLayout = linearLayout;
            this.$removeEntryButton = button;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new n(this.$entriesLayout, this.$removeEntryButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LinearLayout linearLayout = this.$entriesLayout;
                boolean z3 = true;
                linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
                Button button = this.$removeEntryButton;
                int i4 = 0;
                if (this.$entriesLayout.getChildCount() <= 0) {
                    z3 = false;
                }
                if (!z3) {
                    i4 = 8;
                }
                button.setVisibility(i4);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    @SourceDebugExtension({"SMAP\nUIInteractionAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$showGestureSequenceOptionsDialog$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,2410:1\n262#2,2:2411\n*S KotlinDebug\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$showGestureSequenceOptionsDialog$5\n*L\n1832#1:2411,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class o extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ LinearLayout $entriesLayout;
        final /* synthetic */ Button $removeEntryButton;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(AppCompatDialog appCompatDialog, LinearLayout linearLayout, Button button, Continuation<? super o> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
            this.$entriesLayout = linearLayout;
            this.$removeEntryButton = button;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new o(this.$dialog, this.$entriesLayout, this.$removeEntryButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UIInteractionAction uIInteractionAction = UIInteractionAction.this;
                LayoutInflater layoutInflater = this.$dialog.getLayoutInflater();
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "dialog.layoutInflater");
                uIInteractionAction.F0(layoutInflater, this.$entriesLayout, null);
                Button button = this.$removeEntryButton;
                if (button != null) {
                    button.setVisibility(0);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class p extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(MagicText.MagicTextListener magicTextListener, Continuation<? super p> continuation) {
            super(3, continuation);
            this.$magicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new p(this.$magicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displayNumericalVarSelectionDialog(UIInteractionAction.this.getActivity(), UIInteractionAction.this.getMacro(), this.$magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    @SourceDebugExtension({"SMAP\nUIInteractionAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$showGestureSequenceOptionsDialog$8\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,2410:1\n1313#2,2:2411\n1313#2,2:2413\n*S KotlinDebug\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$showGestureSequenceOptionsDialog$8\n*L\n1866#1:2411,2\n1876#1:2413,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class q extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinearLayout $entriesLayout;
        final /* synthetic */ Point $point;
        final /* synthetic */ EditText $startX;
        final /* synthetic */ EditText $startY;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(EditText editText, Point point, EditText editText2, LinearLayout linearLayout, Continuation<? super q> continuation) {
            super(4, continuation);
            this.$startX = editText;
            this.$point = point;
            this.$startY = editText2;
            this.$entriesLayout = linearLayout;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            q qVar = new q(this.$startX, this.$point, this.$startY, this.$entriesLayout, continuation);
            qVar.Z$0 = z3;
            return qVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.Z$0) {
                    UIInteractionAction.this.M0(this.$startX, this.$point.x);
                    UIInteractionAction.this.M0(this.$startY, this.$point.y);
                    Sequence<View> children = ViewGroupKt.getChildren(this.$entriesLayout);
                    UIInteractionAction uIInteractionAction = UIInteractionAction.this;
                    Point point = this.$point;
                    for (View view : children) {
                        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
                        LinearLayout linearLayout = (LinearLayout) view;
                        EditText xText = (EditText) linearLayout.findViewById(R.id.xLocation);
                        EditText yText = (EditText) linearLayout.findViewById(R.id.yLocation);
                        Intrinsics.checkNotNullExpressionValue(xText, "xText");
                        uIInteractionAction.M0(xText, point.x);
                        Intrinsics.checkNotNullExpressionValue(yText, "yText");
                        uIInteractionAction.M0(yText, point.y);
                    }
                } else {
                    UIInteractionAction.this.L0(this.$startX, this.$point.x);
                    UIInteractionAction.this.L0(this.$startY, this.$point.y);
                    Sequence<View> children2 = ViewGroupKt.getChildren(this.$entriesLayout);
                    UIInteractionAction uIInteractionAction2 = UIInteractionAction.this;
                    Point point2 = this.$point;
                    for (View view2 : children2) {
                        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.LinearLayout");
                        LinearLayout linearLayout2 = (LinearLayout) view2;
                        EditText xText2 = (EditText) linearLayout2.findViewById(R.id.xLocation);
                        EditText yText2 = (EditText) linearLayout2.findViewById(R.id.yLocation);
                        Intrinsics.checkNotNullExpressionValue(xText2, "xText");
                        uIInteractionAction2.L0(xText2, point2.x);
                        Intrinsics.checkNotNullExpressionValue(yText2, "yText");
                        uIInteractionAction2.L0(yText2, point2.y);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class r extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ EditText $durationText;
        final /* synthetic */ LinearLayout $entriesLayout;
        final /* synthetic */ int $maxDimension;
        final /* synthetic */ RadioButton $radioButtonPercent;
        final /* synthetic */ EditText $startX;
        final /* synthetic */ EditText $startY;
        final /* synthetic */ CheckBox $waitCheckBox;
        int label;
        final /* synthetic */ UIInteractionAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(LinearLayout linearLayout, UIInteractionAction uIInteractionAction, EditText editText, EditText editText2, EditText editText3, int i4, RadioButton radioButton, CheckBox checkBox, AppCompatDialog appCompatDialog, Continuation<? super r> continuation) {
            super(3, continuation);
            this.$entriesLayout = linearLayout;
            this.this$0 = uIInteractionAction;
            this.$startX = editText;
            this.$startY = editText2;
            this.$durationText = editText3;
            this.$maxDimension = i4;
            this.$radioButtonPercent = radioButton;
            this.$waitCheckBox = checkBox;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new r(this.$entriesLayout, this.this$0, this.$startX, this.$startY, this.$durationText, this.$maxDimension, this.$radioButtonPercent, this.$waitCheckBox, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r6v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v5, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String obj2;
            int i4;
            int i5;
            boolean z3;
            String obj3;
            int i6;
            String obj4;
            int i7;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$entriesLayout.getChildCount() == 0) {
                    ToastCompat.makeText(this.this$0.getActivity(), (int) R.string.ui_interaction_please_add_at_least_one_swipe, 1).show();
                } else {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Ref.IntRef intRef = new Ref.IntRef();
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    EditText editText = this.$startX;
                    String str = null;
                    if (editText != null) {
                        try {
                            intRef.element = Integer.parseInt(editText.getText().toString());
                            objectRef.element = null;
                        } catch (Exception unused) {
                            intRef.element = 0;
                            objectRef.element = editText.getText().toString();
                        }
                    }
                    EditText editText2 = this.$startY;
                    if (editText2 != null) {
                        try {
                            intRef2.element = Integer.parseInt(editText2.getText().toString());
                            objectRef2.element = null;
                        } catch (Exception unused2) {
                            intRef2.element = 0;
                            objectRef2.element = editText2.getText().toString();
                        }
                    }
                    try {
                        i4 = Integer.parseInt(this.$durationText.getText().toString());
                        obj2 = null;
                    } catch (Exception unused3) {
                        obj2 = this.$durationText.getText().toString();
                        i4 = 0;
                    }
                    ArrayList arrayList = new ArrayList();
                    int childCount = this.$entriesLayout.getChildCount();
                    int i8 = 0;
                    while (i8 < childCount) {
                        View childAt = this.$entriesLayout.getChildAt(i8);
                        EditText editText3 = (EditText) childAt.findViewById(R.id.xLocation);
                        EditText editText4 = (EditText) childAt.findViewById(R.id.yLocation);
                        try {
                            i6 = this.this$0.T0(Integer.parseInt(editText3.getText().toString()), 0, this.$maxDimension);
                            obj3 = str;
                        } catch (Exception unused4) {
                            obj3 = editText3.getText().toString();
                            i6 = 0;
                        }
                        try {
                            i7 = this.this$0.T0(Integer.parseInt(editText4.getText().toString()), 0, this.$maxDimension);
                            obj4 = null;
                        } catch (Exception unused5) {
                            obj4 = editText4.getText().toString();
                            i7 = 0;
                        }
                        arrayList.add(new UiInteractionConfiguration.GestureEntry(i6, i7, obj3, obj4));
                        i8++;
                        str = null;
                    }
                    UIInteractionAction uIInteractionAction = this.this$0;
                    UIInteractionAction uIInteractionAction2 = this.this$0;
                    int i9 = intRef.element;
                    int i10 = 100;
                    if (this.$radioButtonPercent.isChecked()) {
                        i5 = 100;
                    } else {
                        i5 = this.$maxDimension;
                    }
                    int T0 = uIInteractionAction2.T0(i9, 0, i5);
                    UIInteractionAction uIInteractionAction3 = this.this$0;
                    int i11 = intRef2.element;
                    if (!this.$radioButtonPercent.isChecked()) {
                        i10 = this.$maxDimension;
                    }
                    int T02 = uIInteractionAction3.T0(i11, 0, i10);
                    boolean isChecked = this.$radioButtonPercent.isChecked();
                    int T03 = this.this$0.T0(i4, 0, 20000);
                    String str2 = (String) objectRef.element;
                    String str3 = (String) objectRef2.element;
                    CheckBox checkBox = this.$waitCheckBox;
                    if (checkBox != null && !checkBox.isChecked()) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    uIInteractionAction.uiInteractionConfiguration = new UiInteractionConfiguration.GestureSequence(T0, T02, isChecked, T03, str2, str3, obj2, z3, arrayList);
                    this.$dialog.dismiss();
                    this.this$0.itemComplete();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    @SourceDebugExtension({"SMAP\nUIInteractionAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$showPasteOptionsDialog$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,2410:1\n262#2,2:2411\n*S KotlinDebug\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$showPasteOptionsDialog$1\n*L\n1084#1:2411,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class s extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $enterTextLayout;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(ViewGroup viewGroup, Continuation<? super s> continuation) {
            super(4, continuation);
            this.$enterTextLayout = viewGroup;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            s sVar = new s(this.$enterTextLayout, continuation);
            sVar.Z$0 = z3;
            return sVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z3 = this.Z$0;
                ViewGroup viewGroup = this.$enterTextLayout;
                if (viewGroup != null) {
                    if (z3) {
                        i4 = 0;
                    } else {
                        i4 = 8;
                    }
                    viewGroup.setVisibility(i4);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class t extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Point $point;
        final /* synthetic */ EditText $xLocation;
        final /* synthetic */ EditText $yLocation;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(EditText editText, Point point, EditText editText2, Continuation<? super t> continuation) {
            super(4, continuation);
            this.$xLocation = editText;
            this.$point = point;
            this.$yLocation = editText2;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            t tVar = new t(this.$xLocation, this.$point, this.$yLocation, continuation);
            tVar.Z$0 = z3;
            return tVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.Z$0) {
                    UIInteractionAction.this.M0(this.$xLocation, this.$point.x);
                    UIInteractionAction.this.M0(this.$yLocation, this.$point.y);
                } else {
                    UIInteractionAction.this.L0(this.$xLocation, this.$point.x);
                    UIInteractionAction.this.L0(this.$yLocation, this.$point.y);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class u extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(Activity activity, Continuation<? super u> continuation) {
            super(3, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new u(this.$activity, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            String str;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    i4 = Settings.System.getInt(UIInteractionAction.this.getContext().getContentResolver(), "pointer_location");
                } catch (Exception unused) {
                    i4 = 0;
                }
                if (i4 == 0) {
                    str = "1";
                } else {
                    str = "0";
                }
                if (!RootToolsHelper.isAccessGiven()) {
                    if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
                        Context context = UIInteractionAction.this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        HelperSystemCommands.sendSystemSetting(context, HelperCommandsKt.HELPER_SETTING_TYPE_SYSTEM, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT, "pointer_location", str);
                    } else {
                        Activity activity = this.$activity;
                        String r4 = SelectableItem.r(R.string.helper_apk_required);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String r5 = SelectableItem.r(R.string.helper_app_required_setting);
                        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.helper_app_required_setting)");
                        String format = String.format(r5, Arrays.copyOf(new Object[]{PermissionsHelper.HELPER_FILE_LINK}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        PermissionsHelper.showNeedsNewHelperFileDialog(activity, false, false, r4, format);
                    }
                } else {
                    Util.runAsRoot(new String[]{"settings put system pointer_location " + str});
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ UIInteractionAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(Activity activity, MagicText.MagicTextListener magicTextListener, UIInteractionAction this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(UIInteractionAction this$0, RadioButton radioButton, CheckBox checkBox, EditText editText, AppCompatDialog dialog, View view) {
        boolean z3;
        boolean z4;
        Editable editable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (radioButton != null) {
            z3 = radioButton.isChecked();
        } else {
            z3 = true;
        }
        if (checkBox != null) {
            z4 = checkBox.isChecked();
        } else {
            z4 = false;
        }
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        this$0.uiInteractionConfiguration = new UiInteractionConfiguration.Paste(z3, z4, String.valueOf(editable));
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void E1(@StringRes int i4, @StringRes int i5) {
        final UiInteractionConfiguration.Click click;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (!checkActivityAlive()) {
            return;
        }
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            click = (UiInteractionConfiguration.Click) uiInteractionConfiguration;
        } else {
            click = null;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_text_to_match);
        appCompatDialog.setTitle(i4);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.textToMatch);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magicTextButton);
        View findViewById = appCompatDialog.findViewById(R.id.containsRadioButton);
        Intrinsics.checkNotNull(findViewById);
        final RadioButton radioButton = (RadioButton) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.matchesRadioButton);
        Intrinsics.checkNotNull(findViewById2);
        RadioButton radioButton2 = (RadioButton) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.includeScreenOverlaysCheckBox);
        Intrinsics.checkNotNull(findViewById3);
        final CheckBox checkBox = (CheckBox) findViewById3;
        checkBox.setText(SelectableItem.r(R.string.ui_interaction_action_text_match_include_screen_overlays) + " (" + SelectableItem.r(R.string.pro_version_only_short) + ")");
        if (click != null) {
            z3 = click.getCheckOverlays();
        } else {
            z3 = false;
        }
        checkBox.setChecked(z3);
        if (editText != null) {
            editText.setHint(i4);
        }
        if (editText != null) {
            editText.setText((click == null || (r0 = click.getTextContent()) == null) ? "" : "");
        }
        if (editText != null) {
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
        if (click != null) {
            if (click.getTextMatchOption() == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            radioButton.setChecked(z5);
            if (click.getTextMatchOption() == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            radioButton2.setChecked(z6);
        }
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.UIInteractionAction$showTextEntryDialog$2
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NotNull Editable s3) {
                    boolean z7;
                    Intrinsics.checkNotNullParameter(s3, "s");
                    Button button4 = button;
                    if (button4 != null) {
                        Editable text = editText.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "textField.text");
                        if (text.length() > 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        button4.setEnabled(z7);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@NotNull CharSequence s3, int i6, int i7, int i8) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@NotNull CharSequence s3, int i6, int i7, int i8) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }
            });
        }
        if (editText != null) {
            final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.zs
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    UIInteractionAction.G1(editText, magicTextPair);
                }
            };
            if (button3 != null) {
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.at
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UIInteractionAction.H1(activity, magicTextListener, this, view);
                    }
                });
            }
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bt
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.I1(checkBox, this, editText, radioButton, click, appCompatDialog, view);
                }
            });
        }
        if (button != null) {
            Intrinsics.checkNotNull(editText);
            Editable text = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "textField!!.text");
            if (text.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            button.setEnabled(z4);
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ct
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.F1(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(LayoutInflater layoutInflater, LinearLayout linearLayout, UiInteractionConfiguration.GestureEntry gestureEntry) {
        String str;
        String str2;
        String num;
        View inflate = layoutInflater.inflate(R.layout.list_item_gesture_sequence_element, (ViewGroup) linearLayout, false);
        linearLayout.addView(inflate);
        final EditText editText = (EditText) inflate.findViewById(R.id.xLocation);
        final EditText editText2 = (EditText) inflate.findViewById(R.id.yLocation);
        Button button = (Button) inflate.findViewById(R.id.xMagicTextButton);
        Button button2 = (Button) inflate.findViewById(R.id.yMagicTextButton);
        if (gestureEntry != null) {
            str = gestureEntry.getXEndVarName();
        } else {
            str = null;
        }
        String str3 = "0";
        if (str != null) {
            if (editText != null) {
                editText.setText(gestureEntry.getXEndVarName());
            }
        } else if (editText != null) {
            editText.setText((gestureEntry == null || (r3 = Integer.valueOf(gestureEntry.getEndX()).toString()) == null) ? "0" : "0");
        }
        if (gestureEntry != null) {
            str2 = gestureEntry.getYEndVarName();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            if (editText2 != null) {
                editText2.setText(gestureEntry.getYEndVarName());
            }
        } else if (editText2 != null) {
            if (gestureEntry != null && (num = Integer.valueOf(gestureEntry.getEndY()).toString()) != null) {
                str3 = num;
            }
            editText2.setText(str3);
        }
        if (editText != null) {
            MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.xr
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    UIInteractionAction.G0(editText, magicTextPair);
                }
            };
            if (button != null) {
                ViewExtensionsKt.onClick$default(button, null, new a(magicTextListener, null), 1, null);
            }
        }
        if (editText2 != null) {
            MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.is
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    UIInteractionAction.H0(editText2, magicTextPair);
                }
            };
            if (button2 != null) {
                ViewExtensionsKt.onClick$default(button2, null, new b(magicTextListener2, null), 1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(Activity activity, MagicText.MagicTextListener magicTextListener, UIInteractionAction this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    private final void I0() {
        if (!this.wasPointerOverlayEnabledBefore) {
            if (!RootToolsHelper.isAccessGiven()) {
                if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    HelperSystemCommands.sendSystemSetting(context, HelperCommandsKt.HELPER_SETTING_TYPE_SYSTEM, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT, "pointer_location", "0");
                    return;
                }
                return;
            }
            Util.runAsRoot(new String[]{"settings put system pointer_location 0"});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(CheckBox includeScreenOverlaysCheckBox, UIInteractionAction this$0, EditText editText, RadioButton containsRadioButton, UiInteractionConfiguration.Click click, AppCompatDialog dialog, View view) {
        Editable editable;
        boolean z3;
        VariableWithDictionaryKeys variableWithDictionaryKeys;
        Intrinsics.checkNotNullParameter(includeScreenOverlaysCheckBox, "$includeScreenOverlaysCheckBox");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(containsRadioButton, "$containsRadioButton");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (includeScreenOverlaysCheckBox.isChecked() && !this$0.getPremiumStatusHandler().getPremiumStatus().isPro()) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.pro_version_required, 1).show();
            return;
        }
        int i4 = this$0.transientClickOption;
        boolean z4 = this$0.transientLongClick;
        Point point = new Point();
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        int i5 = !containsRadioButton.isChecked();
        if (click != null) {
            z3 = click.getBlocking();
        } else {
            z3 = false;
        }
        if (click != null) {
            variableWithDictionaryKeys = click.getReturnVariable();
        } else {
            variableWithDictionaryKeys = null;
        }
        this$0.X0(new UiInteractionConfiguration.Click(i4, z4, point, false, null, null, valueOf, i5, null, null, z3, variableWithDictionaryKeys, includeScreenOverlaysCheckBox.isChecked()));
        dialog.dismiss();
    }

    private final void J0(final EditText editText) {
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.arlosoft.macrodroid.action.kt
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
                boolean K0;
                K0 = UIInteractionAction.K0(editText, view, i4, keyEvent);
                return K0;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void J1() {
        /*
            Method dump skipped, instructions count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.UIInteractionAction.J1():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K0(EditText editText, View view, int i4, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        if (i4 == 67) {
            try {
                Integer.parseInt(editText.getText().toString());
                return false;
            } catch (Exception unused) {
                editText.setText("");
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void K1(android.widget.EditText r25, android.widget.EditText r26, com.arlosoft.macrodroid.action.UIInteractionAction r27, android.widget.RadioButton r28, int r29, com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click r30, androidx.appcompat.app.AppCompatDialog r31, android.view.View r32) {
        /*
            r0 = r27
            java.lang.String r1 = "$xLocation"
            r2 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "$yLocation"
            r3 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "$radioButtonPercent"
            r4 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "$dialog"
            r5 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            android.text.Editable r1 = r25.getText()
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L35
            int r1 = r1.length()
            if (r1 != 0) goto L33
            goto L35
        L33:
            r1 = 0
            goto L36
        L35:
            r1 = 1
        L36:
            r8 = 0
            if (r1 != 0) goto L51
            android.text.Editable r1 = r25.getText()     // Catch: java.lang.Exception -> L47
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L47
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L47
            r14 = r8
            goto L53
        L47:
            android.text.Editable r1 = r25.getText()
            java.lang.String r1 = r1.toString()
            r14 = r1
            goto L52
        L51:
            r14 = r8
        L52:
            r1 = 0
        L53:
            android.text.Editable r2 = r26.getText()
            if (r2 == 0) goto L61
            int r2 = r2.length()
            if (r2 != 0) goto L60
            goto L61
        L60:
            r6 = 0
        L61:
            if (r6 != 0) goto L7b
            android.text.Editable r2 = r26.getText()     // Catch: java.lang.Exception -> L71
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L71
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L71
            r15 = r8
            goto L7d
        L71:
            android.text.Editable r2 = r26.getText()
            java.lang.String r2 = r2.toString()
            r15 = r2
            goto L7c
        L7b:
            r15 = r8
        L7c:
            r2 = 0
        L7d:
            com.arlosoft.macrodroid.action.UiInteractionConfiguration$Click r3 = new com.arlosoft.macrodroid.action.UiInteractionConfiguration$Click
            int r10 = r0.transientClickOption
            boolean r11 = r0.transientLongClick
            android.graphics.Point r12 = new android.graphics.Point
            boolean r6 = r28.isChecked()
            r9 = 100
            if (r6 == 0) goto L90
            r6 = 100
            goto L92
        L90:
            r6 = r29
        L92:
            int r1 = r0.T0(r1, r7, r6)
            boolean r6 = r28.isChecked()
            if (r6 == 0) goto L9d
            goto L9f
        L9d:
            r9 = r29
        L9f:
            int r2 = r0.T0(r2, r7, r9)
            r12.<init>(r1, r2)
            boolean r13 = r28.isChecked()
            r16 = 0
            r17 = 0
            java.lang.String r18 = ""
            r19 = 0
            if (r30 == 0) goto Lbb
            boolean r7 = r30.getBlocking()
            r20 = r7
            goto Lbd
        Lbb:
            r20 = 0
        Lbd:
            if (r30 == 0) goto Lc3
            com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys r8 = r30.getReturnVariable()
        Lc3:
            r21 = r8
            r22 = 0
            r23 = 4096(0x1000, float:5.74E-42)
            r24 = 0
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0.X0(r3)
            r31.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.UIInteractionAction.K1(android.widget.EditText, android.widget.EditText, com.arlosoft.macrodroid.action.UIInteractionAction, android.widget.RadioButton, int, com.arlosoft.macrodroid.action.UiInteractionConfiguration$Click, androidx.appcompat.app.AppCompatDialog, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(EditText editText, int i4) {
        int i5;
        try {
            i5 = kotlin.math.c.roundToInt((Integer.valueOf(editText.getText().toString()).intValue() / 100.0f) * i4);
        } catch (Exception unused) {
            i5 = -1;
        }
        if (i5 != -1) {
            editText.setText(String.valueOf(Math.min(i4, Math.max(0, i5))));
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.setText(magicTextPair.magicText);
        it.setSelection(magicTextPair.magicText.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(EditText editText, int i4) {
        int i5;
        try {
            i5 = kotlin.math.c.roundToInt((Integer.valueOf(editText.getText().toString()).intValue() / i4) * 100.0f);
        } catch (Exception unused) {
            i5 = -1;
        }
        if (i5 != -1) {
            editText.setText(String.valueOf(i5));
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(Activity activity, UIInteractionAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displayNumericalVarSelectionDialog(activity, this$0.getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
    }

    private final void N0() {
        Intent intent = new Intent(getContext().getApplicationContext(), UiInteractionNotificationPressReceiver.class);
        intent.putExtra("Macro", getMacro());
        intent.putExtra(Constants.EXTRA_CURRENT_ACTION, this);
        PendingIntent broadcast = PendingIntent.getBroadcast(getContext().getApplicationContext(), 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE);
        String r4 = SelectableItem.r(R.string.ui_interaction_notification_navigate_to_app);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.ui_in…fication_navigate_to_app)");
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(getContext()).setSmallIcon(R.drawable.ic_gesture_double_tap_white_24dp).setContentTitle(SelectableItem.r(R.string.ui_interaction_identify_ui_control)).setStyle(new NotificationCompat.BigTextStyle().bigText(r4)).setContentText(r4).setAutoCancel(true).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY).setContentIntent(broadcast);
        Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(context)\n       …tentIntent(pendingIntent)");
        Notification build = contentIntent.build();
        Intrinsics.checkNotNullExpressionValue(build, "notificationBuilder.build()");
        Object systemService = getContext().getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(47632, build);
        Observable<UiInteractionConfiguration.Click> observeOn = UIInteractionAccessibilityService.Companion.getItemSelectedSubject().take(1L).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final c cVar = new c();
        observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.action.ys
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UIInteractionAction.O0(Function1.this, obj);
            }
        });
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        CustomToastHelper.displayCustomToast(context, r4, -1, (int) R.drawable.launcher_no_border, ContextCompat.getColor(getContext(), R.color.actions_primary_dark), 1, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.setText(magicTextPair.magicText);
        it.setSelection(magicTextPair.magicText.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(Activity activity, UIInteractionAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displayNumericalVarSelectionDialog(activity, this$0.getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
    }

    private final List<UIInteractionOption> P0() {
        boolean z3;
        UIInteractionOption[] b4 = Companion.b();
        ArrayList arrayList = new ArrayList();
        for (UIInteractionOption uIInteractionOption : b4) {
            if (Build.VERSION.SDK_INT >= uIInteractionOption.getMinSdk()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                arrayList.add(uIInteractionOption);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(UIInteractionAction this$0, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.I0();
        dialog.cancel();
    }

    private final long Q0(String str, int i4, TriggerContextInfo triggerContextInfo) {
        if (str != null) {
            String value = MagicText.replaceMagicText(getContext(), MagicText.replaceMagicText(getContext(), "[lv=" + str + "]", triggerContextInfo, getMacro()), triggerContextInfo, getMacro());
            try {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                return Long.parseLong(value);
            } catch (Exception unused) {
                Long macroGuid = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError("Variable not found: " + str, macroGuid.longValue());
                return 0L;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(UIInteractionAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleItemCancel();
    }

    private final void R0() {
        boolean z3 = false;
        if (Settings.Global.getInt(getContext().getContentResolver(), "always_finish_activities", 0) != 0) {
            z3 = true;
        }
        if (z3) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String r4 = SelectableItem.r(R.string.disable_developer_option_dont_keep_activities);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.disab…ion_dont_keep_activities)");
            CustomToastHelper.displayCustomToast(context, r4, -1, (int) R.drawable.launcher_no_border, -12303292, 1, true, false);
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        getContext().startActivity(intent);
        N0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(UIInteractionAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0();
    }

    private final void S0(TriggerContextInfo triggerContextInfo, boolean z3, Function0<Unit> function0) {
        long[] longArray;
        long[] longArray2;
        Long longOrNull;
        Long longOrNull2;
        long j4;
        if (!Util.isUIInteractionAccessibilityEnabled(getContext())) {
            PermissionsHelper.showNeedsSpecialPermission(getContext(), getName(), 10);
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("UI Interaction failed, UI Interaction accessibility service is disabled", macroGuid.longValue());
            return;
        }
        Intent intent = new Intent(getContext(), UIInteractionAccessibilityService.class);
        intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_MACRO_GUID, getMacro().getGUID());
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
            Context context = getContext();
            UiInteractionConfiguration uiInteractionConfiguration2 = this.uiInteractionConfiguration;
            Intrinsics.checkNotNull(uiInteractionConfiguration2, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            String itemText = MagicText.replaceMagicText(context, ((UiInteractionConfiguration.Click) uiInteractionConfiguration2).getTextContent(), triggerContextInfo, getMacro());
            Context context2 = getContext();
            UiInteractionConfiguration uiInteractionConfiguration3 = this.uiInteractionConfiguration;
            Intrinsics.checkNotNull(uiInteractionConfiguration3, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            String viewId = MagicText.replaceMagicText(context2, ((UiInteractionConfiguration.Click) uiInteractionConfiguration3).getViewId(), triggerContextInfo, getMacro());
            UiInteractionConfiguration uiInteractionConfiguration4 = this.uiInteractionConfiguration;
            Intrinsics.checkNotNull(uiInteractionConfiguration4, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            Intrinsics.checkNotNullExpressionValue(itemText, "itemText");
            Intrinsics.checkNotNullExpressionValue(viewId, "viewId");
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_UI_INTERACTION_CONFIG, ((UiInteractionConfiguration.Click) uiInteractionConfiguration4).withTextAndViewId(itemText, viewId));
            UiInteractionConfiguration uiInteractionConfiguration5 = this.uiInteractionConfiguration;
            Intrinsics.checkNotNull(uiInteractionConfiguration5, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            String xVarName = ((UiInteractionConfiguration.Click) uiInteractionConfiguration5).getXVarName();
            UiInteractionConfiguration uiInteractionConfiguration6 = this.uiInteractionConfiguration;
            Intrinsics.checkNotNull(uiInteractionConfiguration6, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            String yVarName = ((UiInteractionConfiguration.Click) uiInteractionConfiguration6).getYVarName();
            long j5 = 0;
            if (xVarName != null) {
                String valueX = MagicText.replaceMagicText(getContext(), "[lv=" + xVarName + "]", triggerContextInfo, getMacro());
                if (Intrinsics.areEqual(valueX, "[lv=" + xVarName + "]")) {
                    valueX = MagicText.replaceMagicText(getContext(), "[v=" + xVarName + "]", triggerContextInfo, getMacro());
                }
                if (!Intrinsics.areEqual(valueX, "[v=" + xVarName + "]")) {
                    Intrinsics.checkNotNullExpressionValue(valueX, "valueX");
                    longOrNull2 = kotlin.text.l.toLongOrNull(valueX);
                    if (longOrNull2 != null) {
                        j4 = longOrNull2.longValue();
                    } else {
                        j4 = 0;
                    }
                    intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_X_VARIABLE_VALUE, j4);
                } else {
                    Long macroGuid2 = getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                    SystemLog.logError("X-Location variable not found: " + xVarName, macroGuid2.longValue());
                }
            }
            if (yVarName != null) {
                String valueY = MagicText.replaceMagicText(getContext(), "[lv=" + yVarName + "]", triggerContextInfo, getMacro());
                if (Intrinsics.areEqual(valueY, "[lv=" + yVarName + "]")) {
                    valueY = MagicText.replaceMagicText(getContext(), "[v=" + yVarName + "]", triggerContextInfo, getMacro());
                }
                if (!Intrinsics.areEqual(valueY, "[v=" + yVarName + "]")) {
                    Intrinsics.checkNotNullExpressionValue(valueY, "valueY");
                    longOrNull = kotlin.text.l.toLongOrNull(valueY);
                    if (longOrNull != null) {
                        j5 = longOrNull.longValue();
                    }
                    intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_Y_VARIABLE_VALUE, j5);
                } else {
                    String str = "Y-Location variable not found: " + yVarName;
                    Long macroGuid3 = getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
                    SystemLog.logError(str, macroGuid3.longValue());
                }
            }
            UiInteractionConfiguration uiInteractionConfiguration7 = this.uiInteractionConfiguration;
            Intrinsics.checkNotNull(uiInteractionConfiguration7, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            kotlinx.coroutines.e.e(GlobalScope.INSTANCE, null, null, new UIInteractionAction$runAction$1((UiInteractionConfiguration.Click) uiInteractionConfiguration7, this, serviceRequestId, triggerContextInfo, z3, function0, null), 3, null);
        } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Gesture) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Gesture");
            UiInteractionConfiguration.Gesture gesture = (UiInteractionConfiguration.Gesture) uiInteractionConfiguration;
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_START_X_VARIABLE_VALUE, Q0(gesture.getXStartVarName(), gesture.getStartX(), triggerContextInfo));
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_START_Y_VARIABLE_VALUE, Q0(gesture.getYStartVarName(), gesture.getStartY(), triggerContextInfo));
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_END_X_VARIABLE_VALUE, Q0(gesture.getXEndVarName(), gesture.getEndX(), triggerContextInfo));
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_END_Y_VARIABLE_VALUE, Q0(gesture.getYEndVarName(), gesture.getEndY(), triggerContextInfo));
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_DURATION_VARIABLE_VALUE, Q0(gesture.getDurationVarName(), gesture.getDurationMs(), triggerContextInfo));
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_UI_INTERACTION_CONFIG, this.uiInteractionConfiguration);
        } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.GestureSequence) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.GestureSequence");
            UiInteractionConfiguration.GestureSequence gestureSequence = (UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration;
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_START_X_VARIABLE_VALUE, Q0(gestureSequence.getXStartVarName(), gestureSequence.getStartX(), triggerContextInfo));
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_START_Y_VARIABLE_VALUE, Q0(gestureSequence.getYStartVarName(), gestureSequence.getStartY(), triggerContextInfo));
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_DURATION_VARIABLE_VALUE, Q0(gestureSequence.getDurationVarName(), gestureSequence.getDurationMs(), triggerContextInfo));
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (UiInteractionConfiguration.GestureEntry gestureEntry : gestureSequence.getGestures()) {
                arrayList.add(Long.valueOf(Q0(gestureEntry.getXEndVarName(), gestureEntry.getEndX(), triggerContextInfo)));
                arrayList2.add(Long.valueOf(Q0(gestureEntry.getYEndVarName(), gestureEntry.getEndY(), triggerContextInfo)));
            }
            longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_GESTURE_SEQUENCE_X_VALUES, longArray);
            longArray2 = CollectionsKt___CollectionsKt.toLongArray(arrayList2);
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_GESTURE_SEQUENCE_Y_VALUES, longArray2);
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_UI_INTERACTION_CONFIG, this.uiInteractionConfiguration);
        } else {
            intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_UI_INTERACTION_CONFIG, uiInteractionConfiguration);
        }
        int i4 = serviceRequestId;
        serviceRequestId = i4 + 1;
        intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_SERVICE_REQUEST_ID, i4);
        getContext().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int T0(int i4, int i5, int i6) {
        return Math.min(Math.max(i5, i4), i6);
    }

    private final void U0() {
        final UiInteractionConfiguration.Click click;
        int i4;
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            click = (UiInteractionConfiguration.Click) uiInteractionConfiguration;
        } else {
            click = null;
        }
        if (click != null) {
            i4 = click.getClickOption();
        } else {
            i4 = 0;
        }
        this.transientClickOption = i4;
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(Companion.a(), this.transientClickOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ns
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                UIInteractionAction.V0(UIInteractionAction.this, dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.os
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                UIInteractionAction.W0(UIInteractionAction.this, click, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(UIInteractionAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.transientClickOption = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(UIInteractionAction this$0, UiInteractionConfiguration.Click click, DialogInterface dialogInterface, int i4) {
        boolean z3;
        VariableWithDictionaryKeys variableWithDictionaryKeys;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i5 = this$0.transientClickOption;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            this$0.a1();
                            return;
                        }
                        return;
                    }
                    this$0.R0();
                    return;
                }
                this$0.J1();
                return;
            }
            this$0.E1(R.string.enter_text_to_match, R.string.enter_text_to_match);
            return;
        }
        int i6 = this$0.transientClickOption;
        boolean z4 = this$0.transientLongClick;
        if (click != null) {
            z3 = click.getBlocking();
        } else {
            z3 = false;
        }
        if (click != null) {
            variableWithDictionaryKeys = click.getReturnVariable();
        } else {
            variableWithDictionaryKeys = null;
        }
        this$0.X0(new UiInteractionConfiguration.Click(i6, z4, null, false, null, null, null, 0, "", null, z3, variableWithDictionaryKeys, false, 4096, null));
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [T, com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys] */
    private final void X0(UiInteractionConfiguration.Click click) {
        List listOf;
        String str;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_click_result);
        appCompatDialog.setTitle(R.string.ui_interaction_click_result);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.boolean_variable_spinner);
        Intrinsics.checkNotNull(findViewById3);
        final Spinner spinner = (Spinner) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.add_boolean_variable_button);
        Intrinsics.checkNotNull(findViewById4);
        Button button3 = (Button) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.dont_wait_radio_button);
        Intrinsics.checkNotNull(findViewById5);
        View findViewById6 = appCompatDialog.findViewById(R.id.block_until_complete_radio_button);
        Intrinsics.checkNotNull(findViewById6);
        RadioButton radioButton = (RadioButton) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.save_to_variable_container);
        Intrinsics.checkNotNull(findViewById7);
        ViewGroup viewGroup = (ViewGroup) findViewById7;
        ((RadioButton) findViewById5).setChecked(!click.getBlocking());
        radioButton.setChecked(click.getBlocking());
        Z0(spinner, button3, viewGroup, click.getBlocking());
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton, (CoroutineContext) null, new f(spinner, button3, viewGroup, null), 1, (Object) null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = click.getReturnVariable();
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.none));
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = getMacro();
        VariableWithDictionaryKeys variableWithDictionaryKeys = (VariableWithDictionaryKeys) objectRef.element;
        if (variableWithDictionaryKeys != null) {
            str = variableWithDictionaryKeys.getVariableName();
        } else {
            str = null;
        }
        VariableHelper.configureBooleanVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, false, listOf, str, "", true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.UIInteractionAction$showClickReturnValueDialog$2
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                objectRef.element = null;
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [T, com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys] */
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                Ref.ObjectRef<VariableWithDictionaryKeys> objectRef2 = objectRef;
                String name = variable.getName();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                objectRef2.element = new VariableWithDictionaryKeys(name, new DictionaryKeys(list));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIInteractionAction.Y0(activity, spinner, this, view);
            }
        });
        ViewExtensionsKt.onClick$default(button, null, new g(objectRef, radioButton, click, appCompatDialog, null), 1, null);
        ViewExtensionsKt.onClick$default(button2, null, new h(appCompatDialog, null), 1, null);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(Activity activity, Spinner booleanVariableSpinner, UIInteractionAction this$0, View view) {
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VariablesHelper.createNewVariable(activity, booleanVariableSpinner, this$0, this$0.getDialogTheme(), 0, (VariablesHelper.VariableCreatedListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(Spinner spinner, Button button, ViewGroup viewGroup, boolean z3) {
        float f4;
        spinner.setEnabled(z3);
        button.setEnabled(z3);
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        viewGroup.setAlpha(f4);
    }

    private final void a1() {
        final UiInteractionConfiguration.Click click;
        boolean z3;
        boolean z4;
        boolean z5;
        if (!checkActivityAlive()) {
            return;
        }
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            click = (UiInteractionConfiguration.Click) uiInteractionConfiguration;
        } else {
            click = null;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_select_view_id);
        appCompatDialog.setTitle(R.string.ui_interaction_view_id);
        boolean z6 = false;
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.viewIdText);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magicTextButton);
        View findViewById = appCompatDialog.findViewById(R.id.containsRadioButton);
        Intrinsics.checkNotNull(findViewById);
        final RadioButton radioButton = (RadioButton) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.matchesRadioButton);
        Intrinsics.checkNotNull(findViewById2);
        RadioButton radioButton2 = (RadioButton) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.includeScreenOverlaysCheckBox);
        Intrinsics.checkNotNull(findViewById3);
        final CheckBox checkBox = (CheckBox) findViewById3;
        if (editText != null) {
            editText.setText((click == null || (r6 = click.getViewId()) == null) ? "" : "");
        }
        if (editText != null) {
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
        checkBox.setText(SelectableItem.r(R.string.ui_interaction_action_text_match_include_screen_overlays) + " (" + SelectableItem.r(R.string.pro_version_only_short) + ")");
        if (click != null) {
            z3 = click.getCheckOverlays();
        } else {
            z3 = false;
        }
        checkBox.setChecked(z3);
        if (click != null) {
            if (click.getTextMatchOption() == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            radioButton.setChecked(z4);
            if (click.getTextMatchOption() == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            radioButton2.setChecked(z5);
        }
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.UIInteractionAction$showEnterViewIdDialog$2
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NotNull Editable s3) {
                    boolean z7;
                    Intrinsics.checkNotNullParameter(s3, "s");
                    Button button4 = button;
                    if (button4 != null) {
                        Editable text = editText.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "viewIdText.text");
                        if (text.length() > 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        button4.setEnabled(z7);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }
            });
        }
        if (editText != null) {
            final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ft
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    UIInteractionAction.b1(editText, magicTextPair);
                }
            };
            if (button3 != null) {
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gt
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UIInteractionAction.c1(activity, magicTextListener, this, view);
                    }
                });
            }
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ht
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.d1(UIInteractionAction.this, radioButton, editText, click, checkBox, appCompatDialog, view);
                }
            });
        }
        if (button != null) {
            Intrinsics.checkNotNull(editText);
            Editable text = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "viewIdText!!.text");
            if (text.length() > 0) {
                z6 = true;
            }
            button.setEnabled(z6);
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jt
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.e1(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(Activity activity, MagicText.MagicTextListener magicTextListener, UIInteractionAction this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(UIInteractionAction this$0, RadioButton containsRadioButton, EditText editText, UiInteractionConfiguration.Click click, CheckBox includeScreenOverlaysCheckBox, AppCompatDialog dialog, View view) {
        Editable editable;
        boolean z3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(containsRadioButton, "$containsRadioButton");
        Intrinsics.checkNotNullParameter(includeScreenOverlaysCheckBox, "$includeScreenOverlaysCheckBox");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        int i4 = this$0.transientClickOption;
        boolean z4 = this$0.transientLongClick;
        int i5 = !containsRadioButton.isChecked();
        VariableWithDictionaryKeys variableWithDictionaryKeys = null;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        if (click != null) {
            z3 = click.getBlocking();
        } else {
            z3 = false;
        }
        if (click != null) {
            variableWithDictionaryKeys = click.getReturnVariable();
        }
        this$0.X0(new UiInteractionConfiguration.Click(i4, z4, null, false, null, null, null, i5, null, valueOf, z3, variableWithDictionaryKeys, includeScreenOverlaysCheckBox.isChecked()));
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void f1() {
        UiInteractionConfiguration.Gesture gesture;
        AppCompatDialog appCompatDialog;
        int i4;
        Button button;
        String str;
        String str2;
        String str3;
        String str4;
        String num;
        String str5;
        final AppCompatDialog appCompatDialog2;
        boolean z3;
        AppCompatDialog appCompatDialog3 = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog3.setContentView(R.layout.dialog_ui_interaction_gesture_config);
        appCompatDialog3.setTitle(R.string.ui_interaction_perform_gesture);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog3, 0, 1, null);
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Gesture) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Gesture");
            gesture = (UiInteractionConfiguration.Gesture) uiInteractionConfiguration;
        } else {
            gesture = null;
        }
        View findViewById = appCompatDialog3.findViewById(R.id.showTouchOverlayButton);
        Intrinsics.checkNotNull(findViewById);
        Button button2 = (Button) findViewById;
        Button button3 = (Button) appCompatDialog3.findViewById(R.id.okButton);
        Button button4 = (Button) appCompatDialog3.findViewById(R.id.cancelButton);
        View findViewById2 = appCompatDialog3.findViewById(R.id.start_x_location);
        Intrinsics.checkNotNull(findViewById2);
        final EditText editText = (EditText) findViewById2;
        View findViewById3 = appCompatDialog3.findViewById(R.id.start_y_location);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText2 = (EditText) findViewById3;
        View findViewById4 = appCompatDialog3.findViewById(R.id.end_x_location);
        Intrinsics.checkNotNull(findViewById4);
        final EditText editText3 = (EditText) findViewById4;
        View findViewById5 = appCompatDialog3.findViewById(R.id.end_y_location);
        Intrinsics.checkNotNull(findViewById5);
        final EditText editText4 = (EditText) findViewById5;
        TextView textView = (TextView) appCompatDialog3.findViewById(R.id.resolution_label);
        final EditText editText5 = (EditText) appCompatDialog3.findViewById(R.id.duration);
        final CheckBox checkBox = (CheckBox) appCompatDialog3.findViewById(R.id.waitCheckbox);
        TextView textView2 = (TextView) appCompatDialog3.findViewById(R.id.msLabel);
        Button button5 = (Button) appCompatDialog3.findViewById(R.id.startXMagicTextButton);
        Button button6 = (Button) appCompatDialog3.findViewById(R.id.startYMagicTextButton);
        Button button7 = (Button) appCompatDialog3.findViewById(R.id.endXMagicTextButton);
        Button button8 = (Button) appCompatDialog3.findViewById(R.id.endYMagicTextButton);
        Button button9 = (Button) appCompatDialog3.findViewById(R.id.msMagicTextButton);
        View findViewById6 = appCompatDialog3.findViewById(R.id.radioButtonPixels);
        Intrinsics.checkNotNull(findViewById6);
        RadioButton radioButton = (RadioButton) findViewById6;
        View findViewById7 = appCompatDialog3.findViewById(R.id.radioButtonPercent);
        Intrinsics.checkNotNull(findViewById7);
        final RadioButton radioButton2 = (RadioButton) findViewById7;
        if (gesture == null) {
            appCompatDialog = appCompatDialog3;
            i4 = 1;
            radioButton.setChecked(true);
            button = button6;
        } else {
            appCompatDialog = appCompatDialog3;
            i4 = 1;
            button = button6;
            radioButton.setChecked(!gesture.getXyPercentages());
            radioButton2.setChecked(gesture.getXyPercentages());
        }
        ViewExtensionsKt.onClick$default(button2, null, new i(null), i4, null);
        if (textView2 != null) {
            String r4 = SelectableItem.r(R.string.milliseconds_capital);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.milliseconds_capital)");
            String lowerCase = r4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            textView2.setText(lowerCase);
        }
        if (checkBox != null) {
            if (gesture != null) {
                z3 = gesture.getWaitBeforeNext();
            } else {
                z3 = true;
            }
            checkBox.setChecked(z3);
        }
        if (gesture != null) {
            str = gesture.getXStartVarName();
        } else {
            str = null;
        }
        String str6 = "0";
        if (str != null) {
            editText.setText(gesture.getXStartVarName());
        } else {
            editText.setText((gesture == null || (r3 = Integer.valueOf(gesture.getStartX()).toString()) == null) ? "0" : "0");
        }
        if (gesture != null) {
            str2 = gesture.getYStartVarName();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            editText2.setText(gesture.getYStartVarName());
        } else {
            editText2.setText((gesture == null || (r3 = Integer.valueOf(gesture.getStartY()).toString()) == null) ? "0" : "0");
        }
        if (gesture != null) {
            str3 = gesture.getXEndVarName();
        } else {
            str3 = null;
        }
        if (str3 != null) {
            editText3.setText(gesture.getXEndVarName());
        } else {
            editText3.setText((gesture == null || (r3 = Integer.valueOf(gesture.getEndX()).toString()) == null) ? "0" : "0");
        }
        if (gesture != null) {
            str4 = gesture.getYEndVarName();
        } else {
            str4 = null;
        }
        if (str4 != null) {
            editText4.setText(gesture.getYEndVarName());
        } else {
            if (gesture != null && (num = Integer.valueOf(gesture.getEndY()).toString()) != null) {
                str6 = num;
            }
            editText4.setText(str6);
        }
        if (gesture != null) {
            str5 = gesture.getDurationVarName();
        } else {
            str5 = null;
        }
        if (str5 != null) {
            if (editText5 != null) {
                editText5.setText(gesture.getDurationVarName());
            }
        } else if (editText5 != null) {
            editText5.setText((gesture == null || (r0 = Integer.valueOf(gesture.getDurationMs()).toString()) == null) ? "250" : "250");
        }
        Point point = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getRealSize(point);
        if (textView != null) {
            textView.setText(SelectableItem.r(R.string.screen_resolution) + ": " + point.x + ", " + point.y);
        }
        final int max = Math.max(point.x, point.y);
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton2, (CoroutineContext) null, new j(editText, point, editText2, editText3, editText4, null), 1, (Object) null);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ot
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UIInteractionAction.g1(editText, magicTextPair);
            }
        };
        if (button5 != null) {
            button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zr
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.h1(UIInteractionAction.this, magicTextListener, view);
                }
            });
        }
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.as
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UIInteractionAction.i1(editText2, magicTextPair);
            }
        };
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.j1(UIInteractionAction.this, magicTextListener2, view);
                }
            });
        }
        final MagicText.MagicTextListener magicTextListener3 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.cs
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UIInteractionAction.k1(editText3, magicTextPair);
            }
        };
        if (button7 != null) {
            button7.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ds
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.l1(UIInteractionAction.this, magicTextListener3, view);
                }
            });
        }
        final MagicText.MagicTextListener magicTextListener4 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.es
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UIInteractionAction.m1(editText4, magicTextPair);
            }
        };
        if (button8 != null) {
            button8.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.n1(UIInteractionAction.this, magicTextListener4, view);
                }
            });
        }
        if (editText5 != null) {
            final MagicText.MagicTextListener magicTextListener5 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.gs
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    UIInteractionAction.o1(editText5, magicTextPair);
                }
            };
            if (button9 != null) {
                button9.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.hs
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UIInteractionAction.p1(UIInteractionAction.this, magicTextListener5, view);
                    }
                });
            }
        }
        if (button3 != null) {
            final AppCompatDialog appCompatDialog4 = appCompatDialog;
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pt
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.q1(editText, editText2, editText3, editText4, editText5, this, radioButton2, max, checkBox, appCompatDialog4, view);
                }
            });
        }
        if (button4 != null) {
            appCompatDialog2 = appCompatDialog;
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qt
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.r1(AppCompatDialog.this, view);
                }
            });
        } else {
            appCompatDialog2 = appCompatDialog;
        }
        appCompatDialog2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.yr
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                UIInteractionAction.s1(UIInteractionAction.this, dialogInterface);
            }
        });
        appCompatDialog2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(UIInteractionAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displayNumericalVarSelectionDialog(this$0.getActivity(), this$0.getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(UIInteractionAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displayNumericalVarSelectionDialog(this$0.getActivity(), this$0.getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(UIInteractionAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displayNumericalVarSelectionDialog(this$0.getActivity(), this$0.getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(UIInteractionAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displayNumericalVarSelectionDialog(this$0.getActivity(), this$0.getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(UIInteractionAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displayNumericalVarSelectionDialog(this$0.getActivity(), this$0.getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(EditText startX, EditText startY, EditText endX, EditText endY, EditText editText, UIInteractionAction this$0, RadioButton radioButtonPercent, int i4, CheckBox checkBox, AppCompatDialog dialog, View view) {
        String obj;
        int i5;
        String obj2;
        int i6;
        String obj3;
        int i7;
        String obj4;
        int i8;
        int i9;
        String str;
        int i10;
        int i11;
        int i12;
        boolean z3;
        Intrinsics.checkNotNullParameter(startX, "$startX");
        Intrinsics.checkNotNullParameter(startY, "$startY");
        Intrinsics.checkNotNullParameter(endX, "$endX");
        Intrinsics.checkNotNullParameter(endY, "$endY");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioButtonPercent, "$radioButtonPercent");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        String str2 = null;
        try {
            i5 = Integer.parseInt(startX.getText().toString());
            obj = null;
        } catch (Exception unused) {
            obj = startX.getText().toString();
            i5 = 0;
        }
        try {
            i6 = Integer.parseInt(startY.getText().toString());
            obj2 = null;
        } catch (Exception unused2) {
            obj2 = startY.getText().toString();
            i6 = 0;
        }
        try {
            i7 = Integer.parseInt(endX.getText().toString());
            obj3 = null;
        } catch (Exception unused3) {
            obj3 = endX.getText().toString();
            i7 = 0;
        }
        try {
            i8 = Integer.parseInt(endY.getText().toString());
            obj4 = null;
        } catch (Exception unused4) {
            obj4 = endY.getText().toString();
            i8 = 0;
        }
        if (editText != null) {
            try {
                i9 = Integer.parseInt(editText.getText().toString());
            } catch (Exception unused5) {
                str2 = editText.getText().toString();
                i9 = 0;
            }
            str = str2;
        } else {
            str = null;
            i9 = 0;
        }
        int i13 = 100;
        if (radioButtonPercent.isChecked()) {
            i10 = 100;
        } else {
            i10 = i4;
        }
        int T0 = this$0.T0(i5, 0, i10);
        if (radioButtonPercent.isChecked()) {
            i11 = 100;
        } else {
            i11 = i4;
        }
        int T02 = this$0.T0(i6, 0, i11);
        if (radioButtonPercent.isChecked()) {
            i12 = 100;
        } else {
            i12 = i4;
        }
        int T03 = this$0.T0(i7, 0, i12);
        if (!radioButtonPercent.isChecked()) {
            i13 = i4;
        }
        int T04 = this$0.T0(i8, 0, i13);
        boolean isChecked = radioButtonPercent.isChecked();
        int T05 = this$0.T0(i9, 0, 20000);
        if (checkBox != null) {
            z3 = checkBox.isChecked();
        } else {
            z3 = true;
        }
        this$0.uiInteractionConfiguration = new UiInteractionConfiguration.Gesture(T0, T02, T03, T04, isChecked, T05, obj, obj2, obj3, obj4, str, z3);
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(UIInteractionAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleItemCancel();
    }

    private final void t1() {
        UiInteractionConfiguration.GestureSequence gestureSequence;
        int i4;
        String str;
        String str2;
        String num;
        int i5;
        DispatchedCoroutine dispatchedCoroutine;
        CheckBox checkBox;
        RadioButton radioButton;
        EditText editText;
        Button button;
        final EditText editText2;
        Point point;
        int i6;
        LinearLayout linearLayout;
        String str3;
        Button button2;
        final AppCompatDialog appCompatDialog;
        boolean z3;
        int i7;
        List<UiInteractionConfiguration.GestureEntry> gestures;
        boolean z4;
        AppCompatDialog appCompatDialog2 = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog2.setContentView(R.layout.dialog_ui_interaction_gesture_sequence_config);
        appCompatDialog2.setTitle(R.string.ui_interaction_perform_gesture_sequence);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog2, 0, 1, null);
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.GestureSequence) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.GestureSequence");
            gestureSequence = (UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration;
        } else {
            gestureSequence = null;
        }
        ViewGroup viewGroup = (ViewGroup) appCompatDialog2.findViewById(R.id.topLevelContainer);
        View findViewById = appCompatDialog2.findViewById(R.id.showTouchOverlayButton);
        Intrinsics.checkNotNull(findViewById);
        Button button3 = (Button) findViewById;
        Button button4 = (Button) appCompatDialog2.findViewById(R.id.okButton);
        Button button5 = (Button) appCompatDialog2.findViewById(R.id.cancelButton);
        View findViewById2 = appCompatDialog2.findViewById(R.id.start_x_location);
        Intrinsics.checkNotNull(findViewById2);
        final EditText editText3 = (EditText) findViewById2;
        View findViewById3 = appCompatDialog2.findViewById(R.id.start_y_location);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText4 = (EditText) findViewById3;
        View findViewById4 = appCompatDialog2.findViewById(R.id.duration);
        Intrinsics.checkNotNull(findViewById4);
        EditText editText5 = (EditText) findViewById4;
        Button button6 = (Button) appCompatDialog2.findViewById(R.id.msMagicTextButton);
        TextView textView = (TextView) appCompatDialog2.findViewById(R.id.resolution_label);
        CheckBox checkBox2 = (CheckBox) appCompatDialog2.findViewById(R.id.waitCheckbox);
        TextView textView2 = (TextView) appCompatDialog2.findViewById(R.id.msLabel);
        Button button7 = (Button) appCompatDialog2.findViewById(R.id.startXMagicTextButton);
        Button button8 = (Button) appCompatDialog2.findViewById(R.id.startYMagicTextButton);
        View findViewById5 = appCompatDialog2.findViewById(R.id.entriesLayout);
        Intrinsics.checkNotNull(findViewById5);
        LinearLayout linearLayout2 = (LinearLayout) findViewById5;
        Button button9 = (Button) appCompatDialog2.findViewById(R.id.addEntryButton);
        Button button10 = (Button) appCompatDialog2.findViewById(R.id.removeEntryButton);
        View findViewById6 = appCompatDialog2.findViewById(R.id.radioButtonPixels);
        Intrinsics.checkNotNull(findViewById6);
        RadioButton radioButton2 = (RadioButton) findViewById6;
        View findViewById7 = appCompatDialog2.findViewById(R.id.radioButtonPercent);
        Intrinsics.checkNotNull(findViewById7);
        RadioButton radioButton3 = (RadioButton) findViewById7;
        Intrinsics.checkNotNull(viewGroup);
        LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
        Intrinsics.checkNotNullExpressionValue(layoutTransition, "topLevelContainer!!.layoutTransition");
        layoutTransition.enableTransitionType(4);
        if (textView2 != null) {
            String r4 = SelectableItem.r(R.string.milliseconds_capital);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.milliseconds_capital)");
            String lowerCase = r4.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            textView2.setText(lowerCase);
        }
        if (checkBox2 != null) {
            if (gestureSequence != null) {
                z4 = gestureSequence.getWaitBeforeNext();
            } else {
                z4 = true;
            }
            checkBox2.setChecked(z4);
        }
        if (gestureSequence == null) {
            i4 = 1;
            radioButton2.setChecked(true);
        } else {
            i4 = 1;
            radioButton2.setChecked(!gestureSequence.getXyPercentages());
            radioButton3.setChecked(gestureSequence.getXyPercentages());
        }
        ViewExtensionsKt.onClick$default(button3, null, new k(null), i4, null);
        if (gestureSequence != null) {
            str = gestureSequence.getXStartVarName();
        } else {
            str = null;
        }
        String str4 = "0";
        if (str != null) {
            editText3.setText(gestureSequence.getXStartVarName());
        } else {
            editText3.setText((gestureSequence == null || (r0 = Integer.valueOf(gestureSequence.getStartX()).toString()) == null) ? "0" : "0");
        }
        if (gestureSequence != null) {
            str2 = gestureSequence.getYStartVarName();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            editText4.setText(gestureSequence.getYStartVarName());
        } else {
            if (gestureSequence != null && (num = Integer.valueOf(gestureSequence.getStartY()).toString()) != null) {
                str4 = num;
            }
            editText4.setText(str4);
        }
        Point point2 = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getRealSize(point2);
        if (textView != null) {
            textView.setText(SelectableItem.r(R.string.screen_resolution) + ": " + point2.x + ", " + point2.y);
        }
        int max = Math.max(point2.x, point2.y);
        MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ts
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UIInteractionAction.u1(editText3, magicTextPair);
            }
        };
        if (button7 != null) {
            dispatchedCoroutine = null;
            l lVar = new l(magicTextListener, null);
            i5 = 1;
            ViewExtensionsKt.onClick$default(button7, null, lVar, 1, null);
        } else {
            i5 = 1;
            dispatchedCoroutine = null;
        }
        MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.et
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UIInteractionAction.v1(editText4, magicTextPair);
            }
        };
        if (button8 != null) {
            ViewExtensionsKt.onClick$default(button8, dispatchedCoroutine, new m(magicTextListener2, dispatchedCoroutine), i5, dispatchedCoroutine);
        }
        if (button10 != null) {
            ViewExtensionsKt.onClick$default(button10, dispatchedCoroutine, new n(linearLayout2, button10, dispatchedCoroutine), i5, dispatchedCoroutine);
        }
        if (button9 != null) {
            checkBox = checkBox2;
            button = button6;
            i6 = max;
            linearLayout = linearLayout2;
            radioButton = radioButton3;
            editText = editText4;
            editText2 = editText5;
            point = point2;
            ViewExtensionsKt.onClick$default(button9, null, new o(appCompatDialog2, linearLayout2, button10, null), 1, null);
        } else {
            checkBox = checkBox2;
            radioButton = radioButton3;
            editText = editText4;
            button = button6;
            editText2 = editText5;
            point = point2;
            i6 = max;
            linearLayout = linearLayout2;
        }
        if (gestureSequence != null && (gestures = gestureSequence.getGestures()) != null) {
            for (UiInteractionConfiguration.GestureEntry gestureEntry : gestures) {
                LayoutInflater layoutInflater = appCompatDialog2.getLayoutInflater();
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "dialog.layoutInflater");
                F0(layoutInflater, linearLayout, gestureEntry);
            }
        }
        if (gestureSequence != null) {
            str3 = gestureSequence.getDurationVarName();
        } else {
            str3 = null;
        }
        if (str3 != null) {
            editText2.setText(gestureSequence.getDurationVarName());
        } else {
            editText2.setText((gestureSequence == null || (r0 = Integer.valueOf(gestureSequence.getDurationMs()).toString()) == null) ? "250" : "250");
        }
        MagicText.MagicTextListener magicTextListener3 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.lt
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UIInteractionAction.w1(editText2, magicTextPair);
            }
        };
        if (button != null) {
            ViewExtensionsKt.onClick$default(button, null, new p(magicTextListener3, null), 1, null);
        }
        if (button10 != null) {
            if (linearLayout.getChildCount() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            button10.setVisibility(i7);
        }
        RadioButton radioButton4 = radioButton;
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton4, (CoroutineContext) null, new q(editText3, point, editText, linearLayout, null), 1, (Object) null);
        if (button4 != null) {
            button2 = button5;
            ViewExtensionsKt.onClick$default(button4, null, new r(linearLayout, this, editText3, editText, editText2, i6, radioButton4, checkBox, appCompatDialog2, null), 1, null);
        } else {
            button2 = button5;
        }
        if (button2 != null) {
            appCompatDialog = appCompatDialog2;
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.mt
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.x1(AppCompatDialog.this, view);
                }
            });
        } else {
            appCompatDialog = appCompatDialog2;
        }
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.nt
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                UIInteractionAction.y1(UIInteractionAction.this, dialogInterface);
            }
        });
        appCompatDialog.show();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText(magicTextPair.magicText);
        ViewExtensionsKt.setCursorAtEnd(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(UIInteractionAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleItemCancel();
    }

    private final void z1() {
        UiInteractionConfiguration.Paste paste;
        boolean z3;
        boolean z4;
        int i4;
        if (!checkActivityAlive()) {
            return;
        }
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Paste) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Paste");
            paste = (UiInteractionConfiguration.Paste) uiInteractionConfiguration;
        } else {
            paste = null;
        }
        UiInteractionConfiguration uiInteractionConfiguration2 = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration2 instanceof UiInteractionConfiguration.Paste) {
            Intrinsics.checkNotNull(uiInteractionConfiguration2, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Paste");
            z3 = ((UiInteractionConfiguration.Paste) uiInteractionConfiguration2).getForceClear();
        } else {
            z3 = false;
        }
        if (paste != null) {
            z4 = paste.getUseClipboard();
        } else {
            z4 = true;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_ui_interaction_paste_options);
        appCompatDialog.setTitle(R.string.ui_interaction_paste);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.textToMatch);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magicTextButton);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.useClipboardRadioButton);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.enterTextRadioButton);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.enterTextLayout);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.clearExistingCheckbox);
        if (radioButton != null) {
            radioButton.setChecked(z4);
        }
        if (radioButton2 != null) {
            radioButton2.setChecked(!z4);
        }
        if (checkBox != null) {
            checkBox.setChecked(z3);
        }
        if (viewGroup != null) {
            if (!z4) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            viewGroup.setVisibility(i4);
        }
        if (radioButton2 != null) {
            Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton2, (CoroutineContext) null, new s(viewGroup, null), 1, (Object) null);
        }
        if (editText != null) {
            editText.setText((paste == null || (r0 = paste.getText()) == null) ? "" : "");
        }
        if (editText != null) {
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
        if (editText != null) {
            final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.js
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    UIInteractionAction.A1(editText, magicTextPair);
                }
            };
            if (button3 != null) {
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ks
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UIInteractionAction.B1(activity, magicTextListener, this, view);
                    }
                });
            }
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ls
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.C1(UIInteractionAction.this, radioButton, checkBox, editText, appCompatDialog, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ms
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UIInteractionAction.D1(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.action = P0().get(i4).getId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int collectionSizeOrDefault;
        List<UIInteractionOption> P0 = P0();
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(P0, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (UIInteractionOption uIInteractionOption : P0) {
            arrayList.add(Integer.valueOf(uIInteractionOption.getId()));
        }
        return arrayList.indexOf(Integer.valueOf(this.action));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getEditModeWarning() {
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration != null && (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) && !getPremiumStatusHandler().getPremiumStatus().isPro() && ((UiInteractionConfiguration.Click) uiInteractionConfiguration).getCheckOverlays()) {
            return SelectableItem.r(R.string.using_screen_overlays_requires_pro_version);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str;
        boolean z3;
        String str2;
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration != null) {
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            str = uiInteractionConfiguration.getExtendedDetail(resources);
        } else {
            str = null;
        }
        String name = Companion.b()[this.action].getName();
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            str2 = " [" + str + "]";
        } else {
            str2 = "";
        }
        return name + str2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return UIInteractionActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        return getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (!(uiInteractionConfiguration instanceof UiInteractionConfiguration.Click)) {
            return uiInteractionConfiguration instanceof UiInteractionConfiguration.Paste ? new String[]{((UiInteractionConfiguration.Paste) uiInteractionConfiguration).getText()} : new String[0];
        }
        String[] strArr = new String[2];
        UiInteractionConfiguration.Click click = (UiInteractionConfiguration.Click) uiInteractionConfiguration;
        String textContent = click.getTextContent();
        String str = "";
        if (textContent == null) {
            textContent = "";
        }
        strArr[0] = textContent;
        String viewId = click.getViewId();
        if (viewId != null) {
            str = viewId;
        }
        strArr[1] = str;
        return strArr;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @NotNull
    public final UIInteractionResultCache getUiInteractionResultCache() {
        UIInteractionResultCache uIInteractionResultCache = this.uiInteractionResultCache;
        if (uIInteractionResultCache != null) {
            return uIInteractionResultCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiInteractionResultCache");
        return null;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        int collectionSizeOrDefault;
        List flatten;
        Object[] plus;
        List listOf;
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            UiInteractionConfiguration uiInteractionConfiguration2 = this.uiInteractionConfiguration;
            Intrinsics.checkNotNull(uiInteractionConfiguration2, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
            return new String[]{((UiInteractionConfiguration.Click) uiInteractionConfiguration).getXVarName(), ((UiInteractionConfiguration.Click) uiInteractionConfiguration2).getYVarName()};
        } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Gesture) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Gesture");
            UiInteractionConfiguration.Gesture gesture = (UiInteractionConfiguration.Gesture) uiInteractionConfiguration;
            return new String[]{gesture.getXStartVarName(), gesture.getYStartVarName(), gesture.getXEndVarName(), gesture.getYEndVarName(), gesture.getDurationVarName()};
        } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.GestureSequence) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.GestureSequence");
            UiInteractionConfiguration.GestureSequence gestureSequence = (UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration;
            String[] strArr = {gestureSequence.getXStartVarName(), gestureSequence.getYStartVarName(), gestureSequence.getDurationVarName()};
            List<UiInteractionConfiguration.GestureEntry> gestures = gestureSequence.getGestures();
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(gestures, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (UiInteractionConfiguration.GestureEntry gestureEntry : gestures) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{gestureEntry.getXEndVarName(), gestureEntry.getYEndVarName()});
                arrayList.add(listOf);
            }
            flatten = kotlin.collections.f.flatten(arrayList);
            plus = ArraysKt___ArraysJvmKt.plus((Object[]) strArr, (Collection) flatten);
            return (String[]) plus;
        } else {
            return new String[0];
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        int collectionSizeOrDefault;
        List flatten;
        Object[] plus;
        List listOf;
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
            return new Integer[]{1, 1};
        }
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Gesture) {
            return new Integer[]{1, 1, 1, 1, 1};
        }
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.GestureSequence) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.GestureSequence");
            Integer[] numArr = {1, 1, 1};
            List<UiInteractionConfiguration.GestureEntry> gestures = ((UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration).getGestures();
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(gestures, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (UiInteractionConfiguration.GestureEntry gestureEntry : gestures) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 1});
                arrayList.add(listOf);
            }
            flatten = kotlin.collections.f.flatten(arrayList);
            plus = ArraysKt___ArraysJvmKt.plus((Object[]) numArr, (Collection) flatten);
            return (Integer[]) plus;
        }
        return new Integer[0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemCancel() {
        super.handleItemCancel();
        I0();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.animateInUpgradeSceen(activity);
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        long Q0;
        long j4;
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Gesture) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Gesture");
            if (((UiInteractionConfiguration.Gesture) uiInteractionConfiguration).getWaitBeforeNext()) {
                UiInteractionConfiguration uiInteractionConfiguration2 = this.uiInteractionConfiguration;
                Intrinsics.checkNotNull(uiInteractionConfiguration2, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Gesture");
                String durationVarName = ((UiInteractionConfiguration.Gesture) uiInteractionConfiguration2).getDurationVarName();
                UiInteractionConfiguration uiInteractionConfiguration3 = this.uiInteractionConfiguration;
                Intrinsics.checkNotNull(uiInteractionConfiguration3, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Gesture");
                Q0 = Q0(durationVarName, ((UiInteractionConfiguration.Gesture) uiInteractionConfiguration3).getDurationMs(), triggerContextInfo);
                j4 = Q0;
            }
            j4 = 0;
        } else {
            if (uiInteractionConfiguration instanceof UiInteractionConfiguration.GestureSequence) {
                Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.GestureSequence");
                if (((UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration).getWaitBeforeNext()) {
                    UiInteractionConfiguration uiInteractionConfiguration4 = this.uiInteractionConfiguration;
                    Intrinsics.checkNotNull(uiInteractionConfiguration4, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.GestureSequence");
                    String durationVarName2 = ((UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration4).getDurationVarName();
                    UiInteractionConfiguration uiInteractionConfiguration5 = this.uiInteractionConfiguration;
                    Intrinsics.checkNotNull(uiInteractionConfiguration5, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.GestureSequence");
                    Q0 = Q0(durationVarName2, ((UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration5).getDurationMs(), triggerContextInfo);
                    j4 = Q0;
                }
            }
            j4 = 0;
        }
        S0(triggerContextInfo, z4, new d(i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo));
        if (!z4) {
            UiInteractionConfiguration uiInteractionConfiguration6 = this.uiInteractionConfiguration;
            boolean z5 = false;
            if (uiInteractionConfiguration6 != null && !uiInteractionConfiguration6.handlesOwnAsync()) {
                z5 = true;
            }
            if (z5) {
                kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new e(j4, this, i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo, null), 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        super.itemComplete();
        I0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        int collectionSizeOrDefault;
        List<UIInteractionOption> P0 = P0();
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(P0, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (UIInteractionOption uIInteractionOption : P0) {
            arrayList.add(uIInteractionOption.getName());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresUIInteractionAccessibility() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.action;
        switch (i4) {
            case 0:
            case 1:
                boolean z3 = true;
                if (i4 != 1) {
                    z3 = false;
                }
                this.transientLongClick = z3;
                U0();
                return;
            case 2:
                this.uiInteractionConfiguration = UiInteractionConfiguration.Copy.INSTANCE;
                itemComplete();
                return;
            case 3:
                this.uiInteractionConfiguration = UiInteractionConfiguration.Cut.INSTANCE;
                itemComplete();
                return;
            case 4:
                z1();
                return;
            case 5:
                this.uiInteractionConfiguration = UiInteractionConfiguration.ClearSelection.INSTANCE;
                itemComplete();
                return;
            case 6:
                f1();
                return;
            case 7:
                t1();
                return;
            case 8:
                this.uiInteractionConfiguration = UiInteractionConfiguration.PressEnter.INSTANCE;
                itemComplete();
                return;
            default:
                return;
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        UiInteractionConfiguration.Click copy;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (magicText.length == 2) {
            if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
                copy = r7.copy((r28 & 1) != 0 ? r7.clickOption : 0, (r28 & 2) != 0 ? r7.longClick : false, (r28 & 4) != 0 ? r7.xyPoint : null, (r28 & 8) != 0 ? r7.xyPercentages : false, (r28 & 16) != 0 ? r7.xVarName : null, (r28 & 32) != 0 ? r7.yVarName : null, (r28 & 64) != 0 ? r7.textContent : magicText[0], (r28 & 128) != 0 ? r7.textMatchOption : 0, (r28 & 256) != 0 ? r7.contentDescription : null, (r28 & 512) != 0 ? r7.viewId : magicText[1], (r28 & 1024) != 0 ? r7.blocking : false, (r28 & 2048) != 0 ? r7.returnVariable : null, (r28 & 4096) != 0 ? ((UiInteractionConfiguration.Click) uiInteractionConfiguration).checkOverlays : false);
                this.uiInteractionConfiguration = copy;
            }
        } else if (magicText.length == 1 && (uiInteractionConfiguration instanceof UiInteractionConfiguration.Paste)) {
            this.uiInteractionConfiguration = UiInteractionConfiguration.Paste.copy$default((UiInteractionConfiguration.Paste) uiInteractionConfiguration, false, false, magicText[0], 3, null);
        }
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setUiInteractionResultCache(@NotNull UIInteractionResultCache uIInteractionResultCache) {
        Intrinsics.checkNotNullParameter(uIInteractionResultCache, "<set-?>");
        this.uiInteractionResultCache = uIInteractionResultCache;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        UiInteractionConfiguration uiInteractionConfiguration = this.uiInteractionConfiguration;
        if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
            if (varNames.length == 2) {
                Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click");
                UiInteractionConfiguration.Click click = (UiInteractionConfiguration.Click) uiInteractionConfiguration;
                this.uiInteractionConfiguration = new UiInteractionConfiguration.Click(click.getClickOption(), click.getLongClick(), click.getXyPoint(), false, varNames[0], varNames[1], click.getTextContent(), 0, click.getContentDescription(), click.getViewId(), click.getBlocking(), click.getReturnVariable(), false, 4096, null);
            }
        } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Gesture) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.Gesture");
            UiInteractionConfiguration.Gesture gesture = (UiInteractionConfiguration.Gesture) uiInteractionConfiguration;
            this.uiInteractionConfiguration = new UiInteractionConfiguration.Gesture(gesture.getStartX(), gesture.getStartY(), gesture.getEndX(), gesture.getEndY(), gesture.getXyPercentages(), gesture.getDurationMs(), varNames[0], varNames[1], varNames[2], varNames[3], varNames[4], gesture.getWaitBeforeNext());
        } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.GestureSequence) {
            Intrinsics.checkNotNull(uiInteractionConfiguration, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.UiInteractionConfiguration.GestureSequence");
            UiInteractionConfiguration.GestureSequence gestureSequence = (UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration;
            List<UiInteractionConfiguration.GestureEntry> gestures = gestureSequence.getGestures();
            ArrayList arrayList = new ArrayList();
            if (varNames.length != (gestures.size() * 2) + 3) {
                int length = varNames.length;
                SystemLog.logError("Unexepected length when updating variable names. Expected: " + (gestures.size() + 3) + ", Got: " + length);
                return;
            }
            int size = gestures.size() - 1;
            if (size >= 0) {
                int i4 = 0;
                while (true) {
                    UiInteractionConfiguration.GestureEntry gestureEntry = gestures.get(i4);
                    int i5 = i4 * 2;
                    arrayList.add(new UiInteractionConfiguration.GestureEntry(gestureEntry.getEndX(), gestureEntry.getEndY(), varNames[i5 + 3], varNames[i5 + 4]));
                    if (i4 == size) {
                        break;
                    }
                    i4++;
                }
            }
            this.uiInteractionConfiguration = new UiInteractionConfiguration.GestureSequence(gestureSequence.getStartX(), gestureSequence.getStartY(), gestureSequence.getXyPercentages(), gestureSequence.getDurationMs(), varNames[0], varNames[1], varNames[2], gestureSequence.getWaitBeforeNext(), arrayList);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeParcelable(this.uiInteractionConfiguration, i4);
        out.writeInt(this.action);
    }

    public UIInteractionAction() {
        init();
    }

    public UIInteractionAction(@Nullable Activity activity, @Nullable Macro macro) {
        init();
        setActivity(activity);
        this.m_macro = macro;
    }

    private UIInteractionAction(Parcel parcel) {
        super(parcel);
        init();
        this.uiInteractionConfiguration = (UiInteractionConfiguration) parcel.readParcelable(UiInteractionConfiguration.class.getClassLoader());
        this.action = parcel.readInt();
    }

    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String[] a() {
            String r4 = SelectableItem.r(R.string.ui_interaction_current_focus);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.ui_interaction_current_focus)");
            String r5 = SelectableItem.r(R.string.ui_interaction_by_text_context);
            Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.ui_interaction_by_text_context)");
            String r6 = SelectableItem.r(R.string.ui_interaction_by_x_y_location);
            Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.ui_interaction_by_x_y_location)");
            String r7 = SelectableItem.r(R.string.ui_interaction_select_in_app);
            Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.ui_interaction_select_in_app)");
            String r8 = SelectableItem.r(R.string.ui_interaction_view_id);
            Intrinsics.checkNotNullExpressionValue(r8, "getString(R.string.ui_interaction_view_id)");
            return new String[]{r4, r5, r6, r7, r8};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final UIInteractionOption[] b() {
            String r4 = SelectableItem.r(R.string.ui_interaction_click);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.ui_interaction_click)");
            String r5 = SelectableItem.r(R.string.ui_interaction_long_click);
            Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.ui_interaction_long_click)");
            String r6 = SelectableItem.r(R.string.ui_interaction_copy);
            Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.ui_interaction_copy)");
            String r7 = SelectableItem.r(R.string.ui_interaction_cut);
            Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.ui_interaction_cut)");
            String r8 = SelectableItem.r(R.string.ui_interaction_paste);
            Intrinsics.checkNotNullExpressionValue(r8, "getString(R.string.ui_interaction_paste)");
            String r9 = SelectableItem.r(R.string.ui_interaction_clear_selection);
            Intrinsics.checkNotNullExpressionValue(r9, "getString(R.string.ui_interaction_clear_selection)");
            String r10 = SelectableItem.r(R.string.ui_interaction_perform_gesture);
            Intrinsics.checkNotNullExpressionValue(r10, "getString(R.string.ui_interaction_perform_gesture)");
            String r11 = SelectableItem.r(R.string.ui_interaction_perform_gesture_sequence);
            Intrinsics.checkNotNullExpressionValue(r11, "getString(R.string.ui_in…perform_gesture_sequence)");
            String r12 = SelectableItem.r(R.string.ui_interaction_press_enter);
            Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.ui_interaction_press_enter)");
            return new UIInteractionOption[]{new UIInteractionOption(0, r4, 0), new UIInteractionOption(1, r5, 0), new UIInteractionOption(2, r6, 0), new UIInteractionOption(3, r7, 0), new UIInteractionOption(4, r8, 0), new UIInteractionOption(5, r9, 0), new UIInteractionOption(6, r10, 24), new UIInteractionOption(7, r11, 24), new UIInteractionOption(8, r12, 30)};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
