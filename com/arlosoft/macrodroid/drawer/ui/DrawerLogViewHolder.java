package com.arlosoft.macrodroid.drawer.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.database.room.SystemLogEntryDao;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemLog;
import com.arlosoft.macrodroid.logging.LogActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity;
import java.io.File;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.apache.commons.io.input.ReversedLinesFileReader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DrawerLogViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nDrawerLogViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawerLogViewHolder.kt\ncom/arlosoft/macrodroid/drawer/ui/DrawerLogViewHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,148:1\n1#2:149\n*E\n"})
/* loaded from: classes3.dex */
public final class DrawerLogViewHolder extends DrawerItemViewHolder {
    public static final int $stable = 8;
    @BindView(R.id.drag_handle)
    public ImageView dragHandle;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final MacroDroidRoomDatabase f11485e;

    /* renamed from: f  reason: collision with root package name */
    private DrawerItemLog f11486f;
    @BindView(R.id.log_text)
    public TextView logText;
    @BindView(R.id.title)
    public TextView title;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawerLogViewHolder.kt */
    @SourceDebugExtension({"SMAP\nDrawerLogViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawerLogViewHolder.kt\ncom/arlosoft/macrodroid/drawer/ui/DrawerLogViewHolder$refreshSystemLog$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1855#2,2:149\n*S KotlinDebug\n*F\n+ 1 DrawerLogViewHolder.kt\ncom/arlosoft/macrodroid/drawer/ui/DrawerLogViewHolder$refreshSystemLog$1\n*L\n117#1:149,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DrawerLogViewHolder.kt */
        /* renamed from: com.arlosoft.macrodroid.drawer.ui.DrawerLogViewHolder$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0098a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DrawerLogViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0098a(DrawerLogViewHolder drawerLogViewHolder, Continuation<? super C0098a> continuation) {
                super(2, continuation);
                this.this$0 = drawerLogViewHolder;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0098a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getLogText().setText(R.string.no_events_logged);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0098a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DrawerLogViewHolder.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $text;
            int label;
            final /* synthetic */ DrawerLogViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(DrawerLogViewHolder drawerLogViewHolder, String str, Continuation<? super b> continuation) {
                super(2, continuation);
                this.this$0 = drawerLogViewHolder;
                this.$text = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.this$0, this.$text, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getLogText().setText(this.$text);
                    TextView logText = this.this$0.getLogText();
                    DrawerItemLog drawerItemLog = this.this$0.f11486f;
                    if (drawerItemLog == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("drawerItemLog");
                        drawerItemLog = null;
                    }
                    logText.setMaxLines(drawerItemLog.getMaxLines());
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

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            String replace$default;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2 && i4 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                SystemLogEntryDao systemLogEntryDao = DrawerLogViewHolder.this.f11485e.systemLogEntryDao();
                DrawerItemLog drawerItemLog = DrawerLogViewHolder.this.f11486f;
                if (drawerItemLog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("drawerItemLog");
                    drawerItemLog = null;
                }
                int maxLines = drawerItemLog.getMaxLines();
                int levelInt = LogLevel.INFO.getLevelInt();
                this.label = 1;
                obj = systemLogEntryDao.getLatest(maxLines, levelInt, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            List<SystemLogEntry> list = (List) obj;
            StringBuilder sb = new StringBuilder();
            if (list.isEmpty()) {
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C0098a c0098a = new C0098a(DrawerLogViewHolder.this, null);
                this.label = 2;
                if (BuildersKt.withContext(main, c0098a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                for (SystemLogEntry systemLogEntry : list) {
                    sb.append(systemLogEntry.getLogText());
                    sb.append("\n");
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
                replace$default = kotlin.text.m.replace$default(sb2, "\\n", "\n", false, 4, (Object) null);
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                b bVar = new b(DrawerLogViewHolder.this, replace$default, null);
                this.label = 3;
                if (BuildersKt.withContext(main2, bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerLogViewHolder(@NotNull MacroDroidRoomDatabase roomDatabase, @NotNull View itemView, @Nullable DrawItemListener drawItemListener, int i4) {
        super(itemView, drawItemListener);
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.f11485e = roomDatabase;
        ButterKnife.bind(this, itemView);
        float f4 = i4;
        getTitle().setTextSize(2, f4);
        getLogText().setTextSize(2, f4);
    }

    private final void k() {
        refresh();
    }

    private final void l() {
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(null), 2, null);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.lang.String] */
    private final void m() {
        String replace$default;
        int indexOf$default;
        try {
            File file = new File(this.itemView.getContext().getFilesDir().toString() + "/MacroDroidUserLog.txt");
            StringBuilder sb = new StringBuilder();
            DrawerItemLog drawerItemLog = null;
            if (file.exists()) {
                ReversedLinesFileReader reversedLinesFileReader = new ReversedLinesFileReader(file, 4096, "utf-8");
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                int i4 = 0;
                while (true) {
                    ?? readLine = reversedLinesFileReader.readLine();
                    if (readLine != 0) {
                        objectRef.element = readLine;
                    } else {
                        objectRef.element = null;
                    }
                    if (readLine != 0) {
                        DrawerItemLog drawerItemLog2 = this.f11486f;
                        if (drawerItemLog2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("drawerItemLog");
                            drawerItemLog2 = null;
                        }
                        if (i4 >= drawerItemLog2.getMaxLines()) {
                            break;
                        }
                        T t3 = objectRef.element;
                        Intrinsics.checkNotNull(t3);
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) t3, "] - ", 0, false, 6, (Object) null);
                        if (indexOf$default != -1) {
                            T t4 = objectRef.element;
                            Intrinsics.checkNotNull(t4);
                            String substring = ((String) t4).substring(indexOf$default + 4);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            sb.append(substring);
                            sb.append("\n");
                        } else {
                            sb.append((String) objectRef.element);
                            sb.append("\n");
                        }
                        i4++;
                    } else {
                        break;
                    }
                }
            }
            if (sb.length() > 0) {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
                replace$default = kotlin.text.m.replace$default(sb2, "\\n", "\n", false, 4, (Object) null);
                getLogText().setText(replace$default);
                TextView logText = getLogText();
                DrawerItemLog drawerItemLog3 = this.f11486f;
                if (drawerItemLog3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("drawerItemLog");
                } else {
                    drawerItemLog = drawerItemLog3;
                }
                logText.setMaxLines(drawerItemLog.getMaxLines());
                return;
            }
            getLogText().setText(R.string.no_events_logged);
        } catch (Exception unused) {
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    @Nullable
    protected TextView[] f() {
        return new TextView[]{getTitle(), getLogText()};
    }

    @NotNull
    public final ImageView getDragHandle() {
        ImageView imageView = this.dragHandle;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHandle");
        return null;
    }

    @NotNull
    public final TextView getLogText() {
        TextView textView = this.logText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logText");
        return null;
    }

    @NotNull
    public final TextView getTitle() {
        TextView textView = this.title;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("title");
        return null;
    }

    @OnClick({R.id.log_container})
    public final void handleClick() {
        Intent intent;
        this.itemView.setEnabled(false);
        d();
        DrawerItemLog drawerItemLog = this.f11486f;
        if (drawerItemLog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawerItemLog");
            drawerItemLog = null;
        }
        if (drawerItemLog.isUserLog()) {
            intent = new Intent(this.itemView.getContext(), LogActivity.class);
            intent.putExtra(LogActivity.EXTRA_IS_USER_LOG, true);
        } else {
            intent = new Intent(this.itemView.getContext(), SystemLogActivity.class);
        }
        intent.addFlags(805306368);
        this.itemView.getContext().startActivity(intent);
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NotNull DrawerItem drawerItem, boolean z3) {
        int i4;
        Intrinsics.checkNotNullParameter(drawerItem, "drawerItem");
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemLog) {
            DrawerItemLog drawerItemLog = (DrawerItemLog) drawerItem;
            this.f11486f = drawerItemLog;
            DrawerItemLog drawerItemLog2 = null;
            if (drawerItemLog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("drawerItemLog");
                drawerItemLog = null;
            }
            setColor(drawerItemLog.getColor());
            TextView title = getTitle();
            DrawerItemLog drawerItemLog3 = this.f11486f;
            if (drawerItemLog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("drawerItemLog");
            } else {
                drawerItemLog2 = drawerItemLog3;
            }
            if (drawerItemLog2.isUserLog()) {
                i4 = R.string.user_log;
            } else {
                i4 = R.string.system_log;
            }
            title.setText(i4);
            k();
            if (z3) {
                getDragHandle().setVisibility(0);
                i(getDragHandle());
                return;
            }
            getDragHandle().setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("DrawerItemLog required".toString());
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void refresh() {
        DrawerItemLog drawerItemLog = this.f11486f;
        if (drawerItemLog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawerItemLog");
            drawerItemLog = null;
        }
        if (drawerItemLog.isUserLog()) {
            m();
        } else {
            l();
        }
    }

    public final void setDragHandle(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.dragHandle = imageView;
    }

    public final void setLogText(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.logText = textView;
    }

    public final void setTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.title = textView;
    }
}
