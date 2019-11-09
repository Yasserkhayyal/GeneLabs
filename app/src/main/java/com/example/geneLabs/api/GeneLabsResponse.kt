package com.example.geneLabs.api


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GeneLabsResponse(
    @SerializedName("hits")
    val hits: Hits,
    @SerializedName("_shards")
    val shards: Shards,
    @SerializedName("timed_out")
    val timedOut: Boolean,
    @SerializedName("took")
    val took: Int
) {
    data class Hits(
        @SerializedName("hits")
        val hits: List<Hit>,
        @SerializedName("max_score")
        val maxScore: Double,
        @SerializedName("total")
        val total: Int
    ) {
        data class Hit(
            @SerializedName("highlight")
            val highlight: Highlight,
            @SerializedName("_id")
            val id: String,
            @SerializedName("_index")
            val index: String,
            @SerializedName("_score")
            val score: Double,
            @SerializedName("_source")
            val source: Source,
            @SerializedName("_type")
            val type: String
        ) {
            data class Highlight(
                @SerializedName("all")
                val all: List<String>
            )

            data class Source(
                @SerializedName("Accession")
                val accession: String,
                @SerializedName("Acknowledgments")
                val acknowledgments: String,
                @SerializedName("Authoritative Source URL")
                val authoritativeSourceURL: String,
                @SerializedName("Characteristics")
                val characteristics: String,
                @SerializedName("Data Source Accession")
                val dataSourceAccession: String,
                @SerializedName("Data Source Type")
                val dataSourceType: String,
                @SerializedName("Experiment Platform")
                val experimentPlatform: String,
                @SerializedName("Factor Value")
                val factorValue: String,
                @SerializedName("Flight Program")
                val flightProgram: String,
                @SerializedName("Managing NASA Center")
                val managingNASACenter: String,
                @SerializedName("Material Type")
                val materialType: String,
                @SerializedName("Mission")
                val mission: Mission,
                @SerializedName("organism")
                val organism: String,
                @SerializedName("Parameter Value")
                val parameterValue: String,
                @SerializedName("Project Identifier")
                val projectIdentifier: String,
                @SerializedName("Project Link")
                val projectLink: String,
                @SerializedName("Project Title")
                val projectTitle: String,
                @SerializedName("Project Type")
                val projectType: String,
                @SerializedName("Space Program")
                val spaceProgram: String,
                @SerializedName("Study Assay Measurement Type")
                val studyAssayMeasurementType: String,
                @SerializedName("Study Assay Technology Platform")
                val studyAssayTechnologyPlatform: String,
                @SerializedName("Study Assay Technology Type")
                val studyAssayTechnologyType: String,
                @SerializedName("Study Description")
                val studyDescription: String,
                @SerializedName("Study Factor Name")
                val studyFactorName: String,
                @SerializedName("Study Factor Type")
                val studyFactorType: String,
                @SerializedName("Study Funding Agency")
                val studyFundingAgency: String,
                @SerializedName("Study Grant Number")
                val studyGrantNumber: String,
                @SerializedName("Study Identifier")
                val studyIdentifier: String,
                @SerializedName("Study Person")
                val studyPerson: StudyPerson,
                @SerializedName("Study Protocol Description")
                val studyProtocolDescription: String,
                @SerializedName("Study Protocol Name")
                val studyProtocolName: String,
                @SerializedName("Study Protocol Type")
                val studyProtocolType: String,
                @SerializedName("Study Public Release Date")
                val studyPublicReleaseDate: String,
                @SerializedName("Study Publication Author List")
                val studyPublicationAuthorList: String,
                @SerializedName("Study Publication Title")
                val studyPublicationTitle: String,
                @SerializedName("Study Title")
                val studyTitle: String,
                @SerializedName("thumbnail")
                val thumbnail: String
            ) {
                data class Mission(
                    @SerializedName("End Date")
                    val endDate: String,
                    @SerializedName("Name")
                    val name: String,
                    @SerializedName("Start Date")
                    val startDate: String
                )

                data class StudyPerson(
                    @SerializedName("First Name")
                    val firstName: String,
                    @SerializedName("Last Name")
                    val lastName: String,
                    @SerializedName("Middle Initials")
                    val middleInitials: String
                ) : Serializable
            }
        }
    }

    data class Shards(
        @SerializedName("failed")
        val failed: Int,
        @SerializedName("skipped")
        val skipped: Int,
        @SerializedName("successful")
        val successful: Int,
        @SerializedName("total")
        val total: Int
    )
}