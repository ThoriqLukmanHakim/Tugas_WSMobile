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

    private static final int COUNT = 11;

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
        return new PlaceholderItem(MakeTitle(position),MakeContent(position),MakeImage(position),makeNopung(position),makeNat(position));
    }

    private static String MakeImage(int position){
        StringBuilder builder = new StringBuilder();
        String image[] = {
                "img_1",
                "img_20",
                "img_6",
                "img_19",
                "img_23",
                "img_18",
                "img_14",
                "img_10",
                "img_8",
                "img_21",
                "img_27",
        };
        builder.append(image [position - 1]);
        return builder.toString();
    }

    private static String MakeTitle(int position){
        StringBuilder builder = new StringBuilder();
        String judul[] = {
                "David De Gea",
                "Diogo Dalot",
                "Lisandro Martinez",
                "Raphael Varane",
                "Luke Shaw",
                "Casemiro",
                "Christian Eriksen",
                "Marcus Rashford",
                "Bruno Fernandes",
                "Antony",
                "Wout Weghorst",
        };
        builder.append(judul [position - 1]);
        return  builder.toString();
    }

    private static String makeNopung(int position){
        StringBuilder builder = new StringBuilder();
        String nopung[] = {
                "1",
                "20",
                "6",
                "19",
                "23",
                "18",
                "14",
                "10",
                "8",
                "21",
                "27",
        };
        builder.append(nopung [position - 1]);
        return  builder.toString();
    }

    private static String makeNat(int position){
        StringBuilder builder = new StringBuilder();
        String Nationality[] = {
                "Spanyol",
                "Portugal",
                "Argentina",
                "France",
                "England",
                "Brazil",
                "Denmark",
                "England",
                "Portugal",
                "Brazil",
                "Netherlands",
        };
        builder.append(Nationality [position - 1]);
        return  builder.toString();
    }

    private static String MakeContent(int position){
        StringBuilder builder = new StringBuilder();
        String isi[] = {
                "Goal Keeper",
                "Left Back",
                "Center Back",
                "Center Back",
                "Right Back",
                "Defensive Midfielder",
                "Defensive Midfielder",
                "Left Winger",
                "Attacking Midfielder",
                "Right Winger",
                "Center Forward",
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
        public final String nopung;
        public final String Nat;


        public PlaceholderItem(String id, String content,  String image, String nopung, String Nat) {
            this.id = id;
            this.content = content;
            this.image = image;
            this.nopung = nopung;
            this.Nat = Nat;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}