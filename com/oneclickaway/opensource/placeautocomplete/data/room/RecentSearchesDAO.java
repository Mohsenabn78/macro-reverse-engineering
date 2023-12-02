package com.oneclickaway.opensource.placeautocomplete.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.oneclickaway.opensource.placeautocomplete.data.model.room.SearchSelectedItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: RecentSearchesDAO.kt */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'¨\u0006\b"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/room/RecentSearchesDAO;", "", "addSearchItem", "", "searchSelectedItem", "Lcom/oneclickaway/opensource/placeautocomplete/data/model/room/SearchSelectedItem;", "getRecentSearches", "", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public interface RecentSearchesDAO {
    @Insert(onConflict = 1)
    void addSearchItem(@NotNull SearchSelectedItem searchSelectedItem);

    @Query("SELECT * FROM SearchSelectedItem ORDER BY searchCurrentMilliseconds DESC")
    @NotNull
    List<SearchSelectedItem> getRecentSearches();
}
