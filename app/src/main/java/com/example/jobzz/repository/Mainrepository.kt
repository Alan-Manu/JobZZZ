package com.example.jobzz.repository

import com.example.jobzz.model.JobModel

class Mainrepository {
    val location = listOf("los Angeles,USA","New York,USA")
    val category= listOf("all","Accountant","Programmer","Write")

    val exampleText: String =
        "We are searching for a talented and motivated person for this job to join our growing team.In this role, you will be responsible for this job and you will be responsible for this job"

        val items = listOf(
            JobModel(
                "UI Designer",
                "Chatbook1",
                "logo1",
                "Full-time",
                "Remote",
                "Intership",
                "New York, USA",
                "\$38k - \$46k",
                "2",

            ),
            JobModel(
                "Kotlin Programmer",
                "TestSoft",
                "logo4",
                "Full-Time",
                "Remote",
                "Internship",
                "Los Angeles, USA",
                "\$38k - \$40k",
                "2",
            ),
            JobModel(
                "News Author",
                "MakanSoft",
                "logo3",
                "Part-Time",
                "Remote",
                "Senior level",
                "New York, USA",
                "\$20k - \$23k",
                "3",
            ),
            JobModel(
                "Accountant",
                "KianSoft",
                "logo2",
                "Part-time",
                "Remote",
                "in Person",
                "Los Angeles,USA",
                "\$26k - \$36k",
                "1"
            )
        )
}