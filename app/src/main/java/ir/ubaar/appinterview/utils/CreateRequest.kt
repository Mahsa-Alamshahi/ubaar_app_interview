package ir.ubaar.appinterview.utils

import ir.ubaar.appinterview.data.data_source.remote.dto.Detail


fun createRequest(props: Map<String, String>): Detail = Detail(
    firstName = props["firstName"],
    lastName = props["lastName"],
    address = props["address"],
    coordinatePhoneNumber = props["coordinatePhoneNumber"],
    coordinateMobile =props["coordinateMobile"],
    gender = props["gender"],
    region = 1,
    longitude =29.1007 ,
    latitude =40.9971
)