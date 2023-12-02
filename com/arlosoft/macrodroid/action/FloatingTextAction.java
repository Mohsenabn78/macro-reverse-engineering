package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.FloatingTextAction;
import com.arlosoft.macrodroid.action.info.FloatingTextActionInfo;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.FloatingTextService;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatingTextAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nFloatingTextAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingTextAction.kt\ncom/arlosoft/macrodroid/action/FloatingTextAction\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,611:1\n262#2,2:612\n262#2,2:652\n177#2,2:654\n65#3,16:614\n93#3,3:630\n65#3,16:633\n93#3,3:649\n*S KotlinDebug\n*F\n+ 1 FloatingTextAction.kt\ncom/arlosoft/macrodroid/action/FloatingTextAction\n*L\n221#1:612,2\n291#1:652,2\n340#1:654,2\n278#1:614,16\n278#1:630,3\n281#1:633,16\n281#1:649,3\n*E\n"})
/* loaded from: classes2.dex */
public final class FloatingTextAction extends Action implements SupportsMagicText {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    private static final int DEFAULT_CORNERS = 12;
    private static final int DEFAULT_PADDING = 8;
    private static final int DEFAULT_TEXT_SIZE = 14;
    private static final int MIN_TEXT_SIZE = 6;
    private static final int OPTION_HIDE = 1;
    private static final int OPTION_HIDE_ALL = 2;
    private static final int OPTION_SHOW = 0;
    private int alignment;
    private int alpha;
    private boolean autoHideAfterDelay;
    private int autoHideSeconds;
    private int bgColor;
    private transient int bgColorDuringConfig;
    private int corners;
    private transient int cornersDuringConfig;
    private boolean htmlFormattingEnabled;
    @NotNull
    private String identifier;
    private boolean isInitialised;
    private int option;
    private int padding;
    private boolean preventRemoveByDrag;
    private boolean showOverStatusBar;
    private int textColor;
    private transient int textColorDuringConfig;
    private int textSize;
    @NotNull
    private String textToDisplay;
    private boolean updateLocation;
    private float xPosition;
    private float yPosition;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<FloatingTextAction> CREATOR = new Parcelable.Creator<FloatingTextAction>() { // from class: com.arlosoft.macrodroid.action.FloatingTextAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FloatingTextAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FloatingTextAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FloatingTextAction[] newArray(int i4) {
            return new FloatingTextAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $previewText;
        final /* synthetic */ EditText $text;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(TextView textView, EditText editText, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$previewText = textView;
            this.$text = editText;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$previewText, this.$text, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
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
                FloatingTextAction.this.e0(this.$previewText, this.$text.getText().toString(), this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class c extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ EditText $autoHideDelayEditText;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(EditText editText, Continuation<? super c> continuation) {
            super(4, continuation);
            this.$autoHideDelayEditText = editText;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            c cVar = new c(this.$autoHideDelayEditText, continuation);
            cVar.Z$0 = z3;
            return cVar.invokeSuspend(Unit.INSTANCE);
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
                this.$autoHideDelayEditText.setEnabled(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageButton $alignCenterButton;
        final /* synthetic */ ImageButton $alignLeftButton;
        final /* synthetic */ ImageButton $alignRightButton;
        final /* synthetic */ TextView $previewText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, TextView textView, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$alignLeftButton = imageButton;
            this.$alignCenterButton = imageButton2;
            this.$alignRightButton = imageButton3;
            this.$previewText = textView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$alignLeftButton, this.$alignCenterButton, this.$alignRightButton, this.$previewText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$alignLeftButton.setSelected(true);
                this.$alignCenterButton.setSelected(false);
                this.$alignRightButton.setSelected(false);
                this.$previewText.setGravity(3);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageButton $alignCenterButton;
        final /* synthetic */ ImageButton $alignLeftButton;
        final /* synthetic */ ImageButton $alignRightButton;
        final /* synthetic */ TextView $previewText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, TextView textView, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$alignCenterButton = imageButton;
            this.$alignLeftButton = imageButton2;
            this.$alignRightButton = imageButton3;
            this.$previewText = textView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$alignCenterButton, this.$alignLeftButton, this.$alignRightButton, this.$previewText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$alignCenterButton.setSelected(true);
                this.$alignLeftButton.setSelected(false);
                this.$alignRightButton.setSelected(false);
                this.$previewText.setGravity(1);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageButton $alignCenterButton;
        final /* synthetic */ ImageButton $alignLeftButton;
        final /* synthetic */ ImageButton $alignRightButton;
        final /* synthetic */ TextView $previewText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, TextView textView, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$alignLeftButton = imageButton;
            this.$alignCenterButton = imageButton2;
            this.$alignRightButton = imageButton3;
            this.$previewText = textView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$alignLeftButton, this.$alignCenterButton, this.$alignRightButton, this.$previewText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$alignLeftButton.setSelected(false);
                this.$alignCenterButton.setSelected(false);
                this.$alignRightButton.setSelected(true);
                this.$previewText.setGravity(5);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    @SourceDebugExtension({"SMAP\nFloatingTextAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingTextAction.kt\ncom/arlosoft/macrodroid/action/FloatingTextAction$configureFloatingText$6\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,611:1\n262#2,2:612\n262#2,2:614\n*S KotlinDebug\n*F\n+ 1 FloatingTextAction.kt\ncom/arlosoft/macrodroid/action/FloatingTextAction$configureFloatingText$6\n*L\n250#1:612,2\n251#1:614,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class g extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $identifierLayout;
        final /* synthetic */ EditText $identifierTextView;
        final /* synthetic */ Button $okButton;
        final /* synthetic */ ViewGroup $showConfigLayout;
        final /* synthetic */ EditText $text;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(ViewGroup viewGroup, ViewGroup viewGroup2, Button button, EditText editText, EditText editText2, Continuation<? super g> continuation) {
            super(4, continuation);
            this.$showConfigLayout = viewGroup;
            this.$identifierLayout = viewGroup2;
            this.$okButton = button;
            this.$identifierTextView = editText;
            this.$text = editText2;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            g gVar = new g(this.$showConfigLayout, this.$identifierLayout, this.$okButton, this.$identifierTextView, this.$text, continuation);
            gVar.Z$0 = z3;
            return gVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            boolean z4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.Z$0) {
                    boolean z5 = false;
                    this.$showConfigLayout.setVisibility(0);
                    this.$identifierLayout.setVisibility(0);
                    Button button = this.$okButton;
                    Editable text = this.$identifierTextView.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "identifierTextView.text");
                    if (text.length() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        Editable text2 = this.$text.getText();
                        Intrinsics.checkNotNullExpressionValue(text2, "text.text");
                        if (text2.length() > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            z5 = true;
                        }
                    }
                    button.setEnabled(z5);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    @SourceDebugExtension({"SMAP\nFloatingTextAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingTextAction.kt\ncom/arlosoft/macrodroid/action/FloatingTextAction$configureFloatingText$7\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,611:1\n262#2,2:612\n262#2,2:614\n*S KotlinDebug\n*F\n+ 1 FloatingTextAction.kt\ncom/arlosoft/macrodroid/action/FloatingTextAction$configureFloatingText$7\n*L\n257#1:612,2\n258#1:614,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class h extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $identifierLayout;
        final /* synthetic */ EditText $identifierTextView;
        final /* synthetic */ Button $okButton;
        final /* synthetic */ ViewGroup $showConfigLayout;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(ViewGroup viewGroup, ViewGroup viewGroup2, Button button, EditText editText, Continuation<? super h> continuation) {
            super(4, continuation);
            this.$showConfigLayout = viewGroup;
            this.$identifierLayout = viewGroup2;
            this.$okButton = button;
            this.$identifierTextView = editText;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            h hVar = new h(this.$showConfigLayout, this.$identifierLayout, this.$okButton, this.$identifierTextView, continuation);
            hVar.Z$0 = z3;
            return hVar.invokeSuspend(Unit.INSTANCE);
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
                    this.$showConfigLayout.setVisibility(8);
                    boolean z3 = false;
                    this.$identifierLayout.setVisibility(0);
                    Button button = this.$okButton;
                    Editable text = this.$identifierTextView.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "identifierTextView.text");
                    if (text.length() > 0) {
                        z3 = true;
                    }
                    button.setEnabled(z3);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    @SourceDebugExtension({"SMAP\nFloatingTextAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingTextAction.kt\ncom/arlosoft/macrodroid/action/FloatingTextAction$configureFloatingText$8\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,611:1\n262#2,2:612\n262#2,2:614\n*S KotlinDebug\n*F\n+ 1 FloatingTextAction.kt\ncom/arlosoft/macrodroid/action/FloatingTextAction$configureFloatingText$8\n*L\n264#1:612,2\n265#1:614,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class i extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $identifierLayout;
        final /* synthetic */ Button $okButton;
        final /* synthetic */ ViewGroup $showConfigLayout;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(ViewGroup viewGroup, ViewGroup viewGroup2, Button button, Continuation<? super i> continuation) {
            super(4, continuation);
            this.$showConfigLayout = viewGroup;
            this.$identifierLayout = viewGroup2;
            this.$okButton = button;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            i iVar = new i(this.$showConfigLayout, this.$identifierLayout, this.$okButton, continuation);
            iVar.Z$0 = z3;
            return iVar.invokeSuspend(Unit.INSTANCE);
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
                    this.$showConfigLayout.setVisibility(8);
                    this.$identifierLayout.setVisibility(8);
                    this.$okButton.setEnabled(true);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ FloatingTextAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x041f, code lost:
        if (r0 != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x042c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void U() {
        /*
            Method dump skipped, instructions count: 1481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.FloatingTextAction.U():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(final FloatingTextAction this$0, Activity activity, final MaterialCardView bgColorCircle, final MaterialCardView textColorCircle, final TextView previewText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bgColorCircle, "$bgColorCircle");
        Intrinsics.checkNotNullParameter(textColorCircle, "$textColorCircle");
        Intrinsics.checkNotNullParameter(previewText, "$previewText");
        int[] intArray = this$0.getContext().getResources().getIntArray(R.array.toast_colors);
        Intrinsics.checkNotNullExpressionValue(intArray, "context.resources.getInt…ray(R.array.toast_colors)");
        ColorPickerDialog create = ColorPickerDialog.newBuilder().setColor(this$0.bgColorDuringConfig).setDialogType(1).setPresets(intArray).setAllowCustom(true).setShowAlphaSlider(true).setAllowPresets(false).create();
        create.setColorPickerDialogListener(new ColorPickerDialogListener() { // from class: com.arlosoft.macrodroid.action.FloatingTextAction$configureFloatingText$backgroundColorListener$1$1
            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onColorSelected(int i4, int i5) {
                int i6;
                int i7;
                int i8;
                int i9;
                FloatingTextAction.this.bgColorDuringConfig = i5;
                MaterialCardView materialCardView = bgColorCircle;
                i6 = FloatingTextAction.this.bgColorDuringConfig;
                materialCardView.setCardBackgroundColor(i6);
                MaterialCardView materialCardView2 = textColorCircle;
                i7 = FloatingTextAction.this.textColorDuringConfig;
                materialCardView2.setCardBackgroundColor(i7);
                FloatingTextAction floatingTextAction = FloatingTextAction.this;
                TextView textView = previewText;
                i8 = floatingTextAction.cornersDuringConfig;
                i9 = FloatingTextAction.this.bgColorDuringConfig;
                floatingTextAction.d0(textView, i8, i9);
            }

            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onDialogDismissed(int i4) {
            }
        });
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        create.show(((FragmentActivity) activity).getSupportFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final FloatingTextAction this$0, Activity activity, final MaterialCardView bgColorCircle, final MaterialCardView textColorCircle, final TextView previewText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bgColorCircle, "$bgColorCircle");
        Intrinsics.checkNotNullParameter(textColorCircle, "$textColorCircle");
        Intrinsics.checkNotNullParameter(previewText, "$previewText");
        int[] intArray = this$0.getContext().getResources().getIntArray(R.array.toast_colors);
        Intrinsics.checkNotNullExpressionValue(intArray, "context.resources.getInt…ray(R.array.toast_colors)");
        ColorPickerDialog create = ColorPickerDialog.newBuilder().setColor(this$0.textColorDuringConfig).setDialogType(1).setPresets(intArray).setAllowCustom(true).setShowAlphaSlider(true).setAllowPresets(false).create();
        create.setColorPickerDialogListener(new ColorPickerDialogListener() { // from class: com.arlosoft.macrodroid.action.FloatingTextAction$configureFloatingText$textColorListener$1$1
            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onColorSelected(int i4, int i5) {
                int i6;
                int i7;
                FloatingTextAction.this.textColorDuringConfig = i5;
                MaterialCardView materialCardView = bgColorCircle;
                i6 = FloatingTextAction.this.bgColorDuringConfig;
                materialCardView.setCardBackgroundColor(i6);
                MaterialCardView materialCardView2 = textColorCircle;
                i7 = FloatingTextAction.this.textColorDuringConfig;
                materialCardView2.setCardBackgroundColor(i7);
                previewText.setTextColor(i5);
            }

            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onDialogDismissed(int i4) {
            }
        });
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        create.show(((FragmentActivity) activity).getSupportFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(EditText identifierTextView, MagicText.MagicTextPair pair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(identifierTextView, "$identifierTextView");
        Intrinsics.checkNotNullParameter(pair, "pair");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(identifierTextView.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(identifierTextView.getSelectionEnd(), 0);
        Editable text = identifierTextView.getText();
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
        coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
        String str = pair.magicText;
        text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(FloatingTextAction this$0, MagicText.MagicTextListener magicTextIdentifierListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextIdentifierListener, "$magicTextIdentifierListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), magicTextIdentifierListener, this$0.getMacro(), false, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(EditText text, MagicText.MagicTextPair pair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(text, "$text");
        Intrinsics.checkNotNullParameter(pair, "pair");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(text.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(text.getSelectionEnd(), 0);
        Editable text2 = text.getText();
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
        coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
        String str = pair.magicText;
        text2.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(FloatingTextAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), magicTextListener, this$0.getMacro(), true, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AppCompatDialog dialog, FloatingTextAction this$0, RadioButton showRadioButton, RadioButton hideRadioButton, SeekBar textSizeSeekBar, SeekBar alphaSeekBar, SeekBar paddingSeekBar, EditText text, EditText identifierTextView, SeekBar horizontalPosSeekBar, SeekBar verticalPosSeekBar, CheckBox forceLocationCheckBox, CheckBox htmlFormattingCheckBox, CheckBox showOverStatusBarCheckBox, CheckBox preventRemoveByDragCheckbox, ImageButton alignLeftButton, ImageButton alignRightButton, CheckBox autoHideAfterDelayCheckBox, EditText autoHideDelayEditText, View view) {
        int i4;
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(showRadioButton, "$showRadioButton");
        Intrinsics.checkNotNullParameter(hideRadioButton, "$hideRadioButton");
        Intrinsics.checkNotNullParameter(textSizeSeekBar, "$textSizeSeekBar");
        Intrinsics.checkNotNullParameter(alphaSeekBar, "$alphaSeekBar");
        Intrinsics.checkNotNullParameter(paddingSeekBar, "$paddingSeekBar");
        Intrinsics.checkNotNullParameter(text, "$text");
        Intrinsics.checkNotNullParameter(identifierTextView, "$identifierTextView");
        Intrinsics.checkNotNullParameter(horizontalPosSeekBar, "$horizontalPosSeekBar");
        Intrinsics.checkNotNullParameter(verticalPosSeekBar, "$verticalPosSeekBar");
        Intrinsics.checkNotNullParameter(forceLocationCheckBox, "$forceLocationCheckBox");
        Intrinsics.checkNotNullParameter(htmlFormattingCheckBox, "$htmlFormattingCheckBox");
        Intrinsics.checkNotNullParameter(showOverStatusBarCheckBox, "$showOverStatusBarCheckBox");
        Intrinsics.checkNotNullParameter(preventRemoveByDragCheckbox, "$preventRemoveByDragCheckbox");
        Intrinsics.checkNotNullParameter(alignLeftButton, "$alignLeftButton");
        Intrinsics.checkNotNullParameter(alignRightButton, "$alignRightButton");
        Intrinsics.checkNotNullParameter(autoHideAfterDelayCheckBox, "$autoHideAfterDelayCheckBox");
        Intrinsics.checkNotNullParameter(autoHideDelayEditText, "$autoHideDelayEditText");
        dialog.dismiss();
        int i5 = 1;
        this$0.option = showRadioButton.isChecked() ? 0 : hideRadioButton.isChecked() ? 1 : 2;
        this$0.textSize = textSizeSeekBar.getProgress() + 6;
        this$0.alpha = alphaSeekBar.getProgress();
        this$0.padding = paddingSeekBar.getProgress();
        this$0.textToDisplay = text.getText().toString();
        this$0.identifier = identifierTextView.getText().toString();
        this$0.bgColor = this$0.bgColorDuringConfig;
        this$0.textColor = this$0.textColorDuringConfig;
        this$0.xPosition = horizontalPosSeekBar.getProgress() / 100.0f;
        this$0.yPosition = verticalPosSeekBar.getProgress() / 100.0f;
        this$0.isInitialised = true;
        this$0.updateLocation = forceLocationCheckBox.isChecked();
        this$0.corners = this$0.cornersDuringConfig;
        this$0.htmlFormattingEnabled = htmlFormattingCheckBox.isChecked();
        this$0.showOverStatusBar = showOverStatusBarCheckBox.isChecked();
        this$0.preventRemoveByDrag = preventRemoveByDragCheckbox.isChecked();
        if (!alignLeftButton.isSelected()) {
            i5 = alignRightButton.isSelected() ? 2 : 0;
        }
        this$0.alignment = i5;
        this$0.autoHideAfterDelay = autoHideAfterDelayCheckBox.isChecked();
        try {
            Integer valueOf = Integer.valueOf(autoHideDelayEditText.getText().toString());
            Intrinsics.checkNotNullExpressionValue(valueOf, "{\n                Intege…toString())\n            }");
            i4 = valueOf.intValue();
        } catch (Exception unused) {
            i4 = 0;
        }
        this$0.autoHideSeconds = i4;
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(TextView textView, int i4, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(IntExtensionsKt.getPx(i4));
        gradientDrawable.setColor(i5);
        textView.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(TextView textView, String str, boolean z3) {
        boolean z4;
        String replace$default;
        if (str.length() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            textView.setText(SelectableItem.r(R.string.text));
            return;
        }
        String replaceMagicText = MagicText.replaceMagicText(MacroDroidApplication.Companion.getInstance(), str, null, getMacro());
        Intrinsics.checkNotNullExpressionValue(replaceMagicText, "replaceMagicText(instance, text, null, macro)");
        replace$default = kotlin.text.m.replace$default(replaceMagicText, "\\n", "\n", false, 4, (Object) null);
        Spanned spanned = replace$default;
        if (z3) {
            spanned = Html.fromHtml(replace$default);
        }
        textView.setText(spanned);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        int i4 = this.option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return this.identifier;
                }
                String r4 = SelectableItem.r(R.string.action_floating_text_option_hide_all);
                Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.actio…ing_text_option_hide_all)");
                return r4;
            }
            String r5 = SelectableItem.r(R.string.action_floating_text_option_hide);
            String str = this.identifier;
            return r5 + " (" + str + ")";
        }
        String str2 = this.identifier;
        String str3 = this.textToDisplay;
        return str2 + ": " + str3;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return FloatingTextActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.identifier, this.textToDisplay};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        U();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        int i4 = this.option;
        if (i4 == 2) {
            MacroStore.getInstance().removeAllFloatingTextInstances();
            Database.getInstance().hideAllFloatingTexts();
        } else if (i4 == 1) {
            String replaceMagicText = MagicText.replaceMagicText(getContext(), this.identifier, triggerContextInfo, getMacro());
            if (getMacro() instanceof ActionBlock) {
                MacroStore macroStore = MacroStore.getInstance();
                Long macroGuid = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                macroStore.removeFloatingTextInstance(macroGuid.longValue());
            }
            Database.getInstance().hideFloatingText(replaceMagicText);
        } else if (i4 == 0) {
            String replaceMagicText2 = MagicText.replaceMagicText(getContext(), this.identifier, triggerContextInfo, getMacro());
            if (getMacro() instanceof ActionBlock) {
                MacroStore.getInstance().saveFloatingTextInstance(getMacro());
            }
            Database database = Database.getInstance();
            String str = this.textToDisplay;
            float f4 = this.xPosition;
            float f5 = this.yPosition;
            int i5 = this.textColor;
            int i6 = this.bgColor;
            int i7 = this.padding;
            int i8 = this.textSize;
            int i9 = this.corners;
            int i10 = this.alignment;
            int i11 = this.alpha;
            boolean z3 = this.updateLocation;
            Long macroGuid2 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
            database.configureFloatingText(replaceMagicText2, str, f4, f5, i5, i6, i7, i8, i9, i10, i11, true, z3, macroGuid2.longValue(), this.autoHideAfterDelay, this.autoHideSeconds, this.htmlFormattingEnabled, this.showOverStatusBar, this.preventRemoveByDrag, triggerContextInfo);
        }
        FloatingTextService.Companion companion = FloatingTextService.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.refreshTextViews(context);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 2) {
            this.identifier = magicText[0];
            this.textToDisplay = magicText[1];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeInt(this.bgColor);
        out.writeInt(this.textColor);
        out.writeInt(this.alpha);
        out.writeInt(this.updateLocation ? 1 : 0);
        out.writeFloat(this.xPosition);
        out.writeFloat(this.yPosition);
        out.writeInt(this.padding);
        out.writeString(this.identifier);
        out.writeString(this.textToDisplay);
        out.writeInt(this.isInitialised ? 1 : 0);
        out.writeInt(this.textSize);
        out.writeInt(this.corners);
        out.writeInt(this.alignment);
        out.writeInt(this.autoHideAfterDelay ? 1 : 0);
        out.writeInt(this.autoHideSeconds);
        out.writeInt(this.htmlFormattingEnabled ? 1 : 0);
        out.writeInt(this.showOverStatusBar ? 1 : 0);
        out.writeInt(this.preventRemoveByDrag ? 1 : 0);
    }

    public FloatingTextAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public FloatingTextAction() {
        this.identifier = "";
        this.textToDisplay = "";
        this.bgColor = -16777216;
        this.textColor = -1;
        this.alpha = 100;
        this.corners = 12;
        this.xPosition = 0.5f;
        this.yPosition = 0.5f;
        this.padding = 8;
        this.textSize = 14;
    }

    private FloatingTextAction(Parcel parcel) {
        super(parcel);
        this.identifier = "";
        this.textToDisplay = "";
        this.bgColor = -16777216;
        this.textColor = -1;
        this.alpha = 100;
        this.corners = 12;
        this.xPosition = 0.5f;
        this.yPosition = 0.5f;
        this.padding = 8;
        this.textSize = 14;
        this.option = parcel.readInt();
        this.bgColor = parcel.readInt();
        this.textColor = parcel.readInt();
        this.alpha = parcel.readInt();
        this.updateLocation = parcel.readInt() != 0;
        this.xPosition = parcel.readFloat();
        this.yPosition = parcel.readFloat();
        this.padding = parcel.readInt();
        String readString = parcel.readString();
        this.identifier = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.textToDisplay = readString2 != null ? readString2 : "";
        this.isInitialised = parcel.readInt() != 0;
        this.textSize = parcel.readInt();
        this.corners = parcel.readInt();
        this.alignment = parcel.readInt();
        this.autoHideAfterDelay = parcel.readInt() != 0;
        this.autoHideSeconds = parcel.readInt();
        this.htmlFormattingEnabled = parcel.readInt() != 0;
        this.showOverStatusBar = parcel.readInt() != 0;
        this.preventRemoveByDrag = parcel.readInt() != 0;
    }

    /* compiled from: FloatingTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ CheckBox $showOverStatusBarCheckBox;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, CheckBox checkBox, Continuation<? super b> continuation) {
            super(4, continuation);
            this.$activity = activity;
            this.$showOverStatusBarCheckBox = checkBox;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(CheckBox checkBox, DialogInterface dialogInterface, int i4) {
            checkBox.setChecked(false);
        }

        @Nullable
        public final Object c(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            b bVar = new b(this.$activity, this.$showOverStatusBarCheckBox, continuation);
            bVar.Z$0 = z3;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return c(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.Z$0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.$activity, R.style.Theme_App_Dialog_Action);
                    AlertDialog.Builder positiveButton = builder.setMessage(SelectableItem.r(R.string.floating_text_toggle_option_show_in_status_bar_warning)).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.e7
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            FloatingTextAction.b.e(dialogInterface, i4);
                        }
                    });
                    final CheckBox checkBox = this.$showOverStatusBarCheckBox;
                    positiveButton.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.f7
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            FloatingTextAction.b.f(checkBox, dialogInterface, i4);
                        }
                    });
                    AlertDialog create = builder.create();
                    Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
                    create.show();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(DialogInterface dialogInterface, int i4) {
        }
    }
}
