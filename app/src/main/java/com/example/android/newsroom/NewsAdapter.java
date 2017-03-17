package com.example.android.newsroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.newsroom.R;

import java.util.List;

//import com.example.android.newsroom.R;


public class NewsAdapter extends ArrayAdapter<News> {


    // Resource ID for the background color for this list of words

    private int mColorResourceId;
    private static final String LOCATION_SEPARATOR = "/";
    private static final String LOCATION_SEPARATOR2 = "T";

    /**
     * Create a new {@link NewsAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param newsroom   is the list of {@link newsroom}s to be displayed.
     */
    public NewsAdapter(Context context, List<News> newsroom) {
        super(context, 0, newsroom);

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        News currentNews = getItem(position);


        String newsID = new String(currentNews.getSectionName());
        String locationOffset;

        // Check whether the originalLocation string contains the " of " text
        if (newsID.contains(LOCATION_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the " of " text. We expect an array of 2 Strings, where
            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
            String[] parts = newsID.split(LOCATION_SEPARATOR);
            // Location offset should be "5km N " + " of " --> "5km N of"
            locationOffset = parts[0];


        } else {
            // Otherwise, there is no " of " text in the originalLocation string.
            // Hence, set the default location offset to say "Near the".
            locationOffset = getContext().getString(R.string.near_the);

        }

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Display the location offset of the current earthquake in that TextView
        locationOffsetView.setText(locationOffset);


        String title = new String(currentNews.getTitle());
        TextView newsTitle = (TextView) listItemView.findViewById(R.id.title);
        // Display the location of the current earthquake in that TextView
        newsTitle.setText(title);


        // Create a new Date object from the time in milliseconds of the earthquake
        String dateObject = new String(currentNews.getDate());
        // Find the TextView with view ID date
        // TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        //  String formattedDate = formatDate(dateObject,"GMT","yyyy-MM-dd" );
        // Display the date of the current earthquake in that TextView
        //dateView.setText(formattedDate);

        String publishDate;
        String publishTime;

        // Check whether the originalLocation string contains the " of " text
        if (dateObject.contains(LOCATION_SEPARATOR2)) {
            // Split the string into different parts (as an array of Strings)
            // based on the " of " text. We expect an array of 2 Strings, where
            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
            String[] parts = dateObject.split(LOCATION_SEPARATOR2);
            // Location offset should be "5km N " + " of " --> "5km N of"
            publishDate = "D:" + parts[0];
            // Primary location should be "Cairo, Egypt"
            publishTime = "T:" + parts[1];
        } else {
            // Otherwise, there is no " of " text in the originalLocation string.
            // Hence, set the default location offset to say "Near the".
            publishDate = getContext().getString(R.string.no_date);
            // The primary location will be the full location string "Pacific-Antarctic Ridge".
            publishTime = getContext().getString(R.string.no_time);
            ;
        }

        // Find the TextView with view ID location
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the location of the current earthquake in that TextView
        dateView.setText(publishDate);

        // Find the TextView with view ID location offset
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Display the location offset of the current earthquake in that TextView
        timeView.setText(publishTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


}