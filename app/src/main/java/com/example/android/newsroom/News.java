package com.example.android.newsroom;

/**
 * Created by Anika Dhulipudi on 17/01/2017.
 */

public class News {
    private String mSection;
    private String mTitle;
    private String mDate;
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param section is the magnitude (size) of the book
     * @param newsTitle is the city location of the book
     * @param  date is the time in milliseconds (from the Epoch) when the
     *  book happened
     */
    public News(String section, String newsTitle, String date, String previewLink) {
        mSection= section;
        mTitle = newsTitle;
        mDate = date;
        mUrl = previewLink;

    }
    // return place of earthquake
    public String getSectionName() {
        return mSection;
    }
    // return place of earthquake
    public String getTitle() {
        return mTitle;
    }
//    //return the magnitude for the earthquake
   public String getDate() {
        return mDate;
    }

    //Return url
    public String getUrl() {
        return mUrl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "mSection='" + mSection + '\'' +
                ", mTitle='" + mTitle + '\'' +
               ", mDate='" + mDate + '\'' +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }

}
