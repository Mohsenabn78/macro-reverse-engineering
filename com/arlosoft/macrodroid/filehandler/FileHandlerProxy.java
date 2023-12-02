package com.arlosoft.macrodroid.filehandler;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FileHandlerProxy.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FileHandlerProxy extends AppCompatActivity {
    public static final int $stable = 0;

    /* compiled from: FileHandlerProxy.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FileHandlerProxy this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FileHandlerProxy.kt */
        /* renamed from: com.arlosoft.macrodroid.filehandler.FileHandlerProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0106a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FileHandlerProxy this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0106a(FileHandlerProxy fileHandlerProxy, Continuation<? super C0106a> continuation) {
                super(2, continuation);
                this.this$0 = fileHandlerProxy;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0106a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ToastCompat.makeText(this.this$0.getApplicationContext(), (CharSequence) "The selected file could not be imported into MacroDroid", 1).show();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0106a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FileHandlerProxy.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FileHandlerProxy this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(FileHandlerProxy fileHandlerProxy, Continuation<? super b> continuation) {
                super(2, continuation);
                this.this$0 = fileHandlerProxy;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ToastCompat.makeText(this.this$0.getApplicationContext(), (CharSequence) "The selected file could not be imported into MacroDroid", 1).show();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FileHandlerProxy.kt */
        /* loaded from: classes3.dex */
        public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FileHandlerProxy this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(FileHandlerProxy fileHandlerProxy, Continuation<? super c> continuation) {
                super(2, continuation);
                this.this$0 = fileHandlerProxy;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new c(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.finish();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Uri uri, FileHandlerProxy fileHandlerProxy, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$uri = uri;
            this.this$0 = fileHandlerProxy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(FileHandlerProxy fileHandlerProxy) {
            ToastCompat.makeText((Context) fileHandlerProxy, (CharSequence) fileHandlerProxy.getString(R.string.import_failed), 1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(FileHandlerProxy fileHandlerProxy) {
            ToastCompat.makeText((Context) fileHandlerProxy, (CharSequence) fileHandlerProxy.getString(R.string.import_failed), 1).show();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(this.$uri, this.this$0, continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:76:0x01fd, code lost:
            if (r0 != null) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01ff, code lost:
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x026a, code lost:
            if (r0 == null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x026d, code lost:
            r0 = kotlinx.coroutines.Dispatchers.getMain();
            r2 = new com.arlosoft.macrodroid.filehandler.FileHandlerProxy.a.c(r16.this$0, null);
            r16.label = 3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x027f, code lost:
            if (kotlinx.coroutines.BuildersKt.withContext(r0, r2, r16) != r4) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0281, code lost:
            return r4;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [T, java.io.BufferedReader] */
        /* JADX WARN: Type inference failed for: r13v2, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 725
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.filehandler.FileHandlerProxy.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r7.equals("android.intent.action.VIEW") == true) goto L7;
     */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            r7 = 2131558448(0x7f0d0030, float:1.8742212E38)
            r6.setContentView(r7)
            android.content.Intent r7 = r6.getIntent()
            r0 = 0
            if (r7 == 0) goto L20
            java.lang.String r7 = r7.getAction()
            if (r7 == 0) goto L20
            java.lang.String r1 = "android.intent.action.VIEW"
            boolean r7 = r7.equals(r1)
            r1 = 1
            if (r7 != r1) goto L20
            goto L21
        L20:
            r1 = 0
        L21:
            if (r1 == 0) goto L72
            android.content.Intent r7 = r6.getIntent()
            android.net.Uri r7 = r7.getData()
            if (r7 == 0) goto L72
            android.content.Intent r7 = r6.getIntent()
            android.net.Uri r7 = r7.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r1 = r7.toString()
            java.lang.String r2 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = ".mdr"
            r3 = 2
            r4 = 0
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r1, r2, r0, r3, r4)
            if (r0 == 0) goto L5f
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "com.arlosoft.macrodroid.ExportImportActivity"
            r7.setClassName(r6, r0)
            android.content.Intent r7 = r6.getIntent()
            r6.startActivity(r7)
            r6.finish()
            return
        L5f:
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r6)
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            r2 = 0
            com.arlosoft.macrodroid.filehandler.FileHandlerProxy$a r3 = new com.arlosoft.macrodroid.filehandler.FileHandlerProxy$a
            r3.<init>(r7, r6, r4)
            r4 = 2
            r5 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.filehandler.FileHandlerProxy.onCreate(android.os.Bundle):void");
    }
}
