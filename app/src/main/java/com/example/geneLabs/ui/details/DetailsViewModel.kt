package com.example.geneLabs.ui.details

import androidx.lifecycle.ViewModel
import com.example.geneLabs.api.GeneLabsResponse

class DetailsViewModel : ViewModel() {
    lateinit var studyPerson: GeneLabsResponse.Hits.Hit.Source.StudyPerson
}
