package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzem extends zzf {

    /* renamed from: c  reason: collision with root package name */
    private final zzel f21520c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21521d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzem(zzgd zzgdVar) {
        super(zzgdVar);
        Context zzaw = this.f21734a.zzaw();
        this.f21734a.zzf();
        this.f21520c = new zzel(this, zzaw, "google_app_measurement_local.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0129  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean f(int r18, byte[] r19) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzem.f(int, byte[]):boolean");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean c() {
        return false;
    }

    @VisibleForTesting
    @WorkerThread
    final SQLiteDatabase d() throws SQLiteException {
        if (this.f21521d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f21520c.getWritableDatabase();
        if (writableDatabase == null) {
            this.f21521d = true;
            return null;
        }
        return writableDatabase;
    }

    @VisibleForTesting
    final boolean e() {
        Context zzaw = this.f21734a.zzaw();
        this.f21734a.zzf();
        return zzaw.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0248 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0248 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0248 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzi(int r23) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzem.zzi(int):java.util.List");
    }

    @WorkerThread
    public final void zzj() {
        int delete;
        zzg();
        try {
            SQLiteDatabase d4 = d();
            if (d4 != null && (delete = d4.delete("messages", null, null)) > 0) {
                this.f21734a.zzaA().zzj().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e4) {
            this.f21734a.zzaA().zzd().zzb("Error resetting local analytics data. error", e4);
        }
    }

    @WorkerThread
    public final boolean zzk() {
        return f(3, new byte[0]);
    }

    @WorkerThread
    public final boolean zzm() {
        zzg();
        if (!this.f21521d && e()) {
            int i4 = 5;
            for (int i5 = 0; i5 < 5; i5++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase d4 = d();
                    if (d4 == null) {
                        this.f21521d = true;
                        return false;
                    }
                    d4.beginTransaction();
                    d4.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    d4.setTransactionSuccessful();
                    d4.endTransaction();
                    d4.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i4);
                    i4 += 20;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteFullException e4) {
                    this.f21734a.zzaA().zzd().zzb("Error deleting app launch break from local database", e4);
                    this.f21521d = true;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteException e5) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    this.f21734a.zzaA().zzd().zzb("Error deleting app launch break from local database", e5);
                    this.f21521d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.f21734a.zzaA().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzac zzacVar) {
        byte[] G = this.f21734a.zzv().G(zzacVar);
        if (G.length > 131072) {
            this.f21734a.zzaA().zzh().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return f(2, G);
    }

    public final boolean zzo(zzau zzauVar) {
        Parcel obtain = Parcel.obtain();
        zzav.a(zzauVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.f21734a.zzaA().zzh().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return f(0, marshall);
    }

    public final boolean zzp(zzlk zzlkVar) {
        Parcel obtain = Parcel.obtain();
        zzll.a(zzlkVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.f21734a.zzaA().zzh().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return f(1, marshall);
    }
}
