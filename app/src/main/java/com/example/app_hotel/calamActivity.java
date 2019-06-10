package com.example.app_hotel;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class calamActivity extends Fragment {
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_calam, container, false);
        super.onCreate(savedInstanceState);
        //etConTe(R.layout.activity_calam);
//        final ActionBar actionBar = get();
//        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setTitle(null);



        compactCalendar = view.findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        //Set an event for Teachers' Professional Day 2016 which is 21st of October

        Event ev1 = new Event(Color.WHITE, 1560253803000L);
        compactCalendar.addEvent(ev1);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getContext();

                if (dateClicked.toString().compareTo("Sun ") == 0) {
                    Toast.makeText(context, "Teachers' Professional Day", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                //actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });

        return view;
    }
}
