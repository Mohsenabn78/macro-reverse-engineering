package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.Indexable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class Indexables {
    private Indexables() {
    }

    @NonNull
    public static AggregateRatingBuilder aggregateRatingBuilder() {
        return new AggregateRatingBuilder();
    }

    @NonNull
    public static AlarmBuilder alarmBuilder() {
        return new AlarmBuilder();
    }

    @NonNull
    public static AlarmInstanceBuilder alarmInstanceBuilder() {
        return new AlarmInstanceBuilder();
    }

    @NonNull
    public static AudiobookBuilder audiobookBuilder() {
        return new AudiobookBuilder();
    }

    @NonNull
    public static BookBuilder bookBuilder() {
        return new BookBuilder();
    }

    @NonNull
    public static ConversationBuilder conversationBuilder() {
        return new ConversationBuilder();
    }

    @NonNull
    public static DigitalDocumentBuilder digitalDocumentBuilder() {
        return new DigitalDocumentBuilder();
    }

    @NonNull
    public static DigitalDocumentPermissionBuilder digitalDocumentPermissionBuilder() {
        return new DigitalDocumentPermissionBuilder();
    }

    @NonNull
    public static MessageBuilder emailMessageBuilder() {
        return new MessageBuilder("EmailMessage");
    }

    @NonNull
    public static GeoShapeBuilder geoShapeBuilder() {
        return new GeoShapeBuilder();
    }

    @NonNull
    public static LocalBusinessBuilder localBusinessBuilder() {
        return new LocalBusinessBuilder();
    }

    @NonNull
    public static MessageBuilder messageBuilder() {
        return new MessageBuilder();
    }

    @NonNull
    public static MusicAlbumBuilder musicAlbumBuilder() {
        return new MusicAlbumBuilder();
    }

    @NonNull
    public static MusicGroupBuilder musicGroupBuilder() {
        return new MusicGroupBuilder();
    }

    @NonNull
    public static MusicPlaylistBuilder musicPlaylistBuilder() {
        return new MusicPlaylistBuilder();
    }

    @NonNull
    public static MusicRecordingBuilder musicRecordingBuilder() {
        return new MusicRecordingBuilder();
    }

    @NonNull
    public static Indexable newSimple(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Indexable.Builder builder = new Indexable.Builder();
        builder.setUrl(str2);
        return builder.setName(str).build();
    }

    @NonNull
    public static DigitalDocumentBuilder noteDigitalDocumentBuilder() {
        return new DigitalDocumentBuilder("NoteDigitalDocument");
    }

    @NonNull
    public static PersonBuilder personBuilder() {
        return new PersonBuilder();
    }

    @NonNull
    public static PlaceBuilder placeBuilder() {
        return new PlaceBuilder();
    }

    @NonNull
    public static PostalAddressBuilder postalAddressBuilder() {
        return new PostalAddressBuilder();
    }

    @NonNull
    public static DigitalDocumentBuilder presentationDigitalDocumentBuilder() {
        return new DigitalDocumentBuilder("PresentationDigitalDocument");
    }

    @NonNull
    public static ReservationBuilder reservationBuilder() {
        return new ReservationBuilder();
    }

    @NonNull
    public static LocalBusinessBuilder restaurantBuilder() {
        return new LocalBusinessBuilder("Restaurant");
    }

    @NonNull
    public static DigitalDocumentBuilder spreadsheetDigitalDocumentBuilder() {
        return new DigitalDocumentBuilder("SpreadsheetDigitalDocument");
    }

    @NonNull
    public static StickerBuilder stickerBuilder() {
        return new StickerBuilder();
    }

    @NonNull
    public static StickerPackBuilder stickerPackBuilder() {
        return new StickerPackBuilder();
    }

    @NonNull
    public static StopwatchBuilder stopwatchBuilder() {
        return new StopwatchBuilder();
    }

    @NonNull
    public static StopwatchLapBuilder stopwatchLapBuilder() {
        return new StopwatchLapBuilder();
    }

    @NonNull
    public static DigitalDocumentBuilder textDigitalDocumentBuilder() {
        return new DigitalDocumentBuilder("TextDigitalDocument");
    }

    @NonNull
    public static TimerBuilder timerBuilder() {
        return new TimerBuilder();
    }
}
