package com.example.samplechart.dataclasses

class ApiResponse(

    var errorMessage: String? = null,
    var payload: ArrayList<Payload> = arrayListOf(),
    var status: String? = null,
    var requestId: String? = null,
    var detail: String? = null
)



