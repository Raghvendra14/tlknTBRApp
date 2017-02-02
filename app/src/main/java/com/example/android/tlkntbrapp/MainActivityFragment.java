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
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRBmKbZRg4FvID3DYpGDTBfwxrVvt8czv_AgztG5o1IRv5o3G2V",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp1.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp3.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp4.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp5.jpg",
                "",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp6.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp7.jpg",
                "",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp8.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp9.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp10.jpg",
                "",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp11.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp12.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp13.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp14.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp15.jpg",
                "",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp16.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp17.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp18.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp19.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp20.jpg",
                "http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/natural_world_2011/bp21.jpg"
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
