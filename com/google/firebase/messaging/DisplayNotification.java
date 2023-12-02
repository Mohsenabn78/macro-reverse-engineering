package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.CommonNotificationBuilder;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes5.dex */
class DisplayNotification {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f31627a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f31628b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationParams f31629c;

    public DisplayNotification(Context context, NotificationParams notificationParams, ExecutorService executorService) {
        this.f31627a = executorService;
        this.f31628b = context;
        this.f31629c = notificationParams;
    }

    private boolean b() {
        if (((KeyguardManager) this.f31628b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.isAtLeastLollipop()) {
            SystemClock.sleep(10L);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f31628b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                if (runningAppProcessInfo.importance != 100) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private void c(CommonNotificationBuilder.DisplayNotificationInfo displayNotificationInfo) {
        Log.isLoggable(Constants.TAG, 3);
        ((NotificationManager) this.f31628b.getSystemService("notification")).notify(displayNotificationInfo.tag, displayNotificationInfo.id, displayNotificationInfo.notificationBuilder.build());
    }

    @Nullable
    private ImageDownload d() {
        ImageDownload create = ImageDownload.create(this.f31629c.getString(Constants.MessageNotificationKeys.IMAGE_URL));
        if (create != null) {
            create.start(this.f31627a);
        }
        return create;
    }

    private void e(NotificationCompat.Builder builder, @Nullable ImageDownload imageDownload) {
        if (imageDownload == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(imageDownload.getTask(), 5L, TimeUnit.SECONDS);
            builder.setLargeIcon(bitmap);
            builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));
        } catch (InterruptedException unused) {
            Log.w(Constants.TAG, "Interrupted while downloading image, showing notification without it");
            imageDownload.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e4) {
            Log.w(Constants.TAG, "Failed to download image: " + e4.getCause());
        } catch (TimeoutException unused2) {
            Log.w(Constants.TAG, "Failed to download image in time, showing notification without it");
            imageDownload.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.f31629c.getBoolean(Constants.MessageNotificationKeys.NO_UI)) {
            return true;
        }
        if (b()) {
            return false;
        }
        ImageDownload d4 = d();
        CommonNotificationBuilder.DisplayNotificationInfo d5 = CommonNotificationBuilder.d(this.f31628b, this.f31629c);
        e(d5.notificationBuilder, d4);
        c(d5);
        return true;
    }
}
