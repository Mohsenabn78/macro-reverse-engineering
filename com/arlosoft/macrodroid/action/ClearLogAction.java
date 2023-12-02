package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ClearLogActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.SystemLogEntryDao;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.io.File;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClearLogAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class ClearLogAction extends Action {
    private boolean m_userLog;
    @Inject
    public transient MacroDroidRoomDatabase roomDatabase;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ClearLogAction> CREATOR = new Parcelable.Creator<ClearLogAction>() { // from class: com.arlosoft.macrodroid.action.ClearLogAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ClearLogAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ClearLogAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ClearLogAction[] newArray(int i4) {
            return new ClearLogAction[i4];
        }
    };

    /* compiled from: ClearLogAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

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
                SystemLogEntryDao systemLogEntryDao = ClearLogAction.this.getRoomDatabase().systemLogEntryDao();
                this.label = 1;
                if (systemLogEntryDao.clearAll(this) == coroutine_suspended) {
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

    public /* synthetic */ ClearLogAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] getOptions() {
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        return new String[]{companion.getInstance().getString(R.string.user_log), companion.getInstance().getString(R.string.action_clear_log_option_system_log)};
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_userLog = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_userLog ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = getOptions()[!this.m_userLog ? 1 : 0];
        Intrinsics.checkNotNullExpressionValue(str, "getOptions()[if (m_userLog) 0 else 1]");
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo clearLogActionInfo = ClearLogActionInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(clearLogActionInfo, "getInstance()");
        return clearLogActionInfo;
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

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        if (!this.m_userLog) {
            kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(null), 2, null);
            return;
        }
        File file = new File(getContext().getFilesDir(), LogAction.LOG_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return getOptions();
    }

    public final void setRoomDatabase(@NotNull MacroDroidRoomDatabase macroDroidRoomDatabase) {
        Intrinsics.checkNotNullParameter(macroDroidRoomDatabase, "<set-?>");
        this.roomDatabase = macroDroidRoomDatabase;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(!this.m_userLog ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClearLogAction(@Nullable Activity activity, @NotNull Macro macro) {
        this();
        Intrinsics.checkNotNullParameter(macro, "macro");
        setActivity(activity);
        this.m_macro = macro;
    }

    private ClearLogAction() {
        init();
        this.m_userLog = true;
    }

    private ClearLogAction(Parcel parcel) {
        super(parcel);
        init();
        this.m_userLog = parcel.readInt() == 0;
    }

    /* compiled from: ClearLogAction.kt */
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
}
