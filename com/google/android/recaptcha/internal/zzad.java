package com.google.android.recaptcha.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzad extends SQLiteOpenHelper {
    @NotNull
    public static final zzab zza = new zzab(null);
    @Nullable
    private static zzad zzb;

    public /* synthetic */ zzad(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        super(context, "cesdb", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(@NotNull SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    public final int zza(@NotNull List list) {
        String joinToString$default;
        if (!list.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ", ", "(", ")", 0, null, zzac.zza, 24, null);
            return getWritableDatabase().delete("ce", "id IN ".concat(String.valueOf(joinToString$default)), null);
        }
        return 0;
    }

    public final int zzb() {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM ce", null);
        try {
            if (!rawQuery.moveToNext()) {
                return -1;
            }
            return rawQuery.getInt(0);
        } catch (Exception unused) {
            return -1;
        } finally {
            rawQuery.close();
        }
    }

    @NotNull
    public final List zzd() {
        List emptyList;
        Cursor query = getReadableDatabase().query("ce", null, null, null, null, null, "ts ASC");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzae(query.getString(query.getColumnIndexOrThrow("ss")), query.getLong(query.getColumnIndexOrThrow("ts")), query.getInt(query.getColumnIndexOrThrow("id"))));
            } catch (Exception unused) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public final boolean zzf(@NotNull zzae zzaeVar) {
        List listOf;
        listOf = e.listOf(zzaeVar);
        if (zza(listOf) == 1) {
            return true;
        }
        return false;
    }
}
