package com.arlosoft.macrodroid.action.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.JavaScriptAction;
import com.arlosoft.macrodroid.action.activities.JavaScriptEditActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.databinding.ActivityJavascriptActionConfigureBinding;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.javascript.JavaScripResult;
import com.arlosoft.macrodroid.javascript.JavaScriptExecutor;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import io.github.rosemoe.sora.event.Event;
import io.github.rosemoe.sora.event.EventReceiver;
import io.github.rosemoe.sora.event.PublishSearchResultEvent;
import io.github.rosemoe.sora.event.SelectionChangeEvent;
import io.github.rosemoe.sora.event.Unsubscribe;
import io.github.rosemoe.sora.lang.Language;
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme;
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage;
import io.github.rosemoe.sora.langs.textmate.registry.FileProviderRegistry;
import io.github.rosemoe.sora.langs.textmate.registry.GrammarRegistry;
import io.github.rosemoe.sora.langs.textmate.registry.ThemeRegistry;
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel;
import io.github.rosemoe.sora.langs.textmate.registry.provider.AssetsFileResolver;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.Cursor;
import io.github.rosemoe.sora.text.LineSeparator;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorSearcher;
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion;
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaScriptEditActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nJavaScriptEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaScriptEditActivity.kt\ncom/arlosoft/macrodroid/action/activities/JavaScriptEditActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 Editor.kt\nio/github/rosemoe/sora/widget/EditorKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,536:1\n1#2:537\n262#3,2:538\n262#3,2:540\n38#4:542\n38#4:543\n13309#5,2:544\n*S KotlinDebug\n*F\n+ 1 JavaScriptEditActivity.kt\ncom/arlosoft/macrodroid/action/activities/JavaScriptEditActivity\n*L\n261#1:538,2\n262#1:540,2\n293#1:542\n294#1:543\n383#1:544,2\n*E\n"})
/* loaded from: classes2.dex */
public final class JavaScriptEditActivity extends MacroDroidDialogBaseActivity {
    @NotNull
    public static final String EXTRA_CONSOLE_DICTIONARY_KEYS = "console_dictionary_keys";
    @NotNull
    public static final String EXTRA_CONSOLE_VARIABLE_NAME = "console_variable_name";
    @NotNull
    public static final String EXTRA_JAVASCRIPT_ENGINE = "javascript_engine";
    @NotNull
    public static final String EXTRA_SCRIPT = "script";

    /* renamed from: d  reason: collision with root package name */
    private ActivityJavascriptActionConfigureBinding f2845d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Macro f2846e;

    /* renamed from: f  reason: collision with root package name */
    private JavaScriptAction f2847f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private transient String f2848g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private transient DictionaryKeys f2849h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private transient String f2850i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private transient DictionaryKeys f2851j;

    /* renamed from: k  reason: collision with root package name */
    private String f2852k;

    /* renamed from: l  reason: collision with root package name */
    private String f2853l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2854m;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: JavaScriptEditActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(@NotNull Activity activity, long j4, @NotNull String script, @Nullable String str, @Nullable DictionaryKeys dictionaryKeys, @Nullable String str2, @Nullable DictionaryKeys dictionaryKeys2, @NotNull String javaScriptEngine, int i4) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(script, "script");
            Intrinsics.checkNotNullParameter(javaScriptEngine, "javaScriptEngine");
            Intent intent = new Intent(activity, JavaScriptEditActivity.class);
            intent.putExtra(JavaScriptEditActivity.EXTRA_SCRIPT, script);
            intent.putExtra(Constants.EXTRA_MACRO_GUID, j4);
            intent.putExtra("var_name", str);
            intent.putExtra("dictionary_keys", dictionaryKeys);
            intent.putExtra(JavaScriptEditActivity.EXTRA_CONSOLE_VARIABLE_NAME, str2);
            intent.putExtra(JavaScriptEditActivity.EXTRA_CONSOLE_DICTIONARY_KEYS, dictionaryKeys2);
            intent.putExtra(JavaScriptEditActivity.EXTRA_JAVASCRIPT_ENGINE, javaScriptEngine);
            activity.startActivityForResult(intent, i4);
        }
    }

    /* compiled from: JavaScriptEditActivity.kt */
    /* loaded from: classes2.dex */
    private static final class a extends ArrayAdapter<String> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Activity f2855a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f2856b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Activity activity, @NotNull List<String> items) {
            super(activity, (int) R.layout.spinner_item_macro_action_block, items);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(items, "items");
            this.f2855a = activity;
            this.f2856b = items;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NotNull
        /* renamed from: a */
        public String getItem(int i4) {
            return this.f2856b.get(i4);
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        @NotNull
        public View getDropDownView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (view == null) {
                LayoutInflater layoutInflater = this.f2855a.getLayoutInflater();
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "activity.layoutInflater");
                view = layoutInflater.inflate(17367049, parent, false);
            }
            Intrinsics.checkNotNull(view);
            TextView textView = (TextView) view.findViewById(16908308);
            if (textView != null) {
                textView.setText(getItem(i4));
            }
            return view;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NotNull
        public View getView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (view == null) {
                LayoutInflater layoutInflater = this.f2855a.getLayoutInflater();
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "activity.layoutInflater");
                view = layoutInflater.inflate(R.layout.spinner_item_js_engine, parent, false);
            }
            Intrinsics.checkNotNull(view);
            ((TextView) view.findViewById(R.id.nameText)).setText(this.f2855a.getString(R.string.action_javascript_engine_title));
            ((TextView) view.findViewById(R.id.typeText)).setText(getItem(i4));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaScriptEditActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                JavaScriptEditActivity.this.A();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaScriptEditActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(JavaScriptEditActivity javaScriptEditActivity, MacroDroidVariable macroDroidVariable) {
            javaScriptEditActivity.f2854m = true;
            javaScriptEditActivity.f2848g = macroDroidVariable.getName();
            JavaScriptAction javaScriptAction = null;
            javaScriptEditActivity.f2849h = null;
            ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = javaScriptEditActivity.f2845d;
            if (activityJavascriptActionConfigureBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityJavascriptActionConfigureBinding = null;
            }
            NDSpinner nDSpinner = activityJavascriptActionConfigureBinding.stringVariableSpinner;
            Intrinsics.checkNotNullExpressionValue(nDSpinner, "binding.stringVariableSpinner");
            JavaScriptAction javaScriptAction2 = javaScriptEditActivity.f2847f;
            if (javaScriptAction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("action");
            } else {
                javaScriptAction = javaScriptAction2;
            }
            javaScriptEditActivity.y(nDSpinner, javaScriptAction);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            JavaScriptAction javaScriptAction;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                JavaScriptEditActivity javaScriptEditActivity = JavaScriptEditActivity.this;
                ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = javaScriptEditActivity.f2845d;
                if (activityJavascriptActionConfigureBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityJavascriptActionConfigureBinding = null;
                }
                NDSpinner nDSpinner = activityJavascriptActionConfigureBinding.stringVariableSpinner;
                JavaScriptAction javaScriptAction2 = JavaScriptEditActivity.this.f2847f;
                if (javaScriptAction2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("action");
                    javaScriptAction = null;
                } else {
                    javaScriptAction = javaScriptAction2;
                }
                final JavaScriptEditActivity javaScriptEditActivity2 = JavaScriptEditActivity.this;
                VariablesHelper.createNewVariable(javaScriptEditActivity, nDSpinner, javaScriptAction, (int) R.style.Theme_App_Dialog_Action, 2, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.activities.s
                    @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                    public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                        JavaScriptEditActivity.c.c(JavaScriptEditActivity.this, macroDroidVariable);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaScriptEditActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(3, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(JavaScriptEditActivity javaScriptEditActivity, MacroDroidVariable macroDroidVariable) {
            javaScriptEditActivity.f2854m = true;
            javaScriptEditActivity.f2850i = macroDroidVariable.getName();
            JavaScriptAction javaScriptAction = null;
            javaScriptEditActivity.f2851j = null;
            ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = javaScriptEditActivity.f2845d;
            if (activityJavascriptActionConfigureBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityJavascriptActionConfigureBinding = null;
            }
            NDSpinner nDSpinner = activityJavascriptActionConfigureBinding.consoleVariableSpinner;
            Intrinsics.checkNotNullExpressionValue(nDSpinner, "binding.consoleVariableSpinner");
            JavaScriptAction javaScriptAction2 = javaScriptEditActivity.f2847f;
            if (javaScriptAction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("action");
            } else {
                javaScriptAction = javaScriptAction2;
            }
            javaScriptEditActivity.x(nDSpinner, javaScriptAction);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            JavaScriptAction javaScriptAction;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                JavaScriptEditActivity javaScriptEditActivity = JavaScriptEditActivity.this;
                ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = javaScriptEditActivity.f2845d;
                if (activityJavascriptActionConfigureBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityJavascriptActionConfigureBinding = null;
                }
                NDSpinner nDSpinner = activityJavascriptActionConfigureBinding.consoleVariableSpinner;
                JavaScriptAction javaScriptAction2 = JavaScriptEditActivity.this.f2847f;
                if (javaScriptAction2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("action");
                    javaScriptAction = null;
                } else {
                    javaScriptAction = javaScriptAction2;
                }
                final JavaScriptEditActivity javaScriptEditActivity2 = JavaScriptEditActivity.this;
                VariablesHelper.createNewVariable(javaScriptEditActivity, nDSpinner, javaScriptAction, (int) R.style.Theme_App_Dialog_Action, 2, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.activities.t
                    @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                    public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                        JavaScriptEditActivity.d.c(JavaScriptEditActivity.this, macroDroidVariable);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: JavaScriptEditActivity.kt */
    /* loaded from: classes2.dex */
    static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                JavaScriptEditActivity.this.onBackPressed();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: JavaScriptEditActivity.kt */
    @SourceDebugExtension({"SMAP\nJavaScriptEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaScriptEditActivity.kt\ncom/arlosoft/macrodroid/action/activities/JavaScriptEditActivity$onCreate$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,536:1\n262#2,2:537\n*S KotlinDebug\n*F\n+ 1 JavaScriptEditActivity.kt\ncom/arlosoft/macrodroid/action/activities/JavaScriptEditActivity$onCreate$4\n*L\n152#1:537,2\n*E\n"})
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements Function1<Integer, Unit> {
        final /* synthetic */ String[] $options;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String[] strArr) {
            super(1);
            this.$options = strArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i4) {
            JavaScriptEditActivity javaScriptEditActivity = JavaScriptEditActivity.this;
            String str = this.$options[i4];
            Intrinsics.checkNotNullExpressionValue(str, "options[index]");
            javaScriptEditActivity.f2853l = str;
            ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = JavaScriptEditActivity.this.f2845d;
            String str2 = null;
            if (activityJavascriptActionConfigureBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityJavascriptActionConfigureBinding = null;
            }
            LinearLayout linearLayout = activityJavascriptActionConfigureBinding.consoleVariableTopLevelLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.consoleVariableTopLevelLayout");
            String str3 = JavaScriptEditActivity.this.f2853l;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
            } else {
                str2 = str3;
            }
            linearLayout.setVisibility(Intrinsics.areEqual(str2, "JetPack JavascriptEngine") ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaScriptEditActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $consoleText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Ref.ObjectRef<String> objectRef) {
            super(1);
            this.$consoleText = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String newConsoleText) {
            Intrinsics.checkNotNullParameter(newConsoleText, "newConsoleText");
            Ref.ObjectRef<String> objectRef = this.$consoleText;
            String str = objectRef.element;
            objectRef.element = ((Object) str) + newConsoleText;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaScriptEditActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h extends Lambda implements Function1<JavaScripResult, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $consoleText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Ref.ObjectRef<String> objectRef) {
            super(1);
            this.$consoleText = objectRef;
        }

        public final void a(@NotNull JavaScripResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String str = null;
            if (it instanceof JavaScripResult.Success) {
                JavaScriptEditActivity javaScriptEditActivity = JavaScriptEditActivity.this;
                String result = ((JavaScripResult.Success) it).getResult();
                String str2 = this.$consoleText.element;
                String str3 = JavaScriptEditActivity.this.f2853l;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
                } else {
                    str = str3;
                }
                javaScriptEditActivity.o(result, str2, Intrinsics.areEqual(str, "JetPack JavascriptEngine"));
            } else if (it instanceof JavaScripResult.Failure) {
                JavaScriptEditActivity javaScriptEditActivity2 = JavaScriptEditActivity.this;
                String valueOf = String.valueOf(((JavaScripResult.Failure) it).getError().getMessage());
                String str4 = this.$consoleText.element;
                String str5 = JavaScriptEditActivity.this.f2853l;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
                } else {
                    str = str5;
                }
                javaScriptEditActivity2.o(valueOf, str4, Intrinsics.areEqual(str, "JetPack JavascriptEngine"));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JavaScripResult javaScripResult) {
            a(javaScripResult);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        Intent intent = new Intent();
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = this.f2845d;
        String str = null;
        if (activityJavascriptActionConfigureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding = null;
        }
        intent.putExtra(EXTRA_SCRIPT, activityJavascriptActionConfigureBinding.codeEditor.getText().toString());
        intent.putExtra("var_name", this.f2848g);
        intent.putExtra("dictionary_keys", this.f2849h);
        intent.putExtra(EXTRA_CONSOLE_VARIABLE_NAME, this.f2850i);
        intent.putExtra(EXTRA_CONSOLE_DICTIONARY_KEYS, this.f2851j);
        String str2 = this.f2853l;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
        } else {
            str = str2;
        }
        intent.putExtra(EXTRA_JAVASCRIPT_ENGINE, str);
        setResult(-1, intent);
        finish();
    }

    private final void B() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Variables);
        appCompatDialog.setContentView(R.layout.dialog_javascript_result_explanation);
        appCompatDialog.setTitle(R.string.action_javascript);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.dontShowAgainCheckbox);
        Intrinsics.checkNotNull(findViewById2);
        final CheckBox checkBox = (CheckBox) findViewById2;
        ((Button) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JavaScriptEditActivity.C(AppCompatDialog.this, checkBox, this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AppCompatDialog dialog, CheckBox dontShowAgainCheckbox, JavaScriptEditActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(dontShowAgainCheckbox, "$dontShowAgainCheckbox");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        if (dontShowAgainCheckbox.isChecked()) {
            Settings.setShowJavaScriptVariableWarningNotification(this$0, false);
        }
    }

    private final void D() {
        MagicText.displaySelectionDialog(this, new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.activities.m
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                JavaScriptEditActivity.E(JavaScriptEditActivity.this, magicTextPair);
            }
        }, this.f2846e, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(JavaScriptEditActivity this$0, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pair, "pair");
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = this$0.f2845d;
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding2 = null;
        if (activityJavascriptActionConfigureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding = null;
        }
        int max = Math.max(activityJavascriptActionConfigureBinding.codeEditor.getCursorRange().getStart().index, 0);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding3 = this$0.f2845d;
        if (activityJavascriptActionConfigureBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding3 = null;
        }
        int max2 = Math.max(activityJavascriptActionConfigureBinding3.codeEditor.getCursorRange().getEnd().index, 0);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding4 = this$0.f2845d;
        if (activityJavascriptActionConfigureBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityJavascriptActionConfigureBinding2 = activityJavascriptActionConfigureBinding4;
        }
        activityJavascriptActionConfigureBinding2.codeEditor.getText().replace(Math.min(max, max2), Math.max(max, max2), pair.magicText);
    }

    private final void F() {
        String str;
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = this.f2845d;
        if (activityJavascriptActionConfigureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding = null;
        }
        String script = MagicText.replaceMagicText(this, activityJavascriptActionConfigureBinding.codeEditor.getText().toString(), null, this.f2846e);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        JavaScriptExecutor javaScriptExecutor = JavaScriptExecutor.INSTANCE;
        String str2 = this.f2853l;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
            str = null;
        } else {
            str = str2;
        }
        Macro macro = this.f2846e;
        Intrinsics.checkNotNull(macro);
        Intrinsics.checkNotNullExpressionValue(script, "script");
        javaScriptExecutor.executeJavaScript(this, str, macro, script, new g(objectRef), new h(objectRef));
    }

    private final void G() {
        String str;
        String name;
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = this.f2845d;
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding2 = null;
        if (activityJavascriptActionConfigureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding = null;
        }
        Cursor cursor = activityJavascriptActionConfigureBinding.codeEditor.getCursor();
        String str2 = (cursor.getLeftLine() + 1) + ":" + cursor.getLeftColumn() + ";" + cursor.getLeft() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        if (cursor.isSelected()) {
            str = "(" + (cursor.getRight() - cursor.getLeft()) + " chars)";
        } else {
            ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding3 = this.f2845d;
            if (activityJavascriptActionConfigureBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityJavascriptActionConfigureBinding3 = null;
            }
            Content text = activityJavascriptActionConfigureBinding3.codeEditor.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.codeEditor.text");
            if (text.getColumnCount(cursor.getLeftLine()) == cursor.getLeftColumn()) {
                LineSeparator lineSeparator = text.getLine(cursor.getLeftLine()).getLineSeparator();
                if (lineSeparator == LineSeparator.NONE) {
                    name = "EOF";
                } else {
                    name = lineSeparator.name();
                }
                str = "(<" + ((Object) name) + ">)";
            } else {
                ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding4 = this.f2845d;
                if (activityJavascriptActionConfigureBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityJavascriptActionConfigureBinding4 = null;
                }
                char charAt = activityJavascriptActionConfigureBinding4.codeEditor.getText().charAt(cursor.getLeftLine(), cursor.getLeftColumn());
                if (Character.isLowSurrogate(charAt) && cursor.getLeftColumn() > 0) {
                    char[] cArr = new char[2];
                    ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding5 = this.f2845d;
                    if (activityJavascriptActionConfigureBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityJavascriptActionConfigureBinding5 = null;
                    }
                    cArr[0] = activityJavascriptActionConfigureBinding5.codeEditor.getText().charAt(cursor.getLeftLine(), cursor.getLeftColumn() - 1);
                    cArr[1] = charAt;
                    str = "(" + new String(cArr) + ")";
                } else {
                    if (Character.isHighSurrogate(charAt)) {
                        int leftColumn = cursor.getLeftColumn() + 1;
                        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding6 = this.f2845d;
                        if (activityJavascriptActionConfigureBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityJavascriptActionConfigureBinding6 = null;
                        }
                        if (leftColumn < activityJavascriptActionConfigureBinding6.codeEditor.getText().getColumnCount(cursor.getLeftLine())) {
                            char[] cArr2 = new char[2];
                            cArr2[0] = charAt;
                            ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding7 = this.f2845d;
                            if (activityJavascriptActionConfigureBinding7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                activityJavascriptActionConfigureBinding7 = null;
                            }
                            cArr2[1] = activityJavascriptActionConfigureBinding7.codeEditor.getText().charAt(cursor.getLeftLine(), cursor.getLeftColumn() + 1);
                            str = "(" + new String(cArr2) + ")";
                        }
                    }
                    ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding8 = this.f2845d;
                    if (activityJavascriptActionConfigureBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityJavascriptActionConfigureBinding8 = null;
                    }
                    str = "(" + r(activityJavascriptActionConfigureBinding8.codeEditor.getText().charAt(cursor.getLeftLine(), cursor.getLeftColumn())) + ")";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding9 = this.f2845d;
        if (activityJavascriptActionConfigureBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityJavascriptActionConfigureBinding2 = activityJavascriptActionConfigureBinding9;
        }
        EditorSearcher searcher = activityJavascriptActionConfigureBinding2.codeEditor.getSearcher();
        if (searcher.hasQuery()) {
            searcher.getCurrentMatchedPositionIndex();
            int matchedPositionCount = searcher.getMatchedPositionCount();
            if (matchedPositionCount != 0 && matchedPositionCount != 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(matchedPositionCount);
                sb2.append(" matches");
            }
        }
    }

    private final void handleBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Variables);
        builder.setTitle(R.string.save_changes);
        builder.setMessage(R.string.do_you_wish_to_save_changes_generic).setCancelable(false).setNeutralButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                JavaScriptEditActivity.t(JavaScriptEditActivity.this, dialogInterface, i4);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                JavaScriptEditActivity.s(JavaScriptEditActivity.this, dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String str, String str2, boolean z3) {
        boolean z4;
        boolean z5;
        int i4;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.dialog_javascript_result);
        appCompatDialog.setTitle(R.string.macrodroid);
        View findViewById = appCompatDialog.findViewById(R.id.javascript_result);
        Intrinsics.checkNotNull(findViewById);
        TextView textView = (TextView) findViewById;
        if (str.length() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            str = "<" + getString(R.string.none) + ">";
        }
        textView.setText(str);
        View findViewById2 = appCompatDialog.findViewById(R.id.javascript_console);
        Intrinsics.checkNotNull(findViewById2);
        TextView textView2 = (TextView) findViewById2;
        if (str2.length() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            str2 = "<" + getString(R.string.empty) + ">";
        }
        textView2.setText(str2);
        View findViewById3 = appCompatDialog.findViewById(R.id.console_output_title);
        Intrinsics.checkNotNull(findViewById3);
        int i5 = 8;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        findViewById3.setVisibility(i4);
        View findViewById4 = appCompatDialog.findViewById(R.id.javascript_console);
        Intrinsics.checkNotNull(findViewById4);
        if (z3) {
            i5 = 0;
        }
        findViewById4.setVisibility(i5);
        View findViewById5 = appCompatDialog.findViewById(R.id.ok_button);
        Intrinsics.checkNotNull(findViewById5);
        ((Button) findViewById5).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JavaScriptEditActivity.p(AppCompatDialog.this, view);
            }
        });
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void q() {
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = this.f2845d;
        if (activityJavascriptActionConfigureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding = null;
        }
        CodeEditor codeEditor = activityJavascriptActionConfigureBinding.codeEditor;
        Intrinsics.checkNotNullExpressionValue(codeEditor, "binding.codeEditor");
        EditorColorScheme colorScheme = codeEditor.getColorScheme();
        Intrinsics.checkNotNullExpressionValue(colorScheme, "editor.colorScheme");
        if (!(colorScheme instanceof TextMateColorScheme)) {
            TextMateColorScheme create = TextMateColorScheme.create(ThemeRegistry.getInstance());
            Intrinsics.checkNotNullExpressionValue(create, "create(ThemeRegistry.getInstance())");
            codeEditor.setColorScheme(create);
        }
    }

    private final String r(char c4) {
        if (c4 == '\n') {
            return "\\n";
        }
        if (c4 == '\t') {
            return "\\t";
        }
        if (c4 == '\r') {
            return "\\r";
        }
        if (c4 == ' ') {
            return "<ws>";
        }
        return String.valueOf(c4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(JavaScriptEditActivity this$0, DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(JavaScriptEditActivity this$0, DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this$0.finish();
    }

    private final void u(String str) {
        TextMateLanguage create;
        z();
        FileProviderRegistry.getInstance().addFileProvider(new AssetsFileResolver(getAssets()));
        GrammarRegistry.getInstance().loadGrammars("textmate/languages.json");
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/JetBrainsMono-Regular.ttf");
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = this.f2845d;
        JavaScriptAction javaScriptAction = null;
        if (activityJavascriptActionConfigureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding = null;
        }
        CodeEditor initialise$lambda$8 = activityJavascriptActionConfigureBinding.codeEditor;
        initialise$lambda$8.setTypefaceText(createFromAsset);
        initialise$lambda$8.getProps().stickyScroll = true;
        initialise$lambda$8.setLineSpacing(2.0f, 1.1f);
        initialise$lambda$8.setNonPrintablePaintingFlags(81);
        Intrinsics.checkNotNullExpressionValue(initialise$lambda$8, "initialise$lambda$8");
        Intrinsics.checkNotNullExpressionValue(initialise$lambda$8.subscribeEvent(SelectionChangeEvent.class, new EventReceiver() { // from class: com.arlosoft.macrodroid.action.activities.q
            @Override // io.github.rosemoe.sora.event.EventReceiver
            public final void onReceive(Event event, Unsubscribe unsubscribe) {
                JavaScriptEditActivity.v(JavaScriptEditActivity.this, (SelectionChangeEvent) event, unsubscribe);
            }
        }), "subscribeEvent(...)");
        Intrinsics.checkNotNullExpressionValue(initialise$lambda$8.subscribeEvent(PublishSearchResultEvent.class, new EventReceiver() { // from class: com.arlosoft.macrodroid.action.activities.r
            @Override // io.github.rosemoe.sora.event.EventReceiver
            public final void onReceive(Event event, Unsubscribe unsubscribe) {
                JavaScriptEditActivity.w(JavaScriptEditActivity.this, (PublishSearchResultEvent) event, unsubscribe);
            }
        }), "subscribeEvent(...)");
        ((EditorAutoCompletion) initialise$lambda$8.getComponent(EditorAutoCompletion.class)).setEnabledAnimation(true);
        q();
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding2 = this.f2845d;
        if (activityJavascriptActionConfigureBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding2 = null;
        }
        Language editorLanguage = activityJavascriptActionConfigureBinding2.codeEditor.getEditorLanguage();
        Intrinsics.checkNotNullExpressionValue(editorLanguage, "binding.codeEditor.editorLanguage");
        if (editorLanguage instanceof TextMateLanguage) {
            create = (TextMateLanguage) editorLanguage;
            create.updateLanguage("source.js");
        } else {
            create = TextMateLanguage.create("source.js", true);
        }
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding3 = this.f2845d;
        if (activityJavascriptActionConfigureBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding3 = null;
        }
        activityJavascriptActionConfigureBinding3.codeEditor.setEditorLanguage(create);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding4 = this.f2845d;
        if (activityJavascriptActionConfigureBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding4 = null;
        }
        activityJavascriptActionConfigureBinding4.codeEditor.setText(str, null);
        G();
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding5 = this.f2845d;
        if (activityJavascriptActionConfigureBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding5 = null;
        }
        FloatingActionButton floatingActionButton = activityJavascriptActionConfigureBinding5.saveButton;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.saveButton");
        ViewExtensionsKt.onClick$default(floatingActionButton, null, new b(null), 1, null);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding6 = this.f2845d;
        if (activityJavascriptActionConfigureBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding6 = null;
        }
        Button button = activityJavascriptActionConfigureBinding6.addStringVariableButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.addStringVariableButton");
        ViewExtensionsKt.onClick$default(button, null, new c(null), 1, null);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding7 = this.f2845d;
        if (activityJavascriptActionConfigureBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding7 = null;
        }
        Button button2 = activityJavascriptActionConfigureBinding7.addConsoleVariableButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.addConsoleVariableButton");
        ViewExtensionsKt.onClick$default(button2, null, new d(null), 1, null);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding8 = this.f2845d;
        if (activityJavascriptActionConfigureBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding8 = null;
        }
        NDSpinner nDSpinner = activityJavascriptActionConfigureBinding8.stringVariableSpinner;
        Intrinsics.checkNotNullExpressionValue(nDSpinner, "binding.stringVariableSpinner");
        JavaScriptAction javaScriptAction2 = this.f2847f;
        if (javaScriptAction2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
            javaScriptAction2 = null;
        }
        y(nDSpinner, javaScriptAction2);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding9 = this.f2845d;
        if (activityJavascriptActionConfigureBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding9 = null;
        }
        NDSpinner nDSpinner2 = activityJavascriptActionConfigureBinding9.consoleVariableSpinner;
        Intrinsics.checkNotNullExpressionValue(nDSpinner2, "binding.consoleVariableSpinner");
        JavaScriptAction javaScriptAction3 = this.f2847f;
        if (javaScriptAction3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
        } else {
            javaScriptAction = javaScriptAction3;
        }
        x(nDSpinner2, javaScriptAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(JavaScriptEditActivity this$0, SelectionChangeEvent selectionChangeEvent, Unsubscribe unsubscribe) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectionChangeEvent, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(unsubscribe, "<anonymous parameter 1>");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(JavaScriptEditActivity this$0, PublishSearchResultEvent publishSearchResultEvent, Unsubscribe unsubscribe) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(publishSearchResultEvent, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(unsubscribe, "<anonymous parameter 1>");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(final Spinner spinner, JavaScriptAction javaScriptAction) {
        List listOf;
        String str;
        listOf = kotlin.collections.e.listOf(getString(R.string.none));
        Macro macro = this.f2846e;
        String str2 = this.f2850i;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.f2851j);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(this, R.style.Theme_App_Dialog_Action, javaScriptAction, spinner, macro, listOf, str, true, -1, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.activities.JavaScriptEditActivity$initialiseConoleVariableSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                JavaScriptEditActivity.this.f2850i = null;
                JavaScriptEditActivity.this.f2851j = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                spinner.setEnabled(true);
                JavaScriptEditActivity.this.f2850i = variable.getName();
                JavaScriptEditActivity javaScriptEditActivity = JavaScriptEditActivity.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                javaScriptEditActivity.f2851j = dictionaryKeys;
                JavaScriptEditActivity.this.f2854m = true;
            }
        });
        if (spinner.getCount() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getString(R.string.trigger_variable_no_variables));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, (int) R.layout.simple_spinner_item_white_text, arrayList);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(final Spinner spinner, JavaScriptAction javaScriptAction) {
        List listOf;
        String str;
        listOf = kotlin.collections.e.listOf(getString(R.string.none));
        Macro macro = this.f2846e;
        String str2 = this.f2848g;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.f2849h);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(this, R.style.Theme_App_Dialog_Action, javaScriptAction, spinner, macro, listOf, str, true, -1, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.activities.JavaScriptEditActivity$initialiseResponseTextVariableSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                JavaScriptEditActivity.this.f2848g = null;
                JavaScriptEditActivity.this.f2849h = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                spinner.setEnabled(true);
                JavaScriptEditActivity.this.f2848g = variable.getName();
                JavaScriptEditActivity javaScriptEditActivity = JavaScriptEditActivity.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                javaScriptEditActivity.f2849h = dictionaryKeys;
                JavaScriptEditActivity.this.f2854m = true;
            }
        });
        if (spinner.getCount() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getString(R.string.trigger_variable_no_variables));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, (int) R.layout.simple_spinner_item_white_text, arrayList);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private final void z() {
        FileProviderRegistry.getInstance().addFileProvider(new AssetsFileResolver(getApplicationContext().getAssets()));
        String[] strArr = {"darcula", "abyss", "quietlight", "solarized_drak"};
        ThemeRegistry themeRegistry = ThemeRegistry.getInstance();
        for (int i4 = 0; i4 < 4; i4++) {
            String str = strArr[i4];
            String str2 = "textmate/" + str + ".json";
            ThemeModel themeModel = new ThemeModel(org.eclipse.tm4e.core.registry.b.d(FileProviderRegistry.getInstance().tryGetInputStream(str2), str2, null), str);
            if (!Intrinsics.areEqual(str, "quietlight")) {
                themeModel.setDark(true);
            }
            themeRegistry.loadTheme(themeModel);
        }
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            themeRegistry.setTheme("darcula");
        } else {
            themeRegistry.setTheme("quietlight");
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        String str = this.f2852k;
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(EXTRA_SCRIPT);
            str = null;
        }
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding2 = this.f2845d;
        if (activityJavascriptActionConfigureBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityJavascriptActionConfigureBinding = activityJavascriptActionConfigureBinding2;
        }
        if (Intrinsics.areEqual(str, activityJavascriptActionConfigureBinding.codeEditor.getText().toString()) && !this.f2854m) {
            super.onBackPressed();
        } else {
            handleBackPressed();
        }
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Unit unit;
        List list;
        int indexOf;
        super.onCreate(bundle);
        ActivityJavascriptActionConfigureBinding inflate = ActivityJavascriptActionConfigureBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f2845d = inflate;
        String str = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = this.f2845d;
        if (activityJavascriptActionConfigureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding = null;
        }
        setSupportActionBar(activityJavascriptActionConfigureBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayShowTitleEnabled(false);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setDisplayShowCustomEnabled(true);
        }
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 != null) {
            supportActionBar4.setDisplayUseLogoEnabled(false);
        }
        this.f2846e = MacroStore.getInstance().getMacroByGUID(getIntent().getLongExtra(Constants.EXTRA_MACRO_GUID, -1L));
        JavaScriptEditingStore javaScriptEditingStore = JavaScriptEditingStore.INSTANCE;
        JavaScriptAction action = javaScriptEditingStore.getAction();
        Intrinsics.checkNotNull(action);
        this.f2847f = action;
        JavaScriptAction action2 = javaScriptEditingStore.getAction();
        if (action2 != null) {
            this.f2847f = action2;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            finish();
            return;
        }
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding2 = this.f2845d;
        if (activityJavascriptActionConfigureBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding2 = null;
        }
        ImageButton imageButton = activityJavascriptActionConfigureBinding2.backButton;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.backButton");
        ViewExtensionsKt.onClick$default(imageButton, null, new e(null), 1, null);
        this.f2848g = getIntent().getStringExtra("var_name");
        this.f2849h = (DictionaryKeys) getIntent().getParcelableExtra("dictionary_keys");
        this.f2850i = getIntent().getStringExtra(EXTRA_CONSOLE_VARIABLE_NAME);
        this.f2851j = (DictionaryKeys) getIntent().getParcelableExtra(EXTRA_CONSOLE_DICTIONARY_KEYS);
        String stringExtra = getIntent().getStringExtra(EXTRA_JAVASCRIPT_ENGINE);
        String str2 = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f2853l = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(EXTRA_SCRIPT);
        if (stringExtra2 != null) {
            str2 = stringExtra2;
        }
        this.f2852k = str2;
        u(str2);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding3 = this.f2845d;
        if (activityJavascriptActionConfigureBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding3 = null;
        }
        CodeEditor codeEditor = activityJavascriptActionConfigureBinding3.codeEditor;
        String str3 = this.f2852k;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(EXTRA_SCRIPT);
            str3 = null;
        }
        codeEditor.setText(str3);
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding4 = this.f2845d;
        if (activityJavascriptActionConfigureBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding4 = null;
        }
        activityJavascriptActionConfigureBinding4.codeEditor.setLineNumberEnabled(Settings.getJavaScriptEditorLineNumbers(this));
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding5 = this.f2845d;
        if (activityJavascriptActionConfigureBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding5 = null;
        }
        activityJavascriptActionConfigureBinding5.codeEditor.setWordwrap(Settings.getJavaScriptEditorWordWrap(this));
        if (Settings.getShowJavaScriptVariableWarningNotification(this)) {
            B();
        }
        String[] stringArray = getResources().getStringArray(R.array.javascript_engines);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…array.javascript_engines)");
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding6 = this.f2845d;
        if (activityJavascriptActionConfigureBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding6 = null;
        }
        Spinner spinner = activityJavascriptActionConfigureBinding6.engineSpinner;
        list = ArraysKt___ArraysKt.toList(stringArray);
        spinner.setAdapter((SpinnerAdapter) new a(this, list));
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding7 = this.f2845d;
        if (activityJavascriptActionConfigureBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding7 = null;
        }
        Spinner spinner2 = activityJavascriptActionConfigureBinding7.engineSpinner;
        Intrinsics.checkNotNullExpressionValue(spinner2, "binding.engineSpinner");
        ViewExtensionsKt.itemSelected(spinner2, new f(stringArray));
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding8 = this.f2845d;
        if (activityJavascriptActionConfigureBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityJavascriptActionConfigureBinding8 = null;
        }
        Spinner spinner3 = activityJavascriptActionConfigureBinding8.engineSpinner;
        String str4 = this.f2853l;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
        } else {
            str = str4;
        }
        indexOf = ArraysKt___ArraysKt.indexOf(stringArray, str);
        spinner3.setSelection(Math.max(0, indexOf));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.javascript_edit_menu, menu);
        menu.findItem(R.id.show_line_numbers).setChecked(Settings.getJavaScriptEditorLineNumbers(this));
        menu.findItem(R.id.word_wrap).setChecked(Settings.getJavaScriptEditorWordWrap(this));
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding = null;
        switch (item.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            case R.id.magic_text_button /* 2131363293 */:
                D();
                break;
            case R.id.show_line_numbers /* 2131364027 */:
                item.setChecked(!item.isChecked());
                ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding2 = this.f2845d;
                if (activityJavascriptActionConfigureBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityJavascriptActionConfigureBinding2 = null;
                }
                activityJavascriptActionConfigureBinding2.codeEditor.setLineNumberEnabled(item.isChecked());
                ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding3 = this.f2845d;
                if (activityJavascriptActionConfigureBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityJavascriptActionConfigureBinding = activityJavascriptActionConfigureBinding3;
                }
                activityJavascriptActionConfigureBinding.codeEditor.formatCodeAsync();
                break;
            case R.id.test_button /* 2131364234 */:
                F();
                break;
            case R.id.toggle_variables /* 2131364333 */:
                ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding4 = this.f2845d;
                if (activityJavascriptActionConfigureBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityJavascriptActionConfigureBinding4 = null;
                }
                if (activityJavascriptActionConfigureBinding4.variablesExpandable.isExpanded()) {
                    ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding5 = this.f2845d;
                    if (activityJavascriptActionConfigureBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityJavascriptActionConfigureBinding = activityJavascriptActionConfigureBinding5;
                    }
                    activityJavascriptActionConfigureBinding.variablesExpandable.collapse();
                    item.setTitle(R.string.show_variables);
                    break;
                } else {
                    ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding6 = this.f2845d;
                    if (activityJavascriptActionConfigureBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityJavascriptActionConfigureBinding = activityJavascriptActionConfigureBinding6;
                    }
                    activityJavascriptActionConfigureBinding.variablesExpandable.expand();
                    item.setTitle(R.string.hide_variables);
                    break;
                }
            case R.id.word_wrap /* 2131364661 */:
                item.setChecked(!item.isChecked());
                ActivityJavascriptActionConfigureBinding activityJavascriptActionConfigureBinding7 = this.f2845d;
                if (activityJavascriptActionConfigureBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityJavascriptActionConfigureBinding = activityJavascriptActionConfigureBinding7;
                }
                activityJavascriptActionConfigureBinding.codeEditor.setWordwrap(item.isChecked());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
