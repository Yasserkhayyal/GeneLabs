package com.example.geneLabs.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.geneLabs.api.GeneLabsResponse
import com.example.geneLabs.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentDetailsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@DetailsFragment
            studyPerson =
                arguments?.get("studyPersonKey") as GeneLabsResponse.Hits.Hit.Source.StudyPerson
        }.root
    }
}
