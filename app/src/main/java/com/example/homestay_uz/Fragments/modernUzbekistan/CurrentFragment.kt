package com.example.homestay_uz.Fragments.modernUzbekistan

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homestay_uz.R
import kotlinx.android.synthetic.main.fragment_current.*
import kotlinx.android.synthetic.main.fragment_current.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [CurrentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CurrentFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_current, container, false)

        initViews(view)
        return view
    }

    @SuppressLint("SetTextI18n")
    private fun initViews(view: View) {

       view.full_data_for_country_id.text = "Uzbekistan " +
                "officially the Republic of Uzbekistan " +
                "is a country located in Central Asia. " +
                "It is surrounded by five landlocked countries: Kazakhstan to the north; Kyrgyzstan to the northeast; Tajikistan to the southeast;" +
                " Afghanistan to the south; and Turkmenistan to the southwest. Its capital and largest city is Tashkent.\n " +
                "\nUzbekistan is part of the Turkish world, as well as a member of the Organization of Turkish States. " +
                "The Uzbek language is the majority-spoken language in Uzbekistan, other languages includes Russian and Tajik," +
                " spoken predominantly in Samarkand and Bukhara. " +
                "Islam is the predominant religion in Uzbekistan, most Uzbeks being Sunni Muslims.\n" +
                "" +
               "\nThe Uzbek economy is in a gradual transition to the market economy, with foreign trade policy being based on import substitution." +
                " In September 2021, the country's currency became fully convertible at market rates. Uzbekistan is a major producer and exporter of cotton." +
                " With the gigantic power-generation facilities from the Soviet era and an ample supply of natural gas," +
                " Uzbekistan has become the largest electricity producer in Central Asia." +
                "\n" +
                "\nFrom 2018 to 2021, the republic received a BB- rating by both Standard and Poor (S&P) and Fitch " +
                "Strengths indicated by the Brookings Institution include Uzbekistan having large liquid assets, high economic growth, and low public debt. " +
                "Among the constraints holding the republic back is the low GDP per capital. Uzbekistan is a member of the Commonwealth of Independent States (CIS)," +
                " United Nations and the Shanghai Cooperation Organisation (SCO). "


        view.full_data_regions_for_country_id.text = "\n" +
                "Discover Uzbekistan\n" +
                "\n" +
                "Amazing monuments, architectural and natural attractions that have become the hallmark of each region are scattered throughout Uzbekistan." +
                " \n" +
                "\n" +
                "The Republic of Uzbekistan is divided into 12 territorial and administrative divisions-regions as well as the republic of Karakalpakistan." +
                " Each region has its own administrative center. Regions of our country as a separate book. All Uzbeks wear skullcaps," +
                " but this headdress is decorated differently in each region. All Uzbeks love pilaw, but in every corner of our country they prepare it by their own unique recipe. " +
                "All Uzbeks like to drink tea from beautiful dishes, but the tea ceremony and the ornament on the dishes will differ from each other.\n" +
                "\n" +
                "Every region of our country is a unique area, famous for its natural attractions, architectural and historical monuments. " +
                "National traditions, cooking, customs, local folklore, dialects of the Uzbek language of each region differ from each other and have their own feature.\n"

    }

}