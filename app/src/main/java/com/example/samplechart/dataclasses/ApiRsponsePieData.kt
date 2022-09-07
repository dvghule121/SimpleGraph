package com.example.samplechart.dataclasses

class ApiRsponsePieData (

    var errorMessage: String? = null,
    var payload: PieDataPayload? =  null,
    var status: String? = null,
    var requestId: String? = null,
    var detail: String? = null
)