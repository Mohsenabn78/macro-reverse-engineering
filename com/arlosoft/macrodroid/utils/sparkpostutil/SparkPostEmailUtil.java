package com.arlosoft.macrodroid.utils.sparkpostutil;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.arlosoft.macrodroid.R;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.ion.Ion;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public class SparkPostEmailUtil {
    public static void cancelSending(Context context) {
        Ion.getDefault(context).cancelAll();
    }

    public static void sendEmail(Context context, String str, String str2, String str3, SparkPostSender sparkPostSender, SparkPostRecipient sparkPostRecipient, EmailListener emailListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(sparkPostRecipient);
        sendEmail(context, str, str2, str3, sparkPostSender, arrayList, (String) null, (ArrayList<SparkPostFile>) null, (String) null, emailListener);
    }

    public static void sendEmailOkHttp(final Context context, String str, String str2, String str3, SparkPostSender sparkPostSender, ArrayList<SparkPostRecipient> arrayList, String str4, ArrayList<SparkPostFile> arrayList2, String str5, final EmailListener emailListener) {
        SparkPostEmailJsonRequest sparkPostEmailJsonRequest = new SparkPostEmailJsonRequest(str2, str3, arrayList, sparkPostSender, str4, arrayList2, str5);
        new OkHttpClient().newCall(new Request.Builder().url("https://api.sparkpost.com/api/v1/transmissions?num_rcpt_errors=3").addHeader("Content-Type", "application/json").addHeader(HttpHeaders.ACCEPT, "application/json").addHeader("Authorization", str).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), sparkPostEmailJsonRequest.toString())).build()).enqueue(new Callback() { // from class: com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostEmailUtil.1
            Handler handler = new Handler(Looper.getMainLooper());

            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call, @NotNull final IOException iOException) {
                this.handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostEmailUtil.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EmailListener.this.onError(iOException.toString());
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                try {
                    String string = response.body().string();
                    if (!TextUtils.isEmpty(string)) {
                        final SparkPostResultWrapper fromJson = SparkPostResultWrapper.fromJson(string);
                        if (fromJson.getErrors() != null) {
                            if (!fromJson.getErrors().isEmpty()) {
                                this.handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostEmailUtil.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        EmailListener.this.onError(fromJson.getErrors().get(0).getMessage());
                                    }
                                });
                                return;
                            } else {
                                this.handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostEmailUtil.1.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        EmailListener.this.onError(context.getString(R.string.error));
                                    }
                                });
                                return;
                            }
                        } else if (fromJson.getResults().getTotal_rejected_recipients() == 0) {
                            this.handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostEmailUtil.1.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    EmailListener.this.onSuccess();
                                }
                            });
                            return;
                        }
                    }
                    this.handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostEmailUtil.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            EmailListener.this.onError("No response.");
                        }
                    });
                } catch (Exception e4) {
                    e4.printStackTrace();
                    EmailListener.this.onError(e4.toString());
                }
            }
        });
    }

    public static void sendEmail(Context context, String str, String str2, String str3, SparkPostRecipient sparkPostRecipient, EmailListener emailListener) {
        SparkPostSender sparkPostSender = new SparkPostSender("feedback@sparkpostbox.com", "unknown user");
        ArrayList arrayList = new ArrayList();
        arrayList.add(sparkPostRecipient);
        sendEmail(context, str, str2, str3, sparkPostSender, arrayList, (String) null, (ArrayList<SparkPostFile>) null, (String) null, emailListener);
    }

    public static void sendEmail(Context context, String str, String str2, String str3, SparkPostRecipient sparkPostRecipient, SparkPostSender sparkPostSender, String str4, ArrayList<SparkPostFile> arrayList, String str5, EmailListener emailListener) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(sparkPostRecipient);
        sendEmail(context, str, str2, str3, sparkPostSender, arrayList2, str4, arrayList, str5, emailListener);
    }

    public static void sendEmail(Context context, String str, String str2, String str3, String str4, EmailListener emailListener) {
        sendEmail(context, str, str2, str3, new SparkPostRecipient("feedback@sparkpostbox.com"), emailListener);
    }

    public static void sendEmail(Context context, String str, String str2, String str3, ArrayList<SparkPostRecipient> arrayList, EmailListener emailListener) {
        sendEmail(context, str, str2, str3, new SparkPostSender("feedback@sparkpostbox.com", "unknown user"), arrayList, (String) null, (ArrayList<SparkPostFile>) null, (String) null, emailListener);
    }

    public static void sendEmail(Context context, String str, String str2, String str3, SparkPostSender sparkPostSender, ArrayList<SparkPostRecipient> arrayList, String str4, ArrayList<SparkPostFile> arrayList2, String str5, EmailListener emailListener) {
        sendEmailOkHttp(context, str, str2, str3, sparkPostSender, arrayList, str4, arrayList2, str5, emailListener);
    }
}
