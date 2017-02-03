package com.example.android.tlkntbrapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        int columnCount = getResources().getInteger(R.integer.column_count);
        GridLayoutManager glm =
                new GridLayoutManager(getActivity(), columnCount);

        recyclerView.setLayoutManager(glm);

        String[] nameArray = {
                "Marilyn Monroe",
                "Avicii",
                "Lil Wayne",
                "Jay Z",
                "Mark Twain",
                "Olivia Wilde",
                "Tim Allen",
                "Flo Rida",
                "Jason Alexander",
                "Bono",
                "Katy Perry",
                "50 Cent",
                "Iggy Azalea",
                "Tom Cruise",
                "Nicki Minaj",
                "Eminem",
                "Michael Caine",
                "Skrillex",
                "Pitbull",
                "Vin Diesel",
                "LL Cool J",
                "Spike Jonze",
                "Sting",
                "Wiz Khalifa",
                "Marilyn Manson"
        };

        HashMap<Integer, String> nameHashMap = createHashMap(nameArray);

        String[] contactPicUrlArray = {
                "http://lorempixel.com/200/200/abstract/",
                "http://lorempixel.com/200/200/food/",
                "http://lorempixel.com/200/200/transport/",
                "http://lorempixel.com/200/200/animals/",
                "http://lorempixel.com/200/200/nature/",
                "",
                "http://lorempixel.com/200/200/cats/",
                "http://lorempixel.com/200/200/fashion/",
                "",
                "http://lorempixel.com/200/200/city/",
                "http://lorempixel.com/200/200/abstract/",
                "http://lorempixel.com/200/200/nightlife/",
                "",
                "http://lorempixel.com/200/200/food/",
                "http://lorempixel.com/200/200/nature/",
                "http://lorempixel.com/200/200/people/",
                "http://lorempixel.com/200/200/city/",
                "http://lorempixel.com/200/200/transport/",
                "",
                "http://lorempixel.com/200/200/food/",
                "http://lorempixel.com/200/200/nature/",
                "http://lorempixel.com/200/200/abstract/",
                "http://lorempixel.com/200/200/city/",
                "http://lorempixel.com/200/200/animals/",
                "http://lorempixel.com/200/200/nightlife/"
        };

        HashMap<Integer, String> thumbnailHashMap = createHashMap(contactPicUrlArray);

        CustomRecyclerViewAdapter customRecyclerViewAdapter = new CustomRecyclerViewAdapter(getActivity(), nameHashMap, thumbnailHashMap);
        recyclerView.setAdapter(customRecyclerViewAdapter);

        return  rootView;
    }

    public HashMap<Integer, String> createHashMap(String[] data) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int count = 0; count < data.length; count++) {
            hashMap.put(count, data[count]);
        }

        return hashMap;
    }
}
