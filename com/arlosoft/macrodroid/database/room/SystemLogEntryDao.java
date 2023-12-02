package com.arlosoft.macrodroid.database.room;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemLogEntryDao.kt */
@Dao
/* loaded from: classes3.dex */
public interface SystemLogEntryDao {

    /* compiled from: SystemLogEntryDao.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SystemLogEntryDao.kt */
        /* loaded from: classes3.dex */
        public static final class a extends ContinuationImpl {
            int I$0;
            Object L$0;
            int label;
            /* synthetic */ Object result;

            a(Continuation<? super a> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return DefaultImpls.addLogEntryAndDeleteOld(null, null, 0, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[RETURN] */
        @androidx.room.Transaction
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object addLogEntryAndDeleteOld(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.database.room.SystemLogEntryDao r6, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.database.room.SystemLogEntry r7, int r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                boolean r0 = r9 instanceof com.arlosoft.macrodroid.database.room.SystemLogEntryDao.DefaultImpls.a
                if (r0 == 0) goto L13
                r0 = r9
                com.arlosoft.macrodroid.database.room.SystemLogEntryDao$DefaultImpls$a r0 = (com.arlosoft.macrodroid.database.room.SystemLogEntryDao.DefaultImpls.a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.arlosoft.macrodroid.database.room.SystemLogEntryDao$DefaultImpls$a r0 = new com.arlosoft.macrodroid.database.room.SystemLogEntryDao$DefaultImpls$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3e
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.throwOnFailure(r9)
                goto L62
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                int r8 = r0.I$0
                java.lang.Object r6 = r0.L$0
                com.arlosoft.macrodroid.database.room.SystemLogEntryDao r6 = (com.arlosoft.macrodroid.database.room.SystemLogEntryDao) r6
                kotlin.ResultKt.throwOnFailure(r9)
                goto L4e
            L3e:
                kotlin.ResultKt.throwOnFailure(r9)
                r0.L$0 = r6
                r0.I$0 = r8
                r0.label = r4
                java.lang.Object r9 = r6.addLogEntry(r7, r0)
                if (r9 != r1) goto L4e
                return r1
            L4e:
                java.lang.Number r9 = (java.lang.Number) r9
                long r4 = r9.longValue()
                long r7 = (long) r8
                long r4 = r4 - r7
                r7 = 0
                r0.L$0 = r7
                r0.label = r3
                java.lang.Object r6 = r6.deleteBeforeId(r4, r0)
                if (r6 != r1) goto L62
                return r1
            L62:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.database.room.SystemLogEntryDao.DefaultImpls.addLogEntryAndDeleteOld(com.arlosoft.macrodroid.database.room.SystemLogEntryDao, com.arlosoft.macrodroid.database.room.SystemLogEntry, int, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static /* synthetic */ Object getAll$default(SystemLogEntryDao systemLogEntryDao, LogLevel logLevel, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    logLevel = LogLevel.INFO;
                }
                return systemLogEntryDao.getAll(logLevel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAll");
        }

        public static /* synthetic */ PagingSource pagingSourceFiltered$default(SystemLogEntryDao systemLogEntryDao, int i4, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    i4 = LogLevel.INFO.getLevelInt();
                }
                return systemLogEntryDao.pagingSourceFiltered(i4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pagingSourceFiltered");
        }

        public static /* synthetic */ PagingSource pagingSourceWithFilterAndSearch$default(SystemLogEntryDao systemLogEntryDao, String str, LogLevel logLevel, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = "%%";
                }
                if ((i4 & 2) != 0) {
                    logLevel = LogLevel.INFO;
                }
                return systemLogEntryDao.pagingSourceWithFilterAndSearch(str, logLevel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pagingSourceWithFilterAndSearch");
        }
    }

    @Insert(onConflict = 1)
    @Nullable
    Object addLogEntry(@NotNull SystemLogEntry systemLogEntry, @NotNull Continuation<? super Long> continuation);

    @Transaction
    @Nullable
    Object addLogEntryAndDeleteOld(@NotNull SystemLogEntry systemLogEntry, int i4, @NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM SystemLogEntry")
    @Nullable
    Object clearAll(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM SystemLogEntry WHERE id < :id")
    @Nullable
    Object deleteBeforeId(long j4, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM SystemLogEntry WHERE logLevel >= :logLevel")
    @Nullable
    Object getAll(@NotNull LogLevel logLevel, @NotNull Continuation<? super List<SystemLogEntry>> continuation);

    @RawQuery(observedEntities = {SystemLogEntry.class})
    @Nullable
    Object getAllFiltered(@NotNull SupportSQLiteQuery supportSQLiteQuery, @NotNull Continuation<? super List<SystemLogEntry>> continuation);

    @RawQuery(observedEntities = {SystemLogEntry.class})
    @NotNull
    PagingSource<Integer, SystemLogEntry> getFiltered(@NotNull SupportSQLiteQuery supportSQLiteQuery);

    @Query("SELECT * FROM SystemLogEntry WHERE logLevel >= :logLevel ORDER BY id DESC LIMIT :count")
    @Nullable
    Object getLatest(int i4, int i5, @NotNull Continuation<? super List<SystemLogEntry>> continuation);

    @Query("SELECT * FROM SystemLogEntry ORDER BY id DESC")
    @NotNull
    PagingSource<Integer, SystemLogEntry> pagingSourceAll();

    @Query("SELECT * FROM SystemLogEntry WHERE logLevel >= :logLevel ORDER BY id DESC ")
    @NotNull
    PagingSource<Integer, SystemLogEntry> pagingSourceFiltered(int i4);

    @Query("SELECT * FROM SystemLogEntry WHERE logText LIKE :query")
    @NotNull
    PagingSource<Integer, SystemLogEntry> pagingSourceSearch(@NotNull String str);

    @Query("SELECT * FROM SystemLogEntry WHERE logText LIKE :searchText AND logLevel >= :logLevel")
    @NotNull
    PagingSource<Integer, SystemLogEntry> pagingSourceWithFilterAndSearch(@NotNull String str, @NotNull LogLevel logLevel);
}
