package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzop;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzak extends zzku {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f21444f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f21445g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f21446h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;"};

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f21447i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f21448j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f21449k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f21450l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f21451m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d  reason: collision with root package name */
    private final zzaj f21452d;

    /* renamed from: e  reason: collision with root package name */
    private final zzkq f21453e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(zzlh zzlhVar) {
        super(zzlhVar);
        this.f21453e = new zzkq(this.f21734a.zzax());
        this.f21734a.zzf();
        this.f21452d = new zzaj(this, this.f21734a.zzaw(), "google_app_measurement.db");
    }

    @WorkerThread
    private final long B(String str, String[] strArr, long j4) {
        Cursor cursor = null;
        try {
            try {
                cursor = G().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    long j5 = cursor.getLong(0);
                    cursor.close();
                    return j5;
                }
                cursor.close();
                return j4;
            } catch (SQLiteException e4) {
                this.f21734a.zzaA().zzd().zzc("Database error", str, e4);
                throw e4;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    static final void y(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    private final long z(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = G().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j4 = rawQuery.getLong(0);
                    rawQuery.close();
                    return j4;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e4) {
                this.f21734a.zzaA().zzd().zzc("Database error", str, e4);
                throw e4;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final int A(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        a();
        try {
            return G().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzd().zzd("Error deleting conditional property", zzet.f(str), this.f21734a.zzj().f(str2), e4);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @WorkerThread
    public final long C(String str, String str2) {
        long B;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        a();
        SQLiteDatabase G = G();
        G.beginTransaction();
        long j4 = 0;
        try {
            try {
                B = B("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                if (B == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (G.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        this.f21734a.zzaA().zzd().zzc("Failed to insert column (got -1). appId", zzet.f(str), "first_open_count");
                        return -1L;
                    }
                    B = 0;
                }
            } finally {
                G.endTransaction();
            }
        } catch (SQLiteException e4) {
            e = e4;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put("first_open_count", Long.valueOf(1 + B));
            if (G.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                this.f21734a.zzaA().zzd().zzc("Failed to update column (got 0). appId", zzet.f(str), "first_open_count");
                return -1L;
            }
            G.setTransactionSuccessful();
            return B;
        } catch (SQLiteException e5) {
            e = e5;
            j4 = B;
            this.f21734a.zzaA().zzd().zzd("Error inserting column. appId", zzet.f(str), "first_open_count", e);
            G.endTransaction();
            return j4;
        }
    }

    @WorkerThread
    public final long D() {
        return B("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    @WorkerThread
    public final long E() {
        return B("select max(timestamp) from raw_events", null, 0L);
    }

    public final long F(String str) {
        Preconditions.checkNotEmpty(str);
        return B("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final SQLiteDatabase G() {
        zzg();
        try {
            return this.f21452d.getWritableDatabase();
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzk().zzb("Error opening database", e4);
            throw e4;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00d6: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:44:0x00d6 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle H(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzg()
            r7.a()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.G()     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r2 != 0) goto L30
            com.google.android.gms.measurement.internal.zzgd r8 = r7.f21734a     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzaA()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzj()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r1.close()
            return r0
        L30:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzfs r3 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzmh r2 = com.google.android.gms.measurement.internal.zzlj.v(r3, r2)     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzlb r2 = r2.zzaD()     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzlh r8 = r7.f22016b     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r8.zzu()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.util.List r8 = r2.zzi()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            android.os.Bundle r2 = new android.os.Bundle     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.util.Iterator r8 = r8.iterator()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
        L56:
            boolean r3 = r8.hasNext()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r3 == 0) goto L9e
            java.lang.Object r3 = r8.next()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.lang.String r4 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            boolean r5 = r3.zzu()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r5 == 0) goto L74
            double r5 = r3.zza()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.putDouble(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            goto L56
        L74:
            boolean r5 = r3.zzv()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r5 == 0) goto L82
            float r3 = r3.zzb()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.putFloat(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            goto L56
        L82:
            boolean r5 = r3.zzy()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r5 == 0) goto L90
            java.lang.String r3 = r3.zzh()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.putString(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            goto L56
        L90:
            boolean r5 = r3.zzw()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r5 == 0) goto L56
            long r5 = r3.zzd()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.putLong(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            goto L56
        L9e:
            r1.close()
            return r2
        La2:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgd r3 = r7.f21734a     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.f(r8)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r3.zzc(r4, r8, r2)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r1.close()
            return r0
        Lba:
            r8 = move-exception
            goto Lc0
        Lbc:
            r8 = move-exception
            goto Ld7
        Lbe:
            r8 = move-exception
            r1 = r0
        Lc0:
            com.google.android.gms.measurement.internal.zzgd r2 = r7.f21734a     // Catch: java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch: java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch: java.lang.Throwable -> Ld5
            if (r1 == 0) goto Ld4
            r1.close()
        Ld4:
            return r0
        Ld5:
            r8 = move-exception
            r0 = r1
        Ld7:
            if (r0 == 0) goto Ldc
            r0.close()
        Ldc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.H(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0256: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:69:0x0256 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0123 A[Catch: SQLiteException -> 0x0236, all -> 0x0255, TryCatch #1 {all -> 0x0255, blocks: (B:4:0x0067, B:8:0x0071, B:10:0x00d4, B:15:0x00de, B:19:0x0128, B:21:0x0157, B:26:0x0161, B:30:0x017c, B:32:0x0187, B:33:0x0199, B:35:0x01aa, B:38:0x01c1, B:40:0x01d2, B:42:0x01da, B:46:0x01e2, B:47:0x01e5, B:49:0x01f6, B:50:0x01ff, B:52:0x020d, B:53:0x0216, B:55:0x021f, B:37:0x01b8, B:29:0x0178, B:18:0x0123, B:64:0x023c), top: B:73:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0178 A[Catch: SQLiteException -> 0x0236, all -> 0x0255, TryCatch #1 {all -> 0x0255, blocks: (B:4:0x0067, B:8:0x0071, B:10:0x00d4, B:15:0x00de, B:19:0x0128, B:21:0x0157, B:26:0x0161, B:30:0x017c, B:32:0x0187, B:33:0x0199, B:35:0x01aa, B:38:0x01c1, B:40:0x01d2, B:42:0x01da, B:46:0x01e2, B:47:0x01e5, B:49:0x01f6, B:50:0x01ff, B:52:0x020d, B:53:0x0216, B:55:0x021f, B:37:0x01b8, B:29:0x0178, B:18:0x0123, B:64:0x023c), top: B:73:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0187 A[Catch: SQLiteException -> 0x0236, all -> 0x0255, TryCatch #1 {all -> 0x0255, blocks: (B:4:0x0067, B:8:0x0071, B:10:0x00d4, B:15:0x00de, B:19:0x0128, B:21:0x0157, B:26:0x0161, B:30:0x017c, B:32:0x0187, B:33:0x0199, B:35:0x01aa, B:38:0x01c1, B:40:0x01d2, B:42:0x01da, B:46:0x01e2, B:47:0x01e5, B:49:0x01f6, B:50:0x01ff, B:52:0x020d, B:53:0x0216, B:55:0x021f, B:37:0x01b8, B:29:0x0178, B:18:0x0123, B:64:0x023c), top: B:73:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01aa A[Catch: SQLiteException -> 0x0236, all -> 0x0255, TryCatch #1 {all -> 0x0255, blocks: (B:4:0x0067, B:8:0x0071, B:10:0x00d4, B:15:0x00de, B:19:0x0128, B:21:0x0157, B:26:0x0161, B:30:0x017c, B:32:0x0187, B:33:0x0199, B:35:0x01aa, B:38:0x01c1, B:40:0x01d2, B:42:0x01da, B:46:0x01e2, B:47:0x01e5, B:49:0x01f6, B:50:0x01ff, B:52:0x020d, B:53:0x0216, B:55:0x021f, B:37:0x01b8, B:29:0x0178, B:18:0x0123, B:64:0x023c), top: B:73:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01d2 A[Catch: SQLiteException -> 0x0236, all -> 0x0255, TryCatch #1 {all -> 0x0255, blocks: (B:4:0x0067, B:8:0x0071, B:10:0x00d4, B:15:0x00de, B:19:0x0128, B:21:0x0157, B:26:0x0161, B:30:0x017c, B:32:0x0187, B:33:0x0199, B:35:0x01aa, B:38:0x01c1, B:40:0x01d2, B:42:0x01da, B:46:0x01e2, B:47:0x01e5, B:49:0x01f6, B:50:0x01ff, B:52:0x020d, B:53:0x0216, B:55:0x021f, B:37:0x01b8, B:29:0x0178, B:18:0x0123, B:64:0x023c), top: B:73:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f6 A[Catch: SQLiteException -> 0x0236, all -> 0x0255, TryCatch #1 {all -> 0x0255, blocks: (B:4:0x0067, B:8:0x0071, B:10:0x00d4, B:15:0x00de, B:19:0x0128, B:21:0x0157, B:26:0x0161, B:30:0x017c, B:32:0x0187, B:33:0x0199, B:35:0x01aa, B:38:0x01c1, B:40:0x01d2, B:42:0x01da, B:46:0x01e2, B:47:0x01e5, B:49:0x01f6, B:50:0x01ff, B:52:0x020d, B:53:0x0216, B:55:0x021f, B:37:0x01b8, B:29:0x0178, B:18:0x0123, B:64:0x023c), top: B:73:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x020d A[Catch: SQLiteException -> 0x0236, all -> 0x0255, TryCatch #1 {all -> 0x0255, blocks: (B:4:0x0067, B:8:0x0071, B:10:0x00d4, B:15:0x00de, B:19:0x0128, B:21:0x0157, B:26:0x0161, B:30:0x017c, B:32:0x0187, B:33:0x0199, B:35:0x01aa, B:38:0x01c1, B:40:0x01d2, B:42:0x01da, B:46:0x01e2, B:47:0x01e5, B:49:0x01f6, B:50:0x01ff, B:52:0x020d, B:53:0x0216, B:55:0x021f, B:37:0x01b8, B:29:0x0178, B:18:0x0123, B:64:0x023c), top: B:73:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x021f A[Catch: SQLiteException -> 0x0236, all -> 0x0255, TRY_LEAVE, TryCatch #1 {all -> 0x0255, blocks: (B:4:0x0067, B:8:0x0071, B:10:0x00d4, B:15:0x00de, B:19:0x0128, B:21:0x0157, B:26:0x0161, B:30:0x017c, B:32:0x0187, B:33:0x0199, B:35:0x01aa, B:38:0x01c1, B:40:0x01d2, B:42:0x01da, B:46:0x01e2, B:47:0x01e5, B:49:0x01f6, B:50:0x01ff, B:52:0x020d, B:53:0x0216, B:55:0x021f, B:37:0x01b8, B:29:0x0178, B:18:0x0123, B:64:0x023c), top: B:73:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0259  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzh I(java.lang.String r39) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.I(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0123: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:31:0x0123 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0126  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzac J(java.lang.String r31, java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.J(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    @WorkerThread
    public final zzai K(long j4, String str, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return L(j4, str, 1L, false, false, z5, false, z7);
    }

    @WorkerThread
    public final zzai L(long j4, String str, long j5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Preconditions.checkNotEmpty(str);
        zzg();
        a();
        String[] strArr = {str};
        zzai zzaiVar = new zzai();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase G = G();
                Cursor query = G.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    this.f21734a.zzaA().zzk().zzb("Not updating daily counts, app is not known. appId", zzet.f(str));
                    query.close();
                    return zzaiVar;
                }
                if (query.getLong(0) == j4) {
                    zzaiVar.f21439b = query.getLong(1);
                    zzaiVar.f21438a = query.getLong(2);
                    zzaiVar.f21440c = query.getLong(3);
                    zzaiVar.f21441d = query.getLong(4);
                    zzaiVar.f21442e = query.getLong(5);
                }
                if (z3) {
                    zzaiVar.f21439b += j5;
                }
                if (z4) {
                    zzaiVar.f21438a += j5;
                }
                if (z5) {
                    zzaiVar.f21440c += j5;
                }
                if (z6) {
                    zzaiVar.f21441d += j5;
                }
                if (z7) {
                    zzaiVar.f21442e += j5;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j4));
                contentValues.put("daily_public_events_count", Long.valueOf(zzaiVar.f21438a));
                contentValues.put("daily_events_count", Long.valueOf(zzaiVar.f21439b));
                contentValues.put("daily_conversions_count", Long.valueOf(zzaiVar.f21440c));
                contentValues.put("daily_error_events_count", Long.valueOf(zzaiVar.f21441d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzaiVar.f21442e));
                G.update("apps", contentValues, "app_id=?", strArr);
                query.close();
                return zzaiVar;
            } catch (SQLiteException e4) {
                this.f21734a.zzaA().zzd().zzc("Error updating daily counts. appId", zzet.f(str), e4);
                if (0 != 0) {
                    cursor.close();
                }
                return zzaiVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0150  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzaq M(java.lang.String r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.M(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaq");
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00a3: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:28:0x00a3 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzlm O(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r19.zzg()
            r19.a()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.G()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7d
            java.lang.String r12 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r2 = "value"
            java.lang.String r3 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r0, r2, r3}     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7d
            java.lang.String r14 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7d
            r2 = 0
            r15[r2] = r20     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7d
            r3 = 1
            r15[r3] = r9     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7d
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7d
            boolean r4 = r11.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            if (r4 != 0) goto L40
            r11.close()
            return r10
        L40:
            long r6 = r11.getLong(r2)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            java.lang.Object r8 = r1.P(r11, r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            if (r8 != 0) goto L4e
            r11.close()
            return r10
        L4e:
            java.lang.String r4 = r11.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            com.google.android.gms.measurement.internal.zzlm r0 = new com.google.android.gms.measurement.internal.zzlm     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            boolean r2 = r11.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            if (r2 == 0) goto L75
            com.google.android.gms.measurement.internal.zzgd r2 = r1.f21734a     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.f(r20)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
            r2.zzb(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> La2
        L75:
            r11.close()
            return r0
        L79:
            r0 = move-exception
            goto L7f
        L7b:
            r0 = move-exception
            goto La4
        L7d:
            r0 = move-exception
            r11 = r10
        L7f:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.f21734a     // Catch: java.lang.Throwable -> La2
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch: java.lang.Throwable -> La2
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.f(r20)     // Catch: java.lang.Throwable -> La2
            com.google.android.gms.measurement.internal.zzgd r5 = r1.f21734a     // Catch: java.lang.Throwable -> La2
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzj()     // Catch: java.lang.Throwable -> La2
            java.lang.String r5 = r5.f(r9)     // Catch: java.lang.Throwable -> La2
            r2.zzd(r3, r4, r5, r0)     // Catch: java.lang.Throwable -> La2
            if (r11 == 0) goto La1
            r11.close()
        La1:
            return r10
        La2:
            r0 = move-exception
            r10 = r11
        La4:
            if (r10 == 0) goto La9
            r10.close()
        La9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.O(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzlm");
    }

    @VisibleForTesting
    @WorkerThread
    final Object P(Cursor cursor, int i4) {
        int type = cursor.getType(i4);
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            this.f21734a.zzaA().zzd().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                            return null;
                        }
                        this.f21734a.zzaA().zzd().zza("Loaded invalid blob type value, ignoring it");
                        return null;
                    }
                    return cursor.getString(i4);
                }
                return Double.valueOf(cursor.getDouble(i4));
            }
            return Long.valueOf(cursor.getLong(i4));
        }
        this.f21734a.zzaA().zzd().zza("Loaded invalid null value from database");
        return null;
    }

    @WorkerThread
    public final List Q(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        a();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return R(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0058, code lost:
        r2 = r27.f21734a.zzaA().zzd();
        r27.f21734a.zzf();
        r2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List R(java.lang.String r28, java.lang.String[] r29) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.R(java.lang.String, java.lang.String[]):java.util.List");
    }

    @WorkerThread
    public final List S(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        a();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                this.f21734a.zzf();
                cursor = G().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j4 = cursor.getLong(2);
                        Object P = P(cursor, 3);
                        if (P == null) {
                            this.f21734a.zzaA().zzd().zzb("Read invalid user property value, ignoring it. appId", zzet.f(str));
                        } else {
                            arrayList.add(new zzlm(str, str2, string, j4, P));
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return arrayList;
                }
                cursor.close();
                return arrayList;
            } catch (SQLiteException e4) {
                this.f21734a.zzaA().zzd().zzc("Error querying user properties. appId", zzet.f(str), e4);
                List emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a7, code lost:
        r0 = r17.f21734a.zzaA().zzd();
        r17.f21734a.zzf();
        r0.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0123 A[DONT_GENERATE] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List T(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.T(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void U(List list) {
        zzg();
        a();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (!l()) {
            return;
        }
        String str = "(" + TextUtils.join(",", list) + ")";
        if (z("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
            this.f21734a.zzaA().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            G().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzd().zzb("Error incrementing retry count. error", e4);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzku
    protected final boolean c() {
        return false;
    }

    @WorkerThread
    public final void d(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        a();
        try {
            G().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzd().zzd("Error deleting user property. appId", zzet.f(str), this.f21734a.zzj().f(str2), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0347, code lost:
        if (G().insertWithOnConflict("property_filters", null, r11, 5) != (-1)) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0349, code lost:
        r23.f21734a.zzaA().zzd().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzet.f(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x035d, code lost:
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0361, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0362, code lost:
        r23.f21734a.zzaA().zzd().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzet.f(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0375, code lost:
        a();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        r0 = G();
        r3 = r17;
        r0.delete("property_filters", r3, new java.lang.String[]{r24, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", r3, new java.lang.String[]{r24, java.lang.String.valueOf(r10)});
        r17 = r3;
        r7 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x03ac, code lost:
        r7 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x017a, code lost:
        r11 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0186, code lost:
        if (r11.hasNext() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0192, code lost:
        if (((com.google.android.gms.internal.measurement.zzet) r11.next()).zzj() != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0194, code lost:
        r23.f21734a.zzaA().zzk().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzet.f(r24), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01ad, code lost:
        r11 = r0.zzg().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01c3, code lost:
        if (r11.hasNext() == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01c5, code lost:
        r12 = (com.google.android.gms.internal.measurement.zzek) r11.next();
        a();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01df, code lost:
        if (r12.zzg().isEmpty() == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e1, code lost:
        r0 = r23.f21734a.zzaA().zzk();
        r9 = com.google.android.gms.measurement.internal.zzet.f(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f9, code lost:
        if (r12.zzp() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01fb, code lost:
        r20 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0206, code lost:
        r20 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0208, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r20));
        r21 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0213, code lost:
        r3 = r12.zzbx();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r24);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x022c, code lost:
        if (r12.zzp() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x022e, code lost:
        r9 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0237, code lost:
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0238, code lost:
        r7.put("filter_id", r9);
        r7.put("event_name", r12.zzg());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0248, code lost:
        if (r12.zzq() == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x024a, code lost:
        r9 = java.lang.Boolean.valueOf(r12.zzn());
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0253, code lost:
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0254, code lost:
        r7.put("session_scoped", r9);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0268, code lost:
        if (G().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x026a, code lost:
        r23.f21734a.zzaA().zzd().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzet.f(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x027d, code lost:
        r7 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0283, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0284, code lost:
        r23.f21734a.zzaA().zzd().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzet.f(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0299, code lost:
        r21 = r7;
        r0 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02a7, code lost:
        if (r0.hasNext() == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02a9, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzet) r0.next();
        a();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02c3, code lost:
        if (r3.zze().isEmpty() == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02c5, code lost:
        r0 = r23.f21734a.zzaA().zzk();
        r8 = com.google.android.gms.measurement.internal.zzet.f(r24);
        r9 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02dd, code lost:
        if (r3.zzj() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02df, code lost:
        r3 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02e8, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02e9, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r9, java.lang.String.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02f2, code lost:
        r7 = r3.zzbx();
        r11 = new android.content.ContentValues();
        r11.put("app_id", r24);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0309, code lost:
        if (r3.zzj() == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x030b, code lost:
        r12 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0314, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0315, code lost:
        r11.put("filter_id", r12);
        r22 = r0;
        r11.put("property_name", r3.zze());
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0327, code lost:
        if (r3.zzk() == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0329, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0332, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0333, code lost:
        r11.put("session_scoped", r0);
        r11.put("data", r7);
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(java.lang.String r24, java.util.List r25) {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.e(java.lang.String, java.util.List):void");
    }

    @WorkerThread
    public final void f() {
        a();
        G().setTransactionSuccessful();
    }

    @WorkerThread
    public final void g(zzh zzhVar) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        a();
        String l02 = zzhVar.l0();
        Preconditions.checkNotNull(l02);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", l02);
        contentValues.put("app_instance_id", zzhVar.m0());
        contentValues.put("gmp_app_id", zzhVar.a());
        contentValues.put("resettable_device_id_hash", zzhVar.c());
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.e0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.f0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.d0()));
        contentValues.put("app_version", zzhVar.o0());
        contentValues.put("app_store", zzhVar.n0());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.c0()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.Z()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.O()));
        contentValues.put("day", Long.valueOf(zzhVar.Y()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.W()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.V()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.T()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.S()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.b0()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.R()));
        contentValues.put("firebase_instance_id", zzhVar.p0());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.U()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.X()));
        contentValues.put("health_monitor_sample", zzhVar.b());
        zzhVar.A();
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.N()));
        contentValues.put("admob_app_id", zzhVar.j0());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.a0()));
        contentValues.put("session_stitching_token", zzhVar.d());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.Q()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.h0()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.g0()));
        List e4 = zzhVar.e();
        if (e4 != null) {
            if (e4.isEmpty()) {
                this.f21734a.zzaA().zzk().zzb("Safelisted events should not be an empty list. appId", l02);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", e4));
            }
        }
        zzop.zzc();
        if (this.f21734a.zzf().zzs(null, zzeg.zzak) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase G = G();
            if (G.update("apps", contentValues, "app_id = ?", new String[]{l02}) == 0 && G.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.f21734a.zzaA().zzd().zzb("Failed to insert/update app (got -1). appId", zzet.f(l02));
            }
        } catch (SQLiteException e5) {
            this.f21734a.zzaA().zzd().zzc("Error storing app. appId", zzet.f(l02), e5);
        }
    }

    @WorkerThread
    public final void h(zzaq zzaqVar) {
        Long l4;
        Preconditions.checkNotNull(zzaqVar);
        zzg();
        a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaqVar.f21471a);
        contentValues.put("name", zzaqVar.f21472b);
        contentValues.put("lifetime_count", Long.valueOf(zzaqVar.f21473c));
        contentValues.put("current_bundle_count", Long.valueOf(zzaqVar.f21474d));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzaqVar.f21476f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzaqVar.f21477g));
        contentValues.put("last_bundled_day", zzaqVar.f21478h);
        contentValues.put("last_sampled_complex_event_id", zzaqVar.f21479i);
        contentValues.put("last_sampling_rate", zzaqVar.f21480j);
        contentValues.put("current_session_count", Long.valueOf(zzaqVar.f21475e));
        Boolean bool = zzaqVar.f21481k;
        if (bool != null && bool.booleanValue()) {
            l4 = 1L;
        } else {
            l4 = null;
        }
        contentValues.put("last_exempt_from_sampling", l4);
        try {
            if (G().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.f21734a.zzaA().zzd().zzb("Failed to insert/update event aggregates (got -1). appId", zzet.f(zzaqVar.f21471a));
            }
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzd().zzc("Error storing event aggregates. appId", zzet.f(zzaqVar.f21471a), e4);
        }
    }

    public final boolean i() {
        if (z("select count(1) > 0 from raw_events", null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean j() {
        if (z("select count(1) > 0 from queue where has_realtime = 1", null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        if (z("select count(1) > 0 from raw_events where realtime = 1", null) != 0) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    protected final boolean l() {
        Context zzaw = this.f21734a.zzaw();
        this.f21734a.zzf();
        return zzaw.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean m(String str, Long l4, long j4, com.google.android.gms.internal.measurement.zzft zzftVar) {
        zzg();
        a();
        Preconditions.checkNotNull(zzftVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l4);
        byte[] zzbx = zzftVar.zzbx();
        this.f21734a.zzaA().zzj().zzc("Saving complex main event, appId, data size", this.f21734a.zzj().d(str), Integer.valueOf(zzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l4);
        contentValues.put("children_to_process", Long.valueOf(j4));
        contentValues.put("main_event", zzbx);
        try {
            if (G().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                this.f21734a.zzaA().zzd().zzb("Failed to insert complex main event (got -1). appId", zzet.f(str));
                return false;
            }
            return true;
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzd().zzc("Error storing complex main event. appId", zzet.f(str), e4);
            return false;
        }
    }

    @WorkerThread
    public final boolean n(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzg();
        a();
        String str = zzacVar.zza;
        Preconditions.checkNotNull(str);
        if (O(str, zzacVar.zzc.zzb) == null) {
            long z3 = z("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.f21734a.zzf();
            if (z3 >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzacVar.zzb);
        contentValues.put("name", zzacVar.zzc.zzb);
        y(contentValues, "value", Preconditions.checkNotNull(zzacVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzacVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzacVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzacVar.zzh));
        contentValues.put("timed_out_event", this.f21734a.zzv().G(zzacVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzacVar.zzd));
        contentValues.put("triggered_event", this.f21734a.zzv().G(zzacVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzacVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzacVar.zzj));
        contentValues.put("expired_event", this.f21734a.zzv().G(zzacVar.zzk));
        try {
            if (G().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                this.f21734a.zzaA().zzd().zzb("Failed to insert/update conditional user property (got -1)", zzet.f(str));
            }
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzd().zzc("Error storing conditional user property", zzet.f(str), e4);
        }
        return true;
    }

    @WorkerThread
    public final boolean o(zzlm zzlmVar) {
        Preconditions.checkNotNull(zzlmVar);
        zzg();
        a();
        if (O(zzlmVar.f22068a, zzlmVar.f22070c) == null) {
            if (zzlp.C(zzlmVar.f22070c)) {
                if (z("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzlmVar.f22068a}) >= this.f21734a.zzf().zzf(zzlmVar.f22068a, zzeg.zzG, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzlmVar.f22070c)) {
                long z3 = z("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzlmVar.f22068a, zzlmVar.f22069b});
                this.f21734a.zzf();
                if (z3 >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzlmVar.f22068a);
        contentValues.put("origin", zzlmVar.f22069b);
        contentValues.put("name", zzlmVar.f22070c);
        contentValues.put("set_timestamp", Long.valueOf(zzlmVar.f22071d));
        y(contentValues, "value", zzlmVar.f22072e);
        try {
            if (G().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.f21734a.zzaA().zzd().zzb("Failed to insert/update user property (got -1). appId", zzet.f(zzlmVar.f22068a));
            }
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzd().zzc("Error storing user property. appId", zzet.f(zzlmVar.f22068a), e4);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0225: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:99:0x0225 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void x(String str, long j4, long j5, zzle zzleVar) {
        ?? r4;
        Cursor cursor;
        Cursor rawQuery;
        String string;
        String str2;
        String[] strArr;
        Preconditions.checkNotNull(zzleVar);
        zzg();
        a();
        Cursor cursor2 = null;
        r3 = null;
        r3 = null;
        String str3 = null;
        try {
            try {
                SQLiteDatabase G = G();
                r4 = TextUtils.isEmpty(null);
                String str4 = "";
                try {
                    if (r4 != 0) {
                        int i4 = (j5 > (-1L) ? 1 : (j5 == (-1L) ? 0 : -1));
                        String[] strArr2 = i4 != 0 ? new String[]{String.valueOf(j5), String.valueOf(j4)} : new String[]{String.valueOf(j4)};
                        if (i4 != 0) {
                            str4 = "rowid <= ? and ";
                        }
                        rawQuery = G.rawQuery("select app_id, metadata_fingerprint from raw_events where " + str4 + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", strArr2);
                        if (!rawQuery.moveToFirst()) {
                            rawQuery.close();
                            return;
                        }
                        str3 = rawQuery.getString(0);
                        string = rawQuery.getString(1);
                        rawQuery.close();
                    } else {
                        int i5 = (j5 > (-1L) ? 1 : (j5 == (-1L) ? 0 : -1));
                        String[] strArr3 = i5 != 0 ? new String[]{null, String.valueOf(j5)} : new String[]{null};
                        if (i5 != 0) {
                            str4 = " and rowid <= ?";
                        }
                        rawQuery = G.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + str4 + " order by rowid limit 1;", strArr3);
                        if (!rawQuery.moveToFirst()) {
                            rawQuery.close();
                            return;
                        } else {
                            string = rawQuery.getString(0);
                            rawQuery.close();
                        }
                    }
                    Cursor cursor3 = rawQuery;
                    String str5 = string;
                    try {
                        Cursor query = G.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str3, str5}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                        try {
                            if (!query.moveToFirst()) {
                                this.f21734a.zzaA().zzd().zzb("Raw event metadata record is missing. appId", zzet.f(str3));
                                query.close();
                                return;
                            }
                            try {
                                try {
                                    com.google.android.gms.internal.measurement.zzgd zzgdVar = (com.google.android.gms.internal.measurement.zzgd) ((com.google.android.gms.internal.measurement.zzgc) zzlj.v(com.google.android.gms.internal.measurement.zzgd.zzu(), query.getBlob(0))).zzaD();
                                    if (query.moveToNext()) {
                                        this.f21734a.zzaA().zzk().zzb("Get multiple raw event metadata records, expected one. appId", zzet.f(str3));
                                    }
                                    query.close();
                                    Preconditions.checkNotNull(zzgdVar);
                                    zzleVar.f22034a = zzgdVar;
                                    if (j5 != -1) {
                                        str2 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                        strArr = new String[]{str3, str5, String.valueOf(j5)};
                                    } else {
                                        str2 = "app_id = ? and metadata_fingerprint = ?";
                                        strArr = new String[]{str3, str5};
                                    }
                                    Cursor query2 = G.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str2, strArr, null, null, "rowid", null);
                                    if (query2.moveToFirst()) {
                                        do {
                                            long j6 = query2.getLong(0);
                                            try {
                                                com.google.android.gms.internal.measurement.zzfs zzfsVar = (com.google.android.gms.internal.measurement.zzfs) zzlj.v(com.google.android.gms.internal.measurement.zzft.zze(), query2.getBlob(3));
                                                zzfsVar.zzi(query2.getString(1));
                                                zzfsVar.zzm(query2.getLong(2));
                                                if (!zzleVar.a(j6, (com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaD())) {
                                                    query2.close();
                                                    return;
                                                }
                                            } catch (IOException e4) {
                                                this.f21734a.zzaA().zzd().zzc("Data loss. Failed to merge raw event. appId", zzet.f(str3), e4);
                                            }
                                        } while (query2.moveToNext());
                                        query2.close();
                                        return;
                                    }
                                    this.f21734a.zzaA().zzk().zzb("Raw event data disappeared while in transaction. appId", zzet.f(str3));
                                    query2.close();
                                } catch (SQLiteException e5) {
                                    e = e5;
                                    r4 = query;
                                    this.f21734a.zzaA().zzd().zzc("Data loss. Error selecting raw event. appId", zzet.f(str3), e);
                                    if (r4 != 0) {
                                        r4.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = query;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            } catch (IOException e6) {
                                this.f21734a.zzaA().zzd().zzc("Data loss. Failed to merge raw event metadata. appId", zzet.f(str3), e6);
                                query.close();
                            }
                        } catch (SQLiteException e7) {
                            e = e7;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (SQLiteException e8) {
                        e = e8;
                        r4 = cursor3;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = cursor3;
                    }
                } catch (SQLiteException e9) {
                    e = e9;
                }
            } catch (SQLiteException e10) {
                e = e10;
                r4 = 0;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            cursor2 = cursor;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzr() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.G()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L22
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            r0.close()
            return r1
        L1a:
            r0.close()
            return r1
        L1e:
            r2 = move-exception
            goto L25
        L20:
            r0 = move-exception
            goto L3e
        L22:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L25:
            com.google.android.gms.measurement.internal.zzgd r3 = r6.f21734a     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L39
            r0.close()
        L39:
            return r1
        L3a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzr():java.lang.String");
    }

    @WorkerThread
    public final void zzw() {
        a();
        G().beginTransaction();
    }

    @WorkerThread
    public final void zzx() {
        a();
        G().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzz() {
        zzg();
        a();
        if (l()) {
            long zza = this.f22016b.zzs().zza.zza();
            long elapsedRealtime = this.f21734a.zzax().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza);
            this.f21734a.zzf();
            if (abs > ((Long) zzeg.zzy.zza(null)).longValue()) {
                this.f22016b.zzs().zza.zzb(elapsedRealtime);
                zzg();
                a();
                if (l()) {
                    SQLiteDatabase G = G();
                    this.f21734a.zzf();
                    int delete = G.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.f21734a.zzax().currentTimeMillis()), String.valueOf(zzag.zzA())});
                    if (delete > 0) {
                        this.f21734a.zzaA().zzj().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }
}
