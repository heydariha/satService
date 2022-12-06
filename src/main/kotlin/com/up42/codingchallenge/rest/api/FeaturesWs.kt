package com.up42.codingchallenge.rest.api

import com.up42.codingchallenge.persistence.FeatureCollection
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*


interface FeaturesWs {

    @GetMapping("/features")
    fun getFeatures(): List<FeatureCollection.Feature>

    @GetMapping("/features/{featureId}/quicklook")
    @ResponseBody
    fun getFeatureImage(@PathVariable featureId: UUID): ResponseEntity<ByteArray?>?

}
