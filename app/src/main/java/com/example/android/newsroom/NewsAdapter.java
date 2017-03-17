package com.example.android.newsroom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//import com.example.android.newsroom.R;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private Context context;
    private static final String LOCATION_SEPARATOR = "/";
    private static final String LOCATION_SEPARATOR2 = "T";

        private List<News> newsList;



    public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView newsTitle, locationOffsetView, dateView, timeView;

            public MyViewHolder(View view) {
                super(view);
                newsTitle = (TextView) view.findViewById(R.id.title);
                locationOffsetView = (TextView) view.findViewById(R.id.location_offset);
                dateView = (TextView) view.findViewById(R.id.date);
                timeView = (TextView) view.findViewById(R.id.time);

            }
        }

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News currentNews = newsList.get(position);

    //    holder.genre.setText(movie.getGenre());
      //  holder.year.setText(movie.getYear());

//    public NewsAdapter(Context context, List<News> newsroom) {
//        super(context, 0, newsroom);
//    }
        // Find the earthquake at the given position in the list of earthquakes
        //News currentNews = getItem(position);


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
            locationOffset =context.getResources().getString(R.string.near_the);

        }

      //  TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Display the location offset of the current earthquake in that TextView
        holder.locationOffsetView.setText(locationOffset);
       // locationOffsetView.setText(locationOffset);


       // String title = new String(currentNews.getTitle());
        // TextView newsTitle = (TextView) listItemView.findViewById(R.id.title);
        // Display the location of the current earthquake in that TextView
        //newsTitle.setText(title);
        holder.newsTitle.setText(currentNews.getTitle());

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
            publishDate = context.getString(R.string.no_date);
            // The primary location will be the full location string "Pacific-Antarctic Ridge".
            publishTime = context.getString(R.string.no_time);
            ;
        }

        // Find the TextView with view ID location
       // TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the location of the current earthquake in that TextView
      //  dateView.setText(publishDate);
        holder.dateView.setText(publishDate);
        // Find the TextView with view ID location offset
      //  TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Display the location offset of the current earthquake in that TextView
       // timeView.setText(publishTime);
        holder.timeView.setText(publishTime);
        // Return the list item view that is now showing the appropriate data
       // return listItemView;

    }
    @Override
    public int getItemCount() {
        return newsList.size();
    }

}