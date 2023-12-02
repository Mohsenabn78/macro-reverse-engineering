package com.arlosoft.macrodroid.triggers;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.common.IncomingSMS;
import com.arlosoft.macrodroid.data.NotificationContextInfo;
import com.arlosoft.macrodroid.data.WeatherContextInfo;
import com.arlosoft.macrodroid.thirdparty.spotify.data.SpotifyPlaybackData;

@DontObfuscate
/* loaded from: classes3.dex */
public class TriggerContextInfo implements Parcelable {
    public static final Parcelable.Creator<TriggerContextInfo> CREATOR = new a();
    private String m_calendarDetail;
    private String m_calendarEndDate;
    private String m_calendarEndDateUs;
    private String m_calendarEndTime;
    private String m_calendarLocation;
    private String m_calendarStartDate;
    private String m_calendarStartDateUs;
    private String m_calendarStartTime;
    private String m_calendarTitle;
    private Contact m_contact;
    private IncomingSMS m_incomingSMS;
    private NotificationContextInfo m_notificationContextInfo;
    private String m_textData;
    private transient Trigger m_trigger;
    private String m_triggerClass;
    private String m_usbManufacturerName;
    private String m_usbProductName;
    private WeatherContextInfo m_weatherContextInfo;
    private TriggerContextInfo nestedTriggerContextInfo;
    private String secondaryTextData;
    private String settingCategory;
    private String settingKey;
    private String settingValue;
    private SpotifyPlaybackData spotifyPlaybackData;
    private long triggerGuid;
    private String usbDeviceHashCode;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<TriggerContextInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TriggerContextInfo createFromParcel(Parcel parcel) {
            return new TriggerContextInfo(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TriggerContextInfo[] newArray(int i4) {
            return new TriggerContextInfo[i4];
        }
    }

    /* synthetic */ TriggerContextInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static TriggerContextInfo createLogcatTriggerContextInfo(Trigger trigger, String str) {
        TriggerContextInfo triggerContextInfo = new TriggerContextInfo(trigger);
        triggerContextInfo.m_textData = str;
        return triggerContextInfo;
    }

    public static TriggerContextInfo createSpotifyContextInfo(Trigger trigger, SpotifyPlaybackData spotifyPlaybackData) {
        TriggerContextInfo triggerContextInfo = new TriggerContextInfo(trigger);
        triggerContextInfo.spotifyPlaybackData = spotifyPlaybackData;
        return triggerContextInfo;
    }

    public static TriggerContextInfo createSystemSettingContextInfo(Trigger trigger, String str, String str2, String str3) {
        TriggerContextInfo triggerContextInfo = new TriggerContextInfo(trigger);
        triggerContextInfo.settingCategory = str;
        triggerContextInfo.settingKey = str2;
        triggerContextInfo.settingValue = str3;
        return triggerContextInfo;
    }

    public static TriggerContextInfo createUsbTriggerContextInfo(Trigger trigger, String str, String str2, String str3) {
        TriggerContextInfo triggerContextInfo = new TriggerContextInfo(trigger);
        triggerContextInfo.m_usbProductName = str;
        triggerContextInfo.m_usbManufacturerName = str2;
        triggerContextInfo.usbDeviceHashCode = str3;
        return triggerContextInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCalendarDetail() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarDetail() != null) {
            return this.nestedTriggerContextInfo.getCalendarDetail();
        }
        return this.m_calendarDetail;
    }

    public String getCalendarEndDate() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarEndDate() != null) {
            return this.nestedTriggerContextInfo.getCalendarEndDate();
        }
        return this.m_calendarEndDate;
    }

    public String getCalendarEndDateUs() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarEndDateUs() != null) {
            return this.nestedTriggerContextInfo.getCalendarEndDateUs();
        }
        return this.m_calendarEndDateUs;
    }

    public String getCalendarEndTime() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarEndTime() != null) {
            return this.nestedTriggerContextInfo.getCalendarEndTime();
        }
        return this.m_calendarEndTime;
    }

    public String getCalendarLocation() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarLocation() != null) {
            return this.nestedTriggerContextInfo.getCalendarLocation();
        }
        return this.m_calendarLocation;
    }

    public String getCalendarStartDate() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarStartDate() != null) {
            return this.nestedTriggerContextInfo.getCalendarStartDate();
        }
        return this.m_calendarStartDate;
    }

    public String getCalendarStartDateUs() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarStartDateUs() != null) {
            return this.nestedTriggerContextInfo.getCalendarStartDateUs();
        }
        return this.m_calendarStartDateUs;
    }

    public String getCalendarStartTime() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarStartTime() != null) {
            return this.nestedTriggerContextInfo.getCalendarStartTime();
        }
        return this.m_calendarStartTime;
    }

    public String getCalendarTitle() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getCalendarTitle() != null) {
            return this.nestedTriggerContextInfo.getCalendarTitle();
        }
        return this.m_calendarTitle;
    }

    public Contact getContactData() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getContactData() != null) {
            return this.nestedTriggerContextInfo.getContactData();
        }
        return this.m_contact;
    }

    public IncomingSMS getIncomingSMSData() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getIncomingSMSData() != null) {
            return this.nestedTriggerContextInfo.getIncomingSMSData();
        }
        return this.m_incomingSMS;
    }

    public TriggerContextInfo getNestedTriggerContextInfo() {
        return this.nestedTriggerContextInfo;
    }

    public NotificationContextInfo getNotificationContextInfoData() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getNotificationContextInfoData() != null) {
            return this.nestedTriggerContextInfo.getNotificationContextInfoData();
        }
        return this.m_notificationContextInfo;
    }

    public String getSecondaryTextData() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getSecondaryTextData() != null) {
            return this.nestedTriggerContextInfo.getSecondaryTextData();
        }
        return this.secondaryTextData;
    }

    public String getSettingCategory() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getSettingKey() != null) {
            return this.nestedTriggerContextInfo.getSettingCategory();
        }
        return this.settingCategory;
    }

    public String getSettingKey() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getSettingKey() != null) {
            return this.nestedTriggerContextInfo.getSettingKey();
        }
        return this.settingKey;
    }

    public String getSettingValue() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getSettingValue() != null) {
            return this.nestedTriggerContextInfo.getSettingValue();
        }
        return this.settingValue;
    }

    public SpotifyPlaybackData getSpotifyPlaybackData() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getSpotifyPlaybackData() != null) {
            return this.nestedTriggerContextInfo.getSpotifyPlaybackData();
        }
        return this.spotifyPlaybackData;
    }

    public String getTextData() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getTextData() != null) {
            return this.nestedTriggerContextInfo.getTextData();
        }
        return this.m_textData;
    }

    public Trigger getTrigger() {
        return this.m_trigger;
    }

    public String getTriggerClass() {
        return this.m_triggerClass;
    }

    public long getTriggerGuid() {
        return this.triggerGuid;
    }

    public String getUsbDeviceHashCode() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getUsbDeviceHashCode() != null) {
            return this.nestedTriggerContextInfo.getUsbDeviceHashCode();
        }
        return this.usbDeviceHashCode;
    }

    public String getUsbManufacturerName() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getUsbManufacturerName() != null) {
            return this.nestedTriggerContextInfo.getUsbManufacturerName();
        }
        return this.m_usbManufacturerName;
    }

    public String getUsbProduceName() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getUsbProduceName() != null) {
            return this.nestedTriggerContextInfo.getUsbProduceName();
        }
        return this.m_usbProductName;
    }

    public WeatherContextInfo getWeatherData() {
        TriggerContextInfo triggerContextInfo = this.nestedTriggerContextInfo;
        if (triggerContextInfo != null && triggerContextInfo.getWeatherData() != null) {
            return this.nestedTriggerContextInfo.getWeatherData();
        }
        return this.m_weatherContextInfo;
    }

    public void setNestedTriggerContextInfo(TriggerContextInfo triggerContextInfo) {
        this.nestedTriggerContextInfo = triggerContextInfo;
    }

    public void setTrigger(Trigger trigger) {
        if (trigger != null) {
            this.m_trigger = trigger;
            this.triggerGuid = trigger.getSIGUID();
            this.m_triggerClass = trigger.getClass().getSimpleName();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.m_triggerClass);
        parcel.writeString(this.m_textData);
        parcel.writeParcelable(this.m_notificationContextInfo, i4);
        parcel.writeParcelable(this.m_incomingSMS, i4);
        parcel.writeParcelable(this.m_contact, i4);
        parcel.writeParcelable(this.m_weatherContextInfo, i4);
        parcel.writeString(this.m_calendarTitle);
        parcel.writeString(this.m_calendarDetail);
        parcel.writeParcelable(this.nestedTriggerContextInfo, i4);
        parcel.writeString(this.m_calendarLocation);
        parcel.writeString(this.m_calendarStartDate);
        parcel.writeString(this.m_calendarStartDateUs);
        parcel.writeString(this.m_calendarStartTime);
        parcel.writeString(this.m_calendarEndDate);
        parcel.writeString(this.m_calendarEndDateUs);
        parcel.writeString(this.m_calendarEndTime);
        parcel.writeParcelable(this.spotifyPlaybackData, i4);
        parcel.writeString(this.settingCategory);
        parcel.writeString(this.settingKey);
        parcel.writeString(this.settingValue);
        parcel.writeLong(this.triggerGuid);
        parcel.writeString(this.usbDeviceHashCode);
        parcel.writeString(this.secondaryTextData);
    }

    public TriggerContextInfo(String str) {
        this.m_triggerClass = str;
    }

    public TriggerContextInfo(Trigger trigger) {
        setTrigger(trigger);
    }

    public TriggerContextInfo(Trigger trigger, String str) {
        setTrigger(trigger);
        this.m_textData = str;
    }

    public TriggerContextInfo(Trigger trigger, String str, String str2) {
        setTrigger(trigger);
        this.m_textData = str;
        this.secondaryTextData = str2;
    }

    public TriggerContextInfo(Trigger trigger, NotificationContextInfo notificationContextInfo) {
        setTrigger(trigger);
        this.m_notificationContextInfo = notificationContextInfo;
    }

    public TriggerContextInfo(Trigger trigger, IncomingSMS incomingSMS) {
        setTrigger(trigger);
        this.m_incomingSMS = incomingSMS;
    }

    public TriggerContextInfo(Trigger trigger, Contact contact) {
        setTrigger(trigger);
        this.m_contact = contact;
    }

    public TriggerContextInfo(Trigger trigger, WeatherContextInfo weatherContextInfo) {
        setTrigger(trigger);
        this.m_weatherContextInfo = weatherContextInfo;
    }

    public TriggerContextInfo(Trigger trigger, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        setTrigger(trigger);
        this.m_calendarTitle = str;
        this.m_calendarDetail = str2;
        this.m_calendarLocation = str3;
        this.m_calendarStartDate = str4;
        this.m_calendarStartDateUs = str5;
        this.m_calendarStartTime = str6;
        this.m_calendarEndDate = str7;
        this.m_calendarEndDateUs = str8;
        this.m_calendarEndTime = str9;
    }

    private TriggerContextInfo(Parcel parcel) {
        try {
            this.m_triggerClass = parcel.readString();
            this.m_textData = parcel.readString();
            this.m_notificationContextInfo = (NotificationContextInfo) parcel.readParcelable(NotificationContextInfo.class.getClassLoader());
            this.m_incomingSMS = (IncomingSMS) parcel.readParcelable(IncomingSMS.class.getClassLoader());
            this.m_contact = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
            this.m_weatherContextInfo = (WeatherContextInfo) parcel.readParcelable(WeatherContextInfo.class.getClassLoader());
            this.m_calendarTitle = parcel.readString();
            this.m_calendarDetail = parcel.readString();
            if (parcel.dataAvail() > 0) {
                try {
                    this.nestedTriggerContextInfo = (TriggerContextInfo) parcel.readParcelable(TriggerContextInfo.class.getClassLoader());
                } catch (Exception e4) {
                    try {
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Data position = " + parcel.dataPosition() + ", Data size = " + parcel.dataSize() + ", Data available = " + parcel.dataAvail(), e4));
                        parcel.setDataPosition(parcel.dataSize());
                    } catch (Exception unused) {
                    }
                }
            }
            this.m_calendarLocation = parcel.readString();
            this.m_calendarStartDate = parcel.readString();
            this.m_calendarStartDateUs = parcel.readString();
            this.m_calendarStartTime = parcel.readString();
            this.m_calendarEndDate = parcel.readString();
            this.m_calendarEndDateUs = parcel.readString();
            this.m_calendarEndTime = parcel.readString();
            this.spotifyPlaybackData = (SpotifyPlaybackData) parcel.readParcelable(SpotifyPlaybackData.class.getClassLoader());
            this.settingCategory = parcel.readString();
            this.settingKey = parcel.readString();
            this.settingValue = parcel.readString();
            this.triggerGuid = parcel.readLong();
            this.usbDeviceHashCode = parcel.readString();
            this.secondaryTextData = parcel.readString();
        } catch (Exception e5) {
            FirebaseAnalyticsEventLogger.logHandledException(e5);
        }
    }
}
