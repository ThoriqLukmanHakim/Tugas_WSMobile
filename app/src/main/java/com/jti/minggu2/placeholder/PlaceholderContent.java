package com.jti.minggu2.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static final int COUNT = 3;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {
        return new PlaceholderItem(MakeTitle(position),MakeContent(position),MakeImage(position));
    }

    private static String MakeImage(int position){
        StringBuilder builder = new StringBuilder();
        String image[] = {
                "img_1",
                "img_2",
                "img_3"
        };
        builder.append(image [position - 1]);
        return builder.toString();
    }

    private static String MakeTitle(int position){
        StringBuilder builder = new StringBuilder();
        String judul[] = {
                "David De Gea",
                "Marcus Rashford",
                "Casemiro"
        };
        builder.append(judul [position - 1]);
        return  builder.toString();
    }
    private static String MakeContent(int position){
        StringBuilder builder = new StringBuilder();
        String isi[] = {
                "Goal Keeper",
                "Left Winger",
                "Defensive Midfielder"
        };
        builder.append(isi [position - 1]);
        return  builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String image;


        public PlaceholderItem(String id, String content,  String image) {
            this.id = id;
            this.content = content;
            this.image = image;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}