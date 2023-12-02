package com.arlosoft.macrodroid;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockConfigDialog;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.extensions.DrawableExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.ShortcutTrigger;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.triggers.receivers.InvokeMacroReceiver;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import com.google.android.material.card.MaterialCardView;
import com.thebluealliance.spectrum.SpectrumDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShortcutActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nShortcutActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShortcutActivity.kt\ncom/arlosoft/macrodroid/ShortcutActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,391:1\n262#2,2:392\n*S KotlinDebug\n*F\n+ 1 ShortcutActivity.kt\ncom/arlosoft/macrodroid/ShortcutActivity\n*L\n279#1:392,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ShortcutActivity extends MacroDroidDialogDaggerBaseActivity {
    @NotNull
    public static final String EXTRA_PICK_ICON = "extra_pick_icon";

    /* renamed from: d  reason: collision with root package name */
    private int f2021d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f2022e = BuildConfig.APPLICATION_ID;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f2023f = "";
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Uri f2024g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private ImageView f2025h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2026i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Drawable f2027j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Drawable f2028k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private CheckBox f2029l;
    @Inject
    @JvmField
    @Nullable
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    @JvmField
    @Nullable
    public RemoteConfig remoteConfig;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ShortcutActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(21)
        public final Bitmap a(VectorDrawable vectorDrawable) {
            Bitmap createBitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(vectorDrawa… Bitmap.Config.ARGB_8888)");
            Canvas canvas = new Canvas(createBitmap);
            vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            vectorDrawable.draw(canvas);
            return createBitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShortcutActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<ActionBlockData, Unit> {
        final /* synthetic */ ActionBlock $actionBlock;
        final /* synthetic */ boolean $pickIcon;
        final /* synthetic */ ShortcutActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z3, ShortcutActivity shortcutActivity, ActionBlock actionBlock) {
            super(1);
            this.$pickIcon = z3;
            this.this$0 = shortcutActivity;
            this.$actionBlock = actionBlock;
        }

        public final void a(@Nullable ActionBlockData actionBlockData) {
            if (this.$pickIcon) {
                this.this$0.w(this.$actionBlock, actionBlockData);
                return;
            }
            ShortcutActivity shortcutActivity = this.this$0;
            ActionBlock actionBlock = this.$actionBlock;
            String name = actionBlock.getName();
            Intrinsics.checkNotNullExpressionValue(name, "actionBlock.name");
            shortcutActivity.r(actionBlock, name, null, actionBlockData);
            this.this$0.finish();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActionBlockData actionBlockData) {
            a(actionBlockData);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShortcutActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageView $icon;
        final /* synthetic */ Ref.IntRef $tintColor;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImageView imageView, Ref.IntRef intRef, Continuation<? super b> continuation) {
            super(4, continuation);
            this.$icon = imageView;
            this.$tintColor = intRef;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            b bVar = new b(this.$icon, this.$tintColor, continuation);
            bVar.Z$0 = z3;
            return bVar.invokeSuspend(Unit.INSTANCE);
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
                boolean z3 = this.Z$0;
                Drawable drawable = ShortcutActivity.this.f2028k;
                if (drawable != null) {
                    ImageView imageView = this.$icon;
                    Ref.IntRef intRef = this.$tintColor;
                    ShortcutActivity shortcutActivity = ShortcutActivity.this;
                    if (z3) {
                        imageView.setImageDrawable(DrawableExtensionsKt.tint(drawable, intRef.element));
                    } else {
                        imageView.setImageDrawable(shortcutActivity.f2027j);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ShortcutActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivityForResult(new Intent(this$0, IconSelectActivity.class), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
        if (r2.isChecked() == true) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void B(androidx.appcompat.app.AppCompatDialog r2, android.widget.ImageView r3, com.arlosoft.macrodroid.ShortcutActivity r4, kotlin.jvm.internal.Ref.IntRef r5, com.arlosoft.macrodroid.macro.Macro r6, com.arlosoft.macrodroid.actionblock.common.ActionBlockData r7, android.view.View r8) {
        /*
            java.lang.String r8 = "$dialog"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r8)
            java.lang.String r8 = "$icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r8)
            java.lang.String r8 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r8)
            java.lang.String r8 = "$tintColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
            r2.dismiss()
            android.graphics.drawable.Drawable r2 = r3.getDrawable()
            boolean r2 = r2 instanceof android.graphics.drawable.VectorDrawable
            r8 = 0
            r0 = 0
            if (r2 == 0) goto L34
            com.arlosoft.macrodroid.ShortcutActivity$Companion r2 = com.arlosoft.macrodroid.ShortcutActivity.Companion
            android.graphics.drawable.Drawable r3 = r3.getDrawable()
            java.lang.String r5 = "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)
            android.graphics.drawable.VectorDrawable r3 = (android.graphics.drawable.VectorDrawable) r3
            android.graphics.Bitmap r2 = com.arlosoft.macrodroid.ShortcutActivity.Companion.access$getBitmap(r2, r3)
            goto L67
        L34:
            android.widget.CheckBox r2 = r4.f2029l
            if (r2 == 0) goto L40
            boolean r2 = r2.isChecked()
            r1 = 1
            if (r2 != r1) goto L40
            goto L41
        L40:
            r1 = 0
        L41:
            if (r1 == 0) goto L5f
            android.graphics.drawable.Drawable r2 = r3.getDrawable()
            if (r2 == 0) goto L5d
            android.graphics.drawable.Drawable r2 = r3.getDrawable()
            android.graphics.Bitmap r2 = com.arlosoft.macrodroid.utils.DrawableUtils.getBitmapFromDrawable(r2)
            java.lang.String r3 = "getBitmapFromDrawable(icon.drawable)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            int r3 = r5.element
            android.graphics.Bitmap r2 = r4.s(r2, r3)
            goto L67
        L5d:
            r2 = r8
            goto L67
        L5f:
            android.graphics.drawable.Drawable r2 = r3.getDrawable()
            android.graphics.Bitmap r2 = com.arlosoft.macrodroid.utils.DrawableUtils.getBitmapFromDrawable(r2)
        L67:
            if (r2 == 0) goto L7b
            int r3 = r2.getWidth()
            r5 = 192(0xc0, float:2.69E-43)
            if (r3 > r5) goto L77
            int r3 = r2.getHeight()
            if (r3 <= r5) goto L7b
        L77:
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r5, r5, r0)
        L7b:
            if (r6 != 0) goto L80
            java.lang.String r3 = ""
            goto L91
        L80:
            java.lang.String r3 = r6.getName()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L8d
            java.lang.String r3 = " "
            goto L91
        L8d:
            java.lang.String r3 = r6.getName()
        L91:
            java.lang.String r5 = "shortcutName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            r4.r(r6, r3, r2, r7)
            r4.f2025h = r8
            r4.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.ShortcutActivity.B(androidx.appcompat.app.AppCompatDialog, android.widget.ImageView, com.arlosoft.macrodroid.ShortcutActivity, kotlin.jvm.internal.Ref$IntRef, com.arlosoft.macrodroid.macro.Macro, com.arlosoft.macrodroid.actionblock.common.ActionBlockData, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AppCompatDialog dialog, ShortcutActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.cancel();
        this$0.f2025h = null;
        this$0.finish();
    }

    private final void q(ActionBlock actionBlock, boolean z3) {
        String name = actionBlock.getName();
        Intrinsics.checkNotNullExpressionValue(name, "actionBlock.name");
        ActionBlockConfigDialog.displayConfigurationDialog(this, actionBlock, new ActionBlockData(name, actionBlock.getGUID(), new HashMap(), new HashMap()), null, new a(z3, this, actionBlock));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Macro macro, String str, Bitmap bitmap, ActionBlockData actionBlockData) {
        String str2;
        HashMap<String, String> inputVarsMap;
        Collection<String> values;
        HashMap<String, String> inputVarsMap2;
        Set<String> keySet;
        String str3 = null;
        if (this.f2026i) {
            Intent intent = new Intent(this, ShortcutDispatchActivity.class);
            intent.setAction("android.intent.action.MAIN");
            Intrinsics.checkNotNull(macro);
            intent.putExtra("com.arlosoft.macrodroid.MACRO_NAME", macro.getName());
            intent.putExtra(Util.EXTRA_GUID, macro.getGUID());
            intent.putExtra(Util.EXTRA_IS_ACTION_BLOCK, macro.isActionBlock);
            intent.addFlags(268435456);
            intent.addFlags(67141632);
            ShortcutInfoCompat.Builder intent2 = new ShortcutInfoCompat.Builder(this, str + UUID.randomUUID().getLeastSignificantBits()).setShortLabel(str).setIntent(intent);
            Intrinsics.checkNotNullExpressionValue(intent2, "Builder(this, shortcutNa…setIntent(shortcutIntent)");
            if (bitmap != null) {
                IconCompat createWithBitmap = IconCompat.createWithBitmap(bitmap);
                Intrinsics.checkNotNullExpressionValue(createWithBitmap, "createWithBitmap(bitmap)");
                intent2.setIcon(createWithBitmap);
            }
            ShortcutInfoCompat build = intent2.build();
            Intrinsics.checkNotNullExpressionValue(build, "pinShortcutInfoBuilder.build()");
            ShortcutManagerCompat.requestPinShortcut(this, build, null);
            return;
        }
        Intent intent3 = new Intent("com.arlosoft.macrodroid.ShortcutDispatch");
        intent3.putExtra("com.arlosoft.macrodroid.MACRO_NAME", str);
        Intrinsics.checkNotNull(macro);
        intent3.putExtra(Util.EXTRA_GUID, macro.getGUID());
        intent3.putExtra(Util.EXTRA_IS_ACTION_BLOCK, macro.isActionBlock);
        if (actionBlockData != null && (inputVarsMap2 = actionBlockData.getInputVarsMap()) != null && (keySet = inputVarsMap2.keySet()) != null) {
            str2 = CollectionsKt___CollectionsKt.joinToString$default(keySet, InvokeMacroReceiver.EXTRA_ACTION_BLOCK_ITEM_DIVIDER, null, null, 0, null, null, 62, null);
        } else {
            str2 = null;
        }
        intent3.putExtra(InvokeMacroReceiver.EXTRA_ACTION_BLOCK_PARAMS, str2);
        if (actionBlockData != null && (inputVarsMap = actionBlockData.getInputVarsMap()) != null && (values = inputVarsMap.values()) != null) {
            str3 = CollectionsKt___CollectionsKt.joinToString$default(values, InvokeMacroReceiver.EXTRA_ACTION_BLOCK_ITEM_DIVIDER, null, null, 0, null, null, 62, null);
        }
        intent3.putExtra(InvokeMacroReceiver.EXTRA_ACTION_BLOCK_VALUES, str3);
        intent3.addFlags(268435456);
        intent3.addFlags(67141632);
        intent3.setType("macrodroid/macro");
        Intent intent4 = new Intent();
        intent4.putExtra("android.intent.extra.shortcut.INTENT", intent3);
        intent4.putExtra("android.intent.extra.shortcut.NAME", str);
        if (bitmap != null) {
            intent4.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        }
        intent4.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        setResult(-1, intent4);
    }

    private final Bitmap s(Bitmap bitmap, @ColorInt int i4) {
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i4, PorterDuff.Mode.SRC_IN));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
        new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, width, height), paint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ShortcutActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f2021d = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ShortcutActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ShortcutActivity this$0, boolean z3, List shortcutTriggerMacros, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shortcutTriggerMacros, "$shortcutTriggerMacros");
        int i5 = this$0.f2021d;
        if (i5 == 0) {
            int size = MacroStore.getInstance().getAllCompletedMacros().size();
            int freeMacros = Settings.getFreeMacros(this$0);
            if (!MacroDroidApplication.Companion.getInstance().getPremiumStatusHandler().getPremiumStatus().isPro() && size >= freeMacros) {
                Util.showMacroLimitReached(this$0, this$0.remoteConfig);
                this$0.finish();
                return;
            }
            Macro macro = new Macro();
            macro.addTrigger(new ShortcutTrigger());
            macro.setConfiguringShortcut(true);
            Intent intent = new Intent(this$0, WizardActivity.class);
            intent.putExtra("Macro", macro);
            this$0.startActivityForResult(intent, 88);
            ToastCompat.makeText(this$0.getApplicationContext(), (int) R.string.creating_new_macro_with_shortcut_launched_trigger, 0).show();
        } else if (z3) {
            Macro macro2 = (Macro) shortcutTriggerMacros.get(i5 - 1);
            if (macro2.isActionBlock) {
                Intrinsics.checkNotNull(macro2, "null cannot be cast to non-null type com.arlosoft.macrodroid.actionblock.data.ActionBlock");
                this$0.q((ActionBlock) macro2, true);
                return;
            }
            this$0.w(macro2, null);
        } else {
            Macro macro3 = (Macro) shortcutTriggerMacros.get(i5 - 1);
            if (macro3.isActionBlock) {
                Intrinsics.checkNotNull(macro3, "null cannot be cast to non-null type com.arlosoft.macrodroid.actionblock.data.ActionBlock");
                this$0.q((ActionBlock) macro3, false);
                return;
            }
            String name = macro3.getName();
            Intrinsics.checkNotNullExpressionValue(name, "macro.name");
            this$0.r(macro3, name, null, null);
            this$0.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(final Macro macro, final ActionBlockData actionBlockData) {
        boolean equals;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog);
        int i4 = 0;
        appCompatDialog.setCancelable(false);
        appCompatDialog.setContentView(R.layout.dialog_shortcut_icon_configure);
        appCompatDialog.setTitle(getString(R.string.select_icon));
        View findViewById = appCompatDialog.findViewById(R.id.shortcut_icon_configure_icon);
        Intrinsics.checkNotNull(findViewById);
        this.f2025h = (ImageView) findViewById;
        Button button = (Button) appCompatDialog.findViewById(R.id.shortcut_icon_configure_change_button);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        View findViewById2 = appCompatDialog.findViewById(R.id.xiaomi_warning);
        View findViewById3 = appCompatDialog.findViewById(R.id.tint_icon_checkbox);
        Intrinsics.checkNotNull(findViewById3);
        this.f2029l = (CheckBox) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.iconTintColorCircle);
        Intrinsics.checkNotNull(findViewById4);
        final MaterialCardView materialCardView = (MaterialCardView) findViewById4;
        final ImageView imageView = this.f2025h;
        Intrinsics.checkNotNull(imageView);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        materialCardView.setCardBackgroundColor(-1);
        materialCardView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortcutActivity.y(ShortcutActivity.this, intRef, materialCardView, imageView, view);
            }
        });
        ImageView imageView2 = this.f2025h;
        Intrinsics.checkNotNull(imageView2);
        Drawable drawable = imageView2.getDrawable();
        this.f2028k = drawable;
        Intrinsics.checkNotNull(drawable);
        Drawable.ConstantState constantState = drawable.getConstantState();
        Intrinsics.checkNotNull(constantState);
        this.f2027j = constantState.newDrawable().mutate();
        CheckBox checkBox = this.f2029l;
        if (checkBox != null) {
            Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox, (CoroutineContext) null, new b(imageView, intRef, null), 1, (Object) null);
        }
        if (findViewById2 != null) {
            equals = kotlin.text.m.equals(Build.MANUFACTURER, "xiaomi", true);
            if (!equals) {
                i4 = 8;
            }
            findViewById2.setVisibility(i4);
        }
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortcutActivity.A(ShortcutActivity.this, view);
            }
        });
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortcutActivity.B(AppCompatDialog.this, imageView, this, intRef, macro, actionBlockData, view);
            }
        });
        Intrinsics.checkNotNull(button3);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortcutActivity.C(AppCompatDialog.this, this, view);
            }
        });
        appCompatDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.arlosoft.macrodroid.q0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ShortcutActivity.x(ShortcutActivity.this, dialogInterface);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ShortcutActivity this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f2028k = null;
        this$0.f2029l = null;
        this$0.f2025h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final ShortcutActivity this$0, final Ref.IntRef tintColor, final MaterialCardView tintColorCircle, final ImageView icon, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tintColor, "$tintColor");
        Intrinsics.checkNotNullParameter(tintColorCircle, "$tintColorCircle");
        Intrinsics.checkNotNullParameter(icon, "$icon");
        new SpectrumDialog.Builder(this$0).setTitle(R.string.select_color).setColors(R.array.toast_colors).setSelectedColor(tintColor.element).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.r0
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                ShortcutActivity.z(Ref.IntRef.this, tintColorCircle, this$0, icon, z3, i4);
            }
        }).build().show(this$0.getSupportFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Ref.IntRef tintColor, MaterialCardView tintColorCircle, ShortcutActivity this$0, ImageView icon, boolean z3, int i4) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(tintColor, "$tintColor");
        Intrinsics.checkNotNullParameter(tintColorCircle, "$tintColorCircle");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(icon, "$icon");
        if (z3) {
            tintColor.element = i4;
            tintColorCircle.setCardBackgroundColor(i4);
            CheckBox checkBox = this$0.f2029l;
            boolean z4 = false;
            if (checkBox != null && checkBox.isChecked()) {
                z4 = true;
            }
            if (z4 && (drawable = this$0.f2028k) != null) {
                icon.setImageDrawable(DrawableExtensionsKt.tint(drawable, tintColor.element));
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 88) {
            if (intent != null) {
                Macro macroByName = MacroStore.getInstance().getMacroByName(intent.getStringExtra("com.arlosoft.macrodroid.MACRO_NAME"));
                if (macroByName != null) {
                    if (macroByName.isActionBlock) {
                        q((ActionBlock) macroByName, true);
                    } else {
                        w(macroByName, null);
                    }
                }
            }
        } else if (i4 == 0 && i5 == -1) {
            Intrinsics.checkNotNull(intent);
            this.f2023f = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.f2022e = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            this.f2024g = intent.getData();
            CheckBox checkBox = this.f2029l;
            if (checkBox != null) {
                checkBox.setChecked(false);
            }
            ImageView imageView = this.f2025h;
            Intrinsics.checkNotNull(imageView);
            if (imageView != null) {
                Uri uri = this.f2024g;
                if (uri != null) {
                    imageView.setImageURI(uri);
                    return;
                }
                String str = this.f2022e;
                if (str != null && Intrinsics.areEqual(str, Constants.USER_ICON_OPTION_PACKAGE)) {
                    Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(this.f2023f);
                    if (decodeBitmapFromUserIconFile != null) {
                        imageView.setImageBitmap(decodeBitmapFromUserIconFile);
                        return;
                    } else {
                        imageView.setImageResource(R.drawable.launcher_no_border);
                        return;
                    }
                }
                Drawable drawableFromPackageWithName = Util.getDrawableFromPackageWithName(this, this.f2022e, this.f2023f);
                this.f2028k = drawableFromPackageWithName;
                Intrinsics.checkNotNull(drawableFromPackageWithName);
                Drawable.ConstantState constantState = drawableFromPackageWithName.getConstantState();
                Intrinsics.checkNotNull(constantState);
                this.f2027j = constantState.newDrawable().mutate();
                Drawable drawable = this.f2028k;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogDaggerBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String name;
        super.onCreate(bundle);
        Macro macro = (Macro) getIntent().getParcelableExtra("Macro");
        if (macro != null) {
            this.f2026i = true;
            if (macro.isActionBlock) {
                q((ActionBlock) macro, true);
                return;
            } else {
                w(macro, null);
                return;
            }
        }
        final boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_PICK_ICON, true);
        final ArrayList<Macro> arrayList = new ArrayList(MacroStore.getInstance().getAllCompletedMacrosWithActionBlocksSortedMacrosFirst());
        Spanned[] spannedArr = new Spanned[arrayList.size() + 1];
        spannedArr[0] = Html.fromHtml(getString(R.string.add_new_macro));
        int i4 = 1;
        for (Macro macro2 : arrayList) {
            if (macro2.getIsFavourite()) {
                name = "⭐ " + macro2.getName();
            } else {
                name = macro2.getName();
            }
            if (macro2.isActionBlock) {
                name = name + "<br/><small>(" + getString(R.string.action_block) + ")</small>";
            }
            spannedArr[i4] = Html.fromHtml(name);
            i4++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.select_macro_or_action_block);
        builder.setSingleChoiceItems(spannedArr, 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.j0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ShortcutActivity.t(ShortcutActivity.this, dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.k0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ShortcutActivity.u(ShortcutActivity.this, dialogInterface, i5);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ShortcutActivity.v(ShortcutActivity.this, booleanExtra, arrayList, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }
}
